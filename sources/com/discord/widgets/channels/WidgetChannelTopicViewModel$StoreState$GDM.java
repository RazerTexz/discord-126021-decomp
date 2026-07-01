package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopicViewModel$StoreState$GDM extends WidgetChannelTopicViewModel$StoreState {
    private final Channel channel;
    private final boolean developerModeEnabled;
    private final boolean isOnHomeTab;
    private final boolean isRightPanelOpened;

    public /* synthetic */ WidgetChannelTopicViewModel$StoreState$GDM(Channel channel, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, (i & 2) != 0 ? false : z2, z3, z4);
    }

    public static /* synthetic */ WidgetChannelTopicViewModel$StoreState$GDM copy$default(WidgetChannelTopicViewModel$StoreState$GDM widgetChannelTopicViewModel$StoreState$GDM, Channel channel, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelTopicViewModel$StoreState$GDM.channel;
        }
        if ((i & 2) != 0) {
            z2 = widgetChannelTopicViewModel$StoreState$GDM.developerModeEnabled;
        }
        if ((i & 4) != 0) {
            z3 = widgetChannelTopicViewModel$StoreState$GDM.getIsRightPanelOpened();
        }
        if ((i & 8) != 0) {
            z4 = widgetChannelTopicViewModel$StoreState$GDM.getIsOnHomeTab();
        }
        return widgetChannelTopicViewModel$StoreState$GDM.copy(channel, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    public final boolean component3() {
        return getIsRightPanelOpened();
    }

    public final boolean component4() {
        return getIsOnHomeTab();
    }

    public final WidgetChannelTopicViewModel$StoreState$GDM copy(Channel channel, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelTopicViewModel$StoreState$GDM(channel, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopicViewModel$StoreState$GDM)) {
            return false;
        }
        WidgetChannelTopicViewModel$StoreState$GDM widgetChannelTopicViewModel$StoreState$GDM = (WidgetChannelTopicViewModel$StoreState$GDM) other;
        return m.areEqual(this.channel, widgetChannelTopicViewModel$StoreState$GDM.channel) && this.developerModeEnabled == widgetChannelTopicViewModel$StoreState$GDM.developerModeEnabled && getIsRightPanelOpened() == widgetChannelTopicViewModel$StoreState$GDM.getIsRightPanelOpened() && getIsOnHomeTab() == widgetChannelTopicViewModel$StoreState$GDM.getIsOnHomeTab();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getDeveloperModeEnabled() {
        return this.developerModeEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.developerModeEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
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
        StringBuilder sbU = a.U("GDM(channel=");
        sbU.append(this.channel);
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
    public WidgetChannelTopicViewModel$StoreState$GDM(Channel channel, boolean z2, boolean z3, boolean z4) {
        super(z3, z4, null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.developerModeEnabled = z2;
        this.isRightPanelOpened = z3;
        this.isOnHomeTab = z4;
    }
}
