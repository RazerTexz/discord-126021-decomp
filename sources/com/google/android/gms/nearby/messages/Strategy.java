package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p333j.p334b.C4326j;

/* JADX INFO: loaded from: classes3.dex */
public class Strategy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Strategy> CREATOR = new C4326j();

    /* JADX INFO: renamed from: j */
    public static final Strategy f20727j = new Strategy(2, 0, 300, 0, false, -1, 3, 0);

    /* JADX INFO: renamed from: k */
    public static final Strategy f20728k;

    /* JADX INFO: renamed from: l */
    public final int f20729l;

    /* JADX INFO: renamed from: m */
    @Deprecated
    public final int f20730m;

    /* JADX INFO: renamed from: n */
    public final int f20731n;

    /* JADX INFO: renamed from: o */
    public final int f20732o;

    /* JADX INFO: renamed from: p */
    @Deprecated
    public final boolean f20733p;

    /* JADX INFO: renamed from: q */
    public final int f20734q;

    /* JADX INFO: renamed from: r */
    public final int f20735r;

    /* JADX INFO: renamed from: s */
    public final int f20736s;

    static {
        C1460d.m547n(true, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.MAX_VALUE, 86400);
        f20728k = new Strategy(2, 0, Integer.MAX_VALUE, 0, false, 2, 3, 0);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000b A[PHI: r8
      0x000b: PHI (r8v2 int) = (r8v0 int), (r8v1 int) binds: [B:3:0x0009, B:7:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    public Strategy(int i, int i2, int i3, int i4, boolean z2, int i5, int i6, int i7) {
        this.f20729l = i;
        this.f20730m = i2;
        if (i2 == 0) {
            this.f20735r = i6;
        } else if (i2 != 2) {
            i6 = 3;
            if (i2 != 3) {
                this.f20735r = i6;
            } else {
                this.f20735r = 2;
            }
        } else {
            this.f20735r = 1;
        }
        this.f20732o = i4;
        this.f20733p = z2;
        if (z2) {
            this.f20734q = 2;
            this.f20731n = Integer.MAX_VALUE;
        } else {
            this.f20731n = i3;
            if (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 6) {
                this.f20734q = -1;
            } else {
                this.f20734q = i5;
            }
        }
        this.f20736s = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.f20729l == strategy.f20729l && this.f20735r == strategy.f20735r && this.f20731n == strategy.f20731n && this.f20732o == strategy.f20732o && this.f20734q == strategy.f20734q && this.f20736s == strategy.f20736s;
    }

    public int hashCode() {
        return (((((((((this.f20729l * 31) + this.f20735r) * 31) + this.f20731n) * 31) + this.f20732o) * 31) + this.f20734q) * 31) + this.f20736s;
    }

    public String toString() {
        String strM851g;
        String strM851g2;
        String strM851g3;
        int i = this.f20731n;
        int i2 = this.f20732o;
        String strM851g4 = "DEFAULT";
        if (i2 != 0) {
            strM851g = i2 != 1 ? C1643a.m851g(19, "UNKNOWN:", i2) : "EARSHOT";
        } else {
            strM851g = "DEFAULT";
        }
        int i3 = this.f20734q;
        if (i3 == -1) {
            strM851g2 = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            strM851g2 = arrayList.isEmpty() ? C1643a.m851g(19, "UNKNOWN:", i3) : arrayList.toString();
        }
        int i4 = this.f20735r;
        if (i4 == 3) {
            strM851g3 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            strM851g3 = arrayList2.isEmpty() ? C1643a.m851g(19, "UNKNOWN:", i4) : arrayList2.toString();
        }
        int i5 = this.f20736s;
        if (i5 != 0) {
            strM851g4 = i5 != 1 ? C1643a.m851g(20, "UNKNOWN: ", i5) : "ALWAYS_ON";
        }
        StringBuilder sb = new StringBuilder(C1643a.m841b(strM851g4, C1643a.m841b(strM851g3, C1643a.m841b(strM851g2, C1643a.m841b(strM851g, 102)))));
        sb.append("Strategy{ttlSeconds=");
        sb.append(i);
        sb.append(", distanceType=");
        sb.append(strM851g);
        C1643a.m876s0(sb, ", discoveryMedium=", strM851g2, ", discoveryMode=", strM851g3);
        sb.append(", backgroundScanMode=");
        sb.append(strM851g4);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20730m;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20731n;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = this.f20732o;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        boolean z2 = this.f20733p;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        int i5 = this.f20734q;
        parcel.writeInt(262149);
        parcel.writeInt(i5);
        int i6 = this.f20735r;
        parcel.writeInt(262150);
        parcel.writeInt(i6);
        int i7 = this.f20736s;
        parcel.writeInt(262151);
        parcel.writeInt(i7);
        int i8 = this.f20729l;
        parcel.writeInt(263144);
        parcel.writeInt(i8);
        C1460d.m418A2(parcel, iM594y2);
    }
}
