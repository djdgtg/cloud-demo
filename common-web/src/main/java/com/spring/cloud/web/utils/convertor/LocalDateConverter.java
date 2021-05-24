package com.spring.cloud.web.utils.convertor;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.spring.cloud.web.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author qinchao
 * @description
 * @date 2020/12/2 11:33
 */
@Component
public class LocalDateConverter implements Converter<LocalDate> {

    @Override
    public Class<LocalDate> supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) {
        LocalDate localDate = LocalDate.of(1900,1,1);
        return localDate.plusDays(cellData.getNumberValue().intValue()-2);
    }

    @Override
    public CellData<String> convertToExcelData(LocalDate localDate, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) {
        return new CellData<>(DateUtils.dateString(localDate));
    }
}

