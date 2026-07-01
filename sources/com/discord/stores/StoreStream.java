package com.discord.stores;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.e.Backgrounded4;
import co.discord.media_engine.DeviceDescription4;
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
import com.discord.api.guildjoinrequest.GuildJoinRequest2;
import com.discord.api.guildjoinrequest.GuildJoinRequest3;
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
import com.discord.models.domain.ModelApplicationStream3;
import com.discord.models.domain.ModelApplicationStream5;
import com.discord.models.domain.ModelApplicationStream7;
import com.discord.models.domain.ModelAuditLogEntry;
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
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.stores.ReadyPayloadUtils;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.Batched;
import com.discord.utilities.StoreUIEventHandler;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher;
import com.discord.utilities.logging.AppGatewaySocketLogger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeElapsed;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.settings.premium.OutboundPromosPreviewFeatureFlag;
import com.google.gson.Gson;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.c.ExecutorScheduler;
import j0.p.Schedulers2;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Func4;
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
    private final StoreAudioManagerV2.VideoUseDetector videoUseDetector;
    private final StoreVoiceChannelSelected voiceChannelSelected;
    private final StoreVoiceParticipants voiceParticipants;
    private final StoreVoiceSpeaking voiceSpeaking;
    private final StoreVoiceStates voiceStates;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STORE_THREAD_NAME = "Main-StoreThread";
    private static final String LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY = "last_logged_notification_permissions_key";
    private static final long DAY_IN_MILLS = TimeUnit.DAYS.toMillis(1);
    private static final Lazy collector$delegate = LazyJVM.lazy(StoreStream$Companion$collector$2.INSTANCE);

    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class Companion {
        private Companion() {
        }

        private final StoreStream getCollector() {
            Lazy lazy = StoreStream.collector$delegate;
            Companion companion = StoreStream.INSTANCE;
            return (StoreStream) lazy.getValue();
        }

        public final StoreAccessibility getAccessibility() {
            return getCollector().getAccessibility();
        }

        public final StoreAnalytics getAnalytics() {
            return getCollector().getAnalytics();
        }

        public final StoreApplication getApplication() {
            return getCollector().getApplication();
        }

        public final StoreApplicationAssets getApplicationAssets() {
            return getCollector().getApplicationAssets();
        }

        public final StoreApplicationCommandFrecency getApplicationComandFrecency() {
            return getCollector().getApplicationCommandFrecency();
        }

        public final StoreApplicationCommands getApplicationCommands() {
            return getCollector().getApplicationCommands();
        }

        public final StoreApplicationStreamPreviews getApplicationStreamPreviews() {
            return getCollector().getApplicationStreamPreviews();
        }

        public final StoreApplicationStreaming getApplicationStreaming() {
            return getCollector().getApplicationStreaming();
        }

        public final ArchivedThreadsStore getArchivedThreads() {
            return getCollector().getArchivedThreads();
        }

        public final StoreAudioManagerV2 getAudioManagerV2() {
            return getCollector().getAudioManagerV2();
        }

        public final StoreAuditLog getAuditLog() {
            return getCollector().getAuditLog();
        }

        public final StoreAuthentication getAuthentication() {
            return getCollector().getAuthentication();
        }

        public final StoreAutocomplete getAutocomplete() {
            return getCollector().getAutocomplete();
        }

        public final StoreBans getBans() {
            return getCollector().getBans();
        }

        public final StoreCalls getCalls() {
            return getCollector().getCalls();
        }

        public final StoreCallsIncoming getCallsIncoming() {
            return getCollector().getCallsIncoming();
        }

        public final StoreChangeLog getChangeLog() {
            return getCollector().getChangeLogStore();
        }

        public final StoreChannelFollowerStats getChannelFollowerStats() {
            return getCollector().getChannelFollowerStats();
        }

        public final StoreChannelMembers getChannelMembers() {
            return getCollector().getLazyChannelMembersStore();
        }

        public final StoreChannels getChannels() {
            return getCollector().getChannels();
        }

        public final StoreChannelsSelected getChannelsSelected() {
            return getCollector().getChannelsSelected();
        }

        public final StoreChat getChat() {
            return getCollector().getChat();
        }

        public final StoreConnectionOpen getConnectionOpen() {
            return getCollector().getConnectionOpen();
        }

        public final StoreConnectivity getConnectivity() {
            return getCollector().getConnectivity();
        }

        public final StoreContactSync getContactSync() {
            return getCollector().getContactSync();
        }

        public final StoreEmojiCustom getCustomEmojis() {
            return getCollector().customEmojis;
        }

        public final StoreDirectories getDirectories() {
            return getCollector().getDirectories();
        }

        public final Dispatcher getDispatcherYesThisIsIntentional() {
            return getCollector().dispatcher;
        }

        public final StoreDynamicLink getDynamicLinkCache() {
            return getCollector().getStoreDynamicLink();
        }

        public final StoreEmbeddedActivities getEmbeddedActivities() {
            return getCollector().getEmbeddedActivities();
        }

        public final StoreEmoji getEmojis() {
            return getCollector().getEmojis();
        }

        public final StoreEntitlements getEntitlements() {
            return getCollector().getEntitlements();
        }

        public final StoreExpandedGuildFolders getExpandedGuildFolders() {
            return getCollector().getExpandedGuildFolders();
        }

        public final StoreExperiments getExperiments() {
            return getCollector().getExperiments();
        }

        public final StoreExpressionPickerNavigation getExpressionPickerNavigation() {
            return getCollector().getExpressionPickerNavigation();
        }

        public final StoreExpressionSuggestions getExpressionSuggestions() {
            return getCollector().getExpressionSuggestions();
        }

        public final StoreForumPostMessages getForumPostMessages() {
            return getCollector().getForumPostMessages();
        }

        public final StoreForumPostReadStates getForumPostReadStates() {
            return getCollector().getForumPostReadStates();
        }

        public final StoreFriendSuggestions getFriendSuggestions() {
            return getCollector().getFriendSuggestions();
        }

        public final StoreGameParty getGameParty() {
            return getCollector().getGameParty();
        }

        public final StoreGatewayConnection getGatewaySocket() {
            return getCollector().getGatewaySocket();
        }

        public final StoreGifPicker getGifPicker() {
            return getCollector().getGifPicker();
        }

        public final StoreGifting getGifting() {
            return getCollector().getGifting();
        }

        public final StoreGooglePlayPurchases getGooglePlayPurchases() {
            return getCollector().getGooglePlayPurchases();
        }

        public final StoreGooglePlaySkuDetails getGooglePlaySkuDetails() {
            return getCollector().getGooglePlaySkuDetails();
        }

        public final StoreGuildBoost getGuildBoosts() {
            return getCollector().getGuildBoosts();
        }

        public final StoreEmojiGuild getGuildEmojis() {
            return getCollector().getGuildEmojis();
        }

        public final StoreGuildIntegrations getGuildIntegrations() {
            return getCollector().getIntegrations();
        }

        public final StoreGuildJoinRequest getGuildJoinRequests() {
            return getCollector().getGuildJoinRequests();
        }

        public final StoreGuildMemberCounts getGuildMemberCounts() {
            return getCollector().getGuildMemberCounts();
        }

        public final StoreGuildMemberRequester getGuildMemberRequester() {
            return getCollector().getGuildMemberRequesterStore();
        }

        public final StoreGuildProfiles getGuildProfiles() {
            return getCollector().getGuildProfiles();
        }

        public final StoreGuildRoleMemberCounts getGuildRoleMemberCounts() {
            return getCollector().getGuildRoleMemberCounts();
        }

        public final StoreGuildRoleSubscriptions getGuildRoleSubscriptions() {
            return getCollector().getGuildRoleSubscriptions();
        }

        public final StoreGuildScheduledEvents getGuildScheduledEvents() {
            return getCollector().getGuildScheduledEvents();
        }

        public final StoreGuildSelected getGuildSelected() {
            return getCollector().getGuildSelected();
        }

        public final StoreGuildStickers getGuildStickers() {
            return getCollector().getGuildStickers();
        }

        public final StoreGuildSubscriptions getGuildSubscriptions() {
            return getCollector().getGuildSubscriptions();
        }

        public final StoreGuildTemplates getGuildTemplates() {
            return getCollector().getGuildTemplates();
        }

        public final StoreGuildVoiceRegions getGuildVoiceRegions() {
            return getCollector().getGuildVoiceRegions();
        }

        public final StoreGuildWelcomeScreens getGuildWelcomeScreens() {
            return getCollector().getGuildWelcomeScreens();
        }

        public final StoreGuilds getGuilds() {
            return getCollector().getGuilds();
        }

        public final StoreGuildsNsfw getGuildsNsfw() {
            return getCollector().getGuildsNsfw();
        }

        public final StoreGuildsSorted getGuildsSorted() {
            return getCollector().getGuildsSorted();
        }

        public final StoreInstantInvites getInstantInvites() {
            return getCollector().getInstantInvites();
        }

        public final StoreApplicationInteractions getInteractions() {
            return getCollector().getApplicationInteractions();
        }

        public final StoreInviteSettings getInviteSettings() {
            return getCollector().getGuildInvite();
        }

        public final StoreLibrary getLibrary() {
            return getCollector().getLibrary();
        }

        public final StoreLocalActionComponentState getLocalActionComponentState() {
            return getCollector().getLocalActionComponentState();
        }

        public final StoreLurking getLurking() {
            return getCollector().getLurking();
        }

        public final StoreMFA getMFA() {
            return getCollector().getMfa();
        }

        public final StoreMaskedLinks getMaskedLinks() {
            return getCollector().getMaskedLinks();
        }

        public final StoreMediaEngine getMediaEngine() {
            return getCollector().getMediaEngine();
        }

        public final StoreMediaFavorites getMediaFavorites() {
            return getCollector().getMediaFavorites();
        }

        public final StoreMediaSettings getMediaSettings() {
            return getCollector().getMediaSettings();
        }

        public final StoreGuildMemberVerificationForm getMemberVerificationForms() {
            return getCollector().getMemberVerificationForms();
        }

        public final StoreMentions getMentions() {
            return getCollector().getMentions();
        }

        public final StoreMessageAck getMessageAck() {
            return getCollector().getMessageAck();
        }

        public final StoreMessageReactions getMessageReactions() {
            return getCollector().getMessageReactions();
        }

        public final StoreMessageState getMessageState() {
            return getCollector().getMessageStates();
        }

        public final StoreMessageUploads getMessageUploads() {
            return getCollector().getMessageUploads();
        }

        public final StoreMessages getMessages() {
            return getCollector().getMessages();
        }

        public final StoreMessagesLoader getMessagesLoader() {
            return getCollector().getMessagesLoader();
        }

        public final StoreMessagesMostRecent getMessagesMostRecent() {
            return getCollector().getMessagesMostRecent();
        }

        public final StoreNavigation getNavigation() {
            return getCollector().getNavigation();
        }

        public final StoreNotices getNotices() {
            return getCollector().getNotices();
        }

        public final StoreNotificationUpsells getNotificationUpsells() {
            return getCollector().getNotificationUpsells();
        }

        public final StoreNotifications getNotifications() {
            return getCollector().getNotifications();
        }

        public final StoreNux getNux() {
            return getCollector().getNux();
        }

        public final StoreOutboundPromotions getOutboundPromotions() {
            return getCollector().getOutboundPromotions();
        }

        public final StorePaymentSources getPaymentSources() {
            return getCollector().getPaymentSources();
        }

        public final StorePendingReplies getPendingReplies() {
            return getCollector().getPendingReplies();
        }

        public final StorePermissions getPermissions() {
            return getCollector().getPermissions();
        }

        public final StorePhone getPhone() {
            return getCollector().getPhone();
        }

        public final StorePinnedMessages getPinnedMessages() {
            return getCollector().getPinnedMessages();
        }

        public final StoreUserPresence getPresences() {
            return getCollector().getPresences();
        }

        public final StoreReadStates getReadStates() {
            return getCollector().getReadStates();
        }

        public final StoreMessageReplies getRepliedMessages() {
            return getCollector().getMessageReplies();
        }

        public final StoreRequestedStageChannels getRequestedStageChannels() {
            return getCollector().getRequestedStageChannels();
        }

        public final StoreReviewRequest getReviewRequest() {
            return getCollector().getReviewRequestStore();
        }

        public final StoreRtcConnection getRtcConnection() {
            return getCollector().getRtcConnection();
        }

        public final long getSTORE_THREAD_ID() {
            return StoreStream.STORE_THREAD_ID;
        }

        public final String getSTORE_THREAD_NAME() {
            return StoreStream.STORE_THREAD_NAME;
        }

        public final StoreSearch getSearch() {
            return getCollector().getSearch();
        }

        public final StoreSlowMode getSlowMode() {
            return getCollector().getSlowMode();
        }

        public final StoreSpotify getSpotify() {
            return getCollector().getSpotify();
        }

        public final StoreStageChannelSelfPresence getStageChannelSelfPresence() {
            return getCollector().getStageSelfPresence();
        }

        public final StoreStageChannels getStageChannels() {
            return getCollector().getStageChannels();
        }

        public final StoreStageInstances getStageInstances() {
            return getCollector().getStageInstances();
        }

        public final StoreStickers getStickers() {
            return getCollector().getStickers();
        }

        public final StoreCollapsedChannelCategories getStoreChannelCategories() {
            return getCollector().getCollapsedChannelCategories();
        }

        public final StoreStreamRtcConnection getStreamRtcConnection() {
            return getCollector().streamRtcConnection;
        }

        public final StoreSubscriptions getSubscriptions() {
            return getCollector().getSubscriptions();
        }

        public final StoreTabsNavigation getTabsNavigation() {
            return getCollector().getTabsNavigation();
        }

        public final StoreThreadDraft getThreadDraft() {
            return getCollector().getThreadDraft();
        }

        public final StoreThreadMembers getThreadMembers() {
            return getCollector().getLazyThreadMembersStore();
        }

        public final StoreThreadMessages getThreadMessages() {
            return getCollector().getThreadMessages();
        }

        public final StoreThreadsActive getThreadsActive() {
            return getCollector().getThreadsActive();
        }

        public final StoreThreadsActiveJoined getThreadsActiveJoined() {
            return getCollector().getThreadsActiveJoined();
        }

        public final StoreThreadsJoined getThreadsJoined() {
            return getCollector().getThreadsJoined();
        }

        public final StoreUserAffinities getUserAffinities() {
            return getCollector().getUserAffinities();
        }

        public final StoreUserConnections getUserConnections() {
            return getCollector().getUserConnections();
        }

        public final StoreUserGuildSettings getUserGuildSettings() {
            return getCollector().getGuildSettings();
        }

        public final StoreUserProfile getUserProfile() {
            return getCollector().getUserProfile();
        }

        public final StoreUserRelationships getUserRelationships() {
            return getCollector().getUserRelationships();
        }

        public final StoreUserRequiredActions getUserRequiredActions() {
            return getCollector().getUserRequiredAction();
        }

        public final StoreUserSettings getUserSettings() {
            return getCollector().getUserSettings();
        }

        public final StoreUserSettingsSystem getUserSettingsSystem() {
            return getCollector().getUserSettingsSystem();
        }

        public final StoreUserSurvey getUserSurvey() {
            return getCollector().getUserSurvey();
        }

        public final StoreUser getUsers() {
            return getCollector().getUsers();
        }

        public final StoreUserNotes getUsersNotes() {
            return getCollector().getUserNotes();
        }

        public final StoreUserTyping getUsersTyping() {
            return getCollector().getUsersTyping();
        }

        public final StoreVoiceChannelSelected getVoiceChannelSelected() {
            return getCollector().getVoiceChannelSelected();
        }

        public final StoreVoiceParticipants getVoiceParticipants() {
            return getCollector().getVoiceParticipants();
        }

        public final StoreVoiceStates getVoiceStates() {
            return getCollector().getVoiceStates();
        }

        public final void initialize(Application application) {
            Intrinsics3.checkNotNullParameter(application, "application");
            if (StoreStream.isInitialized) {
                return;
            }
            Rules.setEmojiDataProvider(getCollector().getEmojis());
            getCollector().init(application);
            RestAPI.AppHeadersProvider.authTokenProvider = StoreStream$Companion$initialize$1.INSTANCE;
            RestAPI.AppHeadersProvider.fingerprintProvider = StoreStream$Companion$initialize$2.INSTANCE;
            RestAPI.AppHeadersProvider.localeProvider = StoreStream$Companion$initialize$3.INSTANCE;
            getCollector().deferredInit(application);
            StoreStream.isInitialized = true;
        }

        public final Observable<Boolean> isInitializedObservable() {
            BehaviorSubject behaviorSubject = StoreStream.INSTANCE.getCollector().initialized;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "collector.initialized");
            return behaviorSubject;
        }

        public final void setSTORE_THREAD_ID(long j) {
            StoreStream.STORE_THREAD_ID = j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Application $context;

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final class C01771 extends Lambda implements Function1<Boolean, Unit> {
            public C01771() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
                StoreStream.this.handlePreLogout();
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$10, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
            public AnonymousClass10(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleBackgrounded", "handleBackgrounded(Z)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
                ((StoreStream) this.receiver).handleBackgrounded(z2);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$12, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
            public AnonymousClass12(BehaviorSubject behaviorSubject) {
                super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                ((BehaviorSubject) this.receiver).onNext(bool);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<AuthState, Unit> {
            public AnonymousClass2(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleAuthState", "handleAuthState(Lcom/discord/models/authentication/AuthState;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                ((StoreStream) this.receiver).handleAuthState(authState);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<String, Unit> {
            public AnonymousClass3(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleFingerprint", "handleFingerprint(Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ((StoreStream) this.receiver).handleFingerprint(str);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<StoreMessagesLoader.ChannelChunk, Unit> {
            public AnonymousClass4(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleMessagesLoaded", "handleMessagesLoaded(Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreMessagesLoader.ChannelChunk channelChunk) {
                invoke2(channelChunk);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreMessagesLoader.ChannelChunk channelChunk) {
                Intrinsics3.checkNotNullParameter(channelChunk, "p1");
                ((StoreStream) this.receiver).handleMessagesLoaded(channelChunk);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Long, Unit> {
            public AnonymousClass5(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleChannelSelected", "handleChannelSelected(J)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.a;
            }

            public final void invoke(long j) {
                ((StoreStream) this.receiver).handleChannelSelected(j);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Long, Unit> {
            public AnonymousClass6(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleVoiceChannelSelected", "handleVoiceChannelSelected(J)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.a;
            }

            public final void invoke(long j) {
                ((StoreStream) this.receiver).handleVoiceChannelSelected(j);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Set<? extends Long>, Unit> {
            public AnonymousClass7(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleSpeakingUsers", "handleSpeakingUsers(Ljava/util/Set;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
                invoke2((Set<Long>) set);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<Long> set) {
                Intrinsics3.checkNotNullParameter(set, "p1");
                ((StoreStream) this.receiver).handleSpeakingUsers(set);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<RtcConnection.StateChange, Unit> {
            public AnonymousClass8(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleRtcConnectionStateChanged", "handleRtcConnectionStateChanged(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RtcConnection.StateChange stateChange) {
                invoke2(stateChange);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RtcConnection.StateChange stateChange) {
                Intrinsics3.checkNotNullParameter(stateChange, "p1");
                ((StoreStream) this.receiver).handleRtcConnectionStateChanged(stateChange);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<List<? extends StoreRtcConnection.SpeakingUserUpdate>, Unit> {
            public AnonymousClass9(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleSpeakingUpdates", "handleSpeakingUpdates(Ljava/util/List;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreRtcConnection.SpeakingUserUpdate> list) {
                invoke2((List<StoreRtcConnection.SpeakingUserUpdate>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StoreRtcConnection.SpeakingUserUpdate> list) {
                Intrinsics3.checkNotNullParameter(list, "p1");
                ((StoreStream) this.receiver).handleSpeakingUpdates(list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Application application) {
            super(0);
            this.$context = application;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TimeElapsed timeElapsed = new TimeElapsed(StoreStream.this.clock, 0L, 2, null);
            NetworkMonitor networkMonitor = new NetworkMonitor(this.$context, AppLog.g);
            StoreStream.this.startStoreInitializationTimer(networkMonitor);
            StoreStream.this.getExperiments().init(this.$context);
            StoreStream.this.getMediaEngine().init(this.$context);
            StoreStream.this.getAccessibility().init(this.$context);
            StoreStream.this.getGatewaySocket().init(this.$context, networkMonitor);
            StoreStream.this.getNavigation().init(this.$context);
            StoreStream.this.getNux().init(this.$context);
            StoreStream.this.getChannels().init();
            StoreStream.this.getUsers().init(this.$context);
            StoreStream.this.getGuilds().init(this.$context);
            StoreStream.this.getPermissions().init();
            StoreStream.this.getGuildsSorted().init(this.$context);
            StoreStream.this.getGuildsNsfw().init(this.$context);
            StoreStream.this.getGuildSelected().init(this.$context);
            StoreStream.this.getChannelsSelected().init();
            StoreStream.this.getMediaSettings().init();
            StoreStream.this.getMessages().init(this.$context);
            StoreStream.this.getMessagesLoader().init(this.$context);
            StoreStream.this.getMessageAck().init(this.$context);
            StoreStream.this.getMessagesMostRecent().init(this.$context);
            StoreStream.this.getNotifications().init(this.$context);
            StoreStream.this.getRtcConnection().init(this.$context, networkMonitor);
            StoreStream.this.getReadStates().init(this.$context);
            StoreStream.this.getVoiceChannelSelected().init(this.$context);
            StoreStream.this.getVoiceSpeaking().init(this.$context);
            StoreStream.this.getVoiceParticipants().init(this.$context);
            StoreStream.this.getConnectivity().init(networkMonitor);
            StoreStream.this.getClientVersion().init(this.$context);
            StoreStream.this.getMediaSettings().init(this.$context);
            StoreStream.this.getAnalytics().init(this.$context);
            StoreStream.this.getCollapsedChannelCategories().init(this.$context);
            StoreStream.this.getGuildSettings().init(this.$context);
            StoreStream.this.getNotices().init(this.$context);
            StoreStream.this.getUserConnections().init(this.$context);
            StoreStream.this.getChangeLogStore().init(this.$context);
            StoreStream.this.getReviewRequestStore().init(this.$context);
            StoreStream.this.getPresences().init(this.$context);
            StoreStream.this.getSpotify().init(this.$context);
            StoreStream.this.streamRtcConnection.init(networkMonitor);
            StoreStream.this.getGuildsSorted().init(this.$context);
            StoreStream.this.getExpandedGuildFolders().init(this.$context);
            StoreStream.this.getUserRelationships().init();
            StoreStream.this.getMaskedLinks().init(this.$context);
            StoreStream.this.getRtcRegion().init();
            StoreStream.this.getStickers().init();
            StoreStream.this.getGooglePlayPurchases().init(this.$context);
            StoreStream.this.getPhone().init(this.$context);
            StoreStream.this.getApplicationInteractions().init(this.$context);
            StoreStream.this.getStageSelfPresence().init();
            StoreStream.this.getContactSync().init(this.$context);
            StoreStream.this.getAudioManagerV2().init(this.$context);
            StoreStream.this.getOutboundPromotions().init(this.$context);
            StoreStream storeStream = StoreStream.this;
            storeStream.dispatchSubscribe(storeStream.getAuthentication().getPreLogoutSignal$app_productionGoogleRelease(), "streamPreLogout", new C01771());
            StoreStream storeStream2 = StoreStream.this;
            storeStream2.dispatchSubscribe(storeStream2.getAuthentication().m8getAuthState$app_productionGoogleRelease(), "streamAuthState", new AnonymousClass2(StoreStream.this));
            StoreStream storeStream3 = StoreStream.this;
            storeStream3.dispatchSubscribe(storeStream3.getAuthentication().getFingerPrint$app_productionGoogleRelease(), "streamAuthedFingerprint", new AnonymousClass3(StoreStream.this));
            StoreStream storeStream4 = StoreStream.this;
            storeStream4.dispatchSubscribe(storeStream4.getMessagesLoader().get(), "streamMessagesLoaded", new AnonymousClass4(StoreStream.this));
            StoreStream storeStream5 = StoreStream.this;
            storeStream5.dispatchSubscribe(storeStream5.getChannelsSelected().observeId(), "streamChannelSelected", new AnonymousClass5(StoreStream.this));
            StoreStream storeStream6 = StoreStream.this;
            storeStream6.dispatchSubscribe(storeStream6.getVoiceChannelSelected().observeSelectedVoiceChannelId(), "streamVoiceChannelSelected", new AnonymousClass6(StoreStream.this));
            StoreStream storeStream7 = StoreStream.this;
            storeStream7.dispatchSubscribe(storeStream7.getVoiceSpeaking().observeSpeakingUsers(), "streamUserSpeaking", new AnonymousClass7(StoreStream.this));
            StoreStream storeStream8 = StoreStream.this;
            storeStream8.dispatchSubscribe(storeStream8.getRtcConnection().getConnectionState(), "streamRtcConnectionStateChanged", new AnonymousClass8(StoreStream.this));
            StoreStream storeStream9 = StoreStream.this;
            storeStream9.dispatchSubscribe(storeStream9.getRtcConnection().getSpeakingUpdates(), "streamRtcSpeakingUpdates", new AnonymousClass9(StoreStream.this));
            StoreStream.this.initGatewaySocketListeners();
            StoreStream.this.dispatchSubscribe(Backgrounded4.d.a(), "streamBackgrounded", new AnonymousClass10(StoreStream.this));
            StoreStream storeStream10 = StoreStream.this;
            Observable observableH = Observable.h(storeStream10.getExperiments().isInitialized().r(), StoreStream.this.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), StoreStream.this.getChannelsSelected().observeInitializedForAuthedUser(), Persister.INSTANCE.isPreloaded(), new Func4<Boolean, Boolean, Boolean, Boolean, Boolean>() { // from class: com.discord.stores.StoreStream.deferredInit.1.11
                /* JADX WARN: Code duplicated, block: B:11:0x0029  */
                @Override // rx.functions.Func4
                public final Boolean call(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
                    boolean z2;
                    Intrinsics3.checkNotNullExpressionValue(bool, "experimentsInitialized");
                    if (bool.booleanValue()) {
                        Intrinsics3.checkNotNullExpressionValue(bool4, "cachesInitialized");
                        if (bool4.booleanValue()) {
                            if (bool2.booleanValue()) {
                                Intrinsics3.checkNotNullExpressionValue(bool3, "channelsSelectedInitialized");
                                if (!bool3.booleanValue()) {
                                    z2 = false;
                                }
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    return Boolean.valueOf(z2);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable\n        .comb…tedInitialized)\n        }");
            storeStream10.dispatchSubscribe(observableH, "streamInit", new AnonymousClass12(StoreStream.this.initialized));
            AppLog.i("[StoreStream] Application stores initialized in: " + timeElapsed.getSeconds() + " seconds.");
            VoiceEngineServiceController.INSTANCE.getINSTANCE().init(this.$context);
            StoreStream storeStream11 = StoreStream.this;
            storeStream11.maybeLogNotificationPermissionStatus(this.$context, storeStream11.clock);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.StoreStream$dispatchSubscribe$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$dispatchSubscribe$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final class C01781 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Object $emission;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01781(Object obj) {
                super(0);
                this.$emission = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1.this.$onNext.invoke(this.$emission);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            StoreStream.this.dispatcher.schedule(new C01781(t));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.StoreStream$dispatchSubscribe$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass2<T> extends Lambda implements Function1<List<? extends T>, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((List) obj);
            return Unit.a;
        }

        public final void invoke(List<? extends T> list) {
            Intrinsics3.checkNotNullParameter(list, "batch");
            Iterator<? extends T> it = list.iterator();
            while (it.hasNext()) {
                this.$onNext.invoke(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModelPayload, Unit> {
        public AnonymousClass1(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleConnectionOpen", "handleConnectionOpen(Lcom/discord/models/domain/ModelPayload;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPayload modelPayload) {
            invoke2(modelPayload);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPayload modelPayload) {
            Intrinsics3.checkNotNullParameter(modelPayload, "p1");
            ((StoreStream) this.receiver).handleConnectionOpen(modelPayload);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$10, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<Guild, Unit> {
        public AnonymousClass10(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRemove", "handleGuildRemove(Lcom/discord/api/guild/Guild;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            ((StoreStream) this.receiver).handleGuildRemove(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$11, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements Function1<ModelBan, Unit> {
        public AnonymousClass11(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleBanAdd", "handleBanAdd(Lcom/discord/models/domain/ModelBan;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
            invoke2(modelBan);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelBan modelBan) {
            Intrinsics3.checkNotNullParameter(modelBan, "p1");
            ((StoreStream) this.receiver).handleBanAdd(modelBan);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$12, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements Function1<ModelBan, Unit> {
        public AnonymousClass12(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleBanRemove", "handleBanRemove(Lcom/discord/models/domain/ModelBan;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
            invoke2(modelBan);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelBan modelBan) {
            Intrinsics3.checkNotNullParameter(modelBan, "p1");
            ((StoreStream) this.receiver).handleBanRemove(modelBan);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$13, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass13 extends FunctionReferenceImpl implements Function1<ModelGuildIntegration.Update, Unit> {
        public AnonymousClass13(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildIntegrationUpdate", "handleGuildIntegrationUpdate(Lcom/discord/models/domain/ModelGuildIntegration$Update;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildIntegration.Update update) {
            invoke2(update);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildIntegration.Update update) {
            Intrinsics3.checkNotNullParameter(update, "p1");
            ((StoreStream) this.receiver).handleGuildIntegrationUpdate(update);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$14, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass14 extends FunctionReferenceImpl implements Function1<GuildMember, Unit> {
        public AnonymousClass14(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMemberAdd", "handleGuildMemberAdd(Lcom/discord/api/guildmember/GuildMember;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember) {
            invoke2(guildMember);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(guildMember, "p1");
            ((StoreStream) this.receiver).handleGuildMemberAdd(guildMember);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$15, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass15 extends FunctionReferenceImpl implements Function1<GuildJoinRequest2, Unit> {
        public AnonymousClass15(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildJoinRequestCreateOrUpdate", "handleGuildJoinRequestCreateOrUpdate(Lcom/discord/api/guildjoinrequest/GuildJoinRequestCreateOrUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildJoinRequest2 guildJoinRequest2) {
            invoke2(guildJoinRequest2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildJoinRequest2 guildJoinRequest2) {
            Intrinsics3.checkNotNullParameter(guildJoinRequest2, "p1");
            ((StoreStream) this.receiver).handleGuildJoinRequestCreateOrUpdate(guildJoinRequest2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$16, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass16 extends FunctionReferenceImpl implements Function1<GuildJoinRequest3, Unit> {
        public AnonymousClass16(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildJoinRequestDelete", "handleGuildJoinRequestDelete(Lcom/discord/api/guildjoinrequest/GuildJoinRequestDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildJoinRequest3 guildJoinRequest3) {
            invoke2(guildJoinRequest3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildJoinRequest3 guildJoinRequest3) {
            Intrinsics3.checkNotNullParameter(guildJoinRequest3, "p1");
            ((StoreStream) this.receiver).handleGuildJoinRequestDelete(guildJoinRequest3);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$17, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass17 extends FunctionReferenceImpl implements Function1<GuildMembersChunk, Unit> {
        public AnonymousClass17(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMembersChunk", "handleGuildMembersChunk(Lcom/discord/api/guildmember/GuildMembersChunk;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildMembersChunk guildMembersChunk) {
            invoke2(guildMembersChunk);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMembersChunk guildMembersChunk) {
            Intrinsics3.checkNotNullParameter(guildMembersChunk, "p1");
            ((StoreStream) this.receiver).handleGuildMembersChunk(guildMembersChunk);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$18, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass18 extends FunctionReferenceImpl implements Function1<GuildMemberRemove, Unit> {
        public AnonymousClass18(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMemberRemove", "handleGuildMemberRemove(Lcom/discord/api/guildmember/GuildMemberRemove;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildMemberRemove guildMemberRemove) {
            invoke2(guildMemberRemove);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMemberRemove guildMemberRemove) {
            Intrinsics3.checkNotNullParameter(guildMemberRemove, "p1");
            ((StoreStream) this.receiver).handleGuildMemberRemove(guildMemberRemove);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$19, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass19 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass19(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleChannelCreateOrUpdate", "handleChannelCreateOrUpdate(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleChannelCreateOrUpdate(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleConnected", "handleConnected(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((StoreStream) this.receiver).handleConnected(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$20, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass20 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass20(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleChannelDelete", "handleChannelDelete(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleChannelDelete(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$21, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass21 extends FunctionReferenceImpl implements Function1<ModelChannelUnreadUpdate, Unit> {
        public AnonymousClass21(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleChannelUnreadUpdate", "handleChannelUnreadUpdate(Lcom/discord/models/domain/ModelChannelUnreadUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
            invoke2(modelChannelUnreadUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
            Intrinsics3.checkNotNullParameter(modelChannelUnreadUpdate, "p1");
            ((StoreStream) this.receiver).handleChannelUnreadUpdate(modelChannelUnreadUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$22, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass22 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass22(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadCreateOrUpdate", "handleThreadCreateOrUpdate(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleThreadCreateOrUpdate(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$23, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass23 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass23(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadDelete", "handleThreadDelete(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleThreadDelete(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$24, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass24 extends FunctionReferenceImpl implements Function1<ModelThreadListSync, Unit> {
        public AnonymousClass24(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadListSync", "handleThreadListSync(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelThreadListSync modelThreadListSync) {
            invoke2(modelThreadListSync);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelThreadListSync modelThreadListSync) {
            Intrinsics3.checkNotNullParameter(modelThreadListSync, "p1");
            ((StoreStream) this.receiver).handleThreadListSync(modelThreadListSync);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$25, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass25 extends FunctionReferenceImpl implements Function1<ThreadMemberUpdate, Unit> {
        public AnonymousClass25(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadMemberUpdate", "handleThreadMemberUpdate(Lcom/discord/api/thread/ThreadMemberUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMemberUpdate threadMemberUpdate) {
            invoke2(threadMemberUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMemberUpdate threadMemberUpdate) {
            Intrinsics3.checkNotNullParameter(threadMemberUpdate, "p1");
            ((StoreStream) this.receiver).handleThreadMemberUpdate(threadMemberUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$26, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass26 extends FunctionReferenceImpl implements Function1<ThreadMembersUpdate, Unit> {
        public AnonymousClass26(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadMembersUpdate", "handleThreadMembersUpdate(Lcom/discord/api/thread/ThreadMembersUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMembersUpdate threadMembersUpdate) {
            invoke2(threadMembersUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMembersUpdate threadMembersUpdate) {
            Intrinsics3.checkNotNullParameter(threadMembersUpdate, "p1");
            ((StoreStream) this.receiver).handleThreadMembersUpdate(threadMembersUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$27, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass27 extends FunctionReferenceImpl implements Function1<ThreadMemberListUpdate, Unit> {
        public AnonymousClass27(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadMemberListUpdate", "handleThreadMemberListUpdate(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMemberListUpdate threadMemberListUpdate) {
            invoke2(threadMemberListUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMemberListUpdate threadMemberListUpdate) {
            Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "p1");
            ((StoreStream) this.receiver).handleThreadMemberListUpdate(threadMemberListUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$28, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass28 extends FunctionReferenceImpl implements Function1<User, Unit> {
        public AnonymousClass28(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleUserUpdated", "handleUserUpdated(Lcom/discord/api/user/User;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "p1");
            ((StoreStream) this.receiver).handleUserUpdated(user);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$29, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass29 extends FunctionReferenceImpl implements Function1<ModelUserNote.Update, Unit> {
        public AnonymousClass29(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleUserNoteUpdated", "handleUserNoteUpdated(Lcom/discord/models/domain/ModelUserNote$Update;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote.Update update) {
            invoke2(update);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserNote.Update update) {
            Intrinsics3.checkNotNullParameter(update, "p1");
            ((StoreStream) this.receiver).handleUserNoteUpdated(update);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass3(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleConnectionReady", "handleConnectionReady(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((StoreStream) this.receiver).handleConnectionReady(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$30, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass30 extends FunctionReferenceImpl implements Function1<ModelUserRelationship, Unit> {
        public AnonymousClass30(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleRelationshipAdd", "handleRelationshipAdd(Lcom/discord/models/domain/ModelUserRelationship;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserRelationship modelUserRelationship) {
            invoke2(modelUserRelationship);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserRelationship modelUserRelationship) {
            Intrinsics3.checkNotNullParameter(modelUserRelationship, "p1");
            ((StoreStream) this.receiver).handleRelationshipAdd(modelUserRelationship);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$31, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass31 extends FunctionReferenceImpl implements Function1<ModelUserRelationship, Unit> {
        public AnonymousClass31(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleRelationshipRemove", "handleRelationshipRemove(Lcom/discord/models/domain/ModelUserRelationship;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserRelationship modelUserRelationship) {
            invoke2(modelUserRelationship);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserRelationship modelUserRelationship) {
            Intrinsics3.checkNotNullParameter(modelUserRelationship, "p1");
            ((StoreStream) this.receiver).handleRelationshipRemove(modelUserRelationship);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$32, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass32 extends FunctionReferenceImpl implements Function1<Message, Unit> {
        public AnonymousClass32(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageUpdate", "handleMessageUpdate(Lcom/discord/api/message/Message;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            Intrinsics3.checkNotNullParameter(message, "p1");
            ((StoreStream) this.receiver).handleMessageUpdate(message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$33, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass33 extends FunctionReferenceImpl implements Function1<Message, Unit> {
        public AnonymousClass33(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageCreate", "handleMessageCreate(Lcom/discord/api/message/Message;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            Intrinsics3.checkNotNullParameter(message, "p1");
            ((StoreStream) this.receiver).handleMessageCreate(message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$34, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass34 extends FunctionReferenceImpl implements Function1<MessageReactionUpdate, Unit> {
        public AnonymousClass34(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionAdd", "handleReactionAdd(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            Intrinsics3.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionAdd(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$35, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass35 extends FunctionReferenceImpl implements Function1<MessageReactionUpdate, Unit> {
        public AnonymousClass35(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionRemove", "handleReactionRemove(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            Intrinsics3.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionRemove(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$36, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass36 extends FunctionReferenceImpl implements Function1<MessageReactionUpdate, Unit> {
        public AnonymousClass36(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionRemoveEmoji", "handleReactionRemoveEmoji(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            Intrinsics3.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionRemoveEmoji(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$37, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass37 extends FunctionReferenceImpl implements Function1<MessageReactionUpdate, Unit> {
        public AnonymousClass37(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionRemoveAll", "handleReactionRemoveAll(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            Intrinsics3.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionRemoveAll(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$38, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass38 extends FunctionReferenceImpl implements Function1<ModelMessageDelete, Unit> {
        public AnonymousClass38(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageDelete", "handleMessageDelete(Lcom/discord/models/domain/ModelMessageDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMessageDelete modelMessageDelete) {
            invoke2(modelMessageDelete);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMessageDelete modelMessageDelete) {
            Intrinsics3.checkNotNullParameter(modelMessageDelete, "p1");
            ((StoreStream) this.receiver).handleMessageDelete(modelMessageDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$39, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass39 extends FunctionReferenceImpl implements Function1<ModelReadState, Unit> {
        public AnonymousClass39(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageAck", "handleMessageAck(Lcom/discord/models/domain/ModelReadState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelReadState modelReadState) {
            invoke2(modelReadState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "p1");
            ((StoreStream) this.receiver).handleMessageAck(modelReadState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<GuildApplicationCommands, Unit> {
        public AnonymousClass4(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildApplicationCommands", "handleGuildApplicationCommands(Lcom/discord/api/commands/GuildApplicationCommands;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildApplicationCommands guildApplicationCommands) {
            invoke2(guildApplicationCommands);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildApplicationCommands guildApplicationCommands) {
            Intrinsics3.checkNotNullParameter(guildApplicationCommands, "p1");
            ((StoreStream) this.receiver).handleGuildApplicationCommands(guildApplicationCommands);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$40, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass40 extends FunctionReferenceImpl implements Function1<VoiceState, Unit> {
        public AnonymousClass40(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleVoiceStateUpdate", "handleVoiceStateUpdate(Lcom/discord/api/voice/state/VoiceState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VoiceState voiceState) {
            invoke2(voiceState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VoiceState voiceState) {
            Intrinsics3.checkNotNullParameter(voiceState, "p1");
            ((StoreStream) this.receiver).handleVoiceStateUpdate(voiceState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$41, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass41 extends FunctionReferenceImpl implements Function1<VoiceServer, Unit> {
        public AnonymousClass41(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleVoiceServerUpdate", "handleVoiceServerUpdate(Lcom/discord/api/voice/server/VoiceServer;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VoiceServer voiceServer) {
            invoke2(voiceServer);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VoiceServer voiceServer) {
            Intrinsics3.checkNotNullParameter(voiceServer, "p1");
            ((StoreStream) this.receiver).handleVoiceServerUpdate(voiceServer);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$42, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass42 extends FunctionReferenceImpl implements Function1<ModelNotificationSettings, Unit> {
        public AnonymousClass42(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildSettingUpdated", "handleGuildSettingUpdated(Lcom/discord/models/domain/ModelNotificationSettings;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelNotificationSettings modelNotificationSettings) {
            invoke2(modelNotificationSettings);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelNotificationSettings modelNotificationSettings) {
            Intrinsics3.checkNotNullParameter(modelNotificationSettings, "p1");
            ((StoreStream) this.receiver).handleGuildSettingUpdated(modelNotificationSettings);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$43, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass43 extends FunctionReferenceImpl implements Function1<ModelUserSettings, Unit> {
        public AnonymousClass43(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleUserSettingsUpdate", "handleUserSettingsUpdate(Lcom/discord/models/domain/ModelUserSettings;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "p1");
            ((StoreStream) this.receiver).handleUserSettingsUpdate(modelUserSettings);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$44, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass44 extends FunctionReferenceImpl implements Function1<TypingUser, Unit> {
        public AnonymousClass44(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleTypingStart", "handleTypingStart(Lcom/discord/api/user/TypingUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
            invoke2(typingUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TypingUser typingUser) {
            Intrinsics3.checkNotNullParameter(typingUser, "p1");
            ((StoreStream) this.receiver).handleTypingStart(typingUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$45, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass45 extends Lambda implements Function1<Presence, Unit> {
        public AnonymousClass45() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Presence presence) {
            invoke2(presence);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Presence presence) {
            StoreStream storeStream = StoreStream.this;
            Long lD = presence.getGuildId();
            long jLongValue = lD != null ? lD.longValue() : 0L;
            Intrinsics3.checkNotNullExpressionValue(presence, "it");
            storeStream.handlePresenceUpdate(jLongValue, presence);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$46, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass46 extends FunctionReferenceImpl implements Function1<List<? extends Presence>, Unit> {
        public AnonymousClass46(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handlePresenceReplace", "handlePresenceReplace(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Presence> list) {
            invoke2((List<Presence>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Presence> list) {
            Intrinsics3.checkNotNullParameter(list, "p1");
            ((StoreStream) this.receiver).handlePresenceReplace(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$47, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass47 extends FunctionReferenceImpl implements Function1<ChannelRecipient, Unit> {
        public AnonymousClass47(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGroupDMRecipientAdd", "handleGroupDMRecipientAdd(Lcom/discord/api/channel/ChannelRecipient;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelRecipient channelRecipient) {
            invoke2(channelRecipient);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelRecipient channelRecipient) {
            Intrinsics3.checkNotNullParameter(channelRecipient, "p1");
            ((StoreStream) this.receiver).handleGroupDMRecipientAdd(channelRecipient);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$48, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass48 extends FunctionReferenceImpl implements Function1<ChannelRecipient, Unit> {
        public AnonymousClass48(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGroupDMRecipientRemove", "handleGroupDMRecipientRemove(Lcom/discord/api/channel/ChannelRecipient;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelRecipient channelRecipient) {
            invoke2(channelRecipient);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelRecipient channelRecipient) {
            Intrinsics3.checkNotNullParameter(channelRecipient, "p1");
            ((StoreStream) this.receiver).handleGroupDMRecipientRemove(channelRecipient);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$49, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass49 extends FunctionReferenceImpl implements Function1<ModelCall, Unit> {
        public AnonymousClass49(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleCallDelete", "handleCallDelete(Lcom/discord/models/domain/ModelCall;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            Intrinsics3.checkNotNullParameter(modelCall, "p1");
            ((StoreStream) this.receiver).handleCallDelete(modelCall);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Guild, Unit> {
        public AnonymousClass5(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildCreate", "handleGuildCreate(Lcom/discord/api/guild/Guild;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "p1");
            ((StoreStream) this.receiver).handleGuildCreate(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$50, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass50 extends FunctionReferenceImpl implements Function1<ModelCall, Unit> {
        public AnonymousClass50(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleCallCreateOrUpdate", "handleCallCreateOrUpdate(Lcom/discord/models/domain/ModelCall;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            Intrinsics3.checkNotNullParameter(modelCall, "p1");
            ((StoreStream) this.receiver).handleCallCreateOrUpdate(modelCall);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$51, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass51 extends FunctionReferenceImpl implements Function1<GuildEmojisUpdate, Unit> {
        public AnonymousClass51(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleEmojiUpdate", "handleEmojiUpdate(Lcom/discord/api/emoji/GuildEmojisUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildEmojisUpdate guildEmojisUpdate) {
            invoke2(guildEmojisUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildEmojisUpdate guildEmojisUpdate) {
            Intrinsics3.checkNotNullParameter(guildEmojisUpdate, "p1");
            ((StoreStream) this.receiver).handleEmojiUpdate(guildEmojisUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$52, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass52 extends FunctionReferenceImpl implements Function1<GuildStickersUpdate, Unit> {
        public AnonymousClass52(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStickersUpdate", "handleStickersUpdate(Lcom/discord/api/sticker/GuildStickersUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildStickersUpdate guildStickersUpdate) {
            invoke2(guildStickersUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildStickersUpdate guildStickersUpdate) {
            Intrinsics3.checkNotNullParameter(guildStickersUpdate, "p1");
            ((StoreStream) this.receiver).handleStickersUpdate(guildStickersUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$53, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass53 extends FunctionReferenceImpl implements Function1<UserRequiredActionUpdate, Unit> {
        public AnonymousClass53(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleRequiredActionUpdate", "handleRequiredActionUpdate(Lcom/discord/api/requiredaction/UserRequiredActionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserRequiredActionUpdate userRequiredActionUpdate) {
            invoke2(userRequiredActionUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserRequiredActionUpdate userRequiredActionUpdate) {
            Intrinsics3.checkNotNullParameter(userRequiredActionUpdate, "p1");
            ((StoreStream) this.receiver).handleRequiredActionUpdate(userRequiredActionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$54, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass54 extends FunctionReferenceImpl implements Function1<ModelGuildMemberListUpdate, Unit> {
        public AnonymousClass54(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMemberListUpdate", "handleGuildMemberListUpdate(Lcom/discord/models/domain/ModelGuildMemberListUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
            invoke2(modelGuildMemberListUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
            Intrinsics3.checkNotNullParameter(modelGuildMemberListUpdate, "p1");
            ((StoreStream) this.receiver).handleGuildMemberListUpdate(modelGuildMemberListUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$55, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass55 extends FunctionReferenceImpl implements Function1<List<? extends ModelSession>, Unit> {
        public AnonymousClass55(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleSessionsReplace", "handleSessionsReplace(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelSession> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelSession> list) {
            Intrinsics3.checkNotNullParameter(list, "p1");
            ((StoreStream) this.receiver).handleSessionsReplace(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$56, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass56 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass56() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreStream.this.handleUserPaymentSourcesUpdate();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$57, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass57 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass57() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreStream.this.handleUserSubscriptionsUpdate();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$58, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass58 extends FunctionReferenceImpl implements Function1<ModelApplicationStream3, Unit> {
        public AnonymousClass58(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStreamCreate", "handleStreamCreate(Lcom/discord/models/domain/StreamCreateOrUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStream3 modelApplicationStream3) {
            invoke2(modelApplicationStream3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStream3 modelApplicationStream3) {
            Intrinsics3.checkNotNullParameter(modelApplicationStream3, "p1");
            ((StoreStream) this.receiver).handleStreamCreate(modelApplicationStream3);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$59, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass59 extends FunctionReferenceImpl implements Function1<ModelApplicationStream3, Unit> {
        public AnonymousClass59(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStreamUpdate", "handleStreamUpdate(Lcom/discord/models/domain/StreamCreateOrUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStream3 modelApplicationStream3) {
            invoke2(modelApplicationStream3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStream3 modelApplicationStream3) {
            Intrinsics3.checkNotNullParameter(modelApplicationStream3, "p1");
            ((StoreStream) this.receiver).handleStreamUpdate(modelApplicationStream3);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$6, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<Guild, Unit> {
        public AnonymousClass6(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildUpdate", "handleGuildUpdate(Lcom/discord/api/guild/Guild;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "p1");
            ((StoreStream) this.receiver).handleGuildUpdate(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$60, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass60 extends Lambda implements Function1<ModelApplicationStream5, Unit> {
        public AnonymousClass60() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStream5 modelApplicationStream5) {
            invoke2(modelApplicationStream5);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStream5 modelApplicationStream5) {
            StoreStream storeStream = StoreStream.this;
            Intrinsics3.checkNotNullExpressionValue(modelApplicationStream5, "it");
            storeStream.handleStreamDelete(modelApplicationStream5, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$61, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass61 extends FunctionReferenceImpl implements Function1<ModelApplicationStream7, Unit> {
        public AnonymousClass61(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStreamServerUpdate", "handleStreamServerUpdate(Lcom/discord/models/domain/StreamServerUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStream7 modelApplicationStream7) {
            invoke2(modelApplicationStream7);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStream7 modelApplicationStream7) {
            Intrinsics3.checkNotNullParameter(modelApplicationStream7, "p1");
            ((StoreStream) this.receiver).handleStreamServerUpdate(modelApplicationStream7);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$62, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass62 extends FunctionReferenceImpl implements Function1<InteractionStateUpdate, Unit> {
        public AnonymousClass62(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionCreate", "handleInteractionCreate(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
            invoke2(interactionStateUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
            Intrinsics3.checkNotNullParameter(interactionStateUpdate, "p1");
            ((StoreStream) this.receiver).handleInteractionCreate(interactionStateUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$63, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass63 extends FunctionReferenceImpl implements Function1<InteractionStateUpdate, Unit> {
        public AnonymousClass63(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionSuccess", "handleInteractionSuccess(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
            invoke2(interactionStateUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
            Intrinsics3.checkNotNullParameter(interactionStateUpdate, "p1");
            ((StoreStream) this.receiver).handleInteractionSuccess(interactionStateUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$64, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass64 extends FunctionReferenceImpl implements Function1<InteractionStateUpdate, Unit> {
        public AnonymousClass64(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionFailure", "handleInteractionFailure(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
            invoke2(interactionStateUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
            Intrinsics3.checkNotNullParameter(interactionStateUpdate, "p1");
            ((StoreStream) this.receiver).handleInteractionFailure(interactionStateUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$65, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass65 extends FunctionReferenceImpl implements Function1<InteractionModalCreate, Unit> {
        public AnonymousClass65(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionModalCreate", "handleInteractionModalCreate(Lcom/discord/api/interaction/InteractionModalCreate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
            invoke2(interactionModalCreate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionModalCreate interactionModalCreate) {
            Intrinsics3.checkNotNullParameter(interactionModalCreate, "p1");
            ((StoreStream) this.receiver).handleInteractionModalCreate(interactionModalCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$66, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass66 extends FunctionReferenceImpl implements Function1<ApplicationCommandAutocompleteResult, Unit> {
        public AnonymousClass66(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleApplicationCommandAutocompleteResult", "handleApplicationCommandAutocompleteResult(Lcom/discord/api/commands/ApplicationCommandAutocompleteResult;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult) {
            invoke2(applicationCommandAutocompleteResult);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult) {
            Intrinsics3.checkNotNullParameter(applicationCommandAutocompleteResult, "p1");
            ((StoreStream) this.receiver).handleApplicationCommandAutocompleteResult(applicationCommandAutocompleteResult);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$67, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass67 extends FunctionReferenceImpl implements Function1<StageInstance, Unit> {
        public AnonymousClass67(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStageInstanceCreate", "handleStageInstanceCreate(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(stageInstance, "p1");
            ((StoreStream) this.receiver).handleStageInstanceCreate(stageInstance);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$68, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass68 extends FunctionReferenceImpl implements Function1<StageInstance, Unit> {
        public AnonymousClass68(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStageInstanceUpdate", "handleStageInstanceUpdate(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(stageInstance, "p1");
            ((StoreStream) this.receiver).handleStageInstanceUpdate(stageInstance);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$69, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass69 extends FunctionReferenceImpl implements Function1<StageInstance, Unit> {
        public AnonymousClass69(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStageInstanceDelete", "handleStageInstanceDelete(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(stageInstance, "p1");
            ((StoreStream) this.receiver).handleStageInstanceDelete(stageInstance);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$7, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<GuildRoleCreate, Unit> {
        public AnonymousClass7(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRoleCreate", "handleGuildRoleCreate(Lcom/discord/api/role/GuildRoleCreate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleCreate guildRoleCreate) {
            invoke2(guildRoleCreate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleCreate guildRoleCreate) {
            Intrinsics3.checkNotNullParameter(guildRoleCreate, "p1");
            ((StoreStream) this.receiver).handleGuildRoleCreate(guildRoleCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$70, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass70 extends FunctionReferenceImpl implements Function1<FriendSuggestion, Unit> {
        public AnonymousClass70(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleFriendSuggestionCreate", "handleFriendSuggestionCreate(Lcom/discord/api/friendsuggestions/FriendSuggestion;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendSuggestion friendSuggestion) {
            invoke2(friendSuggestion);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendSuggestion friendSuggestion) {
            Intrinsics3.checkNotNullParameter(friendSuggestion, "p1");
            ((StoreStream) this.receiver).handleFriendSuggestionCreate(friendSuggestion);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$71, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass71 extends FunctionReferenceImpl implements Function1<FriendSuggestionDelete, Unit> {
        public AnonymousClass71(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleFriendSuggestionDelete", "handleFriendSuggestionDelete(Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendSuggestionDelete friendSuggestionDelete) {
            invoke2(friendSuggestionDelete);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendSuggestionDelete friendSuggestionDelete) {
            Intrinsics3.checkNotNullParameter(friendSuggestionDelete, "p1");
            ((StoreStream) this.receiver).handleFriendSuggestionDelete(friendSuggestionDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$72, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass72 extends FunctionReferenceImpl implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass72(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildScheduledEventCreate", "handleGuildScheduledEventCreate(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "p1");
            ((StoreStream) this.receiver).handleGuildScheduledEventCreate(guildScheduledEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$73, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass73 extends FunctionReferenceImpl implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass73(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildScheduledEventUpdate", "handleGuildScheduledEventUpdate(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "p1");
            ((StoreStream) this.receiver).handleGuildScheduledEventUpdate(guildScheduledEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$74, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass74 extends FunctionReferenceImpl implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass74(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildScheduledEventDelete", "handleGuildScheduledEventDelete(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "p1");
            ((StoreStream) this.receiver).handleGuildScheduledEventDelete(guildScheduledEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$75, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass75 extends FunctionReferenceImpl implements Function1<GuildScheduledEventUserUpdate, Unit> {
        public AnonymousClass75(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "guildScheduledEventUserAdd", "guildScheduledEventUserAdd(Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            invoke2(guildScheduledEventUserUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventUserUpdate, "p1");
            ((StoreStream) this.receiver).guildScheduledEventUserAdd(guildScheduledEventUserUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$76, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass76 extends FunctionReferenceImpl implements Function1<GuildScheduledEventUserUpdate, Unit> {
        public AnonymousClass76(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "guildScheduledEventUserRemove", "guildScheduledEventUserRemove(Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            invoke2(guildScheduledEventUserUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventUserUpdate, "p1");
            ((StoreStream) this.receiver).guildScheduledEventUserRemove(guildScheduledEventUserUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$77, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass77 extends FunctionReferenceImpl implements Function1<EmbeddedActivityInboundUpdate, Unit> {
        public AnonymousClass77(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleEmbeddedActivityInboundUpdate", "handleEmbeddedActivityInboundUpdate(Lcom/discord/api/embeddedactivities/EmbeddedActivityInboundUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
            invoke2(embeddedActivityInboundUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
            Intrinsics3.checkNotNullParameter(embeddedActivityInboundUpdate, "p1");
            ((StoreStream) this.receiver).handleEmbeddedActivityInboundUpdate(embeddedActivityInboundUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$78, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass78 extends FunctionReferenceImpl implements Function1<ForumUnreads, Unit> {
        public AnonymousClass78(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleForumUnreads", "handleForumUnreads(Lcom/discord/api/forum/ForumUnreads;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ForumUnreads forumUnreads) {
            invoke2(forumUnreads);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForumUnreads forumUnreads) {
            Intrinsics3.checkNotNullParameter(forumUnreads, "p1");
            ((StoreStream) this.receiver).handleForumUnreads(forumUnreads);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$8, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<GuildRoleUpdate, Unit> {
        public AnonymousClass8(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRoleUpdate", "handleGuildRoleUpdate(Lcom/discord/api/role/GuildRoleUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleUpdate guildRoleUpdate) {
            invoke2(guildRoleUpdate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleUpdate guildRoleUpdate) {
            Intrinsics3.checkNotNullParameter(guildRoleUpdate, "p1");
            ((StoreStream) this.receiver).handleGuildRoleUpdate(guildRoleUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$9, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<GuildRoleDelete, Unit> {
        public AnonymousClass9(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRoleDelete", "handleGuildRoleDelete(Lcom/discord/api/role/GuildRoleDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleDelete guildRoleDelete) {
            invoke2(guildRoleDelete);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleDelete guildRoleDelete) {
            Intrinsics3.checkNotNullParameter(guildRoleDelete, "p1");
            ((StoreStream) this.receiver).handleGuildRoleDelete(guildRoleDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$maybeLogNotificationPermissionStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, Unit> {
        public final /* synthetic */ Application $context;
        public final /* synthetic */ long $currentTime;
        public final /* synthetic */ SharedPreferences $sharedPrefs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SharedPreferences sharedPreferences, long j, Application application) {
            super(1);
            this.$sharedPrefs = sharedPreferences;
            this.$currentTime = j;
            this.$context = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationClient.SettingsV2 settingsV2) {
            invoke2(settingsV2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationClient.SettingsV2 settingsV2) {
            this.$sharedPrefs.edit().putLong(StoreStream.LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY, this.$currentTime).apply();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Application application = this.$context;
            Intrinsics3.checkNotNullExpressionValue(settingsV2, "it");
            analyticsTracker.notificationPermissionStatus(application, settingsV2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$startStoreInitializationTimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Object, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$startStoreInitializationTimer$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final class C01791 extends Lambda implements Function0<Unit> {
            public C01791() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.this.handleStoreInitializationTimeout();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            StoreStream.this.dispatcher.schedule(new C01791());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreStream() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.discord.stores.StoreStream$storeThreadScheduler$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Thread thread = new Thread(runnable, companion.getSTORE_THREAD_NAME());
                thread.setPriority((int) 8.0d);
                companion.setSTORE_THREAD_ID(thread.getId());
                return thread;
            }
        });
        AtomicReference<Schedulers2> atomicReference = Schedulers2.a;
        ExecutorScheduler executorScheduler = new ExecutorScheduler(executorServiceNewSingleThreadExecutor);
        Intrinsics3.checkNotNullExpressionValue(executorScheduler, "Schedulers.from(Executor…       newThread\n      })");
        this.storeThreadScheduler = executorScheduler;
        Dispatcher dispatcher = new Dispatcher(executorScheduler, false);
        this.dispatcher = dispatcher;
        Clock clock = ClockFactory.get();
        this.clock = clock;
        StoreAnalytics storeAnalytics = new StoreAnalytics(this, dispatcher, clock);
        this.analytics = storeAnalytics;
        StoreAuthentication storeAuthentication = new StoreAuthentication(this, dispatcher);
        this.authentication = storeAuthentication;
        StoreChannels storeChannels = new StoreChannels(dispatcher, ObservationDeck4.get(), new StoreStream$channels$1(this), new StoreStream$channels$2(this), new StoreStream$channels$3(this), null, 32, null);
        this.channels = storeChannels;
        ObservationDeck observationDeck = null;
        StoreUser storeUser = new StoreUser(new StoreStream$users$1(this), dispatcher, observationDeck, null, 12, 0 == true ? 1 : 0);
        this.users = storeUser;
        StoreGuilds storeGuilds = new StoreGuilds(storeUser, dispatcher, observationDeck, 4, null);
        this.guilds = storeGuilds;
        StoreStageInstances storeStageInstances = new StoreStageInstances(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.stageInstances = storeStageInstances;
        this.requestedStageChannels = new StoreRequestedStageChannels(dispatcher, null, null, 6, null);
        StoreThreadsJoined storeThreadsJoined = new StoreThreadsJoined(storeUser, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        this.threadsJoined = storeThreadsJoined;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.guildSettings = new StoreUserGuildSettings(dispatcher, clock, storeAnalytics, storeChannels, storeThreadsJoined, null, 0 == true ? 1 : 0, 96, defaultConstructorMarker);
        StorePermissions storePermissions = new StorePermissions(storeUser, storeChannels, storeGuilds, storeThreadsJoined, storeStageInstances, ObservationDeck4.get());
        this.permissions = storePermissions;
        StoreGuildSelected storeGuildSelected = new StoreGuildSelected(this, dispatcher, storeGuilds, storeAnalytics, null, 16, null);
        this.guildSelected = storeGuildSelected;
        StoreChannelsSelected storeChannelsSelected = new StoreChannelsSelected(this, storeChannels, storePermissions, storeGuildSelected, dispatcher, ObservationDeck4.get());
        this.channelsSelected = storeChannelsSelected;
        this.channelConversions = new StoreChannelConversions();
        this.clientVersion = new StoreClientVersion();
        StoreGuildMemberCounts storeGuildMemberCounts = new StoreGuildMemberCounts();
        this.guildMemberCounts = storeGuildMemberCounts;
        this.guildJoinRequests = new StoreGuildJoinRequest(storeUser, storeGuilds, dispatcher, ObservationDeck4.get());
        StoreGuildsNsfw storeGuildsNsfw = new StoreGuildsNsfw(dispatcher, storeChannels, ObservationDeck4.get());
        this.guildsNsfw = storeGuildsNsfw;
        this.bans = new StoreBans(dispatcher, ObservationDeck4.get());
        ObservationDeck observationDeck2 = ObservationDeck4.get();
        RestAPI.Companion companion = RestAPI.INSTANCE;
        this.guildEmojis = new StoreEmojiGuild(observationDeck2, dispatcher, companion.getApi());
        this.integrations = new StoreGuildIntegrations(dispatcher);
        this.instantInvites = new StoreInstantInvites(dispatcher, null, null, 6, null);
        this.guildTemplates = new StoreGuildTemplates(ObservationDeck4.get(), dispatcher, companion.getApi());
        this.guildInvite = new StoreInviteSettings();
        StoreMessages storeMessages = new StoreMessages(this, dispatcher, clock);
        this.messages = storeMessages;
        this.messagesLoader = new StoreMessagesLoader(this, dispatcher);
        this.messagesMostRecent = new StoreMessagesMostRecent(storeChannels, null, 2, 0 == true ? 1 : 0);
        StoreMessageAck storeMessageAck = new StoreMessageAck(this, ObservationDeck4.get(), dispatcher, companion.getApi());
        this.messageAck = storeMessageAck;
        this.messageReplies = new StoreMessageReplies(dispatcher, storeMessages, 0 == true ? 1 : 0, 4, defaultConstructorMarker);
        this.messageStates = new StoreMessageState(dispatcher);
        this.notifications = new StoreNotifications(clock, this);
        StoreExperiments storeExperiments = new StoreExperiments(clock, dispatcher, storeUser, storeGuilds, storeAuthentication, storeGuildMemberCounts, 0 == true ? 1 : 0, 64, defaultConstructorMarker);
        this.experiments = storeExperiments;
        this.lurking = new StoreLurking(this, storeGuilds, dispatcher);
        this.userConnections = new StoreUserConnections(this, dispatcher, null, 4, null);
        StoreUserPresence storeUserPresence = new StoreUserPresence(clock, this, ObservationDeck4.get());
        this.presences = storeUserPresence;
        this.userProfile = new StoreUserProfile(dispatcher, ObservationDeck4.get(), this, null, 8, null);
        this.userNotes = new StoreUserNotes(dispatcher, 0 == true ? 1 : 0, null, 6, null);
        this.usersTyping = new StoreUserTyping(this, dispatcher, null, 0 == true ? 1 : 0, 12, null);
        StoreAccessibility storeAccessibility = new StoreAccessibility(dispatcher, 0 == true ? 1 : 0, null, 6, null);
        this.accessibility = storeAccessibility;
        this.userSettings = new StoreUserSettings(dispatcher, storeAccessibility);
        StoreUserSettingsSystem storeUserSettingsSystem = new StoreUserSettingsSystem(new StoreStream$userSettingsSystem$1(this), dispatcher);
        this.userSettingsSystem = storeUserSettingsSystem;
        this.userSurvey = new StoreUserSurvey(dispatcher, storeUser, storeGuilds, storePermissions, ObservationDeck4.get(), companion.getApi(), clock, SharedPreferencesProvider.INSTANCE.get());
        this.userRequiredAction = new StoreUserRequiredActions(ObservationDeck4.get());
        StoreUserRelationships storeUserRelationships = new StoreUserRelationships(null, 1, 0 == true ? 1 : 0);
        this.userRelationships = storeUserRelationships;
        StoreVoiceStates storeVoiceStates = new StoreVoiceStates(new StoreStream$voiceStates$1(this), ObservationDeck4.get());
        this.voiceStates = storeVoiceStates;
        this.tabsNavigation = new StoreTabsNavigation(dispatcher, this, null, 4, null);
        this.maskedLinks = new StoreMaskedLinks(this.dispatcher, storeChannelsSelected, storeUserRelationships);
        this.navigation = new StoreNavigation(this);
        this.customEmojis = new StoreEmojiCustom(this);
        StoreVoiceChannelSelected storeVoiceChannelSelected = new StoreVoiceChannelSelected(this, this.dispatcher, this.clock, null, 8, null);
        this.voiceChannelSelected = storeVoiceChannelSelected;
        StoreAudioManagerV2.VideoUseDetector videoUseDetector = new StoreAudioManagerV2.VideoUseDetector(this.channels, storeVoiceStates, this.users);
        this.videoUseDetector = videoUseDetector;
        this.gatewaySocket = new StoreGatewayConnection(this, this.clock, null, null, AppGatewaySocketLogger.INSTANCE.getINSTANCE(), 12, null);
        this.connectivity = new StoreConnectivity(this, this.dispatcher, this.clock);
        this.connectionOpen = new StoreConnectionOpen();
        this.calls = new StoreCalls(this);
        this.callsIncoming = new StoreCallsIncoming(this.dispatcher, ObservationDeck4.get(), this.users);
        this.chat = new StoreChat(this.dispatcher, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        this.mentions = new StoreMentions(storeUserRelationships, this.permissions, storeMessageAck, this.guildSettings, this.channels, this.threadsJoined, null, 64, null);
        this.pinnedMessages = new StorePinnedMessages(this.dispatcher, ObservationDeck4.get());
        this.readStates = new StoreReadStates(this.clock);
        this.voiceParticipants = new StoreVoiceParticipants(this);
        this.search = new StoreSearch(this, this.dispatcher, storeGuildsNsfw, this.users, ObservationDeck4.get(), this.channels, this.guilds);
        StoreMediaSettings storeMediaSettings = new StoreMediaSettings(storeVoiceChannelSelected, this.channels, this.permissions, null, null, 24, null);
        this.mediaSettings = storeMediaSettings;
        this.storeDynamicLink = new StoreDynamicLink(this, this.dispatcher);
        this.collapsedChannelCategories = new StoreCollapsedChannelCategories(this.dispatcher, ObservationDeck4.get());
        StoreMediaEngine storeMediaEngine = new StoreMediaEngine(storeMediaSettings, this, this.dispatcher);
        this.mediaEngine = storeMediaEngine;
        StoreRtcRegion storeRtcRegion = new StoreRtcRegion(this.dispatcher, this.clock, storeMediaEngine, storeExperiments, null, 16, 0 == true ? 1 : 0);
        this.rtcRegion = storeRtcRegion;
        StoreRtcConnection storeRtcConnection = new StoreRtcConnection(this, this.dispatcher, this.clock, storeRtcRegion, this.analytics, storeVoiceStates, null, null, Opcodes.CHECKCAST, null);
        this.rtcConnection = storeRtcConnection;
        this.voiceSpeaking = new StoreVoiceSpeaking(ObservationDeck4.get());
        this.videoStreams = new StoreVideoStreams(null, 1, 0 == true ? 1 : 0);
        this.gameParty = new StoreGameParty(ObservationDeck4.get(), storeUserPresence, this.users);
        StoreNotices storeNotices = new StoreNotices(this.clock, this);
        this.notices = storeNotices;
        this.guildSubscriptions = new StoreGuildSubscriptions(this, this.dispatcher);
        StoreApplicationStreaming storeApplicationStreaming = new StoreApplicationStreaming(this, this.dispatcher, this.users, storeVoiceChannelSelected, storeRtcConnection, null, 32, null);
        this.applicationStreaming = storeApplicationStreaming;
        this.lazyChannelMembersStore = new StoreChannelMembers(ObservationDeck4.get(), this.dispatcher, this.guilds, this.users, new StoreStream$lazyChannelMembersStore$1(this.channels), new StoreStream$lazyChannelMembersStore$2(this.guildMemberCounts), new StoreStream$lazyChannelMembersStore$3(storeUserPresence.getPresences()), new StoreStream$lazyChannelMembersStore$4(storeApplicationStreaming));
        this.lazyThreadMembersStore = new StoreThreadMembers(ObservationDeck4.get(), this.channels);
        this.guildMemberRequesterStore = new StoreGuildMemberRequester(this, this.dispatcher);
        this.reviewRequestStore = new StoreReviewRequest(this.clock, this);
        this.changeLogStore = new StoreChangeLog(this.clock, storeNotices, this.users, storeUserSettingsSystem, this.experiments, this.dispatcher);
        this.slowMode = new StoreSlowMode(this.clock, this);
        this.auditLog = new StoreAuditLog(ObservationDeck4.get(), this.dispatcher, companion.getApi());
        this.messageUploads = new StoreMessageUploads();
        this.nux = new StoreNux(this.dispatcher);
        this.library = new StoreLibrary(this.dispatcher, ObservationDeck4.get());
        this.gifting = new StoreGifting(this.dispatcher);
        this.spotify = new StoreSpotify(this, this.dispatcher, this.clock);
        this.messageReactions = new StoreMessageReactions(this.dispatcher, this.users, null, 4, null);
        this.application = new StoreApplication(this.dispatcher, ObservationDeck4.get());
        this.applicationAssets = new StoreApplicationAssets(this.dispatcher, null, 0 == true ? 1 : 0, 6, 0 == true ? 1 : 0);
        this.paymentSources = new StorePaymentSources(this.dispatcher, null, null, 6, null);
        this.subscriptions = new StoreSubscriptions(ObservationDeck4.get(), this.dispatcher, companion.getApi());
        this.mfa = new StoreMFA(this, this.dispatcher, ObservationDeck4.get());
        StoreStreamRtcConnection storeStreamRtcConnection = new StoreStreamRtcConnection(storeMediaEngine, this.users, this, this.dispatcher, this.clock, this.analytics, storeRtcConnection, 0 == true ? 1 : 0, null, null, 896, null);
        this.streamRtcConnection = storeStreamRtcConnection;
        this.audioManagerV2 = new StoreAudioManagerV2(ObservationDeck4.get(), this.dispatcher, storeVoiceChannelSelected, this.channels, storeStreamRtcConnection, videoUseDetector, this.experiments);
        this.applicationStreamPreviews = new StoreApplicationStreamPreviews(this.dispatcher, this.clock, null, 0 == true ? 1 : 0, 12, 0 == true ? 1 : 0);
        StoreGuildsSorted storeGuildsSorted = new StoreGuildsSorted(ObservationDeck4.get(), this.dispatcher, this.guilds, this.lurking);
        this.guildsSorted = storeGuildsSorted;
        int i = 2;
        this.expandedGuildFolders = new StoreExpandedGuildFolders(this.dispatcher, null, i, 0 == true ? 1 : 0);
        StoreMediaFavorites storeMediaFavorites = new StoreMediaFavorites(ObservationDeck4.get(), this.dispatcher, null, 4, 0 == true ? 1 : 0);
        this.mediaFavorites = storeMediaFavorites;
        this.emojis = new StoreEmoji(this.customEmojis, this.users, this.permissions, storeGuildsSorted, storeMediaFavorites);
        StoreGuildBoost storeGuildBoost = new StoreGuildBoost(this.dispatcher, ObservationDeck4.get());
        this.guildBoosts = storeGuildBoost;
        StoreEntitlements storeEntitlements = new StoreEntitlements(this.dispatcher, ObservationDeck4.get(), null, 4, null);
        this.entitlements = storeEntitlements;
        StoreGuildProfiles storeGuildProfiles = new StoreGuildProfiles(this.dispatcher, ObservationDeck4.get());
        this.guildProfiles = storeGuildProfiles;
        StoreGuildWelcomeScreens storeGuildWelcomeScreens = new StoreGuildWelcomeScreens(this.dispatcher, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this.guildWelcomeScreens = storeGuildWelcomeScreens;
        StoreGuildVoiceRegions storeGuildVoiceRegions = new StoreGuildVoiceRegions(this.dispatcher, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this.guildVoiceRegions = storeGuildVoiceRegions;
        StoreUserAffinities storeUserAffinities = new StoreUserAffinities(this.dispatcher, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this.userAffinities = storeUserAffinities;
        StoreClientDataState storeClientDataState = new StoreClientDataState(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.clientDataState = storeClientDataState;
        StoreGifPicker storeGifPicker = new StoreGifPicker(this.dispatcher, this.userSettingsSystem, null, null, 12, null);
        this.gifPicker = storeGifPicker;
        StoreStickers storeStickers = new StoreStickers(this.dispatcher, null, 0 == true ? 1 : 0, null, 14, null);
        this.stickers = storeStickers;
        StoreGooglePlayPurchases storeGooglePlayPurchases = new StoreGooglePlayPurchases(ObservationDeck4.get(), this.dispatcher, companion.getApi(), this.clock, new Gson(), AnalyticsTracker.INSTANCE);
        this.googlePlayPurchases = storeGooglePlayPurchases;
        StoreGooglePlaySkuDetails storeGooglePlaySkuDetails = new StoreGooglePlaySkuDetails(ObservationDeck4.get(), this.dispatcher);
        this.googlePlaySkuDetails = storeGooglePlaySkuDetails;
        StoreExpressionPickerNavigation storeExpressionPickerNavigation = new StoreExpressionPickerNavigation(ObservationDeck4.get(), this.dispatcher);
        this.expressionPickerNavigation = storeExpressionPickerNavigation;
        StoreChannelFollowerStats storeChannelFollowerStats = new StoreChannelFollowerStats(this.dispatcher, ObservationDeck4.get());
        this.channelFollowerStats = storeChannelFollowerStats;
        int i2 = 2;
        StoreApplicationCommandFrecency storeApplicationCommandFrecency = new StoreApplicationCommandFrecency(this.dispatcher, null, i2, 0 == true ? 1 : 0);
        this.applicationCommandFrecency = storeApplicationCommandFrecency;
        StorePendingReplies storePendingReplies = new StorePendingReplies(this.dispatcher, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        this.pendingReplies = storePendingReplies;
        StoreApplicationCommands storeApplicationCommands = new StoreApplicationCommands(this.gatewaySocket, this.permissions, storeApplicationCommandFrecency, this.guilds, this.users, this.experiments, this.dispatcher, null, ObservationDeck4.get(), null, null, 1664, null);
        this.applicationCommands = storeApplicationCommands;
        StoreLocalActionComponentState storeLocalActionComponentState = new StoreLocalActionComponentState(this.dispatcher, null, 2, 0 == true ? 1 : 0);
        this.localActionComponentState = storeLocalActionComponentState;
        StoreApplicationInteractions storeApplicationInteractions = new StoreApplicationInteractions(this, this.dispatcher, this.messages, storeLocalActionComponentState, this.users, this.clock, null, null, null, null, 960, null);
        this.applicationInteractions = storeApplicationInteractions;
        StoreGuildMemberVerificationForm storeGuildMemberVerificationForm = new StoreGuildMemberVerificationForm(this.dispatcher, null, null, 6, null);
        this.memberVerificationForms = storeGuildMemberVerificationForm;
        StorePhone storePhone = new StorePhone(this.dispatcher);
        this.phone = storePhone;
        StoreThreadsActive storeThreadsActive = new StoreThreadsActive(this.channels, null, 2, 0 == true ? 1 : 0);
        this.threadsActive = storeThreadsActive;
        StoreThreadsActiveJoined storeThreadsActiveJoined = new StoreThreadsActiveJoined(storeThreadsActive, this.threadsJoined, ObservationDeck4.get());
        this.threadsActiveJoined = storeThreadsActiveJoined;
        StoreThreadMessages storeThreadMessages = new StoreThreadMessages(this.messages, this.channels, ObservationDeck4.get());
        this.threadMessages = storeThreadMessages;
        StoreForumPostMessages storeForumPostMessages = new StoreForumPostMessages(this.dispatcher, this.users, ObservationDeck4.get());
        this.forumPostMessages = storeForumPostMessages;
        StoreForumPostReadStates storeForumPostReadStates = new StoreForumPostReadStates(this.dispatcher, this.gatewaySocket, storeThreadsActive, this.messageAck, this.channels, this.users, ObservationDeck4.get());
        this.forumPostReadStates = storeForumPostReadStates;
        ArchivedThreadsStore archivedThreadsStore = new ArchivedThreadsStore(this, this.dispatcher, storeForumPostMessages, ObservationDeck4.get());
        this.archivedThreads = archivedThreadsStore;
        StoreThreadDraft storeThreadDraft = new StoreThreadDraft(this.dispatcher);
        this.threadDraft = storeThreadDraft;
        StoreExpressionSuggestions storeExpressionSuggestions = new StoreExpressionSuggestions(ObservationDeck4.get(), this.dispatcher, null, 4, null);
        this.expressionSuggestions = storeExpressionSuggestions;
        StoreStageChannels storeStageChannels = new StoreStageChannels(this.users, this.guilds, this.channels, this.voiceStates, this.permissions, this.stageInstances, null, 64, null);
        this.stageChannels = storeStageChannels;
        StoreStageChannelSelfPresence storeStageChannelSelfPresence = new StoreStageChannelSelfPresence(ObservationDeck4.get(), this.users, this.presences, storeStageChannels, this.voiceChannelSelected, this.userSettings, this.dispatcher);
        this.stageSelfPresence = storeStageChannelSelfPresence;
        StoreAutocomplete storeAutocomplete = new StoreAutocomplete(ObservationDeck4.get(), this.dispatcher);
        this.autocomplete = storeAutocomplete;
        StoreContactSync storeContactSync = new StoreContactSync(this.dispatcher, companion.getApi(), this.clock, this.userConnections, this.users, this.experiments, this.notices, this.userSettings);
        this.contactSync = storeContactSync;
        Dispatcher dispatcher2 = this.dispatcher;
        StoreFriendSuggestions storeFriendSuggestions = new StoreFriendSuggestions(this, dispatcher2, new FriendSuggestionsFetcher(dispatcher2, companion.getApi(), new StoreStream$friendSuggestions$1(this), new StoreStream$friendSuggestions$2(this)));
        this.friendSuggestions = storeFriendSuggestions;
        StoreGuildStickers storeGuildStickers = new StoreGuildStickers(this.dispatcher, null, new StoreStream$guildStickers$1(this), 2, null);
        this.guildStickers = storeGuildStickers;
        StoreOutboundPromotions storeOutboundPromotions = new StoreOutboundPromotions(new OutboundPromosPreviewFeatureFlag(this.experiments), this.dispatcher, 0 == true ? 1 : 0, null, 12, null);
        this.outboundPromotions = storeOutboundPromotions;
        StoreGuildScheduledEvents storeGuildScheduledEvents = new StoreGuildScheduledEvents(this.dispatcher, ObservationDeck4.get(), this.permissions, this.users, this.guilds, this.clock, this.experiments);
        this.guildScheduledEvents = storeGuildScheduledEvents;
        StoreDirectories storeDirectories = new StoreDirectories(this.dispatcher, ObservationDeck4.get(), this.guilds, storeGuildScheduledEvents, null, 16, null);
        this.directories = storeDirectories;
        int i3 = 2;
        StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = new StoreGuildRoleSubscriptions(this.dispatcher, null, i3, 0 == true ? 1 : 0);
        this.guildRoleSubscriptions = storeGuildRoleSubscriptions;
        StoreNotificationUpsells storeNotificationUpsells = new StoreNotificationUpsells(this.dispatcher, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        this.notificationUpsells = storeNotificationUpsells;
        ConnectionTimeStats connectionTimeStats = new ConnectionTimeStats(this.clock);
        this.connectionTimeStats = connectionTimeStats;
        StoreEmbeddedActivities storeEmbeddedActivities = new StoreEmbeddedActivities(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.embeddedActivities = storeEmbeddedActivities;
        StoreGuildRoleMemberCounts storeGuildRoleMemberCounts = new StoreGuildRoleMemberCounts(this.dispatcher, this.clock, null, 4, null);
        this.guildRoleMemberCounts = storeGuildRoleMemberCounts;
        List<StoreV2> listListOf = Collections2.listOf((Object[]) new StoreV2[]{this.bans, this.users, this.guilds, this.channels, this.channelConversions, this.presences, this.permissions, this.voiceChannelSelected, this.voiceSpeaking, this.accessibility, this.callsIncoming, this.connectivity, this.connectionOpen, storeGuildWelcomeScreens, storeGuildVoiceRegions, this.videoStreams, storeClientDataState, storeGifPicker, storeStickers, this.guildMemberCounts, this.guildJoinRequests, this.experiments, this.messageReplies, storeChannelFollowerStats, storePendingReplies, storeGuildProfiles, this.application, this.applicationAssets, storeApplicationCommands, this.guildSelected, this.channelsSelected, this.pinnedMessages, storeGuildMemberVerificationForm, this.userRequiredAction, this.userSurvey, storePhone, storeThreadsActive, this.threadsJoined, storeThreadsActiveJoined, storeThreadMessages, archivedThreadsStore, storeThreadDraft, storeExpressionPickerNavigation, storeGuildBoost, this.collapsedChannelCategories, this.messageUploads, storeExpressionSuggestions, this.applicationStreaming, storeApplicationInteractions, storeApplicationCommandFrecency, storeLocalActionComponentState, this.stageInstances, this.requestedStageChannels, storeStageChannels, storeStageChannelSelfPresence, storeAutocomplete, this.messageReactions, this.library, this.userRelationships, this.userSettingsSystem, this.tabsNavigation, this.voiceStates, this.mentions, storeUserAffinities, this.userProfile, this.userConnections, this.messagesMostRecent, this.usersTyping, this.instantInvites, this.guildSettings, this.customEmojis, storeEntitlements, this.mediaFavorites, this.subscriptions, storeGooglePlayPurchases, storeGooglePlaySkuDetails, this.guildTemplates, this.userNotes, this.mfa, this.messageAck, this.guildSubscriptions, this.lazyChannelMembersStore, this.lazyThreadMembersStore, this.guildEmojis, this.guildsSorted, this.auditLog, this.expandedGuildFolders, this.maskedLinks, this.streamRtcConnection, this.paymentSources, storeContactSync, this.applicationStreamPreviews, this.guildsNsfw, this.gameParty, storeFriendSuggestions, this.chat, this.audioManagerV2, storeGuildStickers, storeOutboundPromotions, storeDirectories, storeGuildScheduledEvents, storeGuildRoleSubscriptions, storeNotificationUpsells, storeEmbeddedActivities, storeGuildRoleMemberCounts, storeForumPostMessages, storeForumPostReadStates});
        this.storesV2 = listListOf;
        StoreV2DispatchHandler storeV2DispatchHandler = new StoreV2DispatchHandler(listListOf, null, 2, 0 == true ? 1 : 0);
        this.storeV2DispatchHandler = storeV2DispatchHandler;
        this.dispatcher.registerDispatchHandlers(storeV2DispatchHandler);
        connectionTimeStats.addListener(this.rtcConnection);
        connectionTimeStats.addListener(this.streamRtcConnection);
        connectionTimeStats.addListener(this.mediaEngine);
    }

    private final void deferredInit(Application context) {
        this.dispatcher.schedule(new AnonymousClass1(context));
    }

    private final <T> void dispatchSubscribe(Observable<T> observable, String str, Function1<? super T, Unit> function1) {
        Observable<T> observableK = observable.K();
        Intrinsics3.checkNotNullExpressionValue(observableK, "onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe(observableK, (117 & 1) != 0 ? null : null, str, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(function1), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    public static final StoreAnalytics getAnalytics() {
        return INSTANCE.getAnalytics();
    }

    public static final StoreApplication getApplication() {
        return INSTANCE.getApplication();
    }

    public static final StoreApplicationCommands getApplicationCommands() {
        return INSTANCE.getApplicationCommands();
    }

    public static final StoreApplicationStreamPreviews getApplicationStreamPreviews() {
        return INSTANCE.getApplicationStreamPreviews();
    }

    public static final StoreApplicationStreaming getApplicationStreaming() {
        return INSTANCE.getApplicationStreaming();
    }

    public static final StoreAuditLog getAuditLog() {
        return INSTANCE.getAuditLog();
    }

    public static final StoreAuthentication getAuthentication() {
        return INSTANCE.getAuthentication();
    }

    public static final StoreBans getBans() {
        return INSTANCE.getBans();
    }

    public static final StoreCalls getCalls() {
        return INSTANCE.getCalls();
    }

    public static final StoreCallsIncoming getCallsIncoming() {
        return INSTANCE.getCallsIncoming();
    }

    public static final StoreChangeLog getChangeLog() {
        return INSTANCE.getChangeLog();
    }

    public static final StoreChannelFollowerStats getChannelFollowerStats() {
        return INSTANCE.getChannelFollowerStats();
    }

    public static final StoreChannelMembers getChannelMembers() {
        return INSTANCE.getChannelMembers();
    }

    public static final StoreChannels getChannels() {
        return INSTANCE.getChannels();
    }

    public static final StoreChannelsSelected getChannelsSelected() {
        return INSTANCE.getChannelsSelected();
    }

    public static final StoreChat getChat() {
        return INSTANCE.getChat();
    }

    public static final StoreConnectivity getConnectivity() {
        return INSTANCE.getConnectivity();
    }

    public static final Dispatcher getDispatcherYesThisIsIntentional() {
        return INSTANCE.getDispatcherYesThisIsIntentional();
    }

    public static final StoreDynamicLink getDynamicLinkCache() {
        return INSTANCE.getDynamicLinkCache();
    }

    public static final StoreEmoji getEmojis() {
        return INSTANCE.getEmojis();
    }

    public static final StoreEntitlements getEntitlements() {
        return INSTANCE.getEntitlements();
    }

    public static final StoreExpandedGuildFolders getExpandedGuildFolders() {
        return INSTANCE.getExpandedGuildFolders();
    }

    public static final StoreExperiments getExperiments() {
        return INSTANCE.getExperiments();
    }

    public static final StoreGameParty getGameParty() {
        return INSTANCE.getGameParty();
    }

    public static final StoreGatewayConnection getGatewaySocket() {
        return INSTANCE.getGatewaySocket();
    }

    public static final StoreGifting getGifting() {
        return INSTANCE.getGifting();
    }

    public static final StoreGuildBoost getGuildBoosts() {
        return INSTANCE.getGuildBoosts();
    }

    public static final StoreEmojiGuild getGuildEmojis() {
        return INSTANCE.getGuildEmojis();
    }

    public static final StoreGuildIntegrations getGuildIntegrations() {
        return INSTANCE.getGuildIntegrations();
    }

    public static final StoreGuildJoinRequest getGuildJoinRequests() {
        return INSTANCE.getGuildJoinRequests();
    }

    public static final StoreGuildMemberCounts getGuildMemberCounts() {
        return INSTANCE.getGuildMemberCounts();
    }

    public static final StoreGuildProfiles getGuildProfiles() {
        return INSTANCE.getGuildProfiles();
    }

    public static final StoreGuildScheduledEvents getGuildScheduledEvents() {
        return INSTANCE.getGuildScheduledEvents();
    }

    public static final StoreGuildSelected getGuildSelected() {
        return INSTANCE.getGuildSelected();
    }

    public static final StoreGuildSubscriptions getGuildSubscriptions() {
        return INSTANCE.getGuildSubscriptions();
    }

    public static final StoreGuildTemplates getGuildTemplates() {
        return INSTANCE.getGuildTemplates();
    }

    public static final StoreGuildVoiceRegions getGuildVoiceRegions() {
        return INSTANCE.getGuildVoiceRegions();
    }

    public static final StoreGuildWelcomeScreens getGuildWelcomeScreens() {
        return INSTANCE.getGuildWelcomeScreens();
    }

    public static final StoreGuilds getGuilds() {
        return INSTANCE.getGuilds();
    }

    public static final StoreGuildsNsfw getGuildsNsfw() {
        return INSTANCE.getGuildsNsfw();
    }

    public static final StoreGuildsSorted getGuildsSorted() {
        return INSTANCE.getGuildsSorted();
    }

    public static final StoreInstantInvites getInstantInvites() {
        return INSTANCE.getInstantInvites();
    }

    public static final StoreApplicationInteractions getInteractions() {
        return INSTANCE.getInteractions();
    }

    public static final StoreInviteSettings getInviteSettings() {
        return INSTANCE.getInviteSettings();
    }

    public static final StoreLibrary getLibrary() {
        return INSTANCE.getLibrary();
    }

    public static final StoreLurking getLurking() {
        return INSTANCE.getLurking();
    }

    public static final StoreMFA getMFA() {
        return INSTANCE.getMFA();
    }

    public static final StoreMediaEngine getMediaEngine() {
        return INSTANCE.getMediaEngine();
    }

    public static final StoreMediaSettings getMediaSettings() {
        return INSTANCE.getMediaSettings();
    }

    public static final StoreGuildMemberVerificationForm getMemberVerificationForms() {
        return INSTANCE.getMemberVerificationForms();
    }

    public static final StoreMentions getMentions() {
        return INSTANCE.getMentions();
    }

    public static final StoreMessageAck getMessageAck() {
        return INSTANCE.getMessageAck();
    }

    public static final StoreMessageReactions getMessageReactions() {
        return INSTANCE.getMessageReactions();
    }

    public static final StoreMessageState getMessageState() {
        return INSTANCE.getMessageState();
    }

    public static final StoreMessageUploads getMessageUploads() {
        return INSTANCE.getMessageUploads();
    }

    public static final StoreMessages getMessages() {
        return INSTANCE.getMessages();
    }

    public static final StoreMessagesLoader getMessagesLoader() {
        return INSTANCE.getMessagesLoader();
    }

    public static final StoreMessagesMostRecent getMessagesMostRecent() {
        return INSTANCE.getMessagesMostRecent();
    }

    public static final StoreNavigation getNavigation() {
        return INSTANCE.getNavigation();
    }

    public static final StoreNotices getNotices() {
        return INSTANCE.getNotices();
    }

    public static final StoreNotifications getNotifications() {
        return INSTANCE.getNotifications();
    }

    public static final StoreNux getNux() {
        return INSTANCE.getNux();
    }

    public static final StorePaymentSources getPaymentSources() {
        return INSTANCE.getPaymentSources();
    }

    public static final StorePermissions getPermissions() {
        return INSTANCE.getPermissions();
    }

    public static final StorePinnedMessages getPinnedMessages() {
        return INSTANCE.getPinnedMessages();
    }

    public static final StoreUserPresence getPresences() {
        return INSTANCE.getPresences();
    }

    public static final StoreReadStates getReadStates() {
        return INSTANCE.getReadStates();
    }

    public static final StoreMessageReplies getRepliedMessages() {
        return INSTANCE.getRepliedMessages();
    }

    public static final StoreReviewRequest getReviewRequest() {
        return INSTANCE.getReviewRequest();
    }

    public static final StoreRtcConnection getRtcConnection() {
        return INSTANCE.getRtcConnection();
    }

    public static final StoreSearch getSearch() {
        return INSTANCE.getSearch();
    }

    public static final StoreSlowMode getSlowMode() {
        return INSTANCE.getSlowMode();
    }

    public static final StoreSpotify getSpotify() {
        return INSTANCE.getSpotify();
    }

    public static final StoreStageChannels getStageChannels() {
        return INSTANCE.getStageChannels();
    }

    public static final StoreCollapsedChannelCategories getStoreChannelCategories() {
        return INSTANCE.getStoreChannelCategories();
    }

    public static final StoreStreamRtcConnection getStreamRtcConnection() {
        return INSTANCE.getStreamRtcConnection();
    }

    public static final StoreSubscriptions getSubscriptions() {
        return INSTANCE.getSubscriptions();
    }

    public static final StoreThreadMembers getThreadMembers() {
        return INSTANCE.getThreadMembers();
    }

    public static final StoreThreadMessages getThreadMessages() {
        return INSTANCE.getThreadMessages();
    }

    public static final StoreThreadsActive getThreadsActive() {
        return INSTANCE.getThreadsActive();
    }

    public static final StoreUserAffinities getUserAffinities() {
        return INSTANCE.getUserAffinities();
    }

    public static final StoreUserConnections getUserConnections() {
        return INSTANCE.getUserConnections();
    }

    public static final StoreUserGuildSettings getUserGuildSettings() {
        return INSTANCE.getUserGuildSettings();
    }

    public static final StoreUserProfile getUserProfile() {
        return INSTANCE.getUserProfile();
    }

    public static final StoreUserRelationships getUserRelationships() {
        return INSTANCE.getUserRelationships();
    }

    public static final StoreUserRequiredActions getUserRequiredActions() {
        return INSTANCE.getUserRequiredActions();
    }

    public static final StoreUserSettings getUserSettings() {
        return INSTANCE.getUserSettings();
    }

    public static final StoreUserSettingsSystem getUserSettingsSystem() {
        return INSTANCE.getUserSettingsSystem();
    }

    public static final StoreUserSurvey getUserSurvey() {
        return INSTANCE.getUserSurvey();
    }

    public static final StoreUser getUsers() {
        return INSTANCE.getUsers();
    }

    public static final StoreUserNotes getUsersNotes() {
        return INSTANCE.getUsersNotes();
    }

    public static final StoreUserTyping getUsersTyping() {
        return INSTANCE.getUsersTyping();
    }

    public static final StoreVoiceChannelSelected getVoiceChannelSelected() {
        return INSTANCE.getVoiceChannelSelected();
    }

    public static final StoreVoiceParticipants getVoiceParticipants() {
        return INSTANCE.getVoiceParticipants();
    }

    public static final StoreVoiceStates getVoiceStates() {
        return INSTANCE.getVoiceStates();
    }

    @Store3
    private final void guildScheduledEventUserAdd(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        this.guildScheduledEvents.handleGuildScheduledEventUserAdd(guildScheduledEventUserUpdate);
    }

    @Store3
    private final void guildScheduledEventUserRemove(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        this.guildScheduledEvents.handleGuildScheduledEventUserRemove(guildScheduledEventUserUpdate);
    }

    @Store3
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

    @Store3
    private final void handleBackgrounded(boolean backgrounded) {
        AppLog.i("[StoreStream] Application backgrounded: " + backgrounded);
        this.connectivity.handleBackgrounded(backgrounded);
        this.messagesLoader.handleBackgrounded(backgrounded);
    }

    @Store3
    private final void handleBanAdd(ModelBan ban) {
        this.bans.handleBanAdd(ban);
    }

    @Store3
    private final void handleBanRemove(ModelBan ban) {
        this.bans.handleBanRemove(ban);
    }

    @Store3
    private final void handleCallCreateOrUpdate(ModelCall call) {
        this.calls.handleCallCreateOrUpdate(call);
        this.callsIncoming.handleCallCreateOrUpdate(call);
        List<VoiceState> voiceStates = call.getVoiceStates();
        if (voiceStates != null) {
            for (VoiceState voiceState : voiceStates) {
                Intrinsics3.checkNotNullExpressionValue(voiceState, "voiceState");
                handleVoiceStateUpdate(voiceState);
            }
        }
    }

    @Store3
    private final void handleCallDelete(ModelCall callDelete) {
        this.callsIncoming.handleCallDelete(callDelete);
        this.calls.handleCallDelete(callDelete);
    }

    @Store3
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

    @Store3
    private final void handleChannelDelete(Channel channel) {
        handleChannelOrThreadDelete(channel);
    }

    @Store3
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

    @Store3
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

    @Store3
    private final void handleChannelUnreadUpdate(ModelChannelUnreadUpdate channelUnreadUpdate) {
        this.messagesMostRecent.handleChannelUnreadUpdate(channelUnreadUpdate);
    }

    @Store3
    private final void handleConnected(boolean connected) {
        this.messages.handleConnected(connected);
        this.messagesLoader.handleConnected(connected);
        this.analytics.handleConnected(connected);
        this.connectivity.handleConnected(connected);
        this.connectionOpen.handleConnected(connected);
        this.channels.handleConnected(connected);
    }

    @Store3
    private final void handleConnectionOpen(ModelPayload payload_) {
        TimeElapsed timeElapsed = new TimeElapsed(this.clock, 0L, 2, null);
        ReadyPayloadUtils.HydrateResult hydrateResultHydrateReadyPayload = ReadyPayloadUtils.INSTANCE.hydrateReadyPayload(payload_, this.guilds, this.channels, this.customEmojis, this.guildStickers);
        if (!(hydrateResultHydrateReadyPayload instanceof ReadyPayloadUtils.HydrateResult.Success)) {
            handleHydrateError();
            return;
        }
        ModelPayload payload = ((ReadyPayloadUtils.HydrateResult.Success) hydrateResultHydrateReadyPayload).getPayload();
        String authToken = payload.getAuthToken();
        if (authToken != null) {
            handleAuthState(AuthState.INSTANCE.from(authToken, Sets5.emptySet()));
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

    @Store3
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

    @Store3
    private final void handleEmbeddedActivityInboundUpdate(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        this.embeddedActivities.handleEmbeddedActivityInboundUpdate(embeddedActivityInboundUpdate);
    }

    @Store3
    private final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        this.customEmojis.handleEmojiUpdate(emojiUpdate);
        this.guildEmojis.handleEmojiUpdate(emojiUpdate);
        this.clientDataState.handleEmojiUpdate(emojiUpdate);
    }

    @Store3
    private final void handleFingerprint(String fingerprint) {
        this.experiments.handleFingerprint(fingerprint);
        this.analytics.handleFingerprint(fingerprint);
    }

    @Store3
    private final void handleForumUnreads(ForumUnreads forumUnreads) {
        this.forumPostReadStates.handleForumUnreads(forumUnreads);
    }

    @Store3
    private final void handleFriendSuggestionsFetchFailure() {
        this.friendSuggestions.handleFriendSuggestionsLoadFailure();
    }

    @Store3
    private final void handleFriendSuggestionsFetched(List<FriendSuggestion> friendSuggestions) {
        handleFriendSuggestionsLoaded(friendSuggestions);
    }

    @Store3
    private final void handleGroupDMRecipientAdd(ChannelRecipient recipient) {
        this.channels.handleGroupDMRecipient(recipient, true);
    }

    @Store3
    private final void handleGroupDMRecipientRemove(ChannelRecipient recipient) {
        this.channels.handleGroupDMRecipient(recipient, false);
    }

    @Store3
    private final void handleGuildApplicationCommands(GuildApplicationCommands commandsGateway) {
        this.applicationCommands.handleApplicationCommandsUpdate(commandsGateway);
    }

    @Store3
    private final void handleGuildCreate(Guild guild) {
        handleGuildCreateOrUpdate(guild);
        this.threadsActive.handleGuildCreate();
        this.threadsJoined.handleGuildCreate(guild);
        this.threadsActiveJoined.handleGuildCreate(guild);
        this.messageAck.handleGuildCreate();
        this.threadMessages.handleGuildCreate(guild);
        this.embeddedActivities.handleGuildCreate(guild);
    }

    @Store3
    private final void handleGuildCreateOrUpdate(Guild guild_) {
        if (guild_ == null) {
            return;
        }
        ReadyPayloadUtils.HydrateGuildResult hydrateGuildResultHydrateGuild$default = ReadyPayloadUtils.hydrateGuild$default(ReadyPayloadUtils.INSTANCE, guild_, null, null, 6, null);
        if (!(hydrateGuildResultHydrateGuild$default instanceof ReadyPayloadUtils.HydrateGuildResult.Success)) {
            handleHydrateError();
            return;
        }
        Guild guild = ((ReadyPayloadUtils.HydrateGuildResult.Success) hydrateGuildResultHydrateGuild$default).getGuild();
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

    @Store3
    private final void handleGuildIntegrationUpdate(ModelGuildIntegration.Update update) {
        this.integrations.handleUpdate(update);
    }

    @Store3
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

    @Store3
    private final void handleGuildMemberListUpdate(ModelGuildMemberListUpdate update) {
        for (ModelGuildMemberListUpdate.Operation operation : update.getOperations()) {
            if (operation.getItem() != null) {
                handleItem(update.getGuildId(), operation.getItem());
            }
            List<ModelGuildMemberListUpdate.Operation.Item> items = operation.getItems();
            if (items != null) {
                Iterator<ModelGuildMemberListUpdate.Operation.Item> it = items.iterator();
                while (it.hasNext()) {
                    handleItem(update.getGuildId(), it.next());
                }
            }
        }
        this.lazyChannelMembersStore.handleGuildMemberListUpdate(update);
    }

    @Store3
    private final void handleGuildMemberRemove(GuildMemberRemove event) {
        this.guilds.handleGuildMemberRemove(event.getGuildId(), event.getUser().getId());
        this.guildMemberCounts.handleGuildMemberRemove(event.getGuildId());
        this.presences.handleGuildMemberRemove(event.getGuildId(), event.getUser().getId());
        this.stageChannels.handleGuildMemberRemove(event.getGuildId(), event.getUser().getId());
    }

    @Store3
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

    @Store3
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

    @Store3
    private final void handleGuildRoleCreate(GuildRoleCreate event) {
        handleGuildRoleCreateOrUpdate(event.getGuildId(), event.getRole(), event.getGuildHashes());
    }

    @Store3
    private final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role, GuildHashes guildHashes) {
        this.guilds.handleGuildRoleCreateOrUpdate(guildId, role);
        this.permissions.handleGuildRolesChanged(guildId);
        this.voiceChannelSelected.handleGuildRoleCreateOrUpdate();
        this.lazyChannelMembersStore.handleGuildRoleCreateOrUpdate(guildId);
        this.clientDataState.handleRoleAddOrRemove(guildId, guildHashes);
        this.stageChannels.handleGuildRoleCreateOrUpdate(guildId);
    }

    @Store3
    private final void handleGuildRoleDelete(GuildRoleDelete event) {
        this.guilds.handleGuildRoleRemove(event.getRoleId(), event.getGuildId());
        this.permissions.handleGuildRolesChanged(event.getGuildId());
        this.voiceChannelSelected.handleGuildRoleRemove();
        this.clientDataState.handleRoleAddOrRemove(event.getGuildId(), event.getGuildHashes());
    }

    @Store3
    private final void handleGuildRoleUpdate(GuildRoleUpdate event) {
        GuildRole guildRoleC = event.getRole();
        if (guildRoleC != null) {
            handleGuildRoleCreateOrUpdate(event.getGuildId(), guildRoleC, event.getGuildHashes());
        }
    }

    @Store3
    private final void handleGuildScheduledEventCreate(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvents.handleGuildScheduledEventCreate(guildScheduledEvent);
    }

    @Store3
    private final void handleGuildScheduledEventDelete(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvents.handleGuildScheduledEventDelete(guildScheduledEvent);
    }

    @Store3
    private final void handleGuildScheduledEventUpdate(GuildScheduledEvent guildScheduledEvent) {
        this.guildScheduledEvents.handleGuildScheduledEventUpdate(guildScheduledEvent);
    }

    @Store3
    private final void handleGuildSettingUpdated(ModelNotificationSettings modelNotificationSettings) {
        this.guildSettings.handleGuildSettingUpdated$app_productionGoogleRelease(CollectionsJVM.listOf(modelNotificationSettings));
        this.clientDataState.handleGuildSettingUpdated(modelNotificationSettings);
    }

    @Store3
    private final void handleGuildUpdate(Guild guild) {
        handleGuildCreateOrUpdate(guild);
    }

    @Store3
    private final void handleHydrateError() {
        this.clientDataState.clear();
        this.gatewaySocket.resetOnError();
    }

    @Store3
    private final void handleInteractionCreate(InteractionStateUpdate interactionStateUpdate) {
        this.applicationInteractions.handleInteractionCreate(interactionStateUpdate);
        this.messages.handleInteractionCreate(interactionStateUpdate);
    }

    @Store3
    private final void handleInteractionSuccess(InteractionStateUpdate interactionStateUpdate) {
        this.applicationInteractions.handleInteractionSuccess(interactionStateUpdate);
    }

    @Store3
    private final void handleItem(long guildId, ModelGuildMemberListUpdate.Operation.Item item) {
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
            GuildMember member = ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember();
            synthesizeGuildMemberAdd(Long.valueOf(guildId), member.getUser(), member);
            Presence presence = member.getPresence();
            if (presence != null) {
                handlePresenceUpdate(guildId, presence);
            }
        }
    }

    @Store3
    private final void handleMessageAck(ModelReadState readState) {
        this.mentions.handleMessageAck(readState);
        this.messageAck.handleMessageAck(readState);
        this.forumPostReadStates.handleMessageAck(readState);
        this.clientDataState.handleMessageAck(readState);
    }

    @Store3
    private final void handleMessageCreate(Message message) {
        processMessageUsers(message);
        this.mentions.handleMessageCreateOrUpdate(message);
        this.users.handleMessageCreateOrUpdate(message);
        this.usersTyping.handleMessageCreate(message);
        this.applicationInteractions.handleMessageCreate(message);
        this.messages.handleMessageCreate(CollectionsJVM.listOf(message));
        this.messagesMostRecent.handleMessageCreate(message);
        this.messageAck.handleMessageCreate(message);
        this.messageReplies.handleMessageCreate(message);
        this.notifications.handleMessageCreate(message);
        this.clientDataState.handleMessageCreate(message);
        this.threadMessages.handleMessageCreate(message);
        this.forumPostMessages.handleMessageCreate(message);
        this.forumPostReadStates.handleMessageCreate(message);
    }

    @Store3
    private final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        this.messages.handleMessageDelete(messageDeleteBulk);
        this.mentions.handleMessageDeleted(messageDeleteBulk);
        StorePinnedMessages storePinnedMessages = this.pinnedMessages;
        long channelId = messageDeleteBulk.getChannelId();
        List<Long> messageIds = messageDeleteBulk.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
        storePinnedMessages.handleMessageDeleteBulk(channelId, messageIds);
        this.messageStates.handleMessageDelete(messageDeleteBulk);
        this.messageReplies.handleMessageDelete(messageDeleteBulk);
        this.pendingReplies.handleMessageDelete(messageDeleteBulk);
        this.threadMessages.handleMessageDelete(messageDeleteBulk);
        this.forumPostMessages.handleMessageDelete(messageDeleteBulk);
    }

    @Store3
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

    @Store3
    private final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        this.users.handleMessagesLoaded(chunk);
        this.applicationInteractions.handleMessagesCreateOrLoad(chunk.getMessages());
        this.messages.handleMessagesLoaded(chunk);
        this.guildMemberRequesterStore.handleLoadMessages(chunk.getChannelId(), chunk.getMessages());
        this.messageReplies.handleLoadMessages(chunk.getMessages());
        this.channels.handleMessagesLoaded(chunk.getMessages());
        this.threadMessages.handleMessagesLoaded(chunk);
        this.permissions.handleMessagesLoaded(chunk.getMessages());
    }

    @Store3
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

    @Store3
    private final void handlePresenceReplace(List<Presence> presencesList) {
        this.presences.handlePresenceReplace(presencesList);
        this.gameParty.handlePresenceReplace(presencesList);
    }

    @Store3
    private final void handlePresenceUpdate(long guildId, Presence presence) {
        this.users.handlePresenceUpdate(presence);
        this.presences.handlePresenceUpdate(guildId, presence);
        this.gameParty.handlePresenceUpdate(presence, guildId);
    }

    @Store3
    private final void handleReactionAdd(MessageReactionUpdate update) {
        this.messages.handleReactionUpdate(CollectionsJVM.listOf(update), true);
        this.messageReactions.handleReactionAdd(update);
        this.forumPostMessages.handleReactionAdd(update);
    }

    @Store3
    private final void handleReactionRemove(MessageReactionUpdate update) {
        this.messages.handleReactionUpdate(CollectionsJVM.listOf(update), false);
        this.messageReactions.handleReactionRemove(update);
        this.forumPostMessages.handleReactionRemove(update);
    }

    @Store3
    private final void handleReactionRemoveAll(MessageReactionUpdate update) {
        this.messages.handleReactionsRemoveAll(update);
        this.messageReactions.handleReactionRemoveAll(update);
        this.forumPostMessages.handleReactionRemoveAll(update);
    }

    @Store3
    private final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        this.messages.handleReactionsRemoveEmoji(update);
        this.messageReactions.handleReactionRemoveEmoji(update);
        this.forumPostMessages.handleReactionRemoveEmoji(update);
    }

    @Store3
    private final void handleRelationshipRemove(ModelUserRelationship relationship) {
        this.userRelationships.handleRelationshipRemove(relationship);
    }

    @Store3
    private final void handleRequiredActionUpdate(UserRequiredActionUpdate requiredActionUpdate) {
        this.userRequiredAction.handleUserRequiredActionUpdate(requiredActionUpdate);
    }

    @Store3
    private final void handleRtcConnectionStateChanged(RtcConnection.StateChange stateChange) {
        this.gatewaySocket.handleRtcConnectionStateChanged(stateChange);
        this.voiceChannelSelected.handleRtcConnectionStateChanged(stateChange.state);
        this.audioManagerV2.handleRtcConnectionState(stateChange.state);
    }

    @Store3
    private final void handleSessionsReplace(List<? extends ModelSession> sessions) {
        this.presences.handleSessionsReplace(sessions);
    }

    @Store3
    private final void handleSpeakingUpdates(List<StoreRtcConnection.SpeakingUserUpdate> speakingUsers) {
        this.voiceSpeaking.handleSpeakingUpdates(speakingUsers);
    }

    @Store3
    private final void handleSpeakingUsers(Set<Long> speakingUsers) {
        this.analytics.handleUserSpeaking(speakingUsers);
    }

    @Store3
    private final void handleStickersUpdate(GuildStickersUpdate stickerUpdate) {
        this.guildStickers.handleStickerUpdate(stickerUpdate);
        this.clientDataState.handleStickersUpdate(stickerUpdate);
    }

    @Store3
    private final void handleStreamCreate(ModelApplicationStream3 streamCreate) {
        this.streamRtcConnection.handleStreamCreate(streamCreate);
        this.applicationStreaming.handleStreamCreate(streamCreate);
    }

    @Store3
    private final void handleStreamServerUpdate(ModelApplicationStream7 streamServerUpdate) {
        this.streamRtcConnection.handleStreamServerUpdate(streamServerUpdate);
    }

    @Store3
    private final void handleStreamUpdate(ModelApplicationStream3 streamUpdate) {
        this.applicationStreaming.handleStreamUpdate(streamUpdate);
    }

    @Store3
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

    @Store3
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

    @Store3
    private final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        this.presences.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.users.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.guilds.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.gameParty.handleThreadMemberListUpdate(threadMemberListUpdate);
        this.lazyThreadMembersStore.handleThreadMemberListUpdate(threadMemberListUpdate);
    }

    @Store3
    private final void handleThreadMemberUpdate(ThreadMemberUpdate threadMemberUpdate) {
        this.threadsJoined.handleThreadMemberUpdate(threadMemberUpdate);
        this.threadsActiveJoined.handleThreadMemberUpdate(threadMemberUpdate);
        this.permissions.handleThreadMemberUpdate(threadMemberUpdate);
    }

    @Store3
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

    @Store3
    private final void handleTypingStart(TypingUser typing) {
        Long lValueOf = Long.valueOf(typing.getGuildId());
        GuildMember guildMemberC = typing.getMember();
        synthesizeGuildMemberAdd(lValueOf, guildMemberC != null ? guildMemberC.getUser() : null, typing.getMember());
        this.usersTyping.handleTypingStart(typing);
    }

    @Store3
    private final void handleUserNoteUpdated(ModelUserNote.Update userNote) {
        this.userNotes.handleNoteUpdate(userNote);
    }

    @Store3
    private final void handleUserPaymentSourcesUpdate() {
        this.paymentSources.handleUserPaymentSourcesUpdate();
    }

    @Store3
    private final void handleUserSettingsUpdate(ModelUserSettings userSettingsUpdate) {
        this.userSettings.handleUserSettingsUpdate(userSettingsUpdate);
        this.userSettingsSystem.handleUserSettingsUpdate(userSettingsUpdate);
        this.presences.handleUserSettingsUpdate(userSettingsUpdate);
    }

    @Store3
    private final void handleUserSubscriptionsUpdate() {
        this.subscriptions.handleUserSubscriptionsUpdate();
    }

    @Store3
    private final void handleUserUpdated(User user) {
        this.users.handleUserUpdated(user);
        this.mfa.handleUserUpdated(user);
    }

    @Store3
    private final void handleVoiceChannelSelected(long voiceChannelId) {
        this.rtcConnection.handleVoiceChannelSelected(Long.valueOf(voiceChannelId));
        this.applicationStreaming.handleVoiceChannelSelected(voiceChannelId);
        this.videoStreams.handleVoiceChannelSelected(voiceChannelId);
        if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.guildSelected.getSelectedGuildId()))) {
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

    @Store3
    private final void handleVoiceServerUpdate(VoiceServer voiceServer) {
        this.rtcConnection.handleVoiceServerUpdate(voiceServer);
    }

    @Store3
    private final void handleVoiceStateUpdate(VoiceState voiceState) {
        Long lValueOf = Long.valueOf(voiceState.getGuildId());
        GuildMember guildMemberD = voiceState.getMember();
        synthesizeGuildMemberAdd(lValueOf, guildMemberD != null ? guildMemberD.getUser() : null, voiceState.getMember());
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
        ChannelSelector.INSTANCE.init(this, this.dispatcher, ObservationDeck4.get());
        new StoreUIEventHandler(context, this.mediaEngine, this.channels, this.voiceChannelSelected, this.stageChannels, this.guildSettings);
    }

    @Store3
    private final void initGatewaySocketListeners() {
        dispatchSubscribe(this.gatewaySocket.getReady(), "streamConnectionOpen", new AnonymousClass1(this));
        dispatchSubscribe(this.gatewaySocket.getConnected(), "streamConnected", new AnonymousClass2(this));
        dispatchSubscribe(this.gatewaySocket.getConnectionReady(), "streamReady", new AnonymousClass3(this));
        dispatchSubscribe(this.gatewaySocket.getGuildApplicationCommands(), "guildApplicationCommands", new AnonymousClass4(this));
        dispatchSubscribe(this.gatewaySocket.getGuildCreate(), "streamGuildCreate", new AnonymousClass5(this));
        dispatchSubscribe(this.gatewaySocket.getGuildUpdate(), "streamGuildUpdate", new AnonymousClass6(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleCreate(), "streamGuildRoleAdd", new AnonymousClass7(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleUpdate(), "streamGuildRoleUpdate", new AnonymousClass8(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleDelete(), "streamGuildRoleRemove", new AnonymousClass9(this));
        dispatchSubscribe(this.gatewaySocket.getGuildDeleted(), "streamGuildRemove", new AnonymousClass10(this));
        dispatchSubscribe(this.gatewaySocket.getGuildBanAdd(), "streamBanAdd", new AnonymousClass11(this));
        dispatchSubscribe(this.gatewaySocket.getGuildBanRemove(), "streamBanRemove", new AnonymousClass12(this));
        dispatchSubscribe(this.gatewaySocket.getGuildIntegrationsUpdate(), "streamGuildIntegrationUpdate", new AnonymousClass13(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMembersAdd(), "streamGuildMemberAdd", new AnonymousClass14(this));
        dispatchSubscribe(this.gatewaySocket.getGuildJoinRequestCreateOrUpdate(), "streamGuildJoinRequestCreateOrUpdate", new AnonymousClass15(this));
        dispatchSubscribe(this.gatewaySocket.getGuildJoinRequestDelete(), "streamGuildJoinRequestDelete", new AnonymousClass16(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMembersChunk(), "streamGuildMemberChunk", new AnonymousClass17(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMemberRemove(), "streamGuildMemberRemove", new AnonymousClass18(this));
        dispatchSubscribe(this.gatewaySocket.getChannelCreateOrUpdate(), "streamChannelCreateOrUpdate", new AnonymousClass19(this));
        dispatchSubscribe(this.gatewaySocket.getChannelDeleted(), "streamChannelDelete", new AnonymousClass20(this));
        dispatchSubscribe(this.gatewaySocket.getChannelUnreadUpdate(), "streamChannelUnreadUpdate", new AnonymousClass21(this));
        dispatchSubscribe(this.gatewaySocket.getThreadCreateOrUpdate(), "streamThreadCreateOrUpdate", new AnonymousClass22(this));
        dispatchSubscribe(this.gatewaySocket.getThreadDelete(), "streamThreadDelete", new AnonymousClass23(this));
        dispatchSubscribe(this.gatewaySocket.getThreadListSync(), "streamThreadListSync", new AnonymousClass24(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMemberUpdate(), "streamThreadMemberUpdate", new AnonymousClass25(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMembersUpdate(), "streamThreadMembersUpdate", new AnonymousClass26(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMemberListUpdate(), "threadMemberListUpdate", new AnonymousClass27(this));
        dispatchSubscribe(this.gatewaySocket.getUserUpdate(), "streamUserUpdated", new AnonymousClass28(this));
        dispatchSubscribe(this.gatewaySocket.getUserNoteUpdate(), "handleUserNoteUpdated", new AnonymousClass29(this));
        dispatchSubscribe(this.gatewaySocket.getRelationshipAdd(), "streamRelationshipAdd", new AnonymousClass30(this));
        dispatchSubscribe(this.gatewaySocket.getRelationshipRemove(), "streamRelationshipRemove", new AnonymousClass31(this));
        dispatchSubscribe(this.gatewaySocket.getMessageUpdate(), "streamMessageUpdate", new AnonymousClass32(this));
        dispatchSubscribe(this.gatewaySocket.getMessageCreate(), "streamMessageCreate", new AnonymousClass33(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionAdd(), "streamReactionAdd", new AnonymousClass34(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemove(), "streamReactionRemove", new AnonymousClass35(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemoveEmoji(), "streamMessageRemoveEmoji", new AnonymousClass36(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemoveAll(), "streamMessageRemoveAll", new AnonymousClass37(this));
        dispatchSubscribe(this.gatewaySocket.getMessageDelete(), "streamMessageDelete", new AnonymousClass38(this));
        dispatchSubscribe(this.gatewaySocket.getMessageAck(), "streamMessageAck", new AnonymousClass39(this));
        dispatchSubscribe(this.gatewaySocket.getVoiceStateUpdate(), "streamVoiceStateUpdate", new AnonymousClass40(this));
        dispatchSubscribe(this.gatewaySocket.getVoiceServerUpdate(), "streamVoiceServerUpdate", new AnonymousClass41(this));
        dispatchSubscribe(this.gatewaySocket.getUserGuildSettingsUpdate(), "streamGuildSettingUpdated", new AnonymousClass42(this));
        dispatchSubscribe(this.gatewaySocket.getUserSettingsUpdate(), "streamUserSettingsUpdate", new AnonymousClass43(this));
        dispatchSubscribe(this.gatewaySocket.getTypingStart(), "streamTypingStart", new AnonymousClass44(this));
        dispatchSubscribe(this.gatewaySocket.getPresenceUpdate(), "streamPresenceUpdate", new AnonymousClass45());
        dispatchSubscribe(this.gatewaySocket.getPresenceReplace(), "streamPresenceReplace", new AnonymousClass46(this));
        dispatchSubscribe(this.gatewaySocket.getChannelRecipientAdd(), "streamGroupDMRecipientAdd", new AnonymousClass47(this));
        dispatchSubscribe(this.gatewaySocket.getChannelRecipientRemove(), "streamGroupDMRecipientRemove", new AnonymousClass48(this));
        dispatchSubscribe(this.gatewaySocket.getCallDelete(), "streamCallDelete", new AnonymousClass49(this));
        dispatchSubscribe(this.gatewaySocket.getCallCreateOrUpdate(), "streamCallCreateOrUpdate", new AnonymousClass50(this));
        dispatchSubscribe(this.gatewaySocket.getGuildEmojisUpdate(), "streamEmojisUpdate", new AnonymousClass51(this));
        dispatchSubscribe(this.gatewaySocket.getGuildStickersUpdate(), "streamStickersUpdate", new AnonymousClass52(this));
        dispatchSubscribe(this.gatewaySocket.getUserRequiredActionUpdate(), "streamUserRequiredActionUpdate", new AnonymousClass53(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMemberListUpdate(), "guildMemberListUpdate", new AnonymousClass54(this));
        dispatchSubscribe(this.gatewaySocket.getSessionsReplace(), "streamSessionsReplace", new AnonymousClass55(this));
        dispatchSubscribe(this.gatewaySocket.getUserPaymentSourcesUpdate(), "streamUserPaymentSourcesUpdate", new AnonymousClass56());
        dispatchSubscribe(this.gatewaySocket.getUserSubscriptionsUpdate(), "streamUserSubscriptionsUpdate", new AnonymousClass57());
        dispatchSubscribe(this.gatewaySocket.getStreamCreate(), "streamStreamCreate", new AnonymousClass58(this));
        dispatchSubscribe(this.gatewaySocket.getStreamUpdate(), "streamStreamUpdate", new AnonymousClass59(this));
        dispatchSubscribe(this.gatewaySocket.getStreamDelete(), "streamStreamDelete", new AnonymousClass60());
        dispatchSubscribe(this.gatewaySocket.getStreamServerUpdate(), "streamStreamServerUpdate", new AnonymousClass61(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionCreate(), "interactionCreate", new AnonymousClass62(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionSuccess(), "interactionSuccess", new AnonymousClass63(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionFailure(), "interactionFailure", new AnonymousClass64(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionModalCreate(), "interactionModalCreate", new AnonymousClass65(this));
        dispatchSubscribe(this.gatewaySocket.getApplicationCommandAutocompleteResult(), "applicationCommandAutocompleteResult", new AnonymousClass66(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceCreate(), "stageInstanceCreate", new AnonymousClass67(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceUpdate(), "stageInstanceUpdate", new AnonymousClass68(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceDelete(), "stageInstanceDelete", new AnonymousClass69(this));
        dispatchSubscribe(this.gatewaySocket.getFriendSuggestionCreate(), "friendSuggestionCreate", new AnonymousClass70(this));
        dispatchSubscribe(this.gatewaySocket.getFriendSuggestionDelete(), "friendSuggestionDelete", new AnonymousClass71(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventCreate(), "guildScheduledEventCreate", new AnonymousClass72(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUpdate(), "guildScheduledEventUpdate", new AnonymousClass73(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventDelete(), "guildScheduledEventDelete", new AnonymousClass74(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUserAdd(), "guildScheduledEventUserAdd", new AnonymousClass75(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUserRemove(), "guildScheduledEventUserRemove", new AnonymousClass76(this));
        dispatchSubscribe(this.gatewaySocket.getEmbeddedActivityInboundUpdate(), "embeddedActivityInboundUpdate", new AnonymousClass77(this));
        dispatchSubscribe(this.gatewaySocket.getForumUnreads(), "forumUnreads", new AnonymousClass78(this));
    }

    private final void maybeLogNotificationPermissionStatus(Application context, Clock clock) {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        long jCurrentTimeMillis = clock.currentTimeMillis();
        if (jCurrentTimeMillis - sharedPreferences.getLong(LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY, 0L) > DAY_IN_MILLS) {
            Observable<NotificationClient.SettingsV2> observableZ = this.notifications.getSettings().Z(1);
            Intrinsics3.checkNotNullExpressionValue(observableZ, "notifications.getSettings().take(1)");
            ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) StoreStream.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(sharedPreferences, jCurrentTimeMillis, context));
        }
    }

    @Store3
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
        Observable observableZ = Observable.I(networkMonitor.observeIsConnected().y(new Func1<Boolean, Boolean>() { // from class: com.discord.stores.StoreStream$startStoreInitializationTimer$isOfflineObservable$1
            @Override // j0.k.Func1
            public final Boolean call(Boolean bool) {
                return Boolean.valueOf(!bool.booleanValue());
            }
        }), Observable.d0(6000L, TimeUnit.MILLISECONDS)).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable.merge(\n      …le\n    )\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) StoreStream.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public static /* synthetic */ void streamCreate$default(StoreStream storeStream, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        storeStream.streamCreate(str, str2);
    }

    @Store3
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

    @Store3
    public final void handleApplicationCommandAutocompleteResult(ApplicationCommandAutocompleteResult interactionStateUpdate) {
        Intrinsics3.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        this.applicationCommands.handleApplicationCommandAutocompleteResult(interactionStateUpdate);
    }

    @Store3
    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.videoStreams.handleApplicationStreamUpdate(userId, streamId);
        this.connectionTimeStats.handleApplicationStreamUpdate(userId, streamId);
    }

    @Store3
    public final void handleApplicationStreamVideoMetadataUpdate(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        this.videoStreams.handleApplicationStreamVideoMetadataUpdate(metadata);
    }

    @Store3
    public final void handleFriendSuggestionCreate(FriendSuggestion friendSuggestionCreate) {
        Intrinsics3.checkNotNullParameter(friendSuggestionCreate, "friendSuggestionCreate");
        this.friendSuggestions.handleFriendSuggestionCreate(friendSuggestionCreate);
        this.users.handleFriendSuggestionCreate(friendSuggestionCreate);
    }

    @Store3
    public final void handleFriendSuggestionDelete(FriendSuggestionDelete friendSuggestionDelete) {
        Intrinsics3.checkNotNullParameter(friendSuggestionDelete, "friendSuggestionDelete");
        this.friendSuggestions.handleFriendSuggestionDelete(friendSuggestionDelete);
    }

    @Store3
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> friendSuggestions) {
        Intrinsics3.checkNotNullParameter(friendSuggestions, "friendSuggestions");
        this.friendSuggestions.handleFriendSuggestionsLoaded(friendSuggestions);
        this.users.handleFriendSuggestionsLoaded(friendSuggestions);
    }

    @Store3
    public final void handleGuildJoinRequestCreateOrUpdate(GuildJoinRequest2 update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.guildJoinRequests.handleGuildJoinRequestCreateOrUpdate(update.getGuildId(), update.getRequest());
    }

    @Store3
    public final void handleGuildJoinRequestDelete(GuildJoinRequest3 update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.guildJoinRequests.handleGuildJoinRequestDelete(update.getUserId(), update.getGuildId());
    }

    @Store3
    public final void handleGuildJoined(long guildId, GuildWelcomeScreen welcomeScreen) {
        this.guildWelcomeScreens.handleGuildJoined(guildId, welcomeScreen);
    }

    @Store3
    public final void handleGuildSelected(long guildId) {
        this.guildSelected.handleGuildSelected(guildId);
        this.channelsSelected.handleGuildSelected();
        this.calls.handleGuildSelect(guildId);
        this.guildSubscriptions.handleGuildSelect(guildId);
        this.lurking.handleGuildSelected$app_productionGoogleRelease(guildId);
        this.nux.handleGuildSelected(guildId);
        this.guildInvite.handleGuildSelected(guildId);
    }

    @Store3
    public final void handleHomeTabSelected(StoreNavigation.PanelAction panelAction) {
        Intrinsics3.checkNotNullParameter(panelAction, "panelAction");
        this.navigation.handleHomeTabSelected(panelAction);
    }

    @Store3
    public final void handleInteractionFailure(InteractionStateUpdate interactionStateUpdate) {
        Intrinsics3.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        this.applicationInteractions.handleInteractionFailure(interactionStateUpdate);
        this.messages.handleInteractionFailure(interactionStateUpdate);
    }

    @Store3
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        Intrinsics3.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        this.applicationInteractions.handleInteractionModalCreate(interactionModalCreate);
        this.messages.handleInteractionModalCreate(interactionModalCreate);
    }

    @Store3
    public final void handleIsScreenSharingChanged(boolean isScreenSharing) {
        this.analytics.handleIsScreenSharingChanged(isScreenSharing);
    }

    @Store3
    public final void handleLocalMessageDelete(com.discord.models.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.applicationInteractions.handleLocalMessageDelete(message);
    }

    @Store3
    public final void handleLoginResult(ModelLoginResult loginResult) {
        Intrinsics3.checkNotNullParameter(loginResult, "loginResult");
        this.authentication.handleLoginResult(loginResult);
        this.userSettingsSystem.handleLoginResult(loginResult);
    }

    @Store3
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        this.users.handleUserRelationshipAdd(relationship);
        this.userRelationships.handleRelationshipAdd(relationship);
    }

    @Store3
    public final void handleSamplePremiumGuildSelected(long guildId) {
        this.guildSelected.handleGuildSelected(guildId);
        this.channelsSelected.handleGuildSelected();
        this.nux.handleSamplePremiumGuildSelected(guildId);
    }

    @Store3
    public final void handleSearchFinish(SearchState searchState) {
        Intrinsics3.checkNotNullParameter(searchState, "searchState");
        this.channels.handleSearchFinish(searchState);
        this.permissions.handleSearchFinish(searchState);
        this.threadsJoined.handleSearchFinish(searchState);
    }

    @Store3
    public final void handleStageInstanceCreate(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceCreate(stageInstance);
        this.stageSelfPresence.handleStageInstanceCreate();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @Store3
    public final void handleStageInstanceDelete(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceDelete(stageInstance);
        this.stageSelfPresence.handleStageInstanceDelete();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @Store3
    public final void handleStageInstanceUpdate(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceUpdate(stageInstance);
        this.stageSelfPresence.handleStageInstanceUpdate();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @Store3
    public final void handleStoreInitializationTimeout() {
        this.channels.handleStoreInitTimeout();
        this.channelsSelected.handleStoreInitTimeout();
    }

    @Store3
    public final void handleStreamDelete(ModelApplicationStream5 streamDelete, boolean isLocal) {
        Intrinsics3.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamRtcConnection.handleStreamDelete();
        this.applicationStreaming.handleStreamDelete(streamDelete);
        if (isLocal) {
            this.gatewaySocket.streamDelete(streamDelete.getStreamKey());
        }
    }

    @Store3
    public final void handleStreamRtcConnectionStateChange(RtcConnection.StateChange stateChange) {
        Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
        this.gatewaySocket.handleRtcConnectionStateChanged(stateChange);
        this.streamRtcConnection.handleStreamRtcConnectionStateChange(stateChange.state);
    }

    @Store3
    public final void handleStreamTargeted(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.applicationStreaming.handleStreamTargeted(streamKey);
        this.voiceChannelSelected.handleStreamTargeted(streamKey);
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
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

    @Store3
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        Intrinsics3.checkNotNullParameter(accounts, "accounts");
        this.userConnections.handleUserConnections(accounts);
        this.spotify.handleUserConnections(accounts);
    }

    @Store3
    public final void handleUserProfile(UserProfile userProfileInstance, Long guildId) {
        GuildMember guildMemberC;
        Intrinsics3.checkNotNullParameter(userProfileInstance, "userProfileInstance");
        this.userProfile.handleUserProfile(userProfileInstance);
        if (guildId == null || (guildMemberC = userProfileInstance.getGuildMember()) == null) {
            return;
        }
        this.guilds.handleGuildMember(GuildMember.a(guildMemberC, guildId.longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), guildId.longValue(), true);
    }

    @Store3
    public final void handleVideoInputDeviceSelected(DeviceDescription4 selectedVideoInputDevice) {
        this.analytics.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    @Store3
    public final void handleVideoMetadataUpdate(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        this.videoStreams.handleVideoMetadataUpdate(metadata);
    }

    @Store3
    public final void handleVideoStreamUpdate(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        this.videoStreams.handleVideoStreamUpdate(userId, streamId);
        this.connectionTimeStats.handleVideoStreamUpdate(userId, streamId, audioSsrc, videoSsrc, rtxSsrc);
    }

    @Store3
    public final void handleVoiceStatesUpdated(long guildId, long oldChannelId, long userId) {
        this.audioManagerV2.handleVoiceStatesUpdated();
        this.stageChannels.handleVoiceStatesUpdated(guildId, oldChannelId, userId);
    }

    @Store3
    public final void streamCreate(String streamKey, String preferredRegion) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.gatewaySocket.streamCreate(streamKey, preferredRegion);
        this.applicationStreaming.handleStreamCreateRequest(streamKey);
    }

    @Store3
    public final void streamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.gatewaySocket.streamWatch(streamKey);
        this.applicationStreaming.handleStreamWatch(streamKey);
        this.connectionTimeStats.handleStreamWatch(streamKey);
    }

    private final <T> void dispatchSubscribe(Batched<T> batched, String str, Function1<? super T, Unit> function1) {
        dispatchSubscribe(batched.observe(), str, new AnonymousClass2(function1));
    }

    @Store3
    private final void synthesizeGuildMemberAdd(Long guildId, User user, GuildMember member) {
        synthesizeGuildMemberAdd(guildId, user, member != null ? member.l() : null, member != null ? member.getNick() : null, member != null ? member.getPremiumSince() : null, member != null ? Boolean.valueOf(member.getPending()) : null, member != null ? member.getAvatar() : null, member != null ? member.getJoinedAt() : null, member != null ? member.getCommunicationDisabledUntil() : null);
    }
}
