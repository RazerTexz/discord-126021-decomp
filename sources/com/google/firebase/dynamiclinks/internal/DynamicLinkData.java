package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.c.o.b.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DynamicLinkData> CREATOR = new a();
    public String j;
    public String k;
    public int l;
    public long m;
    public Bundle n;
    public Uri o;

    public DynamicLinkData(String str, String str2, int i, long j, Bundle bundle, Uri uri) {
        this.m = 0L;
        this.n = null;
        this.j = str;
        this.k = str2;
        this.l = i;
        this.m = j;
        this.n = bundle;
        this.o = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.j, false);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        int i2 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        long j = this.m;
        parcel.writeInt(524292);
        parcel.writeLong(j);
        Bundle bundle = this.n;
        if (bundle == null) {
            bundle = new Bundle();
        }
        AnimatableValueParser.p2(parcel, 5, bundle, false);
        AnimatableValueParser.s2(parcel, 6, this.o, i, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
