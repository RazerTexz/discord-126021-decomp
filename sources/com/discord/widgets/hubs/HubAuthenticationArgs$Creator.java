package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class HubAuthenticationArgs$Creator implements Parcelable$Creator<HubAuthenticationArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubAuthenticationArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new HubAuthenticationArgs(parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubAuthenticationArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubAuthenticationArgs[] newArray(int i) {
        return new HubAuthenticationArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubAuthenticationArgs[] newArray(int i) {
        return newArray(i);
    }
}
