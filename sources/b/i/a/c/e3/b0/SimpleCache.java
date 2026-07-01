package b.i.a.c.e3.b0;

import android.os.ConditionVariable;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.q, reason: use source file name */
/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleCache extends Thread {
    public final /* synthetic */ ConditionVariable j;
    public final /* synthetic */ SimpleCache2 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleCache(SimpleCache2 simpleCache2, String str, ConditionVariable conditionVariable) {
        super(str);
        this.k = simpleCache2;
        this.j = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this.k) {
            this.j.open();
            SimpleCache2.j(this.k);
            this.k.c.e();
        }
    }
}
