package com.client.ws.rasplus.utils

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.sql.Date
import java.time.YearMonth

@Converter(autoApply = true)
class YearMonthConverter : AttributeConverter<YearMonth?, Date?> {
    override fun convertToDatabaseColumn(yearMonth: YearMonth?): Date? {
        return if (yearMonth == null) {
            null
        } else Date.valueOf(yearMonth.atDay(1))
    }

    override fun convertToEntityAttribute(date: Date?): YearMonth? {
        return if (date == null) {
            null
        } else YearMonth.from(date.toLocalDate())
    }
}
