package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p225i.p226a.p288f.p336k.C4333g;

/* JADX INFO: loaded from: classes3.dex */
public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new C4333g();

    /* JADX INFO: renamed from: j */
    public String f20821j;

    /* JADX INFO: renamed from: k */
    public DataHolder f20822k;

    /* JADX INFO: renamed from: l */
    public ParcelFileDescriptor f20823l;

    /* JADX INFO: renamed from: m */
    public long f20824m;

    /* JADX INFO: renamed from: n */
    public byte[] f20825n;

    public SafeBrowsingData() {
        this.f20821j = null;
        this.f20822k = null;
        this.f20823l = null;
        this.f20824m = 0L;
        this.f20825n = null;
    }

    public SafeBrowsingData(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        this.f20821j = str;
        this.f20822k = dataHolder;
        this.f20823l = parcelFileDescriptor;
        this.f20824m = j;
        this.f20825n = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelFileDescriptor parcelFileDescriptor = this.f20823l;
        C4333g.m5997a(this, parcel, i);
        this.f20823l = null;
    }
}
