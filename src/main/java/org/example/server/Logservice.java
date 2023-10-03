package org.example.server;

import org.example.connection.MongoDBConnection;

import static spark.Spark.*;
/*
PARA CORRER HAY QUE ABRIR 3 CMD DE LOGSERVICE

set PORT=4568
set PORT=4569
set PORT=4570


para cada cmd:


mvn exec:java
mvn exec:java
mvn exec:java


LUEGO ABRIR UN CMD EN LOGROUNDROBIN

mvn exec:java



 */
public class Logservice {
    public static void main(String... args){
        port(getPort());
        get("/logs", (req,res) -> {
            String log = req.queryParams("log");
            MongoDBConnection.insertLog(log);
            return MongoDBConnection.getLast10Logs();
        });
    }

    private static int getPort(){
        if(System.getenv("PORT") != null ){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}