package com.discord.utilities.voice;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.voice.model.CallModel;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(VoiceEngineServiceController$Companion$INSTANCE$2.INSTANCE);
    private static final NotificationData NOTIFICATION_DATA_DISCONNECTED = new NotificationData(new RtcConnection.State.C5610d(false), "", false, false, false, false, -1, null, false, false);
    private final StoreAudioManagerV2 audioManagerStore;
    private final StoreMediaSettings mediaSettingsStore;
    private final Observable<NotificationData> notificationDataObservable;
    private VoiceEngineForegroundService.Connection serviceBinding;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* JADX INFO: compiled from: VoiceEngineServiceController.kt */
    public static final class Companion {
        private Companion() {
        }

        public final VoiceEngineServiceController getINSTANCE() {
            Lazy lazy = VoiceEngineServiceController.INSTANCE$delegate;
            Companion companion = VoiceEngineServiceController.INSTANCE;
            return (VoiceEngineServiceController) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: VoiceEngineServiceController.kt */
    public static final /* data */ class NotificationData {
        private final boolean canSpeak;
        private final long channelId;
        private final String channelName;
        private final Long guildId;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final boolean isSelfStreaming;
        private final boolean isVideo;
        private final boolean proximityLockEnabled;
        private final RtcConnection.State rtcConnectionState;

        @StringRes
        private final int stateString;

        public NotificationData(RtcConnection.State state, String str, boolean z2, boolean z3, boolean z4, boolean z5, long j, Long l, boolean z6, boolean z7) {
            int i;
            C12238m.checkNotNullParameter(state, "rtcConnectionState");
            C12238m.checkNotNullParameter(str, "channelName");
            this.rtcConnectionState = state;
            this.channelName = str;
            this.isSelfMuted = z2;
            this.isSelfDeafened = z3;
            this.isSelfStreaming = z4;
            this.isVideo = z5;
            this.channelId = j;
            this.guildId = l;
            this.proximityLockEnabled = z6;
            this.canSpeak = z7;
            if (state instanceof RtcConnection.State.C5610d) {
                i = C5419R.string.connection_status_disconnected;
            } else if (C12238m.areEqual(state, RtcConnection.State.C5608b.f18810a)) {
                i = C5419R.string.connection_status_awaiting_endpoint;
            } else if (C12238m.areEqual(state, RtcConnection.State.C5607a.f18809a)) {
                i = C5419R.string.connection_status_authenticating;
            } else if (C12238m.areEqual(state, RtcConnection.State.C5609c.f18811a)) {
                i = C5419R.string.connection_status_connecting;
            } else if (C12238m.areEqual(state, RtcConnection.State.C5614h.f18816a)) {
                i = C5419R.string.connection_status_rtc_disconnected;
            } else if (C12238m.areEqual(state, RtcConnection.State.C5613g.f18815a)) {
                i = C5419R.string.connection_status_rtc_connecting;
            } else if (C12238m.areEqual(state, RtcConnection.State.C5612f.f18814a)) {
                i = z4 ? C5419R.string.connection_status_stream_self_connected : z5 ? C5419R.string.connection_status_video_connected : C5419R.string.connection_status_voice_connected;
            } else {
                if (!C12238m.areEqual(state, RtcConnection.State.C5611e.f18813a)) {
                    throw new NoWhenBranchMatchedException();
                }
                i = C5419R.string.connection_status_no_route;
            }
            this.stateString = i;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getCanSpeak() {
            return this.canSpeak;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsSelfMuted() {
            return this.isSelfMuted;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsSelfDeafened() {
            return this.isSelfDeafened;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsSelfStreaming() {
            return this.isSelfStreaming;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsVideo() {
            return this.isVideo;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getProximityLockEnabled() {
            return this.proximityLockEnabled;
        }

        public final NotificationData copy(RtcConnection.State rtcConnectionState, String channelName, boolean isSelfMuted, boolean isSelfDeafened, boolean isSelfStreaming, boolean isVideo, long channelId, Long guildId, boolean proximityLockEnabled, boolean canSpeak) {
            C12238m.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            C12238m.checkNotNullParameter(channelName, "channelName");
            return new NotificationData(rtcConnectionState, channelName, isSelfMuted, isSelfDeafened, isSelfStreaming, isVideo, channelId, guildId, proximityLockEnabled, canSpeak);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotificationData)) {
                return false;
            }
            NotificationData notificationData = (NotificationData) other;
            return C12238m.areEqual(this.rtcConnectionState, notificationData.rtcConnectionState) && C12238m.areEqual(this.channelName, notificationData.channelName) && this.isSelfMuted == notificationData.isSelfMuted && this.isSelfDeafened == notificationData.isSelfDeafened && this.isSelfStreaming == notificationData.isSelfStreaming && this.isVideo == notificationData.isVideo && this.channelId == notificationData.channelId && C12238m.areEqual(this.guildId, notificationData.guildId) && this.proximityLockEnabled == notificationData.proximityLockEnabled && this.canSpeak == notificationData.canSpeak;
        }

        public final boolean getCanSpeak() {
            return this.canSpeak;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final boolean getProximityLockEnabled() {
            return this.proximityLockEnabled;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final int getStateString() {
            return this.stateString;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v18, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            String str = this.channelName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isSelfMuted;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            boolean z3 = this.isSelfDeafened;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.isSelfStreaming;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i3 = (i2 + r4) * 31;
            boolean z5 = this.isVideo;
            ?? r5 = z5;
            if (z5) {
                r5 = 1;
            }
            int iM3a = (C0002b.m3a(this.channelId) + ((i3 + r5) * 31)) * 31;
            Long l = this.guildId;
            int iHashCode3 = (iM3a + (l != null ? l.hashCode() : 0)) * 31;
            boolean z6 = this.proximityLockEnabled;
            ?? r0 = z6;
            if (z6) {
                r0 = 1;
            }
            int i4 = (iHashCode3 + r0) * 31;
            boolean z7 = this.canSpeak;
            return i4 + (z7 ? 1 : z7);
        }

        public final boolean isSelfDeafened() {
            return this.isSelfDeafened;
        }

        public final boolean isSelfMuted() {
            return this.isSelfMuted;
        }

        public final boolean isSelfStreaming() {
            return this.isSelfStreaming;
        }

        public final boolean isVideo() {
            return this.isVideo;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("NotificationData(rtcConnectionState=");
            sbM833U.append(this.rtcConnectionState);
            sbM833U.append(", channelName=");
            sbM833U.append(this.channelName);
            sbM833U.append(", isSelfMuted=");
            sbM833U.append(this.isSelfMuted);
            sbM833U.append(", isSelfDeafened=");
            sbM833U.append(this.isSelfDeafened);
            sbM833U.append(", isSelfStreaming=");
            sbM833U.append(this.isSelfStreaming);
            sbM833U.append(", isVideo=");
            sbM833U.append(this.isVideo);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", proximityLockEnabled=");
            sbM833U.append(this.proximityLockEnabled);
            sbM833U.append(", canSpeak=");
            return C1643a.m827O(sbM833U, this.canSpeak, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreMediaSettings.SelfMuteFailure.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreMediaSettings.SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$1 */
    /* JADX INFO: compiled from: VoiceEngineServiceController.kt */
    public static final class C70511 extends AbstractC12240o implements Function0<Unit> {
        public C70511() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            VoiceEngineServiceController.this.voiceChannelSelectedStore.clear();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$2 */
    /* JADX INFO: compiled from: VoiceEngineServiceController.kt */
    public static final class C70522 extends AbstractC12240o implements Function0<Unit> {
        public C70522() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            VoiceEngineServiceController.this.mediaSettingsStore.toggleSelfDeafened();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$3 */
    /* JADX INFO: compiled from: VoiceEngineServiceController.kt */
    public static final class C70533 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70533(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMediaSettings.SelfMuteFailure selfMuteFailure = VoiceEngineServiceController.this.mediaSettingsStore.toggleSelfMuted();
            if (selfMuteFailure == null || selfMuteFailure.ordinal() != 0) {
                return;
            }
            C0876m.m169g(this.$context, C5419R.string.vad_permission_small, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$4 */
    /* JADX INFO: compiled from: VoiceEngineServiceController.kt */
    public static final class C70544 extends AbstractC12240o implements Function1<NotificationData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70544(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationData notificationData) {
            invoke2(notificationData);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationData notificationData) {
            if (notificationData.getRtcConnectionState() instanceof RtcConnection.State.C5610d) {
                DiscordOverlayService.INSTANCE.launchForClose(this.$context);
                VoiceEngineForegroundService.INSTANCE.stopForegroundAndUnbind(VoiceEngineServiceController.access$getServiceBinding$p(VoiceEngineServiceController.this));
                return;
            }
            Context context = this.$context;
            VoiceEngineForegroundService.INSTANCE.startForegroundAndBind(VoiceEngineServiceController.access$getServiceBinding$p(VoiceEngineServiceController.this), C1107b.m216h(context, C5419R.string.call_mobile_tap_to_return, new Object[]{C1107b.m216h(context, notificationData.getStateString(), new Object[0], null, 4)}, null, 4), notificationData.getChannelName(), notificationData.isSelfMuted(), notificationData.isSelfDeafened(), notificationData.isSelfStreaming(), notificationData.getChannelId(), notificationData.getGuildId(), notificationData.getProximityLockEnabled(), notificationData.getCanSpeak());
            if (C12238m.areEqual(notificationData.getRtcConnectionState(), RtcConnection.State.C5612f.f18814a)) {
                DiscordOverlayService.INSTANCE.launchForVoice(this.$context);
            }
        }
    }

    public VoiceEngineServiceController(StoreAudioManagerV2 storeAudioManagerV2, StoreMediaSettings storeMediaSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection) {
        C12238m.checkNotNullParameter(storeAudioManagerV2, "audioManagerStore");
        C12238m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        this.audioManagerStore = storeAudioManagerV2;
        this.mediaSettingsStore = storeMediaSettings;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        Observable<R> observableM11099Y = storeRtcConnection.getConnectionState().m11099Y(new InterfaceC12589b<RtcConnection.StateChange, Observable<? extends NotificationData>>() { // from class: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends VoiceEngineServiceController.NotificationData> call(RtcConnection.StateChange stateChange) {
                final RtcConnection.State state = stateChange.state;
                return C12238m.areEqual(state, RtcConnection.State.C5614h.f18816a) ? new C12721k(VoiceEngineServiceController.NOTIFICATION_DATA_DISCONNECTED) : this.this$0.voiceChannelSelectedStore.observeSelectedVoiceChannelId().m11099Y(new InterfaceC12589b<Long, Observable<? extends VoiceEngineServiceController.NotificationData>>() { // from class: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends VoiceEngineServiceController.NotificationData> call(Long l) {
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = VoiceEngineServiceController$notificationDataObservable$1.this.this$0.mediaSettingsStore.getVoiceConfig();
                        Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = VoiceEngineServiceController$notificationDataObservable$1.this.this$0.audioManagerStore.observeAudioManagerState();
                        CallModel.Companion companion = CallModel.INSTANCE;
                        C12238m.checkNotNullExpressionValue(l, "selectedVoiceChannelId");
                        return ObservableWithLeadingEdgeThrottle.combineLatest(voiceConfig, observableObserveAudioManagerState, companion.get(l.longValue()), new Func3<StoreMediaSettings.VoiceConfiguration, StoreAudioManagerV2.State, CallModel, VoiceEngineServiceController.NotificationData>() { // from class: com.discord.utilities.voice.VoiceEngineServiceController.notificationDataObservable.1.1.1
                            @Override // p658rx.functions.Func3
                            public final VoiceEngineServiceController.NotificationData call(StoreMediaSettings.VoiceConfiguration voiceConfiguration, StoreAudioManagerV2.State state2, CallModel callModel) {
                                Channel channel;
                                Channel channel2;
                                Channel channel3;
                                boolean z2 = false;
                                boolean z3 = callModel != null && callModel.getIsVideoCall();
                                boolean z4 = !z3 && (state2.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE);
                                boolean z5 = callModel == null || !callModel.isSuppressed();
                                RtcConnection.State state3 = state;
                                String strM7679c = (callModel == null || (channel3 = callModel.getChannel()) == null) ? null : ChannelUtils.m7679c(channel3);
                                if (strM7679c == null) {
                                    strM7679c = "";
                                }
                                boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                                boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                                boolean z6 = callModel != null && callModel.isStreaming();
                                long id2 = (callModel == null || (channel2 = callModel.getChannel()) == null) ? -1L : channel2.getId();
                                Long lValueOf = (callModel == null || (channel = callModel.getChannel()) == null) ? null : Long.valueOf(channel.getGuildId());
                                if (lValueOf != null && lValueOf.longValue() > 0) {
                                    z2 = true;
                                }
                                if (!z2) {
                                    lValueOf = null;
                                }
                                return new VoiceEngineServiceController.NotificationData(state3, strM7679c, zIsSelfMuted, zIsSelfDeafened, z6, z3, id2, lValueOf, z4, z5);
                            }
                        }, 300L, TimeUnit.MILLISECONDS);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "rtcConnectionStore\n     …            }\n          }");
        this.notificationDataObservable = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
    }

    public static final /* synthetic */ VoiceEngineForegroundService.Connection access$getServiceBinding$p(VoiceEngineServiceController voiceEngineServiceController) {
        VoiceEngineForegroundService.Connection connection = voiceEngineServiceController.serviceBinding;
        if (connection == null) {
            C12238m.throwUninitializedPropertyAccessException("serviceBinding");
        }
        return connection;
    }

    public final void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        companion.setOnDisconnect(new C70511());
        companion.setOnToggleSelfDeafen(new C70522());
        companion.setOnToggleSelfMute(new C70533(context));
        this.serviceBinding = new VoiceEngineForegroundService.Connection(context);
        Observable<NotificationData> observable = this.notificationDataObservable;
        C12238m.checkNotNullExpressionValue(observable, "notificationDataObservable");
        ObservableExtensionsKt.appSubscribe(observable, (Class<?>) VoiceEngineServiceController.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C70544(context));
    }

    public final void startStream(Intent permissionIntent) {
        C12238m.checkNotNullParameter(permissionIntent, "permissionIntent");
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        VoiceEngineForegroundService.Connection connection = this.serviceBinding;
        if (connection == null) {
            C12238m.throwUninitializedPropertyAccessException("serviceBinding");
        }
        companion.startStream(connection, permissionIntent);
    }

    public final void stopStream() {
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        VoiceEngineForegroundService.Connection connection = this.serviceBinding;
        if (connection == null) {
            C12238m.throwUninitializedPropertyAccessException("serviceBinding");
        }
        companion.stopStream(connection);
    }
}
