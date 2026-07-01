package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGroupInviteFriends$Model {
    public static final WidgetGroupInviteFriends$Model$Companion Companion = new WidgetGroupInviteFriends$Model$Companion(null);
    public static final int MODE_ADD = 1;
    public static final int MODE_CREATE = 0;
    private final Channel channel;
    private final String filterText;
    private final int maxGroupMemberCount;
    private final int mode;
    private final List<WidgetGroupInviteFriends$Model$FriendItem> potentialAdditions;
    private final Collection<User> selectedUsers;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGroupInviteFriends$Model(Channel channel, String str, Collection<? extends User> collection, List<WidgetGroupInviteFriends$Model$FriendItem> list, int i, int i2) {
        m.checkNotNullParameter(collection, "selectedUsers");
        m.checkNotNullParameter(list, "potentialAdditions");
        this.channel = channel;
        this.filterText = str;
        this.selectedUsers = collection;
        this.potentialAdditions = list;
        this.mode = i;
        this.maxGroupMemberCount = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGroupInviteFriends$Model copy$default(WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model, Channel channel, String str, Collection collection, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            channel = widgetGroupInviteFriends$Model.channel;
        }
        if ((i3 & 2) != 0) {
            str = widgetGroupInviteFriends$Model.filterText;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            collection = widgetGroupInviteFriends$Model.selectedUsers;
        }
        Collection collection2 = collection;
        if ((i3 & 8) != 0) {
            list = widgetGroupInviteFriends$Model.potentialAdditions;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            i = widgetGroupInviteFriends$Model.mode;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = widgetGroupInviteFriends$Model.maxGroupMemberCount;
        }
        return widgetGroupInviteFriends$Model.copy(channel, str2, collection2, list2, i4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFilterText() {
        return this.filterText;
    }

    public final Collection<User> component3() {
        return this.selectedUsers;
    }

    public final List<WidgetGroupInviteFriends$Model$FriendItem> component4() {
        return this.potentialAdditions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMaxGroupMemberCount() {
        return this.maxGroupMemberCount;
    }

    public final WidgetGroupInviteFriends$Model copy(Channel channel, String filterText, Collection<? extends User> selectedUsers, List<WidgetGroupInviteFriends$Model$FriendItem> potentialAdditions, int mode, int maxGroupMemberCount) {
        m.checkNotNullParameter(selectedUsers, "selectedUsers");
        m.checkNotNullParameter(potentialAdditions, "potentialAdditions");
        return new WidgetGroupInviteFriends$Model(channel, filterText, selectedUsers, potentialAdditions, mode, maxGroupMemberCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGroupInviteFriends$Model)) {
            return false;
        }
        WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model = (WidgetGroupInviteFriends$Model) other;
        return m.areEqual(this.channel, widgetGroupInviteFriends$Model.channel) && m.areEqual(this.filterText, widgetGroupInviteFriends$Model.filterText) && m.areEqual(this.selectedUsers, widgetGroupInviteFriends$Model.selectedUsers) && m.areEqual(this.potentialAdditions, widgetGroupInviteFriends$Model.potentialAdditions) && this.mode == widgetGroupInviteFriends$Model.mode && this.maxGroupMemberCount == widgetGroupInviteFriends$Model.maxGroupMemberCount;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getFilterText() {
        return this.filterText;
    }

    public final int getMaxGroupMemberCount() {
        return this.maxGroupMemberCount;
    }

    public final int getMode() {
        return this.mode;
    }

    public final List<WidgetGroupInviteFriends$Model$FriendItem> getPotentialAdditions() {
        return this.potentialAdditions;
    }

    public final Collection<User> getSelectedUsers() {
        return this.selectedUsers;
    }

    public final int getTotalNumRecipients() {
        int size = this.selectedUsers.size() + 1;
        Channel channel = this.channel;
        if (channel == null) {
            return size;
        }
        List<com.discord.api.user.User> listZ = channel.z();
        return size + (listZ != null ? listZ.size() : 0);
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        String str = this.filterText;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Collection<User> collection = this.selectedUsers;
        int iHashCode3 = (iHashCode2 + (collection != null ? collection.hashCode() : 0)) * 31;
        List<WidgetGroupInviteFriends$Model$FriendItem> list = this.potentialAdditions;
        return ((((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.mode) * 31) + this.maxGroupMemberCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(channel=");
        sbU.append(this.channel);
        sbU.append(", filterText=");
        sbU.append(this.filterText);
        sbU.append(", selectedUsers=");
        sbU.append(this.selectedUsers);
        sbU.append(", potentialAdditions=");
        sbU.append(this.potentialAdditions);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", maxGroupMemberCount=");
        return a.B(sbU, this.maxGroupMemberCount, ")");
    }

    public /* synthetic */ WidgetGroupInviteFriends$Model(Channel channel, String str, Collection collection, List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : channel, (i3 & 2) != 0 ? null : str, collection, list, (i3 & 16) != 0 ? 0 : i, i2);
    }
}
