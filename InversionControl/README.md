# Injection of Control(IoC) & Dependency Injection (DI)
The dependency injection is used by Spring IoC framework, in order to manage the components of Java application. 
Before learning the framework, we've to know how the DI works, by using **_loose coupling_** and switch between multiple versions of the application.


<h1>Dependency Injection</h1>

<h3> without Spring </h3>
<h6> Tight coupling </h6>
If there is a dependence between two classes (unidirectional association), we said that aClass is <i>tightly coupled</i> with the other class. The main problem is whenever we have a modification to for a class then we are obliged to apply all the changes for the rest of the dependent classes.

![Tight_Coupling](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/InversionControl/screenshots/tight_coupling.png)


That's why loose coupling comes to put in evidence the independence between classes, through a common interface.
<h6> Loose coupling </h6>

![Loose_Coupling](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/InversionControl/screenshots/loose_coupling.png)

In this case, we used the dynamic instantiation instead of the static one. This type of instantiation allows the inversion of control easily, because it reads the implementation classes

<h3> using Spring </h3>
<h6> Spring Annotation </h6>
THe usage of annotations in Spring help to indicate to the framework the interfaces that will be implemented. Then, Spring will scan the packages to generate the Beans.

![Spring_Annotation](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/InversionControl/screenshots/spring_annotation.png)

<h6> XML version </h6>
For the XML file configuration, it contains the beans that will be generated by Spring while executing the program. 

![Spring_XML](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/InversionControl/screenshots/spring_xml.png)
