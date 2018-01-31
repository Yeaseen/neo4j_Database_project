/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.neo4j;

import java.util.HashMap;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author Asus
 */



public class Extend {
    
    public static Integer BFS(String s, String d){
        Driver driver = GraphDatabase.driver( 
        "bolt://localhost", AuthTokens.basic( "neo4j", "lArojA18996" ) );
        Session session = driver.session();
        Map<String, Integer>map = new HashMap<String, Integer>();
         Map<String, String>par = new HashMap<String, String>();
        //String query = "match(n:User) return n.name as ans";
        String query = "match(n:Person1) return n,n.name as ans";
        //ExecutionResult result = (ExecutionResult) ser.execute(query);
        StatementResult result = session.run(query);
        //Iterator<Node> nodes;
        //nodes = result.columnAs("n");
        Integer ret = -1 ;
        while(result.hasNext()){ 
            Record record = result.next();
            //System.out.println(record.get("ans").asString()+" ehil e asi");
            map. put( record.get("ans").asString(), -1);
            
        }
            
        map.put(s,0);
        par.put(s,s);
        Queue<String>q = new LinkedList<String>();
        //System.out.println(s);
        q.add(s);
        
        while(!q.isEmpty()){
            String u = q.peek();
            //System.out.println(u);
            q.poll();
            //System.out.println("path : " + u);
            //query = "match (n:User)-[*..15]->(m:User) where n.name='u' return m.name as ans2";
            query = "match (n)-[:goes]->(m:Person1) where n.name='"+u+"' return m.name as ans2";
            result = session.run(query);
            while(result.hasNext()){
                //Node node = nodes.next();
                Record record = result.next();
                String v = record.get("ans2").asString();
  //              System.out.println(v+"  "+  map.get(v));
                
                if(map.get(v)==-1){
//                    System.out.println("chole  "+  map.get(u));
                    map.put(v,map.get(u)+1);
                    
                    par.put(v, u);
                    if(v.equals(d)) { ret = map.get(v) ; break ; }
                    
                    q.add(v);
                }
            }
        }
        session.close();
        driver.close();
        if(ret.equals(-1))return -1 ;
        else
        {
            printPath(d,par);
            System.out.println("");
            return ret ;
        }
        
    }
    
    public static void printPath(String d, Map<String, String> par) {
        String papa = par.get(d) ;
        if(papa.equals(d) ){System.out.print(d ); return ;}
        printPath(papa,par) ;
        System.out.print(" -> "+ d );
        
            
    }
    
    
    public static void main(String[] args){
        
        //Integer i=  BFS("adamfazio","Tyler Fitch");
        Integer i=  BFS("e","Arthur3");
        System.out.println(i);
    }
    
}
