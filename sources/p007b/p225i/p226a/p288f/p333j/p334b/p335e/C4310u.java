package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.u */
/* JADX INFO: loaded from: classes3.dex */
public final class C4310u implements InterfaceC4357c<Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TaskCompletionSource f11434a;

    public C4310u(TaskCompletionSource taskCompletionSource) {
        this.f11434a = taskCompletionSource;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(@NonNull Task<Boolean> task) {
        if (task.mo6021p()) {
            this.f11434a.f20845a.m6024s(null);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.f11434a;
        taskCompletionSource.f20845a.m6025t(task.mo6016k());
    }
}
