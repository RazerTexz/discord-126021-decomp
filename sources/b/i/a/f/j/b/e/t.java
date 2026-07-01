package b.i.a.f.j.b.e;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements b.i.a.f.e.h.j.e<Status> {
    public final /* synthetic */ TaskCompletionSource a;

    public t(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // b.i.a.f.e.h.j.e
    public final void a(Status status) {
        TaskCompletionSource taskCompletionSource = this.a;
        taskCompletionSource.a.t(new ApiException(status));
    }

    @Override // b.i.a.f.e.h.j.e
    public final void b(Object obj) {
        this.a.a.s(null);
    }
}
