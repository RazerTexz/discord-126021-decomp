package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p336k.C4331e;

/* JADX INFO: loaded from: classes3.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new C4331e();

    /* JADX INFO: renamed from: j */
    public final String f20831j;

    public zzf(String str) {
        this.f20831j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 2, this.f20831j, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
