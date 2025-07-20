package nl.codeclan.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig : WebMvcConfigurer {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun addCorsMappings(registry: CorsRegistry) {
        logger.info("Adding CORS")

        registry.addMapping("/**").allowedMethods("*")
    }
}