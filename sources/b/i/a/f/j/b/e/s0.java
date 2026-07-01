package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 extends b.i.a.f.h.m.b implements r0 {
    public s0() {
        super("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // b.i.a.f.h.m.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((b.i.a.f.h.m.j) this).g((Status) b.i.a.f.h.m.c.a(parcel, Status.CREATOR));
        return true;
    }
}
