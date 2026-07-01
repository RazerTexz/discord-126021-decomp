package d0.e0.p.d.m0.l.b.d0;

import d0.z.d.Intrinsics3;
import java.io.InputStream;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.d, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsResourceLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String str) {
        Intrinsics3.checkNotNullParameter(str, "path");
        ClassLoader classLoader = BuiltInsResourceLoader.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
