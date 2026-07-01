package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.k.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HarmfulAppsData> CREATOR = new c();
    public final String j;
    public final byte[] k;
    public final int l;

    public HarmfulAppsData(String str, byte[] bArr, int i) {
        this.j = str;
        this.k = bArr;
        this.l = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 2, this.j, false);
        AnimatableValueParser.q2(parcel, 3, this.k, false);
        int i2 = this.l;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
