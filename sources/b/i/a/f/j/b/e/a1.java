package b.i.a.f.j.b.e;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 extends b.i.a.f.h.m.b implements z0 {
    public a1() {
        super("com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // b.i.a.f.h.m.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        int i3 = b.i.a.f.h.m.c.a;
        ((b.i.a.f.h.m.m) this).a.a(new b.i.a.f.h.m.n(parcel.readInt() != 0));
        return true;
    }
}
