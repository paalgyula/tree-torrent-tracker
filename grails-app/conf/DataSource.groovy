dataSource {
    pooled = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update"
			driverClassName = "org.hsqldb.jdbcDriver"
			username = "sa"
			password = ""
            url = "jdbc:hsqldb:file:development.db;shutdown=true"
			//loggingSql = true
        }
    }
    test {
        dataSource {
			dbCreate = "update"
			driverClassName = "org.hsqldb.jdbcDriver"
			url = "jdbc:hsqldb:file:development.db;shutdown=true"
			username = "sa"
			password = ""
        }
    }
    production {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
			driverClassName = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/thetree"
			dialect = org.hibernate.dialect.PostgreSQLDialect
			username = "goofy"
			password = "icGp4"
			//loggingSql = true
        }
    }
}
