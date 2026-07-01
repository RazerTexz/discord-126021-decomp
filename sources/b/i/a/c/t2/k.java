package b.i.a.c.t2;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Executor {
    public final /* synthetic */ Handler j;

    public /* synthetic */ k(Handler handler) {
        this.j = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.j.post(runnable);
    }
}
