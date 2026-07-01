package com.discord.widgets.guild_role_subscriptions.tier.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class Benefit$IntangibleBenefit$Creator implements Parcelable$Creator<Benefit$IntangibleBenefit> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final Benefit$IntangibleBenefit createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new Benefit$IntangibleBenefit(parcel.readString(), (Emoji) parcel.readParcelable(Benefit$IntangibleBenefit.class.getClassLoader()), parcel.readString());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Benefit$IntangibleBenefit createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final Benefit$IntangibleBenefit[] newArray(int i) {
        return new Benefit$IntangibleBenefit[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Benefit$IntangibleBenefit[] newArray(int i) {
        return newArray(i);
    }
}
