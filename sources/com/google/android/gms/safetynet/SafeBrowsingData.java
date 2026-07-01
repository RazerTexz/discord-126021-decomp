package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.i.a.f.k.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new g();
    public String j;
    public DataHolder k;
    public ParcelFileDescriptor l;
    public long m;
    public byte[] n;

    public SafeBrowsingData() {
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = 0L;
        this.n = null;
    }

    public SafeBrowsingData(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        this.j = str;
        this.k = dataHolder;
        this.l = parcelFileDescriptor;
        this.m = j;
        this.n = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelFileDescriptor parcelFileDescriptor = this.l;
        g.a(this, parcel, i);
        this.l = null;
    }
}
