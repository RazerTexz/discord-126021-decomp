package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4314w;

/* JADX INFO: loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Parcelable.Creator<zza> CREATOR = new C4314w();

    /* JADX INFO: renamed from: j */
    public final int f20771j;

    /* JADX INFO: renamed from: k */
    public final int f20772k;

    /* JADX INFO: renamed from: l */
    public final int f20773l;

    public zza(int i, int i2, int i3) {
        this.f20771j = i;
        this.f20772k = i2;
        this.f20773l = (-169 >= i3 || i3 >= 87) ? Integer.MIN_VALUE : i3;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    /* JADX INFO: renamed from: U */
    public final int mo9118U() {
        return this.f20773l;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    /* JADX INFO: renamed from: V */
    public final int mo9119V() {
        return this.f20772k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        return this.f20772k == bleSignal.mo9119V() && this.f20773l == bleSignal.mo9118U();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20772k), Integer.valueOf(this.f20773l)});
    }

    public final String toString() {
        int i = this.f20772k;
        int i2 = this.f20773l;
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
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20771j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20772k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = this.f20773l;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        C1460d.m418A2(parcel, iM594y2);
    }
}
