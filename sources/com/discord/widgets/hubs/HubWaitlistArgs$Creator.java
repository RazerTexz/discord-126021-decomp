package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class HubWaitlistArgs$Creator implements Parcelable$Creator<HubWaitlistArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubWaitlistArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new HubWaitlistArgs(parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubWaitlistArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubWaitlistArgs[] newArray(int i) {
        return new HubWaitlistArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubWaitlistArgs[] newArray(int i) {
        return newArray(i);
    }
}
