package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p337l.p338b.C4337b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zab extends AbstractSafeParcelable implements InterfaceC3273h {
    public static final Parcelable.Creator<zab> CREATOR = new C4337b();

    /* JADX INFO: renamed from: j */
    public final int f20834j;

    /* JADX INFO: renamed from: k */
    public int f20835k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public Intent f20836l;

    public zab() {
        this.f20834j = 2;
        this.f20835k = 0;
        this.f20836l = null;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h
    /* JADX INFO: renamed from: b0 */
    public final Status mo4053b0() {
        return this.f20835k == 0 ? Status.f20489j : Status.f20493n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20834j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20835k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        C1460d.m570s2(parcel, 3, this.f20836l, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zab(int i, int i2, @Nullable Intent intent) {
        this.f20834j = i;
        this.f20835k = i2;
        this.f20836l = intent;
    }
}
