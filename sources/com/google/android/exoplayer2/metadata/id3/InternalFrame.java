package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import b.i.a.c.f3.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable$Creator<InternalFrame> CREATOR = new InternalFrame$a();
    public final String k;
    public final String l;
    public final String m;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.k = str;
        this.l = str2;
        this.m = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return e0.a(this.l, internalFrame.l) && e0.a(this.k, internalFrame.k) && e0.a(this.m, internalFrame.m);
    }

    public int hashCode() {
        String str = this.k;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.m;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.j;
        String str2 = this.k;
        String str3 = this.l;
        StringBuilder sbS = a.S(a.b(str3, a.b(str2, a.b(str, 23))), str, ": domain=", str2, ", description=");
        sbS.append(str3);
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.m);
    }

    public InternalFrame(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        int i = e0.a;
        this.k = string;
        this.l = parcel.readString();
        this.m = parcel.readString();
    }
}
