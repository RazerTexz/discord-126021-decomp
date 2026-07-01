package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.stores.StoreNotices$Notice;
import d0.z.d.m;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppFlexInputViewModel$StoreState {
    private final Long channelPermission;
    private final boolean isThreadCreation;
    private final PanelState leftPanelState;
    private final StoreNotices$Notice notice;
    private final PanelState rightPanelState;
    private final Channel selectedChannel;
    private final boolean stickerSuggestionsEnabled;

    public AppFlexInputViewModel$StoreState(PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices$Notice storeNotices$Notice, boolean z2, boolean z3) {
        m.checkNotNullParameter(panelState, "leftPanelState");
        m.checkNotNullParameter(panelState2, "rightPanelState");
        this.leftPanelState = panelState;
        this.rightPanelState = panelState2;
        this.selectedChannel = channel;
        this.channelPermission = l;
        this.notice = storeNotices$Notice;
        this.stickerSuggestionsEnabled = z2;
        this.isThreadCreation = z3;
    }

    public static /* synthetic */ AppFlexInputViewModel$StoreState copy$default(AppFlexInputViewModel$StoreState appFlexInputViewModel$StoreState, PanelState panelState, PanelState panelState2, Channel channel, Long l, StoreNotices$Notice storeNotices$Notice, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            panelState = appFlexInputViewModel$StoreState.leftPanelState;
        }
        if ((i & 2) != 0) {
            panelState2 = appFlexInputViewModel$StoreState.rightPanelState;
        }
        PanelState panelState3 = panelState2;
        if ((i & 4) != 0) {
            channel = appFlexInputViewModel$StoreState.selectedChannel;
        }
        Channel channel2 = channel;
        if ((i & 8) != 0) {
            l = appFlexInputViewModel$StoreState.channelPermission;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            storeNotices$Notice = appFlexInputViewModel$StoreState.notice;
        }
        StoreNotices$Notice storeNotices$Notice2 = storeNotices$Notice;
        if ((i & 32) != 0) {
            z2 = appFlexInputViewModel$StoreState.stickerSuggestionsEnabled;
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            z3 = appFlexInputViewModel$StoreState.isThreadCreation;
        }
        return appFlexInputViewModel$StoreState.copy(panelState, panelState3, channel2, l2, storeNotices$Notice2, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PanelState getRightPanelState() {
        return this.rightPanelState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getChannelPermission() {
        return this.channelPermission;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StoreNotices$Notice getNotice() {
        return this.notice;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getStickerSuggestionsEnabled() {
        return this.stickerSuggestionsEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsThreadCreation() {
        return this.isThreadCreation;
    }

    public final AppFlexInputViewModel$StoreState copy(PanelState leftPanelState, PanelState rightPanelState, Channel selectedChannel, Long channelPermission, StoreNotices$Notice notice, boolean stickerSuggestionsEnabled, boolean isThreadCreation) {
        m.checkNotNullParameter(leftPanelState, "leftPanelState");
        m.checkNotNullParameter(rightPanelState, "rightPanelState");
        return new AppFlexInputViewModel$StoreState(leftPanelState, rightPanelState, selectedChannel, channelPermission, notice, stickerSuggestionsEnabled, isThreadCreation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFlexInputViewModel$StoreState)) {
            return false;
        }
        AppFlexInputViewModel$StoreState appFlexInputViewModel$StoreState = (AppFlexInputViewModel$StoreState) other;
        return m.areEqual(this.leftPanelState, appFlexInputViewModel$StoreState.leftPanelState) && m.areEqual(this.rightPanelState, appFlexInputViewModel$StoreState.rightPanelState) && m.areEqual(this.selectedChannel, appFlexInputViewModel$StoreState.selectedChannel) && m.areEqual(this.channelPermission, appFlexInputViewModel$StoreState.channelPermission) && m.areEqual(this.notice, appFlexInputViewModel$StoreState.notice) && this.stickerSuggestionsEnabled == appFlexInputViewModel$StoreState.stickerSuggestionsEnabled && this.isThreadCreation == appFlexInputViewModel$StoreState.isThreadCreation;
    }

    public final Long getChannelPermission() {
        return this.channelPermission;
    }

    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    public final StoreNotices$Notice getNotice() {
        return this.notice;
    }

    public final PanelState getRightPanelState() {
        return this.rightPanelState;
    }

    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final boolean getStickerSuggestionsEnabled() {
        return this.stickerSuggestionsEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    public int hashCode() {
        PanelState panelState = this.leftPanelState;
        int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
        PanelState panelState2 = this.rightPanelState;
        int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
        Channel channel = this.selectedChannel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        Long l = this.channelPermission;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        StoreNotices$Notice storeNotices$Notice = this.notice;
        int iHashCode5 = (iHashCode4 + (storeNotices$Notice != null ? storeNotices$Notice.hashCode() : 0)) * 31;
        boolean z2 = this.stickerSuggestionsEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode5 + r1) * 31;
        boolean z3 = this.isThreadCreation;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isThreadCreation() {
        return this.isThreadCreation;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(leftPanelState=");
        sbU.append(this.leftPanelState);
        sbU.append(", rightPanelState=");
        sbU.append(this.rightPanelState);
        sbU.append(", selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", channelPermission=");
        sbU.append(this.channelPermission);
        sbU.append(", notice=");
        sbU.append(this.notice);
        sbU.append(", stickerSuggestionsEnabled=");
        sbU.append(this.stickerSuggestionsEnabled);
        sbU.append(", isThreadCreation=");
        return a.O(sbU, this.isThreadCreation, ")");
    }
}
