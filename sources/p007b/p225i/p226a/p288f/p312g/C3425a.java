package p007b.p225i.p226a.p288f.p312g;

import dalvik.system.PathClassLoader;

/* JADX INFO: renamed from: b.i.a.f.g.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3425a extends PathClassLoader {
    public C3425a(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z2) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z2);
    }
}
