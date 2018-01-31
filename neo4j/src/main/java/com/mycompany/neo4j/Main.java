/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.neo4j;
import java.util.Iterator;
import javafx.scene.Node;
import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;



public class Main {
  /*  
    public static void main(String[] args) {
    Driver driver = GraphDatabase.driver( 
        "bolt://localhost", AuthTokens.basic( "neo4j", "lArojA18996" ) );
    Session session = driver.session();
    /*
    session.run( "CREATE (a:Person1 {name:'Arthur3', title:'KingofAzkaban'})" );

    StatementResult result = session.run( "MATCH (a:Person1) WHERE a.name = {name} " +
                                      "RETURN a.name AS name, a.title AS title",
        parameters( "name", "Arthur" ) );

    while ( result.hasNext() ) {
        Record record = result.next();
        System.out.println( record.get( "title" ).asString() + 
                                " " + record.get("name").asString() );
    }
    /
    
    //total_posts by "KMarsh"
    /*
    StatementResult result = session.run("match (tweets:Tweet) <- [r:POSTS] - (user:User {name:\"KMarsh\"}) return count(r) as ans");
    
    while (result.hasNext()){
        Record record = result.next();
        System.out.println(record.get("ans"));    
    }
    */
    /*
    
    StatementResult result=session.run("match (b:User)\n" +
"with max(b.followers) as mx\n" +
"match (a:User)\n" +
"where a.followers=mx\n" +
"return a.name as name,a.followers as followers");
    
    while(result.hasNext()){
        Record record = result.next();
        System.out.println(record.get("name").asString()+"HAS HIGHEST "+record.get("followers")+" followers");
    }
    
    */
    
    /*
    #most_tagged Hashtag and how many times by a user who has maximum followers 
    StatementResult result=session.run("match (b:User)\n" +
"with max(b.followers) as mx\n" +
"match (a:User)\n" +
"where a.followers=mx\n" +
"with a.name as fk\n" +
"match (h:Hashtag)-[:TAGS]->(t:Tweet) <-[:POSTS]-(user:User {name:fk}) \n" +
"with h, count(h) as Hashtags\n" +
"order by Hashtags desc\n" +
"return h.name as name,Hashtags");
    
    while(result.hasNext()){
        Record record = result.next();
        System.out.println(record.get("name").asString()+"---->"+record.get("Hashtags"));
    }
    
    
    StatementResult result=session.run("match (h:Hashtag)-[:TAGS]->(t:Tweet) <-[:POSTS]-(user:User {name:\"O'Reilly OSCON\"}) \n" +
"with h, count(h) as Hashtags\n" +
"order by Hashtags desc\n" +
"return h.name as name,Hashtags");
    
    while(result.hasNext()){
        Record record = result.next();
        System.out.println(record.get("name").asString()+"---->"+record.get("Hashtags"));
    }
    
    session.close();
    driver.close();
}
*/
}
