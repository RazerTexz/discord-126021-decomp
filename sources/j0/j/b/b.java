package j0.j.b;

import android.os.Handler;
import android.os.Looper;
import rx.Scheduler;
import rx.Scheduler$Worker;

/* JADX INFO: compiled from: LooperScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends Scheduler {
    public final Handler a;

    public b(Looper looper) {
        this.a = new Handler(looper);
    }

    @Override // rx.Scheduler
    public Scheduler$Worker a() {
        return new b$a(this.a);
    }
}
