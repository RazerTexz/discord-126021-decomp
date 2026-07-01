package com.discord.utilities.rest;

import android.content.Context;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.BuildConfig;
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
import com.discord.api.channel.ChannelUtils;
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
import com.discord.api.user.UserSurvey3;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
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
import com.discord.models.user.User;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.RestInterceptors;
import com.discord.restapi.RestInterceptors2;
import com.discord.restapi.RestInterceptors3;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import d0.Tuples;
import d0.g0.Charsets2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import f0.e0.Util7;
import f0.f0.HttpLoggingInterceptor;
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
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import j0.l.e.ScalarSynchronousObservable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI implements RestAPIInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static RestAPI api;
    public static RestAPIInterface.Dynamic apiClientVersions;
    public static RestAPIInterface.Files apiFiles;
    public static RestAPIInterface.RtcLatency apiRtcLatency;
    public static RestAPI apiSerializeNulls;
    public static RestAPI apiSpotify;
    private final RestAPIInterface _api;

    /* JADX INFO: compiled from: RestAPI.kt */
    public static final class AppHeadersProvider implements RestInterceptors2.HeadersProvider {
        public static final AppHeadersProvider INSTANCE = new AppHeadersProvider();
        public static Function0<String> authTokenProvider = RestAPI3.INSTANCE;
        public static Function0<String> fingerprintProvider = RestAPI4.INSTANCE;
        public static Function0<String> localeProvider = RestAPI5.INSTANCE;
        public static Function0<String> acceptLanguageProvider = RestAPI2.INSTANCE;
        public static Function0<String> spotifyTokenProvider = RestAPI6.INSTANCE;

        private AppHeadersProvider() {
        }

        @Override // com.discord.restapi.RestInterceptors2.HeadersProvider
        public String getAcceptLanguages() {
            return acceptLanguageProvider.invoke();
        }

        @Override // com.discord.restapi.RestInterceptors2.HeadersProvider
        public String getAuthToken() {
            return authTokenProvider.invoke();
        }

        @Override // com.discord.restapi.RestInterceptors2.HeadersProvider
        public String getFingerprint() {
            return fingerprintProvider.invoke();
        }

        @Override // com.discord.restapi.RestInterceptors2.HeadersProvider
        public String getLocale() {
            return localeProvider.invoke();
        }

        @Override // com.discord.restapi.RestInterceptors2.HeadersProvider
        public String getSpotifyToken() {
            return spotifyTokenProvider.invoke();
        }

        @Override // com.discord.restapi.RestInterceptors2.HeadersProvider
        public String getUserAgent() {
            return BuildConfig.USER_AGENT;
        }
    }

    /* JADX INFO: compiled from: RestAPI.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void getApi$annotations() {
        }

        public static /* synthetic */ void getApiSerializeNulls$annotations() {
        }

        public static /* synthetic */ void getApiSpotify$annotations() {
        }

        public final Interceptor buildAnalyticsInterceptor() {
            int i = Interceptor.a;
            return new Interceptor() { // from class: com.discord.utilities.rest.RestAPI$Companion$buildAnalyticsInterceptor$$inlined$invoke$1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) {
                    Intrinsics3.checkParameterIsNotNull(chain, "chain");
                    Request requestC = chain.c();
                    Intrinsics3.checkParameterIsNotNull(requestC, "request");
                    new LinkedHashMap();
                    HttpUrl httpUrl = requestC.url;
                    String str = requestC.method;
                    RequestBody requestBody = requestC.body;
                    Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                    Headers.a aVarE = requestC.headers.e();
                    String superPropertiesStringBase64 = AnalyticSuperProperties.INSTANCE.getSuperPropertiesStringBase64();
                    Intrinsics3.checkParameterIsNotNull("X-Super-Properties", ModelAuditLogEntry.CHANGE_KEY_NAME);
                    Intrinsics3.checkParameterIsNotNull(superPropertiesStringBase64, "value");
                    aVarE.a("X-Super-Properties", superPropertiesStringBase64);
                    if (httpUrl != null) {
                        return chain.a(new Request(httpUrl, str, aVarE.c(), requestBody, Util7.A(linkedHashMap)));
                    }
                    throw new IllegalStateException("url == null".toString());
                }
            };
        }

        public final Interceptor buildLoggingInterceptor() {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.b() { // from class: com.discord.utilities.rest.RestAPI$Companion$buildLoggingInterceptor$1
                @Override // f0.f0.HttpLoggingInterceptor.b
                public void log(String message) {
                    Intrinsics3.checkNotNullParameter(message, "message");
                    Logger.v$default(AppLog.g, message, null, 2, null);
                }
            });
            HttpLoggingInterceptor.a aVar = HttpLoggingInterceptor.a.BASIC;
            Intrinsics3.checkParameterIsNotNull(aVar, "<set-?>");
            httpLoggingInterceptor.c = aVar;
            return httpLoggingInterceptor;
        }

        public final RestAPI getApi() {
            RestAPI restAPI = RestAPI.api;
            if (restAPI == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("api");
            }
            return restAPI;
        }

        public final RestAPIInterface.Dynamic getApiClientVersions() {
            RestAPIInterface.Dynamic dynamic = RestAPI.apiClientVersions;
            if (dynamic == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("apiClientVersions");
            }
            return dynamic;
        }

        public final RestAPIInterface.Files getApiFiles() {
            RestAPIInterface.Files files = RestAPI.apiFiles;
            if (files == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("apiFiles");
            }
            return files;
        }

        public final RestAPIInterface.RtcLatency getApiRtcLatency() {
            RestAPIInterface.RtcLatency rtcLatency = RestAPI.apiRtcLatency;
            if (rtcLatency == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("apiRtcLatency");
            }
            return rtcLatency;
        }

        public final RestAPI getApiSerializeNulls() {
            RestAPI restAPI = RestAPI.apiSerializeNulls;
            if (restAPI == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("apiSerializeNulls");
            }
            return restAPI;
        }

        public final RestAPI getApiSpotify() {
            RestAPI restAPI = RestAPI.apiSpotify;
            if (restAPI == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("apiSpotify");
            }
            return restAPI;
        }

        public final void init(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppHeadersProvider appHeadersProvider = AppHeadersProvider.INSTANCE;
            RestInterceptors2 restInterceptors2 = new RestInterceptors2(appHeadersProvider);
            RestInterceptors restInterceptors = new RestInterceptors(AppLog.g);
            Interceptor interceptorBuildAnalyticsInterceptor = buildAnalyticsInterceptor();
            Interceptor interceptorBuildLoggingInterceptor = buildLoggingInterceptor();
            List listMutableListOf = Collections2.mutableListOf(restInterceptors2, interceptorBuildAnalyticsInterceptor, buildLoggingInterceptor(), restInterceptors);
            List listListOf = Collections2.listOf((Object[]) new Interceptor[]{interceptorBuildLoggingInterceptor, restInterceptors});
            PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
            RestAPIBuilder restAPIBuilder = new RestAPIBuilder(BuildConfig.HOST_API, persistentCookieJar);
            setApi(new RestAPI((RestAPIInterface) restAPIBuilder.build(RestAPIInterface.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listMutableListOf, (102 & 16) == 0 ? "client_base" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null)));
            setApiSerializeNulls(new RestAPI((RestAPIInterface) restAPIBuilder.build(RestAPIInterface.class, (102 & 2) != 0 ? false : true, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listMutableListOf, (102 & 16) == 0 ? "client_serialize_nulls" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null)));
            setApiClientVersions((RestAPIInterface.Dynamic) restAPIBuilder.build(RestAPIInterface.Dynamic.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listListOf, (102 & 16) == 0 ? "client_dynamic" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null));
            setApiRtcLatency((RestAPIInterface.RtcLatency) restAPIBuilder.build(RestAPIInterface.RtcLatency.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listListOf, (102 & 16) == 0 ? "client_rtc_latency" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null));
            setApiSpotify(new RestAPI((RestAPIInterface) new RestAPIBuilder("https://api.spotify.com/v1/", persistentCookieJar).build(RestAPIInterface.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : Collections2.listOf((Object[]) new Interceptor[]{interceptorBuildLoggingInterceptor, new RestInterceptors3(appHeadersProvider)}), (102 & 16) == 0 ? "client_spotify" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null)));
            setApiFiles((RestAPIInterface.Files) restAPIBuilder.build(RestAPIInterface.Files.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : CollectionsJVM.listOf(interceptorBuildLoggingInterceptor), (102 & 16) == 0 ? "client_files" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null));
        }

        public final void setApi(RestAPI restAPI) {
            Intrinsics3.checkNotNullParameter(restAPI, "<set-?>");
            RestAPI.api = restAPI;
        }

        public final void setApiClientVersions(RestAPIInterface.Dynamic dynamic) {
            Intrinsics3.checkNotNullParameter(dynamic, "<set-?>");
            RestAPI.apiClientVersions = dynamic;
        }

        public final void setApiFiles(RestAPIInterface.Files files) {
            Intrinsics3.checkNotNullParameter(files, "<set-?>");
            RestAPI.apiFiles = files;
        }

        public final void setApiRtcLatency(RestAPIInterface.RtcLatency rtcLatency) {
            Intrinsics3.checkNotNullParameter(rtcLatency, "<set-?>");
            RestAPI.apiRtcLatency = rtcLatency;
        }

        public final void setApiSerializeNulls(RestAPI restAPI) {
            Intrinsics3.checkNotNullParameter(restAPI, "<set-?>");
            RestAPI.apiSerializeNulls = restAPI;
        }

        public final void setApiSpotify(RestAPI restAPI) {
            Intrinsics3.checkNotNullParameter(restAPI, "<set-?>");
            RestAPI.apiSpotify = restAPI;
        }

        public final Observable<Void> uploadSystemLog() {
            return ObservableExtensionsKt.restSubscribeOn$default(getApi().uploadLog("android_system_log.txt", SystemLogUtils.INSTANCE.fetch()), false, 1, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: RestAPI.kt */
    public static abstract class HarvestState {

        /* JADX INFO: compiled from: RestAPI.kt */
        public static final class LastRequested extends HarvestState {
            private final ModelUserConsents3 data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LastRequested(ModelUserConsents3 modelUserConsents3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelUserConsents3, "data");
                this.data = modelUserConsents3;
            }

            public final ModelUserConsents3 getData() {
                return this.data;
            }
        }

        /* JADX INFO: compiled from: RestAPI.kt */
        public static final class NeverRequested extends HarvestState {
            public NeverRequested() {
                super(null);
            }
        }

        private HarvestState() {
        }

        public /* synthetic */ HarvestState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RestAPI(RestAPIInterface restAPIInterface) {
        Intrinsics3.checkNotNullParameter(restAPIInterface, "_api");
        this._api = restAPIInterface;
    }

    public static final Interceptor buildAnalyticsInterceptor() {
        return INSTANCE.buildAnalyticsInterceptor();
    }

    public static final Interceptor buildLoggingInterceptor() {
        return INSTANCE.buildLoggingInterceptor();
    }

    public static final RestAPI getApi() {
        RestAPI restAPI = api;
        if (restAPI == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("api");
        }
        return restAPI;
    }

    public static final RestAPI getApiSerializeNulls() {
        RestAPI restAPI = apiSerializeNulls;
        if (restAPI == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("apiSerializeNulls");
        }
        return restAPI;
    }

    public static final RestAPI getApiSpotify() {
        RestAPI restAPI = apiSpotify;
        if (restAPI == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("apiSpotify");
        }
        return restAPI;
    }

    public static /* synthetic */ Observable inviteUserToSpeak$default(RestAPI restAPI, Channel channel, long j, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return restAPI.inviteUserToSpeak(channel, j, clock);
    }

    public static /* synthetic */ Observable postInviteCode$default(RestAPI restAPI, ModelInvite modelInvite, String str, RestAPIParams.InviteCode inviteCode, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "mobile";
        }
        return restAPI.postInviteCode(modelInvite, str, inviteCode);
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
        if (grant == null || (listEmptyList = CollectionsJVM.listOf(grant)) == null) {
            listEmptyList = Collections2.emptyList();
        }
        if (revoke == null || (listEmptyList2 = CollectionsJVM.listOf(revoke)) == null) {
            listEmptyList2 = Collections2.emptyList();
        }
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.setConsents(new RestAPIParams.Consents(listEmptyList, listEmptyList2)), false, 1, null);
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
    @POST("guilds/{guildId}/creator-monetization/{requestId}/accept-terms")
    public Observable<CreatorMonetizationEnableRequest> acceptCreatorMonetizationTerms(@Path2("guildId") long guildId, @Path2("requestId") long requestId) {
        return this._api.acceptCreatorMonetizationTerms(guildId, requestId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("entitlements/gift-codes/{code}/redeem")
    public Observable<Void> acceptGift(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.acceptGift(code);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/ack")
    public Observable<Void> ackGuild(@Path2("guildId") long guildId) {
        return this._api.ackGuild(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/requests/@me/ack")
    public Observable<Void> ackGuildJoinRequest(@Path2("guildId") long guildId) {
        return this._api.ackGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("channels/{channelId}/pins/{messageId}")
    public Observable<Void> addChannelPin(@Path2("channelId") long channelId, @Path2("messageId") long messageId) {
        return this._api.addChannelPin(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("channels/{channelId}/recipients/{recipientId}")
    public Observable<Void> addChannelRecipient(@Path2("channelId") long channelId, @Path2("recipientId") long recipientId) {
        return this._api.addChannelRecipient(channelId, recipientId);
    }

    public final Observable<Channel> addGroupRecipients(final long channelId, final List<? extends User> recipients) {
        Intrinsics3.checkNotNullParameter(recipients, "recipients");
        Observable<Channel> observableY = StoreStream.INSTANCE.getChannels().observePrivateChannel(channelId).y(new Func1<Channel, Boolean>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.1
            @Override // j0.k.Func1
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel != null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…nnel -> channel != null }");
        Observable observableY2 = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null).Y(new Func1<Channel, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.2
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(Channel channel) {
                return (channel == null || !ChannelUtils.z(channel)) ? RestAPI.this._api.convertDMToGroup(channelId, ((User) _Collections.first(recipients)).getId()) : new ScalarSynchronousObservable(channel);
            }
        }).Y(new Func1<Channel, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(final Channel channel) {
                List listSubList;
                if (channel.getId() == channelId) {
                    listSubList = recipients;
                } else {
                    List list = recipients;
                    listSubList = list.subList(1, list.size());
                }
                return Observable.B(listSubList).G(new Func1<User, Observable<Void>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3.1
                    @Override // j0.k.Func1
                    public final Observable<Void> call(User user) {
                        return RestAPI.this._api.addChannelRecipient(channel.getId(), user.getId());
                    }
                }).f0().Y(new Func1<List<Observable<Void>>, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3.2
                    @Override // j0.k.Func1
                    public final Observable<? extends Channel> call(List<Observable<Void>> list2) {
                        return Observable.H(Observable.h0(new OnSubscribeFromIterable(list2))).f0().G(new Func1<List<Void>, Channel>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3.2.1
                            @Override // j0.k.Func1
                            public final Channel call(List<Void> list3) {
                                return channel;
                            }
                        });
                    }
                });
            }
        }).Y(new Func1<Channel, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.4
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(Channel channel) {
                Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(channel.getId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                return observableG;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY2, "StoreStream\n          .g….filterNull()\n          }");
        return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY2, 0L, false, 3, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    public Observable<Void> addReaction(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        return this._api.addReaction(channelId, messageId, reaction);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("users/@me/relationships/{userId}")
    public Observable<Void> addRelationship(@Path2("userId") long userId, @Body RestAPIParams.UserRelationship relationship, @Header3("X-Context-Properties") String context) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        Intrinsics3.checkNotNullParameter(context, "context");
        return this._api.addRelationship(userId, relationship, context);
    }

    public final Observable<Void> addRelationship(String location, long userId, Integer type, String friendToken, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.addRelationship(userId, new RestAPIParams.UserRelationship(type, friendToken, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), jsonObjectOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/directory-entry/{guildId}")
    public Observable<retrofit2.Response<DirectoryEntryGuild>> addServerToHub(@Path2("channelId") long channelId, @Path2("guildId") long guildId, @Body RestAPIParams.AddServerBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.addServerToHub(channelId, guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("connections/{connection}/authorize")
    public Observable<ModelUrl> authorizeConnection(@Path2("connection") String connection) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        return this._api.authorizeConnection(connection);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/authorize-ip")
    public Observable<retrofit2.Response<Void>> authorizeIP(@Body RestAPIParams.AuthorizeIP body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.authorizeIP(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("guilds/{guildId}/bans/{userId}")
    public Observable<Void> banGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.BanGuildMember body, @Header3("X-Audit-Log-Reason") String reason) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.banGuildMember(guildId, userId, body, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/roles")
    public Observable<Void> batchUpdateRole(@Path2("guildId") long guildId, @Body List<RestAPIParams.Role> body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.batchUpdateRole(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/relationships/bulk")
    public Observable<retrofit2.Response<BulkAddFriendsResponse>> bulkAddRelationships(@Body RestAPIParams.UserBulkRelationship body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.bulkAddRelationships(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/call")
    public Observable<ModelCall.Ringable> call(@Path2("channelId") long channelId) {
        return this._api.call(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/cancel")
    public Observable<ModelGuildBoostSlot> cancelSubscriptionSlot(@Path2("subscriptionSlotId") long slotId) {
        return this._api.cancelSubscriptionSlot(slotId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/members/{userId}")
    public Observable<Void> changeGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.GuildMember body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.changeGuildMember(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/members/@me/nick")
    public Observable<Void> changeGuildNickname(@Path2("guildId") long guildId, @Body RestAPIParams.Nick body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.changeGuildNickname(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("outbound-promotions/{promotionId}/claim")
    public Observable<ClaimedOutboundPromotion> claimOutboundPromotion(@Path2("promotionId") long promotionId) {
        return this._api.claimOutboundPromotion(promotionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("store/skus/{skuId}/purchase")
    public Observable<Unit> claimSku(@Path2("skuId") long skuId, @Body RestAPIParams.EmptyBody emptyBody) {
        Intrinsics3.checkNotNullParameter(emptyBody, "emptyBody");
        return this._api.claimSku(skuId, emptyBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("channels/{channelId}/recipients/{recipientId}")
    public Observable<Channel> convertDMToGroup(@Path2("channelId") long channelId, @Path2("recipientId") long recipientId) {
        return this._api.convertDMToGroup(channelId, recipientId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/followers")
    public Observable<Void> createChannelFollower(@Path2("channelId") long channelId, @Body RestAPIParams.ChannelFollowerPost body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createChannelFollower(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("users/@me/connections/contacts/@me")
    public Observable<ConnectedAccount> createConnectionContacts(@Body RestAPIParams.ConnectedAccountContacts connectedAccountContacts) {
        Intrinsics3.checkNotNullParameter(connectedAccountContacts, "connectedAccountContacts");
        return this._api.createConnectionContacts(connectedAccountContacts);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/creator-monetization/enable-requests")
    public Observable<CreatorMonetizationEnableRequest> createCreatorMonetizationEnableRequest(@Path2("guildId") long guildId) {
        return this._api.createCreatorMonetizationEnableRequest(guildId);
    }

    public final Observable<Channel> createGroupDM(List<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Channel> observableU = ObservableExtensionsKt.restSubscribeOn$default(this._api.userCreateChannel(new RestAPIParams.CreateChannel(userIds)), false, 1, null).u(new Action1<Channel>() { // from class: com.discord.utilities.rest.RestAPI.createGroupDM.1
            @Override // rx.functions.Action1
            public final void call(Channel channel) {
                StoreChannels channels = StoreStream.INSTANCE.getChannels();
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                channels.onGroupCreated(channel);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "_api\n      .userCreateCh…pCreated(channel)\n      }");
        return observableU;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds")
    public Observable<retrofit2.Response<Guild>> createGuild(@Body RestAPIParams.CreateGuild body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createGuild(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/channels")
    public Observable<retrofit2.Response<Channel>> createGuildChannel(@Path2("guildId") long guildId, @Body RestAPIParams.CreateGuildChannel body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createGuildChannel(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/templates/{guildTemplateCode}")
    public Observable<Guild> createGuildFromTemplate(@Path2("guildTemplateCode") String guildTemplateCode, @Body RestAPIParams.CreateGuildFromTemplate body) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createGuildFromTemplate(guildTemplateCode, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> createGuildJoinRequest(@Path2("guildId") long guildId, @Body RestAPIParams.MemberVerificationForm body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createGuildJoinRequest(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/role-subscriptions/group-listings")
    public Observable<GuildRoleSubscriptionGroupListing> createGuildRoleSubscriptionGroupListing(@Path2("guildId") long guildId, @Body RestAPIParams.CreateGuildRoleSubscriptionGroupListing body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createGuildRoleSubscriptionGroupListing(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings")
    public Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTier(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Body RestAPIParams.CreateGuildRoleSubscriptionTierListing body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createGuildRoleSubscriptionTier(guildId, groupListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/scheduled-events")
    public Observable<GuildScheduledEvent> createGuildScheduledEvent(@Path2("guildId") long guildId, @Body RestAPIParams.CreateGuildScheduledEventBody event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        return this._api.createGuildScheduledEvent(guildId, event);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    public Observable<Unit> createGuildScheduledEventRsvp(@Path2("guildId") long guildId, @Path2("eventId") long eventId) {
        return this._api.createGuildScheduledEventRsvp(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/handoff")
    public Observable<HandoffToken> createHandoffToken(@Body CreateHandoffTokenRequest body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createHandoffToken(body);
    }

    public final Observable<HandoffToken> createHandoffTokenWithNonce(String nonce) {
        Intrinsics3.checkNotNullParameter(nonce, "nonce");
        return this._api.createHandoffToken(new CreateHandoffTokenRequest(nonce));
    }

    public final Observable<Channel> createOrFetchDM(final long userId) {
        Observable<Channel> observableY = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observePrivateChannels(), 0L, false, 3, null).Y(new Func1<Map<Long, ? extends Channel>, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.createOrFetchDM.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Channel> call2(Map<Long, Channel> map) {
                T next;
                User userA;
                Iterator<T> it = map.values().iterator();
                do {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                    userA = ChannelUtils.a((Channel) next);
                } while (!(userA != null && userA.getId() == userId));
                Channel channel = next;
                return channel != null ? new ScalarSynchronousObservable(channel) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.this._api.userCreateChannel(new RestAPIParams.CreateChannel(userId)), false, 1, null).u(new Action1<Channel>() { // from class: com.discord.utilities.rest.RestAPI.createOrFetchDM.1.1
                    @Override // rx.functions.Action1
                    public final void call(Channel channel2) {
                        StoreStream.INSTANCE.getGatewaySocket().getChannelCreateOrUpdate().k.onNext(channel2);
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
        return observableY;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("google-play/purchase-metadata")
    public Observable<Unit> createPurchaseMetadata(@Body RestAPIParams.PurchaseMetadataBody purchaseMetadataBody) {
        Intrinsics3.checkNotNullParameter(purchaseMetadataBody, "purchaseMetadataBody");
        return this._api.createPurchaseMetadata(purchaseMetadataBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/roles")
    public Observable<GuildRole> createRole(@Path2("guildId") long guildId) {
        return this._api.createRole(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/threads")
    public Observable<Channel> createThread(@Path2("channelId") long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @Body RestAPIParams.ThreadCreationSettings body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createThread(channelId, location, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/messages/{messageId}/threads")
    public Observable<Channel> createThreadFromMessage(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @Body RestAPIParams.ThreadCreationSettings body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.createThreadFromMessage(channelId, messageId, location, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/threads?has_message=true")
    @Multipart
    public Observable<Channel> createThreadWithMessage(@Path2("channelId") long channelId, @Part2(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @Part2("content") String content, @Part2("applied_tags") List<Long> appliedTags, @Part2("sticker_ids") List<Long> stickerIds, @Part2("type") int type, @Part2(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION) Integer autoArchiveDuration, @Part2 MultipartBody.Part[] files) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(content, "content");
        Intrinsics3.checkNotNullParameter(appliedTags, "appliedTags");
        Intrinsics3.checkNotNullParameter(stickerIds, "stickerIds");
        Intrinsics3.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.createThreadWithMessage(channelId, name, content, appliedTags, stickerIds, type, autoArchiveDuration, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/messages/{messageId}/crosspost")
    public Observable<Void> crosspostMessage(@Path2("channelId") long channelId, @Path2("messageId") Long messageId) {
        return this._api.crosspostMessage(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/delete")
    public Observable<Void> deleteAccount(@Body RestAPIParams.DisableAccount body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.deleteAccount(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}")
    public Observable<Channel> deleteChannel(@Path2("channelId") long channelId) {
        return this._api.deleteChannel(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/pins/{messageId}")
    public Observable<Void> deleteChannelPin(@Path2("channelId") long channelId, @Path2("messageId") long messageId) {
        return this._api.deleteChannelPin(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("users/@me/connections/{connection}/{connectionId}")
    public Observable<retrofit2.Response<Void>> deleteConnection(@Path2("connection") String connection, @Path2("connectionId") String connectionId) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        Intrinsics3.checkNotNullParameter(connectionId, "connectionId");
        return this._api.deleteConnection(connection, connectionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/delete")
    public Observable<Void> deleteGuild(@Path2("guildId") long guildId, @Body RestAPIParams.DeleteGuild body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.deleteGuild(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/emojis/{emojiId}")
    public Observable<Void> deleteGuildEmoji(@Path2("guildId") long guildId, @Path2("emojiId") long emojiId) {
        return this._api.deleteGuildEmoji(guildId, emojiId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/integrations/{integrationId}")
    public Observable<Void> deleteGuildIntegration(@Path2("guildId") long guildId, @Path2("integrationId") long integrationId) {
        return this._api.deleteGuildIntegration(guildId, integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> deleteGuildJoinRequest(@Path2("guildId") long guildId) {
        return this._api.deleteGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    public Observable<Void> deleteGuildRoleSubscriptionTierListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Path2("listingId") long tierListingId) {
        return this._api.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<Void> deleteGuildScheduledEvent(@Path2("guildId") long guildId, @Path2("eventId") long eventId) {
        return this._api.deleteGuildScheduledEvent(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    public Observable<Void> deleteGuildScheduledEventRsvp(@Path2("guildId") long guildId, @Path2("eventId") long eventId) {
        return this._api.deleteGuildScheduledEventRsvp(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channel_id}/messages/{message_id}")
    public Observable<Void> deleteMessage(@Path2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @Path2("message_id") long messageId) {
        return this._api.deleteMessage(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("oauth2/tokens/{oauthId}")
    public Observable<Void> deleteOAuthToken(@Path2("oauthId") long oauthId) {
        return this._api.deleteOAuthToken(oauthId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("users/@me/billing/payment-sources/{paymentSourceId}")
    public Observable<Void> deletePaymentSource(@Path2("paymentSourceId") String paymentSourceId) {
        Intrinsics3.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        return this._api.deletePaymentSource(paymentSourceId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/permissions/{targetId}")
    public Observable<Void> deletePermissionOverwrites(@Path2("channelId") long channelId, @Path2("targetId") long targetId) {
        return this._api.deletePermissionOverwrites(channelId, targetId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/roles/{roleId}")
    public Observable<Void> deleteRole(@Path2("guildId") long guildId, @Path2("roleId") long roleId) {
        return this._api.deleteRole(guildId, roleId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("users/@me/billing/subscriptions/{subscriptionId}")
    public Observable<Void> deleteSubscription(@Path2("subscriptionId") String subscriptionId) {
        Intrinsics3.checkNotNullParameter(subscriptionId, "subscriptionId");
        return this._api.deleteSubscription(subscriptionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/disable")
    public Observable<Void> disableAccount(@Body RestAPIParams.DisableAccount body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.disableAccount(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/members/{userId}")
    public Observable<retrofit2.Response<Void>> disableGuildCommunication(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.DisableGuildCommunication body, @Header3("X-Audit-Log-Reason") String reason) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.disableGuildCommunication(guildId, userId, body, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/mfa/totp/disable")
    public Observable<DisableMfaResponse> disableMFA(@Body DisableMfaRequestBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.disableMFA(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/mfa/sms/disable")
    public Observable<Void> disableMfaSMS(@Body RestAPIParams.ActivateMfaSMS body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.disableMfaSMS(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/members/{userId}")
    public Observable<Void> disconnectGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.GuildMemberDisconnect body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.disconnectGuildMember(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("google-play/downgrade-subscription")
    public Observable<Object> downgradeSubscription(@Body RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody) {
        Intrinsics3.checkNotNullParameter(downgradeSubscriptionBody, "downgradeSubscriptionBody");
        return this._api.downgradeSubscription(downgradeSubscriptionBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}")
    public Observable<Channel> editGroupDM(@Path2("channelId") long channelId, @Body RestAPIParams.GroupDM body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.editGroupDM(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channel_id}/messages/{message_id}")
    public Observable<Message> editMessage(@Path2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @Path2("message_id") long messageId, @Body RestAPIParams.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        return this._api.editMessage(channelId, messageId, message);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}")
    public Observable<Channel> editTextChannel(@Path2("channelId") long channelId, @Body RestAPIParams.TextChannel body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.editTextChannel(channelId, body);
    }

    public final Observable<Channel> editTextChannel(long channelId, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.editTextChannel(channelId, new RestAPIParams.TextChannel(name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}")
    public Observable<Channel> editThread(@Path2("channelId") long channelId, @Body RestAPIParams.ThreadSettings body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.editThread(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}")
    public Observable<Channel> editTopicalChannel(@Path2("channelId") long channelId, @Body RestAPIParams.TopicalChannel body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.editTopicalChannel(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}")
    public Observable<Channel> editVoiceChannel(@Path2("channelId") long channelId, @Body RestAPIParams.VoiceChannel body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.editVoiceChannel(channelId, body);
    }

    public final Observable<Channel> editVoiceChannel(long channelId, String name, String topic, Boolean nsfw, Integer type, Integer bitrate, Integer userLimit, String rtcRegion) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.editVoiceChannel(channelId, new RestAPIParams.VoiceChannel(name, topic, type, nsfw, userLimit, bitrate, rtcRegion)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/integrations")
    public Observable<Void> enableIntegration(@Path2("guildId") long guildId, @Body RestAPIParams.EnableIntegration body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.enableIntegration(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/mfa/totp/enable")
    public Observable<EnableMfaResponse> enableMFA(@Body RestAPIParams.EnableMFA body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.enableMFA(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/mfa/sms/enable")
    public Observable<Void> enableMfaSMS(@Body RestAPIParams.ActivateMfaSMS body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.enableMfaSMS(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("stage-instances/{channelId}")
    public Observable<Unit> endStageInstance(@Path2("channelId") long channelId) {
        return this._api.endStageInstance(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/forgot")
    public Observable<retrofit2.Response<Void>> forgotPassword(@Body RestAPIParams.ForgotPassword body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.forgotPassword(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/entitlements/gift-codes")
    public Observable<ModelGift> generateGiftCode(@Body RestAPIParams.GenerateGiftCode body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.generateGiftCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/{userId}/sessions/{sessionId}/activities/{applicationId}/metadata")
    public Observable<ActivityMetadata> getActivityMetadata(@Path2("userId") long userId, @Path2("sessionId") String sessionId, @Path2("applicationId") long applicationId) {
        Intrinsics3.checkNotNullParameter(sessionId, "sessionId");
        return this._api.getActivityMetadata(userId, sessionId, applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("outbound-promotions")
    public Observable<List<OutboundPromotion>> getAllActiveOutboundPromotions() {
        return this._api.getAllActiveOutboundPromotions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("outbound-promotions/preview")
    public Observable<List<OutboundPromotion>> getAllPreviewPromotions() {
        return this._api.getAllPreviewPromotions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/threads/archived/private")
    public Observable<ThreadListing> getAllPrivateArchivedThreads(@Path2("channelId") long channelId, @Query2("before") String before) {
        return this._api.getAllPrivateArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/threads/archived/public")
    public Observable<ThreadListing> getAllPublicArchivedThreads(@Path2("channelId") long channelId, @Query2("before") String before) {
        return this._api.getAllPublicArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("oauth2/applications/{applicationId}/assets")
    public Observable<List<ApplicationAsset>> getApplicationAssets(@Path2("applicationId") long applicationId) {
        return this._api.getApplicationAssets(applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("applications/{botId}/commands")
    public Observable<List<ApplicationCommand>> getApplicationCommands(@Path2("botId") long botId) {
        return this._api.getApplicationCommands(botId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("applications/public")
    public Observable<List<Application>> getApplications(@Query2("application_ids") long appIds) {
        return this._api.getApplications(appIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/audit-logs")
    public Observable<ModelAuditLog> getAuditLogs(@Path2("guildId") long guildId, @Query2("limit") int limit, @Query2("before") Long before, @Query2("user_id") Long userId, @Query2("action_type") Integer actionType) {
        return this._api.getAuditLogs(guildId, limit, before, userId, actionType);
    }

    public final Observable<ModelAuditLog> getAuditLogs(long guildId, Long before, Long userId, Integer actionType) {
        return this._api.getAuditLogs(guildId, 50, before, (userId != null && userId.longValue() == 0) ? null : userId, (actionType != null && actionType.intValue() == 0) ? null : actionType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/mfa/codes")
    public Observable<GetBackupCodesResponse> getBackupCodes(@Body GetBackupCodesRequestBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.getBackupCodes(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/verify/view-backup-codes-challenge")
    public Observable<GetBackupCodesSendVerificationKeyResponse> getBackupCodesSendVerificationKey(@Body GetBackupCodesSendVerificationKeyRequestBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.getBackupCodesSendVerificationKey(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/mfa/codes-verification")
    public Observable<GetBackupCodesResponse> getBackupCodesVerification(@Body GetBackupCodesVerificationRequestBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.getBackupCodesVerification(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/bans")
    public Observable<List<ModelBan>> getBans(@Path2("guildId") long guildId) {
        return this._api.getBans(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("private/bug-reports")
    public Observable<BugReportConfig> getBugReportConfig() {
        return this._api.getBugReportConfig();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}")
    public Observable<Channel> getChannel(@Path2("channelId") long channelId) {
        return this._api.getChannel(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/follower-stats")
    public Observable<ModelChannelFollowerStatsDto> getChannelFollowerStats(@Path2("channelId") long channelId) {
        return this._api.getChannelFollowerStats(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/messages")
    public Observable<List<Message>> getChannelMessages(@Path2("channelId") long channelId, @Query2("before") Long before, @Query2("after") Long after, @Query2("limit") Integer limit) {
        return this._api.getChannelMessages(channelId, before, after, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/messages")
    public Observable<List<Message>> getChannelMessagesAround(@Path2("channelId") long channelId, @Query2("limit") int limit, @Query2("around") long around) {
        return this._api.getChannelMessagesAround(channelId, limit, around);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/pins")
    public Observable<List<Message>> getChannelPins(@Path2("channelId") long channelId) {
        return this._api.getChannelPins(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/outbound-promotions/codes")
    public Observable<List<ClaimedOutboundPromotion>> getClaimedOutboundPromotions() {
        return this._api.getClaimedOutboundPromotions();
    }

    public final Observable<Integer> getClientVersion() {
        RestAPIInterface.Dynamic dynamic = apiClientVersions;
        if (dynamic == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("apiClientVersions");
        }
        Observable<R> observableG = dynamic.get("https://dl.discordapp.net/apps/android/versions.json").G(new Func1<JsonObject, Integer>() { // from class: com.discord.utilities.rest.RestAPI.getClientVersion.1
            /* JADX WARN: Code duplicated, block: B:10:0x0019  */
            @Override // j0.k.Func1
            public final Integer call(JsonObject jsonObject) {
                int iC;
                if (jsonObject == null) {
                    iC = 0;
                } else {
                    LinkedTreeMap.e<String, JsonElement> eVarC = jsonObject.a.c("discord_android_min_version");
                    JsonElement jsonElement = eVarC != null ? eVarC.p : null;
                    if (jsonElement != null) {
                        iC = jsonElement.c();
                    } else {
                        iC = 0;
                    }
                }
                return Integer.valueOf(iC);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "apiClientVersions\n      …n_version\")?.asInt ?: 0 }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableG, false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/connections/{platformType}/{accountId}/access-token")
    public Observable<ModelConnectionAccessToken> getConnectionAccessToken(@Path2("platformType") String platformType, @Path2("accountId") String accountId) {
        Intrinsics3.checkNotNullParameter(platformType, "platformType");
        Intrinsics3.checkNotNullParameter(accountId, "accountId");
        return this._api.getConnectionAccessToken(platformType, accountId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("connections/{connection}/callback-continuation/{pinNumber}")
    public Observable<ModelConnectionState> getConnectionState(@Path2("connection") String connection, @Path2("pinNumber") String pinNumber) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        Intrinsics3.checkNotNullParameter(pinNumber, "pinNumber");
        return this._api.getConnectionState(connection, pinNumber);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/connections")
    public Observable<List<ConnectedAccount>> getConnections() {
        return this._api.getConnections();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/consent")
    public Observable<ModelUserConsents2> getConsents() {
        return this._api.getConsents();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/creator-monetization/requirements")
    public Observable<CreatorMonetizationEligibilityRequirements> getCreatorMonetizationEligibilityRequirements(@Path2("guildId") long guildId) {
        return this._api.getCreatorMonetizationEligibilityRequirements(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/directory-entries")
    public Observable<List<DirectoryEntryGuild>> getDirectoryEntries(@Path2("channelId") long channelId) {
        return this._api.getDirectoryEntries(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/directory-entries/broadcast")
    public Observable<GuildScheduledEventBroadcast> getDirectoryEntryBroadcastInfo(@Path2("guildId") long guildId, @Query2("entity_id") Long entityId, @Query2("type") int type) {
        return this._api.getDirectoryEntryBroadcastInfo(guildId, entityId, type);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/directory-entries")
    public Observable<List<DirectoryEntryGuild2>> getDirectoryGuildScheduledEvents(@Path2("channelId") long channelId, @Query2("type") int type) {
        return this._api.getDirectoryGuildScheduledEvents(channelId, type);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("emojis/{emojiId}/guild")
    public Observable<Guild> getEmojiGuild(@Path2("emojiId") long emojiId) {
        return this._api.getEmojiGuild(emojiId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/directory-entries/counts")
    public Observable<Map<Integer, Integer>> getEntryCounts(@Path2("channelId") long channelId) {
        return this._api.getEntryCounts(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("experiments")
    public Observable<UnauthenticatedUserExperimentsDto> getExperiments() {
        return this._api.getExperiments();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/post-data")
    public Observable<ForumPostFirstMessages> getForumPostData(@Path2("channelId") long channelId, @Body RestAPIParams.GetForumPostData body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.getForumPostData(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("friend-suggestions")
    public Observable<List<FriendSuggestion>> getFriendSuggestions() {
        return this._api.getFriendSuggestions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("gifs/search")
    public Observable<List<GifDto>> getGifSearchResults(@Query2("q") String query, @Query2("provider") String provider, @Query2("locale") String locale, @Query2("media_format") String mediaFormat, @Query2("limit") int limit) {
        Intrinsics3.checkNotNullParameter(query, "query");
        Intrinsics3.checkNotNullParameter(provider, "provider");
        Intrinsics3.checkNotNullParameter(locale, "locale");
        Intrinsics3.checkNotNullParameter(mediaFormat, "mediaFormat");
        return this._api.getGifSearchResults(query, provider, locale, mediaFormat, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("gifs/suggest")
    public Observable<List<String>> getGifSuggestedSearchTerms(@Query2("provider") String provider, @Query2("q") String query, @Query2("locale") String locale, @Query2("limit") int limit) {
        outline.q0(provider, "provider", query, "query", locale, "locale");
        return this._api.getGifSuggestedSearchTerms(provider, query, locale, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("gifs/trending-search")
    public Observable<List<String>> getGifTrendingSearchTerms(@Query2("provider") String provider, @Query2("locale") String locale, @Query2("limit") int limit) {
        Intrinsics3.checkNotNullParameter(provider, "provider");
        Intrinsics3.checkNotNullParameter(locale, "locale");
        return this._api.getGifTrendingSearchTerms(provider, locale, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/entitlements/gifts")
    public Observable<List<ModelEntitlement>> getGifts() {
        return this._api.getGifts();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/applications")
    public Observable<List<Application>> getGuildApplications(@Path2("guildId") long guildId, @Query2("include_team") boolean includeTeam) {
        return this._api.getGuildApplications(guildId, includeTeam);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/emojis")
    public Observable<List<ModelEmojiGuild>> getGuildEmojis(@Path2("guildId") long guildId) {
        return this._api.getGuildEmojis(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/integrations")
    public Observable<List<ModelGuildIntegration>> getGuildIntegrations(@Path2("guildId") long guildId) {
        return this._api.getGuildIntegrations(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/invites")
    public Observable<List<ModelInvite>> getGuildInvites(@Path2("guildId") long guildId) {
        return this._api.getGuildInvites(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/member-verification")
    public Observable<ModelMemberVerificationForm> getGuildMemberVerificationForm(@Path2("guildId") long guildId) {
        return this._api.getGuildMemberVerificationForm(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/preview")
    public Observable<GuildPreview> getGuildPreview(@Path2("guildId") long guildId) {
        return this._api.getGuildPreview(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/roles/member-counts")
    public Observable<Map<Long, Integer>> getGuildRoleMemberCounts(@Path2("guildId") long guildId) {
        return this._api.getGuildRoleMemberCounts(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/roles/{roleId}/member-ids")
    public Observable<List<Long>> getGuildRoleMemberIds(@Path2("guildId") long guildId, @Path2("roleId") long roleId) {
        return this._api.getGuildRoleMemberIds(guildId, roleId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/role-subscriptions/trials")
    public Observable<List<GuildRoleSubscriptionTierFreeTrial>> getGuildRoleSubscriptionFreeTrials(@Path2("guildId") long guildId) {
        return this._api.getGuildRoleSubscriptionFreeTrials(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    public Observable<GuildRoleSubscriptionGroupListing> getGuildRoleSubscriptionGroupListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId) {
        return this._api.getGuildRoleSubscriptionGroupListing(guildId, groupListingId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/role-subscriptions/group-listings")
    public Observable<List<GuildRoleSubscriptionGroupListing>> getGuildRoleSubscriptionGroupListings(@Path2("guildId") long guildId) {
        return this._api.getGuildRoleSubscriptionGroupListings(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<GuildScheduledEvent> getGuildScheduledEvent(@Path2("guildId") long guildId, @Path2("eventId") long eventId) {
        return this._api.getGuildScheduledEvent(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/scheduled-events/{eventId}/users")
    public Observable<List<ApiGuildScheduledEventUser>> getGuildScheduledEventUsers(@Path2("guildId") long guildId, @Path2("eventId") long eventId, @Query2("limit") int limit, @Query2("with_member") boolean withMember, @Query2("upgrade_response_type") boolean upgradeResponseType) {
        return this._api.getGuildScheduledEventUsers(guildId, eventId, limit, withMember, upgradeResponseType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/scheduled-events")
    public Observable<List<GuildScheduledEvent>> getGuildScheduledEvents(@Path2("guildId") long guildId, @Query2("with_user_count") boolean withUserCount) {
        return this._api.getGuildScheduledEvents(guildId, withUserCount);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/templates/{guildTemplateCode}")
    public Observable<ModelGuildTemplate> getGuildTemplateCode(@Path2("guildTemplateCode") String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this._api.getGuildTemplateCode(guildTemplateCode);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/regions")
    public Observable<List<ModelVoiceRegion>> getGuildVoiceRegions(@Path2("guildId") long guildId) {
        return this._api.getGuildVoiceRegions(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/welcome-screen")
    public Observable<GuildWelcomeScreen> getGuildWelcomeScreen(@Path2("guildId") long guildId) {
        return this._api.getGuildWelcomeScreen(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/harvest")
    public Observable<ModelUserConsents3> getHarvestStatus() {
        return this._api.getHarvestStatus();
    }

    public final Observable<HarvestState> getHarvestStatusGuarded() {
        Observable<R> observableG = this._api.getHarvestStatus().G(new Func1<ModelUserConsents3, HarvestState>() { // from class: com.discord.utilities.rest.RestAPI.getHarvestStatusGuarded.1
            @Override // j0.k.Func1
            public final HarvestState call(ModelUserConsents3 modelUserConsents3) {
                return modelUserConsents3 != null ? new HarvestState.LastRequested(modelUserConsents3) : new HarvestState.NeverRequested();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "_api.getHarvestStatus()\n…erRequested()\n          }");
        return ObservableExtensionsKt.restSubscribeOn(observableG, false);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/messages/{messageId}/interaction-data")
    public Observable<ApplicationCommandData> getInteractionData(@Path2("channelId") long channelId, @Path2("messageId") long messageId) {
        return this._api.getInteractionData(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("invites/{code}")
    public Observable<retrofit2.Response<ModelInvite>> getInviteCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @Query2("with_counts") boolean withCounts, @Query2("guild_scheduled_event_id") Long guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.getInviteCode(code, withCounts, guildScheduledEventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/billing/invoices/preview")
    public Observable<ModelInvoicePreview> getInvoicePreview(@Body RestAPIParams.InvoicePreviewBody invoicePreviewBody) {
        Intrinsics3.checkNotNullParameter(invoicePreviewBody, "invoicePreviewBody");
        return this._api.getInvoicePreview(invoicePreviewBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/library")
    public Observable<List<ModelLibraryApplication>> getLibrary() {
        return this._api.getLibrary();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("auth/location-metadata")
    public Observable<ModelLocationMetadata> getLocationMetadata() {
        return this._api.getLocationMetadata();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/scheduled-events")
    public Observable<List<GuildScheduledEventMeUser>> getMeGuildScheduledEvents(@Query2("guild_ids") long guildIds) {
        return this._api.getMeGuildScheduledEvents(guildIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/mentions")
    public Observable<List<Message>> getMentions(@Query2("limit") int limit, @Query2("roles") boolean roles, @Query2(ModelGuildMemberListUpdate.EVERYONE_ID) boolean everyone, @Query2(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @Query2("before") Long before) {
        return this._api.getMentions(limit, roles, everyone, guildId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/applications/{applicationId}/entitlements")
    public Observable<List<ModelEntitlement>> getMyEntitlements(@Path2("applicationId") long applicationId, @Query2("exclude_consumed") boolean excludeConsumed) {
        return this._api.getMyEntitlements(applicationId, excludeConsumed);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/users/@me/threads/archived/private")
    public Observable<ThreadListing> getMyPrivateArchivedThreads(@Path2("channelId") long channelId, @Query2("before") Long before) {
        return this._api.getMyPrivateArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("oauth2/tokens")
    public Observable<List<ModelOAuth2Token>> getOAuthTokens() {
        return this._api.getOAuthTokens();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("oauth2/authorize")
    public Observable<RestAPIParams.OAuth2Authorize.ResponseGet> getOauth2Authorize(@Query2("client_id") String clientId, @Query2("state") String state, @Query2("response_type") String responseType, @Query2("redirect_uri") String redirectUrl, @Query2("prompt") String prompt, @Query2("scope") String scope, @Query2(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions) {
        outline.q0(clientId, "clientId", prompt, "prompt", scope, "scope");
        return this._api.getOauth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("oauth2/samsung/authorize")
    public Observable<Void> getOauth2SamsungAuthorize(@Query2("client_id") String clientId, @Query2("state") String state, @Query2("response_type") String responseType, @Query2("redirect_uri") String redirectUrl, @Query2("prompt") String prompt, @Query2("scope") String scope) {
        outline.q0(clientId, "clientId", prompt, "prompt", scope, "scope");
        return this._api.getOauth2SamsungAuthorize(clientId, state, responseType, redirectUrl, prompt, scope);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("applications/{applicationId}/payment-payout-groups")
    public Observable<List<PayoutGroup>> getPaymentPayoutGroups(@Path2("applicationId") long applicationId) {
        return this._api.getPaymentPayoutGroups(applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/billing/payment-sources")
    public Observable<List<ModelPaymentSource3>> getPaymentSources() {
        return this._api.getPaymentSources();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("store/price-tiers")
    public Observable<List<Integer>> getPriceTiers(@Query2("price_tier_type") int priceTierType) {
        return this._api.getPriceTiers(priceTierType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/prune")
    public Observable<PruneCountResponse> getPruneCount(@Path2("guildId") long guildId, @Query2("days") int days) {
        return this._api.getPruneCount(guildId, days);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/messages/{messageId}/reactions/{emoji}")
    public Observable<List<com.discord.api.user.User>> getReactionUsers(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "emoji") String emoji, @Query2("limit") Integer limit) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        return this._api.getReactionUsers(channelId, messageId, emoji, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("stage-instances")
    public Observable<retrofit2.Response<List<RecommendedStageInstance>>> getRecommendedStageInstances() {
        return this._api.getRecommendedStageInstances();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/{userId}/relationships")
    public Observable<List<ModelUserRelationship>> getRelationships(@Path2("userId") long userId) {
        return this._api.getRelationships(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("reporting/menu/{reportType}")
    public Observable<MenuAPIResponse> getReportMenu(@Path2("reportType") String reportType) {
        Intrinsics3.checkNotNullParameter(reportType, "reportType");
        return this._api.getReportMenu(reportType);
    }

    public final Observable<List<ModelRtcLatencyRegion>> getRtcLatencyTestRegionsIps() {
        RestAPIInterface.RtcLatency rtcLatency = apiRtcLatency;
        if (rtcLatency == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("apiRtcLatency");
        }
        return ObservableExtensionsKt.restSubscribeOn$default(rtcLatency.get("https://latency.discord.media/rtc"), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("tracks/{id}")
    public Observable<ModelSpotifyTrack> getSpotifyTrack(@Path2(ModelAuditLogEntry.CHANGE_KEY_ID) String id2) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return this._api.getSpotifyTrack(id2);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("stage-instances/extra")
    public Observable<List<RecommendedStageInstance>> getStageInstancesForChannels(@Query2("channel_ids") Set<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        return this._api.getStageInstancesForChannels(channelIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("stickers/{stickerId}")
    public Observable<Sticker> getSticker(@Path2("stickerId") long stickerId) {
        return this._api.getSticker(stickerId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("stickers/{stickerId}/guild")
    public Observable<Guild> getStickerGuild(@Path2("stickerId") long stickerId) {
        return this._api.getStickerGuild(stickerId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("sticker-packs/{packId}")
    public Observable<ModelStickerPack> getStickerPack(@Path2("packId") long packId) {
        return this._api.getStickerPack(packId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("sticker-packs")
    public Observable<ModelStickerStoreDirectory> getStickerPacks() {
        return this._api.getStickerPacks();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("streams/{streamKey}/preview")
    public Observable<ModelApplicationStreamPreview> getStreamPreview(@Path2("streamKey") String streamKey, @Query2("version") long version) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        return this._api.getStreamPreview(streamKey, version);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/guilds/premium/subscription-slots")
    public Observable<List<ModelGuildBoostSlot>> getSubscriptionSlots() {
        return this._api.getSubscriptionSlots();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/billing/subscriptions")
    public Observable<List<ModelSubscription>> getSubscriptions() {
        return this._api.getSubscriptions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("gifs/trending")
    public Observable<TrendingGifCategoriesResponseDto> getTrendingGifCategories(@Query2("provider") String provider, @Query2("locale") String locale, @Query2("media_format") String mediaFormat) {
        outline.q0(provider, "provider", locale, "locale", mediaFormat, "mediaFormat");
        return this._api.getTrendingGifCategories(provider, locale, mediaFormat);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("gifs/trending-gifs")
    public Observable<List<GifDto>> getTrendingGifCategory(@Query2("provider") String provider, @Query2("locale") String locale, @Query2("media_format") String mediaFormat, @Query2("limit") int limit) {
        outline.q0(provider, "provider", locale, "locale", mediaFormat, "mediaFormat");
        return this._api.getTrendingGifCategory(provider, locale, mediaFormat, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/affinities/users")
    public Observable<ModelUserAffinities> getUserAffinities() {
        return this._api.getUserAffinities();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/join-request-guilds")
    public Observable<List<Guild>> getUserJoinRequestGuilds() {
        return this._api.getUserJoinRequestGuilds();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/notes/{userId}")
    public Observable<ModelUserNote> getUserNote(@Path2("userId") long userId) {
        return this._api.getUserNote(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/survey")
    public Observable<retrofit2.Response<UserSurvey3>> getUserSurvey() {
        return this._api.getUserSurvey();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/vanity-url")
    public Observable<VanityUrlResponse> getVanityUrl(@Path2("guildId") long guildId) {
        return this._api.getVanityUrl(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("friend-suggestions/{userId}")
    public Observable<Void> ignoreFriendSuggestion(@Path2("userId") long userId) {
        return this._api.ignoreFriendSuggestion(userId);
    }

    public final Observable<Void> inviteUserToSpeak(Channel channel, long userId, Clock clock) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return this._api.updateUserVoiceStates(channel.getGuildId(), userId, new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), Boolean.FALSE, new UtcDateTime(clock.currentTimeMillis())));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("guilds/{guildId}/members/@me")
    public Observable<Guild> joinGuild(@Path2("guildId") long guildId, @Query2("lurker") boolean isLurker, @Query2("session_id") String sessionId, @Query2("directory_channel_id") Long directoryChannelId, @Body RestAPIParams.InviteCode body, @Header3("X-Context-Properties") String context) {
        return this._api.joinGuild(guildId, isLurker, sessionId, directoryChannelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("integrations/{integrationId}/join")
    public Observable<Void> joinGuildFromIntegration(@Path2("integrationId") String integrationId) {
        Intrinsics3.checkNotNullParameter(integrationId, "integrationId");
        return this._api.joinGuildFromIntegration(integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("hub-waitlist/signup")
    public Observable<WaitlistSignup> joinHubWaitlist(@Body RestAPIParams.HubWaitlist body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.joinHubWaitlist(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/thread-members/@me")
    public Observable<Void> joinThread(@Path2("channelId") long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @Body RestAPIParams.EmptyBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.joinThread(channelId, location, body);
    }

    public final String jsonObjectOf(Tuples2<String, ? extends Object>... map) {
        Intrinsics3.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Tuples2<String, ? extends Object> tuples2 : map) {
            try {
                jSONObject.put(tuples2.component1(), tuples2.component2());
            } catch (JSONException e) {
                Logger.e$default(AppLog.g, "RestAPI", "Unable to serialize context property.", e, null, 8, null);
            }
        }
        String string = jSONObject.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "it.toString()");
        Charset charset = Charsets2.a;
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = string.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "JSONObject().apply {\n   …toByteArray(), NO_WRAP) }");
        return strEncodeToString;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/members/{userId}")
    public Observable<Void> kickGuildMember(@Path2("guildId") long guildId, @Path2("userId") long userId, @Header3("X-Audit-Log-Reason") String reason) {
        return this._api.kickGuildMember(guildId, userId, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("users/@me/guilds/{guildId}")
    public Observable<Void> leaveGuild(@Path2("guildId") long guildId) {
        return this._api.leaveGuild(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @HTTP(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/guilds/{guildId}")
    public Observable<Void> leaveGuild(@Path2("guildId") long guildId, @Body RestAPIParams.LeaveGuildBody leaveGuildBody) {
        Intrinsics3.checkNotNullParameter(leaveGuildBody, "leaveGuildBody");
        return this._api.leaveGuild(guildId, leaveGuildBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/thread-members/@me")
    public Observable<Void> leaveThread(@Path2("channelId") long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location) {
        return this._api.leaveThread(channelId, location);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/logout")
    public Observable<retrofit2.Response<Void>> logout(@Body RestAPIParams.UserDevices body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.logout(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}/directory-entry/{guildId}")
    public Observable<DirectoryEntryGuild> modifyServerInHub(@Path2("channelId") long channelId, @Path2("guildId") long guildId, @Body RestAPIParams.AddServerBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.modifyServerInHub(channelId, guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/emojis/{emojiId}")
    public Observable<ModelEmojiGuild> patchGuildEmoji(@Path2("guildId") long guildId, @Path2("emojiId") long emojiId, @Body RestAPIParams.PatchGuildEmoji body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.patchGuildEmoji(guildId, emojiId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me")
    public Observable<com.discord.api.user.User> patchUser(@Body PatchUserBody patchUserBody) {
        Intrinsics3.checkNotNullParameter(patchUserBody, "patchUserBody");
        return this._api.patchUser(patchUserBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me")
    public Observable<com.discord.api.user.User> patchUser(@Body RestAPIParams.UserInfo userInfo) {
        Intrinsics3.checkNotNullParameter(userInfo, "userInfo");
        return this._api.patchUser(userInfo);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("phone-verifications/resend")
    public Observable<Void> phoneVerificationsResend(@Body RestAPIParams.VerificationCodeResend body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.phoneVerificationsResend(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("phone-verifications/verify")
    public Observable<retrofit2.Response<ModelPhoneVerificationToken>> phoneVerificationsVerify(@Body RestAPIParams.VerificationCode body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.phoneVerificationsVerify(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/fingerprint")
    public Observable<FingerprintResponse> postAuthFingerprint(@Body RestAPIParams.EmptyBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postAuthFingerprint(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/login")
    public Observable<retrofit2.Response<ModelLoginResult>> postAuthLogin(@Body RestAPIParams.AuthLogin body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postAuthLogin(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/register")
    public Observable<retrofit2.Response<RegisterResponse>> postAuthRegister(@Body RestAPIParams.AuthRegister body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postAuthRegister(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/register/phone")
    public Observable<retrofit2.Response<Void>> postAuthRegisterPhone(@Body RestAPIParams.AuthRegisterPhone body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postAuthRegisterPhone(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/verify/resend")
    public Observable<retrofit2.Response<Void>> postAuthVerifyResend(@Body RestAPIParams.EmptyBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postAuthVerifyResend(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/invites")
    public Observable<ModelInvite> postChannelInvite(@Path2("channelId") long channelId, @Body RestAPIParams.Invite body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postChannelInvite(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/messages/{messageId}/ack")
    public Observable<Void> postChannelMessagesAck(@Path2("channelId") long channelId, @Path2("messageId") Long messageId, @Body RestAPIParams.ChannelMessagesAck body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postChannelMessagesAck(channelId, messageId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/emojis")
    public Observable<ModelEmojiGuild> postGuildEmoji(@Path2("guildId") long guildId, @Body RestAPIParams.PostGuildEmoji body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postGuildEmoji(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/ack/{ackType}/{ackedId}")
    public Observable<Void> postGuildFeatureAck(@Path2("guildId") long channelId, @Path2("ackType") int ackType, @Path2("ackedId") long ackedId, @Body RestAPIParams.GuildFeatureAck body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postGuildFeatureAck(channelId, ackType, ackedId, body);
    }

    public final Observable<ModelInvite> postInviteCode(ModelInvite invite, String location, RestAPIParams.InviteCode body) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(body, "body");
        RestAPIInterface restAPIInterface = this._api;
        String str = invite.code;
        Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
        Tuples2<String, ? extends Object>[] tuples2Arr = new Tuples2[5];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        Guild guild = invite.guild;
        tuples2Arr[1] = Tuples.to("location_guild_id", guild != null ? Long.valueOf(guild.getId()) : null);
        Channel channel = invite.getChannel();
        tuples2Arr[2] = Tuples.to("location_channel_id", channel != null ? Long.valueOf(channel.getId()) : null);
        Channel channel2 = invite.getChannel();
        tuples2Arr[3] = Tuples.to("location_channel_type", channel2 != null ? Integer.valueOf(channel2.getType()) : null);
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        tuples2Arr[4] = Tuples.to("invite_guild_scheduled_event_id", guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
        return ObservableExtensionsKt.restSubscribeOn$default(restAPIInterface.postInviteCode(str, body, jsonObjectOf(tuples2Arr)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("invites/{code}")
    public Observable<ModelInvite> postInviteCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @Body RestAPIParams.InviteCode body, @Header3("X-Context-Properties") String context) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(body, "body");
        Intrinsics3.checkNotNullParameter(context, "context");
        return this._api.postInviteCode(code, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("auth/mfa/totp")
    public Observable<retrofit2.Response<ModelLoginResult>> postMFACode(@Body RestAPIParams.MFALogin body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postMFACode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("oauth2/authorize")
    public Observable<RestAPIParams.OAuth2Authorize.ResponsePost> postOauth2Authorize(@Query2("client_id") String clientId, @Query2("state") String state, @Query2("response_type") String responseType, @Query2("redirect_uri") String redirectUrl, @Query2("prompt") String prompt, @Query2("scope") String scope, @Query2(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions, @Query2("code_challenge") String codeChallenge, @Query2("code_challenge_method") String codeChallengeMethod, @Body Map<String, String> body) {
        Intrinsics3.checkNotNullParameter(clientId, "clientId");
        Intrinsics3.checkNotNullParameter(prompt, "prompt");
        Intrinsics3.checkNotNullParameter(scope, "scope");
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postOauth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/remote-auth/cancel")
    public Observable<Void> postRemoteAuthCancel(@Body RestAPIParams.RemoteAuthCancel body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthCancel(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/remote-auth/finish")
    public Observable<Void> postRemoteAuthFinish(@Body RestAPIParams.RemoteAuthFinish body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthFinish(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/remote-auth")
    public Observable<ModelRemoteAuthHandshake> postRemoteAuthInitialize(@Body RestAPIParams.RemoteAuthInitialize body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthInitialize(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("streams/{streamKey}/preview")
    public Observable<Void> postStreamPreview(@Path2("streamKey") String streamKey, @Body RestAPIParams.Thumbnail thumbnail) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(thumbnail, "thumbnail");
        return this._api.postStreamPreview(streamKey, thumbnail);
    }

    public final Observable<Void> postStreamPreview(String streamKey, String thumbnail) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(thumbnail, "thumbnail");
        return this._api.postStreamPreview(streamKey, new RestAPIParams.Thumbnail(thumbnail));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/prune")
    public Observable<Void> pruneMembers(@Path2("guildId") long guildId, @Body RestAPIParams.PruneGuild body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.pruneMembers(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/messages/{messageId}/reactions")
    public Observable<Void> removeAllReactions(@Path2("channelId") long channelId, @Path2("messageId") long messageId) {
        return this._api.removeAllReactions(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/recipients/{recipientId}")
    public Observable<Void> removeChannelRecipient(@Path2("channelId") long channelId, @Path2("recipientId") long recipientId) {
        return this._api.removeChannelRecipient(channelId, recipientId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/messages/{messageId}/reactions/{reaction}/{userId}")
    public Observable<Void> removeReaction(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction, @Path2("userId") long userId) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        return this._api.removeReaction(channelId, messageId, reaction, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("users/@me/relationships/{userId}")
    public Observable<Void> removeRelationship(@Path2("userId") long userId, @Header3("X-Context-Properties") String context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return this._api.removeRelationship(userId, context);
    }

    public final Observable<Void> removeRelationship(String location, long userId) {
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.removeRelationship(userId, jsonObjectOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    public Observable<Void> removeSelfReaction(@Path2("channelId") long channelId, @Path2("messageId") long messageId, @Path2(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        return this._api.removeSelfReaction(channelId, messageId, reaction);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("channels/{channelId}/directory-entry/{guildId}")
    public Observable<retrofit2.Response<DirectoryEntryGuild>> removeServerFromHub(@Path2("channelId") long channelId, @Path2("guildId") long guildId) {
        return this._api.removeServerFromHub(channelId, guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/channels")
    public Observable<Void> reorderChannels(@Path2("guildId") long guildId, @Body List<RestAPIParams.ChannelPosition> body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.reorderChannels(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("report")
    public Observable<Unit> report(@Body RestAPIParams.Report body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.report(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("report")
    public Observable<List<ReportReason>> report(@Query2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @Query2(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @Query2("message_id") Long messageId, @Query2("user_id") Long userId) {
        return this._api.report(channelId, guildId, messageId, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/harvest")
    public Observable<ModelUserConsents3> requestHarvest() {
        return this._api.requestHarvest();
    }

    public final Observable<Void> requestToSpeak(Channel channel, Clock clock) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return this._api.updateMyVoiceStates(channel.getGuildId(), new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), null, new UtcDateTime(clock.currentTimeMillis()), 2, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> resetGuildJoinRequest(@Path2("guildId") long guildId) {
        return this._api.resetGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("entitlements/gift-codes/{code}")
    public Observable<ModelGift> resolveGiftCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @Query2("with_application") boolean withApplication, @Query2("with_subscription_plan") boolean withSubscription) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.resolveGiftCode(code, withApplication, withSubscription);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/@me/entitlements/gift-codes")
    public Observable<List<ModelGift>> resolveSkuIdGift(@Query2("sku_id") long skuId, @Query2("subscription_plan_id") Long subscriptionPlanId) {
        return this._api.resolveSkuIdGift(skuId, subscriptionPlanId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("users/@me/entitlements/gift-codes/{code}")
    public Observable<Void> revokeGiftCode(@Path2(ModelAuditLogEntry.CHANGE_KEY_CODE) String code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.revokeGiftCode(code);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("invites/{inviteCode}")
    public Observable<ModelInvite> revokeInvite(@Path2("inviteCode") String inviteCode) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        return this._api.revokeInvite(inviteCode);
    }

    public final Observable<Void> ring(long channelId, long messageId, List<Long> recipients) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.ring(channelId, new RestAPIParams.Ring(recipients), jsonObjectOf(Tuples.to("message_id", Long.valueOf(messageId)))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/call/ring")
    public Observable<Void> ring(@Path2("channelId") long channelId, @Body RestAPIParams.Ring body, @Header3("X-Context-Properties") String context) {
        Intrinsics3.checkNotNullParameter(body, "body");
        Intrinsics3.checkNotNullParameter(context, "context");
        return this._api.ring(channelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("science")
    public Observable<Void> science(@Body Science body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.science(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/messages/search")
    public Observable<ModelSearchResponse> searchChannelMessages(@Path2("channelId") long channelId, @Query2("max_id") Long oldestMessageId, @Query2("author_id") List<String> authorIds, @Query2("mentions") List<String> mentionsIds, @Query2("has") List<String> has, @Query2("content") List<String> content, @Query2("attempts") Integer attempts, @Query2("include_nsfw") Boolean includeNsfw) {
        return this._api.searchChannelMessages(channelId, oldestMessageId, authorIds, mentionsIds, has, content, attempts, includeNsfw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("guilds/{guildId}/messages/search")
    public Observable<ModelSearchResponse> searchGuildMessages(@Path2("guildId") long guildId, @Query2("max_id") Long oldestMessageId, @Query2("author_id") List<String> authorIds, @Query2("mentions") List<String> mentionsIds, @Query2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) List<String> inChannelIds, @Query2("has") List<String> has, @Query2("content") List<String> content, @Query2("attempts") Integer attempts, @Query2("include_nsfw") Boolean includeNsfw) {
        return this._api.searchGuildMessages(guildId, oldestMessageId, authorIds, mentionsIds, inChannelIds, has, content, attempts, includeNsfw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("channels/{channelId}/directory-entries/search")
    public Observable<List<DirectoryEntryGuild>> searchServers(@Path2("channelId") long channelId, @Query2("query") String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        return this._api.searchServers(channelId, query);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("interactions")
    @Multipart
    public Observable<Void> sendApplicationCommand(@Part2("payload_json") PayloadJSON<RestAPIParams.ApplicationCommand> payloadJson, @Part2 MultipartBody.Part[] files) {
        Intrinsics3.checkNotNullParameter(payloadJson, "payloadJson");
        Intrinsics3.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.sendApplicationCommand(payloadJson, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("interactions")
    public Observable<Void> sendApplicationCommand(@Body RestAPIParams.ApplicationCommand body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.sendApplicationCommand(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("private/bug-reports")
    @Multipart
    public Observable<Unit> sendBugReport(@Part2(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @Part2(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) String description, @Part2("priority") int priority, @Part2("asana_inbox_id") Long asanaInboxId, @Part2 MultipartBody.Part screenshot) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this._api.sendBugReport(name, description, priority, asanaInboxId, screenshot);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("interactions")
    public Observable<Void> sendComponentInteraction(@Body RestAPIParams.ComponentInteraction body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.sendComponentInteraction(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/greet")
    public Observable<Message> sendGreetMessage(@Path2("channelId") long channelId, @Body RestAPIParams.GreetMessage body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.sendGreetMessage(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/messages")
    @Multipart
    public Observable<Message> sendMessage(@Path2("channelId") long channelId, @Part2("payload_json") PayloadJSON<RestAPIParams.Message> payloadJson, @Part2 MultipartBody.Part[] files) {
        Intrinsics3.checkNotNullParameter(payloadJson, "payloadJson");
        Intrinsics3.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.sendMessage(channelId, payloadJson, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/messages")
    public Observable<Message> sendMessage(@Path2("channelId") long channelId, @Body RestAPIParams.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        return this._api.sendMessage(channelId, message);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("interactions")
    public Observable<Void> sendModalInteraction(@Body RestAPIParams.ModalInteraction body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.sendModalInteraction(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/relationships")
    public Observable<Void> sendRelationshipRequest(@Body RestAPIParams.UserRelationship.Add relationship, @Header3("X-Context-Properties") String context) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        Intrinsics3.checkNotNullParameter(context, "context");
        return this._api.sendRelationshipRequest(relationship, context);
    }

    public final Observable<Void> sendRelationshipRequest(String location, String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(username, "username");
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.sendRelationshipRequest(new RestAPIParams.UserRelationship.Add(username, discriminator, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), jsonObjectOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/consent")
    public Observable<Void> setConsents(@Body RestAPIParams.Consents body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.setConsents(body);
    }

    public final Observable<Void> setMeSuppressed(Channel channel, boolean isSuppressed) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return this._api.updateMyVoiceStates(channel.getGuildId(), new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), Boolean.valueOf(isSuppressed), null, 4, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/mfa")
    public Observable<Void> setMfaLevel(@Path2("guildId") long guildId, @Body RestAPIParams.GuildMFA body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.setMfaLevel(guildId, body);
    }

    public final Observable<Void> setUserSuppressed(Channel channel, long userId, boolean isSuppressed) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return this._api.updateUserVoiceStates(channel.getGuildId(), userId, new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), Boolean.valueOf(isSuppressed), null, 4, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/typing")
    public Observable<ModelTypingResponse> setUserTyping(@Path2("channelId") long channelId, @Body RestAPIParams.EmptyBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.setUserTyping(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("stage-instances")
    public Observable<StageInstance> startStageInstance(@Body RestAPIParams.StartStageInstanceBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.startStageInstance(body);
    }

    public final Observable<Void> stopRinging(long channelId, long messageId, List<Long> recipients) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.stopRinging(channelId, new RestAPIParams.Ring(recipients), jsonObjectOf(Tuples.to("message_id", Long.valueOf(messageId)))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("channels/{channelId}/call/stop-ringing")
    public Observable<Void> stopRinging(@Path2("channelId") long channelId, @Body RestAPIParams.Ring body, @Header3("X-Context-Properties") String context) {
        Intrinsics3.checkNotNullParameter(body, "body");
        Intrinsics3.checkNotNullParameter(context, "context");
        return this._api.stopRinging(channelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("connections/{connection}/callback")
    public Observable<Void> submitConnectionState(@Path2("connection") String connection, @Body RestAPIParams.ConnectionState state) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        Intrinsics3.checkNotNullParameter(state, "state");
        return this._api.submitConnectionState(connection, state);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("reporting/{reportType}")
    public Observable<Unit> submitReport(@Path2("reportType") String reportType, @Body ReportSubmissionBody body) {
        Intrinsics3.checkNotNullParameter(reportType, "reportType");
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.submitReport(reportType, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("guilds/{guildId}/premium/subscriptions")
    public Observable<List<ModelAppliedGuildBoost>> subscribeToGuild(@Path2("guildId") long guildId, @Body RestAPIParams.GuildBoosting guildBoosting) {
        Intrinsics3.checkNotNullParameter(guildBoosting, "guildBoosting");
        return this._api.subscribeToGuild(guildId, guildBoosting);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/{guildId}/integrations/{integrationId}/sync")
    public Observable<Void> syncIntegration(@Path2("guildId") long guildId, @Path2("integrationId") long integrationId) {
        return this._api.syncIntegration(guildId, integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}")
    public Observable<Void> transferGuildOwnership(@Path2("guildId") long guildId, @Body RestAPIParams.TransferGuildOwnership transferGuildOwnership) {
        Intrinsics3.checkNotNullParameter(transferGuildOwnership, "transferGuildOwnership");
        return this._api.transferGuildOwnership(guildId, transferGuildOwnership);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/bans/{userId}")
    public Observable<Void> unbanUser(@Path2("guildId") long guildId, @Path2("userId") long userId) {
        return this._api.unbanUser(guildId, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/uncancel")
    public Observable<ModelGuildBoostSlot> uncancelSubscriptionSlot(@Path2("subscriptionSlotId") long slotId) {
        return this._api.uncancelSubscriptionSlot(slotId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @DELETE("guilds/{guildId}/premium/subscriptions/{subscriptionId}")
    public Observable<Void> unsubscribeToGuild(@Path2("guildId") long guildId, @Path2("subscriptionId") long subscriptionId) {
        return this._api.unsubscribeToGuild(guildId, subscriptionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/connections/{connection}/{connectionId}")
    public Observable<retrofit2.Response<ConnectedAccount>> updateConnection(@Path2("connection") String connection, @Path2("connectionId") String connectionId, @Body RestAPIParams.ConnectedAccount connectedAccount) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        Intrinsics3.checkNotNullParameter(connectionId, "connectionId");
        Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
        return this._api.updateConnection(connection, connectionId, connectedAccount);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/connections/{connection}/{connectionId}")
    public Observable<retrofit2.Response<ConnectedAccount>> updateConnectionName(@Path2("connection") String connection, @Path2("connectionId") String connectionId, @Body RestAPIParams.ConnectedAccountNameOnly connectedAccountName) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        Intrinsics3.checkNotNullParameter(connectionId, "connectionId");
        Intrinsics3.checkNotNullParameter(connectedAccountName, "connectedAccountName");
        return this._api.updateConnectionName(connection, connectionId, connectedAccountName);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}")
    public Observable<Guild> updateGuild(@Path2("guildId") long guildId, @Body RestAPIParams.UpdateGuild body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateGuild(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/integrations/{integrationId}")
    public Observable<Void> updateGuildIntegration(@Path2("guildId") long guildId, @Path2("integrationId") long integrationId, @Body RestAPIParams.GuildIntegration body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateGuildIntegration(guildId, integrationId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    public Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Body RestAPIParams.UpdateGuildRoleSubscriptionGroupListing body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/role-subscriptions/subscription-listings/{listingId}/trial")
    public Observable<GuildRoleSubscriptionTierFreeTrial> updateGuildRoleSubscriptionTierFreeTrial(@Path2("guildId") long guildId, @Path2("listingId") long listingId, @Body RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionTierFreeTrial(guildId, listingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    public Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(@Path2("guildId") long guildId, @Path2("groupListingId") long groupListingId, @Path2("listingId") long tierListingId, @Body RestAPIParams.UpdateGuildRoleSubscriptionTierListing body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<Unit> updateGuildScheduledEvent(@Path2("guildId") long guildId, @Path2("eventId") long eventId, @Body RestAPIParams.UpdateGuildScheduledEventBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateGuildScheduledEvent(guildId, eventId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/members/@me")
    public Observable<GuildMember> updateMeGuildMember(@Path2("guildId") long guildId, @Body PatchGuildMemberBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateMeGuildMember(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/voice-states/@me")
    public Observable<Void> updateMyVoiceStates(@Path2("guildId") long guildId, @Body RestAPIParams.ChannelVoiceStateUpdate body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateMyVoiceStates(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/billing/payment-sources/{paymentSourceId}")
    public Observable<Void> updatePaymentSource(@Path2("paymentSourceId") String paymentSourceId, @Body ModelPaymentSource2 PatchPaymentSourceRaw) {
        Intrinsics3.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        Intrinsics3.checkNotNullParameter(PatchPaymentSourceRaw, "PatchPaymentSourceRaw");
        return this._api.updatePaymentSource(paymentSourceId, PatchPaymentSourceRaw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("channels/{channelId}/permissions/{targetId}")
    public Observable<Void> updatePermissionOverwrites(@Path2("channelId") long channelId, @Path2("targetId") long targetId, @Body RestAPIParams.ChannelPermissionOverwrites body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updatePermissionOverwrites(channelId, targetId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/guilds/@me/settings")
    public Observable<ModelNotificationSettings> updatePrivateChannelSettings(@Body RestAPIParams.UserGuildSettings userGuildSettings) {
        Intrinsics3.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        return this._api.updatePrivateChannelSettings(userGuildSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/roles/{roleId}")
    public Observable<Void> updateRole(@Path2("guildId") long guildId, @Path2("roleId") long roleId, @Body RestAPIParams.Role body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateRole(guildId, roleId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("stage-instances/{channelId}")
    public Observable<StageInstance> updateStageInstance(@Path2("channelId") long channelId, @Body RestAPIParams.UpdateStageInstanceBody body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateStageInstance(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/billing/subscriptions/{subscriptionId}")
    public Observable<Void> updateSubscription(@Path2("subscriptionId") String subscriptionId, @Body RestAPIParams.UpdateSubscription updateSubscription) {
        Intrinsics3.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics3.checkNotNullParameter(updateSubscription, "updateSubscription");
        return this._api.updateSubscription(subscriptionId, updateSubscription);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("channels/{channelId}/thread-members/@me/settings")
    public Observable<ThreadMember> updateThreadMemberSettings(@Path2("channelId") long channelId, @Body RestAPIParams.ThreadMemberSettings body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateThreadMemberSettings(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    public Observable<ModelNotificationSettings> updateUserGuildSettings(long guildId, RestAPIParams.UserGuildSettings userGuildSettings) {
        Intrinsics3.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        return guildId == 0 ? this._api.updatePrivateChannelSettings(userGuildSettings) : this._api.updateUserGuildSettings(guildId, userGuildSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("users/@me/notes/{userId}")
    public Observable<Void> updateUserNotes(@Path2("userId") long userId, @Body RestAPIParams.UserNoteUpdate userNoteUpdate) {
        Intrinsics3.checkNotNullParameter(userNoteUpdate, "userNoteUpdate");
        return this._api.updateUserNotes(userId, userNoteUpdate);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/settings")
    public Observable<ModelUserSettings> updateUserSettings(@Body RestAPIParams.UserSettings userSettings) {
        Intrinsics3.checkNotNullParameter(userSettings, "userSettings");
        return this._api.updateUserSettings(userSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/settings")
    public Observable<ModelUserSettings> updateUserSettingsCustomStatus(@Body RestAPIParams.UserSettingsCustomStatus userSettingsCustomStatus) {
        Intrinsics3.checkNotNullParameter(userSettingsCustomStatus, "userSettingsCustomStatus");
        return this._api.updateUserSettingsCustomStatus(userSettingsCustomStatus);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/voice-states/{userId}")
    public Observable<Void> updateUserVoiceStates(@Path2("guildId") long guildId, @Path2("userId") long userId, @Body RestAPIParams.ChannelVoiceStateUpdate body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateUserVoiceStates(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("guilds/{guildId}/vanity-url")
    public Observable<VanityUrlResponse> updateVanityUrl(@Path2("guildId") long guildId, @Body RestAPIParams.VanityUrl body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.updateVanityUrl(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("users/@me/connections/contacts/@me/external-friend-list-entries")
    public Observable<retrofit2.Response<BulkFriendSuggestions>> uploadContacts(@Body RestAPIParams.UploadContacts uploadContacts) {
        Intrinsics3.checkNotNullParameter(uploadContacts, "uploadContacts");
        return this._api.uploadContacts(uploadContacts);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("debug-logs/4/{filename}")
    public Observable<Void> uploadLog(@Path2("filename") String filename, @Body String content) {
        Intrinsics3.checkNotNullParameter(filename, "filename");
        Intrinsics3.checkNotNullParameter(content, "content");
        return this._api.uploadLog(filename, content);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("debug-logs/multi/4")
    @Multipart
    public Observable<Void> uploadLogs(@Part2 MultipartBody.Part[] files) {
        Intrinsics3.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.uploadLogs(files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/{userId}/sessions/{sessionId}/activities/{applicationId}/{actionType}")
    public Observable<ActivityActionConfirmation> userActivityAction(@Path2("userId") long userId, @Path2("applicationId") long application, @Path2("sessionId") String sessionId, @Path2("actionType") Integer actionType, @Query2(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @Query2("message_id") Long messageId) {
        Intrinsics3.checkNotNullParameter(sessionId, "sessionId");
        return this._api.userActivityAction(userId, application, sessionId, actionType, channelId, messageId);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long j, long j2, String str) {
        return userActivityActionJoin$default(this, j, j2, str, null, null, 24, null);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long j, long j2, String str, Long l) {
        return userActivityActionJoin$default(this, j, j2, str, l, null, 16, null);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long authorId, long applicationId, String sessionId, Long channelId, Long messageId) {
        Intrinsics3.checkNotNullParameter(sessionId, "sessionId");
        return this._api.userActivityAction(authorId, applicationId, sessionId, Integer.valueOf(MessageActivityType.JOIN.getApiInt()), channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/phone")
    public Observable<Void> userAddPhone(@Body RestAPIParams.Phone body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userAddPhone(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/phone/verify")
    public Observable<Void> userAddPhoneNoPassword(@Body RestAPIParams.VerificationCodeOnly body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userAddPhoneNoPassword(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PATCH("users/@me/agreements")
    public Observable<Void> userAgreements(@Body RestAPIParams.UserAgreements body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userAgreements(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/captcha/verify")
    public Observable<Void> userCaptchaVerify(@Body RestAPIParams.CaptchaCode body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userCaptchaVerify(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/channels")
    public Observable<Channel> userCreateChannel(@Body RestAPIParams.CreateChannel body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userCreateChannel(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/devices")
    public Observable<Void> userCreateDevice(@Body RestAPIParams.UserDevices body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userCreateDevice(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @PUT("users/@me/email")
    public Observable<Void> userEmail() {
        return this._api.userEmail();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/email/verify-code")
    public Observable<ModelEmailChangeConfirm> userEmailVerifyCode(@Body RestAPIParams.UserEmailConfirmCode body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userEmailVerifyCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/{userId}")
    public Observable<com.discord.api.user.User> userGet(@Path2("userId") long userId) {
        return this._api.userGet(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @HTTP(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/phone")
    public Observable<Void> userPhoneDelete(@Body RestAPIParams.DeletePhone body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userPhoneDelete(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("users/@me/phone")
    public Observable<Void> userPhoneWithToken(@Body RestAPIParams.VerificationPhoneCode body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.userPhoneWithToken(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @GET("users/{userId}/profile")
    public Observable<UserProfile> userProfileGet(@Path2("userId") long userId, @Query2("with_mutual_guilds") boolean withMutualGuilds, @Query2(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId) {
        return this._api.userProfileGet(userId, withMutualGuilds, guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/automations/email-domain-lookup")
    public Observable<retrofit2.Response<EmailVerification>> verifyEmail(@Body RestAPIParams.VerifyEmail body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.verifyEmail(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("guilds/automations/email-domain-lookup/verify-code")
    public Observable<retrofit2.Response<EmailVerification2>> verifyEmailCode(@Body RestAPIParams.VerifyEmailCode body) {
        Intrinsics3.checkNotNullParameter(body, "body");
        return this._api.verifyEmailCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @POST("google-play/verify-purchase-token")
    public Observable<RestAPIParams.VerifyPurchaseResponse> verifyPurchaseToken(@Body RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseBody) {
        Intrinsics3.checkNotNullParameter(verifyPurchaseBody, "verifyPurchaseBody");
        return this._api.verifyPurchaseToken(verifyPurchaseBody);
    }

    public final Observable<Void> setConsent(boolean consented, String consentType) {
        Intrinsics3.checkNotNullParameter(consentType, "consentType");
        if (consented) {
            return setConsent$default(this, consentType, null, 2, null);
        }
        return setConsent$default(this, null, consentType, 1, null);
    }
}
