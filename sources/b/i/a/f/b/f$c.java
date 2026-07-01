package b.i.a.f.b;

import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public class f$c extends Thread {
    public f$c(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
