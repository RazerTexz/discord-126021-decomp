package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeElement;
import com.discord.api.report.ReportNodeElement$Companion;
import com.discord.api.report.ReportNodeElementData;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$ViewState$Menu extends MobileReportsViewModel$ViewState {
    private final MobileReportsViewModel$BlockUserElement blockUserElement;
    private final MobileReportsViewModel$ChannelPreview channelPreview;
    private final MobileReportsViewModel$DirectoryServerPreview directoryServerPreview;
    private final MobileReportsViewModel$GuildScheduledEventPreview eventPreview;
    private final List<NodeResult> history;
    private final MenuAPIResponse menu;
    private final MobileReportsViewModel$MessagePreview messagePreview;
    private final MobileReportsViewModel$NodeNavigationType nodeNavigationType;
    private final MobileReportsViewModel$SubmitState submitState;

    public /* synthetic */ MobileReportsViewModel$ViewState$Menu(MenuAPIResponse menuAPIResponse, MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview, MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview, MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview, MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview, MobileReportsViewModel$NodeNavigationType mobileReportsViewModel$NodeNavigationType, MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState, List list, MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(menuAPIResponse, mobileReportsViewModel$MessagePreview, mobileReportsViewModel$ChannelPreview, mobileReportsViewModel$DirectoryServerPreview, mobileReportsViewModel$GuildScheduledEventPreview, mobileReportsViewModel$NodeNavigationType, (i & 64) != 0 ? MobileReportsViewModel$SubmitState$None.INSTANCE : mobileReportsViewModel$SubmitState, list, mobileReportsViewModel$BlockUserElement);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileReportsViewModel$ViewState$Menu copy$default(MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu, MenuAPIResponse menuAPIResponse, MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview, MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview, MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview, MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview, MobileReportsViewModel$NodeNavigationType mobileReportsViewModel$NodeNavigationType, MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState, List list, MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement, int i, Object obj) {
        return mobileReportsViewModel$ViewState$Menu.copy((i & 1) != 0 ? mobileReportsViewModel$ViewState$Menu.menu : menuAPIResponse, (i & 2) != 0 ? mobileReportsViewModel$ViewState$Menu.messagePreview : mobileReportsViewModel$MessagePreview, (i & 4) != 0 ? mobileReportsViewModel$ViewState$Menu.channelPreview : mobileReportsViewModel$ChannelPreview, (i & 8) != 0 ? mobileReportsViewModel$ViewState$Menu.directoryServerPreview : mobileReportsViewModel$DirectoryServerPreview, (i & 16) != 0 ? mobileReportsViewModel$ViewState$Menu.eventPreview : mobileReportsViewModel$GuildScheduledEventPreview, (i & 32) != 0 ? mobileReportsViewModel$ViewState$Menu.nodeNavigationType : mobileReportsViewModel$NodeNavigationType, (i & 64) != 0 ? mobileReportsViewModel$ViewState$Menu.submitState : mobileReportsViewModel$SubmitState, (i & 128) != 0 ? mobileReportsViewModel$ViewState$Menu.history : list, (i & 256) != 0 ? mobileReportsViewModel$ViewState$Menu.blockUserElement : mobileReportsViewModel$BlockUserElement);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MenuAPIResponse getMenu() {
        return this.menu;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MobileReportsViewModel$MessagePreview getMessagePreview() {
        return this.messagePreview;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MobileReportsViewModel$ChannelPreview getChannelPreview() {
        return this.channelPreview;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MobileReportsViewModel$DirectoryServerPreview getDirectoryServerPreview() {
        return this.directoryServerPreview;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MobileReportsViewModel$GuildScheduledEventPreview getEventPreview() {
        return this.eventPreview;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MobileReportsViewModel$NodeNavigationType getNodeNavigationType() {
        return this.nodeNavigationType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MobileReportsViewModel$SubmitState getSubmitState() {
        return this.submitState;
    }

    public final List<NodeResult> component8() {
        return this.history;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MobileReportsViewModel$BlockUserElement getBlockUserElement() {
        return this.blockUserElement;
    }

    public final MobileReportsViewModel$ViewState$Menu copy(MenuAPIResponse menu, MobileReportsViewModel$MessagePreview messagePreview, MobileReportsViewModel$ChannelPreview channelPreview, MobileReportsViewModel$DirectoryServerPreview directoryServerPreview, MobileReportsViewModel$GuildScheduledEventPreview eventPreview, MobileReportsViewModel$NodeNavigationType nodeNavigationType, MobileReportsViewModel$SubmitState submitState, List<NodeResult> history, MobileReportsViewModel$BlockUserElement blockUserElement) {
        m.checkNotNullParameter(menu, "menu");
        m.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
        m.checkNotNullParameter(submitState, "submitState");
        m.checkNotNullParameter(history, "history");
        return new MobileReportsViewModel$ViewState$Menu(menu, messagePreview, channelPreview, directoryServerPreview, eventPreview, nodeNavigationType, submitState, history, blockUserElement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$ViewState$Menu)) {
            return false;
        }
        MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu = (MobileReportsViewModel$ViewState$Menu) other;
        return m.areEqual(this.menu, mobileReportsViewModel$ViewState$Menu.menu) && m.areEqual(this.messagePreview, mobileReportsViewModel$ViewState$Menu.messagePreview) && m.areEqual(this.channelPreview, mobileReportsViewModel$ViewState$Menu.channelPreview) && m.areEqual(this.directoryServerPreview, mobileReportsViewModel$ViewState$Menu.directoryServerPreview) && m.areEqual(this.eventPreview, mobileReportsViewModel$ViewState$Menu.eventPreview) && m.areEqual(this.nodeNavigationType, mobileReportsViewModel$ViewState$Menu.nodeNavigationType) && m.areEqual(this.submitState, mobileReportsViewModel$ViewState$Menu.submitState) && m.areEqual(this.history, mobileReportsViewModel$ViewState$Menu.history) && m.areEqual(this.blockUserElement, mobileReportsViewModel$ViewState$Menu.blockUserElement);
    }

    public final MobileReportsViewModel$NodeState genNodeState() {
        Object obj;
        Object next;
        MobileReportsViewModel$CheckboxElement mobileReportsViewModel$CheckboxElement;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object next6;
        Object next7;
        ReportNodeElement reportNodeElement;
        ReportNodeElement reportNodeElement2;
        ReportNodeElement reportNodeElement3;
        ReportNodeElement reportNodeElement4;
        ReportNodeElement reportNodeElement5;
        ReportNodeElement reportNodeElement6;
        ReportNodeElement reportNodeElement7;
        ReportNode node = this.nodeNavigationType.getNode();
        List<ReportNodeElement> listC = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion = ReportNodeElement.Companion;
        Iterator<T> it = listC.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            reportNodeElement7 = (ReportNodeElement) next;
            Objects.requireNonNull(reportNodeElement$Companion);
            m.checkNotNullParameter(reportNodeElement7, "element");
        } while (!m.areEqual(reportNodeElement7.getType(), "checkbox"));
        ReportNodeElement reportNodeElement8 = (ReportNodeElement) next;
        if (reportNodeElement8 != null) {
            List<ReportNodeElementData> listA = reportNodeElement8.a();
            mobileReportsViewModel$CheckboxElement = listA == null ? null : new MobileReportsViewModel$CheckboxElement(reportNodeElement8.getName(), listA, new HashSet());
        } else {
            mobileReportsViewModel$CheckboxElement = null;
        }
        List<ReportNodeElement> listC2 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion2 = ReportNodeElement.Companion;
        Iterator<T> it2 = listC2.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            reportNodeElement6 = (ReportNodeElement) next2;
            Objects.requireNonNull(reportNodeElement$Companion2);
            m.checkNotNullParameter(reportNodeElement6, "element");
        } while (!m.areEqual(reportNodeElement6.getType(), "message_preview"));
        MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview = ((ReportNodeElement) next2) != null ? this.messagePreview : null;
        List<ReportNodeElement> listC3 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion3 = ReportNodeElement.Companion;
        Iterator<T> it3 = listC3.iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
            reportNodeElement5 = (ReportNodeElement) next3;
            Objects.requireNonNull(reportNodeElement$Companion3);
            m.checkNotNullParameter(reportNodeElement5, "element");
        } while (!m.areEqual(reportNodeElement5.getType(), "channel_preview"));
        MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview = ((ReportNodeElement) next3) != null ? this.channelPreview : null;
        List<ReportNodeElement> listC4 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion4 = ReportNodeElement.Companion;
        Iterator<T> it4 = listC4.iterator();
        do {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
            reportNodeElement4 = (ReportNodeElement) next4;
            Objects.requireNonNull(reportNodeElement$Companion4);
            m.checkNotNullParameter(reportNodeElement4, "element");
        } while (!m.areEqual(reportNodeElement4.getType(), "guild_directory_entry_preview"));
        MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview = ((ReportNodeElement) next4) != null ? this.directoryServerPreview : null;
        List<ReportNodeElement> listC5 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion5 = ReportNodeElement.Companion;
        Iterator<T> it5 = listC5.iterator();
        do {
            if (!it5.hasNext()) {
                next5 = null;
                break;
            }
            next5 = it5.next();
            reportNodeElement3 = (ReportNodeElement) next5;
            Objects.requireNonNull(reportNodeElement$Companion5);
            m.checkNotNullParameter(reportNodeElement3, "element");
        } while (!m.areEqual(reportNodeElement3.getType(), "guild_scheduled_event_preview"));
        MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview = ((ReportNodeElement) next5) != null ? this.eventPreview : null;
        List<ReportNodeElement> listC6 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion6 = ReportNodeElement.Companion;
        Iterator<T> it6 = listC6.iterator();
        do {
            if (!it6.hasNext()) {
                next6 = null;
                break;
            }
            next6 = it6.next();
            reportNodeElement2 = (ReportNodeElement) next6;
            Objects.requireNonNull(reportNodeElement$Companion6);
            m.checkNotNullParameter(reportNodeElement2, "element");
        } while (!m.areEqual(reportNodeElement2.getType(), "block_users"));
        MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement = ((ReportNodeElement) next6) != null ? this.blockUserElement : null;
        List<ReportNodeElement> listC7 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion7 = ReportNodeElement.Companion;
        Iterator<T> it7 = listC7.iterator();
        do {
            if (!it7.hasNext()) {
                next7 = null;
                break;
            }
            next7 = it7.next();
            reportNodeElement = (ReportNodeElement) next7;
            Objects.requireNonNull(reportNodeElement$Companion7);
            m.checkNotNullParameter(reportNodeElement, "element");
        } while (!m.areEqual(reportNodeElement.getType(), "breadcrumbs"));
        List<NodeResult> list = ((ReportNodeElement) next7) != null ? this.history : null;
        List<ReportNodeElement> listC8 = node.c();
        ReportNodeElement$Companion reportNodeElement$Companion8 = ReportNodeElement.Companion;
        for (Object obj2 : listC8) {
            ReportNodeElement reportNodeElement9 = (ReportNodeElement) obj2;
            Objects.requireNonNull(reportNodeElement$Companion8);
            m.checkNotNullParameter(reportNodeElement9, "element");
            if (m.areEqual(reportNodeElement9.getType(), "success")) {
                obj = obj2;
                break;
            }
        }
        return new MobileReportsViewModel$NodeState(node, mobileReportsViewModel$CheckboxElement, mobileReportsViewModel$MessagePreview, mobileReportsViewModel$ChannelPreview, mobileReportsViewModel$DirectoryServerPreview, mobileReportsViewModel$GuildScheduledEventPreview, mobileReportsViewModel$BlockUserElement, list, obj != null, this.submitState, node.getButton());
    }

    public final MobileReportsViewModel$BlockUserElement getBlockUserElement() {
        return this.blockUserElement;
    }

    public final MobileReportsViewModel$ChannelPreview getChannelPreview() {
        return this.channelPreview;
    }

    public final MobileReportsViewModel$DirectoryServerPreview getDirectoryServerPreview() {
        return this.directoryServerPreview;
    }

    public final MobileReportsViewModel$GuildScheduledEventPreview getEventPreview() {
        return this.eventPreview;
    }

    public final List<NodeResult> getHistory() {
        return this.history;
    }

    public final MenuAPIResponse getMenu() {
        return this.menu;
    }

    public final MobileReportsViewModel$MessagePreview getMessagePreview() {
        return this.messagePreview;
    }

    public final MobileReportsViewModel$NodeNavigationType getNodeNavigationType() {
        return this.nodeNavigationType;
    }

    public final MobileReportsViewModel$SubmitState getSubmitState() {
        return this.submitState;
    }

    public int hashCode() {
        MenuAPIResponse menuAPIResponse = this.menu;
        int iHashCode = (menuAPIResponse != null ? menuAPIResponse.hashCode() : 0) * 31;
        MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview = this.messagePreview;
        int iHashCode2 = (iHashCode + (mobileReportsViewModel$MessagePreview != null ? mobileReportsViewModel$MessagePreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview = this.channelPreview;
        int iHashCode3 = (iHashCode2 + (mobileReportsViewModel$ChannelPreview != null ? mobileReportsViewModel$ChannelPreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview = this.directoryServerPreview;
        int iHashCode4 = (iHashCode3 + (mobileReportsViewModel$DirectoryServerPreview != null ? mobileReportsViewModel$DirectoryServerPreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview = this.eventPreview;
        int iHashCode5 = (iHashCode4 + (mobileReportsViewModel$GuildScheduledEventPreview != null ? mobileReportsViewModel$GuildScheduledEventPreview.hashCode() : 0)) * 31;
        MobileReportsViewModel$NodeNavigationType mobileReportsViewModel$NodeNavigationType = this.nodeNavigationType;
        int iHashCode6 = (iHashCode5 + (mobileReportsViewModel$NodeNavigationType != null ? mobileReportsViewModel$NodeNavigationType.hashCode() : 0)) * 31;
        MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState = this.submitState;
        int iHashCode7 = (iHashCode6 + (mobileReportsViewModel$SubmitState != null ? mobileReportsViewModel$SubmitState.hashCode() : 0)) * 31;
        List<NodeResult> list = this.history;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement = this.blockUserElement;
        return iHashCode8 + (mobileReportsViewModel$BlockUserElement != null ? mobileReportsViewModel$BlockUserElement.hashCode() : 0);
    }

    public final boolean shouldHideBackArrow() {
        return (this.submitState instanceof MobileReportsViewModel$SubmitState$Loading) || this.nodeNavigationType.getNode().getId() == this.menu.getSuccess_node_id() || this.nodeNavigationType.getNode().getId() == this.menu.getRoot_node_id();
    }

    public String toString() {
        StringBuilder sbU = a.U("Menu(menu=");
        sbU.append(this.menu);
        sbU.append(", messagePreview=");
        sbU.append(this.messagePreview);
        sbU.append(", channelPreview=");
        sbU.append(this.channelPreview);
        sbU.append(", directoryServerPreview=");
        sbU.append(this.directoryServerPreview);
        sbU.append(", eventPreview=");
        sbU.append(this.eventPreview);
        sbU.append(", nodeNavigationType=");
        sbU.append(this.nodeNavigationType);
        sbU.append(", submitState=");
        sbU.append(this.submitState);
        sbU.append(", history=");
        sbU.append(this.history);
        sbU.append(", blockUserElement=");
        sbU.append(this.blockUserElement);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel$ViewState$Menu(MenuAPIResponse menuAPIResponse, MobileReportsViewModel$MessagePreview mobileReportsViewModel$MessagePreview, MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview, MobileReportsViewModel$DirectoryServerPreview mobileReportsViewModel$DirectoryServerPreview, MobileReportsViewModel$GuildScheduledEventPreview mobileReportsViewModel$GuildScheduledEventPreview, MobileReportsViewModel$NodeNavigationType mobileReportsViewModel$NodeNavigationType, MobileReportsViewModel$SubmitState mobileReportsViewModel$SubmitState, List<NodeResult> list, MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement) {
        super(null);
        m.checkNotNullParameter(menuAPIResponse, "menu");
        m.checkNotNullParameter(mobileReportsViewModel$NodeNavigationType, "nodeNavigationType");
        m.checkNotNullParameter(mobileReportsViewModel$SubmitState, "submitState");
        m.checkNotNullParameter(list, "history");
        this.menu = menuAPIResponse;
        this.messagePreview = mobileReportsViewModel$MessagePreview;
        this.channelPreview = mobileReportsViewModel$ChannelPreview;
        this.directoryServerPreview = mobileReportsViewModel$DirectoryServerPreview;
        this.eventPreview = mobileReportsViewModel$GuildScheduledEventPreview;
        this.nodeNavigationType = mobileReportsViewModel$NodeNavigationType;
        this.submitState = mobileReportsViewModel$SubmitState;
        this.history = list;
        this.blockUserElement = mobileReportsViewModel$BlockUserElement;
    }
}
