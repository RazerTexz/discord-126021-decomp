package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p336k.C4329c;

/* JADX INFO: loaded from: classes3.dex */
public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HarmfulAppsData> CREATOR = new C4329c();

    /* JADX INFO: renamed from: j */
    public final String f20818j;

    /* JADX INFO: renamed from: k */
    public final byte[] f20819k;

    /* JADX INFO: renamed from: l */
    public final int f20820l;

    public HarmfulAppsData(String str, byte[] bArr, int i) {
        this.f20818j = str;
        this.f20819k = bArr;
        this.f20820l = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, this.f20818j, false);
        C1460d.m562q2(parcel, 3, this.f20819k, false);
        int i2 = this.f20820l;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        C1460d.m418A2(parcel, iM594y2);
    }
}
