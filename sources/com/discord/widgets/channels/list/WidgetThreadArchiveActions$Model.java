package com.discord.widgets.channels.list;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadArchiveActions$Model {
    public static final WidgetThreadArchiveActions$Model$Companion Companion = new WidgetThreadArchiveActions$Model$Companion(null);
    private final Channel channel;
    private final Guild guild;
    private final boolean isModerator;

    public WidgetThreadArchiveActions$Model(Channel channel, Guild guild, boolean z2) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.guild = guild;
        this.isModerator = z2;
    }

    public static /* synthetic */ WidgetThreadArchiveActions$Model copy$default(WidgetThreadArchiveActions$Model widgetThreadArchiveActions$Model, Channel channel, Guild guild, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetThreadArchiveActions$Model.channel;
        }
        if ((i & 2) != 0) {
            guild = widgetThreadArchiveActions$Model.guild;
        }
        if ((i & 4) != 0) {
            z2 = widgetThreadArchiveActions$Model.isModerator;
        }
        return widgetThreadArchiveActions$Model.copy(channel, guild, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    public final WidgetThreadArchiveActions$Model copy(Channel channel, Guild guild, boolean isModerator) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetThreadArchiveActions$Model(channel, guild, isModerator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadArchiveActions$Model)) {
            return false;
        }
        WidgetThreadArchiveActions$Model widgetThreadArchiveActions$Model = (WidgetThreadArchiveActions$Model) other;
        return m.areEqual(this.channel, widgetThreadArchiveActions$Model.channel) && m.areEqual(this.guild, widgetThreadArchiveActions$Model.guild) && this.isModerator == widgetThreadArchiveActions$Model.isModerator;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isModerator=");
        return a.O(sbU, this.isModerator, ")");
    }
}
