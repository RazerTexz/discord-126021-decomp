package b.i.a.c.e3.b0;

import android.os.ConditionVariable;

/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends Thread {
    public final /* synthetic */ ConditionVariable j;
    public final /* synthetic */ r k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, String str, ConditionVariable conditionVariable) {
        super(str);
        this.k = rVar;
        this.j = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this.k) {
            this.j.open();
            r.j(this.k);
            this.k.c.e();
        }
    }
}
