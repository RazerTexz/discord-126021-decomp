package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zas;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p337l.p338b.C4344i;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new C4344i();

    /* JADX INFO: renamed from: j */
    public final int f20839j;

    /* JADX INFO: renamed from: k */
    public final zas f20840k;

    public zak(int i, zas zasVar) {
        this.f20839j = i;
        this.f20840k = zasVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20839j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 2, this.f20840k, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zak(zas zasVar) {
        this.f20839j = 1;
        this.f20840k = zasVar;
    }
}
