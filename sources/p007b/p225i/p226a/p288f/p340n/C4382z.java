package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: renamed from: b.i.a.f.n.z */
/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4382z<TResult> {

    /* JADX INFO: renamed from: a */
    public final Object f11524a = new Object();

    /* JADX INFO: renamed from: b */
    public Queue<InterfaceC4381y<TResult>> f11525b;

    /* JADX INFO: renamed from: c */
    public boolean f11526c;

    /* JADX INFO: renamed from: a */
    public final void m6031a(@NonNull InterfaceC4381y<TResult> interfaceC4381y) {
        synchronized (this.f11524a) {
            if (this.f11525b == null) {
                this.f11525b = new ArrayDeque();
            }
            this.f11525b.add(interfaceC4381y);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m6032b(@NonNull Task<TResult> task) {
        InterfaceC4381y<TResult> interfaceC4381yPoll;
        synchronized (this.f11524a) {
            if (this.f11525b != null && !this.f11526c) {
                this.f11526c = true;
                while (true) {
                    synchronized (this.f11524a) {
                        interfaceC4381yPoll = this.f11525b.poll();
                        if (interfaceC4381yPoll == null) {
                            this.f11526c = false;
                            return;
                        }
                    }
                    interfaceC4381yPoll.mo6030a(task);
                }
            }
        }
    }
}
