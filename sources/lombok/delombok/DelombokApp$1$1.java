package lombok.delombok;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

/* JADX INFO: loaded from: app.apk:lombok/delombok/DelombokApp$1$1.SCL.lombok */
class DelombokApp$1$1 implements Enumeration<URL> {
    private boolean first = false;
    final /* synthetic */ DelombokApp$1 this$1;
    private final /* synthetic */ Enumeration val$parent;
    private final /* synthetic */ File val$toolsJar;
    private final /* synthetic */ String val$name;

    @Override // java.util.Enumeration
    public /* bridge */ /* synthetic */ URL nextElement() {
        return nextElement();
    }

    DelombokApp$1$1(DelombokApp$1 delombokApp$1, Enumeration enumeration, File file, String str) {
        this.this$1 = delombokApp$1;
        this.val$parent = enumeration;
        this.val$toolsJar = file;
        this.val$name = str;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return !this.first || this.val$parent.hasMoreElements();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Enumeration
    public URL nextElement() {
        if (!this.first) {
            this.first = true;
            try {
                return new URL("jar:file:" + this.val$toolsJar.getAbsolutePath() + "!" + this.val$name);
            } catch (MalformedURLException unused) {
                return (URL) this.val$parent.nextElement();
            }
        }
        return (URL) this.val$parent.nextElement();
    }
}
