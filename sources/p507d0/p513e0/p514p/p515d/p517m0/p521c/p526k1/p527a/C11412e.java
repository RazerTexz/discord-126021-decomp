package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.e */
/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11412e {
    public static final Class<?> tryLoadClass(ClassLoader classLoader, String str) {
        C12238m.checkNotNullParameter(classLoader, "<this>");
        C12238m.checkNotNullParameter(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
