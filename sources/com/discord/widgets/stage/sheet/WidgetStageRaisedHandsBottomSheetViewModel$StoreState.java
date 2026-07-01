package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageRaisedHandsBottomSheetViewModel$StoreState {
    private final Channel channel;
    private final int myStageRoles;
    private final List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> raisedHandsParticipants;
    private final Map<Long, GuildRole> roles;

    /* JADX WARN: Multi-variable type inference failed */
    private WidgetStageRaisedHandsBottomSheetViewModel$StoreState(Channel channel, Map<Long, GuildRole> map, List<? extends WidgetStageRaisedHandsBottomSheetAdapter$ListItem> list, int i) {
        this.channel = channel;
        this.roles = map;
        this.raisedHandsParticipants = list;
        this.myStageRoles = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-FZjiw-U$default, reason: not valid java name */
    public static /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$StoreState m47copyFZjiwU$default(WidgetStageRaisedHandsBottomSheetViewModel$StoreState widgetStageRaisedHandsBottomSheetViewModel$StoreState, Channel channel, Map map, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = widgetStageRaisedHandsBottomSheetViewModel$StoreState.channel;
        }
        if ((i2 & 2) != 0) {
            map = widgetStageRaisedHandsBottomSheetViewModel$StoreState.roles;
        }
        if ((i2 & 4) != 0) {
            list = widgetStageRaisedHandsBottomSheetViewModel$StoreState.raisedHandsParticipants;
        }
        if ((i2 & 8) != 0) {
            i = widgetStageRaisedHandsBottomSheetViewModel$StoreState.myStageRoles;
        }
        return widgetStageRaisedHandsBottomSheetViewModel$StoreState.m49copyFZjiwU(channel, map, list, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, GuildRole> component2() {
        return this.roles;
    }

    public final List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> component3() {
        return this.raisedHandsParticipants;
    }

    /* JADX INFO: renamed from: component4-1LxfuJo, reason: not valid java name and from getter */
    public final int getMyStageRoles() {
        return this.myStageRoles;
    }

    /* JADX INFO: renamed from: copy-FZjiw-U, reason: not valid java name */
    public final WidgetStageRaisedHandsBottomSheetViewModel$StoreState m49copyFZjiwU(Channel channel, Map<Long, GuildRole> roles, List<? extends WidgetStageRaisedHandsBottomSheetAdapter$ListItem> raisedHandsParticipants, int myStageRoles) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(raisedHandsParticipants, "raisedHandsParticipants");
        return new WidgetStageRaisedHandsBottomSheetViewModel$StoreState(channel, roles, raisedHandsParticipants, myStageRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageRaisedHandsBottomSheetViewModel$StoreState)) {
            return false;
        }
        WidgetStageRaisedHandsBottomSheetViewModel$StoreState widgetStageRaisedHandsBottomSheetViewModel$StoreState = (WidgetStageRaisedHandsBottomSheetViewModel$StoreState) other;
        return m.areEqual(this.channel, widgetStageRaisedHandsBottomSheetViewModel$StoreState.channel) && m.areEqual(this.roles, widgetStageRaisedHandsBottomSheetViewModel$StoreState.roles) && m.areEqual(this.raisedHandsParticipants, widgetStageRaisedHandsBottomSheetViewModel$StoreState.raisedHandsParticipants) && this.myStageRoles == widgetStageRaisedHandsBottomSheetViewModel$StoreState.myStageRoles;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
    public final int m50getMyStageRoles1LxfuJo() {
        return this.myStageRoles;
    }

    public final List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> getRaisedHandsParticipants() {
        return this.raisedHandsParticipants;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> list = this.raisedHandsParticipants;
        return ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.myStageRoles;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channel=");
        sbU.append(this.channel);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", raisedHandsParticipants=");
        sbU.append(this.raisedHandsParticipants);
        sbU.append(", myStageRoles=");
        sbU.append(StageRoles.m34toStringimpl(this.myStageRoles));
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$StoreState(Channel channel, Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, map, list, i);
    }
}
