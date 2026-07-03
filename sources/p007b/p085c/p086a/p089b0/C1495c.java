package p007b.p085c.p086a.p089b0;

import android.util.Log;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.InterfaceC1514m;

/* JADX INFO: renamed from: b.c.a.b0.c */
/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class C1495c {

    /* JADX INFO: renamed from: a */
    public static InterfaceC1514m f2296a = new C1494b();

    /* JADX INFO: renamed from: a */
    public static void m639a(String str) {
        Objects.requireNonNull((C1494b) f2296a);
    }

    /* JADX INFO: renamed from: b */
    public static void m640b(String str) {
        Objects.requireNonNull((C1494b) f2296a);
        Set<String> set = C1494b.f2295a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        set.add(str);
    }

    /* JADX INFO: renamed from: c */
    public static void m641c(String str, Throwable th) {
        Objects.requireNonNull((C1494b) f2296a);
        Set<String> set = C1494b.f2295a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }
}
