package com.discord.widgets.nux;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class GuildCreateArgs$Creator implements Parcelable$Creator<GuildCreateArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final GuildCreateArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new GuildCreateArgs(parcel.readInt() != 0, parcel.readString(), (CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), GuildTemplateArgs.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ GuildCreateArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final GuildCreateArgs[] newArray(int i) {
        return new GuildCreateArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ GuildCreateArgs[] newArray(int i) {
        return newArray(i);
    }
}
