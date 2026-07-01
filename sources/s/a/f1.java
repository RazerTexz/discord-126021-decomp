package s.a;

import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f1 extends h1 implements CompletableJob {
    public final boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(Job job) {
        h1 h1Var;
        super(true);
        boolean z2 = true;
        P(job);
        Job4 job4 = (Job4) this._parentHandle;
        q qVar = (q) (job4 instanceof q ? job4 : null);
        if (qVar == null || (h1Var = (h1) qVar.m) == null) {
            z2 = false;
            break;
        }
        while (!h1Var.J()) {
            Job4 job5 = (Job4) h1Var._parentHandle;
            q qVar2 = (q) (job5 instanceof q ? job5 : null);
            if (qVar2 == null || (h1Var = (h1) qVar2.m) == null) {
                z2 = false;
                break;
            }
        }
        this.k = z2;
    }

    @Override // s.a.h1
    public boolean J() {
        return this.k;
    }

    @Override // s.a.h1
    public boolean K() {
        return true;
    }
}
