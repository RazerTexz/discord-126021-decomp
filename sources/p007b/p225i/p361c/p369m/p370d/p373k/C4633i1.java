package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.c.m.d.k.i1 */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4633i1<T> implements InterfaceC4353a<T, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TaskCompletionSource f12321a;

    public C4633i1(TaskCompletionSource taskCompletionSource) {
        this.f12321a = taskCompletionSource;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public Void mo4012a(@NonNull Task task) throws Exception {
        if (task.mo6021p()) {
            this.f12321a.m9126b(task.mo6017l());
            return null;
        }
        this.f12321a.m9125a(task.mo6016k());
        return null;
    }
}
