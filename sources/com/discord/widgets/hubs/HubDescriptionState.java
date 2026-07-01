package com.discord.widgets.hubs;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.models.hubs.DirectoryEntryCategory$Companion;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubDescriptionState {
    private final RestCallState<DirectoryEntryGuild> addServerAsync;
    private final Channel channel;
    private final String guildName;
    private final Integer primaryCategoryId;

    public HubDescriptionState() {
        this(null, null, null, null, 15, null);
    }

    public HubDescriptionState(Channel channel, Integer num, String str, RestCallState<DirectoryEntryGuild> restCallState) {
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(restCallState, "addServerAsync");
        this.channel = channel;
        this.primaryCategoryId = num;
        this.guildName = str;
        this.addServerAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubDescriptionState copy$default(HubDescriptionState hubDescriptionState, Channel channel, Integer num, String str, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = hubDescriptionState.channel;
        }
        if ((i & 2) != 0) {
            num = hubDescriptionState.primaryCategoryId;
        }
        if ((i & 4) != 0) {
            str = hubDescriptionState.guildName;
        }
        if ((i & 8) != 0) {
            restCallState = hubDescriptionState.addServerAsync;
        }
        return hubDescriptionState.copy(channel, num, str, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final RestCallState<DirectoryEntryGuild> component4() {
        return this.addServerAsync;
    }

    public final HubDescriptionState copy(Channel channel, Integer primaryCategoryId, String guildName, RestCallState<DirectoryEntryGuild> addServerAsync) {
        m.checkNotNullParameter(guildName, "guildName");
        m.checkNotNullParameter(addServerAsync, "addServerAsync");
        return new HubDescriptionState(channel, primaryCategoryId, guildName, addServerAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubDescriptionState)) {
            return false;
        }
        HubDescriptionState hubDescriptionState = (HubDescriptionState) other;
        return m.areEqual(this.channel, hubDescriptionState.channel) && m.areEqual(this.primaryCategoryId, hubDescriptionState.primaryCategoryId) && m.areEqual(this.guildName, hubDescriptionState.guildName) && m.areEqual(this.addServerAsync, hubDescriptionState.addServerAsync);
    }

    public final RestCallState<DirectoryEntryGuild> getAddServerAsync() {
        return this.addServerAsync;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final Integer getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public final DirectoryEntryCategory getSelectedCategory() {
        Integer num = this.primaryCategoryId;
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        DirectoryEntryCategory$Companion directoryEntryCategory$Companion = DirectoryEntryCategory.Companion;
        Channel channel = this.channel;
        return directoryEntryCategory$Companion.findByKey(iIntValue, channel != null && ChannelUtils.x(channel));
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Integer num = this.primaryCategoryId;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.guildName;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        RestCallState<DirectoryEntryGuild> restCallState = this.addServerAsync;
        return iHashCode3 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HubDescriptionState(channel=");
        sbU.append(this.channel);
        sbU.append(", primaryCategoryId=");
        sbU.append(this.primaryCategoryId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", addServerAsync=");
        sbU.append(this.addServerAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ HubDescriptionState(Channel channel, Integer num, String str, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : channel, (i & 2) != 0 ? null : num, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? Default.INSTANCE : restCallState);
    }
}
