//create a new node

create (n:Person {name:"Arafat"}) return n

create (n:Person {name:"Arafat2"}) return n

create (n:Person {name:"Arafat3"}) return n

create (n:Person {name:"Arafat4"}) return n

//create a graph using all nodes of n

match (n:Person) return n


create (n:Movies {name2:"Arafat5"}) return n

create (n:Movies {name2:"Arafat6"}) return n

create (n:Movies {name2:"Arafat7"}) return n

create (n:Movies {name2:"Arafat8"}) return n

match (n:Movies) return n

//making whole graph 

match(n) return n

 //adding a property to a node

 match(n:Person {name:"Arafat"}) set n.age=22

 //for updating property

 match(n:Person {name:"Arafat"}) set n.age=22

 //removing a property

match(n:Person {name:"Arafat"}) remove n.age



//making a relation between graphs

match (a:Person {name:"Arafat"}),(b:Person {name:"ahimas"}) merge (a)-[r:crush]->(b)

match (a:Movies {name:"Sherlock Holmes"}),(b:Movies {names:"X-man"}) merge (a)-[r:uhu]->(b)

match (a:Person {name:"ssush"}),(b:Movies {name:"X-man"}) merge (a)-[r:fav]->(b)

//find a node

match(n:Person) where n.name="Arafat" return n 

match(n:Person {name="Arafat"}) return n 


//return a property
match(n:Person) where n.name="Arafat" return n.name

match(n:Person) where n.name="Arafat" or n.name="ssush" return n


//search in relationship.

match(a:Person {name:"Arafat"})-[:crush]->(b:Person) return a,b
match(a:Person {name:"Arafat"})-[:crush]->(b:Person) return b

match(a:Person)-[:crush]->(b:Person  {name:"Arafat"}  ) return a,b //no row, cz directed graph was created

match(a:Person)-[:crush]-(b:Person  {name:"Arafat"}  ) return a,b //ja asw.e tai e dibe

match(a:Person)<-[:crush]-(b:Person  {name:"Arafat"}  ) return a,b //dibe

//Deletetion of a node=== if a node is in a relationship , it cant be deleted easily

match(a:Person {name:"Arafat"}) delete a   //not deleted

match(a:Person {name:"Arafat"})-[r]-(b) delete r  //1stly deletenig the relations == then delete the desired node

match(a:Movies {name:"GodFather"}) delete a //deleted 


match (n) optional match (n)-[r]-() delete n,r
















































