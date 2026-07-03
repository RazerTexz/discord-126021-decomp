package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p326m.C3929f;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new C3929f();

    /* JADX INFO: renamed from: j */
    public static final zzgs f20644j = new zzgs(1, "", null);

    /* JADX INFO: renamed from: k */
    public final int f20645k;

    /* JADX INFO: renamed from: l */
    public final String f20646l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f20647m;

    public zzgs(int i, @Nullable String str, @Nullable String str2) {
        Integer numValueOf = Integer.valueOf(i);
        Objects.requireNonNull(numValueOf, "null reference");
        this.f20645k = numValueOf.intValue();
        this.f20646l = str == null ? "" : str;
        this.f20647m = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return false;
        }
        zzgs zzgsVar = (zzgs) obj;
        return C1460d.m524h0(this.f20646l, zzgsVar.f20646l) && C1460d.m524h0(this.f20647m, zzgsVar.f20647m);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20646l, this.f20647m});
    }

    public final String toString() {
        String str = this.f20646l;
        String str2 = this.f20647m;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str2, C1643a.m841b(str, 40)), "NearbyDevice{handle=", str, ", bluetoothAddress=", str2);
        sbM831S.append("}");
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 3, this.f20646l, false);
        C1460d.m574t2(parcel, 6, this.f20647m, false);
        int i2 = this.f20645k;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        C1460d.m418A2(parcel, iM594y2);
    }
}
