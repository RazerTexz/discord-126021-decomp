package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.NonNull;
import b.c.a.a0.d;
import b.i.c.w.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable$Creator<RemoteMessage> CREATOR = new s();
    public Bundle j;
    public Map<String, String> k;

    public RemoteMessage(Bundle bundle) {
        this.j = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.p2(parcel, 2, this.j, false);
        d.A2(parcel, iY2);
    }
}
