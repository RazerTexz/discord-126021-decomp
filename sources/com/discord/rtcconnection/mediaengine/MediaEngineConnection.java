package com.discord.rtcconnection.mediaengine;

import android.content.Intent;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.KrispOveruseDetector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p041q.p044m0.C1221a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngineConnection {

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public enum ConnectionState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        NO_ROUTE
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static final class FailedConnectionException extends Exception {
        private final FailureType type;

        /* JADX INFO: compiled from: MediaEngineConnection.kt */
        public enum FailureType {
            DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED,
            TIMEOUT,
            ADDRESS_IP_RESOLVED,
            NO_CONNECTION_INFO,
            CODEC_NEGOTIATION_FAILED,
            UNKNOWN;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException$FailureType$a, reason: from kotlin metadata */
            /* JADX INFO: compiled from: MediaEngineConnection.kt */
            public static final class Companion {
                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedConnectionException(String str, FailureType failureType) {
            super(str);
            C12238m.checkNotNullParameter(failureType, "type");
            this.type = failureType;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final FailureType getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public enum InputMode {
        VOICE_ACTIVITY(1),
        PUSH_TO_TALK(2);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int numeral;

        /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: MediaEngineConnection.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        InputMode(int i) {
            this.numeral = i;
        }

        public final int getNumeral() {
            return this.numeral;
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static final /* data */ class TransportInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String address;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final int port;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final Protocol protocol;

        /* JADX INFO: compiled from: MediaEngineConnection.kt */
        public enum Protocol {
            UDP,
            TCP
        }

        public TransportInfo(String str, int i, Protocol protocol) {
            C12238m.checkNotNullParameter(str, "address");
            C12238m.checkNotNullParameter(protocol, "protocol");
            this.address = str;
            this.port = i;
            this.protocol = protocol;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransportInfo)) {
                return false;
            }
            TransportInfo transportInfo = (TransportInfo) other;
            return C12238m.areEqual(this.address, transportInfo.address) && this.port == transportInfo.port && C12238m.areEqual(this.protocol, transportInfo.protocol);
        }

        public int hashCode() {
            String str = this.address;
            int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.port) * 31;
            Protocol protocol = this.protocol;
            return iHashCode + (protocol != null ? protocol.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("TransportInfo(address=");
            sbM833U.append(this.address);
            sbM833U.append(", port=");
            sbM833U.append(this.port);
            sbM833U.append(", protocol=");
            sbM833U.append(this.protocol);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public enum Type {
        DEFAULT,
        STREAM
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$a */
    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static abstract class AbstractC5645a implements InterfaceC5648d {
        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onConnected(MediaEngineConnection mediaEngineConnection, TransportInfo transportInfo, List<C1221a> list) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(transportInfo, "transportInfo");
            C12238m.checkNotNullParameter(list, "supportedVideoCodecs");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, ConnectionState connectionState) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(connectionState, "connectionState");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public abstract void onDestroy(MediaEngineConnection mediaEngineConnection);

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onError(MediaEngineConnection mediaEngineConnection, FailedConnectionException failedConnectionException) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(failedConnectionException, "exception");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(status, "status");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onLocalMute(long j, boolean z2) {
        }

        public void onLocalVideoDisabled(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onLocalVideoOffScreen(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onSpeaking(long j, int i, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onTargetBitrate(int i) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onTargetFrameRate(int i) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
            C12238m.checkNotNullParameter(streamParametersArr, "streams");
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$b */
    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static final class C5646b {

        /* JADX INFO: renamed from: a */
        public final int f18905a;

        /* JADX INFO: renamed from: b */
        public final int f18906b;

        /* JADX INFO: renamed from: c */
        public final int f18907c;

        /* JADX INFO: renamed from: d */
        public final int f18908d;

        /* JADX INFO: renamed from: e */
        public final int f18909e;

        /* JADX INFO: renamed from: f */
        public final int f18910f;

        public C5646b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f18905a = i;
            this.f18906b = i2;
            this.f18907c = i3;
            this.f18908d = i4;
            this.f18909e = i5;
            this.f18910f = i6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5646b)) {
                return false;
            }
            C5646b c5646b = (C5646b) obj;
            return this.f18905a == c5646b.f18905a && this.f18906b == c5646b.f18906b && this.f18907c == c5646b.f18907c && this.f18908d == c5646b.f18908d && this.f18909e == c5646b.f18909e && this.f18910f == c5646b.f18910f;
        }

        public int hashCode() {
            return (((((((((this.f18905a * 31) + this.f18906b) * 31) + this.f18907c) * 31) + this.f18908d) * 31) + this.f18909e) * 31) + this.f18910f;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("EncodingQuality(minBitrate=");
            sbM833U.append(this.f18905a);
            sbM833U.append(", maxBitrate=");
            sbM833U.append(this.f18906b);
            sbM833U.append(", width=");
            sbM833U.append(this.f18907c);
            sbM833U.append(", height=");
            sbM833U.append(this.f18908d);
            sbM833U.append(", mutedFramerate=");
            sbM833U.append(this.f18909e);
            sbM833U.append(", framerate=");
            return C1643a.m814B(sbM833U, this.f18910f, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$c */
    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static final class C5647c {

        /* JADX INFO: renamed from: a */
        public final int f18911a;

        /* JADX INFO: renamed from: b */
        public final int f18912b;

        /* JADX INFO: renamed from: c */
        public final int f18913c;

        /* JADX INFO: renamed from: d */
        public final boolean f18914d;

        /* JADX INFO: renamed from: e */
        public final boolean f18915e;

        /* JADX INFO: renamed from: f */
        public final int f18916f;

        public C5647c() {
            this(0, 0, 0, false, false, 0, 63);
        }

        public C5647c(int i, int i2, int i3, boolean z2, boolean z3, int i4) {
            this.f18911a = i;
            this.f18912b = i2;
            this.f18913c = i3;
            this.f18914d = z2;
            this.f18915e = z3;
            this.f18916f = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5647c)) {
                return false;
            }
            C5647c c5647c = (C5647c) obj;
            return this.f18911a == c5647c.f18911a && this.f18912b == c5647c.f18912b && this.f18913c == c5647c.f18913c && this.f18914d == c5647c.f18914d && this.f18915e == c5647c.f18915e && this.f18916f == c5647c.f18916f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int i = ((((this.f18911a * 31) + this.f18912b) * 31) + this.f18913c) * 31;
            boolean z2 = this.f18914d;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i2 = (i + r1) * 31;
            boolean z3 = this.f18915e;
            return ((i2 + (z3 ? 1 : z3)) * 31) + this.f18916f;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("InputModeOptions(vadThreshold=");
            sbM833U.append(this.f18911a);
            sbM833U.append(", vadLeadingFrames=");
            sbM833U.append(this.f18912b);
            sbM833U.append(", vadTrailingFrames=");
            sbM833U.append(this.f18913c);
            sbM833U.append(", vadAutoThreshold=");
            sbM833U.append(this.f18914d);
            sbM833U.append(", vadUseKrisp=");
            sbM833U.append(this.f18915e);
            sbM833U.append(", pttReleaseDelayMs=");
            return C1643a.m814B(sbM833U, this.f18916f, ")");
        }

        public C5647c(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            i = (i5 & 1) != 0 ? 0 : i;
            i2 = (i5 & 2) != 0 ? 10 : i2;
            i3 = (i5 & 4) != 0 ? 40 : i3;
            z2 = (i5 & 8) != 0 ? true : z2;
            z3 = (i5 & 16) != 0 ? true : z3;
            i4 = (i5 & 32) != 0 ? 5 : i4;
            this.f18911a = i;
            this.f18912b = i2;
            this.f18913c = i3;
            this.f18914d = z2;
            this.f18915e = z3;
            this.f18916f = i4;
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$d */
    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public interface InterfaceC5648d {
        void onConnected(MediaEngineConnection mediaEngineConnection, TransportInfo transportInfo, List<C1221a> list);

        void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, ConnectionState connectionState);

        void onDestroy(MediaEngineConnection mediaEngineConnection);

        void onError(MediaEngineConnection mediaEngineConnection, FailedConnectionException failedConnectionException);

        void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status);

        void onLocalMute(long j, boolean z2);

        void onLocalVideoOffScreen(long j, boolean z2);

        void onSpeaking(long j, int i, boolean z2);

        void onTargetBitrate(int i);

        void onTargetFrameRate(int i);

        void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr);
    }

    /* JADX INFO: renamed from: a */
    void mo295a(Intent permission, ThumbnailEmitter thumbnailEmitter);

    /* JADX INFO: renamed from: b */
    boolean mo296b();

    /* JADX INFO: renamed from: c */
    void mo297c(boolean selfMute);

    /* JADX INFO: renamed from: d */
    void mo298d(long userId, boolean offScreen);

    void destroy();

    /* JADX INFO: renamed from: e */
    void mo299e(long userId, float volume);

    /* JADX INFO: renamed from: f */
    void mo300f(KrispOveruseDetector.Status status);

    /* JADX INFO: renamed from: g */
    boolean mo301g(long userId);

    Type getType();

    /* JADX INFO: renamed from: h */
    void mo302h();

    /* JADX INFO: renamed from: i */
    void mo303i(long userId, boolean disabled);

    /* JADX INFO: renamed from: j */
    void mo304j(boolean isVideoBroadcast);

    /* JADX INFO: renamed from: k */
    void mo305k(InputMode inputMode, C5647c inputModeOptions);

    /* JADX INFO: renamed from: l */
    void mo306l(InterfaceC5648d listener);

    /* JADX INFO: renamed from: m */
    void mo307m(C5646b quality);

    /* JADX INFO: renamed from: n */
    void mo308n(Function1<? super Stats, Unit> onStats);

    /* JADX INFO: renamed from: o */
    void mo309o(InterfaceC5648d listener);

    /* JADX INFO: renamed from: p */
    boolean mo310p(long userId);

    /* JADX INFO: renamed from: q */
    void mo311q(boolean active);

    /* JADX INFO: renamed from: r */
    void mo312r(String audioCodec, String videoCodec);

    /* JADX INFO: renamed from: s */
    void mo313s(long userId, int audioSsrc, Integer videoSsrc, boolean isMuted, float volume);

    /* JADX INFO: renamed from: t */
    void mo314t(String mode, int[] secretKey);

    /* JADX INFO: renamed from: u */
    boolean mo315u(long userId);

    /* JADX INFO: renamed from: v */
    void mo316v(boolean selfDeaf);

    /* JADX INFO: renamed from: w */
    void mo317w(long userId, boolean mute);
}
