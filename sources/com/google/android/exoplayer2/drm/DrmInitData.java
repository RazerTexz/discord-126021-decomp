package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.x0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class DrmInitData implements Comparator<DrmInitData$SchemeData>, Parcelable {
    public static final Parcelable$Creator<DrmInitData> CREATOR = new DrmInitData$a();
    public final DrmInitData$SchemeData[] j;
    public int k;

    @Nullable
    public final String l;
    public final int m;

    public DrmInitData(@Nullable String str, boolean z2, DrmInitData$SchemeData... drmInitData$SchemeDataArr) {
        this.l = str;
        drmInitData$SchemeDataArr = z2 ? (DrmInitData$SchemeData[]) drmInitData$SchemeDataArr.clone() : drmInitData$SchemeDataArr;
        this.j = drmInitData$SchemeDataArr;
        this.m = drmInitData$SchemeDataArr.length;
        Arrays.sort(drmInitData$SchemeDataArr, this);
    }

    public DrmInitData a(@Nullable String str) {
        return e0.a(this.l, str) ? this : new DrmInitData(str, false, this.j);
    }

    @Override // java.util.Comparator
    public int compare(DrmInitData$SchemeData drmInitData$SchemeData, DrmInitData$SchemeData drmInitData$SchemeData2) {
        DrmInitData$SchemeData drmInitData$SchemeData3 = drmInitData$SchemeData;
        DrmInitData$SchemeData drmInitData$SchemeData4 = drmInitData$SchemeData2;
        UUID uuid = x0.a;
        if (uuid.equals(drmInitData$SchemeData3.k)) {
            return uuid.equals(drmInitData$SchemeData4.k) ? 0 : 1;
        }
        return drmInitData$SchemeData3.k.compareTo(drmInitData$SchemeData4.k);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return e0.a(this.l, drmInitData.l) && Arrays.equals(this.j, drmInitData.j);
    }

    public int hashCode() {
        if (this.k == 0) {
            String str = this.l;
            this.k = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.j);
        }
        return this.k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.l);
        parcel.writeTypedArray(this.j, 0);
    }

    public DrmInitData(Parcel parcel) {
        this.l = parcel.readString();
        DrmInitData$SchemeData[] drmInitData$SchemeDataArr = (DrmInitData$SchemeData[]) parcel.createTypedArray(DrmInitData$SchemeData.CREATOR);
        int i = e0.a;
        this.j = drmInitData$SchemeDataArr;
        this.m = drmInitData$SchemeDataArr.length;
    }
}
