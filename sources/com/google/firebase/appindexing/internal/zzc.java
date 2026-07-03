package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p365k.p367d.C4568f;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new C4568f();

    /* JADX INFO: renamed from: j */
    public int f21412j;

    /* JADX INFO: renamed from: k */
    public final boolean f21413k;

    /* JADX INFO: renamed from: l */
    public final String f21414l;

    /* JADX INFO: renamed from: m */
    public final String f21415m;

    /* JADX INFO: renamed from: n */
    public final byte[] f21416n;

    /* JADX INFO: renamed from: o */
    public final boolean f21417o;

    public zzc(int i, boolean z2, String str, String str2, byte[] bArr, boolean z3) {
        this.f21412j = 0;
        this.f21412j = i;
        this.f21413k = z2;
        this.f21414l = str;
        this.f21415m = str2;
        this.f21416n = bArr;
        this.f21417o = z3;
    }

    public final String toString() {
        StringBuilder sbM836X = C1643a.m836X("MetadataImpl { ", "{ eventStatus: '");
        sbM836X.append(this.f21412j);
        sbM836X.append("' } ");
        sbM836X.append("{ uploadable: '");
        sbM836X.append(this.f21413k);
        sbM836X.append("' } ");
        if (this.f21414l != null) {
            sbM836X.append("{ completionToken: '");
            sbM836X.append(this.f21414l);
            sbM836X.append("' } ");
        }
        if (this.f21415m != null) {
            sbM836X.append("{ accountName: '");
            sbM836X.append(this.f21415m);
            sbM836X.append("' } ");
        }
        if (this.f21416n != null) {
            sbM836X.append("{ ssbContext: [ ");
            for (byte b2 : this.f21416n) {
                sbM836X.append("0x");
                sbM836X.append(Integer.toHexString(b2));
                sbM836X.append(" ");
            }
            sbM836X.append("] } ");
        }
        sbM836X.append("{ contextOnly: '");
        sbM836X.append(this.f21417o);
        sbM836X.append("' } ");
        sbM836X.append("}");
        return sbM836X.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f21412j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z2 = this.f21413k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m574t2(parcel, 3, this.f21414l, false);
        C1460d.m574t2(parcel, 4, this.f21415m, false);
        C1460d.m562q2(parcel, 5, this.f21416n, false);
        boolean z3 = this.f21417o;
        parcel.writeInt(262150);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zzc(boolean z2) {
        this.f21412j = 0;
        this.f21413k = z2;
        this.f21414l = null;
        this.f21415m = null;
        this.f21416n = null;
        this.f21417o = false;
    }
}
