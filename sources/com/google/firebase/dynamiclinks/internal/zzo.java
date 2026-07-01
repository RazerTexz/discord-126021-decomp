package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.c.o.b.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new m();
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
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.s2(parcel, 1, this.j, i, false);
        AnimatableValueParser.s2(parcel, 2, this.k, i, false);
        AnimatableValueParser.w2(parcel, 3, this.l, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
