package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.AbstractBinderC4307s0;

/* JADX INFO: renamed from: b.i.a.f.h.m.j */
/* JADX INFO: loaded from: classes3.dex */
public final class BinderC3933j extends AbstractBinderC4307s0 {

    /* JADX INFO: renamed from: a */
    public final C3301k<InterfaceC3287e<Status>> f10460a;

    /* JADX INFO: renamed from: b */
    public boolean f10461b = false;

    public BinderC3933j(C3301k<InterfaceC3287e<Status>> c3301k) {
        this.f10460a = c3301k;
    }

    /* JADX INFO: renamed from: g */
    public final synchronized void m5406g(Status status) throws RemoteException {
        if (!this.f10461b) {
            this.f10460a.m4106a(new C3934k(status));
            this.f10461b = true;
            return;
        }
        String strValueOf = String.valueOf(status);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
        sb.append("Received multiple statuses: ");
        sb.append(strValueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", sb.toString(), new Exception());
    }
}
