package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.j.b.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Strategy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Strategy> CREATOR = new j();
    public static final Strategy j = new Strategy(2, 0, 300, 0, false, -1, 3, 0);
    public static final Strategy k;
    public final int l;

    @Deprecated
    public final int m;
    public final int n;
    public final int o;

    @Deprecated
    public final boolean p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f3018s;

    static {
        AnimatableValueParser.n(true, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.MAX_VALUE, 86400);
        k = new Strategy(2, 0, Integer.MAX_VALUE, 0, false, 2, 3, 0);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000b A[PHI: r8
      0x000b: PHI (r8v2 int) = (r8v0 int), (r8v1 int) binds: [B:3:0x0009, B:7:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    public Strategy(int i, int i2, int i3, int i4, boolean z2, int i5, int i6, int i7) {
        this.l = i;
        this.m = i2;
        if (i2 == 0) {
            this.r = i6;
        } else if (i2 != 2) {
            i6 = 3;
            if (i2 != 3) {
                this.r = i6;
            } else {
                this.r = 2;
            }
        } else {
            this.r = 1;
        }
        this.o = i4;
        this.p = z2;
        if (z2) {
            this.q = 2;
            this.n = Integer.MAX_VALUE;
        } else {
            this.n = i3;
            if (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 6) {
                this.q = -1;
            } else {
                this.q = i5;
            }
        }
        this.f3018s = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.l == strategy.l && this.r == strategy.r && this.n == strategy.n && this.o == strategy.o && this.q == strategy.q && this.f3018s == strategy.f3018s;
    }

    public int hashCode() {
        return (((((((((this.l * 31) + this.r) * 31) + this.n) * 31) + this.o) * 31) + this.q) * 31) + this.f3018s;
    }

    public String toString() {
        String strG;
        String strG2;
        String strG3;
        int i = this.n;
        int i2 = this.o;
        String strG4 = "DEFAULT";
        if (i2 != 0) {
            strG = i2 != 1 ? outline.g(19, "UNKNOWN:", i2) : "EARSHOT";
        } else {
            strG = "DEFAULT";
        }
        int i3 = this.q;
        if (i3 == -1) {
            strG2 = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            strG2 = arrayList.isEmpty() ? outline.g(19, "UNKNOWN:", i3) : arrayList.toString();
        }
        int i4 = this.r;
        if (i4 == 3) {
            strG3 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            strG3 = arrayList2.isEmpty() ? outline.g(19, "UNKNOWN:", i4) : arrayList2.toString();
        }
        int i5 = this.f3018s;
        if (i5 != 0) {
            strG4 = i5 != 1 ? outline.g(20, "UNKNOWN: ", i5) : "ALWAYS_ON";
        }
        StringBuilder sb = new StringBuilder(outline.b(strG4, outline.b(strG3, outline.b(strG2, outline.b(strG, 102)))));
        sb.append("Strategy{ttlSeconds=");
        sb.append(i);
        sb.append(", distanceType=");
        sb.append(strG);
        outline.s0(sb, ", discoveryMedium=", strG2, ", discoveryMode=", strG3);
        sb.append(", backgroundScanMode=");
        sb.append(strG4);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = this.m;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.n;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = this.o;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        boolean z2 = this.p;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        int i5 = this.q;
        parcel.writeInt(262149);
        parcel.writeInt(i5);
        int i6 = this.r;
        parcel.writeInt(262150);
        parcel.writeInt(i6);
        int i7 = this.f3018s;
        parcel.writeInt(262151);
        parcel.writeInt(i7);
        int i8 = this.l;
        parcel.writeInt(263144);
        parcel.writeInt(i8);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
