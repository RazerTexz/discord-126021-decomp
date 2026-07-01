package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDetailsArgs implements Parcelable {
    public static final Parcelable$Creator<GuildScheduledEventDetailsArgs> CREATOR = new GuildScheduledEventDetailsArgs$Creator();
    private final Long channelId;
    private final long eventId;
    private final Long guildId;
    private final GuildScheduledEventDetailsSource source;

    public GuildScheduledEventDetailsArgs(long j, Long l, Long l2, GuildScheduledEventDetailsSource guildScheduledEventDetailsSource) {
        m.checkNotNullParameter(guildScheduledEventDetailsSource, "source");
        this.eventId = j;
        this.guildId = l;
        this.channelId = l2;
        this.source = guildScheduledEventDetailsSource;
    }

    public static /* synthetic */ GuildScheduledEventDetailsArgs copy$default(GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, long j, Long l, Long l2, GuildScheduledEventDetailsSource guildScheduledEventDetailsSource, int i, Object obj) {
        if ((i & 1) != 0) {
            j = guildScheduledEventDetailsArgs.eventId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            l = guildScheduledEventDetailsArgs.guildId;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = guildScheduledEventDetailsArgs.channelId;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            guildScheduledEventDetailsSource = guildScheduledEventDetailsArgs.source;
        }
        return guildScheduledEventDetailsArgs.copy(j2, l3, l4, guildScheduledEventDetailsSource);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getEventId() {
        return this.eventId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildScheduledEventDetailsSource getSource() {
        return this.source;
    }

    public final GuildScheduledEventDetailsArgs copy(long eventId, Long guildId, Long channelId, GuildScheduledEventDetailsSource source) {
        m.checkNotNullParameter(source, "source");
        return new GuildScheduledEventDetailsArgs(eventId, guildId, channelId, source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventDetailsArgs)) {
            return false;
        }
        GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs = (GuildScheduledEventDetailsArgs) other;
        return this.eventId == guildScheduledEventDetailsArgs.eventId && m.areEqual(this.guildId, guildScheduledEventDetailsArgs.guildId) && m.areEqual(this.channelId, guildScheduledEventDetailsArgs.channelId) && m.areEqual(this.source, guildScheduledEventDetailsArgs.source);
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final long getEventId() {
        return this.eventId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final GuildScheduledEventDetailsSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int iA = b.a(this.eventId) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        GuildScheduledEventDetailsSource guildScheduledEventDetailsSource = this.source;
        return iHashCode2 + (guildScheduledEventDetailsSource != null ? guildScheduledEventDetailsSource.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventDetailsArgs(eventId=");
        sbU.append(this.eventId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.eventId);
        Long l = this.guildId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Long l2 = this.channelId;
        if (l2 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.source.name());
    }

    public /* synthetic */ GuildScheduledEventDetailsArgs(long j, Long l, Long l2, GuildScheduledEventDetailsSource guildScheduledEventDetailsSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? GuildScheduledEventDetailsSource.Guild : guildScheduledEventDetailsSource);
    }
}
