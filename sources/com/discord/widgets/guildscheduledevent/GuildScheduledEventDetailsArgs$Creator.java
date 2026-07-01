package com.discord.widgets.guildscheduledevent;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class GuildScheduledEventDetailsArgs$Creator implements Parcelable$Creator<GuildScheduledEventDetailsArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final GuildScheduledEventDetailsArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new GuildScheduledEventDetailsArgs(parcel.readLong(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, (GuildScheduledEventDetailsSource) Enum.valueOf(GuildScheduledEventDetailsSource.class, parcel.readString()));
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ GuildScheduledEventDetailsArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final GuildScheduledEventDetailsArgs[] newArray(int i) {
        return new GuildScheduledEventDetailsArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ GuildScheduledEventDetailsArgs[] newArray(int i) {
        return newArray(i);
    }
}
