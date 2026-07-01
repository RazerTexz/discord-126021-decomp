package b.i.a.f.e.k;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y0 extends b.i.a.f.h.g.b implements z0 {
    public static final /* synthetic */ int a = 0;

    public y0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // b.i.a.f.h.g.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            b.i.a.f.f.a aVarD = ((b.i.a.f.e.x) this).d();
            parcel2.writeNoException();
            b.i.a.f.h.g.c.b(parcel2, aVarD);
        } else {
            if (i != 2) {
                return false;
            }
            int i3 = ((b.i.a.f.e.x) this).f1401b;
            parcel2.writeNoException();
            parcel2.writeInt(i3);
        }
        return true;
    }
}
