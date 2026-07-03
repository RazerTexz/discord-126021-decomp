package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4280f;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4286i;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4312v;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.n0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3308n0 extends AbstractC3288e0<Void> {

    /* JADX INFO: renamed from: c */
    public final C3285d0 f9436c;

    public C3308n0(C3285d0 c3285d0, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f9436c = c3285d0;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ void mo4113d(@NonNull C3328x0 c3328x0, boolean z2) {
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3306m0
    @Nullable
    /* JADX INFO: renamed from: f */
    public final Feature[] mo4111f(C3293g.a<?> aVar) {
        Objects.requireNonNull(this.f9436c.f9360a);
        return null;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3306m0
    /* JADX INFO: renamed from: g */
    public final boolean mo4112g(C3293g.a<?> aVar) {
        Objects.requireNonNull(this.f9436c.f9360a);
        return false;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3288e0
    /* JADX INFO: renamed from: h */
    public final void mo4075h(C3293g.a<?> aVar) throws RemoteException {
        AbstractC3305m<C3266a.b, ?> abstractC3305m = this.f9436c.f9360a;
        C3266a.f fVar = aVar.f9393b;
        TaskCompletionSource<T> taskCompletionSource = this.f9367b;
        C4312v c4312v = (C4312v) abstractC3305m;
        Objects.requireNonNull(c4312v);
        c4312v.f11435b.mo5981a((C4280f) fVar, C4286i.m5983j(c4312v.f11436c, taskCompletionSource));
        C3301k.a<?> aVar2 = this.f9436c.f9360a.f9435a.f9430c;
        if (aVar2 != null) {
            aVar.f9398g.put(aVar2, this.f9436c);
        }
    }
}
