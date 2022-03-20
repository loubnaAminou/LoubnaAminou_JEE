<h1> Many To Many JPA association mapping</h1>

<h4> Join Table </h4>
The join table is a separate table that hols the foreign keys of the associated tables. And the composite of the foreign keys will be the primary key of this table. 

![join_table]()

<h4> Many To Many Annotation </h4>
In each class, we include a collection of the <i>many</i> elements of the other class. At this level, we add the @ManyToMany annotation, and also the @JoinTable to change the name of the table that will be generated, if needed. 

![many_to_many]()