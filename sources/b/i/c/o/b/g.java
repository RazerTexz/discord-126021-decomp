package b.i.c.o.b;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends k {
    public final TaskCompletionSource<PendingDynamicLinkData> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b.i.c.j.a.a f1759b;

    public g(b.i.c.j.a.a aVar, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) {
        this.f1759b = aVar;
        this.a = taskCompletionSource;
    }
}
