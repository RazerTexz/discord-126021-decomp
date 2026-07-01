package lombok.eclipse.agent;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* JADX WARN: Classes with same name are omitted, all sources:
  app.apk:Class50/lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok
  app.apk:lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok
 */
/* JADX INFO: loaded from: app.apk:Class50/lombok/eclipse/agent/EclipseLoaderPatcherTransplants.SCL.lombok */
public class EclipseLoaderPatcherTransplants {
    public static boolean overrideLoadDecide(ClassLoader original, String name, boolean resolve) {
        return name.startsWith("lombok.");
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.String, java.lang.Throwable] */
    public static Class overrideLoadResult(ClassLoader original, String name, boolean resolve) throws ClassNotFoundException {
        try {
            Field shadowLoaderField = original.getClass().getField("lombok$shadowLoader");
            ClassLoader shadowLoader = (ClassLoader) shadowLoaderField.get(original);
            if (shadowLoader == null) {
                ?? Intern = "lombok$shadowLoader$globalLock".intern();
                synchronized (Intern) {
                    try {
                        shadowLoader = (ClassLoader) shadowLoaderField.get(original);
                        if (shadowLoader == null) {
                            Class shadowClassLoaderClass = (Class) original.getClass().getField("lombok$shadowLoaderClass").get(null);
                            Class<?> cls = Class.forName("java.lang.ClassLoader");
                            String jarLoc = (String) original.getClass().getField("lombok$location").get(null);
                            if (shadowClassLoaderClass == null) {
                                JarFile jf = new JarFile(jarLoc);
                                InputStream in = null;
                                try {
                                    ZipEntry entry = jf.getEntry("lombok/launch/ShadowClassLoader.class");
                                    InputStream in2 = jf.getInputStream(entry);
                                    byte[] bytes = new byte[65536];
                                    int len = 0;
                                    while (true) {
                                        int r = in2.read(bytes, len, bytes.length - len);
                                        if (r != -1) {
                                            len += r;
                                            if (len == bytes.length) {
                                                throw new IllegalStateException("lombok.launch.ShadowClassLoader too large.");
                                            }
                                        } else {
                                            in2.close();
                                            Class<?>[] clsArr = new Class[4];
                                            clsArr[0] = "".getClass();
                                            clsArr[1] = new byte[0].getClass();
                                            clsArr[2] = Integer.TYPE;
                                            clsArr[3] = clsArr[2];
                                            Method defineClassMethod = cls.getDeclaredMethod("defineClass", clsArr);
                                            defineClassMethod.setAccessible(true);
                                            shadowClassLoaderClass = (Class) defineClassMethod.invoke(original, "lombok.launch.ShadowClassLoader", bytes, new Integer(0), new Integer(len));
                                            original.getClass().getField("lombok$shadowLoaderClass").set(null, shadowClassLoaderClass);
                                            if (in2 != null) {
                                                in2.close();
                                            }
                                            jf.close();
                                            break;
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (0 != 0) {
                                        in.close();
                                    }
                                    jf.close();
                                    throw th;
                                }
                            }
                            Class<?>[] clsArr2 = new Class[5];
                            clsArr2[0] = cls;
                            clsArr2[1] = "".getClass();
                            clsArr2[2] = clsArr2[1];
                            clsArr2[3] = Class.forName("java.util.List");
                            clsArr2[4] = clsArr2[3];
                            Constructor constructor = shadowClassLoaderClass.getDeclaredConstructor(clsArr2);
                            constructor.setAccessible(true);
                            shadowLoader = (ClassLoader) constructor.newInstance(original, "lombok", jarLoc, Arrays.asList("lombok."), Arrays.asList("lombok.patcher.Symbols"));
                            shadowLoaderField.set(original, shadowLoader);
                        }
                    } catch (Throwable th2) {
                        throw Intern;
                    }
                }
            }
            if (resolve) {
                Class[] paramTypes = {"".getClass(), Boolean.TYPE};
                Method m = shadowLoader.getClass().getDeclaredMethod("loadClass", String.class, Boolean.TYPE);
                m.setAccessible(true);
                return (Class) m.invoke(shadowLoader, name, Boolean.TRUE);
            }
            return shadowLoader.loadClass(name);
        } catch (Exception ex) {
            Throwable t = ex;
            if (t instanceof InvocationTargetException) {
                t = t.getCause();
            }
            if (t instanceof RuntimeException) {
                throw ((RuntimeException) t);
            }
            if (t instanceof Error) {
                throw ((Error) t);
            }
            throw new RuntimeException(t);
        }
    }
}
