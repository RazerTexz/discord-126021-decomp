package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2997x0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new C10711a();

    /* JADX INFO: renamed from: j */
    public final SchemeData[] f19847j;

    /* JADX INFO: renamed from: k */
    public int f19848k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f19849l;

    /* JADX INFO: renamed from: m */
    public final int f19850m;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DrmInitData$a */
    public class C10711a implements Parcelable.Creator<DrmInitData> {
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
        this.f19849l = str;
        schemeDataArr = z2 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f19847j = schemeDataArr;
        this.f19850m = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    /* JADX INFO: renamed from: a */
    public DrmInitData m8835a(@Nullable String str) {
        return C2738e0.m2993a(this.f19849l, str) ? this : new DrmInitData(str, false, this.f19847j);
    }

    @Override // java.util.Comparator
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        UUID uuid = C2997x0.f8021a;
        if (uuid.equals(schemeData3.f19852k)) {
            return uuid.equals(schemeData4.f19852k) ? 0 : 1;
        }
        return schemeData3.f19852k.compareTo(schemeData4.f19852k);
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
        return C2738e0.m2993a(this.f19849l, drmInitData.f19849l) && Arrays.equals(this.f19847j, drmInitData.f19847j);
    }

    public int hashCode() {
        if (this.f19848k == 0) {
            String str = this.f19849l;
            this.f19848k = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f19847j);
        }
        return this.f19848k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19849l);
        parcel.writeTypedArray(this.f19847j, 0);
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new C10710a();

        /* JADX INFO: renamed from: j */
        public int f19851j;

        /* JADX INFO: renamed from: k */
        public final UUID f19852k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public final String f19853l;

        /* JADX INFO: renamed from: m */
        public final String f19854m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public final byte[] f19855n;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.DrmInitData$SchemeData$a */
        public class C10710a implements Parcelable.Creator<SchemeData> {
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
            this.f19852k = uuid;
            this.f19853l = str;
            Objects.requireNonNull(str2);
            this.f19854m = str2;
            this.f19855n = bArr;
        }

        /* JADX INFO: renamed from: a */
        public boolean m8836a(UUID uuid) {
            return C2997x0.f8021a.equals(this.f19852k) || uuid.equals(this.f19852k);
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
            return C2738e0.m2993a(this.f19853l, schemeData.f19853l) && C2738e0.m2993a(this.f19854m, schemeData.f19854m) && C2738e0.m2993a(this.f19852k, schemeData.f19852k) && Arrays.equals(this.f19855n, schemeData.f19855n);
        }

        public int hashCode() {
            if (this.f19851j == 0) {
                int iHashCode = this.f19852k.hashCode() * 31;
                String str = this.f19853l;
                this.f19851j = Arrays.hashCode(this.f19855n) + C1643a.m863m(this.f19854m, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
            }
            return this.f19851j;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f19852k.getMostSignificantBits());
            parcel.writeLong(this.f19852k.getLeastSignificantBits());
            parcel.writeString(this.f19853l);
            parcel.writeString(this.f19854m);
            parcel.writeByteArray(this.f19855n);
        }

        public SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
            Objects.requireNonNull(uuid);
            this.f19852k = uuid;
            this.f19853l = null;
            this.f19854m = str;
            this.f19855n = bArr;
        }

        public SchemeData(Parcel parcel) {
            this.f19852k = new UUID(parcel.readLong(), parcel.readLong());
            this.f19853l = parcel.readString();
            String string = parcel.readString();
            int i = C2738e0.f6708a;
            this.f19854m = string;
            this.f19855n = parcel.createByteArray();
        }
    }

    public DrmInitData(Parcel parcel) {
        this.f19849l = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        int i = C2738e0.f6708a;
        this.f19847j = schemeDataArr;
        this.f19850m = schemeDataArr.length;
    }
}
