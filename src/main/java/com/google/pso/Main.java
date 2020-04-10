/*
 * Copyright 2010-2020 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.pso;


import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.logging.LogFactory;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {



        public static void main(String[] args) throws SQLException {
            // Create the Flyway instance and point it to the database
            String jdbcUrlFormat =
                    "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s;credentials=%s";
            String credentialsUrl = "/Users/radoslaws/repos/flywaydemo/key.json";
            String conn = String.format(
                    jdbcUrlFormat, "radoslaws-playground", "flywaydemo", "example-db", credentialsUrl);
            DriverManager.registerDriver(new com.google.cloud.spanner.jdbc.JdbcDriver());


            Flyway flyway = Flyway.configure().dataSource(conn,null,null).load();
            flyway.repair();
            // Start the migration
            flyway.migrate();
        }

}
