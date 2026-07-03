package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* JADX INFO: renamed from: b.i.a.f.e.h.j.y0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3330y0<TResult> implements InterfaceC4357c<TResult> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TaskCompletionSource f9467a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C3328x0 f9468b;

    public C3330y0(C3328x0 c3328x0, TaskCompletionSource taskCompletionSource) {
        this.f9468b = c3328x0;
        this.f9467a = taskCompletionSource;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(@NonNull Task<TResult> task) {
        this.f9468b.f9465b.remove(this.f9467a);
    }
}
