package kz.spring.aop.main;

import kz.spring.aop.objects.FileManager;
import kz.spring.aop.objects.FileManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartFile {

    public static void main(String[] args) {
        String folder = "c:\\Windows\\System32";

        ApplicationContext context = new ClassPathXmlApplicationContext("aop/applicationContext.xml");

        FileManager fileManager = (FileManager) context.getBean("fileManager");
        fileManager.getExtensionList(folder);
        fileManager.getExtensionCount(folder);

        FileManagerImpl fileManagerImpl = (FileManagerImpl) context.getBean("fileManagerImpl");
        fileManagerImpl.getExtensionList(folder);
        fileManagerImpl.getExtensionCount(folder);
    }
}
