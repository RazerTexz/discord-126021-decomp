package com.discord.widgets.chat.list.sheet;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final long interactionId;
    private final long interactionUserId;
    private final long messageId;
    private final String messageNonce;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel) {
            super(1, widgetApplicationCommandBottomSheetViewModel, WidgetApplicationCommandBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((WidgetApplicationCommandBottomSheetViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<UserData, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserData userData) {
            invoke2(userData);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserData userData) {
            if (WidgetApplicationCommandBottomSheetViewModel.this.getGuildId() != null) {
                StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), WidgetApplicationCommandBottomSheetViewModel.this.getGuildId().longValue(), null, _Collections.toList(userData.getMentionedUserIds()), null, 10, null);
            }
            if (userData.getUsers().size() != userData.getMentionedUserIds().size()) {
                StoreStream.INSTANCE.getUsers().fetchUsers(_Collections.toList(userData.getMentionedUserIds()));
            }
        }
    }

    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(ObservationDeck observationDeck, long interactionId, Long guildId, long userId, long applicationId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUsers, StoreApplicationInteractions storeInteractions, StoreApplicationCommands storeApplicationCommands) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeApplicationCommands, storeChannels, storeInteractions, storeGuilds, storeUsers}, false, null, null, new WidgetApplicationCommandBottomSheetViewModel2(storeInteractions, interactionId, storeApplicationCommands, applicationId, userId, storeGuilds, guildId, storeUsers, storeChannels), 14, null);
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
            outline.q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "value", str3, "copyText");
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
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(value, "value");
            Intrinsics3.checkNotNullParameter(copyText, "copyText");
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
            return Intrinsics3.areEqual(this.name, slashCommandParam.name) && Intrinsics3.areEqual(this.value, slashCommandParam.value) && Intrinsics3.areEqual(this.valueColor, slashCommandParam.valueColor) && Intrinsics3.areEqual(this.copyText, slashCommandParam.copyText);
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
            StringBuilder sbU = outline.U("SlashCommandParam(name=");
            sbU.append(this.name);
            sbU.append(", value=");
            sbU.append(this.value);
            sbU.append(", valueColor=");
            sbU.append(this.valueColor);
            sbU.append(", copyText=");
            return outline.J(sbU, this.copyText, ")");
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
            Intrinsics3.checkNotNullParameter(set, "mentionedUsers");
            Intrinsics3.checkNotNullParameter(map3, "users");
            Intrinsics3.checkNotNullParameter(map4, "channels");
            Intrinsics3.checkNotNullParameter(map5, "commandValues");
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
            Intrinsics3.checkNotNullParameter(mentionedUsers, "mentionedUsers");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(commandValues, "commandValues");
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
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.interactionUser, storeState.interactionUser) && Intrinsics3.areEqual(this.interactionState, storeState.interactionState) && Intrinsics3.areEqual(this.application, storeState.application) && Intrinsics3.areEqual(this.mentionedUsers, storeState.mentionedUsers) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.guildRoles, storeState.guildRoles) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.commandValues, storeState.commandValues);
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
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", interactionUser=");
            sbU.append(this.interactionUser);
            sbU.append(", interactionState=");
            sbU.append(this.interactionState);
            sbU.append(", application=");
            sbU.append(this.application);
            sbU.append(", mentionedUsers=");
            sbU.append(this.mentionedUsers);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", commandValues=");
            return outline.M(sbU, this.commandValues, ")");
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
            Intrinsics3.checkNotNullParameter(set, "mentionedUserIds");
            Intrinsics3.checkNotNullParameter(map, "users");
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
            Intrinsics3.checkNotNullParameter(mentionedUserIds, "mentionedUserIds");
            Intrinsics3.checkNotNullParameter(users, "users");
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
            return Intrinsics3.areEqual(this.mentionedUserIds, userData.mentionedUserIds) && Intrinsics3.areEqual(this.users, userData.users);
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
            StringBuilder sbU = outline.U("UserData(mentionedUserIds=");
            sbU.append(this.mentionedUserIds);
            sbU.append(", users=");
            return outline.M(sbU, this.users, ")");
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
                Intrinsics3.checkNotNullParameter(applicationCommandData, "applicationCommandData");
                Intrinsics3.checkNotNullParameter(map4, "usernamesOrNicks");
                Intrinsics3.checkNotNullParameter(map5, "commandValues");
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
            ObservationDeck observationDeck = ObservationDeck4.get();
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
        if (Intrinsics3.areEqual(interactionState, StoreApplicationInteractions.State.Failure.INSTANCE)) {
            updateViewState(ViewState.Failed.INSTANCE);
            return;
        }
        if (Intrinsics3.areEqual(interactionState, StoreApplicationInteractions.State.Fetching.INSTANCE)) {
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
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.interactionId = j;
        this.messageId = j2;
        this.channelId = j3;
        this.guildId = l;
        this.interactionUserId = j4;
        this.applicationId = j5;
        this.messageNonce = str;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetApplicationCommandBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        requestInteractionData();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).G(new Func1<StoreState, UserData>() { // from class: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel.2
            @Override // j0.k.Func1
            public final UserData call(StoreState storeState) {
                return new UserData(storeState.getMentionedUsers(), storeState.getUsers());
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeObservable.computat…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) WidgetApplicationCommandBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }
}
