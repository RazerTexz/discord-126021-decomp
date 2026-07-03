package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p325l.C3675h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new C3675h();

    /* JADX INFO: renamed from: j */
    public final long f20621j;

    /* JADX INFO: renamed from: k */
    public final long f20622k;

    /* JADX INFO: renamed from: l */
    public final boolean f20623l;

    /* JADX INFO: renamed from: m */
    public final String f20624m;

    /* JADX INFO: renamed from: n */
    public final String f20625n;

    /* JADX INFO: renamed from: o */
    public final String f20626o;

    /* JADX INFO: renamed from: p */
    public final Bundle f20627p;

    public zzae(long j, long j2, boolean z2, String str, String str2, String str3, Bundle bundle) {
        this.f20621j = j;
        this.f20622k = j2;
        this.f20623l = z2;
        this.f20624m = str;
        this.f20625n = str2;
        this.f20626o = str3;
        this.f20627p = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        long j = this.f20621j;
        parcel.writeInt(524289);
        parcel.writeLong(j);
        long j2 = this.f20622k;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        boolean z2 = this.f20623l;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m574t2(parcel, 4, this.f20624m, false);
        C1460d.m574t2(parcel, 5, this.f20625n, false);
        C1460d.m574t2(parcel, 6, this.f20626o, false);
        C1460d.m558p2(parcel, 7, this.f20627p, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
