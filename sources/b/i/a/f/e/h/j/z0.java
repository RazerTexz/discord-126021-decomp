package b.i.a.f.e.h.j;

import b.i.a.f.e.h.d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements d.a {
    public final /* synthetic */ BasePendingResult a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f1377b;

    public z0(x0 x0Var, BasePendingResult basePendingResult) {
        this.f1377b = x0Var;
        this.a = basePendingResult;
    }

    @Override // b.i.a.f.e.h.d.a
    public final void a(Status status) {
        this.f1377b.a.remove(this.a);
    }
}
