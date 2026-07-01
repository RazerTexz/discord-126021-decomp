package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.f3.Util2;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();
    public final String k;
    public final String l;
    public final String m;
    public final byte[] n;

    public class a implements Parcelable.Creator<GeobFrame> {
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
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return Util2.a(this.k, geobFrame.k) && Util2.a(this.l, geobFrame.l) && Util2.a(this.m, geobFrame.m) && Arrays.equals(this.n, geobFrame.n);
    }

    public int hashCode() {
        String str = this.k;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.m;
        return Arrays.hashCode(this.n) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.j;
        String str2 = this.k;
        String str3 = this.l;
        String str4 = this.m;
        return outline.K(outline.S(outline.b(str4, outline.b(str3, outline.b(str2, outline.b(str, 36)))), str, ": mimeType=", str2, ", filename="), str3, ", description=", str4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeByteArray(this.n);
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        String string = parcel.readString();
        int i = Util2.a;
        this.k = string;
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.createByteArray();
    }
}
