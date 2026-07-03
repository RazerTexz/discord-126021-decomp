package p007b.p225i.p361c.p391o.p392b;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;

/* JADX INFO: renamed from: b.i.c.o.b.i */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4776i extends AbstractC3311p<C4771d, PendingDynamicLinkData> {

    /* JADX INFO: renamed from: c */
    public final String f12813c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final InterfaceC4549a f12814d;

    public C4776i(InterfaceC4549a interfaceC4549a, String str) {
        this.f12813c = str;
        this.f12814d = interfaceC4549a;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ void mo4109c(C3266a.b bVar, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) throws RemoteException {
        C4771d c4771d = (C4771d) bVar;
        try {
            ((InterfaceC4777j) c4771d.m4142w()).mo6704b0(new BinderC4774g(this.f12814d, taskCompletionSource), this.f12813c);
        } catch (RemoteException unused) {
        }
    }
}
