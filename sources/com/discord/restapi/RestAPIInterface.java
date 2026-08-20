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
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.models.domain.ModelRtcLatencyRegion;
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
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p630i0.p636f0.InterfaceC12528a;
import p630i0.p636f0.InterfaceC12529b;
import p630i0.p636f0.InterfaceC12533f;
import p630i0.p636f0.InterfaceC12535h;
import p630i0.p636f0.InterfaceC12536i;
import p630i0.p636f0.InterfaceC12539l;
import p630i0.p636f0.InterfaceC12541n;
import p630i0.p636f0.InterfaceC12542o;
import p630i0.p636f0.InterfaceC12543p;
import p630i0.p636f0.InterfaceC12544q;
import p630i0.p636f0.InterfaceC12546s;
import p630i0.p636f0.InterfaceC12547t;
import p630i0.p636f0.InterfaceC12552y;
import p658rx.Observable;
import retrofit2.Response;

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
                return restAPIInterface.postOauth2Authorize(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? "consent" : str5, str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? C12134g0.mapOf(C12116o.m10073to("authorize", "true")) : map);
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
        @InterfaceC12533f
        Observable<JsonObject> get(@InterfaceC12552y String url);
    }

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public interface Files {
        @InterfaceC12533f
        Observable<ResponseBody> getFile(@InterfaceC12552y String url);
    }

    /* JADX INFO: compiled from: RestAPIInterface.kt */
    public interface RtcLatency {
        @InterfaceC12533f
        Observable<List<ModelRtcLatencyRegion>> get(@InterfaceC12552y String url);
    }

    @InterfaceC12542o("guilds/{guildId}/creator-monetization/{requestId}/accept-terms")
    Observable<CreatorMonetizationEnableRequest> acceptCreatorMonetizationTerms(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("requestId") long requestId);

    @InterfaceC12542o("entitlements/gift-codes/{code}/redeem")
    Observable<Void> acceptGift(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code);

    @InterfaceC12542o("guilds/{guildId}/ack")
    Observable<Void> ackGuild(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12541n("guilds/{guildId}/requests/@me/ack")
    Observable<Void> ackGuildJoinRequest(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12543p("channels/{channelId}/pins/{messageId}")
    Observable<Void> addChannelPin(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId);

    @InterfaceC12543p("channels/{channelId}/recipients/{recipientId}")
    Observable<Void> addChannelRecipient(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("recipientId") long recipientId);

    @InterfaceC12543p("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    Observable<Void> addReaction(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction);

    @InterfaceC12543p("users/@me/relationships/{userId}")
    Observable<Void> addRelationship(@InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.UserRelationship relationship, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12542o("channels/{channelId}/directory-entry/{guildId}")
    Observable<Response<DirectoryEntryGuild>> addServerToHub(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.AddServerBody body);

    @InterfaceC12533f("connections/{connection}/authorize")
    Observable<ModelUrl> authorizeConnection(@InterfaceC12546s("connection") String connection);

    @InterfaceC12542o("auth/authorize-ip")
    Observable<Response<Void>> authorizeIP(@InterfaceC12528a RestAPIParams.AuthorizeIP body);

    @InterfaceC12543p("guilds/{guildId}/bans/{userId}")
    Observable<Void> banGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.BanGuildMember body, @InterfaceC12536i("X-Audit-Log-Reason") String reason);

    @InterfaceC12541n("guilds/{guildId}/roles")
    Observable<Void> batchUpdateRole(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a List<RestAPIParams.Role> body);

    @InterfaceC12542o("users/@me/relationships/bulk")
    Observable<Response<BulkAddFriendsResponse>> bulkAddRelationships(@InterfaceC12528a RestAPIParams.UserBulkRelationship body);

    @InterfaceC12533f("channels/{channelId}/call")
    Observable<ModelCall.Ringable> call(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12542o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/cancel")
    Observable<ModelGuildBoostSlot> cancelSubscriptionSlot(@InterfaceC12546s("subscriptionSlotId") long slotId);

    @InterfaceC12541n("guilds/{guildId}/members/{userId}")
    Observable<Void> changeGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.GuildMember body);

    @InterfaceC12541n("guilds/{guildId}/members/@me/nick")
    Observable<Void> changeGuildNickname(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.Nick body);

    @InterfaceC12542o("outbound-promotions/{promotionId}/claim")
    Observable<ClaimedOutboundPromotion> claimOutboundPromotion(@InterfaceC12546s("promotionId") long promotionId);

    @InterfaceC12542o("store/skus/{skuId}/purchase")
    Observable<Unit> claimSku(@InterfaceC12546s("skuId") long skuId, @InterfaceC12528a RestAPIParams.EmptyBody emptyBody);

    @InterfaceC12543p("channels/{channelId}/recipients/{recipientId}")
    Observable<Channel> convertDMToGroup(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("recipientId") long recipientId);

    @InterfaceC12542o("channels/{channelId}/followers")
    Observable<Void> createChannelFollower(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.ChannelFollowerPost body);

    @InterfaceC12543p("users/@me/connections/contacts/@me")
    Observable<ConnectedAccount> createConnectionContacts(@InterfaceC12528a RestAPIParams.ConnectedAccountContacts connectedAccountContacts);

    @InterfaceC12542o("guilds/{guildId}/creator-monetization/enable-requests")
    Observable<CreatorMonetizationEnableRequest> createCreatorMonetizationEnableRequest(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12542o("guilds")
    Observable<Response<Guild>> createGuild(@InterfaceC12528a RestAPIParams.CreateGuild body);

    @InterfaceC12542o("guilds/{guildId}/channels")
    Observable<Response<Channel>> createGuildChannel(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.CreateGuildChannel body);

    @InterfaceC12542o("guilds/templates/{guildTemplateCode}")
    Observable<Guild> createGuildFromTemplate(@InterfaceC12546s("guildTemplateCode") String guildTemplateCode, @InterfaceC12528a RestAPIParams.CreateGuildFromTemplate body);

    @InterfaceC12543p("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> createGuildJoinRequest(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.MemberVerificationForm body);

    @InterfaceC12542o("guilds/{guildId}/role-subscriptions/group-listings")
    Observable<GuildRoleSubscriptionGroupListing> createGuildRoleSubscriptionGroupListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.CreateGuildRoleSubscriptionGroupListing body);

    @InterfaceC12542o("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings")
    Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTier(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12528a RestAPIParams.CreateGuildRoleSubscriptionTierListing body);

    @InterfaceC12542o("guilds/{guildId}/scheduled-events")
    Observable<GuildScheduledEvent> createGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.CreateGuildScheduledEventBody event);

    @InterfaceC12543p("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    Observable<Unit> createGuildScheduledEventRsvp(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId);

    @InterfaceC12542o("auth/handoff")
    Observable<HandoffToken> createHandoffToken(@InterfaceC12528a CreateHandoffTokenRequest body);

    @InterfaceC12542o("google-play/purchase-metadata")
    Observable<Unit> createPurchaseMetadata(@InterfaceC12528a RestAPIParams.PurchaseMetadataBody purchaseMetadataBody);

    @InterfaceC12542o("guilds/{guildId}/roles")
    Observable<GuildRole> createRole(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12542o("channels/{channelId}/threads")
    Observable<Channel> createThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @InterfaceC12528a RestAPIParams.ThreadCreationSettings body);

    @InterfaceC12542o("channels/{channelId}/messages/{messageId}/threads")
    Observable<Channel> createThreadFromMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @InterfaceC12528a RestAPIParams.ThreadCreationSettings body);

    @InterfaceC12542o("channels/{channelId}/threads?has_message=true")
    @InterfaceC12539l
    Observable<Channel> createThreadWithMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @InterfaceC12544q("content") String content, @InterfaceC12544q("applied_tags") List<Long> appliedTags, @InterfaceC12544q("sticker_ids") List<Long> stickerIds, @InterfaceC12544q("type") int type, @InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION) Integer autoArchiveDuration, @InterfaceC12544q MultipartBody.Part[] files);

    @InterfaceC12542o("channels/{channelId}/messages/{messageId}/crosspost")
    Observable<Void> crosspostMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") Long messageId);

    @InterfaceC12542o("users/@me/delete")
    Observable<Void> deleteAccount(@InterfaceC12528a RestAPIParams.DisableAccount body);

    @InterfaceC12529b("channels/{channelId}")
    Observable<Channel> deleteChannel(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12529b("channels/{channelId}/pins/{messageId}")
    Observable<Void> deleteChannelPin(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId);

    @InterfaceC12529b("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<Void>> deleteConnection(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("connectionId") String connectionId);

    @InterfaceC12542o("guilds/{guildId}/delete")
    Observable<Void> deleteGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.DeleteGuild body);

    @InterfaceC12529b("guilds/{guildId}/emojis/{emojiId}")
    Observable<Void> deleteGuildEmoji(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("emojiId") long emojiId);

    @InterfaceC12529b("guilds/{guildId}/integrations/{integrationId}")
    Observable<Void> deleteGuildIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("integrationId") long integrationId);

    @InterfaceC12529b("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> deleteGuildJoinRequest(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12529b("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    Observable<Void> deleteGuildRoleSubscriptionTierListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12546s("listingId") long tierListingId);

    @InterfaceC12529b("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<Void> deleteGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId);

    @InterfaceC12529b("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    Observable<Void> deleteGuildScheduledEventRsvp(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId);

    @InterfaceC12529b("channels/{channel_id}/messages/{message_id}")
    Observable<Void> deleteMessage(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @InterfaceC12546s("message_id") long messageId);

    @InterfaceC12529b("oauth2/tokens/{oauthId}")
    Observable<Void> deleteOAuthToken(@InterfaceC12546s("oauthId") long oauthId);

    @InterfaceC12529b("users/@me/billing/payment-sources/{paymentSourceId}")
    Observable<Void> deletePaymentSource(@InterfaceC12546s("paymentSourceId") String paymentSourceId);

    @InterfaceC12529b("channels/{channelId}/permissions/{targetId}")
    Observable<Void> deletePermissionOverwrites(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("targetId") long targetId);

    @InterfaceC12529b("guilds/{guildId}/roles/{roleId}")
    Observable<Void> deleteRole(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("roleId") long roleId);

    @InterfaceC12529b("users/@me/billing/subscriptions/{subscriptionId}")
    Observable<Void> deleteSubscription(@InterfaceC12546s("subscriptionId") String subscriptionId);

    @InterfaceC12542o("users/@me/disable")
    Observable<Void> disableAccount(@InterfaceC12528a RestAPIParams.DisableAccount body);

    @InterfaceC12541n("guilds/{guildId}/members/{userId}")
    Observable<Response<Void>> disableGuildCommunication(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.DisableGuildCommunication body, @InterfaceC12536i("X-Audit-Log-Reason") String reason);

    @InterfaceC12542o("users/@me/mfa/totp/disable")
    Observable<DisableMfaResponse> disableMFA(@InterfaceC12528a DisableMfaRequestBody body);

    @InterfaceC12542o("users/@me/mfa/sms/disable")
    Observable<Void> disableMfaSMS(@InterfaceC12528a RestAPIParams.ActivateMfaSMS body);

    @InterfaceC12541n("guilds/{guildId}/members/{userId}")
    Observable<Void> disconnectGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.GuildMemberDisconnect body);

    @InterfaceC12542o("google-play/downgrade-subscription")
    Observable<Object> downgradeSubscription(@InterfaceC12528a RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody);

    @InterfaceC12541n("channels/{channelId}")
    Observable<Channel> editGroupDM(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.GroupDM body);

    @InterfaceC12541n("channels/{channel_id}/messages/{message_id}")
    Observable<Message> editMessage(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @InterfaceC12546s("message_id") long messageId, @InterfaceC12528a RestAPIParams.Message message);

    @InterfaceC12541n("channels/{channelId}")
    Observable<Channel> editTextChannel(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.TextChannel body);

    @InterfaceC12541n("channels/{channelId}")
    Observable<Channel> editThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.ThreadSettings body);

    @InterfaceC12541n("channels/{channelId}")
    Observable<Channel> editTopicalChannel(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.TopicalChannel body);

    @InterfaceC12541n("channels/{channelId}")
    Observable<Channel> editVoiceChannel(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.VoiceChannel body);

    @InterfaceC12542o("guilds/{guildId}/integrations")
    Observable<Void> enableIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.EnableIntegration body);

    @InterfaceC12542o("users/@me/mfa/totp/enable")
    Observable<EnableMfaResponse> enableMFA(@InterfaceC12528a RestAPIParams.EnableMFA body);

    @InterfaceC12542o("users/@me/mfa/sms/enable")
    Observable<Void> enableMfaSMS(@InterfaceC12528a RestAPIParams.ActivateMfaSMS body);

    @InterfaceC12529b("stage-instances/{channelId}")
    Observable<Unit> endStageInstance(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12542o("auth/forgot")
    Observable<Response<Void>> forgotPassword(@InterfaceC12528a RestAPIParams.ForgotPassword body);

    @InterfaceC12542o("users/@me/entitlements/gift-codes")
    Observable<ModelGift> generateGiftCode(@InterfaceC12528a RestAPIParams.GenerateGiftCode body);

    @InterfaceC12533f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/metadata")
    Observable<ActivityMetadata> getActivityMetadata(@InterfaceC12546s("userId") long userId, @InterfaceC12546s("sessionId") String sessionId, @InterfaceC12546s("applicationId") long applicationId);

    @InterfaceC12533f("outbound-promotions")
    Observable<List<OutboundPromotion>> getAllActiveOutboundPromotions();

    @InterfaceC12533f("outbound-promotions/preview")
    Observable<List<OutboundPromotion>> getAllPreviewPromotions();

    @InterfaceC12533f("channels/{channelId}/threads/archived/private")
    Observable<ThreadListing> getAllPrivateArchivedThreads(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") String before);

    @InterfaceC12533f("channels/{channelId}/threads/archived/public")
    Observable<ThreadListing> getAllPublicArchivedThreads(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") String before);

    @InterfaceC12533f("oauth2/applications/{applicationId}/assets")
    Observable<List<ApplicationAsset>> getApplicationAssets(@InterfaceC12546s("applicationId") long applicationId);

    @InterfaceC12533f("applications/{botId}/commands")
    Observable<List<ApplicationCommand>> getApplicationCommands(@InterfaceC12546s("botId") long botId);

    @InterfaceC12533f("applications/public")
    Observable<List<Application>> getApplications(@InterfaceC12547t("application_ids") long appIds);

    @InterfaceC12533f("guilds/{guildId}/audit-logs")
    Observable<ModelAuditLog> getAuditLogs(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("limit") int limit, @InterfaceC12547t("before") Long before, @InterfaceC12547t("user_id") Long userId, @InterfaceC12547t("action_type") Integer actionType);

    @InterfaceC12542o("users/@me/mfa/codes")
    Observable<GetBackupCodesResponse> getBackupCodes(@InterfaceC12528a GetBackupCodesRequestBody body);

    @InterfaceC12542o("auth/verify/view-backup-codes-challenge")
    Observable<GetBackupCodesSendVerificationKeyResponse> getBackupCodesSendVerificationKey(@InterfaceC12528a GetBackupCodesSendVerificationKeyRequestBody body);

    @InterfaceC12542o("users/@me/mfa/codes-verification")
    Observable<GetBackupCodesResponse> getBackupCodesVerification(@InterfaceC12528a GetBackupCodesVerificationRequestBody body);

    @InterfaceC12533f("guilds/{guildId}/bans")
    Observable<List<ModelBan>> getBans(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("private/bug-reports")
    Observable<BugReportConfig> getBugReportConfig();

    @InterfaceC12533f("channels/{channelId}")
    Observable<Channel> getChannel(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12533f("channels/{channelId}/follower-stats")
    Observable<ModelChannelFollowerStatsDto> getChannelFollowerStats(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12533f("channels/{channelId}/messages")
    Observable<List<Message>> getChannelMessages(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") Long before, @InterfaceC12547t("after") Long after, @InterfaceC12547t("limit") Integer limit);

    @InterfaceC12533f("channels/{channelId}/messages")
    Observable<List<Message>> getChannelMessagesAround(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("limit") int limit, @InterfaceC12547t("around") long around);

    @InterfaceC12533f("channels/{channelId}/pins")
    Observable<List<Message>> getChannelPins(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12533f("users/@me/outbound-promotions/codes")
    Observable<List<ClaimedOutboundPromotion>> getClaimedOutboundPromotions();

    @InterfaceC12533f("users/@me/connections/{platformType}/{accountId}/access-token")
    Observable<ModelConnectionAccessToken> getConnectionAccessToken(@InterfaceC12546s("platformType") String platformType, @InterfaceC12546s("accountId") String accountId);

    @InterfaceC12533f("connections/{connection}/callback-continuation/{pinNumber}")
    Observable<ModelConnectionState> getConnectionState(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("pinNumber") String pinNumber);

    @InterfaceC12533f("users/@me/connections")
    Observable<List<ConnectedAccount>> getConnections();

    @InterfaceC12533f("users/@me/consent")
    Observable<Consents> getConsents();

    @InterfaceC12533f("guilds/{guildId}/creator-monetization/requirements")
    Observable<CreatorMonetizationEligibilityRequirements> getCreatorMonetizationEligibilityRequirements(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("channels/{channelId}/directory-entries")
    Observable<List<DirectoryEntryGuild>> getDirectoryEntries(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12533f("guilds/{guildId}/directory-entries/broadcast")
    Observable<GuildScheduledEventBroadcast> getDirectoryEntryBroadcastInfo(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("entity_id") Long entityId, @InterfaceC12547t("type") int type);

    @InterfaceC12533f("channels/{channelId}/directory-entries")
    Observable<List<DirectoryEntryEvent>> getDirectoryGuildScheduledEvents(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("type") int type);

    @InterfaceC12533f("emojis/{emojiId}/guild")
    Observable<Guild> getEmojiGuild(@InterfaceC12546s("emojiId") long emojiId);

    @InterfaceC12533f("channels/{channelId}/directory-entries/counts")
    Observable<Map<Integer, Integer>> getEntryCounts(@InterfaceC12546s("channelId") long channelId);

    @InterfaceC12533f("experiments")
    Observable<UnauthenticatedUserExperimentsDto> getExperiments();

    @InterfaceC12542o("channels/{channelId}/post-data")
    Observable<ForumPostFirstMessages> getForumPostData(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.GetForumPostData body);

    @InterfaceC12533f("friend-suggestions")
    Observable<List<FriendSuggestion>> getFriendSuggestions();

    @InterfaceC12533f("gifs/search")
    Observable<List<GifDto>> getGifSearchResults(@InterfaceC12547t("q") String query, @InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("media_format") String mediaFormat, @InterfaceC12547t("limit") int limit);

    @InterfaceC12533f("gifs/suggest")
    Observable<List<String>> getGifSuggestedSearchTerms(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("q") String query, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("limit") int limit);

    @InterfaceC12533f("gifs/trending-search")
    Observable<List<String>> getGifTrendingSearchTerms(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("limit") int limit);

    @InterfaceC12533f("users/@me/entitlements/gifts")
    Observable<List<ModelEntitlement>> getGifts();

    @InterfaceC12533f("guilds/{guildId}/applications")
    Observable<List<Application>> getGuildApplications(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("include_team") boolean includeTeam);

    @InterfaceC12533f("guilds/{guildId}/emojis")
    Observable<List<ModelEmojiGuild>> getGuildEmojis(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/integrations")
    Observable<List<ModelGuildIntegration>> getGuildIntegrations(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/invites")
    Observable<List<ModelInvite>> getGuildInvites(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/member-verification")
    Observable<ModelMemberVerificationForm> getGuildMemberVerificationForm(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/preview")
    Observable<GuildPreview> getGuildPreview(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/roles/member-counts")
    Observable<Map<Long, Integer>> getGuildRoleMemberCounts(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/roles/{roleId}/member-ids")
    Observable<List<Long>> getGuildRoleMemberIds(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("roleId") long roleId);

    @InterfaceC12533f("guilds/{guildId}/role-subscriptions/trials")
    Observable<List<GuildRoleSubscriptionTierFreeTrial>> getGuildRoleSubscriptionFreeTrials(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    Observable<GuildRoleSubscriptionGroupListing> getGuildRoleSubscriptionGroupListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId);

    @InterfaceC12533f("guilds/{guildId}/role-subscriptions/group-listings")
    Observable<List<GuildRoleSubscriptionGroupListing>> getGuildRoleSubscriptionGroupListings(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<GuildScheduledEvent> getGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId);

    @InterfaceC12533f("guilds/{guildId}/scheduled-events/{eventId}/users")
    Observable<List<ApiGuildScheduledEventUser>> getGuildScheduledEventUsers(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId, @InterfaceC12547t("limit") int limit, @InterfaceC12547t("with_member") boolean withMember, @InterfaceC12547t("upgrade_response_type") boolean upgradeResponseType);

    @InterfaceC12533f("guilds/{guildId}/scheduled-events")
    Observable<List<GuildScheduledEvent>> getGuildScheduledEvents(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("with_user_count") boolean withUserCount);

    @InterfaceC12533f("guilds/templates/{guildTemplateCode}")
    Observable<ModelGuildTemplate> getGuildTemplateCode(@InterfaceC12546s("guildTemplateCode") String guildTemplateCode);

    @InterfaceC12533f("guilds/{guildId}/regions")
    Observable<List<ModelVoiceRegion>> getGuildVoiceRegions(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("guilds/{guildId}/welcome-screen")
    Observable<GuildWelcomeScreen> getGuildWelcomeScreen(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("users/@me/harvest")
    Observable<Harvest> getHarvestStatus();

    @InterfaceC12533f("channels/{channelId}/messages/{messageId}/interaction-data")
    Observable<ApplicationCommandData> getInteractionData(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId);

    @InterfaceC12533f("invites/{code}")
    Observable<Response<ModelInvite>> getInviteCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @InterfaceC12547t("with_counts") boolean withCounts, @InterfaceC12547t("guild_scheduled_event_id") Long guildScheduledEventId);

    @InterfaceC12542o("users/@me/billing/invoices/preview")
    Observable<ModelInvoicePreview> getInvoicePreview(@InterfaceC12528a RestAPIParams.InvoicePreviewBody invoicePreviewBody);

    @InterfaceC12533f("users/@me/library")
    Observable<List<ModelLibraryApplication>> getLibrary();

    @InterfaceC12533f("auth/location-metadata")
    Observable<ModelLocationMetadata> getLocationMetadata();

    @InterfaceC12533f("users/@me/scheduled-events")
    Observable<List<GuildScheduledEventMeUser>> getMeGuildScheduledEvents(@InterfaceC12547t("guild_ids") long guildIds);

    @InterfaceC12533f("users/@me/mentions")
    Observable<List<Message>> getMentions(@InterfaceC12547t("limit") int limit, @InterfaceC12547t("roles") boolean roles, @InterfaceC12547t(ModelGuildMemberListUpdate.EVERYONE_ID) boolean everyone, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @InterfaceC12547t("before") Long before);

    @InterfaceC12533f("users/@me/applications/{applicationId}/entitlements")
    Observable<List<ModelEntitlement>> getMyEntitlements(@InterfaceC12546s("applicationId") long applicationId, @InterfaceC12547t("exclude_consumed") boolean excludeConsumed);

    @InterfaceC12533f("channels/{channelId}/users/@me/threads/archived/private")
    Observable<ThreadListing> getMyPrivateArchivedThreads(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") Long before);

    @InterfaceC12533f("oauth2/tokens")
    Observable<List<ModelOAuth2Token>> getOAuthTokens();

    @InterfaceC12533f("oauth2/authorize")
    Observable<RestAPIParams.OAuth2Authorize.ResponseGet> getOauth2Authorize(@InterfaceC12547t("client_id") String clientId, @InterfaceC12547t("state") String state, @InterfaceC12547t("response_type") String responseType, @InterfaceC12547t("redirect_uri") String redirectUrl, @InterfaceC12547t("prompt") String prompt, @InterfaceC12547t("scope") String scope, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions);

    @InterfaceC12533f("oauth2/samsung/authorize")
    Observable<Void> getOauth2SamsungAuthorize(@InterfaceC12547t("client_id") String clientId, @InterfaceC12547t("state") String state, @InterfaceC12547t("response_type") String responseType, @InterfaceC12547t("redirect_uri") String redirectUrl, @InterfaceC12547t("prompt") String prompt, @InterfaceC12547t("scope") String scope);

    @InterfaceC12533f("applications/{applicationId}/payment-payout-groups")
    Observable<List<PayoutGroup>> getPaymentPayoutGroups(@InterfaceC12546s("applicationId") long applicationId);

    @InterfaceC12533f("users/@me/billing/payment-sources")
    Observable<List<PaymentSourceRaw>> getPaymentSources();

    @InterfaceC12533f("store/price-tiers")
    Observable<List<Integer>> getPriceTiers(@InterfaceC12547t("price_tier_type") int priceTierType);

    @InterfaceC12533f("guilds/{guildId}/prune")
    Observable<PruneCountResponse> getPruneCount(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("days") int days);

    @InterfaceC12533f("channels/{channelId}/messages/{messageId}/reactions/{emoji}")
    Observable<List<User>> getReactionUsers(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "emoji") String emoji, @InterfaceC12547t("limit") Integer limit);

    @InterfaceC12533f("stage-instances")
    Observable<Response<List<RecommendedStageInstance>>> getRecommendedStageInstances();

    @InterfaceC12533f("users/{userId}/relationships")
    Observable<List<ModelUserRelationship>> getRelationships(@InterfaceC12546s("userId") long userId);

    @InterfaceC12533f("reporting/menu/{reportType}")
    Observable<MenuAPIResponse> getReportMenu(@InterfaceC12546s("reportType") String reportType);

    @InterfaceC12533f("tracks/{id}")
    Observable<ModelSpotifyTrack> getSpotifyTrack(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_ID) String id2);

    @InterfaceC12533f("stage-instances/extra")
    Observable<List<RecommendedStageInstance>> getStageInstancesForChannels(@InterfaceC12547t("channel_ids") Set<Long> channelIds);

    @InterfaceC12533f("stickers/{stickerId}")
    Observable<Sticker> getSticker(@InterfaceC12546s("stickerId") long stickerId);

    @InterfaceC12533f("stickers/{stickerId}/guild")
    Observable<Guild> getStickerGuild(@InterfaceC12546s("stickerId") long stickerId);

    @InterfaceC12533f("sticker-packs/{packId}")
    Observable<ModelStickerPack> getStickerPack(@InterfaceC12546s("packId") long packId);

    @InterfaceC12533f("sticker-packs")
    Observable<ModelStickerStoreDirectory> getStickerPacks();

    @InterfaceC12533f("streams/{streamKey}/preview")
    Observable<ModelApplicationStreamPreview> getStreamPreview(@InterfaceC12546s("streamKey") String streamKey, @InterfaceC12547t("version") long version);

    @InterfaceC12533f("users/@me/guilds/premium/subscription-slots")
    Observable<List<ModelGuildBoostSlot>> getSubscriptionSlots();

    @InterfaceC12533f("users/@me/billing/subscriptions")
    Observable<List<ModelSubscription>> getSubscriptions();

    @InterfaceC12533f("gifs/trending")
    Observable<TrendingGifCategoriesResponseDto> getTrendingGifCategories(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("media_format") String mediaFormat);

    @InterfaceC12533f("gifs/trending-gifs")
    Observable<List<GifDto>> getTrendingGifCategory(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("media_format") String mediaFormat, @InterfaceC12547t("limit") int limit);

    @InterfaceC12533f("users/@me/affinities/users")
    Observable<ModelUserAffinities> getUserAffinities();

    @InterfaceC12533f("users/@me/join-request-guilds")
    Observable<List<Guild>> getUserJoinRequestGuilds();

    @InterfaceC12533f("users/@me/notes/{userId}")
    Observable<ModelUserNote> getUserNote(@InterfaceC12546s("userId") long userId);

    @InterfaceC12533f("users/@me/survey")
    Observable<Response<UserSurveyFetchResponse>> getUserSurvey();

    @InterfaceC12533f("guilds/{guildId}/vanity-url")
    Observable<VanityUrlResponse> getVanityUrl(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12529b("friend-suggestions/{userId}")
    Observable<Void> ignoreFriendSuggestion(@InterfaceC12546s("userId") long userId);

    @InterfaceC12543p("guilds/{guildId}/members/@me")
    Observable<Guild> joinGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("lurker") boolean isLurker, @InterfaceC12547t("session_id") String sessionId, @InterfaceC12547t("directory_channel_id") Long directoryChannelId, @InterfaceC12528a RestAPIParams.InviteCode body, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12542o("integrations/{integrationId}/join")
    Observable<Void> joinGuildFromIntegration(@InterfaceC12546s("integrationId") String integrationId);

    @InterfaceC12542o("hub-waitlist/signup")
    Observable<WaitlistSignup> joinHubWaitlist(@InterfaceC12528a RestAPIParams.HubWaitlist body);

    @InterfaceC12542o("channels/{channelId}/thread-members/@me")
    Observable<Void> joinThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @InterfaceC12528a RestAPIParams.EmptyBody body);

    @InterfaceC12529b("guilds/{guildId}/members/{userId}")
    Observable<Void> kickGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12536i("X-Audit-Log-Reason") String reason);

    @InterfaceC12529b("users/@me/guilds/{guildId}")
    Observable<Void> leaveGuild(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12535h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/guilds/{guildId}")
    Observable<Void> leaveGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.LeaveGuildBody leaveGuildBody);

    @InterfaceC12529b("channels/{channelId}/thread-members/@me")
    Observable<Void> leaveThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location);

    @InterfaceC12542o("auth/logout")
    Observable<Response<Void>> logout(@InterfaceC12528a RestAPIParams.UserDevices body);

    @InterfaceC12541n("channels/{channelId}/directory-entry/{guildId}")
    Observable<DirectoryEntryGuild> modifyServerInHub(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.AddServerBody body);

    @InterfaceC12541n("guilds/{guildId}/emojis/{emojiId}")
    Observable<ModelEmojiGuild> patchGuildEmoji(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("emojiId") long emojiId, @InterfaceC12528a RestAPIParams.PatchGuildEmoji body);

    @InterfaceC12541n("users/@me")
    Observable<User> patchUser(@InterfaceC12528a PatchUserBody patchUserBody);

    @InterfaceC12541n("users/@me")
    Observable<User> patchUser(@InterfaceC12528a RestAPIParams.UserInfo userInfo);

    @InterfaceC12542o("phone-verifications/resend")
    Observable<Void> phoneVerificationsResend(@InterfaceC12528a RestAPIParams.VerificationCodeResend body);

    @InterfaceC12542o("phone-verifications/verify")
    Observable<Response<ModelPhoneVerificationToken>> phoneVerificationsVerify(@InterfaceC12528a RestAPIParams.VerificationCode body);

    @InterfaceC12542o("auth/fingerprint")
    Observable<FingerprintResponse> postAuthFingerprint(@InterfaceC12528a RestAPIParams.EmptyBody body);

    @InterfaceC12542o("auth/login")
    Observable<Response<ModelLoginResult>> postAuthLogin(@InterfaceC12528a RestAPIParams.AuthLogin body);

    @InterfaceC12542o("auth/register")
    Observable<Response<RegisterResponse>> postAuthRegister(@InterfaceC12528a RestAPIParams.AuthRegister body);

    @InterfaceC12542o("auth/register/phone")
    Observable<Response<Void>> postAuthRegisterPhone(@InterfaceC12528a RestAPIParams.AuthRegisterPhone body);

    @InterfaceC12542o("auth/verify/resend")
    Observable<Response<Void>> postAuthVerifyResend(@InterfaceC12528a RestAPIParams.EmptyBody body);

    @InterfaceC12542o("channels/{channelId}/invites")
    Observable<ModelInvite> postChannelInvite(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Invite body);

    @InterfaceC12542o("channels/{channelId}/messages/{messageId}/ack")
    Observable<Void> postChannelMessagesAck(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") Long messageId, @InterfaceC12528a RestAPIParams.ChannelMessagesAck body);

    @InterfaceC12542o("guilds/{guildId}/emojis")
    Observable<ModelEmojiGuild> postGuildEmoji(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.PostGuildEmoji body);

    @InterfaceC12542o("guilds/{guildId}/ack/{ackType}/{ackedId}")
    Observable<Void> postGuildFeatureAck(@InterfaceC12546s("guildId") long channelId, @InterfaceC12546s("ackType") int ackType, @InterfaceC12546s("ackedId") long ackedId, @InterfaceC12528a RestAPIParams.GuildFeatureAck body);

    @InterfaceC12542o("invites/{code}")
    Observable<ModelInvite> postInviteCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @InterfaceC12528a RestAPIParams.InviteCode body, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12542o("auth/mfa/totp")
    Observable<Response<ModelLoginResult>> postMFACode(@InterfaceC12528a RestAPIParams.MFALogin body);

    @InterfaceC12542o("oauth2/authorize")
    Observable<RestAPIParams.OAuth2Authorize.ResponsePost> postOauth2Authorize(@InterfaceC12547t("client_id") String clientId, @InterfaceC12547t("state") String state, @InterfaceC12547t("response_type") String responseType, @InterfaceC12547t("redirect_uri") String redirectUrl, @InterfaceC12547t("prompt") String prompt, @InterfaceC12547t("scope") String scope, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions, @InterfaceC12547t("code_challenge") String codeChallenge, @InterfaceC12547t("code_challenge_method") String codeChallengeMethod, @InterfaceC12528a Map<String, String> body);

    @InterfaceC12542o("users/@me/remote-auth/cancel")
    Observable<Void> postRemoteAuthCancel(@InterfaceC12528a RestAPIParams.RemoteAuthCancel body);

    @InterfaceC12542o("users/@me/remote-auth/finish")
    Observable<Void> postRemoteAuthFinish(@InterfaceC12528a RestAPIParams.RemoteAuthFinish body);

    @InterfaceC12542o("users/@me/remote-auth")
    Observable<ModelRemoteAuthHandshake> postRemoteAuthInitialize(@InterfaceC12528a RestAPIParams.RemoteAuthInitialize body);

    @InterfaceC12542o("streams/{streamKey}/preview")
    Observable<Void> postStreamPreview(@InterfaceC12546s("streamKey") String streamKey, @InterfaceC12528a RestAPIParams.Thumbnail thumbnail);

    @InterfaceC12542o("guilds/{guildId}/prune")
    Observable<Void> pruneMembers(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.PruneGuild body);

    @InterfaceC12529b("channels/{channelId}/messages/{messageId}/reactions")
    Observable<Void> removeAllReactions(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId);

    @InterfaceC12529b("channels/{channelId}/recipients/{recipientId}")
    Observable<Void> removeChannelRecipient(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("recipientId") long recipientId);

    @InterfaceC12529b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/{userId}")
    Observable<Void> removeReaction(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction, @InterfaceC12546s("userId") long userId);

    @InterfaceC12529b("users/@me/relationships/{userId}")
    Observable<Void> removeRelationship(@InterfaceC12546s("userId") long userId, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12529b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    Observable<Void> removeSelfReaction(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction);

    @InterfaceC12529b("channels/{channelId}/directory-entry/{guildId}")
    Observable<Response<DirectoryEntryGuild>> removeServerFromHub(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("guildId") long guildId);

    @InterfaceC12541n("guilds/{guildId}/channels")
    Observable<Void> reorderChannels(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a List<RestAPIParams.ChannelPosition> body);

    @InterfaceC12542o("report")
    Observable<Unit> report(@InterfaceC12528a RestAPIParams.Report body);

    @InterfaceC12533f("report")
    Observable<List<ReportReason>> report(@InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @InterfaceC12547t("message_id") Long messageId, @InterfaceC12547t("user_id") Long userId);

    @InterfaceC12542o("users/@me/harvest")
    Observable<Harvest> requestHarvest();

    @InterfaceC12542o("guilds/{guildId}/requests/@me")
    Observable<ModelMemberVerificationFormResponse> resetGuildJoinRequest(@InterfaceC12546s("guildId") long guildId);

    @InterfaceC12533f("entitlements/gift-codes/{code}")
    Observable<ModelGift> resolveGiftCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @InterfaceC12547t("with_application") boolean withApplication, @InterfaceC12547t("with_subscription_plan") boolean withSubscription);

    @InterfaceC12533f("users/@me/entitlements/gift-codes")
    Observable<List<ModelGift>> resolveSkuIdGift(@InterfaceC12547t("sku_id") long skuId, @InterfaceC12547t("subscription_plan_id") Long subscriptionPlanId);

    @InterfaceC12529b("users/@me/entitlements/gift-codes/{code}")
    Observable<Void> revokeGiftCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code);

    @InterfaceC12529b("invites/{inviteCode}")
    Observable<ModelInvite> revokeInvite(@InterfaceC12546s("inviteCode") String inviteCode);

    @InterfaceC12542o("channels/{channelId}/call/ring")
    Observable<Void> ring(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Ring body, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12542o("science")
    Observable<Void> science(@InterfaceC12528a Science body);

    @InterfaceC12533f("channels/{channelId}/messages/search")
    Observable<ModelSearchResponse> searchChannelMessages(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("max_id") Long oldestMessageId, @InterfaceC12547t("author_id") List<String> authorIds, @InterfaceC12547t("mentions") List<String> mentionsIds, @InterfaceC12547t("has") List<String> has, @InterfaceC12547t("content") List<String> content, @InterfaceC12547t("attempts") Integer attempts, @InterfaceC12547t("include_nsfw") Boolean includeNsfw);

    @InterfaceC12533f("guilds/{guildId}/messages/search")
    Observable<ModelSearchResponse> searchGuildMessages(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("max_id") Long oldestMessageId, @InterfaceC12547t("author_id") List<String> authorIds, @InterfaceC12547t("mentions") List<String> mentionsIds, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) List<String> inChannelIds, @InterfaceC12547t("has") List<String> has, @InterfaceC12547t("content") List<String> content, @InterfaceC12547t("attempts") Integer attempts, @InterfaceC12547t("include_nsfw") Boolean includeNsfw);

    @InterfaceC12533f("channels/{channelId}/directory-entries/search")
    Observable<List<DirectoryEntryGuild>> searchServers(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("query") String query);

    @InterfaceC12542o("interactions")
    @InterfaceC12539l
    Observable<Void> sendApplicationCommand(@InterfaceC12544q("payload_json") PayloadJSON<RestAPIParams.ApplicationCommand> payloadJson, @InterfaceC12544q MultipartBody.Part[] files);

    @InterfaceC12542o("interactions")
    Observable<Void> sendApplicationCommand(@InterfaceC12528a RestAPIParams.ApplicationCommand body);

    @InterfaceC12542o("private/bug-reports")
    @InterfaceC12539l
    Observable<Unit> sendBugReport(@InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) String description, @InterfaceC12544q("priority") int priority, @InterfaceC12544q("asana_inbox_id") Long asanaInboxId, @InterfaceC12544q MultipartBody.Part screenshot);

    @InterfaceC12542o("interactions")
    Observable<Void> sendComponentInteraction(@InterfaceC12528a RestAPIParams.ComponentInteraction body);

    @InterfaceC12542o("channels/{channelId}/greet")
    Observable<Message> sendGreetMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.GreetMessage body);

    @InterfaceC12542o("channels/{channelId}/messages")
    @InterfaceC12539l
    Observable<Message> sendMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12544q("payload_json") PayloadJSON<RestAPIParams.Message> payloadJson, @InterfaceC12544q MultipartBody.Part[] files);

    @InterfaceC12542o("channels/{channelId}/messages")
    Observable<Message> sendMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Message message);

    @InterfaceC12542o("interactions")
    Observable<Void> sendModalInteraction(@InterfaceC12528a RestAPIParams.ModalInteraction body);

    @InterfaceC12542o("users/@me/relationships")
    Observable<Void> sendRelationshipRequest(@InterfaceC12528a RestAPIParams.UserRelationship.Add relationship, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12542o("users/@me/consent")
    Observable<Void> setConsents(@InterfaceC12528a RestAPIParams.Consents body);

    @InterfaceC12542o("guilds/{guildId}/mfa")
    Observable<Void> setMfaLevel(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.GuildMFA body);

    @InterfaceC12542o("channels/{channelId}/typing")
    Observable<ModelTypingResponse> setUserTyping(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.EmptyBody body);

    @InterfaceC12542o("stage-instances")
    Observable<StageInstance> startStageInstance(@InterfaceC12528a RestAPIParams.StartStageInstanceBody body);

    @InterfaceC12542o("channels/{channelId}/call/stop-ringing")
    Observable<Void> stopRinging(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Ring body, @InterfaceC12536i("X-Context-Properties") String context);

    @InterfaceC12542o("connections/{connection}/callback")
    Observable<Void> submitConnectionState(@InterfaceC12546s("connection") String connection, @InterfaceC12528a RestAPIParams.ConnectionState state);

    @InterfaceC12542o("reporting/{reportType}")
    Observable<Unit> submitReport(@InterfaceC12546s("reportType") String reportType, @InterfaceC12528a ReportSubmissionBody body);

    @InterfaceC12543p("guilds/{guildId}/premium/subscriptions")
    Observable<List<ModelAppliedGuildBoost>> subscribeToGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.GuildBoosting guildBoosting);

    @InterfaceC12542o("guilds/{guildId}/integrations/{integrationId}/sync")
    Observable<Void> syncIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("integrationId") long integrationId);

    @InterfaceC12541n("guilds/{guildId}")
    Observable<Void> transferGuildOwnership(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.TransferGuildOwnership transferGuildOwnership);

    @InterfaceC12529b("guilds/{guildId}/bans/{userId}")
    Observable<Void> unbanUser(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId);

    @InterfaceC12542o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/uncancel")
    Observable<ModelGuildBoostSlot> uncancelSubscriptionSlot(@InterfaceC12546s("subscriptionSlotId") long slotId);

    @InterfaceC12529b("guilds/{guildId}/premium/subscriptions/{subscriptionId}")
    Observable<Void> unsubscribeToGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("subscriptionId") long subscriptionId);

    @InterfaceC12541n("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<ConnectedAccount>> updateConnection(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("connectionId") String connectionId, @InterfaceC12528a RestAPIParams.ConnectedAccount connectedAccount);

    @InterfaceC12541n("users/@me/connections/{connection}/{connectionId}")
    Observable<Response<ConnectedAccount>> updateConnectionName(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("connectionId") String connectionId, @InterfaceC12528a RestAPIParams.ConnectedAccountNameOnly connectedAccountName);

    @InterfaceC12541n("guilds/{guildId}")
    Observable<Guild> updateGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.UpdateGuild body);

    @InterfaceC12541n("guilds/{guildId}/integrations/{integrationId}")
    Observable<Void> updateGuildIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("integrationId") long integrationId, @InterfaceC12528a RestAPIParams.GuildIntegration body);

    @InterfaceC12541n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12528a RestAPIParams.UpdateGuildRoleSubscriptionGroupListing body);

    @InterfaceC12541n("guilds/{guildId}/role-subscriptions/subscription-listings/{listingId}/trial")
    Observable<GuildRoleSubscriptionTierFreeTrial> updateGuildRoleSubscriptionTierFreeTrial(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("listingId") long listingId, @InterfaceC12528a RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial body);

    @InterfaceC12541n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12546s("listingId") long tierListingId, @InterfaceC12528a RestAPIParams.UpdateGuildRoleSubscriptionTierListing body);

    @InterfaceC12541n("guilds/{guildId}/scheduled-events/{eventId}")
    Observable<Unit> updateGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId, @InterfaceC12528a RestAPIParams.UpdateGuildScheduledEventBody body);

    @InterfaceC12541n("guilds/{guildId}/members/@me")
    Observable<GuildMember> updateMeGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a PatchGuildMemberBody body);

    @InterfaceC12541n("guilds/{guildId}/voice-states/@me")
    Observable<Void> updateMyVoiceStates(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.ChannelVoiceStateUpdate body);

    @InterfaceC12541n("users/@me/billing/payment-sources/{paymentSourceId}")
    Observable<Void> updatePaymentSource(@InterfaceC12546s("paymentSourceId") String paymentSourceId, @InterfaceC12528a PatchPaymentSourceRaw PatchPaymentSourceRaw);

    @InterfaceC12543p("channels/{channelId}/permissions/{targetId}")
    Observable<Void> updatePermissionOverwrites(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("targetId") long targetId, @InterfaceC12528a RestAPIParams.ChannelPermissionOverwrites body);

    @InterfaceC12541n("users/@me/guilds/@me/settings")
    Observable<ModelNotificationSettings> updatePrivateChannelSettings(@InterfaceC12528a RestAPIParams.UserGuildSettings userGuildSettings);

    @InterfaceC12541n("guilds/{guildId}/roles/{roleId}")
    Observable<Void> updateRole(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("roleId") long roleId, @InterfaceC12528a RestAPIParams.Role body);

    @InterfaceC12541n("stage-instances/{channelId}")
    Observable<StageInstance> updateStageInstance(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.UpdateStageInstanceBody body);

    @InterfaceC12541n("users/@me/billing/subscriptions/{subscriptionId}")
    Observable<Void> updateSubscription(@InterfaceC12546s("subscriptionId") String subscriptionId, @InterfaceC12528a RestAPIParams.UpdateSubscription updateSubscription);

    @InterfaceC12541n("channels/{channelId}/thread-members/@me/settings")
    Observable<ThreadMember> updateThreadMemberSettings(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.ThreadMemberSettings body);

    @InterfaceC12541n("users/@me/guilds/{guildId}/settings")
    Observable<ModelNotificationSettings> updateUserGuildSettings(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.UserGuildSettings userGuildSettings);

    @InterfaceC12543p("users/@me/notes/{userId}")
    Observable<Void> updateUserNotes(@InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.UserNoteUpdate userNoteUpdate);

    @InterfaceC12541n("users/@me/settings")
    Observable<ModelUserSettings> updateUserSettings(@InterfaceC12528a RestAPIParams.UserSettings userSettings);

    @InterfaceC12541n("users/@me/settings")
    Observable<ModelUserSettings> updateUserSettingsCustomStatus(@InterfaceC12528a RestAPIParams.UserSettingsCustomStatus userSettingsCustomStatus);

    @InterfaceC12541n("guilds/{guildId}/voice-states/{userId}")
    Observable<Void> updateUserVoiceStates(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.ChannelVoiceStateUpdate body);

    @InterfaceC12541n("guilds/{guildId}/vanity-url")
    Observable<VanityUrlResponse> updateVanityUrl(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.VanityUrl body);

    @InterfaceC12543p("users/@me/connections/contacts/@me/external-friend-list-entries")
    Observable<Response<BulkFriendSuggestions>> uploadContacts(@InterfaceC12528a RestAPIParams.UploadContacts uploadContacts);

    @InterfaceC12542o("debug-logs/4/{filename}")
    Observable<Void> uploadLog(@InterfaceC12546s("filename") String filename, @InterfaceC12528a String content);

    @InterfaceC12542o("debug-logs/multi/4")
    @InterfaceC12539l
    Observable<Void> uploadLogs(@InterfaceC12544q MultipartBody.Part[] files);

    @InterfaceC12533f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/{actionType}")
    Observable<ActivityActionConfirmation> userActivityAction(@InterfaceC12546s("userId") long userId, @InterfaceC12546s("applicationId") long application, @InterfaceC12546s("sessionId") String sessionId, @InterfaceC12546s("actionType") Integer actionType, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @InterfaceC12547t("message_id") Long messageId);

    @InterfaceC12542o("users/@me/phone")
    Observable<Void> userAddPhone(@InterfaceC12528a RestAPIParams.Phone body);

    @InterfaceC12542o("users/@me/phone/verify")
    Observable<Void> userAddPhoneNoPassword(@InterfaceC12528a RestAPIParams.VerificationCodeOnly body);

    @InterfaceC12541n("users/@me/agreements")
    Observable<Void> userAgreements(@InterfaceC12528a RestAPIParams.UserAgreements body);

    @InterfaceC12542o("users/@me/captcha/verify")
    Observable<Void> userCaptchaVerify(@InterfaceC12528a RestAPIParams.CaptchaCode body);

    @InterfaceC12542o("users/@me/channels")
    Observable<Channel> userCreateChannel(@InterfaceC12528a RestAPIParams.CreateChannel body);

    @InterfaceC12542o("users/@me/devices")
    Observable<Void> userCreateDevice(@InterfaceC12528a RestAPIParams.UserDevices body);

    @InterfaceC12543p("users/@me/email")
    Observable<Void> userEmail();

    @InterfaceC12542o("users/@me/email/verify-code")
    Observable<ModelEmailChangeConfirm> userEmailVerifyCode(@InterfaceC12528a RestAPIParams.UserEmailConfirmCode body);

    @InterfaceC12533f("users/{userId}")
    Observable<User> userGet(@InterfaceC12546s("userId") long userId);

    @InterfaceC12535h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/phone")
    Observable<Void> userPhoneDelete(@InterfaceC12528a RestAPIParams.DeletePhone body);

    @InterfaceC12542o("users/@me/phone")
    Observable<Void> userPhoneWithToken(@InterfaceC12528a RestAPIParams.VerificationPhoneCode body);

    @InterfaceC12533f("users/{userId}/profile")
    Observable<UserProfile> userProfileGet(@InterfaceC12546s("userId") long userId, @InterfaceC12547t("with_mutual_guilds") boolean withMutualGuilds, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId);

    @InterfaceC12542o("guilds/automations/email-domain-lookup")
    Observable<Response<EmailVerification>> verifyEmail(@InterfaceC12528a RestAPIParams.VerifyEmail body);

    @InterfaceC12542o("guilds/automations/email-domain-lookup/verify-code")
    Observable<Response<EmailVerificationCode>> verifyEmailCode(@InterfaceC12528a RestAPIParams.VerifyEmailCode body);

    @InterfaceC12542o("google-play/verify-purchase-token")
    Observable<RestAPIParams.VerifyPurchaseResponse> verifyPurchaseToken(@InterfaceC12528a RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseBody);
}
