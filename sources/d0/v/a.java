package d0.v;

import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final Thread thread(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "block");
        a$a a_a = new a$a(function0);
        if (z3) {
            a_a.setDaemon(true);
        }
        if (i > 0) {
            a_a.setPriority(i);
        }
        if (str != null) {
            a_a.setName(str);
        }
        if (classLoader != null) {
            a_a.setContextClassLoader(classLoader);
        }
        if (z2) {
            a_a.start();
        }
        return a_a;
    }

    public static /* synthetic */ Thread thread$default(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        return thread((i2 & 1) != 0 ? true : z2, (i2 & 2) != 0 ? false : z3, (i2 & 4) != 0 ? null : classLoader, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? -1 : i, function0);
    }
}
