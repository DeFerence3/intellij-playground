package glassfish

internal data class DatabaseDet(
    var databaseName: String,
    var year: String,
    var module: Modules,
    var isCurrent: Boolean = false
)

