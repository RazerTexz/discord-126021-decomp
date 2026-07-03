package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3259d0;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new C3259d0();

    /* JADX INFO: renamed from: j */
    public final boolean f20564j;

    /* JADX INFO: renamed from: k */
    public final String f20565k;

    /* JADX INFO: renamed from: l */
    public final int f20566l;

    public zzq(boolean z2, String str, int i) {
        this.f20564j = z2;
        this.f20565k = str;
        this.f20566l = C3404f.m4310k2(i) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        boolean z2 = this.f20564j;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m574t2(parcel, 2, this.f20565k, false);
        int i2 = this.f20566l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        C1460d.m418A2(parcel, iM594y2);
    }
}
