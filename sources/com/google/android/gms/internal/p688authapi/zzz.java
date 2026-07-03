package com.google.android.gms.internal.p688authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p316c.C3472u;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new C3472u();

    /* JADX INFO: renamed from: j */
    public final Credential f20584j;

    public zzz(Credential credential) {
        this.f20584j = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m570s2(parcel, 1, this.f20584j, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
