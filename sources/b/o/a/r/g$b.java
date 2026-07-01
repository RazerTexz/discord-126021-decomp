package b.o.a.r;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkerHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$b implements Executor {
    public final /* synthetic */ g j;

    public g$b(g gVar) {
        this.j = gVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.j.c(runnable);
    }
}
