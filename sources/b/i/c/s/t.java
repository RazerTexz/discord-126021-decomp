package b.i.c.s;

import android.util.Pair;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements b.i.a.f.n.a {
    public final u a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair f1772b;

    public t(u uVar, Pair pair) {
        this.a = uVar;
        this.f1772b = pair;
    }

    @Override // b.i.a.f.n.a
    public final Object a(Task task) {
        u uVar = this.a;
        Pair pair = this.f1772b;
        synchronized (uVar) {
            uVar.f1773b.remove(pair);
        }
        return task;
    }
}
