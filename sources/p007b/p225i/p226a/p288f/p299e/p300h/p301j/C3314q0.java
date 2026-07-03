package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.q0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3314q0<ResultT> extends AbstractC3306m0 {

    /* JADX INFO: renamed from: b */
    public final AbstractC3311p<C3266a.b, ResultT> f9444b;

    /* JADX INFO: renamed from: c */
    public final TaskCompletionSource<ResultT> f9445c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC3307n f9446d;

    public C3314q0(int i, AbstractC3311p<C3266a.b, ResultT> abstractC3311p, TaskCompletionSource<ResultT> taskCompletionSource, InterfaceC3307n interfaceC3307n) {
        super(i);
        this.f9445c = taskCompletionSource;
        this.f9444b = abstractC3311p;
        this.f9446d = interfaceC3307n;
        if (i == 2 && abstractC3311p.f9439b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: b */
    public final void mo4072b(@NonNull Status status) {
        this.f9445c.m9125a(this.f9446d.mo4055a(status));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: c */
    public final void mo4073c(C3293g.a<?> aVar) throws DeadObjectException {
        try {
            this.f9444b.mo4109c(aVar.f9393b, this.f9445c);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            this.f9445c.m9125a(this.f9446d.mo4055a(AbstractC3317s.m4114a(e2)));
        } catch (RuntimeException e3) {
            this.f9445c.m9125a(e3);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: d */
    public final void mo4113d(@NonNull C3328x0 c3328x0, boolean z2) {
        TaskCompletionSource<ResultT> taskCompletionSource = this.f9445c;
        c3328x0.f9465b.put(taskCompletionSource, Boolean.valueOf(z2));
        taskCompletionSource.f20845a.mo6007b(new C3330y0(c3328x0, taskCompletionSource));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: e */
    public final void mo4074e(@NonNull Exception exc) {
        this.f9445c.m9125a(exc);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3306m0
    @Nullable
    /* JADX INFO: renamed from: f */
    public final Feature[] mo4111f(C3293g.a<?> aVar) {
        return this.f9444b.f9438a;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3306m0
    /* JADX INFO: renamed from: g */
    public final boolean mo4112g(C3293g.a<?> aVar) {
        return this.f9444b.f9439b;
    }
}
