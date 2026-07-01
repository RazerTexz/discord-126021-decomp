package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.k.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new f();
    public final int j;
    public final boolean k;

    public zzh(int i, boolean z2) {
        this.j = i;
        this.k = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        boolean z2 = this.k;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
