package com.client.ws.rasplus.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.MessageSourceResolvable
import org.springframework.context.i18n.LocaleContext
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component
import java.text.NumberFormat
import java.util.*
@Component

class TranslatorCompomnent(private val messageSource: MessageSource) {

    private val availableLanguages = listOf("pt_BR", "en_US")

    fun translate(code: String) :String {
        return translate(code, emptyArray())
    }

    fun translate(code: String, args: Array<Any>) :String {
        val locale = LocaleContextHolder.getLocale()
        return messageSource.getMessage(code, args, locale)
    }

    fun translate(messageSourceResolvable: MessageSourceResolvable) :String {
        val locale = LocaleContextHolder.getLocale()
        return messageSource.getMessage(messageSourceResolvable, locale)
    }

    fun getLanguage() :String {
        val locale = LocaleContextHolder.getLocale().toString()
        return if (availableLanguages.contains(locale)) locale else "pt_BR"
    }

    fun getLocale() :Locale {
        return LocaleContextHolder.getLocale()
    }

    fun formatCurrency(value: Double) :String {
        val locale = LocaleContextHolder.getLocale()
        val numberFormat = NumberFormat.getCurrencyInstance(locale)
        return numberFormat.format(value)
    }
}
