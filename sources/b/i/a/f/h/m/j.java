package b.i.a.f.h.m;

import android.os.RemoteException;
import android.util.Log;
import b.i.a.f.j.b.e.s0;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends s0 {
    public final b.i.a.f.e.h.j.k<b.i.a.f.e.h.j.e<Status>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1509b = false;

    public j(b.i.a.f.e.h.j.k<b.i.a.f.e.h.j.e<Status>> kVar) {
        this.a = kVar;
    }

    public final synchronized void g(Status status) throws RemoteException {
        if (!this.f1509b) {
            this.a.a(new k(status));
            this.f1509b = true;
            return;
        }
        String strValueOf = String.valueOf(status);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
        sb.append("Received multiple statuses: ");
        sb.append(strValueOf);
        Log.wtf("NearbyMessagesCallbackWrapper", sb.toString(), new Exception());
    }
}
