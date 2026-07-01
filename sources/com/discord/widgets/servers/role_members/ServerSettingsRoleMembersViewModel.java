package com.discord.widgets.servers.role_members;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final long guildRoleId;
    private final RestAPI restApi;
    private final BehaviorSubject<String> searchQuerySubject;
    private final StoreGatewayConnection storeGatewayConnection;

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel = ServerSettingsRoleMembersViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            serverSettingsRoleMembersViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreGatewayConnection.requestGuildMembers$default(ServerSettingsRoleMembersViewModel.this.storeGatewayConnection, ServerSettingsRoleMembersViewModel.this.guildId, str, null, null, 12, null);
        }
    }

    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeGuildRoleMembers(long guildId, long guildRoleId, StoreGuilds storeGuilds, StoreUser storeUser, ObservationDeck observationDeck) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuilds, storeUser}, false, null, null, new ServerSettingsRoleMembersViewModel2(storeGuilds, guildId, guildRoleId, storeUser), 14, null);
        }

        public final Observable<StoreState> observeStoreState(long guildId, long guildRoleId, BehaviorSubject<String> searchFilterSubject, StoreGuilds storeGuilds, StoreUser storeUser, ObservationDeck observationDeck) {
            Intrinsics3.checkNotNullParameter(searchFilterSubject, "searchFilterSubject");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Observable<StoreState> observableJ = Observable.j(searchFilterSubject.r(), observeGuildRoleMembers(guildId, guildRoleId, storeGuilds, storeUser, observationDeck), new Func2<String, StoreState, StoreState>() { // from class: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public final ServerSettingsRoleMembersViewModel.StoreState call(String str, ServerSettingsRoleMembersViewModel.StoreState storeState) {
                    String nick;
                    String username;
                    Intrinsics3.checkNotNullParameter(str, "filter");
                    Intrinsics3.checkNotNullParameter(storeState, "storeState");
                    List<GuildMember> guildMembers = storeState.getGuildMembers();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : guildMembers) {
                        GuildMember guildMember = (GuildMember) obj;
                        User user = storeState.getUsers().get(Long.valueOf(guildMember.getUserId()));
                        boolean z2 = true;
                        if ((user == null || (username = user.getUsername()) == null || !Strings4.contains((CharSequence) username, (CharSequence) str, true)) && ((nick = guildMember.getNick()) == null || !Strings4.contains((CharSequence) nick, (CharSequence) str, true))) {
                            z2 = false;
                        }
                        if (z2) {
                            arrayList.add(obj);
                        }
                    }
                    return ServerSettingsRoleMembersViewModel.StoreState.copy$default(storeState, arrayList, null, null, 6, null);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…eredGuildMembers)\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
        public static final /* data */ class RemoveMemberFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoveMemberFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ RemoveMemberFailure copy$default(RemoveMemberFailure removeMemberFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = removeMemberFailure.error;
                }
                return removeMemberFailure.copy(error);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final RemoveMemberFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new RemoveMemberFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RemoveMemberFailure) && Intrinsics3.areEqual(this.error, ((RemoveMemberFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("RemoveMemberFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<GuildMember> guildMembers;
        private final GuildRole role;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(List<GuildMember> list, Map<Long, ? extends User> map, GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(list, "guildMembers");
            Intrinsics3.checkNotNullParameter(map, "users");
            this.guildMembers = list;
            this.users = map;
            this.role = guildRole;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Map map, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.guildMembers;
            }
            if ((i & 2) != 0) {
                map = storeState.users;
            }
            if ((i & 4) != 0) {
                guildRole = storeState.role;
            }
            return storeState.copy(list, map, guildRole);
        }

        public final List<GuildMember> component1() {
            return this.guildMembers;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final StoreState copy(List<GuildMember> guildMembers, Map<Long, ? extends User> users, GuildRole role) {
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new StoreState(guildMembers, users, role);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.role, storeState.role);
        }

        public final List<GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            List<GuildMember> list = this.guildMembers;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            GuildRole guildRole = this.role;
            return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isUpdating;
            private final List<ServerSettingsRoleMemberAdapterItem> memberList;
            private final GuildRole role;

            public /* synthetic */ Loaded(boolean z2, List list, GuildRole guildRole, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z2, list, guildRole);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, List list, GuildRole guildRole, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.isUpdating;
                }
                if ((i & 2) != 0) {
                    list = loaded.memberList;
                }
                if ((i & 4) != 0) {
                    guildRole = loaded.role;
                }
                return loaded.copy(z2, list, guildRole);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsUpdating() {
                return this.isUpdating;
            }

            public final List<ServerSettingsRoleMemberAdapterItem> component2() {
                return this.memberList;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildRole getRole() {
                return this.role;
            }

            public final Loaded copy(boolean isUpdating, List<ServerSettingsRoleMemberAdapterItem> memberList, GuildRole role) {
                Intrinsics3.checkNotNullParameter(memberList, "memberList");
                Intrinsics3.checkNotNullParameter(role, "role");
                return new Loaded(isUpdating, memberList, role);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.isUpdating == loaded.isUpdating && Intrinsics3.areEqual(this.memberList, loaded.memberList) && Intrinsics3.areEqual(this.role, loaded.role);
            }

            public final List<ServerSettingsRoleMemberAdapterItem> getMemberList() {
                return this.memberList;
            }

            public final GuildRole getRole() {
                return this.role;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r0v7 */
            public int hashCode() {
                boolean z2 = this.isUpdating;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                List<ServerSettingsRoleMemberAdapterItem> list = this.memberList;
                int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
                GuildRole guildRole = this.role;
                return iHashCode + (guildRole != null ? guildRole.hashCode() : 0);
            }

            public final boolean isUpdating() {
                return this.isUpdating;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(isUpdating=");
                sbU.append(this.isUpdating);
                sbU.append(", memberList=");
                sbU.append(this.memberList);
                sbU.append(", role=");
                sbU.append(this.role);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(boolean z2, List<ServerSettingsRoleMemberAdapterItem> list, GuildRole guildRole) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "memberList");
                Intrinsics3.checkNotNullParameter(guildRole, "role");
                this.isUpdating = z2;
                this.memberList = list;
                this.role = guildRole;
            }
        }

        /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$removeRoleFromMember$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            ServerSettingsRoleMembersViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, null, null, 6, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$removeRoleFromMember$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            ServerSettingsRoleMembersViewModel.this.emitEvent(new Event.RemoveMemberFailure(error));
        }
    }

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
        StoreGatewayConnection gatewaySocket = (i & 4) != 0 ? StoreStream.INSTANCE.getGatewaySocket() : storeGatewayConnection;
        if ((i & 8) != 0) {
            BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0("");
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
            behaviorSubject2 = behaviorSubjectL0;
        } else {
            behaviorSubject2 = behaviorSubject;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 64) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreUser users = (i & 128) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, j2, gatewaySocket, behaviorSubject2, api, guilds, observationDeck2, users, (i & 256) != 0 ? INSTANCE.observeStoreState(j, j2, behaviorSubject2, guilds, users, observationDeck2) : observable);
    }

    private final void emitEvent(Event event) {
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
                arrayList.add(new ServerSettingsRoleMemberAdapterItem(guildMember, new PermissionOwner.Member(user, nick.toString(), false)));
            }
        }
        return arrayList;
    }

    private final void handleStoreState(StoreState storeState) {
        if (storeState.getRole() == null) {
            return;
        }
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        updateViewState(new ViewState.Loaded(loaded != null ? loaded.isUpdating() : false, generateGuildMemberList(storeState.getGuildMembers(), storeState.getUsers()), storeState.getRole()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeRoleFromMember(GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, true, null, null, 6, null));
            List<Long> mutableList = _Collections.toMutableList((Collection) guildMember.getRoles());
            mutableList.remove(Long.valueOf(this.guildRoleId));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.changeGuildMember(this.guildId, guildMember.getUserId(), RestAPIParams.GuildMember.INSTANCE.createWithRoles(mutableList)), false, 1, null), this, null, 2, null), (Class<?>) ServerSettingsRoleMembersViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(loaded));
        }
    }

    public final void updateSearchQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.searchQuerySubject.onNext(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel(long j, long j2, StoreGatewayConnection storeGatewayConnection, BehaviorSubject<String> behaviorSubject, RestAPI restAPI, StoreGuilds storeGuilds, ObservationDeck observationDeck, StoreUser storeUser, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        Intrinsics3.checkNotNullParameter(behaviorSubject, "searchQuerySubject");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.guildRoleId = j2;
        this.storeGatewayConnection = storeGatewayConnection;
        this.searchQuerySubject = behaviorSubject;
        this.restApi = restAPI;
        this.eventSubject = PublishSubject.k0();
        StoreGuilds.Actions.requestRoleMembers(j, j2, this, restAPI, storeGatewayConnection);
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) ServerSettingsRoleMembersViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        Observable<String> observableP = behaviorSubject.P(750L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableP), this, null, 2, null), (Class<?>) ServerSettingsRoleMembersViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
