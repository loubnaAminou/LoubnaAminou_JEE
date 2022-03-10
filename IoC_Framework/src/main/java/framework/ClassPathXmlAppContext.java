package framework;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ClassPathXmlAppContext {
    private File XmlFile;
    private String XmlFileName;

    public ClassPathXmlAppContext(String xmlFileName) {
        String path = "src\\main\\resources\\"+xmlFileName;
        XmlFile = new File(path);
    }

    public Object getBean(Class<?> impl) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(impl);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object aClass = (Object) unmarshaller.unmarshal(XmlFile);


        return aClass;
    }
}
