package com.discord.widgets.guild_role_subscriptions.tier.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class Benefit$ChannelBenefit$Creator implements Parcelable$Creator<Benefit$ChannelBenefit> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final Benefit$ChannelBenefit createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new Benefit$ChannelBenefit(parcel.readString(), (Emoji) parcel.readParcelable(Benefit$ChannelBenefit.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Benefit$ChannelBenefit createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final Benefit$ChannelBenefit[] newArray(int i) {
        return new Benefit$ChannelBenefit[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Benefit$ChannelBenefit[] newArray(int i) {
        return newArray(i);
    }
}
