package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.j.b.e.m0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class zze extends AbstractSafeParcelable implements Distance {
    public static final Parcelable.Creator<zze> CREATOR = new m0();
    public final int j;
    public final int k;
    public final double l;

    public zze() {
        this.j = 1;
        this.k = 1;
        this.l = Double.NaN;
    }

    public zze(int i, int i2, double d) {
        this.j = i;
        this.k = i2;
        this.l = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.k == zzeVar.k && compareTo(zzeVar) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), Double.valueOf(this.l)});
    }

    @Override // com.google.android.gms.nearby.messages.Distance
    public final double r0() {
        return this.l;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(this.l);
        objArr[1] = this.k != 1 ? "UNKNOWN" : "LOW";
        return String.format(locale, "(%.1fm, %s)", objArr);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull Distance distance) {
        if (Double.isNaN(this.l) && Double.isNaN(distance.r0())) {
            return 0;
        }
        return Double.compare(this.l, distance.r0());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        double d = this.l;
        parcel.writeInt(524291);
        parcel.writeDouble(d);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
