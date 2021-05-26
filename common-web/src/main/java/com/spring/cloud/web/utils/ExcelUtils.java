package com.spring.cloud.web.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.spring.cloud.web.exception.StatusException;
import com.spring.cloud.web.utils.convertor.LocalDateConverter;
import com.spring.cloud.web.utils.convertor.LocalDateTimeConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author qinchao
 * @description
 * @date 2020/11/30 16:33
 */
@Component
@Slf4j
public class ExcelUtils {

    @Autowired
    private LocalDateTimeConverter localDateTimeConverter;

    @Autowired
    private LocalDateConverter localDateConverter;

    public <T> List<T> getList(MultipartFile file, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        try {
            EasyExcel.read(file.getInputStream(), clazz, new AnalysisEventListener<T>() {
                @Override
                public void invoke(T object, AnalysisContext analysisContext) {
                    list.add(object);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    //可以加一些判断如果list过长，抛出异常
                }
            }).registerConverter(localDateTimeConverter).registerConverter(localDateConverter).sheet(0).doRead();
        } catch (IOException e) {
            log.error("Excel cellData convert to Object occur IOException", e);
            throw new StatusException(400, e.getMessage(), e);
        }
        return list;
    }

    public <T> void export(List<T> list, String fileName, Class<T> header) {
        try {
            HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
            fileName = HttpServletUtils.getFileName(fileName);
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            ServletOutputStream outputStream = response.getOutputStream();

            EasyExcel.write(outputStream).head(header).registerConverter(localDateTimeConverter)
                    .registerConverter(localDateConverter).excelType(ExcelTypeEnum.XLSX).sheet("sheet").doWrite(list);
        } catch (IOException e) {
            log.error("Excel export occur IOException", e);
            throw new StatusException(400, e);
        }
    }

    public void exportFile(String filePath) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = getClass().getClassLoader().getResourceAsStream(filePath);
            String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            out = response.getOutputStream();
            if (in != null) {
                IOUtils.copy(in, out);
            }
            out.flush();
        } catch (IOException e) {
            log.error("Excel template download occur IOException", e);
            throw new StatusException(400, e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }

}
