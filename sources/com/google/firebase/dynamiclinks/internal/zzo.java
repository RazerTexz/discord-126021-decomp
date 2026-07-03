package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p361c.p391o.p392b.C4780m;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new C4780m();

    /* JADX INFO: renamed from: j */
    public final Uri f21428j;

    /* JADX INFO: renamed from: k */
    public final Uri f21429k;

    /* JADX INFO: renamed from: l */
    public final List<zzr> f21430l;

    public zzo(Uri uri, Uri uri2, List<zzr> list) {
        this.f21428j = uri;
        this.f21429k = uri2;
        this.f21430l = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m570s2(parcel, 1, this.f21428j, i, false);
        C1460d.m570s2(parcel, 2, this.f21429k, i, false);
        C1460d.m586w2(parcel, 3, this.f21430l, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
