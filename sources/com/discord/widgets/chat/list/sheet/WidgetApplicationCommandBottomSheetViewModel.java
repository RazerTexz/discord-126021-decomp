package com.discord.widgets.chat.list.sheet;

import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final long interactionId;
    private final long interactionUserId;
    private final long messageId;
    private final String messageNonce;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final /* synthetic */ class C81691 extends C12236k implements Function1<StoreState, Unit> {
        public C81691(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel) {
            super(1, widgetApplicationCommandBottomSheetViewModel, WidgetApplicationCommandBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((WidgetApplicationCommandBottomSheetViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$3 */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final class C81713 extends AbstractC12240o implements Function1<UserData, Unit> {
        public C81713() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
            invoke2(userData);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserData userData) {
            if (WidgetApplicationCommandBottomSheetViewModel.this.getGuildId() != null) {
                StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), WidgetApplicationCommandBottomSheetViewModel.this.getGuildId().longValue(), null, C12163u.toList(userData.getMentionedUserIds()), null, 10, null);
            }
            if (userData.getUsers().size() != userData.getMentionedUserIds().size()) {
                StoreStream.INSTANCE.getUsers().fetchUsers(C12163u.toList(userData.getMentionedUserIds()));
            }
        }
    }

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(ObservationDeck observationDeck, long interactionId, Long guildId, long userId, long applicationId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUsers, StoreApplicationInteractions storeInteractions, StoreApplicationCommands storeApplicationCommands) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeApplicationCommands, storeChannels, storeInteractions, storeGuilds, storeUsers}, false, null, null, new C8172xc617f2ce(storeInteractions, interactionId, storeApplicationCommands, applicationId, userId, storeGuilds, guildId, storeUsers, storeChannels), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final /* data */ class SlashCommandParam {
        private final String copyText;
        private final String name;
        private final String value;
        private final Integer valueColor;

        public SlashCommandParam(String str, String str2, Integer num, String str3) {
            C1643a.m872q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "value", str3, "copyText");
            this.name = str;
            this.value = str2;
            this.valueColor = num;
            this.copyText = str3;
        }

        public static /* synthetic */ SlashCommandParam copy$default(SlashCommandParam slashCommandParam, String str, String str2, Integer num, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = slashCommandParam.name;
            }
            if ((i & 2) != 0) {
                str2 = slashCommandParam.value;
            }
            if ((i & 4) != 0) {
                num = slashCommandParam.valueColor;
            }
            if ((i & 8) != 0) {
                str3 = slashCommandParam.copyText;
            }
            return slashCommandParam.copy(str, str2, num, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getValueColor() {
            return this.valueColor;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCopyText() {
            return this.copyText;
        }

        public final SlashCommandParam copy(String name, String value, Integer valueColor, String copyText) {
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(value, "value");
            C12238m.checkNotNullParameter(copyText, "copyText");
            return new SlashCommandParam(name, value, valueColor, copyText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SlashCommandParam)) {
                return false;
            }
            SlashCommandParam slashCommandParam = (SlashCommandParam) other;
            return C12238m.areEqual(this.name, slashCommandParam.name) && C12238m.areEqual(this.value, slashCommandParam.value) && C12238m.areEqual(this.valueColor, slashCommandParam.valueColor) && C12238m.areEqual(this.copyText, slashCommandParam.copyText);
        }

        public final String getCopyText() {
            return this.copyText;
        }

        public final String getName() {
            return this.name;
        }

        public final String getValue() {
            return this.value;
        }

        public final Integer getValueColor() {
            return this.valueColor;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.valueColor;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            String str3 = this.copyText;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SlashCommandParam(name=");
            sbM833U.append(this.name);
            sbM833U.append(", value=");
            sbM833U.append(this.value);
            sbM833U.append(", valueColor=");
            sbM833U.append(this.valueColor);
            sbM833U.append(", copyText=");
            return C1643a.m822J(sbM833U, this.copyText, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Application application;
        private final Map<Long, Channel> channels;
        private final Map<String, SlashCommandParam> commandValues;
        private final Map<Long, GuildMember> guildMembers;
        private final Map<Long, GuildRole> guildRoles;
        private final StoreApplicationInteractions.State interactionState;
        private final GuildMember interactionUser;
        private final Set<Long> mentionedUsers;
        private final User user;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(User user, GuildMember guildMember, StoreApplicationInteractions.State state, Application application, Set<Long> set, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, ? extends User> map3, Map<Long, Channel> map4, Map<String, SlashCommandParam> map5) {
            C12238m.checkNotNullParameter(set, "mentionedUsers");
            C12238m.checkNotNullParameter(map3, "users");
            C12238m.checkNotNullParameter(map4, "channels");
            C12238m.checkNotNullParameter(map5, "commandValues");
            this.user = user;
            this.interactionUser = guildMember;
            this.interactionState = state;
            this.application = application;
            this.mentionedUsers = set;
            this.guildMembers = map;
            this.guildRoles = map2;
            this.users = map3;
            this.channels = map4;
            this.commandValues = map5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<String, SlashCommandParam> component10() {
            return this.commandValues;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GuildMember getInteractionUser() {
            return this.interactionUser;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreApplicationInteractions.State getInteractionState() {
            return this.interactionState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        public final Set<Long> component5() {
            return this.mentionedUsers;
        }

        public final Map<Long, GuildMember> component6() {
            return this.guildMembers;
        }

        public final Map<Long, GuildRole> component7() {
            return this.guildRoles;
        }

        public final Map<Long, User> component8() {
            return this.users;
        }

        public final Map<Long, Channel> component9() {
            return this.channels;
        }

        public final StoreState copy(User user, GuildMember interactionUser, StoreApplicationInteractions.State interactionState, Application application, Set<Long> mentionedUsers, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, ? extends User> users, Map<Long, Channel> channels, Map<String, SlashCommandParam> commandValues) {
            C12238m.checkNotNullParameter(mentionedUsers, "mentionedUsers");
            C12238m.checkNotNullParameter(users, "users");
            C12238m.checkNotNullParameter(channels, "channels");
            C12238m.checkNotNullParameter(commandValues, "commandValues");
            return new StoreState(user, interactionUser, interactionState, application, mentionedUsers, guildMembers, guildRoles, users, channels, commandValues);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.user, storeState.user) && C12238m.areEqual(this.interactionUser, storeState.interactionUser) && C12238m.areEqual(this.interactionState, storeState.interactionState) && C12238m.areEqual(this.application, storeState.application) && C12238m.areEqual(this.mentionedUsers, storeState.mentionedUsers) && C12238m.areEqual(this.guildMembers, storeState.guildMembers) && C12238m.areEqual(this.guildRoles, storeState.guildRoles) && C12238m.areEqual(this.users, storeState.users) && C12238m.areEqual(this.channels, storeState.channels) && C12238m.areEqual(this.commandValues, storeState.commandValues);
        }

        public final Application getApplication() {
            return this.application;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Map<String, SlashCommandParam> getCommandValues() {
            return this.commandValues;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final StoreApplicationInteractions.State getInteractionState() {
            return this.interactionState;
        }

        public final GuildMember getInteractionUser() {
            return this.interactionUser;
        }

        public final Set<Long> getMentionedUsers() {
            return this.mentionedUsers;
        }

        public final User getUser() {
            return this.user;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.interactionUser;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            StoreApplicationInteractions.State state = this.interactionState;
            int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
            Application application = this.application;
            int iHashCode4 = (iHashCode3 + (application != null ? application.hashCode() : 0)) * 31;
            Set<Long> set = this.mentionedUsers;
            int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map = this.guildMembers;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.guildRoles;
            int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, User> map3 = this.users;
            int iHashCode8 = (iHashCode7 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, Channel> map4 = this.channels;
            int iHashCode9 = (iHashCode8 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<String, SlashCommandParam> map5 = this.commandValues;
            return iHashCode9 + (map5 != null ? map5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(user=");
            sbM833U.append(this.user);
            sbM833U.append(", interactionUser=");
            sbM833U.append(this.interactionUser);
            sbM833U.append(", interactionState=");
            sbM833U.append(this.interactionState);
            sbM833U.append(", application=");
            sbM833U.append(this.application);
            sbM833U.append(", mentionedUsers=");
            sbM833U.append(this.mentionedUsers);
            sbM833U.append(", guildMembers=");
            sbM833U.append(this.guildMembers);
            sbM833U.append(", guildRoles=");
            sbM833U.append(this.guildRoles);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", channels=");
            sbM833U.append(this.channels);
            sbM833U.append(", commandValues=");
            return C1643a.m825M(sbM833U, this.commandValues, ")");
        }

        public /* synthetic */ StoreState(User user, GuildMember guildMember, StoreApplicationInteractions.State state, Application application, Set set, Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, (i & 2) != 0 ? null : guildMember, state, application, set, map, map2, map3, map4, map5);
        }
    }

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final /* data */ class UserData {
        private final Set<Long> mentionedUserIds;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UserData(Set<Long> set, Map<Long, ? extends User> map) {
            C12238m.checkNotNullParameter(set, "mentionedUserIds");
            C12238m.checkNotNullParameter(map, "users");
            this.mentionedUserIds = set;
            this.users = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserData copy$default(UserData userData, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                set = userData.mentionedUserIds;
            }
            if ((i & 2) != 0) {
                map = userData.users;
            }
            return userData.copy(set, map);
        }

        public final Set<Long> component1() {
            return this.mentionedUserIds;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final UserData copy(Set<Long> mentionedUserIds, Map<Long, ? extends User> users) {
            C12238m.checkNotNullParameter(mentionedUserIds, "mentionedUserIds");
            C12238m.checkNotNullParameter(users, "users");
            return new UserData(mentionedUserIds, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserData)) {
                return false;
            }
            UserData userData = (UserData) other;
            return C12238m.areEqual(this.mentionedUserIds, userData.mentionedUserIds) && C12238m.areEqual(this.users, userData.users);
        }

        public final Set<Long> getMentionedUserIds() {
            return this.mentionedUserIds;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Set<Long> set = this.mentionedUserIds;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UserData(mentionedUserIds=");
            sbM833U.append(this.mentionedUserIds);
            sbM833U.append(", users=");
            return C1643a.m825M(sbM833U, this.users, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
        public static final class Loaded extends ViewState {
            private final Application application;
            private final ApplicationCommandData applicationCommandData;
            private final Long channelId;
            private final Map<Long, Channel> channels;
            private final Map<String, SlashCommandParam> commandValues;
            private final Long guildId;
            private final Map<Long, GuildMember> guildMembers;
            private final Map<Long, GuildRole> guildRoles;
            private final long id;
            private final GuildMember interactionUser;
            private final User user;
            private final Map<Long, String> usernamesOrNicks;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, User user, GuildMember guildMember, Application application, ApplicationCommandData applicationCommandData, Long l, Long l2, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, Channel> map3, Map<Long, String> map4, Map<String, SlashCommandParam> map5) {
                super(null);
                C12238m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
                C12238m.checkNotNullParameter(map4, "usernamesOrNicks");
                C12238m.checkNotNullParameter(map5, "commandValues");
                this.id = j;
                this.user = user;
                this.interactionUser = guildMember;
                this.application = application;
                this.applicationCommandData = applicationCommandData;
                this.guildId = l;
                this.channelId = l2;
                this.guildMembers = map;
                this.guildRoles = map2;
                this.channels = map3;
                this.usernamesOrNicks = map4;
                this.commandValues = map5;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final ApplicationCommandData getApplicationCommandData() {
                return this.applicationCommandData;
            }

            public final Long getChannelId() {
                return this.channelId;
            }

            public final Map<Long, Channel> getChannels() {
                return this.channels;
            }

            public final Map<String, SlashCommandParam> getCommandValues() {
                return this.commandValues;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final long getId() {
                return this.id;
            }

            public final GuildMember getInteractionUser() {
                return this.interactionUser;
            }

            public final User getUser() {
                return this.user;
            }

            public final Map<Long, String> getUsernamesOrNicks() {
                return this.usernamesOrNicks;
            }
        }

        /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetApplicationCommandBottomSheetViewModel(long j, long j2, long j3, Long l, long j4, long j5, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        if ((i & 128) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(observationDeck, j, l, j4, j5, companion2.getGuilds(), companion2.getChannels(), companion2.getUsers(), companion2.getInteractions(), companion2.getApplicationCommands());
        } else {
            observableObserveStores = observable;
        }
        this(j, j2, j3, l, j4, j5, str, observableObserveStores);
    }

    private final void handleStoreState(StoreState storeState) {
        String username;
        StoreApplicationInteractions.State interactionState = storeState.getInteractionState();
        if (C12238m.areEqual(interactionState, StoreApplicationInteractions.State.Failure.INSTANCE)) {
            updateViewState(ViewState.Failed.INSTANCE);
            return;
        }
        if (C12238m.areEqual(interactionState, StoreApplicationInteractions.State.Fetching.INSTANCE)) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (interactionState instanceof StoreApplicationInteractions.State.Loaded) {
            if (storeState.getMentionedUsers().size() == storeState.getUsers().size()) {
                int size = storeState.getMentionedUsers().size();
                Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                if (guildMembers != null && size == guildMembers.size()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator<T> it = storeState.getMentionedUsers().iterator();
                    while (it.hasNext()) {
                        long jLongValue = ((Number) it.next()).longValue();
                        GuildMember guildMember = storeState.getGuildMembers().get(Long.valueOf(jLongValue));
                        if (guildMember == null || (username = guildMember.getNick()) == null) {
                            User user = storeState.getUsers().get(Long.valueOf(jLongValue));
                            username = user != null ? user.getUsername() : null;
                        }
                        if (username == null) {
                            username = "";
                        }
                        linkedHashMap.put(Long.valueOf(jLongValue), username);
                    }
                    updateViewState(new ViewState.Loaded(this.interactionId, storeState.getUser(), storeState.getInteractionUser(), storeState.getApplication(), ((StoreApplicationInteractions.State.Loaded) storeState.getInteractionState()).getCommandOptions(), this.guildId, Long.valueOf(this.channelId), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannels(), linkedHashMap, storeState.getCommandValues()));
                    return;
                }
            }
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    private final void requestInteractionData() {
        StoreStream.INSTANCE.getInteractions().fetchInteractionDataIfNonExisting(this.interactionId, this.channelId, this.messageId, this.messageNonce);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final long getInteractionId() {
        return this.interactionId;
    }

    public final long getInteractionUserId() {
        return this.interactionUserId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getMessageNonce() {
        return this.messageNonce;
    }

    public final void retry() {
        requestInteractionData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetViewModel(long j, long j2, long j3, Long l, long j4, long j5, String str, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.interactionId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.guildId = l;
        this.interactionUserId = j4;
        this.applicationId = j5;
        this.messageNonce = str;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetApplicationCommandBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81691(this));
        requestInteractionData();
        Observable observableM11112r = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).m11083G(new InterfaceC12589b<StoreState, UserData>() { // from class: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final UserData call(StoreState storeState) {
                return new UserData(storeState.getMentionedUsers(), storeState.getUsers());
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeObservable.computat…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetApplicationCommandBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C81713());
    }
}
