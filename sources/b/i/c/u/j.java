package b.i.c.u;

import b.i.c.u.o.c$a;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: GetIdListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements m {
    public final TaskCompletionSource<String> a;

    public j(TaskCompletionSource<String> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // b.i.c.u.m
    public boolean a(Exception exc) {
        return false;
    }

    @Override // b.i.c.u.m
    public boolean b(b.i.c.u.o.d dVar) {
        if (!(dVar.f() == c$a.UNREGISTERED) && !dVar.j() && !dVar.h()) {
            return false;
        }
        this.a.b(dVar.c());
        return true;
    }
}
