package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildScheduledEventDetailsBottomSheet2 implements Parcelable {
    public static final Parcelable.Creator<WidgetGuildScheduledEventDetailsBottomSheet2> CREATOR = new Creator();
    private final Long channelId;
    private final long eventId;
    private final Long guildId;
    private final WidgetGuildScheduledEventDetailsBottomSheet3 source;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetGuildScheduledEventDetailsBottomSheet2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildScheduledEventDetailsBottomSheet2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetGuildScheduledEventDetailsBottomSheet2(parcel.readLong(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, (WidgetGuildScheduledEventDetailsBottomSheet3) Enum.valueOf(WidgetGuildScheduledEventDetailsBottomSheet3.class, parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetGuildScheduledEventDetailsBottomSheet2[] newArray(int i) {
            return new WidgetGuildScheduledEventDetailsBottomSheet2[i];
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet2(long j, Long l, Long l2, WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3) {
        Intrinsics3.checkNotNullParameter(widgetGuildScheduledEventDetailsBottomSheet3, "source");
        this.eventId = j;
        this.guildId = l;
        this.channelId = l2;
        this.source = widgetGuildScheduledEventDetailsBottomSheet3;
    }

    public static /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 copy$default(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, long j, Long l, Long l2, WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildScheduledEventDetailsBottomSheet2.eventId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            l = widgetGuildScheduledEventDetailsBottomSheet2.guildId;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = widgetGuildScheduledEventDetailsBottomSheet2.channelId;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            widgetGuildScheduledEventDetailsBottomSheet3 = widgetGuildScheduledEventDetailsBottomSheet2.source;
        }
        return widgetGuildScheduledEventDetailsBottomSheet2.copy(j2, l3, l4, widgetGuildScheduledEventDetailsBottomSheet3);
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
    public final WidgetGuildScheduledEventDetailsBottomSheet3 getSource() {
        return this.source;
    }

    public final WidgetGuildScheduledEventDetailsBottomSheet2 copy(long eventId, Long guildId, Long channelId, WidgetGuildScheduledEventDetailsBottomSheet3 source) {
        Intrinsics3.checkNotNullParameter(source, "source");
        return new WidgetGuildScheduledEventDetailsBottomSheet2(eventId, guildId, channelId, source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildScheduledEventDetailsBottomSheet2)) {
            return false;
        }
        WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2 = (WidgetGuildScheduledEventDetailsBottomSheet2) other;
        return this.eventId == widgetGuildScheduledEventDetailsBottomSheet2.eventId && Intrinsics3.areEqual(this.guildId, widgetGuildScheduledEventDetailsBottomSheet2.guildId) && Intrinsics3.areEqual(this.channelId, widgetGuildScheduledEventDetailsBottomSheet2.channelId) && Intrinsics3.areEqual(this.source, widgetGuildScheduledEventDetailsBottomSheet2.source);
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

    public final WidgetGuildScheduledEventDetailsBottomSheet3 getSource() {
        return this.source;
    }

    public int hashCode() {
        int iA = b.a(this.eventId) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3 = this.source;
        return iHashCode2 + (widgetGuildScheduledEventDetailsBottomSheet3 != null ? widgetGuildScheduledEventDetailsBottomSheet3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventDetailsArgs(eventId=");
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
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
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

    public /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2(long j, Long l, Long l2, WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? WidgetGuildScheduledEventDetailsBottomSheet3.Guild : widgetGuildScheduledEventDetailsBottomSheet3);
    }
}
