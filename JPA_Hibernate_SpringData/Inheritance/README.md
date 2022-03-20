#Inheritance in JPA
To translate the inheritance from the oriented object concept to relations in database, Spring provides three strategies :
<ol> 
<li>SINGLE_TABLE</li>
Single table means that only the super class will have its own table and the specification of each sub class will be represented by a discriminator column. For each subclass, we will mention the discriminator value annotation and the value that the record will take while instantiating the class.   
<li>TABLE_PER_CLASS</li>
For each sub class, there is its own table. The attributes of the super class will be redundant in each table. 
<li>JOINED_CLASS</li>
The join relationship between the super and sub classes makes a record be split : a part of the record will be sored in the super class table and the rest in the sub class table.
</ol>

Thanks to @Inheritance Spring Annotation, we are able to move from a strategy to another one by changing the strategy specification
![Interface_Annotation]()
