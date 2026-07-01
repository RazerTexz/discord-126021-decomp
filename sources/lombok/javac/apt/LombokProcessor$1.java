package lombok.javac.apt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/* JADX INFO: loaded from: app.apk:lombok/javac/apt/LombokProcessor$1.SCL.lombok */
class LombokProcessor$1 extends ClassLoader {
    private final /* synthetic */ ClassLoader val$parent;

    LombokProcessor$1(ClassLoader classLoader) {
        this.val$parent = classLoader;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return this.val$parent.loadClass(name);
    }

    public String toString() {
        return this.val$parent.toString();
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String name) {
        return this.val$parent.getResource(name);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String name) throws IOException {
        return this.val$parent.getResources(name);
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String name) {
        return this.val$parent.getResourceAsStream(name);
    }

    @Override // java.lang.ClassLoader
    public void setDefaultAssertionStatus(boolean enabled) {
        this.val$parent.setDefaultAssertionStatus(enabled);
    }

    @Override // java.lang.ClassLoader
    public void setPackageAssertionStatus(String packageName, boolean enabled) {
        this.val$parent.setPackageAssertionStatus(packageName, enabled);
    }

    @Override // java.lang.ClassLoader
    public void setClassAssertionStatus(String className, boolean enabled) {
        this.val$parent.setClassAssertionStatus(className, enabled);
    }

    @Override // java.lang.ClassLoader
    public void clearAssertionStatus() {
        this.val$parent.clearAssertionStatus();
    }
}
