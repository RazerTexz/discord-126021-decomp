package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class HubWaitlistResult$Creator implements Parcelable$Creator<HubWaitlistResult> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubWaitlistResult createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new HubWaitlistResult(parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubWaitlistResult createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubWaitlistResult[] newArray(int i) {
        return new HubWaitlistResult[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubWaitlistResult[] newArray(int i) {
        return newArray(i);
    }
}
