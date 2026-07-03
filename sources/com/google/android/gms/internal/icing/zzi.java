package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p324k.C3569n;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new C3569n();

    /* JADX INFO: renamed from: j */
    public final String f20589j;

    /* JADX INFO: renamed from: k */
    public final String f20590k;

    /* JADX INFO: renamed from: l */
    public final String f20591l;

    public zzi(String str, String str2, String str3) {
        this.f20589j = str;
        this.f20590k = str2;
        this.f20591l = str3;
    }

    public final String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.f20589j, this.f20590k, this.f20591l);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20589j, false);
        C1460d.m574t2(parcel, 2, this.f20590k, false);
        C1460d.m574t2(parcel, 3, this.f20591l, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
