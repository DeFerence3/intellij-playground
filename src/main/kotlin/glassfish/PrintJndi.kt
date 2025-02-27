package glassfish

fun printJndi(){
    val port = 4848
    val host = "localhost"

    val dbPort=1433
    val dbUSer="sa"
    val dbPass="Udyata@pass#Leo"
    val dbUrl="2000SERVER\\SQLEXPRESS"

    val databaseDets = listOf(
        DatabaseDet("Authentication", "2024", Modules.Authentication,true),
        DatabaseDet("Accounts245", "2024", Modules.Accounts,true),
    )
    databaseDets.forEach { (databaseName,year,module,isCurrent) ->
        val poolName = databaseName+"DSPool"
        val datasourceName = module.name+(if (isCurrent) "" else year) +"DS"
        val command =
            ("asadmin --host $host --port $port create-jdbc-connection-pool --datasourceclassname=com.microsoft.sqlserver.jdbc.SQLServerXADataSource --restype=javax.sql.XADataSource --property=User=$dbUSer:Password=$dbPass:DatabaseName="
                    + databaseName
                    + ":URL='jdbc:sqlserver://$dbUrl':PortNumber=$dbPort:ApplicationName=MicrosoftJDBCDriverforSQLServer "
                    + poolName)
        val commandTwo = "asadmin --host $host --port $port create-jdbc-resource --connectionpoolid=$poolName $datasourceName"
        println("$command && $commandTwo")

        val deleteCmd1 = "asadmin --host $host --port $port delete-jdbc-resource $datasourceName"
        val deleteCmnd2 = "asadmin --host $host --port $port delete-jdbc-connection-pool $poolName"

//        println("$deleteCmd1 && $deleteCmnd2")

    }
}