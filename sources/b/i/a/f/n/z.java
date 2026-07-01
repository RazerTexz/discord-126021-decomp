package b.i.a.f.n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class z<TResult> {
    public final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue<y<TResult>> f1602b;
    public boolean c;

    public final void a(@NonNull y<TResult> yVar) {
        synchronized (this.a) {
            if (this.f1602b == null) {
                this.f1602b = new ArrayDeque();
            }
            this.f1602b.add(yVar);
        }
    }

    public final void b(@NonNull Task<TResult> task) {
        y<TResult> yVarPoll;
        synchronized (this.a) {
            if (this.f1602b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        yVarPoll = this.f1602b.poll();
                        if (yVarPoll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    yVarPoll.a(task);
                }
            }
        }
    }
}
