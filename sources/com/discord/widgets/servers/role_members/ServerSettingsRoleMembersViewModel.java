package com.discord.widgets.servers.role_members;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$GuildMember;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuilds$Actions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.permissions.PermissionOwner$Member;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel extends d0<ServerSettingsRoleMembersViewModel$ViewState> {
    public static final ServerSettingsRoleMembersViewModel$Companion Companion = new ServerSettingsRoleMembersViewModel$Companion(null);
    private final PublishSubject<ServerSettingsRoleMembersViewModel$Event> eventSubject;
    private final long guildId;
    private final long guildRoleId;
    private final RestAPI restApi;
    private final BehaviorSubject<String> searchQuerySubject;
    private final StoreGatewayConnection storeGatewayConnection;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ ServerSettingsRoleMembersViewModel(long j, long j2, StoreGatewayConnection storeGatewayConnection, BehaviorSubject behaviorSubject, RestAPI restAPI, StoreGuilds storeGuilds, ObservationDeck observationDeck, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubject2;
        StoreGatewayConnection gatewaySocket = (i & 4) != 0 ? StoreStream.Companion.getGatewaySocket() : storeGatewayConnection;
        if ((i & 8) != 0) {
            BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0("");
            m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
            behaviorSubject2 = behaviorSubjectL0;
        } else {
            behaviorSubject2 = behaviorSubject;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 64) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreUser users = (i & 128) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        this(j, j2, gatewaySocket, behaviorSubject2, api, guilds, observationDeck2, users, (i & 256) != 0 ? Companion.observeStoreState(j, j2, behaviorSubject2, guilds, users, observationDeck2) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, ServerSettingsRoleMembersViewModel$Event serverSettingsRoleMembersViewModel$Event) {
        serverSettingsRoleMembersViewModel.emitEvent(serverSettingsRoleMembersViewModel$Event);
    }

    public static final /* synthetic */ long access$getGuildId$p(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel) {
        return serverSettingsRoleMembersViewModel.guildId;
    }

    public static final /* synthetic */ StoreGatewayConnection access$getStoreGatewayConnection$p(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel) {
        return serverSettingsRoleMembersViewModel.storeGatewayConnection;
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, ServerSettingsRoleMembersViewModel$StoreState serverSettingsRoleMembersViewModel$StoreState) {
        serverSettingsRoleMembersViewModel.handleStoreState(serverSettingsRoleMembersViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewState) {
        serverSettingsRoleMembersViewModel.updateViewState(serverSettingsRoleMembersViewModel$ViewState);
    }

    private final void emitEvent(ServerSettingsRoleMembersViewModel$Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final List<ServerSettingsRoleMemberAdapterItem> generateGuildMemberList(List<GuildMember> guildMembers, Map<Long, ? extends User> users) {
        ArrayList arrayList = new ArrayList();
        for (GuildMember guildMember : guildMembers) {
            User user = users.get(Long.valueOf(guildMember.getUserId()));
            if (user != null) {
                Object nick = guildMember.getNick();
                if (nick == null) {
                    nick = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
                }
                arrayList.add(new ServerSettingsRoleMemberAdapterItem(guildMember, new PermissionOwner$Member(user, nick.toString(), false)));
            }
        }
        return arrayList;
    }

    private final void handleStoreState(ServerSettingsRoleMembersViewModel$StoreState storeState) {
        if (storeState.getRole() == null) {
            return;
        }
        ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsRoleMembersViewModel$ViewStateRequireViewState instanceof ServerSettingsRoleMembersViewModel$ViewState$Loaded)) {
            serverSettingsRoleMembersViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsRoleMembersViewModel$ViewState$Loaded serverSettingsRoleMembersViewModel$ViewState$Loaded = (ServerSettingsRoleMembersViewModel$ViewState$Loaded) serverSettingsRoleMembersViewModel$ViewStateRequireViewState;
        updateViewState(new ServerSettingsRoleMembersViewModel$ViewState$Loaded(serverSettingsRoleMembersViewModel$ViewState$Loaded != null ? serverSettingsRoleMembersViewModel$ViewState$Loaded.isUpdating() : false, generateGuildMemberList(storeState.getGuildMembers(), storeState.getUsers()), storeState.getRole()));
    }

    public final Observable<ServerSettingsRoleMembersViewModel$Event> observeEvents() {
        PublishSubject<ServerSettingsRoleMembersViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeRoleFromMember(GuildMember guildMember) {
        m.checkNotNullParameter(guildMember, "guildMember");
        ServerSettingsRoleMembersViewModel$ViewState serverSettingsRoleMembersViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsRoleMembersViewModel$ViewStateRequireViewState instanceof ServerSettingsRoleMembersViewModel$ViewState$Loaded)) {
            serverSettingsRoleMembersViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsRoleMembersViewModel$ViewState$Loaded serverSettingsRoleMembersViewModel$ViewState$Loaded = (ServerSettingsRoleMembersViewModel$ViewState$Loaded) serverSettingsRoleMembersViewModel$ViewStateRequireViewState;
        if (serverSettingsRoleMembersViewModel$ViewState$Loaded != null) {
            updateViewState(ServerSettingsRoleMembersViewModel$ViewState$Loaded.copy$default(serverSettingsRoleMembersViewModel$ViewState$Loaded, true, null, null, 6, null));
            List<Long> mutableList = u.toMutableList((Collection) guildMember.getRoles());
            mutableList.remove(Long.valueOf(this.guildRoleId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.changeGuildMember(this.guildId, guildMember.getUserId(), RestAPIParams$GuildMember.Companion.createWithRoles(mutableList)), false, 1, null), this, null, 2, null), ServerSettingsRoleMembersViewModel.class, (Context) null, (Function1) null, new ServerSettingsRoleMembersViewModel$removeRoleFromMember$2(this), (Function0) null, (Function0) null, new ServerSettingsRoleMembersViewModel$removeRoleFromMember$1(this, serverSettingsRoleMembersViewModel$ViewState$Loaded), 54, (Object) null);
        }
    }

    public final void updateSearchQuery(String query) {
        m.checkNotNullParameter(query, "query");
        this.searchQuerySubject.onNext(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel(long j, long j2, StoreGatewayConnection storeGatewayConnection, BehaviorSubject<String> behaviorSubject, RestAPI restAPI, StoreGuilds storeGuilds, ObservationDeck observationDeck, StoreUser storeUser, Observable<ServerSettingsRoleMembersViewModel$StoreState> observable) {
        super(ServerSettingsRoleMembersViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        m.checkNotNullParameter(behaviorSubject, "searchQuerySubject");
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.guildRoleId = j2;
        this.storeGatewayConnection = storeGatewayConnection;
        this.searchQuerySubject = behaviorSubject;
        this.restApi = restAPI;
        this.eventSubject = PublishSubject.k0();
        StoreGuilds$Actions.requestRoleMembers(j, j2, this, restAPI, storeGatewayConnection);
        Observable<ServerSettingsRoleMembersViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), ServerSettingsRoleMembersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ServerSettingsRoleMembersViewModel$1(this), 62, (Object) null);
        Observable<String> observableP = behaviorSubject.P(750L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableP), this, null, 2, null), ServerSettingsRoleMembersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ServerSettingsRoleMembersViewModel$2(this), 62, (Object) null);
    }
}
