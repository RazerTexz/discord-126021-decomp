package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b.C3199b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new C3199b();

    /* JADX INFO: renamed from: j */
    public final int f20458j;

    /* JADX INFO: renamed from: k */
    public int f20459k;

    /* JADX INFO: renamed from: l */
    public Bundle f20460l;

    public GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.f20458j = i;
        this.f20459k = i2;
        this.f20460l = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20458j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20459k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        C1460d.m558p2(parcel, 3, this.f20460l, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
