package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModelStoreState$BootstrapData {
    private final Channel channel;
    private final MeUser me;
    private final Channel selectedVoiceChannel;
    private final User user;

    public WidgetUserSheetViewModelStoreState$BootstrapData(User user, MeUser meUser, Channel channel, Channel channel2) {
        m.checkNotNullParameter(meUser, "me");
        this.user = user;
        this.me = meUser;
        this.channel = channel;
        this.selectedVoiceChannel = channel2;
    }

    public static /* synthetic */ WidgetUserSheetViewModelStoreState$BootstrapData copy$default(WidgetUserSheetViewModelStoreState$BootstrapData widgetUserSheetViewModelStoreState$BootstrapData, User user, MeUser meUser, Channel channel, Channel channel2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetUserSheetViewModelStoreState$BootstrapData.user;
        }
        if ((i & 2) != 0) {
            meUser = widgetUserSheetViewModelStoreState$BootstrapData.me;
        }
        if ((i & 4) != 0) {
            channel = widgetUserSheetViewModelStoreState$BootstrapData.channel;
        }
        if ((i & 8) != 0) {
            channel2 = widgetUserSheetViewModelStoreState$BootstrapData.selectedVoiceChannel;
        }
        return widgetUserSheetViewModelStoreState$BootstrapData.copy(user, meUser, channel, channel2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final WidgetUserSheetViewModelStoreState$BootstrapData copy(User user, MeUser me2, Channel channel, Channel selectedVoiceChannel) {
        m.checkNotNullParameter(me2, "me");
        return new WidgetUserSheetViewModelStoreState$BootstrapData(user, me2, channel, selectedVoiceChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModelStoreState$BootstrapData)) {
            return false;
        }
        WidgetUserSheetViewModelStoreState$BootstrapData widgetUserSheetViewModelStoreState$BootstrapData = (WidgetUserSheetViewModelStoreState$BootstrapData) other;
        return m.areEqual(this.user, widgetUserSheetViewModelStoreState$BootstrapData.user) && m.areEqual(this.me, widgetUserSheetViewModelStoreState$BootstrapData.me) && m.areEqual(this.channel, widgetUserSheetViewModelStoreState$BootstrapData.channel) && m.areEqual(this.selectedVoiceChannel, widgetUserSheetViewModelStoreState$BootstrapData.selectedVoiceChannel);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        MeUser meUser = this.me;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.selectedVoiceChannel;
        return iHashCode3 + (channel2 != null ? channel2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("BootstrapData(user=");
        sbU.append(this.user);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
