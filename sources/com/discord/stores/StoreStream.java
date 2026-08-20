package com.discord.stores;

import android.app.Application;
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
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
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
import p007b.p008a.p020e.C0894d;
import p507d0.C12083g;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p645c.C12698c;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Func4;
import p658rx.subjects.BehaviorSubject;

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
    private final BehaviorSubject<Boolean> initialized = BehaviorSubject.m11130l0(Boolean.FALSE);
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
    private static final Lazy collector$delegate = C12083g.lazy(StoreStream$Companion$collector$2.INSTANCE);

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
            C12238m.checkNotNullParameter(application, "application");
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
            C12238m.checkNotNullExpressionValue(behaviorSubject, "collector.initialized");
            return behaviorSubject;
        }

        public final void setSTORE_THREAD_ID(long j) {
            StoreStream.STORE_THREAD_ID = j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C64321 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Application $context;

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Boolean, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f27425a;
            }

            public final void invoke(boolean z2) {
                StoreStream.this.handlePreLogout();
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$10, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass10 extends C12236k implements Function1<Boolean, Unit> {
            public AnonymousClass10(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleBackgrounded", "handleBackgrounded(Z)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f27425a;
            }

            public final void invoke(boolean z2) {
                ((StoreStream) this.receiver).handleBackgrounded(z2);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$12, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass12 extends C12236k implements Function1<Boolean, Unit> {
            public AnonymousClass12(BehaviorSubject behaviorSubject) {
                super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                ((BehaviorSubject) this.receiver).onNext(bool);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass2 extends C12236k implements Function1<AuthState, Unit> {
            public AnonymousClass2(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleAuthState", "handleAuthState(Lcom/discord/models/authentication/AuthState;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthState authState) {
                invoke2(authState);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AuthState authState) {
                ((StoreStream) this.receiver).handleAuthState(authState);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass3 extends C12236k implements Function1<String, Unit> {
            public AnonymousClass3(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleFingerprint", "handleFingerprint(Ljava/lang/String;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ((StoreStream) this.receiver).handleFingerprint(str);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass4 extends C12236k implements Function1<StoreMessagesLoader.ChannelChunk, Unit> {
            public AnonymousClass4(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleMessagesLoaded", "handleMessagesLoaded(Lcom/discord/stores/StoreMessagesLoader$ChannelChunk;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreMessagesLoader.ChannelChunk channelChunk) {
                invoke2(channelChunk);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreMessagesLoader.ChannelChunk channelChunk) {
                C12238m.checkNotNullParameter(channelChunk, "p1");
                ((StoreStream) this.receiver).handleMessagesLoaded(channelChunk);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass5 extends C12236k implements Function1<Long, Unit> {
            public AnonymousClass5(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleChannelSelected", "handleChannelSelected(J)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.f27425a;
            }

            public final void invoke(long j) {
                ((StoreStream) this.receiver).handleChannelSelected(j);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass6 extends C12236k implements Function1<Long, Unit> {
            public AnonymousClass6(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleVoiceChannelSelected", "handleVoiceChannelSelected(J)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.f27425a;
            }

            public final void invoke(long j) {
                ((StoreStream) this.receiver).handleVoiceChannelSelected(j);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass7 extends C12236k implements Function1<Set<? extends Long>, Unit> {
            public AnonymousClass7(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleSpeakingUsers", "handleSpeakingUsers(Ljava/util/Set;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
                invoke2((Set<Long>) set);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<Long> set) {
                C12238m.checkNotNullParameter(set, "p1");
                ((StoreStream) this.receiver).handleSpeakingUsers(set);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass8 extends C12236k implements Function1<RtcConnection.StateChange, Unit> {
            public AnonymousClass8(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleRtcConnectionStateChanged", "handleRtcConnectionStateChanged(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RtcConnection.StateChange stateChange) {
                invoke2(stateChange);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RtcConnection.StateChange stateChange) {
                C12238m.checkNotNullParameter(stateChange, "p1");
                ((StoreStream) this.receiver).handleRtcConnectionStateChanged(stateChange);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$deferredInit$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final /* synthetic */ class AnonymousClass9 extends C12236k implements Function1<List<? extends StoreRtcConnection.SpeakingUserUpdate>, Unit> {
            public AnonymousClass9(StoreStream storeStream) {
                super(1, storeStream, StoreStream.class, "handleSpeakingUpdates", "handleSpeakingUpdates(Ljava/util/List;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StoreRtcConnection.SpeakingUserUpdate> list) {
                invoke2((List<StoreRtcConnection.SpeakingUserUpdate>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StoreRtcConnection.SpeakingUserUpdate> list) {
                C12238m.checkNotNullParameter(list, "p1");
                ((StoreStream) this.receiver).handleSpeakingUpdates(list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64321(Application application) {
            super(0);
            this.$context = application;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TimeElapsed timeElapsed = new TimeElapsed(StoreStream.this.clock, 0L, 2, null);
            NetworkMonitor networkMonitor = new NetworkMonitor(this.$context, AppLog.f14950g);
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
            storeStream.dispatchSubscribe(storeStream.getAuthentication().getPreLogoutSignal$app_productionGoogleRelease(), "streamPreLogout", new AnonymousClass1());
            StoreStream storeStream2 = StoreStream.this;
            storeStream2.dispatchSubscribe(storeStream2.getAuthentication().m11385getAuthState$app_productionGoogleRelease(), "streamAuthState", new AnonymousClass2(StoreStream.this));
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
            StoreStream.this.dispatchSubscribe(C0894d.f600d.m185a(), "streamBackgrounded", new AnonymousClass10(StoreStream.this));
            StoreStream storeStream10 = StoreStream.this;
            Observable observableM11073h = Observable.m11073h(storeStream10.getExperiments().isInitialized().m11112r(), StoreStream.this.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), StoreStream.this.getChannelsSelected().observeInitializedForAuthedUser(), Persister.INSTANCE.isPreloaded(), new Func4<Boolean, Boolean, Boolean, Boolean, Boolean>() { // from class: com.discord.stores.StoreStream.deferredInit.1.11
                /* JADX WARN: Code duplicated, block: B:11:0x0029  */
                @Override // p658rx.functions.Func4
                public final Boolean call(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
                    boolean z2;
                    C12238m.checkNotNullExpressionValue(bool, "experimentsInitialized");
                    if (bool.booleanValue()) {
                        C12238m.checkNotNullExpressionValue(bool4, "cachesInitialized");
                        if (bool4.booleanValue()) {
                            if (bool2.booleanValue()) {
                                C12238m.checkNotNullExpressionValue(bool3, "channelsSelectedInitialized");
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
            C12238m.checkNotNullExpressionValue(observableM11073h, "Observable\n        .comb…tedInitialized)\n        }");
            storeStream10.dispatchSubscribe(observableM11073h, "streamInit", new AnonymousClass12(StoreStream.this.initialized));
            AppLog.m8358i("[StoreStream] Application stores initialized in: " + timeElapsed.getSeconds() + " seconds.");
            VoiceEngineServiceController.INSTANCE.getINSTANCE().init(this.$context);
            StoreStream storeStream11 = StoreStream.this;
            storeStream11.maybeLogNotificationPermissionStatus(this.$context, storeStream11.clock);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.StoreStream$dispatchSubscribe$1 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C64331<T> extends AbstractC12240o implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$dispatchSubscribe$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Object $emission;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Object obj) {
                super(0);
                this.$emission = obj;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C64331.this.$onNext.invoke(this.$emission);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64331(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            StoreStream.this.dispatcher.schedule(new AnonymousClass1(t));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.StoreStream$dispatchSubscribe$2 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C64342<T> extends AbstractC12240o implements Function1<List<? extends T>, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64342(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((List) obj);
            return Unit.f27425a;
        }

        public final void invoke(List<? extends T> list) {
            C12238m.checkNotNullParameter(list, "batch");
            Iterator<? extends T> it = list.iterator();
            while (it.hasNext()) {
                this.$onNext.invoke(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$1 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C64351 extends C12236k implements Function1<ModelPayload, Unit> {
        public C64351(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleConnectionOpen", "handleConnectionOpen(Lcom/discord/models/domain/ModelPayload;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelPayload modelPayload) {
            invoke2(modelPayload);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelPayload modelPayload) {
            C12238m.checkNotNullParameter(modelPayload, "p1");
            ((StoreStream) this.receiver).handleConnectionOpen(modelPayload);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$10 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C643610 extends C12236k implements Function1<Guild, Unit> {
        public C643610(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRemove", "handleGuildRemove(Lcom/discord/api/guild/Guild;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            ((StoreStream) this.receiver).handleGuildRemove(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$11 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C643711 extends C12236k implements Function1<ModelBan, Unit> {
        public C643711(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleBanAdd", "handleBanAdd(Lcom/discord/models/domain/ModelBan;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
            invoke2(modelBan);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelBan modelBan) {
            C12238m.checkNotNullParameter(modelBan, "p1");
            ((StoreStream) this.receiver).handleBanAdd(modelBan);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$12 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C643812 extends C12236k implements Function1<ModelBan, Unit> {
        public C643812(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleBanRemove", "handleBanRemove(Lcom/discord/models/domain/ModelBan;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
            invoke2(modelBan);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelBan modelBan) {
            C12238m.checkNotNullParameter(modelBan, "p1");
            ((StoreStream) this.receiver).handleBanRemove(modelBan);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$13 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C643913 extends C12236k implements Function1<ModelGuildIntegration.Update, Unit> {
        public C643913(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildIntegrationUpdate", "handleGuildIntegrationUpdate(Lcom/discord/models/domain/ModelGuildIntegration$Update;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildIntegration.Update update) {
            invoke2(update);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildIntegration.Update update) {
            C12238m.checkNotNullParameter(update, "p1");
            ((StoreStream) this.receiver).handleGuildIntegrationUpdate(update);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$14 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644014 extends C12236k implements Function1<GuildMember, Unit> {
        public C644014(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMemberAdd", "handleGuildMemberAdd(Lcom/discord/api/guildmember/GuildMember;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember) {
            invoke2(guildMember);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMember guildMember) {
            C12238m.checkNotNullParameter(guildMember, "p1");
            ((StoreStream) this.receiver).handleGuildMemberAdd(guildMember);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$15 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644115 extends C12236k implements Function1<GuildJoinRequestCreateOrUpdate, Unit> {
        public C644115(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildJoinRequestCreateOrUpdate", "handleGuildJoinRequestCreateOrUpdate(Lcom/discord/api/guildjoinrequest/GuildJoinRequestCreateOrUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildJoinRequestCreateOrUpdate guildJoinRequestCreateOrUpdate) {
            invoke2(guildJoinRequestCreateOrUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildJoinRequestCreateOrUpdate guildJoinRequestCreateOrUpdate) {
            C12238m.checkNotNullParameter(guildJoinRequestCreateOrUpdate, "p1");
            ((StoreStream) this.receiver).handleGuildJoinRequestCreateOrUpdate(guildJoinRequestCreateOrUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$16 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644216 extends C12236k implements Function1<GuildJoinRequestDelete, Unit> {
        public C644216(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildJoinRequestDelete", "handleGuildJoinRequestDelete(Lcom/discord/api/guildjoinrequest/GuildJoinRequestDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildJoinRequestDelete guildJoinRequestDelete) {
            invoke2(guildJoinRequestDelete);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildJoinRequestDelete guildJoinRequestDelete) {
            C12238m.checkNotNullParameter(guildJoinRequestDelete, "p1");
            ((StoreStream) this.receiver).handleGuildJoinRequestDelete(guildJoinRequestDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$17 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644317 extends C12236k implements Function1<GuildMembersChunk, Unit> {
        public C644317(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMembersChunk", "handleGuildMembersChunk(Lcom/discord/api/guildmember/GuildMembersChunk;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildMembersChunk guildMembersChunk) {
            invoke2(guildMembersChunk);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMembersChunk guildMembersChunk) {
            C12238m.checkNotNullParameter(guildMembersChunk, "p1");
            ((StoreStream) this.receiver).handleGuildMembersChunk(guildMembersChunk);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$18 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644418 extends C12236k implements Function1<GuildMemberRemove, Unit> {
        public C644418(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMemberRemove", "handleGuildMemberRemove(Lcom/discord/api/guildmember/GuildMemberRemove;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildMemberRemove guildMemberRemove) {
            invoke2(guildMemberRemove);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMemberRemove guildMemberRemove) {
            C12238m.checkNotNullParameter(guildMemberRemove, "p1");
            ((StoreStream) this.receiver).handleGuildMemberRemove(guildMemberRemove);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$19 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644519 extends C12236k implements Function1<Channel, Unit> {
        public C644519(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleChannelCreateOrUpdate", "handleChannelCreateOrUpdate(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleChannelCreateOrUpdate(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$2 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C64462 extends C12236k implements Function1<Boolean, Unit> {
        public C64462(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleConnected", "handleConnected(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((StoreStream) this.receiver).handleConnected(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$20 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644720 extends C12236k implements Function1<Channel, Unit> {
        public C644720(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleChannelDelete", "handleChannelDelete(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleChannelDelete(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$21 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644821 extends C12236k implements Function1<ModelChannelUnreadUpdate, Unit> {
        public C644821(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleChannelUnreadUpdate", "handleChannelUnreadUpdate(Lcom/discord/models/domain/ModelChannelUnreadUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
            invoke2(modelChannelUnreadUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
            C12238m.checkNotNullParameter(modelChannelUnreadUpdate, "p1");
            ((StoreStream) this.receiver).handleChannelUnreadUpdate(modelChannelUnreadUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$22 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C644922 extends C12236k implements Function1<Channel, Unit> {
        public C644922(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadCreateOrUpdate", "handleThreadCreateOrUpdate(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleThreadCreateOrUpdate(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$23 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645023 extends C12236k implements Function1<Channel, Unit> {
        public C645023(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadDelete", "handleThreadDelete(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "p1");
            ((StoreStream) this.receiver).handleThreadDelete(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$24 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645124 extends C12236k implements Function1<ModelThreadListSync, Unit> {
        public C645124(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadListSync", "handleThreadListSync(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelThreadListSync modelThreadListSync) {
            invoke2(modelThreadListSync);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelThreadListSync modelThreadListSync) {
            C12238m.checkNotNullParameter(modelThreadListSync, "p1");
            ((StoreStream) this.receiver).handleThreadListSync(modelThreadListSync);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$25 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645225 extends C12236k implements Function1<ThreadMemberUpdate, Unit> {
        public C645225(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadMemberUpdate", "handleThreadMemberUpdate(Lcom/discord/api/thread/ThreadMemberUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMemberUpdate threadMemberUpdate) {
            invoke2(threadMemberUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMemberUpdate threadMemberUpdate) {
            C12238m.checkNotNullParameter(threadMemberUpdate, "p1");
            ((StoreStream) this.receiver).handleThreadMemberUpdate(threadMemberUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$26 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645326 extends C12236k implements Function1<ThreadMembersUpdate, Unit> {
        public C645326(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadMembersUpdate", "handleThreadMembersUpdate(Lcom/discord/api/thread/ThreadMembersUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMembersUpdate threadMembersUpdate) {
            invoke2(threadMembersUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMembersUpdate threadMembersUpdate) {
            C12238m.checkNotNullParameter(threadMembersUpdate, "p1");
            ((StoreStream) this.receiver).handleThreadMembersUpdate(threadMembersUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$27 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645427 extends C12236k implements Function1<ThreadMemberListUpdate, Unit> {
        public C645427(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleThreadMemberListUpdate", "handleThreadMemberListUpdate(Lcom/discord/api/thread/ThreadMemberListUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ThreadMemberListUpdate threadMemberListUpdate) {
            invoke2(threadMemberListUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ThreadMemberListUpdate threadMemberListUpdate) {
            C12238m.checkNotNullParameter(threadMemberListUpdate, "p1");
            ((StoreStream) this.receiver).handleThreadMemberListUpdate(threadMemberListUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$28 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645528 extends C12236k implements Function1<User, Unit> {
        public C645528(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleUserUpdated", "handleUserUpdated(Lcom/discord/api/user/User;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            C12238m.checkNotNullParameter(user, "p1");
            ((StoreStream) this.receiver).handleUserUpdated(user);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$29 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645629 extends C12236k implements Function1<ModelUserNote.Update, Unit> {
        public C645629(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleUserNoteUpdated", "handleUserNoteUpdated(Lcom/discord/models/domain/ModelUserNote$Update;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote.Update update) {
            invoke2(update);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserNote.Update update) {
            C12238m.checkNotNullParameter(update, "p1");
            ((StoreStream) this.receiver).handleUserNoteUpdated(update);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$3 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C64573 extends C12236k implements Function1<Boolean, Unit> {
        public C64573(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleConnectionReady", "handleConnectionReady(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((StoreStream) this.receiver).handleConnectionReady(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$30 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645830 extends C12236k implements Function1<ModelUserRelationship, Unit> {
        public C645830(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleRelationshipAdd", "handleRelationshipAdd(Lcom/discord/models/domain/ModelUserRelationship;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserRelationship modelUserRelationship) {
            invoke2(modelUserRelationship);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserRelationship modelUserRelationship) {
            C12238m.checkNotNullParameter(modelUserRelationship, "p1");
            ((StoreStream) this.receiver).handleRelationshipAdd(modelUserRelationship);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$31 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C645931 extends C12236k implements Function1<ModelUserRelationship, Unit> {
        public C645931(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleRelationshipRemove", "handleRelationshipRemove(Lcom/discord/models/domain/ModelUserRelationship;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserRelationship modelUserRelationship) {
            invoke2(modelUserRelationship);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserRelationship modelUserRelationship) {
            C12238m.checkNotNullParameter(modelUserRelationship, "p1");
            ((StoreStream) this.receiver).handleRelationshipRemove(modelUserRelationship);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$32 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646032 extends C12236k implements Function1<Message, Unit> {
        public C646032(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageUpdate", "handleMessageUpdate(Lcom/discord/api/message/Message;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            C12238m.checkNotNullParameter(message, "p1");
            ((StoreStream) this.receiver).handleMessageUpdate(message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$33 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646133 extends C12236k implements Function1<Message, Unit> {
        public C646133(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageCreate", "handleMessageCreate(Lcom/discord/api/message/Message;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            C12238m.checkNotNullParameter(message, "p1");
            ((StoreStream) this.receiver).handleMessageCreate(message);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$34 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646234 extends C12236k implements Function1<MessageReactionUpdate, Unit> {
        public C646234(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionAdd", "handleReactionAdd(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            C12238m.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionAdd(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$35 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646335 extends C12236k implements Function1<MessageReactionUpdate, Unit> {
        public C646335(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionRemove", "handleReactionRemove(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            C12238m.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionRemove(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$36 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646436 extends C12236k implements Function1<MessageReactionUpdate, Unit> {
        public C646436(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionRemoveEmoji", "handleReactionRemoveEmoji(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            C12238m.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionRemoveEmoji(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$37 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646537 extends C12236k implements Function1<MessageReactionUpdate, Unit> {
        public C646537(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleReactionRemoveAll", "handleReactionRemoveAll(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
            invoke2(messageReactionUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
            C12238m.checkNotNullParameter(messageReactionUpdate, "p1");
            ((StoreStream) this.receiver).handleReactionRemoveAll(messageReactionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$38 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646638 extends C12236k implements Function1<ModelMessageDelete, Unit> {
        public C646638(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageDelete", "handleMessageDelete(Lcom/discord/models/domain/ModelMessageDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMessageDelete modelMessageDelete) {
            invoke2(modelMessageDelete);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMessageDelete modelMessageDelete) {
            C12238m.checkNotNullParameter(modelMessageDelete, "p1");
            ((StoreStream) this.receiver).handleMessageDelete(modelMessageDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$39 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646739 extends C12236k implements Function1<ModelReadState, Unit> {
        public C646739(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleMessageAck", "handleMessageAck(Lcom/discord/models/domain/ModelReadState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelReadState modelReadState) {
            invoke2(modelReadState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelReadState modelReadState) {
            C12238m.checkNotNullParameter(modelReadState, "p1");
            ((StoreStream) this.receiver).handleMessageAck(modelReadState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$4 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C64684 extends C12236k implements Function1<GuildApplicationCommands, Unit> {
        public C64684(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildApplicationCommands", "handleGuildApplicationCommands(Lcom/discord/api/commands/GuildApplicationCommands;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildApplicationCommands guildApplicationCommands) {
            invoke2(guildApplicationCommands);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildApplicationCommands guildApplicationCommands) {
            C12238m.checkNotNullParameter(guildApplicationCommands, "p1");
            ((StoreStream) this.receiver).handleGuildApplicationCommands(guildApplicationCommands);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$40 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C646940 extends C12236k implements Function1<VoiceState, Unit> {
        public C646940(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleVoiceStateUpdate", "handleVoiceStateUpdate(Lcom/discord/api/voice/state/VoiceState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VoiceState voiceState) {
            invoke2(voiceState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VoiceState voiceState) {
            C12238m.checkNotNullParameter(voiceState, "p1");
            ((StoreStream) this.receiver).handleVoiceStateUpdate(voiceState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$41 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647041 extends C12236k implements Function1<VoiceServer, Unit> {
        public C647041(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleVoiceServerUpdate", "handleVoiceServerUpdate(Lcom/discord/api/voice/server/VoiceServer;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VoiceServer voiceServer) {
            invoke2(voiceServer);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VoiceServer voiceServer) {
            C12238m.checkNotNullParameter(voiceServer, "p1");
            ((StoreStream) this.receiver).handleVoiceServerUpdate(voiceServer);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$42 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647142 extends C12236k implements Function1<ModelNotificationSettings, Unit> {
        public C647142(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildSettingUpdated", "handleGuildSettingUpdated(Lcom/discord/models/domain/ModelNotificationSettings;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelNotificationSettings modelNotificationSettings) {
            invoke2(modelNotificationSettings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelNotificationSettings modelNotificationSettings) {
            C12238m.checkNotNullParameter(modelNotificationSettings, "p1");
            ((StoreStream) this.receiver).handleGuildSettingUpdated(modelNotificationSettings);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$43 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647243 extends C12236k implements Function1<ModelUserSettings, Unit> {
        public C647243(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleUserSettingsUpdate", "handleUserSettingsUpdate(Lcom/discord/models/domain/ModelUserSettings;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            C12238m.checkNotNullParameter(modelUserSettings, "p1");
            ((StoreStream) this.receiver).handleUserSettingsUpdate(modelUserSettings);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$44 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647344 extends C12236k implements Function1<TypingUser, Unit> {
        public C647344(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleTypingStart", "handleTypingStart(Lcom/discord/api/user/TypingUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
            invoke2(typingUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TypingUser typingUser) {
            C12238m.checkNotNullParameter(typingUser, "p1");
            ((StoreStream) this.receiver).handleTypingStart(typingUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$45 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C647445 extends AbstractC12240o implements Function1<Presence, Unit> {
        public C647445() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Presence presence) {
            invoke2(presence);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Presence presence) {
            StoreStream storeStream = StoreStream.this;
            Long lM8155d = presence.getGuildId();
            long jLongValue = lM8155d != null ? lM8155d.longValue() : 0L;
            C12238m.checkNotNullExpressionValue(presence, "it");
            storeStream.handlePresenceUpdate(jLongValue, presence);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$46 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647546 extends C12236k implements Function1<List<? extends Presence>, Unit> {
        public C647546(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handlePresenceReplace", "handlePresenceReplace(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Presence> list) {
            invoke2((List<Presence>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Presence> list) {
            C12238m.checkNotNullParameter(list, "p1");
            ((StoreStream) this.receiver).handlePresenceReplace(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$47 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647647 extends C12236k implements Function1<ChannelRecipient, Unit> {
        public C647647(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGroupDMRecipientAdd", "handleGroupDMRecipientAdd(Lcom/discord/api/channel/ChannelRecipient;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelRecipient channelRecipient) {
            invoke2(channelRecipient);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelRecipient channelRecipient) {
            C12238m.checkNotNullParameter(channelRecipient, "p1");
            ((StoreStream) this.receiver).handleGroupDMRecipientAdd(channelRecipient);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$48 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647748 extends C12236k implements Function1<ChannelRecipient, Unit> {
        public C647748(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGroupDMRecipientRemove", "handleGroupDMRecipientRemove(Lcom/discord/api/channel/ChannelRecipient;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelRecipient channelRecipient) {
            invoke2(channelRecipient);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelRecipient channelRecipient) {
            C12238m.checkNotNullParameter(channelRecipient, "p1");
            ((StoreStream) this.receiver).handleGroupDMRecipientRemove(channelRecipient);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$49 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C647849 extends C12236k implements Function1<ModelCall, Unit> {
        public C647849(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleCallDelete", "handleCallDelete(Lcom/discord/models/domain/ModelCall;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            C12238m.checkNotNullParameter(modelCall, "p1");
            ((StoreStream) this.receiver).handleCallDelete(modelCall);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$5 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C64795 extends C12236k implements Function1<Guild, Unit> {
        public C64795(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildCreate", "handleGuildCreate(Lcom/discord/api/guild/Guild;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            C12238m.checkNotNullParameter(guild, "p1");
            ((StoreStream) this.receiver).handleGuildCreate(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$50 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648050 extends C12236k implements Function1<ModelCall, Unit> {
        public C648050(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleCallCreateOrUpdate", "handleCallCreateOrUpdate(Lcom/discord/models/domain/ModelCall;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            C12238m.checkNotNullParameter(modelCall, "p1");
            ((StoreStream) this.receiver).handleCallCreateOrUpdate(modelCall);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$51 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648151 extends C12236k implements Function1<GuildEmojisUpdate, Unit> {
        public C648151(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleEmojiUpdate", "handleEmojiUpdate(Lcom/discord/api/emoji/GuildEmojisUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildEmojisUpdate guildEmojisUpdate) {
            invoke2(guildEmojisUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildEmojisUpdate guildEmojisUpdate) {
            C12238m.checkNotNullParameter(guildEmojisUpdate, "p1");
            ((StoreStream) this.receiver).handleEmojiUpdate(guildEmojisUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$52 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648252 extends C12236k implements Function1<GuildStickersUpdate, Unit> {
        public C648252(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStickersUpdate", "handleStickersUpdate(Lcom/discord/api/sticker/GuildStickersUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildStickersUpdate guildStickersUpdate) {
            invoke2(guildStickersUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildStickersUpdate guildStickersUpdate) {
            C12238m.checkNotNullParameter(guildStickersUpdate, "p1");
            ((StoreStream) this.receiver).handleStickersUpdate(guildStickersUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$53 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648353 extends C12236k implements Function1<UserRequiredActionUpdate, Unit> {
        public C648353(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleRequiredActionUpdate", "handleRequiredActionUpdate(Lcom/discord/api/requiredaction/UserRequiredActionUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserRequiredActionUpdate userRequiredActionUpdate) {
            invoke2(userRequiredActionUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserRequiredActionUpdate userRequiredActionUpdate) {
            C12238m.checkNotNullParameter(userRequiredActionUpdate, "p1");
            ((StoreStream) this.receiver).handleRequiredActionUpdate(userRequiredActionUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$54 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648454 extends C12236k implements Function1<ModelGuildMemberListUpdate, Unit> {
        public C648454(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildMemberListUpdate", "handleGuildMemberListUpdate(Lcom/discord/models/domain/ModelGuildMemberListUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
            invoke2(modelGuildMemberListUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildMemberListUpdate modelGuildMemberListUpdate) {
            C12238m.checkNotNullParameter(modelGuildMemberListUpdate, "p1");
            ((StoreStream) this.receiver).handleGuildMemberListUpdate(modelGuildMemberListUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$55 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648555 extends C12236k implements Function1<List<? extends ModelSession>, Unit> {
        public C648555(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleSessionsReplace", "handleSessionsReplace(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelSession> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelSession> list) {
            C12238m.checkNotNullParameter(list, "p1");
            ((StoreStream) this.receiver).handleSessionsReplace(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$56 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C648656 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C648656() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreStream.this.handleUserPaymentSourcesUpdate();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$57 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C648757 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C648757() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreStream.this.handleUserSubscriptionsUpdate();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$58 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648858 extends C12236k implements Function1<StreamCreateOrUpdate, Unit> {
        public C648858(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStreamCreate", "handleStreamCreate(Lcom/discord/models/domain/StreamCreateOrUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamCreateOrUpdate streamCreateOrUpdate) {
            invoke2(streamCreateOrUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamCreateOrUpdate streamCreateOrUpdate) {
            C12238m.checkNotNullParameter(streamCreateOrUpdate, "p1");
            ((StoreStream) this.receiver).handleStreamCreate(streamCreateOrUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$59 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C648959 extends C12236k implements Function1<StreamCreateOrUpdate, Unit> {
        public C648959(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStreamUpdate", "handleStreamUpdate(Lcom/discord/models/domain/StreamCreateOrUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamCreateOrUpdate streamCreateOrUpdate) {
            invoke2(streamCreateOrUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamCreateOrUpdate streamCreateOrUpdate) {
            C12238m.checkNotNullParameter(streamCreateOrUpdate, "p1");
            ((StoreStream) this.receiver).handleStreamUpdate(streamCreateOrUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$6 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C64906 extends C12236k implements Function1<Guild, Unit> {
        public C64906(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildUpdate", "handleGuildUpdate(Lcom/discord/api/guild/Guild;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            C12238m.checkNotNullParameter(guild, "p1");
            ((StoreStream) this.receiver).handleGuildUpdate(guild);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$60 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C649160 extends AbstractC12240o implements Function1<StreamDelete, Unit> {
        public C649160() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamDelete streamDelete) {
            invoke2(streamDelete);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamDelete streamDelete) {
            StoreStream storeStream = StoreStream.this;
            C12238m.checkNotNullExpressionValue(streamDelete, "it");
            storeStream.handleStreamDelete(streamDelete, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$61 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649261 extends C12236k implements Function1<StreamServerUpdate, Unit> {
        public C649261(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStreamServerUpdate", "handleStreamServerUpdate(Lcom/discord/models/domain/StreamServerUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamServerUpdate streamServerUpdate) {
            invoke2(streamServerUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamServerUpdate streamServerUpdate) {
            C12238m.checkNotNullParameter(streamServerUpdate, "p1");
            ((StoreStream) this.receiver).handleStreamServerUpdate(streamServerUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$62 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649362 extends C12236k implements Function1<InteractionStateUpdate, Unit> {
        public C649362(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionCreate", "handleInteractionCreate(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
            invoke2(interactionStateUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
            C12238m.checkNotNullParameter(interactionStateUpdate, "p1");
            ((StoreStream) this.receiver).handleInteractionCreate(interactionStateUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$63 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649463 extends C12236k implements Function1<InteractionStateUpdate, Unit> {
        public C649463(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionSuccess", "handleInteractionSuccess(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
            invoke2(interactionStateUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
            C12238m.checkNotNullParameter(interactionStateUpdate, "p1");
            ((StoreStream) this.receiver).handleInteractionSuccess(interactionStateUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$64 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649564 extends C12236k implements Function1<InteractionStateUpdate, Unit> {
        public C649564(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionFailure", "handleInteractionFailure(Lcom/discord/api/interaction/InteractionStateUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionStateUpdate interactionStateUpdate) {
            invoke2(interactionStateUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionStateUpdate interactionStateUpdate) {
            C12238m.checkNotNullParameter(interactionStateUpdate, "p1");
            ((StoreStream) this.receiver).handleInteractionFailure(interactionStateUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$65 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649665 extends C12236k implements Function1<InteractionModalCreate, Unit> {
        public C649665(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleInteractionModalCreate", "handleInteractionModalCreate(Lcom/discord/api/interaction/InteractionModalCreate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
            invoke2(interactionModalCreate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionModalCreate interactionModalCreate) {
            C12238m.checkNotNullParameter(interactionModalCreate, "p1");
            ((StoreStream) this.receiver).handleInteractionModalCreate(interactionModalCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$66 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649766 extends C12236k implements Function1<ApplicationCommandAutocompleteResult, Unit> {
        public C649766(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleApplicationCommandAutocompleteResult", "handleApplicationCommandAutocompleteResult(Lcom/discord/api/commands/ApplicationCommandAutocompleteResult;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult) {
            invoke2(applicationCommandAutocompleteResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult) {
            C12238m.checkNotNullParameter(applicationCommandAutocompleteResult, "p1");
            ((StoreStream) this.receiver).handleApplicationCommandAutocompleteResult(applicationCommandAutocompleteResult);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$67 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649867 extends C12236k implements Function1<StageInstance, Unit> {
        public C649867(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStageInstanceCreate", "handleStageInstanceCreate(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            C12238m.checkNotNullParameter(stageInstance, "p1");
            ((StoreStream) this.receiver).handleStageInstanceCreate(stageInstance);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$68 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C649968 extends C12236k implements Function1<StageInstance, Unit> {
        public C649968(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStageInstanceUpdate", "handleStageInstanceUpdate(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            C12238m.checkNotNullParameter(stageInstance, "p1");
            ((StoreStream) this.receiver).handleStageInstanceUpdate(stageInstance);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$69 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650069 extends C12236k implements Function1<StageInstance, Unit> {
        public C650069(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleStageInstanceDelete", "handleStageInstanceDelete(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            C12238m.checkNotNullParameter(stageInstance, "p1");
            ((StoreStream) this.receiver).handleStageInstanceDelete(stageInstance);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$7 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C65017 extends C12236k implements Function1<GuildRoleCreate, Unit> {
        public C65017(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRoleCreate", "handleGuildRoleCreate(Lcom/discord/api/role/GuildRoleCreate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleCreate guildRoleCreate) {
            invoke2(guildRoleCreate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleCreate guildRoleCreate) {
            C12238m.checkNotNullParameter(guildRoleCreate, "p1");
            ((StoreStream) this.receiver).handleGuildRoleCreate(guildRoleCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$70 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650270 extends C12236k implements Function1<FriendSuggestion, Unit> {
        public C650270(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleFriendSuggestionCreate", "handleFriendSuggestionCreate(Lcom/discord/api/friendsuggestions/FriendSuggestion;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendSuggestion friendSuggestion) {
            invoke2(friendSuggestion);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendSuggestion friendSuggestion) {
            C12238m.checkNotNullParameter(friendSuggestion, "p1");
            ((StoreStream) this.receiver).handleFriendSuggestionCreate(friendSuggestion);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$71 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650371 extends C12236k implements Function1<FriendSuggestionDelete, Unit> {
        public C650371(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleFriendSuggestionDelete", "handleFriendSuggestionDelete(Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendSuggestionDelete friendSuggestionDelete) {
            invoke2(friendSuggestionDelete);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendSuggestionDelete friendSuggestionDelete) {
            C12238m.checkNotNullParameter(friendSuggestionDelete, "p1");
            ((StoreStream) this.receiver).handleFriendSuggestionDelete(friendSuggestionDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$72 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650472 extends C12236k implements Function1<GuildScheduledEvent, Unit> {
        public C650472(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildScheduledEventCreate", "handleGuildScheduledEventCreate(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "p1");
            ((StoreStream) this.receiver).handleGuildScheduledEventCreate(guildScheduledEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$73 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650573 extends C12236k implements Function1<GuildScheduledEvent, Unit> {
        public C650573(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildScheduledEventUpdate", "handleGuildScheduledEventUpdate(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "p1");
            ((StoreStream) this.receiver).handleGuildScheduledEventUpdate(guildScheduledEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$74 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650674 extends C12236k implements Function1<GuildScheduledEvent, Unit> {
        public C650674(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildScheduledEventDelete", "handleGuildScheduledEventDelete(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "p1");
            ((StoreStream) this.receiver).handleGuildScheduledEventDelete(guildScheduledEvent);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$75 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650775 extends C12236k implements Function1<GuildScheduledEventUserUpdate, Unit> {
        public C650775(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "guildScheduledEventUserAdd", "guildScheduledEventUserAdd(Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            invoke2(guildScheduledEventUserUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            C12238m.checkNotNullParameter(guildScheduledEventUserUpdate, "p1");
            ((StoreStream) this.receiver).guildScheduledEventUserAdd(guildScheduledEventUserUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$76 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650876 extends C12236k implements Function1<GuildScheduledEventUserUpdate, Unit> {
        public C650876(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "guildScheduledEventUserRemove", "guildScheduledEventUserRemove(Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            invoke2(guildScheduledEventUserUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
            C12238m.checkNotNullParameter(guildScheduledEventUserUpdate, "p1");
            ((StoreStream) this.receiver).guildScheduledEventUserRemove(guildScheduledEventUserUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$77 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C650977 extends C12236k implements Function1<EmbeddedActivityInboundUpdate, Unit> {
        public C650977(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleEmbeddedActivityInboundUpdate", "handleEmbeddedActivityInboundUpdate(Lcom/discord/api/embeddedactivities/EmbeddedActivityInboundUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
            invoke2(embeddedActivityInboundUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
            C12238m.checkNotNullParameter(embeddedActivityInboundUpdate, "p1");
            ((StoreStream) this.receiver).handleEmbeddedActivityInboundUpdate(embeddedActivityInboundUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$78 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C651078 extends C12236k implements Function1<ForumUnreads, Unit> {
        public C651078(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleForumUnreads", "handleForumUnreads(Lcom/discord/api/forum/ForumUnreads;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ForumUnreads forumUnreads) {
            invoke2(forumUnreads);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ForumUnreads forumUnreads) {
            C12238m.checkNotNullParameter(forumUnreads, "p1");
            ((StoreStream) this.receiver).handleForumUnreads(forumUnreads);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$8 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C65118 extends C12236k implements Function1<GuildRoleUpdate, Unit> {
        public C65118(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRoleUpdate", "handleGuildRoleUpdate(Lcom/discord/api/role/GuildRoleUpdate;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleUpdate guildRoleUpdate) {
            invoke2(guildRoleUpdate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleUpdate guildRoleUpdate) {
            C12238m.checkNotNullParameter(guildRoleUpdate, "p1");
            ((StoreStream) this.receiver).handleGuildRoleUpdate(guildRoleUpdate);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$initGatewaySocketListeners$9 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final /* synthetic */ class C65129 extends C12236k implements Function1<GuildRoleDelete, Unit> {
        public C65129(StoreStream storeStream) {
            super(1, storeStream, StoreStream.class, "handleGuildRoleDelete", "handleGuildRoleDelete(Lcom/discord/api/role/GuildRoleDelete;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleDelete guildRoleDelete) {
            invoke2(guildRoleDelete);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleDelete guildRoleDelete) {
            C12238m.checkNotNullParameter(guildRoleDelete, "p1");
            ((StoreStream) this.receiver).handleGuildRoleDelete(guildRoleDelete);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$maybeLogNotificationPermissionStatus$1 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C65131 extends AbstractC12240o implements Function1<NotificationClient.SettingsV2, Unit> {
        public final /* synthetic */ Application $context;
        public final /* synthetic */ long $currentTime;
        public final /* synthetic */ SharedPreferences $sharedPrefs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65131(SharedPreferences sharedPreferences, long j, Application application) {
            super(1);
            this.$sharedPrefs = sharedPreferences;
            this.$currentTime = j;
            this.$context = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationClient.SettingsV2 settingsV2) {
            invoke2(settingsV2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationClient.SettingsV2 settingsV2) {
            this.$sharedPrefs.edit().putLong(StoreStream.LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY, this.$currentTime).apply();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Application application = this.$context;
            C12238m.checkNotNullExpressionValue(settingsV2, "it");
            analyticsTracker.notificationPermissionStatus(application, settingsV2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreStream$startStoreInitializationTimer$1 */
    /* JADX INFO: compiled from: StoreStream.kt */
    public static final class C65141 extends AbstractC12240o implements Function1<Object, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreStream$startStoreInitializationTimer$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreStream.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.this.handleStoreInitializationTimeout();
            }
        }

        public C65141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            StoreStream.this.dispatcher.schedule(new AnonymousClass1());
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
        AtomicReference<C12781a> atomicReference = C12781a.f27393a;
        C12698c c12698c = new C12698c(executorServiceNewSingleThreadExecutor);
        C12238m.checkNotNullExpressionValue(c12698c, "Schedulers.from(Executor…       newThread\n      })");
        this.storeThreadScheduler = c12698c;
        Dispatcher dispatcher = new Dispatcher(c12698c, false);
        this.dispatcher = dispatcher;
        Clock clock = ClockFactory.get();
        this.clock = clock;
        StoreAnalytics storeAnalytics = new StoreAnalytics(this, dispatcher, clock);
        this.analytics = storeAnalytics;
        StoreAuthentication storeAuthentication = new StoreAuthentication(this, dispatcher);
        this.authentication = storeAuthentication;
        StoreChannels storeChannels = new StoreChannels(dispatcher, ObservationDeckProvider.get(), new StoreStream$channels$1(this), new StoreStream$channels$2(this), new StoreStream$channels$3(this), null, 32, null);
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
        ObservationDeck observationDeck2 = ObservationDeckProvider.get();
        RestAPI.Companion companion = RestAPI.INSTANCE;
        this.guildEmojis = new StoreEmojiGuild(observationDeck2, dispatcher, companion.getApi());
        this.integrations = new StoreGuildIntegrations(dispatcher);
        this.instantInvites = new StoreInstantInvites(dispatcher, null, null, 6, null);
        this.guildTemplates = new StoreGuildTemplates(ObservationDeckProvider.get(), dispatcher, companion.getApi());
        this.guildInvite = new StoreInviteSettings();
        StoreMessages storeMessages = new StoreMessages(this, dispatcher, clock);
        this.messages = storeMessages;
        this.messagesLoader = new StoreMessagesLoader(this, dispatcher);
        this.messagesMostRecent = new StoreMessagesMostRecent(storeChannels, null, 2, 0 == true ? 1 : 0);
        StoreMessageAck storeMessageAck = new StoreMessageAck(this, ObservationDeckProvider.get(), dispatcher, companion.getApi());
        this.messageAck = storeMessageAck;
        this.messageReplies = new StoreMessageReplies(dispatcher, storeMessages, 0 == true ? 1 : 0, 4, defaultConstructorMarker);
        this.messageStates = new StoreMessageState(dispatcher);
        this.notifications = new StoreNotifications(clock, this);
        StoreExperiments storeExperiments = new StoreExperiments(clock, dispatcher, storeUser, storeGuilds, storeAuthentication, storeGuildMemberCounts, 0 == true ? 1 : 0, 64, defaultConstructorMarker);
        this.experiments = storeExperiments;
        this.lurking = new StoreLurking(this, storeGuilds, dispatcher);
        this.userConnections = new StoreUserConnections(this, dispatcher, null, 4, null);
        StoreUserPresence storeUserPresence = new StoreUserPresence(clock, this, ObservationDeckProvider.get());
        this.presences = storeUserPresence;
        this.userProfile = new StoreUserProfile(dispatcher, ObservationDeckProvider.get(), this, null, 8, null);
        this.userNotes = new StoreUserNotes(dispatcher, 0 == true ? 1 : 0, null, 6, null);
        this.usersTyping = new StoreUserTyping(this, dispatcher, null, 0 == true ? 1 : 0, 12, null);
        StoreAccessibility storeAccessibility = new StoreAccessibility(dispatcher, 0 == true ? 1 : 0, null, 6, null);
        this.accessibility = storeAccessibility;
        this.userSettings = new StoreUserSettings(dispatcher, storeAccessibility);
        StoreUserSettingsSystem storeUserSettingsSystem = new StoreUserSettingsSystem(new StoreStream$userSettingsSystem$1(this), dispatcher);
        this.userSettingsSystem = storeUserSettingsSystem;
        this.userSurvey = new StoreUserSurvey(dispatcher, storeUser, storeGuilds, storePermissions, ObservationDeckProvider.get(), companion.getApi(), clock, SharedPreferencesProvider.INSTANCE.get());
        this.userRequiredAction = new StoreUserRequiredActions(ObservationDeckProvider.get());
        StoreUserRelationships storeUserRelationships = new StoreUserRelationships(null, 1, 0 == true ? 1 : 0);
        this.userRelationships = storeUserRelationships;
        StoreVoiceStates storeVoiceStates = new StoreVoiceStates(new StoreStream$voiceStates$1(this), ObservationDeckProvider.get());
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
        this.callsIncoming = new StoreCallsIncoming(this.dispatcher, ObservationDeckProvider.get(), this.users);
        this.chat = new StoreChat(this.dispatcher, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
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
        StoreRtcRegion storeRtcRegion = new StoreRtcRegion(this.dispatcher, this.clock, storeMediaEngine, storeExperiments, null, 16, 0 == true ? 1 : 0);
        this.rtcRegion = storeRtcRegion;
        StoreRtcConnection storeRtcConnection = new StoreRtcConnection(this, this.dispatcher, this.clock, storeRtcRegion, this.analytics, storeVoiceStates, null, null, Opcodes.CHECKCAST, null);
        this.rtcConnection = storeRtcConnection;
        this.voiceSpeaking = new StoreVoiceSpeaking(ObservationDeckProvider.get());
        this.videoStreams = new StoreVideoStreams(null, 1, 0 == true ? 1 : 0);
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
        this.auditLog = new StoreAuditLog(ObservationDeckProvider.get(), this.dispatcher, companion.getApi());
        this.messageUploads = new StoreMessageUploads();
        this.nux = new StoreNux(this.dispatcher);
        this.library = new StoreLibrary(this.dispatcher, ObservationDeckProvider.get());
        this.gifting = new StoreGifting(this.dispatcher);
        this.spotify = new StoreSpotify(this, this.dispatcher, this.clock);
        this.messageReactions = new StoreMessageReactions(this.dispatcher, this.users, null, 4, null);
        this.application = new StoreApplication(this.dispatcher, ObservationDeckProvider.get());
        this.applicationAssets = new StoreApplicationAssets(this.dispatcher, null, 0 == true ? 1 : 0, 6, 0 == true ? 1 : 0);
        this.paymentSources = new StorePaymentSources(this.dispatcher, null, null, 6, null);
        this.subscriptions = new StoreSubscriptions(ObservationDeckProvider.get(), this.dispatcher, companion.getApi());
        this.mfa = new StoreMFA(this, this.dispatcher, ObservationDeckProvider.get());
        StoreStreamRtcConnection storeStreamRtcConnection = new StoreStreamRtcConnection(storeMediaEngine, this.users, this, this.dispatcher, this.clock, this.analytics, storeRtcConnection, 0 == true ? 1 : 0, null, null, 896, null);
        this.streamRtcConnection = storeStreamRtcConnection;
        this.audioManagerV2 = new StoreAudioManagerV2(ObservationDeckProvider.get(), this.dispatcher, storeVoiceChannelSelected, this.channels, storeStreamRtcConnection, videoUseDetector, this.experiments);
        this.applicationStreamPreviews = new StoreApplicationStreamPreviews(this.dispatcher, this.clock, null, 0 == true ? 1 : 0, 12, 0 == true ? 1 : 0);
        StoreGuildsSorted storeGuildsSorted = new StoreGuildsSorted(ObservationDeckProvider.get(), this.dispatcher, this.guilds, this.lurking);
        this.guildsSorted = storeGuildsSorted;
        int i = 2;
        this.expandedGuildFolders = new StoreExpandedGuildFolders(this.dispatcher, null, i, 0 == true ? 1 : 0);
        StoreMediaFavorites storeMediaFavorites = new StoreMediaFavorites(ObservationDeckProvider.get(), this.dispatcher, null, 4, 0 == true ? 1 : 0);
        this.mediaFavorites = storeMediaFavorites;
        this.emojis = new StoreEmoji(this.customEmojis, this.users, this.permissions, storeGuildsSorted, storeMediaFavorites);
        StoreGuildBoost storeGuildBoost = new StoreGuildBoost(this.dispatcher, ObservationDeckProvider.get());
        this.guildBoosts = storeGuildBoost;
        StoreEntitlements storeEntitlements = new StoreEntitlements(this.dispatcher, ObservationDeckProvider.get(), null, 4, null);
        this.entitlements = storeEntitlements;
        StoreGuildProfiles storeGuildProfiles = new StoreGuildProfiles(this.dispatcher, ObservationDeckProvider.get());
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
        StoreGooglePlayPurchases storeGooglePlayPurchases = new StoreGooglePlayPurchases(ObservationDeckProvider.get(), this.dispatcher, companion.getApi(), this.clock, new Gson(), AnalyticsTracker.INSTANCE);
        this.googlePlayPurchases = storeGooglePlayPurchases;
        StoreGooglePlaySkuDetails storeGooglePlaySkuDetails = new StoreGooglePlaySkuDetails(ObservationDeckProvider.get(), this.dispatcher);
        this.googlePlaySkuDetails = storeGooglePlaySkuDetails;
        StoreExpressionPickerNavigation storeExpressionPickerNavigation = new StoreExpressionPickerNavigation(ObservationDeckProvider.get(), this.dispatcher);
        this.expressionPickerNavigation = storeExpressionPickerNavigation;
        StoreChannelFollowerStats storeChannelFollowerStats = new StoreChannelFollowerStats(this.dispatcher, ObservationDeckProvider.get());
        this.channelFollowerStats = storeChannelFollowerStats;
        int i2 = 2;
        StoreApplicationCommandFrecency storeApplicationCommandFrecency = new StoreApplicationCommandFrecency(this.dispatcher, null, i2, 0 == true ? 1 : 0);
        this.applicationCommandFrecency = storeApplicationCommandFrecency;
        StorePendingReplies storePendingReplies = new StorePendingReplies(this.dispatcher, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        this.pendingReplies = storePendingReplies;
        StoreApplicationCommands storeApplicationCommands = new StoreApplicationCommands(this.gatewaySocket, this.permissions, storeApplicationCommandFrecency, this.guilds, this.users, this.experiments, this.dispatcher, null, ObservationDeckProvider.get(), null, null, 1664, null);
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
        StoreContactSync storeContactSync = new StoreContactSync(this.dispatcher, companion.getApi(), this.clock, this.userConnections, this.users, this.experiments, this.notices, this.userSettings);
        this.contactSync = storeContactSync;
        Dispatcher dispatcher2 = this.dispatcher;
        StoreFriendSuggestions storeFriendSuggestions = new StoreFriendSuggestions(this, dispatcher2, new FriendSuggestionsFetcher(dispatcher2, companion.getApi(), new StoreStream$friendSuggestions$1(this), new StoreStream$friendSuggestions$2(this)));
        this.friendSuggestions = storeFriendSuggestions;
        StoreGuildStickers storeGuildStickers = new StoreGuildStickers(this.dispatcher, null, new StoreStream$guildStickers$1(this), 2, null);
        this.guildStickers = storeGuildStickers;
        StoreOutboundPromotions storeOutboundPromotions = new StoreOutboundPromotions(new OutboundPromosPreviewFeatureFlag(this.experiments), this.dispatcher, 0 == true ? 1 : 0, null, 12, null);
        this.outboundPromotions = storeOutboundPromotions;
        StoreGuildScheduledEvents storeGuildScheduledEvents = new StoreGuildScheduledEvents(this.dispatcher, ObservationDeckProvider.get(), this.permissions, this.users, this.guilds, this.clock, this.experiments);
        this.guildScheduledEvents = storeGuildScheduledEvents;
        StoreDirectories storeDirectories = new StoreDirectories(this.dispatcher, ObservationDeckProvider.get(), this.guilds, storeGuildScheduledEvents, null, 16, null);
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
        List<StoreV2> listListOf = C12147n.listOf((Object[]) new StoreV2[]{this.bans, this.users, this.guilds, this.channels, this.channelConversions, this.presences, this.permissions, this.voiceChannelSelected, this.voiceSpeaking, this.accessibility, this.callsIncoming, this.connectivity, this.connectionOpen, storeGuildWelcomeScreens, storeGuildVoiceRegions, this.videoStreams, storeClientDataState, storeGifPicker, storeStickers, this.guildMemberCounts, this.guildJoinRequests, this.experiments, this.messageReplies, storeChannelFollowerStats, storePendingReplies, storeGuildProfiles, this.application, this.applicationAssets, storeApplicationCommands, this.guildSelected, this.channelsSelected, this.pinnedMessages, storeGuildMemberVerificationForm, this.userRequiredAction, this.userSurvey, storePhone, storeThreadsActive, this.threadsJoined, storeThreadsActiveJoined, storeThreadMessages, archivedThreadsStore, storeThreadDraft, storeExpressionPickerNavigation, storeGuildBoost, this.collapsedChannelCategories, this.messageUploads, storeExpressionSuggestions, this.applicationStreaming, storeApplicationInteractions, storeApplicationCommandFrecency, storeLocalActionComponentState, this.stageInstances, this.requestedStageChannels, storeStageChannels, storeStageChannelSelfPresence, storeAutocomplete, this.messageReactions, this.library, this.userRelationships, this.userSettingsSystem, this.tabsNavigation, this.voiceStates, this.mentions, storeUserAffinities, this.userProfile, this.userConnections, this.messagesMostRecent, this.usersTyping, this.instantInvites, this.guildSettings, this.customEmojis, storeEntitlements, this.mediaFavorites, this.subscriptions, storeGooglePlayPurchases, storeGooglePlaySkuDetails, this.guildTemplates, this.userNotes, this.mfa, this.messageAck, this.guildSubscriptions, this.lazyChannelMembersStore, this.lazyThreadMembersStore, this.guildEmojis, this.guildsSorted, this.auditLog, this.expandedGuildFolders, this.maskedLinks, this.streamRtcConnection, this.paymentSources, storeContactSync, this.applicationStreamPreviews, this.guildsNsfw, this.gameParty, storeFriendSuggestions, this.chat, this.audioManagerV2, storeGuildStickers, storeOutboundPromotions, storeDirectories, storeGuildScheduledEvents, storeGuildRoleSubscriptions, storeNotificationUpsells, storeEmbeddedActivities, storeGuildRoleMemberCounts, storeForumPostMessages, storeForumPostReadStates});
        this.storesV2 = listListOf;
        StoreV2DispatchHandler storeV2DispatchHandler = new StoreV2DispatchHandler(listListOf, null, 2, 0 == true ? 1 : 0);
        this.storeV2DispatchHandler = storeV2DispatchHandler;
        this.dispatcher.registerDispatchHandlers(storeV2DispatchHandler);
        connectionTimeStats.addListener(this.rtcConnection);
        connectionTimeStats.addListener(this.streamRtcConnection);
        connectionTimeStats.addListener(this.mediaEngine);
    }

    private final void deferredInit(Application context) {
        this.dispatcher.schedule(new C64321(context));
    }

    private final <T> void dispatchSubscribe(Observable<T> observable, String str, Function1<? super T, Unit> function1) {
        Observable<T> observableM11085K = observable.m11085K();
        C12238m.checkNotNullExpressionValue(observableM11085K, "onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe(observableM11085K, (117 & 1) != 0 ? null : null, str, (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C64331(function1), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
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
        AppLog.m8358i("[StoreStream] Application backgrounded: " + backgrounded);
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
                C12238m.checkNotNullExpressionValue(voiceState, "voiceState");
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
        ReadyPayloadUtils.HydrateResult hydrateResultHydrateReadyPayload = ReadyPayloadUtils.INSTANCE.hydrateReadyPayload(payload_, this.guilds, this.channels, this.customEmojis, this.guildStickers);
        if (!(hydrateResultHydrateReadyPayload instanceof ReadyPayloadUtils.HydrateResult.Success)) {
            handleHydrateError();
            return;
        }
        ModelPayload payload = ((ReadyPayloadUtils.HydrateResult.Success) hydrateResultHydrateReadyPayload).getPayload();
        String authToken = payload.getAuthToken();
        if (authToken != null) {
            handleAuthState(AuthState.INSTANCE.from(authToken, C12148n0.emptySet()));
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
        AppLog.m8358i("[StoreStream] Processed ready payload in " + timeElapsed.getSeconds() + " seconds");
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

    @StoreThread
    private final void handleGuildIntegrationUpdate(ModelGuildIntegration.Update update) {
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
        List<Presence> listM7934d = chunk.m7934d();
        if (listM7934d != null) {
            Iterator<Presence> it = listM7934d.iterator();
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
        GuildRole guildRoleM8213c = event.getRole();
        if (guildRoleM8213c != null) {
            handleGuildRoleCreateOrUpdate(event.getGuildId(), guildRoleM8213c, event.getGuildHashes());
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
        this.guildSettings.handleGuildSettingUpdated$app_productionGoogleRelease(C12145m.listOf(modelNotificationSettings));
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
        this.messages.handleMessageCreate(C12145m.listOf(message));
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
        C12238m.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
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
        this.messages.handleReactionUpdate(C12145m.listOf(update), true);
        this.messageReactions.handleReactionAdd(update);
        this.forumPostMessages.handleReactionAdd(update);
    }

    @StoreThread
    private final void handleReactionRemove(MessageReactionUpdate update) {
        this.messages.handleReactionUpdate(C12145m.listOf(update), false);
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
    private final void handleRtcConnectionStateChanged(RtcConnection.StateChange stateChange) {
        this.gatewaySocket.handleRtcConnectionStateChanged(stateChange);
        this.voiceChannelSelected.handleRtcConnectionStateChanged(stateChange.state);
        this.audioManagerV2.handleRtcConnectionState(stateChange.state);
    }

    @StoreThread
    private final void handleSessionsReplace(List<? extends ModelSession> sessions) {
        this.presences.handleSessionsReplace(sessions);
    }

    @StoreThread
    private final void handleSpeakingUpdates(List<StoreRtcConnection.SpeakingUserUpdate> speakingUsers) {
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
        GuildMember guildMemberM8286c = typing.getMember();
        synthesizeGuildMemberAdd(lValueOf, guildMemberM8286c != null ? guildMemberM8286c.getUser() : null, typing.getMember());
        this.usersTyping.handleTypingStart(typing);
    }

    @StoreThread
    private final void handleUserNoteUpdated(ModelUserNote.Update userNote) {
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

    @StoreThread
    private final void handleVoiceServerUpdate(VoiceServer voiceServer) {
        this.rtcConnection.handleVoiceServerUpdate(voiceServer);
    }

    @StoreThread
    private final void handleVoiceStateUpdate(VoiceState voiceState) {
        Long lValueOf = Long.valueOf(voiceState.getGuildId());
        GuildMember guildMemberM8331d = voiceState.getMember();
        synthesizeGuildMemberAdd(lValueOf, guildMemberM8331d != null ? guildMemberM8331d.getUser() : null, voiceState.getMember());
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
        ChannelSelector.INSTANCE.init(this, this.dispatcher, ObservationDeckProvider.get());
        new StoreUIEventHandler(context, this.mediaEngine, this.channels, this.voiceChannelSelected, this.stageChannels, this.guildSettings);
    }

    @StoreThread
    private final void initGatewaySocketListeners() {
        dispatchSubscribe(this.gatewaySocket.getReady(), "streamConnectionOpen", new C64351(this));
        dispatchSubscribe(this.gatewaySocket.getConnected(), "streamConnected", new C64462(this));
        dispatchSubscribe(this.gatewaySocket.getConnectionReady(), "streamReady", new C64573(this));
        dispatchSubscribe(this.gatewaySocket.getGuildApplicationCommands(), "guildApplicationCommands", new C64684(this));
        dispatchSubscribe(this.gatewaySocket.getGuildCreate(), "streamGuildCreate", new C64795(this));
        dispatchSubscribe(this.gatewaySocket.getGuildUpdate(), "streamGuildUpdate", new C64906(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleCreate(), "streamGuildRoleAdd", new C65017(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleUpdate(), "streamGuildRoleUpdate", new C65118(this));
        dispatchSubscribe(this.gatewaySocket.getGuildRoleDelete(), "streamGuildRoleRemove", new C65129(this));
        dispatchSubscribe(this.gatewaySocket.getGuildDeleted(), "streamGuildRemove", new C643610(this));
        dispatchSubscribe(this.gatewaySocket.getGuildBanAdd(), "streamBanAdd", new C643711(this));
        dispatchSubscribe(this.gatewaySocket.getGuildBanRemove(), "streamBanRemove", new C643812(this));
        dispatchSubscribe(this.gatewaySocket.getGuildIntegrationsUpdate(), "streamGuildIntegrationUpdate", new C643913(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMembersAdd(), "streamGuildMemberAdd", new C644014(this));
        dispatchSubscribe(this.gatewaySocket.getGuildJoinRequestCreateOrUpdate(), "streamGuildJoinRequestCreateOrUpdate", new C644115(this));
        dispatchSubscribe(this.gatewaySocket.getGuildJoinRequestDelete(), "streamGuildJoinRequestDelete", new C644216(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMembersChunk(), "streamGuildMemberChunk", new C644317(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMemberRemove(), "streamGuildMemberRemove", new C644418(this));
        dispatchSubscribe(this.gatewaySocket.getChannelCreateOrUpdate(), "streamChannelCreateOrUpdate", new C644519(this));
        dispatchSubscribe(this.gatewaySocket.getChannelDeleted(), "streamChannelDelete", new C644720(this));
        dispatchSubscribe(this.gatewaySocket.getChannelUnreadUpdate(), "streamChannelUnreadUpdate", new C644821(this));
        dispatchSubscribe(this.gatewaySocket.getThreadCreateOrUpdate(), "streamThreadCreateOrUpdate", new C644922(this));
        dispatchSubscribe(this.gatewaySocket.getThreadDelete(), "streamThreadDelete", new C645023(this));
        dispatchSubscribe(this.gatewaySocket.getThreadListSync(), "streamThreadListSync", new C645124(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMemberUpdate(), "streamThreadMemberUpdate", new C645225(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMembersUpdate(), "streamThreadMembersUpdate", new C645326(this));
        dispatchSubscribe(this.gatewaySocket.getThreadMemberListUpdate(), "threadMemberListUpdate", new C645427(this));
        dispatchSubscribe(this.gatewaySocket.getUserUpdate(), "streamUserUpdated", new C645528(this));
        dispatchSubscribe(this.gatewaySocket.getUserNoteUpdate(), "handleUserNoteUpdated", new C645629(this));
        dispatchSubscribe(this.gatewaySocket.getRelationshipAdd(), "streamRelationshipAdd", new C645830(this));
        dispatchSubscribe(this.gatewaySocket.getRelationshipRemove(), "streamRelationshipRemove", new C645931(this));
        dispatchSubscribe(this.gatewaySocket.getMessageUpdate(), "streamMessageUpdate", new C646032(this));
        dispatchSubscribe(this.gatewaySocket.getMessageCreate(), "streamMessageCreate", new C646133(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionAdd(), "streamReactionAdd", new C646234(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemove(), "streamReactionRemove", new C646335(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemoveEmoji(), "streamMessageRemoveEmoji", new C646436(this));
        dispatchSubscribe(this.gatewaySocket.getMessageReactionRemoveAll(), "streamMessageRemoveAll", new C646537(this));
        dispatchSubscribe(this.gatewaySocket.getMessageDelete(), "streamMessageDelete", new C646638(this));
        dispatchSubscribe(this.gatewaySocket.getMessageAck(), "streamMessageAck", new C646739(this));
        dispatchSubscribe(this.gatewaySocket.getVoiceStateUpdate(), "streamVoiceStateUpdate", new C646940(this));
        dispatchSubscribe(this.gatewaySocket.getVoiceServerUpdate(), "streamVoiceServerUpdate", new C647041(this));
        dispatchSubscribe(this.gatewaySocket.getUserGuildSettingsUpdate(), "streamGuildSettingUpdated", new C647142(this));
        dispatchSubscribe(this.gatewaySocket.getUserSettingsUpdate(), "streamUserSettingsUpdate", new C647243(this));
        dispatchSubscribe(this.gatewaySocket.getTypingStart(), "streamTypingStart", new C647344(this));
        dispatchSubscribe(this.gatewaySocket.getPresenceUpdate(), "streamPresenceUpdate", new C647445());
        dispatchSubscribe(this.gatewaySocket.getPresenceReplace(), "streamPresenceReplace", new C647546(this));
        dispatchSubscribe(this.gatewaySocket.getChannelRecipientAdd(), "streamGroupDMRecipientAdd", new C647647(this));
        dispatchSubscribe(this.gatewaySocket.getChannelRecipientRemove(), "streamGroupDMRecipientRemove", new C647748(this));
        dispatchSubscribe(this.gatewaySocket.getCallDelete(), "streamCallDelete", new C647849(this));
        dispatchSubscribe(this.gatewaySocket.getCallCreateOrUpdate(), "streamCallCreateOrUpdate", new C648050(this));
        dispatchSubscribe(this.gatewaySocket.getGuildEmojisUpdate(), "streamEmojisUpdate", new C648151(this));
        dispatchSubscribe(this.gatewaySocket.getGuildStickersUpdate(), "streamStickersUpdate", new C648252(this));
        dispatchSubscribe(this.gatewaySocket.getUserRequiredActionUpdate(), "streamUserRequiredActionUpdate", new C648353(this));
        dispatchSubscribe(this.gatewaySocket.getGuildMemberListUpdate(), "guildMemberListUpdate", new C648454(this));
        dispatchSubscribe(this.gatewaySocket.getSessionsReplace(), "streamSessionsReplace", new C648555(this));
        dispatchSubscribe(this.gatewaySocket.getUserPaymentSourcesUpdate(), "streamUserPaymentSourcesUpdate", new C648656());
        dispatchSubscribe(this.gatewaySocket.getUserSubscriptionsUpdate(), "streamUserSubscriptionsUpdate", new C648757());
        dispatchSubscribe(this.gatewaySocket.getStreamCreate(), "streamStreamCreate", new C648858(this));
        dispatchSubscribe(this.gatewaySocket.getStreamUpdate(), "streamStreamUpdate", new C648959(this));
        dispatchSubscribe(this.gatewaySocket.getStreamDelete(), "streamStreamDelete", new C649160());
        dispatchSubscribe(this.gatewaySocket.getStreamServerUpdate(), "streamStreamServerUpdate", new C649261(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionCreate(), "interactionCreate", new C649362(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionSuccess(), "interactionSuccess", new C649463(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionFailure(), "interactionFailure", new C649564(this));
        dispatchSubscribe(this.gatewaySocket.getInteractionModalCreate(), "interactionModalCreate", new C649665(this));
        dispatchSubscribe(this.gatewaySocket.getApplicationCommandAutocompleteResult(), "applicationCommandAutocompleteResult", new C649766(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceCreate(), "stageInstanceCreate", new C649867(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceUpdate(), "stageInstanceUpdate", new C649968(this));
        dispatchSubscribe(this.gatewaySocket.getStageInstanceDelete(), "stageInstanceDelete", new C650069(this));
        dispatchSubscribe(this.gatewaySocket.getFriendSuggestionCreate(), "friendSuggestionCreate", new C650270(this));
        dispatchSubscribe(this.gatewaySocket.getFriendSuggestionDelete(), "friendSuggestionDelete", new C650371(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventCreate(), "guildScheduledEventCreate", new C650472(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUpdate(), "guildScheduledEventUpdate", new C650573(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventDelete(), "guildScheduledEventDelete", new C650674(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUserAdd(), "guildScheduledEventUserAdd", new C650775(this));
        dispatchSubscribe(this.gatewaySocket.getGuildScheduledEventUserRemove(), "guildScheduledEventUserRemove", new C650876(this));
        dispatchSubscribe(this.gatewaySocket.getEmbeddedActivityInboundUpdate(), "embeddedActivityInboundUpdate", new C650977(this));
        dispatchSubscribe(this.gatewaySocket.getForumUnreads(), "forumUnreads", new C651078(this));
    }

    private final void maybeLogNotificationPermissionStatus(Application context, Clock clock) {
        SharedPreferences sharedPreferences = SharedPreferencesProvider.INSTANCE.get();
        long jCurrentTimeMillis = clock.currentTimeMillis();
        if (jCurrentTimeMillis - sharedPreferences.getLong(LAST_LOGGED_NOTIFICATION_PERMISSIONS_KEY, 0L) > DAY_IN_MILLS) {
            Observable<NotificationClient.SettingsV2> observableM11100Z = this.notifications.getSettings().m11100Z(1);
            C12238m.checkNotNullExpressionValue(observableM11100Z, "notifications.getSettings().take(1)");
            ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) StoreStream.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65131(sharedPreferences, jCurrentTimeMillis, context));
        }
    }

    @StoreThread
    private final void processMessageUsers(Message message) {
        synthesizeGuildMemberAdd(message.getGuildId(), message.getAuthor(), message.getMember());
        List<User> listM8047t = message.m8047t();
        if (listM8047t != null) {
            for (User user : listM8047t) {
                synthesizeGuildMemberAdd(message.getGuildId(), user, user.getMember());
            }
        }
    }

    private final void startStoreInitializationTimer(NetworkMonitor networkMonitor) {
        Observable observableM11100Z = Observable.m11064I(networkMonitor.observeIsConnected().m11118y(new InterfaceC12589b<Boolean, Boolean>() { // from class: com.discord.stores.StoreStream$startStoreInitializationTimer$isOfflineObservable$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Boolean bool) {
                return Boolean.valueOf(!bool.booleanValue());
            }
        }), Observable.m11068d0(6000L, TimeUnit.MILLISECONDS)).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "Observable.merge(\n      …le\n    )\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) StoreStream.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C65141());
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
        C12238m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        this.applicationCommands.handleApplicationCommandAutocompleteResult(interactionStateUpdate);
    }

    @StoreThread
    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        this.videoStreams.handleApplicationStreamUpdate(userId, streamId);
        this.connectionTimeStats.handleApplicationStreamUpdate(userId, streamId);
    }

    @StoreThread
    public final void handleApplicationStreamVideoMetadataUpdate(VideoMetadata metadata) {
        C12238m.checkNotNullParameter(metadata, "metadata");
        this.videoStreams.handleApplicationStreamVideoMetadataUpdate(metadata);
    }

    @StoreThread
    public final void handleFriendSuggestionCreate(FriendSuggestion friendSuggestionCreate) {
        C12238m.checkNotNullParameter(friendSuggestionCreate, "friendSuggestionCreate");
        this.friendSuggestions.handleFriendSuggestionCreate(friendSuggestionCreate);
        this.users.handleFriendSuggestionCreate(friendSuggestionCreate);
    }

    @StoreThread
    public final void handleFriendSuggestionDelete(FriendSuggestionDelete friendSuggestionDelete) {
        C12238m.checkNotNullParameter(friendSuggestionDelete, "friendSuggestionDelete");
        this.friendSuggestions.handleFriendSuggestionDelete(friendSuggestionDelete);
    }

    @StoreThread
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> friendSuggestions) {
        C12238m.checkNotNullParameter(friendSuggestions, "friendSuggestions");
        this.friendSuggestions.handleFriendSuggestionsLoaded(friendSuggestions);
        this.users.handleFriendSuggestionsLoaded(friendSuggestions);
    }

    @StoreThread
    public final void handleGuildJoinRequestCreateOrUpdate(GuildJoinRequestCreateOrUpdate update) {
        C12238m.checkNotNullParameter(update, "update");
        this.guildJoinRequests.handleGuildJoinRequestCreateOrUpdate(update.getGuildId(), update.getRequest());
    }

    @StoreThread
    public final void handleGuildJoinRequestDelete(GuildJoinRequestDelete update) {
        C12238m.checkNotNullParameter(update, "update");
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
    public final void handleHomeTabSelected(StoreNavigation.PanelAction panelAction) {
        C12238m.checkNotNullParameter(panelAction, "panelAction");
        this.navigation.handleHomeTabSelected(panelAction);
    }

    @StoreThread
    public final void handleInteractionFailure(InteractionStateUpdate interactionStateUpdate) {
        C12238m.checkNotNullParameter(interactionStateUpdate, "interactionStateUpdate");
        this.applicationInteractions.handleInteractionFailure(interactionStateUpdate);
        this.messages.handleInteractionFailure(interactionStateUpdate);
    }

    @StoreThread
    public final void handleInteractionModalCreate(InteractionModalCreate interactionModalCreate) {
        C12238m.checkNotNullParameter(interactionModalCreate, "interactionModalCreate");
        this.applicationInteractions.handleInteractionModalCreate(interactionModalCreate);
        this.messages.handleInteractionModalCreate(interactionModalCreate);
    }

    @StoreThread
    public final void handleIsScreenSharingChanged(boolean isScreenSharing) {
        this.analytics.handleIsScreenSharingChanged(isScreenSharing);
    }

    @StoreThread
    public final void handleLocalMessageDelete(com.discord.models.message.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        this.applicationInteractions.handleLocalMessageDelete(message);
    }

    @StoreThread
    public final void handleLoginResult(ModelLoginResult loginResult) {
        C12238m.checkNotNullParameter(loginResult, "loginResult");
        this.authentication.handleLoginResult(loginResult);
        this.userSettingsSystem.handleLoginResult(loginResult);
    }

    @StoreThread
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        C12238m.checkNotNullParameter(relationship, "relationship");
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
        C12238m.checkNotNullParameter(searchState, "searchState");
        this.channels.handleSearchFinish(searchState);
        this.permissions.handleSearchFinish(searchState);
        this.threadsJoined.handleSearchFinish(searchState);
    }

    @StoreThread
    public final void handleStageInstanceCreate(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceCreate(stageInstance);
        this.stageSelfPresence.handleStageInstanceCreate();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @StoreThread
    public final void handleStageInstanceDelete(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
        this.stageInstances.handleStageInstanceDelete(stageInstance);
        this.stageSelfPresence.handleStageInstanceDelete();
        this.permissions.handleStageInstanceChange(stageInstance);
    }

    @StoreThread
    public final void handleStageInstanceUpdate(StageInstance stageInstance) {
        C12238m.checkNotNullParameter(stageInstance, "stageInstance");
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
        C12238m.checkNotNullParameter(streamDelete, "streamDelete");
        this.streamRtcConnection.handleStreamDelete();
        this.applicationStreaming.handleStreamDelete(streamDelete);
        if (isLocal) {
            this.gatewaySocket.streamDelete(streamDelete.getStreamKey());
        }
    }

    @StoreThread
    public final void handleStreamRtcConnectionStateChange(RtcConnection.StateChange stateChange) {
        C12238m.checkNotNullParameter(stateChange, "stateChange");
        this.gatewaySocket.handleRtcConnectionStateChanged(stateChange);
        this.streamRtcConnection.handleStreamRtcConnectionStateChange(stateChange.state);
    }

    @StoreThread
    public final void handleStreamTargeted(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        this.applicationStreaming.handleStreamTargeted(streamKey);
        this.voiceChannelSelected.handleStreamTargeted(streamKey);
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
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
        C12238m.checkNotNullParameter(accounts, "accounts");
        this.userConnections.handleUserConnections(accounts);
        this.spotify.handleUserConnections(accounts);
    }

    @StoreThread
    public final void handleUserProfile(UserProfile userProfileInstance, Long guildId) {
        GuildMember guildMemberM8307c;
        C12238m.checkNotNullParameter(userProfileInstance, "userProfileInstance");
        this.userProfile.handleUserProfile(userProfileInstance);
        if (guildId == null || (guildMemberM8307c = userProfileInstance.getGuildMember()) == null) {
            return;
        }
        this.guilds.handleGuildMember(GuildMember.m7915a(guildMemberM8307c, guildId.longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), guildId.longValue(), true);
    }

    @StoreThread
    public final void handleVideoInputDeviceSelected(VideoInputDeviceDescription selectedVideoInputDevice) {
        this.analytics.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    @StoreThread
    public final void handleVideoMetadataUpdate(VideoMetadata metadata) {
        C12238m.checkNotNullParameter(metadata, "metadata");
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
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        this.gatewaySocket.streamCreate(streamKey, preferredRegion);
        this.applicationStreaming.handleStreamCreateRequest(streamKey);
    }

    @StoreThread
    public final void streamWatch(String streamKey) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        this.gatewaySocket.streamWatch(streamKey);
        this.applicationStreaming.handleStreamWatch(streamKey);
        this.connectionTimeStats.handleStreamWatch(streamKey);
    }

    private final <T> void dispatchSubscribe(Batched<T> batched, String str, Function1<? super T, Unit> function1) {
        dispatchSubscribe(batched.observe(), str, new C64342(function1));
    }

    @StoreThread
    private final void synthesizeGuildMemberAdd(Long guildId, User user, GuildMember member) {
        synthesizeGuildMemberAdd(guildId, user, member != null ? member.m7926l() : null, member != null ? member.getNick() : null, member != null ? member.getPremiumSince() : null, member != null ? Boolean.valueOf(member.getPending()) : null, member != null ? member.getAvatar() : null, member != null ? member.getJoinedAt() : null, member != null ? member.getCommunicationDisabledUntil() : null);
    }
}
