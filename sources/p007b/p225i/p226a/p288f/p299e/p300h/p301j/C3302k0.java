package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p;
import p007b.p225i.p226a.p288f.p313h.p315b.BinderC3451k;
import p007b.p225i.p226a.p288f.p313h.p315b.C3449i;
import p007b.p225i.p226a.p288f.p313h.p315b.InterfaceC3445e;

/* JADX INFO: Add missing generic type declarations: [A, ResultT] */
/* JADX INFO: renamed from: b.i.a.f.e.h.j.k0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3302k0<A, ResultT> extends AbstractC3311p<A, ResultT> {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ AbstractC3311p.a f9434c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3302k0(AbstractC3311p.a aVar, Feature[] featureArr, boolean z2) {
        super(featureArr, z2, null);
        this.f9434c = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TA;Lcom/google/android/gms/tasks/TaskCompletionSource<TResultT;>;)V */
    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p
    /* JADX INFO: renamed from: c */
    public final void mo4109c(C3266a.b bVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        Objects.requireNonNull(this.f9434c.f9440a);
        ((InterfaceC3445e) ((C3449i) bVar).m4142w()).mo4393Y(new BinderC3451k(taskCompletionSource));
    }
}
