package com.discord.widgets.guilds.create;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreate$Result implements Parcelable {
    public static final Parcelable$Creator<WidgetGuildCreate$Result> CREATOR = new WidgetGuildCreate$Result$Creator();
    private final long guildId;

    public WidgetGuildCreate$Result(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ WidgetGuildCreate$Result copy$default(WidgetGuildCreate$Result widgetGuildCreate$Result, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildCreate$Result.guildId;
        }
        return widgetGuildCreate$Result.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetGuildCreate$Result copy(long guildId) {
        return new WidgetGuildCreate$Result(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildCreate$Result) && this.guildId == ((WidgetGuildCreate$Result) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("Result(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
