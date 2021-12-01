import java.util.*

interface FlavorConfig {
    val name: String
    val manifestPlaceholder: Map<String, String>
    val applicationIdSuffix: String
    val dimension: String
    val supportedBuildTypes: Array<BuildTypeConfig>
    val configs:List<Triple<String,String,String>>
}

object Flavors {

    private const val dimensionBase = "base"
    private const val dimensionMarket = "market"

    val dimensions = arrayOf(dimensionBase)

    val flavors = arrayOf(Develop)

    object Develop: FlavorConfig {
        private const val API_VERSION = "1"
        override val name: String = this::class.java.simpleName.toLowerCase(Locale.ENGLISH)
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to "${Configuration.appName} - $name")
        override val applicationIdSuffix: String = "dev"
        override val dimension: String = dimensionBase
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug)
        override val configs: List<Triple<String, String, String>> = listOf(
            Triple("String", "API_BASE_URL", "https://api$API_VERSION.kiliaro.com/"),
            Triple("String", "SHARE_ID", "djlCbGusTJamg_ca4axEVw"),
            Triple("int", "DATABASE_VERSION", "1"),
            Triple("String", "SCHEMA_NAME", "kiliaro_db")
        )
    }

    object Product: FlavorConfig {
        override val name: String = this::class.java.simpleName.toLowerCase(Locale.ENGLISH)
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to Configuration.appName)
        override val applicationIdSuffix: String = "dev"
        override val dimension: String = dimensionBase
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug)
        override val configs: List<Triple<String, String, String>> = emptyList()
    }

    object LocalMarket: FlavorConfig {
        override val name: String = "local"
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to "${Configuration.appName} - $name")
        override val applicationIdSuffix: String = "local"
        override val dimension: String = dimensionMarket
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug, BuildTypes.Release)
        override val configs: List<Triple<String, String, String>> = emptyList()
    }

    object PlayMarket: FlavorConfig {
        override val name: String = "play"
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to "${Configuration.appName} - $name")
        override val applicationIdSuffix: String = "play"
        override val dimension: String = dimensionMarket
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug, BuildTypes.Release)
        override val configs: List<Triple<String, String, String>> = emptyList()
    }

}