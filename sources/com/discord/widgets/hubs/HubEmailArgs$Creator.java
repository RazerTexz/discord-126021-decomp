package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class HubEmailArgs$Creator implements Parcelable$Creator<HubEmailArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubEmailArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new HubEmailArgs(parcel.readString(), parcel.readInt(), (HubEmailEntryPoint) Enum.valueOf(HubEmailEntryPoint.class, parcel.readString()));
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubEmailArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubEmailArgs[] newArray(int i) {
        return new HubEmailArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubEmailArgs[] newArray(int i) {
        return newArray(i);
    }
}
