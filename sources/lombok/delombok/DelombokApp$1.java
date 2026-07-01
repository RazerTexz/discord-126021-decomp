package lombok.delombok;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: app.apk:lombok/delombok/DelombokApp$1.SCL.lombok */
class DelombokApp$1 extends ClassLoader {
    private final /* synthetic */ JarFile val$toolsJarFile;
    private final /* synthetic */ File val$toolsJar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DelombokApp$1(ClassLoader $anonymous0, JarFile jarFile, File file) {
        super($anonymous0);
        this.val$toolsJarFile = jarFile;
        this.val$toolsJar = file;
    }

    private Class<?> loadStreamAsClass(String name, boolean resolve, InputStream in) throws ClassNotFoundException {
        try {
            try {
                byte[] b2 = new byte[65536];
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                while (true) {
                    int r = in.read(b2);
                    if (r == -1) {
                        break;
                    }
                    out.write(b2, 0, r);
                }
                in.close();
                byte[] data = out.toByteArray();
                Class<?> c = defineClass(name, data, 0, data.length);
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            } finally {
                in.close();
            }
        } catch (Exception e2) {
            throw new ClassNotFoundException(name, e2);
        }
    }

    @Override // java.lang.ClassLoader
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        String binName = name.replace(".", AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        String rawName = String.valueOf(binName) + ".class";
        String altName = String.valueOf(binName) + ".SCL.lombok";
        JarEntry entry = this.val$toolsJarFile.getJarEntry(rawName);
        if (entry == null) {
            if (name.startsWith("lombok.")) {
                InputStream res = getParent().getResourceAsStream(rawName);
                if (res == null) {
                    res = getParent().getResourceAsStream(altName);
                }
                return loadStreamAsClass(name, resolve, res);
            }
            return super.loadClass(name, resolve);
        }
        try {
            return loadStreamAsClass(name, resolve, this.val$toolsJarFile.getInputStream(entry));
        } catch (IOException e2) {
            throw new ClassNotFoundException(name, e2);
        }
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String name) {
        JarEntry entry = this.val$toolsJarFile.getJarEntry(name);
        if (entry == null) {
            return super.getResource(name);
        }
        try {
            return new URL("jar:file:" + this.val$toolsJar.getAbsolutePath() + "!" + name);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String name) throws IOException {
        JarEntry entry = this.val$toolsJarFile.getJarEntry(name);
        Enumeration<URL> parent = super.getResources(name);
        return entry == null ? super.getResources(name) : new DelombokApp$1$1(this, parent, this.val$toolsJar, name);
    }
}
