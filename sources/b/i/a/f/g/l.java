package b.i.a.f.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.i.a.f.f.a$a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends b.i.a.f.h.g.a implements IInterface {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final b.i.a.f.f.a i(b.i.a.f.f.a aVar, String str, int i, b.i.a.f.f.a aVar2) throws RemoteException {
        Parcel parcelG = g();
        b.i.a.f.h.g.c.b(parcelG, aVar);
        parcelG.writeString(str);
        parcelG.writeInt(i);
        b.i.a.f.h.g.c.b(parcelG, aVar2);
        Parcel parcelC = c(2, parcelG);
        b.i.a.f.f.a aVarG = a$a.g(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarG;
    }

    public final b.i.a.f.f.a t0(b.i.a.f.f.a aVar, String str, int i, b.i.a.f.f.a aVar2) throws RemoteException {
        Parcel parcelG = g();
        b.i.a.f.h.g.c.b(parcelG, aVar);
        parcelG.writeString(str);
        parcelG.writeInt(i);
        b.i.a.f.h.g.c.b(parcelG, aVar2);
        Parcel parcelC = c(3, parcelG);
        b.i.a.f.f.a aVarG = a$a.g(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarG;
    }
}
