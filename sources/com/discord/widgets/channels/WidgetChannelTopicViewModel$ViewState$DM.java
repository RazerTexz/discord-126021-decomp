package com.discord.widgets.channels;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$ViewState$DM extends WidgetChannelTopicViewModel$ViewState {
    private final long channelId;
    private final boolean developerModeEnabled;
    private final List<GuildMember> guildMembers;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;
    private final String recipientName;
    private final Set<String> recipientNicknames;
    private final Long recipientUserId;

    public /* synthetic */ WidgetChannelTopicViewModel$ViewState$DM(String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, set, list, j, (i & 32) != 0 ? false : z2, z3, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelTopicViewModel$ViewState$DM copy$default(WidgetChannelTopicViewModel$ViewState$DM widgetChannelTopicViewModel$ViewState$DM, String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return widgetChannelTopicViewModel$ViewState$DM.copy((i & 1) != 0 ? widgetChannelTopicViewModel$ViewState$DM.recipientName : str, (i & 2) != 0 ? widgetChannelTopicViewModel$ViewState$DM.recipientUserId : l, (i & 4) != 0 ? widgetChannelTopicViewModel$ViewState$DM.recipientNicknames : set, (i & 8) != 0 ? widgetChannelTopicViewModel$ViewState$DM.guildMembers : list, (i & 16) != 0 ? widgetChannelTopicViewModel$ViewState$DM.channelId : j, (i & 32) != 0 ? widgetChannelTopicViewModel$ViewState$DM.developerModeEnabled : z2, (i & 64) != 0 ? widgetChannelTopicViewModel$ViewState$DM.getIsRightPanelOpened() : z3, (i & 128) != 0 ? widgetChannelTopicViewModel$ViewState$DM.getIsOnHomeTab() : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRecipientName() {
        return this.recipientName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getRecipientUserId() {
        return this.recipientUserId;
    }

    public final Set<String> component3() {
        return this.recipientNicknames;
    }

    public final List<GuildMember> component4() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    public final boolean component7() {
        return getIsRightPanelOpened();
    }

    public final boolean component8() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$ViewState$DM copy(String recipientName, Long recipientUserId, Set<String> recipientNicknames, List<GuildMember> guildMembers, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(recipientNicknames, "recipientNicknames");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        return new WidgetChannelTopicViewModel$ViewState$DM(recipientName, recipientUserId, recipientNicknames, guildMembers, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$ViewState$DM)) {
            return false;
        }
        WidgetChannelTopicViewModel$ViewState$DM widgetChannelTopicViewModel$ViewState$DM = (WidgetChannelTopicViewModel$ViewState$DM) other;
        return m.areEqual(this.recipientName, widgetChannelTopicViewModel$ViewState$DM.recipientName) && m.areEqual(this.recipientUserId, widgetChannelTopicViewModel$ViewState$DM.recipientUserId) && m.areEqual(this.recipientNicknames, widgetChannelTopicViewModel$ViewState$DM.recipientNicknames) && m.areEqual(this.guildMembers, widgetChannelTopicViewModel$ViewState$DM.guildMembers) && this.channelId == widgetChannelTopicViewModel$ViewState$DM.channelId && this.developerModeEnabled == widgetChannelTopicViewModel$ViewState$DM.developerModeEnabled && getIsRightPanelOpened() == widgetChannelTopicViewModel$ViewState$DM.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$ViewState$DM.getIsOnHomeTab();
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    public final List<GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final String getRecipientName() {
        return this.recipientName;
    }

    public final Set<String> getRecipientNicknames() {
        return this.recipientNicknames;
    }

    public final Long getRecipientUserId() {
        return this.recipientUserId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        String str = this.recipientName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.recipientUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Set<String> set = this.recipientNicknames;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        List<GuildMember> list = this.guildMembers;
        int iA = (b.a(this.channelId) + ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31)) * 31;
        boolean z2 = this.developerModeEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA + r0) * 31;
        boolean isRightPanelOpened = getIsRightPanelOpened();
        ?? r1 = isRightPanelOpened;
        if (isRightPanelOpened) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean isOnHomeTab = getIsOnHomeTab();
        return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState
    /* JADX INFO: renamed from: isOnHomeTab, reason: from getter */
    public boolean getIsOnHomeTab() {
        return this.isOnHomeTab;
    }

    @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel$ViewState
    /* JADX INFO: renamed from: isRightPanelOpened, reason: from getter */
    public boolean getIsRightPanelOpened() {
        return this.isRightPanelOpened;
    }

    public String toString() {
        StringBuilder sbU = a.U("DM(recipientName=");
        sbU.append(this.recipientName);
        sbU.append(", recipientUserId=");
        sbU.append(this.recipientUserId);
        sbU.append(", recipientNicknames=");
        sbU.append(this.recipientNicknames);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
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
    public WidgetChannelTopicViewModel$ViewState$DM(String str, Long l, Set<String> set, List<GuildMember> list, long j, boolean z2, boolean z3, boolean z4) {
        super(z3, z4, null);
        m.checkNotNullParameter(set, "recipientNicknames");
        m.checkNotNullParameter(list, "guildMembers");
        this.recipientName = str;
        this.recipientUserId = l;
        this.recipientNicknames = set;
        this.guildMembers = list;
        this.channelId = j;
        this.developerModeEnabled = z2;
        this.isRightPanelOpened = z3;
        this.isOnHomeTab = z4;
    }
}
