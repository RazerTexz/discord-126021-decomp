package b.i.c.s;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class z implements b.i.a.f.n.c {
    public final d0$a a;

    public z(d0$a d0_a) {
        this.a = d0_a;
    }

    @Override // b.i.a.f.n.c
    public final void onComplete(Task task) {
        this.a.a();
    }
}
