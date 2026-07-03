package com.google.android.gms.internal.icing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p324k.C3571p;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new C3571p();

    /* JADX INFO: renamed from: j */
    public final int f20597j;

    /* JADX INFO: renamed from: k */
    public final Bundle f20598k;

    public zzm(int i, Bundle bundle) {
        this.f20597j = i;
        this.f20598k = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        if (this.f20597j != zzmVar.f20597j) {
            return false;
        }
        Bundle bundle = this.f20598k;
        if (bundle == null) {
            return zzmVar.f20598k == null;
        }
        if (zzmVar.f20598k == null || bundle.size() != zzmVar.f20598k.size()) {
            return false;
        }
        for (String str : this.f20598k.keySet()) {
            if (!zzmVar.f20598k.containsKey(str) || !C1460d.m524h0(this.f20598k.getString(str), zzmVar.f20598k.getString(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.f20597j));
        Bundle bundle = this.f20598k;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                arrayList.add(str);
                arrayList.add(this.f20598k.getString(str));
            }
        }
        return Arrays.hashCode(arrayList.toArray(new Object[0]));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20597j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m558p2(parcel, 2, this.f20598k, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
