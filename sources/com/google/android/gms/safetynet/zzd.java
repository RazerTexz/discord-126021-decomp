package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.k.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new d();
    public final long j;
    public final HarmfulAppsData[] k;
    public final int l;
    public final boolean m;

    public zzd(long j, HarmfulAppsData[] harmfulAppsDataArr, int i, boolean z2) {
        this.j = j;
        this.k = harmfulAppsDataArr;
        this.m = z2;
        if (z2) {
            this.l = i;
        } else {
            this.l = -1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        long j = this.j;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        AnimatableValueParser.v2(parcel, 3, this.k, i, false);
        int i2 = this.l;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        boolean z2 = this.m;
        parcel.writeInt(262149);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
