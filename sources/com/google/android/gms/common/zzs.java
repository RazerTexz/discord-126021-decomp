package com.google.android.gms.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.RemoteException;
import android.util.Log;
import b.c.a.a0.d;
import b.i.a.f.e.e0;
import b.i.a.f.e.k.x0;
import b.i.a.f.e.k.y0;
import b.i.a.f.e.k.z0;
import b.i.a.f.e.x;
import b.i.a.f.e.y;
import b.i.a.f.f.a;
import b.i.a.f.f.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzs> CREATOR = new e0();
    public final String j;
    public final x k;
    public final boolean l;
    public final boolean m;

    public zzs(String str, IBinder iBinder, boolean z2, boolean z3) {
        this.j = str;
        y yVar = null;
        if (iBinder != null) {
            try {
                int i = y0.a;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                a aVarD = (iInterfaceQueryLocalInterface instanceof z0 ? (z0) iInterfaceQueryLocalInterface : new x0(iBinder)).d();
                byte[] bArr = aVarD == null ? null : (byte[]) b.i(aVarD);
                if (bArr != null) {
                    yVar = new y(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.k = yVar;
        this.l = z2;
        this.m = z3;
    }

    public zzs(String str, x xVar, boolean z2, boolean z3) {
        this.j = str;
        this.k = xVar;
        this.l = z2;
        this.m = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.t2(parcel, 1, this.j, false);
        x xVar = this.k;
        if (xVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            xVar = null;
        }
        d.r2(parcel, 2, xVar, false);
        boolean z2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(z3 ? 1 : 0);
        d.A2(parcel, iY2);
    }
}
