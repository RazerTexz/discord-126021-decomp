package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubDescriptionState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubDescriptionViewModel3 {
    private final RestCallState<DirectoryEntryGuild> addServerAsync;
    private final Channel channel;
    private final String guildName;
    private final Integer primaryCategoryId;

    public WidgetHubDescriptionViewModel3() {
        this(null, null, null, null, 15, null);
    }

    public WidgetHubDescriptionViewModel3(Channel channel, Integer num, String str, RestCallState<DirectoryEntryGuild> restCallState) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(restCallState, "addServerAsync");
        this.channel = channel;
        this.primaryCategoryId = num;
        this.guildName = str;
        this.addServerAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubDescriptionViewModel3 copy$default(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3, Channel channel, Integer num, String str, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetHubDescriptionViewModel3.channel;
        }
        if ((i & 2) != 0) {
            num = widgetHubDescriptionViewModel3.primaryCategoryId;
        }
        if ((i & 4) != 0) {
            str = widgetHubDescriptionViewModel3.guildName;
        }
        if ((i & 8) != 0) {
            restCallState = widgetHubDescriptionViewModel3.addServerAsync;
        }
        return widgetHubDescriptionViewModel3.copy(channel, num, str, restCallState);
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

    public final WidgetHubDescriptionViewModel3 copy(Channel channel, Integer primaryCategoryId, String guildName, RestCallState<DirectoryEntryGuild> addServerAsync) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        Intrinsics3.checkNotNullParameter(addServerAsync, "addServerAsync");
        return new WidgetHubDescriptionViewModel3(channel, primaryCategoryId, guildName, addServerAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDescriptionViewModel3)) {
            return false;
        }
        WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3 = (WidgetHubDescriptionViewModel3) other;
        return Intrinsics3.areEqual(this.channel, widgetHubDescriptionViewModel3.channel) && Intrinsics3.areEqual(this.primaryCategoryId, widgetHubDescriptionViewModel3.primaryCategoryId) && Intrinsics3.areEqual(this.guildName, widgetHubDescriptionViewModel3.guildName) && Intrinsics3.areEqual(this.addServerAsync, widgetHubDescriptionViewModel3.addServerAsync);
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
        DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
        Channel channel = this.channel;
        return companion.findByKey(iIntValue, channel != null && ChannelUtils.x(channel));
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
        StringBuilder sbU = outline.U("HubDescriptionState(channel=");
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

    public /* synthetic */ WidgetHubDescriptionViewModel3(Channel channel, Integer num, String str, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : channel, (i & 2) != 0 ? null : num, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
