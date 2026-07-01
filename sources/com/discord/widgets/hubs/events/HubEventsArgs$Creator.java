package com.discord.widgets.hubs.events;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class HubEventsArgs$Creator implements Parcelable$Creator<HubEventsArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubEventsArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new HubEventsArgs(parcel.readLong(), parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubEventsArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubEventsArgs[] newArray(int i) {
        return new HubEventsArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubEventsArgs[] newArray(int i) {
        return newArray(i);
    }
}
