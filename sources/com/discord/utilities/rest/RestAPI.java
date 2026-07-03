package com.discord.utilities.rest;

import android.content.Context;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
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
import com.discord.models.user.User;
import com.discord.restapi.BreadcrumbInterceptor;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RequiredHeadersInterceptor;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.SpotifyTokenInterceptor;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12086c;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.p601e0.C12272c;
import p600f0.p614f0.C12362a;
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
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12662q;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Action1;

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
    public static final class AppHeadersProvider implements RequiredHeadersInterceptor.HeadersProvider {
        public static final AppHeadersProvider INSTANCE = new AppHeadersProvider();
        public static Function0<String> authTokenProvider = RestAPI$AppHeadersProvider$authTokenProvider$1.INSTANCE;
        public static Function0<String> fingerprintProvider = RestAPI$AppHeadersProvider$fingerprintProvider$1.INSTANCE;
        public static Function0<String> localeProvider = RestAPI$AppHeadersProvider$localeProvider$1.INSTANCE;
        public static Function0<String> acceptLanguageProvider = RestAPI$AppHeadersProvider$acceptLanguageProvider$1.INSTANCE;
        public static Function0<String> spotifyTokenProvider = RestAPI$AppHeadersProvider$spotifyTokenProvider$1.INSTANCE;

        private AppHeadersProvider() {
        }

        @Override // com.discord.restapi.RequiredHeadersInterceptor.HeadersProvider
        public String getAcceptLanguages() {
            return acceptLanguageProvider.invoke();
        }

        @Override // com.discord.restapi.RequiredHeadersInterceptor.HeadersProvider
        public String getAuthToken() {
            return authTokenProvider.invoke();
        }

        @Override // com.discord.restapi.RequiredHeadersInterceptor.HeadersProvider
        public String getFingerprint() {
            return fingerprintProvider.invoke();
        }

        @Override // com.discord.restapi.RequiredHeadersInterceptor.HeadersProvider
        public String getLocale() {
            return localeProvider.invoke();
        }

        @Override // com.discord.restapi.RequiredHeadersInterceptor.HeadersProvider
        public String getSpotifyToken() {
            return spotifyTokenProvider.invoke();
        }

        @Override // com.discord.restapi.RequiredHeadersInterceptor.HeadersProvider
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
            int i = Interceptor.f27513a;
            return new Interceptor() { // from class: com.discord.utilities.rest.RestAPI$Companion$buildAnalyticsInterceptor$$inlined$invoke$1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) {
                    C12238m.checkParameterIsNotNull(chain, "chain");
                    Request requestMo10230c = chain.mo10230c();
                    C12238m.checkParameterIsNotNull(requestMo10230c, "request");
                    new LinkedHashMap();
                    C12379w c12379w = requestMo10230c.url;
                    String str = requestMo10230c.method;
                    RequestBody requestBody = requestMo10230c.body;
                    Map linkedHashMap = requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : C12136h0.toMutableMap(requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                    Headers.C12930a c12930aM10956e = requestMo10230c.headers.m10956e();
                    String superPropertiesStringBase64 = AnalyticSuperProperties.INSTANCE.getSuperPropertiesStringBase64();
                    C12238m.checkParameterIsNotNull("X-Super-Properties", ModelAuditLogEntry.CHANGE_KEY_NAME);
                    C12238m.checkParameterIsNotNull(superPropertiesStringBase64, "value");
                    c12930aM10956e.m10958a("X-Super-Properties", superPropertiesStringBase64);
                    if (c12379w != null) {
                        return chain.mo10228a(new Request(c12379w, str, c12930aM10956e.m10960c(), requestBody, C12272c.m10116A(linkedHashMap)));
                    }
                    throw new IllegalStateException("url == null".toString());
                }
            };
        }

        public final Interceptor buildLoggingInterceptor() {
            C12362a c12362a = new C12362a(new C12362a.b() { // from class: com.discord.utilities.rest.RestAPI$Companion$buildLoggingInterceptor$1
                @Override // p600f0.p614f0.C12362a.b
                public void log(String message) {
                    C12238m.checkNotNullParameter(message, "message");
                    Logger.v$default(AppLog.f14950g, message, null, 2, null);
                }
            });
            C12362a.a aVar = C12362a.a.BASIC;
            C12238m.checkParameterIsNotNull(aVar, "<set-?>");
            c12362a.f25896c = aVar;
            return c12362a;
        }

        public final RestAPI getApi() {
            RestAPI restAPI = RestAPI.api;
            if (restAPI == null) {
                C12238m.throwUninitializedPropertyAccessException("api");
            }
            return restAPI;
        }

        public final RestAPIInterface.Dynamic getApiClientVersions() {
            RestAPIInterface.Dynamic dynamic = RestAPI.apiClientVersions;
            if (dynamic == null) {
                C12238m.throwUninitializedPropertyAccessException("apiClientVersions");
            }
            return dynamic;
        }

        public final RestAPIInterface.Files getApiFiles() {
            RestAPIInterface.Files files = RestAPI.apiFiles;
            if (files == null) {
                C12238m.throwUninitializedPropertyAccessException("apiFiles");
            }
            return files;
        }

        public final RestAPIInterface.RtcLatency getApiRtcLatency() {
            RestAPIInterface.RtcLatency rtcLatency = RestAPI.apiRtcLatency;
            if (rtcLatency == null) {
                C12238m.throwUninitializedPropertyAccessException("apiRtcLatency");
            }
            return rtcLatency;
        }

        public final RestAPI getApiSerializeNulls() {
            RestAPI restAPI = RestAPI.apiSerializeNulls;
            if (restAPI == null) {
                C12238m.throwUninitializedPropertyAccessException("apiSerializeNulls");
            }
            return restAPI;
        }

        public final RestAPI getApiSpotify() {
            RestAPI restAPI = RestAPI.apiSpotify;
            if (restAPI == null) {
                C12238m.throwUninitializedPropertyAccessException("apiSpotify");
            }
            return restAPI;
        }

        public final void init(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            AppHeadersProvider appHeadersProvider = AppHeadersProvider.INSTANCE;
            RequiredHeadersInterceptor requiredHeadersInterceptor = new RequiredHeadersInterceptor(appHeadersProvider);
            BreadcrumbInterceptor breadcrumbInterceptor = new BreadcrumbInterceptor(AppLog.f14950g);
            Interceptor interceptorBuildAnalyticsInterceptor = buildAnalyticsInterceptor();
            Interceptor interceptorBuildLoggingInterceptor = buildLoggingInterceptor();
            List listMutableListOf = C12147n.mutableListOf(requiredHeadersInterceptor, interceptorBuildAnalyticsInterceptor, buildLoggingInterceptor(), breadcrumbInterceptor);
            List listListOf = C12147n.listOf((Object[]) new Interceptor[]{interceptorBuildLoggingInterceptor, breadcrumbInterceptor});
            PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
            RestAPIBuilder restAPIBuilder = new RestAPIBuilder(BuildConfig.HOST_API, persistentCookieJar);
            setApi(new RestAPI((RestAPIInterface) restAPIBuilder.build(RestAPIInterface.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listMutableListOf, (102 & 16) == 0 ? "client_base" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null)));
            setApiSerializeNulls(new RestAPI((RestAPIInterface) restAPIBuilder.build(RestAPIInterface.class, (102 & 2) != 0 ? false : true, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listMutableListOf, (102 & 16) == 0 ? "client_serialize_nulls" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null)));
            setApiClientVersions((RestAPIInterface.Dynamic) restAPIBuilder.build(RestAPIInterface.Dynamic.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listListOf, (102 & 16) == 0 ? "client_dynamic" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null));
            setApiRtcLatency((RestAPIInterface.RtcLatency) restAPIBuilder.build(RestAPIInterface.RtcLatency.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : listListOf, (102 & 16) == 0 ? "client_rtc_latency" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null));
            setApiSpotify(new RestAPI((RestAPIInterface) new RestAPIBuilder("https://api.spotify.com/v1/", persistentCookieJar).build(RestAPIInterface.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : C12147n.listOf((Object[]) new Interceptor[]{interceptorBuildLoggingInterceptor, new SpotifyTokenInterceptor(appHeadersProvider)}), (102 & 16) == 0 ? "client_spotify" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null)));
            setApiFiles((RestAPIInterface.Files) restAPIBuilder.build(RestAPIInterface.Files.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : C12145m.listOf(interceptorBuildLoggingInterceptor), (102 & 16) == 0 ? "client_files" : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null));
        }

        public final void setApi(RestAPI restAPI) {
            C12238m.checkNotNullParameter(restAPI, "<set-?>");
            RestAPI.api = restAPI;
        }

        public final void setApiClientVersions(RestAPIInterface.Dynamic dynamic) {
            C12238m.checkNotNullParameter(dynamic, "<set-?>");
            RestAPI.apiClientVersions = dynamic;
        }

        public final void setApiFiles(RestAPIInterface.Files files) {
            C12238m.checkNotNullParameter(files, "<set-?>");
            RestAPI.apiFiles = files;
        }

        public final void setApiRtcLatency(RestAPIInterface.RtcLatency rtcLatency) {
            C12238m.checkNotNullParameter(rtcLatency, "<set-?>");
            RestAPI.apiRtcLatency = rtcLatency;
        }

        public final void setApiSerializeNulls(RestAPI restAPI) {
            C12238m.checkNotNullParameter(restAPI, "<set-?>");
            RestAPI.apiSerializeNulls = restAPI;
        }

        public final void setApiSpotify(RestAPI restAPI) {
            C12238m.checkNotNullParameter(restAPI, "<set-?>");
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
            private final Harvest data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LastRequested(Harvest harvest) {
                super(null);
                C12238m.checkNotNullParameter(harvest, "data");
                this.data = harvest;
            }

            public final Harvest getData() {
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
        C12238m.checkNotNullParameter(restAPIInterface, "_api");
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
            C12238m.throwUninitializedPropertyAccessException("api");
        }
        return restAPI;
    }

    public static final RestAPI getApiSerializeNulls() {
        RestAPI restAPI = apiSerializeNulls;
        if (restAPI == null) {
            C12238m.throwUninitializedPropertyAccessException("apiSerializeNulls");
        }
        return restAPI;
    }

    public static final RestAPI getApiSpotify() {
        RestAPI restAPI = apiSpotify;
        if (restAPI == null) {
            C12238m.throwUninitializedPropertyAccessException("apiSpotify");
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
        if (grant == null || (listEmptyList = C12145m.listOf(grant)) == null) {
            listEmptyList = C12147n.emptyList();
        }
        if (revoke == null || (listEmptyList2 = C12145m.listOf(revoke)) == null) {
            listEmptyList2 = C12147n.emptyList();
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
    @InterfaceC12542o("guilds/{guildId}/creator-monetization/{requestId}/accept-terms")
    public Observable<CreatorMonetizationEnableRequest> acceptCreatorMonetizationTerms(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("requestId") long requestId) {
        return this._api.acceptCreatorMonetizationTerms(guildId, requestId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("entitlements/gift-codes/{code}/redeem")
    public Observable<Void> acceptGift(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.acceptGift(code);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/ack")
    public Observable<Void> ackGuild(@InterfaceC12546s("guildId") long guildId) {
        return this._api.ackGuild(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/requests/@me/ack")
    public Observable<Void> ackGuildJoinRequest(@InterfaceC12546s("guildId") long guildId) {
        return this._api.ackGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("channels/{channelId}/pins/{messageId}")
    public Observable<Void> addChannelPin(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId) {
        return this._api.addChannelPin(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("channels/{channelId}/recipients/{recipientId}")
    public Observable<Void> addChannelRecipient(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("recipientId") long recipientId) {
        return this._api.addChannelRecipient(channelId, recipientId);
    }

    public final Observable<Channel> addGroupRecipients(final long channelId, final List<? extends User> recipients) {
        C12238m.checkNotNullParameter(recipients, "recipients");
        Observable<Channel> observableM11118y = StoreStream.INSTANCE.getChannels().observePrivateChannel(channelId).m11118y(new InterfaceC12589b<Channel, Boolean>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel != null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "StoreStream\n          .g…nnel -> channel != null }");
        Observable observableM11099Y = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, false, 3, null).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Channel> call(Channel channel) {
                return (channel == null || !ChannelUtils.m7702z(channel)) ? RestAPI.this._api.convertDMToGroup(channelId, ((User) C12163u.first(recipients)).getId()) : new C12721k(channel);
            }
        }).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Channel> call(final Channel channel) {
                List listSubList;
                if (channel.getId() == channelId) {
                    listSubList = recipients;
                } else {
                    List list = recipients;
                    listSubList = list.subList(1, list.size());
                }
                return Observable.m11058B(listSubList).m11083G(new InterfaceC12589b<User, Observable<Void>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<Void> call(User user) {
                        return RestAPI.this._api.addChannelRecipient(channel.getId(), user.getId());
                    }
                }).m11105f0().m11099Y(new InterfaceC12589b<List<Observable<Void>>, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends Channel> call(List<Observable<Void>> list2) {
                        return Observable.m11063H(Observable.m11074h0(new C12662q(list2))).m11105f0().m11083G(new InterfaceC12589b<List<Void>, Channel>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.3.2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Channel call(List<Void> list3) {
                                return channel;
                            }
                        });
                    }
                });
            }
        }).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.addGroupRecipients.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Channel> call(Channel channel) {
                Observable<R> observableM11083G = StoreStream.INSTANCE.getChannels().observeChannel(channel.getId()).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
                C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
                return observableM11083G;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g….filterNull()\n          }");
        return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11099Y, 0L, false, 3, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    public Observable<Void> addReaction(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction) {
        C12238m.checkNotNullParameter(reaction, "reaction");
        return this._api.addReaction(channelId, messageId, reaction);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("users/@me/relationships/{userId}")
    public Observable<Void> addRelationship(@InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.UserRelationship relationship, @InterfaceC12536i("X-Context-Properties") String context) {
        C12238m.checkNotNullParameter(relationship, "relationship");
        C12238m.checkNotNullParameter(context, "context");
        return this._api.addRelationship(userId, relationship, context);
    }

    public final Observable<Void> addRelationship(String location, long userId, Integer type, String friendToken, CaptchaHelper.CaptchaPayload captchaPayload) {
        C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.addRelationship(userId, new RestAPIParams.UserRelationship(type, friendToken, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), jsonObjectOf(C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/directory-entry/{guildId}")
    public Observable<retrofit2.Response<DirectoryEntryGuild>> addServerToHub(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.AddServerBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.addServerToHub(channelId, guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("connections/{connection}/authorize")
    public Observable<ModelUrl> authorizeConnection(@InterfaceC12546s("connection") String connection) {
        C12238m.checkNotNullParameter(connection, "connection");
        return this._api.authorizeConnection(connection);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/authorize-ip")
    public Observable<retrofit2.Response<Void>> authorizeIP(@InterfaceC12528a RestAPIParams.AuthorizeIP body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.authorizeIP(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("guilds/{guildId}/bans/{userId}")
    public Observable<Void> banGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.BanGuildMember body, @InterfaceC12536i("X-Audit-Log-Reason") String reason) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.banGuildMember(guildId, userId, body, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/roles")
    public Observable<Void> batchUpdateRole(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a List<RestAPIParams.Role> body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.batchUpdateRole(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/relationships/bulk")
    public Observable<retrofit2.Response<BulkAddFriendsResponse>> bulkAddRelationships(@InterfaceC12528a RestAPIParams.UserBulkRelationship body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.bulkAddRelationships(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/call")
    public Observable<ModelCall.Ringable> call(@InterfaceC12546s("channelId") long channelId) {
        return this._api.call(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/cancel")
    public Observable<ModelGuildBoostSlot> cancelSubscriptionSlot(@InterfaceC12546s("subscriptionSlotId") long slotId) {
        return this._api.cancelSubscriptionSlot(slotId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/members/{userId}")
    public Observable<Void> changeGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.GuildMember body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.changeGuildMember(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/members/@me/nick")
    public Observable<Void> changeGuildNickname(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.Nick body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.changeGuildNickname(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("outbound-promotions/{promotionId}/claim")
    public Observable<ClaimedOutboundPromotion> claimOutboundPromotion(@InterfaceC12546s("promotionId") long promotionId) {
        return this._api.claimOutboundPromotion(promotionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("store/skus/{skuId}/purchase")
    public Observable<Unit> claimSku(@InterfaceC12546s("skuId") long skuId, @InterfaceC12528a RestAPIParams.EmptyBody emptyBody) {
        C12238m.checkNotNullParameter(emptyBody, "emptyBody");
        return this._api.claimSku(skuId, emptyBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("channels/{channelId}/recipients/{recipientId}")
    public Observable<Channel> convertDMToGroup(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("recipientId") long recipientId) {
        return this._api.convertDMToGroup(channelId, recipientId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/followers")
    public Observable<Void> createChannelFollower(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.ChannelFollowerPost body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createChannelFollower(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("users/@me/connections/contacts/@me")
    public Observable<ConnectedAccount> createConnectionContacts(@InterfaceC12528a RestAPIParams.ConnectedAccountContacts connectedAccountContacts) {
        C12238m.checkNotNullParameter(connectedAccountContacts, "connectedAccountContacts");
        return this._api.createConnectionContacts(connectedAccountContacts);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/creator-monetization/enable-requests")
    public Observable<CreatorMonetizationEnableRequest> createCreatorMonetizationEnableRequest(@InterfaceC12546s("guildId") long guildId) {
        return this._api.createCreatorMonetizationEnableRequest(guildId);
    }

    public final Observable<Channel> createGroupDM(List<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Observable<Channel> observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(this._api.userCreateChannel(new RestAPIParams.CreateChannel(userIds)), false, 1, null).m11115u(new Action1<Channel>() { // from class: com.discord.utilities.rest.RestAPI.createGroupDM.1
            @Override // p658rx.functions.Action1
            public final void call(Channel channel) {
                StoreChannels channels = StoreStream.INSTANCE.getChannels();
                C12238m.checkNotNullExpressionValue(channel, "channel");
                channels.onGroupCreated(channel);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "_api\n      .userCreateCh…pCreated(channel)\n      }");
        return observableM11115u;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds")
    public Observable<retrofit2.Response<Guild>> createGuild(@InterfaceC12528a RestAPIParams.CreateGuild body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createGuild(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/channels")
    public Observable<retrofit2.Response<Channel>> createGuildChannel(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.CreateGuildChannel body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createGuildChannel(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/templates/{guildTemplateCode}")
    public Observable<Guild> createGuildFromTemplate(@InterfaceC12546s("guildTemplateCode") String guildTemplateCode, @InterfaceC12528a RestAPIParams.CreateGuildFromTemplate body) {
        C12238m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createGuildFromTemplate(guildTemplateCode, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> createGuildJoinRequest(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.MemberVerificationForm body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createGuildJoinRequest(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/role-subscriptions/group-listings")
    public Observable<GuildRoleSubscriptionGroupListing> createGuildRoleSubscriptionGroupListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.CreateGuildRoleSubscriptionGroupListing body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createGuildRoleSubscriptionGroupListing(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings")
    public Observable<GuildRoleSubscriptionTierListing> createGuildRoleSubscriptionTier(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12528a RestAPIParams.CreateGuildRoleSubscriptionTierListing body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createGuildRoleSubscriptionTier(guildId, groupListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/scheduled-events")
    public Observable<GuildScheduledEvent> createGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.CreateGuildScheduledEventBody event) {
        C12238m.checkNotNullParameter(event, "event");
        return this._api.createGuildScheduledEvent(guildId, event);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    public Observable<Unit> createGuildScheduledEventRsvp(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId) {
        return this._api.createGuildScheduledEventRsvp(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/handoff")
    public Observable<HandoffToken> createHandoffToken(@InterfaceC12528a CreateHandoffTokenRequest body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createHandoffToken(body);
    }

    public final Observable<HandoffToken> createHandoffTokenWithNonce(String nonce) {
        C12238m.checkNotNullParameter(nonce, "nonce");
        return this._api.createHandoffToken(new CreateHandoffTokenRequest(nonce));
    }

    public final Observable<Channel> createOrFetchDM(final long userId) {
        Observable<Channel> observableM11099Y = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observePrivateChannels(), 0L, false, 3, null).m11099Y(new InterfaceC12589b<Map<Long, ? extends Channel>, Observable<? extends Channel>>() { // from class: com.discord.utilities.rest.RestAPI.createOrFetchDM.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Channel> call2(Map<Long, Channel> map) {
                T next;
                User userM7677a;
                Iterator<T> it = map.values().iterator();
                do {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                    userM7677a = ChannelUtils.m7677a((Channel) next);
                } while (!(userM7677a != null && userM7677a.getId() == userId));
                Channel channel = next;
                return channel != null ? new C12721k(channel) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.this._api.userCreateChannel(new RestAPIParams.CreateChannel(userId)), false, 1, null).m11115u(new Action1<Channel>() { // from class: com.discord.utilities.rest.RestAPI.createOrFetchDM.1.1
                    @Override // p658rx.functions.Action1
                    public final void call(Channel channel2) {
                        StoreStream.INSTANCE.getGatewaySocket().getChannelCreateOrUpdate().f27653k.onNext(channel2);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n          .g…            }\n          }");
        return observableM11099Y;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("google-play/purchase-metadata")
    public Observable<Unit> createPurchaseMetadata(@InterfaceC12528a RestAPIParams.PurchaseMetadataBody purchaseMetadataBody) {
        C12238m.checkNotNullParameter(purchaseMetadataBody, "purchaseMetadataBody");
        return this._api.createPurchaseMetadata(purchaseMetadataBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/roles")
    public Observable<GuildRole> createRole(@InterfaceC12546s("guildId") long guildId) {
        return this._api.createRole(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/threads")
    public Observable<Channel> createThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @InterfaceC12528a RestAPIParams.ThreadCreationSettings body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createThread(channelId, location, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/messages/{messageId}/threads")
    public Observable<Channel> createThreadFromMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @InterfaceC12528a RestAPIParams.ThreadCreationSettings body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.createThreadFromMessage(channelId, messageId, location, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/threads?has_message=true")
    @InterfaceC12539l
    public Observable<Channel> createThreadWithMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @InterfaceC12544q("content") String content, @InterfaceC12544q("applied_tags") List<Long> appliedTags, @InterfaceC12544q("sticker_ids") List<Long> stickerIds, @InterfaceC12544q("type") int type, @InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_AUTO_ARCHIVE_DURATION) Integer autoArchiveDuration, @InterfaceC12544q MultipartBody.Part[] files) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(content, "content");
        C12238m.checkNotNullParameter(appliedTags, "appliedTags");
        C12238m.checkNotNullParameter(stickerIds, "stickerIds");
        C12238m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.createThreadWithMessage(channelId, name, content, appliedTags, stickerIds, type, autoArchiveDuration, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/messages/{messageId}/crosspost")
    public Observable<Void> crosspostMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") Long messageId) {
        return this._api.crosspostMessage(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/delete")
    public Observable<Void> deleteAccount(@InterfaceC12528a RestAPIParams.DisableAccount body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.deleteAccount(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}")
    public Observable<Channel> deleteChannel(@InterfaceC12546s("channelId") long channelId) {
        return this._api.deleteChannel(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/pins/{messageId}")
    public Observable<Void> deleteChannelPin(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId) {
        return this._api.deleteChannelPin(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("users/@me/connections/{connection}/{connectionId}")
    public Observable<retrofit2.Response<Void>> deleteConnection(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("connectionId") String connectionId) {
        C12238m.checkNotNullParameter(connection, "connection");
        C12238m.checkNotNullParameter(connectionId, "connectionId");
        return this._api.deleteConnection(connection, connectionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/delete")
    public Observable<Void> deleteGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.DeleteGuild body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.deleteGuild(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/emojis/{emojiId}")
    public Observable<Void> deleteGuildEmoji(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("emojiId") long emojiId) {
        return this._api.deleteGuildEmoji(guildId, emojiId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/integrations/{integrationId}")
    public Observable<Void> deleteGuildIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("integrationId") long integrationId) {
        return this._api.deleteGuildIntegration(guildId, integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> deleteGuildJoinRequest(@InterfaceC12546s("guildId") long guildId) {
        return this._api.deleteGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    public Observable<Void> deleteGuildRoleSubscriptionTierListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12546s("listingId") long tierListingId) {
        return this._api.deleteGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<Void> deleteGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId) {
        return this._api.deleteGuildScheduledEvent(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/scheduled-events/{eventId}/users/@me")
    public Observable<Void> deleteGuildScheduledEventRsvp(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId) {
        return this._api.deleteGuildScheduledEventRsvp(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channel_id}/messages/{message_id}")
    public Observable<Void> deleteMessage(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @InterfaceC12546s("message_id") long messageId) {
        return this._api.deleteMessage(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("oauth2/tokens/{oauthId}")
    public Observable<Void> deleteOAuthToken(@InterfaceC12546s("oauthId") long oauthId) {
        return this._api.deleteOAuthToken(oauthId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("users/@me/billing/payment-sources/{paymentSourceId}")
    public Observable<Void> deletePaymentSource(@InterfaceC12546s("paymentSourceId") String paymentSourceId) {
        C12238m.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        return this._api.deletePaymentSource(paymentSourceId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/permissions/{targetId}")
    public Observable<Void> deletePermissionOverwrites(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("targetId") long targetId) {
        return this._api.deletePermissionOverwrites(channelId, targetId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/roles/{roleId}")
    public Observable<Void> deleteRole(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("roleId") long roleId) {
        return this._api.deleteRole(guildId, roleId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("users/@me/billing/subscriptions/{subscriptionId}")
    public Observable<Void> deleteSubscription(@InterfaceC12546s("subscriptionId") String subscriptionId) {
        C12238m.checkNotNullParameter(subscriptionId, "subscriptionId");
        return this._api.deleteSubscription(subscriptionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/disable")
    public Observable<Void> disableAccount(@InterfaceC12528a RestAPIParams.DisableAccount body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.disableAccount(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/members/{userId}")
    public Observable<retrofit2.Response<Void>> disableGuildCommunication(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.DisableGuildCommunication body, @InterfaceC12536i("X-Audit-Log-Reason") String reason) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.disableGuildCommunication(guildId, userId, body, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/mfa/totp/disable")
    public Observable<DisableMfaResponse> disableMFA(@InterfaceC12528a DisableMfaRequestBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.disableMFA(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/mfa/sms/disable")
    public Observable<Void> disableMfaSMS(@InterfaceC12528a RestAPIParams.ActivateMfaSMS body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.disableMfaSMS(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/members/{userId}")
    public Observable<Void> disconnectGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.GuildMemberDisconnect body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.disconnectGuildMember(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("google-play/downgrade-subscription")
    public Observable<Object> downgradeSubscription(@InterfaceC12528a RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody) {
        C12238m.checkNotNullParameter(downgradeSubscriptionBody, "downgradeSubscriptionBody");
        return this._api.downgradeSubscription(downgradeSubscriptionBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}")
    public Observable<Channel> editGroupDM(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.GroupDM body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.editGroupDM(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channel_id}/messages/{message_id}")
    public Observable<Message> editMessage(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) long channelId, @InterfaceC12546s("message_id") long messageId, @InterfaceC12528a RestAPIParams.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        return this._api.editMessage(channelId, messageId, message);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}")
    public Observable<Channel> editTextChannel(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.TextChannel body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.editTextChannel(channelId, body);
    }

    public final Observable<Channel> editTextChannel(long channelId, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.editTextChannel(channelId, new RestAPIParams.TextChannel(name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}")
    public Observable<Channel> editThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.ThreadSettings body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.editThread(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}")
    public Observable<Channel> editTopicalChannel(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.TopicalChannel body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.editTopicalChannel(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}")
    public Observable<Channel> editVoiceChannel(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.VoiceChannel body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.editVoiceChannel(channelId, body);
    }

    public final Observable<Channel> editVoiceChannel(long channelId, String name, String topic, Boolean nsfw, Integer type, Integer bitrate, Integer userLimit, String rtcRegion) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.editVoiceChannel(channelId, new RestAPIParams.VoiceChannel(name, topic, type, nsfw, userLimit, bitrate, rtcRegion)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/integrations")
    public Observable<Void> enableIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.EnableIntegration body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.enableIntegration(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/mfa/totp/enable")
    public Observable<EnableMfaResponse> enableMFA(@InterfaceC12528a RestAPIParams.EnableMFA body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.enableMFA(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/mfa/sms/enable")
    public Observable<Void> enableMfaSMS(@InterfaceC12528a RestAPIParams.ActivateMfaSMS body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.enableMfaSMS(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("stage-instances/{channelId}")
    public Observable<Unit> endStageInstance(@InterfaceC12546s("channelId") long channelId) {
        return this._api.endStageInstance(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/forgot")
    public Observable<retrofit2.Response<Void>> forgotPassword(@InterfaceC12528a RestAPIParams.ForgotPassword body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.forgotPassword(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/entitlements/gift-codes")
    public Observable<ModelGift> generateGiftCode(@InterfaceC12528a RestAPIParams.GenerateGiftCode body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.generateGiftCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/metadata")
    public Observable<ActivityMetadata> getActivityMetadata(@InterfaceC12546s("userId") long userId, @InterfaceC12546s("sessionId") String sessionId, @InterfaceC12546s("applicationId") long applicationId) {
        C12238m.checkNotNullParameter(sessionId, "sessionId");
        return this._api.getActivityMetadata(userId, sessionId, applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("outbound-promotions")
    public Observable<List<OutboundPromotion>> getAllActiveOutboundPromotions() {
        return this._api.getAllActiveOutboundPromotions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("outbound-promotions/preview")
    public Observable<List<OutboundPromotion>> getAllPreviewPromotions() {
        return this._api.getAllPreviewPromotions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/threads/archived/private")
    public Observable<ThreadListing> getAllPrivateArchivedThreads(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") String before) {
        return this._api.getAllPrivateArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/threads/archived/public")
    public Observable<ThreadListing> getAllPublicArchivedThreads(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") String before) {
        return this._api.getAllPublicArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("oauth2/applications/{applicationId}/assets")
    public Observable<List<ApplicationAsset>> getApplicationAssets(@InterfaceC12546s("applicationId") long applicationId) {
        return this._api.getApplicationAssets(applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("applications/{botId}/commands")
    public Observable<List<ApplicationCommand>> getApplicationCommands(@InterfaceC12546s("botId") long botId) {
        return this._api.getApplicationCommands(botId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("applications/public")
    public Observable<List<Application>> getApplications(@InterfaceC12547t("application_ids") long appIds) {
        return this._api.getApplications(appIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/audit-logs")
    public Observable<ModelAuditLog> getAuditLogs(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("limit") int limit, @InterfaceC12547t("before") Long before, @InterfaceC12547t("user_id") Long userId, @InterfaceC12547t("action_type") Integer actionType) {
        return this._api.getAuditLogs(guildId, limit, before, userId, actionType);
    }

    public final Observable<ModelAuditLog> getAuditLogs(long guildId, Long before, Long userId, Integer actionType) {
        return this._api.getAuditLogs(guildId, 50, before, (userId != null && userId.longValue() == 0) ? null : userId, (actionType != null && actionType.intValue() == 0) ? null : actionType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/mfa/codes")
    public Observable<GetBackupCodesResponse> getBackupCodes(@InterfaceC12528a GetBackupCodesRequestBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.getBackupCodes(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/verify/view-backup-codes-challenge")
    public Observable<GetBackupCodesSendVerificationKeyResponse> getBackupCodesSendVerificationKey(@InterfaceC12528a GetBackupCodesSendVerificationKeyRequestBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.getBackupCodesSendVerificationKey(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/mfa/codes-verification")
    public Observable<GetBackupCodesResponse> getBackupCodesVerification(@InterfaceC12528a GetBackupCodesVerificationRequestBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.getBackupCodesVerification(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/bans")
    public Observable<List<ModelBan>> getBans(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getBans(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("private/bug-reports")
    public Observable<BugReportConfig> getBugReportConfig() {
        return this._api.getBugReportConfig();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}")
    public Observable<Channel> getChannel(@InterfaceC12546s("channelId") long channelId) {
        return this._api.getChannel(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/follower-stats")
    public Observable<ModelChannelFollowerStatsDto> getChannelFollowerStats(@InterfaceC12546s("channelId") long channelId) {
        return this._api.getChannelFollowerStats(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/messages")
    public Observable<List<Message>> getChannelMessages(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") Long before, @InterfaceC12547t("after") Long after, @InterfaceC12547t("limit") Integer limit) {
        return this._api.getChannelMessages(channelId, before, after, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/messages")
    public Observable<List<Message>> getChannelMessagesAround(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("limit") int limit, @InterfaceC12547t("around") long around) {
        return this._api.getChannelMessagesAround(channelId, limit, around);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/pins")
    public Observable<List<Message>> getChannelPins(@InterfaceC12546s("channelId") long channelId) {
        return this._api.getChannelPins(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/outbound-promotions/codes")
    public Observable<List<ClaimedOutboundPromotion>> getClaimedOutboundPromotions() {
        return this._api.getClaimedOutboundPromotions();
    }

    public final Observable<Integer> getClientVersion() {
        RestAPIInterface.Dynamic dynamic = apiClientVersions;
        if (dynamic == null) {
            C12238m.throwUninitializedPropertyAccessException("apiClientVersions");
        }
        Observable<R> observableM11083G = dynamic.get("https://dl.discordapp.net/apps/android/versions.json").m11083G(new InterfaceC12589b<JsonObject, Integer>() { // from class: com.discord.utilities.rest.RestAPI.getClientVersion.1
            /* JADX WARN: Code duplicated, block: B:10:0x0019  */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Integer call(JsonObject jsonObject) {
                int iMo6854c;
                if (jsonObject == null) {
                    iMo6854c = 0;
                } else {
                    LinkedTreeMap.C11105e<String, JsonElement> c11105eM9225c = jsonObject.f21481a.m9225c("discord_android_min_version");
                    JsonElement jsonElement = c11105eM9225c != null ? c11105eM9225c.f21508p : null;
                    if (jsonElement != null) {
                        iMo6854c = jsonElement.mo6854c();
                    } else {
                        iMo6854c = 0;
                    }
                }
                return Integer.valueOf(iMo6854c);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "apiClientVersions\n      …n_version\")?.asInt ?: 0 }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM11083G, false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/connections/{platformType}/{accountId}/access-token")
    public Observable<ModelConnectionAccessToken> getConnectionAccessToken(@InterfaceC12546s("platformType") String platformType, @InterfaceC12546s("accountId") String accountId) {
        C12238m.checkNotNullParameter(platformType, "platformType");
        C12238m.checkNotNullParameter(accountId, "accountId");
        return this._api.getConnectionAccessToken(platformType, accountId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("connections/{connection}/callback-continuation/{pinNumber}")
    public Observable<ModelConnectionState> getConnectionState(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("pinNumber") String pinNumber) {
        C12238m.checkNotNullParameter(connection, "connection");
        C12238m.checkNotNullParameter(pinNumber, "pinNumber");
        return this._api.getConnectionState(connection, pinNumber);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/connections")
    public Observable<List<ConnectedAccount>> getConnections() {
        return this._api.getConnections();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/consent")
    public Observable<Consents> getConsents() {
        return this._api.getConsents();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/creator-monetization/requirements")
    public Observable<CreatorMonetizationEligibilityRequirements> getCreatorMonetizationEligibilityRequirements(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getCreatorMonetizationEligibilityRequirements(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/directory-entries")
    public Observable<List<DirectoryEntryGuild>> getDirectoryEntries(@InterfaceC12546s("channelId") long channelId) {
        return this._api.getDirectoryEntries(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/directory-entries/broadcast")
    public Observable<GuildScheduledEventBroadcast> getDirectoryEntryBroadcastInfo(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("entity_id") Long entityId, @InterfaceC12547t("type") int type) {
        return this._api.getDirectoryEntryBroadcastInfo(guildId, entityId, type);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/directory-entries")
    public Observable<List<DirectoryEntryEvent>> getDirectoryGuildScheduledEvents(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("type") int type) {
        return this._api.getDirectoryGuildScheduledEvents(channelId, type);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("emojis/{emojiId}/guild")
    public Observable<Guild> getEmojiGuild(@InterfaceC12546s("emojiId") long emojiId) {
        return this._api.getEmojiGuild(emojiId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/directory-entries/counts")
    public Observable<Map<Integer, Integer>> getEntryCounts(@InterfaceC12546s("channelId") long channelId) {
        return this._api.getEntryCounts(channelId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("experiments")
    public Observable<UnauthenticatedUserExperimentsDto> getExperiments() {
        return this._api.getExperiments();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/post-data")
    public Observable<ForumPostFirstMessages> getForumPostData(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.GetForumPostData body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.getForumPostData(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("friend-suggestions")
    public Observable<List<FriendSuggestion>> getFriendSuggestions() {
        return this._api.getFriendSuggestions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("gifs/search")
    public Observable<List<GifDto>> getGifSearchResults(@InterfaceC12547t("q") String query, @InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("media_format") String mediaFormat, @InterfaceC12547t("limit") int limit) {
        C12238m.checkNotNullParameter(query, "query");
        C12238m.checkNotNullParameter(provider, "provider");
        C12238m.checkNotNullParameter(locale, "locale");
        C12238m.checkNotNullParameter(mediaFormat, "mediaFormat");
        return this._api.getGifSearchResults(query, provider, locale, mediaFormat, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("gifs/suggest")
    public Observable<List<String>> getGifSuggestedSearchTerms(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("q") String query, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("limit") int limit) {
        C1643a.m872q0(provider, "provider", query, "query", locale, "locale");
        return this._api.getGifSuggestedSearchTerms(provider, query, locale, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("gifs/trending-search")
    public Observable<List<String>> getGifTrendingSearchTerms(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("limit") int limit) {
        C12238m.checkNotNullParameter(provider, "provider");
        C12238m.checkNotNullParameter(locale, "locale");
        return this._api.getGifTrendingSearchTerms(provider, locale, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/entitlements/gifts")
    public Observable<List<ModelEntitlement>> getGifts() {
        return this._api.getGifts();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/applications")
    public Observable<List<Application>> getGuildApplications(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("include_team") boolean includeTeam) {
        return this._api.getGuildApplications(guildId, includeTeam);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/emojis")
    public Observable<List<ModelEmojiGuild>> getGuildEmojis(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildEmojis(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/integrations")
    public Observable<List<ModelGuildIntegration>> getGuildIntegrations(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildIntegrations(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/invites")
    public Observable<List<ModelInvite>> getGuildInvites(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildInvites(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/member-verification")
    public Observable<ModelMemberVerificationForm> getGuildMemberVerificationForm(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildMemberVerificationForm(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/preview")
    public Observable<GuildPreview> getGuildPreview(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildPreview(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/roles/member-counts")
    public Observable<Map<Long, Integer>> getGuildRoleMemberCounts(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildRoleMemberCounts(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/roles/{roleId}/member-ids")
    public Observable<List<Long>> getGuildRoleMemberIds(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("roleId") long roleId) {
        return this._api.getGuildRoleMemberIds(guildId, roleId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/role-subscriptions/trials")
    public Observable<List<GuildRoleSubscriptionTierFreeTrial>> getGuildRoleSubscriptionFreeTrials(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildRoleSubscriptionFreeTrials(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    public Observable<GuildRoleSubscriptionGroupListing> getGuildRoleSubscriptionGroupListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId) {
        return this._api.getGuildRoleSubscriptionGroupListing(guildId, groupListingId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/role-subscriptions/group-listings")
    public Observable<List<GuildRoleSubscriptionGroupListing>> getGuildRoleSubscriptionGroupListings(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildRoleSubscriptionGroupListings(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<GuildScheduledEvent> getGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId) {
        return this._api.getGuildScheduledEvent(guildId, eventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/scheduled-events/{eventId}/users")
    public Observable<List<ApiGuildScheduledEventUser>> getGuildScheduledEventUsers(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId, @InterfaceC12547t("limit") int limit, @InterfaceC12547t("with_member") boolean withMember, @InterfaceC12547t("upgrade_response_type") boolean upgradeResponseType) {
        return this._api.getGuildScheduledEventUsers(guildId, eventId, limit, withMember, upgradeResponseType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/scheduled-events")
    public Observable<List<GuildScheduledEvent>> getGuildScheduledEvents(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("with_user_count") boolean withUserCount) {
        return this._api.getGuildScheduledEvents(guildId, withUserCount);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/templates/{guildTemplateCode}")
    public Observable<ModelGuildTemplate> getGuildTemplateCode(@InterfaceC12546s("guildTemplateCode") String guildTemplateCode) {
        C12238m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this._api.getGuildTemplateCode(guildTemplateCode);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/regions")
    public Observable<List<ModelVoiceRegion>> getGuildVoiceRegions(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildVoiceRegions(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/welcome-screen")
    public Observable<GuildWelcomeScreen> getGuildWelcomeScreen(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getGuildWelcomeScreen(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/harvest")
    public Observable<Harvest> getHarvestStatus() {
        return this._api.getHarvestStatus();
    }

    public final Observable<HarvestState> getHarvestStatusGuarded() {
        Observable<R> observableM11083G = this._api.getHarvestStatus().m11083G(new InterfaceC12589b<Harvest, HarvestState>() { // from class: com.discord.utilities.rest.RestAPI.getHarvestStatusGuarded.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final HarvestState call(Harvest harvest) {
                return harvest != null ? new HarvestState.LastRequested(harvest) : new HarvestState.NeverRequested();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "_api.getHarvestStatus()\n…erRequested()\n          }");
        return ObservableExtensionsKt.restSubscribeOn(observableM11083G, false);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/messages/{messageId}/interaction-data")
    public Observable<ApplicationCommandData> getInteractionData(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId) {
        return this._api.getInteractionData(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("invites/{code}")
    public Observable<retrofit2.Response<ModelInvite>> getInviteCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @InterfaceC12547t("with_counts") boolean withCounts, @InterfaceC12547t("guild_scheduled_event_id") Long guildScheduledEventId) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.getInviteCode(code, withCounts, guildScheduledEventId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/billing/invoices/preview")
    public Observable<ModelInvoicePreview> getInvoicePreview(@InterfaceC12528a RestAPIParams.InvoicePreviewBody invoicePreviewBody) {
        C12238m.checkNotNullParameter(invoicePreviewBody, "invoicePreviewBody");
        return this._api.getInvoicePreview(invoicePreviewBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/library")
    public Observable<List<ModelLibraryApplication>> getLibrary() {
        return this._api.getLibrary();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("auth/location-metadata")
    public Observable<ModelLocationMetadata> getLocationMetadata() {
        return this._api.getLocationMetadata();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/scheduled-events")
    public Observable<List<GuildScheduledEventMeUser>> getMeGuildScheduledEvents(@InterfaceC12547t("guild_ids") long guildIds) {
        return this._api.getMeGuildScheduledEvents(guildIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/mentions")
    public Observable<List<Message>> getMentions(@InterfaceC12547t("limit") int limit, @InterfaceC12547t("roles") boolean roles, @InterfaceC12547t(ModelGuildMemberListUpdate.EVERYONE_ID) boolean everyone, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @InterfaceC12547t("before") Long before) {
        return this._api.getMentions(limit, roles, everyone, guildId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/applications/{applicationId}/entitlements")
    public Observable<List<ModelEntitlement>> getMyEntitlements(@InterfaceC12546s("applicationId") long applicationId, @InterfaceC12547t("exclude_consumed") boolean excludeConsumed) {
        return this._api.getMyEntitlements(applicationId, excludeConsumed);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/users/@me/threads/archived/private")
    public Observable<ThreadListing> getMyPrivateArchivedThreads(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("before") Long before) {
        return this._api.getMyPrivateArchivedThreads(channelId, before);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("oauth2/tokens")
    public Observable<List<ModelOAuth2Token>> getOAuthTokens() {
        return this._api.getOAuthTokens();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("oauth2/authorize")
    public Observable<RestAPIParams.OAuth2Authorize.ResponseGet> getOauth2Authorize(@InterfaceC12547t("client_id") String clientId, @InterfaceC12547t("state") String state, @InterfaceC12547t("response_type") String responseType, @InterfaceC12547t("redirect_uri") String redirectUrl, @InterfaceC12547t("prompt") String prompt, @InterfaceC12547t("scope") String scope, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions) {
        C1643a.m872q0(clientId, "clientId", prompt, "prompt", scope, "scope");
        return this._api.getOauth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("oauth2/samsung/authorize")
    public Observable<Void> getOauth2SamsungAuthorize(@InterfaceC12547t("client_id") String clientId, @InterfaceC12547t("state") String state, @InterfaceC12547t("response_type") String responseType, @InterfaceC12547t("redirect_uri") String redirectUrl, @InterfaceC12547t("prompt") String prompt, @InterfaceC12547t("scope") String scope) {
        C1643a.m872q0(clientId, "clientId", prompt, "prompt", scope, "scope");
        return this._api.getOauth2SamsungAuthorize(clientId, state, responseType, redirectUrl, prompt, scope);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("applications/{applicationId}/payment-payout-groups")
    public Observable<List<PayoutGroup>> getPaymentPayoutGroups(@InterfaceC12546s("applicationId") long applicationId) {
        return this._api.getPaymentPayoutGroups(applicationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/billing/payment-sources")
    public Observable<List<PaymentSourceRaw>> getPaymentSources() {
        return this._api.getPaymentSources();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("store/price-tiers")
    public Observable<List<Integer>> getPriceTiers(@InterfaceC12547t("price_tier_type") int priceTierType) {
        return this._api.getPriceTiers(priceTierType);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/prune")
    public Observable<PruneCountResponse> getPruneCount(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("days") int days) {
        return this._api.getPruneCount(guildId, days);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/messages/{messageId}/reactions/{emoji}")
    public Observable<List<com.discord.api.user.User>> getReactionUsers(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "emoji") String emoji, @InterfaceC12547t("limit") Integer limit) {
        C12238m.checkNotNullParameter(emoji, "emoji");
        return this._api.getReactionUsers(channelId, messageId, emoji, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("stage-instances")
    public Observable<retrofit2.Response<List<RecommendedStageInstance>>> getRecommendedStageInstances() {
        return this._api.getRecommendedStageInstances();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/{userId}/relationships")
    public Observable<List<ModelUserRelationship>> getRelationships(@InterfaceC12546s("userId") long userId) {
        return this._api.getRelationships(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("reporting/menu/{reportType}")
    public Observable<MenuAPIResponse> getReportMenu(@InterfaceC12546s("reportType") String reportType) {
        C12238m.checkNotNullParameter(reportType, "reportType");
        return this._api.getReportMenu(reportType);
    }

    public final Observable<List<ModelRtcLatencyRegion>> getRtcLatencyTestRegionsIps() {
        RestAPIInterface.RtcLatency rtcLatency = apiRtcLatency;
        if (rtcLatency == null) {
            C12238m.throwUninitializedPropertyAccessException("apiRtcLatency");
        }
        return ObservableExtensionsKt.restSubscribeOn$default(rtcLatency.get("https://latency.discord.media/rtc"), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("tracks/{id}")
    public Observable<ModelSpotifyTrack> getSpotifyTrack(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_ID) String id2) {
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return this._api.getSpotifyTrack(id2);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("stage-instances/extra")
    public Observable<List<RecommendedStageInstance>> getStageInstancesForChannels(@InterfaceC12547t("channel_ids") Set<Long> channelIds) {
        C12238m.checkNotNullParameter(channelIds, "channelIds");
        return this._api.getStageInstancesForChannels(channelIds);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("stickers/{stickerId}")
    public Observable<Sticker> getSticker(@InterfaceC12546s("stickerId") long stickerId) {
        return this._api.getSticker(stickerId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("stickers/{stickerId}/guild")
    public Observable<Guild> getStickerGuild(@InterfaceC12546s("stickerId") long stickerId) {
        return this._api.getStickerGuild(stickerId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("sticker-packs/{packId}")
    public Observable<ModelStickerPack> getStickerPack(@InterfaceC12546s("packId") long packId) {
        return this._api.getStickerPack(packId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("sticker-packs")
    public Observable<ModelStickerStoreDirectory> getStickerPacks() {
        return this._api.getStickerPacks();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("streams/{streamKey}/preview")
    public Observable<ModelApplicationStreamPreview> getStreamPreview(@InterfaceC12546s("streamKey") String streamKey, @InterfaceC12547t("version") long version) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        return this._api.getStreamPreview(streamKey, version);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/guilds/premium/subscription-slots")
    public Observable<List<ModelGuildBoostSlot>> getSubscriptionSlots() {
        return this._api.getSubscriptionSlots();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/billing/subscriptions")
    public Observable<List<ModelSubscription>> getSubscriptions() {
        return this._api.getSubscriptions();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("gifs/trending")
    public Observable<TrendingGifCategoriesResponseDto> getTrendingGifCategories(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("media_format") String mediaFormat) {
        C1643a.m872q0(provider, "provider", locale, "locale", mediaFormat, "mediaFormat");
        return this._api.getTrendingGifCategories(provider, locale, mediaFormat);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("gifs/trending-gifs")
    public Observable<List<GifDto>> getTrendingGifCategory(@InterfaceC12547t("provider") String provider, @InterfaceC12547t("locale") String locale, @InterfaceC12547t("media_format") String mediaFormat, @InterfaceC12547t("limit") int limit) {
        C1643a.m872q0(provider, "provider", locale, "locale", mediaFormat, "mediaFormat");
        return this._api.getTrendingGifCategory(provider, locale, mediaFormat, limit);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/affinities/users")
    public Observable<ModelUserAffinities> getUserAffinities() {
        return this._api.getUserAffinities();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/join-request-guilds")
    public Observable<List<Guild>> getUserJoinRequestGuilds() {
        return this._api.getUserJoinRequestGuilds();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/notes/{userId}")
    public Observable<ModelUserNote> getUserNote(@InterfaceC12546s("userId") long userId) {
        return this._api.getUserNote(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/survey")
    public Observable<retrofit2.Response<UserSurveyFetchResponse>> getUserSurvey() {
        return this._api.getUserSurvey();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/vanity-url")
    public Observable<VanityUrlResponse> getVanityUrl(@InterfaceC12546s("guildId") long guildId) {
        return this._api.getVanityUrl(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("friend-suggestions/{userId}")
    public Observable<Void> ignoreFriendSuggestion(@InterfaceC12546s("userId") long userId) {
        return this._api.ignoreFriendSuggestion(userId);
    }

    public final Observable<Void> inviteUserToSpeak(Channel channel, long userId, Clock clock) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(clock, "clock");
        return this._api.updateUserVoiceStates(channel.getGuildId(), userId, new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), Boolean.FALSE, new UtcDateTime(clock.currentTimeMillis())));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("guilds/{guildId}/members/@me")
    public Observable<Guild> joinGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("lurker") boolean isLurker, @InterfaceC12547t("session_id") String sessionId, @InterfaceC12547t("directory_channel_id") Long directoryChannelId, @InterfaceC12528a RestAPIParams.InviteCode body, @InterfaceC12536i("X-Context-Properties") String context) {
        return this._api.joinGuild(guildId, isLurker, sessionId, directoryChannelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("integrations/{integrationId}/join")
    public Observable<Void> joinGuildFromIntegration(@InterfaceC12546s("integrationId") String integrationId) {
        C12238m.checkNotNullParameter(integrationId, "integrationId");
        return this._api.joinGuildFromIntegration(integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("hub-waitlist/signup")
    public Observable<WaitlistSignup> joinHubWaitlist(@InterfaceC12528a RestAPIParams.HubWaitlist body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.joinHubWaitlist(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/thread-members/@me")
    public Observable<Void> joinThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location, @InterfaceC12528a RestAPIParams.EmptyBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.joinThread(channelId, location, body);
    }

    public final String jsonObjectOf(Pair<String, ? extends Object>... map) {
        C12238m.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, ? extends Object> pair : map) {
            try {
                jSONObject.put(pair.component1(), pair.component2());
            } catch (JSONException e) {
                Logger.e$default(AppLog.f14950g, "RestAPI", "Unable to serialize context property.", e, null, 8, null);
            }
        }
        String string = jSONObject.toString();
        C12238m.checkNotNullExpressionValue(string, "it.toString()");
        Charset charset = C12086c.f25136a;
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = string.getBytes(charset);
        C12238m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        C12238m.checkNotNullExpressionValue(strEncodeToString, "JSONObject().apply {\n   …toByteArray(), NO_WRAP) }");
        return strEncodeToString;
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/members/{userId}")
    public Observable<Void> kickGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12536i("X-Audit-Log-Reason") String reason) {
        return this._api.kickGuildMember(guildId, userId, reason);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("users/@me/guilds/{guildId}")
    public Observable<Void> leaveGuild(@InterfaceC12546s("guildId") long guildId) {
        return this._api.leaveGuild(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12535h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/guilds/{guildId}")
    public Observable<Void> leaveGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.LeaveGuildBody leaveGuildBody) {
        C12238m.checkNotNullParameter(leaveGuildBody, "leaveGuildBody");
        return this._api.leaveGuild(guildId, leaveGuildBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/thread-members/@me")
    public Observable<Void> leaveThread(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_LOCATION) String location) {
        return this._api.leaveThread(channelId, location);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/logout")
    public Observable<retrofit2.Response<Void>> logout(@InterfaceC12528a RestAPIParams.UserDevices body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.logout(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}/directory-entry/{guildId}")
    public Observable<DirectoryEntryGuild> modifyServerInHub(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.AddServerBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.modifyServerInHub(channelId, guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/emojis/{emojiId}")
    public Observable<ModelEmojiGuild> patchGuildEmoji(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("emojiId") long emojiId, @InterfaceC12528a RestAPIParams.PatchGuildEmoji body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.patchGuildEmoji(guildId, emojiId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me")
    public Observable<com.discord.api.user.User> patchUser(@InterfaceC12528a PatchUserBody patchUserBody) {
        C12238m.checkNotNullParameter(patchUserBody, "patchUserBody");
        return this._api.patchUser(patchUserBody);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me")
    public Observable<com.discord.api.user.User> patchUser(@InterfaceC12528a RestAPIParams.UserInfo userInfo) {
        C12238m.checkNotNullParameter(userInfo, "userInfo");
        return this._api.patchUser(userInfo);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("phone-verifications/resend")
    public Observable<Void> phoneVerificationsResend(@InterfaceC12528a RestAPIParams.VerificationCodeResend body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.phoneVerificationsResend(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("phone-verifications/verify")
    public Observable<retrofit2.Response<ModelPhoneVerificationToken>> phoneVerificationsVerify(@InterfaceC12528a RestAPIParams.VerificationCode body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.phoneVerificationsVerify(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/fingerprint")
    public Observable<FingerprintResponse> postAuthFingerprint(@InterfaceC12528a RestAPIParams.EmptyBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postAuthFingerprint(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/login")
    public Observable<retrofit2.Response<ModelLoginResult>> postAuthLogin(@InterfaceC12528a RestAPIParams.AuthLogin body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postAuthLogin(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/register")
    public Observable<retrofit2.Response<RegisterResponse>> postAuthRegister(@InterfaceC12528a RestAPIParams.AuthRegister body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postAuthRegister(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/register/phone")
    public Observable<retrofit2.Response<Void>> postAuthRegisterPhone(@InterfaceC12528a RestAPIParams.AuthRegisterPhone body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postAuthRegisterPhone(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/verify/resend")
    public Observable<retrofit2.Response<Void>> postAuthVerifyResend(@InterfaceC12528a RestAPIParams.EmptyBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postAuthVerifyResend(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/invites")
    public Observable<ModelInvite> postChannelInvite(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Invite body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postChannelInvite(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/messages/{messageId}/ack")
    public Observable<Void> postChannelMessagesAck(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") Long messageId, @InterfaceC12528a RestAPIParams.ChannelMessagesAck body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postChannelMessagesAck(channelId, messageId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/emojis")
    public Observable<ModelEmojiGuild> postGuildEmoji(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.PostGuildEmoji body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postGuildEmoji(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/ack/{ackType}/{ackedId}")
    public Observable<Void> postGuildFeatureAck(@InterfaceC12546s("guildId") long channelId, @InterfaceC12546s("ackType") int ackType, @InterfaceC12546s("ackedId") long ackedId, @InterfaceC12528a RestAPIParams.GuildFeatureAck body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postGuildFeatureAck(channelId, ackType, ackedId, body);
    }

    public final Observable<ModelInvite> postInviteCode(ModelInvite invite, String location, RestAPIParams.InviteCode body) {
        C12238m.checkNotNullParameter(invite, "invite");
        C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        C12238m.checkNotNullParameter(body, "body");
        RestAPIInterface restAPIInterface = this._api;
        String str = invite.code;
        C12238m.checkNotNullExpressionValue(str, "invite.code");
        Pair<String, ? extends Object>[] pairArr = new Pair[5];
        pairArr[0] = C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        Guild guild = invite.guild;
        pairArr[1] = C12116o.m10073to("location_guild_id", guild != null ? Long.valueOf(guild.getId()) : null);
        Channel channel = invite.getChannel();
        pairArr[2] = C12116o.m10073to("location_channel_id", channel != null ? Long.valueOf(channel.getId()) : null);
        Channel channel2 = invite.getChannel();
        pairArr[3] = C12116o.m10073to("location_channel_type", channel2 != null ? Integer.valueOf(channel2.getType()) : null);
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        pairArr[4] = C12116o.m10073to("invite_guild_scheduled_event_id", guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
        return ObservableExtensionsKt.restSubscribeOn$default(restAPIInterface.postInviteCode(str, body, jsonObjectOf(pairArr)), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("invites/{code}")
    public Observable<ModelInvite> postInviteCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @InterfaceC12528a RestAPIParams.InviteCode body, @InterfaceC12536i("X-Context-Properties") String context) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        C12238m.checkNotNullParameter(body, "body");
        C12238m.checkNotNullParameter(context, "context");
        return this._api.postInviteCode(code, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("auth/mfa/totp")
    public Observable<retrofit2.Response<ModelLoginResult>> postMFACode(@InterfaceC12528a RestAPIParams.MFALogin body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postMFACode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("oauth2/authorize")
    public Observable<RestAPIParams.OAuth2Authorize.ResponsePost> postOauth2Authorize(@InterfaceC12547t("client_id") String clientId, @InterfaceC12547t("state") String state, @InterfaceC12547t("response_type") String responseType, @InterfaceC12547t("redirect_uri") String redirectUrl, @InterfaceC12547t("prompt") String prompt, @InterfaceC12547t("scope") String scope, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS) String permissions, @InterfaceC12547t("code_challenge") String codeChallenge, @InterfaceC12547t("code_challenge_method") String codeChallengeMethod, @InterfaceC12528a Map<String, String> body) {
        C12238m.checkNotNullParameter(clientId, "clientId");
        C12238m.checkNotNullParameter(prompt, "prompt");
        C12238m.checkNotNullParameter(scope, "scope");
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postOauth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/remote-auth/cancel")
    public Observable<Void> postRemoteAuthCancel(@InterfaceC12528a RestAPIParams.RemoteAuthCancel body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthCancel(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/remote-auth/finish")
    public Observable<Void> postRemoteAuthFinish(@InterfaceC12528a RestAPIParams.RemoteAuthFinish body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthFinish(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/remote-auth")
    public Observable<ModelRemoteAuthHandshake> postRemoteAuthInitialize(@InterfaceC12528a RestAPIParams.RemoteAuthInitialize body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.postRemoteAuthInitialize(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("streams/{streamKey}/preview")
    public Observable<Void> postStreamPreview(@InterfaceC12546s("streamKey") String streamKey, @InterfaceC12528a RestAPIParams.Thumbnail thumbnail) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        C12238m.checkNotNullParameter(thumbnail, "thumbnail");
        return this._api.postStreamPreview(streamKey, thumbnail);
    }

    public final Observable<Void> postStreamPreview(String streamKey, String thumbnail) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        C12238m.checkNotNullParameter(thumbnail, "thumbnail");
        return this._api.postStreamPreview(streamKey, new RestAPIParams.Thumbnail(thumbnail));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/prune")
    public Observable<Void> pruneMembers(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.PruneGuild body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.pruneMembers(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/messages/{messageId}/reactions")
    public Observable<Void> removeAllReactions(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId) {
        return this._api.removeAllReactions(channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/recipients/{recipientId}")
    public Observable<Void> removeChannelRecipient(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("recipientId") long recipientId) {
        return this._api.removeChannelRecipient(channelId, recipientId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/{userId}")
    public Observable<Void> removeReaction(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction, @InterfaceC12546s("userId") long userId) {
        C12238m.checkNotNullParameter(reaction, "reaction");
        return this._api.removeReaction(channelId, messageId, reaction, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("users/@me/relationships/{userId}")
    public Observable<Void> removeRelationship(@InterfaceC12546s("userId") long userId, @InterfaceC12536i("X-Context-Properties") String context) {
        C12238m.checkNotNullParameter(context, "context");
        return this._api.removeRelationship(userId, context);
    }

    public final Observable<Void> removeRelationship(String location, long userId) {
        C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.removeRelationship(userId, jsonObjectOf(C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/messages/{messageId}/reactions/{reaction}/@me")
    public Observable<Void> removeSelfReaction(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("messageId") long messageId, @InterfaceC12546s(encoded = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "reaction") String reaction) {
        C12238m.checkNotNullParameter(reaction, "reaction");
        return this._api.removeSelfReaction(channelId, messageId, reaction);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("channels/{channelId}/directory-entry/{guildId}")
    public Observable<retrofit2.Response<DirectoryEntryGuild>> removeServerFromHub(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("guildId") long guildId) {
        return this._api.removeServerFromHub(channelId, guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/channels")
    public Observable<Void> reorderChannels(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a List<RestAPIParams.ChannelPosition> body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.reorderChannels(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("report")
    public Observable<Unit> report(@InterfaceC12528a RestAPIParams.Report body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.report(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("report")
    public Observable<List<ReportReason>> report(@InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId, @InterfaceC12547t("message_id") Long messageId, @InterfaceC12547t("user_id") Long userId) {
        return this._api.report(channelId, guildId, messageId, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/harvest")
    public Observable<Harvest> requestHarvest() {
        return this._api.requestHarvest();
    }

    public final Observable<Void> requestToSpeak(Channel channel, Clock clock) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(clock, "clock");
        return this._api.updateMyVoiceStates(channel.getGuildId(), new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), null, new UtcDateTime(clock.currentTimeMillis()), 2, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/requests/@me")
    public Observable<ModelMemberVerificationFormResponse> resetGuildJoinRequest(@InterfaceC12546s("guildId") long guildId) {
        return this._api.resetGuildJoinRequest(guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("entitlements/gift-codes/{code}")
    public Observable<ModelGift> resolveGiftCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code, @InterfaceC12547t("with_application") boolean withApplication, @InterfaceC12547t("with_subscription_plan") boolean withSubscription) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.resolveGiftCode(code, withApplication, withSubscription);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/@me/entitlements/gift-codes")
    public Observable<List<ModelGift>> resolveSkuIdGift(@InterfaceC12547t("sku_id") long skuId, @InterfaceC12547t("subscription_plan_id") Long subscriptionPlanId) {
        return this._api.resolveSkuIdGift(skuId, subscriptionPlanId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("users/@me/entitlements/gift-codes/{code}")
    public Observable<Void> revokeGiftCode(@InterfaceC12546s(ModelAuditLogEntry.CHANGE_KEY_CODE) String code) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return this._api.revokeGiftCode(code);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("invites/{inviteCode}")
    public Observable<ModelInvite> revokeInvite(@InterfaceC12546s("inviteCode") String inviteCode) {
        C12238m.checkNotNullParameter(inviteCode, "inviteCode");
        return this._api.revokeInvite(inviteCode);
    }

    public final Observable<Void> ring(long channelId, long messageId, List<Long> recipients) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.ring(channelId, new RestAPIParams.Ring(recipients), jsonObjectOf(C12116o.m10073to("message_id", Long.valueOf(messageId)))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/call/ring")
    public Observable<Void> ring(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Ring body, @InterfaceC12536i("X-Context-Properties") String context) {
        C12238m.checkNotNullParameter(body, "body");
        C12238m.checkNotNullParameter(context, "context");
        return this._api.ring(channelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("science")
    public Observable<Void> science(@InterfaceC12528a Science body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.science(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/messages/search")
    public Observable<ModelSearchResponse> searchChannelMessages(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("max_id") Long oldestMessageId, @InterfaceC12547t("author_id") List<String> authorIds, @InterfaceC12547t("mentions") List<String> mentionsIds, @InterfaceC12547t("has") List<String> has, @InterfaceC12547t("content") List<String> content, @InterfaceC12547t("attempts") Integer attempts, @InterfaceC12547t("include_nsfw") Boolean includeNsfw) {
        return this._api.searchChannelMessages(channelId, oldestMessageId, authorIds, mentionsIds, has, content, attempts, includeNsfw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("guilds/{guildId}/messages/search")
    public Observable<ModelSearchResponse> searchGuildMessages(@InterfaceC12546s("guildId") long guildId, @InterfaceC12547t("max_id") Long oldestMessageId, @InterfaceC12547t("author_id") List<String> authorIds, @InterfaceC12547t("mentions") List<String> mentionsIds, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) List<String> inChannelIds, @InterfaceC12547t("has") List<String> has, @InterfaceC12547t("content") List<String> content, @InterfaceC12547t("attempts") Integer attempts, @InterfaceC12547t("include_nsfw") Boolean includeNsfw) {
        return this._api.searchGuildMessages(guildId, oldestMessageId, authorIds, mentionsIds, inChannelIds, has, content, attempts, includeNsfw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("channels/{channelId}/directory-entries/search")
    public Observable<List<DirectoryEntryGuild>> searchServers(@InterfaceC12546s("channelId") long channelId, @InterfaceC12547t("query") String query) {
        C12238m.checkNotNullParameter(query, "query");
        return this._api.searchServers(channelId, query);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("interactions")
    @InterfaceC12539l
    public Observable<Void> sendApplicationCommand(@InterfaceC12544q("payload_json") PayloadJSON<RestAPIParams.ApplicationCommand> payloadJson, @InterfaceC12544q MultipartBody.Part[] files) {
        C12238m.checkNotNullParameter(payloadJson, "payloadJson");
        C12238m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.sendApplicationCommand(payloadJson, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("interactions")
    public Observable<Void> sendApplicationCommand(@InterfaceC12528a RestAPIParams.ApplicationCommand body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.sendApplicationCommand(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("private/bug-reports")
    @InterfaceC12539l
    public Observable<Unit> sendBugReport(@InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_NAME) String name, @InterfaceC12544q(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION) String description, @InterfaceC12544q("priority") int priority, @InterfaceC12544q("asana_inbox_id") Long asanaInboxId, @InterfaceC12544q MultipartBody.Part screenshot) {
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this._api.sendBugReport(name, description, priority, asanaInboxId, screenshot);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("interactions")
    public Observable<Void> sendComponentInteraction(@InterfaceC12528a RestAPIParams.ComponentInteraction body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.sendComponentInteraction(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/greet")
    public Observable<Message> sendGreetMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.GreetMessage body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.sendGreetMessage(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/messages")
    @InterfaceC12539l
    public Observable<Message> sendMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12544q("payload_json") PayloadJSON<RestAPIParams.Message> payloadJson, @InterfaceC12544q MultipartBody.Part[] files) {
        C12238m.checkNotNullParameter(payloadJson, "payloadJson");
        C12238m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.sendMessage(channelId, payloadJson, files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/messages")
    public Observable<Message> sendMessage(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Message message) {
        C12238m.checkNotNullParameter(message, "message");
        return this._api.sendMessage(channelId, message);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("interactions")
    public Observable<Void> sendModalInteraction(@InterfaceC12528a RestAPIParams.ModalInteraction body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.sendModalInteraction(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/relationships")
    public Observable<Void> sendRelationshipRequest(@InterfaceC12528a RestAPIParams.UserRelationship.Add relationship, @InterfaceC12536i("X-Context-Properties") String context) {
        C12238m.checkNotNullParameter(relationship, "relationship");
        C12238m.checkNotNullParameter(context, "context");
        return this._api.sendRelationshipRequest(relationship, context);
    }

    public final Observable<Void> sendRelationshipRequest(String location, String username, int discriminator, CaptchaHelper.CaptchaPayload captchaPayload) {
        C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        C12238m.checkNotNullParameter(username, "username");
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.sendRelationshipRequest(new RestAPIParams.UserRelationship.Add(username, discriminator, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), jsonObjectOf(C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/consent")
    public Observable<Void> setConsents(@InterfaceC12528a RestAPIParams.Consents body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.setConsents(body);
    }

    public final Observable<Void> setMeSuppressed(Channel channel, boolean isSuppressed) {
        C12238m.checkNotNullParameter(channel, "channel");
        return this._api.updateMyVoiceStates(channel.getGuildId(), new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), Boolean.valueOf(isSuppressed), null, 4, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/mfa")
    public Observable<Void> setMfaLevel(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.GuildMFA body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.setMfaLevel(guildId, body);
    }

    public final Observable<Void> setUserSuppressed(Channel channel, long userId, boolean isSuppressed) {
        C12238m.checkNotNullParameter(channel, "channel");
        return this._api.updateUserVoiceStates(channel.getGuildId(), userId, new RestAPIParams.ChannelVoiceStateUpdate(channel.getId(), Boolean.valueOf(isSuppressed), null, 4, null));
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/typing")
    public Observable<ModelTypingResponse> setUserTyping(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.EmptyBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.setUserTyping(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("stage-instances")
    public Observable<StageInstance> startStageInstance(@InterfaceC12528a RestAPIParams.StartStageInstanceBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.startStageInstance(body);
    }

    public final Observable<Void> stopRinging(long channelId, long messageId, List<Long> recipients) {
        return ObservableExtensionsKt.restSubscribeOn$default(this._api.stopRinging(channelId, new RestAPIParams.Ring(recipients), jsonObjectOf(C12116o.m10073to("message_id", Long.valueOf(messageId)))), false, 1, null);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("channels/{channelId}/call/stop-ringing")
    public Observable<Void> stopRinging(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.Ring body, @InterfaceC12536i("X-Context-Properties") String context) {
        C12238m.checkNotNullParameter(body, "body");
        C12238m.checkNotNullParameter(context, "context");
        return this._api.stopRinging(channelId, body, context);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("connections/{connection}/callback")
    public Observable<Void> submitConnectionState(@InterfaceC12546s("connection") String connection, @InterfaceC12528a RestAPIParams.ConnectionState state) {
        C12238m.checkNotNullParameter(connection, "connection");
        C12238m.checkNotNullParameter(state, "state");
        return this._api.submitConnectionState(connection, state);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("reporting/{reportType}")
    public Observable<Unit> submitReport(@InterfaceC12546s("reportType") String reportType, @InterfaceC12528a ReportSubmissionBody body) {
        C12238m.checkNotNullParameter(reportType, "reportType");
        C12238m.checkNotNullParameter(body, "body");
        return this._api.submitReport(reportType, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("guilds/{guildId}/premium/subscriptions")
    public Observable<List<ModelAppliedGuildBoost>> subscribeToGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.GuildBoosting guildBoosting) {
        C12238m.checkNotNullParameter(guildBoosting, "guildBoosting");
        return this._api.subscribeToGuild(guildId, guildBoosting);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/{guildId}/integrations/{integrationId}/sync")
    public Observable<Void> syncIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("integrationId") long integrationId) {
        return this._api.syncIntegration(guildId, integrationId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}")
    public Observable<Void> transferGuildOwnership(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.TransferGuildOwnership transferGuildOwnership) {
        C12238m.checkNotNullParameter(transferGuildOwnership, "transferGuildOwnership");
        return this._api.transferGuildOwnership(guildId, transferGuildOwnership);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/bans/{userId}")
    public Observable<Void> unbanUser(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId) {
        return this._api.unbanUser(guildId, userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/guilds/premium/subscription-slots/{subscriptionSlotId}/uncancel")
    public Observable<ModelGuildBoostSlot> uncancelSubscriptionSlot(@InterfaceC12546s("subscriptionSlotId") long slotId) {
        return this._api.uncancelSubscriptionSlot(slotId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12529b("guilds/{guildId}/premium/subscriptions/{subscriptionId}")
    public Observable<Void> unsubscribeToGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("subscriptionId") long subscriptionId) {
        return this._api.unsubscribeToGuild(guildId, subscriptionId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/connections/{connection}/{connectionId}")
    public Observable<retrofit2.Response<ConnectedAccount>> updateConnection(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("connectionId") String connectionId, @InterfaceC12528a RestAPIParams.ConnectedAccount connectedAccount) {
        C12238m.checkNotNullParameter(connection, "connection");
        C12238m.checkNotNullParameter(connectionId, "connectionId");
        C12238m.checkNotNullParameter(connectedAccount, "connectedAccount");
        return this._api.updateConnection(connection, connectionId, connectedAccount);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/connections/{connection}/{connectionId}")
    public Observable<retrofit2.Response<ConnectedAccount>> updateConnectionName(@InterfaceC12546s("connection") String connection, @InterfaceC12546s("connectionId") String connectionId, @InterfaceC12528a RestAPIParams.ConnectedAccountNameOnly connectedAccountName) {
        C12238m.checkNotNullParameter(connection, "connection");
        C12238m.checkNotNullParameter(connectionId, "connectionId");
        C12238m.checkNotNullParameter(connectedAccountName, "connectedAccountName");
        return this._api.updateConnectionName(connection, connectionId, connectedAccountName);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}")
    public Observable<Guild> updateGuild(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.UpdateGuild body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateGuild(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/integrations/{integrationId}")
    public Observable<Void> updateGuildIntegration(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("integrationId") long integrationId, @InterfaceC12528a RestAPIParams.GuildIntegration body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateGuildIntegration(guildId, integrationId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}")
    public Observable<GuildRoleSubscriptionGroupListing> updateGuildRoleSubscriptionGroupListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12528a RestAPIParams.UpdateGuildRoleSubscriptionGroupListing body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionGroupListing(guildId, groupListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/role-subscriptions/subscription-listings/{listingId}/trial")
    public Observable<GuildRoleSubscriptionTierFreeTrial> updateGuildRoleSubscriptionTierFreeTrial(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("listingId") long listingId, @InterfaceC12528a RestAPIParams.UpdateGuildRoleSubscriptionTierFreeTrial body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionTierFreeTrial(guildId, listingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/role-subscriptions/group-listings/{groupListingId}/subscription-listings/{listingId}")
    public Observable<GuildRoleSubscriptionTierListing> updateGuildRoleSubscriptionTierListing(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("groupListingId") long groupListingId, @InterfaceC12546s("listingId") long tierListingId, @InterfaceC12528a RestAPIParams.UpdateGuildRoleSubscriptionTierListing body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateGuildRoleSubscriptionTierListing(guildId, groupListingId, tierListingId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/scheduled-events/{eventId}")
    public Observable<Unit> updateGuildScheduledEvent(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("eventId") long eventId, @InterfaceC12528a RestAPIParams.UpdateGuildScheduledEventBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateGuildScheduledEvent(guildId, eventId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/members/@me")
    public Observable<GuildMember> updateMeGuildMember(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a PatchGuildMemberBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateMeGuildMember(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/voice-states/@me")
    public Observable<Void> updateMyVoiceStates(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.ChannelVoiceStateUpdate body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateMyVoiceStates(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/billing/payment-sources/{paymentSourceId}")
    public Observable<Void> updatePaymentSource(@InterfaceC12546s("paymentSourceId") String paymentSourceId, @InterfaceC12528a PatchPaymentSourceRaw PatchPaymentSourceRaw) {
        C12238m.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        C12238m.checkNotNullParameter(PatchPaymentSourceRaw, "PatchPaymentSourceRaw");
        return this._api.updatePaymentSource(paymentSourceId, PatchPaymentSourceRaw);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("channels/{channelId}/permissions/{targetId}")
    public Observable<Void> updatePermissionOverwrites(@InterfaceC12546s("channelId") long channelId, @InterfaceC12546s("targetId") long targetId, @InterfaceC12528a RestAPIParams.ChannelPermissionOverwrites body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updatePermissionOverwrites(channelId, targetId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/guilds/@me/settings")
    public Observable<ModelNotificationSettings> updatePrivateChannelSettings(@InterfaceC12528a RestAPIParams.UserGuildSettings userGuildSettings) {
        C12238m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        return this._api.updatePrivateChannelSettings(userGuildSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/roles/{roleId}")
    public Observable<Void> updateRole(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("roleId") long roleId, @InterfaceC12528a RestAPIParams.Role body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateRole(guildId, roleId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("stage-instances/{channelId}")
    public Observable<StageInstance> updateStageInstance(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.UpdateStageInstanceBody body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateStageInstance(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/billing/subscriptions/{subscriptionId}")
    public Observable<Void> updateSubscription(@InterfaceC12546s("subscriptionId") String subscriptionId, @InterfaceC12528a RestAPIParams.UpdateSubscription updateSubscription) {
        C12238m.checkNotNullParameter(subscriptionId, "subscriptionId");
        C12238m.checkNotNullParameter(updateSubscription, "updateSubscription");
        return this._api.updateSubscription(subscriptionId, updateSubscription);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("channels/{channelId}/thread-members/@me/settings")
    public Observable<ThreadMember> updateThreadMemberSettings(@InterfaceC12546s("channelId") long channelId, @InterfaceC12528a RestAPIParams.ThreadMemberSettings body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateThreadMemberSettings(channelId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    public Observable<ModelNotificationSettings> updateUserGuildSettings(long guildId, RestAPIParams.UserGuildSettings userGuildSettings) {
        C12238m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        return guildId == 0 ? this._api.updatePrivateChannelSettings(userGuildSettings) : this._api.updateUserGuildSettings(guildId, userGuildSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("users/@me/notes/{userId}")
    public Observable<Void> updateUserNotes(@InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.UserNoteUpdate userNoteUpdate) {
        C12238m.checkNotNullParameter(userNoteUpdate, "userNoteUpdate");
        return this._api.updateUserNotes(userId, userNoteUpdate);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/settings")
    public Observable<ModelUserSettings> updateUserSettings(@InterfaceC12528a RestAPIParams.UserSettings userSettings) {
        C12238m.checkNotNullParameter(userSettings, "userSettings");
        return this._api.updateUserSettings(userSettings);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/settings")
    public Observable<ModelUserSettings> updateUserSettingsCustomStatus(@InterfaceC12528a RestAPIParams.UserSettingsCustomStatus userSettingsCustomStatus) {
        C12238m.checkNotNullParameter(userSettingsCustomStatus, "userSettingsCustomStatus");
        return this._api.updateUserSettingsCustomStatus(userSettingsCustomStatus);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/voice-states/{userId}")
    public Observable<Void> updateUserVoiceStates(@InterfaceC12546s("guildId") long guildId, @InterfaceC12546s("userId") long userId, @InterfaceC12528a RestAPIParams.ChannelVoiceStateUpdate body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateUserVoiceStates(guildId, userId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("guilds/{guildId}/vanity-url")
    public Observable<VanityUrlResponse> updateVanityUrl(@InterfaceC12546s("guildId") long guildId, @InterfaceC12528a RestAPIParams.VanityUrl body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.updateVanityUrl(guildId, body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("users/@me/connections/contacts/@me/external-friend-list-entries")
    public Observable<retrofit2.Response<BulkFriendSuggestions>> uploadContacts(@InterfaceC12528a RestAPIParams.UploadContacts uploadContacts) {
        C12238m.checkNotNullParameter(uploadContacts, "uploadContacts");
        return this._api.uploadContacts(uploadContacts);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("debug-logs/4/{filename}")
    public Observable<Void> uploadLog(@InterfaceC12546s("filename") String filename, @InterfaceC12528a String content) {
        C12238m.checkNotNullParameter(filename, "filename");
        C12238m.checkNotNullParameter(content, "content");
        return this._api.uploadLog(filename, content);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("debug-logs/multi/4")
    @InterfaceC12539l
    public Observable<Void> uploadLogs(@InterfaceC12544q MultipartBody.Part[] files) {
        C12238m.checkNotNullParameter(files, ChatInputComponentTypes.FILES);
        return this._api.uploadLogs(files);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/{userId}/sessions/{sessionId}/activities/{applicationId}/{actionType}")
    public Observable<ActivityActionConfirmation> userActivityAction(@InterfaceC12546s("userId") long userId, @InterfaceC12546s("applicationId") long application, @InterfaceC12546s("sessionId") String sessionId, @InterfaceC12546s("actionType") Integer actionType, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID) Long channelId, @InterfaceC12547t("message_id") Long messageId) {
        C12238m.checkNotNullParameter(sessionId, "sessionId");
        return this._api.userActivityAction(userId, application, sessionId, actionType, channelId, messageId);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long j, long j2, String str) {
        return userActivityActionJoin$default(this, j, j2, str, null, null, 24, null);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long j, long j2, String str, Long l) {
        return userActivityActionJoin$default(this, j, j2, str, l, null, 16, null);
    }

    public final Observable<ActivityActionConfirmation> userActivityActionJoin(long authorId, long applicationId, String sessionId, Long channelId, Long messageId) {
        C12238m.checkNotNullParameter(sessionId, "sessionId");
        return this._api.userActivityAction(authorId, applicationId, sessionId, Integer.valueOf(MessageActivityType.JOIN.getApiInt()), channelId, messageId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/phone")
    public Observable<Void> userAddPhone(@InterfaceC12528a RestAPIParams.Phone body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userAddPhone(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/phone/verify")
    public Observable<Void> userAddPhoneNoPassword(@InterfaceC12528a RestAPIParams.VerificationCodeOnly body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userAddPhoneNoPassword(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12541n("users/@me/agreements")
    public Observable<Void> userAgreements(@InterfaceC12528a RestAPIParams.UserAgreements body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userAgreements(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/captcha/verify")
    public Observable<Void> userCaptchaVerify(@InterfaceC12528a RestAPIParams.CaptchaCode body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userCaptchaVerify(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/channels")
    public Observable<Channel> userCreateChannel(@InterfaceC12528a RestAPIParams.CreateChannel body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userCreateChannel(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/devices")
    public Observable<Void> userCreateDevice(@InterfaceC12528a RestAPIParams.UserDevices body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userCreateDevice(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12543p("users/@me/email")
    public Observable<Void> userEmail() {
        return this._api.userEmail();
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/email/verify-code")
    public Observable<ModelEmailChangeConfirm> userEmailVerifyCode(@InterfaceC12528a RestAPIParams.UserEmailConfirmCode body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userEmailVerifyCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/{userId}")
    public Observable<com.discord.api.user.User> userGet(@InterfaceC12546s("userId") long userId) {
        return this._api.userGet(userId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12535h(hasBody = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, method = "DELETE", path = "users/@me/phone")
    public Observable<Void> userPhoneDelete(@InterfaceC12528a RestAPIParams.DeletePhone body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userPhoneDelete(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("users/@me/phone")
    public Observable<Void> userPhoneWithToken(@InterfaceC12528a RestAPIParams.VerificationPhoneCode body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.userPhoneWithToken(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12533f("users/{userId}/profile")
    public Observable<UserProfile> userProfileGet(@InterfaceC12546s("userId") long userId, @InterfaceC12547t("with_mutual_guilds") boolean withMutualGuilds, @InterfaceC12547t(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID) Long guildId) {
        return this._api.userProfileGet(userId, withMutualGuilds, guildId);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/automations/email-domain-lookup")
    public Observable<retrofit2.Response<EmailVerification>> verifyEmail(@InterfaceC12528a RestAPIParams.VerifyEmail body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.verifyEmail(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("guilds/automations/email-domain-lookup/verify-code")
    public Observable<retrofit2.Response<EmailVerificationCode>> verifyEmailCode(@InterfaceC12528a RestAPIParams.VerifyEmailCode body) {
        C12238m.checkNotNullParameter(body, "body");
        return this._api.verifyEmailCode(body);
    }

    @Override // com.discord.restapi.RestAPIInterface
    @InterfaceC12542o("google-play/verify-purchase-token")
    public Observable<RestAPIParams.VerifyPurchaseResponse> verifyPurchaseToken(@InterfaceC12528a RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseBody) {
        C12238m.checkNotNullParameter(verifyPurchaseBody, "verifyPurchaseBody");
        return this._api.verifyPurchaseToken(verifyPurchaseBody);
    }

    public final Observable<Void> setConsent(boolean consented, String consentType) {
        C12238m.checkNotNullParameter(consentType, "consentType");
        if (consented) {
            return setConsent$default(this, consentType, null, 2, null);
        }
        return setConsent$default(this, null, consentType, 1, null);
    }
}
