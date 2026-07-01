package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.h.m.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgu extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzgu> CREATOR = new g();
    public final int j;
    public final int k;
    public final byte[] l;
    public final boolean m;

    public zzgu(int i, int i2, byte[] bArr, boolean z2) {
        this.j = i;
        this.k = i2;
        this.l = bArr;
        this.m = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.k;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        d.q2(parcel, 2, this.l, false);
        boolean z2 = this.m;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i3);
        d.A2(parcel, iY2);
    }
}
