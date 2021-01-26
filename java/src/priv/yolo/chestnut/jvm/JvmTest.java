package priv.yolo.chestnut.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class JvmTest {

    public static void main(String[] args) throws ClassNotFoundException {
        DemoClassLoader acl = new DemoClassLoader();
        DemoClassLoader bcl = new DemoClassLoader();
        String classPath1 = "priv.yolo.chestnut.jvm.Person";
        Class<?> a = acl.loadClass(classPath1);
        Class<?> b = acl.loadClass(classPath1);
        Class<?> c = bcl.loadClass(classPath1);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a.getClassLoader());
        System.out.println(b.getClassLoader());
        System.out.println(c.getClassLoader());

        Person person = new Person();
        System.out.println(person.getClass().getClassLoader());
    }

}

class DemoClassLoader extends ClassLoader {

    // 用于演示，非线程安全
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // bootstrap ext app(sys) 这里用的是ext
        ClassLoader extClassloader = getSystemClassLoader().getParent();
        Class<?> aClass;
        // 判断是否已经加载过了
        aClass = findLoadedClass(name);
        if (aClass != null)
            return aClass;

        try {
            aClass = extClassloader.loadClass(name);
        } catch (ClassNotFoundException e) {
            // 省略
        }

        if (aClass != null)
            return aClass;
        return findClass(name);
//        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = "/Users/mryao/Person.class";
        byte[] data = new byte[0];
        try (FileInputStream fis = new FileInputStream(classPath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int c;
            while ((c = fis.read()) != -1) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, data, 0, data.length);
//        return super.findClass(name);
    }

}

