package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.e0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3288e0<T> extends AbstractC3306m0 {

    /* JADX INFO: renamed from: b */
    public final TaskCompletionSource<T> f9367b;

    public AbstractC3288e0(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f9367b = taskCompletionSource;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: b */
    public void mo4072b(@NonNull Status status) {
        this.f9367b.m9125a(new ApiException(status));
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: c */
    public final void mo4073c(C3293g.a<?> aVar) throws DeadObjectException {
        try {
            mo4075h(aVar);
        } catch (DeadObjectException e) {
            this.f9367b.m9125a(new ApiException(AbstractC3317s.m4114a(e)));
            throw e;
        } catch (RemoteException e2) {
            this.f9367b.m9125a(new ApiException(AbstractC3317s.m4114a(e2)));
        } catch (RuntimeException e3) {
            this.f9367b.m9125a(e3);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3317s
    /* JADX INFO: renamed from: e */
    public void mo4074e(@NonNull Exception exc) {
        this.f9367b.m9125a(exc);
    }

    /* JADX INFO: renamed from: h */
    public abstract void mo4075h(C3293g.a<?> aVar) throws RemoteException;
}
