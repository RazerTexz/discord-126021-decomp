package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import b.i.a.c.f3.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable$Creator<UrlLinkFrame> CREATOR = new UrlLinkFrame$a();

    @Nullable
    public final String k;
    public final String l;

    public UrlLinkFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.k = str2;
        this.l = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.j.equals(urlLinkFrame.j) && e0.a(this.k, urlLinkFrame.k) && e0.a(this.l, urlLinkFrame.l);
    }

    public int hashCode() {
        int iM = a.m(this.j, 527, 31);
        String str = this.k;
        int iHashCode = (iM + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.j;
        String str2 = this.l;
        return a.k(a.b(str2, a.b(str, 6)), str, ": url=", str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UrlLinkFrame(Parcel parcel) {
        String string = parcel.readString();
        int i = e0.a;
        super(string);
        this.k = parcel.readString();
        this.l = parcel.readString();
    }
}
