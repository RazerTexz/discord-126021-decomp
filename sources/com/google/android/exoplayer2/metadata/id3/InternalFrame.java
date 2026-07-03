package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new C10732a();

    /* JADX INFO: renamed from: k */
    public final String f19990k;

    /* JADX INFO: renamed from: l */
    public final String f19991l;

    /* JADX INFO: renamed from: m */
    public final String f19992m;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.InternalFrame$a */
    public class C10732a implements Parcelable.Creator<InternalFrame> {
        @Override // android.os.Parcelable.Creator
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InternalFrame[] newArray(int i) {
            return new InternalFrame[i];
        }
    }

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f19990k = str;
        this.f19991l = str2;
        this.f19992m = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return C2738e0.m2993a(this.f19991l, internalFrame.f19991l) && C2738e0.m2993a(this.f19990k, internalFrame.f19990k) && C2738e0.m2993a(this.f19992m, internalFrame.f19992m);
    }

    public int hashCode() {
        String str = this.f19990k;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19991l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19992m;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f19990k;
        String str3 = this.f19991l;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 23))), str, ": domain=", str2, ", description=");
        sbM831S.append(str3);
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19989j);
        parcel.writeString(this.f19990k);
        parcel.writeString(this.f19992m);
    }

    public InternalFrame(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19990k = string;
        this.f19991l = parcel.readString();
        this.f19992m = parcel.readString();
    }
}
