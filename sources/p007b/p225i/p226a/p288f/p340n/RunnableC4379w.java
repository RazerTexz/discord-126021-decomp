package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.a.f.n.w */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4379w implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Task f11519j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4380x f11520k;

    public RunnableC4379w(C4380x c4380x, Task task) {
        this.f11520k = c4380x;
        this.f11519j = task;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task taskMo4013a = this.f11520k.f11522b.mo4013a((TResult) this.f11519j.mo6017l());
            if (taskMo4013a == null) {
                C4380x c4380x = this.f11520k;
                c4380x.f11523c.m6025t(new NullPointerException("Continuation returned null"));
            } else {
                Executor executor = C4363g.f11480b;
                taskMo4013a.mo6012g(executor, this.f11520k);
                taskMo4013a.mo6010e(executor, this.f11520k);
                taskMo4013a.mo6006a(executor, this.f11520k);
            }
        } catch (RuntimeExecutionException e) {
            if (!(e.getCause() instanceof Exception)) {
                this.f11520k.f11523c.m6025t(e);
                return;
            }
            C4380x c4380x2 = this.f11520k;
            c4380x2.f11523c.m6025t((Exception) e.getCause());
        } catch (CancellationException unused) {
            this.f11520k.f11523c.m6026u();
        } catch (Exception e2) {
            this.f11520k.f11523c.m6025t(e2);
        }
    }
}
