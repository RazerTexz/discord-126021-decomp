package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import b.c.a.a0.d;
import b.i.a.f.d.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CloudMessage extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable$Creator<CloudMessage> CREATOR = new c();

    @NonNull
    public Intent j;

    public CloudMessage(@NonNull Intent intent) {
        this.j = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.s2(parcel, 1, this.j, i, false);
        d.A2(parcel, iY2);
    }
}
