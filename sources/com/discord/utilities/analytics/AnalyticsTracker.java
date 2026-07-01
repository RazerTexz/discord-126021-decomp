package com.discord.utilities.analytics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.app.NotificationManagerCompat;
import b.d.b.a.a;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.adjust.sdk.AdjustAttribution;
import com.discord.analytics.generated.events.TrackAccountLinkStep;
import com.discord.analytics.generated.events.TrackAgeGateSubmitted;
import com.discord.analytics.generated.events.TrackConnectedAccountInitiated;
import com.discord.analytics.generated.events.TrackDismissibleContentDismissed;
import com.discord.analytics.generated.events.TrackForceUpdatePasswordSucceeded;
import com.discord.analytics.generated.events.TrackGuildAutomodFeedback;
import com.discord.analytics.generated.events.TrackRoleSubscriptionListingUpsellPageViewedV3;
import com.discord.analytics.generated.events.impression.TrackImpressionInviteAccept;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.sticker.Sticker;
import com.discord.api.thread.ThreadMemberFlags;
import com.discord.api.user.User;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.rtcconnection.mediaengine.MediaEngine$AudioInfo;
import com.discord.rtcconnection.mediaengine.MediaEngine$EchoCancellationInfo;
import com.discord.stores.FailedMessageResolutionType;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreMediaSettings$NoiseProcessing;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.email.EmailUtils;
import com.discord.utilities.fcm.NotificationClient$SettingsV2;
import com.discord.utilities.intent.RouteHandlers$AnalyticsMetadata;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.FileUploadAlertType;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.guilds.create.StockGuildTemplate;
import com.discord.widgets.guilds.invite.GuildInvite;
import com.discord.widgets.stage.model.StageAnalyticsRequestToSpeakState;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$FormState;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemChannel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemGuild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemUser;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.g;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker {
    private static final int ATTACHMENT_ADD = 0;
    public static final String ATTACHMENT_SOURCE_KEYBOARD = "keyboard";
    public static final String ATTACHMENT_SOURCE_PICKER = "media_picker";
    public static final String ATTACHMENT_SOURCE_SHARE = "share";
    public static final long THROTTLE_LONG = 900000;
    public static final long THROTTLE_MEDIUM = 300000;
    public static final long THROTTLE_SHORT = 60000;
    public static final AnalyticsTracker INSTANCE = new AnalyticsTracker();
    private static final AnalyticsUtils$Tracker tracker = AnalyticsUtils$Tracker.Companion.getInstance();

    /* JADX INFO: renamed from: firebaseAnalytics$delegate, reason: from kotlin metadata */
    private static final Lazy firebaseAnalytics = g.lazy(AnalyticsTracker$firebaseAnalytics$2.INSTANCE);

    private AnalyticsTracker() {
    }

    public static /* synthetic */ void accountLinkFailed$default(AnalyticsTracker analyticsTracker, String str, Integer num, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        analyticsTracker.accountLinkFailed(str, num, str2, str3, str4);
    }

    public static /* synthetic */ void accountLinkStep$default(AnalyticsTracker analyticsTracker, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        analyticsTracker.accountLinkStep(str, str2, str3, str4);
    }

    public static final void addAttachment(String source, String mimeType, int totalAttachments) {
        m.checkNotNullParameter(source, "source");
        m.checkNotNullParameter(mimeType, "mimeType");
        Observable<Channel> observableZ = StoreStream.Companion.getChannelsSelected().observeSelectedChannel().Z(1);
        m.checkNotNullExpressionValue(observableZ, "StoreStream\n        .get…hannel()\n        .take(1)");
        Observable<R> observableG = observableZ.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableG2 = observableG.G(new AnalyticsTracker$addAttachment$1(source, mimeType, totalAttachments));
        m.checkNotNullExpressionValue(observableG2, "StoreStream\n        .get…+ it.properties\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableG2), INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnalyticsTracker$addAttachment$2.INSTANCE, 62, (Object) null);
    }

    private final void addVoiceConnectionProperties(Map<String, Object> mutableProperties, Channel channel, String cloudflareBestRegion) {
        if (channel != null) {
            mutableProperties.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(Long.valueOf(channel.getId()).longValue()));
        }
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        if (lValueOf != null && lValueOf.longValue() > 0) {
            mutableProperties.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, lValueOf);
        }
        if (cloudflareBestRegion != null) {
            mutableProperties.put("cloudflare_best_region", cloudflareBestRegion);
        }
    }

    public static final void appLandingViewed(long lastLogoutTs) {
        Long lValueOf = Long.valueOf(lastLogoutTs);
        if (!(lValueOf.longValue() != 0)) {
            lValueOf = null;
        }
        tracker.track("app_landing_viewed", lValueOf != null ? g0.mapOf(o.to("last_logout_ts", Long.valueOf(lValueOf.longValue()))) : null);
    }

    public static final void appNotificationClicked(Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        if (!properties.isEmpty()) {
            tracker.track("notification_clicked", properties);
        }
    }

    private final String audioOutputDeviceTypeToString(DiscordAudioManager$DeviceTypes type) {
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            return "default";
        }
        if (iOrdinal == 1) {
            return "invalid";
        }
        if (iOrdinal == 2) {
            return "speaker";
        }
        if (iOrdinal == 3) {
            return "wired_headset";
        }
        if (iOrdinal == 4) {
            return "earpiece";
        }
        if (iOrdinal != 5) {
            return null;
        }
        return "bluetooth_headset";
    }

    public static /* synthetic */ void callReportProblem$default(AnalyticsTracker analyticsTracker, long j, String str, Channel channel, Map map, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice, boolean z2, String str4, int i, Object obj) {
        analyticsTracker.callReportProblem(j, str, channel, map, (i & 16) != 0 ? null : l, str2, feedbackRating, num, str3, storeMediaSettings$VoiceConfiguration, discordAudioManager$AudioDevice, z2, (i & 4096) != 0 ? null : str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void changeLogEvent$default(AnalyticsTracker analyticsTracker, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = new HashMap();
        }
        analyticsTracker.changeLogEvent(str, str2, str3, map);
    }

    private final void closeTutorial(String tutorial, boolean acknowledged) {
        tracker.track("close_tutorial", h0.mapOf(o.to("tutorial", tutorial), o.to("acknowledged", Boolean.valueOf(acknowledged))));
    }

    public static final void connectedAccountViewed(String platformType) {
        HashMap map = new HashMap();
        if (platformType != null) {
            map.put("platform_type", platformType);
        }
        tracker.track("connected_account_viewed", map);
    }

    public static /* synthetic */ void connectedAccountViewed$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        connectedAccountViewed(str);
    }

    public static /* synthetic */ void dismissModal$default(AnalyticsTracker analyticsTracker, String str, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        analyticsTracker.dismissModal(str, str2, str3, l);
    }

    private final void expressionPickerCategorySelected(Long stickerPackId, Long guildId, String tab) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab", tab);
        if (guildId != null) {
            guildId.longValue();
            linkedHashMap.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, guildId);
        }
        if (stickerPackId != null) {
            stickerPackId.longValue();
            linkedHashMap.put("sticker_pack_id", stickerPackId);
        }
        tracker.track("expression_picker_category_selected", linkedHashMap);
    }

    public static /* synthetic */ void expressionPickerCategorySelected$default(AnalyticsTracker analyticsTracker, Long l, Long l2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            l2 = null;
        }
        analyticsTracker.expressionPickerCategorySelected(l, l2, str);
    }

    public static final void externalFingerprintDropped(String fingerprint, String droppedFingerprint) {
        m.checkNotNullParameter(fingerprint, "fingerprint");
        m.checkNotNullParameter(droppedFingerprint, "droppedFingerprint");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AnalyticsTracker analyticsTracker = INSTANCE;
        Long fingerprintNumber = analyticsTracker.toFingerprintNumber(fingerprint);
        if (fingerprintNumber != null) {
            linkedHashMap.put("fingerprint", Long.valueOf(fingerprintNumber.longValue()));
        }
        Long fingerprintNumber2 = analyticsTracker.toFingerprintNumber(droppedFingerprint);
        if (fingerprintNumber2 != null) {
            linkedHashMap.put("dropped_fingerprint", Long.valueOf(fingerprintNumber2.longValue()));
        }
        tracker.track("external_fingerprint_dropped", linkedHashMap);
    }

    public static /* synthetic */ void friendRequestFailed$default(AnalyticsTracker analyticsTracker, CharSequence charSequence, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        analyticsTracker.friendRequestFailed(charSequence, str, num, str2);
    }

    private final String getAnalyticsValueForNotificationFrequency(Integer messageNotifications) {
        int i = ModelNotificationSettings.FREQUENCY_ALL;
        if (messageNotifications != null && messageNotifications.intValue() == i) {
            return "All";
        }
        int i2 = ModelNotificationSettings.FREQUENCY_MENTIONS;
        if (messageNotifications != null && messageNotifications.intValue() == i2) {
            return "Mentions";
        }
        int i3 = ModelNotificationSettings.FREQUENCY_NOTHING;
        if (messageNotifications != null && messageNotifications.intValue() == i3) {
            return "Nothing";
        }
        int i4 = ModelNotificationSettings.FREQUENCY_UNSET;
        if (messageNotifications != null && messageNotifications.intValue() == i4) {
            return "Unset";
        }
        return null;
    }

    private final String getAnalyticsValueForThreadNotificationFrequency(ThreadMemberFlags threadMemberFlags, int i) {
        if (i == (i & 2)) {
            return "All";
        }
        if (i == (i & 4)) {
            return "Mentions";
        }
        return i == (i & 8) ? "Nothing" : "Unset";
    }

    private final FirebaseAnalytics getFirebaseAnalytics() {
        return (FirebaseAnalytics) firebaseAnalytics.getValue();
    }

    private final Observable<Map<String, Object>> getGameProperties(long meId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Presence> observableObserveLocalPresence = storeStream$Companion.getPresences().observeLocalPresence();
        Observable<R> observableG = storeStream$Companion.getPresences().observePresenceForUser(meId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableJ = Observable.j(observableObserveLocalPresence, observableG, AnalyticsTracker$getGameProperties$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…\n            })\n        )");
        Observable<Map<String, Object>> observableG2 = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 0L, false, 3, null).G(AnalyticsTracker$getGameProperties$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "Observable\n        .comb…NonNullValues()\n        }");
        return observableG2;
    }

    private final String getNetworkTypeAnalyticsValue(Integer networkType) {
        if (networkType == null) {
            return null;
        }
        if (networkType.intValue() == 1) {
            return "wifi";
        }
        if (networkType.intValue() == 0) {
            return "cellular";
        }
        if (networkType.intValue() == 9) {
            return "ethernet";
        }
        if (networkType.intValue() == 7) {
            return "bluetooth";
        }
        if (networkType.intValue() == 6) {
            return "wimax";
        }
        return networkType.intValue() == 17 ? "vpn" : "other";
    }

    private final Map<String, Object> getStageChannelMetadata(long channelId) {
        String strF;
        String str;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Channel channel = storeStream$Companion.getChannels().getChannel(channelId);
        if (channel == null) {
            return null;
        }
        PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
        Map<Long, GuildRole> mapEmptyMap = (Map) a.c(channel, storeStream$Companion.getGuilds().getRoles());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        boolean zCanEveryoneRole = permissionUtils.canEveryoneRole(Permission.REQUEST_TO_SPEAK, channel, mapEmptyMap);
        StageInstance stageInstanceForChannel = storeStream$Companion.getStageInstances().getStageInstanceForChannel(channelId);
        Pair[] pairArr = new Pair[5];
        pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId));
        pairArr[1] = o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(channel.getGuildId()));
        if (stageInstanceForChannel == null || (strF = stageInstanceForChannel.getTopic()) == null) {
            strF = "";
        }
        pairArr[2] = o.to(ModelAuditLogEntry.CHANGE_KEY_TOPIC, strF);
        pairArr[3] = o.to("stage_instance_id", stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null);
        pairArr[4] = o.to("request_to_speak_state", Integer.valueOf(zCanEveryoneRole ? StageAnalyticsRequestToSpeakState.REQUEST_TO_SPEAK_EVERYONE.getIntegerValue() : StageAnalyticsRequestToSpeakState.REQUEST_TO_SPEAK_NO_ONE.getIntegerValue()));
        Map mapMutableMapOf = h0.mutableMapOf(pairArr);
        RtcConnection$Metadata rtcConnectionMetadata = storeStream$Companion.getRtcConnection().getRtcConnectionMetadata();
        if (rtcConnectionMetadata != null && (str = rtcConnectionMetadata.mediaSessionId) != null) {
            mapMutableMapOf.put("media_session_id", str);
        }
        return CollectionExtensionsKt.filterNonNullValues(mapMutableMapOf);
    }

    public static /* synthetic */ void getTHROTTLE_SHORT$annotations() {
    }

    private final Map<String, Object> getVoiceChannelProperties(long meId, Channel channel, Long durationMs, Map<Long, VoiceState> guildVoiceStates, VideoInputDeviceDescription videoInputDevice, String rtcConnectionId) {
        int i;
        int i2;
        Collection<VoiceState> collectionValues;
        if (guildVoiceStates == null || (collectionValues = guildVoiceStates.values()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
            for (VoiceState voiceState : collectionValues) {
                Long channelId = voiceState.getChannelId();
                long id2 = channel.getId();
                if (channelId != null && channelId.longValue() == id2 && voiceState.getUserId() != meId) {
                    i++;
                    if (voiceState.getSelfVideo()) {
                        i2++;
                    }
                }
            }
        }
        Map<String, Object> mapMutableMapOf = h0.mutableMapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId())), o.to("channel_type", Integer.valueOf(channel.getType())), o.to("voice_state_count", Integer.valueOf(i)), o.to("video_stream_count", Integer.valueOf(i2)));
        long guildId = channel.getGuildId();
        if (guildId > 0) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        }
        mapMutableMapOf.put("video_enabled", Boolean.valueOf(videoInputDevice != null));
        if (durationMs != null) {
            mapMutableMapOf.put("duration", Long.valueOf(durationMs.longValue()));
        }
        if (rtcConnectionId != null) {
            mapMutableMapOf.put("rtc_connection_id", rtcConnectionId);
        }
        return mapMutableMapOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map getVoiceChannelProperties$default(AnalyticsTracker analyticsTracker, long j, Channel channel, Long l, Map map, VideoInputDeviceDescription videoInputDeviceDescription, String str, int i, Object obj) {
        return analyticsTracker.getVoiceChannelProperties(j, channel, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : videoInputDeviceDescription, (i & 32) != 0 ? null : str);
    }

    public static /* synthetic */ void guildBoostPromotionClosed$default(AnalyticsTracker analyticsTracker, long j, Traits$Location traits$Location, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        analyticsTracker.guildBoostPromotionClosed(j, traits$Location, l);
    }

    public static /* synthetic */ void guildBoostPromotionOpened$default(AnalyticsTracker analyticsTracker, long j, Traits$Location traits$Location, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        analyticsTracker.guildBoostPromotionOpened(j, traits$Location, l);
    }

    public static final void guildExperimentTriggered(String name, int revision, int bucket, long guildId) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        tracker.track("experiment_guild_triggered", h0.mutableMapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_NAME, name), o.to("revision", Integer.valueOf(revision)), o.to("bucket", Integer.valueOf(bucket)), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void guildRoleSubscriptionUpsellOpened$default(AnalyticsTracker analyticsTracker, long j, List list, boolean z2, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            list = n.emptyList();
        }
        analyticsTracker.guildRoleSubscriptionUpsellOpened(j, list, z2, str);
    }

    public static final void guildTemplateResolveFailed(String guildTemplateCode) {
        m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        tracker.track("guild_template_resolved", h0.mapOf(o.to("resolved", Boolean.FALSE), o.to("guild_template_code", guildTemplateCode)));
    }

    private final Map<String, Object> insertUriProperties(Map<String, Object> map, Uri uri) {
        String host = uri.getHost();
        if (host != null) {
            m.checkNotNullExpressionValue(host, "it");
            map.put("uri_host", host);
        }
        String scheme = uri.getScheme();
        if (scheme != null) {
            m.checkNotNullExpressionValue(scheme, "it");
            map.put("uri_scheme", scheme);
        }
        String path = uri.getPath();
        if (!(path == null || path.length() == 0)) {
            if (path.length() > 100) {
                path = path.substring(0, 99);
                m.checkNotNullExpressionValue(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            map.put("uri_path", path);
        }
        return map;
    }

    public static final void inviteCopied(ModelInvite invite, String source) {
        m.checkNotNullParameter(source, "source");
        if (invite == null) {
            return;
        }
        AnalyticsTracker analyticsTracker = INSTANCE;
        String str = invite.code;
        m.checkNotNullExpressionValue(str, "invite.code");
        Guild guild = invite.guild;
        Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
        Channel channel = invite.getChannel();
        Long lValueOf2 = channel != null ? Long.valueOf(channel.getId()) : null;
        Channel channel2 = invite.getChannel();
        Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        analyticsTracker.inviteCopied(str, lValueOf, lValueOf2, numValueOf, source, guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
    }

    public static final void inviteOpened(String inviteCode) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        tracker.track("invite_opened", g0.mapOf(o.to("invite_code", inviteCode)));
    }

    public static final void inviteResolveFailed(String inviteCode, String location, String errorMessage, Integer errorCode) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        analyticsUtils$Tracker.track("resolve_invite", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_CODE, inviteCode), o.to("resolved", Boolean.FALSE), o.to("authenticated", Boolean.valueOf(analyticsUtils$Tracker.isAuthed$app_productionGoogleRelease())), o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location), o.to("error_message", errorMessage), o.to("error_code", errorCode))));
    }

    public static /* synthetic */ void inviteResolveFailed$default(String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        inviteResolveFailed(str, str2, str3, num);
    }

    public static final void inviteShareClicked(ModelInvite invite) {
        if (invite == null) {
            return;
        }
        AnalyticsTracker analyticsTracker = INSTANCE;
        String str = invite.code;
        m.checkNotNullExpressionValue(str, "invite.code");
        Guild guild = invite.guild;
        Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
        Channel channel = invite.getChannel();
        Long lValueOf2 = channel != null ? Long.valueOf(channel.getId()) : null;
        Channel channel2 = invite.getChannel();
        Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
        User inviter = invite.getInviter();
        Long lValueOf3 = inviter != null ? Long.valueOf(inviter.getId()) : null;
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        analyticsTracker.inviteShareClicked(str, lValueOf, lValueOf2, numValueOf, lValueOf3, guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
    }

    public static final void nearbyConnected() {
        AnalyticsUtils$Tracker.track$default(tracker, "friend_add_nearby_connected", null, 2, null);
    }

    public static /* synthetic */ void newUserOnboarding$default(AnalyticsTracker analyticsTracker, String str, String str2, String str3, Long l, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        analyticsTracker.newUserOnboarding(str, str2, str3, l, (i & 16) != 0 ? false : z2);
    }

    public static final void openGiftModal(ModelGift gift, Channel channel, String location) {
        Map<String, Object> mapEmptyMap;
        m.checkNotNullParameter(gift, "gift");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsTracker analyticsTracker = INSTANCE;
        ModelStoreListing storeListing = gift.getStoreListing();
        Map<String, Object> properties = analyticsTracker.toProperties(storeListing != null ? storeListing.getSku() : null);
        if (channel == null || (mapEmptyMap = AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channel)) == null) {
            mapEmptyMap = h0.emptyMap();
        }
        tracker.track("open_modal", h0.plus(h0.plus(h0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location), o.to("type", "gift")), mapEmptyMap), properties));
    }

    public static final void openModal(String modalName, String location, Long guildId) {
        m.checkNotNullParameter(modalName, "modalName");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("location_section", location), o.to("type", modalName));
        if (guildId != null) {
            guildId.longValue();
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guildId.longValue()));
        }
        tracker.track("open_modal", mapMutableMapOf);
    }

    public static /* synthetic */ void openModal$default(String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        openModal(str, str2, l);
    }

    public static /* synthetic */ void openUserSheet$default(AnalyticsTracker analyticsTracker, boolean z2, String str, ActivityPlatform activityPlatform, GuildMember guildMember, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            activityPlatform = null;
        }
        if ((i & 8) != 0) {
            guildMember = null;
        }
        analyticsTracker.openUserSheet(z2, str, activityPlatform, guildMember);
    }

    public static final void overlayToggled(boolean isEnabled) {
        tracker.track("mobile_overlay_toggled", g0.mapOf(o.to("enabled", Boolean.valueOf(isEnabled))));
    }

    public static /* synthetic */ void paymentFlowCompleted$default(AnalyticsTracker analyticsTracker, Traits$Location traits$Location, Traits$Subscription traits$Subscription, Traits$Payment traits$Payment, Traits$StoreSku traits$StoreSku, String str, int i, Object obj) {
        analyticsTracker.paymentFlowCompleted(traits$Location, (i & 2) != 0 ? null : traits$Subscription, (i & 4) != 0 ? null : traits$Payment, (i & 8) != 0 ? null : traits$StoreSku, (i & 16) != 0 ? null : str);
    }

    public static /* synthetic */ void paymentFlowFailed$default(AnalyticsTracker analyticsTracker, Traits$Location traits$Location, Traits$Subscription traits$Subscription, Traits$StoreSku traits$StoreSku, Traits$Payment traits$Payment, int i, Object obj) {
        if ((i & 2) != 0) {
            traits$Subscription = null;
        }
        if ((i & 4) != 0) {
            traits$StoreSku = null;
        }
        if ((i & 8) != 0) {
            traits$Payment = null;
        }
        analyticsTracker.paymentFlowFailed(traits$Location, traits$Subscription, traits$StoreSku, traits$Payment);
    }

    public static /* synthetic */ void paymentFlowStarted$default(AnalyticsTracker analyticsTracker, Traits$Location traits$Location, Traits$Subscription traits$Subscription, Traits$StoreSku traits$StoreSku, Traits$Payment traits$Payment, int i, Object obj) {
        if ((i & 2) != 0) {
            traits$Subscription = null;
        }
        if ((i & 4) != 0) {
            traits$StoreSku = null;
        }
        if ((i & 8) != 0) {
            traits$Payment = null;
        }
        analyticsTracker.paymentFlowStarted(traits$Location, traits$Subscription, traits$StoreSku, traits$Payment);
    }

    public static /* synthetic */ void paymentFlowStep$default(AnalyticsTracker analyticsTracker, Traits$Location traits$Location, Traits$Subscription traits$Subscription, String str, String str2, Traits$StoreSku traits$StoreSku, Traits$Payment traits$Payment, int i, Object obj) {
        analyticsTracker.paymentFlowStep(traits$Location, (i & 2) != 0 ? null : traits$Subscription, str, str2, (i & 16) != 0 ? null : traits$StoreSku, (i & 32) != 0 ? null : traits$Payment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void premiumUpsellViewed$default(AnalyticsTracker analyticsTracker, AnalyticsTracker$PremiumUpsellType analyticsTracker$PremiumUpsellType, Traits$Location traits$Location, Map map, Traits$Source traits$Source, int i, Object obj) {
        if ((i & 2) != 0) {
            traits$Location = null;
        }
        if ((i & 4) != 0) {
            map = h0.emptyMap();
        }
        if ((i & 8) != 0) {
            traits$Source = null;
        }
        analyticsTracker.premiumUpsellViewed(analyticsTracker$PremiumUpsellType, traits$Location, map, traits$Source);
    }

    public static final void readyPayloadReceived(Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        tracker.track("ready_payload_received", properties);
    }

    public static /* synthetic */ void registerViewed$default(AnalyticsTracker analyticsTracker, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = null;
        }
        analyticsTracker.registerViewed(modelInvite);
    }

    public static /* synthetic */ void relationshipSyncFlow$default(AnalyticsTracker analyticsTracker, String str, String str2, String str3, int i, boolean z2, boolean z3, Map map, int i2, Object obj) {
        analyticsTracker.relationshipSyncFlow(str, str2, str3, i, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? false : z3, map);
    }

    public static /* synthetic */ void reportStreamProblem$default(AnalyticsTracker analyticsTracker, ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, String str, String str2, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = null;
        }
        analyticsTracker.reportStreamProblem(modelApplicationStream, feedbackRating, str, str2, str3);
    }

    public static /* synthetic */ void searchStart$default(AnalyticsTracker analyticsTracker, SearchType searchType, Traits$Location traits$Location, Map map, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        analyticsTracker.searchStart(searchType, traits$Location, map, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void settingsPaneViewed$default(AnalyticsTracker analyticsTracker, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        analyticsTracker.settingsPaneViewed(str, str2, map);
    }

    private final void showTutorial(String tutorial) {
        tracker.track("show_tutorial", g0.mapOf(o.to("tutorial", tutorial)));
    }

    private final Long toFingerprintNumber(String str) {
        String strSubstringBefore = w.substringBefore(str, '.', "");
        if (!(strSubstringBefore.length() > 0)) {
            strSubstringBefore = null;
        }
        if (strSubstringBefore != null) {
            return s.toLongOrNull(strSubstringBefore);
        }
        return null;
    }

    private final Map<String, Object> toProperties(MediaEngine$AudioInfo mediaEngine$AudioInfo, Map<String, Object> map) {
        if (mediaEngine$AudioInfo == null) {
            return map;
        }
        map.put("audio_subsystem", mediaEngine$AudioInfo.audioSubsystem);
        map.put("audio_layer", mediaEngine$AudioInfo.audioLayer);
        return map;
    }

    private final void trackStageChannelEvent(String event, long channelId, Map<String, ? extends Object> extraProperties) {
        Map<String, Object> stageChannelMetadata = getStageChannelMetadata(channelId);
        if (stageChannelMetadata != null) {
            tracker.track(event, h0.plus(stageChannelMetadata, extraProperties));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackStageChannelEvent$default(AnalyticsTracker analyticsTracker, String str, long j, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = h0.emptyMap();
        }
        analyticsTracker.trackStageChannelEvent(str, j, map);
    }

    private final void trackUserVoiceEvent(Channel channel, long j, String str, Pair<String, Long> pair) {
        withGameProperties(j, new AnalyticsTracker$trackUserVoiceEvent$1(channel, pair, str));
    }

    public static final void userExperimentTriggered(String experimentName, int revision, int population, int bucket) {
        m.checkNotNullParameter(experimentName, "experimentName");
        tracker.track("experiment_user_triggered", h0.mutableMapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_NAME, experimentName), o.to("revision", Integer.valueOf(revision)), o.to("population", Integer.valueOf(population)), o.to("bucket", Integer.valueOf(bucket))));
    }

    public static final void welcomeScreenChannelSelected(int index, long guildId, List<String> optionDescriptions, List<Long> channelIds, String description, boolean hasCustomEmojis) {
        m.checkNotNullParameter(optionDescriptions, "optionDescriptions");
        m.checkNotNullParameter(channelIds, "channelIds");
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        HashMap map = new HashMap();
        map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        map.put("index", Integer.valueOf(index));
        map.put("options", optionDescriptions);
        map.put("options_channel_ids", channelIds);
        map.put("guild_description", description);
        map.put("has_custom_emojis", Boolean.valueOf(hasCustomEmojis));
        tracker.track("guild_welcome_screen_option_selected", map);
    }

    private final void withGameProperties(long meId, Function1<? super Map<String, Object>, Unit> onGameProps) {
        ObservableExtensionsKt.appSubscribe$default(getGameProperties(meId), AnalyticsTracker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, onGameProps, 62, (Object) null);
    }

    public final void accountLinkFailed(String errorMessage, Integer statusCode, String linkMethod, String currentStep, String platformType) {
        HashMap map = new HashMap();
        if (errorMessage != null) {
            map.put("error_message", errorMessage);
        }
        if (statusCode != null) {
            map.put("status_code", Integer.valueOf(statusCode.intValue()));
        }
        if (linkMethod != null) {
            map.put("link_method", linkMethod);
        }
        if (currentStep != null) {
            map.put("current_step", currentStep);
        }
        if (platformType != null) {
            map.put("platform_type", platformType);
        }
        tracker.track("account_link_failed", map);
    }

    public final void accountLinkStep(String previousStep, String currentStep, String sessionId, String platformType) {
        HashMap map = new HashMap();
        if (previousStep != null) {
            map.put("previous_step", previousStep);
        }
        if (currentStep != null) {
            map.put("current_step", currentStep);
        }
        if (sessionId != null) {
            map.put("session_id", sessionId);
        }
        if (platformType != null) {
            map.put("platform_type", platformType);
        }
        tracker.track("account_link_step", map);
    }

    public final void ackMessage(Channel channel, Function0<? extends Map<String, ? extends Object>> propertyProvider) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(propertyProvider, "propertyProvider");
        tracker.track(o.to("ack_messages", Long.valueOf(channel.getGuildId())), 900000L, new AnalyticsTracker$ackMessage$1(propertyProvider));
    }

    public final void activityUpdatedSpotify(String trackId, boolean hasImages) {
        m.checkNotNullParameter(trackId, "trackId");
        HashMap map = new HashMap();
        map.put("track_id", trackId);
        map.put("party_platform", Platform.SPOTIFY.getProperName());
        map.put("has_images", Boolean.valueOf(hasImages));
        tracker.track("activity_updated", map);
    }

    public final void ageGateSubmitted(long dob, String sourcePage) {
        m.checkNotNullParameter(sourcePage, "sourcePage");
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        Long lValueOf = Long.valueOf(dob);
        Locale locale = Locale.ROOT;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd", locale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String str = simpleDateFormat.format(new Date(dob));
        m.checkNotNullExpressionValue(str, "formatter.format(Date(this))");
        Long lValueOf2 = Long.valueOf(Long.parseLong(str));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM", locale);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        String str2 = simpleDateFormat2.format(new Date(dob));
        m.checkNotNullExpressionValue(str2, "formatter.format(Date(this))");
        Long lValueOf3 = Long.valueOf(Long.parseLong(str2));
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy", locale);
        simpleDateFormat3.setTimeZone(TimeZone.getTimeZone("UTC"));
        String str3 = simpleDateFormat3.format(new Date(dob));
        m.checkNotNullExpressionValue(str3, "formatter.format(Date(this))");
        TrackAgeGateSubmitted trackAgeGateSubmitted = new TrackAgeGateSubmitted(lValueOf, lValueOf2, lValueOf3, Long.valueOf(Long.parseLong(str3)));
        trackAgeGateSubmitted.e(new TrackSourceMetadata(sourcePage, null, null, null, null, 30));
        analyticsUtils$Tracker.track(trackAgeGateSubmitted);
    }

    public final void appCrashed() {
        AnalyticsUtils$Tracker.track$default(tracker, "app_crashed", null, 2, null);
    }

    public final void appExceptionThrown(String stacktrace) {
        m.checkNotNullParameter(stacktrace, "stacktrace");
        tracker.track("app_exception_thrown", g0.mapOf(o.to("stacktrace", stacktrace)));
    }

    public final void appFirstLogin() {
        Persister persister = new Persister("app_first_login", Boolean.TRUE);
        if (((Boolean) persister.get()).booleanValue()) {
            tracker.track("app_first_login", g0.mapOf(o.to("platform", "Android")));
            persister.set(Boolean.FALSE, true);
        }
    }

    public final void appNativeCrash(boolean didCrash, String exitReason, String exitDescription, String tombstoneGroupHash, String tombstoneCause) {
        tracker.track("app_native_crash", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to("did_crash", Boolean.valueOf(didCrash)), o.to("exit_reason", exitReason), o.to("exit_description", exitDescription), o.to("tombstone_hash", tombstoneGroupHash), o.to("tombstone_cause", tombstoneCause))));
    }

    public final void appNotificationDropped(Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        tracker.track("notification_dropped", properties);
    }

    public final void applicationCommandBrowserJump(long targetApplicationId) {
        tracker.track("application_command_browser_jumped", g0.mapOf(o.to("target_application_id", Long.valueOf(targetApplicationId))));
    }

    public final void applicationCommandBrowserOpened(Map<String, ? extends Object> snapshotProperties) {
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        tracker.track("application_command_browser_opened", CollectionExtensionsKt.filterNonNullValues(snapshotProperties));
    }

    public final void applicationCommandBrowserScrolled() {
        AnalyticsUtils$Tracker.track$default(tracker, "application_command_browser_scrolled", null, 2, null);
    }

    public final void applicationCommandSelected(long applicationId, long commandId, Map<String, ? extends Object> snapshotProperties) {
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        tracker.track("application_command_selected", h0.plus(h0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, Long.valueOf(applicationId)), o.to("command_id", Long.valueOf(commandId))), CollectionExtensionsKt.filterNonNullValues(snapshotProperties)));
    }

    public final void applicationCommandValidationFailure(long applicationId, long commandId, String argumentType, boolean isRequired) {
        m.checkNotNullParameter(argumentType, "argumentType");
        tracker.track("application_command_validation_failed", h0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, Long.valueOf(applicationId)), o.to("command_id", Long.valueOf(commandId)), o.to("argument_type", argumentType), o.to("is_required", Boolean.valueOf(isRequired))));
    }

    public final void attributionChange(AdjustAttribution attribution) {
        m.checkNotNullParameter(attribution, "attribution");
        tracker.track("user_attribution_received", h0.mapOf(o.to("adjust_tracker_token", attribution.trackerToken), o.to("adjust_tracker_name", attribution.trackerName), o.to("adjust_adid", attribution.adid), o.to("attribution_network", attribution.network), o.to("attribution_campaign", attribution.campaign), o.to("attribution_adgroup", attribution.adgroup), o.to("attribution_creative", attribution.creative)));
    }

    public final void autocompleteOpen(Map<String, ? extends Object> snapshotProperties, String autocompleteType, int numEmojiResults, int numStickerResults) {
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        m.checkNotNullParameter(autocompleteType, "autocompleteType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(snapshotProperties);
        linkedHashMap.put("autocomplete_type", autocompleteType);
        linkedHashMap.put("num_emoji_results", Integer.valueOf(numEmojiResults));
        linkedHashMap.put("num_sticker_results", Integer.valueOf(numStickerResults));
        tracker.track("channel_autocomplete_open", h0.toMap(linkedHashMap));
    }

    public final void autocompleteSelect(Map<String, ? extends Object> snapshotProperties, String autocompleteType, int numEmojiResults, int numStickerResults, String selectionType, String selection, Long stickerId) {
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        m.checkNotNullParameter(autocompleteType, "autocompleteType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(snapshotProperties);
        linkedHashMap.put("autocomplete_type", autocompleteType);
        linkedHashMap.put("num_emoji_results", Integer.valueOf(numEmojiResults));
        linkedHashMap.put("num_sticker_results", Integer.valueOf(numStickerResults));
        if (selectionType != null) {
            linkedHashMap.put("selection_type", selectionType);
        }
        if (selection != null) {
            linkedHashMap.put("selection", selection);
        }
        if (stickerId != null) {
            linkedHashMap.put("sticker_id", Long.valueOf(stickerId.longValue()));
        }
        tracker.track("channel_autocomplete_selected", h0.toMap(linkedHashMap));
    }

    public final void callReportProblem(long meId, String rtcConnectionId, Channel channel, Map<Long, VoiceState> guildVoiceStates, Long durationMs, String mediaSessionId, FeedbackRating feedbackRating, Integer reasonCode, String reasonDescription, StoreMediaSettings$VoiceConfiguration voiceConfig, DiscordAudioManager$AudioDevice audioOutputDevice, boolean videoHardwareScalingEnabled, String issueDetails) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildVoiceStates, "guildVoiceStates");
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        m.checkNotNullParameter(voiceConfig, "voiceConfig");
        m.checkNotNullParameter(audioOutputDevice, "audioOutputDevice");
        HashMap map = new HashMap(h0.plus(getVoiceChannelProperties$default(this, meId, channel, durationMs, guildVoiceStates, null, rtcConnectionId, 16, null), toProperties(voiceConfig)));
        map.put("media_session_id", mediaSessionId);
        map.put("audio_output_mode", audioOutputDeviceTypeToString(audioOutputDevice.type));
        String str = audioOutputDevice.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_NAME java.lang.String;
        if (str != null) {
            map.put("output_device_name", str);
        }
        map.put("rating", feedbackRating.getAnalyticsValue());
        map.put("reason_code", reasonCode);
        map.put("reason_description", reasonDescription);
        map.put("feedback", issueDetails);
        map.put("video_hardware_scaling_enabled", Boolean.valueOf(videoHardwareScalingEnabled));
        if (reasonCode != null) {
            AppLog appLog = AppLog.g;
            String strValueOf = String.valueOf(reasonCode);
            LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
            for (Map$Entry map$Entry : map.entrySet()) {
                linkedHashMap.put(map$Entry.getKey(), String.valueOf(map$Entry.getValue()));
            }
            appLog.e("call_report_problem", strValueOf, null, linkedHashMap);
        }
        tracker.track("call_report_problem", CollectionExtensionsKt.filterNonNullValues(map));
    }

    public final void captchaFailed(String reason) {
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        tracker.track("captcha_failed", g0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_REASON, reason)));
    }

    public final void changeLogEvent(String event, String version, String revision, Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(event, "event");
        m.checkNotNullParameter(version, "version");
        m.checkNotNullParameter(revision, "revision");
        m.checkNotNullParameter(properties, "properties");
        HashMap map = new HashMap();
        map.put("change_log_id", version + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + revision);
        tracker.track(event, h0.plus(map, properties));
    }

    public final void channelOpened(long channelId, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
        m.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
        tracker.track(o.to("channel_opened", Long.valueOf(channelId)), 900000L, new AnalyticsTracker$channelOpened$1(lazyPropertyProvider));
    }

    public final void chatInputComponentViewed(String type) {
        m.checkNotNullParameter(type, "type");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", type);
        tracker.track("chat_input_component_viewed", linkedHashMap);
    }

    public final void closeFirstServerTipTutorial(boolean acknowledged) {
        closeTutorial("create-first-server-tip", acknowledged);
    }

    public final void contactSyncToggled(boolean enabled, boolean phoneDiscoverable, boolean emailDiscoverable) {
        tracker.track("contact_sync_toggled", h0.mapOf(o.to("is_enabled", Boolean.valueOf(enabled)), o.to("am_discoverable_phone", Boolean.valueOf(phoneDiscoverable)), o.to("am_discoverable_email", Boolean.valueOf(emailDiscoverable))));
    }

    public final void createGuildViewed(StockGuildTemplate stockGuildTemplate, ModelGuildTemplate guildTemplate, String source) {
        Map mapMapOf;
        m.checkNotNullParameter(stockGuildTemplate, "stockGuildTemplate");
        m.checkNotNullParameter(source, "source");
        if (guildTemplate == null || (mapMapOf = h0.mapOf(o.to("guild_template_code", guildTemplate.getCode()), o.to("guild_template_name", guildTemplate.getName()), o.to("guild_template_description", guildTemplate.getDescription()), o.to("guild_template_guild_id", Long.valueOf(guildTemplate.getSourceGuildId())))) == null) {
            mapMapOf = g0.mapOf(o.to("guild_template_name", stockGuildTemplate.name()));
        }
        tracker.track("create_guild_viewed", h0.plus(mapMapOf, g0.mapOf(o.to("location_section", source))));
    }

    public final void customStatusUpdated(WidgetUserSetCustomStatusViewModel$FormState formState, Traits$Location locationTrait) {
        m.checkNotNullParameter(formState, "formState");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        toProperties(formState, map);
        tracker.track("custom_status_updated", map);
    }

    public final void deepLinkReceived(Intent intent, RouteHandlers$AnalyticsMetadata metadata, Map<String, ? extends Object> snapshotProperties) {
        m.checkNotNullParameter(intent, "intent");
        m.checkNotNullParameter(metadata, "metadata");
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        tracker.track("deep_link_received", h0.plus(CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to("type", metadata.getType()), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, metadata.getGuildId()), o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, metadata.getChannelId()), o.to("voice_action", Boolean.valueOf(intent.getStringExtra("actions.fulfillment.extra.ACTION_TOKEN") != null)), o.to("source", intent.getStringExtra("com.discord.intent.extra.EXTRA_SOURCE")))), CollectionExtensionsKt.filterNonNullValues(snapshotProperties)));
    }

    public final void dismissModal(String modalName, String location, String dismissType, Long guildId) {
        a.q0(modalName, "modalName", location, ModelAuditLogEntry.CHANGE_KEY_LOCATION, dismissType, "dismissType");
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("location_section", location), o.to("type", modalName), o.to("dismiss_type", dismissType));
        if (guildId != null) {
            guildId.longValue();
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guildId.longValue()));
        }
        tracker.track("modal_dismissed", mapMutableMapOf);
    }

    public final void echoCancellationConfigured(MediaEngine$EchoCancellationInfo info) {
        m.checkNotNullParameter(info, "info");
        tracker.track("native_echo_cancellation_configured", h0.mapOf(o.to("builtin_aec_supported_java", Boolean.valueOf(info.builtinAecSupportedJava)), o.to("builtin_aec_supported_native", Boolean.valueOf(info.builtinAecSupportedNative)), o.to("builtin_aec_requested", Boolean.valueOf(info.builtinAecRequested)), o.to("builtin_aec_enabled", Boolean.valueOf(info.builtinAecEnabled)), o.to("aec_enabled_in_settings", Boolean.valueOf(info.aecEnabledInSettings)), o.to("aec_enabled_in_native_config", Boolean.valueOf(info.aecEnabledInNativeConfig)), o.to("aec_mobile_mode", Boolean.valueOf(info.aecMobileMode)), o.to("aec_enabled_by_default", Boolean.valueOf(info.aecEnabledByDefault)), o.to("aec_mobile_mode_by_default", Boolean.valueOf(info.aecMobileModeByDefault))));
    }

    public final void emojiCategorySelected(long guildId) {
        expressionPickerCategorySelected$default(this, null, Long.valueOf(guildId), "emoji", 1, null);
    }

    public final void expressionPickerOpened(String tab, boolean badged) {
        m.checkNotNullParameter(tab, "tab");
        tracker.track("expression_picker_opened", h0.mutableMapOf(o.to("badged", Boolean.valueOf(badged)), o.to("tab", tab)));
    }

    public final void expressionPickerStickerShopViewed(boolean badged) {
        tracker.track("expression_picker_sticker_shop_viewed", h0.mutableMapOf(o.to("badged", Boolean.valueOf(badged))));
    }

    public final void expressionPickerTabClicked(String tab, boolean badged) {
        m.checkNotNullParameter(tab, "tab");
        tracker.track("expression_picker_tab_clicked", h0.mutableMapOf(o.to("badged", Boolean.valueOf(badged)), o.to("tab", tab)));
    }

    public final void expressionSuggestionsDisplayed(String suggestionTrigger) {
        m.checkNotNullParameter(suggestionTrigger, "suggestionTrigger");
        tracker.track("auto_suggest_displayed", g0.mapOf(o.to("suggestion_trigger", suggestionTrigger)));
    }

    public final void expressionSuggestionsSelected(long stickerId, String suggestionTrigger) {
        m.checkNotNullParameter(suggestionTrigger, "suggestionTrigger");
        tracker.track("auto_suggest_expression_selected", h0.mapOf(o.to("sticker_id", Long.valueOf(stickerId)), o.to("suggestion_trigger", suggestionTrigger)));
    }

    public final void externalDynamicLinkReceived(String fingerprint, String attemptId, String inviteCode, String guildTemplateCode, String authToken, boolean isBackgrounded) {
        String str = fingerprint != null ? fingerprint : inviteCode;
        if (str == null) {
            str = authToken;
        }
        if (str != null) {
            Pair[] pairArr = new Pair[6];
            pairArr[0] = o.to("fingerprint", fingerprint != null ? toFingerprintNumber(fingerprint) : null);
            pairArr[1] = o.to("attempt_id", attemptId);
            pairArr[2] = o.to("invite_code", inviteCode);
            pairArr[3] = o.to("guild_template_code", guildTemplateCode);
            pairArr[4] = o.to("has_auth_token", Boolean.valueOf(true ^ (authToken == null || t.isBlank(authToken))));
            pairArr[5] = o.to("is_backgrounded", Boolean.valueOf(isBackgrounded));
            tracker.track("external_dynamic_link_received", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(pairArr)));
        }
    }

    public final void externalShare(Uri uri) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        tracker.trackFireBase("handle_ext_share", insertUriProperties(new HashMap(), uri));
    }

    public final void externalViewClosed(String type, long durationMs) {
        m.checkNotNullParameter(type, "type");
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = o.to("type", type);
        Long lValueOf = Long.valueOf(durationMs);
        if (!(lValueOf.longValue() != 0)) {
            lValueOf = null;
        }
        pairArr[1] = o.to("duration_open_ms", lValueOf);
        analyticsUtils$Tracker.track("app_external_view_closed", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(pairArr)));
    }

    public final void failedMessageResolved(int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, FailedMessageResolutionType resolutionType, long initialAttemptTimestamp, int numRetries, Map<String, ? extends Object> snapshotProperties) {
        m.checkNotNullParameter(resolutionType, "resolutionType");
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("num_attachments", Integer.valueOf(numAttachments));
        linkedHashMap.put("max_attachment_size", Integer.valueOf(maxAttachmentSize));
        linkedHashMap.put("total_attachment_size", Integer.valueOf(totalAttachmentSize));
        linkedHashMap.put("has_image", Boolean.valueOf(hasImage));
        linkedHashMap.put("has_video", Boolean.valueOf(hasVideo));
        linkedHashMap.put("resolution_type", resolutionType.getAnalyticsValue());
        linkedHashMap.put("initial_attempt_ts", Long.valueOf(initialAttemptTimestamp));
        linkedHashMap.put("num_retries", Integer.valueOf(numRetries));
        tracker.track("failed_message_resolved", h0.plus(linkedHashMap, CollectionExtensionsKt.filterNonNullValues(snapshotProperties)));
    }

    public final void fileUploadAlertViewed(FileUploadAlertType alertType, int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, boolean isPremium, Map<String, ? extends Object> snapshotProperties) {
        m.checkNotNullParameter(alertType, "alertType");
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("alert_type", alertType.getAnalyticsValue());
        linkedHashMap.put("num_attachments", Integer.valueOf(numAttachments));
        linkedHashMap.put("max_attachment_size", Integer.valueOf(maxAttachmentSize));
        linkedHashMap.put("total_attachment_size", Integer.valueOf(totalAttachmentSize));
        linkedHashMap.put("has_image", Boolean.valueOf(hasImage));
        linkedHashMap.put("has_video", Boolean.valueOf(hasVideo));
        linkedHashMap.put("is_premium", Boolean.valueOf(isPremium));
        tracker.track("file_upload_alert_viewed", h0.plus(linkedHashMap, CollectionExtensionsKt.filterNonNullValues(snapshotProperties)));
    }

    public final void friendAddViewed(String type) {
        m.checkNotNullParameter(type, "type");
        tracker.track("friend_add_viewed", g0.mapOf(o.to("friend_add_type", type)));
    }

    public final void friendRequestFailed(CharSequence query, String username, Integer discriminator, String reason) {
        m.checkNotNullParameter(query, "query");
        m.checkNotNullParameter(username, "username");
        HashMap map = new HashMap();
        if (reason != null) {
            map.put(ModelAuditLogEntry.CHANGE_KEY_REASON, reason);
            map.put("discrim_len", Integer.valueOf(String.valueOf(discriminator).length()));
            map.put("username_len", Integer.valueOf(username.length()));
            map.put("is_email_like", Boolean.valueOf(EmailUtils.INSTANCE.isEmailLike(query.toString())));
            map.put("is_num_only", Boolean.valueOf(PhoneUtils.INSTANCE.isValidPhoneFragment(query.toString())));
        }
        tracker.track("friend_request_failed", map);
    }

    public final void friendsListViewed() {
        AnalyticsUtils$Tracker.track$default(tracker, "friends_list_viewed", null, 2, null);
    }

    public final AnalyticsUtils$Tracker getTracker() {
        return tracker;
    }

    public final void giftResolved(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        ModelStoreListing storeListing = gift.getStoreListing();
        tracker.track("gift_code_resolved", h0.plus(toProperties(storeListing != null ? storeListing.getSku() : null), h0.mapOf(o.to("gift_code", gift.getCode()), o.to("gift_code_max_uses", Integer.valueOf(gift.getMaxUses())), o.to("resolved", Boolean.TRUE))));
    }

    public final void giftResolvedFailed(String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        tracker.track("gift_code_resolved", h0.mapOf(o.to("gift_code", giftCode), o.to("resolved", Boolean.FALSE)));
    }

    public final void guildBoostPromotionClosed(long guildId, Traits$Location locationTrait, Long channelId) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        if (channelId != null) {
            map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId.longValue()));
        }
        locationTrait.serializeTo(map);
        tracker.track("premium_guild_promotion_closed", map);
    }

    public final void guildBoostPromotionOpened(long guildId, Traits$Location locationTrait, Long channelId) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        if (channelId != null) {
            map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId.longValue()));
        }
        locationTrait.serializeTo(map);
        tracker.track("premium_guild_promotion_opened", map);
    }

    public final void guildCategorySelected(long guildId) {
        expressionPickerCategorySelected$default(this, null, Long.valueOf(guildId), "sticker", 1, null);
    }

    public final void guildCreationIntentSelected(Boolean isCommunity) {
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = o.to("skipped", Boolean.valueOf(isCommunity == null));
        pairArr[1] = o.to("is_community", Boolean.valueOf(isCommunity != null ? isCommunity.booleanValue() : false));
        analyticsUtils$Tracker.track("guild_creation_intent_selected", h0.mapOf(pairArr));
    }

    public final void guildRoleSubscriptionUpsellOpened(long guildRoleSubscriptionGroupListingId, List<Long> guildRoleSubscriptionTierListingIds, boolean hasUserActiveSubscriptions, String location) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        TrackRoleSubscriptionListingUpsellPageViewedV3 trackRoleSubscriptionListingUpsellPageViewedV3 = new TrackRoleSubscriptionListingUpsellPageViewedV3(Long.valueOf(guildRoleSubscriptionGroupListingId), guildRoleSubscriptionTierListingIds, Boolean.valueOf(hasUserActiveSubscriptions));
        trackRoleSubscriptionListingUpsellPageViewedV3.e(new TrackBase(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, location, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1073741825, 2047));
        analyticsUtils$Tracker.track(trackRoleSubscriptionListingUpsellPageViewedV3);
    }

    public final void guildTemplateResolved(ModelGuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        tracker.track("guild_template_resolved", h0.mapOf(o.to("resolved", Boolean.TRUE), o.to("guild_template_code", guildTemplate.getCode()), o.to("guild_template_name", guildTemplate.getName()), o.to("guild_template_description", guildTemplate.getDescription()), o.to("guild_template_guild_id", Long.valueOf(guildTemplate.getSourceGuildId()))));
    }

    public final void guildViewed(long guildId, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
        m.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
        tracker.track(o.to("guild_viewed", Long.valueOf(guildId)), 900000L, new AnalyticsTracker$guildViewed$1(lazyPropertyProvider));
    }

    public final void impressionInviteAccept(String inviteCode) {
        if (inviteCode != null) {
            tracker.track(new TrackImpressionInviteAccept(inviteCode, null, 2));
        }
    }

    public final void inviteResolved(ModelInvite invite, String location) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("resolved", Boolean.TRUE), o.to("authenticated", Boolean.valueOf(analyticsUtils$Tracker.isAuthed$app_productionGoogleRelease())), o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location));
        if (invite != null) {
            String str = invite.code;
            m.checkNotNullExpressionValue(str, "invite.code");
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_CODE, str);
            Channel channel = invite.getChannel();
            if (channel != null) {
                mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
                mapMutableMapOf.put("channel_type", Integer.valueOf(channel.getType()));
            }
            Guild guild = invite.guild;
            if (guild != null) {
                mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guild.getId()));
            }
            User inviter = invite.getInviter();
            if (inviter != null) {
                mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_INVITER_ID, Long.valueOf(inviter.getId()));
            }
        }
        analyticsUtils$Tracker.track("resolve_invite", mapMutableMapOf);
    }

    public final void inviteSent(ModelInvite invite, Map<String, ? extends Object> snapshotProperties) {
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        tracker.track("invite_sent", toProperties(invite, CollectionExtensionsKt.filterNonNullValues(snapshotProperties)));
    }

    public final void inviteSuggestionOpened(long guildId, List<Channel> channelSuggestions, List<? extends com.discord.models.user.User> userSuggestions) {
        Collection collectionEmptyList;
        m.checkNotNullParameter(channelSuggestions, "channelSuggestions");
        m.checkNotNullParameter(userSuggestions, "userSuggestions");
        List[] listArr = new List[2];
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = channelSuggestions.iterator();
        while (it.hasNext()) {
            List<User> listZ = ((Channel) it.next()).z();
            if (listZ != null) {
                collectionEmptyList = new ArrayList(d0.t.o.collectionSizeOrDefault(listZ, 10));
                Iterator<T> it2 = listZ.iterator();
                while (it2.hasNext()) {
                    collectionEmptyList.add(Long.valueOf(((User) it2.next()).getId()));
                }
            } else {
                collectionEmptyList = n.emptyList();
            }
            r.addAll(arrayList, collectionEmptyList);
        }
        listArr[0] = arrayList;
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(userSuggestions, 10));
        Iterator<T> it3 = userSuggestions.iterator();
        while (it3.hasNext()) {
            arrayList2.add(Long.valueOf(((com.discord.models.user.User) it3.next()).getId()));
        }
        listArr[1] = arrayList2;
        Observable<R> observableG = StoreStream.Companion.getUserRelationships().observe(u.distinct(d0.t.o.flatten(n.listOf((Object[]) listArr)))).G(AnalyticsTracker$inviteSuggestionOpened$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…         }.keys\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), AnalyticsTracker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnalyticsTracker$inviteSuggestionOpened$2(channelSuggestions, userSuggestions, guildId), 62, (Object) null);
    }

    public final void joinGuildViewed() {
        AnalyticsUtils$Tracker.track$default(tracker, "join_guild_viewed", null, 2, null);
    }

    public final void launchGame(String gameName) {
        m.checkNotNullParameter(gameName, "gameName");
        HashMap map = new HashMap();
        map.put("game", gameName);
        map.put("game_platform", "android");
        tracker.track("launch_game", map);
    }

    public final void loginAttempt(boolean isSuccessful) {
        if (isSuccessful) {
            AnalyticsTracker$AdjustEventTracker.INSTANCE.trackLogin();
        }
    }

    public final void loginViewed(ModelInvite invite) {
        tracker.track("login_viewed", toProperties(invite, new LinkedHashMap()));
    }

    public final void mediaSessionJoined(Map<String, ? extends Object> properties, Channel channel) {
        m.checkNotNullParameter(properties, "properties");
        Map<String, ? extends Object> mutableMap = h0.toMutableMap(properties);
        if (channel != null) {
            mutableMap.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
            mutableMap.put("channel_type", Integer.valueOf(channel.getType()));
            long guildId = channel.getGuildId();
            if (guildId > 0) {
                mutableMap.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
            }
        }
        tracker.track("media_session_joined", mutableMap);
    }

    public final Map<String, Object> modelInviteToProperties(ModelInvite modelInvite, Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        if (modelInvite == null) {
            return properties;
        }
        String str = modelInvite.code;
        m.checkNotNullExpressionValue(str, "modelInvite.code");
        properties.put("invite_code", str);
        Channel channel = modelInvite.getChannel();
        if (channel != null) {
            properties.put("invite_channel_id", Long.valueOf(channel.getId()));
            properties.put("invite_channel_type", Integer.valueOf(channel.getType()));
        }
        Guild guild = modelInvite.guild;
        if (guild != null) {
            properties.put("invite_guild_id", Long.valueOf(guild.getId()));
        }
        User inviter = modelInvite.getInviter();
        if (inviter != null) {
            properties.put("invite_inviter_id", Long.valueOf(inviter.getId()));
        }
        return properties;
    }

    public final void nameSubmitted(int numWords, int numChars) {
        tracker.track("name_submitted", h0.mapOf(o.to("num_words", Integer.valueOf(numWords)), o.to("num_chars", Integer.valueOf(numChars))));
    }

    public final void newUserOnboarding(String flowType, String fromStep, String toStep, Long fromStepStartTime, boolean skip) {
        a.q0(flowType, "flowType", fromStep, "fromStep", toStep, "toStep");
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("flow_type", flowType), o.to("from_step", fromStep), o.to("to_step", toStep), o.to("skip", Boolean.valueOf(skip)));
        if (fromStepStartTime != null) {
            fromStepStartTime.longValue();
            mapMutableMapOf.put("seconds_on_from_step", Long.valueOf(ClockFactory.get().currentTimeMillis() - fromStepStartTime.longValue()));
        }
        tracker.track("nuo_transition", mapMutableMapOf);
    }

    public final void notificationPermissionStatus(Context context, NotificationClient$SettingsV2 notificationSettings) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(notificationSettings, "notificationSettings");
        tracker.track("notification_permission_status", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to("os_enabled", Boolean.valueOf(NotificationManagerCompat.from(context).areNotificationsEnabled())), o.to("foreground_app_enabled", Boolean.valueOf(notificationSettings.isEnabled())), o.to("background_app_enabled", Boolean.valueOf(notificationSettings.isEnabledInApp())))));
    }

    public final void notificationSettingsUpdated(ModelNotificationSettings userGuildSettings, Channel channel) {
        boolean z2;
        Object next;
        ModelMuteConfig muteConfig;
        ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride;
        m.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        HashMap map = new HashMap();
        map.put("update_type", userGuildSettings.getChannelOverrides() == null ? "guild" : "channel");
        map.put("guild_suppress_everyone", Boolean.valueOf(userGuildSettings.isSuppressEveryone()));
        map.put("guild_suppress_roles", Boolean.valueOf(userGuildSettings.isSuppressRoles()));
        map.put("guild_is_muted", Boolean.valueOf(userGuildSettings.isMuted()));
        ModelMuteConfig muteConfig2 = userGuildSettings.getMuteConfig();
        Long endTimeMs = null;
        map.put("guild_muted_until", muteConfig2 != null ? muteConfig2.getEndTimeMs() : null);
        map.put("guild_receive_mobile_push", Boolean.valueOf(userGuildSettings.isMobilePush()));
        map.put("guild_message_notification_settings", getAnalyticsValueForNotificationFrequency(Integer.valueOf(userGuildSettings.getMessageNotifications())));
        map.put("parent_id", channel != null ? Long.valueOf(channel.getParentId()) : null);
        List<ModelNotificationSettings$ChannelOverride> channelOverrides = userGuildSettings.getChannelOverrides();
        m.checkNotNullExpressionValue(channelOverrides, "userGuildSettings.channelOverrides");
        Iterator<T> it = channelOverrides.iterator();
        do {
            z2 = true;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                modelNotificationSettings$ChannelOverride = (ModelNotificationSettings$ChannelOverride) next;
                m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride, "it");
            }
        } while (!(channel != null && modelNotificationSettings$ChannelOverride.getChannelId() == channel.getId()));
        ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride2 = (ModelNotificationSettings$ChannelOverride) next;
        Boolean boolValueOf = modelNotificationSettings$ChannelOverride2 != null ? Boolean.valueOf(modelNotificationSettings$ChannelOverride2.isMuted()) : null;
        Integer numValueOf = modelNotificationSettings$ChannelOverride2 != null ? Integer.valueOf(modelNotificationSettings$ChannelOverride2.getMessageNotifications()) : null;
        if (channel != null) {
            if ((channel.getGuildId() == -1 || channel.getGuildId() == 0) ? false : true) {
                if (!m.areEqual(boolValueOf, Boolean.TRUE) && numValueOf == null) {
                    z2 = false;
                }
                map.put("channel_is_overridden", Boolean.valueOf(z2));
            }
        }
        map.put("channel_is_muted", boolValueOf);
        if (modelNotificationSettings$ChannelOverride2 != null && (muteConfig = modelNotificationSettings$ChannelOverride2.getMuteConfig()) != null) {
            endTimeMs = muteConfig.getEndTimeMs();
        }
        map.put("channel_muted_until", endTimeMs);
        map.put("channel_message_notification_settings", getAnalyticsValueForNotificationFrequency(numValueOf));
        tracker.track("notification_settings_updated", CollectionExtensionsKt.filterNonNullValues(map));
    }

    public final void oauth2AuthorizedViewed(long applicationId) {
        tracker.track("oauth2_authorize_viewed", g0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, Long.valueOf(applicationId))));
    }

    public final void openCallFeedbackSheet(long guildId, long channelId, int channelType) {
        HashMap map = new HashMap();
        map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId));
        map.put("channel_type", Integer.valueOf(channelType));
        map.put("type", "Call Session Feedback");
        tracker.track("open_popout", map);
    }

    public final void openCustomEmojiPopout(long guildId, long emojiId, boolean isPremium, boolean joinedSourceGuild, boolean sourceGuildPrivate, Map<String, ? extends Object> channelProperties) {
        String str;
        m.checkNotNullParameter(channelProperties, "channelProperties");
        boolean z2 = (!isPremium && joinedSourceGuild) || !(isPremium || joinedSourceGuild || sourceGuildPrivate);
        boolean z3 = (isPremium || joinedSourceGuild || !sourceGuildPrivate) ? false : true;
        if (z2) {
            str = " (Upsell)";
        } else {
            str = z3 ? " (Soft Upsell)" : "";
        }
        tracker.track("open_popout", h0.plus(channelProperties, h0.mapOf(o.to("type", "Custom Emoji Popout" + str), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId)), o.to("emoji_id", Long.valueOf(emojiId)))));
    }

    public final void openGuildProfileSheet(long guildId) {
        HashMap map = new HashMap();
        map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        map.put("type", "Guild Profile");
        tracker.track("open_popout", map);
    }

    public final void openGuildScheduledEventSheet(long guildId, int numEvents) {
        tracker.track("open_modal", h0.mapOf(o.to("type", "Guild Events Modal"), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId)), o.to("guild_events_count", Integer.valueOf(numEvents))));
    }

    public final void openPopout(String popoutName, String location) {
        m.checkNotNullParameter(popoutName, "popoutName");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        tracker.track("open_popout", h0.mapOf(o.to("location_section", location), o.to("type", popoutName)));
    }

    public final void openUnicodeEmojiPopout(long guildId, Map<String, ? extends Object> channelProperties) {
        m.checkNotNullParameter(channelProperties, "channelProperties");
        tracker.track("open_popout", h0.plus(channelProperties, h0.mapOf(o.to("type", "Standard Emoji Popout"), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId)))));
    }

    public final void openUserSheet(boolean profileHasPremiumCustomization, String gameName, ActivityPlatform gamePlatform, GuildMember guildMember) {
        HashMap map = new HashMap();
        map.put("profile_has_nitro_customization", Boolean.valueOf(profileHasPremiumCustomization));
        if (gameName != null) {
            map.put("game_name", gameName);
        }
        if (gamePlatform != null) {
            String strName = gamePlatform.name();
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            map.put("game_platform", lowerCase);
        }
        map.put("type", "User Sheet");
        if (guildMember != null) {
            String nick = guildMember.getNick();
            map.put("has_nickname", Boolean.valueOf(!(nick == null || nick.length() == 0)));
            map.put("has_guild_member_avatar", Boolean.valueOf(guildMember.hasAvatar()));
            map.put("has_guild_member_banner", Boolean.valueOf(guildMember.hasBanner()));
            String bio = guildMember.getBio();
            map.put("has_guild_member_bio", Boolean.valueOf(!(bio == null || bio.length() == 0)));
        }
        tracker.track("open_popout", map);
    }

    public final void openUserStatusSheet(Traits$Location locationTrait, boolean hasCustomStatus) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        map.put("type", "User Status Menu");
        map.put("has_custom_status", Boolean.valueOf(hasCustomStatus));
        tracker.track("open_popout", map);
    }

    public final void overlayVoiceClosed(Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        tracker.track("mobile_overlay_closed", h0.plus(g0.mapOf(o.to("type", "voice")), properties));
    }

    public final void overlayVoiceOpened(Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        tracker.track("mobile_overlay_opened", h0.plus(g0.mapOf(o.to("type", "voice")), properties));
    }

    public final void paymentFlowCompleted(Traits$Location locationTrait, Traits$Subscription subscriptionTrait, Traits$Payment paymentTrait, Traits$StoreSku storeSkuTrait, String paymentType) {
        HashMap map = new HashMap();
        if (locationTrait != null) {
            locationTrait.serializeTo(map);
        }
        if (subscriptionTrait != null) {
            subscriptionTrait.serializeTo(map);
        }
        if (paymentTrait != null) {
            paymentTrait.serializeTo(map);
        }
        if (storeSkuTrait != null) {
            storeSkuTrait.serializeTo(map);
        }
        if (paymentType != null) {
            map.put("payment_type", paymentType);
        }
        tracker.track("payment_flow_completed", map);
    }

    public final void paymentFlowFailed(Traits$Location locationTrait, Traits$Subscription subscriptionTrait, Traits$StoreSku storeSkuTrait, Traits$Payment paymentTrait) {
        HashMap map = new HashMap();
        if (locationTrait != null) {
            locationTrait.serializeTo(map);
        }
        if (subscriptionTrait != null) {
            subscriptionTrait.serializeTo(map);
        }
        if (storeSkuTrait != null) {
            storeSkuTrait.serializeTo(map);
        }
        if (paymentTrait != null) {
            paymentTrait.serializeTo(map);
        }
        tracker.track("payment_flow_failed", map);
    }

    public final void paymentFlowStarted(Traits$Location locationTrait, Traits$Subscription subscriptionTrait, Traits$StoreSku storeSkuTrait, Traits$Payment paymentTrait) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        if (subscriptionTrait != null) {
            subscriptionTrait.serializeTo(map);
        }
        if (storeSkuTrait != null) {
            storeSkuTrait.serializeTo(map);
        }
        if (paymentTrait != null) {
            paymentTrait.serializeTo(map);
        }
        tracker.track("payment_flow_started", map);
    }

    public final void paymentFlowStep(Traits$Location locationTrait, Traits$Subscription subscriptionTrait, String toStep, String fromStep, Traits$StoreSku storeSkuTrait, Traits$Payment paymentTrait) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        m.checkNotNullParameter(toStep, "toStep");
        m.checkNotNullParameter(fromStep, "fromStep");
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("to_step", toStep), o.to("from_step", fromStep));
        locationTrait.serializeTo(mapMutableMapOf);
        if (subscriptionTrait != null) {
            subscriptionTrait.serializeTo(mapMutableMapOf);
        }
        if (storeSkuTrait != null) {
            storeSkuTrait.serializeTo(mapMutableMapOf);
        }
        if (paymentTrait != null) {
            paymentTrait.serializeTo(mapMutableMapOf);
        }
        tracker.track("payment_flow_step", mapMutableMapOf);
    }

    public final void permissionsAcked(String permissionType, boolean granted) {
        String str;
        m.checkNotNullParameter(permissionType, "permissionType");
        if (granted) {
            str = "accepted";
        } else {
            if (granted) {
                throw new NoWhenBranchMatchedException();
            }
            str = "denied";
        }
        tracker.track("permissions_acked", h0.mapOf(o.to("type", permissionType), o.to("action", str)));
    }

    public final void permissionsRequested(String permissionType) {
        m.checkNotNullParameter(permissionType, "permissionType");
        tracker.track("permissions_requested", g0.mapOf(o.to("type", permissionType)));
    }

    public final void premiumSettingsOpened(Traits$Location locationTrait) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        tracker.track("premium_promotion_opened", map);
    }

    public final void premiumUpsellViewed(AnalyticsTracker$PremiumUpsellType type, Traits$Location locationTrait, Map<String, ? extends Object> properties, Traits$Source sourceTrait) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(properties, "properties");
        Map<String, ? extends Object> mutableMap = h0.toMutableMap(properties);
        mutableMap.put("type", type.getAnalyticsName());
        if (locationTrait != null) {
            locationTrait.serializeTo(mutableMap);
        }
        if (sourceTrait != null) {
            sourceTrait.serializeTo(mutableMap);
        }
        tracker.track("premium_upsell_viewed", mutableMap);
    }

    public final void promotedToSpeaker(long channelId) {
        trackStageChannelEvent$default(this, "promoted_to_speaker", channelId, null, 4, null);
    }

    public final void quickSwitcherOpen() {
        tracker.track("quickswitcher_opened", g0.mapOf(o.to("source", "ANDROID_QUICK")));
    }

    public final void quickSwitcherSelect(WidgetGlobalSearchModel model, WidgetGlobalSearchModel$ItemDataPayload selected, int index) {
        String str;
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(selected, "selected");
        int searchType = model.getSearchType();
        if (searchType == 0) {
            str = "GENERAL";
        } else if (searchType == 1) {
            str = "USER";
        } else if (searchType == 2) {
            str = "TEXT_CHANNEL";
        } else if (searchType != 3) {
            str = searchType != 4 ? "" : "VOICE_CHANNEL";
        } else {
            str = "GUILD";
        }
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("query_length", Integer.valueOf(model.getFilter().length())), o.to("query_mode", str), o.to("num_results_total", Integer.valueOf(model.getData().size())), o.to("selected_index", Integer.valueOf(index)));
        if (selected instanceof WidgetGlobalSearchModel$ItemChannel) {
            WidgetGlobalSearchModel$ItemChannel widgetGlobalSearchModel$ItemChannel = (WidgetGlobalSearchModel$ItemChannel) selected;
            mapMutableMapOf.put("selected_channel_id", Long.valueOf(widgetGlobalSearchModel$ItemChannel.getChannel().getId()));
            mapMutableMapOf.put("selected_type", widgetGlobalSearchModel$ItemChannel.getChannel().getType() == 3 ? "GROUP_DM" : "TEXT_CHANNEL");
        } else if (selected instanceof WidgetGlobalSearchModel$ItemUser) {
            mapMutableMapOf.put("selected_user_id", Long.valueOf(((WidgetGlobalSearchModel$ItemUser) selected).getUser().getId()));
            mapMutableMapOf.put("selected_type", "USER");
        } else {
            if (!(selected instanceof WidgetGlobalSearchModel$ItemGuild)) {
                AppLog appLog = AppLog.g;
                StringBuilder sbU = a.U("Unknown QuickSwitcher type: ");
                sbU.append(selected.getType());
                Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
                return;
            }
            mapMutableMapOf.put("selected_guild_id", Long.valueOf(((WidgetGlobalSearchModel$ItemGuild) selected).getGuild().getId()));
            mapMutableMapOf.put("selected_type", "GUILD");
        }
        tracker.track("quickswitcher_result_selected", mapMutableMapOf);
    }

    public final void registerTransition(String step, String actionType, String identityType, List<String> details, Map<String, ? extends Object> additionalProps) {
        Map<String, ? extends Object> linkedHashMap;
        m.checkNotNullParameter(step, "step");
        m.checkNotNullParameter(actionType, "actionType");
        if (additionalProps == null || (linkedHashMap = h0.toMutableMap(additionalProps)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("step", step);
        if (identityType != null) {
            linkedHashMap.put("identity_type", identityType);
        }
        linkedHashMap.put("action_type", actionType);
        if (details != null) {
            linkedHashMap.put("action_details", details);
        }
        tracker.track("register_transition", linkedHashMap);
    }

    public final void registerViewed(ModelInvite invite) {
        tracker.track("register_viewed", toProperties(invite, h0.mutableMapOf(o.to("is_unclaimed", Boolean.FALSE))));
    }

    public final void registered(boolean isSuccessful) {
        if (isSuccessful) {
            AnalyticsTracker$AdjustEventTracker.INSTANCE.trackRegister();
        }
    }

    public final void relationshipSyncFlow(String type, String fromStep, String toStep, int secondsOnFromStep, boolean skip, boolean back, Map<String, ? extends Object> additionalProps) {
        Map<String, ? extends Object> linkedHashMap;
        a.q0(type, "type", fromStep, "fromStep", toStep, "toStep");
        if (additionalProps == null || (linkedHashMap = h0.toMutableMap(additionalProps)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put("flow_type", type);
        linkedHashMap.put("from_step", fromStep);
        linkedHashMap.put("to_step", toStep);
        linkedHashMap.put("skip", Boolean.valueOf(skip));
        linkedHashMap.put("back", Boolean.valueOf(back));
        linkedHashMap.put("seconds_on_from_step", Integer.valueOf(secondsOnFromStep));
        tracker.track("relationship_sync_flow", linkedHashMap);
    }

    public final void reportStreamProblem(ModelApplicationStream stream, FeedbackRating rating, String reason, String mediaSessionId, String issueDetails) {
        m.checkNotNullParameter(stream, "stream");
        HashMap map = new HashMap();
        map.put("streamer_user_id", String.valueOf(stream.getOwnerId()));
        map.put("stream_channel_id", String.valueOf(stream.getChannelId()));
        if (stream instanceof ModelApplicationStream$GuildStream) {
            map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(((ModelApplicationStream$GuildStream) stream).getGuildId()));
        }
        map.put("rating", rating != null ? rating.getAnalyticsValue() : null);
        map.put("media_session_id", mediaSessionId);
        map.put(ModelAuditLogEntry.CHANGE_KEY_REASON, reason);
        map.put("feedback", issueDetails);
        tracker.track("stream_report_problem", CollectionExtensionsKt.filterNonNullValues(map));
    }

    public final void reportTosViolation(int reason, long channelId, long messageId, List<Long> mutualGuildIds) {
        m.checkNotNullParameter(mutualGuildIds, "mutualGuildIds");
        HashMap map = new HashMap();
        map.put("reason_enum", Integer.valueOf(reason));
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId));
        map.put("message_id", Long.valueOf(messageId));
        map.put("location_object", "android_report_modal");
        map.put("mutual_guild_ids", mutualGuildIds);
        tracker.track("message_reported", CollectionExtensionsKt.filterNonNullValues(map));
    }

    public final void requestToSpeakInitiated(long channelId) {
        trackStageChannelEvent$default(this, "request_to_speak_initiated", channelId, null, 4, null);
    }

    public final void reviewRequestAccepted() {
        dismissModal$default(this, "App Store Ratings Prompt", "auto", "accepted", null, 8, null);
    }

    public final void reviewRequestDismissed() {
        dismissModal$default(this, "App Store Ratings Prompt", "auto", "dismissed", null, 8, null);
    }

    public final void reviewRequestTriggered() {
        openModal$default("App Store Ratings Prompt", "auto", null, 4, null);
    }

    public final void searchResultSelected(SearchType searchType, Traits$Location locationTrait, Traits$Source sourceTrait, int totalResultsCount, Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(searchType, "searchType");
        m.checkNotNullParameter(properties, "properties");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("search_type", searchType.name());
        linkedHashMap.put("total_results", Integer.valueOf(totalResultsCount));
        if (locationTrait != null) {
            locationTrait.serializeTo(linkedHashMap);
        }
        if (sourceTrait != null) {
            sourceTrait.serializeTo(linkedHashMap);
        }
        tracker.track("search_result_selected", h0.plus(linkedHashMap, CollectionExtensionsKt.filterNonNullValues(properties)));
    }

    public final void searchResultViewed(SearchType searchType, int totalResultsCount, Integer lockedResultsCount, Traits$Location locationTrait, Map<String, ? extends Object> properties, boolean throttle) {
        m.checkNotNullParameter(searchType, "searchType");
        m.checkNotNullParameter(properties, "properties");
        AnalyticsTracker$searchResultViewed$propertyProvider$1 analyticsTracker$searchResultViewed$propertyProvider$1 = new AnalyticsTracker$searchResultViewed$propertyProvider$1(searchType, totalResultsCount, lockedResultsCount, locationTrait, properties);
        if (throttle) {
            tracker.track(new Pair<>("search_result_viewed", null), 1000L, analyticsTracker$searchResultViewed$propertyProvider$1);
        } else {
            tracker.track("search_result_viewed", analyticsTracker$searchResultViewed$propertyProvider$1.invoke());
        }
    }

    public final void searchResultsEmpty(SearchType searchType, Traits$Location locationTrait, Map<String, ? extends Object> properties, boolean throttle) {
        m.checkNotNullParameter(searchType, "searchType");
        m.checkNotNullParameter(properties, "properties");
        AnalyticsTracker$searchResultsEmpty$propertyProvider$1 analyticsTracker$searchResultsEmpty$propertyProvider$1 = new AnalyticsTracker$searchResultsEmpty$propertyProvider$1(searchType, locationTrait, properties);
        if (throttle) {
            tracker.track(new Pair<>("search_result_empty", null), 1000L, analyticsTracker$searchResultsEmpty$propertyProvider$1);
        } else {
            tracker.track("search_result_empty", analyticsTracker$searchResultsEmpty$propertyProvider$1.invoke());
        }
    }

    public final void searchStart(SearchType searchType, Traits$Location locationTrait, Map<String, ? extends Object> properties, boolean throttle) {
        m.checkNotNullParameter(searchType, "searchType");
        m.checkNotNullParameter(properties, "properties");
        AnalyticsTracker$searchStart$propertyProvider$1 analyticsTracker$searchStart$propertyProvider$1 = new AnalyticsTracker$searchStart$propertyProvider$1(searchType, locationTrait, properties);
        if (throttle) {
            tracker.track(new Pair<>("search_started", null), 1000L, analyticsTracker$searchStart$propertyProvider$1);
        } else {
            tracker.track("search_started", analyticsTracker$searchStart$propertyProvider$1.invoke());
        }
    }

    public final void settingsPaneViewed(String settingsType, String pane, Map<String, ? extends Object> extraProperties) {
        m.checkNotNullParameter(settingsType, "settingsType");
        m.checkNotNullParameter(pane, "pane");
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("settings_type", settingsType), o.to("destination_pane", pane));
        if (extraProperties != null) {
            mapMutableMapOf.putAll(extraProperties);
        }
        tracker.track("settings_pane_viewed", mapMutableMapOf);
    }

    public final void showFirstServerTipTutorial() {
        showTutorial("create-first-server-tip");
    }

    public final void smartLockAutoLogin() {
        AnalyticsUtils$Tracker.track$default(tracker, "smart_lock_auto_login", null, 2, null);
    }

    public final void smartLockLogin() {
        AnalyticsUtils$Tracker.track$default(tracker, "smart_lock_login", null, 2, null);
    }

    public final void smartLockLoginCredentialsFailed() {
        AnalyticsUtils$Tracker.track$default(tracker, "smart_lock_login_credentials_failed", null, 2, null);
    }

    public final void stickerPackCategorySelected(long stickerPackId) {
        expressionPickerCategorySelected$default(this, Long.valueOf(stickerPackId), null, "sticker", 2, null);
    }

    public final void stickerPackViewAllViewed(Sticker sticker, String type, String location, Traits$Location locationTrait) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        Long packId = sticker.getPackId();
        m.checkNotNull(packId);
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("sticker_id", Long.valueOf(sticker.getId())), o.to("sticker_pack_id", packId), o.to("type", type));
        if (location != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        }
        locationTrait.serializeTo(mapMutableMapOf);
        tracker.track("open_popout", mapMutableMapOf);
    }

    public final void stickerPopoutOpened(long stickerPackId, String location, Traits$Location locationTrait) {
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(locationTrait, "locationTrait");
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location), o.to("sticker_pack_id", Long.valueOf(stickerPackId)), o.to("type", "Sticker Upsell Sheet"));
        locationTrait.serializeTo(mapMutableMapOf);
        tracker.track("open_popout", mapMutableMapOf);
    }

    public final void stickerSuggestionsEnabledToggled(boolean enabled, Traits$Location location) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("enabled", Boolean.valueOf(enabled));
        if (location != null) {
            linkedHashMap.put(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        }
        tracker.track("sticker_suggestions_enabled_toggled", linkedHashMap);
    }

    public final void surveyViewed(String surveyId) {
        m.checkNotNullParameter(surveyId, "surveyId");
        Bundle bundle = new Bundle();
        bundle.putString("survey_id", surveyId);
        getFirebaseAnalytics().f3109b.c(null, "Survey_Viewed", bundle, false, true, null);
    }

    public final void textInVoiceOpened(long channelId, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
        m.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
        tracker.track(o.to("text_in_voice_opened", Long.valueOf(channelId)), 900000L, new AnalyticsTracker$textInVoiceOpened$1(lazyPropertyProvider));
    }

    public final void threadBrowserTabChanged(Map<String, ? extends Object> snapshotProperties, String type) {
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        m.checkNotNullParameter(type, "type");
        tracker.track("thread_browser_tab_changed", CollectionExtensionsKt.filterNonNullValues(h0.plus(snapshotProperties, g0.mapOf(o.to("type", type)))));
    }

    public final void threadCreationStarted(long channelId, long guildId, String location) {
        HashMap map = new HashMap();
        map.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId));
        map.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        map.put(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        tracker.track("thread_creation_started", CollectionExtensionsKt.filterNonNullValues(map));
    }

    public final void threadNotificationSettingsUpdated(Map<String, ? extends Object> threadProperties, boolean hasInteractedWith, boolean parentIsMuted, int parentNotificationSetting, int oldFlags, int flags) {
        m.checkNotNullParameter(threadProperties, "threadProperties");
        HashMap map = new HashMap(threadProperties);
        map.put("has_interacted_with_thread", Boolean.valueOf(hasInteractedWith));
        map.put("parent_is_muted", Boolean.valueOf(parentIsMuted));
        ThreadMemberFlags threadMemberFlags = ThreadMemberFlags.INSTANCE;
        map.put("old_thread_notification_setting", getAnalyticsValueForThreadNotificationFrequency(threadMemberFlags, oldFlags));
        map.put("new_thread_notification_setting", getAnalyticsValueForThreadNotificationFrequency(threadMemberFlags, flags));
        map.put("parent_notification_setting", getAnalyticsValueForNotificationFrequency(Integer.valueOf(parentNotificationSetting)));
        tracker.track("notification_settings_updated", CollectionExtensionsKt.filterNonNullValues(map));
    }

    public final void trackAccountLinkStep(String platformType, String previousStep) {
        m.checkNotNullParameter(platformType, "platformType");
        m.checkNotNullParameter(previousStep, "previousStep");
        tracker.track(new TrackAccountLinkStep(previousStep, null, null, platformType, 6));
    }

    public final void trackConnectedAccountInitiated(String platformType, String location) {
        m.checkNotNullParameter(platformType, "platformType");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        AnalyticsUtils$Tracker analyticsUtils$Tracker = tracker;
        TrackConnectedAccountInitiated trackConnectedAccountInitiated = new TrackConnectedAccountInitiated(platformType);
        trackConnectedAccountInitiated.e(new TrackBase(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, location, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1073741825, 2047));
        analyticsUtils$Tracker.track(trackConnectedAccountInitiated);
    }

    public final void trackDismissibleContentDismissed(String type) {
        m.checkNotNullParameter(type, "type");
        tracker.track(new TrackDismissibleContentDismissed(type, null, null, null, null, 30));
    }

    public final void trackForceUpdatePasswordSucceeded() {
        tracker.track(new TrackForceUpdatePasswordSucceeded());
    }

    public final void trackGuildIdentityMarketingSheet() {
        tracker.track("tooltip_viewed", g0.mapOf(o.to("type", "per server identity tooltip")));
    }

    public final void trackReportIssueWithAutoMod(String decisionId, long messageId, CharSequence feedbackType, String content) {
        m.checkNotNullParameter(decisionId, "decisionId");
        m.checkNotNullParameter(feedbackType, "feedbackType");
        m.checkNotNullParameter(content, "content");
        tracker.track(new TrackGuildAutomodFeedback(decisionId, String.valueOf(messageId), null, feedbackType, content, 4));
    }

    public final void trackStartStageOpened(boolean canStartPublicStage, Long stageInstanceId, Long guildId) {
        tracker.track("start_stage_opened", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to("can_start_public_stage", Boolean.valueOf(canStartPublicStage)), o.to("stage_instance_id", stageInstanceId), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, guildId))));
    }

    public final void unhandledUrl(String url) {
        m.checkNotNullParameter(url, "url");
        tracker.trackFireBase("unhandled_uri", g0.mapOf(o.to("url", url)));
    }

    public final void updateNotifications(boolean enabled) {
        tracker.track("local_settings_updated", g0.mapOf(o.to("notifications_enabled", Boolean.valueOf(enabled))));
    }

    public final void updateNotificationsInApp(boolean enabled) {
        tracker.track("local_settings_updated", g0.mapOf(o.to("notifications_in_app_enabled", Boolean.valueOf(enabled))));
    }

    public final void upgradePremiumYearlyClosed(Traits$Location locationTrait) {
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        tracker.track("upgrade_premium_yearly_closed", map);
    }

    public final void userListening(long meId, Set<Long> speakingList, String inputMode, Channel channel) {
        m.checkNotNullParameter(speakingList, "speakingList");
        m.checkNotNullParameter(inputMode, "inputMode");
        m.checkNotNullParameter(channel, "channel");
        boolean z2 = true;
        if (!(speakingList instanceof Collection) || !speakingList.isEmpty()) {
            Iterator<T> it = speakingList.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
            } while (!(((Number) it.next()).longValue() != meId));
        } else {
            z2 = false;
            break;
        }
        if (z2) {
            trackUserVoiceEvent(channel, meId, inputMode, o.to("start_listening", Long.valueOf(channel.getGuildId())));
        }
    }

    public final void userReportSubmitted(String reportName, long guildId, String reason, String feedback, boolean skipped) {
        m.checkNotNullParameter(reportName, "reportName");
        tracker.track("user_report_submitted", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to("report_name", reportName), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId)), o.to(ModelAuditLogEntry.CHANGE_KEY_REASON, reason), o.to("feedback", feedback), o.to("skipped", Boolean.valueOf(skipped)))));
    }

    public final void userSpeaking(long meId, Set<Long> speakingList, String inputMode, Channel channel) {
        m.checkNotNullParameter(speakingList, "speakingList");
        m.checkNotNullParameter(inputMode, "inputMode");
        m.checkNotNullParameter(channel, "channel");
        if (speakingList.contains(Long.valueOf(meId))) {
            trackUserVoiceEvent(channel, meId, inputMode, o.to("start_speaking", Long.valueOf(channel.getGuildId())));
        }
    }

    public final void videoEventTimes(String eventType, Long gatewayConnection, Long gatewayHello, Long voiceConnection, Long streamRequested, Long streamConnection, Long streamFirstFrame, Long videoFirstFrame, Long mediaEngineConnection, Long connectionVideoFirstFrame, Long connectionStreamFirstFrame) {
        m.checkNotNullParameter(eventType, "eventType");
        Pair[] pairArr = new Pair[11];
        pairArr[0] = o.to("event_time_name", eventType);
        pairArr[1] = o.to("gateway_connection", Long.valueOf(gatewayConnection != null ? gatewayConnection.longValue() : -1L));
        pairArr[2] = o.to("gateway_hello", Long.valueOf(gatewayHello != null ? gatewayHello.longValue() : -1L));
        pairArr[3] = o.to("voice_connection", Long.valueOf(voiceConnection != null ? voiceConnection.longValue() : -1L));
        pairArr[4] = o.to("stream_requested", Long.valueOf(streamRequested != null ? streamRequested.longValue() : -1L));
        pairArr[5] = o.to("stream_connection", Long.valueOf(streamConnection != null ? streamConnection.longValue() : -1L));
        pairArr[6] = o.to("stream_first_frame", Long.valueOf(streamFirstFrame != null ? streamFirstFrame.longValue() : -1L));
        pairArr[7] = o.to("video_first_frame", Long.valueOf(videoFirstFrame != null ? videoFirstFrame.longValue() : -1L));
        pairArr[8] = o.to("media_engine_connection", Long.valueOf(mediaEngineConnection != null ? mediaEngineConnection.longValue() : -1L));
        pairArr[9] = o.to("connection_video_first_frame", Long.valueOf(connectionVideoFirstFrame != null ? connectionVideoFirstFrame.longValue() : -1L));
        pairArr[10] = o.to("connection_stream_first_frame", Long.valueOf(connectionStreamFirstFrame != null ? connectionStreamFirstFrame.longValue() : -1L));
        tracker.track("video_event_times", h0.mapOf(pairArr));
    }

    public final void videoInputsUpdate(long meId, Channel channel, Map<Long, VoiceState> guildVoiceStates, VideoInputDeviceDescription videoInputDevice, boolean isScreenSharing, String mediaSessionId) {
        String str;
        m.checkNotNullParameter(guildVoiceStates, "guildVoiceStates");
        if (channel == null) {
            return;
        }
        Map voiceChannelProperties$default = getVoiceChannelProperties$default(this, meId, channel, null, guildVoiceStates, videoInputDevice, null, 36, null);
        String str2 = ChatInputComponentTypes.CAMERA;
        if (isScreenSharing) {
            str = "screen";
        } else {
            str = videoInputDevice != null ? ChatInputComponentTypes.CAMERA : "none";
        }
        voiceChannelProperties$default.put("video_input_type", str);
        String[] strArr = new String[2];
        strArr[0] = isScreenSharing ? "screen" : null;
        if (videoInputDevice == null) {
            str2 = null;
        }
        strArr[1] = str2;
        voiceChannelProperties$default.put("enabled_inputs", n.listOfNotNull((Object[]) strArr));
        voiceChannelProperties$default.put("media_session_id", mediaSessionId);
        withGameProperties(meId, new AnalyticsTracker$videoInputsUpdate$1(voiceChannelProperties$default));
    }

    public final void videoLayoutToggled(String videoLayout, long meId, Channel channel) {
        m.checkNotNullParameter(videoLayout, "videoLayout");
        if (channel == null) {
            return;
        }
        Map voiceChannelProperties$default = getVoiceChannelProperties$default(this, meId, channel, null, null, null, null, 60, null);
        voiceChannelProperties$default.put("video_layout", videoLayout);
        tracker.track("video_layout_toggled", CollectionExtensionsKt.filterNonNullValues(voiceChannelProperties$default));
    }

    public final void videoStreamEnded(Map<String, ? extends Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        tracker.track("video_stream_ended", CollectionExtensionsKt.filterNonNullValues(properties));
    }

    public final void viewedDisableCommunicationModal(long guildId, long targetUserId) {
        tracker.track("open_modal", h0.mapOf(o.to("type", "Set Communication Disabled Modal"), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId)), o.to("other_user_id", Long.valueOf(targetUserId))));
    }

    public final void viewedEnableCommunicationModal(long guildId, long targetUserId) {
        tracker.track("open_modal", h0.mapOf(o.to("type", "Clear Communication Disabled Modal"), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId)), o.to("other_user_id", Long.valueOf(targetUserId))));
    }

    public final void voiceAudioOutputModeSelected(long meId, String rtcConnectionId, String mediaSessionId, Channel channel, DiscordAudioManager$DeviceTypes fromAudioOutputMode, DiscordAudioManager$DeviceTypes toAudioOutputMode) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(fromAudioOutputMode, "fromAudioOutputMode");
        m.checkNotNullParameter(toAudioOutputMode, "toAudioOutputMode");
        Map mapMutableMapOf = h0.mutableMapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId())), o.to("from_audio_output_mode", audioOutputDeviceTypeToString(fromAudioOutputMode)), o.to("to_audio_output_mode", audioOutputDeviceTypeToString(toAudioOutputMode)));
        if (rtcConnectionId != null) {
            mapMutableMapOf.put("rtc_connection_id", rtcConnectionId);
        }
        if (mediaSessionId != null) {
            mapMutableMapOf.put("media_session_id", mediaSessionId);
        }
        tracker.track("voice_audio_output_mode_selected", CollectionExtensionsKt.filterNonNullValues(mapMutableMapOf));
    }

    public final void voiceChannelJoin(long meId, String rtcConnectionId, Channel channel, Map<Long, VoiceState> guildVoiceStates, VideoInputDeviceDescription videoInputDevice, Integer networkType, Long stageInstanceId, Long guildScheduledEventId) {
        m.checkNotNullParameter(rtcConnectionId, "rtcConnectionId");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildVoiceStates, "guildVoiceStates");
        Map voiceChannelProperties$default = getVoiceChannelProperties$default(this, meId, channel, null, guildVoiceStates, videoInputDevice, rtcConnectionId, 4, null);
        voiceChannelProperties$default.put("connection_type", getNetworkTypeAnalyticsValue(networkType));
        voiceChannelProperties$default.put("stage_instance_id", stageInstanceId);
        voiceChannelProperties$default.put("guild_scheduled_event_id", guildScheduledEventId);
        withGameProperties(meId, new AnalyticsTracker$voiceChannelJoin$1(voiceChannelProperties$default));
    }

    public final void voiceChannelLeave(long meId, String rtcConnectionId, Channel channel, Map<Long, VoiceState> guildVoiceStates, String mediaSessionId, Map<String, ? extends Object> voiceProps, Long durationMs, Long stageInstanceId, Long guildScheduledEventId) {
        m.checkNotNullParameter(rtcConnectionId, "rtcConnectionId");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildVoiceStates, "guildVoiceStates");
        m.checkNotNullParameter(voiceProps, "voiceProps");
        Map voiceChannelProperties$default = getVoiceChannelProperties$default(this, meId, channel, durationMs, guildVoiceStates, null, rtcConnectionId, 16, null);
        voiceChannelProperties$default.putAll(voiceProps);
        voiceChannelProperties$default.put("media_session_id", mediaSessionId);
        voiceChannelProperties$default.put("stage_instance_id", stageInstanceId);
        voiceChannelProperties$default.put("guild_scheduled_event_id", guildScheduledEventId);
        withGameProperties(meId, new AnalyticsTracker$voiceChannelLeave$1(voiceChannelProperties$default));
    }

    public final void voiceConnectionFailure(Map<String, ? extends Object> properties, Channel channel, String cloudflareBestRegion) {
        m.checkNotNullParameter(properties, "properties");
        Map<String, ? extends Object> mutableMap = h0.toMutableMap(properties);
        addVoiceConnectionProperties(mutableMap, channel, cloudflareBestRegion);
        tracker.track("voice_connection_failure", mutableMap);
    }

    public final void voiceConnectionSuccess(Map<String, ? extends Object> properties, MediaEngine$AudioInfo audioInfo, Channel channel, String cloudflareBestRegion) {
        m.checkNotNullParameter(properties, "properties");
        m.checkNotNullParameter(audioInfo, "audioInfo");
        Map<String, ? extends Object> mutableMap = h0.toMutableMap(properties);
        addVoiceConnectionProperties(mutableMap, channel, cloudflareBestRegion);
        toProperties(audioInfo, mutableMap);
        tracker.track("voice_connection_success", mutableMap);
    }

    public final void voiceDisconnect(Map<String, ? extends Object> properties, StoreMediaSettings$VoiceConfiguration voiceConfig, Channel channel, String cloudflareBestRegion) {
        m.checkNotNullParameter(properties, "properties");
        m.checkNotNullParameter(voiceConfig, "voiceConfig");
        Map<String, Object> mutableMap = h0.toMutableMap(properties);
        addVoiceConnectionProperties(mutableMap, channel, cloudflareBestRegion);
        if (channel != null) {
            mutableMap.put("channel_type", Integer.valueOf(channel.getType()));
            mutableMap.put("channel_bitrate", Integer.valueOf(channel.getBitrate()));
        }
        tracker.track("voice_disconnect", h0.plus(CollectionExtensionsKt.filterNonNullValues(mutableMap), toProperties(voiceConfig)));
    }

    public final void inviteSent(GuildInvite guildInvite, Channel channel, Map<String, ? extends Object> snapshotProperties) {
        Long inviterId;
        Long guildId;
        m.checkNotNullParameter(snapshotProperties, "snapshotProperties");
        Map<String, ? extends Object> mapFilterNonNullValues = CollectionExtensionsKt.filterNonNullValues(snapshotProperties);
        if (channel != null) {
            mapFilterNonNullValues.put("invite_channel_id", Long.valueOf(channel.getId()));
        }
        if (channel != null) {
            mapFilterNonNullValues.put("invite_channel_type", Integer.valueOf(channel.getType()));
        }
        if (guildInvite != null) {
            mapFilterNonNullValues.put("invite_code", guildInvite.getInviteCode());
        }
        if (guildInvite != null && (guildId = guildInvite.getGuildId()) != null) {
            mapFilterNonNullValues.put("invite_guild_id", Long.valueOf(guildId.longValue()));
        }
        if (guildInvite != null && (inviterId = guildInvite.getInviterId()) != null) {
            mapFilterNonNullValues.put("invite_inviter_id", Long.valueOf(inviterId.longValue()));
        }
        tracker.track("invite_sent", mapFilterNonNullValues);
    }

    private final Map<String, Object> toProperties(ModelInvite modelInvite, Map<String, Object> map) {
        return modelInviteToProperties(modelInvite, map);
    }

    private final Map<String, Object> toProperties(ModelSku modelSku) {
        HashMap map = new HashMap();
        if (modelSku == null) {
            return map;
        }
        map.put("sku_id", Long.valueOf(modelSku.getId()));
        map.put("sku_type", Integer.valueOf(modelSku.getType()));
        map.put(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, Long.valueOf(modelSku.getApplicationId()));
        map.put("store_title", modelSku.getName());
        map.put("distribution_type", modelSku.getPremium() ? "premium" : "distribution");
        Application application = modelSku.getApplication();
        if (application != null) {
            map.put("application_name", application.getName());
        }
        return map;
    }

    public final void openPopout(String popoutName, Traits$Location locationTrait) {
        m.checkNotNullParameter(popoutName, "popoutName");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        map.put("type", popoutName);
        tracker.track("open_popout", map);
    }

    public final void openModal(String modalName, Traits$Source sourceTrait) {
        m.checkNotNullParameter(modalName, "modalName");
        m.checkNotNullParameter(sourceTrait, "sourceTrait");
        HashMap map = new HashMap();
        sourceTrait.serializeTo(map);
        map.put("type", modalName);
        tracker.track("open_modal", map);
    }

    public final void inviteCopied(GuildInvite guildInvite, Channel channel, String source) {
        m.checkNotNullParameter(guildInvite, "guildInvite");
        m.checkNotNullParameter(source, "source");
        inviteCopied(guildInvite.getInviteCode(), guildInvite.getGuildId(), channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Integer.valueOf(channel.getType()) : null, source, guildInvite.getGuildScheduledEventId());
    }

    public final void inviteShareClicked(GuildInvite guildInvite, Channel channel) {
        m.checkNotNullParameter(guildInvite, "guildInvite");
        inviteShareClicked(guildInvite.getInviteCode(), guildInvite.getGuildId(), channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Integer.valueOf(channel.getType()) : null, guildInvite.getInviterId(), guildInvite.getGuildScheduledEventId());
    }

    public final void openModal(String modalName, Traits$Location locationTrait) {
        m.checkNotNullParameter(modalName, "modalName");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        HashMap map = new HashMap();
        locationTrait.serializeTo(map);
        map.put("type", modalName);
        tracker.track("open_modal", map);
    }

    private final Map<String, Object> toProperties(WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState, Map<String, Object> map) {
        String str;
        map.put("text_len", Integer.valueOf(TextUtils.getTrimmedLength(widgetUserSetCustomStatusViewModel$FormState.getText())));
        Emoji emoji = widgetUserSetCustomStatusViewModel$FormState.getEmoji();
        String strValueOf = null;
        if (emoji instanceof ModelEmojiCustom) {
            str = "custom";
        } else {
            str = emoji instanceof ModelEmojiUnicode ? "unicode" : null;
        }
        if (str != null) {
            map.put("emoji_type", str);
        }
        int iOrdinal = widgetUserSetCustomStatusViewModel$FormState.getExpiration().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                strValueOf = String.valueOf(StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
            } else if (iOrdinal == 2) {
                strValueOf = String.valueOf(3600000L);
            } else if (iOrdinal == 3) {
                strValueOf = String.valueOf(14400000L);
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                strValueOf = "TODAY";
            }
        }
        if (strValueOf != null) {
            map.put("clear_after", strValueOf);
        }
        return map;
    }

    private final void inviteCopied(String inviteCode, Long guildId, Long channelId, Integer inviteChannelType, String source, Long guildScheduledEventId) {
        tracker.track("copy_instant_invite", CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_CODE, inviteCode), o.to("server", guildId), o.to("channel", channelId), o.to("channel_type", inviteChannelType), o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, source), o.to("guild_scheduled_event_id", guildScheduledEventId))));
    }

    private final void inviteShareClicked(String inviteCode, Long guildId, Long channelId, Integer inviteChannelType, Long inviterId, Long guildScheduledEventId) {
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(o.to("invite_code", inviteCode));
        if (guildId != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId.longValue()));
        }
        if (channelId != null) {
            mapMutableMapOf.put(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId.longValue()));
        }
        if (inviteChannelType != null) {
            mapMutableMapOf.put("invite_channel_type", Integer.valueOf(inviteChannelType.intValue()));
        }
        if (inviterId != null) {
            mapMutableMapOf.put("invite_inviter_id", Long.valueOf(inviterId.longValue()));
        }
        if (guildScheduledEventId != null) {
            mapMutableMapOf.put("invite_guild_scheduled_event_id", Long.valueOf(guildScheduledEventId.longValue()));
        }
        tracker.track("instant_invite_shared", mapMutableMapOf);
    }

    private final Map<String, Object> toProperties(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        if (storeMediaSettings$VoiceConfiguration == null) {
            return h0.emptyMap();
        }
        Pair[] pairArr = new Pair[8];
        pairArr[0] = o.to("audio_input_mode", storeMediaSettings$VoiceConfiguration.getInputMode());
        pairArr[1] = o.to("automatic_audio_input_sensitivity_enabled", Boolean.valueOf(storeMediaSettings$VoiceConfiguration.getAutomaticVad()));
        pairArr[2] = o.to("audio_input_sensitivity", Float.valueOf(storeMediaSettings$VoiceConfiguration.getSensitivity()));
        pairArr[3] = o.to("echo_cancellation_enabled", Boolean.valueOf(storeMediaSettings$VoiceConfiguration.getEchoCancellation()));
        pairArr[4] = o.to("noise_suppression_enabled", Boolean.valueOf(storeMediaSettings$VoiceConfiguration.getNoiseProcessing() == StoreMediaSettings$NoiseProcessing.Suppression));
        pairArr[5] = o.to("noise_cancellation_enabled", Boolean.valueOf(storeMediaSettings$VoiceConfiguration.getNoiseProcessing() == StoreMediaSettings$NoiseProcessing.Cancellation));
        pairArr[6] = o.to("automatic_gain_control_enabled", Boolean.valueOf(storeMediaSettings$VoiceConfiguration.getAutomaticGainControl()));
        pairArr[7] = o.to("voice_output_volume", Float.valueOf(storeMediaSettings$VoiceConfiguration.getOutputVolume()));
        return h0.mapOf(pairArr);
    }
}
