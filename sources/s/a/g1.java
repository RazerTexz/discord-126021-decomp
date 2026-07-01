package s.a;

import java.util.Objects;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g1<J extends Job> extends CompletionHandler2 implements Job2, z0 {
    public final J m;

    public g1(J j) {
        this.m = j;
    }

    @Override // s.a.z0
    public boolean a() {
        return true;
    }

    @Override // s.a.Job2
    public void dispose() {
        Object objM;
        J j = this.m;
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        h1 h1Var = (h1) j;
        do {
            objM = h1Var.M();
            if (!(objM instanceof g1)) {
                if (!(objM instanceof z0) || ((z0) objM).getList() == null) {
                    return;
                }
                n();
                return;
            }
            if (objM != this) {
                return;
            }
        } while (!h1.j.compareAndSet(h1Var, objM, i1.g));
    }

    @Override // s.a.z0
    public m1 getList() {
        return null;
    }
}
