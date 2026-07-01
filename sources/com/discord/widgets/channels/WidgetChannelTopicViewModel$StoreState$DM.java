package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$StoreState$DM extends WidgetChannelTopicViewModel$StoreState {
    private final Channel channel;
    private final boolean developerModeEnabled;
    private final Collection<Map<Long, GuildMember>> guildMembers;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    public /* synthetic */ WidgetChannelTopicViewModel$StoreState$DM(Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, collection, (i & 4) != 0 ? false : z2, z3, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelTopicViewModel$StoreState$DM copy$default(WidgetChannelTopicViewModel$StoreState$DM widgetChannelTopicViewModel$StoreState$DM, Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelTopicViewModel$StoreState$DM.channel;
        }
        if ((i & 2) != 0) {
            collection = widgetChannelTopicViewModel$StoreState$DM.guildMembers;
        }
        Collection collection2 = collection;
        if ((i & 4) != 0) {
            z2 = widgetChannelTopicViewModel$StoreState$DM.developerModeEnabled;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = widgetChannelTopicViewModel$StoreState$DM.getIsRightPanelOpened();
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = widgetChannelTopicViewModel$StoreState$DM.getIsOnHomeTab();
        }
        return widgetChannelTopicViewModel$StoreState$DM.copy(channel, collection2, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Collection<Map<Long, GuildMember>> component2() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    public final boolean component4() {
        return getIsRightPanelOpened();
    }

    public final boolean component5() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$StoreState$DM copy(Channel channel, Collection<? extends Map<Long, GuildMember>> guildMembers, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        return new WidgetChannelTopicViewModel$StoreState$DM(channel, guildMembers, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$StoreState$DM)) {
            return false;
        }
        WidgetChannelTopicViewModel$StoreState$DM widgetChannelTopicViewModel$StoreState$DM = (WidgetChannelTopicViewModel$StoreState$DM) other;
        return m.areEqual(this.channel, widgetChannelTopicViewModel$StoreState$DM.channel) && m.areEqual(this.guildMembers, widgetChannelTopicViewModel$StoreState$DM.guildMembers) && this.developerModeEnabled == widgetChannelTopicViewModel$StoreState$DM.developerModeEnabled && getIsRightPanelOpened() == widgetChannelTopicViewModel$StoreState$DM.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$StoreState$DM.getIsOnHomeTab();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    public final Collection<Map<Long, GuildMember>> getGuildMembers() {
        return this.guildMembers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Collection<Map<Long, GuildMember>> collection = this.guildMembers;
        int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
        boolean z2 = this.developerModeEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r2 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState
    /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
    public boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$StoreState
    /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
    public boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public String toString() {
        StringBuilder sbU = a.U("DM(channel=");
        sbU.append(this.channel);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", developerModeEnabled=");
        sbU.append(this.developerModeEnabled);
        sbU.append(", isRightPanelOpened=");
        sbU.append(getIsRightPanelOpened());
        sbU.append(", isOnHomeTab=");
        sbU.append(getIsOnHomeTab());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelTopicViewModel$StoreState$DM(Channel channel, Collection<? extends Map<Long, GuildMember>> collection, boolean z2, boolean z3, boolean z4) {
        super(z3, z4, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(collection, "guildMembers");
        this.channel = channel;
        this.guildMembers = collection;
        this.developerModeEnabled = z2;
        this.isRightPanelOpened = z3;
        this.isOnHomeTab = z4;
    }
}
