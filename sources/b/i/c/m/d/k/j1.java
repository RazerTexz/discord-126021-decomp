package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class j1 implements Runnable {
    public final /* synthetic */ Callable j;
    public final /* synthetic */ TaskCompletionSource k;

    public j1(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.j = callable;
        this.k = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((Task) this.j.call()).h(new j1$a(this));
        } catch (Exception e) {
            this.k.a.t(e);
        }
    }
}
