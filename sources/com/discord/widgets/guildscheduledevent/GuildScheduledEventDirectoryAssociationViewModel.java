package com.discord.widgets.guildscheduledevent;

import com.discord.api.directory.DirectoryEntryType;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDirectoryAssociationViewModel extends AbstractC0859d0<GuildScheduledEventDirectoryAssociationState> {

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDirectoryAssociationViewModel$1 */
    /* JADX INFO: compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
    public static final class C88181 extends AbstractC12240o implements Function1<RestCallState<? extends GuildScheduledEventBroadcast>, Unit> {
        public C88181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends GuildScheduledEventBroadcast> restCallState) {
            invoke2((RestCallState<GuildScheduledEventBroadcast>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "async");
            GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationStateAccess$getViewState$p = GuildScheduledEventDirectoryAssociationViewModel.access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel.this);
            if (guildScheduledEventDirectoryAssociationStateAccess$getViewState$p != null) {
                GuildScheduledEventDirectoryAssociationViewModel.this.updateViewState(guildScheduledEventDirectoryAssociationStateAccess$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ GuildScheduledEventDirectoryAssociationState access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel) {
        return guildScheduledEventDirectoryAssociationViewModel.getViewState();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI) {
        super(new GuildScheduledEventDirectoryAssociationState(null, 1, null));
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        Guild guild = storeGuilds.getGuild(j);
        if (guild != null ? guild.hasFeature(GuildFeature.HAS_DIRECTORY_ENTRY) : true) {
            RestCallStateKt.executeRequest(restAPI.getDirectoryEntryBroadcastInfo(j, l, DirectoryEntryType.GuildScheduledEvent.getKey()), new C88181());
        }
    }
}
