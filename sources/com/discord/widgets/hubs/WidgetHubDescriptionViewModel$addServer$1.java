package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionDirectoryGuildEntryCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel$addServer$1 extends o implements Function1<DirectoryEntryGuild, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ DirectoryEntryCategory $category;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel$addServer$1(long j, long j2, DirectoryEntryCategory directoryEntryCategory) {
        super(1);
        this.$channelId = j;
        this.$guildId = j2;
        this.$category = directoryEntryCategory;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(DirectoryEntryGuild directoryEntryGuild) {
        return invoke2(directoryEntryGuild);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(DirectoryEntryGuild directoryEntryGuild) {
        return new TrackNetworkActionDirectoryGuildEntryCreate(Long.valueOf(this.$channelId), Long.valueOf(this.$guildId), Long.valueOf(this.$category.getKey()));
    }
}
