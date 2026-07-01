package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.c.o.b.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzo> CREATOR = new m();
    public final Uri j;
    public final Uri k;
    public final List<zzr> l;

    public zzo(Uri uri, Uri uri2, List<zzr> list) {
        this.j = uri;
        this.k = uri2;
        this.l = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.s2(parcel, 1, this.j, i, false);
        d.s2(parcel, 2, this.k, i, false);
        d.w2(parcel, 3, this.l, false);
        d.A2(parcel, iY2);
    }
}
