package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p279z2.C3155a;

/* JADX INFO: loaded from: classes3.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new C10724a();

    /* JADX INFO: renamed from: j */
    public final int f19957j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final String f19958k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f19959l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final String f19960m;

    /* JADX INFO: renamed from: n */
    public final boolean f19961n;

    /* JADX INFO: renamed from: o */
    public final int f19962o;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.metadata.icy.IcyHeaders$a */
    public class C10724a implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IcyHeaders[] newArray(int i) {
            return new IcyHeaders[i];
        }
    }

    public IcyHeaders(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, int i2) {
        C1460d.m531j(i2 == -1 || i2 > 0);
        this.f19957j = i;
        this.f19958k = str;
        this.f19959l = str2;
        this.f19960m = str3;
        this.f19961n = z2;
        this.f19962o = i2;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static IcyHeaders m8881a(Map<String, List<String>> map) {
        boolean z2;
        int i;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i2;
        List<String> list = map.get("icy-br");
        int i3 = -1;
        boolean z3 = true;
        if (list != null) {
            String str4 = list.get(0);
            try {
                i2 = Integer.parseInt(str4) * 1000;
                if (i2 > 0) {
                    z2 = true;
                } else {
                    try {
                        String strValueOf = String.valueOf(str4);
                        Log.w("IcyHeaders", strValueOf.length() != 0 ? "Invalid bitrate: ".concat(strValueOf) : new String("Invalid bitrate: "));
                        z2 = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        String strValueOf2 = String.valueOf(str4);
                        Log.w("IcyHeaders", strValueOf2.length() != 0 ? "Invalid bitrate header: ".concat(strValueOf2) : new String("Invalid bitrate header: "));
                        i = i2;
                        z2 = false;
                    }
                }
                i = i2;
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        } else {
            z2 = false;
            i = -1;
        }
        List<String> list2 = map.get("icy-genre");
        if (list2 != null) {
            str = list2.get(0);
            z2 = true;
        } else {
            str = null;
        }
        List<String> list3 = map.get("icy-name");
        if (list3 != null) {
            str2 = list3.get(0);
            z2 = true;
        } else {
            str2 = null;
        }
        List<String> list4 = map.get("icy-url");
        if (list4 != null) {
            str3 = list4.get(0);
            z2 = true;
        } else {
            str3 = null;
        }
        List<String> list5 = map.get("icy-pub");
        if (list5 != null) {
            zEquals = list5.get(0).equals("1");
            z2 = true;
        } else {
            zEquals = false;
        }
        List<String> list6 = map.get("icy-metaint");
        if (list6 != null) {
            String str5 = list6.get(0);
            try {
                int i4 = Integer.parseInt(str5);
                if (i4 > 0) {
                    i3 = i4;
                } else {
                    try {
                        String strValueOf3 = String.valueOf(str5);
                        Log.w("IcyHeaders", strValueOf3.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf3) : new String("Invalid metadata interval: "));
                        z3 = z2;
                    } catch (NumberFormatException unused3) {
                        i3 = i4;
                        String strValueOf4 = String.valueOf(str5);
                        Log.w("IcyHeaders", strValueOf4.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf4) : new String("Invalid metadata interval: "));
                    }
                }
                z2 = z3;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z2) {
            return new IcyHeaders(i, str, str2, str3, zEquals, i3);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.f19957j == icyHeaders.f19957j && C2738e0.m2993a(this.f19958k, icyHeaders.f19958k) && C2738e0.m2993a(this.f19959l, icyHeaders.f19959l) && C2738e0.m2993a(this.f19960m, icyHeaders.f19960m) && this.f19961n == icyHeaders.f19961n && this.f19962o == icyHeaders.f19962o;
    }

    public int hashCode() {
        int i = (527 + this.f19957j) * 31;
        String str = this.f19958k;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f19959l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f19960m;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f19961n ? 1 : 0)) * 31) + this.f19962o;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: n */
    public /* synthetic */ void mo8878n(C2835p1.b bVar) {
        C3155a.m3894c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return C3155a.m3892a(this);
    }

    public String toString() {
        String str = this.f19959l;
        String str2 = this.f19958k;
        int i = this.f19957j;
        int i2 = this.f19962o;
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str2, C1643a.m841b(str, 80)), "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        sbM831S.append("\", bitrate=");
        sbM831S.append(i);
        sbM831S.append(", metadataInterval=");
        sbM831S.append(i2);
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19957j);
        parcel.writeString(this.f19958k);
        parcel.writeString(this.f19959l);
        parcel.writeString(this.f19960m);
        boolean z2 = this.f19961n;
        int i2 = C2738e0.f6708a;
        parcel.writeInt(z2 ? 1 : 0);
        parcel.writeInt(this.f19962o);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* JADX INFO: renamed from: y */
    public /* synthetic */ C2811j1 mo8880y() {
        return C3155a.m3893b(this);
    }

    public IcyHeaders(Parcel parcel) {
        this.f19957j = parcel.readInt();
        this.f19958k = parcel.readString();
        this.f19959l = parcel.readString();
        this.f19960m = parcel.readString();
        int i = C2738e0.f6708a;
        this.f19961n = parcel.readInt() != 0;
        this.f19962o = parcel.readInt();
    }
}
