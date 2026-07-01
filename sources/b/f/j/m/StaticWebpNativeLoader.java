package b.f.j.m;

import b.f.m.n.NativeLoader;

/* JADX INFO: renamed from: b.f.j.m.b, reason: use source file name */
/* JADX INFO: compiled from: StaticWebpNativeLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public class StaticWebpNativeLoader {
    public static boolean a;

    public static synchronized void a() {
        if (!a) {
            NativeLoader.c("static-webp");
            a = true;
        }
    }
}
