package com.discord.widgets.channels;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$ViewState$GDM extends WidgetChannelTopicViewModel$ViewState {
    private final Channel channel;
    private final long channelId;
    private final boolean developerModeEnabled;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    public /* synthetic */ WidgetChannelTopicViewModel$ViewState$GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, j, (i & 4) != 0 ? false : z2, z3, z4);
    }

    public static /* synthetic */ WidgetChannelTopicViewModel$ViewState$GDM copy$default(WidgetChannelTopicViewModel$ViewState$GDM widgetChannelTopicViewModel$ViewState$GDM, Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelTopicViewModel$ViewState$GDM.channel;
        }
        if ((i & 2) != 0) {
            j = widgetChannelTopicViewModel$ViewState$GDM.channelId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z2 = widgetChannelTopicViewModel$ViewState$GDM.developerModeEnabled;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = widgetChannelTopicViewModel$ViewState$GDM.getIsRightPanelOpened();
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = widgetChannelTopicViewModel$ViewState$GDM.getIsOnHomeTab();
        }
        return widgetChannelTopicViewModel$ViewState$GDM.copy(channel, j2, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
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

    public final WidgetChannelTopicViewModel$ViewState$GDM copy(Channel channel, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelTopicViewModel$ViewState$GDM(channel, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$ViewState$GDM)) {
            return false;
        }
        WidgetChannelTopicViewModel$ViewState$GDM widgetChannelTopicViewModel$ViewState$GDM = (WidgetChannelTopicViewModel$ViewState$GDM) other;
        return m.areEqual(this.channel, widgetChannelTopicViewModel$ViewState$GDM.channel) && this.channelId == widgetChannelTopicViewModel$ViewState$GDM.channelId && this.developerModeEnabled == widgetChannelTopicViewModel$ViewState$GDM.developerModeEnabled && getIsRightPanelOpened() == widgetChannelTopicViewModel$ViewState$GDM.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$ViewState$GDM.getIsOnHomeTab();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iA = (b.a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
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
        StringBuilder sbU = a.U("GDM(channel=");
        sbU.append(this.channel);
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
    public WidgetChannelTopicViewModel$ViewState$GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4) {
        super(z3, z4, null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.channelId = j;
        this.developerModeEnabled = z2;
        this.isRightPanelOpened = z3;
        this.isOnHomeTab = z4;
    }
}
