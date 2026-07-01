package b.c.a.b0;

import android.util.Log;
import b.c.a.m;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static m a = new b();

    public static void a(String str) {
        Objects.requireNonNull((b) a);
    }

    public static void b(String str) {
        Objects.requireNonNull((b) a);
        Set<String> set = b.a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        set.add(str);
    }

    public static void c(String str, Throwable th) {
        Objects.requireNonNull((b) a);
        Set<String> set = b.a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }
}
