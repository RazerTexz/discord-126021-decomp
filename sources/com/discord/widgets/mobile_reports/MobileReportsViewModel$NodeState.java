package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$NodeState {
    private final MobileReportsViewModel$BlockUserElement blockUserElement;
    private final ReportNodeBottomButton bottomButton;
    private final List<NodeResult> breadcrumbsElement;
    private final MobileReportsViewModel$ChannelPreview channelPreviewElement;
    private final MobileReportsViewModel$CheckboxElement checkboxElement;
    private final MobileReportsViewModel$DirectoryServerPreview directoryServerPreviewElement;
    private final MobileReportsViewModel$GuildScheduledEventPreview eventPreviewElement;
    private final MobileReportsViewModel$MessagePreview messagePreviewElement;
    private final ReportNode node;
    private final MobileReportsViewModel$SubmitState submitState;
    private final boolean successElement;

    public MobileReportsViewModel$NodeState(ReportNode reportNode, MobileReportsViewModel$CheckboxElement mobileReportsViewModel$CheckboxElement, MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview, MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview, MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview, MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview, MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement, List<NodeResult> list, boolean z2, MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState, ReportNodeBottomButton reportNodeBottomButton) {
        m.checkNotNullParameter(reportNode, "node");
        this.node = reportNode;
        this.checkboxElement = mobileReportsViewModel$CheckboxElement;
        this.messagePreviewElement = mobileReportsViewModel$MessagePreview;
        this.channelPreviewElement = mobileReportsViewModel$ChannelPreview;
        this.directoryServerPreviewElement = mobileReportsViewModel$DirectoryServerPreview;
        this.eventPreviewElement = mobileReportsViewModel$GuildScheduledEventPreview;
        this.blockUserElement = mobileReportsViewModel$BlockUserElement;
        this.breadcrumbsElement = list;
        this.successElement = z2;
        this.submitState = mobileReportsViewModel$SubmitState;
        this.bottomButton = reportNodeBottomButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileReportsViewModel$NodeState copy$default(MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState, ReportNode reportNode, MobileReportsViewModel$CheckboxElement mobileReportsViewModel$CheckboxElement, MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview, MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview, MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview, MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview, MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement, List list, boolean z2, MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState, ReportNodeBottomButton reportNodeBottomButton, int i, Object obj) {
        return mobileReportsViewModel$NodeState.copy((i & 1) != 0 ? mobileReportsViewModel$NodeState.node : reportNode, (i & 2) != 0 ? mobileReportsViewModel$NodeState.checkboxElement : mobileReportsViewModel$CheckboxElement, (i & 4) != 0 ? mobileReportsViewModel$NodeState.messagePreviewElement : mobileReportsViewModel$MessagePreview, (i & 8) != 0 ? mobileReportsViewModel$NodeState.channelPreviewElement : mobileReportsViewModel$ChannelPreview, (i & 16) != 0 ? mobileReportsViewModel$NodeState.directoryServerPreviewElement : mobileReportsViewModel$DirectoryServerPreview, (i & 32) != 0 ? mobileReportsViewModel$NodeState.eventPreviewElement : mobileReportsViewModel$GuildScheduledEventPreview, (i & 64) != 0 ? mobileReportsViewModel$NodeState.blockUserElement : mobileReportsViewModel$BlockUserElement, (i & 128) != 0 ? mobileReportsViewModel$NodeState.breadcrumbsElement : list, (i & 256) != 0 ? mobileReportsViewModel$NodeState.successElement : z2, (i & 512) != 0 ? mobileReportsViewModel$NodeState.submitState : mobileReportsViewModel$SubmitState, (i & 1024) != 0 ? mobileReportsViewModel$NodeState.bottomButton : reportNodeBottomButton);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ReportNode getNode() {
        return this.node;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MobileReportsViewModel$SubmitState getSubmitState() {
        return this.submitState;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ReportNodeBottomButton getBottomButton() {
        return this.bottomButton;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MobileReportsViewModel$CheckboxElement getCheckboxElement() {
        return this.checkboxElement;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MobileReportsViewModel$MessagePreview getMessagePreviewElement() {
        return this.messagePreviewElement;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MobileReportsViewModel$ChannelPreview getChannelPreviewElement() {
        return this.channelPreviewElement;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MobileReportsViewModel$DirectoryServerPreview getDirectoryServerPreviewElement() {
        return this.directoryServerPreviewElement;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MobileReportsViewModel$GuildScheduledEventPreview getEventPreviewElement() {
        return this.eventPreviewElement;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MobileReportsViewModel$BlockUserElement getBlockUserElement() {
        return this.blockUserElement;
    }

    public final List<NodeResult> component8() {
        return this.breadcrumbsElement;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getSuccessElement() {
        return this.successElement;
    }

    public final MobileReportsViewModel$NodeState copy(ReportNode node, MobileReportsViewModel$CheckboxElement checkboxElement, MobileReportsViewModel$MessagePreview messagePreviewElement, MobileReportsViewModel$ChannelPreview channelPreviewElement, MobileReportsViewModel$DirectoryServerPreview directoryServerPreviewElement, MobileReportsViewModel$GuildScheduledEventPreview eventPreviewElement, MobileReportsViewModel$BlockUserElement blockUserElement, List<NodeResult> breadcrumbsElement, boolean successElement, MobileReportsViewModel$SubmitState submitState, ReportNodeBottomButton bottomButton) {
        m.checkNotNullParameter(node, "node");
        return new MobileReportsViewModel$NodeState(node, checkboxElement, messagePreviewElement, channelPreviewElement, directoryServerPreviewElement, eventPreviewElement, blockUserElement, breadcrumbsElement, successElement, submitState, bottomButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$NodeState)) {
            return false;
        }
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState = (MobileReportsViewModel$NodeState) other;
        return m.areEqual(this.node, mobileReportsViewModel$NodeState.node) && m.areEqual(this.checkboxElement, mobileReportsViewModel$NodeState.checkboxElement) && m.areEqual(this.messagePreviewElement, mobileReportsViewModel$NodeState.messagePreviewElement) && m.areEqual(this.channelPreviewElement, mobileReportsViewModel$NodeState.channelPreviewElement) && m.areEqual(this.directoryServerPreviewElement, mobileReportsViewModel$NodeState.directoryServerPreviewElement) && m.areEqual(this.eventPreviewElement, mobileReportsViewModel$NodeState.eventPreviewElement) && m.areEqual(this.blockUserElement, mobileReportsViewModel$NodeState.blockUserElement) && m.areEqual(this.breadcrumbsElement, mobileReportsViewModel$NodeState.breadcrumbsElement) && this.successElement == mobileReportsViewModel$NodeState.successElement && m.areEqual(this.submitState, mobileReportsViewModel$NodeState.submitState) && m.areEqual(this.bottomButton, mobileReportsViewModel$NodeState.bottomButton);
    }

    public final MobileReportsViewModel$BlockUserElement getBlockUserElement() {
        return this.blockUserElement;
    }

    public final ReportNodeBottomButton getBottomButton() {
        return this.bottomButton;
    }

    public final List<NodeResult> getBreadcrumbsElement() {
        return this.breadcrumbsElement;
    }

    public final MobileReportsViewModel$ChannelPreview getChannelPreviewElement() {
        return this.channelPreviewElement;
    }

    public final MobileReportsViewModel$CheckboxElement getCheckboxElement() {
        return this.checkboxElement;
    }

    public final MobileReportsViewModel$DirectoryServerPreview getDirectoryServerPreviewElement() {
        return this.directoryServerPreviewElement;
    }

    public final MobileReportsViewModel$GuildScheduledEventPreview getEventPreviewElement() {
        return this.eventPreviewElement;
    }

    public final MobileReportsViewModel$MessagePreview getMessagePreviewElement() {
        return this.messagePreviewElement;
    }

    public final ReportNode getNode() {
        return this.node;
    }

    public final MobileReportsViewModel$SubmitState getSubmitState() {
        return this.submitState;
    }

    public final boolean getSuccessElement() {
        return this.successElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v36 */
    public int hashCode() {
        ReportNode reportNode = this.node;
        int iHashCode = (reportNode != null ? reportNode.hashCode() : 0) * 31;
        MobileReportsViewModel$CheckboxElement mobileReportsViewModel$CheckboxElement = this.checkboxElement;
        int iHashCode2 = (iHashCode + (mobileReportsViewModel$CheckboxElement != null ? mobileReportsViewModel$CheckboxElement.hashCode() : 0)) * 31;
        MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview = this.messagePreviewElement;
        int iHashCode3 = (iHashCode2 + (mobileReportsViewModel$MessagePreview != null ? mobileReportsViewModel$MessagePreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview = this.channelPreviewElement;
        int iHashCode4 = (iHashCode3 + (mobileReportsViewModel$ChannelPreview != null ? mobileReportsViewModel$ChannelPreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview = this.directoryServerPreviewElement;
        int iHashCode5 = (iHashCode4 + (mobileReportsViewModel$DirectoryServerPreview != null ? mobileReportsViewModel$DirectoryServerPreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview = this.eventPreviewElement;
        int iHashCode6 = (iHashCode5 + (mobileReportsViewModel$GuildScheduledEventPreview != null ? mobileReportsViewModel$GuildScheduledEventPreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement = this.blockUserElement;
        int iHashCode7 = (iHashCode6 + (mobileReportsViewModel$BlockUserElement != null ? mobileReportsViewModel$BlockUserElement.hashCode() : 0)) * 31;
        List<NodeResult> list = this.breadcrumbsElement;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.successElement;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode8 + r2) * 31;
        MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState = this.submitState;
        int iHashCode9 = (i + (mobileReportsViewModel$SubmitState != null ? mobileReportsViewModel$SubmitState.hashCode() : 0)) * 31;
        ReportNodeBottomButton reportNodeBottomButton = this.bottomButton;
        return iHashCode9 + (reportNodeBottomButton != null ? reportNodeBottomButton.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("NodeState(node=");
        sbU.append(this.node);
        sbU.append(", checkboxElement=");
        sbU.append(this.checkboxElement);
        sbU.append(", messagePreviewElement=");
        sbU.append(this.messagePreviewElement);
        sbU.append(", channelPreviewElement=");
        sbU.append(this.channelPreviewElement);
        sbU.append(", directoryServerPreviewElement=");
        sbU.append(this.directoryServerPreviewElement);
        sbU.append(", eventPreviewElement=");
        sbU.append(this.eventPreviewElement);
        sbU.append(", blockUserElement=");
        sbU.append(this.blockUserElement);
        sbU.append(", breadcrumbsElement=");
        sbU.append(this.breadcrumbsElement);
        sbU.append(", successElement=");
        sbU.append(this.successElement);
        sbU.append(", submitState=");
        sbU.append(this.submitState);
        sbU.append(", bottomButton=");
        sbU.append(this.bottomButton);
        sbU.append(")");
        return sbU.toString();
    }
}
