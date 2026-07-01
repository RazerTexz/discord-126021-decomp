package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.e.d0;
import b.i.a.f.e.o.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzq> CREATOR = new d0();
    public final boolean j;
    public final String k;
    public final int l;

    public zzq(boolean z2, String str, int i) {
        this.j = z2;
        this.k = str;
        this.l = f.k2(i) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        boolean z2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        d.t2(parcel, 2, this.k, false);
        int i2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        d.A2(parcel, iY2);
    }
}
