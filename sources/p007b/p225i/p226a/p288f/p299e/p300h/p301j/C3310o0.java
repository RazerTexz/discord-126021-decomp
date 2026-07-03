package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.o0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3310o0<A extends AbstractC3284d<? extends InterfaceC3273h, C3266a.b>> extends AbstractC3317s {

    /* JADX INFO: renamed from: b */
    public final A f9437b;

    public C3310o0(int i, A a) {
        super(i);
        C1460d.m595z(a, "Null methods are not runnable.");
        this.f9437b = a;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: b */
    public final void mo4072b(@NonNull Status status) {
        this.f9437b.mo4067a(status);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: c */
    public final void mo4073c(C3293g.a<?> aVar) throws DeadObjectException {
        try {
            this.f9437b.m4068l(aVar.f9393b);
        } catch (RuntimeException e) {
            mo4074e(e);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: d */
    public final void mo4113d(@NonNull C3328x0 c3328x0, boolean z2) {
        A a = this.f9437b;
        c3328x0.f9464a.put(a, Boolean.valueOf(z2));
        a.mo4051c(new C3332z0(c3328x0, a));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: e */
    public final void mo4074e(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        this.f9437b.mo4067a(new Status(10, C1643a.m859k(C1643a.m841b(localizedMessage, simpleName.length() + 2), simpleName, ": ", localizedMessage)));
    }
}
