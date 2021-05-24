package com.spring.cloud.web.utils;

import io.minio.BucketExistsArgs;
import io.minio.CopyObjectArgs;
import io.minio.CopySource;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * description
 *
 * @author qinchao
 * @date 2020/12/2 18:06
 */
@Component
public class MinioUtils {

    @Autowired
    private MinioClient client;

    /**
     * 创建桶
     *
     * @param bucket 桶
     */
    public void makeBucket(String bucket) throws Exception {
        // 判断桶是否存在
        boolean isExist = client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!isExist) {
            // 新建桶
            client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }

    /**
     * 上传本地文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @param filePath  文件路径
     */
    public void uploadFile(String bucket, String objectKey, String filePath) throws Exception {
        client.uploadObject(UploadObjectArgs.builder().bucket(bucket).object(objectKey).filename(filePath).contentType("image/png").build());
    }

    /**
     * 流式上传文件
     *
     * @param bucket      桶
     * @param objectKey   文件key
     * @param inputStream 文件输入流
     */
    public void uploadInputStream(String bucket, String objectKey, InputStream inputStream) throws Exception {
        client.putObject(PutObjectArgs.builder().bucket(bucket).object(objectKey).stream(inputStream, inputStream.available(), -1).contentType("image/png").build());
    }

    /**
     * 下载文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @return 文件流
     */
    public InputStream download(String bucket, String objectKey) throws Exception {
        return client.getObject(GetObjectArgs.builder().bucket(bucket).object(objectKey).build());
    }

    /**
     * 下载文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @return 文件流
     */
    public void download(String bucket, String objectKey, HttpServletResponse response) throws Exception {
        InputStream in = download(bucket, objectKey);
        response.setHeader("Content-Disposition", "attachment; filename=" + objectKey);
        int count = 0;
        byte[] by = new byte[1024];
        //通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        while ((count = in.read(by)) != -1) {
            //将缓冲区的数据输出到浏览器
            out.write(by, 0, count);
        }
        in.close();
        out.flush();
        out.close();
    }

    /**
     * 文件复制
     *
     * @param sourceBucket    源桶
     * @param sourceObjectKey 源文件key
     * @param bucket          桶
     * @param objectKey       文件key
     */
    public void copyFile(String sourceBucket, String sourceObjectKey, String bucket, String objectKey) throws Exception {
        CopySource source = CopySource.builder().bucket(sourceBucket).object(sourceObjectKey).build();
        client.copyObject(CopyObjectArgs.builder().bucket(bucket).object(objectKey).source(source).build());
    }

    /**
     * 删除文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     */
    public void deleteFile(String bucket, String objectKey) throws Exception {
        client.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(objectKey).build());
    }

    /**
     * 获取文件签名url
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @param expires   签名有效时间  单位秒
     * @return 文件签名地址
     */
    public String getSignedUrl(String bucket, String objectKey, int expires) throws Exception {
        return client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucket).object(objectKey).expiry(expires).build());
    }

}
