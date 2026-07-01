package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class IcyHeaders implements Metadata$Entry {
    public static final Parcelable$Creator<IcyHeaders> CREATOR = new IcyHeaders$a();
    public final int j;

    @Nullable
    public final String k;

    @Nullable
    public final String l;

    @Nullable
    public final String m;
    public final boolean n;
    public final int o;

    public IcyHeaders(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, int i2) {
        d.j(i2 == -1 || i2 > 0);
        this.j = i;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = z2;
        this.o = i2;
    }

    @Nullable
    public static IcyHeaders a(Map<String, List<String>> map) {
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
        return this.j == icyHeaders.j && e0.a(this.k, icyHeaders.k) && e0.a(this.l, icyHeaders.l) && e0.a(this.m, icyHeaders.m) && this.n == icyHeaders.n && this.o == icyHeaders.o;
    }

    public int hashCode() {
        int i = (527 + this.j) * 31;
        String str = this.k;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.m;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.n ? 1 : 0)) * 31) + this.o;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ void n(p1$b p1_b) {
        a.c(this, p1_b);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return a.a(this);
    }

    public String toString() {
        String str = this.l;
        String str2 = this.k;
        int i = this.j;
        int i2 = this.o;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str2, b.d.b.a.a.b(str, 80)), "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        sbS.append("\", bitrate=");
        sbS.append(i);
        sbS.append(", metadataInterval=");
        sbS.append(i2);
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        boolean z2 = this.n;
        int i2 = e0.a;
        parcel.writeInt(z2 ? 1 : 0);
        parcel.writeInt(this.o);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }

    public IcyHeaders(Parcel parcel) {
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        int i = e0.a;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readInt();
    }
}
