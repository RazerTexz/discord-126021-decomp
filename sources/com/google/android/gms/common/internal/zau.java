package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.e.k.g;
import b.i.a.f.e.k.g$a;
import b.i.a.f.e.k.x;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zau extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zau> CREATOR = new x();
    public final int j;

    @Nullable
    public IBinder k;
    public ConnectionResult l;
    public boolean m;
    public boolean n;

    public zau(int i, @Nullable IBinder iBinder, ConnectionResult connectionResult, boolean z2, boolean z3) {
        this.j = i;
        this.k = iBinder;
        this.l = connectionResult;
        this.m = z2;
        this.n = z3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zau)) {
            return false;
        }
        zau zauVar = (zau) obj;
        return this.l.equals(zauVar.l) && d.h0(w0(), zauVar.w0());
    }

    @Nullable
    public final g w0() {
        IBinder iBinder = this.k;
        if (iBinder == null) {
            return null;
        }
        return g$a.g(iBinder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        d.r2(parcel, 2, this.k, false);
        d.s2(parcel, 3, this.l, i, false);
        boolean z2 = this.m;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        d.A2(parcel, iY2);
    }
}
