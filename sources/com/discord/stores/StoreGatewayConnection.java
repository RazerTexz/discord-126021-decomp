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
import com.discord.app.App$a;
import com.discord.app.AppLog;
import com.discord.gateway.GatewayEventHandler;
import com.discord.gateway.GatewaySocket;
import com.discord.gateway.GatewaySocket$IdentifyData;
import com.discord.gateway.io.OutgoingPayload$GuildSubscriptions;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelGuildIntegration$Update;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserNote$Update;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.StreamCreateOrUpdate;
import com.discord.models.domain.StreamDelete;
import com.discord.models.domain.StreamServerUpdate;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.stores.utilities.BatchManager;
import com.discord.stores.utilities.Batched;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.lazy.subscriptions.GuildSubscriptions;
import com.discord.utilities.logging.AppGatewaySocketLogger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPI$AppHeadersProvider;
import com.discord.utilities.rest.RestAPI$Companion;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.time.Clock;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.l.c.c;
import j0.p.a;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import okhttp3.Interceptor;
import rx.Observable;
import rx.Scheduler;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import s.a.w0;

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
    private StoreGatewayConnection$ClientState clientState;
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
    private final SerializedSubject<ModelGuildIntegration$Update, ModelGuildIntegration$Update> guildIntegrationsUpdate;
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
    private final SerializedSubject<ModelUserNote$Update, ModelUserNote$Update> userNoteUpdate;
    private final SerializedSubject<Unit, Unit> userPaymentSourcesUpdate;
    private final SerializedSubject<UserRequiredActionUpdate, UserRequiredActionUpdate> userRequiredActionUpdate;
    private final SerializedSubject<ModelUserSettings, ModelUserSettings> userSettingsUpdate;
    private final SerializedSubject<Unit, Unit> userSubscriptionsUpdate;
    private final SerializedSubject<User, User> userUpdate;
    private final SerializedSubject<VoiceServer, VoiceServer> voiceServerUpdate;
    private final Batched<VoiceState> voiceStateUpdate;

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, AppGatewaySocketLogger appGatewaySocketLogger) {
        this(storeStream, clock, null, null, appGatewaySocketLogger, 12, null);
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, AppGatewaySocketLogger appGatewaySocketLogger) {
        this(storeStream, clock, executorService, null, appGatewaySocketLogger, 8, null);
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, Scheduler scheduler, AppGatewaySocketLogger appGatewaySocketLogger) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(executorService, "executor");
        m.checkNotNullParameter(scheduler, "scheduler");
        m.checkNotNullParameter(appGatewaySocketLogger, "gatewaySocketLogger");
        this.stream = storeStream;
        this.clock = clock;
        this.executor = executorService;
        this.scheduler = scheduler;
        this.gatewaySocketLogger = appGatewaySocketLogger;
        w0 w0Var = new w0(executorService);
        this.coroutineDispatcher = w0Var;
        BatchManager batchManager = new BatchManager(w0Var, null, 2, null);
        this.batches = batchManager;
        Boolean bool = Boolean.FALSE;
        this.connected = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.connectionReady = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.callCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.callDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelDeleted = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelRecipientAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelRecipientRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.channelUnreadUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.embeddedActivityInboundUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildApplicationCommands = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildBanAdd = new SerializedSubject<>(PublishSubject.k0());
        this.guildBanRemove = new SerializedSubject<>(PublishSubject.k0());
        this.guildCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildEmojisUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildStickersUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildDeleted = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMembersAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMembersChunk = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMemberRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildJoinRequestCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildJoinRequestDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildRoleCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildRoleUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildRoleDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildIntegrationsUpdate = new SerializedSubject<>(PublishSubject.k0());
        this.messageAck = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionRemoveEmoji = new SerializedSubject<>(BehaviorSubject.k0());
        this.messageReactionRemoveAll = new SerializedSubject<>(BehaviorSubject.k0());
        this.presenceUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.presenceReplace = new SerializedSubject<>(BehaviorSubject.k0());
        this.ready = new SerializedSubject<>(BehaviorSubject.k0());
        this.relationshipAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.relationshipRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.typingStart = new SerializedSubject<>(BehaviorSubject.k0());
        this.userConnectionUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userSettingsUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userGuildSettingsUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userNoteUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userRequiredActionUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.sessionsReplace = new SerializedSubject<>(BehaviorSubject.k0());
        this.voiceStateUpdate = BatchManager.createBatched$default(batchManager, "VOICE_STATE_UPDATE", 0L, 0L, 6, null);
        this.voiceServerUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildMemberListUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userPaymentSourcesUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.userSubscriptionsUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamServerUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.streamDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadCreateOrUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadListSync = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadMemberUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadMembersUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.threadMemberListUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionSuccess = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionFailure = new SerializedSubject<>(BehaviorSubject.k0());
        this.interactionModalCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.applicationCommandAutocompleteResult = new SerializedSubject<>(BehaviorSubject.k0());
        this.stageInstanceCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.stageInstanceUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.stageInstanceDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendSuggestionCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendSuggestionDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventCreate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventUpdate = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventDelete = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventUserAdd = new SerializedSubject<>(BehaviorSubject.k0());
        this.guildScheduledEventUserRemove = new SerializedSubject<>(BehaviorSubject.k0());
        this.forumUnreads = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ GatewaySocket$IdentifyData access$getIdentifyData(StoreGatewayConnection storeGatewayConnection) {
        return storeGatewayConnection.getIdentifyData();
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreGatewayConnection storeGatewayConnection) {
        return storeGatewayConnection.stream;
    }

    public static final /* synthetic */ void access$handleClientStateUpdate(StoreGatewayConnection storeGatewayConnection, StoreGatewayConnection$ClientState storeGatewayConnection$ClientState) {
        storeGatewayConnection.handleClientStateUpdate(storeGatewayConnection$ClientState);
    }

    private final GatewaySocket buildGatewaySocket(Context context, NetworkMonitor networkMonitor) {
        RestAPI$Companion restAPI$Companion = RestAPI.Companion;
        List listListOf = n.listOf((Object[]) new Interceptor[]{restAPI$Companion.buildAnalyticsInterceptor(), restAPI$Companion.buildLoggingInterceptor()});
        App$a app$a = App.Companion;
        Objects.requireNonNull(app$a);
        SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = App.access$getIS_LOCAL$cp() ? null : SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
        Objects.requireNonNull(app$a);
        GatewaySocket gatewaySocket = new GatewaySocket(new StoreGatewayConnection$buildGatewaySocket$socket$1(this), StoreGatewayConnection$buildGatewaySocket$socket$2.INSTANCE, this, this.scheduler, AppLog.g, networkMonitor, new RestConfig(BuildConfig.HOST_API, RestAPI$AppHeadersProvider.INSTANCE, listListOf), context, App.access$getIS_LOCAL$cp() ? StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1.INSTANCE : null, sSLSocketFactoryCreateSocketFactory$default, AnalyticSuperProperties.INSTANCE.getSuperProperties(), this.gatewaySocketLogger);
        this.stream.getConnectionTimeStats().addListener(gatewaySocket);
        return gatewaySocket;
    }

    private final GatewaySocket$IdentifyData getIdentifyData() {
        StoreGatewayConnection$ClientState storeGatewayConnection$ClientState = this.clientState;
        if (storeGatewayConnection$ClientState != null) {
            return storeGatewayConnection$ClientState.getIdentifyData();
        }
        return null;
    }

    private final void handleClientStateUpdate(StoreGatewayConnection$ClientState clientState) {
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
        serializedSubject.k.onNext(obj);
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
    public static /* synthetic */ boolean requestApplicationCommands$default(StoreGatewayConnection storeGatewayConnection, long j, String str, boolean z2, String str2, Integer num, int i, List list, int i2, Object obj) {
        return storeGatewayConnection.requestApplicationCommands(j, str, z2, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : num, i, (i2 & 64) != 0 ? null : list);
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
        requestIfSessionEstablished(new StoreGatewayConnection$streamPing$1(streamKey));
    }

    private final void voiceServerPing() {
        requestIfSessionEstablished(StoreGatewayConnection$voiceServerPing$1.INSTANCE);
    }

    public static /* synthetic */ boolean voiceStateUpdate$default(StoreGatewayConnection storeGatewayConnection, Long l, Long l2, boolean z2, boolean z3, boolean z4, String str, boolean z5, int i, Object obj) {
        return storeGatewayConnection.voiceStateUpdate(l, l2, z2, z3, z4, (i & 32) != 0 ? null : str, (i & 64) != 0 ? true : z5);
    }

    public final boolean callConnect(long channelId) {
        return requestIfSessionEstablished(new StoreGatewayConnection$callConnect$1(channelId));
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
        Observable<Boolean> observableR = this.connected.r();
        m.checkNotNullExpressionValue(observableR, "connected.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getConnectionReady() {
        Observable<Boolean> observableR = this.connectionReady.r();
        m.checkNotNullExpressionValue(observableR, "connectionReady.distinctUntilChanged()");
        return observableR;
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

    public final SerializedSubject<ModelGuildIntegration$Update, ModelGuildIntegration$Update> getGuildIntegrationsUpdate() {
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

    public final SerializedSubject<ModelUserNote$Update, ModelUserNote$Update> getUserNoteUpdate() {
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
        serializedSubject.k.onNext(Boolean.valueOf(connected));
    }

    @Override // com.discord.gateway.GatewayEventHandler
    public void handleConnectionReady(boolean connectionReady) {
        SerializedSubject<Boolean, Boolean> serializedSubject = this.connectionReady;
        serializedSubject.k.onNext(Boolean.valueOf(connectionReady));
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
        m.checkNotNullParameter(data, "data");
        this.batches.flushBatches(type);
        if (type == null) {
            return;
        }
        switch (type.hashCode()) {
            case -2137365335:
                if (type.equals("MESSAGE_REACTION_REMOVE_EMOJI")) {
                    this.messageReactionRemoveEmoji.k.onNext(data);
                }
                break;
            case -2067017195:
                if (!type.equals("GUILD_JOIN_REQUEST_CREATE")) {
                }
                this.guildJoinRequestCreateOrUpdate.k.onNext(data);
                break;
            case -2050181436:
                if (type.equals("GUILD_JOIN_REQUEST_DELETE")) {
                    this.guildJoinRequestDelete.k.onNext(data);
                }
                break;
            case -2026522382:
                if (type.equals("SESSIONS_REPLACE")) {
                    this.sessionsReplace.k.onNext(data);
                }
                break;
            case -2002723137:
                if (type.equals("GUILD_SCHEDULED_EVENT_CREATE")) {
                    this.guildScheduledEventCreate.k.onNext(data);
                }
                break;
            case -1985887378:
                if (type.equals("GUILD_SCHEDULED_EVENT_DELETE")) {
                    this.guildScheduledEventDelete.k.onNext(data);
                }
                break;
            case -1967037287:
                if (type.equals("THREAD_MEMBER_UPDATE")) {
                    this.threadMemberUpdate.k.onNext(data);
                }
                break;
            case -1921449515:
                if (type.equals("APPLICATION_COMMAND_AUTOCOMPLETE_RESPONSE")) {
                    this.applicationCommandAutocompleteResult.k.onNext(data);
                }
                break;
            case -1862771270:
                if (type.equals("THREAD_MEMBER_LIST_UPDATE")) {
                    this.threadMemberListUpdate.k.onNext(data);
                }
                break;
            case -1825641445:
                if (type.equals("GUILD_MEMBERS_CHUNK")) {
                    this.guildMembersChunk.k.onNext(data);
                }
                break;
            case -1580624828:
                if (type.equals("EMBEDDED_ACTIVITY_UPDATE")) {
                    this.embeddedActivityInboundUpdate.k.onNext(data);
                }
                break;
            case -1553569310:
                if (!type.equals("GUILD_JOIN_REQUEST_UPDATE")) {
                }
                this.guildJoinRequestCreateOrUpdate.k.onNext(data);
                break;
            case -1553064252:
                if (type.equals("MESSAGE_REACTION_REMOVE_ALL")) {
                    this.messageReactionRemoveAll.k.onNext(data);
                }
                break;
            case -1533134522:
                if (type.equals("FORUM_UNREADS")) {
                    this.forumUnreads.k.onNext(data);
                }
                break;
            case -1489275252:
                if (type.equals(NotificationData.TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                    this.guildScheduledEventUpdate.k.onNext(data);
                }
                break;
            case -1484942443:
                if (type.equals("GUILD_SCHEDULED_EVENT_USER_REMOVE")) {
                    this.guildScheduledEventUserRemove.k.onNext(data);
                }
                break;
            case -1467383482:
                if (type.equals("USER_REQUIRED_ACTION_UPDATE")) {
                    this.userRequiredActionUpdate.k.onNext(data);
                }
                break;
            case -1446088218:
                if (type.equals("GUILD_STICKERS_UPDATE")) {
                    this.guildStickersUpdate.k.onNext(data);
                }
                break;
            case -1327124998:
                if (type.equals(NotificationData.TYPE_RELATIONSHIP_ADD)) {
                    this.relationshipAdd.k.onNext(data);
                }
                break;
            case -1263316859:
                if (type.equals(NotificationData.TYPE_STAGE_INSTANCE_CREATE)) {
                    this.stageInstanceCreate.k.onNext(data);
                }
                break;
            case -1261304891:
                if (type.equals("GUILD_BAN_ADD")) {
                    this.guildBanAdd.k.onNext(data);
                }
                break;
            case -1248965304:
                if (!type.equals("GUILD_MEMBER_ADD")) {
                }
                this.guildMembersAdd.k.onNext(data);
                break;
            case -1246481100:
                if (type.equals("STAGE_INSTANCE_DELETE")) {
                    this.stageInstanceDelete.k.onNext(data);
                }
                break;
            case -1238538557:
                if (type.equals("MESSAGE_REACTION_ADD")) {
                    this.messageReactionAdd.k.onNext(data);
                }
                break;
            case -1201943215:
                if (type.equals("GUILD_MEMBER_LIST_UPDATE")) {
                    this.guildMemberListUpdate.k.onNext(data);
                }
                break;
            case -974414266:
                if (type.equals("USER_SUBSCRIPTIONS_UPDATE")) {
                    this.userSubscriptionsUpdate.k.onNext(data);
                }
                break;
            case -960563390:
                if (type.equals("USER_NOTE_UPDATE")) {
                    this.userNoteUpdate.k.onNext(data);
                }
                break;
            case -903406451:
                if (type.equals("PRESENCE_UPDATE")) {
                    this.presenceUpdate.k.onNext(data);
                }
                break;
            case -850953239:
                if (type.equals("INTERACTION_CREATE")) {
                    this.interactionCreate.k.onNext(data);
                }
                break;
            case -843352707:
                if (type.equals("GUILD_INTEGRATIONS_UPDATE")) {
                    this.guildIntegrationsUpdate.k.onNext(data);
                }
                break;
            case -778017807:
                if (type.equals("USER_SETTINGS_UPDATE")) {
                    this.userSettingsUpdate.k.onNext(data);
                }
                break;
            case -767350043:
                if (type.equals("GUILD_APPLICATION_COMMANDS_UPDATE")) {
                    this.guildApplicationCommands.k.onNext(data);
                }
                break;
            case -749868974:
                if (type.equals("STAGE_INSTANCE_UPDATE")) {
                    this.stageInstanceUpdate.k.onNext(data);
                }
                break;
            case -718889877:
                if (type.equals("RELATIONSHIP_REMOVE")) {
                    this.relationshipRemove.k.onNext(data);
                }
                break;
            case -675064872:
                if (!type.equals("CHANNEL_CREATE")) {
                }
                this.channelCreateOrUpdate.k.onNext(data);
                break;
            case -658229113:
                if (type.equals("CHANNEL_DELETE")) {
                    this.channelDeleted.k.onNext(data);
                }
                break;
            case -548091546:
                if (type.equals("CHANNEL_RECIPIENT_REMOVE")) {
                    this.channelRecipientRemove.k.onNext(data);
                }
                break;
            case -510741638:
                if (type.equals("TYPING_START")) {
                    this.typingStart.k.onNext(data);
                }
                break;
            case -300870211:
                if (type.equals("USER_PAYMENT_SOURCES_UPDATE")) {
                    this.userPaymentSourcesUpdate.k.onNext(data);
                }
                break;
            case -273749272:
                if (type.equals("GUILD_CREATE")) {
                    this.guildCreate.k.onNext(data);
                }
                break;
            case -256913513:
                if (type.equals("GUILD_DELETE")) {
                    this.guildDeleted.k.onNext(data);
                }
                break;
            case -233612803:
                if (!type.equals("CALL_CREATE")) {
                }
                this.callCreateOrUpdate.k.onNext(data);
                break;
            case -216777044:
                if (type.equals("CALL_DELETE")) {
                    this.callDelete.k.onNext(data);
                }
                break;
            case -207118083:
                if (type.equals("CHANNEL_UNREAD_UPDATE")) {
                    this.channelUnreadUpdate.k.onNext(data);
                }
                break;
            case -161616987:
                if (!type.equals("CHANNEL_UPDATE")) {
                }
                this.channelCreateOrUpdate.k.onNext(data);
                break;
            case -135720355:
                if (type.equals("GUILD_MEMBER_REMOVE")) {
                    this.guildMemberRemove.k.onNext(data);
                }
                break;
            case -107601202:
                if (!type.equals("MESSAGE_DELETE_BULK")) {
                }
                this.messageDelete.k.onNext(data);
                break;
            case -45642698:
                if (type.equals("FRIEND_SUGGESTION_CREATE")) {
                    this.friendSuggestionCreate.k.onNext(data);
                }
                break;
            case -39955806:
                if (!type.equals("GUILD_MEMBER_UPDATE")) {
                }
                this.guildMembersAdd.k.onNext(data);
                break;
            case -28806939:
                if (type.equals("FRIEND_SUGGESTION_DELETE")) {
                    this.friendSuggestionDelete.k.onNext(data);
                }
                break;
            case 77848963:
                if (type.equals("READY")) {
                    this.ready.k.onNext(data);
                }
                break;
            case 85547718:
                if (type.equals("STREAM_SERVER_UPDATE")) {
                    this.streamServerUpdate.k.onNext(data);
                }
                break;
            case 151900580:
                if (type.equals("THREAD_MEMBERS_UPDATE")) {
                    this.threadMembersUpdate.k.onNext(data);
                }
                break;
            case 239698613:
                if (type.equals("GUILD_UPDATE")) {
                    this.guildUpdate.k.onNext(data);
                }
                break;
            case 279835082:
                if (!type.equals("CALL_UPDATE")) {
                }
                this.callCreateOrUpdate.k.onNext(data);
                break;
            case 391412669:
                if (type.equals("USER_UPDATE")) {
                    this.userUpdate.k.onNext(data);
                }
                break;
            case 789496470:
                if (type.equals("INTERACTION_SUCCESS")) {
                    this.interactionSuccess.k.onNext(data);
                }
                break;
            case 998188116:
                if (type.equals(NotificationData.TYPE_MESSAGE_CREATE)) {
                    this.messageCreate.k.onNext(data);
                }
                break;
            case 1015023875:
                if (!type.equals("MESSAGE_DELETE")) {
                }
                this.messageDelete.k.onNext(data);
                break;
            case 1190664927:
                if (type.equals("CHANNEL_RECIPIENT_ADD")) {
                    this.channelRecipientAdd.k.onNext(data);
                }
                break;
            case 1249854210:
                if (type.equals("MESSAGE_REACTION_REMOVE")) {
                    this.messageReactionRemove.k.onNext(data);
                }
                break;
            case 1268388049:
                if (!type.equals("THREAD_CREATE")) {
                }
                this.threadCreateOrUpdate.k.onNext(data);
                break;
            case 1276846319:
                if (type.equals("GUILD_EMOJIS_UPDATE")) {
                    this.guildEmojisUpdate.k.onNext(data);
                }
                break;
            case 1281125393:
                if (type.equals("MESSAGE_ACK")) {
                    this.messageAck.k.onNext(data);
                }
                break;
            case 1285223808:
                if (type.equals("THREAD_DELETE")) {
                    this.threadDelete.k.onNext(data);
                }
                break;
            case 1389895301:
                if (type.equals("USER_GUILD_SETTINGS_UPDATE")) {
                    this.userGuildSettingsUpdate.k.onNext(data);
                }
                break;
            case 1476675193:
                if (type.equals("GUILD_ROLE_CREATE")) {
                    this.guildRoleCreate.k.onNext(data);
                }
                break;
            case 1478484999:
                if (type.equals("USER_CONNECTIONS_UPDATE")) {
                    SerializedSubject<Unit, Unit> serializedSubject = this.userConnectionUpdate;
                    serializedSubject.k.onNext(Unit.a);
                }
                break;
            case 1493510952:
                if (type.equals("GUILD_ROLE_DELETE")) {
                    this.guildRoleDelete.k.onNext(data);
                }
                break;
            case 1511636001:
                if (type.equals("MESSAGE_UPDATE")) {
                    this.messageUpdate.k.onNext(data);
                }
                break;
            case 1570092061:
                if (type.equals("INTERACTION_FAILURE")) {
                    this.interactionFailure.k.onNext(data);
                }
                break;
            case 1616207515:
                if (type.equals("STREAM_CREATE")) {
                    this.streamCreate.k.onNext(data);
                }
                break;
            case 1622830784:
                if (type.equals("GUILD_BAN_REMOVE")) {
                    this.guildBanRemove.k.onNext(data);
                }
                break;
            case 1633043274:
                if (type.equals("STREAM_DELETE")) {
                    this.streamDelete.k.onNext(data);
                }
                break;
            case 1689894925:
                if (type.equals("PRESENCES_REPLACE")) {
                    this.presenceReplace.k.onNext(data);
                }
                break;
            case 1699412580:
                if (type.equals("VOICE_STATE_UPDATE")) {
                    this.voiceStateUpdate.onNext(data);
                }
                break;
            case 1737758480:
                if (type.equals("GUILD_SCHEDULED_EVENT_USER_ADD")) {
                    this.guildScheduledEventUserAdd.k.onNext(data);
                }
                break;
            case 1781835934:
                if (!type.equals("THREAD_UPDATE")) {
                }
                this.threadCreateOrUpdate.k.onNext(data);
                break;
            case 1882183896:
                if (type.equals("VOICE_SERVER_UPDATE")) {
                    this.voiceServerUpdate.k.onNext(data);
                }
                break;
            case 1901414427:
                if (type.equals("INTERACTION_MODAL_CREATE")) {
                    this.interactionModalCreate.k.onNext(data);
                }
                break;
            case 1928220071:
                if (type.equals("THREAD_LIST_SYNC")) {
                    this.threadListSync.k.onNext(data);
                }
                break;
            case 1990123078:
                if (type.equals("GUILD_ROLE_UPDATE")) {
                    this.guildRoleUpdate.k.onNext(data);
                }
                break;
            case 2129655400:
                if (type.equals("STREAM_UPDATE")) {
                    this.streamUpdate.k.onNext(data);
                }
                break;
        }
    }

    public final void handlePreLogout() {
        voiceStateUpdate$default(this, null, null, false, false, false, null, false, 96, null);
    }

    public final void handleRtcConnectionStateChanged(RtcConnection$StateChange stateChange) {
        m.checkNotNullParameter(stateChange, "stateChange");
        RtcConnection$State rtcConnection$State = stateChange.state;
        if ((rtcConnection$State instanceof RtcConnection$State$d) && ((RtcConnection$State$d) rtcConnection$State).a) {
            RtcConnection$Metadata rtcConnection$Metadata = stateChange.metadata;
            String str = rtcConnection$Metadata != null ? rtcConnection$Metadata.streamKey : null;
            if (str instanceof String) {
                streamPing(str);
            } else {
                voiceServerPing();
            }
        }
    }

    public final void init(Context context, NetworkMonitor networkMonitor) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.socket = buildGatewaySocket(context, networkMonitor);
        StoreGatewayConnection$ClientState.Companion.initialize(this.stream, this.scheduler, new StoreGatewayConnection$init$1(this));
    }

    public final boolean presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        return requestIfSessionEstablished(new StoreGatewayConnection$presenceUpdate$1(status, since, activities, afk));
    }

    public final boolean requestApplicationCommands(long guildId, String nonce, boolean applications, String query, Integer offset, int commandLimit, List<String> commandIds) {
        m.checkNotNullParameter(nonce, "nonce");
        return requestIfSessionEstablished(new StoreGatewayConnection$requestApplicationCommands$1(guildId, nonce, applications, offset, query, commandLimit, commandIds));
    }

    public final boolean requestForumUnreads(long guildId, long channelId, List<Pair<Long, Long>> threadMessagePairs) {
        m.checkNotNullParameter(threadMessagePairs, "threadMessagePairs");
        return requestIfSessionEstablished(new StoreGatewayConnection$requestForumUnreads$1(guildId, channelId, threadMessagePairs));
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
        return requestIfSessionEstablished(new StoreGatewayConnection$requestGuildMembers$1(guildId, query, userIds, limit));
    }

    public final Unit resetOnError() {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket == null) {
            return null;
        }
        gatewaySocket.resetOnError();
        return Unit.a;
    }

    public final void simulateReconnectForTesting() {
        GatewaySocket gatewaySocket = this.socket;
        if (gatewaySocket != null) {
            gatewaySocket.simulateReconnectForTesting();
        }
    }

    @StoreThread
    public final void streamCreate(String streamKey, String preferredRegion) {
        m.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new StoreGatewayConnection$streamCreate$1(this, streamKey, ModelApplicationStream.Companion.decodeStreamKey(streamKey), preferredRegion));
    }

    public final void streamDelete(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new StoreGatewayConnection$streamDelete$1(streamKey));
    }

    @StoreThread
    public final void streamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        requestIfSessionEstablished(new StoreGatewayConnection$streamWatch$1(this, streamKey));
    }

    public final boolean updateGuildSubscriptions(long guildId, GuildSubscriptions guildSubscriptions) {
        m.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Map<Long, List<List<Integer>>> serializedRanges = guildSubscriptions.getSerializedRanges();
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        Boolean threads = guildSubscriptions.getThreads();
        Set<Long> members = guildSubscriptions.getMembers();
        return requestIfSessionEstablished(new StoreGatewayConnection$updateGuildSubscriptions$1(guildId, new OutgoingPayload$GuildSubscriptions(serializedRanges, typing, activities, members != null ? u.toList(members) : null, threads, guildSubscriptions.getThreadMemberLists())));
    }

    public final boolean voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        return requestIfSessionEstablished(new StoreGatewayConnection$voiceStateUpdate$1(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion, shouldIncludePreferredRegion));
    }

    public StoreGatewayConnection(StoreStream storeStream, Clock clock, ExecutorService executorService, Scheduler scheduler, AppGatewaySocketLogger appGatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            executorService = Executors.newFixedThreadPool(1);
            m.checkNotNullExpressionValue(executorService, "Executors.newFixedThreadPool(1)");
        }
        ExecutorService executorService2 = executorService;
        if ((i & 8) != 0) {
            AtomicReference<a> atomicReference = a.a;
            scheduler = new c(executorService2);
            m.checkNotNullExpressionValue(scheduler, "Schedulers.from(executor)");
        }
        this(storeStream, clock, executorService2, scheduler, appGatewaySocketLogger);
    }
}
