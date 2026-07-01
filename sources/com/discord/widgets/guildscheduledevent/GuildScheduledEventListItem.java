package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildScheduledEventListItem implements MGRecyclerDataPayload {
    public static final int TYPE_EVENT = 0;

    /* JADX INFO: compiled from: GuildScheduledEventListItem.kt */
    public static final /* data */ class Event extends GuildScheduledEventListItem {
        private final boolean canConnect;
        private final boolean canShare;
        private final boolean canStartEvent;
        private final Channel channel;
        private final UserGuildMember creator;
        private final GuildScheduledEvent event;
        private final boolean isConnected;
        private final boolean isRsvped;
        private final String key;
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(GuildScheduledEvent guildScheduledEvent, Channel channel, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            this.event = guildScheduledEvent;
            this.channel = channel;
            this.creator = userGuildMember;
            this.isRsvped = z2;
            this.canStartEvent = z3;
            this.canShare = z4;
            this.isConnected = z5;
            this.canConnect = z6;
            this.key = String.valueOf(guildScheduledEvent.getId());
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsConnected() {
            return this.isConnected;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final Event copy(GuildScheduledEvent event, Channel channel, UserGuildMember creator, boolean isRsvped, boolean canStartEvent, boolean canShare, boolean isConnected, boolean canConnect) {
            Intrinsics3.checkNotNullParameter(event, "event");
            return new Event(event, channel, creator, isRsvped, canStartEvent, canShare, isConnected, canConnect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics3.areEqual(this.event, event.event) && Intrinsics3.areEqual(this.channel, event.channel) && Intrinsics3.areEqual(this.creator, event.creator) && this.isRsvped == event.isRsvped && this.canStartEvent == event.canStartEvent && this.canShare == event.canShare && this.isConnected == event.isConnected && this.canConnect == event.canConnect;
        }

        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final boolean getCanShare() {
            return this.canShare;
        }

        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.event;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode3 = (iHashCode2 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            boolean z2 = this.isRsvped;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode3 + r1) * 31;
            boolean z3 = this.canStartEvent;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.canShare;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isConnected;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.canConnect;
            return i4 + (z6 ? 1 : z6);
        }

        public final boolean isConnected() {
            return this.isConnected;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Event(event=");
            sbU.append(this.event);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", canStartEvent=");
            sbU.append(this.canStartEvent);
            sbU.append(", canShare=");
            sbU.append(this.canShare);
            sbU.append(", isConnected=");
            sbU.append(this.isConnected);
            sbU.append(", canConnect=");
            return outline.O(sbU, this.canConnect, ")");
        }
    }

    private GuildScheduledEventListItem() {
    }

    public /* synthetic */ GuildScheduledEventListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
