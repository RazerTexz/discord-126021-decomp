package b.c.a.b0;

import android.util.Log;
import b.c.a.LottieLogger;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.c.a.b0.c, reason: use source file name */
/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class Logger2 {
    public static LottieLogger a = new LogcatLogger2();

    public static void a(String str) {
        Objects.requireNonNull((LogcatLogger2) a);
    }

    public static void b(String str) {
        Objects.requireNonNull((LogcatLogger2) a);
        Set<String> set = LogcatLogger2.a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, null);
        set.add(str);
    }

    public static void c(String str, Throwable th) {
        Objects.requireNonNull((LogcatLogger2) a);
        Set<String> set = LogcatLogger2.a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }
}
