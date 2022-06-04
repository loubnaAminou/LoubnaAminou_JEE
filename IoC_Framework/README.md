# Create a framework of Dependency injection similar to spring IoC
the purpose behind the creation of a DI framework is to understand the mechanism od this pattern and discover how does Spring framework work.   

For this example, I made my own version of reading beans form xml file using JAVAX XML binding, and the annotation version as well.

### Step 1 : Business Layer
I created a layer where we found the interface and its implementation, which represents the business code (created by the programmer). And at this class where I use the customized annotation to instantiate my class as a Java Bean

![layer](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/layer.png)

The program is such a dummy business code just as example to understand how Dependency Injection (XML version) works.

![code](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/business_code.png)

### Step 2 XML : XML file configuration
The xml file contains the implementation name as a tag, which represent a JAVA BEAN in our case, with an added value for the age attribute.

![xml_config](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/xml_config.png)

### Step 2 Annotation : Customized Annotation
We create the custom annotations, we use @Target to specify the use of the annotation if it would be for class(as like our example) or for a method(like @Override for example) or for an attribute(like @JSONProperty) 

![annotation](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/annotation.png)

###Step 3 : The XML application context
The third step is to prepare the context of the XML configuration file using JAXB package, to be able to read from an XML file, create the context and instantiate the Java class

![context](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/context.png)

### Step 4 : main class
First things first, the call of the XML application context, to get the declared implementation. Then , I instantiate the class using the bean returned by the XML context. And now, I have got the object, and it's ready to use it normally

![main](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/main.png)

The result of the execution of main method looks like :

![result](https://github.com/loubnaAminou/LoubnaAminou_JEE/blob/main/IoC_Framework/screenshots/result.png)
