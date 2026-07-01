package b.i.a.f.e.k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzi;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 extends b.i.a.f.h.g.b implements h {
    public a0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // b.i.a.f.h.g.b
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ((j0) this).g(parcel.readInt(), parcel.readStrongBinder(), (Bundle) b.i.a.f.h.g.c.a(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            parcel.readInt();
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            zzi zziVar = (zzi) b.i.a.f.h.g.c.a(parcel, zzi.CREATOR);
            j0 j0Var = (j0) this;
            b bVar = j0Var.a;
            b.c.a.a0.d.z(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Objects.requireNonNull(zziVar, "null reference");
            bVar.v = zziVar;
            j0Var.g(i3, strongBinder, zziVar.j);
        }
        parcel2.writeNoException();
        return true;
    }
}
