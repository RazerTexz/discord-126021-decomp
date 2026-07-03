package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new C10736a();

    /* JADX INFO: renamed from: k */
    @Nullable
    public final String f20002k;

    /* JADX INFO: renamed from: l */
    public final String f20003l;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.UrlLinkFrame$a */
    public class C10736a implements Parcelable.Creator<UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UrlLinkFrame[] newArray(int i) {
            return new UrlLinkFrame[i];
        }
    }

    public UrlLinkFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.f20002k = str2;
        this.f20003l = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f19989j.equals(urlLinkFrame.f19989j) && C2738e0.m2993a(this.f20002k, urlLinkFrame.f20002k) && C2738e0.m2993a(this.f20003l, urlLinkFrame.f20003l);
    }

    public int hashCode() {
        int iM863m = C1643a.m863m(this.f19989j, 527, 31);
        String str = this.f20002k;
        int iHashCode = (iM863m + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f20003l;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f20003l;
        return C1643a.m859k(C1643a.m841b(str2, C1643a.m841b(str, 6)), str, ": url=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19989j);
        parcel.writeString(this.f20002k);
        parcel.writeString(this.f20003l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UrlLinkFrame(Parcel parcel) {
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        super(string);
        this.f20002k = parcel.readString();
        this.f20003l = parcel.readString();
    }
}
