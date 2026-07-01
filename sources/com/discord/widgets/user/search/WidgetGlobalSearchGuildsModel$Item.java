package com.discord.widgets.user.search;

import a0.a.a.b;
import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchGuildsModel$Item implements MGRecyclerDataPayload {
    public static final WidgetGlobalSearchGuildsModel$Item$Companion Companion = new WidgetGlobalSearchGuildsModel$Item$Companion(null);
    public static final int TYPE_DIVIDER = 1;
    public static final int TYPE_DM = 2;
    public static final int TYPE_GUILD = 3;
    private final int _type;
    private final Channel channel;
    private final boolean connectedToVoice;
    private final Guild guild;
    private final long id;
    private final boolean isSelected;
    private final boolean isUnread;
    private final String key;
    private final int mentionCount;
    private final int type;
    private final int unavailableGuildCount;

    public WidgetGlobalSearchGuildsModel$Item() {
        this(0, 0L, null, null, 0, false, false, false, 0, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public WidgetGlobalSearchGuildsModel$Item(int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3) {
        this._type = i;
        this.id = j;
        this.channel = channel;
        this.guild = guild;
        this.mentionCount = i2;
        this.isUnread = z2;
        this.isSelected = z3;
        this.connectedToVoice = z4;
        this.unavailableGuildCount = i3;
        this.type = i;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append('-');
        sb.append(j);
        this.key = sb.toString();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int get_type() {
        return this._type;
    }

    public static /* synthetic */ WidgetGlobalSearchGuildsModel$Item copy$default(WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item, int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4, Object obj) {
        return widgetGlobalSearchGuildsModel$Item.copy((i4 & 1) != 0 ? widgetGlobalSearchGuildsModel$Item._type : i, (i4 & 2) != 0 ? widgetGlobalSearchGuildsModel$Item.id : j, (i4 & 4) != 0 ? widgetGlobalSearchGuildsModel$Item.channel : channel, (i4 & 8) != 0 ? widgetGlobalSearchGuildsModel$Item.guild : guild, (i4 & 16) != 0 ? widgetGlobalSearchGuildsModel$Item.mentionCount : i2, (i4 & 32) != 0 ? widgetGlobalSearchGuildsModel$Item.isUnread : z2, (i4 & 64) != 0 ? widgetGlobalSearchGuildsModel$Item.isSelected : z3, (i4 & 128) != 0 ? widgetGlobalSearchGuildsModel$Item.connectedToVoice : z4, (i4 & 256) != 0 ? widgetGlobalSearchGuildsModel$Item.unavailableGuildCount : i3);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMentionCount() {
        return this.mentionCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsUnread() {
        return this.isUnread;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getConnectedToVoice() {
        return this.connectedToVoice;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getUnavailableGuildCount() {
        return this.unavailableGuildCount;
    }

    public final WidgetGlobalSearchGuildsModel$Item copy(int _type, long id2, Channel channel, Guild guild, int mentionCount, boolean isUnread, boolean isSelected, boolean connectedToVoice, int unavailableGuildCount) {
        return new WidgetGlobalSearchGuildsModel$Item(_type, id2, channel, guild, mentionCount, isUnread, isSelected, connectedToVoice, unavailableGuildCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchGuildsModel$Item)) {
            return false;
        }
        WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item = (WidgetGlobalSearchGuildsModel$Item) other;
        return this._type == widgetGlobalSearchGuildsModel$Item._type && this.id == widgetGlobalSearchGuildsModel$Item.id && m.areEqual(this.channel, widgetGlobalSearchGuildsModel$Item.channel) && m.areEqual(this.guild, widgetGlobalSearchGuildsModel$Item.guild) && this.mentionCount == widgetGlobalSearchGuildsModel$Item.mentionCount && this.isUnread == widgetGlobalSearchGuildsModel$Item.isUnread && this.isSelected == widgetGlobalSearchGuildsModel$Item.isSelected && this.connectedToVoice == widgetGlobalSearchGuildsModel$Item.connectedToVoice && this.unavailableGuildCount == widgetGlobalSearchGuildsModel$Item.unavailableGuildCount;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getConnectedToVoice() {
        return this.connectedToVoice;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getMentionCount() {
        return this.mentionCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final int getUnavailableGuildCount() {
        return this.unavailableGuildCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iA = (b.a(this.id) + (this._type * 31)) * 31;
        Channel channel = this.channel;
        int iHashCode = (iA + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31) + this.mentionCount) * 31;
        boolean z2 = this.isUnread;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode2 + r0) * 31;
        boolean z3 = this.isSelected;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z4 = this.connectedToVoice;
        return ((i2 + (z4 ? 1 : z4)) * 31) + this.unavailableGuildCount;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("Item(_type=");
        sbU.append(this._type);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", mentionCount=");
        sbU.append(this.mentionCount);
        sbU.append(", isUnread=");
        sbU.append(this.isUnread);
        sbU.append(", isSelected=");
        sbU.append(this.isSelected);
        sbU.append(", connectedToVoice=");
        sbU.append(this.connectedToVoice);
        sbU.append(", unavailableGuildCount=");
        return a.B(sbU, this.unavailableGuildCount, ")");
    }

    public /* synthetic */ WidgetGlobalSearchGuildsModel$Item(int i, long j, Channel channel, Guild guild, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? null : channel, (i4 & 8) == 0 ? guild : null, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? false : z3, (i4 & 128) != 0 ? false : z4, (i4 & 256) == 0 ? i3 : 0);
    }
}
