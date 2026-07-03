package com.discord.widgets.hubs;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddNameViewModel extends AbstractC0859d0<AddNameState> {
    private final long guildId;
    private final StoreGuilds guildStore;
    private final RestAPI restAPI;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddNameViewModel$setName$2 */
    /* JADX INFO: compiled from: WidgetHubAddNameViewModel.kt */
    public static final class C89902 extends AbstractC12240o implements Function1<RestCallState<? extends Void>, Unit> {
        public C89902() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Void> restCallState) {
            invoke2((RestCallState<Void>) restCallState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<Void> restCallState) {
            C12238m.checkNotNullParameter(restCallState, "async");
            AddNameState addNameStateAccess$getViewState$p = WidgetHubAddNameViewModel.access$getViewState$p(WidgetHubAddNameViewModel.this);
            if (addNameStateAccess$getViewState$p != null) {
                WidgetHubAddNameViewModel.this.updateViewState(AddNameState.copy$default(addNameStateAccess$getViewState$p, null, null, restCallState, 3, null));
            }
        }
    }

    public /* synthetic */ WidgetHubAddNameViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ AddNameState access$getViewState$p(WidgetHubAddNameViewModel widgetHubAddNameViewModel) {
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
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        AddNameState viewState = getViewState();
        if (viewState != null) {
            updateViewState(AddNameState.copy$default(viewState, name, null, null, 6, null));
        }
        RestCallStateKt.executeRequest(this.restAPI.changeGuildNickname(this.guildId, new RestAPIParams.Nick(name)), new C89902());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddNameViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, RestAPI restAPI) {
        super(new AddNameState(null, null, null, 7, null));
        C12238m.checkNotNullParameter(storeGuilds, "guildStore");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.guildStore = storeGuilds;
        this.userStore = storeUser;
        this.restAPI = restAPI;
        Guild guild = storeGuilds.getGuild(j);
        GuildMember member = storeGuilds.getMember(j, storeUser.getMeSnapshot().getId());
        String nick = member != null ? member.getNick() : null;
        updateViewState(new AddNameState(nick == null ? "" : nick, guild, null, 4, null));
    }
}
