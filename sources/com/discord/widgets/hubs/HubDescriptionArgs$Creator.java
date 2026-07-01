package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class HubDescriptionArgs$Creator implements Parcelable$Creator<HubDescriptionArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubDescriptionArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new HubDescriptionArgs(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubDescriptionArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final HubDescriptionArgs[] newArray(int i) {
        return new HubDescriptionArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ HubDescriptionArgs[] newArray(int i) {
        return newArray(i);
    }
}
