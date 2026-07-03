package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.C3191f;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new C3191f();

    /* JADX INFO: renamed from: j */
    public final int f20401j;

    /* JADX INFO: renamed from: k */
    public final boolean f20402k;

    /* JADX INFO: renamed from: l */
    public final boolean f20403l;

    /* JADX INFO: renamed from: m */
    public final int f20404m;

    public CredentialPickerConfig(int i, boolean z2, boolean z3, boolean z4, int i2) {
        this.f20401j = i;
        this.f20402k = z2;
        this.f20403l = z3;
        if (i < 2) {
            this.f20404m = z4 ? 3 : 1;
        } else {
            this.f20404m = i2;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        boolean z2 = this.f20402k;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.f20403l;
        parcel.writeInt(262146);
        parcel.writeInt(z3 ? 1 : 0);
        int i2 = this.f20404m == 3 ? 1 : 0;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        int i3 = this.f20404m;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.f20401j;
        parcel.writeInt(263144);
        parcel.writeInt(i4);
        C1460d.m418A2(parcel, iM594y2);
    }
}
