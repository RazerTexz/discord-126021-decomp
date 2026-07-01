package com.discord.widgets.guildscheduledevent;

import b.a.d.d0;
import com.discord.api.directory.DirectoryEntryType;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDirectoryAssociationViewModel extends d0<GuildScheduledEventDirectoryAssociationState> {
    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, (i & 4) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ GuildScheduledEventDirectoryAssociationState access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel) {
        return guildScheduledEventDirectoryAssociationViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel, GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationState) {
        guildScheduledEventDirectoryAssociationViewModel.updateViewState(guildScheduledEventDirectoryAssociationState);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI) {
        super(new GuildScheduledEventDirectoryAssociationState(null, 1, null));
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(restAPI, "restAPI");
        Guild guild = storeGuilds.getGuild(j);
        if (guild != null ? guild.hasFeature(GuildFeature.HAS_DIRECTORY_ENTRY) : true) {
            RestCallStateKt.executeRequest(restAPI.getDirectoryEntryBroadcastInfo(j, l, DirectoryEntryType.GuildScheduledEvent.getKey()), new GuildScheduledEventDirectoryAssociationViewModel$1(this));
        }
    }
}
