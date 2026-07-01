package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.ActivityActionConfirmation;
import com.discord.api.activity.ActivityMetadata;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationAsset;
import com.discord.api.auth.RegisterResponse;
import com.discord.api.auth.mfa.DisableMfaRequestBody;
import com.discord.api.auth.mfa.DisableMfaResponse;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.api.auth.mfa.GetBackupCodesRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesResponse;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyResponse;
import com.discord.api.auth.mfa.GetBackupCodesVerificationRequestBody;
import com.discord.api.bugreport.BugReportConfig;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommand;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.fingerprint.FingerprintResponse;
import com.discord.api.forum.ForumPostFirstMessages;
import com.discord.api.friendsuggestions.BulkAddFriendsResponse;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.guild.Guild;
import com.discord.api.guild.PruneCountResponse;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.PayoutGroup;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.api.guildscheduledevent.GuildScheduledEventMeUser;
import com.discord.api.handoff.CreateHandoffTokenRequest;
import com.discord.api.handoff.HandoffToken;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.api.message.Message;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.ReportReason;
import com.discord.api.report.ReportSubmissionBody;
import com.discord.api.role.GuildRole;
import com.discord.api.science.Science;
import com.discord.api.stageinstance.RecommendedStageInstance;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.sticker.Sticker;
import com.discord.api.thread.ThreadListing;
import com.discord.api.thread.ThreadMember;
import com.discord.api.user.PatchUserBody;
import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.api.user.UserSurveyFetchResponse;
import com.discord.models.domain.Consents;
import com.discord.models.domain.Harvest;
import com.discord.models.domain.ModelApplicationStreamPreview;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelAuditLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall$Ringable;
import com.discord.models.domain.ModelChannelFollowerStatsDto;
import com.discord.models.domain.ModelConnectionAccessToken;
import com.discord.models.domain.ModelConnectionState;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.models.domain.ModelLocationMetadata;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.models.domain.ModelUrl;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.models.domain.PatchPaymentSourceRaw;
import com.discord.models.domain.PaymentSourceRaw;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.models.experiments.dto.UnauthenticatedUserExperimentsDto;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.auth.GoogleSmartLockManager;
import i0.f0.a;
import i0.f0.b;
import i0.f0.f;
import i0.f0.h;
import i0.f0.i;
import i0.f0.l;
import i0.f0.n;
import i0.f0.o;
import i0.f0.p;
import i0.f0.q;
import i0.f0.s;
import i0.f0.t;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import okhttp3.MultipartBody$Part;
import retrofit2.Response;
import rx.Observable;

/* JADX INFO: compiled from: RestAPIInterface.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestAPIInterface {
    public static final RestAPIInterface$Companion Companion = RestAPIInterface$Companion.$$INSTANCE;

    @o("guilds/{guildId}/creator-monetization/{requestId}/accept-terms")
    Observable<CreatorMonetizationEnableRequest> acceptCreatorMonetizationTerms(@s("guildId") long guildId, @s("requestId") long requestId);

    @o("entitlements/gift-codes/{code}/redeem")
    Observable<Void> acceptGift(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code);

    @o("guilds/{guildId}/ack")
    Observable<Void> ackGuild(@s("guildId") long guildId);

    @n("guilds/{guildId}/requests/@me/ack")
    Observable<Void> ackGuildJoinRequest(@s("guildId") long guildId);

    @p("channels/{channelId}/pins/{messageId}")
    Observable<Void> addChannelPin(@s("channelId") long channelId, @s("messageId") long messageId);

    @p("channels/{channelId}/recipients/{recipientId}")
    Observable<Void> addChannelRecipient(@s("channelId") long channelId, @s("recipientId") long recipientId);

    @p("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    Observable<Void> addReaction(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction);

    @p("users/@me/relationships/{userId}")
    Observable<Void> addRelationship(@s("userId") long userId, @a RestAPIParams$UserRelationship relationship, @i("X-Context-Properties") String context);

    @o("channels/{channelId}/directory-entry/{guildId}")
    Observable<Response<DirectoryEntryGuild>> addServerToHub(@s("channelId") long channelId, @s("guildId") long guildId, @a RestAPIParams$AddServerBody body);

    @f("connections/{connection}/authorize")
    Observable<ModelUrl> authorizeConnection(@s("connection") String connection);

    @o("auth/authorize-ip")
    Observable<Response<Void>> authorizeIP(@a RestAPIParams$AuthorizeIP body);

    @p("guilds/{guildId}/bans/{userId}")
    Observable<Void> banGuildMember(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$BanGuildMember body, @i("X-Audit-Log-Reason") String reason);

    @n("guilds/{guildId}/roles")
    Observable<Void> batchUpdateRole(@s("guildId") long guildId, @a List<RestAPIParams$Role> body);

    @o("users/@me/relationships/bulk")
    Observable<Response<BulkAddFriendsResponse>> bulkAddRelationships(@a RestAPIParams$UserBulkRelationship body);

    @f("channels/{channelId}/call")
    Observable<ModelCall$Ringable> call(@s("channelId") long channelId);

    @o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/cancel")
    Observable<ModelGuildBoostSlot> cancelSubscriptionSlot(@s("subscriptionSlotId") long slotId);

    @n("guilds/{guildId}/members/{userId}")
    Observable<Void> changeGuildMember(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$GuildMember body);

    @n("guilds/{guildId}/members/@me/nick")
    Observable<Void> changeGuildNickname(@s("guildId") long guildId, @a RestAPIParams$Nick body);

    @o("outbound-promotions/{promotionId}/claim")
    Observable<ClaimedOutboundPromotion> claimOutboundPromotion(@s("promotionId") long promotionId);

    @o("store/skus/{skuId}/purchase")
    Observable<Unit> claimSku(@s("skuId") long skuId, @a RestAPIParams$EmptyBody emptyBody);

    @p("channels/{channelId}/recipients/{recipientId}")
    Observable<Channel> convertDMToGroup(@s("channelId") long channelId, @s("recipientId") long recipientId);

    @o("channels/{channelId}/followers")
    Observable<Void> createChannelFollower(@s("channelId") long channelId, @a RestAPIParams$ChannelFollowerPost body);

    @p("users/@me/connections/contacts/@me")
    Observable<ConnectedAccount> createConnectionContacts(@a RestAPIParams$ConnectedAccountContacts connectedAccountContacts);

    @o("guilds/{guildId}/creator-monetization/enable-requests")
    Observable<CreatorMonetizationEnableRequest> createCreatorMonetizationEnableRequest(@s("guildId") long guildId);

    @o("guilds")
    Observable<Response<Guild>> createGuild(@a RestAPIParams$CreateGuild body);

    @o("guilds/{guildId}/channels")
    Observable<Response<Channel>> createGuildChannel(@s("guildId") long guildId, @a RestAPIParams$CreateGuildChannel body);

    @o("guilds/templates/{guildTemplateCode}")
    Observable<Guild> createGuildFromTemplate(@s("guildTemplateCode") String guildTemplateCode, @a RestAPIParams$CreateGuildFromTemplate body);

    @p("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> createGuildJoinRequest(@s("guildId") long guildId, @a RestAPIParams$MemberVerificationForm body);

    @o("guilds/{guildId}/role-subscriptions/group-listings")
    Observable<GuildRoleSubscriptionGroupListing> createGuildRoleSubscriptionGroupListing(@s("guildId") long guildId, @a RestAPIParams$CreateGuildRoleSubscriptionGroupListing body);

    @o("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings")
    Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTier(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @a RestAPIParams$CreateGuildRoleSubscriptionTierListing body);

    @o("guilds/{guildId}/scheduled-events")
    Observable<GuildScheduledEvent> createGuildScheduledEvent(@s("guildId") long guildId, @a RestAPIParams$CreateGuildScheduledEventBody event);

    @p("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    Observable<Unit> createGuildScheduledEventRsvp(@s("guildId") long guildId, @s("eventId") long eventId);

    @o("auth/handoff")
    Observable<HandoffToken> createHandoffToken(@a CreateHandoffTokenRequest body);

    @o("google-play/purchase-metadata")
    Observable<Unit> createPurchaseMetadata(@a RestAPIParams$PurchaseMetadataBody purchaseMetadataBody);

    @o("guilds/{guildId}/roles")
    Observable<GuildRole> createRole(@s("guildId") long guildId);

    @o("channels/{channelId}/threads")
    Observable<Channel> createThread(@s("channelId") long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @a RestAPIParams$ThreadCreationSettings body);

    @o("channels/{channelId}/messages/{messageId}/threads")
    Observable<Channel> createThreadFromMessage(@s("channelId") long channelId, @s("messageId") long messageId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @a RestAPIParams$ThreadCreationSettings body);

    @o("channels/{channelId}/threads?has_message=true")
    @l
    Observable<Channel> createThreadWithMessage(@s("channelId") long channelId, @q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @q("content") String content, @q("applied_tags") List<Long> appliedTags, @q("sticker_ids") List<Long> stickerIds, @q("type") int type, @q(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION) Integer autoArchiveDuration, @q MultipartBody$Part[] files);

    @o("channels/{channelId}/messages/{messageId}/crosspost")
    Observable<Void> crosspostMessage(@s("channelId") long channelId, @s("messageId") Long messageId);

    @o("users/@me/delete")
    Observable<Void> deleteAccount(@a RestAPIParams$DisableAccount body);

    @b("channels/{channelId}")
    Observable<Channel> deleteChannel(@s("channelId") long channelId);

    @b("channels/{channelId}/pins/{messageId}")
    Observable<Void> deleteChannelPin(@s("channelId") long channelId, @s("messageId") long messageId);

    @b("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<Void>> deleteConnection(@s("connection") String connection, @s("connectionId") String connectionId);

    @o("guilds/{guildId}/delete")
    Observable<Void> deleteGuild(@s("guildId") long guildId, @a RestAPIParams$DeleteGuild body);

    @b("guilds/{guildId}/emojis/{emojiId}")
    Observable<Void> deleteGuildEmoji(@s("guildId") long guildId, @s("emojiId") long emojiId);

    @b("guilds/{guildId}/integrations/{integrationId}")
    Observable<Void> deleteGuildIntegration(@s("guildId") long guildId, @s("integrationId") long integrationId);

    @b("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> deleteGuildJoinRequest(@s("guildId") long guildId);

    @b("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    Observable<Void> deleteGuildRoleSubscriptionTierListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @s("listingId") long tierListingId);

    @b("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<Void> deleteGuildScheduledEvent(@s("guildId") long guildId, @s("eventId") long eventId);

    @b("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    Observable<Void> deleteGuildScheduledEventRsvp(@s("guildId") long guildId, @s("eventId") long eventId);

    @b("channels/{channel_id}/messages/{message_id}")
    Observable<Void> deleteMessage(@s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @s("message_id") long messageId);

    @b("oauth2/tokens/{oauthId}")
    Observable<Void> deleteOAuthToken(@s("oauthId") long oauthId);

    @b("users/@me/billing/payment-sources/{paymentSourceId}")
    Observable<Void> deletePaymentSource(@s("paymentSourceId") String paymentSourceId);

    @b("channels/{channelId}/permissions/{targetId}")
    Observable<Void> deletePermissionOverwrites(@s("channelId") long channelId, @s("targetId") long targetId);

    @b("guilds/{guildId}/roles/{roleId}")
    Observable<Void> deleteRole(@s("guildId") long guildId, @s("roleId") long roleId);

    @b("users/@me/billing/subscriptions/{subscriptionId}")
    Observable<Void> deleteSubscription(@s("subscriptionId") String subscriptionId);

    @o("users/@me/disable")
    Observable<Void> disableAccount(@a RestAPIParams$DisableAccount body);

    @n("guilds/{guildId}/members/{userId}")
    Observable<Response<Void>> disableGuildCommunication(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$DisableGuildCommunication body, @i("X-Audit-Log-Reason") String reason);

    @o("users/@me/mfa/totp/disable")
    Observable<DisableMfaResponse> disableMFA(@a DisableMfaRequestBody body);

    @o("users/@me/mfa/sms/disable")
    Observable<Void> disableMfaSMS(@a RestAPIParams$ActivateMfaSMS body);

    @n("guilds/{guildId}/members/{userId}")
    Observable<Void> disconnectGuildMember(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$GuildMemberDisconnect body);

    @o("google-play/downgrade-subscription")
    Observable<Object> downgradeSubscription(@a RestAPIParams$DowngradeSubscriptionBody downgradeSubscriptionBody);

    @n("channels/{channelId}")
    Observable<Channel> editGroupDM(@s("channelId") long channelId, @a RestAPIParams$GroupDM body);

    @n("channels/{channel_id}/messages/{message_id}")
    Observable<Message> editMessage(@s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @s("message_id") long messageId, @a RestAPIParams$Message message);

    @n("channels/{channelId}")
    Observable<Channel> editTextChannel(@s("channelId") long channelId, @a RestAPIParams$TextChannel body);

    @n("channels/{channelId}")
    Observable<Channel> editThread(@s("channelId") long channelId, @a RestAPIParams$ThreadSettings body);

    @n("channels/{channelId}")
    Observable<Channel> editTopicalChannel(@s("channelId") long channelId, @a RestAPIParams$TopicalChannel body);

    @n("channels/{channelId}")
    Observable<Channel> editVoiceChannel(@s("channelId") long channelId, @a RestAPIParams$VoiceChannel body);

    @o("guilds/{guildId}/integrations")
    Observable<Void> enableIntegration(@s("guildId") long guildId, @a RestAPIParams$EnableIntegration body);

    @o("users/@me/mfa/totp/enable")
    Observable<EnableMfaResponse> enableMFA(@a RestAPIParams$EnableMFA body);

    @o("users/@me/mfa/sms/enable")
    Observable<Void> enableMfaSMS(@a RestAPIParams$ActivateMfaSMS body);

    @b("stage-instances/{channelId}")
    Observable<Unit> endStageInstance(@s("channelId") long channelId);

    @o("auth/forgot")
    Observable<Response<Void>> forgotPassword(@a RestAPIParams$ForgotPassword body);

    @o("users/@me/entitlements/gift-codes")
    Observable<ModelGift> generateGiftCode(@a RestAPIParams$GenerateGiftCode body);

    @f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/metadata")
    Observable<ActivityMetadata> getActivityMetadata(@s("userId") long userId, @s("sessionId") String sessionId, @s("applicationId") long applicationId);

    @f("outbound-promotions")
    Observable<List<OutboundPromotion>> getAllActiveOutboundPromotions();

    @f("outbound-promotions/preview")
    Observable<List<OutboundPromotion>> getAllPreviewPromotions();

    @f("channels/{channelId}/threads/archived/private")
    Observable<ThreadListing> getAllPrivateArchivedThreads(@s("channelId") long channelId, @t("before") String before);

    @f("channels/{channelId}/threads/archived/public")
    Observable<ThreadListing> getAllPublicArchivedThreads(@s("channelId") long channelId, @t("before") String before);

    @f("oauth2/applications/{applicationId}/assets")
    Observable<List<ApplicationAsset>> getApplicationAssets(@s("applicationId") long applicationId);

    @f("applications/{botId}/commands")
    Observable<List<ApplicationCommand>> getApplicationCommands(@s("botId") long botId);

    @f("applications/public")
    Observable<List<Application>> getApplications(@t("application_ids") long appIds);

    @f("guilds/{guildId}/audit-logs")
    Observable<ModelAuditLog> getAuditLogs(@s("guildId") long guildId, @t("limit") int limit, @t("before") Long before, @t("user_id") Long userId, @t("action_type") Integer actionType);

    @o("users/@me/mfa/codes")
    Observable<GetBackupCodesResponse> getBackupCodes(@a GetBackupCodesRequestBody body);

    @o("auth/verify/view-backup-codes-challenge")
    Observable<GetBackupCodesSendVerificationKeyResponse> getBackupCodesSendVerificationKey(@a GetBackupCodesSendVerificationKeyRequestBody body);

    @o("users/@me/mfa/codes-verification")
    Observable<GetBackupCodesResponse> getBackupCodesVerification(@a GetBackupCodesVerificationRequestBody body);

    @f("guilds/{guildId}/bans")
    Observable<List<ModelBan>> getBans(@s("guildId") long guildId);

    @f("private/bug-reports")
    Observable<BugReportConfig> getBugReportConfig();

    @f("channels/{channelId}")
    Observable<Channel> getChannel(@s("channelId") long channelId);

    @f("channels/{channelId}/follower-stats")
    Observable<ModelChannelFollowerStatsDto> getChannelFollowerStats(@s("channelId") long channelId);

    @f("channels/{channelId}/messages")
    Observable<List<Message>> getChannelMessages(@s("channelId") long channelId, @t("before") Long before, @t("after") Long after, @t("limit") Integer limit);

    @f("channels/{channelId}/messages")
    Observable<List<Message>> getChannelMessagesAround(@s("channelId") long channelId, @t("limit") int limit, @t("around") long around);

    @f("channels/{channelId}/pins")
    Observable<List<Message>> getChannelPins(@s("channelId") long channelId);

    @f("users/@me/outbound-promotions/codes")
    Observable<List<ClaimedOutboundPromotion>> getClaimedOutboundPromotions();

    @f("users/@me/connections/{platformType}/{accountId}/access-token")
    Observable<ModelConnectionAccessToken> getConnectionAccessToken(@s("platformType") String platformType, @s("accountId") String accountId);

    @f("connections/{connection}/callback-continuation/{pinNumber}")
    Observable<ModelConnectionState> getConnectionState(@s("connection") String connection, @s("pinNumber") String pinNumber);

    @f("users/@me/connections")
    Observable<List<ConnectedAccount>> getConnections();

    @f("users/@me/consent")
    Observable<Consents> getConsents();

    @f("guilds/{guildId}/creator-monetization/requirements")
    Observable<CreatorMonetizationEligibilityRequirements> getCreatorMonetizationEligibilityRequirements(@s("guildId") long guildId);

    @f("channels/{channelId}/directory-entries")
    Observable<List<DirectoryEntryGuild>> getDirectoryEntries(@s("channelId") long channelId);

    @f("guilds/{guildId}/directory-entries/broadcast")
    Observable<GuildScheduledEventBroadcast> getDirectoryEntryBroadcastInfo(@s("guildId") long guildId, @t("entity_id") Long entityId, @t("type") int type);

    @f("channels/{channelId}/directory-entries")
    Observable<List<DirectoryEntryEvent>> getDirectoryGuildScheduledEvents(@s("channelId") long channelId, @t("type") int type);

    @f("emojis/{emojiId}/guild")
    Observable<Guild> getEmojiGuild(@s("emojiId") long emojiId);

    @f("channels/{channelId}/directory-entries/counts")
    Observable<Map<Integer, Integer>> getEntryCounts(@s("channelId") long channelId);

    @f("experiments")
    Observable<UnauthenticatedUserExperimentsDto> getExperiments();

    @o("channels/{channelId}/post-data")
    Observable<ForumPostFirstMessages> getForumPostData(@s("channelId") long channelId, @a RestAPIParams$GetForumPostData body);

    @f("friend-suggestions")
    Observable<List<FriendSuggestion>> getFriendSuggestions();

    @f("gifs/search")
    Observable<List<GifDto>> getGifSearchResults(@t("q") String query, @t("provider") String provider, @t("locale") String locale, @t("media_format") String mediaFormat, @t("limit") int limit);

    @f("gifs/suggest")
    Observable<List<String>> getGifSuggestedSearchTerms(@t("provider") String provider, @t("q") String query, @t("locale") String locale, @t("limit") int limit);

    @f("gifs/trending-search")
    Observable<List<String>> getGifTrendingSearchTerms(@t("provider") String provider, @t("locale") String locale, @t("limit") int limit);

    @f("users/@me/entitlements/gifts")
    Observable<List<ModelEntitlement>> getGifts();

    @f("guilds/{guildId}/applications")
    Observable<List<Application>> getGuildApplications(@s("guildId") long guildId, @t("include_team") boolean includeTeam);

    @f("guilds/{guildId}/emojis")
    Observable<List<ModelEmojiGuild>> getGuildEmojis(@s("guildId") long guildId);

    @f("guilds/{guildId}/integrations")
    Observable<List<ModelGuildIntegration>> getGuildIntegrations(@s("guildId") long guildId);

    @f("guilds/{guildId}/invites")
    Observable<List<ModelInvite>> getGuildInvites(@s("guildId") long guildId);

    @f("guilds/{guildId}/member-verification")
    Observable<ModelMemberVerificationForm> getGuildMemberVerificationForm(@s("guildId") long guildId);

    @f("guilds/{guildId}/preview")
    Observable<GuildPreview> getGuildPreview(@s("guildId") long guildId);

    @f("guilds/{guildId}/roles/member-counts")
    Observable<Map<Long, Integer>> getGuildRoleMemberCounts(@s("guildId") long guildId);

    @f("guilds/{guildId}/roles/{roleId}/member-ids")
    Observable<List<Long>> getGuildRoleMemberIds(@s("guildId") long guildId, @s("roleId") long roleId);

    @f("guilds/{guildId}/role-subscriptions/trials")
    Observable<List<GuildRoleSubscriptionTierFreeTrial>> getGuildRoleSubscriptionFreeTrials(@s("guildId") long guildId);

    @f("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    Observable<GuildRoleSubscriptionGroupListing> getGuildRoleSubscriptionGroupListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId);

    @f("guilds/{guildId}/role-subscriptions/group-listings")
    Observable<List<GuildRoleSubscriptionGroupListing>> getGuildRoleSubscriptionGroupListings(@s("guildId") long guildId);

    @f("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<GuildScheduledEvent> getGuildScheduledEvent(@s("guildId") long guildId, @s("eventId") long eventId);

    @f("guilds/{guildId}/scheduled-events/{eventId}/users")
    Observable<List<ApiGuildScheduledEventUser>> getGuildScheduledEventUsers(@s("guildId") long guildId, @s("eventId") long eventId, @t("limit") int limit, @t("with_member") boolean withMember, @t("upgrade_response_type") boolean upgradeResponseType);

    @f("guilds/{guildId}/scheduled-events")
    Observable<List<GuildScheduledEvent>> getGuildScheduledEvents(@s("guildId") long guildId, @t("with_user_count") boolean withUserCount);

    @f("guilds/templates/{guildTemplateCode}")
    Observable<ModelGuildTemplate> getGuildTemplateCode(@s("guildTemplateCode") String guildTemplateCode);

    @f("guilds/{guildId}/regions")
    Observable<List<ModelVoiceRegion>> getGuildVoiceRegions(@s("guildId") long guildId);

    @f("guilds/{guildId}/welcome-screen")
    Observable<GuildWelcomeScreen> getGuildWelcomeScreen(@s("guildId") long guildId);

    @f("users/@me/harvest")
    Observable<Harvest> getHarvestStatus();

    @f("channels/{channelId}/messages/{messageId}/interaction-data")
    Observable<ApplicationCommandData> getInteractionData(@s("channelId") long channelId, @s("messageId") long messageId);

    @f("invites/{code}")
    Observable<Response<ModelInvite>> getInviteCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @t("with_counts") boolean withCounts, @t("guild_scheduled_event_id") Long guildScheduledEventId);

    @o("users/@me/billing/invoices/preview")
    Observable<ModelInvoicePreview> getInvoicePreview(@a RestAPIParams$InvoicePreviewBody invoicePreviewBody);

    @f("users/@me/library")
    Observable<List<ModelLibraryApplication>> getLibrary();

    @f("auth/location-metadata")
    Observable<ModelLocationMetadata> getLocationMetadata();

    @f("users/@me/scheduled-events")
    Observable<List<GuildScheduledEventMeUser>> getMeGuildScheduledEvents(@t("guild_ids") long guildIds);

    @f("users/@me/mentions")
    Observable<List<Message>> getMentions(@t("limit") int limit, @t("roles") boolean roles, @t(ModelGuildMemberListUpdate.EVERYONE_ID) boolean everyone, @t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @t("before") Long before);

    @f("users/@me/applications/{applicationId}/entitlements")
    Observable<List<ModelEntitlement>> getMyEntitlements(@s("applicationId") long applicationId, @t("exclude_consumed") boolean excludeConsumed);

    @f("channels/{channelId}/users/@me/threads/archived/private")
    Observable<ThreadListing> getMyPrivateArchivedThreads(@s("channelId") long channelId, @t("before") Long before);

    @f("oauth2/tokens")
    Observable<List<ModelOAuth2Token>> getOAuthTokens();

    @f("oauth2/authorize")
    Observable<RestAPIParams$OAuth2Authorize$ResponseGet> getOauth2Authorize(@t("client_id") String clientId, @t("state") String state, @t("response_type") String responseType, @t("redirect_uri") String redirectUrl, @t("prompt") String prompt, @t("scope") String scope, @t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions);

    @f("oauth2/samsung/authorize")
    Observable<Void> getOauth2SamsungAuthorize(@t("client_id") String clientId, @t("state") String state, @t("response_type") String responseType, @t("redirect_uri") String redirectUrl, @t("prompt") String prompt, @t("scope") String scope);

    @f("applications/{applicationId}/payment-payout-groups")
    Observable<List<PayoutGroup>> getPaymentPayoutGroups(@s("applicationId") long applicationId);

    @f("users/@me/billing/payment-sources")
    Observable<List<PaymentSourceRaw>> getPaymentSources();

    @f("store/price-tiers")
    Observable<List<Integer>> getPriceTiers(@t("price_tier_type") int priceTierType);

    @f("guilds/{guildId}/prune")
    Observable<PruneCountResponse> getPruneCount(@s("guildId") long guildId, @t("days") int days);

    @f("channels/{channelId}/messages/{messageId}/reactions/{emoji}")
    Observable<List<User>> getReactionUsers(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "emoji") String emoji, @t("limit") Integer limit);

    @f("stage-instances")
    Observable<Response<List<RecommendedStageInstance>>> getRecommendedStageInstances();

    @f("users/{userId}/relationships")
    Observable<List<ModelUserRelationship>> getRelationships(@s("userId") long userId);

    @f("reporting/menu/{reportType}")
    Observable<MenuAPIResponse> getReportMenu(@s("reportType") String reportType);

    @f("tracks/{id}")
    Observable<ModelSpotifyTrack> getSpotifyTrack(@s(ModelAuditLogEntry.CHANGE_KEY_ID) String id2);

    @f("stage-instances/extra")
    Observable<List<RecommendedStageInstance>> getStageInstancesForChannels(@t("channel_ids") Set<Long> channelIds);

    @f("stickers/{stickerId}")
    Observable<Sticker> getSticker(@s("stickerId") long stickerId);

    @f("stickers/{stickerId}/guild")
    Observable<Guild> getStickerGuild(@s("stickerId") long stickerId);

    @f("sticker-packs/{packId}")
    Observable<ModelStickerPack> getStickerPack(@s("packId") long packId);

    @f("sticker-packs")
    Observable<ModelStickerStoreDirectory> getStickerPacks();

    @f("streams/{streamKey}/preview")
    Observable<ModelApplicationStreamPreview> getStreamPreview(@s("streamKey") String streamKey, @t("version") long version);

    @f("users/@me/guilds/premium/subscription-slots")
    Observable<List<ModelGuildBoostSlot>> getSubscriptionSlots();

    @f("users/@me/billing/subscriptions")
    Observable<List<ModelSubscription>> getSubscriptions();

    @f("gifs/trending")
    Observable<TrendingGifCategoriesResponseDto> getTrendingGifCategories(@t("provider") String provider, @t("locale") String locale, @t("media_format") String mediaFormat);

    @f("gifs/trending-gifs")
    Observable<List<GifDto>> getTrendingGifCategory(@t("provider") String provider, @t("locale") String locale, @t("media_format") String mediaFormat, @t("limit") int limit);

    @f("users/@me/affinities/users")
    Observable<ModelUserAffinities> getUserAffinities();

    @f("users/@me/join-request-guilds")
    Observable<List<Guild>> getUserJoinRequestGuilds();

    @f("users/@me/notes/{userId}")
    Observable<ModelUserNote> getUserNote(@s("userId") long userId);

    @f("users/@me/survey")
    Observable<Response<UserSurveyFetchResponse>> getUserSurvey();

    @f("guilds/{guildId}/vanity-url")
    Observable<VanityUrlResponse> getVanityUrl(@s("guildId") long guildId);

    @b("friend-suggestions/{userId}")
    Observable<Void> ignoreFriendSuggestion(@s("userId") long userId);

    @p("guilds/{guildId}/members/@me")
    Observable<Guild> joinGuild(@s("guildId") long guildId, @t("lurker") boolean isLurker, @t("session_id") String sessionId, @t("directory_channel_id") Long directoryChannelId, @a RestAPIParams$InviteCode body, @i("X-Context-Properties") String context);

    @o("integrations/{integrationId}/join")
    Observable<Void> joinGuildFromIntegration(@s("integrationId") String integrationId);

    @o("hub-waitlist/signup")
    Observable<WaitlistSignup> joinHubWaitlist(@a RestAPIParams$HubWaitlist body);

    @o("channels/{channelId}/thread-members/@me")
    Observable<Void> joinThread(@s("channelId") long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @a RestAPIParams$EmptyBody body);

    @b("guilds/{guildId}/members/{userId}")
    Observable<Void> kickGuildMember(@s("guildId") long guildId, @s("userId") long userId, @i("X-Audit-Log-Reason") String reason);

    @b("users/@me/guilds/{guildId}")
    Observable<Void> leaveGuild(@s("guildId") long guildId);

    @h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/guilds/{guildId}")
    Observable<Void> leaveGuild(@s("guildId") long guildId, @a RestAPIParams$LeaveGuildBody leaveGuildBody);

    @b("channels/{channelId}/thread-members/@me")
    Observable<Void> leaveThread(@s("channelId") long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location);

    @o("auth/logout")
    Observable<Response<Void>> logout(@a RestAPIParams$UserDevices body);

    @n("channels/{channelId}/directory-entry/{guildId}")
    Observable<DirectoryEntryGuild> modifyServerInHub(@s("channelId") long channelId, @s("guildId") long guildId, @a RestAPIParams$AddServerBody body);

    @n("guilds/{guildId}/emojis/{emojiId}")
    Observable<ModelEmojiGuild> patchGuildEmoji(@s("guildId") long guildId, @s("emojiId") long emojiId, @a RestAPIParams$PatchGuildEmoji body);

    @n("users/@me")
    Observable<User> patchUser(@a PatchUserBody patchUserBody);

    @n("users/@me")
    Observable<User> patchUser(@a RestAPIParams$UserInfo userInfo);

    @o("phone-verifications/resend")
    Observable<Void> phoneVerificationsResend(@a RestAPIParams$VerificationCodeResend body);

    @o("phone-verifications/verify")
    Observable<Response<ModelPhoneVerificationToken>> phoneVerificationsVerify(@a RestAPIParams$VerificationCode body);

    @o("auth/fingerprint")
    Observable<FingerprintResponse> postAuthFingerprint(@a RestAPIParams$EmptyBody body);

    @o("auth/login")
    Observable<Response<ModelLoginResult>> postAuthLogin(@a RestAPIParams$AuthLogin body);

    @o("auth/register")
    Observable<Response<RegisterResponse>> postAuthRegister(@a RestAPIParams$AuthRegister body);

    @o("auth/register/phone")
    Observable<Response<Void>> postAuthRegisterPhone(@a RestAPIParams$AuthRegisterPhone body);

    @o("auth/verify/resend")
    Observable<Response<Void>> postAuthVerifyResend(@a RestAPIParams$EmptyBody body);

    @o("channels/{channelId}/invites")
    Observable<ModelInvite> postChannelInvite(@s("channelId") long channelId, @a RestAPIParams$Invite body);

    @o("channels/{channelId}/messages/{messageId}/ack")
    Observable<Void> postChannelMessagesAck(@s("channelId") long channelId, @s("messageId") Long messageId, @a RestAPIParams$ChannelMessagesAck body);

    @o("guilds/{guildId}/emojis")
    Observable<ModelEmojiGuild> postGuildEmoji(@s("guildId") long guildId, @a RestAPIParams$PostGuildEmoji body);

    @o("guilds/{guildId}/ack/{ackType}/{ackedId}")
    Observable<Void> postGuildFeatureAck(@s("guildId") long channelId, @s("ackType") int ackType, @s("ackedId") long ackedId, @a RestAPIParams$GuildFeatureAck body);

    @o("invites/{code}")
    Observable<ModelInvite> postInviteCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @a RestAPIParams$InviteCode body, @i("X-Context-Properties") String context);

    @o("auth/mfa/totp")
    Observable<Response<ModelLoginResult>> postMFACode(@a RestAPIParams$MFALogin body);

    @o("oauth2/authorize")
    Observable<RestAPIParams$OAuth2Authorize$ResponsePost> postOauth2Authorize(@t("client_id") String clientId, @t("state") String state, @t("response_type") String responseType, @t("redirect_uri") String redirectUrl, @t("prompt") String prompt, @t("scope") String scope, @t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions, @t("code_challenge") String codeChallenge, @t("code_challenge_method") String codeChallengeMethod, @a Map<String, String> body);

    @o("users/@me/remote-auth/cancel")
    Observable<Void> postRemoteAuthCancel(@a RestAPIParams$RemoteAuthCancel body);

    @o("users/@me/remote-auth/finish")
    Observable<Void> postRemoteAuthFinish(@a RestAPIParams$RemoteAuthFinish body);

    @o("users/@me/remote-auth")
    Observable<ModelRemoteAuthHandshake> postRemoteAuthInitialize(@a RestAPIParams$RemoteAuthInitialize body);

    @o("streams/{streamKey}/preview")
    Observable<Void> postStreamPreview(@s("streamKey") String streamKey, @a RestAPIParams$Thumbnail thumbnail);

    @o("guilds/{guildId}/prune")
    Observable<Void> pruneMembers(@s("guildId") long guildId, @a RestAPIParams$PruneGuild body);

    @b("channels/{channelId}/messages/{messageId}/reactions")
    Observable<Void> removeAllReactions(@s("channelId") long channelId, @s("messageId") long messageId);

    @b("channels/{channelId}/recipients/{recipientId}")
    Observable<Void> removeChannelRecipient(@s("channelId") long channelId, @s("recipientId") long recipientId);

    @b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/{userId}")
    Observable<Void> removeReaction(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction, @s("userId") long userId);

    @b("users/@me/relationships/{userId}")
    Observable<Void> removeRelationship(@s("userId") long userId, @i("X-Context-Properties") String context);

    @b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    Observable<Void> removeSelfReaction(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction);

    @b("channels/{channelId}/directory-entry/{guildId}")
    Observable<Response<DirectoryEntryGuild>> removeServerFromHub(@s("channelId") long channelId, @s("guildId") long guildId);

    @n("guilds/{guildId}/channels")
    Observable<Void> reorderChannels(@s("guildId") long guildId, @a List<RestAPIParams$ChannelPosition> body);

    @o("report")
    Observable<Unit> report(@a RestAPIParams$Report body);

    @f("report")
    Observable<List<ReportReason>> report(@t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @t("message_id") Long messageId, @t("user_id") Long userId);

    @o("users/@me/harvest")
    Observable<Harvest> requestHarvest();

    @o("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> resetGuildJoinRequest(@s("guildId") long guildId);

    @f("entitlements/gift-codes/{code}")
    Observable<ModelGift> resolveGiftCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @t("with_application") boolean withApplication, @t("with_subscription_plan") boolean withSubscription);

    @f("users/@me/entitlements/gift-codes")
    Observable<List<ModelGift>> resolveSkuIdGift(@t("sku_id") long skuId, @t("subscription_plan_id") Long subscriptionPlanId);

    @b("users/@me/entitlements/gift-codes/{code}")
    Observable<Void> revokeGiftCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code);

    @b("invites/{inviteCode}")
    Observable<ModelInvite> revokeInvite(@s("inviteCode") String inviteCode);

    @o("channels/{channelId}/call/ring")
    Observable<Void> ring(@s("channelId") long channelId, @a RestAPIParams$Ring body, @i("X-Context-Properties") String context);

    @o("science")
    Observable<Void> science(@a Science body);

    @f("channels/{channelId}/messages/search")
    Observable<ModelSearchResponse> searchChannelMessages(@s("channelId") long channelId, @t("max_id") Long oldestMessageId, @t("author_id") List<String> authorIds, @t("mentions") List<String> mentionsIds, @t("has") List<String> has, @t("content") List<String> content, @t("attempts") Integer attempts, @t("include_nsfw") Boolean includeNsfw);

    @f("guilds/{guildId}/messages/search")
    Observable<ModelSearchResponse> searchGuildMessages(@s("guildId") long guildId, @t("max_id") Long oldestMessageId, @t("author_id") List<String> authorIds, @t("mentions") List<String> mentionsIds, @t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) List<String> inChannelIds, @t("has") List<String> has, @t("content") List<String> content, @t("attempts") Integer attempts, @t("include_nsfw") Boolean includeNsfw);

    @f("channels/{channelId}/directory-entries/search")
    Observable<List<DirectoryEntryGuild>> searchServers(@s("channelId") long channelId, @t("query") String query);

    @o("interactions")
    @l
    Observable<Void> sendApplicationCommand(@q("payload_json") PayloadJSON<RestAPIParams$ApplicationCommand> payloadJson, @q MultipartBody$Part[] files);

    @o("interactions")
    Observable<Void> sendApplicationCommand(@a RestAPIParams$ApplicationCommand body);

    @o("private/bug-reports")
    @l
    Observable<Unit> sendBugReport(@q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @q(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) String description, @q("priority") int priority, @q("asana_inbox_id") Long asanaInboxId, @q MultipartBody$Part screenshot);

    @o("interactions")
    Observable<Void> sendComponentInteraction(@a RestAPIParams$ComponentInteraction body);

    @o("channels/{channelId}/greet")
    Observable<Message> sendGreetMessage(@s("channelId") long channelId, @a RestAPIParams$GreetMessage body);

    @o("channels/{channelId}/messages")
    @l
    Observable<Message> sendMessage(@s("channelId") long channelId, @q("payload_json") PayloadJSON<RestAPIParams$Message> payloadJson, @q MultipartBody$Part[] files);

    @o("channels/{channelId}/messages")
    Observable<Message> sendMessage(@s("channelId") long channelId, @a RestAPIParams$Message message);

    @o("interactions")
    Observable<Void> sendModalInteraction(@a RestAPIParams$ModalInteraction body);

    @o("users/@me/relationships")
    Observable<Void> sendRelationshipRequest(@a RestAPIParams$UserRelationship$Add relationship, @i("X-Context-Properties") String context);

    @o("users/@me/consent")
    Observable<Void> setConsents(@a RestAPIParams$Consents body);

    @o("guilds/{guildId}/mfa")
    Observable<Void> setMfaLevel(@s("guildId") long guildId, @a RestAPIParams$GuildMFA body);

    @o("channels/{channelId}/typing")
    Observable<ModelTypingResponse> setUserTyping(@s("channelId") long channelId, @a RestAPIParams$EmptyBody body);

    @o("stage-instances")
    Observable<StageInstance> startStageInstance(@a RestAPIParams$StartStageInstanceBody body);

    @o("channels/{channelId}/call/stop-ringing")
    Observable<Void> stopRinging(@s("channelId") long channelId, @a RestAPIParams$Ring body, @i("X-Context-Properties") String context);

    @o("connections/{connection}/callback")
    Observable<Void> submitConnectionState(@s("connection") String connection, @a RestAPIParams$ConnectionState state);

    @o("reporting/{reportType}")
    Observable<Unit> submitReport(@s("reportType") String reportType, @a ReportSubmissionBody body);

    @p("guilds/{guildId}/premium/subscriptions")
    Observable<List<ModelAppliedGuildBoost>> subscribeToGuild(@s("guildId") long guildId, @a RestAPIParams$GuildBoosting guildBoosting);

    @o("guilds/{guildId}/integrations/{integrationId}/sync")
    Observable<Void> syncIntegration(@s("guildId") long guildId, @s("integrationId") long integrationId);

    @n("guilds/{guildId}")
    Observable<Void> transferGuildOwnership(@s("guildId") long guildId, @a RestAPIParams$TransferGuildOwnership transferGuildOwnership);

    @b("guilds/{guildId}/bans/{userId}")
    Observable<Void> unbanUser(@s("guildId") long guildId, @s("userId") long userId);

    @o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/uncancel")
    Observable<ModelGuildBoostSlot> uncancelSubscriptionSlot(@s("subscriptionSlotId") long slotId);

    @b("guilds/{guildId}/premium/subscriptions/{subscriptionId}")
    Observable<Void> unsubscribeToGuild(@s("guildId") long guildId, @s("subscriptionId") long subscriptionId);

    @n("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<ConnectedAccount>> updateConnection(@s("connection") String connection, @s("connectionId") String connectionId, @a RestAPIParams$ConnectedAccount connectedAccount);

    @n("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<ConnectedAccount>> updateConnectionName(@s("connection") String connection, @s("connectionId") String connectionId, @a RestAPIParams$ConnectedAccountNameOnly connectedAccountName);

    @n("guilds/{guildId}")
    Observable<Guild> updateGuild(@s("guildId") long guildId, @a RestAPIParams$UpdateGuild body);

    @n("guilds/{guildId}/integrations/{integrationId}")
    Observable<Void> updateGuildIntegration(@s("guildId") long guildId, @s("integrationId") long integrationId, @a RestAPIParams$GuildIntegration body);

    @n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @a RestAPIParams$UpdateGuildRoleSubscriptionGroupListing body);

    @n("guilds/{guildId}/role-subscriptions/subscription-listings/{listingId}/trial")
    Observable<GuildRoleSubscriptionTierFreeTrial> updateGuildRoleSubscriptionTierFreeTrial(@s("guildId") long guildId, @s("listingId") long listingId, @a RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial body);

    @n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @s("listingId") long tierListingId, @a RestAPIParams$UpdateGuildRoleSubscriptionTierListing body);

    @n("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<Unit> updateGuildScheduledEvent(@s("guildId") long guildId, @s("eventId") long eventId, @a RestAPIParams$UpdateGuildScheduledEventBody body);

    @n("guilds/{guildId}/members/@me")
    Observable<GuildMember> updateMeGuildMember(@s("guildId") long guildId, @a PatchGuildMemberBody body);

    @n("guilds/{guildId}/voice-states/@me")
    Observable<Void> updateMyVoiceStates(@s("guildId") long guildId, @a RestAPIParams$ChannelVoiceStateUpdate body);

    @n("users/@me/billing/payment-sources/{paymentSourceId}")
    Observable<Void> updatePaymentSource(@s("paymentSourceId") String paymentSourceId, @a PatchPaymentSourceRaw PatchPaymentSourceRaw);

    @p("channels/{channelId}/permissions/{targetId}")
    Observable<Void> updatePermissionOverwrites(@s("channelId") long channelId, @s("targetId") long targetId, @a RestAPIParams$ChannelPermissionOverwrites body);

    @n("users/@me/guilds/@me/settings")
    Observable<ModelNotificationSettings> updatePrivateChannelSettings(@a RestAPIParams$UserGuildSettings userGuildSettings);

    @n("guilds/{guildId}/roles/{roleId}")
    Observable<Void> updateRole(@s("guildId") long guildId, @s("roleId") long roleId, @a RestAPIParams$Role body);

    @n("stage-instances/{channelId}")
    Observable<StageInstance> updateStageInstance(@s("channelId") long channelId, @a RestAPIParams$UpdateStageInstanceBody body);

    @n("users/@me/billing/subscriptions/{subscriptionId}")
    Observable<Void> updateSubscription(@s("subscriptionId") String subscriptionId, @a RestAPIParams$UpdateSubscription updateSubscription);

    @n("channels/{channelId}/thread-members/@me/settings")
    Observable<ThreadMember> updateThreadMemberSettings(@s("channelId") long channelId, @a RestAPIParams$ThreadMemberSettings body);

    @n("users/@me/guilds/{guildId}/settings")
    Observable<ModelNotificationSettings> updateUserGuildSettings(@s("guildId") long guildId, @a RestAPIParams$UserGuildSettings userGuildSettings);

    @p("users/@me/notes/{userId}")
    Observable<Void> updateUserNotes(@s("userId") long userId, @a RestAPIParams$UserNoteUpdate userNoteUpdate);

    @n("users/@me/settings")
    Observable<ModelUserSettings> updateUserSettings(@a RestAPIParams$UserSettings userSettings);

    @n("users/@me/settings")
    Observable<ModelUserSettings> updateUserSettingsCustomStatus(@a RestAPIParams$UserSettingsCustomStatus userSettingsCustomStatus);

    @n("guilds/{guildId}/voice-states/{userId}")
    Observable<Void> updateUserVoiceStates(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$ChannelVoiceStateUpdate body);

    @n("guilds/{guildId}/vanity-url")
    Observable<VanityUrlResponse> updateVanityUrl(@s("guildId") long guildId, @a RestAPIParams$VanityUrl body);

    @p("users/@me/connections/contacts/@me/external-friend-list-entries")
    Observable<Response<BulkFriendSuggestions>> uploadContacts(@a RestAPIParams$UploadContacts uploadContacts);

    @o("debug-logs/4/{filename}")
    Observable<Void> uploadLog(@s("filename") String filename, @a String content);

    @o("debug-logs/multi/4")
    @l
    Observable<Void> uploadLogs(@q MultipartBody$Part[] files);

    @f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/{actionType}")
    Observable<ActivityActionConfirmation> userActivityAction(@s("userId") long userId, @s("applicationId") long application, @s("sessionId") String sessionId, @s("actionType") Integer actionType, @t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @t("message_id") Long messageId);

    @o("users/@me/phone")
    Observable<Void> userAddPhone(@a RestAPIParams$Phone body);

    @o("users/@me/phone/verify")
    Observable<Void> userAddPhoneNoPassword(@a RestAPIParams$VerificationCodeOnly body);

    @n("users/@me/agreements")
    Observable<Void> userAgreements(@a RestAPIParams$UserAgreements body);

    @o("users/@me/captcha/verify")
    Observable<Void> userCaptchaVerify(@a RestAPIParams$CaptchaCode body);

    @o("users/@me/channels")
    Observable<Channel> userCreateChannel(@a RestAPIParams$CreateChannel body);

    @o("users/@me/devices")
    Observable<Void> userCreateDevice(@a RestAPIParams$UserDevices body);

    @p("users/@me/email")
    Observable<Void> userEmail();

    @o("users/@me/email/verify-code")
    Observable<ModelEmailChangeConfirm> userEmailVerifyCode(@a RestAPIParams$UserEmailConfirmCode body);

    @f("users/{userId}")
    Observable<User> userGet(@s("userId") long userId);

    @h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/phone")
    Observable<Void> userPhoneDelete(@a RestAPIParams$DeletePhone body);

    @o("users/@me/phone")
    Observable<Void> userPhoneWithToken(@a RestAPIParams$VerificationPhoneCode body);

    @f("users/{userId}/profile")
    Observable<UserProfile> userProfileGet(@s("userId") long userId, @t("with_mutual_guilds") boolean withMutualGuilds, @t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId);

    @o("guilds/automations/email-domain-lookup")
    Observable<Response<EmailVerification>> verifyEmail(@a RestAPIParams$VerifyEmail body);

    @o("guilds/automations/email-domain-lookup/verify-code")
    Observable<Response<EmailVerificationCode>> verifyEmailCode(@a RestAPIParams$VerifyEmailCode body);

    @o("google-play/verify-purchase-token")
    Observable<RestAPIParams$VerifyPurchaseResponse> verifyPurchaseToken(@a RestAPIParams$VerifyPurchaseTokenBody verifyPurchaseBody);
}
