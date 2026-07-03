package p686z;

import bolts.ExecutorException;
import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: renamed from: z.d */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class C13199d<TResult> implements InterfaceC13198c<TResult, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C13203h f27969a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InterfaceC13198c f27970b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Executor f27971c;

    public C13199d(C13202g c13202g, C13203h c13203h, InterfaceC13198c interfaceC13198c, Executor executor) {
        this.f27969a = c13203h;
        this.f27970b = interfaceC13198c;
        this.f27971c = executor;
    }

    @Override // p686z.InterfaceC13198c
    /* JADX INFO: renamed from: a */
    public Void mo1510a(C13202g c13202g) throws Exception {
        C13203h c13203h = this.f27969a;
        InterfaceC13198c interfaceC13198c = this.f27970b;
        try {
            this.f27971c.execute(new RunnableC13200e(c13203h, interfaceC13198c, c13202g));
            return null;
        } catch (Exception e) {
            c13203h.m11375b(new ExecutorException(e));
            return null;
        }
    }
}
