package com.discord.stores;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.BuildConfig;
import com.discord.api.activity.Activity;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipient;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.guild.Guild;
import com.discord.api.guildjoinrequest.GuildJoinRequestCreateOrUpdate;
import com.discord.api.guildjoinrequest.GuildJoinRequestDelete;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMemberRemove;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.interaction.InteractionStateUpdate;
import com.discord.api.message.Message;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.Presence;
import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.api.role.GuildRoleCreate;
import com.discord.api.role.GuildRoleDelete;
import com.discord.api.role.GuildRoleUpdate;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.gateway.GatewayEventHandler;
import com.discord.gateway.GatewaySocket;
import com.discord.gateway.p498io.OutgoingPayload;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.StreamCreateOrUpdate;
import com.discord.models.domain.StreamDelete;
import com.discord.models.domain.StreamServerUpdate;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreClientDataState;
import com.discord.stores.utilities.BatchManager;
import com.discord.stores.utilities.Batched;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.lazy.subscriptions.GuildSubscriptions;
import com.discord.utilities.logging.AppGatewaySocketLogger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import okhttp3.Interceptor;
import p007b.p008a.p018d.C0872k;
import p007b.p008a.p018d.C0874l;
import p007b.p008a.p020e.C0894d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p645c.C12698c;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Func5;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.SerializedSubject;
import p659s.p660a.C13160w0;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection implements GatewayEventHandler {
    private final SerializedSubject<ApplicationCommandAutocompleteResult, ApplicationCommandAutocompleteResult> applicationCommandAutocompleteResult;
    private final BatchManager batches;
    private final SerializedSubject<ModelCall, ModelCall> callCreateOrUpdate;
    private final SerializedSubject<ModelCall, ModelCall> callDelete;
    private final SerializedSubject<Channel, Channel> channelCreateOrUpdate;
    private final SerializedSubject<Channel, Channel> channelDeleted;
    private final SerializedSubject<ChannelRecipient, ChannelRecipient> channelRecipientAdd;
    private final SerializedSubject<ChannelRecipient, ChannelRecipient> channelRecipientRemove;
    private final SerializedSubject<ModelChannelUnreadUpdate, ModelChannelUnreadUpdate> channelUnreadUpdate;
    private ClientState clientState;
    private final Clock clock;
    private final SerializedSubject<Boolean, Boolean> connected;
    private final SerializedSubject<Boolean, Boolean> connectionReady;
    private final ExecutorCoroutineDispatcher coroutineDispatcher;
    private final SerializedSubject<EmbeddedActivityInboundUpdate, EmbeddedActivityInboundUpdate> embeddedActivityInboundUpdate;
    private final ExecutorService executor;
    private final SerializedSubject<ForumUnreads, ForumUnreads> forumUnreads;
    private final SerializedSubject<FriendSuggestion, FriendSuggestion> friendSuggestionCreate;
    private final SerializedSubject<FriendSuggestionDelete, FriendSuggestionDelete> friendSuggestionDelete;
    private final AppGatewaySocketLogger gatewaySocketLogger;
    private final SerializedSubject<GuildApplicationCommands, GuildApplicationCommands> guildApplicationCommands;
    private final SerializedSubject<ModelBan, ModelBan> guildBanAdd;
    private final SerializedSubject<ModelBan, ModelBan> guildBanRemove;
    private final SerializedSubject<Guild, Guild> guildCreate;
    private final SerializedSubject<Guild, Guild> guildDeleted;
    private final SerializedSubject<GuildEmojisUpdate, GuildEmojisUpdate> guildEmojisUpdate;
    private final SerializedSubject<ModelGuildIntegration.Update, ModelGuildIntegration.Update> guildIntegrationsUpdate;
    private final SerializedSubject<GuildJoinRequestCreateOrUpdate, GuildJoinRequestCreateOrUpdate> guildJoinRequestCreateOrUpdate;
    private final SerializedSubject<GuildJoinRequestDelete, GuildJoinRequestDelete> guildJoinRequestDelete;
    private final SerializedSubject<ModelGuildMemberListUpdate, ModelGuildMemberListUpdate> guildMemberListUpdate;
    private final SerializedSubject<GuildMemberRemove, GuildMemberRemove> guildMemberRemove;
    private final SerializedSubject<GuildMember, GuildMember> guildMembersAdd;
    private final SerializedSubject<GuildMembersChunk, GuildMembersChunk> guildMembersChunk;
    private final SerializedSubject<GuildRoleCreate, GuildRoleCreate> guildRoleCreate;
    private final SerializedSubject<GuildRoleDelete, GuildRoleDelete> guildRoleDelete;
    private final SerializedSubject<GuildRoleUpdate, GuildRoleUpdate> guildRoleUpdate;
    private final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> guildScheduledEventCreate;
    private final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> guildScheduledEventDelete;
    private final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> guildScheduledEventUpdate;
    private final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> guildScheduledEventUserAdd;
    private final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> guildScheduledEventUserRemove;
    private final SerializedSubject<GuildStickersUpdate, GuildStickersUpdate> guildStickersUpdate;
    private final SerializedSubject<Guild, Guild> guildUpdate;
    private final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> interactionCreate;
    private final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> interactionFailure;
    private final SerializedSubject<InteractionModalCreate, InteractionModalCreate> interactionModalCreate;
    private final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> interactionSuccess;
    private final SerializedSubject<ModelReadState, ModelReadState> messageAck;
    private final SerializedSubject<Message, Message> messageCreate;
    private final SerializedSubject<ModelMessageDelete, ModelMessageDelete> messageDelete;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionAdd;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionRemove;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionRemoveAll;
    private final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> messageReactionRemoveEmoji;
    private final SerializedSubject<Message, Message> messageUpdate;
    private final SerializedSubject<List<Presence>, List<Presence>> presenceReplace;
    private final SerializedSubject<Presence, Presence> presenceUpdate;
    private final SerializedSubject<ModelPayload, ModelPayload> ready;
    private final SerializedSubject<ModelUserRelationship, ModelUserRelationship> relationshipAdd;
    private final SerializedSubject<ModelUserRelationship, ModelUserRelationship> relationshipRemove;
    private final Scheduler scheduler;
    private final SerializedSubject<List<ModelSession>, List<ModelSession>> sessionsReplace;
    private GatewaySocket socket;
    private final SerializedSubject<StageInstance, StageInstance> stageInstanceCreate;
    private final SerializedSubject<StageInstance, StageInstance> stageInstanceDelete;
    private final SerializedSubject<StageInstance, StageInstance> stageInstanceUpdate;
    private final StoreStream stream;
    private final SerializedSubject<StreamCreateOrUpdate, StreamCreateOrUpdate> streamCreate;
    private final SerializedSubject<StreamDelete, StreamDelete> streamDelete;
    private final SerializedSubject<StreamServerUpdate, StreamServerUpdate> streamServerUpdate;
    private final SerializedSubject<StreamCreateOrUpdate, StreamCreateOrUpdate> streamUpdate;
    private final SerializedSubject<Channel, Channel> threadCreateOrUpdate;
    private final SerializedSubject<Channel, Channel> threadDelete;
    private final SerializedSubject<ModelThreadListSync, ModelThreadListSync> threadListSync;
    private final SerializedSubject<ThreadMemberListUpdate, ThreadMemberListUpdate> threadMemberListUpdate;
    private final SerializedSubject<ThreadMemberUpdate, ThreadMemberUpdate> threadMemberUpdate;
    private final SerializedSubject<ThreadMembersUpdate, ThreadMembersUpdate> threadMembersUpdate;
    private final SerializedSubject<TypingUser, TypingUser> typingStart;
    private final SerializedSubject<Unit, Unit> userConnectionUpdate;
    private final SerializedSubject<ModelNotificationSettings, ModelNotificationSettings> userGuildSettingsUpdate;
    private final SerializedSubject<ModelUserNote.Update, ModelUserNote.Update> userNoteUpdate;
    private final SerializedSubject<Unit, Unit> userPaymentSourcesUpdate;
    private final SerializedSubject<UserRequiredActionUpdate, UserRequiredActionUpdate> userRequiredActionUpdate;
    private final SerializedSubject<ModelUserSettings, ModelUserSettings> userSettingsUpdate;
    private final SerializedSubject<Unit, Unit> userSubscriptionsUpdate;
    private final SerializedSubject<User, User> userUpdate;
    private final SerializedSubject<VoiceServer, VoiceServer> voiceServerUpdate;
    private final Batched<VoiceState> voiceStateUpdate;

    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final /* data */ class ClientState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean authed;
        private final StoreClientDataState.ClientDataState clientDataState;
        private final String tokenIfAvailable;

        /* JADX INFO: compiled from: StoreGatewayConnection.kt */
        public static final class Companion {
            private Companion() {
            }

            private final ClientState create(boolean backgrounded, String token, long selectedVoiceChannelId, boolean hasGatewayConnectionConsumers, StoreClientDataState.ClientDataState clientDataState) {
                boolean z2 = token != null;
                if (backgrounded && selectedVoiceChannelId <= 0 && !hasGatewayConnectionConsumers) {
                    token = null;
                }
                return new ClientState(token, z2, clientDataState);
            }

            public final void initialize(StoreStream stream, Scheduler scheduler, Function1<? super ClientState, Unit> callback) {
                C12238m.checkNotNullParameter(stream, "stream");
                C12238m.checkNotNullParameter(scheduler, "scheduler");
                C12238m.checkNotNullParameter(callback, "callback");
                Observable<Boolean> observableM185a = C0894d.f600d.m185a();
                Observable<String> authedToken$app_productionGoogleRelease = stream.getAuthentication().getAuthedToken$app_productionGoogleRelease();
                Observable<Long> observableObserveSelectedVoiceChannelId = stream.getVoiceChannelSelected().observeSelectedVoiceChannelId();
                C0874l c0874l = C0874l.f530c;
                Observable observableM11112r = C0874l.f529b.m11083G(C0872k.f526j).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "numGatewayConnectionCons…  .distinctUntilChanged()");
                Observable<StoreClientDataState.ClientDataState> observableObserveClientState = stream.getClientDataState().observeClientState();
                final StoreGatewayConnection$ClientState$Companion$initialize$1 storeGatewayConnection$ClientState$Companion$initialize$1 = new StoreGatewayConnection$ClientState$Companion$initialize$1(this);
                Observable observableM11072g = Observable.m11072g(observableM185a, authedToken$app_productionGoogleRelease, observableObserveSelectedVoiceChannelId, observableM11112r, observableObserveClientState, new Func5() { // from class: com.discord.stores.StoreGatewayConnection$sam$rx_functions_Func5$0
                    @Override // p658rx.functions.Func5
                    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                        return storeGatewayConnection$ClientState$Companion$initialize$1.invoke(obj, obj2, obj3, obj4, obj5);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11072g, "Observable\n            .…   ::create\n            )");
                Observable observableM11084J = ObservableExtensionsKt.computationLatest(observableM11072g).m11084J(scheduler);
                C12238m.checkNotNullExpressionValue(observableM11084J, "Observable\n            .…    .observeOn(scheduler)");
                ObservableExtensionsKt.appSubscribe(observableM11084J, (117 & 1) != 0 ? null : null, "clientState", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), callback, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ClientState(String str, boolean z2, StoreClientDataState.ClientDataState clientDataState) {
            C12238m.checkNotNullParameter(clientDataState, "clientDataState");
            this.tokenIfAvailable = str;
            this.authed = z2;
            this.clientDataState = clientDataState;
        }

        public static /* synthetic */ ClientState copy$default(ClientState clientState, String str, boolean z2, StoreClientDataState.ClientDataState clientDataState, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clientState.tokenIfAvailable;
            }
            if ((i & 2) != 0) {
                z2 = clientState.authed;
            }
            if ((i & 4) != 0) {
                clientDataState = clientState.clientDataState;
            }
            return clientState.copy(str, z2, clientDataState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTokenIfAvailable() {
            return this.tokenIfAvailable;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getAuthed() {
            return this.authed;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreClientDataState.ClientDataState getClientDataState() {
            return this.clientDataState;
        }

        public final ClientState copy(String tokenIfAvailable, boolean authed, StoreClientDataState.ClientDataState clientDataState) {
            C12238m.checkNotNullParameter(clientDataState, "clientDataState");
            return new ClientState(tokenIfAvailable, authed, clientDataState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientState)) {
                return false;
            }
            ClientState clientState = (ClientState) other;
            return C12238m.areEqual(this.tokenIfAvailable, clientState.tokenIfAvailable) && this.authed == clientState.authed && C12238m.areEqual(this.clientDataState, clientState.clientDataState);
        }

        public final boolean getAuthed() {
            return this.authed;
        }

        public final StoreClientDataState.ClientDataState getClientDataState() {
            return this.clientDataState;
        }

        public final GatewaySocket.IdentifyData getIdentifyData() {
            String str = this.tokenIfAvailable;
            if (str != null) {
                return new GatewaySocket.IdentifyData(str, this.clientDataState.toIdentifyData());
            }
            return null;
        }

        public final String getTokenIfAvailable() {
            return this.tokenIfAvailable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            String str = this.tokenIfAvailable;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.authed;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            StoreClientDataState.ClientDataState clientDataState = this.clientDataState;
            return i + (clientDataState != null ? clientDataState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ClientState(tokenIfAvailable=");
            sbM833U.append(this.tokenIfAvailable);
            sbM833U.append(", authed=");
            sbM833U.append(this.authed);
            sbM833U.append(", clientDataState=");
            sbM833U.append(this.clientDataState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$callConnect$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59431 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59431(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.callConnect(this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$init$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59441 extends AbstractC12240o implements Function1<ClientState, Unit> {
        public C59441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClientState clientState) {
            invoke2(clientState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClientState clientState) {
            C12238m.checkNotNullParameter(clientState, "it");
            StoreGatewayConnection.this.handleClientStateUpdate(clientState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$presenceUpdate$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59451 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ List $activities;
        public final /* synthetic */ Boolean $afk;
        public final /* synthetic */ Long $since;
        public final /* synthetic */ ClientStatus $status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59451(ClientStatus clientStatus, Long l, List list, Boolean bool) {
            super(1);
            this.$status = clientStatus;
            this.$since = l;
            this.$activities = list;
            this.$afk = bool;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.presenceUpdate(this.$status, this.$since, this.$activities, this.$afk);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$requestApplicationCommands$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59461 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ boolean $applications;
        public final /* synthetic */ List $commandIds;
        public final /* synthetic */ int $commandLimit;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ String $nonce;
        public final /* synthetic */ Integer $offset;
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59461(long j, String str, boolean z2, Integer num, String str2, int i, List list) {
            super(1);
            this.$guildId = j;
            this.$nonce = str;
            this.$applications = z2;
            this.$offset = num;
            this.$query = str2;
            this.$commandLimit = i;
            this.$commandIds = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            long j = this.$guildId;
            String str = this.$nonce;
            boolean z2 = this.$applications;
            gatewaySocket.requestApplicationCommands(new OutgoingPayload.ApplicationCommandRequest(j, this.$query, this.$offset, Integer.valueOf(this.$commandLimit), z2, str, this.$commandIds));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$requestForumUnreads$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59471 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $threadMessagePairs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59471(long j, long j2, List list) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$threadMessagePairs = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            long j = this.$guildId;
            long j2 = this.$channelId;
            List<Pair> list = this.$threadMessagePairs;
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            for (Pair pair : list) {
                arrayList.add(new OutgoingPayload.ForumUnreadsRequestThread(((Number) pair.component1()).longValue(), ((Number) pair.component2()).longValue()));
            }
            gatewaySocket.requestForumUnreads(new OutgoingPayload.ForumUnreadsRequest(j, j2, arrayList));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$requestGuildMembers$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59481 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Integer $limit;
        public final /* synthetic */ String $query;
        public final /* synthetic */ List $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59481(long j, String str, List list, Integer num) {
            super(1);
            this.$guildId = j;
            this.$query = str;
            this.$userIds = list;
            this.$limit = num;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.requestGuildMembers(C12145m.listOf(Long.valueOf(this.$guildId)), this.$query, this.$userIds, this.$limit);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$streamCreate$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59491 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ ModelApplicationStream $newStream;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59491(String str, ModelApplicationStream modelApplicationStream, String str2) {
            super(1);
            this.$streamKey = str;
            this.$newStream = modelApplicationStream;
            this.$preferredRegion = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
            String strM8507xb25617db = StoreGatewayConnection.this.stream.getApplicationStreaming().m8507xb25617db();
            if (strM8507xb25617db != null && (!C12238m.areEqual(strM8507xb25617db, this.$streamKey))) {
                StoreGatewayConnection.this.streamDelete(strM8507xb25617db);
            }
            ModelApplicationStream modelApplicationStream = this.$newStream;
            gatewaySocket.streamCreate(this.$newStream.getType(), this.$newStream.getChannelId(), modelApplicationStream instanceof ModelApplicationStream.GuildStream ? Long.valueOf(((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId()) : null, this.$preferredRegion);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$streamDelete$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59501 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59501(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.streamDelete(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$streamPing$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59511 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59511(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.streamPing(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$streamWatch$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59521 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59521(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            String strM8507xb25617db = StoreGatewayConnection.this.stream.getApplicationStreaming().m8507xb25617db();
            if (strM8507xb25617db != null && (!C12238m.areEqual(strM8507xb25617db, this.$streamKey))) {
                StoreGatewayConnection.this.streamDelete(strM8507xb25617db);
            }
            gatewaySocket.streamWatch(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$updateGuildSubscriptions$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59531 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ OutgoingPayload.GuildSubscriptions $payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59531(long j, OutgoingPayload.GuildSubscriptions guildSubscriptions) {
            super(1);
            this.$guildId = j;
            this.$payload = guildSubscriptions;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.updateGuildSubscriptions(this.$guildId, this.$payload);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$voiceServerPing$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59541 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public static final C59541 INSTANCE = new C59541();

        public C59541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.voiceServerPing();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$voiceStateUpdate$1 */
    /* JADX INFO: compiled from: StoreGatewayConnection.kt */
    public static final class C59551 extends AbstractC12240o implements Function1<GatewaySocket, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ boolean $selfDeaf;
        public final /* synthetic */ boolean $selfMute;
        public final /* synthetic */ boolean $selfVideo;
        public final /* synthetic */ boolean $shouldIncludePreferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59551(Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, boolean z5) {
            super(1);
            this.$guildId = l;
            this.$channelId = l2;
            this.$selfMute = z2;
            this.$selfDeaf = z3;
            this.$selfVideo = z4;
            this.$preferredRegion = str;
            this.$shouldIncludePreferredRegion = z5;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GatewaySocket gatewaySocket) {
            invoke2(gatewaySocket);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GatewaySocket gatewaySocket) {
            C12238m.checkNotNullParameter(gatewaySocket, "it");
            gatewaySocket.voiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion, this.$shouldIncludePreferredRegion);
        }
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, AppGatewaySocketLogger appGatewaySocketLogger) {
        this(storeStream, clock, null, null, appGatewaySocketLogger, 12, null);
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, AppGatewaySocketLogger appGatewaySocketLogger) {
        this(storeStream, clock, executorService, null, appGatewaySocketLogger, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, Scheduler scheduler, AppGatewaySocketLogger appGatewaySocketLogger) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(executorService, "executor");
        C12238m.checkNotNullParameter(scheduler, "scheduler");
        C12238m.checkNotNullParameter(appGatewaySocketLogger, "gatewaySocketLogger");
        this.stream = storeStream;
        this.clock = clock;
        this.executor = executorService;
        this.scheduler = scheduler;
        this.gatewaySocketLogger = appGatewaySocketLogger;
        C13160w0 c13160w0 = new C13160w0(executorService);
        this.coroutineDispatcher = c13160w0;
        BatchManager batchManager = new BatchManager(c13160w0, null, 2, 0 == true ? 1 : 0);
        this.batches = batchManager;
        Boolean bool = Boolean.FALSE;
        this.connected = new SerializedSubject<>(BehaviorSubject.m11130l0(bool));
        this.connectionReady = new SerializedSubject<>(BehaviorSubject.m11130l0(bool));
        this.callCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.callDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.channelCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.channelDeleted = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.channelRecipientAdd = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.channelRecipientRemove = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.channelUnreadUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.embeddedActivityInboundUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildApplicationCommands = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildBanAdd = new SerializedSubject<>(PublishSubject.m11133k0());
        this.guildBanRemove = new SerializedSubject<>(PublishSubject.m11133k0());
        this.guildCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildEmojisUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildStickersUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildDeleted = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildMembersAdd = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildMembersChunk = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildMemberRemove = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildJoinRequestCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildJoinRequestDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildRoleCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildRoleUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildRoleDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildIntegrationsUpdate = new SerializedSubject<>(PublishSubject.m11133k0());
        this.messageAck = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageReactionAdd = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageReactionRemove = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageReactionRemoveEmoji = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.messageReactionRemoveAll = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.presenceUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.presenceReplace = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.ready = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.relationshipAdd = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.relationshipRemove = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.typingStart = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userConnectionUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userSettingsUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userGuildSettingsUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userNoteUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userRequiredActionUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.sessionsReplace = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.voiceStateUpdate = BatchManager.createBatched$default(batchManager, "VOICE_STATE_UPDATE", 0L, 0L, 6, null);
        this.voiceServerUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildMemberListUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userPaymentSourcesUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.userSubscriptionsUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.streamCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.streamUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.streamServerUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.streamDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.threadCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.threadDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.threadListSync = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.threadMemberUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.threadMembersUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.threadMemberListUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.interactionCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.interactionSuccess = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.interactionFailure = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.interactionModalCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.applicationCommandAutocompleteResult = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.stageInstanceCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.stageInstanceUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.stageInstanceDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.friendSuggestionCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.friendSuggestionDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildScheduledEventCreate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildScheduledEventUpdate = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildScheduledEventDelete = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildScheduledEventUserAdd = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.guildScheduledEventUserRemove = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.forumUnreads = new SerializedSubject<>(BehaviorSubject.m11129k0());
    }

    private final GatewaySocket buildGatewaySocket(Context context, NetworkMonitor networkMonitor) {
        RestAPI.Companion companion = RestAPI.INSTANCE;
        List listListOf = C12147n.listOf((Object[]) new Interceptor[]{companion.buildAnalyticsInterceptor(), companion.buildLoggingInterceptor()});
        App.Companion companion2 = App.INSTANCE;
        Objects.requireNonNull(companion2);
        SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = App.IS_LOCAL ? null : SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
        Objects.requireNonNull(companion2);
        GatewaySocket gatewaySocket = new GatewaySocket(new StoreGatewayConnection$buildGatewaySocket$socket$1(this), StoreGatewayConnection$buildGatewaySocket$socket$2.INSTANCE, this, this.scheduler, AppLog.f14950g, networkMonitor, new RestConfig(BuildConfig.HOST_API, RestAPI.AppHeadersProvider.INSTANCE, listListOf), context, App.IS_LOCAL ? StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1.INSTANCE : null, sSLSocketFactoryCreateSocketFactory$default, AnalyticSuperProperties.INSTANCE.getSuperProperties(), this.gatewaySocketLogger);
        this.stream.getConnectionTimeStats().addListener(gatewaySocket);
        return gatewaySocket;
    }

    private final GatewaySocket.IdentifyData getIdentifyData() {
        ClientState clientState = this.clientState;
        if (clientState != null) {
            return clientState.getIdentifyData();
        }
        return null;
    }

    private final void handleClientStateUpdate(ClientState clientState) {
        this.clientState = clientState;
        if (clientState.getTokenIfAvailable() != null) {
            GatewaySocket gatewaySocket = this.socket;
            if (gatewaySocket != null) {
                gatewaySocket.connect();
                return;
            }
            return;
        }
        GatewaySocket gatewaySocket2 = this.socket;
        if (gatewaySocket2 != null) {
            gatewaySocket2.close(!clientState.getAuthed());
        }
    }

    private final <T> void onNext(SerializedSubject<T, T> serializedSubject, Object obj) {
        serializedSubject.f27653k.onNext(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean presenceUpdate$default(StoreGatewayConnection storeGatewayConnection, ClientStatus clientStatus, Long l, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            l = Long.valueOf(storeGatewayConnection.clock.currentTimeMillis());
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        return storeGatewayConnection.presenceUpdate(clientStatus, l, list, bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean requestGuildMembers$default(StoreGatewayConnection storeGatewayConnection, long j, String str, List list, Integer num, int i, Object obj) {
        String str2 = (i & 2) != 0 ? null : str;
        List list2 = (i & 4) != 0 ? null : list;
        if ((i & 8) != 0) {
            num = 100;
        }
        return storeGatewayConnection.requestGuildMembers(j, str2, list2, num);
    }

    private final boolean requestIfSessionEstablished(Function1<? super GatewaySocket, Unit> socketCallback) {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket == null) {
            return false;
        }
        boolean zIsSessionEstablished = gatewaySocket.isSessionEstablished();
        if (zIsSessionEstablished) {
            socketCallback.invoke(gatewaySocket);
        }
        return zIsSessionEstablished;
    }

    private final void streamPing(String streamKey) {
        requestIfSessionEstablished(new C59511(streamKey));
    }

    private final void voiceServerPing() {
        requestIfSessionEstablished(C59541.INSTANCE);
    }

    public static /* synthetic */ boolean voiceStateUpdate$default(StoreGatewayConnection storeGatewayConnection, Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, boolean z5, int i, Object obj) {
        return storeGatewayConnection.voiceStateUpdate(l, l2, z2, z3, z4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? true : z5);
    }

    public final boolean callConnect(long channelId) {
        return requestIfSessionEstablished(new C59431(channelId));
    }

    public final SerializedSubject<ApplicationCommandAutocompleteResult, ApplicationCommandAutocompleteResult> getApplicationCommandAutocompleteResult() {
        return this.applicationCommandAutocompleteResult;
    }

    public final SerializedSubject<ModelCall, ModelCall> getCallCreateOrUpdate() {
        return this.callCreateOrUpdate;
    }

    public final SerializedSubject<ModelCall, ModelCall> getCallDelete() {
        return this.callDelete;
    }

    public final SerializedSubject<Channel, Channel> getChannelCreateOrUpdate() {
        return this.channelCreateOrUpdate;
    }

    public final SerializedSubject<Channel, Channel> getChannelDeleted() {
        return this.channelDeleted;
    }

    public final SerializedSubject<ChannelRecipient, ChannelRecipient> getChannelRecipientAdd() {
        return this.channelRecipientAdd;
    }

    public final SerializedSubject<ChannelRecipient, ChannelRecipient> getChannelRecipientRemove() {
        return this.channelRecipientRemove;
    }

    public final SerializedSubject<ModelChannelUnreadUpdate, ModelChannelUnreadUpdate> getChannelUnreadUpdate() {
        return this.channelUnreadUpdate;
    }

    public final Observable<Boolean> getConnected() {
        Observable<Boolean> observableM11112r = this.connected.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "connected.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> getConnectionReady() {
        Observable<Boolean> observableM11112r = this.connectionReady.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "connectionReady.distinctUntilChanged()");
        return observableM11112r;
    }

    public final ExecutorCoroutineDispatcher getCoroutineDispatcher() {
        return this.coroutineDispatcher;
    }

    public final SerializedSubject<EmbeddedActivityInboundUpdate, EmbeddedActivityInboundUpdate> getEmbeddedActivityInboundUpdate() {
        return this.embeddedActivityInboundUpdate;
    }

    public final SerializedSubject<ForumUnreads, ForumUnreads> getForumUnreads() {
        return this.forumUnreads;
    }

    public final SerializedSubject<FriendSuggestion, FriendSuggestion> getFriendSuggestionCreate() {
        return this.friendSuggestionCreate;
    }

    public final SerializedSubject<FriendSuggestionDelete, FriendSuggestionDelete> getFriendSuggestionDelete() {
        return this.friendSuggestionDelete;
    }

    public final SerializedSubject<GuildApplicationCommands, GuildApplicationCommands> getGuildApplicationCommands() {
        return this.guildApplicationCommands;
    }

    public final SerializedSubject<ModelBan, ModelBan> getGuildBanAdd() {
        return this.guildBanAdd;
    }

    public final SerializedSubject<ModelBan, ModelBan> getGuildBanRemove() {
        return this.guildBanRemove;
    }

    public final SerializedSubject<Guild, Guild> getGuildCreate() {
        return this.guildCreate;
    }

    public final SerializedSubject<Guild, Guild> getGuildDeleted() {
        return this.guildDeleted;
    }

    public final SerializedSubject<GuildEmojisUpdate, GuildEmojisUpdate> getGuildEmojisUpdate() {
        return this.guildEmojisUpdate;
    }

    public final SerializedSubject<ModelGuildIntegration.Update, ModelGuildIntegration.Update> getGuildIntegrationsUpdate() {
        return this.guildIntegrationsUpdate;
    }

    public final SerializedSubject<GuildJoinRequestCreateOrUpdate, GuildJoinRequestCreateOrUpdate> getGuildJoinRequestCreateOrUpdate() {
        return this.guildJoinRequestCreateOrUpdate;
    }

    public final SerializedSubject<GuildJoinRequestDelete, GuildJoinRequestDelete> getGuildJoinRequestDelete() {
        return this.guildJoinRequestDelete;
    }

    public final SerializedSubject<ModelGuildMemberListUpdate, ModelGuildMemberListUpdate> getGuildMemberListUpdate() {
        return this.guildMemberListUpdate;
    }

    public final SerializedSubject<GuildMemberRemove, GuildMemberRemove> getGuildMemberRemove() {
        return this.guildMemberRemove;
    }

    public final SerializedSubject<GuildMember, GuildMember> getGuildMembersAdd() {
        return this.guildMembersAdd;
    }

    public final SerializedSubject<GuildMembersChunk, GuildMembersChunk> getGuildMembersChunk() {
        return this.guildMembersChunk;
    }

    public final SerializedSubject<GuildRoleCreate, GuildRoleCreate> getGuildRoleCreate() {
        return this.guildRoleCreate;
    }

    public final SerializedSubject<GuildRoleDelete, GuildRoleDelete> getGuildRoleDelete() {
        return this.guildRoleDelete;
    }

    public final SerializedSubject<GuildRoleUpdate, GuildRoleUpdate> getGuildRoleUpdate() {
        return this.guildRoleUpdate;
    }

    public final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> getGuildScheduledEventCreate() {
        return this.guildScheduledEventCreate;
    }

    public final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> getGuildScheduledEventDelete() {
        return this.guildScheduledEventDelete;
    }

    public final SerializedSubject<GuildScheduledEvent, GuildScheduledEvent> getGuildScheduledEventUpdate() {
        return this.guildScheduledEventUpdate;
    }

    public final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> getGuildScheduledEventUserAdd() {
        return this.guildScheduledEventUserAdd;
    }

    public final SerializedSubject<GuildScheduledEventUserUpdate, GuildScheduledEventUserUpdate> getGuildScheduledEventUserRemove() {
        return this.guildScheduledEventUserRemove;
    }

    public final SerializedSubject<GuildStickersUpdate, GuildStickersUpdate> getGuildStickersUpdate() {
        return this.guildStickersUpdate;
    }

    public final SerializedSubject<Guild, Guild> getGuildUpdate() {
        return this.guildUpdate;
    }

    public final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> getInteractionCreate() {
        return this.interactionCreate;
    }

    public final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> getInteractionFailure() {
        return this.interactionFailure;
    }

    public final SerializedSubject<InteractionModalCreate, InteractionModalCreate> getInteractionModalCreate() {
        return this.interactionModalCreate;
    }

    public final SerializedSubject<InteractionStateUpdate, InteractionStateUpdate> getInteractionSuccess() {
        return this.interactionSuccess;
    }

    public final SerializedSubject<ModelReadState, ModelReadState> getMessageAck() {
        return this.messageAck;
    }

    public final SerializedSubject<Message, Message> getMessageCreate() {
        return this.messageCreate;
    }

    public final SerializedSubject<ModelMessageDelete, ModelMessageDelete> getMessageDelete() {
        return this.messageDelete;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionAdd() {
        return this.messageReactionAdd;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionRemove() {
        return this.messageReactionRemove;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionRemoveAll() {
        return this.messageReactionRemoveAll;
    }

    public final SerializedSubject<MessageReactionUpdate, MessageReactionUpdate> getMessageReactionRemoveEmoji() {
        return this.messageReactionRemoveEmoji;
    }

    public final SerializedSubject<Message, Message> getMessageUpdate() {
        return this.messageUpdate;
    }

    public final SerializedSubject<List<Presence>, List<Presence>> getPresenceReplace() {
        return this.presenceReplace;
    }

    public final SerializedSubject<Presence, Presence> getPresenceUpdate() {
        return this.presenceUpdate;
    }

    public final SerializedSubject<ModelPayload, ModelPayload> getReady() {
        return this.ready;
    }

    public final SerializedSubject<ModelUserRelationship, ModelUserRelationship> getRelationshipAdd() {
        return this.relationshipAdd;
    }

    public final SerializedSubject<ModelUserRelationship, ModelUserRelationship> getRelationshipRemove() {
        return this.relationshipRemove;
    }

    public final SerializedSubject<List<ModelSession>, List<ModelSession>> getSessionsReplace() {
        return this.sessionsReplace;
    }

    public final SerializedSubject<StageInstance, StageInstance> getStageInstanceCreate() {
        return this.stageInstanceCreate;
    }

    public final SerializedSubject<StageInstance, StageInstance> getStageInstanceDelete() {
        return this.stageInstanceDelete;
    }

    public final SerializedSubject<StageInstance, StageInstance> getStageInstanceUpdate() {
        return this.stageInstanceUpdate;
    }

    public final SerializedSubject<StreamCreateOrUpdate, StreamCreateOrUpdate> getStreamCreate() {
        return this.streamCreate;
    }

    public final SerializedSubject<StreamDelete, StreamDelete> getStreamDelete() {
        return this.streamDelete;
    }

    public final SerializedSubject<StreamServerUpdate, StreamServerUpdate> getStreamServerUpdate() {
        return this.streamServerUpdate;
    }

    public final SerializedSubject<StreamCreateOrUpdate, StreamCreateOrUpdate> getStreamUpdate() {
        return this.streamUpdate;
    }

    public final SerializedSubject<Channel, Channel> getThreadCreateOrUpdate() {
        return this.threadCreateOrUpdate;
    }

    public final SerializedSubject<Channel, Channel> getThreadDelete() {
        return this.threadDelete;
    }

    public final SerializedSubject<ModelThreadListSync, ModelThreadListSync> getThreadListSync() {
        return this.threadListSync;
    }

    public final SerializedSubject<ThreadMemberListUpdate, ThreadMemberListUpdate> getThreadMemberListUpdate() {
        return this.threadMemberListUpdate;
    }

    public final SerializedSubject<ThreadMemberUpdate, ThreadMemberUpdate> getThreadMemberUpdate() {
        return this.threadMemberUpdate;
    }

    public final SerializedSubject<ThreadMembersUpdate, ThreadMembersUpdate> getThreadMembersUpdate() {
        return this.threadMembersUpdate;
    }

    public final SerializedSubject<TypingUser, TypingUser> getTypingStart() {
        return this.typingStart;
    }

    public final SerializedSubject<Unit, Unit> getUserConnectionUpdate() {
        return this.userConnectionUpdate;
    }

    public final SerializedSubject<ModelNotificationSettings, ModelNotificationSettings> getUserGuildSettingsUpdate() {
        return this.userGuildSettingsUpdate;
    }

    public final SerializedSubject<ModelUserNote.Update, ModelUserNote.Update> getUserNoteUpdate() {
        return this.userNoteUpdate;
    }

    public final SerializedSubject<Unit, Unit> getUserPaymentSourcesUpdate() {
        return this.userPaymentSourcesUpdate;
    }

    public final SerializedSubject<UserRequiredActionUpdate, UserRequiredActionUpdate> getUserRequiredActionUpdate() {
        return this.userRequiredActionUpdate;
    }

    public final SerializedSubject<ModelUserSettings, ModelUserSettings> getUserSettingsUpdate() {
        return this.userSettingsUpdate;
    }

    public final SerializedSubject<Unit, Unit> getUserSubscriptionsUpdate() {
        return this.userSubscriptionsUpdate;
    }

    public final SerializedSubject<User, User> getUserUpdate() {
        return this.userUpdate;
    }

    public final SerializedSubject<VoiceServer, VoiceServer> getVoiceServerUpdate() {
        return this.voiceServerUpdate;
    }

    public final Batched<VoiceState> getVoiceStateUpdate() {
        return this.voiceStateUpdate;
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleConnected(boolean connected) {
        SerializedSubject<Boolean, Boolean> serializedSubject = this.connected;
        serializedSubject.f27653k.onNext(Boolean.valueOf(connected));
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleConnectionReady(boolean connectionReady) {
        SerializedSubject<Boolean, Boolean> serializedSubject = this.connectionReady;
        serializedSubject.f27653k.onNext(Boolean.valueOf(connectionReady));
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleDisconnect(boolean authenticationFailed) {
        if (authenticationFailed) {
            this.stream.getAuthentication().logout();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.discord.gateway.GatewayEventHandler
    public void handleDispatch(String type, Object data) {
        C12238m.checkNotNullParameter(data, "data");
        this.batches.flushBatches(type);
        if (type == null) {
            return;
        }
        switch (type.hashCode()) {
            case -2137365335:
                if (type.equals("MESSAGE_REACTION_REMOVE_EMOJI")) {
                    this.messageReactionRemoveEmoji.f27653k.onNext(data);
                }
                break;
            case -2067017195:
                if (!type.equals("GUILD_JOIN_REQUEST_CREATE")) {
                }
                this.guildJoinRequestCreateOrUpdate.f27653k.onNext(data);
                break;
            case -2050181436:
                if (type.equals("GUILD_JOIN_REQUEST_DELETE")) {
                    this.guildJoinRequestDelete.f27653k.onNext(data);
                }
                break;
            case -2026522382:
                if (type.equals("SESSIONS_REPLACE")) {
                    this.sessionsReplace.f27653k.onNext(data);
                }
                break;
            case -2002723137:
                if (type.equals("GUILD_SCHEDULED_EVENT_CREATE")) {
                    this.guildScheduledEventCreate.f27653k.onNext(data);
                }
                break;
            case -1985887378:
                if (type.equals("GUILD_SCHEDULED_EVENT_DELETE")) {
                    this.guildScheduledEventDelete.f27653k.onNext(data);
                }
                break;
            case -1967037287:
                if (type.equals("THREAD_MEMBER_UPDATE")) {
                    this.threadMemberUpdate.f27653k.onNext(data);
                }
                break;
            case -1921449515:
                if (type.equals("APPLICATION_COMMAND_AUTOCOMPLETE_RESPONSE")) {
                    this.applicationCommandAutocompleteResult.f27653k.onNext(data);
                }
                break;
            case -1862771270:
                if (type.equals("THREAD_MEMBER_LIST_UPDATE")) {
                    this.threadMemberListUpdate.f27653k.onNext(data);
                }
                break;
            case -1825641445:
                if (type.equals("GUILD_MEMBERS_CHUNK")) {
                    this.guildMembersChunk.f27653k.onNext(data);
                }
                break;
            case -1580624828:
                if (type.equals("EMBEDDED_ACTIVITY_UPDATE")) {
                    this.embeddedActivityInboundUpdate.f27653k.onNext(data);
                }
                break;
            case -1553569310:
                if (!type.equals("GUILD_JOIN_REQUEST_UPDATE")) {
                }
                this.guildJoinRequestCreateOrUpdate.f27653k.onNext(data);
                break;
            case -1553064252:
                if (type.equals("MESSAGE_REACTION_REMOVE_ALL")) {
                    this.messageReactionRemoveAll.f27653k.onNext(data);
                }
                break;
            case -1533134522:
                if (type.equals("FORUM_UNREADS")) {
                    this.forumUnreads.f27653k.onNext(data);
                }
                break;
            case -1489275252:
                if (type.equals(NotificationData.TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    this.guildScheduledEventUpdate.f27653k.onNext(data);
                }
                break;
            case -1484942443:
                if (type.equals("GUILD_SCHEDULED_EVENT_USER_REMOVE")) {
                    this.guildScheduledEventUserRemove.f27653k.onNext(data);
                }
                break;
            case -1467383482:
                if (type.equals("USER_REQUIRED_ACTION_UPDATE")) {
                    this.userRequiredActionUpdate.f27653k.onNext(data);
                }
                break;
            case -1446088218:
                if (type.equals("GUILD_STICKERS_UPDATE")) {
                    this.guildStickersUpdate.f27653k.onNext(data);
                }
                break;
            case -1327124998:
                if (type.equals(NotificationData.TYPE_RELATIONSHIP_ADD)) {
                    this.relationshipAdd.f27653k.onNext(data);
                }
                break;
            case -1263316859:
                if (type.equals(NotificationData.TYPE_STAGE_INSTANCE_CREATE)) {
                    this.stageInstanceCreate.f27653k.onNext(data);
                }
                break;
            case -1261304891:
                if (type.equals("GUILD_BAN_ADD")) {
                    this.guildBanAdd.f27653k.onNext(data);
                }
                break;
            case -1248965304:
                if (!type.equals("GUILD_MEMBER_ADD")) {
                }
                this.guildMembersAdd.f27653k.onNext(data);
                break;
            case -1246481100:
                if (type.equals("STAGE_INSTANCE_DELETE")) {
                    this.stageInstanceDelete.f27653k.onNext(data);
                }
                break;
            case -1238538557:
                if (type.equals("MESSAGE_REACTION_ADD")) {
                    this.messageReactionAdd.f27653k.onNext(data);
                }
                break;
            case -1201943215:
                if (type.equals("GUILD_MEMBER_LIST_UPDATE")) {
                    this.guildMemberListUpdate.f27653k.onNext(data);
                }
                break;
            case -974414266:
                if (type.equals("USER_SUBSCRIPTIONS_UPDATE")) {
                    this.userSubscriptionsUpdate.f27653k.onNext(data);
                }
                break;
            case -960563390:
                if (type.equals("USER_NOTE_UPDATE")) {
                    this.userNoteUpdate.f27653k.onNext(data);
                }
                break;
            case -903406451:
                if (type.equals("PRESENCE_UPDATE")) {
                    this.presenceUpdate.f27653k.onNext(data);
                }
                break;
            case -850953239:
                if (type.equals("INTERACTION_CREATE")) {
                    this.interactionCreate.f27653k.onNext(data);
                }
                break;
            case -843352707:
                if (type.equals("GUILD_INTEGRATIONS_UPDATE")) {
                    this.guildIntegrationsUpdate.f27653k.onNext(data);
                }
                break;
            case -778017807:
                if (type.equals("USER_SETTINGS_UPDATE")) {
                    this.userSettingsUpdate.f27653k.onNext(data);
                }
                break;
            case -767350043:
                if (type.equals("GUILD_APPLICATION_COMMANDS_UPDATE")) {
                    this.guildApplicationCommands.f27653k.onNext(data);
                }
                break;
            case -749868974:
                if (type.equals("STAGE_INSTANCE_UPDATE")) {
                    this.stageInstanceUpdate.f27653k.onNext(data);
                }
                break;
            case -718889877:
                if (type.equals("RELATIONSHIP_REMOVE")) {
                    this.relationshipRemove.f27653k.onNext(data);
                }
                break;
            case -675064872:
                if (!type.equals("CHANNEL_CREATE")) {
                }
                this.channelCreateOrUpdate.f27653k.onNext(data);
                break;
            case -658229113:
                if (type.equals("CHANNEL_DELETE")) {
                    this.channelDeleted.f27653k.onNext(data);
                }
                break;
            case -548091546:
                if (type.equals("CHANNEL_RECIPIENT_REMOVE")) {
                    this.channelRecipientRemove.f27653k.onNext(data);
                }
                break;
            case -510741638:
                if (type.equals("TYPING_START")) {
                    this.typingStart.f27653k.onNext(data);
                }
                break;
            case -300870211:
                if (type.equals("USER_PAYMENT_SOURCES_UPDATE")) {
                    this.userPaymentSourcesUpdate.f27653k.onNext(data);
                }
                break;
            case -273749272:
                if (type.equals("GUILD_CREATE")) {
                    this.guildCreate.f27653k.onNext(data);
                }
                break;
            case -256913513:
                if (type.equals("GUILD_DELETE")) {
                    this.guildDeleted.f27653k.onNext(data);
                }
                break;
            case -233612803:
                if (!type.equals("CALL_CREATE")) {
                }
                this.callCreateOrUpdate.f27653k.onNext(data);
                break;
            case -216777044:
                if (type.equals("CALL_DELETE")) {
                    this.callDelete.f27653k.onNext(data);
                }
                break;
            case -207118083:
                if (type.equals("CHANNEL_UNREAD_UPDATE")) {
                    this.channelUnreadUpdate.f27653k.onNext(data);
                }
                break;
            case -161616987:
                if (!type.equals("CHANNEL_UPDATE")) {
                }
                this.channelCreateOrUpdate.f27653k.onNext(data);
                break;
            case -135720355:
                if (type.equals("GUILD_MEMBER_REMOVE")) {
                    this.guildMemberRemove.f27653k.onNext(data);
                }
                break;
            case -107601202:
                if (!type.equals("MESSAGE_DELETE_BULK")) {
                }
                this.messageDelete.f27653k.onNext(data);
                break;
            case -45642698:
                if (type.equals("FRIEND_SUGGESTION_CREATE")) {
                    this.friendSuggestionCreate.f27653k.onNext(data);
                }
                break;
            case -39955806:
                if (!type.equals("GUILD_MEMBER_UPDATE")) {
                }
                this.guildMembersAdd.f27653k.onNext(data);
                break;
            case -28806939:
                if (type.equals("FRIEND_SUGGESTION_DELETE")) {
                    this.friendSuggestionDelete.f27653k.onNext(data);
                }
                break;
            case 77848963:
                if (type.equals("READY")) {
                    this.ready.f27653k.onNext(data);
                }
                break;
            case 85547718:
                if (type.equals("STREAM_SERVER_UPDATE")) {
                    this.streamServerUpdate.f27653k.onNext(data);
                }
                break;
            case 151900580:
                if (type.equals("THREAD_MEMBERS_UPDATE")) {
                    this.threadMembersUpdate.f27653k.onNext(data);
                }
                break;
            case 239698613:
                if (type.equals("GUILD_UPDATE")) {
                    this.guildUpdate.f27653k.onNext(data);
                }
                break;
            case 279835082:
                if (!type.equals("CALL_UPDATE")) {
                }
                this.callCreateOrUpdate.f27653k.onNext(data);
                break;
            case 391412669:
                if (type.equals("USER_UPDATE")) {
                    this.userUpdate.f27653k.onNext(data);
                }
                break;
            case 789496470:
                if (type.equals("INTERACTION_SUCCESS")) {
                    this.interactionSuccess.f27653k.onNext(data);
                }
                break;
            case 998188116:
                if (type.equals(NotificationData.TYPE_MESSAGE_CREATE)) {
                    this.messageCreate.f27653k.onNext(data);
                }
                break;
            case 1015023875:
                if (!type.equals("MESSAGE_DELETE")) {
                }
                this.messageDelete.f27653k.onNext(data);
                break;
            case 1190664927:
                if (type.equals("CHANNEL_RECIPIENT_ADD")) {
                    this.channelRecipientAdd.f27653k.onNext(data);
                }
                break;
            case 1249854210:
                if (type.equals("MESSAGE_REACTION_REMOVE")) {
                    this.messageReactionRemove.f27653k.onNext(data);
                }
                break;
            case 1268388049:
                if (!type.equals("THREAD_CREATE")) {
                }
                this.threadCreateOrUpdate.f27653k.onNext(data);
                break;
            case 1276846319:
                if (type.equals("GUILD_EMOJIS_UPDATE")) {
                    this.guildEmojisUpdate.f27653k.onNext(data);
                }
                break;
            case 1281125393:
                if (type.equals("MESSAGE_ACK")) {
                    this.messageAck.f27653k.onNext(data);
                }
                break;
            case 1285223808:
                if (type.equals("THREAD_DELETE")) {
                    this.threadDelete.f27653k.onNext(data);
                }
                break;
            case 1389895301:
                if (type.equals("USER_GUILD_SETTINGS_UPDATE")) {
                    this.userGuildSettingsUpdate.f27653k.onNext(data);
                }
                break;
            case 1476675193:
                if (type.equals("GUILD_ROLE_CREATE")) {
                    this.guildRoleCreate.f27653k.onNext(data);
                }
                break;
            case 1478484999:
                if (type.equals("USER_CONNECTIONS_UPDATE")) {
                    SerializedSubject<Unit, Unit> serializedSubject = this.userConnectionUpdate;
                    serializedSubject.f27653k.onNext(Unit.f27425a);
                }
                break;
            case 1493510952:
                if (type.equals("GUILD_ROLE_DELETE")) {
                    this.guildRoleDelete.f27653k.onNext(data);
                }
                break;
            case 1511636001:
                if (type.equals("MESSAGE_UPDATE")) {
                    this.messageUpdate.f27653k.onNext(data);
                }
                break;
            case 1570092061:
                if (type.equals("INTERACTION_FAILURE")) {
                    this.interactionFailure.f27653k.onNext(data);
                }
                break;
            case 1616207515:
                if (type.equals("STREAM_CREATE")) {
                    this.streamCreate.f27653k.onNext(data);
                }
                break;
            case 1622830784:
                if (type.equals("GUILD_BAN_REMOVE")) {
                    this.guildBanRemove.f27653k.onNext(data);
                }
                break;
            case 1633043274:
                if (type.equals("STREAM_DELETE")) {
                    this.streamDelete.f27653k.onNext(data);
                }
                break;
            case 1689894925:
                if (type.equals("PRESENCES_REPLACE")) {
                    this.presenceReplace.f27653k.onNext(data);
                }
                break;
            case 1699412580:
                if (type.equals("VOICE_STATE_UPDATE")) {
                    this.voiceStateUpdate.onNext(data);
                }
                break;
            case 1737758480:
                if (type.equals("GUILD_SCHEDULED_EVENT_USER_ADD")) {
                    this.guildScheduledEventUserAdd.f27653k.onNext(data);
                }
                break;
            case 1781835934:
                if (!type.equals("THREAD_UPDATE")) {
                }
                this.threadCreateOrUpdate.f27653k.onNext(data);
                break;
            case 1882183896:
                if (type.equals("VOICE_SERVER_UPDATE")) {
                    this.voiceServerUpdate.f27653k.onNext(data);
                }
                break;
            case 1901414427:
                if (type.equals("INTERACTION_MODAL_CREATE")) {
                    this.interactionModalCreate.f27653k.onNext(data);
                }
                break;
            case 1928220071:
                if (type.equals("THREAD_LIST_SYNC")) {
                    this.threadListSync.f27653k.onNext(data);
                }
                break;
            case 1990123078:
                if (type.equals("GUILD_ROLE_UPDATE")) {
                    this.guildRoleUpdate.f27653k.onNext(data);
                }
                break;
            case 2129655400:
                if (type.equals("STREAM_UPDATE")) {
                    this.streamUpdate.f27653k.onNext(data);
                }
                break;
        }
    }

    public final void handlePreLogout() {
        voiceStateUpdate$default(this, null, null, false, false, false, null, false, 96, null);
    }

    public final void handleRtcConnectionStateChanged(RtcConnection.StateChange stateChange) {
        C12238m.checkNotNullParameter(stateChange, "stateChange");
        RtcConnection.State state = stateChange.state;
        if ((state instanceof RtcConnection.State.C5610d) && ((RtcConnection.State.C5610d) state).f18812a) {
            RtcConnection.Metadata metadata = stateChange.metadata;
            String str = metadata != null ? metadata.streamKey : null;
            if (str instanceof String) {
                streamPing(str);
            } else {
                voiceServerPing();
            }
        }
    }

    public final void init(Context context, NetworkMonitor networkMonitor) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.socket = buildGatewaySocket(context, networkMonitor);
        ClientState.INSTANCE.initialize(this.stream, this.scheduler, new C59441());
    }

    public final boolean presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        return requestIfSessionEstablished(new C59451(status, since, activities, afk));
    }

    public final boolean requestApplicationCommands(long guildId, String nonce, boolean applications, String query, Integer offset, int commandLimit, List<String> commandIds) {
        C12238m.checkNotNullParameter(nonce, "nonce");
        return requestIfSessionEstablished(new C59461(guildId, nonce, applications, offset, query, commandLimit, commandIds));
    }

    public final boolean requestForumUnreads(long guildId, long channelId, List<Pair<Long, Long>> threadMessagePairs) {
        C12238m.checkNotNullParameter(threadMessagePairs, "threadMessagePairs");
        return requestIfSessionEstablished(new C59471(guildId, channelId, threadMessagePairs));
    }

    public final boolean requestGuildMembers(long j) {
        return requestGuildMembers$default(this, j, null, null, null, 14, null);
    }

    public final boolean requestGuildMembers(long j, String str) {
        return requestGuildMembers$default(this, j, str, null, null, 12, null);
    }

    public final boolean requestGuildMembers(long j, String str, List<Long> list) {
        return requestGuildMembers$default(this, j, str, list, null, 8, null);
    }

    public final boolean requestGuildMembers(long guildId, String query, List<Long> userIds, Integer limit) {
        return requestIfSessionEstablished(new C59481(guildId, query, userIds, limit));
    }

    public final Unit resetOnError() {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket == null) {
            return null;
        }
        gatewaySocket.resetOnError();
        return Unit.f27425a;
    }

    public final void simulateReconnectForTesting() {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket != null) {
            gatewaySocket.simulateReconnectForTesting();
        }
    }

    @StoreThread
    public final void streamCreate(String streamKey, String preferredRegion) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new C59491(streamKey, ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey), preferredRegion));
    }

    public final void streamDelete(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new C59501(streamKey));
    }

    @StoreThread
    public final void streamWatch(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new C59521(streamKey));
    }

    public final boolean updateGuildSubscriptions(long guildId, GuildSubscriptions guildSubscriptions) {
        C12238m.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Map<Long, List<List<Integer>>> serializedRanges = guildSubscriptions.getSerializedRanges();
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        Boolean threads = guildSubscriptions.getThreads();
        Set<Long> members = guildSubscriptions.getMembers();
        return requestIfSessionEstablished(new C59531(guildId, new OutgoingPayload.GuildSubscriptions(serializedRanges, typing, activities, members != null ? C12163u.toList(members) : null, threads, guildSubscriptions.getThreadMemberLists())));
    }

    public final boolean voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        return requestIfSessionEstablished(new C59551(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion, shouldIncludePreferredRegion));
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, Scheduler scheduler, AppGatewaySocketLogger appGatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            executorService = Executors.newFixedThreadPool(1);
            C12238m.checkNotNullExpressionValue(executorService, "Executors.newFixedThreadPool(1)");
        }
        ExecutorService executorService2 = executorService;
        if ((i & 8) != 0) {
            AtomicReference<C12781a> atomicReference = C12781a.f27393a;
            scheduler = new C12698c(executorService2);
            C12238m.checkNotNullExpressionValue(scheduler, "Schedulers.from(executor)");
        }
        this(storeStream, clock, executorService2, scheduler, appGatewaySocketLogger);
    }
}
