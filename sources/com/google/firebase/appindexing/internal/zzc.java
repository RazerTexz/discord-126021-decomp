package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.d.b.a.a;
import b.i.c.k.d.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzc> CREATOR = new f();
    public int j;
    public final boolean k;
    public final String l;
    public final String m;
    public final byte[] n;
    public final boolean o;

    public zzc(int i, boolean z2, String str, String str2, byte[] bArr, boolean z3) {
        this.j = 0;
        this.j = i;
        this.k = z2;
        this.l = str;
        this.m = str2;
        this.n = bArr;
        this.o = z3;
    }

    public final String toString() {
        StringBuilder sbX = a.X("MetadataImpl { ", "{ eventStatus: '");
        sbX.append(this.j);
        sbX.append("' } ");
        sbX.append("{ uploadable: '");
        sbX.append(this.k);
        sbX.append("' } ");
        if (this.l != null) {
            sbX.append("{ completionToken: '");
            sbX.append(this.l);
            sbX.append("' } ");
        }
        if (this.m != null) {
            sbX.append("{ accountName: '");
            sbX.append(this.m);
            sbX.append("' } ");
        }
        if (this.n != null) {
            sbX.append("{ ssbContext: [ ");
            for (byte b2 : this.n) {
                sbX.append("0x");
                sbX.append(Integer.toHexString(b2));
                sbX.append(" ");
            }
            sbX.append("] } ");
        }
        sbX.append("{ contextOnly: '");
        sbX.append(this.o);
        sbX.append("' } ");
        sbX.append("}");
        return sbX.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z2 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        d.t2(parcel, 3, this.l, false);
        d.t2(parcel, 4, this.m, false);
        d.q2(parcel, 5, this.n, false);
        boolean z3 = this.o;
        parcel.writeInt(262150);
        parcel.writeInt(z3 ? 1 : 0);
        d.A2(parcel, iY2);
    }

    public zzc(boolean z2) {
        this.j = 0;
        this.k = z2;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
    }
}
