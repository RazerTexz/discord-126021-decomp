package com.discord.widgets.hubs;

import b.a.d.AppViewModel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddNameViewModel extends AppViewModel<WidgetHubAddNameViewModel2> {
    private final long guildId;
    private final StoreGuilds guildStore;
    private final RestAPI restAPI;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddNameViewModel$setName$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends Void>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Void> restCallState) {
            invoke2((RestCallState<Void>) restCallState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<Void> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "async");
            WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2Access$getViewState$p = WidgetHubAddNameViewModel.access$getViewState$p(WidgetHubAddNameViewModel.this);
            if (widgetHubAddNameViewModel2Access$getViewState$p != null) {
                WidgetHubAddNameViewModel.this.updateViewState(WidgetHubAddNameViewModel2.copy$default(widgetHubAddNameViewModel2Access$getViewState$p, null, null, restCallState, 3, null));
            }
        }
    }

    public /* synthetic */ WidgetHubAddNameViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ WidgetHubAddNameViewModel2 access$getViewState$p(WidgetHubAddNameViewModel widgetHubAddNameViewModel) {
        return widgetHubAddNameViewModel.getViewState();
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final StoreGuilds getGuildStore() {
        return this.guildStore;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreUser getUserStore() {
        return this.userStore;
    }

    public final void setName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        WidgetHubAddNameViewModel2 viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetHubAddNameViewModel2.copy$default(viewState, name, null, null, 6, null));
        }
        RestCallState5.executeRequest(this.restAPI.changeGuildNickname(this.guildId, new RestAPIParams.Nick(name)), new AnonymousClass2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddNameViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, RestAPI restAPI) {
        super(new WidgetHubAddNameViewModel2(null, null, null, 7, null));
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.guildStore = storeGuilds;
        this.userStore = storeUser;
        this.restAPI = restAPI;
        Guild guild = storeGuilds.getGuild(j);
        GuildMember member = storeGuilds.getMember(j, storeUser.getMeSnapshot().getId());
        String nick = member != null ? member.getNick() : null;
        updateViewState(new WidgetHubAddNameViewModel2(nick == null ? "" : nick, guild, null, 4, null));
    }
}
