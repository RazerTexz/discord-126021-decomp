package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelMembersListViewModel$StoreState$Private extends WidgetChannelMembersListViewModel$StoreState {
    private final Map<Long, ModelApplicationStream> applicationStreams;
    private final Channel channel;
    private final boolean isPanelOpen;
    private final Map<Long, Presence> presences;
    private final Map<Long, Integer> relationships;
    private final Map<Long, User> users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelMembersListViewModel$StoreState$Private(boolean z2, Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, Integer> map4) {
        super(z2, channel, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "presences");
        m.checkNotNullParameter(map3, "applicationStreams");
        m.checkNotNullParameter(map4, "relationships");
        this.isPanelOpen = z2;
        this.channel = channel;
        this.users = map;
        this.presences = map2;
        this.applicationStreams = map3;
        this.relationships = map4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Private copy$default(WidgetChannelMembersListViewModel$StoreState$Private widgetChannelMembersListViewModel$StoreState$Private, boolean z2, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetChannelMembersListViewModel$StoreState$Private.getIsPanelOpen();
        }
        if ((i & 2) != 0) {
            channel = widgetChannelMembersListViewModel$StoreState$Private.getChannel();
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            map = widgetChannelMembersListViewModel$StoreState$Private.users;
        }
        Map map5 = map;
        if ((i & 8) != 0) {
            map2 = widgetChannelMembersListViewModel$StoreState$Private.presences;
        }
        Map map6 = map2;
        if ((i & 16) != 0) {
            map3 = widgetChannelMembersListViewModel$StoreState$Private.applicationStreams;
        }
        Map map7 = map3;
        if ((i & 32) != 0) {
            map4 = widgetChannelMembersListViewModel$StoreState$Private.relationships;
        }
        return widgetChannelMembersListViewModel$StoreState$Private.copy(z2, channel2, map5, map6, map7, map4);
    }

    public final boolean component1() {
        return getIsPanelOpen();
    }

    public final Channel component2() {
        return getChannel();
    }

    public final Map<Long, User> component3() {
        return this.users;
    }

    public final Map<Long, Presence> component4() {
        return this.presences;
    }

    public final Map<Long, ModelApplicationStream> component5() {
        return this.applicationStreams;
    }

    public final Map<Long, Integer> component6() {
        return this.relationships;
    }

    public final WidgetChannelMembersListViewModel$StoreState$Private copy(boolean isPanelOpen, Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, Integer> relationships) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(presences, "presences");
        m.checkNotNullParameter(applicationStreams, "applicationStreams");
        m.checkNotNullParameter(relationships, "relationships");
        return new WidgetChannelMembersListViewModel$StoreState$Private(isPanelOpen, channel, users, presences, applicationStreams, relationships);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelMembersListViewModel$StoreState$Private)) {
            return false;
        }
        WidgetChannelMembersListViewModel$StoreState$Private widgetChannelMembersListViewModel$StoreState$Private = (WidgetChannelMembersListViewModel$StoreState$Private) other;
        return getIsPanelOpen() == widgetChannelMembersListViewModel$StoreState$Private.getIsPanelOpen() && m.areEqual(getChannel(), widgetChannelMembersListViewModel$StoreState$Private.getChannel()) && m.areEqual(this.users, widgetChannelMembersListViewModel$StoreState$Private.users) && m.areEqual(this.presences, widgetChannelMembersListViewModel$StoreState$Private.presences) && m.areEqual(this.applicationStreams, widgetChannelMembersListViewModel$StoreState$Private.applicationStreams) && m.areEqual(this.relationships, widgetChannelMembersListViewModel$StoreState$Private.relationships);
    }

    public final Map<Long, ModelApplicationStream> getApplicationStreams() {
        return this.applicationStreams;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    public Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, Presence> getPresences() {
        return this.presences;
    }

    public final Map<Long, Integer> getRelationships() {
        return this.relationships;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        boolean isPanelOpen = getIsPanelOpen();
        int i = isPanelOpen;
        if (isPanelOpen) {
            i = 1;
        }
        int i2 = i * 31;
        Channel channel = getChannel();
        int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
        Map<Long, User> map = this.users;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Presence> map2 = this.presences;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Integer> map4 = this.relationships;
        return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
    public boolean getIsPanelOpen() {
        return this.isPanelOpen;
    }

    public String toString() {
        StringBuilder sbU = a.U("Private(isPanelOpen=");
        sbU.append(getIsPanelOpen());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", applicationStreams=");
        sbU.append(this.applicationStreams);
        sbU.append(", relationships=");
        return a.M(sbU, this.relationships, ")");
    }
}
