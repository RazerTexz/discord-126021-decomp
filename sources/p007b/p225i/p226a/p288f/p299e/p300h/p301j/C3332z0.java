package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.z0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3332z0 implements AbstractC3269d.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ BasePendingResult f9471a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C3328x0 f9472b;

    public C3332z0(C3328x0 c3328x0, BasePendingResult basePendingResult) {
        this.f9472b = c3328x0;
        this.f9471a = basePendingResult;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d.a
    /* JADX INFO: renamed from: a */
    public final void mo4052a(Status status) {
        this.f9472b.f9464a.remove(this.f9471a);
    }
}
