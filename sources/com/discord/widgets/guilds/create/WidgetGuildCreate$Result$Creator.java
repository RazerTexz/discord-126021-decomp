package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildCreate$Result$Creator implements Parcelable$Creator<WidgetGuildCreate$Result> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final WidgetGuildCreate$Result createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new WidgetGuildCreate$Result(parcel.readLong());
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ WidgetGuildCreate$Result createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final WidgetGuildCreate$Result[] newArray(int i) {
        return new WidgetGuildCreate$Result[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ WidgetGuildCreate$Result[] newArray(int i) {
        return newArray(i);
    }
}
