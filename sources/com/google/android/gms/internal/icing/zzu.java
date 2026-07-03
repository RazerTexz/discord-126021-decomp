package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p324k.C3575t;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new C3575t();

    /* JADX INFO: renamed from: j */
    public final boolean f20611j;

    public zzu(boolean z2) {
        this.f20611j = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzu) && this.f20611j == ((zzu) obj).f20611j;
    }

    public final int hashCode() {
        return this.f20611j ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        boolean z2 = this.f20611j;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        C1460d.m418A2(parcel, iM594y2);
    }
}
