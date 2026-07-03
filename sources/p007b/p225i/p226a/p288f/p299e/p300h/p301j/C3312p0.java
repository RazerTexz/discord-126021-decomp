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
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4316x;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.p0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3312p0 extends AbstractC3288e0<Boolean> {

    /* JADX INFO: renamed from: c */
    public final C3301k.a<?> f9442c;

    public C3312p0(C3301k.a<?> aVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f9442c = aVar;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ void mo4113d(@NonNull C3328x0 c3328x0, boolean z2) {
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3306m0
    @Nullable
    /* JADX INFO: renamed from: f */
    public final Feature[] mo4111f(C3293g.a<?> aVar) {
        C3285d0 c3285d0 = aVar.f9398g.get(this.f9442c);
        if (c3285d0 == null) {
            return null;
        }
        Objects.requireNonNull(c3285d0.f9360a);
        return null;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3306m0
    /* JADX INFO: renamed from: g */
    public final boolean mo4112g(C3293g.a<?> aVar) {
        C3285d0 c3285d0 = aVar.f9398g.get(this.f9442c);
        if (c3285d0 == null) {
            return false;
        }
        Objects.requireNonNull(c3285d0.f9360a);
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3288e0
    /* JADX INFO: renamed from: h */
    public final void mo4075h(C3293g.a<?> aVar) throws RemoteException {
        C3285d0 c3285d0Remove = aVar.f9398g.remove(this.f9442c);
        if (c3285d0Remove == null) {
            this.f9367b.m9126b((T) Boolean.FALSE);
            return;
        }
        AbstractC3313q<C3266a.b, ?> abstractC3313q = c3285d0Remove.f9361b;
        C3266a.f fVar = aVar.f9393b;
        TaskCompletionSource<T> taskCompletionSource = this.f9367b;
        C4316x c4316x = (C4316x) abstractC3313q;
        Objects.requireNonNull(c4316x);
        c4316x.f11437b.mo5981a((C4280f) fVar, C4286i.m5983j(c4316x.f11438c, taskCompletionSource));
        C3301k<?> c3301k = c3285d0Remove.f9360a.f9435a;
        c3301k.f9429b = null;
        c3301k.f9430c = null;
    }
}
