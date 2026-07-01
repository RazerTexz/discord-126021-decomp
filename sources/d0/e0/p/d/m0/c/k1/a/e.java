package d0.e0.p.d.m0.c.k1.a;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final Class<?> tryLoadClass(ClassLoader classLoader, String str) {
        d0.z.d.m.checkNotNullParameter(classLoader, "<this>");
        d0.z.d.m.checkNotNullParameter(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
