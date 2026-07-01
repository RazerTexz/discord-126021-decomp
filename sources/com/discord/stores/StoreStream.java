package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipient;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.guild.Guild;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.api.guildhash.GuildHashes;
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
import com.discord.api.presence.Presence;
import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.api.role.GuildRole;
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
import com.discord.api.user.UserProfile;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.models.authentication.AuthState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall;
import com.discord.models.domain.ModelChannelUnreadUpdate;
import com.discord.models.domain.ModelGuildIntegration$Update;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item$MemberItem;
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
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Batched;
import com.discord.utilities.StoreUIEventHandler;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher;
import com.discord.utilities.logging.AppGatewaySocketLogger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPI$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeElapsed;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.settings.premium.OutboundPromosPreviewFeatureFlag;
import com.google.gson.Gson;
import d0.g;
import d0.t.n;
import d0.t.n0;
import d0.z.d.m;
import j0.l.c.c;
import j0.p.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Scheduler;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream {
    private static long STORE_THREAD_ID;
    private static boolean isInitialized;
    private final StoreAccessibility accessibility;
    private final StoreAnalytics analytics;
    private final StoreApplication application;
    private final StoreApplicationAssets applicationAssets;
    private final StoreApplicationCommandFrecency applicationCommandFrecency;
    private final StoreApplicationCommands applicationCommands;
    private final StoreApplicationInteractions applicationInteractions;
    private final StoreApplicationStreamPreviews applicationStreamPreviews;
    private final StoreApplicationStreaming applicationStreaming;
    private final ArchivedThreadsStore archivedThreads;
    private final StoreAudioManagerV2 audioManagerV2;
    private final StoreAuditLog auditLog;
    private final StoreAuthentication authentication;
    private final StoreAutocomplete autocomplete;
    private final StoreBans bans;
    private final StoreCalls calls;
    private final StoreCallsIncoming callsIncoming;
    private final StoreChangeLog changeLogStore;
    private final StoreChannelConversions channelConversions;
    private final StoreChannelFollowerStats channelFollowerStats;
    private final StoreChannels channels;
    private final StoreChannelsSelected channelsSelected;
    private final StoreChat chat;
    private final StoreClientDataState clientDataState;
    private final StoreClientVersion clientVersion;
    private final Clock clock;
    private final StoreCollapsedChannelCategories collapsedChannelCategories;
    private final StoreConnectionOpen connectionOpen;
    private final ConnectionTimeStats connectionTimeStats;
    private final StoreConnectivity connectivity;
    private final StoreContactSync contactSync;
    private final StoreEmojiCustom customEmojis;
    private final StoreDirectories directories;
    private final Dispatcher dispatcher;
    private final StoreEmbeddedActivities embeddedActivities;
    private final StoreEmoji emojis;
    private final StoreEntitlements entitlements;
    private final StoreExpandedGuildFolders expandedGuildFolders;
    private final StoreExperiments experiments;
    private final StoreExpressionPickerNavigation expressionPickerNavigation;
    private final StoreExpressionSuggestions expressionSuggestions;
    private final StoreForumPostMessages forumPostMessages;
    private final StoreForumPostReadStates forumPostReadStates;
    private final StoreFriendSuggestions friendSuggestions;
    private final StoreGameParty gameParty;
    private final StoreGatewayConnection gatewaySocket;
    private final StoreGifPicker gifPicker;
    private final StoreGifting gifting;
    private final StoreGooglePlayPurchases googlePlayPurchases;
    private final StoreGooglePlaySkuDetails googlePlaySkuDetails;
    private final StoreGuildBoost guildBoosts;
    private final StoreEmojiGuild guildEmojis;
    private final StoreInviteSettings guildInvite;
    private final StoreGuildJoinRequest guildJoinRequests;
    private final StoreGuildMemberCounts guildMemberCounts;
    private final StoreGuildMemberRequester guildMemberRequesterStore;
    private final StoreGuildProfiles guildProfiles;
    private final StoreGuildRoleMemberCounts guildRoleMemberCounts;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptions;
    private final StoreGuildScheduledEvents guildScheduledEvents;
    private final StoreGuildSelected guildSelected;
    private final StoreUserGuildSettings guildSettings;
    private final StoreGuildStickers guildStickers;
    private final StoreGuildSubscriptions guildSubscriptions;
    private final StoreGuildTemplates guildTemplates;
    private final StoreGuildVoiceRegions guildVoiceRegions;
    private final StoreGuildWelcomeScreens guildWelcomeScreens;
    private final StoreGuilds guilds;
    private final StoreGuildsNsfw guildsNsfw;
    private final StoreGuildsSorted guildsSorted;
    private final BehaviorSubject<Boolean> initialized = BehaviorSubject.l0(Boolean.FALSE);
    private final StoreInstantInvites instantInvites;
    private final StoreGuildIntegrations integrations;
    private final StoreChannelMembers lazyChannelMembersStore;
    private final StoreThreadMembers lazyThreadMembersStore;
    private final StoreLibrary library;
    private final StoreLocalActionComponentState localActionComponentState;
    private final StoreLurking lurking;
    private final StoreMaskedLinks maskedLinks;
    private final StoreMediaEngine mediaEngine;
    private final StoreMediaFavorites mediaFavorites;
    private final StoreMediaSettings mediaSettings;
    private final StoreGuildMemberVerificationForm memberVerificationForms;
    private final StoreMentions mentions;
    private final StoreMessageAck messageAck;
    private final StoreMessageReactions messageReactions;
    private final StoreMessageReplies messageReplies;
    private final StoreMessageState messageStates;
    private final StoreMessageUploads messageUploads;
    private final StoreMessages messages;
    private final StoreMessagesLoader messagesLoader;
    private final StoreMessagesMostRecent messagesMostRecent;
    private final StoreMFA mfa;
    private final StoreNavigation navigation;
    private final StoreNotices notices;
    private final StoreNotificationUpsells notificationUpsells;
    private final StoreNotifications notifications;
    private final StoreNux nux;
    private final StoreOutboundPromotions outboundPromotions;
    private final StorePaymentSources paymentSources;
    private final StorePendingReplies pendingReplies;
    private final StorePermissions permissions;
    private final StorePhone phone;
    private final StorePinnedMessages pinnedMessages;
    private final StoreUserPresence presences;
    private final StoreReadStates readStates;
    private final StoreRequestedStageChannels requestedStageChannels;
    private final StoreReviewRequest reviewRequestStore;
    private final StoreRtcConnection rtcConnection;
    private final StoreRtcRegion rtcRegion;
    private final StoreSearch search;
    private final StoreSlowMode slowMode;
    private final StoreSpotify spotify;
    private final StoreStageChannels stageChannels;
    private final StoreStageInstances stageInstances;
    private final StoreStageChannelSelfPresence stageSelfPresence;
    private final StoreStickers stickers;
    private final StoreDynamicLink storeDynamicLink;
    private final Scheduler storeThreadScheduler;
    private final StoreV2DispatchHandler storeV2DispatchHandler;
    private final List<StoreV2> storesV2;
    private final StoreStreamRtcConnection streamRtcConnection;
    private final StoreSubscriptions subscriptions;
    private final StoreTabsNavigation tabsNavigation;
    private final StoreThreadDraft threadDraft;
    private final StoreThreadMessages threadMessages;
    private final StoreThreadsActive threadsActive;
    private final StoreThreadsActiveJoined threadsActiveJoined;
    private final StoreThreadsJoined threadsJoined;
    private final StoreUserAffinities userAffinities;
    private final StoreUserConnections userConnections;
    private final StoreUserNotes userNotes;
    private final StoreUserProfile userProfile;
    private final StoreUserRelationships userRelationships;
    private final StoreUserRequiredActions userRequiredAction;
    private final StoreUserSettings userSettings;
    private final StoreUserSettingsSystem userSettingsSystem;
    private final StoreUserSurvey userSurvey;
    private final StoreUser users;
    private final StoreUserTyping usersTyping;
    private final StoreVideoStreams videoStreams;
    private final StoreAudioManagerV2$VideoUseDetector videoUseDetector;
    private final StoreVoiceChannelSelected voiceChannelSelected;
    private final StoreVoiceParticipants voiceParticipants;
    private final StoreVoiceSpeaking voiceSpeaking;
    private final StoreVoiceStates voiceStates;
    public static final StoreStream$Companion Companion = new StoreStream$Companion(null);
    private static final String STORE_THREAD_NAME = "Main-StoreThread";
    private static final String LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY = "last_logged_notification_permissions_key";
    private static final long DAY_IN_MILLS = TimeUnit.DAYS.toMillis(1);
    private static final Lazy collector$delegate = g.lazy(StoreStream$Companion$collector$2.INSTANCE);

    public StoreStream() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(StoreStream$storeThreadScheduler$1.INSTANCE);
        AtomicReference<a> atomicReference = a.a;
        c cVar = new c(executorServiceNewSingleThreadExecutor);
        m.checkNotNullExpressionValue(cVar, "Schedulers.from(Executor…       newThread\n      })");
        this.storeThreadScheduler = cVar;
        Dispatcher dispatcher = new Dispatcher(cVar, false);
        this.dispatcher = dispatcher;
        Clock clock = ClockFactory.get();
        this.clock = clock;
        StoreAnalytics storeAnalytics = new StoreAnalytics(this, dispatcher, clock);
        this.analytics = storeAnalytics;
        StoreAuthentication storeAuthentication = new StoreAuthentication(this, dispatcher);
        this.authentication = storeAuthentication;
        StoreChannels storeChannels = new StoreChannels(dispatcher, ObservationDeckProvider.get(), new StoreStream$channels$1(this), new StoreStream$channels$2(this), new StoreStream$channels$3(this), null, 32, null);
        this.channels = storeChannels;
        StoreUser storeUser = new StoreUser(new StoreStream$users$1(this), dispatcher, null, null, 12, null);
        this.users = storeUser;
        StoreGuilds storeGuilds = new StoreGuilds(storeUser, dispatcher, null, 4, null);
        this.guilds = storeGuilds;
        StoreStageInstances storeStageInstances = new StoreStageInstances(null, 1, null);
        this.stageInstances = storeStageInstances;
        this.requestedStageChannels = new StoreRequestedStageChannels(dispatcher, null, null, 6, null);
        StoreThreadsJoined storeThreadsJoined = new StoreThreadsJoined(storeUser, null, 2, null);
        this.threadsJoined = storeThreadsJoined;
        this.guildSettings = new StoreUserGuildSettings(dispatcher, clock, storeAnalytics, storeChannels, storeThreadsJoined, null, null, 96, null);
        StorePermissions storePermissions = new StorePermissions(storeUser, storeChannels, storeGuilds, storeThreadsJoined, storeStageInstances, ObservationDeckProvider.get());
        this.permissions = storePermissions;
        StoreGuildSelected storeGuildSelected = new StoreGuildSelected(this, dispatcher, storeGuilds, storeAnalytics, null, 16, null);
        this.guildSelected = storeGuildSelected;
        StoreChannelsSelected storeChannelsSelected = new StoreChannelsSelected(this, storeChannels, storePermissions, storeGuildSelected, dispatcher, ObservationDeckProvider.get());
        this.channelsSelected = storeChannelsSelected;
        this.channelConversions = new StoreChannelConversions();
        this.clientVersion = new StoreClientVersion();
        StoreGuildMemberCounts storeGuildMemberCounts = new StoreGuildMemberCounts();
        this.guildMemberCounts = storeGuildMemberCounts;
        this.guildJoinRequests = new StoreGuildJoinRequest(storeUser, storeGuilds, dispatcher, ObservationDeckProvider.get());
        StoreGuildsNsfw storeGuildsNsfw = new StoreGuildsNsfw(dispatcher, storeChannels, ObservationDeckProvider.get());
        this.guildsNsfw = storeGuildsNsfw;
        this.bans = new StoreBans(dispatcher, ObservationDeckProvider.get());
        ObservationDeck observationDeck = ObservationDeckProvider.get();
        RestAPI$Companion restAPI$Companion = RestAPI.Companion;
        this.guildEmojis = new StoreEmojiGuild(observationDeck, dispatcher, restAPI$Companion.getApi());
        this.integrations = new StoreGuildIntegrations(dispatcher);
        this.instantInvites = new StoreInstantInvites(dispatcher, null, null, 6, null);
        this.guildTemplates = new StoreGuildTemplates(ObservationDeckProvider.get(), dispatcher, restAPI$Companion.getApi());
        this.guildInvite = new StoreInviteSettings();
        StoreMessages storeMessages = new StoreMessages(this, dispatcher, clock);
        this.messages = storeMessages;
        this.messagesLoader = new StoreMessagesLoader(this, dispatcher);
        this.messagesMostRecent = new StoreMessagesMostRecent(storeChannels, null, 2, null);
        StoreMessageAck storeMessageAck = new StoreMessageAck(this, ObservationDeckProvider.get(), dispatcher, restAPI$Companion.getApi());
        this.messageAck = storeMessageAck;
        this.messageReplies = new StoreMessageReplies(dispatcher, storeMessages, null, 4, null);
        this.messageStates = new StoreMessageState(dispatcher);
        this.notifications = new StoreNotifications(clock, this);
        StoreExperiments storeExperiments = new StoreExperiments(clock, dispatcher, storeUser, storeGuilds, storeAuthentication, storeGuildMemberCounts, null, 64, null);
        this.experiments = storeExperiments;
        this.lurking = new StoreLurking(this, storeGuilds, dispatcher);
        this.userConnections = new StoreUserConnections(this, dispatcher, null, 4, null);
        StoreUserPresence storeUserPresence = new StoreUserPresence(clock, this, ObservationDeckProvider.get());
        this.presences = storeUserPresence;
        this.userProfile = new StoreUserProfile(dispatcher, ObservationDeckProvider.get(), this, null, 8, null);
        this.userNotes = new StoreUserNotes(dispatcher, null, null, 6, null);
        this.usersTyping = new StoreUserTyping(this, dispatcher, null, null, 12, null);
        StoreAccessibility storeAccessibility = new StoreAccessibility(dispatcher, null, null, 6, null);
        this.accessibility = storeAccessibility;
        this.userSettings = new StoreUserSettings(dispatcher, storeAccessibility);
        StoreUserSettingsSystem storeUserSettingsSystem = new StoreUserSettingsSystem(new StoreStream$userSettingsSystem$1(this), dispatcher);
        this.userSettingsSystem = storeUserSettingsSystem;
        this.userSurvey = new StoreUserSurvey(dispatcher, storeUser, storeGuilds, storePermissions, ObservationDeckProvider.get(), restAPI$Companion.getApi(), clock, SharedPreferencesProvider.INSTANCE.get());
        this.userRequiredAction = new StoreUserRequiredActions(ObservationDeckProvider.get());
        StoreUserRelationships storeUserRelationships = new StoreUserRelationships(null, 1, null);
        this.userRelationships = storeUserRelationships;
        StoreVoiceStates storeVoiceStates = new StoreVoiceStates(new StoreStream$voiceStates$1(this), ObservationDeckProvider.get());
        this.voiceStates = storeVoiceStates;
        this.tabsNavigation = new StoreTabsNavigation(dispatcher, this, null, 4, null);
        this.maskedLinks = new StoreMaskedLinks(this.dispatcher, storeChannelsSelected, storeUserRelationships);
        this.navigation = new StoreNavigation(this);
        this.customEmojis = new StoreEmojiCustom(this);
        StoreVoiceChannelSelected storeVoiceChannelSelected = new StoreVoiceChannelSelected(this, this.dispatcher, this.clock, null, 8, null);
        this.voiceChannelSelected = storeVoiceChannelSelected;
        StoreAudioManagerV2$VideoUseDetector storeAudioManagerV2$VideoUseDetector = new StoreAudioManagerV2$VideoUseDetector(this.channels, storeVoiceStates, this.users);
        this.videoUseDetector = storeAudioManagerV2$VideoUseDetector;
        this.gatewaySocket = new StoreGatewayConnection(this, this.clock, null, null, AppGatewaySocketLogger.Companion.getINSTANCE(), 12, null);
        this.connectivity = new StoreConnectivity(this, this.dispatcher, this.clock);
        this.connectionOpen = new StoreConnectionOpen();
        this.calls = new StoreCalls(this);
        this.callsIncoming = new StoreCallsIncoming(this.dispatcher, ObservationDeckProvider.get(), this.users);
        this.chat = new StoreChat(this.dispatcher, null, 2, null);
        this.mentions = new StoreMentions(storeUserRelationships, this.permissions, storeMessageAck, this.guildSettings, this.channels, this.threadsJoined, null, 64, null);
        this.pinnedMessages = new StorePinnedMessages(this.dispatcher, ObservationDeckProvider.get());
        this.readStates = new StoreReadStates(this.clock);
        this.voiceParticipants = new StoreVoiceParticipants(this);
        this.search = new StoreSearch(this, this.dispatcher, storeGuildsNsfw, this.users, ObservationDeckProvider.get(), this.channels, this.guilds);
        StoreMediaSettings storeMediaSettings = new StoreMediaSettings(storeVoiceChannelSelected, this.channels, this.permissions, null, null, 24, null);
        this.mediaSettings = storeMediaSettings;
        this.storeDynamicLink = new StoreDynamicLink(this, this.dispatcher);
        this.collapsedChannelCategories = new StoreCollapsedChannelCategories(this.dispatcher, ObservationDeckProvider.get());
        StoreMediaEngine storeMediaEngine = new StoreMediaEngine(storeMediaSettings, this, this.dispatcher);
        this.mediaEngine = storeMediaEngine;
        StoreRtcRegion storeRtcRegion = new StoreRtcRegion(this.dispatcher, this.clock, storeMediaEngine, storeExperiments, null, 16, null);
        this.rtcRegion = storeRtcRegion;
        StoreRtcConnection storeRtcConnection = new StoreRtcConnection(this, this.dispatcher, this.clock, storeRtcRegion, this.analytics, storeVoiceStates, null, null, Opcodes.CHECKCAST, null);
        this.rtcConnection = storeRtcConnection;
        this.voiceSpeaking = new StoreVoiceSpeaking(ObservationDeckProvider.get());
        this.videoStreams = new StoreVideoStreams(null, 1, null);
        this.gameParty = new StoreGameParty(ObservationDeckProvider.get(), storeUserPresence, this.users);
        StoreNotices storeNotices = new StoreNotices(this.clock, this);
        this.notices = storeNotices;
        this.guildSubscriptions = new StoreGuildSubscriptions(this, this.dispatcher);
        StoreApplicationStreaming storeApplicationStreaming = new StoreApplicationStreaming(this, this.dispatcher, this.users, storeVoiceChannelSelected, storeRtcConnection, null, 32, null);
        this.applicationStreaming = storeApplicationStreaming;
        this.lazyChannelMembersStore = new StoreChannelMembers(ObservationDeckProvider.get(), this.dispatcher, this.guilds, this.users, new StoreStream$lazyChannelMembersStore$1(this.channels), new StoreStream$lazyChannelMembersStore$2(this.guildMemberCounts), new StoreStream$lazyChannelMembersStore$3(storeUserPresence.getPresences()), new StoreStream$lazyChannelMembersStore$4(storeApplicationStreaming));
        this.lazyThreadMembersStore = new StoreThreadMembers(ObservationDeckProvider.get(), this.channels);
        this.guildMemberRequesterStore = new StoreGuildMemberRequester(this, this.dispatcher);
        this.reviewRequestStore = new StoreReviewRequest(this.clock, this);
        this.changeLogStore = new StoreChangeLog(this.clock, storeNotices, this.users, storeUserSettingsSystem, this.experiments, this.dispatcher);
        this.slowMode = new StoreSlowMode(this.clock, this);
        this.auditLog = new StoreAuditLog(ObservationDeckProvider.get(), this.dispatcher, restAPI$Companion.getApi());
        this.messageUploads = new StoreMessageUploads();
        this.nux = new StoreNux(this.dispatcher);
        this.library = new StoreLibrary(this.dispatcher, ObservationDeckProvider.get());
        this.gifting = new StoreGifting(this.dispatcher);
        this.spotify = new StoreSpotify(this, this.dispatcher, this.clock);
        this.messageReactions = new StoreMessageReactions(this.dispatcher, this.users, null, 4, null);
        this.application = new StoreApplication(this.dispatcher, ObservationDeckProvider.get());
        this.applicationAssets = new StoreApplicationAssets(this.dispatcher, null, null, 6, null);
        this.paymentSources = new StorePaymentSources(this.dispatcher, null, null, 6, null);
        this.subscriptions = new StoreSubscriptions(ObservationDeckProvider.get(), this.dispatcher, restAPI$Companion.getApi());
        this.mfa = new StoreMFA(this, this.dispatcher, ObservationDeckProvider.get());
        StoreStreamRtcConnection storeStreamRtcConnection = new StoreStreamRtcConnection(storeMediaEngine, this.users, this, this.dispatcher, this.clock, this.analytics, storeRtcConnection, null, null, null, 896, null);
        this.streamRtcConnection = storeStreamRtcConnection;
        this.audioManagerV2 = new StoreAudioManagerV2(ObservationDeckProvider.get(), this.dispatcher, storeVoiceChannelSelected, this.channels, storeStreamRtcConnection, storeAudioManagerV2$VideoUseDetector, this.experiments);
        this.applicationStreamPreviews = new StoreApplicationStreamPreviews(this.dispatcher, this.clock, null, null, 12, null);
        StoreGuildsSorted storeGuildsSorted = new StoreGuildsSorted(ObservationDeckProvider.get(), this.dispatcher, this.guilds, this.lurking);
        this.guildsSorted = storeGuildsSorted;
        this.expandedGuildFolders = new StoreExpandedGuildFolders(this.dispatcher, null, 2, null);
        StoreMediaFavorites storeMediaFavorites = new StoreMediaFavorites(ObservationDeckProvider.get(), this.dispatcher, null, 4, null);
        this.mediaFavorites = storeMediaFavorites;
        this.emojis = new StoreEmoji(this.customEmojis, this.users, this.permissions, storeGuildsSorted, storeMediaFavorites);
        StoreGuildBoost storeGuildBoost = new StoreGuildBoost(this.dispatcher, ObservationDeckProvider.get());
        this.guildBoosts = storeGuildBoost;
        StoreEntitlements storeEntitlements = new StoreEntitlements(this.dispatcher, ObservationDeckProvider.get(), null, 4, null);
        this.entitlements = storeEntitlements;
        StoreGuildProfiles storeGuildProfiles = new StoreGuildProfiles(this.dispatcher, ObservationDeckProvider.get());
        this.guildProfiles = storeGuildProfiles;
        StoreGuildWelcomeScreens storeGuildWelcomeScreens = new StoreGuildWelcomeScreens(this.dispatcher, null, 2, null);
        this.guildWelcomeScreens = storeGuildWelcomeScreens;
        StoreGuildVoiceRegions storeGuildVoiceRegions = new StoreGuildVoiceRegions(this.dispatcher, null, 2, null);
        this.guildVoiceRegions = storeGuildVoiceRegions;
        StoreUserAffinities storeUserAffinities = new StoreUserAffinities(this.dispatcher, null, 2, null);
        this.userAffinities = storeUserAffinities;
        StoreClientDataState storeClientDataState = new StoreClientDataState(null, 1, null);
        this.clientDataState = storeClientDataState;
        StoreGifPicker storeGifPicker = new StoreGifPicker(this.dispatcher, this.userSettingsSystem, null, null, 12, null);
        this.gifPicker = storeGifPicker;
        StoreStickers storeStickers = new StoreStickers(this.dispatcher, null, null, null, 14, null);
        this.stickers = storeStickers;
        StoreGooglePlayPurchases storeGooglePlayPurchases = new StoreGooglePlayPurchases(ObservationDeckProvider.get(), this.dispatcher, restAPI$Companion.getApi(), this.clock, new Gson(), AnalyticsTracker.INSTANCE);
        this.googlePlayPurchases = storeGooglePlayPurchases;
        StoreGooglePlaySkuDetails storeGooglePlaySkuDetails = new StoreGooglePlaySkuDetails(ObservationDeckProvider.get(), this.dispatcher);
        this.googlePlaySkuDetails = storeGooglePlaySkuDetails;
        StoreExpressionPickerNavigation storeExpressionPickerNavigation = new StoreExpressionPickerNavigation(ObservationDeckProvider.get(), this.dispatcher);
        this.expressionPickerNavigation = storeExpressionPickerNavigation;
        StoreChannelFollowerStats storeChannelFollowerStats = new StoreChannelFollowerStats(this.dispatcher, ObservationDeckProvider.get());
        this.channelFollowerStats = storeChannelFollowerStats;
        StoreApplicationCommandFrecency storeApplicationCommandFrecency = new StoreApplicationCommandFrecency(this.dispatcher, null, 2, null);
        this.applicationCommandFrecency = storeApplicationCommandFrecency;
        StorePendingReplies storePendingReplies = new StorePendingReplies(this.dispatcher, null, 2, null);
        this.pendingReplies = storePendingReplies;
        StoreApplicationCommands storeApplicationCommands = new StoreApplicationCommands(this.gatewaySocket, this.permissions, storeApplicationCommandFrecency, this.guilds, this.users, this.experiments, this.dispatcher, null, ObservationDeckProvider.get(), null, null, 1664, null);
        this.applicationCommands = storeApplicationCommands;
        StoreLocalActionComponentState storeLocalActionComponentState = new StoreLocalActionComponentState(this.dispatcher, null, 2, null);
        this.localActionComponentState = storeLocalActionComponentState;
        StoreApplicationInteractions storeApplicationInteractions = new StoreApplicationInteractions(this, this.dispatcher, this.messages, storeLocalActionComponentState, this.users, this.clock, null, null, null, null, 960, null);
        this.applicationInteractions = storeApplicationInteractions;
        StoreGuildMemberVerificationForm storeGuildMemberVerificationForm = new StoreGuildMemberVerificationForm(this.dispatcher, null, null, 6, null);
        this.memberVerificationForms = storeGuildMemberVerificationForm;
        StorePhone storePhone = new StorePhone(this.dispatcher);
        this.phone = storePhone;
        StoreThreadsActive storeThreadsActive = new StoreThreadsActive(this.channels, null, 2, null);
        this.threadsActive = storeThreadsActive;
        StoreThreadsActiveJoined storeThreadsActiveJoined = new StoreThreadsActiveJoined(storeThreadsActive, this.threadsJoined, ObservationDeckProvider.get());
        this.threadsActiveJoined = storeThreadsActiveJoined;
        StoreThreadMessages storeThreadMessages = new StoreThreadMessages(this.messages, this.channels, ObservationDeckProvider.get());
        this.threadMessages = storeThreadMessages;
        StoreForumPostMessages storeForumPostMessages = new StoreForumPostMessages(this.dispatcher, this.users, ObservationDeckProvider.get());
        this.forumPostMessages = storeForumPostMessages;
        StoreForumPostReadStates storeForumPostReadStates = new StoreForumPostReadStates(this.dispatcher, this.gatewaySocket, storeThreadsActive, this.messageAck, this.channels, this.users, ObservationDeckProvider.get());
        this.forumPostReadStates = storeForumPostReadStates;
        ArchivedThreadsStore archivedThreadsStore = new ArchivedThreadsStore(this, this.dispatcher, storeForumPostMessages, ObservationDeckProvider.get());
        this.archivedThreads = archivedThreadsStore;
        StoreThreadDraft storeThreadDraft = new StoreThreadDraft(this.dispatcher);
        this.threadDraft = storeThreadDraft;
        StoreExpressionSuggestions storeExpressionSuggestions = new StoreExpressionSuggestions(ObservationDeckProvider.get(), this.dispatcher, null, 4, null);
        this.expressionSuggestions = storeExpressionSuggestions;
        StoreStageChannels storeStageChannels = new StoreStageChannels(this.users, this.guilds, this.channels, this.voiceStates, this.permissions, this.stageInstances, null, 64, null);
        this.stageChannels = storeStageChannels;
        StoreStageChannelSelfPresence storeStageChannelSelfPresence = new StoreStageChannelSelfPresence(ObservationDeckProvider.get(), this.users, this.presences, storeStageChannels, this.voiceChannelSelected, this.userSettings, this.dispatcher);
        this.stageSelfPresence = storeStageChannelSelfPresence;
        StoreAutocomplete storeAutocomplete = new StoreAutocomplete(ObservationDeckProvider.get(), this.dispatcher);
        this.autocomplete = storeAutocomplete;
        StoreContactSync storeContactSync = new StoreContactSync(this.dispatcher, restAPI$Companion.getApi(), this.clock, this.userConnections, this.users, this.experiments, this.notices, this.userSettings);
        this.contactSync = storeContactSync;
        Dispatcher dispatcher2 = this.dispatcher;
        StoreFriendSuggestions storeFriendSuggestions = new StoreFriendSuggestions(this, dispatcher2, new FriendSuggestionsFetcher(dispatcher2, restAPI$Companion.getApi(), new StoreStream$friendSuggestions$1(this), new StoreStream$friendSuggestions$2(this)));
        this.friendSuggestions = storeFriendSuggestions;
        StoreGuildStickers storeGuildStickers = new StoreGuildStickers(this.dispatcher, null, new StoreStream$guildStickers$1(this), 2, null);
        this.guildStickers = storeGuildStickers;
        StoreOutboundPromotions storeOutboundPromotions = new StoreOutboundPromotions(new OutboundPromosPreviewFeatureFlag(this.experiments), this.dispatcher, null, null, 12, null);
        this.outboundPromotions = storeOutboundPromotions;
        StoreGuildScheduledEvents storeGuildScheduledEvents = new StoreGuildScheduledEvents(this.dispatcher, ObservationDeckProvider.get(), this.permissions, this.users, this.guilds, this.clock, this.experiments);
        this.guildScheduledEvents = storeGuildScheduledEvents;
        StoreDirectories storeDirectories = new StoreDirectories(this.dispatcher, ObservationDeckProvider.get(), this.guilds, storeGuildScheduledEvents, null, 16, null);
        this.directories = storeDirectories;
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = new StoreGuildRoleSubscriptions(this.dispatcher, null, 2, null);
        this.guildRoleSubscriptions = storeGuildRoleSubscriptions;
        StoreNotificationUpsells storeNotificationUpsells = new StoreNotificationUpsells(this.dispatcher, null, 2, null);
        this.notificationUpsells = storeNotificationUpsells;
        ConnectionTimeStats connectionTimeStats = new ConnectionTimeStats(this.clock);
        this.connectionTimeStats = connectionTimeStats;
        StoreEmbeddedActivities storeEmbeddedActivities = new StoreEmbeddedActivities(null, 1, null);
        this.embeddedActivities = storeEmbeddedActivities;
        StoreGuildRoleMemberCounts storeGuildRoleMemberCounts = new StoreGuildRoleMemberCounts(this.dispatcher, this.clock, null, 4, null);
        this.guildRoleMemberCounts = storeGuildRoleMemberCounts;
        List<StoreV2> listListOf = n.listOf((Object[]) new StoreV2[]{this.bans, this.users, this.guilds, this.channels, this.channelConversions, this.presences, this.permissions, this.voiceChannelSelected, this.voiceSpeaking, this.accessibility, this.callsIncoming, this.connectivity, this.connectionOpen, storeGuildWelcomeScreens, storeGuildVoiceRegions, this.videoStreams, storeClientDataState, storeGifPicker, storeStickers, this.guildMemberCounts, this.guildJoinRequests, this.experiments, this.messageReplies, storeChannelFollowerStats, storePendingReplies, storeGuildProfiles, this.application, this.applicationAssets, storeApplicationCommands, this.guildSelected, this.channelsSelected, this.pinnedMessages, storeGuildMemberVerificationForm, this.userRequiredAction, this.userSurvey, storePhone, storeThreadsActive, this.threadsJoined, storeThreadsActiveJoined, storeThreadMessages, archivedThreadsStore, storeThreadDraft, storeExpressionPickerNavigation, storeGuildBoost, this.collapsedChannelCategories, this.messageUploads, storeExpressionSuggestions, this.applicationStreaming, storeApplicationInteractions, storeApplicationCommandFrecency, storeLocalActionComponentState, this.stageInstances, this.requestedStageChannels, storeStageChannels, storeStageChannelSelfPresence, storeAutocomplete, this.messageReactions, this.library, this.userRelationships, this.userSettingsSystem, this.tabsNavigation, this.voiceStates, this.mentions, storeUserAffinities, this.userProfile, this.userConnections, this.messagesMostRecent, this.usersTyping, this.instantInvites, this.guildSettings, this.customEmojis, storeEntitlements, this.mediaFavorites, this.subscriptions, storeGooglePlayPurchases, storeGooglePlaySkuDetails, this.guildTemplates, this.userNotes, this.mfa, this.messageAck, this.guildSubscriptions, this.lazyChannelMembersStore, this.lazyThreadMembersStore, this.guildEmojis, this.guildsSorted, this.auditLog, this.expandedGuildFolders, this.maskedLinks, this.streamRtcConnection, this.paymentSources, storeContactSync, this.applicationStreamPreviews, this.guildsNsfw, this.gameParty, storeFriendSuggestions, this.chat, this.audioManagerV2, storeGuildStickers, storeOutboundPromotions, storeDirectories, storeGuildScheduledEvents, storeGuildRoleSubscriptions, storeNotificationUpsells, storeEmbeddedActivities, storeGuildRoleMemberCounts, storeForumPostMessages, storeForumPostReadStates});
        this.storesV2 = listListOf;
        StoreV2DispatchHandler storeV2DispatchHandler = new StoreV2DispatchHandler(listListOf, null, 2, null);
        this.storeV2DispatchHandler = storeV2DispatchHandler;
        this.dispatcher.registerDispatchHandlers(storeV2DispatchHandler);
        connectionTimeStats.addListener(this.rtcConnection);
        connectionTimeStats.addListener(this.streamRtcConnection);
        connectionTimeStats.addListener(this.mediaEngine);
    }

    public static final /* synthetic */ void access$deferredInit(StoreStream storeStream, Application application) {
        storeStream.deferredInit(application);
    }

    public static final /* synthetic */ void access$dispatchSubscribe(StoreStream storeStream, Observable observable, String str, Function1 function1) {
        storeStream.dispatchSubscribe(observable, str, function1);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreStream storeStream) {
        return storeStream.clock;
    }

    public static final /* synthetic */ Lazy access$getCollector$cp() {
        return collector$delegate;
    }

    public static final /* synthetic */ StoreEmojiCustom access$getCustomEmojis$p(StoreStream storeStream) {
        return storeStream.customEmojis;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreStream storeStream) {
        return storeStream.dispatcher;
    }

    public static final /* synthetic */ BehaviorSubject access$getInitialized$p(StoreStream storeStream) {
        return storeStream.initialized;
    }

    public static final /* synthetic */ String access$getLAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY$cp() {
        return LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY;
    }

    public static final /* synthetic */ long access$getSTORE_THREAD_ID$cp() {
        return STORE_THREAD_ID;
    }

    public static final /* synthetic */ String access$getSTORE_THREAD_NAME$cp() {
        return STORE_THREAD_NAME;
    }

    public static final /* synthetic */ StoreStreamRtcConnection access$getStreamRtcConnection$p(StoreStream storeStream) {
        return storeStream.streamRtcConnection;
    }

    public static final /* synthetic */ void access$guildScheduledEventUserAdd(StoreStream storeStream, GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        storeStream.guildScheduledEventUserAdd(guildScheduledEventUserUpdate);
    }

    public static final /* synthetic */ void access$guildScheduledEventUserRemove(StoreStream storeStream, GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        storeStream.guildScheduledEventUserRemove(guildScheduledEventUserUpdate);
    }

    public static final /* synthetic */ void access$handleAuthState(StoreStream storeStream, AuthState authState) {
        storeStream.handleAuthState(authState);
    }

    public static final /* synthetic */ void access$handleBackgrounded(StoreStream storeStream, boolean z2) {
        storeStream.handleBackgrounded(z2);
    }

    public static final /* synthetic */ void access$handleBanAdd(StoreStream storeStream, ModelBan modelBan) {
        storeStream.handleBanAdd(modelBan);
    }

    public static final /* synthetic */ void access$handleBanRemove(StoreStream storeStream, ModelBan modelBan) {
        storeStream.handleBanRemove(modelBan);
    }

    public static final /* synthetic */ void access$handleCallCreateOrUpdate(StoreStream storeStream, ModelCall modelCall) {
        storeStream.handleCallCreateOrUpdate(modelCall);
    }

    public static final /* synthetic */ void access$handleCallDelete(StoreStream storeStream, ModelCall modelCall) {
        storeStream.handleCallDelete(modelCall);
    }

    public static final /* synthetic */ void access$handleChannelCreateOrUpdate(StoreStream storeStream, Channel channel) {
        storeStream.handleChannelCreateOrUpdate(channel);
    }

    public static final /* synthetic */ void access$handleChannelDelete(StoreStream storeStream, Channel channel) {
        storeStream.handleChannelDelete(channel);
    }

    public static final /* synthetic */ void access$handleChannelSelected(StoreStream storeStream, long j) {
        storeStream.handleChannelSelected(j);
    }

    public static final /* synthetic */ void access$handleChannelUnreadUpdate(StoreStream storeStream, ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
        storeStream.handleChannelUnreadUpdate(modelChannelUnreadUpdate);
    }

    public static final /* synthetic */ void access$handleConnected(StoreStream storeStream, boolean z2) {
        storeStream.handleConnected(z2);
    }

    public static final /* synthetic */ void access$handleConnectionOpen(StoreStream storeStream, ModelPayload modelPayload) {
        storeStream.handleConnectionOpen(modelPayload);
    }

    public static final /* synthetic */ void access$handleConnectionReady(StoreStream storeStream, boolean z2) {
        storeStream.handleConnectionReady(z2);
    }

    public static final /* synthetic */ void access$handleEmbeddedActivityInboundUpdate(StoreStream storeStream, EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        storeStream.handleEmbeddedActivityInboundUpdate(embeddedActivityInboundUpdate);
    }

    public static final /* synthetic */ void access$handleEmojiUpdate(StoreStream storeStream, GuildEmojisUpdate guildEmojisUpdate) {
        storeStream.handleEmojiUpdate(guildEmojisUpdate);
    }

    public static final /* synthetic */ void access$handleFingerprint(StoreStream storeStream, String str) {
        storeStream.handleFingerprint(str);
    }

    public static final /* synthetic */ void access$handleForumUnreads(StoreStream storeStream, ForumUnreads forumUnreads) {
        storeStream.handleForumUnreads(forumUnreads);
    }

    public static final /* synthetic */ void access$handleFriendSuggestionsFetchFailure(StoreStream storeStream) {
        storeStream.handleFriendSuggestionsFetchFailure();
    }

    public static final /* synthetic */ void access$handleFriendSuggestionsFetched(StoreStream storeStream, List list) {
        storeStream.handleFriendSuggestionsFetched(list);
    }

    public static final /* synthetic */ void access$handleGroupDMRecipientAdd(StoreStream storeStream, ChannelRecipient channelRecipient) {
        storeStream.handleGroupDMRecipientAdd(channelRecipient);
    }

    public static final /* synthetic */ void access$handleGroupDMRecipientRemove(StoreStream storeStream, ChannelRecipient channelRecipient) {
        storeStream.handleGroupDMRecipientRemove(channelRecipient);
    }

    public static final /* synthetic */ void access$handleGuildApplicationCommands(StoreStream storeStream, GuildApplicationCommands guildApplicationCommands) {
        storeStream.handleGuildApplicationCommands(guildApplicationCommands);
    }

    public static final /* synthetic */ void access$handleGuildCreate(StoreStream storeStream, Guild guild) {
        storeStream.handleGuildCreate(guild);
    }

    public static final /* synthetic */ void access$handleGuildIntegrationUpdate(StoreStream storeStream, ModelGuildIntegration$Update modelGuildIntegration$Update) {
        storeStream.handleGuildIntegrationUpdate(modelGuildIntegration$Update);
    }

    public static final /* synthetic */ void access$handleGuildMemberAdd(StoreStream storeStream, GuildMember guildMember) {
        storeStream.handleGuildMemberAdd(guildMember);
    }

    public static final /* synthetic */ void access$handleGuildMemberListUpdate(StoreStream storeStream, ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
        storeStream.handleGuildMemberListUpdate(modelGuildMemberListUpdate);
    }

    public static final /* synthetic */ void access$handleGuildMemberRemove(StoreStream storeStream, GuildMemberRemove guildMemberRemove) {
        storeStream.handleGuildMemberRemove(guildMemberRemove);
    }

    public static final /* synthetic */ void access$handleGuildMembersChunk(StoreStream storeStream, GuildMembersChunk guildMembersChunk) {
        storeStream.handleGuildMembersChunk(guildMembersChunk);
    }

    public static final /* synthetic */ void access$handleGuildRemove(StoreStream storeStream, Guild guild) {
        storeStream.handleGuildRemove(guild);
    }

    public static final /* synthetic */ void access$handleGuildRoleCreate(StoreStream storeStream, GuildRoleCreate guildRoleCreate) {
        storeStream.handleGuildRoleCreate(guildRoleCreate);
    }

    public static final /* synthetic */ void access$handleGuildRoleDelete(StoreStream storeStream, GuildRoleDelete guildRoleDelete) {
        storeStream.handleGuildRoleDelete(guildRoleDelete);
    }

    public static final /* synthetic */ void access$handleGuildRoleUpdate(StoreStream storeStream, GuildRoleUpdate guildRoleUpdate) {
        storeStream.handleGuildRoleUpdate(guildRoleUpdate);
    }

    public static final /* synthetic */ void access$handleGuildScheduledEventCreate(StoreStream storeStream, GuildScheduledEvent guildScheduledEvent) {
        storeStream.handleGuildScheduledEventCreate(guildScheduledEvent);
    }

    public static final /* synthetic */ void access$handleGuildScheduledEventDelete(StoreStream storeStream, GuildScheduledEvent guildScheduledEvent) {
        storeStream.handleGuildScheduledEventDelete(guildScheduledEvent);
    }

    public static final /* synthetic */ void access$handleGuildScheduledEventUpdate(StoreStream storeStream, GuildScheduledEvent guildScheduledEvent) {
        storeStream.handleGuildScheduledEventUpdate(guildScheduledEvent);
    }

    public static final /* synthetic */ void access$handleGuildSettingUpdated(StoreStream storeStream, ModelNotificationSettings modelNotificationSettings) {
        storeStream.handleGuildSettingUpdated(modelNotificationSettings);
    }

    public static final /* synthetic */ void access$handleGuildUpdate(StoreStream storeStream, Guild guild) {
        storeStream.handleGuildUpdate(guild);
    }

    public static final /* synthetic */ void access$handleInteractionCreate(StoreStream storeStream, InteractionStateUpdate interactionStateUpdate) {
        storeStream.handleInteractionCreate(interactionStateUpdate);
    }

    public static final /* synthetic */ void access$handleInteractionSuccess(StoreStream storeStream, InteractionStateUpdate interactionStateUpdate) {
        storeStream.handleInteractionSuccess(interactionStateUpdate);
    }

    public static final /* synthetic */ void access$handleMessageAck(StoreStream storeStream, ModelReadState modelReadState) {
        storeStream.handleMessageAck(modelReadState);
    }

    public static final /* synthetic */ void access$handleMessageCreate(StoreStream storeStream, Message message) {
        storeStream.handleMessageCreate(message);
    }

    public static final /* synthetic */ void access$handleMessageDelete(StoreStream storeStream, ModelMessageDelete modelMessageDelete) {
        storeStream.handleMessageDelete(modelMessageDelete);
    }

    public static final /* synthetic */ void access$handleMessageUpdate(StoreStream storeStream, Message message) {
        storeStream.handleMessageUpdate(message);
    }

    public static final /* synthetic */ void access$handleMessagesLoaded(StoreStream storeStream, StoreMessagesLoader$ChannelChunk storeMessagesLoader$ChannelChunk) {
        storeStream.handleMessagesLoaded(storeMessagesLoader$ChannelChunk);
    }

    public static final /* synthetic */ void access$handlePreLogout(StoreStream storeStream) {
        storeStream.handlePreLogout();
    }

    public static final /* synthetic */ void access$handlePresenceReplace(StoreStream storeStream, List list) {
        storeStream.handlePresenceReplace(list);
    }

    public static final /* synthetic */ void access$handlePresenceUpdate(StoreStream storeStream, long j, Presence presence) {
        storeStream.handlePresenceUpdate(j, presence);
    }

    public static final /* synthetic */ void access$handleReactionAdd(StoreStream storeStream, MessageReactionUpdate messageReactionUpdate) {
        storeStream.handleReactionAdd(messageReactionUpdate);
    }

    public static final /* synthetic */ void access$handleReactionRemove(StoreStream storeStream, MessageReactionUpdate messageReactionUpdate) {
        storeStream.handleReactionRemove(messageReactionUpdate);
    }

    public static final /* synthetic */ void access$handleReactionRemoveAll(StoreStream storeStream, MessageReactionUpdate messageReactionUpdate) {
        storeStream.handleReactionRemoveAll(messageReactionUpdate);
    }

    public static final /* synthetic */ void access$handleReactionRemoveEmoji(StoreStream storeStream, MessageReactionUpdate messageReactionUpdate) {
        storeStream.handleReactionRemoveEmoji(messageReactionUpdate);
    }

    public static final /* synthetic */ void access$handleRelationshipRemove(StoreStream storeStream, ModelUserRelationship modelUserRelationship) {
        storeStream.handleRelationshipRemove(modelUserRelationship);
    }

    public static final /* synthetic */ void access$handleRequiredActionUpdate(StoreStream storeStream, UserRequiredActionUpdate userRequiredActionUpdate) {
        storeStream.handleRequiredActionUpdate(userRequiredActionUpdate);
    }

    public static final /* synthetic */ void access$handleRtcConnectionStateChanged(StoreStream storeStream, RtcConnection$StateChange rtcConnection$StateChange) {
        storeStream.handleRtcConnectionStateChanged(rtcConnection$StateChange);
    }

    public static final /* synthetic */ void access$handleSessionsReplace(StoreStream storeStream, List list) {
        storeStream.handleSessionsReplace(list);
    }

    public static final /* synthetic */ void access$handleSpeakingUpdates(StoreStream storeStream, List list) {
        storeStream.handleSpeakingUpdates(list);
    }

    public static final /* synthetic */ void access$handleSpeakingUsers(StoreStream storeStream, Set set) {
        storeStream.handleSpeakingUsers(set);
    }

    public static final /* synthetic */ void access$handleStickersUpdate(StoreStream storeStream, GuildStickersUpdate guildStickersUpdate) {
        storeStream.handleStickersUpdate(guildStickersUpdate);
    }

    public static final /* synthetic */ void access$handleStreamCreate(StoreStream storeStream, StreamCreateOrUpdate streamCreateOrUpdate) {
        storeStream.handleStreamCreate(streamCreateOrUpdate);
    }

    public static final /* synthetic */ void access$handleStreamServerUpdate(StoreStream storeStream, StreamServerUpdate streamServerUpdate) {
        storeStream.handleStreamServerUpdate(streamServerUpdate);
    }

    public static final /* synthetic */ void access$handleStreamUpdate(StoreStream storeStream, StreamCreateOrUpdate streamCreateOrUpdate) {
        storeStream.handleStreamUpdate(streamCreateOrUpdate);
    }

    public static final /* synthetic */ void access$handleThreadDelete(StoreStream storeStream, Channel channel) {
        storeStream.handleThreadDelete(channel);
    }

    public static final /* synthetic */ void access$handleThreadListSync(StoreStream storeStream, ModelThreadListSync modelThreadListSync) {
        storeStream.handleThreadListSync(modelThreadListSync);
    }

    public static final /* synthetic */ void access$handleThreadMemberListUpdate(StoreStream storeStream, ThreadMemberListUpdate threadMemberListUpdate) {
        storeStream.handleThreadMemberListUpdate(threadMemberListUpdate);
    }

    public static final /* synthetic */ void access$handleThreadMemberUpdate(StoreStream storeStream, ThreadMemberUpdate threadMemberUpdate) {
        storeStream.handleThreadMemberUpdate(threadMemberUpdate);
    }

    public static final /* synthetic */ void access$handleThreadMembersUpdate(StoreStream storeStream, ThreadMembersUpdate threadMembersUpdate) {
        storeStream.handleThreadMembersUpdate(threadMembersUpdate);
    }

    public static final /* synthetic */ void access$handleTypingStart(StoreStream storeStream, TypingUser typingUser) {
        storeStream.handleTypingStart(typingUser);
    }

    public static final /* synthetic */ void access$handleUserNoteUpdated(StoreStream storeStream, ModelUserNote$Update modelUserNote$Update) {
        storeStream.handleUserNoteUpdated(modelUserNote$Update);
    }

    public static final /* synthetic */ void access$handleUserPaymentSourcesUpdate(StoreStream storeStream) {
        storeStream.handleUserPaymentSourcesUpdate();
    }

    public static final /* synthetic */ void access$handleUserSettingsUpdate(StoreStream storeStream, ModelUserSettings modelUserSettings) {
        storeStream.handleUserSettingsUpdate(modelUserSettings);
    }

    public static final /* synthetic */ void access$handleUserSubscriptionsUpdate(StoreStream storeStream) {
        storeStream.handleUserSubscriptionsUpdate();
    }

    public static final /* synthetic */ void access$handleUserUpdated(StoreStream storeStream, User user) {
        storeStream.handleUserUpdated(user);
    }

    public static final /* synthetic */ void access$handleVoiceChannelSelected(StoreStream storeStream, long j) {
        storeStream.handleVoiceChannelSelected(j);
    }

    public static final /* synthetic */ void access$handleVoiceServerUpdate(StoreStream storeStream, VoiceServer voiceServer) {
        storeStream.handleVoiceServerUpdate(voiceServer);
    }

    public static final /* synthetic */ void access$handleVoiceStateUpdate(StoreStream storeStream, VoiceState voiceState) {
        storeStream.handleVoiceStateUpdate(voiceState);
    }

    public static final /* synthetic */ void access$init(StoreStream storeStream, Application application) {
        storeStream.init(application);
    }

    public static final /* synthetic */ void access$initGatewaySocketListeners(StoreStream storeStream) {
        storeStream.initGatewaySocketListeners();
    }

    public static final /* synthetic */ boolean access$isInitialized$cp() {
        return isInitialized;
    }

    public static final /* synthetic */ void access$maybeLogNotificationPermissionStatus(StoreStream storeStream, Application application, Clock clock) {
        storeStream.maybeLogNotificationPermissionStatus(application, clock);
    }

    public static final /* synthetic */ void access$setInitialized$cp(boolean z2) {
        isInitialized = z2;
    }

    public static final /* synthetic */ void access$setSTORE_THREAD_ID$cp(long j) {
        STORE_THREAD_ID = j;
    }

    public static final /* synthetic */ void access$startStoreInitializationTimer(StoreStream storeStream, NetworkMonitor networkMonitor) {
        storeStream.startStoreInitializationTimer(networkMonitor);
    }

    private final void deferredInit(Application context) {
        this.dispatcher.schedule(new StoreStream$deferredInit$1(this, context));
    }

    private final <T> void dispatchSubscribe(Observable<T> observable, String str, Function1<? super T, Unit> function1) {
        Observable<T> observableK = observable.K();
        m.checkNotNullExpressionValue(observableK, "onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe$default(observableK, (Context) null, str, (Function1) null, new StoreStream$dispatchSubscribe$1(this, function1), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    public static final StoreAnalytics getAnalytics() {
        return Companion.getAnalytics();
    }

    public static final StoreApplication getApplication() {
        return Companion.getApplication();
    }

    public static final StoreApplicationCommands getApplicationCommands() {
        return Companion.getApplicationCommands();
    }

    public static final StoreApplicationStreamPreviews getApplicationStreamPreviews() {
        return Companion.getApplicationStreamPreviews();
    }

    public static final StoreApplicationStreaming getApplicationStreaming() {
        return Companion.getApplicationStreaming();
    }

    public static final StoreAuditLog getAuditLog() {
        return Companion.getAuditLog();
    }

    public static final StoreAuthentication getAuthentication() {
        return Companion.getAuthentication();
    }

    public static final StoreBans getBans() {
        return Companion.getBans();
    }

    public static final StoreCalls getCalls() {
        return Companion.getCalls();
    }

    public static final StoreCallsIncoming getCallsIncoming() {
        return Companion.getCallsIncoming();
    }

    public static final StoreChangeLog getChangeLog() {
        return Companion.getChangeLog();
    }

    public static final StoreChannelFollowerStats getChannelFollowerStats() {
        return Companion.getChannelFollowerStats();
    }

    public static final StoreChannelMembers getChannelMembers() {
        return Companion.getChannelMembers();
    }

    public static final StoreChannels getChannels() {
        return Companion.getChannels();
    }

    public static final StoreChannelsSelected getChannelsSelected() {
        return Companion.getChannelsSelected();
    }

    public static final StoreChat getChat() {
        return Companion.getChat();
    }

    public static final StoreConnectivity getConnectivity() {
        return Companion.getConnectivity();
    }

    public static final Dispatcher getDispatcherYesThisIsIntentional() {
        return Companion.getDispatcherYesThisIsIntentional();
    }

    public static final StoreDynamicLink getDynamicLinkCache() {
        return Companion.getDynamicLinkCache();
    }

    public static final StoreEmoji getEmojis() {
        return Companion.getEmojis();
    }

    public static final StoreEntitlements getEntitlements() {
        return Companion.getEntitlements();
    }

    public static final StoreExpandedGuildFolders getExpandedGuildFolders() {
        return Companion.getExpandedGuildFolders();
    }

    public static final StoreExperiments getExperiments() {
        return Companion.getExperiments();
    }

    public static final StoreGameParty getGameParty() {
        return Companion.getGameParty();
    }

    public static final StoreGatewayConnection getGatewaySocket() {
        return Companion.getGatewaySocket();
    }

    public static final StoreGifting getGifting() {
        return Companion.getGifting();
    }

    public static final StoreGuildBoost getGuildBoosts() {
        return Companion.getGuildBoosts();
    }

    public static final StoreEmojiGuild getGuildEmojis() {
        return Companion.getGuildEmojis();
    }

    public static final StoreGuildIntegrations getGuildIntegrations() {
        return Companion.getGuildIntegrations();
    }

    public static final StoreGuildJoinRequest getGuildJoinRequests() {
        return Companion.getGuildJoinRequests();
    }

    public static final StoreGuildMemberCounts getGuildMemberCounts() {
        return Companion.getGuildMemberCounts();
    }

    public static final StoreGuildProfiles getGuildProfiles() {
        return Companion.getGuildProfiles();
    }

    public static final StoreGuildScheduledEvents getGuildScheduledEvents() {
        return Companion.getGuildScheduledEvents();
    }

    public static final StoreGuildSelected getGuildSelected() {
        return Companion.getGuildSelected();
    }

    public static final StoreGuildSubscriptions getGuildSubscriptions() {
        return Companion.getGuildSubscriptions();
    }

    public static final StoreGuildTemplates getGuildTemplates() {
        return Companion.getGuildTemplates();
    }

    public static final StoreGuildVoiceRegions getGuildVoiceRegions() {
        return Companion.getGuildVoiceRegions();
    }

    public static final StoreGuildWelcomeScreens getGuildWelcomeScreens() {
        return Companion.getGuildWelcomeScreens();
    }

    public static final StoreGuilds getGuilds() {
        return Companion.getGuilds();
    }

    public static final StoreGuildsNsfw getGuildsNsfw() {
        return Companion.getGuildsNsfw();
    }

    public static final StoreGuildsSorted getGuildsSorted() {
        return Companion.getGuildsSorted();
    }

    public static final StoreInstantInvites getInstantInvites() {
        return Companion.getInstantInvites();
    }

    public static final StoreApplicationInteractions getInteractions() {
        return Companion.getInteractions();
    }

    public static final StoreInviteSettings getInviteSettings() {
        return Companion.getInviteSettings();
    }

    public static final StoreLibrary getLibrary() {
        return Companion.getLibrary();
    }

    public static final StoreLurking getLurking() {
        return Companion.getLurking();
    }

    public static final StoreMFA getMFA() {
        return Companion.getMFA();
    }

    public static final StoreMediaEngine getMediaEngine() {
        return Companion.getMediaEngine();
    }

    public static final StoreMediaSettings getMediaSettings() {
        return Companion.getMediaSettings();
    }

    public static final StoreGuildMemberVerificationForm getMemberVerificationForms() {
        return Companion.getMemberVerificationForms();
    }

    public static final StoreMentions getMentions() {
        return Companion.getMentions();
    }

    public static final StoreMessageAck getMessageAck() {
        return Companion.getMessageAck();
    }

    public static final StoreMessageReactions getMessageReactions() {
        return Companion.getMessageReactions();
    }

    public static final StoreMessageState getMessageState() {
        return Companion.getMessageState();
    }

    public static final StoreMessageUploads getMessageUploads() {
        return Companion.getMessageUploads();
    }

    public static final StoreMessages getMessages() {
        return Companion.getMessages();
    }

    public static final StoreMessagesLoader getMessagesLoader() {
        return Companion.getMessagesLoader();
    }

    public static final StoreMessagesMostRecent getMessagesMostRecent() {
        return Companion.getMessagesMostRecent();
    }

    public static final StoreNavigation getNavigation() {
        return Companion.getNavigation();
    }

    public static final StoreNotices getNotices() {
        return Companion.getNotices();
    }

    public static final StoreNotifications getNotifications() {
        return Companion.getNotifications();
    }

    public static final StoreNux getNux() {
        return Companion.getNux();
    }

    public static final StorePaymentSources getPaymentSources() {
        return Companion.getPaymentSources();
    }

    public static final StorePermissions getPermissions() {
        return Companion.getPermissions();
    }

    public static final StorePinnedMessages getPinnedMessages() {
        return Companion.getPinnedMessages();
    }

    public static final StoreUserPresence getPresences() {
        return Companion.getPresences();
    }

    public static final StoreReadStates getReadStates() {
        return Companion.getReadStates();
    }

    public static final StoreMessageReplies getRepliedMessages() {
        return Companion.getRepliedMessages();
    }

    public static final StoreReviewRequest getReviewRequest() {
        return Companion.getReviewRequest();
    }

    public static final StoreRtcConnection getRtcConnection() {
        return Companion.getRtcConnection();
    }

    public static final StoreSearch getSearch() {
        return Companion.getSearch();
    }

    public static final StoreSlowMode getSlowMode() {
        return Companion.getSlowMode();
    }

    public static final StoreSpotify getSpotify() {
        return Companion.getSpotify();
    }

    public static final StoreStageChannels getStageChannels() {
        return Companion.getStageChannels();
    }

    public static final StoreCollapsedChannelCategories getStoreChannelCategories() {
        return Companion.getStoreChannelCategories();
    }

    public static final StoreStreamRtcConnection getStreamRtcConnection() {
        return Companion.getStreamRtcConnection();
    }

    public static final StoreSubscriptions getSubscriptions() {
        return Companion.getSubscriptions();
    }

    public static final StoreThreadMembers getThreadMembers() {
        return Companion.getThreadMembers();
    }

    public static final StoreThreadMessages getThreadMessages() {
        return Companion.getThreadMessages();
    }

    public static final StoreThreadsActive getThreadsActive() {
        return Companion.getThreadsActive();
    }

    public static final StoreUserAffinities getUserAffinities() {
        return Companion.getUserAffinities();
    }

    public static final StoreUserConnections getUserConnections() {
        return Companion.getUserConnections();
    }

    public static final StoreUserGuildSettings getUserGuildSettings() {
        return Companion.getUserGuildSettings();
    }

    public static final StoreUserProfile getUserProfile() {
        return Companion.getUserProfile();
    }

    public static final StoreUserRelationships getUserRelationships() {
        return Companion.getUserRelationships();
    }

    public static final StoreUserRequiredActions getUserRequiredActions() {
        return Companion.getUserRequiredActions();
    }

    public static final StoreUserSettings getUserSettings() {
        return Companion.getUserSettings();
    }

    public static final StoreUserSettingsSystem getUserSettingsSystem() {
        return Companion.getUserSettingsSystem();
    }

    public static final StoreUserSurvey getUserSurvey() {
        return Companion.getUserSurvey();
    }

    public static final StoreUser getUsers() {
        return Companion.getUsers();
    }

    public static final StoreUserNotes getUsersNotes() {
        return Companion.getUsersNotes();
    }

    public static final StoreUserTyping getUsersTyping() {
        return Companion.getUsersTyping();
    }

    public static final StoreVoiceChannelSelected getVoiceChannelSelected() {
        return Companion.getVoiceChannelSelected();
    }

    public static final StoreVoiceParticipants getVoiceParticipants() {
        return Companion.getVoiceParticipants();
    }

    public static final StoreVoiceStates getVoiceStates() {
        return Companion.getVoiceStates();
    }

    @StoreThread
    private final void guildScheduledEventUserAdd(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        this.guildScheduledEvents.handleGuildScheduledEventUserAdd(guildScheduledEventUserUpdate);
    }

    @StoreThread
    private final void guildScheduledEventUserRemove(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        this.guildScheduledEvents.handleGuildScheduledEventUserRemove(guildScheduledEventUserUpdate);
    }

    @StoreThread
    private final void handleAuthState(AuthState authState) {
        this.authentication.handleAuthState$app_productionGoogleRelease(authState);
        this.users.handleAuthToken(authState != null ? authState.getToken() : null);
        this.messagesLoader.handleAuthToken(authState != null ? authState.getToken() : null);
        this.notifications.handleAuthToken(authState != null ? authState.getToken() : null);
        this.experiments.handleAuthToken(authState != null ? authState.getToken() : null);
        this.analytics.handleAuthToken(authState != null ? authState.getToken() : null);
        this.voiceChannelSelected.handleAuthToken(authState != null ? authState.getToken() : null);
        this.voiceStates.handleAuthToken(authState != null ? authState.getToken() : null);
    }

    @StoreThread
    private final void handleBackgrounded(boolean backgrounded) {
        AppLog.i("[StoreStream] Application backgrounded: " + backgrounded);
        this.connectivity.handleBackgrounded(backgrounded);
        this.messagesLoader.handleBackgrounded(backgrounded);
    }

    @StoreThread
    private final void handleBanAdd(ModelBan ban) {
        this.bans.handleBanAdd(ban);
    }

    @StoreThread
    private final void handleBanRemove(ModelBan ban) {
        this.bans.handleBanRemove(ban);
    }

    @StoreThread
    private final void handleCallCreateOrUpdate(ModelCall call) {
        this.calls.handleCallCreateOrUpdate(call);
        this.callsIncoming.handleCallCreateOrUpdate(call);
        List<VoiceState> voiceStates = call.getVoiceStates();
        if (voiceStates != null) {
            for (VoiceState voiceState : voiceStates) {
                m.checkNotNullExpressionValue(voiceState, "voiceState");
                handleVoiceStateUpdate(voiceState);
            }
        }
    }

    @StoreThread
    private final void handleCallDelete(ModelCall callDelete) {
        this.callsIncoming.handleCallDelete(callDelete);
        this.calls.handleCallDelete(callDelete);
    }

    @StoreThread
    private final void handleChannelCreateOrUpdate(Channel channel) {
        this.users.handleChannelCreated(channel);
        this.channelConversions.handleChannelCreateOrUpdate(channel);
        this.channels.handleChannelOrThreadCreateOrUpdate(channel);
        this.channelsSelected.handleChannelOrThreadCreateOrUpdate(channel);
        this.permissions.handleChannelOrThreadCreateOrUpdate(channel);
        this.voiceChannelSelected.handleChannelOrThreadCreateOrUpdate();
        this.mentions.handleChannelOrThreadCreateOrUpdate(channel);
        this.messagesMostRecent.handleChannelCreateOrUpdate(channel);
        this.clientDataState.handleChannelCreateOrUpdateOrDelete(channel);
        this.threadsActive.handleChannelCreateOrUpdate(channel);
        this.threadsActiveJoined.handleChannelCreateOrUpdate(channel);
    }

    @StoreThread
    private final void handleChannelDelete(Channel channel) {
        handleChannelOrThreadDelete(channel);
    }

    @StoreThread
    private final void handleChannelOrThreadDelete(Channel channel) {
        this.channels.handleChannelOrThreadDelete(channel);
        this.stageInstances.handleChannelDelete(channel);
        this.permissions.handleChannelOrThreadDelete(channel);
        this.voiceChannelSelected.handleChannelOrThreadDelete();
        this.clientDataState.handleChannelCreateOrUpdateOrDelete(channel);
        this.channelsSelected.handleChannelOrThreadDelete(channel);
        this.threadMessages.handleChannelDelete(channel);
        this.stageChannels.handleChannelDelete(channel);
        this.mentions.handleChannelOrThreadDelete(channel);
        Iterator<T> it = this.channels.getThreadsForChannelInternal$app_productionGoogleRelease(channel.getId()).iterator();
        while (it.hasNext()) {
            handleChannelOrThreadDelete((Channel) it.next());
        }
    }

    @StoreThread
    private final void handleChannelSelected(long channelId) {
        this.channelConversions.handleChannelSelected(channelId);
        this.calls.handleChannelSelect(channelId);
        this.mentions.handleChannelSelected(channelId);
        this.messages.handleChannelSelected(channelId);
        this.messagesLoader.handleChannelSelected(channelId);
        this.messageStates.handleChannelSelected();
        this.messageAck.handleChannelSelected();
        this.notifications.handleChannelSelected(channelId);
        this.expressionSuggestions.handleChannelSelected();
        this.applicationInteractions.handleChannelSelected();
    }

    @StoreThread
    private final void handleChannelUnreadUpdate(ModelChannelUnreadUpdate channelUnreadUpdate) {
        this.messagesMostRecent.handleChannelUnreadUpdate(channelUnreadUpdate);
    }

    @StoreThread
    private final void handleConnected(boolean connected) {
        this.messages.handleConnected(connected);
        this.messagesLoader.handleConnected(connected);
        this.analytics.handleConnected(connected);
        this.connectivity.handleConnected(connected);
        this.connectionOpen.handleConnected(connected);
        this.channels.handleConnected(connected);
    }

    @StoreThread
    private final void handleConnectionOpen(ModelPayload payload_) {
        TimeElapsed timeElapsed = new TimeElapsed(this.clock, 0L, 2, null);
        ReadyPayloadUtils$HydrateResult readyPayloadUtils$HydrateResultHydrateReadyPayload = ReadyPayloadUtils.INSTANCE.hydrateReadyPayload(payload_, this.guilds, this.channels, this.customEmojis, this.guildStickers);
        if (!(readyPayloadUtils$HydrateResultHydrateReadyPayload instanceof ReadyPayloadUtils$HydrateResult$Success)) {
            handleHydrateError();
            return;
        }
        ModelPayload payload = ((ReadyPayloadUtils$HydrateResult$Success) readyPayloadUtils$HydrateResultHydrateReadyPayload).getPayload();
        String authToken = payload.getAuthToken();
        if (authToken != null) {
            handleAuthState(AuthState.Companion.from(authToken, n0.emptySet()));
            this.authentication.setAuthed(authToken);
        }
        this.users.handleConnectionOpen(payload);
        this.userConnections.handleConnectionOpen(payload);
        this.userSettings.handleConnectionOpen(payload);
        this.userSettingsSystem.handleConnectionOpen(payload);
        this.userRelationships.handleConnectionOpen(payload);
        this.userRequiredAction.handleConnectionOpen(payload);
        this.userSurvey.handleConnectionOpen();
        this.guilds.handleConnectionOpen(payload);
        this.guildMemberCounts.handleConnectionOpen(payload);
        this.guildJoinRequests.handleConnectionOpen(payload);
        this.guildSelected.handleConnectionOpen(payload);
        this.guildSettings.handleConnectionOpen$app_productionGoogleRelease(payload);
        this.lurking.handleConnectionOpen$app_productionGoogleRelease(payload);
        this.channels.handleConnectionOpen(payload);
        this.stageChannels.handleConnectionOpen();
        this.stageInstances.handleConnectionOpen(payload);
        this.threadsActive.handleConnectionOpen();
        this.threadsJoined.handleConnectionOpen(payload);
        this.threadsActiveJoined.handleConnectionOpen();
        this.channelsSelected.handleConnectionOpen(payload);
        this.collapsedChannelCategories.handleConnectionOpen(payload);
        this.voiceStates.handleConnectionOpen(payload);
        this.applicationStreaming.handleConnectionOpen(payload);
        this.permissions.handleConnectionOpen();
        this.customEmojis.handleConnectionOpen(payload);
        this.presences.handleConnectionOpen(payload);
        this.userNotes.handleConnectionOpen();
        this.voiceChannelSelected.handleConnectionOpen(payload);
        this.mentions.handleConnectionOpen(payload);
        this.rtcConnection.handleConnectionOpen(payload);
        this.analytics.handleConnectionOpen(payload);
        this.experiments.handleConnectionOpen(payload);
        this.messages.handleConnectionOpen(payload);
        this.messagesMostRecent.handleConnectionOpen(payload);
        this.messageAck.handleConnectionOpen(payload);
        this.calls.handleConnectionOpen();
        this.mediaEngine.handleConnectionOpen(payload);
        this.gameParty.handleConnectionOpen(payload);
        this.guildMemberRequesterStore.handleConnectionOpen();
        this.reviewRequestStore.handleConnectionOpen(payload);
        this.connectionOpen.handleConnectionOpen();
        this.messageReactions.handleConnectionOpen();
        this.spotify.handleConnectionOpen(payload);
        this.changeLogStore.handleConnectionOpen();
        this.streamRtcConnection.handleConnectionOpen(payload);
        this.rtcRegion.handleConnectionOpen$app_productionGoogleRelease();
        this.userAffinities.handleConnectionOpen();
        this.clientDataState.handleConnectionOpen(payload);
        this.phone.handleConnectionOpen(payload);
        this.threadMessages.handleConnectionOpen(payload);
        this.archivedThreads.handleConnectionOpen();
        this.contactSync.handleConnectionOpen();
        this.friendSuggestions.handleConnectionOpen(payload);
        this.guildStickers.handleConnectionOpen(payload);
        this.outboundPromotions.handleConnectionOpen$app_productionGoogleRelease(payload);
        this.lazyThreadMembersStore.handleConnectionOpen();
        this.connectionTimeStats.handleConnectionOpen(payload);
        this.guildScheduledEvents.handleConnectionOpen(payload);
        this.embeddedActivities.handleConnectionOpen(payload);
        this.applicationCommands.handleConnectionOpen(payload);
        this.applicationInteractions.handleConnectionOpen(payload);
        this.forumPostMessages.handleConnectionOpen(payload);
        this.forumPostReadStates.handleConnectionOpen(payload);
        AppLog.i("[StoreStream] Processed ready payload in " + timeElapsed.getSeconds() + " seconds");
    }

    @StoreThread
    private final void handleConnectionReady(boolean connectionReady) {
        this.rtcConnection.handleConnectionReady(connectionReady);
        this.calls.handleConnectionReady(connectionReady);
        this.connectivity.handleConnectionReady(connectionReady);
        this.guildSubscriptions.handleConnectionReady(connectionReady);
        this.guildMemberRequesterStore.handleConnectionReady(connectionReady);
        this.spotify.handleConnectionReady(connectionReady);
        this.applicationCommands.handleConnectionReady(connectionReady);
        this.applicationInteractions.handleConnectionReady(connectionReady);
    }

    @StoreThread
    private final void handleEmbeddedActivityInboundUpdate(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        this.embeddedActivities.handleEmbeddedActivityInboundUpdate(embeddedActivityInboundUpdate);
    }

    @StoreThread
    private final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        this.customEmojis.handleEmojiUpdate(emojiUpdate);
        this.guildEmojis.handleEmojiUpdate(emojiUpdate);
        this.clientDataState.handleEmojiUpdate(emojiUpdate);
    }

    @StoreThread
    private final void handleFingerprint(String fingerprint) {
        this.experiments.handleFingerprint(fingerprint);
        this.analytics.handleFingerprint(fingerprint);
    }

    @StoreThread
    private final void handleForumUnreads(ForumUnreads forumUnreads) {
        this.forumPostReadStates.handleForumUnreads(forumUnreads);
    }

    @StoreThread
    private final void handleFriendSuggestionsFetchFailure() {
        this.friendSuggestions.handleFriendSuggestionsLoadFailure();
    }

    @StoreThread
    private final void handleFriendSuggestionsFetched(List<FriendSuggestion> friendSuggestions) {
        handleFriendSuggestionsLoaded(friendSuggestions);
    }

    @StoreThread
    private final void handleGroupDMRecipientAdd(ChannelRecipient recipient) {
        this.channels.handleGroupDMRecipient(recipient, true);
    }

    @StoreThread
    private final void handleGroupDMRecipientRemove(ChannelRecipient recipient) {
        this.channels.handleGroupDMRecipient(recipient, false);
    }

    @StoreThread
    private final void handleGuildApplicationCommands(GuildApplicationCommands commandsGateway) {
        this.applicationCommands.handleApplicationCommandsUpdate(commandsGateway);
    }

    @StoreThread
    private final void handleGuildCreate(Guild guild) {
        handleGuildCreateOrUpdate(guild);
        this.threadsActive.handleGuildCreate();
        this.threadsJoined.handleGuildCreate(guild);
        this.threadsActiveJoined.handleGuildCreate(guild);
        this.messageAck.handleGuildCreate();
        this.threadMessages.handleGuildCreate(guild);
        this.embeddedActivities.handleGuildCreate(guild);
    }

    @StoreThread
    private final void handleGuildCreateOrUpdate(Guild guild_) {
        if (guild_ == null) {
            return;
        }
        ReadyPayloadUtils$HydrateGuildResult readyPayloadUtils$HydrateGuildResultHydrateGuild$default = ReadyPayloadUtils.hydrateGuild$default(ReadyPayloadUtils.INSTANCE, guild_, null, null, 6, null);
        if (!(readyPayloadUtils$HydrateGuildResultHydrateGuild$default instanceof ReadyPayloadUtils$HydrateGuildResult$Success)) {
            handleHydrateError();
            return;
        }
        Guild guild = ((ReadyPayloadUtils$HydrateGuildResult$Success) readyPayloadUtils$HydrateGuildResultHydrateGuild$default).getGuild();
        this.users.handleGuildAddOrSync(guild);
        this.guilds.handleGuildAdd(guild);
        this.guildMemberCounts.handleGuildCreate(guild);
        this.presences.handleGuildAdd(guild);
        this.channels.handleGuildAdd(guild);
        this.stageInstances.handleGuildAdd(guild);
        this.permissions.handleGuildAdd(guild);
        this.channelsSelected.handleGuildAdd(guild);
        this.customEmojis.handleGuildAdd(guild);
        this.mentions.handleGuildAdd(guild);
        this.messagesMostRecent.handleGuildAdd(guild);
        this.voiceStates.handleGuildAdd(guild);
        this.gameParty.handleGuildCreateOrSync(guild);
        this.lurking.handleGuildAdd$app_productionGoogleRelease(guild);
        this.clientDataState.handleGuildAdd(guild);
        this.guildStickers.handleGuildCreateOrUpdate(guild);
        this.guildScheduledEvents.handleGuildCreate(guild);
        this.embeddedActivities.handleGuildCreate(guild);
    }

    @StoreThread
    private final void handleGuildIntegrationUpdate(ModelGuildIntegration$Update update) {
        this.integrations.handleUpdate(update);
    }

    @StoreThread
    private final void handleGuildMemberAdd(GuildMember member) {
        this.users.handleGuildMemberAdd(member);
        this.guilds.handleGuildMemberAdd(member);
        this.guildMemberCounts.handleGuildMemberAdd(member);
        this.permissions.handleGuildMemberAdd(member);
        this.customEmojis.handleGuildMemberAdd(member);
        this.stageChannels.handleGuildMemberAdd(member);
        this.voiceChannelSelected.handleGuildMemberAdd(member);
        this.mentions.handleGuildMemberAdd(member);
    }

    @StoreThread
    private final void handleGuildMemberListUpdate(ModelGuildMemberListUpdate update) {
        for (ModelGuildMemberListUpdate$Operation modelGuildMemberListUpdate$Operation : update.getOperations()) {
            if (modelGuildMemberListUpdate$Operation.getItem() != null) {
                handleItem(update.getGuildId(), modelGuildMemberListUpdate$Operation.getItem());
            }
            List<ModelGuildMemberListUpdate$Operation$Item> items = modelGuildMemberListUpdate$Operation.getItems();
            if (items != null) {
                Iterator<ModelGuildMemberListUpdate$Operation$Item> it = items.iterator();
                while (it.hasNext()) {
                    handleItem(update.getGuildId(), it.next());
                }
            }
        }
        this.lazyChannelMembersStore.handleGuildMemberListUpdate(update);
    }

    @StoreThread
    private final void handleGuildMemberRemove(GuildMemberRemove event) {
        this.guilds.handleGuildMemberRemove(event.getGuildId(), event.getUser().getId());
        this.guildMemberCounts.handleGuildMemberRemove(event.getGuildId());
        this.presences.handleGuildMemberRemove(event.getGuildId(), event.getUser().getId());
        this.stageChannels.handleGuildMemberRemove(event.getGuildId(), event.getUser().getId());
    }

    @StoreThread
    private final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        this.users.handleGuildMembersChunk(chunk);
        this.guilds.handleGuildMembersChunk(chunk);
        List<Presence> listD = chunk.d();
        if (listD != null) {
            Iterator<Presence> it = listD.iterator();
            while (it.hasNext()) {
                handlePresenceUpdate(chunk.getGuildId(), it.next());
            }
        }
        this.guildMemberRequesterStore.handleGuildMembersChunk(chunk);
    }

    @StoreThread
    private final void handleGuildRemove(Guild guild) {
        if (guild == null) {
            return;
        }
        this.guilds.handleGuildRemove(guild);
        this.guildMemberCounts.handleGuildDelete(guild.getId());
        this.guildSubscriptions.handleGuildRemove(guild.getId());
        this.lazyChannelMembersStore.handleGuildRemove(guild.getId());
        this.presences.handleGuildRemove(guild);
        this.guildSelected.handleGuildRemove(guild);
        this.channels.handleGuildRemove(guild);
        this.stageChannels.handleGuildRemove(guild);
        this.stageInstances.handleGuildRemove(guild);
        this.permissions.handleGuildRemove(guild);
        this.channelsSelected.handleGuildRemove(guild);
        this.customEmojis.handleGuildRemove(guild);
        this.voiceChannelSelected.handleGuildRemove();
        this.voiceStates.handleGuildRemove(guild);
        this.lurking.handleGuildRemove$app_productionGoogleRelease(guild);
        this.clientDataState.handleGuildRemove(guild);
        this.threadsActive.handleGuildDelete(guild.getId());
        this.threadsJoined.handleGuildDelete(guild.getId());
        this.threadsActiveJoined.handleGuildDelete(guild.getId());
        this.threadMessages.handleGuildDelete(guild.getId());
        this.guildJoinRequests.handleGuildRemove(guild.getId());
        this.guildStickers.handleGuildRemove(guild.getId());
        this.guildScheduledEvents.handleGuildRemove(guild.getId());
        this.guildRoleMemberCounts.handleGuildRemove(guild.getId());
    }

    @StoreThread
    private final void handleGuildRoleCreate(GuildRoleCreate event) {
        handleGuildRoleCreateOrUpdate(event.getGuildId(), event.getRole(), event.getGuildHashes());
    }

    @StoreThread
    private final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role, GuildHashes guildHashes) {
        this.guilds.handleGuildRoleCreateOrUpdate(guildId, role);
        this.permissions.handleGuildRolesChanged(guildId);
        this.voiceChannelSelected.handleGuildRoleCreateOrUpdate();
        this.lazyChannelMembersStore.handleGuildRoleCreateOrUpdate(guildId);
        this.clientDataState.handleRoleAddOrRemove(guildId, guildHashes);
        this.stageChannels.handleGuildRoleCreateOrUpdate(guildId);
    }

    @StoreThread
    private final void handleGuildRoleDelete(GuildRoleDelete event) {
        this.guilds.handleGuildRoleRemove(event.getRoleId(), event.getGuildId());
        this.permissions.handleGuildRolesChanged(event.getGuildId());
        this.voiceChannelSelected.handleGuildRoleRemove();
        this.clientDataState.handleRoleAddOrRemove(event.getGuildId(), event.getGuildHashes());
    }

    @StoreThread
    private final void handleGuildRoleUpdate(GuildRoleUpdate event) {
        GuildRole guildRoleC = event.getRole();
        if (guildRoleC != null) {
            handleGuildRoleCreateOrUpdate(event.getGuildId(), guildRoleC, event.getGuildHashes());
        }
    }

    @StoreThread
    private final void handleGuildScheduledEventCreate(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvents.handleGuildScheduledEventCreate(guildScheduledEvent);
    }

    @StoreThread
    private final void handleGuildScheduledEventDelete(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvents.handleGuildScheduledEventDelete(guildScheduledEvent);
    }

    @StoreThread
    private final void handleGuildScheduledEventUpdate(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvents.handleGuildScheduledEventUpdate(guildScheduledEvent);
    }

    @StoreThread
    private final void handleGuildSettingUpdated(ModelNotificationSettings modelNotificationSettings) {
        this.guildSettings.handleGuildSettingUpdated$app_productionGoogleRelease(d0.t.m.listOf(modelNotificationSettings));
        this.clientDataState.handleGuildSettingUpdated(modelNotificationSettings);
    }

    @StoreThread
    private final void handleGuildUpdate(Guild guild) {
        handleGuildCreateOrUpdate(guild);
    }

    @StoreThread
    private final void handleHydrateError() {
        this.clientDataState.clear();
        this.gatewaySocket.resetOnError();
    }

    @StoreThread
    private final void handleInteractionCreate(InteractionStateUpdate interactionStateUpdate) {
        this.applicationInteractions.handleInteractionCreate(interactionStateUpdate);
        this.messages.handleInteractionCreate(interactionStateUpdate);
    }

    @StoreThread
    private final void handleInteractionSuccess(InteractionStateUpdate interactionStateUpdate) {
        this.applicationInteractions.handleInteractionSuccess(interactionStateUpdate);
    }

    @StoreThread
    private final void handleItem(long guildId, ModelGuildMemberListUpdate$Operation$Item item) {
        if (item instanceof ModelGuildMemberListUpdate$Operation$Item$MemberItem) {
            GuildMember member = ((ModelGuildMemberListUpdate$Operation$Item$MemberItem) item).getMember();
            synthesizeGuildMemberAdd(Long.valueOf(guildId), member.getUser(), member);
            Presence presence = member.getPresence();
            if (presence != null) {
                handlePresenceUpdate(guildId, presence);
            }
        }
    }

    @StoreThread
    private final void handleMessageAck(ModelReadState readState) {
        this.mentions.handleMessageAck(readState);
        this.messageAck.handleMessageAck(readState);
        this.forumPostReadStates.handleMessageAck(readState);
        this.clientDataState.handleMessageAck(readState);
    }

    @StoreThread
    private final void handleMessageCreate(Message message) {
        processMessageUsers(message);
        this.mentions.handleMessageCreateOrUpdate(message);
        this.users.handleMessageCreateOrUpdate(message);
        this.usersTyping.handleMessageCreate(message);
        this.applicationInteractions.handleMessageCreate(message);
        this.messages.handleMessageCreate(d0.t.m.listOf(message));
        this.messagesMostRecent.handleMessageCreate(message);
        this.messageAck.handleMessageCreate(message);
        this.messageReplies.handleMessageCreate(message);
        this.notifications.handleMessageCreate(message);
        this.clientDataState.handleMessageCreate(message);
        this.threadMessages.handleMessageCreate(message);
        this.forumPostMessages.handleMessageCreate(message);
        this.forumPostReadStates.handleMessageCreate(message);
    }

    @StoreThread
    private final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        this.messages.handleMessageDelete(messageDeleteBulk);
        this.mentions.handleMessageDeleted(messageDeleteBulk);
        StorePinnedMessages storePinnedMessages = this.pinnedMessages;
        long channelId = messageDeleteBulk.getChannelId();
        List<Long> messageIds = messageDeleteBulk.getMessageIds();
        m.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
        storePinnedMessages.handleMessageDeleteBulk(channelId, messageIds);
        this.messageStates.handleMessageDelete(messageDeleteBulk);
        this.messageReplies.handleMessageDelete(messageDeleteBulk);
        this.pendingReplies.handleMessageDelete(messageDeleteBulk);
        this.threadMessages.handleMessageDelete(messageDeleteBulk);
        this.forumPostMessages.handleMessageDelete(messageDeleteBulk);
    }

    @StoreThread
    private final void handleMessageUpdate(Message message) {
        processMessageUsers(message);
        this.mentions.handleMessageCreateOrUpdate(message);
        this.users.handleMessageCreateOrUpdate(message);
        this.messages.handleMessageUpdate(message);
        this.messageReplies.handleMessageUpdate(message);
        this.pinnedMessages.handleMessageUpdate(message);
        this.messageStates.handleMessageUpdate(message);
        this.threadMessages.handleMessageUpdate(message);
        this.applicationInteractions.handleMessageUpdate(message);
        this.forumPostMessages.handleMessageUpdate(message);
    }

    @StoreThread
    private final void handleMessagesLoaded(StoreMessagesLoader$ChannelChunk chunk) {
        this.users.handleMessagesLoaded(chunk);
        this.applicationInteractions.handleMessagesCreateOrLoad(chunk.getMessages());
        this.messages.handleMessagesLoaded(chunk);
        this.guildMemberRequesterStore.handleLoadMessages(chunk.getChannelId(), chunk.getMessages());
        this.messageReplies.handleLoadMessages(chunk.getMessages());
        this.channels.handleMessagesLoaded(chunk.getMessages());
        this.threadMessages.handleMessagesLoaded(chunk);
        this.permissions.handleMessagesLoaded(chunk.getMessages());
    }

    @StoreThread
    private final void handlePreLogout() {
        this.gatewaySocket.handlePreLogout();
        this.guildSelected.handlePreLogout();
        this.guildSubscriptions.handlePreLogout();
        this.authentication.handlePreLogout$app_productionGoogleRelease();
        this.gifting.handlePreLogout();
        this.spotify.handlePreLogout();
        this.paymentSources.handlePreLogout();
        this.subscriptions.handlePreLogout();
        this.userSettingsSystem.handlePreLogout();
        this.notifications.handlePreLogout();
        this.analytics.handlePreLogout();
        this.tabsNavigation.handlePreLogout();
        this.userRelationships.handlePreLogout();
        this.messages.handlePreLogout();
        this.emojis.handlePreLogout();
        this.stickers.handlePreLogout();
        this.pendingReplies.handlePreLogout();
        this.messageAck.handlePreLogout();
        this.applicationInteractions.handlePreLogout();
    }

    @StoreThread
    private final void handlePresenceReplace(List<Presence> presencesList) {
        this.presences.handlePresenceReplace(presencesList);
        this.gameParty.handlePresenceReplace(presencesList);
    }

    @StoreThread
    private final void handlePresenceUpdate(long guildId, Presence presence) {
        this.users.handlePresenceUpdate(presence);
        this.presences.handlePresenceUpdate(guildId, presence);
        this.gameParty.handlePresenceUpdate(presence, guildId);
    }

    @StoreThread
    private final void handleReactionAdd(MessageReactionUpdate update) {
        this.messages.handleReactionUpdate(d0.t.m.listOf(update), true);
        this.messageReactions.handleReactionAdd(update);
        this.forumPostMessages.handleReactionAdd(update);
    }

    @StoreThread
    private final void handleReactionRemove(MessageReactionUpdate update) {
        this.messages.handleReactionUpdate(d0.t.m.listOf(update), false);
        this.messageReactions.handleReactionRemove(update);
        this.forumPostMessages.handleReactionRemove(update);
    }

    @StoreThread
    private final void handleReactionRemoveAll(MessageReactionUpdate update) {
        this.messages.handleReactionsRemoveAll(update);
        this.messageReactions.handleReactionRemoveAll(update);
        this.forumPostMessages.handleReactionRemoveAll(update);
    }

    @StoreThread
    private final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        this.messages.handleReactionsRemoveEmoji(update);
        this.messageReactions.handleReactionRemoveEmoji(update);
        this.forumPostMessages.handleReactionRemoveEmoji(update);
    }

    @StoreThread
    private final void handleRelationshipRemove(ModelUserRelationship relationship) {
        this.userRelationships.handleRelationshipRemove(relationship);
    }

    @StoreThread
    private final void handleRequiredActionUpdate(UserRequiredActionUpdate requiredActionUpdate) {
        this.userRequiredAction.handleUserRequiredActionUpdate(requiredActionUpdate);
    }

    @StoreThread
    private final void handleRtcConnectionStateChanged(RtcConnection$StateChange stateChange) {
        this.gatewaySocket.handleRtcConnectionStateChanged(stateChange);
        this.voiceChannelSelected.handleRtcConnectionStateChanged(stateChange.state);
        this.audioManagerV2.handleRtcConnectionState(stateChange.state);
    }

    @StoreThread
    private final void handleSessionsReplace(List<? extends ModelSession> sessions) {
        this.presences.handleSessionsReplace(sessions);
    }

    @StoreThread
    private final void handleSpeakingUpdates(List<StoreRtcConnection$SpeakingUserUpdate> speakingUsers) {
        this.voiceSpeaking.handleSpeakingUpdates(speakingUsers);
    }

    @StoreThread
    private final void handleSpeakingUsers(Set<Long> speakingUsers) {
        this.analytics.handleUserSpeaking(speakingUsers);
    }

    @StoreThread
    private final void handleStickersUpdate(GuildStickersUpdate stickerUpdate) {
        this.guildStickers.handleStickerUpdate(stickerUpdate);
        this.clientDataState.handleStickersUpdate(stickerUpdate);
    }

    @StoreThread
    private final void handleStreamCreate(StreamCreateOrUpdate streamCreate) {
        this.streamRtcConnection.handleStreamCreate(streamCreate);
        this.applicationStreaming.handleStreamCreate(streamCreate);
    }

    @StoreThread
    private final void handleStreamServerUpdate(StreamServerUpdate streamServerUpdate) {
        this.streamRtcConnection.handleStreamServerUpdate(streamServerUpdate);
    }

    @StoreThread
    private final void handleStreamUpdate(StreamCreateOrUpdate streamUpdate) {
        this.applicationStreaming.handleStreamUpdate(streamUpdate);
    }

    @StoreThread
    private final void handleThreadDelete(Channel channel) {
        handleChannelOrThreadDelete(channel);
        this.threadsActive.handleThreadDelete(channel);
        this.threadsJoined.handleThreadDelete(channel);
        this.threadsActiveJoined.handleThreadCreateOrUpdateOrDelete(channel);
        this.threadMessages.handleThreadDelete(channel);
        this.lazyThreadMembersStore.handleThreadDelete(channel);
        this.forumPostMessages.handleThreadDelete(channel);
        this.forumPostReadStates.handleThreadDelete(channel);
    }

    @StoreThread
    private final void handleThreadListSync(ModelThreadListSync threadListSync) {
        this.channels.handleThreadListSync(threadListSync);
        this.threadsActive.handleThreadListSync(threadListSync);
        this.threadsJoined.handleThreadListSync(threadListSync);
        this.threadsActiveJoined.handleThreadListSync(threadListSync);
        this.permissions.handleThreadListSync(threadListSync);
        this.mentions.handleThreadListSync(threadListSync);
        this.messagesMostRecent.handleThreadListSync(threadListSync);
        this.threadMessages.handleThreadListSync(threadListSync);
    }

    @StoreThread
    private final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        this.presences.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.users.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.guilds.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.gameParty.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.lazyThreadMembersStore.handleThreadMemberListUpdate(threadMemberListUpdate);
    }

    @StoreThread
    private final void handleThreadMemberUpdate(ThreadMemberUpdate threadMemberUpdate) {
        this.threadsJoined.handleThreadMemberUpdate(threadMemberUpdate);
        this.threadsActiveJoined.handleThreadMemberUpdate(threadMemberUpdate);
        this.permissions.handleThreadMemberUpdate(threadMemberUpdate);
    }

    @StoreThread
    private final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        this.threadsJoined.handleThreadMembersUpdate(threadMembersUpdate);
        this.threadsActiveJoined.handleThreadMembersUpdate(threadMembersUpdate);
        this.permissions.handleThreadMembersUpdate(threadMembersUpdate);
        this.mentions.handleThreadMembersUpdate(threadMembersUpdate);
        this.presences.handleThreadMembersUpdate(threadMembersUpdate);
        this.users.handleThreadMembersUpdate(threadMembersUpdate);
        this.guilds.handleThreadMembersUpdate(threadMembersUpdate);
        this.gameParty.handleThreadMembersUpdate(threadMembersUpdate);
        this.lazyThreadMembersStore.handleThreadMembersUpdate(threadMembersUpdate);
    }

    @StoreThread
    private final void handleTypingStart(TypingUser typing) {
        Long lValueOf = Long.valueOf(typing.getGuildId());
        GuildMember guildMemberC = typing.getMember();
        synthesizeGuildMemberAdd(lValueOf, guildMemberC != null ? guildMemberC.getUser() : null, typing.getMember());
        this.usersTyping.handleTypingStart(typing);
    }

    @StoreThread
    private final void handleUserNoteUpdated(ModelUserNote$Update userNote) {
        this.userNotes.handleNoteUpdate(userNote);
    }

    @StoreThread
    private final void handleUserPaymentSourcesUpdate() {
        this.paymentSources.handleUserPaymentSourcesUpdate();
    }

    @StoreThread
    private final void handleUserSettingsUpdate(ModelUserSettings userSettingsUpdate) {
        this.userSettings.handleUserSettingsUpdate(userSettingsUpdate);
        this.userSettingsSystem.handleUserSettingsUpdate(userSettingsUpdate);
        this.presences.handleUserSettingsUpdate(userSettingsUpdate);
    }

    @StoreThread
    private final void handleUserSubscriptionsUpdate() {
        this.subscriptions.handleUserSubscriptionsUpdate();
    }

    @StoreThread
    private final void handleUserUpdated(User user) {
        this.users.handleUserUpdated(user);
        this.mfa.handleUserUpdated(user);
    }

    @StoreThread
    private final void handleVoiceChannelSelected(long voiceChannelId) {
        this.rtcConnection.handleVoiceChannelSelected(Long.valueOf(voiceChannelId));
        this.applicationStreaming.handleVoiceChannelSelected(voiceChannelId);
        this.videoStreams.handleVoiceChannelSelected(voiceChannelId);
        if (TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(this.guildSelected.getSelectedGuildId()))) {
            this.messages.handleChannelSelected(voiceChannelId);
            this.messagesLoader.handleVoiceChannelJoined(voiceChannelId);
        }
        this.voiceSpeaking.handleVoiceChannelSelected(voiceChannelId);
        this.callsIncoming.handleVoiceChannelSelected(voiceChannelId);
        this.mediaEngine.handleVoiceChannelSelected(voiceChannelId);
        this.mediaSettings.handleVoiceChannelSelected(voiceChannelId);
        this.stageSelfPresence.handleVoiceChannelSelected();
        this.lurking.handleVoiceChannelSelected$app_productionGoogleRelease(voiceChannelId);
    }

    @StoreThread
    private final void handleVoiceServerUpdate(VoiceServer voiceServer) {
        this.rtcConnection.handleVoiceServerUpdate(voiceServer);
    }

    @StoreThread
    private final void handleVoiceStateUpdate(VoiceState voiceState) {
        Long lValueOf = Long.valueOf(voiceState.getGuildId());
        GuildMember member = voiceState.getMember();
        synthesizeGuildMemberAdd(lValueOf, member != null ? member.getUser() : null, voiceState.getMember());
        this.voiceStates.handleVoiceStateUpdate(voiceState);
        StoreApplicationStreaming.handleVoiceStateUpdate$default(this.applicationStreaming, voiceState, 0L, 2, null);
        this.voiceChannelSelected.handleVoiceStateUpdates(voiceState);
        this.videoStreams.handleVoiceStateUpdates(voiceState);
        this.rtcConnection.handleVoiceStateUpdate(voiceState);
        this.stageSelfPresence.handleVoiceStateUpdate(voiceState);
        this.connectionTimeStats.handleVoiceStateUpdate(voiceState);
    }

    private final void init(Application context) {
        this.authentication.init(context);
        this.userSettingsSystem.init(context);
        this.emojis.initBlocking(context);
        this.userSettings.init(context);
        ChannelSelector.Companion.init(this, this.dispatcher, ObservationDeckProvider.get());
        new StoreUIEventHandler(context, this.mediaEngine, this.channels, this.voiceChannelSelected, this.stageChannels, this.guildSettings);
    }

    @StoreThread
    private final void initGatewaySocketListeners() {
        dispatchSubscribe(this.gatewaySocket.getReady(), "streamConnectionOpen", new StoreStream$initGatewaySocketListeners$1(this));
        dispatchSubscribe(this.gatewaySocket.getConnected(), "streamConnected", new StoreStream$initGatewaySocketListeners$2(this));
        dispatchSubscribe(this.gatewaySocket.getConnectionReady(), "streamReady", new StoreStream$initGatewaySocketListeners$3(this));
        dispatchSubscribe(this.gatewaySocket.getGuildApplicationCommands(), "guildApplicationCommands", new StoreStream$initGatewaySocketListeners$4(this));
        dispatchSubscribe(this.gatewaySocket.getGuildCreate(), "streamGuildCreate", new StoreStream$initGatewaySocketListeners$5(this));
        dispatchSubscribe(this.gatewaySocket.getGuildUpdate(), "streamGuildUpdate", new StoreStream$initGatewaySocketListeners$6(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleCreate(), "streamGuildRoleAdd", new StoreStream$initGatewaySocketListeners$7(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleUpdate(), "streamGuildRoleUpdate", new StoreStream$initGatewaySocketListeners$8(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleDelete(), "streamGuildRoleRemove", new StoreStream$initGatewaySocketListeners$9(this));
        dispatchSubscribe(this.gatewaySocket.getGuildDeleted(), "streamGuildRemove", new StoreStream$initGatewaySocketListeners$10(this));
        dispatchSubscribe(this.gatewaySocket.getGuildBanAdd(), "streamBanAdd", new StoreStream$initGatewaySocketListeners$11(this));
        dispatchSubscribe(this.gatewaySocket.getGuildBanRemove(), "streamBanRemove", new StoreStream$initGatewaySocketListeners$12(this));
        dispatchSubscribe(this.gatewaySocket.getGuildIntegrationsUpdate(), "streamGuildIntegrationUpdate", new StoreStream$initGatewaySocketListeners$13(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMembersAdd(), "streamGuildMemberAdd", new StoreStream$initGatewaySocketListeners$14(this));
        dispatchSubscribe(this.gatewaySocket.getGuildJoinRequestCreateOrUpdate(), "streamGuildJoinRequestCreateOrUpdate", new StoreStream$initGatewaySocketListeners$15(this));
        dispatchSubscribe(this.gatewaySocket.getGuildJoinRequestDelete(), "streamGuildJoinRequestDelete", new StoreStream$initGatewaySocketListeners$16(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMembersChunk(), "streamGuildMemberChunk", new StoreStream$initGatewaySocketListeners$17(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMemberRemove(), "streamGuildMemberRemove", new StoreStream$initGatewaySocketListeners$18(this));
        dispatchSubscribe(this.gatewaySocket.getChannelCreateOrUpdate(), "streamChannelCreateOrUpdate", new StoreStream$initGatewaySocketListeners$19(this));
        dispatchSubscribe(this.gatewaySocket.getChannelDeleted(), "streamChannelDelete", new StoreStream$initGatewaySocketListeners$20(this));
        dispatchSubscribe(this.gatewaySocket.getChannelUnreadUpdate(), "streamChannelUnreadUpdate", new StoreStream$initGatewaySocketListeners$21(this));
        dispatchSubscribe(this.gatewaySocket.getThreadCreateOrUpdate(), "streamThreadCreateOrUpdate", new StoreStream$initGatewaySocketListeners$22(this));
        dispatchSubscribe(this.gatewaySocket.getThreadDelete(), "streamThreadDelete", new StoreStream$initGatewaySocketListeners$23(this));
        dispatchSubscribe(this.gatewaySocket.getThreadListSync(), "streamThreadListSync", new StoreStream$initGatewaySocketListeners$24(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMemberUpdate(), "streamThreadMemberUpdate", new StoreStream$initGatewaySocketListeners$25(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMembersUpdate(), "streamThreadMembersUpdate", new StoreStream$initGatewaySocketListeners$26(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMemberListUpdate(), "threadMemberListUpdate", new StoreStream$initGatewaySocketListeners$27(this));
        dispatchSubscribe(this.gatewaySocket.getUserUpdate(), "streamUserUpdated", new StoreStream$initGatewaySocketListeners$28(this));
        dispatchSubscribe(this.gatewaySocket.getUserNoteUpdate(), "handleUserNoteUpdated", new StoreStream$initGatewaySocketListeners$29(this));
        dispatchSubscribe(this.gatewaySocket.getRelationshipAdd(), "streamRelationshipAdd", new StoreStream$initGatewaySocketListeners$30(this));
        dispatchSubscribe(this.gatewaySocket.getRelationshipRemove(), "streamRelationshipRemove", new StoreStream$initGatewaySocketListeners$31(this));
        dispatchSubscribe(this.gatewaySocket.getMessageUpdate(), "streamMessageUpdate", new StoreStream$initGatewaySocketListeners$32(this));
        dispatchSubscribe(this.gatewaySocket.getMessageCreate(), "streamMessageCreate", new StoreStream$initGatewaySocketListeners$33(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionAdd(), "streamReactionAdd", new StoreStream$initGatewaySocketListeners$34(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemove(), "streamReactionRemove", new StoreStream$initGatewaySocketListeners$35(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemoveEmoji(), "streamMessageRemoveEmoji", new StoreStream$initGatewaySocketListeners$36(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemoveAll(), "streamMessageRemoveAll", new StoreStream$initGatewaySocketListeners$37(this));
        dispatchSubscribe(this.gatewaySocket.getMessageDelete(), "streamMessageDelete", new StoreStream$initGatewaySocketListeners$38(this));
        dispatchSubscribe(this.gatewaySocket.getMessageAck(), "streamMessageAck", new StoreStream$initGatewaySocketListeners$39(this));
        dispatchSubscribe(this.gatewaySocket.getVoiceStateUpdate(), "streamVoiceStateUpdate", new StoreStream$initGatewaySocketListeners$40(this));
        dispatchSubscribe(this.gatewaySocket.getVoiceServerUpdate(), "streamVoiceServerUpdate", new StoreStream$initGatewaySocketListeners$41(this));
        dispatchSubscribe(this.gatewaySocket.getUserGuildSettingsUpdate(), "streamGuildSettingUpdated", new StoreStream$initGatewaySocketListeners$42(this));
        dispatchSubscribe(this.gatewaySocket.getUserSettingsUpdate(), "streamUserSettingsUpdate", new StoreStream$initGatewaySocketListeners$43(this));
        dispatchSubscribe(this.gatewaySocket.getTypingStart(), "streamTypingStart", new StoreStream$initGatewaySocketListeners$44(this));
        dispatchSubscribe(this.gatewaySocket.getPresenceUpdate(), "streamPresenceUpdate", new StoreStream$initGatewaySocketListeners$45(this));
        dispatchSubscribe(this.gatewaySocket.getPresenceReplace(), "streamPresenceReplace", new StoreStream$initGatewaySocketListeners$46(this));
        dispatchSubscribe(this.gatewaySocket.getChannelRecipientAdd(), "streamGroupDMRecipientAdd", new StoreStream$initGatewaySocketListeners$47(this));
        dispatchSubscribe(this.gatewaySocket.getChannelRecipientRemove(), "streamGroupDMRecipientRemove", new StoreStream$initGatewaySocketListeners$48(this));
        dispatchSubscribe(this.gatewaySocket.getCallDelete(), "streamCallDelete", new StoreStream$initGatewaySocketListeners$49(this));
        dispatchSubscribe(this.gatewaySocket.getCallCreateOrUpdate(), "streamCallCreateOrUpdate", new StoreStream$initGatewaySocketListeners$50(this));
        dispatchSubscribe(this.gatewaySocket.getGuildEmojisUpdate(), "streamEmojisUpdate", new StoreStream$initGatewaySocketListeners$51(this));
        dispatchSubscribe(this.gatewaySocket.getGuildStickersUpdate(), "streamStickersUpdate", new StoreStream$initGatewaySocketListeners$52(this));
        dispatchSubscribe(this.gatewaySocket.getUserRequiredActionUpdate(), "streamUserRequiredActionUpdate", new StoreStream$initGatewaySocketListeners$53(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMemberListUpdate(), "guildMemberListUpdate", new StoreStream$initGatewaySocketListeners$54(this));
        dispatchSubscribe(this.gatewaySocket.getSessionsReplace(), "streamSessionsReplace", new StoreStream$initGatewaySocketListeners$55(this));
        dispatchSubscribe(this.gatewaySocket.getUserPaymentSourcesUpdate(), "streamUserPaymentSourcesUpdate", new StoreStream$initGatewaySocketListeners$56(this));
        dispatchSubscribe(this.gatewaySocket.getUserSubscriptionsUpdate(), "streamUserSubscriptionsUpdate", new StoreStream$initGatewaySocketListeners$57(this));
        dispatchSubscribe(this.gatewaySocket.getStreamCreate(), "streamStreamCreate", new StoreStream$initGatewaySocketListeners$58(this));
        dispatchSubscribe(this.gatewaySocket.getStreamUpdate(), "streamStreamUpdate", new StoreStream$initGatewaySocketListeners$59(this));
        dispatchSubscribe(this.gatewaySocket.getStreamDelete(), "streamStreamDelete", new StoreStream$initGatewaySocketListeners$60(this));
        dispatchSubscribe(this.gatewaySocket.getStreamServerUpdate(), "streamStreamServerUpdate", new StoreStream$initGatewaySocketListeners$61(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionCreate(), "interactionCreate", new StoreStream$initGatewaySocketListeners$62(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionSuccess(), "interactionSuccess", new StoreStream$initGatewaySocketListeners$63(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionFailure(), "interactionFailure", new StoreStream$initGatewaySocketListeners$64(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionModalCreate(), "interactionModalCreate", new StoreStream$initGatewaySocketListeners$65(this));
        dispatchSubscribe(this.gatewaySocket.getApplicationCommandAutocompleteResult(), "applicationCommandAutocompleteResult", new StoreStream$initGatewaySocketListeners$66(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceCreate(), "stageInstanceCreate", new StoreStream$initGatewaySocketListeners$67(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceUpdate(), "stageInstanceUpdate", new StoreStream$initGatewaySocketListeners$68(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceDelete(), "stageInstanceDelete", new StoreStream$initGatewaySocketListeners$69(this));
        dispatchSubscribe(this.gatewaySocket.getFriendSuggestionCreate(), "friendSuggestionCreate", new StoreStream$initGatewaySocketListeners$70(this));
        dispatchSubscribe(this.gatewaySocket.getFriendSuggestionDelete(), "friendSuggestionDelete", new StoreStream$initGatewaySocketListeners$71(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventCreate(), "guildScheduledEventCreate", new StoreStream$initGatewaySocketListeners$72(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUpdate(), "guildScheduledEventUpdate", new StoreStream$initGatewaySocketListeners$73(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventDelete(), "guildScheduledEventDelete", new StoreStream$initGatewaySocketListeners$74(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUserAdd(), "guildScheduledEventUserAdd", new StoreStream$initGatewaySocketListeners$75(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUserRemove(), "guildScheduledEventUserRemove", new StoreStream$initGatewaySocketListeners$76(this));
        dispatchSubscribe(this.gatewaySocket.getEmbeddedActivityInboundUpdate(), "embeddedActivityInboundUpdate", new StoreStream$initGatewaySocketListeners$77(this));
        dispatchSubscribe(this.gatewaySocket.getForumUnreads(), "forumUnreads", new StoreStream$initGatewaySocketListeners$78(this));
    }

    private final void maybeLogNotificationPermissionStatus(Application context, Clock clock) {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        long jCurrentTimeMillis = clock.currentTimeMillis();
        if (jCurrentTimeMillis - sharedPreferences.getLong(LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY, 0L) > DAY_IN_MILLS) {
            Observable<NotificationClient$SettingsV2> observableZ = this.notifications.getSettings().Z(1);
            m.checkNotNullExpressionValue(observableZ, "notifications.getSettings().take(1)");
            ObservableExtensionsKt.appSubscribe$default(observableZ, StoreStream.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreStream$maybeLogNotificationPermissionStatus$1(sharedPreferences, jCurrentTimeMillis, context), 62, (Object) null);
        }
    }

    @StoreThread
    private final void processMessageUsers(Message message) {
        synthesizeGuildMemberAdd(message.getGuildId(), message.getAuthor(), message.getMember());
        List<User> listT = message.t();
        if (listT != null) {
            for (User user : listT) {
                synthesizeGuildMemberAdd(message.getGuildId(), user, user.getMember());
            }
        }
    }

    private final void startStoreInitializationTimer(NetworkMonitor networkMonitor) {
        Observable observableZ = Observable.I(networkMonitor.observeIsConnected().y(StoreStream$startStoreInitializationTimer$isOfflineObservable$1.INSTANCE), Observable.d0(6000L, TimeUnit.MILLISECONDS)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable.merge(\n      …le\n    )\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreStream.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreStream$startStoreInitializationTimer$1(this), 62, (Object) null);
    }

    public static /* synthetic */ void streamCreate$default(StoreStream storeStream, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        storeStream.streamCreate(str, str2);
    }

    @StoreThread
    private final void synthesizeGuildMemberAdd(Long guildId, User user, List<Long> roles, String nick, String premiumSince, Boolean pending, String avatar, UtcDateTime joinedAt, UtcDateTime communicationDisabledUntil) {
        if (guildId == null || user == null || roles == null) {
            return;
        }
        handleGuildMemberAdd(new GuildMember(guildId.longValue(), user, roles, nick, premiumSince, joinedAt, pending != null ? pending.booleanValue() : false, null, null, avatar, null, null, communicationDisabledUntil, 3072));
    }

    /* JADX INFO: renamed from: getAccessibility$app_productionGoogleRelease, reason: from getter */
    public final StoreAccessibility getAccessibility() {
        return this.accessibility;
    }

    /* JADX INFO: renamed from: getAnalytics$app_productionGoogleRelease, reason: from getter */
    public final StoreAnalytics getAnalytics() {
        return this.analytics;
    }

    /* JADX INFO: renamed from: getApplication$app_productionGoogleRelease, reason: from getter */
    public final StoreApplication getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: getApplicationAssets$app_productionGoogleRelease, reason: from getter */
    public final StoreApplicationAssets getApplicationAssets() {
        return this.applicationAssets;
    }

    /* JADX INFO: renamed from: getApplicationCommandFrecency$app_productionGoogleRelease, reason: from getter */
    public final StoreApplicationCommandFrecency getApplicationCommandFrecency() {
        return this.applicationCommandFrecency;
    }

    /* JADX INFO: renamed from: getApplicationCommands$app_productionGoogleRelease, reason: from getter */
    public final StoreApplicationCommands getApplicationCommands() {
        return this.applicationCommands;
    }

    /* JADX INFO: renamed from: getApplicationInteractions$app_productionGoogleRelease, reason: from getter */
    public final StoreApplicationInteractions getApplicationInteractions() {
        return this.applicationInteractions;
    }

    /* JADX INFO: renamed from: getApplicationStreamPreviews$app_productionGoogleRelease, reason: from getter */
    public final StoreApplicationStreamPreviews getApplicationStreamPreviews() {
        return this.applicationStreamPreviews;
    }

    /* JADX INFO: renamed from: getApplicationStreaming$app_productionGoogleRelease, reason: from getter */
    public final StoreApplicationStreaming getApplicationStreaming() {
        return this.applicationStreaming;
    }

    /* JADX INFO: renamed from: getArchivedThreads$app_productionGoogleRelease, reason: from getter */
    public final ArchivedThreadsStore getArchivedThreads() {
        return this.archivedThreads;
    }

    /* JADX INFO: renamed from: getAudioManagerV2$app_productionGoogleRelease, reason: from getter */
    public final StoreAudioManagerV2 getAudioManagerV2() {
        return this.audioManagerV2;
    }

    /* JADX INFO: renamed from: getAuditLog$app_productionGoogleRelease, reason: from getter */
    public final StoreAuditLog getAuditLog() {
        return this.auditLog;
    }

    /* JADX INFO: renamed from: getAuthentication$app_productionGoogleRelease, reason: from getter */
    public final StoreAuthentication getAuthentication() {
        return this.authentication;
    }

    /* JADX INFO: renamed from: getAutocomplete$app_productionGoogleRelease, reason: from getter */
    public final StoreAutocomplete getAutocomplete() {
        return this.autocomplete;
    }

    /* JADX INFO: renamed from: getBans$app_productionGoogleRelease, reason: from getter */
    public final StoreBans getBans() {
        return this.bans;
    }

    /* JADX INFO: renamed from: getCalls$app_productionGoogleRelease, reason: from getter */
    public final StoreCalls getCalls() {
        return this.calls;
    }

    /* JADX INFO: renamed from: getCallsIncoming$app_productionGoogleRelease, reason: from getter */
    public final StoreCallsIncoming getCallsIncoming() {
        return this.callsIncoming;
    }

    /* JADX INFO: renamed from: getChangeLogStore$app_productionGoogleRelease, reason: from getter */
    public final StoreChangeLog getChangeLogStore() {
        return this.changeLogStore;
    }

    /* JADX INFO: renamed from: getChannelFollowerStats$app_productionGoogleRelease, reason: from getter */
    public final StoreChannelFollowerStats getChannelFollowerStats() {
        return this.channelFollowerStats;
    }

    /* JADX INFO: renamed from: getChannels$app_productionGoogleRelease, reason: from getter */
    public final StoreChannels getChannels() {
        return this.channels;
    }

    /* JADX INFO: renamed from: getChannelsSelected$app_productionGoogleRelease, reason: from getter */
    public final StoreChannelsSelected getChannelsSelected() {
        return this.channelsSelected;
    }

    /* JADX INFO: renamed from: getChat$app_productionGoogleRelease, reason: from getter */
    public final StoreChat getChat() {
        return this.chat;
    }

    /* JADX INFO: renamed from: getClientDataState$app_productionGoogleRelease, reason: from getter */
    public final StoreClientDataState getClientDataState() {
        return this.clientDataState;
    }

    /* JADX INFO: renamed from: getClientVersion$app_productionGoogleRelease, reason: from getter */
    public final StoreClientVersion getClientVersion() {
        return this.clientVersion;
    }

    /* JADX INFO: renamed from: getCollapsedChannelCategories$app_productionGoogleRelease, reason: from getter */
    public final StoreCollapsedChannelCategories getCollapsedChannelCategories() {
        return this.collapsedChannelCategories;
    }

    /* JADX INFO: renamed from: getConnectionOpen$app_productionGoogleRelease, reason: from getter */
    public final StoreConnectionOpen getConnectionOpen() {
        return this.connectionOpen;
    }

    /* JADX INFO: renamed from: getConnectionTimeStats$app_productionGoogleRelease, reason: from getter */
    public final ConnectionTimeStats getConnectionTimeStats() {
        return this.connectionTimeStats;
    }

    /* JADX INFO: renamed from: getConnectivity$app_productionGoogleRelease, reason: from getter */
    public final StoreConnectivity getConnectivity() {
        return this.connectivity;
    }

    /* JADX INFO: renamed from: getContactSync$app_productionGoogleRelease, reason: from getter */
    public final StoreContactSync getContactSync() {
        return this.contactSync;
    }

    /* JADX INFO: renamed from: getDirectories$app_productionGoogleRelease, reason: from getter */
    public final StoreDirectories getDirectories() {
        return this.directories;
    }

    /* JADX INFO: renamed from: getEmbeddedActivities$app_productionGoogleRelease, reason: from getter */
    public final StoreEmbeddedActivities getEmbeddedActivities() {
        return this.embeddedActivities;
    }

    /* JADX INFO: renamed from: getEmojis$app_productionGoogleRelease, reason: from getter */
    public final StoreEmoji getEmojis() {
        return this.emojis;
    }

    /* JADX INFO: renamed from: getEntitlements$app_productionGoogleRelease, reason: from getter */
    public final StoreEntitlements getEntitlements() {
        return this.entitlements;
    }

    /* JADX INFO: renamed from: getExpandedGuildFolders$app_productionGoogleRelease, reason: from getter */
    public final StoreExpandedGuildFolders getExpandedGuildFolders() {
        return this.expandedGuildFolders;
    }

    /* JADX INFO: renamed from: getExperiments$app_productionGoogleRelease, reason: from getter */
    public final StoreExperiments getExperiments() {
        return this.experiments;
    }

    /* JADX INFO: renamed from: getExpressionPickerNavigation$app_productionGoogleRelease, reason: from getter */
    public final StoreExpressionPickerNavigation getExpressionPickerNavigation() {
        return this.expressionPickerNavigation;
    }

    /* JADX INFO: renamed from: getExpressionSuggestions$app_productionGoogleRelease, reason: from getter */
    public final StoreExpressionSuggestions getExpressionSuggestions() {
        return this.expressionSuggestions;
    }

    /* JADX INFO: renamed from: getForumPostMessages$app_productionGoogleRelease, reason: from getter */
    public final StoreForumPostMessages getForumPostMessages() {
        return this.forumPostMessages;
    }

    /* JADX INFO: renamed from: getForumPostReadStates$app_productionGoogleRelease, reason: from getter */
    public final StoreForumPostReadStates getForumPostReadStates() {
        return this.forumPostReadStates;
    }

    /* JADX INFO: renamed from: getFriendSuggestions$app_productionGoogleRelease, reason: from getter */
    public final StoreFriendSuggestions getFriendSuggestions() {
        return this.friendSuggestions;
    }

    /* JADX INFO: renamed from: getGameParty$app_productionGoogleRelease, reason: from getter */
    public final StoreGameParty getGameParty() {
        return this.gameParty;
    }

    /* JADX INFO: renamed from: getGatewaySocket$app_productionGoogleRelease, reason: from getter */
    public final StoreGatewayConnection getGatewaySocket() {
        return this.gatewaySocket;
    }

    /* JADX INFO: renamed from: getGifPicker$app_productionGoogleRelease, reason: from getter */
    public final StoreGifPicker getGifPicker() {
        return this.gifPicker;
    }

    /* JADX INFO: renamed from: getGifting$app_productionGoogleRelease, reason: from getter */
    public final StoreGifting getGifting() {
        return this.gifting;
    }

    /* JADX INFO: renamed from: getGooglePlayPurchases$app_productionGoogleRelease, reason: from getter */
    public final StoreGooglePlayPurchases getGooglePlayPurchases() {
        return this.googlePlayPurchases;
    }

    /* JADX INFO: renamed from: getGooglePlaySkuDetails$app_productionGoogleRelease, reason: from getter */
    public final StoreGooglePlaySkuDetails getGooglePlaySkuDetails() {
        return this.googlePlaySkuDetails;
    }

    /* JADX INFO: renamed from: getGuildBoosts$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildBoost getGuildBoosts() {
        return this.guildBoosts;
    }

    /* JADX INFO: renamed from: getGuildEmojis$app_productionGoogleRelease, reason: from getter */
    public final StoreEmojiGuild getGuildEmojis() {
        return this.guildEmojis;
    }

    /* JADX INFO: renamed from: getGuildInvite$app_productionGoogleRelease, reason: from getter */
    public final StoreInviteSettings getGuildInvite() {
        return this.guildInvite;
    }

    /* JADX INFO: renamed from: getGuildJoinRequests$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildJoinRequest getGuildJoinRequests() {
        return this.guildJoinRequests;
    }

    /* JADX INFO: renamed from: getGuildMemberCounts$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildMemberCounts getGuildMemberCounts() {
        return this.guildMemberCounts;
    }

    /* JADX INFO: renamed from: getGuildMemberRequesterStore$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildMemberRequester getGuildMemberRequesterStore() {
        return this.guildMemberRequesterStore;
    }

    /* JADX INFO: renamed from: getGuildProfiles$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildProfiles getGuildProfiles() {
        return this.guildProfiles;
    }

    /* JADX INFO: renamed from: getGuildRoleMemberCounts$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildRoleMemberCounts getGuildRoleMemberCounts() {
        return this.guildRoleMemberCounts;
    }

    /* JADX INFO: renamed from: getGuildRoleSubscriptions$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildRoleSubscriptions getGuildRoleSubscriptions() {
        return this.guildRoleSubscriptions;
    }

    /* JADX INFO: renamed from: getGuildScheduledEvents$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildScheduledEvents getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    /* JADX INFO: renamed from: getGuildSelected$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildSelected getGuildSelected() {
        return this.guildSelected;
    }

    /* JADX INFO: renamed from: getGuildSettings$app_productionGoogleRelease, reason: from getter */
    public final StoreUserGuildSettings getGuildSettings() {
        return this.guildSettings;
    }

    /* JADX INFO: renamed from: getGuildStickers$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildStickers getGuildStickers() {
        return this.guildStickers;
    }

    /* JADX INFO: renamed from: getGuildSubscriptions$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildSubscriptions getGuildSubscriptions() {
        return this.guildSubscriptions;
    }

    /* JADX INFO: renamed from: getGuildTemplates$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildTemplates getGuildTemplates() {
        return this.guildTemplates;
    }

    /* JADX INFO: renamed from: getGuildVoiceRegions$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildVoiceRegions getGuildVoiceRegions() {
        return this.guildVoiceRegions;
    }

    /* JADX INFO: renamed from: getGuildWelcomeScreens$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildWelcomeScreens getGuildWelcomeScreens() {
        return this.guildWelcomeScreens;
    }

    /* JADX INFO: renamed from: getGuilds$app_productionGoogleRelease, reason: from getter */
    public final StoreGuilds getGuilds() {
        return this.guilds;
    }

    /* JADX INFO: renamed from: getGuildsNsfw$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildsNsfw getGuildsNsfw() {
        return this.guildsNsfw;
    }

    /* JADX INFO: renamed from: getGuildsSorted$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildsSorted getGuildsSorted() {
        return this.guildsSorted;
    }

    /* JADX INFO: renamed from: getInstantInvites$app_productionGoogleRelease, reason: from getter */
    public final StoreInstantInvites getInstantInvites() {
        return this.instantInvites;
    }

    /* JADX INFO: renamed from: getIntegrations$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildIntegrations getIntegrations() {
        return this.integrations;
    }

    /* JADX INFO: renamed from: getLazyChannelMembersStore$app_productionGoogleRelease, reason: from getter */
    public final StoreChannelMembers getLazyChannelMembersStore() {
        return this.lazyChannelMembersStore;
    }

    /* JADX INFO: renamed from: getLazyThreadMembersStore$app_productionGoogleRelease, reason: from getter */
    public final StoreThreadMembers getLazyThreadMembersStore() {
        return this.lazyThreadMembersStore;
    }

    /* JADX INFO: renamed from: getLibrary$app_productionGoogleRelease, reason: from getter */
    public final StoreLibrary getLibrary() {
        return this.library;
    }

    /* JADX INFO: renamed from: getLocalActionComponentState$app_productionGoogleRelease, reason: from getter */
    public final StoreLocalActionComponentState getLocalActionComponentState() {
        return this.localActionComponentState;
    }

    /* JADX INFO: renamed from: getLurking$app_productionGoogleRelease, reason: from getter */
    public final StoreLurking getLurking() {
        return this.lurking;
    }

    /* JADX INFO: renamed from: getMaskedLinks$app_productionGoogleRelease, reason: from getter */
    public final StoreMaskedLinks getMaskedLinks() {
        return this.maskedLinks;
    }

    /* JADX INFO: renamed from: getMediaEngine$app_productionGoogleRelease, reason: from getter */
    public final StoreMediaEngine getMediaEngine() {
        return this.mediaEngine;
    }

    /* JADX INFO: renamed from: getMediaFavorites$app_productionGoogleRelease, reason: from getter */
    public final StoreMediaFavorites getMediaFavorites() {
        return this.mediaFavorites;
    }

    /* JADX INFO: renamed from: getMediaSettings$app_productionGoogleRelease, reason: from getter */
    public final StoreMediaSettings getMediaSettings() {
        return this.mediaSettings;
    }

    /* JADX INFO: renamed from: getMemberVerificationForms$app_productionGoogleRelease, reason: from getter */
    public final StoreGuildMemberVerificationForm getMemberVerificationForms() {
        return this.memberVerificationForms;
    }

    /* JADX INFO: renamed from: getMentions$app_productionGoogleRelease, reason: from getter */
    public final StoreMentions getMentions() {
        return this.mentions;
    }

    /* JADX INFO: renamed from: getMessageAck$app_productionGoogleRelease, reason: from getter */
    public final StoreMessageAck getMessageAck() {
        return this.messageAck;
    }

    /* JADX INFO: renamed from: getMessageReactions$app_productionGoogleRelease, reason: from getter */
    public final StoreMessageReactions getMessageReactions() {
        return this.messageReactions;
    }

    /* JADX INFO: renamed from: getMessageReplies$app_productionGoogleRelease, reason: from getter */
    public final StoreMessageReplies getMessageReplies() {
        return this.messageReplies;
    }

    /* JADX INFO: renamed from: getMessageStates$app_productionGoogleRelease, reason: from getter */
    public final StoreMessageState getMessageStates() {
        return this.messageStates;
    }

    /* JADX INFO: renamed from: getMessageUploads$app_productionGoogleRelease, reason: from getter */
    public final StoreMessageUploads getMessageUploads() {
        return this.messageUploads;
    }

    /* JADX INFO: renamed from: getMessages$app_productionGoogleRelease, reason: from getter */
    public final StoreMessages getMessages() {
        return this.messages;
    }

    /* JADX INFO: renamed from: getMessagesLoader$app_productionGoogleRelease, reason: from getter */
    public final StoreMessagesLoader getMessagesLoader() {
        return this.messagesLoader;
    }

    /* JADX INFO: renamed from: getMessagesMostRecent$app_productionGoogleRelease, reason: from getter */
    public final StoreMessagesMostRecent getMessagesMostRecent() {
        return this.messagesMostRecent;
    }

    /* JADX INFO: renamed from: getMfa$app_productionGoogleRelease, reason: from getter */
    public final StoreMFA getMfa() {
        return this.mfa;
    }

    /* JADX INFO: renamed from: getNavigation$app_productionGoogleRelease, reason: from getter */
    public final StoreNavigation getNavigation() {
        return this.navigation;
    }

    /* JADX INFO: renamed from: getNotices$app_productionGoogleRelease, reason: from getter */
    public final StoreNotices getNotices() {
        return this.notices;
    }

    /* JADX INFO: renamed from: getNotificationUpsells$app_productionGoogleRelease, reason: from getter */
    public final StoreNotificationUpsells getNotificationUpsells() {
        return this.notificationUpsells;
    }

    /* JADX INFO: renamed from: getNotifications$app_productionGoogleRelease, reason: from getter */
    public final StoreNotifications getNotifications() {
        return this.notifications;
    }

    /* JADX INFO: renamed from: getNux$app_productionGoogleRelease, reason: from getter */
    public final StoreNux getNux() {
        return this.nux;
    }

    /* JADX INFO: renamed from: getOutboundPromotions$app_productionGoogleRelease, reason: from getter */
    public final StoreOutboundPromotions getOutboundPromotions() {
        return this.outboundPromotions;
    }

    /* JADX INFO: renamed from: getPaymentSources$app_productionGoogleRelease, reason: from getter */
    public final StorePaymentSources getPaymentSources() {
        return this.paymentSources;
    }

    /* JADX INFO: renamed from: getPendingReplies$app_productionGoogleRelease, reason: from getter */
    public final StorePendingReplies getPendingReplies() {
        return this.pendingReplies;
    }

    /* JADX INFO: renamed from: getPermissions$app_productionGoogleRelease, reason: from getter */
    public final StorePermissions getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: getPhone$app_productionGoogleRelease, reason: from getter */
    public final StorePhone getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: getPinnedMessages$app_productionGoogleRelease, reason: from getter */
    public final StorePinnedMessages getPinnedMessages() {
        return this.pinnedMessages;
    }

    /* JADX INFO: renamed from: getPresences$app_productionGoogleRelease, reason: from getter */
    public final StoreUserPresence getPresences() {
        return this.presences;
    }

    /* JADX INFO: renamed from: getReadStates$app_productionGoogleRelease, reason: from getter */
    public final StoreReadStates getReadStates() {
        return this.readStates;
    }

    /* JADX INFO: renamed from: getRequestedStageChannels$app_productionGoogleRelease, reason: from getter */
    public final StoreRequestedStageChannels getRequestedStageChannels() {
        return this.requestedStageChannels;
    }

    /* JADX INFO: renamed from: getReviewRequestStore$app_productionGoogleRelease, reason: from getter */
    public final StoreReviewRequest getReviewRequestStore() {
        return this.reviewRequestStore;
    }

    /* JADX INFO: renamed from: getRtcConnection$app_productionGoogleRelease, reason: from getter */
    public final StoreRtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    /* JADX INFO: renamed from: getRtcRegion$app_productionGoogleRelease, reason: from getter */
    public final StoreRtcRegion getRtcRegion() {
        return this.rtcRegion;
    }

    /* JADX INFO: renamed from: getSearch$app_productionGoogleRelease, reason: from getter */
    public final StoreSearch getSearch() {
        return this.search;
    }

    /* JADX INFO: renamed from: getSlowMode$app_productionGoogleRelease, reason: from getter */
    public final StoreSlowMode getSlowMode() {
        return this.slowMode;
    }

    /* JADX INFO: renamed from: getSpotify$app_productionGoogleRelease, reason: from getter */
    public final StoreSpotify getSpotify() {
        return this.spotify;
    }

    /* JADX INFO: renamed from: getStageChannels$app_productionGoogleRelease, reason: from getter */
    public final StoreStageChannels getStageChannels() {
        return this.stageChannels;
    }

    /* JADX INFO: renamed from: getStageInstances$app_productionGoogleRelease, reason: from getter */
    public final StoreStageInstances getStageInstances() {
        return this.stageInstances;
    }

    /* JADX INFO: renamed from: getStageSelfPresence$app_productionGoogleRelease, reason: from getter */
    public final StoreStageChannelSelfPresence getStageSelfPresence() {
        return this.stageSelfPresence;
    }

    /* JADX INFO: renamed from: getStickers$app_productionGoogleRelease, reason: from getter */
    public final StoreStickers getStickers() {
        return this.stickers;
    }

    /* JADX INFO: renamed from: getStoreDynamicLink$app_productionGoogleRelease, reason: from getter */
    public final StoreDynamicLink getStoreDynamicLink() {
        return this.storeDynamicLink;
    }

    /* JADX INFO: renamed from: getSubscriptions$app_productionGoogleRelease, reason: from getter */
    public final StoreSubscriptions getSubscriptions() {
        return this.subscriptions;
    }

    /* JADX INFO: renamed from: getTabsNavigation$app_productionGoogleRelease, reason: from getter */
    public final StoreTabsNavigation getTabsNavigation() {
        return this.tabsNavigation;
    }

    /* JADX INFO: renamed from: getThreadDraft$app_productionGoogleRelease, reason: from getter */
    public final StoreThreadDraft getThreadDraft() {
        return this.threadDraft;
    }

    /* JADX INFO: renamed from: getThreadMessages$app_productionGoogleRelease, reason: from getter */
    public final StoreThreadMessages getThreadMessages() {
        return this.threadMessages;
    }

    /* JADX INFO: renamed from: getThreadsActive$app_productionGoogleRelease, reason: from getter */
    public final StoreThreadsActive getThreadsActive() {
        return this.threadsActive;
    }

    /* JADX INFO: renamed from: getThreadsActiveJoined$app_productionGoogleRelease, reason: from getter */
    public final StoreThreadsActiveJoined getThreadsActiveJoined() {
        return this.threadsActiveJoined;
    }

    /* JADX INFO: renamed from: getThreadsJoined$app_productionGoogleRelease, reason: from getter */
    public final StoreThreadsJoined getThreadsJoined() {
        return this.threadsJoined;
    }

    /* JADX INFO: renamed from: getUserAffinities$app_productionGoogleRelease, reason: from getter */
    public final StoreUserAffinities getUserAffinities() {
        return this.userAffinities;
    }

    /* JADX INFO: renamed from: getUserConnections$app_productionGoogleRelease, reason: from getter */
    public final StoreUserConnections getUserConnections() {
        return this.userConnections;
    }

    /* JADX INFO: renamed from: getUserNotes$app_productionGoogleRelease, reason: from getter */
    public final StoreUserNotes getUserNotes() {
        return this.userNotes;
    }

    /* JADX INFO: renamed from: getUserProfile$app_productionGoogleRelease, reason: from getter */
    public final StoreUserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX INFO: renamed from: getUserRelationships$app_productionGoogleRelease, reason: from getter */
    public final StoreUserRelationships getUserRelationships() {
        return this.userRelationships;
    }

    /* JADX INFO: renamed from: getUserRequiredAction$app_productionGoogleRelease, reason: from getter */
    public final StoreUserRequiredActions getUserRequiredAction() {
        return this.userRequiredAction;
    }

    /* JADX INFO: renamed from: getUserSettings$app_productionGoogleRelease, reason: from getter */
    public final StoreUserSettings getUserSettings() {
        return this.userSettings;
    }

    /* JADX INFO: renamed from: getUserSettingsSystem$app_productionGoogleRelease, reason: from getter */
    public final StoreUserSettingsSystem getUserSettingsSystem() {
        return this.userSettingsSystem;
    }

    /* JADX INFO: renamed from: getUserSurvey$app_productionGoogleRelease, reason: from getter */
    public final StoreUserSurvey getUserSurvey() {
        return this.userSurvey;
    }

    /* JADX INFO: renamed from: getUsers$app_productionGoogleRelease, reason: from getter */
    public final StoreUser getUsers() {
        return this.users;
    }

    /* JADX INFO: renamed from: getUsersTyping$app_productionGoogleRelease, reason: from getter */
    public final StoreUserTyping getUsersTyping() {
        return this.usersTyping;
    }

    /* JADX INFO: renamed from: getVideoStreams$app_productionGoogleRelease, reason: from getter */
    public final StoreVideoStreams getVideoStreams() {
        return this.videoStreams;
    }

    /* JADX INFO: renamed from: getVoiceChannelSelected$app_productionGoogleRelease, reason: from getter */
    public final StoreVoiceChannelSelected getVoiceChannelSelected() {
        return this.voiceChannelSelected;
    }

    /* JADX INFO: renamed from: getVoiceParticipants$app_productionGoogleRelease, reason: from getter */
    public final StoreVoiceParticipants getVoiceParticipants() {
        return this.voiceParticipants;
    }

    /* JADX INFO: renamed from: getVoiceSpeaking$app_productionGoogleRelease, reason: from getter */
    public final StoreVoiceSpeaking getVoiceSpeaking() {
        return this.voiceSpeaking;
    }

    /* JADX INFO: renamed from: getVoiceStates$app_productionGoogleRelease, reason: from getter */
    public final StoreVoiceStates getVoiceStates() {
        return this.voiceStates;
    }

    @StoreThread
    public final void handleApplicationCommandAutocompleteResult(ApplicationCommandAutocompleteResult interactionStateUpdate) {
        m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        this.applicationCommands.handleApplicationCommandAutocompleteResult(interactionStateUpdate);
    }

    @StoreThread
    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.videoStreams.handleApplicationStreamUpdate(userId, streamId);
        this.connectionTimeStats.handleApplicationStreamUpdate(userId, streamId);
    }

    @StoreThread
    public final void handleApplicationStreamVideoMetadataUpdate(VideoMetadata metadata) {
        m.checkNotNullParameter(metadata, "metadata");
        this.videoStreams.handleApplicationStreamVideoMetadataUpdate(metadata);
    }

    @StoreThread
    public final void handleFriendSuggestionCreate(FriendSuggestion friendSuggestionCreate) {
        m.checkNotNullParameter(friendSuggestionCreate, "friendSuggestionCreate");
        this.friendSuggestions.handleFriendSuggestionCreate(friendSuggestionCreate);
        this.users.handleFriendSuggestionCreate(friendSuggestionCreate);
    }

    @StoreThread
    public final void handleFriendSuggestionDelete(FriendSuggestionDelete friendSuggestionDelete) {
        m.checkNotNullParameter(friendSuggestionDelete, "friendSuggestionDelete");
        this.friendSuggestions.handleFriendSuggestionDelete(friendSuggestionDelete);
    }

    @StoreThread
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> friendSuggestions) {
        m.checkNotNullParameter(friendSuggestions, "friendSuggestions");
        this.friendSuggestions.handleFriendSuggestionsLoaded(friendSuggestions);
        this.users.handleFriendSuggestionsLoaded(friendSuggestions);
    }

    @StoreThread
    public final void handleGuildJoinRequestCreateOrUpdate(GuildJoinRequestCreateOrUpdate update) {
        m.checkNotNullParameter(update, "update");
        this.guildJoinRequests.handleGuildJoinRequestCreateOrUpdate(update.getGuildId(), update.getRequest());
    }

    @StoreThread
    public final void handleGuildJoinRequestDelete(GuildJoinRequestDelete update) {
        m.checkNotNullParameter(update, "update");
        this.guildJoinRequests.handleGuildJoinRequestDelete(update.getUserId(), update.getGuildId());
    }

    @StoreThread
    public final void handleGuildJoined(long guildId, GuildWelcomeScreen welcomeScreen) {
        this.guildWelcomeScreens.handleGuildJoined(guildId, welcomeScreen);
    }

    @StoreThread
    public final void handleGuildSelected(long guildId) {
        this.guildSelected.handleGuildSelected(guildId);
        this.channelsSelected.handleGuildSelected();
        this.calls.handleGuildSelect(guildId);
        this.guildSubscriptions.handleGuildSelect(guildId);
        this.lurking.handleGuildSelected$app_productionGoogleRelease(guildId);
        this.nux.handleGuildSelected(guildId);
        this.guildInvite.handleGuildSelected(guildId);
    }

    @StoreThread
    public final void handleHomeTabSelected(StoreNavigation$PanelAction panelAction) {
        m.checkNotNullParameter(panelAction, "panelAction");
        this.navigation.handleHomeTabSelected(panelAction);
    }

    @StoreThread
    public final void handleInteractionFailure(InteractionStateUpdate interactionStateUpdate) {
        m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        this.applicationInteractions.handleInteractionFailure(interactionStateUpdate);
        this.messages.handleInteractionFailure(interactionStateUpdate);
    }

    @StoreThread
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        m.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        this.applicationInteractions.handleInteractionModalCreate(interactionModalCreate);
        this.messages.handleInteractionModalCreate(interactionModalCreate);
    }

    @StoreThread
    public final void handleIsScreenSharingChanged(boolean isScreenSharing) {
        this.analytics.handleIsScreenSharingChanged(isScreenSharing);
    }

    @StoreThread
    public final void handleLocalMessageDelete(com.discord.models.message.Message message) {
        m.checkNotNullParameter(message, "message");
        this.applicationInteractions.handleLocalMessageDelete(message);
    }

    @StoreThread
    public final void handleLoginResult(ModelLoginResult loginResult) {
        m.checkNotNullParameter(loginResult, "loginResult");
        this.authentication.handleLoginResult(loginResult);
        this.userSettingsSystem.handleLoginResult(loginResult);
    }

    @StoreThread
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        m.checkNotNullParameter(relationship, "relationship");
        this.users.handleUserRelationshipAdd(relationship);
        this.userRelationships.handleRelationshipAdd(relationship);
    }

    @StoreThread
    public final void handleSamplePremiumGuildSelected(long guildId) {
        this.guildSelected.handleGuildSelected(guildId);
        this.channelsSelected.handleGuildSelected();
        this.nux.handleSamplePremiumGuildSelected(guildId);
    }

    @StoreThread
    public final void handleSearchFinish(SearchState searchState) {
        m.checkNotNullParameter(searchState, "searchState");
        this.channels.handleSearchFinish(searchState);
        this.permissions.handleSearchFinish(searchState);
        this.threadsJoined.handleSearchFinish(searchState);
    }

    @StoreThread
    public final void handleStageInstanceCreate(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceCreate(stageInstance);
        this.stageSelfPresence.handleStageInstanceCreate();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @StoreThread
    public final void handleStageInstanceDelete(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceDelete(stageInstance);
        this.stageSelfPresence.handleStageInstanceDelete();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @StoreThread
    public final void handleStageInstanceUpdate(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceUpdate(stageInstance);
        this.stageSelfPresence.handleStageInstanceUpdate();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @StoreThread
    public final void handleStoreInitializationTimeout() {
        this.channels.handleStoreInitTimeout();
        this.channelsSelected.handleStoreInitTimeout();
    }

    @StoreThread
    public final void handleStreamDelete(StreamDelete streamDelete, boolean isLocal) {
        m.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamRtcConnection.handleStreamDelete();
        this.applicationStreaming.handleStreamDelete(streamDelete);
        if (isLocal) {
            this.gatewaySocket.streamDelete(streamDelete.getStreamKey());
        }
    }

    @StoreThread
    public final void handleStreamRtcConnectionStateChange(RtcConnection$StateChange stateChange) {
        m.checkNotNullParameter(stateChange, "stateChange");
        this.gatewaySocket.handleRtcConnectionStateChanged(stateChange);
        this.streamRtcConnection.handleStreamRtcConnectionStateChange(stateChange.state);
    }

    @StoreThread
    public final void handleStreamTargeted(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.applicationStreaming.handleStreamTargeted(streamKey);
        this.voiceChannelSelected.handleStreamTargeted(streamKey);
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.channels.handleThreadCreateOrUpdate(channel);
        this.channelsSelected.handleChannelOrThreadCreateOrUpdate(channel);
        this.permissions.handleChannelOrThreadCreateOrUpdate(channel);
        this.voiceChannelSelected.handleChannelOrThreadCreateOrUpdate();
        this.mentions.handleChannelOrThreadCreateOrUpdate(channel);
        this.messagesMostRecent.handleThreadCreateOrUpdate(channel);
        this.messageAck.handleThreadCreateOrUpdate(channel);
        this.threadsActive.handleThreadCreateOrUpdate(channel);
        this.threadsJoined.handleThreadCreateOrUpdate(channel);
        this.threadsActiveJoined.handleThreadCreateOrUpdateOrDelete(channel);
        this.threadMessages.handleThreadCreateOrUpdate(channel);
        this.lazyThreadMembersStore.handleThreadCreateOrUpdate(channel);
        this.forumPostMessages.handleThreadCreateOrUpdate(channel);
        this.forumPostReadStates.handleThreadCreateOrUpdate(channel);
    }

    @StoreThread
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        m.checkNotNullParameter(accounts, "accounts");
        this.userConnections.handleUserConnections(accounts);
        this.spotify.handleUserConnections(accounts);
    }

    @StoreThread
    public final void handleUserProfile(UserProfile userProfileInstance, Long guildId) {
        GuildMember guildMemberC;
        m.checkNotNullParameter(userProfileInstance, "userProfileInstance");
        this.userProfile.handleUserProfile(userProfileInstance);
        if (guildId == null || (guildMemberC = userProfileInstance.getGuildMember()) == null) {
            return;
        }
        this.guilds.handleGuildMember(GuildMember.a(guildMemberC, guildId.longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), guildId.longValue(), true);
    }

    @StoreThread
    public final void handleVideoInputDeviceSelected(VideoInputDeviceDescription selectedVideoInputDevice) {
        this.analytics.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    @StoreThread
    public final void handleVideoMetadataUpdate(VideoMetadata metadata) {
        m.checkNotNullParameter(metadata, "metadata");
        this.videoStreams.handleVideoMetadataUpdate(metadata);
    }

    @StoreThread
    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        this.videoStreams.handleVideoStreamUpdate(userId, streamId);
        this.connectionTimeStats.handleVideoStreamUpdate(userId, streamId, audioSsrc, videoSsrc, rtxSsrc);
    }

    @StoreThread
    public final void handleVoiceStatesUpdated(long guildId, long oldChannelId, long userId) {
        this.audioManagerV2.handleVoiceStatesUpdated();
        this.stageChannels.handleVoiceStatesUpdated(guildId, oldChannelId, userId);
    }

    @StoreThread
    public final void streamCreate(String streamKey, String preferredRegion) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.gatewaySocket.streamCreate(streamKey, preferredRegion);
        this.applicationStreaming.handleStreamCreateRequest(streamKey);
    }

    @StoreThread
    public final void streamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.gatewaySocket.streamWatch(streamKey);
        this.applicationStreaming.handleStreamWatch(streamKey);
        this.connectionTimeStats.handleStreamWatch(streamKey);
    }

    private final <T> void dispatchSubscribe(Batched<T> batched, String str, Function1<? super T, Unit> function1) {
        dispatchSubscribe(batched.observe(), str, new StoreStream$dispatchSubscribe$2(function1));
    }

    @StoreThread
    private final void synthesizeGuildMemberAdd(Long guildId, User user, GuildMember member) {
        synthesizeGuildMemberAdd(guildId, user, member != null ? member.l() : null, member != null ? member.getNick() : null, member != null ? member.getPremiumSince() : null, member != null ? Boolean.valueOf(member.getPending()) : null, member != null ? member.getAvatar() : null, member != null ? member.getJoinedAt() : null, member != null ? member.getCommunicationDisabledUntil() : null);
    }
}
