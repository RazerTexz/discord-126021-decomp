package com.discord.rtcconnection.mediaengine;

import android.content.Intent;
import b.a.q.m0.Codec2;
import b.d.b.a.outline;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.KrispOveruseDetector;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
            Intrinsics3.checkNotNullParameter(failureType, "type");
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

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int port;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final Protocol protocol;

        /* JADX INFO: compiled from: MediaEngineConnection.kt */
        public enum Protocol {
            UDP,
            TCP
        }

        public TransportInfo(String str, int i, Protocol protocol) {
            Intrinsics3.checkNotNullParameter(str, "address");
            Intrinsics3.checkNotNullParameter(protocol, "protocol");
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
            return Intrinsics3.areEqual(this.address, transportInfo.address) && this.port == transportInfo.port && Intrinsics3.areEqual(this.protocol, transportInfo.protocol);
        }

        public int hashCode() {
            String str = this.address;
            int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.port) * 31;
            Protocol protocol = this.protocol;
            return iHashCode + (protocol != null ? protocol.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("TransportInfo(address=");
            sbU.append(this.address);
            sbU.append(", port=");
            sbU.append(this.port);
            sbU.append(", protocol=");
            sbU.append(this.protocol);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public enum Type {
        DEFAULT,
        STREAM
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static abstract class a implements d {
        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onConnected(MediaEngineConnection mediaEngineConnection, TransportInfo transportInfo, List<Codec2> list) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
            Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, ConnectionState connectionState) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public abstract void onDestroy(MediaEngineConnection mediaEngineConnection);

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onError(MediaEngineConnection mediaEngineConnection, FailedConnectionException failedConnectionException) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(status, "status");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onLocalMute(long j, boolean z2) {
        }

        public void onLocalVideoDisabled(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onLocalVideoOffScreen(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onSpeaking(long j, int i, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onTargetBitrate(int i) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onTargetFrameRate(int i) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
            Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2799b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.f2799b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.f2799b == bVar.f2799b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
        }

        public int hashCode() {
            return (((((((((this.a * 31) + this.f2799b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EncodingQuality(minBitrate=");
            sbU.append(this.a);
            sbU.append(", maxBitrate=");
            sbU.append(this.f2799b);
            sbU.append(", width=");
            sbU.append(this.c);
            sbU.append(", height=");
            sbU.append(this.d);
            sbU.append(", mutedFramerate=");
            sbU.append(this.e);
            sbU.append(", framerate=");
            return outline.B(sbU, this.f, ")");
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2800b;
        public final int c;
        public final boolean d;
        public final boolean e;
        public final int f;

        public c() {
            this(0, 0, 0, false, false, 0, 63);
        }

        public c(int i, int i2, int i3, boolean z2, boolean z3, int i4) {
            this.a = i;
            this.f2800b = i2;
            this.c = i3;
            this.d = z2;
            this.e = z3;
            this.f = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.f2800b == cVar.f2800b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f;
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
            int i = ((((this.a * 31) + this.f2800b) * 31) + this.c) * 31;
            boolean z2 = this.d;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i2 = (i + r1) * 31;
            boolean z3 = this.e;
            return ((i2 + (z3 ? 1 : z3)) * 31) + this.f;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InputModeOptions(vadThreshold=");
            sbU.append(this.a);
            sbU.append(", vadLeadingFrames=");
            sbU.append(this.f2800b);
            sbU.append(", vadTrailingFrames=");
            sbU.append(this.c);
            sbU.append(", vadAutoThreshold=");
            sbU.append(this.d);
            sbU.append(", vadUseKrisp=");
            sbU.append(this.e);
            sbU.append(", pttReleaseDelayMs=");
            return outline.B(sbU, this.f, ")");
        }

        public c(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            i = (i5 & 1) != 0 ? 0 : i;
            i2 = (i5 & 2) != 0 ? 10 : i2;
            i3 = (i5 & 4) != 0 ? 40 : i3;
            z2 = (i5 & 8) != 0 ? true : z2;
            z3 = (i5 & 16) != 0 ? true : z3;
            i4 = (i5 & 32) != 0 ? 5 : i4;
            this.a = i;
            this.f2800b = i2;
            this.c = i3;
            this.d = z2;
            this.e = z3;
            this.f = i4;
        }
    }

    /* JADX INFO: compiled from: MediaEngineConnection.kt */
    public interface d {
        void onConnected(MediaEngineConnection mediaEngineConnection, TransportInfo transportInfo, List<Codec2> list);

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

    void a(Intent permission, ThumbnailEmitter thumbnailEmitter);

    boolean b();

    void c(boolean selfMute);

    void d(long userId, boolean offScreen);

    void destroy();

    void e(long userId, float volume);

    void f(KrispOveruseDetector.Status status);

    boolean g(long userId);

    Type getType();

    void h();

    void i(long userId, boolean disabled);

    void j(boolean isVideoBroadcast);

    void k(InputMode inputMode, c inputModeOptions);

    void l(d listener);

    void m(b quality);

    void n(Function1<? super Stats, Unit> onStats);

    void o(d listener);

    boolean p(long userId);

    void q(boolean active);

    void r(String audioCodec, String videoCodec);

    void s(long userId, int audioSsrc, Integer videoSsrc, boolean isMuted, float volume);

    void t(String mode, int[] secretKey);

    boolean u(long userId);

    void v(boolean selfDeaf);

    void w(long userId, boolean mute);
}
