package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p361c.p406w.C4881s;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new C4881s();

    /* JADX INFO: renamed from: j */
    public Bundle f21460j;

    /* JADX INFO: renamed from: k */
    public Map<String, String> f21461k;

    public RemoteMessage(Bundle bundle) {
        this.f21460j = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m558p2(parcel, 2, this.f21460j, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
