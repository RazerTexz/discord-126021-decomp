package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.j.b.e.w;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Parcelable$Creator<zza> CREATOR = new w();
    public final int j;
    public final int k;
    public final int l;

    public zza(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = (-169 >= i3 || i3 >= 87) ? Integer.MIN_VALUE : i3;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int U() {
        return this.l;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int V() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        return this.k == bleSignal.V() && this.l == bleSignal.U();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), Integer.valueOf(this.l)});
    }

    public final String toString() {
        int i = this.k;
        int i2 = this.l;
        StringBuilder sb = new StringBuilder(48);
        sb.append("BleSignal{rssi=");
        sb.append(i);
        sb.append(", txPower=");
        sb.append(i2);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        d.A2(parcel, iY2);
    }
}
