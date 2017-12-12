package ch.fhnw.youbarter

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.util.logging.Slf4j
import org.springframework.context.MessageSource
import org.springframework.web.servlet.support.RequestContextUtils

import java.util.logging.Logger

/*
* this taglib was copied from grails tutorial page on i18n
* */
@Slf4j
class LocaleNavBarTagLib implements GrailsConfigurationAware {
    //static defaultEncodeAs = [taglib:'html']


    static namespace = 'localeNavBar'

    static defaultEncodeAs = [taglib: 'none']

    MessageSource messageSource

    List<String> languages

    @Override
    void setConfiguration(Config co) {
        languages = co.getProperty('guide.languages', List)
    }

    def localeDropdownListItems = { args ->
        String uri = args.uri

        for (String lang : languages) {

            String languageCode = "language.$lang"
            log.info("found lang: " + lang +", resolved to : " + languageCode)
            def locale = RequestContextUtils.getLocale(request)
            def msg = messageSource.getMessage(languageCode, [] as Object[], "n/a", locale)
            log.info("<a class='dropdown-item' href='${uri}?lang=${lang}'>${msg}</a>")
//            out << "<option><a href='${uri}?lang=${lang}'>${msg}</a></option>"

            out << "<a class='dropdown-item' href='${uri}?lang=${lang}'>${msg}</a>"

        }

    }

}