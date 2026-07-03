package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new C10731a();

    /* JADX INFO: renamed from: k */
    public final String f19985k;

    /* JADX INFO: renamed from: l */
    public final String f19986l;

    /* JADX INFO: renamed from: m */
    public final String f19987m;

    /* JADX INFO: renamed from: n */
    public final byte[] f19988n;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.GeobFrame$a */
    public class C10731a implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeobFrame[] newArray(int i) {
            return new GeobFrame[i];
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f19985k = str;
        this.f19986l = str2;
        this.f19987m = str3;
        this.f19988n = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return C2738e0.m2993a(this.f19985k, geobFrame.f19985k) && C2738e0.m2993a(this.f19986l, geobFrame.f19986l) && C2738e0.m2993a(this.f19987m, geobFrame.f19987m) && Arrays.equals(this.f19988n, geobFrame.f19988n);
    }

    public int hashCode() {
        String str = this.f19985k;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19986l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19987m;
        return Arrays.hashCode(this.f19988n) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f19985k;
        String str3 = this.f19986l;
        String str4 = this.f19987m;
        return C1643a.m823K(C1643a.m831S(C1643a.m841b(str4, C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 36)))), str, ": mimeType=", str2, ", filename="), str3, ", description=", str4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19985k);
        parcel.writeString(this.f19986l);
        parcel.writeString(this.f19987m);
        parcel.writeByteArray(this.f19988n);
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19985k = string;
        this.f19986l = parcel.readString();
        this.f19987m = parcel.readString();
        this.f19988n = parcel.createByteArray();
    }
}
