package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.messages.internal.Update;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p0 extends b.i.a.f.h.m.b implements o0 {
    public p0() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // b.i.a.f.h.m.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1 || i == 2) {
        } else {
            if (i != 4) {
                return false;
            }
            ((b.i.a.f.h.m.h) this).a.a(new b.i.a.f.h.m.i(parcel.createTypedArrayList(Update.CREATOR)));
        }
        return true;
    }
}
