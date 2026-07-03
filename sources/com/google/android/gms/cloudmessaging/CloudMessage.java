package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p298d.C3228c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CloudMessage extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new C3228c();

    /* JADX INFO: renamed from: j */
    @NonNull
    public Intent f20470j;

    public CloudMessage(@NonNull Intent intent) {
        this.f20470j = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m570s2(parcel, 1, this.f20470j, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
