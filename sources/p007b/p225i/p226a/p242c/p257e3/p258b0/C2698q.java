package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.os.ConditionVariable;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.q */
/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2698q extends Thread {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ConditionVariable f6504j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C2699r f6505k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2698q(C2699r c2699r, String str, ConditionVariable conditionVariable) {
        super(str);
        this.f6505k = c2699r;
        this.f6504j = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this.f6505k) {
            this.f6504j.open();
            C2699r.m2823j(this.f6505k);
            this.f6505k.f6508c.mo2786e();
        }
    }
}
