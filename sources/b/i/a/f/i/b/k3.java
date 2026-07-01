package b.i.a.f.i.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k3 extends b.i.a.f.h.l.a implements i3 {
    public k3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // b.i.a.f.i.b.i3
    public final String A(zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        Parcel parcelG = g(11, parcelC);
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // b.i.a.f.i.b.i3
    public final void G(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeLong(j);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        i(10, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final void I(zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(18, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final List<zzz> J(String str, String str2, String str3) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        Parcel parcelG = g(17, parcelC);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzz.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b.i.a.f.i.b.i3
    public final List<zzz> K(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        Parcel parcelG = g(16, parcelC);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzz.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b.i.a.f.i.b.i3
    public final List<zzku> R(String str, String str2, boolean z2, zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        ClassLoader classLoader = b.i.a.f.h.l.v.a;
        parcelC.writeInt(z2 ? 1 : 0);
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        Parcel parcelG = g(14, parcelC);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzku.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // b.i.a.f.i.b.i3
    public final void T(zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(4, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final void d0(zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(6, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final byte[] j(zzaq zzaqVar, String str) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zzaqVar);
        parcelC.writeString(str);
        Parcel parcelG = g(9, parcelC);
        byte[] bArrCreateByteArray = parcelG.createByteArray();
        parcelG.recycle();
        return bArrCreateByteArray;
    }

    @Override // b.i.a.f.i.b.i3
    public final void l0(zzaq zzaqVar, zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zzaqVar);
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(1, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final void m(zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(20, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final void m0(Bundle bundle, zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, bundle);
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(19, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final void p0(zzku zzkuVar, zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zzkuVar);
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(2, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final void q0(zzz zzzVar, zzn zznVar) throws RemoteException {
        Parcel parcelC = c();
        b.i.a.f.h.l.v.c(parcelC, zzzVar);
        b.i.a.f.h.l.v.c(parcelC, zznVar);
        i(12, parcelC);
    }

    @Override // b.i.a.f.i.b.i3
    public final List<zzku> u(String str, String str2, String str3, boolean z2) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        ClassLoader classLoader = b.i.a.f.h.l.v.a;
        parcelC.writeInt(z2 ? 1 : 0);
        Parcel parcelG = g(15, parcelC);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(zzku.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }
}
