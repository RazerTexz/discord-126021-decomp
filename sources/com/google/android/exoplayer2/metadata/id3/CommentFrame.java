package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new C10730a();

    /* JADX INFO: renamed from: k */
    public final String f19982k;

    /* JADX INFO: renamed from: l */
    public final String f19983l;

    /* JADX INFO: renamed from: m */
    public final String f19984m;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.id3.CommentFrame$a */
    public class C10730a implements Parcelable.Creator<CommentFrame> {
        @Override // android.os.Parcelable.Creator
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f19982k = str;
        this.f19983l = str2;
        this.f19984m = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return C2738e0.m2993a(this.f19983l, commentFrame.f19983l) && C2738e0.m2993a(this.f19982k, commentFrame.f19982k) && C2738e0.m2993a(this.f19984m, commentFrame.f19984m);
    }

    public int hashCode() {
        String str = this.f19982k;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19983l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19984m;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        String str = this.f19989j;
        String str2 = this.f19982k;
        String str3 = this.f19983l;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str3, C1643a.m841b(str2, C1643a.m841b(str, 25))), str, ": language=", str2, ", description=");
        sbM831S.append(str3);
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19989j);
        parcel.writeString(this.f19982k);
        parcel.writeString(this.f19984m);
    }

    public CommentFrame(Parcel parcel) {
        super("COMM");
        String string = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19982k = string;
        this.f19983l = parcel.readString();
        this.f19984m = parcel.readString();
    }
}
