package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.C;
import b.i.a.c.f3.Util2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();
    public final SchemeData[] j;
    public int k;

    @Nullable
    public final String l;
    public final int m;

    public class a implements Parcelable.Creator<DrmInitData> {
        @Override // android.os.Parcelable.Creator
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    }

    public DrmInitData(@Nullable String str, boolean z2, SchemeData... schemeDataArr) {
        this.l = str;
        schemeDataArr = z2 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.j = schemeDataArr;
        this.m = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    public DrmInitData a(@Nullable String str) {
        return Util2.a(this.l, str) ? this : new DrmInitData(str, false, this.j);
    }

    @Override // java.util.Comparator
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        UUID uuid = C.a;
        if (uuid.equals(schemeData3.k)) {
            return uuid.equals(schemeData4.k) ? 0 : 1;
        }
        return schemeData3.k.compareTo(schemeData4.k);
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
        return Util2.a(this.l, drmInitData.l) && Arrays.equals(this.j, drmInitData.j);
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

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();
        public int j;
        public final UUID k;

        @Nullable
        public final String l;
        public final String m;

        @Nullable
        public final byte[] n;

        public class a implements Parcelable.Creator<SchemeData> {
            @Override // android.os.Parcelable.Creator
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        }

        public SchemeData(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            Objects.requireNonNull(uuid);
            this.k = uuid;
            this.l = str;
            Objects.requireNonNull(str2);
            this.m = str2;
            this.n = bArr;
        }

        public boolean a(UUID uuid) {
            return C.a.equals(this.k) || uuid.equals(this.k);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return Util2.a(this.l, schemeData.l) && Util2.a(this.m, schemeData.m) && Util2.a(this.k, schemeData.k) && Arrays.equals(this.n, schemeData.n);
        }

        public int hashCode() {
            if (this.j == 0) {
                int iHashCode = this.k.hashCode() * 31;
                String str = this.l;
                this.j = Arrays.hashCode(this.n) + outline.m(this.m, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
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

        public SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
            Objects.requireNonNull(uuid);
            this.k = uuid;
            this.l = null;
            this.m = str;
            this.n = bArr;
        }

        public SchemeData(Parcel parcel) {
            this.k = new UUID(parcel.readLong(), parcel.readLong());
            this.l = parcel.readString();
            String string = parcel.readString();
            int i = Util2.a;
            this.m = string;
            this.n = parcel.createByteArray();
        }
    }

    public DrmInitData(Parcel parcel) {
        this.l = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        int i = Util2.a;
        this.j = schemeDataArr;
        this.m = schemeDataArr.length;
    }
}
