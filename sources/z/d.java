package z;

import bolts.ExecutorException;
import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class d<TResult> implements c<TResult, Void> {
    public final /* synthetic */ h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f3859b;
    public final /* synthetic */ Executor c;

    public d(g gVar, h hVar, c cVar, Executor executor) {
        this.a = hVar;
        this.f3859b = cVar;
        this.c = executor;
    }

    @Override // z.c
    public Void a(g gVar) throws Exception {
        h hVar = this.a;
        c cVar = this.f3859b;
        try {
            this.c.execute(new e(hVar, cVar, gVar));
            return null;
        } catch (Exception e) {
            hVar.b(new ExecutorException(e));
            return null;
        }
    }
}
