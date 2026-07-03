package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Arrays;
import java.util.Locale;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4295m0;

/* JADX INFO: loaded from: classes3.dex */
public final class zze extends AbstractSafeParcelable implements Distance {
    public static final Parcelable.Creator<zze> CREATOR = new C4295m0();

    /* JADX INFO: renamed from: j */
    public final int f20812j;

    /* JADX INFO: renamed from: k */
    public final int f20813k;

    /* JADX INFO: renamed from: l */
    public final double f20814l;

    public zze() {
        this.f20812j = 1;
        this.f20813k = 1;
        this.f20814l = Double.NaN;
    }

    public zze(int i, int i2, double d) {
        this.f20812j = i;
        this.f20813k = i2;
        this.f20814l = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.f20813k == zzeVar.f20813k && compareTo(zzeVar) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20813k), Double.valueOf(this.f20814l)});
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    /* JADX INFO: renamed from: r0 */
    public final double mo9120r0() {
        return this.f20814l;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(this.f20814l);
        objArr[1] = this.f20813k != 1 ? "UNKNOWN" : "LOW";
        return String.format(locale, "(%.1fm, %s)", objArr);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull Distance distance) {
        if (Double.isNaN(this.f20814l) && Double.isNaN(distance.mo9120r0())) {
            return 0;
        }
        return Double.compare(this.f20814l, distance.mo9120r0());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20812j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20813k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        double d = this.f20814l;
        parcel.writeInt(524291);
        parcel.writeDouble(d);
        C1460d.m418A2(parcel, iM594y2);
    }
}
