package p507d0.p583v;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.v.a */
/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12173a {

    /* JADX INFO: renamed from: d0.v.a$a */
    /* JADX INFO: compiled from: Thread.kt */
    public static final class a extends Thread {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Function0 f25231j;

        public a(Function0 function0) {
            this.f25231j = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f25231j.invoke();
        }
    }

    public static final Thread thread(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "block");
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
