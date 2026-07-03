package p007b.p225i.p361c.p391o.p392b;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;

/* JADX INFO: renamed from: b.i.c.o.b.g */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC4774g extends AbstractBinderC4778k {

    /* JADX INFO: renamed from: a */
    public final TaskCompletionSource<PendingDynamicLinkData> f12811a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final InterfaceC4549a f12812b;

    public BinderC4774g(InterfaceC4549a interfaceC4549a, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) {
        this.f12812b = interfaceC4549a;
        this.f12811a = taskCompletionSource;
    }
}
