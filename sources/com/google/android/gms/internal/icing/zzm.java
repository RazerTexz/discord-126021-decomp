package com.google.android.gms.internal.icing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.c.a.a0.d;
import b.i.a.f.h.k.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzm> CREATOR = new p();
    public final int j;
    public final Bundle k;

    public zzm(int i, Bundle bundle) {
        this.j = i;
        this.k = bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        if (this.j != zzmVar.j) {
            return false;
        }
        Bundle bundle = this.k;
        if (bundle == null) {
            return zzmVar.k == null;
        }
        if (zzmVar.k == null || bundle.size() != zzmVar.k.size()) {
            return false;
        }
        for (String str : this.k.keySet()) {
            if (!zzmVar.k.containsKey(str) || !d.h0(this.k.getString(str), zzmVar.k.getString(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.j));
        Bundle bundle = this.k;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                arrayList.add(str);
                arrayList.add(this.k.getString(str));
            }
        }
        return Arrays.hashCode(arrayList.toArray(new Object[0]));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        d.p2(parcel, 2, this.k, false);
        d.A2(parcel, iY2);
    }
}
