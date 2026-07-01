package d0.v;

import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.v.a, reason: use source file name */
/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Thread2 {

    /* JADX INFO: renamed from: d0.v.a$a */
    /* JADX INFO: compiled from: Thread.kt */
    public static final class a extends Thread {
        public final /* synthetic */ Function0 j;

        public a(Function0 function0) {
            this.j = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.j.invoke();
        }
    }

    public static final Thread thread(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "block");
        a aVar = new a(function0);
        if (z3) {
            aVar.setDaemon(true);
        }
        if (i > 0) {
            aVar.setPriority(i);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z2) {
            aVar.start();
        }
        return aVar;
    }
}
