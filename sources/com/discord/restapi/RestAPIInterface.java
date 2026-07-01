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
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
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
import com.discord.api.hubs.EmailVerification2;
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
import com.discord.api.user.UserSurvey3;
import com.discord.models.domain.ModelApplicationStreamPreview;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelAuditLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelBan;
import com.discord.models.domain.ModelCall;
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
import com.discord.models.domain.ModelPaymentSource2;
import com.discord.models.domain.ModelPaymentSource3;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.models.domain.ModelSearchResponse;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.models.domain.ModelUrl;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserConsents3;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.models.experiments.dto.UnauthenticatedUserExperimentsDto;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.gson.JsonObject;
import d0.Tuples;
import d0.t.MapsJVM;
import i0.f0.Body;
import i0.f0.DELETE;
import i0.f0.GET;
import i0.f0.HTTP;
import i0.f0.Header3;
import i0.f0.Multipart;
import i0.f0.PATCH;
import i0.f0.POST;
import i0.f0.PUT;
import i0.f0.Part2;
import i0.f0.Path2;
import i0.f0.Query2;
import i0.f0.Url;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/* JADX INFO: compiled from: RestAPIInterface.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RestAPIInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String X_CONTEXT_PROPERTIES = "X-Context-Properties";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getInviteCode$default(RestAPIInterface restAPIInterface, String str, boolean z2, Long l, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInviteCode");
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return restAPIInterface.getInviteCode(str, z2, l);
        }

        public static /* synthetic */ Observable getMyEntitlements$default(RestAPIInterface restAPIInterface, long j, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyEntitlements");
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return restAPIInterface.getMyEntitlements(j, z2);
        }

        public static /* synthetic */ Observable getOauth2Authorize$default(RestAPIInterface restAPIInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if (obj == null) {
                return restAPIInterface.getOauth2Authorize(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? "consent" : str5, str6, (i & 64) != 0 ? null : str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOauth2Authorize");
        }

        public static /* synthetic */ Observable getOauth2SamsungAuthorize$default(RestAPIInterface restAPIInterface, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOauth2SamsungAuthorize");
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str5 = "consent";
            }
            return restAPIInterface.getOauth2SamsungAuthorize(str, str2, str7, str4, str5, str6);
        }

        public static /* synthetic */ Observable joinGuild$default(RestAPIInterface restAPIInterface, long j, boolean z2, String str, Long l, RestAPIParams.InviteCode inviteCode, String str2, int i, Object obj) {
            if (obj == null) {
                return restAPIInterface.joinGuild(j, z2, str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : inviteCode, (i & 32) != 0 ? null : str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinGuild");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable postOauth2Authorize$default(RestAPIInterface restAPIInterface, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map map, int i, Object obj) {
            if (obj == null) {
                return restAPIInterface.postOauth2Authorize(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? "consent" : str5, str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? MapsJVM.mapOf(Tuples.to("authorize", "true")) : map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOauth2Authorize");
        }

        public static /* synthetic */ Observable report$default(RestAPIInterface restAPIInterface, Long l, Long l2, Long l3, Long l4, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((i & 1) != 0) {
                l = null;
            }
            if ((i & 2) != 0) {
                l2 = null;
            }
            if ((i & 4) != 0) {
                l3 = null;
            }
            if ((i & 8) != 0) {
                l4 = null;
            }
            return restAPIInterface.report(l, l2, l3, l4);
        }

        public static /* synthetic */ Observable userProfileGet$default(RestAPIInterface restAPIInterface, long j, boolean z2, Long l, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userProfileGet");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return restAPIInterface.userProfileGet(j, z2, l);
        }
    }

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public interface Dynamic {
        @GET
        Observable<JsonObject> get(@Url String url);
    }

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public interface Files {
        @GET
        Observable<ResponseBody> getFile(@Url String url);
    }

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public interface RtcLatency {
        @GET
        Observable<List<ModelRtcLatencyRegion>> get(@Url String url);
    }

    @POST("guilds/{guildId}/creator-monetization/{requestId}/accept-terms")
    Observable<CreatorMonetizationEnableRequest> acceptCreatorMonetizationTerms(@Path2("guildId") long guildId, @Path2("requestId") long requestId);

    @POST("entitlements/gift-codes/{code}/redeem")
    Observable<Void> acceptGift(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code);

    @POST("guilds/{guildId}/ack")
    Observable<Void> ackGuild(@Path2("guildId") long guildId);

    @PATCH("guilds/{guildId}/requests/@me/ack")
    Observable<Void> ackGuildJoinRequest(@Path2("guildId") long guildId);

    @PUT("channels/{channelId}/pins/{messageId}")
    Observable<Void> addChannelPin(@Path2("channelId") long channelId, @Path2("messageId") long messageId);

    @PUT("channels/{channelId}/recipients/{recipientId}")
    Observable<Void> addChannelRecipient(@Path2("channelId") long channelId, @Path2("recipientId") long recipientId);

    @PUT("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    Observable<Void> addReaction(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction);

    @PUT("users/@me/relationships/{userId}")
    Observable<Void> addRelationship(@Path2("userId") long userId, @Body RestAPIParams.UserRelationship relationship, @Header3("X-Context-Properties") String context);

    @POST("channels/{channelId}/directory-entry/{guildId}")
    Observable<Response<DirectoryEntryGuild>> addServerToHub(@Path2("channelId") long channelId, @Path2("guildId") long guildId, @Body RestAPIParams.AddServerBody body);

    @GET("connections/{connection}/authorize")
    Observable<ModelUrl> authorizeConnection(@Path2("connection") String connection);

    @POST("auth/authorize-ip")
    Observable<Response<Void>> authorizeIP(@Body RestAPIParams.AuthorizeIP body);

    @PUT("guilds/{guildId}/bans/{userId}")
    Observable<Void> banGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.BanGuildMember body, @Header3("X-Audit-Log-Reason") String reason);

    @PATCH("guilds/{guildId}/roles")
    Observable<Void> batchUpdateRole(@Path2("guildId") long guildId, @Body List<RestAPIParams.Role> body);

    @POST("users/@me/relationships/bulk")
    Observable<Response<BulkAddFriendsResponse>> bulkAddRelationships(@Body RestAPIParams.UserBulkRelationship body);

    @GET("channels/{channelId}/call")
    Observable<ModelCall.Ringable> call(@Path2("channelId") long channelId);

    @POST("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/cancel")
    Observable<ModelGuildBoostSlot> cancelSubscriptionSlot(@Path2("subscriptionSlotId") long slotId);

    @PATCH("guilds/{guildId}/members/{userId}")
    Observable<Void> changeGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.GuildMember body);

    @PATCH("guilds/{guildId}/members/@me/nick")
    Observable<Void> changeGuildNickname(@Path2("guildId") long guildId, @Body RestAPIParams.Nick body);

    @POST("outbound-promotions/{promotionId}/claim")
    Observable<ClaimedOutboundPromotion> claimOutboundPromotion(@Path2("promotionId") long promotionId);

    @POST("store/skus/{skuId}/purchase")
    Observable<Unit> claimSku(@Path2("skuId") long skuId, @Body RestAPIParams.EmptyBody emptyBody);

    @PUT("channels/{channelId}/recipients/{recipientId}")
    Observable<Channel> convertDMToGroup(@Path2("channelId") long channelId, @Path2("recipientId") long recipientId);

    @POST("channels/{channelId}/followers")
    Observable<Void> createChannelFollower(@Path2("channelId") long channelId, @Body RestAPIParams.ChannelFollowerPost body);

    @PUT("users/@me/connections/contacts/@me")
    Observable<ConnectedAccount> createConnectionContacts(@Body RestAPIParams.ConnectedAccountContacts connectedAccountContacts);

    @POST("guilds/{guildId}/creator-monetization/enable-requests")
    Observable<CreatorMonetizationEnableRequest> createCreatorMonetizationEnableRequest(@Path2("guildId") long guildId);

    @POST("guilds")
    Observable<Response<Guild>> createGuild(@Body RestAPIParams.CreateGuild body);

    @POST("guilds/{guildId}/channels")
    Observable<Response<Channel>> createGuildChannel(@Path2("guildId") long guildId, @Body RestAPIParams.CreateGuildChannel body);

    @POST("guilds/templates/{guildTemplateCode}")
    Observable<Guild> createGuildFromTemplate(@Path2("guildTemplateCode") String guildTemplateCode, @Body RestAPIParams.CreateGuildFromTemplate body);

    @PUT("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> createGuildJoinRequest(@Path2("guildId") long guildId, @Body RestAPIParams.MemberVerificationForm body);

    @POST("guilds/{guildId}/role-subscriptions/group-listings")
    Observable<GuildRoleSubscriptionGroupListing> createGuildRoleSubscriptionGroupListing(@Path2("guildId") long guildId, @Body RestAPIParams.CreateGuildRoleSubscriptionGroupListing body);

    @POST("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings")
    Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTier(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Body RestAPIParams.CreateGuildRoleSubscriptionTierListing body);

    @POST("guilds/{guildId}/scheduled-events")
    Observable<GuildScheduledEvent> createGuildScheduledEvent(@Path2("guildId") long guildId, @Body RestAPIParams.CreateGuildScheduledEventBody event);

    @PUT("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    Observable<Unit> createGuildScheduledEventRsvp(@Path2("guildId") long guildId, @Path2("eventId") long eventId);

    @POST("auth/handoff")
    Observable<HandoffToken> createHandoffToken(@Body CreateHandoffTokenRequest body);

    @POST("google-play/purchase-metadata")
    Observable<Unit> createPurchaseMetadata(@Body RestAPIParams.PurchaseMetadataBody purchaseMetadataBody);

    @POST("guilds/{guildId}/roles")
    Observable<GuildRole> createRole(@Path2("guildId") long guildId);

    @POST("channels/{channelId}/threads")
    Observable<Channel> createThread(@Path2("channelId") long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @Body RestAPIParams.ThreadCreationSettings body);

    @POST("channels/{channelId}/messages/{messageId}/threads")
    Observable<Channel> createThreadFromMessage(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @Body RestAPIParams.ThreadCreationSettings body);

    @POST("channels/{channelId}/threads?has_message=true")
    @Multipart
    Observable<Channel> createThreadWithMessage(@Path2("channelId") long channelId, @Part2(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @Part2("content") String content, @Part2("applied_tags") List<Long> appliedTags, @Part2("sticker_ids") List<Long> stickerIds, @Part2("type") int type, @Part2(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION) Integer autoArchiveDuration, @Part2 MultipartBody.Part[] files);

    @POST("channels/{channelId}/messages/{messageId}/crosspost")
    Observable<Void> crosspostMessage(@Path2("channelId") long channelId, @Path2("messageId") Long messageId);

    @POST("users/@me/delete")
    Observable<Void> deleteAccount(@Body RestAPIParams.DisableAccount body);

    @DELETE("channels/{channelId}")
    Observable<Channel> deleteChannel(@Path2("channelId") long channelId);

    @DELETE("channels/{channelId}/pins/{messageId}")
    Observable<Void> deleteChannelPin(@Path2("channelId") long channelId, @Path2("messageId") long messageId);

    @DELETE("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<Void>> deleteConnection(@Path2("connection") String connection, @Path2("connectionId") String connectionId);

    @POST("guilds/{guildId}/delete")
    Observable<Void> deleteGuild(@Path2("guildId") long guildId, @Body RestAPIParams.DeleteGuild body);

    @DELETE("guilds/{guildId}/emojis/{emojiId}")
    Observable<Void> deleteGuildEmoji(@Path2("guildId") long guildId, @Path2("emojiId") long emojiId);

    @DELETE("guilds/{guildId}/integrations/{integrationId}")
    Observable<Void> deleteGuildIntegration(@Path2("guildId") long guildId, @Path2("integrationId") long integrationId);

    @DELETE("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> deleteGuildJoinRequest(@Path2("guildId") long guildId);

    @DELETE("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    Observable<Void> deleteGuildRoleSubscriptionTierListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Path2("listingId") long tierListingId);

    @DELETE("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<Void> deleteGuildScheduledEvent(@Path2("guildId") long guildId, @Path2("eventId") long eventId);

    @DELETE("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    Observable<Void> deleteGuildScheduledEventRsvp(@Path2("guildId") long guildId, @Path2("eventId") long eventId);

    @DELETE("channels/{channel_id}/messages/{message_id}")
    Observable<Void> deleteMessage(@Path2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @Path2("message_id") long messageId);

    @DELETE("oauth2/tokens/{oauthId}")
    Observable<Void> deleteOAuthToken(@Path2("oauthId") long oauthId);

    @DELETE("users/@me/billing/payment-sources/{paymentSourceId}")
    Observable<Void> deletePaymentSource(@Path2("paymentSourceId") String paymentSourceId);

    @DELETE("channels/{channelId}/permissions/{targetId}")
    Observable<Void> deletePermissionOverwrites(@Path2("channelId") long channelId, @Path2("targetId") long targetId);

    @DELETE("guilds/{guildId}/roles/{roleId}")
    Observable<Void> deleteRole(@Path2("guildId") long guildId, @Path2("roleId") long roleId);

    @DELETE("users/@me/billing/subscriptions/{subscriptionId}")
    Observable<Void> deleteSubscription(@Path2("subscriptionId") String subscriptionId);

    @POST("users/@me/disable")
    Observable<Void> disableAccount(@Body RestAPIParams.DisableAccount body);

    @PATCH("guilds/{guildId}/members/{userId}")
    Observable<Response<Void>> disableGuildCommunication(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.DisableGuildCommunication body, @Header3("X-Audit-Log-Reason") String reason);

    @POST("users/@me/mfa/totp/disable")
    Observable<DisableMfaResponse> disableMFA(@Body DisableMfaRequestBody body);

    @POST("users/@me/mfa/sms/disable")
    Observable<Void> disableMfaSMS(@Body RestAPIParams.ActivateMfaSMS body);

    @PATCH("guilds/{guildId}/members/{userId}")
    Observable<Void> disconnectGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.GuildMemberDisconnect body);

    @POST("google-play/downgrade-subscription")
    Observable<Object> downgradeSubscription(@Body RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody);

    @PATCH("channels/{channelId}")
    Observable<Channel> editGroupDM(@Path2("channelId") long channelId, @Body RestAPIParams.GroupDM body);

    @PATCH("channels/{channel_id}/messages/{message_id}")
    Observable<Message> editMessage(@Path2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @Path2("message_id") long messageId, @Body RestAPIParams.Message message);

    @PATCH("channels/{channelId}")
    Observable<Channel> editTextChannel(@Path2("channelId") long channelId, @Body RestAPIParams.TextChannel body);

    @PATCH("channels/{channelId}")
    Observable<Channel> editThread(@Path2("channelId") long channelId, @Body RestAPIParams.ThreadSettings body);

    @PATCH("channels/{channelId}")
    Observable<Channel> editTopicalChannel(@Path2("channelId") long channelId, @Body RestAPIParams.TopicalChannel body);

    @PATCH("channels/{channelId}")
    Observable<Channel> editVoiceChannel(@Path2("channelId") long channelId, @Body RestAPIParams.VoiceChannel body);

    @POST("guilds/{guildId}/integrations")
    Observable<Void> enableIntegration(@Path2("guildId") long guildId, @Body RestAPIParams.EnableIntegration body);

    @POST("users/@me/mfa/totp/enable")
    Observable<EnableMfaResponse> enableMFA(@Body RestAPIParams.EnableMFA body);

    @POST("users/@me/mfa/sms/enable")
    Observable<Void> enableMfaSMS(@Body RestAPIParams.ActivateMfaSMS body);

    @DELETE("stage-instances/{channelId}")
    Observable<Unit> endStageInstance(@Path2("channelId") long channelId);

    @POST("auth/forgot")
    Observable<Response<Void>> forgotPassword(@Body RestAPIParams.ForgotPassword body);

    @POST("users/@me/entitlements/gift-codes")
    Observable<ModelGift> generateGiftCode(@Body RestAPIParams.GenerateGiftCode body);

    @GET("users/{userId}/sessions/{sessionId}/activities/{applicationId}/metadata")
    Observable<ActivityMetadata> getActivityMetadata(@Path2("userId") long userId, @Path2("sessionId") String sessionId, @Path2("applicationId") long applicationId);

    @GET("outbound-promotions")
    Observable<List<OutboundPromotion>> getAllActiveOutboundPromotions();

    @GET("outbound-promotions/preview")
    Observable<List<OutboundPromotion>> getAllPreviewPromotions();

    @GET("channels/{channelId}/threads/archived/private")
    Observable<ThreadListing> getAllPrivateArchivedThreads(@Path2("channelId") long channelId, @Query2("before") String before);

    @GET("channels/{channelId}/threads/archived/public")
    Observable<ThreadListing> getAllPublicArchivedThreads(@Path2("channelId") long channelId, @Query2("before") String before);

    @GET("oauth2/applications/{applicationId}/assets")
    Observable<List<ApplicationAsset>> getApplicationAssets(@Path2("applicationId") long applicationId);

    @GET("applications/{botId}/commands")
    Observable<List<ApplicationCommand>> getApplicationCommands(@Path2("botId") long botId);

    @GET("applications/public")
    Observable<List<Application>> getApplications(@Query2("application_ids") long appIds);

    @GET("guilds/{guildId}/audit-logs")
    Observable<ModelAuditLog> getAuditLogs(@Path2("guildId") long guildId, @Query2("limit") int limit, @Query2("before") Long before, @Query2("user_id") Long userId, @Query2("action_type") Integer actionType);

    @POST("users/@me/mfa/codes")
    Observable<GetBackupCodesResponse> getBackupCodes(@Body GetBackupCodesRequestBody body);

    @POST("auth/verify/view-backup-codes-challenge")
    Observable<GetBackupCodesSendVerificationKeyResponse> getBackupCodesSendVerificationKey(@Body GetBackupCodesSendVerificationKeyRequestBody body);

    @POST("users/@me/mfa/codes-verification")
    Observable<GetBackupCodesResponse> getBackupCodesVerification(@Body GetBackupCodesVerificationRequestBody body);

    @GET("guilds/{guildId}/bans")
    Observable<List<ModelBan>> getBans(@Path2("guildId") long guildId);

    @GET("private/bug-reports")
    Observable<BugReportConfig> getBugReportConfig();

    @GET("channels/{channelId}")
    Observable<Channel> getChannel(@Path2("channelId") long channelId);

    @GET("channels/{channelId}/follower-stats")
    Observable<ModelChannelFollowerStatsDto> getChannelFollowerStats(@Path2("channelId") long channelId);

    @GET("channels/{channelId}/messages")
    Observable<List<Message>> getChannelMessages(@Path2("channelId") long channelId, @Query2("before") Long before, @Query2("after") Long after, @Query2("limit") Integer limit);

    @GET("channels/{channelId}/messages")
    Observable<List<Message>> getChannelMessagesAround(@Path2("channelId") long channelId, @Query2("limit") int limit, @Query2("around") long around);

    @GET("channels/{channelId}/pins")
    Observable<List<Message>> getChannelPins(@Path2("channelId") long channelId);

    @GET("users/@me/outbound-promotions/codes")
    Observable<List<ClaimedOutboundPromotion>> getClaimedOutboundPromotions();

    @GET("users/@me/connections/{platformType}/{accountId}/access-token")
    Observable<ModelConnectionAccessToken> getConnectionAccessToken(@Path2("platformType") String platformType, @Path2("accountId") String accountId);

    @GET("connections/{connection}/callback-continuation/{pinNumber}")
    Observable<ModelConnectionState> getConnectionState(@Path2("connection") String connection, @Path2("pinNumber") String pinNumber);

    @GET("users/@me/connections")
    Observable<List<ConnectedAccount>> getConnections();

    @GET("users/@me/consent")
    Observable<ModelUserConsents2> getConsents();

    @GET("guilds/{guildId}/creator-monetization/requirements")
    Observable<CreatorMonetizationEligibilityRequirements> getCreatorMonetizationEligibilityRequirements(@Path2("guildId") long guildId);

    @GET("channels/{channelId}/directory-entries")
    Observable<List<DirectoryEntryGuild>> getDirectoryEntries(@Path2("channelId") long channelId);

    @GET("guilds/{guildId}/directory-entries/broadcast")
    Observable<GuildScheduledEventBroadcast> getDirectoryEntryBroadcastInfo(@Path2("guildId") long guildId, @Query2("entity_id") Long entityId, @Query2("type") int type);

    @GET("channels/{channelId}/directory-entries")
    Observable<List<DirectoryEntryGuild2>> getDirectoryGuildScheduledEvents(@Path2("channelId") long channelId, @Query2("type") int type);

    @GET("emojis/{emojiId}/guild")
    Observable<Guild> getEmojiGuild(@Path2("emojiId") long emojiId);

    @GET("channels/{channelId}/directory-entries/counts")
    Observable<Map<Integer, Integer>> getEntryCounts(@Path2("channelId") long channelId);

    @GET("experiments")
    Observable<UnauthenticatedUserExperimentsDto> getExperiments();

    @POST("channels/{channelId}/post-data")
    Observable<ForumPostFirstMessages> getForumPostData(@Path2("channelId") long channelId, @Body RestAPIParams.GetForumPostData body);

    @GET("friend-suggestions")
    Observable<List<FriendSuggestion>> getFriendSuggestions();

    @GET("gifs/search")
    Observable<List<GifDto>> getGifSearchResults(@Query2("q") String query, @Query2("provider") String provider, @Query2("locale") String locale, @Query2("media_format") String mediaFormat, @Query2("limit") int limit);

    @GET("gifs/suggest")
    Observable<List<String>> getGifSuggestedSearchTerms(@Query2("provider") String provider, @Query2("q") String query, @Query2("locale") String locale, @Query2("limit") int limit);

    @GET("gifs/trending-search")
    Observable<List<String>> getGifTrendingSearchTerms(@Query2("provider") String provider, @Query2("locale") String locale, @Query2("limit") int limit);

    @GET("users/@me/entitlements/gifts")
    Observable<List<ModelEntitlement>> getGifts();

    @GET("guilds/{guildId}/applications")
    Observable<List<Application>> getGuildApplications(@Path2("guildId") long guildId, @Query2("include_team") boolean includeTeam);

    @GET("guilds/{guildId}/emojis")
    Observable<List<ModelEmojiGuild>> getGuildEmojis(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/integrations")
    Observable<List<ModelGuildIntegration>> getGuildIntegrations(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/invites")
    Observable<List<ModelInvite>> getGuildInvites(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/member-verification")
    Observable<ModelMemberVerificationForm> getGuildMemberVerificationForm(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/preview")
    Observable<GuildPreview> getGuildPreview(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/roles/member-counts")
    Observable<Map<Long, Integer>> getGuildRoleMemberCounts(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/roles/{roleId}/member-ids")
    Observable<List<Long>> getGuildRoleMemberIds(@Path2("guildId") long guildId, @Path2("roleId") long roleId);

    @GET("guilds/{guildId}/role-subscriptions/trials")
    Observable<List<GuildRoleSubscriptionTierFreeTrial>> getGuildRoleSubscriptionFreeTrials(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    Observable<GuildRoleSubscriptionGroupListing> getGuildRoleSubscriptionGroupListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId);

    @GET("guilds/{guildId}/role-subscriptions/group-listings")
    Observable<List<GuildRoleSubscriptionGroupListing>> getGuildRoleSubscriptionGroupListings(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<GuildScheduledEvent> getGuildScheduledEvent(@Path2("guildId") long guildId, @Path2("eventId") long eventId);

    @GET("guilds/{guildId}/scheduled-events/{eventId}/users")
    Observable<List<ApiGuildScheduledEventUser>> getGuildScheduledEventUsers(@Path2("guildId") long guildId, @Path2("eventId") long eventId, @Query2("limit") int limit, @Query2("with_member") boolean withMember, @Query2("upgrade_response_type") boolean upgradeResponseType);

    @GET("guilds/{guildId}/scheduled-events")
    Observable<List<GuildScheduledEvent>> getGuildScheduledEvents(@Path2("guildId") long guildId, @Query2("with_user_count") boolean withUserCount);

    @GET("guilds/templates/{guildTemplateCode}")
    Observable<ModelGuildTemplate> getGuildTemplateCode(@Path2("guildTemplateCode") String guildTemplateCode);

    @GET("guilds/{guildId}/regions")
    Observable<List<ModelVoiceRegion>> getGuildVoiceRegions(@Path2("guildId") long guildId);

    @GET("guilds/{guildId}/welcome-screen")
    Observable<GuildWelcomeScreen> getGuildWelcomeScreen(@Path2("guildId") long guildId);

    @GET("users/@me/harvest")
    Observable<ModelUserConsents3> getHarvestStatus();

    @GET("channels/{channelId}/messages/{messageId}/interaction-data")
    Observable<ApplicationCommandData> getInteractionData(@Path2("channelId") long channelId, @Path2("messageId") long messageId);

    @GET("invites/{code}")
    Observable<Response<ModelInvite>> getInviteCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @Query2("with_counts") boolean withCounts, @Query2("guild_scheduled_event_id") Long guildScheduledEventId);

    @POST("users/@me/billing/invoices/preview")
    Observable<ModelInvoicePreview> getInvoicePreview(@Body RestAPIParams.InvoicePreviewBody invoicePreviewBody);

    @GET("users/@me/library")
    Observable<List<ModelLibraryApplication>> getLibrary();

    @GET("auth/location-metadata")
    Observable<ModelLocationMetadata> getLocationMetadata();

    @GET("users/@me/scheduled-events")
    Observable<List<GuildScheduledEventMeUser>> getMeGuildScheduledEvents(@Query2("guild_ids") long guildIds);

    @GET("users/@me/mentions")
    Observable<List<Message>> getMentions(@Query2("limit") int limit, @Query2("roles") boolean roles, @Query2(ModelGuildMemberListUpdate.EVERYONE_ID) boolean everyone, @Query2(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @Query2("before") Long before);

    @GET("users/@me/applications/{applicationId}/entitlements")
    Observable<List<ModelEntitlement>> getMyEntitlements(@Path2("applicationId") long applicationId, @Query2("exclude_consumed") boolean excludeConsumed);

    @GET("channels/{channelId}/users/@me/threads/archived/private")
    Observable<ThreadListing> getMyPrivateArchivedThreads(@Path2("channelId") long channelId, @Query2("before") Long before);

    @GET("oauth2/tokens")
    Observable<List<ModelOAuth2Token>> getOAuthTokens();

    @GET("oauth2/authorize")
    Observable<RestAPIParams.OAuth2Authorize.ResponseGet> getOauth2Authorize(@Query2("client_id") String clientId, @Query2("state") String state, @Query2("response_type") String responseType, @Query2("redirect_uri") String redirectUrl, @Query2("prompt") String prompt, @Query2("scope") String scope, @Query2(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions);

    @GET("oauth2/samsung/authorize")
    Observable<Void> getOauth2SamsungAuthorize(@Query2("client_id") String clientId, @Query2("state") String state, @Query2("response_type") String responseType, @Query2("redirect_uri") String redirectUrl, @Query2("prompt") String prompt, @Query2("scope") String scope);

    @GET("applications/{applicationId}/payment-payout-groups")
    Observable<List<PayoutGroup>> getPaymentPayoutGroups(@Path2("applicationId") long applicationId);

    @GET("users/@me/billing/payment-sources")
    Observable<List<ModelPaymentSource3>> getPaymentSources();

    @GET("store/price-tiers")
    Observable<List<Integer>> getPriceTiers(@Query2("price_tier_type") int priceTierType);

    @GET("guilds/{guildId}/prune")
    Observable<PruneCountResponse> getPruneCount(@Path2("guildId") long guildId, @Query2("days") int days);

    @GET("channels/{channelId}/messages/{messageId}/reactions/{emoji}")
    Observable<List<User>> getReactionUsers(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "emoji") String emoji, @Query2("limit") Integer limit);

    @GET("stage-instances")
    Observable<Response<List<RecommendedStageInstance>>> getRecommendedStageInstances();

    @GET("users/{userId}/relationships")
    Observable<List<ModelUserRelationship>> getRelationships(@Path2("userId") long userId);

    @GET("reporting/menu/{reportType}")
    Observable<MenuAPIResponse> getReportMenu(@Path2("reportType") String reportType);

    @GET("tracks/{id}")
    Observable<ModelSpotifyTrack> getSpotifyTrack(@Path2(ModelAuditLogEntry.CHANGE_KEY_ID) String id2);

    @GET("stage-instances/extra")
    Observable<List<RecommendedStageInstance>> getStageInstancesForChannels(@Query2("channel_ids") Set<Long> channelIds);

    @GET("stickers/{stickerId}")
    Observable<Sticker> getSticker(@Path2("stickerId") long stickerId);

    @GET("stickers/{stickerId}/guild")
    Observable<Guild> getStickerGuild(@Path2("stickerId") long stickerId);

    @GET("sticker-packs/{packId}")
    Observable<ModelStickerPack> getStickerPack(@Path2("packId") long packId);

    @GET("sticker-packs")
    Observable<ModelStickerStoreDirectory> getStickerPacks();

    @GET("streams/{streamKey}/preview")
    Observable<ModelApplicationStreamPreview> getStreamPreview(@Path2("streamKey") String streamKey, @Query2("version") long version);

    @GET("users/@me/guilds/premium/subscription-slots")
    Observable<List<ModelGuildBoostSlot>> getSubscriptionSlots();

    @GET("users/@me/billing/subscriptions")
    Observable<List<ModelSubscription>> getSubscriptions();

    @GET("gifs/trending")
    Observable<TrendingGifCategoriesResponseDto> getTrendingGifCategories(@Query2("provider") String provider, @Query2("locale") String locale, @Query2("media_format") String mediaFormat);

    @GET("gifs/trending-gifs")
    Observable<List<GifDto>> getTrendingGifCategory(@Query2("provider") String provider, @Query2("locale") String locale, @Query2("media_format") String mediaFormat, @Query2("limit") int limit);

    @GET("users/@me/affinities/users")
    Observable<ModelUserAffinities> getUserAffinities();

    @GET("users/@me/join-request-guilds")
    Observable<List<Guild>> getUserJoinRequestGuilds();

    @GET("users/@me/notes/{userId}")
    Observable<ModelUserNote> getUserNote(@Path2("userId") long userId);

    @GET("users/@me/survey")
    Observable<Response<UserSurvey3>> getUserSurvey();

    @GET("guilds/{guildId}/vanity-url")
    Observable<VanityUrlResponse> getVanityUrl(@Path2("guildId") long guildId);

    @DELETE("friend-suggestions/{userId}")
    Observable<Void> ignoreFriendSuggestion(@Path2("userId") long userId);

    @PUT("guilds/{guildId}/members/@me")
    Observable<Guild> joinGuild(@Path2("guildId") long guildId, @Query2("lurker") boolean isLurker, @Query2("session_id") String sessionId, @Query2("directory_channel_id") Long directoryChannelId, @Body RestAPIParams.InviteCode body, @Header3("X-Context-Properties") String context);

    @POST("integrations/{integrationId}/join")
    Observable<Void> joinGuildFromIntegration(@Path2("integrationId") String integrationId);

    @POST("hub-waitlist/signup")
    Observable<WaitlistSignup> joinHubWaitlist(@Body RestAPIParams.HubWaitlist body);

    @POST("channels/{channelId}/thread-members/@me")
    Observable<Void> joinThread(@Path2("channelId") long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @Body RestAPIParams.EmptyBody body);

    @DELETE("guilds/{guildId}/members/{userId}")
    Observable<Void> kickGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Header3("X-Audit-Log-Reason") String reason);

    @DELETE("users/@me/guilds/{guildId}")
    Observable<Void> leaveGuild(@Path2("guildId") long guildId);

    @HTTP(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/guilds/{guildId}")
    Observable<Void> leaveGuild(@Path2("guildId") long guildId, @Body RestAPIParams.LeaveGuildBody leaveGuildBody);

    @DELETE("channels/{channelId}/thread-members/@me")
    Observable<Void> leaveThread(@Path2("channelId") long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location);

    @POST("auth/logout")
    Observable<Response<Void>> logout(@Body RestAPIParams.UserDevices body);

    @PATCH("channels/{channelId}/directory-entry/{guildId}")
    Observable<DirectoryEntryGuild> modifyServerInHub(@Path2("channelId") long channelId, @Path2("guildId") long guildId, @Body RestAPIParams.AddServerBody body);

    @PATCH("guilds/{guildId}/emojis/{emojiId}")
    Observable<ModelEmojiGuild> patchGuildEmoji(@Path2("guildId") long guildId, @Path2("emojiId") long emojiId, @Body RestAPIParams.PatchGuildEmoji body);

    @PATCH("users/@me")
    Observable<User> patchUser(@Body PatchUserBody patchUserBody);

    @PATCH("users/@me")
    Observable<User> patchUser(@Body RestAPIParams.UserInfo userInfo);

    @POST("phone-verifications/resend")
    Observable<Void> phoneVerificationsResend(@Body RestAPIParams.VerificationCodeResend body);

    @POST("phone-verifications/verify")
    Observable<Response<ModelPhoneVerificationToken>> phoneVerificationsVerify(@Body RestAPIParams.VerificationCode body);

    @POST("auth/fingerprint")
    Observable<FingerprintResponse> postAuthFingerprint(@Body RestAPIParams.EmptyBody body);

    @POST("auth/login")
    Observable<Response<ModelLoginResult>> postAuthLogin(@Body RestAPIParams.AuthLogin body);

    @POST("auth/register")
    Observable<Response<RegisterResponse>> postAuthRegister(@Body RestAPIParams.AuthRegister body);

    @POST("auth/register/phone")
    Observable<Response<Void>> postAuthRegisterPhone(@Body RestAPIParams.AuthRegisterPhone body);

    @POST("auth/verify/resend")
    Observable<Response<Void>> postAuthVerifyResend(@Body RestAPIParams.EmptyBody body);

    @POST("channels/{channelId}/invites")
    Observable<ModelInvite> postChannelInvite(@Path2("channelId") long channelId, @Body RestAPIParams.Invite body);

    @POST("channels/{channelId}/messages/{messageId}/ack")
    Observable<Void> postChannelMessagesAck(@Path2("channelId") long channelId, @Path2("messageId") Long messageId, @Body RestAPIParams.ChannelMessagesAck body);

    @POST("guilds/{guildId}/emojis")
    Observable<ModelEmojiGuild> postGuildEmoji(@Path2("guildId") long guildId, @Body RestAPIParams.PostGuildEmoji body);

    @POST("guilds/{guildId}/ack/{ackType}/{ackedId}")
    Observable<Void> postGuildFeatureAck(@Path2("guildId") long channelId, @Path2("ackType") int ackType, @Path2("ackedId") long ackedId, @Body RestAPIParams.GuildFeatureAck body);

    @POST("invites/{code}")
    Observable<ModelInvite> postInviteCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @Body RestAPIParams.InviteCode body, @Header3("X-Context-Properties") String context);

    @POST("auth/mfa/totp")
    Observable<Response<ModelLoginResult>> postMFACode(@Body RestAPIParams.MFALogin body);

    @POST("oauth2/authorize")
    Observable<RestAPIParams.OAuth2Authorize.ResponsePost> postOauth2Authorize(@Query2("client_id") String clientId, @Query2("state") String state, @Query2("response_type") String responseType, @Query2("redirect_uri") String redirectUrl, @Query2("prompt") String prompt, @Query2("scope") String scope, @Query2(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions, @Query2("code_challenge") String codeChallenge, @Query2("code_challenge_method") String codeChallengeMethod, @Body Map<String, String> body);

    @POST("users/@me/remote-auth/cancel")
    Observable<Void> postRemoteAuthCancel(@Body RestAPIParams.RemoteAuthCancel body);

    @POST("users/@me/remote-auth/finish")
    Observable<Void> postRemoteAuthFinish(@Body RestAPIParams.RemoteAuthFinish body);

    @POST("users/@me/remote-auth")
    Observable<ModelRemoteAuthHandshake> postRemoteAuthInitialize(@Body RestAPIParams.RemoteAuthInitialize body);

    @POST("streams/{streamKey}/preview")
    Observable<Void> postStreamPreview(@Path2("streamKey") String streamKey, @Body RestAPIParams.Thumbnail thumbnail);

    @POST("guilds/{guildId}/prune")
    Observable<Void> pruneMembers(@Path2("guildId") long guildId, @Body RestAPIParams.PruneGuild body);

    @DELETE("channels/{channelId}/messages/{messageId}/reactions")
    Observable<Void> removeAllReactions(@Path2("channelId") long channelId, @Path2("messageId") long messageId);

    @DELETE("channels/{channelId}/recipients/{recipientId}")
    Observable<Void> removeChannelRecipient(@Path2("channelId") long channelId, @Path2("recipientId") long recipientId);

    @DELETE("channels/{channelId}/messages/{messageId}/reactions/{reaction}/{userId}")
    Observable<Void> removeReaction(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction, @Path2("userId") long userId);

    @DELETE("users/@me/relationships/{userId}")
    Observable<Void> removeRelationship(@Path2("userId") long userId, @Header3("X-Context-Properties") String context);

    @DELETE("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    Observable<Void> removeSelfReaction(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction);

    @DELETE("channels/{channelId}/directory-entry/{guildId}")
    Observable<Response<DirectoryEntryGuild>> removeServerFromHub(@Path2("channelId") long channelId, @Path2("guildId") long guildId);

    @PATCH("guilds/{guildId}/channels")
    Observable<Void> reorderChannels(@Path2("guildId") long guildId, @Body List<RestAPIParams.ChannelPosition> body);

    @POST("report")
    Observable<Unit> report(@Body RestAPIParams.Report body);

    @GET("report")
    Observable<List<ReportReason>> report(@Query2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @Query2("message_id") Long messageId, @Query2("user_id") Long userId);

    @POST("users/@me/harvest")
    Observable<ModelUserConsents3> requestHarvest();

    @POST("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> resetGuildJoinRequest(@Path2("guildId") long guildId);

    @GET("entitlements/gift-codes/{code}")
    Observable<ModelGift> resolveGiftCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @Query2("with_application") boolean withApplication, @Query2("with_subscription_plan") boolean withSubscription);

    @GET("users/@me/entitlements/gift-codes")
    Observable<List<ModelGift>> resolveSkuIdGift(@Query2("sku_id") long skuId, @Query2("subscription_plan_id") Long subscriptionPlanId);

    @DELETE("users/@me/entitlements/gift-codes/{code}")
    Observable<Void> revokeGiftCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code);

    @DELETE("invites/{inviteCode}")
    Observable<ModelInvite> revokeInvite(@Path2("inviteCode") String inviteCode);

    @POST("channels/{channelId}/call/ring")
    Observable<Void> ring(@Path2("channelId") long channelId, @Body RestAPIParams.Ring body, @Header3("X-Context-Properties") String context);

    @POST("science")
    Observable<Void> science(@Body Science body);

    @GET("channels/{channelId}/messages/search")
    Observable<ModelSearchResponse> searchChannelMessages(@Path2("channelId") long channelId, @Query2("max_id") Long oldestMessageId, @Query2("author_id") List<String> authorIds, @Query2("mentions") List<String> mentionsIds, @Query2("has") List<String> has, @Query2("content") List<String> content, @Query2("attempts") Integer attempts, @Query2("include_nsfw") Boolean includeNsfw);

    @GET("guilds/{guildId}/messages/search")
    Observable<ModelSearchResponse> searchGuildMessages(@Path2("guildId") long guildId, @Query2("max_id") Long oldestMessageId, @Query2("author_id") List<String> authorIds, @Query2("mentions") List<String> mentionsIds, @Query2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) List<String> inChannelIds, @Query2("has") List<String> has, @Query2("content") List<String> content, @Query2("attempts") Integer attempts, @Query2("include_nsfw") Boolean includeNsfw);

    @GET("channels/{channelId}/directory-entries/search")
    Observable<List<DirectoryEntryGuild>> searchServers(@Path2("channelId") long channelId, @Query2("query") String query);

    @POST("interactions")
    @Multipart
    Observable<Void> sendApplicationCommand(@Part2("payload_json") PayloadJSON<RestAPIParams.ApplicationCommand> payloadJson, @Part2 MultipartBody.Part[] files);

    @POST("interactions")
    Observable<Void> sendApplicationCommand(@Body RestAPIParams.ApplicationCommand body);

    @POST("private/bug-reports")
    @Multipart
    Observable<Unit> sendBugReport(@Part2(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @Part2(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) String description, @Part2("priority") int priority, @Part2("asana_inbox_id") Long asanaInboxId, @Part2 MultipartBody.Part screenshot);

    @POST("interactions")
    Observable<Void> sendComponentInteraction(@Body RestAPIParams.ComponentInteraction body);

    @POST("channels/{channelId}/greet")
    Observable<Message> sendGreetMessage(@Path2("channelId") long channelId, @Body RestAPIParams.GreetMessage body);

    @POST("channels/{channelId}/messages")
    @Multipart
    Observable<Message> sendMessage(@Path2("channelId") long channelId, @Part2("payload_json") PayloadJSON<RestAPIParams.Message> payloadJson, @Part2 MultipartBody.Part[] files);

    @POST("channels/{channelId}/messages")
    Observable<Message> sendMessage(@Path2("channelId") long channelId, @Body RestAPIParams.Message message);

    @POST("interactions")
    Observable<Void> sendModalInteraction(@Body RestAPIParams.ModalInteraction body);

    @POST("users/@me/relationships")
    Observable<Void> sendRelationshipRequest(@Body RestAPIParams.UserRelationship.Add relationship, @Header3("X-Context-Properties") String context);

    @POST("users/@me/consent")
    Observable<Void> setConsents(@Body RestAPIParams.Consents body);

    @POST("guilds/{guildId}/mfa")
    Observable<Void> setMfaLevel(@Path2("guildId") long guildId, @Body RestAPIParams.GuildMFA body);

    @POST("channels/{channelId}/typing")
    Observable<ModelTypingResponse> setUserTyping(@Path2("channelId") long channelId, @Body RestAPIParams.EmptyBody body);

    @POST("stage-instances")
    Observable<StageInstance> startStageInstance(@Body RestAPIParams.StartStageInstanceBody body);

    @POST("channels/{channelId}/call/stop-ringing")
    Observable<Void> stopRinging(@Path2("channelId") long channelId, @Body RestAPIParams.Ring body, @Header3("X-Context-Properties") String context);

    @POST("connections/{connection}/callback")
    Observable<Void> submitConnectionState(@Path2("connection") String connection, @Body RestAPIParams.ConnectionState state);

    @POST("reporting/{reportType}")
    Observable<Unit> submitReport(@Path2("reportType") String reportType, @Body ReportSubmissionBody body);

    @PUT("guilds/{guildId}/premium/subscriptions")
    Observable<List<ModelAppliedGuildBoost>> subscribeToGuild(@Path2("guildId") long guildId, @Body RestAPIParams.GuildBoosting guildBoosting);

    @POST("guilds/{guildId}/integrations/{integrationId}/sync")
    Observable<Void> syncIntegration(@Path2("guildId") long guildId, @Path2("integrationId") long integrationId);

    @PATCH("guilds/{guildId}")
    Observable<Void> transferGuildOwnership(@Path2("guildId") long guildId, @Body RestAPIParams.TransferGuildOwnership transferGuildOwnership);

    @DELETE("guilds/{guildId}/bans/{userId}")
    Observable<Void> unbanUser(@Path2("guildId") long guildId, @Path2("userId") long userId);

    @POST("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/uncancel")
    Observable<ModelGuildBoostSlot> uncancelSubscriptionSlot(@Path2("subscriptionSlotId") long slotId);

    @DELETE("guilds/{guildId}/premium/subscriptions/{subscriptionId}")
    Observable<Void> unsubscribeToGuild(@Path2("guildId") long guildId, @Path2("subscriptionId") long subscriptionId);

    @PATCH("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<ConnectedAccount>> updateConnection(@Path2("connection") String connection, @Path2("connectionId") String connectionId, @Body RestAPIParams.ConnectedAccount connectedAccount);

    @PATCH("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<ConnectedAccount>> updateConnectionName(@Path2("connection") String connection, @Path2("connectionId") String connectionId, @Body RestAPIParams.ConnectedAccountNameOnly connectedAccountName);

    @PATCH("guilds/{guildId}")
    Observable<Guild> updateGuild(@Path2("guildId") long guildId, @Body RestAPIParams.UpdateGuild body);

    @PATCH("guilds/{guildId}/integrations/{integrationId}")
    Observable<Void> updateGuildIntegration(@Path2("guildId") long guildId, @Path2("integrationId") long integrationId, @Body RestAPIParams.GuildIntegration body);

    @PATCH("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Body RestAPIParams.UpdateGuildRoleSubscriptionGroupListing body);

    @PATCH("guilds/{guildId}/role-subscriptions/subscription-listings/{listingId}/trial")
    Observable<GuildRoleSubscriptionTierFreeTrial> updateGuildRoleSubscriptionTierFreeTrial(@Path2("guildId") long guildId, @Path2("listingId") long listingId, @Body RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial body);

    @PATCH("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Path2("listingId") long tierListingId, @Body RestAPIParams.UpdateGuildRoleSubscriptionTierListing body);

    @PATCH("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<Unit> updateGuildScheduledEvent(@Path2("guildId") long guildId, @Path2("eventId") long eventId, @Body RestAPIParams.UpdateGuildScheduledEventBody body);

    @PATCH("guilds/{guildId}/members/@me")
    Observable<GuildMember> updateMeGuildMember(@Path2("guildId") long guildId, @Body PatchGuildMemberBody body);

    @PATCH("guilds/{guildId}/voice-states/@me")
    Observable<Void> updateMyVoiceStates(@Path2("guildId") long guildId, @Body RestAPIParams.ChannelVoiceStateUpdate body);

    @PATCH("users/@me/billing/payment-sources/{paymentSourceId}")
    Observable<Void> updatePaymentSource(@Path2("paymentSourceId") String paymentSourceId, @Body ModelPaymentSource2 PatchPaymentSourceRaw);

    @PUT("channels/{channelId}/permissions/{targetId}")
    Observable<Void> updatePermissionOverwrites(@Path2("channelId") long channelId, @Path2("targetId") long targetId, @Body RestAPIParams.ChannelPermissionOverwrites body);

    @PATCH("users/@me/guilds/@me/settings")
    Observable<ModelNotificationSettings> updatePrivateChannelSettings(@Body RestAPIParams.UserGuildSettings userGuildSettings);

    @PATCH("guilds/{guildId}/roles/{roleId}")
    Observable<Void> updateRole(@Path2("guildId") long guildId, @Path2("roleId") long roleId, @Body RestAPIParams.Role body);

    @PATCH("stage-instances/{channelId}")
    Observable<StageInstance> updateStageInstance(@Path2("channelId") long channelId, @Body RestAPIParams.UpdateStageInstanceBody body);

    @PATCH("users/@me/billing/subscriptions/{subscriptionId}")
    Observable<Void> updateSubscription(@Path2("subscriptionId") String subscriptionId, @Body RestAPIParams.UpdateSubscription updateSubscription);

    @PATCH("channels/{channelId}/thread-members/@me/settings")
    Observable<ThreadMember> updateThreadMemberSettings(@Path2("channelId") long channelId, @Body RestAPIParams.ThreadMemberSettings body);

    @PATCH("users/@me/guilds/{guildId}/settings")
    Observable<ModelNotificationSettings> updateUserGuildSettings(@Path2("guildId") long guildId, @Body RestAPIParams.UserGuildSettings userGuildSettings);

    @PUT("users/@me/notes/{userId}")
    Observable<Void> updateUserNotes(@Path2("userId") long userId, @Body RestAPIParams.UserNoteUpdate userNoteUpdate);

    @PATCH("users/@me/settings")
    Observable<ModelUserSettings> updateUserSettings(@Body RestAPIParams.UserSettings userSettings);

    @PATCH("users/@me/settings")
    Observable<ModelUserSettings> updateUserSettingsCustomStatus(@Body RestAPIParams.UserSettingsCustomStatus userSettingsCustomStatus);

    @PATCH("guilds/{guildId}/voice-states/{userId}")
    Observable<Void> updateUserVoiceStates(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.ChannelVoiceStateUpdate body);

    @PATCH("guilds/{guildId}/vanity-url")
    Observable<VanityUrlResponse> updateVanityUrl(@Path2("guildId") long guildId, @Body RestAPIParams.VanityUrl body);

    @PUT("users/@me/connections/contacts/@me/external-friend-list-entries")
    Observable<Response<BulkFriendSuggestions>> uploadContacts(@Body RestAPIParams.UploadContacts uploadContacts);

    @POST("debug-logs/4/{filename}")
    Observable<Void> uploadLog(@Path2("filename") String filename, @Body String content);

    @POST("debug-logs/multi/4")
    @Multipart
    Observable<Void> uploadLogs(@Part2 MultipartBody.Part[] files);

    @GET("users/{userId}/sessions/{sessionId}/activities/{applicationId}/{actionType}")
    Observable<ActivityActionConfirmation> userActivityAction(@Path2("userId") long userId, @Path2("applicationId") long application, @Path2("sessionId") String sessionId, @Path2("actionType") Integer actionType, @Query2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @Query2("message_id") Long messageId);

    @POST("users/@me/phone")
    Observable<Void> userAddPhone(@Body RestAPIParams.Phone body);

    @POST("users/@me/phone/verify")
    Observable<Void> userAddPhoneNoPassword(@Body RestAPIParams.VerificationCodeOnly body);

    @PATCH("users/@me/agreements")
    Observable<Void> userAgreements(@Body RestAPIParams.UserAgreements body);

    @POST("users/@me/captcha/verify")
    Observable<Void> userCaptchaVerify(@Body RestAPIParams.CaptchaCode body);

    @POST("users/@me/channels")
    Observable<Channel> userCreateChannel(@Body RestAPIParams.CreateChannel body);

    @POST("users/@me/devices")
    Observable<Void> userCreateDevice(@Body RestAPIParams.UserDevices body);

    @PUT("users/@me/email")
    Observable<Void> userEmail();

    @POST("users/@me/email/verify-code")
    Observable<ModelEmailChangeConfirm> userEmailVerifyCode(@Body RestAPIParams.UserEmailConfirmCode body);

    @GET("users/{userId}")
    Observable<User> userGet(@Path2("userId") long userId);

    @HTTP(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/phone")
    Observable<Void> userPhoneDelete(@Body RestAPIParams.DeletePhone body);

    @POST("users/@me/phone")
    Observable<Void> userPhoneWithToken(@Body RestAPIParams.VerificationPhoneCode body);

    @GET("users/{userId}/profile")
    Observable<UserProfile> userProfileGet(@Path2("userId") long userId, @Query2("with_mutual_guilds") boolean withMutualGuilds, @Query2(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId);

    @POST("guilds/automations/email-domain-lookup")
    Observable<Response<EmailVerification>> verifyEmail(@Body RestAPIParams.VerifyEmail body);

    @POST("guilds/automations/email-domain-lookup/verify-code")
    Observable<Response<EmailVerification2>> verifyEmailCode(@Body RestAPIParams.VerifyEmailCode body);

    @POST("google-play/verify-purchase-token")
    Observable<RestAPIParams.VerifyPurchaseResponse> verifyPurchaseToken(@Body RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseBody);
}
