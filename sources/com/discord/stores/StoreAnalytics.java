package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.Message;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreGifting;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.rest.SendUtils2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.auth.WidgetAuthLanding;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.guilds.invite.GuildInvite;
import com.discord.widgets.guilds.invite.WidgetGuildInvite;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics extends Store {
    private String analyticsToken;
    private String authToken;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private String fingerprint;
    private AtomicBoolean hasTrackedAppUiShown;
    private String inputMode;
    private final PublishSubject<ScreenViewed> screenViewedSubject;
    private Channel selectedVoiceChannel;
    private final StoreStream stores;

    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final /* data */ class ScreenViewed {
        private final Class<? extends AppComponent> screen;
        private final long timestamp;

        public ScreenViewed(Class<? extends AppComponent> cls, long j) {
            Intrinsics3.checkNotNullParameter(cls, "screen");
            this.screen = cls;
            this.timestamp = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScreenViewed copy$default(ScreenViewed screenViewed, Class cls, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                cls = screenViewed.screen;
            }
            if ((i & 2) != 0) {
                j = screenViewed.timestamp;
            }
            return screenViewed.copy(cls, j);
        }

        public final Class<? extends AppComponent> component1() {
            return this.screen;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final ScreenViewed copy(Class<? extends AppComponent> screen, long timestamp) {
            Intrinsics3.checkNotNullParameter(screen, "screen");
            return new ScreenViewed(screen, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScreenViewed)) {
                return false;
            }
            ScreenViewed screenViewed = (ScreenViewed) other;
            return Intrinsics3.areEqual(this.screen, screenViewed.screen) && this.timestamp == screenViewed.timestamp;
        }

        public final Class<? extends AppComponent> getScreen() {
            return this.screen;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            Class<? extends AppComponent> cls = this.screen;
            return b.a(this.timestamp) + ((cls != null ? cls.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ScreenViewed(screen=");
            sbU.append(this.screen);
            sbU.append(", timestamp=");
            return outline.C(sbU, this.timestamp, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeedbackIssue.values();
            int[] iArr = new int[24];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_BLACK.ordinal()] = 1;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_BLURRY.ordinal()] = 2;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_LAGGING.ordinal()] = 3;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC.ordinal()] = 4;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING.ordinal()] = 5;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR.ordinal()] = 6;
            iArr[FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY.ordinal()] = 7;
            iArr[FeedbackIssue.OTHER.ordinal()] = 8;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$ackMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$ackMessage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreAnalytics.kt */
        public static final class C00741 extends Lambda implements Function0<Map<String, ? extends Object>> {
            public final /* synthetic */ Map $properties;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00741(Map map) {
                super(0);
                this.$properties = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends Object> invoke() {
                return this.$properties;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                AnalyticsTracker.INSTANCE.ackMessage(channelFindChannelByIdInternal$app_productionGoogleRelease, new C00741(Maps6.plus(StoreAnalytics.this.getGuildAnalyticsPropertiesInternal(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()), StoreAnalytics.getChannelSnapshotAnalyticsProperties$default(StoreAnalytics.this, channelFindChannelByIdInternal$app_productionGoogleRelease, false, 2, (Object) null))));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MediaEngineConnection.InputMode, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MediaEngineConnection.InputMode inputMode) {
            invoke2(inputMode);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MediaEngineConnection.InputMode inputMode) {
            Intrinsics3.checkNotNullParameter(inputMode, "it");
            StoreAnalytics.this.inputMode = inputMode.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            StoreAnalytics.this.selectedVoiceChannel = channel;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$init$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<ScreenViewed, Unit> {
        public AnonymousClass4(StoreAnalytics storeAnalytics) {
            super(1, storeAnalytics, StoreAnalytics.class, "onScreenViewed", "onScreenViewed(Lcom/discord/stores/StoreAnalytics$ScreenViewed;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ScreenViewed screenViewed) {
            invoke2(screenViewed);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ScreenViewed screenViewed) {
            Intrinsics3.checkNotNullParameter(screenViewed, "p1");
            ((StoreAnalytics) this.receiver).onScreenViewed(screenViewed);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$onGuildSettingsPaneViewed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ String $pane;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str) {
            super(0);
            this.$guildId = j;
            this.$pane = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.settingsPaneViewed("guild", this.$pane, StoreAnalytics.this.getGuildAnalyticsPropertiesInternal(this.$guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$onNotificationSettingsUpdated$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ ModelNotificationSettings $notifSettings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, ModelNotificationSettings modelNotificationSettings) {
            super(0);
            this.$channelId = l;
            this.$notifSettings = modelNotificationSettings;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ModelNotificationSettings.ChannelOverride channelOverride;
            Long l = this.$channelId;
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = null;
            if (l != null) {
                long jLongValue = l.longValue();
                List<ModelNotificationSettings.ChannelOverride> channelOverrides = this.$notifSettings.getChannelOverrides();
                Intrinsics3.checkNotNullExpressionValue(channelOverrides, "notifSettings.channelOverrides");
                boolean z2 = true;
                if (!(channelOverrides instanceof Collection) || !channelOverrides.isEmpty()) {
                    Iterator<T> it = channelOverrides.iterator();
                    do {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        } else {
                            channelOverride = (ModelNotificationSettings.ChannelOverride) it.next();
                            Intrinsics3.checkNotNullExpressionValue(channelOverride, "it");
                        }
                    } while (!(channelOverride.getChannelId() == jLongValue));
                } else {
                    z2 = false;
                    break;
                }
                if (!z2) {
                    l = null;
                }
                if (l != null) {
                    channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(l.longValue());
                }
            }
            AnalyticsTracker.INSTANCE.notificationSettingsUpdated(this.$notifSettings, channelFindChannelByIdInternal$app_productionGoogleRelease);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$onOverlayVoiceEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isActive;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$isActive = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<String, String> mapEmptyMap;
            RtcConnection rtcConnection$app_productionGoogleRelease = StoreAnalytics.this.stores.getRtcConnection().getRtcConnection();
            if (rtcConnection$app_productionGoogleRelease == null || (mapEmptyMap = AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(rtcConnection$app_productionGoogleRelease)) == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            if (!this.$isActive) {
                AnalyticsTracker.INSTANCE.overlayVoiceClosed(mapEmptyMap);
                return;
            }
            Channel channel = StoreAnalytics.this.selectedVoiceChannel;
            Map guildAnalyticsPropertiesInternal = channel != null ? StoreAnalytics.this.getGuildAnalyticsPropertiesInternal(channel.getGuildId()) : null;
            if (guildAnalyticsPropertiesInternal == null) {
                guildAnalyticsPropertiesInternal = Maps6.emptyMap();
            }
            Map mapPlus = Maps6.plus(guildAnalyticsPropertiesInternal, mapEmptyMap);
            Channel channel2 = StoreAnalytics.this.selectedVoiceChannel;
            Map<String, Object> properties$app_productionGoogleRelease = channel2 != null ? AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channel2) : null;
            if (properties$app_productionGoogleRelease == null) {
                properties$app_productionGoogleRelease = Maps6.emptyMap();
            }
            AnalyticsTracker.INSTANCE.overlayVoiceOpened(Maps6.plus(mapPlus, properties$app_productionGoogleRelease));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$onScreenViewed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ScreenViewed $screenViewed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ScreenViewed screenViewed) {
            super(0);
            this.$screenViewed = screenViewed;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String simpleName;
            Class<? extends AppComponent> screen = this.$screenViewed.getScreen();
            if (Intrinsics3.areEqual(screen, WidgetHome.class)) {
                simpleName = StoreAnalytics.this.stores.getGuildSelected().getSelectedGuildId() == 0 ? "private_channel" : "guild";
            } else if (Intrinsics3.areEqual(screen, WidgetGuildInvite.class)) {
                simpleName = "invite";
            } else if (Intrinsics3.areEqual(screen, WidgetIncomingShare.class)) {
                simpleName = AnalyticsTracker.ATTACHMENT_SOURCE_SHARE;
            } else {
                simpleName = Intrinsics3.areEqual(screen, WidgetAuthLanding.class) ? "app_landing" : this.$screenViewed.getScreen().getSimpleName();
            }
            AppStartAnalyticsTracker companion = AppStartAnalyticsTracker.INSTANCE.getInstance();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "screenName");
            companion.appUiViewed(simpleName, this.$screenViewed.getTimestamp());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$onThreadNotificationSettingsUpdated$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $flags;
        public final /* synthetic */ int $oldFlags;
        public final /* synthetic */ long $parentChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, int i, int i2) {
            super(0);
            this.$channelId = j;
            this.$parentChannelId = j2;
            this.$oldFlags = i;
            this.$flags = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease;
            ModelNotificationSettings modelNotificationSettings;
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease2 = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease2 == null || (channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$parentChannelId)) == null) {
                return;
            }
            boolean z2 = (this.$oldFlags & 1) != 0;
            long guildId = channelFindChannelByIdInternal$app_productionGoogleRelease2.getGuildId();
            Guild guild = StoreAnalytics.this.stores.getGuilds().getGuild(guildId);
            if (guild == null || (modelNotificationSettings = StoreAnalytics.this.stores.getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null) {
                return;
            }
            AnalyticsTracker.INSTANCE.threadNotificationSettingsUpdated(StoreAnalytics.this.getThreadSnapshotAnalyticsProperties(channelFindChannelByIdInternal$app_productionGoogleRelease2), z2, NotificationTextUtils.INSTANCE.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channelFindChannelByIdInternal$app_productionGoogleRelease), ChannelNotificationSettingsUtils.INSTANCE.computeNotificationSetting(guild, channelFindChannelByIdInternal$app_productionGoogleRelease2, modelNotificationSettings), this.$oldFlags, this.$flags);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackCallReportProblem$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PendingFeedback.CallFeedback $pendingCallFeedback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PendingFeedback.CallFeedback callFeedback) {
            super(0);
            this.$pendingCallFeedback = callFeedback;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long id2 = StoreAnalytics.this.stores.getUsers().getMe().getId();
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$pendingCallFeedback.getChannelId());
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                StoreMediaSettings mediaSettings = StoreAnalytics.this.stores.getMediaSettings();
                DiscordAudioManager.AudioDevice lastActiveAudioDevice$app_productionGoogleRelease = StoreAnalytics.this.stores.getAudioManagerV2().getLastActiveAudioDevice();
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                String rtcConnectionId = this.$pendingCallFeedback.getRtcConnectionId();
                Map<Long, VoiceState> mapEmptyMap = (Map) outline.c(channelFindChannelByIdInternal$app_productionGoogleRelease, StoreAnalytics.this.stores.getVoiceStates().get());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                analyticsTracker.callReportProblem(id2, rtcConnectionId, channelFindChannelByIdInternal$app_productionGoogleRelease, mapEmptyMap, this.$pendingCallFeedback.getDurationMs(), this.$pendingCallFeedback.getMediaSessionId(), this.$pendingCallFeedback.getFeedbackRating(), this.$pendingCallFeedback.getReasonCode(), this.$pendingCallFeedback.getReasonDescription(), mediaSettings.getVoiceConfigurationBlocking(), lastActiveAudioDevice$app_productionGoogleRelease, mediaSettings.getVideoHardwareScalingBlocking(), this.$pendingCallFeedback.getIssueDetails());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackGuildViewed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends Object>> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends Object> invoke() {
            return this.$properties;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackMediaSessionJoined$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.mediaSessionJoined(this.$properties, StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.this.stores.getVoiceChannelSelected().getLastSelectedVoiceChannelId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackOpenGiftAcceptModal$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $giftCode;
        public final /* synthetic */ String $location;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j, String str2) {
            super(0);
            this.$giftCode = str;
            this.$channelId = j;
            this.$location = str2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ModelGift gift;
            StoreGifting.GiftState giftState = StoreAnalytics.this.stores.getGifting().getKnownGifts().get(this.$giftCode);
            if (giftState instanceof StoreGifting.GiftState.Resolved) {
                gift = ((StoreGifting.GiftState.Resolved) giftState).getGift();
            } else if (giftState instanceof StoreGifting.GiftState.Redeeming) {
                gift = ((StoreGifting.GiftState.Redeeming) giftState).getGift();
            } else {
                gift = giftState instanceof StoreGifting.GiftState.RedeemedFailed ? ((StoreGifting.GiftState.RedeemedFailed) giftState).getGift() : null;
            }
            if (gift != null) {
                AnalyticsTracker.openGiftModal(gift, StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId), this.$location);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackShowCallFeedbackSheet$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                AnalyticsTracker.INSTANCE.openCallFeedbackSheet(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getType());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackVoiceAudioOutputModeSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $fromAudioOutputMode;
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $toAudioOutputMode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, DiscordAudioManager.DeviceTypes deviceTypes, DiscordAudioManager.DeviceTypes deviceTypes2) {
            super(0);
            this.$channelId = j;
            this.$fromAudioOutputMode = deviceTypes;
            this.$toAudioOutputMode = deviceTypes2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long id2 = StoreAnalytics.this.stores.getUsers().getMe().getId();
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                RtcConnection.Metadata rtcConnectionMetadata = StoreAnalytics.this.stores.getRtcConnection().getRtcConnectionMetadata();
                AnalyticsTracker.INSTANCE.voiceAudioOutputModeSelected(id2, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, channelFindChannelByIdInternal$app_productionGoogleRelease, this.$fromAudioOutputMode, this.$toAudioOutputMode);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackVoiceConnectionFailure$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.voiceConnectionFailure(this.$properties, StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.this.stores.getVoiceChannelSelected().getSelectedVoiceChannelId()), StoreAnalytics.this.stores.getRtcRegion().getPreferredRegion());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackVoiceConnectionSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackVoiceConnectionSuccess$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreAnalytics.kt */
        public static final class C00751 extends Lambda implements Function1<MediaEngine.AudioInfo, Unit> {
            public final /* synthetic */ Channel $channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00751(Channel channel) {
                super(1);
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaEngine.AudioInfo audioInfo) {
                invoke2(audioInfo);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MediaEngine.AudioInfo audioInfo) {
                Intrinsics3.checkNotNullParameter(audioInfo, "audioInfo");
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                analyticsTracker.voiceConnectionSuccess(anonymousClass1.$properties, audioInfo, this.$channel, StoreAnalytics.this.stores.getRtcRegion().getPreferredRegion());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.this.stores.getVoiceChannelSelected().getSelectedVoiceChannelId());
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(StoreAnalytics.this.stores.getMediaEngine().getMediaEngine().e()), (Class<?>) StoreAnalytics.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C00751(channelFindChannelByIdInternal$app_productionGoogleRelease));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackVoiceDisconnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAnalytics.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Map $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(0);
            this.$properties = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnalyticsTracker.INSTANCE.voiceDisconnect(this.$properties, StoreAnalytics.this.stores.getMediaSettings().getVoiceConfigurationBlocking(), StoreAnalytics.this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.this.stores.getVoiceChannelSelected().getLastSelectedVoiceChannelId()), StoreAnalytics.this.stores.getRtcRegion().getPreferredRegion());
        }
    }

    public StoreAnalytics(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stores");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stores = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.hasTrackedAppUiShown = new AtomicBoolean(false);
        this.screenViewedSubject = PublishSubject.k0();
    }

    private final void emojiPickerUpsellViewed(AnalyticsTracker.PremiumUpsellType type, EmojiPickerContextType emojiPickerContextType, Map<String, ? extends Object> properties) {
        String str;
        if (Intrinsics3.areEqual(emojiPickerContextType, EmojiPickerContextType.Global.INSTANCE)) {
            str = "Custom Status Modal";
        } else if (Intrinsics3.areEqual(emojiPickerContextType, EmojiPickerContextType.Chat.INSTANCE)) {
            Channel channel = this.stores.getChannels().getChannel(this.stores.getChannelsSelected().getId());
            str = (channel == null || channel.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel";
        } else {
            str = "";
        }
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, type, new Traits.Location((String) KotlinExtensions.getExhaustive(str), Traits.Location.Section.EMOJI_PICKER_POPOUT, Traits.Location.Obj.BUTTON_UPSELL, Traits.Location.ObjType.SEARCH, null, 16, null), Maps6.plus(properties, Tuples.to("has_search_query", Boolean.TRUE)), null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emojiPickerUpsellViewed$default(StoreAnalytics storeAnalytics, AnalyticsTracker.PremiumUpsellType premiumUpsellType, EmojiPickerContextType emojiPickerContextType, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = Maps6.emptyMap();
        }
        storeAnalytics.emojiPickerUpsellViewed(premiumUpsellType, emojiPickerContextType, map);
    }

    private final Map<String, Object> getChannelSnapshotAnalyticsProperties(long channelId, boolean includeNsfw) {
        Channel channel = this.stores.getChannels().getChannel(channelId);
        Map<String, Object> channelSnapshotAnalyticsProperties = channel != null ? getChannelSnapshotAnalyticsProperties(channel, includeNsfw) : null;
        return channelSnapshotAnalyticsProperties != null ? channelSnapshotAnalyticsProperties : Maps6.emptyMap();
    }

    public static /* synthetic */ Map getChannelSnapshotAnalyticsProperties$default(StoreAnalytics storeAnalytics, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(j, z2);
    }

    @Store3
    private final Map<String, Object> getGuildAnalyticsPropertiesInternal(long guildId) {
        Collection<Channel> collectionEmptyList;
        GuildMember guildMember;
        List<Long> roles;
        Guild guild = this.stores.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild == null) {
            return new HashMap();
        }
        int approximateMemberCount = this.stores.getGuildMemberCounts().getApproximateMemberCount(guildId);
        Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = this.stores.getChannels().getChannelsForGuildInternal$app_productionGoogleRelease(guildId);
        if (channelsForGuildInternal$app_productionGoogleRelease == null || (collectionEmptyList = channelsForGuildInternal$app_productionGoogleRelease.values()) == null) {
            collectionEmptyList = Collections2.emptyList();
        }
        Collection<Channel> collection = collectionEmptyList;
        Map<Long, GuildRole> map = this.stores.getGuilds().getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        int size = map != null ? map.size() : 0;
        long id2 = this.stores.getUsers().getMe().getId();
        Map<Long, GuildMember> map2 = this.stores.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        int size2 = (map2 == null || (guildMember = map2.get(Long.valueOf(id2))) == null || (roles = guildMember.getRoles()) == null) ? 0 : roles.size();
        Long l = this.stores.getPermissions().getGuildPermissions().get(Long.valueOf(guildId));
        return guildPropertiesMap(guild.getId(), approximateMemberCount, collection, size, size2, l != null ? l.longValue() : 0L, guild.getFeatures().contains(GuildFeature.VIP_REGIONS));
    }

    private final Map<String, Object> getGuildAndChannelSnapshotAnalyticsProperties(long channelId) {
        Channel channel = this.stores.getChannels().getChannel(channelId);
        Map<String, Object> mapPlus = channel != null ? Maps6.plus(getGuildSnapshotAnalyticsProperties(channel.getGuildId()), getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)) : null;
        return mapPlus != null ? mapPlus : Maps6.emptyMap();
    }

    private final Map<String, Object> getGuildSnapshotAnalyticsProperties(long guildId) {
        Guild guild = this.stores.getGuilds().getGuilds().get(Long.valueOf(guildId));
        Map<String, Object> guildSnapshotAnalyticsProperties = guild != null ? getGuildSnapshotAnalyticsProperties(guild) : null;
        return guildSnapshotAnalyticsProperties != null ? guildSnapshotAnalyticsProperties : Maps6.emptyMap();
    }

    private final Map<String, Object> getSnapshotAnalyticsProperties() {
        return getGuildAndChannelSnapshotAnalyticsProperties(this.stores.getChannelsSelected().getId());
    }

    private final String getStreamFeedbackReasonFromIssue(FeedbackIssue issue) {
        if (issue != null) {
            int iOrdinal = issue.ordinal();
            if (iOrdinal == 0) {
                return "OTHER";
            }
            switch (iOrdinal) {
                case 10:
                    return "BLACK_SCREEN";
                case 11:
                    return "BLURRY";
                case 12:
                    return "LAGGING";
                case 13:
                    return "OUT_OF_SYNC";
                case 14:
                    return "AUDIO_MISSING";
                case 15:
                    return "AUDIO_POOR";
                case 16:
                    return "STREAM_STOPPED_UNEXPECTEDLY";
            }
        }
        return null;
    }

    private final Map<String, Object> getThreadSnapshotAnalyticsProperties(Channel channel) {
        Integer threadMessageCount = this.stores.getThreadMessages().getThreadMessageCount(channel.getId());
        boolean z2 = false;
        int iIntValue = threadMessageCount != null ? threadMessageCount.intValue() : 0;
        Tuples2[] tuples2Arr = new Tuples2[9];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        tuples2Arr[1] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(channel.getGuildId()));
        tuples2Arr[2] = Tuples.to("parent_id", Long.valueOf(channel.getParentId()));
        tuples2Arr[3] = Tuples.to("channel_type", Integer.valueOf(channel.getType()));
        tuples2Arr[4] = Tuples.to("thread_approximate_message_count", Integer.valueOf(_Ranges.coerceAtMost(iIntValue, 50)));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        tuples2Arr[5] = Tuples.to("thread_archived", Boolean.valueOf(threadMetadata != null && threadMetadata.getArchived()));
        ThreadMetadata threadMetadata2 = channel.getThreadMetadata();
        if (threadMetadata2 != null && threadMetadata2.getLocked()) {
            z2 = true;
        }
        tuples2Arr[6] = Tuples.to("thread_locked", Boolean.valueOf(z2));
        ThreadMetadata threadMetadata3 = channel.getThreadMetadata();
        tuples2Arr[7] = Tuples.to("thread_auto_archive_duration_minutes", threadMetadata3 != null ? Integer.valueOf(threadMetadata3.getAutoArchiveDuration()) : null);
        tuples2Arr[8] = Tuples.to("thread_approximate_creation_date", Long.valueOf((channel.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
        return Maps6.mapOf(tuples2Arr);
    }

    private final Map<String, Object> guildPropertiesMap(long guildId, int guildSize, Collection<Channel> guildChannels, int numGuildRoles, int guildMemberNumRoles, long guildPermissions, boolean isVip) {
        int i;
        Tuples2[] tuples2Arr = new Tuples2[9];
        int i2 = 0;
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        tuples2Arr[1] = Tuples.to("guild_size_total", Integer.valueOf(guildSize));
        tuples2Arr[2] = Tuples.to("guild_num_channels", Integer.valueOf(guildChannels.size()));
        if (guildChannels.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = guildChannels.iterator();
            i = 0;
            while (it.hasNext()) {
                if (ChannelUtils.v((Channel) it.next()) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        tuples2Arr[3] = Tuples.to("guild_num_text_channels", Integer.valueOf(i));
        if (!guildChannels.isEmpty()) {
            Iterator<T> it2 = guildChannels.iterator();
            while (it2.hasNext()) {
                if (ChannelUtils.w((Channel) it2.next()) && (i2 = i2 + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        tuples2Arr[4] = Tuples.to("guild_num_voice_channels", Integer.valueOf(i2));
        tuples2Arr[5] = Tuples.to("guild_num_roles", Integer.valueOf(numGuildRoles));
        tuples2Arr[6] = Tuples.to("guild_member_num_roles", Integer.valueOf(guildMemberNumRoles));
        tuples2Arr[7] = Tuples.to("guild_member_perms", Long.valueOf(guildPermissions));
        tuples2Arr[8] = Tuples.to("guild_is_vip", Boolean.valueOf(isVip));
        return Maps6.mutableMapOf(tuples2Arr);
    }

    @Store3
    private final void handleVideoInputUpdate(DeviceDescription4 selectedVideoInputDevice, boolean isScreenSharing) {
        Channel channel = this.selectedVoiceChannel;
        if (channel != null) {
            Map<Long, VoiceState> mapEmptyMap = this.stores.getVoiceStates().get().get(Long.valueOf(channel.getGuildId()));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            Map<Long, VoiceState> map = mapEmptyMap;
            long id2 = this.stores.getUsers().getMe().getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            RtcConnection.Metadata rtcConnectionMetadata = this.stores.getRtcConnection().getRtcConnectionMetadata();
            analyticsTracker.videoInputsUpdate(id2, channel, map, selectedVideoInputDevice, isScreenSharing, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null);
        }
    }

    private final void onScreenViewed(ScreenViewed screenViewed) {
        if (this.hasTrackedAppUiShown.getAndSet(true)) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(screenViewed));
    }

    public static /* synthetic */ void onUserSettingsPaneViewed$default(StoreAnalytics storeAnalytics, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        storeAnalytics.onUserSettingsPaneViewed(str, str2);
    }

    public static /* synthetic */ void trackSearchResultSelected$default(StoreAnalytics storeAnalytics, SearchType searchType, int i, Traits.Location location, Traits.Source source, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            location = null;
        }
        if ((i2 & 8) != 0) {
            source = null;
        }
        storeAnalytics.trackSearchResultSelected(searchType, i, location, source);
    }

    public static /* synthetic */ void trackSearchResultsEmpty$default(StoreAnalytics storeAnalytics, SearchType searchType, Traits.Location location, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            location = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeAnalytics.trackSearchResultsEmpty(searchType, location, z2);
    }

    public static /* synthetic */ void trackSearchStarted$default(StoreAnalytics storeAnalytics, SearchType searchType, Traits.Location location, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            location = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeAnalytics.trackSearchStarted(searchType, location, z2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0025  */
    /* JADX WARN: Code duplicated, block: B:31:0x003a  */
    private final void updateTrackingData() {
        boolean z2;
        boolean z3;
        String str = this.authToken;
        boolean z4 = !(str == null || str.length() == 0);
        if (z4) {
            z2 = false;
        } else {
            String str2 = this.fingerprint;
            if (str2 == null || str2.length() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z4) {
            String str3 = this.analyticsToken;
            if (str3 == null || str3.length() == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z2) {
            AnalyticsTracker.INSTANCE.getTracker().setTrackingData(null, true);
        } else if (z3) {
            AnalyticsUtils.Tracker.setTrackingData$default(AnalyticsTracker.INSTANCE.getTracker(), this.analyticsToken, false, 2, null);
        } else {
            AnalyticsTracker.INSTANCE.getTracker().setTrackingData(null, false);
        }
    }

    public final void ackMessage(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    public final void appLandingViewed() {
        AnalyticsTracker.appLandingViewed(getPrefsSessionDurable().getLong("CACHE_KEY_LOGOUT_TS", 0L));
    }

    public final void appUiViewed(Class<? extends AppComponent> screen) {
        Intrinsics3.checkNotNullParameter(screen, "screen");
        PublishSubject<ScreenViewed> publishSubject = this.screenViewedSubject;
        publishSubject.k.onNext(new ScreenViewed(screen, this.clock.currentTimeMillis()));
    }

    public final void deepLinkReceived(Intent intent, RouteHandlers.AnalyticsMetadata metadata) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        Long channelId = metadata.getChannelId();
        Map<String, ? extends Object> guildAndChannelSnapshotAnalyticsProperties = channelId != null ? getGuildAndChannelSnapshotAnalyticsProperties(channelId.longValue()) : null;
        if (guildAndChannelSnapshotAnalyticsProperties == null) {
            guildAndChannelSnapshotAnalyticsProperties = Maps6.emptyMap();
        }
        AnalyticsTracker.INSTANCE.deepLinkReceived(intent, metadata, guildAndChannelSnapshotAnalyticsProperties);
    }

    public final void emojiAutocompleteUpsellInlineViewed() {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.EmojiAutocompleteInline, null, Maps6.emptyMap(), null, 8, null);
    }

    public final void emojiAutocompleteUpsellModalViewed() {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.EmojiAutocompleteModal, null, Maps6.emptyMap(), null, 8, null);
    }

    public final void emojiPickerUpsellHeaderViewed(EmojiPickerContextType emojiPickerContextType) {
        Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        emojiPickerUpsellViewed$default(this, AnalyticsTracker.PremiumUpsellType.EmojiPickerHeaderViewed, emojiPickerContextType, null, 4, null);
    }

    public final void emojiPickerUpsellLockedItemClicked(EmojiPickerContextType emojiPickerContextType, boolean isAnimated) {
        Intrinsics3.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        emojiPickerUpsellViewed(AnalyticsTracker.PremiumUpsellType.EmojiPickerLockedItemClicked, emojiPickerContextType, Maps6.mapOf(Tuples.to("is_animated", Boolean.valueOf(isAnimated)), Tuples.to("is_external", Boolean.TRUE)));
    }

    public final Traits.Location getEmojiPickerUpsellLocation() {
        Channel channel = this.stores.getChannels().getChannel(this.stores.getChannelsSelected().getId());
        return new Traits.Location((channel == null || channel.getGuildId() != 0) ? Traits.Location.Page.GUILD_CHANNEL : "DM Channel", Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, null, 28, null);
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        this.authToken = authToken;
        updateTrackingData();
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        this.analyticsToken = null;
        updateTrackingData();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.analyticsToken = payload.getAnalyticsToken();
        updateTrackingData();
    }

    @Store3
    public final void handleFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        updateTrackingData();
    }

    @Store3
    public final void handleIsScreenSharingChanged(boolean isScreenSharing) {
        handleVideoInputUpdate(this.stores.getMediaEngine().getSelectedVideoInputDevice(), isScreenSharing);
    }

    @Store3
    public final void handlePreLogout() {
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putLong("CACHE_KEY_LOGOUT_TS", this.clock.currentTimeMillis());
        editorEdit.apply();
    }

    @Store3
    public final void handleUserSpeaking(Set<Long> speakingUsers) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(speakingUsers, "speakingUsers");
        String str = this.inputMode;
        if (str == null || (channel = this.selectedVoiceChannel) == null) {
            return;
        }
        long id2 = this.stores.getUsers().getMe().getId();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.userSpeaking(id2, speakingUsers, str, channel);
        analyticsTracker.userListening(id2, speakingUsers, str, channel);
    }

    @Store3
    public final void handleVideoInputDeviceSelected(DeviceDescription4 videoInputDevice) {
        handleVideoInputUpdate(videoInputDevice, this.stores.getApplicationStreaming().isScreenSharing());
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(this.stores.getMediaSettings().getInputMode()), (Class<?>) StoreAnalytics.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(this.stores.getVoiceChannelSelected().observeSelectedChannel()), (Class<?>) StoreAnalytics.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        Observable observableZ = this.screenViewedSubject.Y(new Func1<ScreenViewed, Observable<? extends ScreenViewed>>() { // from class: com.discord.stores.StoreAnalytics.init.3
            @Override // j0.k.Func1
            public final Observable<? extends ScreenViewed> call(final ScreenViewed screenViewed) {
                return Intrinsics3.areEqual(screenViewed.getScreen(), WidgetHome.class) ? Observable.d0(2L, TimeUnit.SECONDS).G(new Func1<Long, ScreenViewed>() { // from class: com.discord.stores.StoreAnalytics.init.3.1
                    @Override // j0.k.Func1
                    public final ScreenViewed call(Long l) {
                        return screenViewed;
                    }
                }) : new ScalarSynchronousObservable(screenViewed);
            }
        }).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "screenViewedSubject\n    …       }\n        .first()");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) StoreAnalytics.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4(this));
    }

    public final void inviteSent(ModelInvite invite, Message message, String location) {
        GuildScheduledEvent guildScheduledEvent;
        Channel channel;
        com.discord.api.guild.Guild guild;
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Tuples2[] tuples2Arr = new Tuples2[5];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        tuples2Arr[1] = Tuples.to("message_id", Long.valueOf(message.getId()));
        Long lValueOf = null;
        tuples2Arr[2] = Tuples.to("invite_guild_id", (invite == null || (guild = invite.guild) == null) ? null : Long.valueOf(guild.getId()));
        tuples2Arr[3] = Tuples.to("invite_channel_id", (invite == null || (channel = invite.getChannel()) == null) ? null : Long.valueOf(channel.getId()));
        if (invite != null && (guildScheduledEvent = invite.getGuildScheduledEvent()) != null) {
            lValueOf = Long.valueOf(guildScheduledEvent.getId());
        }
        tuples2Arr[4] = Tuples.to("invite_guild_scheduled_event_id", lValueOf);
        AnalyticsTracker.INSTANCE.inviteSent(invite, Maps6.plus(Maps6.mapOf(tuples2Arr), getGuildAndChannelSnapshotAnalyticsProperties(message.getChannelId())));
    }

    public final void inviteSuggestionOpened(long guildId, List<Channel> channelSuggestions, List<? extends User> userSuggestions) {
        Intrinsics3.checkNotNullParameter(channelSuggestions, "channelSuggestions");
        Intrinsics3.checkNotNullParameter(userSuggestions, "userSuggestions");
        AnalyticsTracker.INSTANCE.inviteSuggestionOpened(guildId, channelSuggestions, userSuggestions);
    }

    public final void onGuildSettingsPaneViewed(String pane, long guildId) {
        Intrinsics3.checkNotNullParameter(pane, "pane");
        this.dispatcher.schedule(new AnonymousClass1(guildId, pane));
    }

    public final void onNotificationSettingsUpdated(ModelNotificationSettings notifSettings, Long channelId) {
        Intrinsics3.checkNotNullParameter(notifSettings, "notifSettings");
        this.dispatcher.schedule(new AnonymousClass1(channelId, notifSettings));
    }

    public final void onOverlayVoiceEvent(boolean isActive) {
        this.dispatcher.schedule(new AnonymousClass1(isActive));
    }

    public final void onThreadNotificationSettingsUpdated(long channelId, long parentChannelId, int flags, int oldFlags) {
        this.dispatcher.schedule(new AnonymousClass1(channelId, parentChannelId, oldFlags, flags));
    }

    public final void onUserSettingsPaneViewed(String pane, String locationSection) {
        Intrinsics3.checkNotNullParameter(pane, "pane");
        AnalyticsTracker.INSTANCE.settingsPaneViewed("user", pane, locationSection != null ? MapsJVM.mapOf(Tuples.to("location_section", locationSection)) : null);
    }

    public final void openCustomEmojiPopout(Channel channel, long emojiId, boolean isPremium, boolean joinedSourceGuild, boolean sourceGuildPrivate) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        AnalyticsTracker.INSTANCE.openCustomEmojiPopout(channel.getGuildId(), emojiId, isPremium, joinedSourceGuild, sourceGuildPrivate, CollectionExtensions.filterNonNullValues(getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)));
    }

    public final void openUnicodeEmojiPopout(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        AnalyticsTracker.INSTANCE.openUnicodeEmojiPopout(channel.getGuildId(), CollectionExtensions.filterNonNullValues(getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)));
    }

    public final void streamQualityIndicatorViewed(boolean hasPremiumStreamResolution, Boolean hasPremiumStreamFps) {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.StreamQualityIndicator, null, CollectionExtensions.filterNonNullValues(Maps6.mapOf(Tuples.to("has_premium_stream_fps", hasPremiumStreamFps), Tuples.to("has_premium_stream_resolution", Boolean.valueOf(hasPremiumStreamResolution)))), null, 8, null);
    }

    public final void trackApplicationCommandBrowserJump(long targetApplicationId) {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserJump(targetApplicationId);
    }

    public final void trackApplicationCommandBrowserOpened(long channelId) {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserOpened(getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackApplicationCommandBrowserScrolled() {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserScrolled();
    }

    public final void trackApplicationCommandSelected(long channelId, long applicationId, long commandId) {
        AnalyticsTracker.INSTANCE.applicationCommandSelected(applicationId, commandId, getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackApplicationCommandValidationFailure(long applicationId, long commandId, String argumentType, boolean isRequired) {
        Intrinsics3.checkNotNullParameter(argumentType, "argumentType");
        AnalyticsTracker.INSTANCE.applicationCommandValidationFailure(applicationId, commandId, argumentType, isRequired);
    }

    public final void trackAutocompleteOpen(long channelId, String autocompleteType, int numEmojiResults, int numStickerResults) {
        Intrinsics3.checkNotNullParameter(autocompleteType, "autocompleteType");
        AnalyticsTracker.INSTANCE.autocompleteOpen(CollectionExtensions.filterNonNullValues(getGuildAndChannelSnapshotAnalyticsProperties(channelId)), autocompleteType, numEmojiResults, numStickerResults);
    }

    public final void trackAutocompleteSelect(long channelId, String autocompleteType, int numEmojiResults, int numStickerResults, String selectionType, String selection, Long stickerId) {
        Intrinsics3.checkNotNullParameter(autocompleteType, "autocompleteType");
        AnalyticsTracker.INSTANCE.autocompleteSelect(CollectionExtensions.filterNonNullValues(getGuildAndChannelSnapshotAnalyticsProperties(channelId)), autocompleteType, numEmojiResults, numStickerResults, selectionType, selection, stickerId);
    }

    public final void trackCallReportProblem(PendingFeedback.CallFeedback pendingCallFeedback) {
        Intrinsics3.checkNotNullParameter(pendingCallFeedback, "pendingCallFeedback");
        this.dispatcher.schedule(new AnonymousClass1(pendingCallFeedback));
    }

    @Store3
    public final void trackChannelOpened(long channelId, StoreChannelsSelected2 channelView, StoreChannelsSelected3 analyticsLocation) {
        Intrinsics3.checkNotNullParameter(channelView, "channelView");
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            AnalyticsTracker.INSTANCE.channelOpened(channelId, new StoreAnalytics2(channelFindChannelByIdInternal$app_productionGoogleRelease, this, channelId, channelView, analyticsLocation));
        }
    }

    public final void trackChatInputComponentViewed(String type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        AnalyticsTracker.INSTANCE.chatInputComponentViewed(type);
    }

    public final void trackFailedMessageResolved(int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, StoreMessages2 resolutionType, long initialAttemptTimestamp, int numRetries, long channelId) {
        Intrinsics3.checkNotNullParameter(resolutionType, "resolutionType");
        AnalyticsTracker.INSTANCE.failedMessageResolved(numAttachments, maxAttachmentSize, totalAttachmentSize, hasImage, hasVideo, resolutionType, initialAttemptTimestamp, numRetries, getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackFileUploadAlertViewed(SendUtils2 alertType, int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, boolean isPremium) {
        Intrinsics3.checkNotNullParameter(alertType, "alertType");
        AnalyticsTracker.INSTANCE.fileUploadAlertViewed(alertType, numAttachments, maxAttachmentSize, totalAttachmentSize, hasImage, hasVideo, isPremium, getSnapshotAnalyticsProperties());
    }

    public final void trackGuildProfileOpened(long guildId) {
        AnalyticsTracker.INSTANCE.openGuildProfileSheet(guildId);
    }

    @Store3
    public final void trackGuildViewed(long guildId) {
        boolean zContains;
        GuildMember guildMember;
        Guild guild = this.stores.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild != null) {
            long id2 = this.stores.getUsers().getMe().getId();
            Map<Long, GuildMember> map = this.stores.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
            boolean pending = (map == null || (guildMember = map.get(Long.valueOf(id2))) == null) ? false : guildMember.getPending();
            try {
                zContains = guild.getFeatures().contains(GuildFeature.PREVIEW_ENABLED);
            } catch (Exception e) {
                AppLog.g.e("Guild is missing feature set", e, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guild.getId()))));
                zContains = false;
            }
            AnalyticsTracker.INSTANCE.guildViewed(guildId, new AnonymousClass1(Maps6.plus(getGuildAnalyticsPropertiesInternal(guildId), Maps6.mapOf(Tuples.to("is_pending", Boolean.valueOf(pending)), Tuples.to("preview_enabled", Boolean.valueOf(zContains))))));
        }
    }

    public final void trackMediaSessionJoined(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    public final void trackOpenGiftAcceptModal(String giftCode, String location, long channelId) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        this.dispatcher.schedule(new AnonymousClass1(giftCode, channelId, location));
    }

    public final void trackSearchResultSelected(SearchType searchType, int totalResultsCount, Traits.Location locationTrait, Traits.Source sourceTrait) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultSelected(searchType, locationTrait, sourceTrait, totalResultsCount, getSnapshotAnalyticsProperties());
    }

    public final void trackSearchResultViewed(SearchType searchType, int totalResultsCount, Integer lockedResultsCount, Traits.Location locationTrait, boolean throttle) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultViewed(searchType, totalResultsCount, lockedResultsCount, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackSearchResultsEmpty(SearchType searchType, Traits.Location locationTrait, boolean throttle) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultsEmpty(searchType, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackSearchStarted(SearchType searchType, Traits.Location locationTrait, boolean throttle) {
        Intrinsics3.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchStart(searchType, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackShowCallFeedbackSheet(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    public final void trackStreamReportProblem(PendingFeedback.StreamFeedback pendingStreamFeedback) {
        Intrinsics3.checkNotNullParameter(pendingStreamFeedback, "pendingStreamFeedback");
        AnalyticsTracker.INSTANCE.reportStreamProblem(pendingStreamFeedback.getStream(), pendingStreamFeedback.getFeedbackRating(), getStreamFeedbackReasonFromIssue(pendingStreamFeedback.getIssue()), pendingStreamFeedback.getMediaSessionId(), pendingStreamFeedback.getIssueDetails());
    }

    @Store3
    public final void trackTextInVoiceOpened(long channelId, StoreChannelsSelected3 analyticsLocation) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            AnalyticsTracker.INSTANCE.textInVoiceOpened(channelId, new StoreAnalytics3(channelFindChannelByIdInternal$app_productionGoogleRelease, this, channelId, analyticsLocation));
        }
    }

    public final void trackThreadBrowserTabChanged(long channelId, String tabType) {
        Intrinsics3.checkNotNullParameter(tabType, "tabType");
        AnalyticsTracker.INSTANCE.threadBrowserTabChanged(getGuildAndChannelSnapshotAnalyticsProperties(channelId), tabType);
    }

    public final void trackVideoLayoutToggled(String videoLayout, long meId, Channel channel) {
        Intrinsics3.checkNotNullParameter(videoLayout, "videoLayout");
        AnalyticsTracker.INSTANCE.videoLayoutToggled(videoLayout, meId, channel);
    }

    @Store3
    public final void trackVideoStreamEnded(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        Object obj = properties.get("sender_user_id");
        if (!(obj instanceof Long)) {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            long jLongValue = l.longValue();
            Object obj2 = properties.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
            if (!(obj2 instanceof Long)) {
                obj2 = null;
            }
            Long l2 = (Long) obj2;
            if (l2 != null) {
                long jLongValue2 = l2.longValue();
                Object obj3 = properties.get(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID);
                Integer maxViewersForStream = this.stores.getApplicationStreaming().getMaxViewersForStream(jLongValue, jLongValue2, (Long) (obj3 instanceof Long ? obj3 : null));
                if (maxViewersForStream != null) {
                    properties.put("max_viewers", maxViewersForStream);
                }
                AnalyticsTracker.INSTANCE.videoStreamEnded(properties);
            }
        }
    }

    public final void trackVoiceAudioOutputModeSelected(long channelId, DiscordAudioManager.DeviceTypes fromAudioOutputMode, DiscordAudioManager.DeviceTypes toAudioOutputMode) {
        Intrinsics3.checkNotNullParameter(fromAudioOutputMode, "fromAudioOutputMode");
        Intrinsics3.checkNotNullParameter(toAudioOutputMode, "toAudioOutputMode");
        this.dispatcher.schedule(new AnonymousClass1(channelId, fromAudioOutputMode, toAudioOutputMode));
    }

    public final void trackVoiceConnectionFailure(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    public final void trackVoiceConnectionSuccess(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    @Store3
    public final void trackVoiceDisconnect(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new AnonymousClass1(properties));
    }

    public static /* synthetic */ Map getChannelSnapshotAnalyticsProperties$default(StoreAnalytics storeAnalytics, Channel channel, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(channel, z2);
    }

    private final Map<String, Object> getGuildSnapshotAnalyticsProperties(Guild guild) {
        GuildMember guildMember;
        List<Long> roles;
        int approximateMemberCount = this.stores.getGuildMemberCounts().getApproximateMemberCount(guild.getId());
        Collection<Channel> collectionValues = this.stores.getChannels().getChannelsForGuild(guild.getId()).values();
        Map map = (Map) outline.e(guild, this.stores.getGuilds().getRoles());
        int size = map != null ? map.size() : 0;
        long id2 = this.stores.getUsers().getMeSnapshot().getId();
        Map map2 = (Map) outline.e(guild, this.stores.getGuilds().getMembers());
        int size2 = (map2 == null || (guildMember = (GuildMember) map2.get(Long.valueOf(id2))) == null || (roles = guildMember.getRoles()) == null) ? 0 : roles.size();
        Long l = (Long) outline.e(guild, this.stores.getPermissions().getGuildPermissions());
        return guildPropertiesMap(guild.getId(), approximateMemberCount, collectionValues, size, size2, l != null ? l.longValue() : 0L, guild.getFeatures().contains(GuildFeature.VIP_REGIONS));
    }

    private final Map<String, Object> getChannelSnapshotAnalyticsProperties(Channel channel, boolean includeNsfw) {
        PermissionOverwrite permissionOverwrite;
        Object next;
        Long l = (Long) outline.d(channel, this.stores.getPermissions().getPermissionsByChannel());
        List<PermissionOverwrite> listV = channel.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((PermissionOverwrite) next).e() == channel.getGuildId()));
            permissionOverwrite = (PermissionOverwrite) next;
        } else {
            permissionOverwrite = null;
        }
        return Maps6.plus(Maps6.plus(AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channel), Maps6.mapOf(Tuples.to("channel_member_perms", l), Tuples.to("channel_hidden", permissionOverwrite != null ? Boolean.valueOf(PermissionOverwriteUtils.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) : null))), includeNsfw ? MapsJVM.mapOf(Tuples.to("channel_is_nsfw", Boolean.valueOf(channel.getNsfw()))) : Maps6.emptyMap());
    }

    public final void inviteSent(GuildInvite invite, Channel channel, Message message, String location) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Tuples2[] tuples2Arr = new Tuples2[5];
        tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        tuples2Arr[1] = Tuples.to("message_id", Long.valueOf(message.getId()));
        tuples2Arr[2] = Tuples.to("invite_guild_id", invite != null ? invite.getGuildId() : null);
        tuples2Arr[3] = Tuples.to("invite_channel_id", invite != null ? invite.getChannelId() : null);
        tuples2Arr[4] = Tuples.to("invite_guild_scheduled_event_id", invite != null ? invite.getGuildScheduledEventId() : null);
        AnalyticsTracker.INSTANCE.inviteSent(invite, channel, Maps6.plus(Maps6.mapOf(tuples2Arr), getGuildAndChannelSnapshotAnalyticsProperties(message.getChannelId())));
    }
}
