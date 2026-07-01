package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.a.q.w;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.App;
import com.discord.app.AppLog;
import com.discord.gateway.io.Outgoing2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.debug.DebugPrintable3;
import com.discord.utilities.error.Error;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.ssl.SecureSocketsLayerUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRtcConnection extends RtcConnection.b implements DebugPrintable {
    private static final long SPEAKING_UPDATES_BUFFER_MS = 300;
    private static int instanceCounter;
    private final Clock clock;
    private final Observable<RtcConnection.StateChange> connectionState;
    private final SerializedSubject<RtcConnection.StateChange, RtcConnection.StateChange> connectionStateSubject;
    private Context context;
    private Outgoing2.VoiceStateUpdate currentVoiceState;
    private final long debugDisplayId;
    private final Dispatcher dispatcher;
    private final DebugPrintable3 dpc;
    private boolean hasSelectedVoiceChannel;
    private Long joinedChannelTimestamp;
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Logger logger;
    private final String loggingTag;
    private NetworkMonitor networkMonitor;
    private final Observable<RtcConnection.Quality> quality;
    private final BehaviorSubject<RtcConnection.Quality> qualitySubject;
    private RtcConnection rtcConnection;
    private RtcConnection.Metadata rtcConnectionMetadata;
    private final BehaviorSubject<RtcConnection.Metadata> rtcConnectionMetadataSubject;
    private Channel selectedVoiceChannel;
    private String sessionId;
    private final Observable<List<SpeakingUserUpdate>> speakingUpdates;
    private final PublishSubject<SpeakingUserUpdate> speakingUsersSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreRtcRegion storeRtcRegion;
    private final StoreVoiceStates storeVoiceStates;
    private final StoreStream stream;
    private StoreRtcConnection2 voicePropsTracker;
    private VoiceServer voiceServer;

    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onConnected() {
        }

        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onConnecting() {
        }

        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onFirstFrameReceived(long ssrc) {
        }

        @Override // com.discord.stores.StoreRtcConnection.Listener
        public void onFirstFrameSent() {
        }
    }

    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public interface Listener {
        void onConnected();

        void onConnecting();

        /* synthetic */ void onFirstFrameReceived(long j);

        /* synthetic */ void onFirstFrameSent();
    }

    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final /* data */ class SpeakingUserUpdate {
        private final boolean isSpeaking;
        private final long userId;

        public SpeakingUserUpdate(long j, boolean z2) {
            this.userId = j;
            this.isSpeaking = z2;
        }

        public static /* synthetic */ SpeakingUserUpdate copy$default(SpeakingUserUpdate speakingUserUpdate, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = speakingUserUpdate.userId;
            }
            if ((i & 2) != 0) {
                z2 = speakingUserUpdate.isSpeaking;
            }
            return speakingUserUpdate.copy(j, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSpeaking() {
            return this.isSpeaking;
        }

        public final SpeakingUserUpdate copy(long userId, boolean isSpeaking) {
            return new SpeakingUserUpdate(userId, isSpeaking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpeakingUserUpdate)) {
                return false;
            }
            SpeakingUserUpdate speakingUserUpdate = (SpeakingUserUpdate) other;
            return this.userId == speakingUserUpdate.userId && this.isSpeaking == speakingUserUpdate.isSpeaking;
        }

        public final long getUserId() {
            return this.userId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iA = b.a(this.userId) * 31;
            boolean z2 = this.isSpeaking;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iA + r1;
        }

        public final boolean isSpeaking() {
            return this.isSpeaking;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SpeakingUserUpdate(userId=");
            sbU.append(this.userId);
            sbU.append(", isSpeaking=");
            return outline.O(sbU, this.isSpeaking, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            RtcConnection.AnalyticsEvent.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[RtcConnection.AnalyticsEvent.VOICE_CONNECTION_SUCCESS.ordinal()] = 1;
            iArr[RtcConnection.AnalyticsEvent.VOICE_CONNECTION_FAILURE.ordinal()] = 2;
            iArr[RtcConnection.AnalyticsEvent.VOICE_DISCONNECT.ordinal()] = 3;
            iArr[RtcConnection.AnalyticsEvent.VIDEO_STREAM_ENDED.ordinal()] = 4;
            iArr[RtcConnection.AnalyticsEvent.MEDIA_SESSION_JOINED.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$createRtcConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreRtcConnection.kt */
        public static final class C01691 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ boolean $isMuted;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01691(boolean z2) {
                super(0);
                this.$isMuted = z2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.this.handleSelfMuted(this.$isMuted);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreRtcConnection.this.dispatcher.schedule(new C01691(z2));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRtcConnection.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ boolean $isDeafened;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(boolean z2) {
                super(0);
                this.$isDeafened = z2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.this.handleSelfDeafened(this.$isDeafened);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreRtcConnection.this.dispatcher.schedule(new AnonymousClass1(z2));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRtcConnection.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Boolean $isVideoSelected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(0);
                this.$isVideoSelected = bool;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection storeRtcConnection = StoreRtcConnection.this;
                Boolean bool = this.$isVideoSelected;
                Intrinsics3.checkNotNullExpressionValue(bool, "isVideoSelected");
                storeRtcConnection.handleSelfVideo(bool.booleanValue());
            }
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreRtcConnection.this.dispatcher.schedule(new AnonymousClass1(bool));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Map<Long, ? extends Float>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRtcConnection.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Map $usersVolume;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Map map) {
                super(0);
                this.$usersVolume = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.this.handleUsersVolume(this.$usersVolume);
            }
        }

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Float> map) {
            invoke2((Map<Long, Float>) map);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Float> map) {
            Intrinsics3.checkNotNullParameter(map, "usersVolume");
            StoreRtcConnection.this.dispatcher.schedule(new AnonymousClass1(map));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$6, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<Map<Long, ? extends Boolean>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRtcConnection.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Map $usersMuted;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Map map) {
                super(0);
                this.$usersMuted = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.this.handleUsersMuted(this.$usersMuted);
            }
        }

        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Boolean> map) {
            invoke2((Map<Long, Boolean>) map);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "usersMuted");
            StoreRtcConnection.this.dispatcher.schedule(new AnonymousClass1(map));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$7, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass7 extends Lambda implements Function1<Map<Long, ? extends Boolean>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$init$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreRtcConnection.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Map $usersOffScreen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Map map) {
                super(0);
                this.$usersOffScreen = map;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreRtcConnection.this.handleUsersOffScreen(this.$usersOffScreen);
            }
        }

        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Boolean> map) {
            invoke2((Map<Long, Boolean>) map);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Boolean> map) {
            Intrinsics3.checkNotNullParameter(map, "usersOffScreen");
            StoreRtcConnection.this.dispatcher.schedule(new AnonymousClass1(map));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onAnalyticsEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
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
            StoreRtcConnection.this.storeAnalytics.trackVideoStreamEnded(this.$properties);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onFirstFrameReceived$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public final /* synthetic */ long $ssrc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$ssrc = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onFirstFrameReceived(this.$ssrc);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onFirstFrameSent$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onFirstFrameSent();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onMediaEngineConnectionConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RtcConnection $connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RtcConnection rtcConnection) {
            super(0);
            this.$connection = rtcConnection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.applyVoiceConfiguration$default(StoreRtcConnection.this, this.$connection, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onMediaSessionIdReceived$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.this.handleMediaSessionIdReceived();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onSpeaking$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $isSpeaking;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$userId = j;
            this.$isSpeaking = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection2 storeRtcConnection2 = StoreRtcConnection.this.voicePropsTracker;
            if (storeRtcConnection2 != null) {
                storeRtcConnection2.handleOnSpeaking(this.$userId, this.$isSpeaking);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onStateChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnected();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onVideoMetadata$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VideoMetadata $metadata;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VideoMetadata videoMetadata) {
            super(0);
            this.$metadata = videoMetadata;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.this.stream.handleVideoMetadataUpdate(this.$metadata);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreRtcConnection$onVideoStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreRtcConnection.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $audioSsrc;
        public final /* synthetic */ int $rtxSsrc;
        public final /* synthetic */ Integer $streamId;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ int $videoSsrc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Integer num, int i, int i2, int i3) {
            super(0);
            this.$userId = j;
            this.$streamId = num;
            this.$audioSsrc = i;
            this.$videoSsrc = i2;
            this.$rtxSsrc = i3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreRtcConnection.this.stream.handleVideoStreamUpdate(this.$userId, this.$streamId, this.$audioSsrc, this.$videoSsrc, this.$rtxSsrc);
        }
    }

    public /* synthetic */ StoreRtcConnection(StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreRtcRegion storeRtcRegion, StoreAnalytics storeAnalytics, StoreVoiceStates storeVoiceStates, Logger logger, DebugPrintable3 debugPrintable3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, clock, storeRtcRegion, storeAnalytics, storeVoiceStates, (i & 64) != 0 ? AppLog.g : logger, (i & 128) != 0 ? SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease() : debugPrintable3);
    }

    private final void applyVoiceConfiguration(RtcConnection rtcConnection, Long targetUserId) {
        StoreMediaSettings.VoiceConfiguration voiceConfigurationBlocking = this.stream.getMediaSettings().getVoiceConfigurationBlocking();
        for (Map.Entry<Long, Float> entry : voiceConfigurationBlocking.getUserOutputVolumes().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            float fFloatValue = entry.getValue().floatValue();
            if (targetUserId == null || jLongValue == targetUserId.longValue()) {
                rtcConnection.v(jLongValue, fFloatValue);
            }
        }
        for (Map.Entry<Long, Boolean> entry2 : voiceConfigurationBlocking.getMutedUsers().entrySet()) {
            long jLongValue2 = entry2.getKey().longValue();
            boolean zBooleanValue = entry2.getValue().booleanValue();
            if (targetUserId == null || jLongValue2 == targetUserId.longValue()) {
                rtcConnection.mutedUsers.put(Long.valueOf(jLongValue2), Boolean.valueOf(zBooleanValue));
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection != null) {
                    mediaEngineConnection.w(jLongValue2, zBooleanValue);
                }
            }
        }
        for (Map.Entry<Long, Boolean> entry3 : voiceConfigurationBlocking.getOffScreenUsers().entrySet()) {
            long jLongValue3 = entry3.getKey().longValue();
            boolean zBooleanValue2 = entry3.getValue().booleanValue();
            if (targetUserId == null || jLongValue3 == targetUserId.longValue()) {
                MediaEngineConnection mediaEngineConnection2 = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection2 == null) {
                    Log.e("RtcConnection", "MediaEngine not connected for setLocalVideoOffscreen.");
                } else {
                    mediaEngineConnection2.d(jLongValue3, zBooleanValue2);
                }
            }
        }
    }

    public static /* synthetic */ void applyVoiceConfiguration$default(StoreRtcConnection storeRtcConnection, RtcConnection rtcConnection, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        storeRtcConnection.applyVoiceConfiguration(rtcConnection, l);
    }

    @Store3
    private final void checkForVoiceServerUpdate() {
        String endpoint;
        RtcConnection rtcConnection = this.rtcConnection;
        VoiceServer voiceServer = this.voiceServer;
        if (rtcConnection == null || voiceServer == null) {
            return;
        }
        if (voiceServer.getGuildId() == null || !(!Intrinsics3.areEqual(voiceServer.getGuildId(), rtcConnection.guildId))) {
            if (voiceServer.getChannelId() != null) {
                Long channelId = voiceServer.getChannelId();
                long j = rtcConnection.channelId;
                if (channelId == null || channelId.longValue() != j) {
                    return;
                }
            }
            Objects.requireNonNull(App.INSTANCE);
            SSLSocketFactory sSLSocketFactoryCreateSocketFactory$default = null;
            if (App.IS_LOCAL) {
                endpoint = "";
            } else {
                endpoint = voiceServer.getEndpoint();
                sSLSocketFactoryCreateSocketFactory$default = SecureSocketsLayerUtils.createSocketFactory$default(null, 1, null);
            }
            recordBreadcrumb(outline.w("Voice server update, connect to server w/ endpoint: ", endpoint));
            rtcConnection.s(new w(rtcConnection, endpoint, voiceServer.getToken(), sSLSocketFactoryCreateSocketFactory$default));
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    @Store3
    private final void createRtcConnection() {
        Long l;
        long id2 = this.stream.getUsers().getMe().getId();
        String str = this.sessionId;
        Channel channel = this.selectedVoiceChannel;
        if (channel != null) {
            Long lValueOf = Long.valueOf(channel.getGuildId());
            if (lValueOf.longValue() > 0) {
                l = lValueOf;
            } else {
                l = null;
            }
        } else {
            l = null;
        }
        Channel channel2 = this.selectedVoiceChannel;
        Long lValueOf2 = channel2 != null ? Long.valueOf(channel2.getId()) : null;
        MediaEngine mediaEngine = StoreStream.INSTANCE.getMediaEngine().getMediaEngine();
        if (str == null || lValueOf2 == null) {
            return;
        }
        RtcConnection rtcConnection = this.rtcConnection;
        if (Intrinsics3.areEqual(rtcConnection != null ? Long.valueOf(rtcConnection.channelId) : null, lValueOf2)) {
            RtcConnection rtcConnection2 = this.rtcConnection;
            if (Intrinsics3.areEqual(rtcConnection2 != null ? rtcConnection2.sessionId : null, str)) {
                return;
            }
        }
        long jLongValue = l != null ? l.longValue() : 0L;
        this.voicePropsTracker = new StoreRtcConnection2(jLongValue, lValueOf2.longValue(), id2, this.storeVoiceStates.get().get(Long.valueOf(jLongValue)));
        Experiment userExperiment = this.stream.getExperiments().getUserExperiment("2021-03_android_media_sink_wants", false);
        boolean z2 = userExperiment != null && userExperiment.getBucket() == 1;
        RtcConnection rtcConnection3 = this.rtcConnection;
        if (rtcConnection3 != null) {
            rtcConnection3.e();
        }
        long jLongValue2 = lValueOf2.longValue();
        String strValueOf = String.valueOf(l != null ? l.longValue() : lValueOf2.longValue());
        Logger logger = this.logger;
        String str2 = this.loggingTag;
        NetworkMonitor networkMonitor = this.networkMonitor;
        if (networkMonitor == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("networkMonitor");
        }
        RtcConnection rtcConnection4 = new RtcConnection(l, jLongValue2, str, true, strValueOf, id2, mediaEngine, logger, ClockFactory.get(), null, networkMonitor, Maps6.toMutableMap(this.stream.getMediaSettings().getMutedUsers()), null, null, z2, str2, null, 78336);
        rtcConnection4.c(this);
        this.rtcConnection = rtcConnection4;
        this.listenerSubject.notify(AnonymousClass1.INSTANCE);
        updateMetadata();
    }

    @Store3
    private final void destroyRtcConnection(String reason) {
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            recordBreadcrumb(outline.w("destroying rtc connection: ", reason));
            rtcConnection.e();
            this.rtcConnection = null;
            updateMetadata();
        }
    }

    @Store3
    private final void handleMediaSessionIdReceived() {
        AppLog appLog = AppLog.g;
        RtcConnection rtcConnection = this.rtcConnection;
        String str = rtcConnection != null ? rtcConnection.mediaSessionId : null;
        Objects.requireNonNull(appLog);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (str == null) {
            str = "";
        }
        firebaseCrashlytics.setCustomKey("mediaSessionId", str);
        updateMetadata();
    }

    @Store3
    private final void handleSelfDeafened(boolean selfDeafened) {
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, false, selfDeafened, false, null, 55, null);
        onVoiceStateUpdated();
    }

    @Store3
    private final void handleSelfMuted(boolean selfMuted) {
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, selfMuted, false, false, null, 59, null);
        onVoiceStateUpdated();
    }

    @Store3
    private final void handleSelfVideo(boolean selfVideo) {
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(this.currentVoiceState, null, null, false, false, selfVideo, null, 47, null);
        onVoiceStateUpdated();
    }

    @Store3
    private final void handleUsersMuted(Map<Long, Boolean> usersMuted) {
        for (Map.Entry<Long, Boolean> entry : usersMuted.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            boolean zBooleanValue = entry.getValue().booleanValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.mutedUsers.put(Long.valueOf(jLongValue), Boolean.valueOf(zBooleanValue));
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection != null) {
                    mediaEngineConnection.w(jLongValue, zBooleanValue);
                }
            }
        }
    }

    @Store3
    private final void handleUsersOffScreen(Map<Long, Boolean> usersOffScreen) {
        for (Map.Entry<Long, Boolean> entry : usersOffScreen.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            boolean zBooleanValue = entry.getValue().booleanValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                MediaEngineConnection mediaEngineConnection = rtcConnection.mediaEngineConnection;
                if (mediaEngineConnection == null) {
                    Log.e("RtcConnection", "MediaEngine not connected for setLocalVideoOffscreen.");
                } else {
                    mediaEngineConnection.d(jLongValue, zBooleanValue);
                }
            }
        }
    }

    @Store3
    private final void handleUsersVolume(Map<Long, Float> usersVolume) {
        for (Map.Entry<Long, Float> entry : usersVolume.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            float fFloatValue = entry.getValue().floatValue();
            RtcConnection rtcConnection = this.rtcConnection;
            if (rtcConnection != null) {
                rtcConnection.v(jLongValue, fFloatValue);
            }
        }
    }

    @Store3
    private final void logChannelJoin(Channel channel) {
        String str;
        long id2 = this.stream.getUsers().getMe().getId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (str = rtcConnection.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String) == null) {
            return;
        }
        StageInstance stageInstanceForChannel = this.stream.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long lValueOf = stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null;
        GuildScheduledEvent activeEventForChannel = this.stream.getGuildScheduledEvents().getActiveEventForChannel(Long.valueOf(channel.getGuildId()), Long.valueOf(channel.getId()));
        Long lValueOf2 = activeEventForChannel != null ? Long.valueOf(activeEventForChannel.getId()) : null;
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Map<Long, VoiceState> mapEmptyMap = (Map) outline.c(channel, this.stream.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Map<Long, VoiceState> map = mapEmptyMap;
        DeviceDescription4 selectedVideoInputDevice = this.stream.getMediaEngine().getSelectedVideoInputDevice();
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context context = this.context;
        if (context == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("context");
        }
        analyticsTracker.voiceChannelJoin(id2, str, channel, map, selectedVideoInputDevice, networkUtils.getNetworkType(context), lValueOf, lValueOf2);
    }

    @Store3
    private final void logChannelLeave(Channel channel) {
        String str;
        long id2 = this.stream.getUsers().getMe().getId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (str = rtcConnection.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_ID java.lang.String) == null) {
            return;
        }
        String str2 = rtcConnection != null ? rtcConnection.mediaSessionId : null;
        StageInstance stageInstanceForChannel = this.stream.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long lValueOf = stageInstanceForChannel != null ? Long.valueOf(stageInstanceForChannel.getId()) : null;
        GuildScheduledEvent activeEventForChannel = this.stream.getGuildScheduledEvents().getActiveEventForChannel(Long.valueOf(channel.getGuildId()), Long.valueOf(channel.getId()));
        Long lValueOf2 = activeEventForChannel != null ? Long.valueOf(activeEventForChannel.getId()) : null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StoreRtcConnection2 storeRtcConnection2 = this.voicePropsTracker;
        if (storeRtcConnection2 != null) {
            storeRtcConnection2.getProps(linkedHashMap);
        }
        this.voicePropsTracker = null;
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        Map<Long, VoiceState> mapEmptyMap = (Map) outline.c(channel, this.stream.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Map<Long, VoiceState> map = mapEmptyMap;
        Long l = this.joinedChannelTimestamp;
        analyticsTracker.voiceChannelLeave(id2, str, channel, map, str2, linkedHashMap, l != null ? Long.valueOf(this.clock.currentTimeMillis() - l.longValue()) : null, lValueOf, lValueOf2);
    }

    private final void loge(String msg, Throwable e, Map<String, String> metadata) {
        this.logger.e(this.loggingTag, msg, e, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loge$default(StoreRtcConnection storeRtcConnection, String str, Throwable th, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        storeRtcConnection.loge(str, th, map);
    }

    private final void logi(String msg, Throwable e) {
        this.logger.i(this.loggingTag, msg, e);
    }

    public static /* synthetic */ void logi$default(StoreRtcConnection storeRtcConnection, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        storeRtcConnection.logi(str, th);
    }

    private final void logw(String msg) {
        Logger.w$default(this.logger, this.loggingTag, msg, null, 4, null);
    }

    @Store3
    private final void onVoiceStateUpdated() {
        String preferredRegion;
        if (this.hasSelectedVoiceChannel) {
            StringBuilder sbU = outline.U("Voice state update: ");
            sbU.append(this.currentVoiceState);
            recordBreadcrumb(sbU.toString());
        }
        StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
        Long guildId = this.currentVoiceState.getGuildId();
        Long channelId = this.currentVoiceState.getChannelId();
        boolean selfMute = this.currentVoiceState.getSelfMute();
        boolean selfDeaf = this.currentVoiceState.getSelfDeaf();
        boolean selfVideo = this.currentVoiceState.getSelfVideo();
        Long channelId2 = this.currentVoiceState.getChannelId();
        if (channelId2 != null) {
            channelId2.longValue();
            preferredRegion = this.storeRtcRegion.getPreferredRegion();
        } else {
            preferredRegion = null;
        }
        gatewaySocket.voiceStateUpdate(guildId, channelId, selfMute, selfDeaf, selfVideo, preferredRegion, this.storeRtcRegion.shouldIncludePreferredRegion(this.currentVoiceState.getGuildId()));
    }

    private final void recordBreadcrumb(String message) {
        this.logger.recordBreadcrumb(message, this.loggingTag);
    }

    @Store3
    private final void updateMetadata() {
        RtcConnection rtcConnection = this.rtcConnection;
        RtcConnection.Metadata metadataI = rtcConnection != null ? rtcConnection.i() : null;
        this.rtcConnectionMetadata = metadataI;
        this.rtcConnectionMetadataSubject.onNext(metadataI);
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 dp) {
        Intrinsics3.checkNotNullParameter(dp, "dp");
        dp.appendKeyValue("sessionId", this.sessionId);
        dp.appendKeyValue("rtcConnection", (DebugPrintable) this.rtcConnection);
    }

    public final void finalize() {
        this.dpc.remove(this.debugDisplayId);
    }

    public final long getConnectedGuildId() {
        Long l;
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection == null || (l = rtcConnection.guildId) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final Observable<RtcConnection.StateChange> getConnectionState() {
        return this.connectionState;
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final Observable<RtcConnection.Quality> getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: getRtcConnection$app_productionGoogleRelease, reason: from getter */
    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    @Store3
    public final RtcConnection.Metadata getRtcConnectionMetadata() {
        return this.rtcConnectionMetadata;
    }

    public final Observable<List<SpeakingUserUpdate>> getSpeakingUpdates() {
        return this.speakingUpdates;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        RtcConnection rtcConnection = this.rtcConnection;
        if (rtcConnection != null) {
            String sessionId = payload.getSessionId();
            Intrinsics3.checkNotNullExpressionValue(sessionId, "payload.sessionId");
            Intrinsics3.checkNotNullParameter(sessionId, "<set-?>");
            rtcConnection.sessionId = sessionId;
        }
    }

    @Store3
    public final void handleConnectionReady(boolean connected) {
        if (connected) {
            Channel channel = this.selectedVoiceChannel;
            handleVoiceChannelSelected(Long.valueOf(channel != null ? channel.getId() : 0L));
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    @Store3
    public final void handleVoiceChannelSelected(Long channelId) {
        Long l;
        Channel channel = this.selectedVoiceChannel;
        if (!Intrinsics3.areEqual(channelId, channel != null ? Long.valueOf(channel.getId()) : null)) {
            Channel channel2 = this.selectedVoiceChannel;
            if (channel2 != null) {
                logChannelLeave(channel2);
            }
            this.joinedChannelTimestamp = null;
            StringBuilder sb = new StringBuilder();
            sb.append("Channel ID changed, ");
            sb.append(channelId);
            sb.append(" != ");
            Channel channel3 = this.selectedVoiceChannel;
            sb.append(channel3 != null ? Long.valueOf(channel3.getId()) : null);
            destroyRtcConnection(sb.toString());
        }
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = channelId != null ? this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId.longValue()) : null;
        this.selectedVoiceChannel = channelFindChannelByIdInternal$app_productionGoogleRelease;
        Outgoing2.VoiceStateUpdate voiceStateUpdate = this.currentVoiceState;
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            Long lValueOf = Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId());
            if (lValueOf.longValue() > 0) {
                l = lValueOf;
            } else {
                l = null;
            }
        } else {
            l = null;
        }
        this.currentVoiceState = Outgoing2.VoiceStateUpdate.copy$default(voiceStateUpdate, l, channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getId()) : null, false, false, false, null, 60, null);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            this.hasSelectedVoiceChannel = true;
            createRtcConnection();
            this.joinedChannelTimestamp = Long.valueOf(this.clock.currentTimeMillis());
            logChannelJoin(channelFindChannelByIdInternal$app_productionGoogleRelease);
        } else {
            this.voiceServer = null;
        }
        onVoiceStateUpdated();
    }

    @Store3
    public final void handleVoiceServerUpdate(VoiceServer voiceServer) {
        Intrinsics3.checkNotNullParameter(voiceServer, "voiceServer");
        recordBreadcrumb("handling voice server update: " + voiceServer);
        this.voiceServer = voiceServer;
        checkForVoiceServerUpdate();
    }

    @Store3
    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        StoreRtcConnection2 storeRtcConnection2 = this.voicePropsTracker;
        if (storeRtcConnection2 != null) {
            storeRtcConnection2.handleVoiceStateUpdate(voiceState);
        }
    }

    @Store3
    public final void init(Context context, NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.context = context;
        this.networkMonitor = networkMonitor;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        ObservableExtensionsKt.appSubscribe(companion.getMediaSettings().isSelfMuted(), (Class<?>) StoreRtcConnection.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(companion.getMediaSettings().isSelfDeafened(), (Class<?>) StoreRtcConnection.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        Observable<R> observableG = companion.getMediaEngine().getSelectedVideoInputDevice().G(new Func1<DeviceDescription4, Boolean>() { // from class: com.discord.stores.StoreRtcConnection.init.3
            @Override // j0.k.Func1
            public final Boolean call(DeviceDescription4 deviceDescription4) {
                return Boolean.valueOf(deviceDescription4 != null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…viceDescription != null }");
        ObservableExtensionsKt.appSubscribe(observableG, (Class<?>) StoreRtcConnection.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        ObservableExtensionsKt.appSubscribe(this.stream.getMediaSettings().getUsersVolume(), (Class<?>) StoreRtcConnection.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5());
        ObservableExtensionsKt.appSubscribe(this.stream.getMediaSettings().getUsersMuted(), (Class<?>) StoreRtcConnection.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass6());
        ObservableExtensionsKt.appSubscribe(this.stream.getMediaSettings().getUsersOffScreen(), (Class<?>) StoreRtcConnection.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass7());
    }

    public final Observable<RtcConnection.Metadata> observeRtcConnectionMetadata() {
        BehaviorSubject<RtcConnection.Metadata> behaviorSubject = this.rtcConnectionMetadataSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "rtcConnectionMetadataSubject");
        return behaviorSubject;
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onAnalyticsEvent(RtcConnection.AnalyticsEvent event, Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(event, "event");
        Intrinsics3.checkNotNullParameter(properties, "properties");
        int iOrdinal = event.ordinal();
        if (iOrdinal == 0) {
            this.storeAnalytics.trackVoiceConnectionSuccess(properties);
            return;
        }
        if (iOrdinal == 1) {
            this.storeAnalytics.trackVoiceConnectionFailure(properties);
            return;
        }
        if (iOrdinal == 2) {
            this.storeAnalytics.trackVoiceDisconnect(properties);
        } else if (iOrdinal == 3) {
            this.dispatcher.schedule(new AnonymousClass1(properties));
        } else {
            if (iOrdinal != 4) {
                return;
            }
            this.storeAnalytics.trackMediaSessionJoined(properties);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onFatalClose() {
        this.stream.getVoiceChannelSelected().clear();
    }

    @Override // com.discord.rtcconnection.RtcConnection.b
    public void onFirstFrameReceived(long ssrc) {
        this.listenerSubject.notify(new AnonymousClass1(ssrc));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b
    public void onFirstFrameSent() {
        this.listenerSubject.notify(AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onMediaEngineConnectionConnected(RtcConnection connection) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        this.dispatcher.schedule(new AnonymousClass1(connection));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onMediaSessionIdReceived() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onQualityUpdate(RtcConnection.Quality quality) {
        Intrinsics3.checkNotNullParameter(quality, "quality");
        this.qualitySubject.onNext(quality);
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onSpeaking(long userId, boolean isSpeaking) {
        PublishSubject<SpeakingUserUpdate> publishSubject = this.speakingUsersSubject;
        publishSubject.k.onNext(new SpeakingUserUpdate(userId, isSpeaking));
        this.dispatcher.schedule(new AnonymousClass1(userId, isSpeaking));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onStateChange(RtcConnection.StateChange stateChange) {
        Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
        recordBreadcrumb("connection state change: " + stateChange);
        this.connectionStateSubject.k.onNext(stateChange);
        if (Intrinsics3.areEqual(stateChange.state, RtcConnection.State.f.a)) {
            this.listenerSubject.notify(AnonymousClass1.INSTANCE);
        }
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onUserCreated(RtcConnection connection, long userId) {
        Intrinsics3.checkNotNullParameter(connection, "connection");
        applyVoiceConfiguration(connection, Long.valueOf(userId));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onVideoMetadata(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        this.dispatcher.schedule(new AnonymousClass1(metadata));
    }

    @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
    public void onVideoStream(long userId, Integer streamId, int audioSsrc, int videoSsrc, int rtxSsrc) {
        this.dispatcher.schedule(new AnonymousClass1(userId, streamId, audioSsrc, videoSsrc, rtxSsrc));
    }

    public StoreRtcConnection(StoreStream storeStream, Dispatcher dispatcher, Clock clock, StoreRtcRegion storeRtcRegion, StoreAnalytics storeAnalytics, StoreVoiceStates storeVoiceStates, Logger logger, DebugPrintable3 debugPrintable3) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeRtcRegion, "storeRtcRegion");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(debugPrintable3, "dpc");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.storeRtcRegion = storeRtcRegion;
        this.storeAnalytics = storeAnalytics;
        this.storeVoiceStates = storeVoiceStates;
        this.logger = logger;
        this.dpc = debugPrintable3;
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        PublishSubject<SpeakingUserUpdate> publishSubjectK0 = PublishSubject.k0();
        this.speakingUsersSubject = publishSubjectK0;
        BehaviorSubject<RtcConnection.Quality> behaviorSubjectL0 = BehaviorSubject.l0(RtcConnection.Quality.UNKNOWN);
        this.qualitySubject = behaviorSubjectL0;
        this.currentVoiceState = new Outgoing2.VoiceStateUpdate(null, null, false, false, false, null, 32, null);
        SerializedSubject<RtcConnection.StateChange, RtcConnection.StateChange> serializedSubject = new SerializedSubject<>(BehaviorSubject.l0(new RtcConnection.StateChange(new RtcConnection.State.d(false), null)));
        this.connectionStateSubject = serializedSubject;
        this.rtcConnectionMetadataSubject = BehaviorSubject.l0(null);
        Observable<RtcConnection.StateChange> observableR = ObservableExtensionsKt.computationLatest(serializedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "connectionStateSubject\n …  .distinctUntilChanged()");
        this.connectionState = observableR;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "qualitySubject");
        Observable<RtcConnection.Quality> observableR2 = ObservableExtensionsKt.computationLatest(behaviorSubjectL0).r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "qualitySubject\n         …  .distinctUntilChanged()");
        this.quality = observableR2;
        Observable<List<SpeakingUserUpdate>> observableA = publishSubjectK0.a(300L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableA, "speakingUsersSubject\n   …S, TimeUnit.MILLISECONDS)");
        Observable<List<SpeakingUserUpdate>> observableR3 = ObservableExtensionsKt.computationLatest(observableA).r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "speakingUsersSubject\n   …  .distinctUntilChanged()");
        this.speakingUpdates = observableR3;
        StringBuilder sbU = outline.U("StoreRtcConnection ");
        int i = instanceCounter + 1;
        instanceCounter = i;
        sbU.append(i);
        String string = sbU.toString();
        this.loggingTag = string;
        this.debugDisplayId = debugPrintable3.add(this, string);
    }
}
