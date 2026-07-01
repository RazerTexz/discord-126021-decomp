package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import b.i.a.c.f3.e0;
import b.i.a.c.x0;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class DrmInitData$SchemeData implements Parcelable {
    public static final Parcelable$Creator<DrmInitData$SchemeData> CREATOR = new DrmInitData$SchemeData$a();
    public int j;
    public final UUID k;

    @Nullable
    public final String l;
    public final String m;

    @Nullable
    public final byte[] n;

    public DrmInitData$SchemeData(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
        Objects.requireNonNull(uuid);
        this.k = uuid;
        this.l = str;
        Objects.requireNonNull(str2);
        this.m = str2;
        this.n = bArr;
    }

    public boolean a(UUID uuid) {
        return x0.a.equals(this.k) || uuid.equals(this.k);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DrmInitData$SchemeData)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DrmInitData$SchemeData drmInitData$SchemeData = (DrmInitData$SchemeData) obj;
        return e0.a(this.l, drmInitData$SchemeData.l) && e0.a(this.m, drmInitData$SchemeData.m) && e0.a(this.k, drmInitData$SchemeData.k) && Arrays.equals(this.n, drmInitData$SchemeData.n);
    }

    public int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.k.hashCode() * 31;
            String str = this.l;
            this.j = Arrays.hashCode(this.n) + a.m(this.m, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
        }
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.k.getMostSignificantBits());
        parcel.writeLong(this.k.getLeastSignificantBits());
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeByteArray(this.n);
    }

    public DrmInitData$SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
        Objects.requireNonNull(uuid);
        this.k = uuid;
        this.l = null;
        this.m = str;
        this.n = bArr;
    }

    public DrmInitData$SchemeData(Parcel parcel) {
        this.k = new UUID(parcel.readLong(), parcel.readLong());
        this.l = parcel.readString();
        String string = parcel.readString();
        int i = e0.a;
        this.m = string;
        this.n = parcel.createByteArray();
    }
}
