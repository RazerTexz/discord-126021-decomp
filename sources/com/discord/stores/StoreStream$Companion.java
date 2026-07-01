package com.discord.stores;

import android.app.Application;
import com.discord.utilities.rest.RestAPI$AppHeadersProvider;
import com.discord.utilities.textprocessing.Rules;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion {
    private StoreStream$Companion() {
    }

    public static final /* synthetic */ StoreStream access$getCollector$p(StoreStream$Companion storeStream$Companion) {
        return storeStream$Companion.getCollector();
    }

    private final StoreStream getCollector() {
        Lazy lazyAccess$getCollector$cp = StoreStream.access$getCollector$cp();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return (StoreStream) lazyAccess$getCollector$cp.getValue();
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
        return StoreStream.access$getCustomEmojis$p(getCollector());
    }

    public final StoreDirectories getDirectories() {
        return getCollector().getDirectories();
    }

    public final Dispatcher getDispatcherYesThisIsIntentional() {
        return StoreStream.access$getDispatcher$p(getCollector());
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
        return StoreStream.access$getSTORE_THREAD_ID$cp();
    }

    public final String getSTORE_THREAD_NAME() {
        return StoreStream.access$getSTORE_THREAD_NAME$cp();
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
        return StoreStream.access$getStreamRtcConnection$p(getCollector());
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
        m.checkNotNullParameter(application, "application");
        if (StoreStream.access$isInitialized$cp()) {
            return;
        }
        Rules.setEmojiDataProvider(getCollector().getEmojis());
        StoreStream.access$init(getCollector(), application);
        RestAPI$AppHeadersProvider.authTokenProvider = StoreStream$Companion$initialize$1.INSTANCE;
        RestAPI$AppHeadersProvider.fingerprintProvider = StoreStream$Companion$initialize$2.INSTANCE;
        RestAPI$AppHeadersProvider.localeProvider = StoreStream$Companion$initialize$3.INSTANCE;
        StoreStream.access$deferredInit(getCollector(), application);
        StoreStream.access$setInitialized$cp(true);
    }

    public final Observable<Boolean> isInitializedObservable() {
        BehaviorSubject behaviorSubjectAccess$getInitialized$p = StoreStream.access$getInitialized$p(StoreStream.Companion.getCollector());
        m.checkNotNullExpressionValue(behaviorSubjectAccess$getInitialized$p, "collector.initialized");
        return behaviorSubjectAccess$getInitialized$p;
    }

    public final void setSTORE_THREAD_ID(long j) {
        StoreStream.access$setSTORE_THREAD_ID$cp(j);
    }

    public /* synthetic */ StoreStream$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
