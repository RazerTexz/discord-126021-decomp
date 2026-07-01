package com.discord.utilities.rest;

import android.util.Base64;
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
import com.discord.api.message.activity.MessageActivityType;
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
import com.discord.api.user.UserProfile;
import com.discord.api.user.UserSurveyFetchResponse;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
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
import com.discord.models.user.User;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIInterface$Dynamic;
import com.discord.restapi.RestAPIInterface$Files;
import com.discord.restapi.RestAPIInterface$RtcLatency;
import com.discord.restapi.RestAPIParams$ActivateMfaSMS;
import com.discord.restapi.RestAPIParams$AddServerBody;
import com.discord.restapi.RestAPIParams$ApplicationCommand;
import com.discord.restapi.RestAPIParams$AuthLogin;
import com.discord.restapi.RestAPIParams$AuthRegister;
import com.discord.restapi.RestAPIParams$AuthRegisterPhone;
import com.discord.restapi.RestAPIParams$AuthorizeIP;
import com.discord.restapi.RestAPIParams$BanGuildMember;
import com.discord.restapi.RestAPIParams$CaptchaCode;
import com.discord.restapi.RestAPIParams$ChannelFollowerPost;
import com.discord.restapi.RestAPIParams$ChannelMessagesAck;
import com.discord.restapi.RestAPIParams$ChannelPermissionOverwrites;
import com.discord.restapi.RestAPIParams$ChannelPosition;
import com.discord.restapi.RestAPIParams$ChannelVoiceStateUpdate;
import com.discord.restapi.RestAPIParams$ComponentInteraction;
import com.discord.restapi.RestAPIParams$ConnectedAccount;
import com.discord.restapi.RestAPIParams$ConnectedAccountContacts;
import com.discord.restapi.RestAPIParams$ConnectedAccountNameOnly;
import com.discord.restapi.RestAPIParams$ConnectionState;
import com.discord.restapi.RestAPIParams$Consents;
import com.discord.restapi.RestAPIParams$CreateChannel;
import com.discord.restapi.RestAPIParams$CreateGuild;
import com.discord.restapi.RestAPIParams$CreateGuildChannel;
import com.discord.restapi.RestAPIParams$CreateGuildFromTemplate;
import com.discord.restapi.RestAPIParams$CreateGuildRoleSubscriptionGroupListing;
import com.discord.restapi.RestAPIParams$CreateGuildRoleSubscriptionTierListing;
import com.discord.restapi.RestAPIParams$CreateGuildScheduledEventBody;
import com.discord.restapi.RestAPIParams$DeleteGuild;
import com.discord.restapi.RestAPIParams$DeletePhone;
import com.discord.restapi.RestAPIParams$DisableAccount;
import com.discord.restapi.RestAPIParams$DisableGuildCommunication;
import com.discord.restapi.RestAPIParams$DowngradeSubscriptionBody;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.restapi.RestAPIParams$EnableIntegration;
import com.discord.restapi.RestAPIParams$EnableMFA;
import com.discord.restapi.RestAPIParams$ForgotPassword;
import com.discord.restapi.RestAPIParams$GenerateGiftCode;
import com.discord.restapi.RestAPIParams$GetForumPostData;
import com.discord.restapi.RestAPIParams$GreetMessage;
import com.discord.restapi.RestAPIParams$GroupDM;
import com.discord.restapi.RestAPIParams$GuildBoosting;
import com.discord.restapi.RestAPIParams$GuildFeatureAck;
import com.discord.restapi.RestAPIParams$GuildIntegration;
import com.discord.restapi.RestAPIParams$GuildMFA;
import com.discord.restapi.RestAPIParams$GuildMember;
import com.discord.restapi.RestAPIParams$GuildMemberDisconnect;
import com.discord.restapi.RestAPIParams$HubWaitlist;
import com.discord.restapi.RestAPIParams$Invite;
import com.discord.restapi.RestAPIParams$InviteCode;
import com.discord.restapi.RestAPIParams$InvoicePreviewBody;
import com.discord.restapi.RestAPIParams$LeaveGuildBody;
import com.discord.restapi.RestAPIParams$MFALogin;
import com.discord.restapi.RestAPIParams$MemberVerificationForm;
import com.discord.restapi.RestAPIParams$Message;
import com.discord.restapi.RestAPIParams$ModalInteraction;
import com.discord.restapi.RestAPIParams$Nick;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponseGet;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponsePost;
import com.discord.restapi.RestAPIParams$PatchGuildEmoji;
import com.discord.restapi.RestAPIParams$Phone;
import com.discord.restapi.RestAPIParams$PostGuildEmoji;
import com.discord.restapi.RestAPIParams$PruneGuild;
import com.discord.restapi.RestAPIParams$PurchaseMetadataBody;
import com.discord.restapi.RestAPIParams$RemoteAuthCancel;
import com.discord.restapi.RestAPIParams$RemoteAuthFinish;
import com.discord.restapi.RestAPIParams$RemoteAuthInitialize;
import com.discord.restapi.RestAPIParams$Report;
import com.discord.restapi.RestAPIParams$Ring;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.restapi.RestAPIParams$StartStageInstanceBody;
import com.discord.restapi.RestAPIParams$TextChannel;
import com.discord.restapi.RestAPIParams$ThreadCreationSettings;
import com.discord.restapi.RestAPIParams$ThreadMemberSettings;
import com.discord.restapi.RestAPIParams$ThreadSettings;
import com.discord.restapi.RestAPIParams$Thumbnail;
import com.discord.restapi.RestAPIParams$TopicalChannel;
import com.discord.restapi.RestAPIParams$TransferGuildOwnership;
import com.discord.restapi.RestAPIParams$UpdateGuild;
import com.discord.restapi.RestAPIParams$UpdateGuildRoleSubscriptionGroupListing;
import com.discord.restapi.RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial;
import com.discord.restapi.RestAPIParams$UpdateGuildRoleSubscriptionTierListing;
import com.discord.restapi.RestAPIParams$UpdateGuildScheduledEventBody;
import com.discord.restapi.RestAPIParams$UpdateStageInstanceBody;
import com.discord.restapi.RestAPIParams$UpdateSubscription;
import com.discord.restapi.RestAPIParams$UploadContacts;
import com.discord.restapi.RestAPIParams$UserAgreements;
import com.discord.restapi.RestAPIParams$UserBulkRelationship;
import com.discord.restapi.RestAPIParams$UserDevices;
import com.discord.restapi.RestAPIParams$UserEmailConfirmCode;
import com.discord.restapi.RestAPIParams$UserGuildSettings;
import com.discord.restapi.RestAPIParams$UserInfo;
import com.discord.restapi.RestAPIParams$UserNoteUpdate;
import com.discord.restapi.RestAPIParams$UserRelationship;
import com.discord.restapi.RestAPIParams$UserRelationship$Add;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.restapi.RestAPIParams$UserSettingsCustomStatus;
import com.discord.restapi.RestAPIParams$VanityUrl;
import com.discord.restapi.RestAPIParams$VerificationCode;
import com.discord.restapi.RestAPIParams$VerificationCodeOnly;
import com.discord.restapi.RestAPIParams$VerificationCodeResend;
import com.discord.restapi.RestAPIParams$VerificationPhoneCode;
import com.discord.restapi.RestAPIParams$VerifyEmail;
import com.discord.restapi.RestAPIParams$VerifyEmailCode;
import com.discord.restapi.RestAPIParams$VerifyPurchaseResponse;
import com.discord.restapi.RestAPIParams$VerifyPurchaseTokenBody;
import com.discord.restapi.RestAPIParams$VoiceChannel;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.g0.c;
import d0.t.n;
import d0.z.d.m;
import i0.f0.a;
import i0.f0.b;
import i0.f0.f;
import i0.f0.h;
import i0.f0.i;
import i0.f0.l;
import i0.f0.o;
import i0.f0.p;
import i0.f0.q;
import i0.f0.s;
import i0.f0.t;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import okhttp3.Interceptor;
import okhttp3.MultipartBody$Part;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI implements RestAPIInterface {
    public static final RestAPI$Companion Companion = new RestAPI$Companion(null);
    public static RestAPI api;
    public static RestAPIInterface$Dynamic apiClientVersions;
    public static RestAPIInterface$Files apiFiles;
    public static RestAPIInterface$RtcLatency apiRtcLatency;
    public static RestAPI apiSerializeNulls;
    public static RestAPI apiSpotify;
    private final RestAPIInterface _api;

    public RestAPI(RestAPIInterface restAPIInterface) {
        m.checkNotNullParameter(restAPIInterface, "_api");
        this._api = restAPIInterface;
    }

    public static final /* synthetic */ RestAPI access$getApi$cp() {
        return api;
    }

    public static final /* synthetic */ RestAPIInterface$Dynamic access$getApiClientVersions$cp() {
        return apiClientVersions;
    }

    public static final /* synthetic */ RestAPIInterface$Files access$getApiFiles$cp() {
        return apiFiles;
    }

    public static final /* synthetic */ RestAPIInterface$RtcLatency access$getApiRtcLatency$cp() {
        return apiRtcLatency;
    }

    public static final /* synthetic */ RestAPI access$getApiSerializeNulls$cp() {
        return apiSerializeNulls;
    }

    public static final /* synthetic */ RestAPI access$getApiSpotify$cp() {
        return apiSpotify;
    }

    public static final /* synthetic */ RestAPIInterface access$get_api$p(RestAPI restAPI) {
        return restAPI._api;
    }

    public static final /* synthetic */ void access$setApi$cp(RestAPI restAPI) {
        api = restAPI;
    }

    public static final /* synthetic */ void access$setApiClientVersions$cp(RestAPIInterface$Dynamic restAPIInterface$Dynamic) {
        apiClientVersions = restAPIInterface$Dynamic;
    }

    public static final /* synthetic */ void access$setApiFiles$cp(RestAPIInterface$Files restAPIInterface$Files) {
        apiFiles = restAPIInterface$Files;
    }

    public static final /* synthetic */ void access$setApiRtcLatency$cp(RestAPIInterface$RtcLatency restAPIInterface$RtcLatency) {
        apiRtcLatency = restAPIInterface$RtcLatency;
    }

    public static final /* synthetic */ void access$setApiSerializeNulls$cp(RestAPI restAPI) {
        apiSerializeNulls = restAPI;
    }

    public static final /* synthetic */ void access$setApiSpotify$cp(RestAPI restAPI) {
        apiSpotify = restAPI;
    }

    public static /* synthetic */ Observable addRelationship$default(RestAPI restAPI, String str, long j, Integer num, String str2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        return restAPI.addRelationship(str, j, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : captchaHelper$CaptchaPayload);
    }

    public static final Interceptor buildAnalyticsInterceptor() {
        return Companion.buildAnalyticsInterceptor();
    }

    public static final Interceptor buildLoggingInterceptor() {
        return Companion.buildLoggingInterceptor();
    }

    public static /* synthetic */ Observable editTextChannel$default(RestAPI restAPI, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        return restAPI.editTextChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    public static /* synthetic */ Observable editVoiceChannel$default(RestAPI restAPI, long j, String str, String str2, Boolean bool, Integer num, Integer num2, Integer num3, String str3, int i, Object obj) {
        return restAPI.editVoiceChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : str3);
    }

    public static final RestAPI getApi() {
        RestAPI restAPI = api;
        if (restAPI == null) {
            m.throwUninitializedPropertyAccessException("api");
        }
        return restAPI;
    }

    public static final RestAPI getApiSerializeNulls() {
        RestAPI restAPI = apiSerializeNulls;
        if (restAPI == null) {
            m.throwUninitializedPropertyAccessException("apiSerializeNulls");
        }
        return restAPI;
    }

    public static final RestAPI getApiSpotify() {
        RestAPI restAPI = apiSpotify;
        if (restAPI == null) {
            m.throwUninitializedPropertyAccessException("apiSpotify");
        }
        return restAPI;
    }

    public static /* synthetic */ Observable getAuditLogs$default(RestAPI restAPI, long j, Long l, Long l2, Integer num, int i, Object obj) {
        return restAPI.getAuditLogs(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num);
    }

    public static /* synthetic */ Observable inviteUserToSpeak$default(RestAPI restAPI, Channel channel, long j, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return restAPI.inviteUserToSpeak(channel, j, clock);
    }

    public static /* synthetic */ Observable postInviteCode$default(RestAPI restAPI, ModelInvite modelInvite, String str, RestAPIParams$InviteCode restAPIParams$InviteCode, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "mobile";
        }
        return restAPI.postInviteCode(modelInvite, str, restAPIParams$InviteCode);
    }

    public static /* synthetic */ Observable requestToSpeak$default(RestAPI restAPI, Channel channel, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            clock = ClockFactory.get();
        }
        return restAPI.requestToSpeak(channel, clock);
    }

    public static final void setApi(RestAPI restAPI) {
        api = restAPI;
    }

    public static final void setApiSerializeNulls(RestAPI restAPI) {
        apiSerializeNulls = restAPI;
    }

    public static final void setApiSpotify(RestAPI restAPI) {
        apiSpotify = restAPI;
    }

    private final Observable<Void> setConsent(String grant, String revoke) {
        List listEmptyList;
        List listEmptyList2;
        if (grant == null || (listEmptyList = d0.t.m.listOf(grant)) == null) {
            listEmptyList = n.emptyList();
        }
        if (revoke == null || (listEmptyList2 = d0.t.m.listOf(revoke)) == null) {
            listEmptyList2 = n.emptyList();
        }
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.setConsents(new RestAPIParams$Consents(listEmptyList, listEmptyList2)), false, 1, null);
    }

    public static /* synthetic */ Observable setConsent$default(RestAPI restAPI, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return restAPI.setConsent(str, str2);
    }

    public static /* synthetic */ Observable userActivityActionJoin$default(RestAPI restAPI, long j, long j2, String str, Long l, Long l2, int i, Object obj) {
        return restAPI.userActivityActionJoin(j, j2, str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/creator-monetization/{requestId}/accept-terms")
    public Observable<CreatorMonetizationEnableRequest> acceptCreatorMonetizationTerms(@s("guildId") long guildId, @s("requestId") long requestId) {
        return this._api.acceptCreatorMonetizationTerms(guildId, requestId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("entitlements/gift-codes/{code}/redeem")
    public Observable<Void> acceptGift(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.acceptGift(code);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/ack")
    public Observable<Void> ackGuild(@s("guildId") long guildId) {
        return this._api.ackGuild(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/requests/@me/ack")
    public Observable<Void> ackGuildJoinRequest(@s("guildId") long guildId) {
        return this._api.ackGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("channels/{channelId}/pins/{messageId}")
    public Observable<Void> addChannelPin(@s("channelId") long channelId, @s("messageId") long messageId) {
        return this._api.addChannelPin(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("channels/{channelId}/recipients/{recipientId}")
    public Observable<Void> addChannelRecipient(@s("channelId") long channelId, @s("recipientId") long recipientId) {
        return this._api.addChannelRecipient(channelId, recipientId);
    }

    public final Observable<Channel> addGroupRecipients(long channelId, List<? extends User> recipients) {
        m.checkNotNullParameter(recipients, "recipients");
        Observable<Channel> observableY = StoreStream.Companion.getChannels().observePrivateChannel(channelId).y(RestAPI$addGroupRecipients$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…nnel -> channel != null }");
        Observable observableY2 = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null).Y(new RestAPI$addGroupRecipients$2(this, channelId, recipients)).Y(new RestAPI$addGroupRecipients$3(this, channelId, recipients)).Y(RestAPI$addGroupRecipients$4.INSTANCE);
        m.checkNotNullExpressionValue(observableY2, "StoreStream\n          .g….filterNull()\n          }");
        return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY2, 0L, false, 3, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    public Observable<Void> addReaction(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        return this._api.addReaction(channelId, messageId, reaction);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("users/@me/relationships/{userId}")
    public Observable<Void> addRelationship(@s("userId") long userId, @a RestAPIParams$UserRelationship relationship, @i("X-Context-Properties") String context) {
        m.checkNotNullParameter(relationship, "relationship");
        m.checkNotNullParameter(context, "context");
        return this._api.addRelationship(userId, relationship, context);
    }

    public final Observable<Void> addRelationship(String location, long userId, Integer type, String friendToken, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.addRelationship(userId, new RestAPIParams$UserRelationship(type, friendToken, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), jsonObjectOf(d0.o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/directory-entry/{guildId}")
    public Observable<Response<DirectoryEntryGuild>> addServerToHub(@s("channelId") long channelId, @s("guildId") long guildId, @a RestAPIParams$AddServerBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.addServerToHub(channelId, guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("connections/{connection}/authorize")
    public Observable<ModelUrl> authorizeConnection(@s("connection") String connection) {
        m.checkNotNullParameter(connection, "connection");
        return this._api.authorizeConnection(connection);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/authorize-ip")
    public Observable<Response<Void>> authorizeIP(@a RestAPIParams$AuthorizeIP body) {
        m.checkNotNullParameter(body, "body");
        return this._api.authorizeIP(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("guilds/{guildId}/bans/{userId}")
    public Observable<Void> banGuildMember(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$BanGuildMember body, @i("X-Audit-Log-Reason") String reason) {
        m.checkNotNullParameter(body, "body");
        return this._api.banGuildMember(guildId, userId, body, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/roles")
    public Observable<Void> batchUpdateRole(@s("guildId") long guildId, @a List<RestAPIParams$Role> body) {
        m.checkNotNullParameter(body, "body");
        return this._api.batchUpdateRole(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/relationships/bulk")
    public Observable<Response<BulkAddFriendsResponse>> bulkAddRelationships(@a RestAPIParams$UserBulkRelationship body) {
        m.checkNotNullParameter(body, "body");
        return this._api.bulkAddRelationships(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/call")
    public Observable<ModelCall$Ringable> call(@s("channelId") long channelId) {
        return this._api.call(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/cancel")
    public Observable<ModelGuildBoostSlot> cancelSubscriptionSlot(@s("subscriptionSlotId") long slotId) {
        return this._api.cancelSubscriptionSlot(slotId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/members/{userId}")
    public Observable<Void> changeGuildMember(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$GuildMember body) {
        m.checkNotNullParameter(body, "body");
        return this._api.changeGuildMember(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/members/@me/nick")
    public Observable<Void> changeGuildNickname(@s("guildId") long guildId, @a RestAPIParams$Nick body) {
        m.checkNotNullParameter(body, "body");
        return this._api.changeGuildNickname(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("outbound-promotions/{promotionId}/claim")
    public Observable<ClaimedOutboundPromotion> claimOutboundPromotion(@s("promotionId") long promotionId) {
        return this._api.claimOutboundPromotion(promotionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("store/skus/{skuId}/purchase")
    public Observable<Unit> claimSku(@s("skuId") long skuId, @a RestAPIParams$EmptyBody emptyBody) {
        m.checkNotNullParameter(emptyBody, "emptyBody");
        return this._api.claimSku(skuId, emptyBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("channels/{channelId}/recipients/{recipientId}")
    public Observable<Channel> convertDMToGroup(@s("channelId") long channelId, @s("recipientId") long recipientId) {
        return this._api.convertDMToGroup(channelId, recipientId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/followers")
    public Observable<Void> createChannelFollower(@s("channelId") long channelId, @a RestAPIParams$ChannelFollowerPost body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createChannelFollower(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("users/@me/connections/contacts/@me")
    public Observable<ConnectedAccount> createConnectionContacts(@a RestAPIParams$ConnectedAccountContacts connectedAccountContacts) {
        m.checkNotNullParameter(connectedAccountContacts, "connectedAccountContacts");
        return this._api.createConnectionContacts(connectedAccountContacts);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/creator-monetization/enable-requests")
    public Observable<CreatorMonetizationEnableRequest> createCreatorMonetizationEnableRequest(@s("guildId") long guildId) {
        return this._api.createCreatorMonetizationEnableRequest(guildId);
    }

    public final Observable<Channel> createGroupDM(List<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable<Channel> observableU = ObservableExtensionsKt.restSubscribeOn$default(this._api.userCreateChannel(new RestAPIParams$CreateChannel(userIds)), false, 1, null).u(RestAPI$createGroupDM$1.INSTANCE);
        m.checkNotNullExpressionValue(observableU, "_api\n      .userCreateCh…pCreated(channel)\n      }");
        return observableU;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds")
    public Observable<Response<Guild>> createGuild(@a RestAPIParams$CreateGuild body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createGuild(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/channels")
    public Observable<Response<Channel>> createGuildChannel(@s("guildId") long guildId, @a RestAPIParams$CreateGuildChannel body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createGuildChannel(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/templates/{guildTemplateCode}")
    public Observable<Guild> createGuildFromTemplate(@s("guildTemplateCode") String guildTemplateCode, @a RestAPIParams$CreateGuildFromTemplate body) {
        m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        m.checkNotNullParameter(body, "body");
        return this._api.createGuildFromTemplate(guildTemplateCode, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> createGuildJoinRequest(@s("guildId") long guildId, @a RestAPIParams$MemberVerificationForm body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createGuildJoinRequest(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/role-subscriptions/group-listings")
    public Observable<GuildRoleSubscriptionGroupListing> createGuildRoleSubscriptionGroupListing(@s("guildId") long guildId, @a RestAPIParams$CreateGuildRoleSubscriptionGroupListing body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createGuildRoleSubscriptionGroupListing(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings")
    public Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTier(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @a RestAPIParams$CreateGuildRoleSubscriptionTierListing body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createGuildRoleSubscriptionTier(guildId, groupListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/scheduled-events")
    public Observable<GuildScheduledEvent> createGuildScheduledEvent(@s("guildId") long guildId, @a RestAPIParams$CreateGuildScheduledEventBody event) {
        m.checkNotNullParameter(event, "event");
        return this._api.createGuildScheduledEvent(guildId, event);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    public Observable<Unit> createGuildScheduledEventRsvp(@s("guildId") long guildId, @s("eventId") long eventId) {
        return this._api.createGuildScheduledEventRsvp(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/handoff")
    public Observable<HandoffToken> createHandoffToken(@a CreateHandoffTokenRequest body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createHandoffToken(body);
    }

    public final Observable<HandoffToken> createHandoffTokenWithNonce(String nonce) {
        m.checkNotNullParameter(nonce, "nonce");
        return this._api.createHandoffToken(new CreateHandoffTokenRequest(nonce));
    }

    public final Observable<Channel> createOrFetchDM(long userId) {
        Observable<Channel> observableY = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.Companion.getChannels().observePrivateChannels(), 0L, false, 3, null).Y(new RestAPI$createOrFetchDM$1(this, userId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
        return observableY;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("google-play/purchase-metadata")
    public Observable<Unit> createPurchaseMetadata(@a RestAPIParams$PurchaseMetadataBody purchaseMetadataBody) {
        m.checkNotNullParameter(purchaseMetadataBody, "purchaseMetadataBody");
        return this._api.createPurchaseMetadata(purchaseMetadataBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/roles")
    public Observable<GuildRole> createRole(@s("guildId") long guildId) {
        return this._api.createRole(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/threads")
    public Observable<Channel> createThread(@s("channelId") long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @a RestAPIParams$ThreadCreationSettings body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createThread(channelId, location, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/messages/{messageId}/threads")
    public Observable<Channel> createThreadFromMessage(@s("channelId") long channelId, @s("messageId") long messageId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @a RestAPIParams$ThreadCreationSettings body) {
        m.checkNotNullParameter(body, "body");
        return this._api.createThreadFromMessage(channelId, messageId, location, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/threads?has_message=true")
    @l
    public Observable<Channel> createThreadWithMessage(@s("channelId") long channelId, @q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @q("content") String content, @q("applied_tags") List<Long> appliedTags, @q("sticker_ids") List<Long> stickerIds, @q("type") int type, @q(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION) Integer autoArchiveDuration, @q MultipartBody$Part[] files) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(content, "content");
        m.checkNotNullParameter(appliedTags, "appliedTags");
        m.checkNotNullParameter(stickerIds, "stickerIds");
        m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.createThreadWithMessage(channelId, name, content, appliedTags, stickerIds, type, autoArchiveDuration, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/messages/{messageId}/crosspost")
    public Observable<Void> crosspostMessage(@s("channelId") long channelId, @s("messageId") Long messageId) {
        return this._api.crosspostMessage(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/delete")
    public Observable<Void> deleteAccount(@a RestAPIParams$DisableAccount body) {
        m.checkNotNullParameter(body, "body");
        return this._api.deleteAccount(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}")
    public Observable<Channel> deleteChannel(@s("channelId") long channelId) {
        return this._api.deleteChannel(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/pins/{messageId}")
    public Observable<Void> deleteChannelPin(@s("channelId") long channelId, @s("messageId") long messageId) {
        return this._api.deleteChannelPin(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("users/@me/connections/{connection}/{connectionId}")
    public Observable<Response<Void>> deleteConnection(@s("connection") String connection, @s("connectionId") String connectionId) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(connectionId, "connectionId");
        return this._api.deleteConnection(connection, connectionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/delete")
    public Observable<Void> deleteGuild(@s("guildId") long guildId, @a RestAPIParams$DeleteGuild body) {
        m.checkNotNullParameter(body, "body");
        return this._api.deleteGuild(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/emojis/{emojiId}")
    public Observable<Void> deleteGuildEmoji(@s("guildId") long guildId, @s("emojiId") long emojiId) {
        return this._api.deleteGuildEmoji(guildId, emojiId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/integrations/{integrationId}")
    public Observable<Void> deleteGuildIntegration(@s("guildId") long guildId, @s("integrationId") long integrationId) {
        return this._api.deleteGuildIntegration(guildId, integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> deleteGuildJoinRequest(@s("guildId") long guildId) {
        return this._api.deleteGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    public Observable<Void> deleteGuildRoleSubscriptionTierListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @s("listingId") long tierListingId) {
        return this._api.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<Void> deleteGuildScheduledEvent(@s("guildId") long guildId, @s("eventId") long eventId) {
        return this._api.deleteGuildScheduledEvent(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    public Observable<Void> deleteGuildScheduledEventRsvp(@s("guildId") long guildId, @s("eventId") long eventId) {
        return this._api.deleteGuildScheduledEventRsvp(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channel_id}/messages/{message_id}")
    public Observable<Void> deleteMessage(@s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @s("message_id") long messageId) {
        return this._api.deleteMessage(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("oauth2/tokens/{oauthId}")
    public Observable<Void> deleteOAuthToken(@s("oauthId") long oauthId) {
        return this._api.deleteOAuthToken(oauthId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("users/@me/billing/payment-sources/{paymentSourceId}")
    public Observable<Void> deletePaymentSource(@s("paymentSourceId") String paymentSourceId) {
        m.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        return this._api.deletePaymentSource(paymentSourceId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/permissions/{targetId}")
    public Observable<Void> deletePermissionOverwrites(@s("channelId") long channelId, @s("targetId") long targetId) {
        return this._api.deletePermissionOverwrites(channelId, targetId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/roles/{roleId}")
    public Observable<Void> deleteRole(@s("guildId") long guildId, @s("roleId") long roleId) {
        return this._api.deleteRole(guildId, roleId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("users/@me/billing/subscriptions/{subscriptionId}")
    public Observable<Void> deleteSubscription(@s("subscriptionId") String subscriptionId) {
        m.checkNotNullParameter(subscriptionId, "subscriptionId");
        return this._api.deleteSubscription(subscriptionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/disable")
    public Observable<Void> disableAccount(@a RestAPIParams$DisableAccount body) {
        m.checkNotNullParameter(body, "body");
        return this._api.disableAccount(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/members/{userId}")
    public Observable<Response<Void>> disableGuildCommunication(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$DisableGuildCommunication body, @i("X-Audit-Log-Reason") String reason) {
        m.checkNotNullParameter(body, "body");
        return this._api.disableGuildCommunication(guildId, userId, body, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/mfa/totp/disable")
    public Observable<DisableMfaResponse> disableMFA(@a DisableMfaRequestBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.disableMFA(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/mfa/sms/disable")
    public Observable<Void> disableMfaSMS(@a RestAPIParams$ActivateMfaSMS body) {
        m.checkNotNullParameter(body, "body");
        return this._api.disableMfaSMS(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/members/{userId}")
    public Observable<Void> disconnectGuildMember(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$GuildMemberDisconnect body) {
        m.checkNotNullParameter(body, "body");
        return this._api.disconnectGuildMember(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("google-play/downgrade-subscription")
    public Observable<Object> downgradeSubscription(@a RestAPIParams$DowngradeSubscriptionBody downgradeSubscriptionBody) {
        m.checkNotNullParameter(downgradeSubscriptionBody, "downgradeSubscriptionBody");
        return this._api.downgradeSubscription(downgradeSubscriptionBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}")
    public Observable<Channel> editGroupDM(@s("channelId") long channelId, @a RestAPIParams$GroupDM body) {
        m.checkNotNullParameter(body, "body");
        return this._api.editGroupDM(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channel_id}/messages/{message_id}")
    public Observable<Message> editMessage(@s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @s("message_id") long messageId, @a RestAPIParams$Message message) {
        m.checkNotNullParameter(message, "message");
        return this._api.editMessage(channelId, messageId, message);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}")
    public Observable<Channel> editTextChannel(@s("channelId") long channelId, @a RestAPIParams$TextChannel body) {
        m.checkNotNullParameter(body, "body");
        return this._api.editTextChannel(channelId, body);
    }

    public final Observable<Channel> editTextChannel(long channelId, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.editTextChannel(channelId, new RestAPIParams$TextChannel(name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}")
    public Observable<Channel> editThread(@s("channelId") long channelId, @a RestAPIParams$ThreadSettings body) {
        m.checkNotNullParameter(body, "body");
        return this._api.editThread(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}")
    public Observable<Channel> editTopicalChannel(@s("channelId") long channelId, @a RestAPIParams$TopicalChannel body) {
        m.checkNotNullParameter(body, "body");
        return this._api.editTopicalChannel(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}")
    public Observable<Channel> editVoiceChannel(@s("channelId") long channelId, @a RestAPIParams$VoiceChannel body) {
        m.checkNotNullParameter(body, "body");
        return this._api.editVoiceChannel(channelId, body);
    }

    public final Observable<Channel> editVoiceChannel(long channelId, String name, String topic, Boolean nsfw, Integer type, Integer bitrate, Integer userLimit, String rtcRegion) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.editVoiceChannel(channelId, new RestAPIParams$VoiceChannel(name, topic, type, nsfw, userLimit, bitrate, rtcRegion)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/integrations")
    public Observable<Void> enableIntegration(@s("guildId") long guildId, @a RestAPIParams$EnableIntegration body) {
        m.checkNotNullParameter(body, "body");
        return this._api.enableIntegration(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/mfa/totp/enable")
    public Observable<EnableMfaResponse> enableMFA(@a RestAPIParams$EnableMFA body) {
        m.checkNotNullParameter(body, "body");
        return this._api.enableMFA(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/mfa/sms/enable")
    public Observable<Void> enableMfaSMS(@a RestAPIParams$ActivateMfaSMS body) {
        m.checkNotNullParameter(body, "body");
        return this._api.enableMfaSMS(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("stage-instances/{channelId}")
    public Observable<Unit> endStageInstance(@s("channelId") long channelId) {
        return this._api.endStageInstance(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/forgot")
    public Observable<Response<Void>> forgotPassword(@a RestAPIParams$ForgotPassword body) {
        m.checkNotNullParameter(body, "body");
        return this._api.forgotPassword(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/entitlements/gift-codes")
    public Observable<ModelGift> generateGiftCode(@a RestAPIParams$GenerateGiftCode body) {
        m.checkNotNullParameter(body, "body");
        return this._api.generateGiftCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/metadata")
    public Observable<ActivityMetadata> getActivityMetadata(@s("userId") long userId, @s("sessionId") String sessionId, @s("applicationId") long applicationId) {
        m.checkNotNullParameter(sessionId, "sessionId");
        return this._api.getActivityMetadata(userId, sessionId, applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("outbound-promotions")
    public Observable<List<OutboundPromotion>> getAllActiveOutboundPromotions() {
        return this._api.getAllActiveOutboundPromotions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("outbound-promotions/preview")
    public Observable<List<OutboundPromotion>> getAllPreviewPromotions() {
        return this._api.getAllPreviewPromotions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/threads/archived/private")
    public Observable<ThreadListing> getAllPrivateArchivedThreads(@s("channelId") long channelId, @t("before") String before) {
        return this._api.getAllPrivateArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/threads/archived/public")
    public Observable<ThreadListing> getAllPublicArchivedThreads(@s("channelId") long channelId, @t("before") String before) {
        return this._api.getAllPublicArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("oauth2/applications/{applicationId}/assets")
    public Observable<List<ApplicationAsset>> getApplicationAssets(@s("applicationId") long applicationId) {
        return this._api.getApplicationAssets(applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("applications/{botId}/commands")
    public Observable<List<ApplicationCommand>> getApplicationCommands(@s("botId") long botId) {
        return this._api.getApplicationCommands(botId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("applications/public")
    public Observable<List<Application>> getApplications(@t("application_ids") long appIds) {
        return this._api.getApplications(appIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/audit-logs")
    public Observable<ModelAuditLog> getAuditLogs(@s("guildId") long guildId, @t("limit") int limit, @t("before") Long before, @t("user_id") Long userId, @t("action_type") Integer actionType) {
        return this._api.getAuditLogs(guildId, limit, before, userId, actionType);
    }

    public final Observable<ModelAuditLog> getAuditLogs(long guildId, Long before, Long userId, Integer actionType) {
        return this._api.getAuditLogs(guildId, 50, before, (userId != null && userId.longValue() == 0) ? null : userId, (actionType != null && actionType.intValue() == 0) ? null : actionType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/mfa/codes")
    public Observable<GetBackupCodesResponse> getBackupCodes(@a GetBackupCodesRequestBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.getBackupCodes(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/verify/view-backup-codes-challenge")
    public Observable<GetBackupCodesSendVerificationKeyResponse> getBackupCodesSendVerificationKey(@a GetBackupCodesSendVerificationKeyRequestBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.getBackupCodesSendVerificationKey(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/mfa/codes-verification")
    public Observable<GetBackupCodesResponse> getBackupCodesVerification(@a GetBackupCodesVerificationRequestBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.getBackupCodesVerification(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/bans")
    public Observable<List<ModelBan>> getBans(@s("guildId") long guildId) {
        return this._api.getBans(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("private/bug-reports")
    public Observable<BugReportConfig> getBugReportConfig() {
        return this._api.getBugReportConfig();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}")
    public Observable<Channel> getChannel(@s("channelId") long channelId) {
        return this._api.getChannel(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/follower-stats")
    public Observable<ModelChannelFollowerStatsDto> getChannelFollowerStats(@s("channelId") long channelId) {
        return this._api.getChannelFollowerStats(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/messages")
    public Observable<List<Message>> getChannelMessages(@s("channelId") long channelId, @t("before") Long before, @t("after") Long after, @t("limit") Integer limit) {
        return this._api.getChannelMessages(channelId, before, after, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/messages")
    public Observable<List<Message>> getChannelMessagesAround(@s("channelId") long channelId, @t("limit") int limit, @t("around") long around) {
        return this._api.getChannelMessagesAround(channelId, limit, around);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/pins")
    public Observable<List<Message>> getChannelPins(@s("channelId") long channelId) {
        return this._api.getChannelPins(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/outbound-promotions/codes")
    public Observable<List<ClaimedOutboundPromotion>> getClaimedOutboundPromotions() {
        return this._api.getClaimedOutboundPromotions();
    }

    public final Observable<Integer> getClientVersion() {
        RestAPIInterface$Dynamic restAPIInterface$Dynamic = apiClientVersions;
        if (restAPIInterface$Dynamic == null) {
            m.throwUninitializedPropertyAccessException("apiClientVersions");
        }
        Observable<R> observableG = restAPIInterface$Dynamic.get("https://dl.discordapp.net/apps/android/versions.json").G(RestAPI$getClientVersion$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "apiClientVersions\n      …n_version\")?.asInt ?: 0 }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableG, false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/connections/{platformType}/{accountId}/access-token")
    public Observable<ModelConnectionAccessToken> getConnectionAccessToken(@s("platformType") String platformType, @s("accountId") String accountId) {
        m.checkNotNullParameter(platformType, "platformType");
        m.checkNotNullParameter(accountId, "accountId");
        return this._api.getConnectionAccessToken(platformType, accountId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("connections/{connection}/callback-continuation/{pinNumber}")
    public Observable<ModelConnectionState> getConnectionState(@s("connection") String connection, @s("pinNumber") String pinNumber) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(pinNumber, "pinNumber");
        return this._api.getConnectionState(connection, pinNumber);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/connections")
    public Observable<List<ConnectedAccount>> getConnections() {
        return this._api.getConnections();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/consent")
    public Observable<Consents> getConsents() {
        return this._api.getConsents();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/creator-monetization/requirements")
    public Observable<CreatorMonetizationEligibilityRequirements> getCreatorMonetizationEligibilityRequirements(@s("guildId") long guildId) {
        return this._api.getCreatorMonetizationEligibilityRequirements(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/directory-entries")
    public Observable<List<DirectoryEntryGuild>> getDirectoryEntries(@s("channelId") long channelId) {
        return this._api.getDirectoryEntries(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/directory-entries/broadcast")
    public Observable<GuildScheduledEventBroadcast> getDirectoryEntryBroadcastInfo(@s("guildId") long guildId, @t("entity_id") Long entityId, @t("type") int type) {
        return this._api.getDirectoryEntryBroadcastInfo(guildId, entityId, type);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/directory-entries")
    public Observable<List<DirectoryEntryEvent>> getDirectoryGuildScheduledEvents(@s("channelId") long channelId, @t("type") int type) {
        return this._api.getDirectoryGuildScheduledEvents(channelId, type);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("emojis/{emojiId}/guild")
    public Observable<Guild> getEmojiGuild(@s("emojiId") long emojiId) {
        return this._api.getEmojiGuild(emojiId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/directory-entries/counts")
    public Observable<Map<Integer, Integer>> getEntryCounts(@s("channelId") long channelId) {
        return this._api.getEntryCounts(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("experiments")
    public Observable<UnauthenticatedUserExperimentsDto> getExperiments() {
        return this._api.getExperiments();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/post-data")
    public Observable<ForumPostFirstMessages> getForumPostData(@s("channelId") long channelId, @a RestAPIParams$GetForumPostData body) {
        m.checkNotNullParameter(body, "body");
        return this._api.getForumPostData(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("friend-suggestions")
    public Observable<List<FriendSuggestion>> getFriendSuggestions() {
        return this._api.getFriendSuggestions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("gifs/search")
    public Observable<List<GifDto>> getGifSearchResults(@t("q") String query, @t("provider") String provider, @t("locale") String locale, @t("media_format") String mediaFormat, @t("limit") int limit) {
        m.checkNotNullParameter(query, "query");
        m.checkNotNullParameter(provider, "provider");
        m.checkNotNullParameter(locale, "locale");
        m.checkNotNullParameter(mediaFormat, "mediaFormat");
        return this._api.getGifSearchResults(query, provider, locale, mediaFormat, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("gifs/suggest")
    public Observable<List<String>> getGifSuggestedSearchTerms(@t("provider") String provider, @t("q") String query, @t("locale") String locale, @t("limit") int limit) {
        b.d.b.a.a.q0(provider, "provider", query, "query", locale, "locale");
        return this._api.getGifSuggestedSearchTerms(provider, query, locale, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("gifs/trending-search")
    public Observable<List<String>> getGifTrendingSearchTerms(@t("provider") String provider, @t("locale") String locale, @t("limit") int limit) {
        m.checkNotNullParameter(provider, "provider");
        m.checkNotNullParameter(locale, "locale");
        return this._api.getGifTrendingSearchTerms(provider, locale, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/entitlements/gifts")
    public Observable<List<ModelEntitlement>> getGifts() {
        return this._api.getGifts();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/applications")
    public Observable<List<Application>> getGuildApplications(@s("guildId") long guildId, @t("include_team") boolean includeTeam) {
        return this._api.getGuildApplications(guildId, includeTeam);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/emojis")
    public Observable<List<ModelEmojiGuild>> getGuildEmojis(@s("guildId") long guildId) {
        return this._api.getGuildEmojis(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/integrations")
    public Observable<List<ModelGuildIntegration>> getGuildIntegrations(@s("guildId") long guildId) {
        return this._api.getGuildIntegrations(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/invites")
    public Observable<List<ModelInvite>> getGuildInvites(@s("guildId") long guildId) {
        return this._api.getGuildInvites(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/member-verification")
    public Observable<ModelMemberVerificationForm> getGuildMemberVerificationForm(@s("guildId") long guildId) {
        return this._api.getGuildMemberVerificationForm(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/preview")
    public Observable<GuildPreview> getGuildPreview(@s("guildId") long guildId) {
        return this._api.getGuildPreview(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/roles/member-counts")
    public Observable<Map<Long, Integer>> getGuildRoleMemberCounts(@s("guildId") long guildId) {
        return this._api.getGuildRoleMemberCounts(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/roles/{roleId}/member-ids")
    public Observable<List<Long>> getGuildRoleMemberIds(@s("guildId") long guildId, @s("roleId") long roleId) {
        return this._api.getGuildRoleMemberIds(guildId, roleId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/role-subscriptions/trials")
    public Observable<List<GuildRoleSubscriptionTierFreeTrial>> getGuildRoleSubscriptionFreeTrials(@s("guildId") long guildId) {
        return this._api.getGuildRoleSubscriptionFreeTrials(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    public Observable<GuildRoleSubscriptionGroupListing> getGuildRoleSubscriptionGroupListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId) {
        return this._api.getGuildRoleSubscriptionGroupListing(guildId, groupListingId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/role-subscriptions/group-listings")
    public Observable<List<GuildRoleSubscriptionGroupListing>> getGuildRoleSubscriptionGroupListings(@s("guildId") long guildId) {
        return this._api.getGuildRoleSubscriptionGroupListings(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<GuildScheduledEvent> getGuildScheduledEvent(@s("guildId") long guildId, @s("eventId") long eventId) {
        return this._api.getGuildScheduledEvent(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/scheduled-events/{eventId}/users")
    public Observable<List<ApiGuildScheduledEventUser>> getGuildScheduledEventUsers(@s("guildId") long guildId, @s("eventId") long eventId, @t("limit") int limit, @t("with_member") boolean withMember, @t("upgrade_response_type") boolean upgradeResponseType) {
        return this._api.getGuildScheduledEventUsers(guildId, eventId, limit, withMember, upgradeResponseType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/scheduled-events")
    public Observable<List<GuildScheduledEvent>> getGuildScheduledEvents(@s("guildId") long guildId, @t("with_user_count") boolean withUserCount) {
        return this._api.getGuildScheduledEvents(guildId, withUserCount);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/templates/{guildTemplateCode}")
    public Observable<ModelGuildTemplate> getGuildTemplateCode(@s("guildTemplateCode") String guildTemplateCode) {
        m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this._api.getGuildTemplateCode(guildTemplateCode);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/regions")
    public Observable<List<ModelVoiceRegion>> getGuildVoiceRegions(@s("guildId") long guildId) {
        return this._api.getGuildVoiceRegions(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/welcome-screen")
    public Observable<GuildWelcomeScreen> getGuildWelcomeScreen(@s("guildId") long guildId) {
        return this._api.getGuildWelcomeScreen(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/harvest")
    public Observable<Harvest> getHarvestStatus() {
        return this._api.getHarvestStatus();
    }

    public final Observable<RestAPI$HarvestState> getHarvestStatusGuarded() {
        Observable<R> observableG = this._api.getHarvestStatus().G(RestAPI$getHarvestStatusGuarded$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "_api.getHarvestStatus()\n…erRequested()\n          }");
        return ObservableExtensionsKt.restSubscribeOn(observableG, false);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/messages/{messageId}/interaction-data")
    public Observable<ApplicationCommandData> getInteractionData(@s("channelId") long channelId, @s("messageId") long messageId) {
        return this._api.getInteractionData(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("invites/{code}")
    public Observable<Response<ModelInvite>> getInviteCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @t("with_counts") boolean withCounts, @t("guild_scheduled_event_id") Long guildScheduledEventId) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.getInviteCode(code, withCounts, guildScheduledEventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/billing/invoices/preview")
    public Observable<ModelInvoicePreview> getInvoicePreview(@a RestAPIParams$InvoicePreviewBody invoicePreviewBody) {
        m.checkNotNullParameter(invoicePreviewBody, "invoicePreviewBody");
        return this._api.getInvoicePreview(invoicePreviewBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/library")
    public Observable<List<ModelLibraryApplication>> getLibrary() {
        return this._api.getLibrary();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("auth/location-metadata")
    public Observable<ModelLocationMetadata> getLocationMetadata() {
        return this._api.getLocationMetadata();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/scheduled-events")
    public Observable<List<GuildScheduledEventMeUser>> getMeGuildScheduledEvents(@t("guild_ids") long guildIds) {
        return this._api.getMeGuildScheduledEvents(guildIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/mentions")
    public Observable<List<Message>> getMentions(@t("limit") int limit, @t("roles") boolean roles, @t(ModelGuildMemberListUpdate.EVERYONE_ID) boolean everyone, @t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @t("before") Long before) {
        return this._api.getMentions(limit, roles, everyone, guildId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/applications/{applicationId}/entitlements")
    public Observable<List<ModelEntitlement>> getMyEntitlements(@s("applicationId") long applicationId, @t("exclude_consumed") boolean excludeConsumed) {
        return this._api.getMyEntitlements(applicationId, excludeConsumed);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/users/@me/threads/archived/private")
    public Observable<ThreadListing> getMyPrivateArchivedThreads(@s("channelId") long channelId, @t("before") Long before) {
        return this._api.getMyPrivateArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("oauth2/tokens")
    public Observable<List<ModelOAuth2Token>> getOAuthTokens() {
        return this._api.getOAuthTokens();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("oauth2/authorize")
    public Observable<RestAPIParams$OAuth2Authorize$ResponseGet> getOauth2Authorize(@t("client_id") String clientId, @t("state") String state, @t("response_type") String responseType, @t("redirect_uri") String redirectUrl, @t("prompt") String prompt, @t("scope") String scope, @t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions) {
        b.d.b.a.a.q0(clientId, "clientId", prompt, "prompt", scope, "scope");
        return this._api.getOauth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("oauth2/samsung/authorize")
    public Observable<Void> getOauth2SamsungAuthorize(@t("client_id") String clientId, @t("state") String state, @t("response_type") String responseType, @t("redirect_uri") String redirectUrl, @t("prompt") String prompt, @t("scope") String scope) {
        b.d.b.a.a.q0(clientId, "clientId", prompt, "prompt", scope, "scope");
        return this._api.getOauth2SamsungAuthorize(clientId, state, responseType, redirectUrl, prompt, scope);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("applications/{applicationId}/payment-payout-groups")
    public Observable<List<PayoutGroup>> getPaymentPayoutGroups(@s("applicationId") long applicationId) {
        return this._api.getPaymentPayoutGroups(applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/billing/payment-sources")
    public Observable<List<PaymentSourceRaw>> getPaymentSources() {
        return this._api.getPaymentSources();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("store/price-tiers")
    public Observable<List<Integer>> getPriceTiers(@t("price_tier_type") int priceTierType) {
        return this._api.getPriceTiers(priceTierType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/prune")
    public Observable<PruneCountResponse> getPruneCount(@s("guildId") long guildId, @t("days") int days) {
        return this._api.getPruneCount(guildId, days);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/messages/{messageId}/reactions/{emoji}")
    public Observable<List<com.discord.api.user.User>> getReactionUsers(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "emoji") String emoji, @t("limit") Integer limit) {
        m.checkNotNullParameter(emoji, "emoji");
        return this._api.getReactionUsers(channelId, messageId, emoji, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("stage-instances")
    public Observable<Response<List<RecommendedStageInstance>>> getRecommendedStageInstances() {
        return this._api.getRecommendedStageInstances();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/{userId}/relationships")
    public Observable<List<ModelUserRelationship>> getRelationships(@s("userId") long userId) {
        return this._api.getRelationships(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("reporting/menu/{reportType}")
    public Observable<MenuAPIResponse> getReportMenu(@s("reportType") String reportType) {
        m.checkNotNullParameter(reportType, "reportType");
        return this._api.getReportMenu(reportType);
    }

    public final Observable<List<ModelRtcLatencyRegion>> getRtcLatencyTestRegionsIps() {
        RestAPIInterface$RtcLatency restAPIInterface$RtcLatency = apiRtcLatency;
        if (restAPIInterface$RtcLatency == null) {
            m.throwUninitializedPropertyAccessException("apiRtcLatency");
        }
        return ObservableExtensionsKt.restSubscribeOn$default(restAPIInterface$RtcLatency.get("https://latency.discord.media/rtc"), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("tracks/{id}")
    public Observable<ModelSpotifyTrack> getSpotifyTrack(@s(ModelAuditLogEntry.CHANGE_KEY_ID) String id2) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return this._api.getSpotifyTrack(id2);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("stage-instances/extra")
    public Observable<List<RecommendedStageInstance>> getStageInstancesForChannels(@t("channel_ids") Set<Long> channelIds) {
        m.checkNotNullParameter(channelIds, "channelIds");
        return this._api.getStageInstancesForChannels(channelIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("stickers/{stickerId}")
    public Observable<Sticker> getSticker(@s("stickerId") long stickerId) {
        return this._api.getSticker(stickerId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("stickers/{stickerId}/guild")
    public Observable<Guild> getStickerGuild(@s("stickerId") long stickerId) {
        return this._api.getStickerGuild(stickerId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("sticker-packs/{packId}")
    public Observable<ModelStickerPack> getStickerPack(@s("packId") long packId) {
        return this._api.getStickerPack(packId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("sticker-packs")
    public Observable<ModelStickerStoreDirectory> getStickerPacks() {
        return this._api.getStickerPacks();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("streams/{streamKey}/preview")
    public Observable<ModelApplicationStreamPreview> getStreamPreview(@s("streamKey") String streamKey, @t("version") long version) {
        m.checkNotNullParameter(streamKey, "streamKey");
        return this._api.getStreamPreview(streamKey, version);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/guilds/premium/subscription-slots")
    public Observable<List<ModelGuildBoostSlot>> getSubscriptionSlots() {
        return this._api.getSubscriptionSlots();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/billing/subscriptions")
    public Observable<List<ModelSubscription>> getSubscriptions() {
        return this._api.getSubscriptions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("gifs/trending")
    public Observable<TrendingGifCategoriesResponseDto> getTrendingGifCategories(@t("provider") String provider, @t("locale") String locale, @t("media_format") String mediaFormat) {
        b.d.b.a.a.q0(provider, "provider", locale, "locale", mediaFormat, "mediaFormat");
        return this._api.getTrendingGifCategories(provider, locale, mediaFormat);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("gifs/trending-gifs")
    public Observable<List<GifDto>> getTrendingGifCategory(@t("provider") String provider, @t("locale") String locale, @t("media_format") String mediaFormat, @t("limit") int limit) {
        b.d.b.a.a.q0(provider, "provider", locale, "locale", mediaFormat, "mediaFormat");
        return this._api.getTrendingGifCategory(provider, locale, mediaFormat, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/affinities/users")
    public Observable<ModelUserAffinities> getUserAffinities() {
        return this._api.getUserAffinities();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/join-request-guilds")
    public Observable<List<Guild>> getUserJoinRequestGuilds() {
        return this._api.getUserJoinRequestGuilds();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/notes/{userId}")
    public Observable<ModelUserNote> getUserNote(@s("userId") long userId) {
        return this._api.getUserNote(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/survey")
    public Observable<Response<UserSurveyFetchResponse>> getUserSurvey() {
        return this._api.getUserSurvey();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/vanity-url")
    public Observable<VanityUrlResponse> getVanityUrl(@s("guildId") long guildId) {
        return this._api.getVanityUrl(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("friend-suggestions/{userId}")
    public Observable<Void> ignoreFriendSuggestion(@s("userId") long userId) {
        return this._api.ignoreFriendSuggestion(userId);
    }

    public final Observable<Void> inviteUserToSpeak(Channel channel, long userId, Clock clock) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(clock, "clock");
        return this._api.updateUserVoiceStates(channel.getGuildId(), userId, new RestAPIParams$ChannelVoiceStateUpdate(channel.getId(), Boolean.FALSE, new UtcDateTime(clock.currentTimeMillis())));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("guilds/{guildId}/members/@me")
    public Observable<Guild> joinGuild(@s("guildId") long guildId, @t("lurker") boolean isLurker, @t("session_id") String sessionId, @t("directory_channel_id") Long directoryChannelId, @a RestAPIParams$InviteCode body, @i("X-Context-Properties") String context) {
        return this._api.joinGuild(guildId, isLurker, sessionId, directoryChannelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("integrations/{integrationId}/join")
    public Observable<Void> joinGuildFromIntegration(@s("integrationId") String integrationId) {
        m.checkNotNullParameter(integrationId, "integrationId");
        return this._api.joinGuildFromIntegration(integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("hub-waitlist/signup")
    public Observable<WaitlistSignup> joinHubWaitlist(@a RestAPIParams$HubWaitlist body) {
        m.checkNotNullParameter(body, "body");
        return this._api.joinHubWaitlist(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/thread-members/@me")
    public Observable<Void> joinThread(@s("channelId") long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @a RestAPIParams$EmptyBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.joinThread(channelId, location, body);
    }

    public final String jsonObjectOf(Pair<String, ? extends Object>... map) {
        m.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, ? extends Object> pair : map) {
            try {
                jSONObject.put(pair.component1(), pair.component2());
            } catch (JSONException e) {
                Logger.e$default(AppLog.g, "RestAPI", "Unable to serialize context property.", e, null, 8, null);
            }
        }
        String string = jSONObject.toString();
        m.checkNotNullExpressionValue(string, "it.toString()");
        Charset charset = c.a;
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = string.getBytes(charset);
        m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        m.checkNotNullExpressionValue(strEncodeToString, "JSONObject().apply {\n   …toByteArray(), NO_WRAP) }");
        return strEncodeToString;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/members/{userId}")
    public Observable<Void> kickGuildMember(@s("guildId") long guildId, @s("userId") long userId, @i("X-Audit-Log-Reason") String reason) {
        return this._api.kickGuildMember(guildId, userId, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("users/@me/guilds/{guildId}")
    public Observable<Void> leaveGuild(@s("guildId") long guildId) {
        return this._api.leaveGuild(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/guilds/{guildId}")
    public Observable<Void> leaveGuild(@s("guildId") long guildId, @a RestAPIParams$LeaveGuildBody leaveGuildBody) {
        m.checkNotNullParameter(leaveGuildBody, "leaveGuildBody");
        return this._api.leaveGuild(guildId, leaveGuildBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/thread-members/@me")
    public Observable<Void> leaveThread(@s("channelId") long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location) {
        return this._api.leaveThread(channelId, location);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/logout")
    public Observable<Response<Void>> logout(@a RestAPIParams$UserDevices body) {
        m.checkNotNullParameter(body, "body");
        return this._api.logout(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}/directory-entry/{guildId}")
    public Observable<DirectoryEntryGuild> modifyServerInHub(@s("channelId") long channelId, @s("guildId") long guildId, @a RestAPIParams$AddServerBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.modifyServerInHub(channelId, guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/emojis/{emojiId}")
    public Observable<ModelEmojiGuild> patchGuildEmoji(@s("guildId") long guildId, @s("emojiId") long emojiId, @a RestAPIParams$PatchGuildEmoji body) {
        m.checkNotNullParameter(body, "body");
        return this._api.patchGuildEmoji(guildId, emojiId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me")
    public Observable<com.discord.api.user.User> patchUser(@a PatchUserBody patchUserBody) {
        m.checkNotNullParameter(patchUserBody, "patchUserBody");
        return this._api.patchUser(patchUserBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me")
    public Observable<com.discord.api.user.User> patchUser(@a RestAPIParams$UserInfo userInfo) {
        m.checkNotNullParameter(userInfo, "userInfo");
        return this._api.patchUser(userInfo);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("phone-verifications/resend")
    public Observable<Void> phoneVerificationsResend(@a RestAPIParams$VerificationCodeResend body) {
        m.checkNotNullParameter(body, "body");
        return this._api.phoneVerificationsResend(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("phone-verifications/verify")
    public Observable<Response<ModelPhoneVerificationToken>> phoneVerificationsVerify(@a RestAPIParams$VerificationCode body) {
        m.checkNotNullParameter(body, "body");
        return this._api.phoneVerificationsVerify(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/fingerprint")
    public Observable<FingerprintResponse> postAuthFingerprint(@a RestAPIParams$EmptyBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postAuthFingerprint(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/login")
    public Observable<Response<ModelLoginResult>> postAuthLogin(@a RestAPIParams$AuthLogin body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postAuthLogin(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/register")
    public Observable<Response<RegisterResponse>> postAuthRegister(@a RestAPIParams$AuthRegister body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postAuthRegister(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/register/phone")
    public Observable<Response<Void>> postAuthRegisterPhone(@a RestAPIParams$AuthRegisterPhone body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postAuthRegisterPhone(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/verify/resend")
    public Observable<Response<Void>> postAuthVerifyResend(@a RestAPIParams$EmptyBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postAuthVerifyResend(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/invites")
    public Observable<ModelInvite> postChannelInvite(@s("channelId") long channelId, @a RestAPIParams$Invite body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postChannelInvite(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/messages/{messageId}/ack")
    public Observable<Void> postChannelMessagesAck(@s("channelId") long channelId, @s("messageId") Long messageId, @a RestAPIParams$ChannelMessagesAck body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postChannelMessagesAck(channelId, messageId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/emojis")
    public Observable<ModelEmojiGuild> postGuildEmoji(@s("guildId") long guildId, @a RestAPIParams$PostGuildEmoji body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postGuildEmoji(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/ack/{ackType}/{ackedId}")
    public Observable<Void> postGuildFeatureAck(@s("guildId") long channelId, @s("ackType") int ackType, @s("ackedId") long ackedId, @a RestAPIParams$GuildFeatureAck body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postGuildFeatureAck(channelId, ackType, ackedId, body);
    }

    public final Observable<ModelInvite> postInviteCode(ModelInvite invite, String location, RestAPIParams$InviteCode body) {
        m.checkNotNullParameter(invite, "invite");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(body, "body");
        RestAPIInterface restAPIInterface = this._api;
        String str = invite.code;
        m.checkNotNullExpressionValue(str, "invite.code");
        Pair<String, ? extends Object>[] pairArr = new Pair[5];
        pairArr[0] = d0.o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        Guild guild = invite.guild;
        pairArr[1] = d0.o.to("location_guild_id", guild != null ? Long.valueOf(guild.getId()) : null);
        Channel channel = invite.getChannel();
        pairArr[2] = d0.o.to("location_channel_id", channel != null ? Long.valueOf(channel.getId()) : null);
        Channel channel2 = invite.getChannel();
        pairArr[3] = d0.o.to("location_channel_type", channel2 != null ? Integer.valueOf(channel2.getType()) : null);
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        pairArr[4] = d0.o.to("invite_guild_scheduled_event_id", guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
        return ObservableExtensionsKt.restSubscribeOn$default(restAPIInterface.postInviteCode(str, body, jsonObjectOf(pairArr)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("invites/{code}")
    public Observable<ModelInvite> postInviteCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @a RestAPIParams$InviteCode body, @i("X-Context-Properties") String context) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        m.checkNotNullParameter(body, "body");
        m.checkNotNullParameter(context, "context");
        return this._api.postInviteCode(code, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("auth/mfa/totp")
    public Observable<Response<ModelLoginResult>> postMFACode(@a RestAPIParams$MFALogin body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postMFACode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("oauth2/authorize")
    public Observable<RestAPIParams$OAuth2Authorize$ResponsePost> postOauth2Authorize(@t("client_id") String clientId, @t("state") String state, @t("response_type") String responseType, @t("redirect_uri") String redirectUrl, @t("prompt") String prompt, @t("scope") String scope, @t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions, @t("code_challenge") String codeChallenge, @t("code_challenge_method") String codeChallengeMethod, @a Map<String, String> body) {
        m.checkNotNullParameter(clientId, "clientId");
        m.checkNotNullParameter(prompt, "prompt");
        m.checkNotNullParameter(scope, "scope");
        m.checkNotNullParameter(body, "body");
        return this._api.postOauth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/remote-auth/cancel")
    public Observable<Void> postRemoteAuthCancel(@a RestAPIParams$RemoteAuthCancel body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthCancel(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/remote-auth/finish")
    public Observable<Void> postRemoteAuthFinish(@a RestAPIParams$RemoteAuthFinish body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthFinish(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/remote-auth")
    public Observable<ModelRemoteAuthHandshake> postRemoteAuthInitialize(@a RestAPIParams$RemoteAuthInitialize body) {
        m.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthInitialize(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("streams/{streamKey}/preview")
    public Observable<Void> postStreamPreview(@s("streamKey") String streamKey, @a RestAPIParams$Thumbnail thumbnail) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(thumbnail, "thumbnail");
        return this._api.postStreamPreview(streamKey, thumbnail);
    }

    public final Observable<Void> postStreamPreview(String streamKey, String thumbnail) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(thumbnail, "thumbnail");
        return this._api.postStreamPreview(streamKey, new RestAPIParams$Thumbnail(thumbnail));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/prune")
    public Observable<Void> pruneMembers(@s("guildId") long guildId, @a RestAPIParams$PruneGuild body) {
        m.checkNotNullParameter(body, "body");
        return this._api.pruneMembers(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/messages/{messageId}/reactions")
    public Observable<Void> removeAllReactions(@s("channelId") long channelId, @s("messageId") long messageId) {
        return this._api.removeAllReactions(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/recipients/{recipientId}")
    public Observable<Void> removeChannelRecipient(@s("channelId") long channelId, @s("recipientId") long recipientId) {
        return this._api.removeChannelRecipient(channelId, recipientId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/{userId}")
    public Observable<Void> removeReaction(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction, @s("userId") long userId) {
        m.checkNotNullParameter(reaction, "reaction");
        return this._api.removeReaction(channelId, messageId, reaction, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("users/@me/relationships/{userId}")
    public Observable<Void> removeRelationship(@s("userId") long userId, @i("X-Context-Properties") String context) {
        m.checkNotNullParameter(context, "context");
        return this._api.removeRelationship(userId, context);
    }

    public final Observable<Void> removeRelationship(String location, long userId) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.removeRelationship(userId, jsonObjectOf(d0.o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    public Observable<Void> removeSelfReaction(@s("channelId") long channelId, @s("messageId") long messageId, @s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        return this._api.removeSelfReaction(channelId, messageId, reaction);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("channels/{channelId}/directory-entry/{guildId}")
    public Observable<Response<DirectoryEntryGuild>> removeServerFromHub(@s("channelId") long channelId, @s("guildId") long guildId) {
        return this._api.removeServerFromHub(channelId, guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/channels")
    public Observable<Void> reorderChannels(@s("guildId") long guildId, @a List<RestAPIParams$ChannelPosition> body) {
        m.checkNotNullParameter(body, "body");
        return this._api.reorderChannels(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("report")
    public Observable<Unit> report(@a RestAPIParams$Report body) {
        m.checkNotNullParameter(body, "body");
        return this._api.report(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("report")
    public Observable<List<ReportReason>> report(@t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @t("message_id") Long messageId, @t("user_id") Long userId) {
        return this._api.report(channelId, guildId, messageId, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/harvest")
    public Observable<Harvest> requestHarvest() {
        return this._api.requestHarvest();
    }

    public final Observable<Void> requestToSpeak(Channel channel, Clock clock) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(clock, "clock");
        return this._api.updateMyVoiceStates(channel.getGuildId(), new RestAPIParams$ChannelVoiceStateUpdate(channel.getId(), null, new UtcDateTime(clock.currentTimeMillis()), 2, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> resetGuildJoinRequest(@s("guildId") long guildId) {
        return this._api.resetGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("entitlements/gift-codes/{code}")
    public Observable<ModelGift> resolveGiftCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @t("with_application") boolean withApplication, @t("with_subscription_plan") boolean withSubscription) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.resolveGiftCode(code, withApplication, withSubscription);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/@me/entitlements/gift-codes")
    public Observable<List<ModelGift>> resolveSkuIdGift(@t("sku_id") long skuId, @t("subscription_plan_id") Long subscriptionPlanId) {
        return this._api.resolveSkuIdGift(skuId, subscriptionPlanId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("users/@me/entitlements/gift-codes/{code}")
    public Observable<Void> revokeGiftCode(@s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.revokeGiftCode(code);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("invites/{inviteCode}")
    public Observable<ModelInvite> revokeInvite(@s("inviteCode") String inviteCode) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        return this._api.revokeInvite(inviteCode);
    }

    public final Observable<Void> ring(long channelId, long messageId, List<Long> recipients) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.ring(channelId, new RestAPIParams$Ring(recipients), jsonObjectOf(d0.o.to("message_id", Long.valueOf(messageId)))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/call/ring")
    public Observable<Void> ring(@s("channelId") long channelId, @a RestAPIParams$Ring body, @i("X-Context-Properties") String context) {
        m.checkNotNullParameter(body, "body");
        m.checkNotNullParameter(context, "context");
        return this._api.ring(channelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("science")
    public Observable<Void> science(@a Science body) {
        m.checkNotNullParameter(body, "body");
        return this._api.science(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/messages/search")
    public Observable<ModelSearchResponse> searchChannelMessages(@s("channelId") long channelId, @t("max_id") Long oldestMessageId, @t("author_id") List<String> authorIds, @t("mentions") List<String> mentionsIds, @t("has") List<String> has, @t("content") List<String> content, @t("attempts") Integer attempts, @t("include_nsfw") Boolean includeNsfw) {
        return this._api.searchChannelMessages(channelId, oldestMessageId, authorIds, mentionsIds, has, content, attempts, includeNsfw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("guilds/{guildId}/messages/search")
    public Observable<ModelSearchResponse> searchGuildMessages(@s("guildId") long guildId, @t("max_id") Long oldestMessageId, @t("author_id") List<String> authorIds, @t("mentions") List<String> mentionsIds, @t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) List<String> inChannelIds, @t("has") List<String> has, @t("content") List<String> content, @t("attempts") Integer attempts, @t("include_nsfw") Boolean includeNsfw) {
        return this._api.searchGuildMessages(guildId, oldestMessageId, authorIds, mentionsIds, inChannelIds, has, content, attempts, includeNsfw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("channels/{channelId}/directory-entries/search")
    public Observable<List<DirectoryEntryGuild>> searchServers(@s("channelId") long channelId, @t("query") String query) {
        m.checkNotNullParameter(query, "query");
        return this._api.searchServers(channelId, query);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("interactions")
    @l
    public Observable<Void> sendApplicationCommand(@q("payload_json") PayloadJSON<RestAPIParams$ApplicationCommand> payloadJson, @q MultipartBody$Part[] files) {
        m.checkNotNullParameter(payloadJson, "payloadJson");
        m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.sendApplicationCommand(payloadJson, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("interactions")
    public Observable<Void> sendApplicationCommand(@a RestAPIParams$ApplicationCommand body) {
        m.checkNotNullParameter(body, "body");
        return this._api.sendApplicationCommand(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("private/bug-reports")
    @l
    public Observable<Unit> sendBugReport(@q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @q(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) String description, @q("priority") int priority, @q("asana_inbox_id") Long asanaInboxId, @q MultipartBody$Part screenshot) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this._api.sendBugReport(name, description, priority, asanaInboxId, screenshot);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("interactions")
    public Observable<Void> sendComponentInteraction(@a RestAPIParams$ComponentInteraction body) {
        m.checkNotNullParameter(body, "body");
        return this._api.sendComponentInteraction(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/greet")
    public Observable<Message> sendGreetMessage(@s("channelId") long channelId, @a RestAPIParams$GreetMessage body) {
        m.checkNotNullParameter(body, "body");
        return this._api.sendGreetMessage(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/messages")
    @l
    public Observable<Message> sendMessage(@s("channelId") long channelId, @q("payload_json") PayloadJSON<RestAPIParams$Message> payloadJson, @q MultipartBody$Part[] files) {
        m.checkNotNullParameter(payloadJson, "payloadJson");
        m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.sendMessage(channelId, payloadJson, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/messages")
    public Observable<Message> sendMessage(@s("channelId") long channelId, @a RestAPIParams$Message message) {
        m.checkNotNullParameter(message, "message");
        return this._api.sendMessage(channelId, message);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("interactions")
    public Observable<Void> sendModalInteraction(@a RestAPIParams$ModalInteraction body) {
        m.checkNotNullParameter(body, "body");
        return this._api.sendModalInteraction(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/relationships")
    public Observable<Void> sendRelationshipRequest(@a RestAPIParams$UserRelationship$Add relationship, @i("X-Context-Properties") String context) {
        m.checkNotNullParameter(relationship, "relationship");
        m.checkNotNullParameter(context, "context");
        return this._api.sendRelationshipRequest(relationship, context);
    }

    public final Observable<Void> sendRelationshipRequest(String location, String username, int discriminator, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(username, "username");
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.sendRelationshipRequest(new RestAPIParams$UserRelationship$Add(username, discriminator, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), jsonObjectOf(d0.o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/consent")
    public Observable<Void> setConsents(@a RestAPIParams$Consents body) {
        m.checkNotNullParameter(body, "body");
        return this._api.setConsents(body);
    }

    public final Observable<Void> setMeSuppressed(Channel channel, boolean isSuppressed) {
        m.checkNotNullParameter(channel, "channel");
        return this._api.updateMyVoiceStates(channel.getGuildId(), new RestAPIParams$ChannelVoiceStateUpdate(channel.getId(), Boolean.valueOf(isSuppressed), null, 4, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/mfa")
    public Observable<Void> setMfaLevel(@s("guildId") long guildId, @a RestAPIParams$GuildMFA body) {
        m.checkNotNullParameter(body, "body");
        return this._api.setMfaLevel(guildId, body);
    }

    public final Observable<Void> setUserSuppressed(Channel channel, long userId, boolean isSuppressed) {
        m.checkNotNullParameter(channel, "channel");
        return this._api.updateUserVoiceStates(channel.getGuildId(), userId, new RestAPIParams$ChannelVoiceStateUpdate(channel.getId(), Boolean.valueOf(isSuppressed), null, 4, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/typing")
    public Observable<ModelTypingResponse> setUserTyping(@s("channelId") long channelId, @a RestAPIParams$EmptyBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.setUserTyping(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("stage-instances")
    public Observable<StageInstance> startStageInstance(@a RestAPIParams$StartStageInstanceBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.startStageInstance(body);
    }

    public final Observable<Void> stopRinging(long channelId, long messageId, List<Long> recipients) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.stopRinging(channelId, new RestAPIParams$Ring(recipients), jsonObjectOf(d0.o.to("message_id", Long.valueOf(messageId)))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("channels/{channelId}/call/stop-ringing")
    public Observable<Void> stopRinging(@s("channelId") long channelId, @a RestAPIParams$Ring body, @i("X-Context-Properties") String context) {
        m.checkNotNullParameter(body, "body");
        m.checkNotNullParameter(context, "context");
        return this._api.stopRinging(channelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("connections/{connection}/callback")
    public Observable<Void> submitConnectionState(@s("connection") String connection, @a RestAPIParams$ConnectionState state) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(state, "state");
        return this._api.submitConnectionState(connection, state);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("reporting/{reportType}")
    public Observable<Unit> submitReport(@s("reportType") String reportType, @a ReportSubmissionBody body) {
        m.checkNotNullParameter(reportType, "reportType");
        m.checkNotNullParameter(body, "body");
        return this._api.submitReport(reportType, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("guilds/{guildId}/premium/subscriptions")
    public Observable<List<ModelAppliedGuildBoost>> subscribeToGuild(@s("guildId") long guildId, @a RestAPIParams$GuildBoosting guildBoosting) {
        m.checkNotNullParameter(guildBoosting, "guildBoosting");
        return this._api.subscribeToGuild(guildId, guildBoosting);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/{guildId}/integrations/{integrationId}/sync")
    public Observable<Void> syncIntegration(@s("guildId") long guildId, @s("integrationId") long integrationId) {
        return this._api.syncIntegration(guildId, integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}")
    public Observable<Void> transferGuildOwnership(@s("guildId") long guildId, @a RestAPIParams$TransferGuildOwnership transferGuildOwnership) {
        m.checkNotNullParameter(transferGuildOwnership, "transferGuildOwnership");
        return this._api.transferGuildOwnership(guildId, transferGuildOwnership);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/bans/{userId}")
    public Observable<Void> unbanUser(@s("guildId") long guildId, @s("userId") long userId) {
        return this._api.unbanUser(guildId, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/uncancel")
    public Observable<ModelGuildBoostSlot> uncancelSubscriptionSlot(@s("subscriptionSlotId") long slotId) {
        return this._api.uncancelSubscriptionSlot(slotId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @b("guilds/{guildId}/premium/subscriptions/{subscriptionId}")
    public Observable<Void> unsubscribeToGuild(@s("guildId") long guildId, @s("subscriptionId") long subscriptionId) {
        return this._api.unsubscribeToGuild(guildId, subscriptionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/connections/{connection}/{connectionId}")
    public Observable<Response<ConnectedAccount>> updateConnection(@s("connection") String connection, @s("connectionId") String connectionId, @a RestAPIParams$ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(connectionId, "connectionId");
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        return this._api.updateConnection(connection, connectionId, connectedAccount);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/connections/{connection}/{connectionId}")
    public Observable<Response<ConnectedAccount>> updateConnectionName(@s("connection") String connection, @s("connectionId") String connectionId, @a RestAPIParams$ConnectedAccountNameOnly connectedAccountName) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(connectionId, "connectionId");
        m.checkNotNullParameter(connectedAccountName, "connectedAccountName");
        return this._api.updateConnectionName(connection, connectionId, connectedAccountName);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}")
    public Observable<Guild> updateGuild(@s("guildId") long guildId, @a RestAPIParams$UpdateGuild body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateGuild(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/integrations/{integrationId}")
    public Observable<Void> updateGuildIntegration(@s("guildId") long guildId, @s("integrationId") long integrationId, @a RestAPIParams$GuildIntegration body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateGuildIntegration(guildId, integrationId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    public Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @a RestAPIParams$UpdateGuildRoleSubscriptionGroupListing body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/role-subscriptions/subscription-listings/{listingId}/trial")
    public Observable<GuildRoleSubscriptionTierFreeTrial> updateGuildRoleSubscriptionTierFreeTrial(@s("guildId") long guildId, @s("listingId") long listingId, @a RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionTierFreeTrial(guildId, listingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    public Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(@s("guildId") long guildId, @s("groupListingId") long groupListingId, @s("listingId") long tierListingId, @a RestAPIParams$UpdateGuildRoleSubscriptionTierListing body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<Unit> updateGuildScheduledEvent(@s("guildId") long guildId, @s("eventId") long eventId, @a RestAPIParams$UpdateGuildScheduledEventBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateGuildScheduledEvent(guildId, eventId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/members/@me")
    public Observable<GuildMember> updateMeGuildMember(@s("guildId") long guildId, @a PatchGuildMemberBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateMeGuildMember(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/voice-states/@me")
    public Observable<Void> updateMyVoiceStates(@s("guildId") long guildId, @a RestAPIParams$ChannelVoiceStateUpdate body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateMyVoiceStates(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/billing/payment-sources/{paymentSourceId}")
    public Observable<Void> updatePaymentSource(@s("paymentSourceId") String paymentSourceId, @a PatchPaymentSourceRaw PatchPaymentSourceRaw) {
        m.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        m.checkNotNullParameter(PatchPaymentSourceRaw, "PatchPaymentSourceRaw");
        return this._api.updatePaymentSource(paymentSourceId, PatchPaymentSourceRaw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("channels/{channelId}/permissions/{targetId}")
    public Observable<Void> updatePermissionOverwrites(@s("channelId") long channelId, @s("targetId") long targetId, @a RestAPIParams$ChannelPermissionOverwrites body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updatePermissionOverwrites(channelId, targetId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/guilds/@me/settings")
    public Observable<ModelNotificationSettings> updatePrivateChannelSettings(@a RestAPIParams$UserGuildSettings userGuildSettings) {
        m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        return this._api.updatePrivateChannelSettings(userGuildSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/roles/{roleId}")
    public Observable<Void> updateRole(@s("guildId") long guildId, @s("roleId") long roleId, @a RestAPIParams$Role body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateRole(guildId, roleId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("stage-instances/{channelId}")
    public Observable<StageInstance> updateStageInstance(@s("channelId") long channelId, @a RestAPIParams$UpdateStageInstanceBody body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateStageInstance(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/billing/subscriptions/{subscriptionId}")
    public Observable<Void> updateSubscription(@s("subscriptionId") String subscriptionId, @a RestAPIParams$UpdateSubscription updateSubscription) {
        m.checkNotNullParameter(subscriptionId, "subscriptionId");
        m.checkNotNullParameter(updateSubscription, "updateSubscription");
        return this._api.updateSubscription(subscriptionId, updateSubscription);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("channels/{channelId}/thread-members/@me/settings")
    public Observable<ThreadMember> updateThreadMemberSettings(@s("channelId") long channelId, @a RestAPIParams$ThreadMemberSettings body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateThreadMemberSettings(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    public Observable<ModelNotificationSettings> updateUserGuildSettings(long guildId, RestAPIParams$UserGuildSettings userGuildSettings) {
        m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        return guildId == 0 ? this._api.updatePrivateChannelSettings(userGuildSettings) : this._api.updateUserGuildSettings(guildId, userGuildSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("users/@me/notes/{userId}")
    public Observable<Void> updateUserNotes(@s("userId") long userId, @a RestAPIParams$UserNoteUpdate userNoteUpdate) {
        m.checkNotNullParameter(userNoteUpdate, "userNoteUpdate");
        return this._api.updateUserNotes(userId, userNoteUpdate);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/settings")
    public Observable<ModelUserSettings> updateUserSettings(@a RestAPIParams$UserSettings userSettings) {
        m.checkNotNullParameter(userSettings, "userSettings");
        return this._api.updateUserSettings(userSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/settings")
    public Observable<ModelUserSettings> updateUserSettingsCustomStatus(@a RestAPIParams$UserSettingsCustomStatus userSettingsCustomStatus) {
        m.checkNotNullParameter(userSettingsCustomStatus, "userSettingsCustomStatus");
        return this._api.updateUserSettingsCustomStatus(userSettingsCustomStatus);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/voice-states/{userId}")
    public Observable<Void> updateUserVoiceStates(@s("guildId") long guildId, @s("userId") long userId, @a RestAPIParams$ChannelVoiceStateUpdate body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateUserVoiceStates(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("guilds/{guildId}/vanity-url")
    public Observable<VanityUrlResponse> updateVanityUrl(@s("guildId") long guildId, @a RestAPIParams$VanityUrl body) {
        m.checkNotNullParameter(body, "body");
        return this._api.updateVanityUrl(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("users/@me/connections/contacts/@me/external-friend-list-entries")
    public Observable<Response<BulkFriendSuggestions>> uploadContacts(@a RestAPIParams$UploadContacts uploadContacts) {
        m.checkNotNullParameter(uploadContacts, "uploadContacts");
        return this._api.uploadContacts(uploadContacts);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("debug-logs/4/{filename}")
    public Observable<Void> uploadLog(@s("filename") String filename, @a String content) {
        m.checkNotNullParameter(filename, "filename");
        m.checkNotNullParameter(content, "content");
        return this._api.uploadLog(filename, content);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("debug-logs/multi/4")
    @l
    public Observable<Void> uploadLogs(@q MultipartBody$Part[] files) {
        m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.uploadLogs(files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/{actionType}")
    public Observable<ActivityActionConfirmation> userActivityAction(@s("userId") long userId, @s("applicationId") long application, @s("sessionId") String sessionId, @s("actionType") Integer actionType, @t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @t("message_id") Long messageId) {
        m.checkNotNullParameter(sessionId, "sessionId");
        return this._api.userActivityAction(userId, application, sessionId, actionType, channelId, messageId);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long j, long j2, String str) {
        return userActivityActionJoin$default(this, j, j2, str, null, null, 24, null);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long j, long j2, String str, Long l) {
        return userActivityActionJoin$default(this, j, j2, str, l, null, 16, null);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long authorId, long applicationId, String sessionId, Long channelId, Long messageId) {
        m.checkNotNullParameter(sessionId, "sessionId");
        return this._api.userActivityAction(authorId, applicationId, sessionId, Integer.valueOf(MessageActivityType.JOIN.getApiInt()), channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/phone")
    public Observable<Void> userAddPhone(@a RestAPIParams$Phone body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userAddPhone(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/phone/verify")
    public Observable<Void> userAddPhoneNoPassword(@a RestAPIParams$VerificationCodeOnly body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userAddPhoneNoPassword(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @i0.f0.n("users/@me/agreements")
    public Observable<Void> userAgreements(@a RestAPIParams$UserAgreements body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userAgreements(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/captcha/verify")
    public Observable<Void> userCaptchaVerify(@a RestAPIParams$CaptchaCode body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userCaptchaVerify(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/channels")
    public Observable<Channel> userCreateChannel(@a RestAPIParams$CreateChannel body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userCreateChannel(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/devices")
    public Observable<Void> userCreateDevice(@a RestAPIParams$UserDevices body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userCreateDevice(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @p("users/@me/email")
    public Observable<Void> userEmail() {
        return this._api.userEmail();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/email/verify-code")
    public Observable<ModelEmailChangeConfirm> userEmailVerifyCode(@a RestAPIParams$UserEmailConfirmCode body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userEmailVerifyCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/{userId}")
    public Observable<com.discord.api.user.User> userGet(@s("userId") long userId) {
        return this._api.userGet(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/phone")
    public Observable<Void> userPhoneDelete(@a RestAPIParams$DeletePhone body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userPhoneDelete(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("users/@me/phone")
    public Observable<Void> userPhoneWithToken(@a RestAPIParams$VerificationPhoneCode body) {
        m.checkNotNullParameter(body, "body");
        return this._api.userPhoneWithToken(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @f("users/{userId}/profile")
    public Observable<UserProfile> userProfileGet(@s("userId") long userId, @t("with_mutual_guilds") boolean withMutualGuilds, @t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId) {
        return this._api.userProfileGet(userId, withMutualGuilds, guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/automations/email-domain-lookup")
    public Observable<Response<EmailVerification>> verifyEmail(@a RestAPIParams$VerifyEmail body) {
        m.checkNotNullParameter(body, "body");
        return this._api.verifyEmail(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("guilds/automations/email-domain-lookup/verify-code")
    public Observable<Response<EmailVerificationCode>> verifyEmailCode(@a RestAPIParams$VerifyEmailCode body) {
        m.checkNotNullParameter(body, "body");
        return this._api.verifyEmailCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @o("google-play/verify-purchase-token")
    public Observable<RestAPIParams$VerifyPurchaseResponse> verifyPurchaseToken(@a RestAPIParams$VerifyPurchaseTokenBody verifyPurchaseBody) {
        m.checkNotNullParameter(verifyPurchaseBody, "verifyPurchaseBody");
        return this._api.verifyPurchaseToken(verifyPurchaseBody);
    }

    public final Observable<Void> setConsent(boolean consented, String consentType) {
        m.checkNotNullParameter(consentType, "consentType");
        if (consented) {
            return setConsent$default(this, consentType, null, 2, null);
        }
        return setConsent$default(this, null, consentType, 1, null);
    }
}
