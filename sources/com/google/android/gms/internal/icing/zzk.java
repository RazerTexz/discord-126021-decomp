package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p324k.C3570o;
import p007b.p225i.p226a.p288f.p313h.p324k.C3572q;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzk extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: k */
    public final String f20593k;

    /* JADX INFO: renamed from: l */
    public final zzt f20594l;

    /* JADX INFO: renamed from: m */
    public final int f20595m;

    /* JADX INFO: renamed from: n */
    public final byte[] f20596n;

    /* JADX INFO: renamed from: j */
    public static final int f20592j = Integer.parseInt("-1");
    public static final Parcelable.Creator<zzk> CREATOR = new C3570o();

    static {
        ArrayList arrayList = new ArrayList();
        new zzt("SsbContext", "blob", true, 1, false, null, (zzm[]) arrayList.toArray(new zzm[arrayList.size()]), null, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    public zzk(String str, zzt zztVar, int i, byte[] bArr) {
        boolean z2;
        String str2;
        String str3;
        int i2 = f20592j;
        String strM851g = null;
        if (i != i2) {
            String[] strArr = C3572q.f9837a;
            if (i >= 0) {
                String[] strArr2 = C3572q.f9837a;
                if (i >= strArr2.length) {
                    str3 = null;
                } else {
                    str3 = strArr2[i];
                }
            } else {
                str3 = null;
            }
            if (str3 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i);
        C1460d.m551o(z2, sb.toString());
        this.f20593k = str;
        this.f20594l = zztVar;
        this.f20595m = i;
        this.f20596n = bArr;
        if (i != i2) {
            String[] strArr3 = C3572q.f9837a;
            if (i >= 0) {
                String[] strArr4 = C3572q.f9837a;
                if (i >= strArr4.length) {
                    str2 = null;
                } else {
                    str2 = strArr4[i];
                }
            } else {
                str2 = null;
            }
            if (str2 == null) {
                strM851g = C1643a.m851g(32, "Invalid section type ", i);
            } else if (str != null && bArr != null) {
                strM851g = "Both content and blobContent set";
            }
        } else if (str != null) {
            strM851g = "Both content and blobContent set";
        }
        if (strM851g != null) {
            throw new IllegalArgumentException(strM851g);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20593k, false);
        C1460d.m570s2(parcel, 3, this.f20594l, i, false);
        int i2 = this.f20595m;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        C1460d.m562q2(parcel, 5, this.f20596n, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
