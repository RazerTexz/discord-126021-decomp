package com.discord.widgets.guilds.create;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import d0.z.d.m;

/* JADX INFO: loaded from: classes2.dex */
public class CreationIntentArgs$Creator implements Parcelable$Creator<CreationIntentArgs> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final CreationIntentArgs createFromParcel(Parcel parcel) {
        m.checkNotNullParameter(parcel, "in");
        return new CreationIntentArgs((CreateGuildTrigger) Enum.valueOf(CreateGuildTrigger.class, parcel.readString()), WidgetGuildCreate$Options.CREATOR.createFromParcel(parcel));
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ CreationIntentArgs createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public final CreationIntentArgs[] newArray(int i) {
        return new CreationIntentArgs[i];
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ CreationIntentArgs[] newArray(int i) {
        return newArray(i);
    }
}
