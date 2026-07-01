package d0.e0.p.d.m0.l.b.d0;

import d0.z.d.m;
import java.io.InputStream;

/* JADX INFO: compiled from: BuiltInsResourceLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final InputStream loadResource(String str) {
        m.checkNotNullParameter(str, "path");
        ClassLoader classLoader = d.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
