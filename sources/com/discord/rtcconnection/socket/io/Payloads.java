package com.discord.rtcconnection.socket.io;

import a0.a.a.b;
import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.outline;
import b.i.d.p.SerializedName;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.JsonElement;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Payloads {
    public static final Payloads INSTANCE = new Payloads();

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class ClientDisconnect {

        @SerializedName("user_id")
        private final long userId;

        public ClientDisconnect(long j) {
            this.userId = j;
        }

        public static /* synthetic */ ClientDisconnect copy$default(ClientDisconnect clientDisconnect, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = clientDisconnect.userId;
            }
            return clientDisconnect.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        public final ClientDisconnect copy(long userId) {
            return new ClientDisconnect(userId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ClientDisconnect) && this.userId == ((ClientDisconnect) other).userId;
            }
            return true;
        }

        public final long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return b.a(this.userId);
        }

        public String toString() {
            return outline.C(outline.U("ClientDisconnect(userId="), this.userId, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Description {

        @SerializedName("audio_codec")
        private final String audioCodec;

        @SerializedName("media_session_id")
        private final String mediaSessionId;
        private final String mode;

        @SerializedName("secret_key")
        private final List<Integer> secretKey;

        @SerializedName("video_codec")
        private final String videoCodec;

        public Description(List<Integer> list, String str, String str2, String str3, String str4) {
            Intrinsics3.checkNotNullParameter(list, "secretKey");
            Intrinsics3.checkNotNullParameter(str2, "audioCodec");
            Intrinsics3.checkNotNullParameter(str3, "videoCodec");
            Intrinsics3.checkNotNullParameter(str4, "mode");
            this.secretKey = list;
            this.mediaSessionId = str;
            this.audioCodec = str2;
            this.videoCodec = str3;
            this.mode = str4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Description copy$default(Description description, List list, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                list = description.secretKey;
            }
            if ((i & 2) != 0) {
                str = description.mediaSessionId;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = description.audioCodec;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = description.videoCodec;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = description.mode;
            }
            return description.copy(list, str5, str6, str7, str4);
        }

        public final List<Integer> component1() {
            return this.secretKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAudioCodec() {
            return this.audioCodec;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getVideoCodec() {
            return this.videoCodec;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMode() {
            return this.mode;
        }

        public final Description copy(List<Integer> secretKey, String mediaSessionId, String audioCodec, String videoCodec, String mode) {
            Intrinsics3.checkNotNullParameter(secretKey, "secretKey");
            Intrinsics3.checkNotNullParameter(audioCodec, "audioCodec");
            Intrinsics3.checkNotNullParameter(videoCodec, "videoCodec");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            return new Description(secretKey, mediaSessionId, audioCodec, videoCodec, mode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Description)) {
                return false;
            }
            Description description = (Description) other;
            return Intrinsics3.areEqual(this.secretKey, description.secretKey) && Intrinsics3.areEqual(this.mediaSessionId, description.mediaSessionId) && Intrinsics3.areEqual(this.audioCodec, description.audioCodec) && Intrinsics3.areEqual(this.videoCodec, description.videoCodec) && Intrinsics3.areEqual(this.mode, description.mode);
        }

        public final String getAudioCodec() {
            return this.audioCodec;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final String getMode() {
            return this.mode;
        }

        public final List<Integer> getSecretKey() {
            return this.secretKey;
        }

        public final String getVideoCodec() {
            return this.videoCodec;
        }

        public int hashCode() {
            List<Integer> list = this.secretKey;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.audioCodec;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.videoCodec;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.mode;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Description(secretKey=");
            sbU.append(this.secretKey);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", audioCodec=");
            sbU.append(this.audioCodec);
            sbU.append(", videoCodec=");
            sbU.append(this.videoCodec);
            sbU.append(", mode=");
            return outline.J(sbU, this.mode, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Hello {

        @SerializedName("heartbeat_interval")
        private final long heartbeatIntervalMs;

        @SerializedName("v")
        private final int serverVersion;

        public Hello(long j, int i) {
            this.heartbeatIntervalMs = j;
            this.serverVersion = i;
        }

        public static /* synthetic */ Hello copy$default(Hello hello, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = hello.heartbeatIntervalMs;
            }
            if ((i2 & 2) != 0) {
                i = hello.serverVersion;
            }
            return hello.copy(j, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getHeartbeatIntervalMs() {
            return this.heartbeatIntervalMs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getServerVersion() {
            return this.serverVersion;
        }

        public final Hello copy(long heartbeatIntervalMs, int serverVersion) {
            return new Hello(heartbeatIntervalMs, serverVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hello)) {
                return false;
            }
            Hello hello = (Hello) other;
            return this.heartbeatIntervalMs == hello.heartbeatIntervalMs && this.serverVersion == hello.serverVersion;
        }

        public final long getHeartbeatIntervalMs() {
            return this.heartbeatIntervalMs;
        }

        public final int getServerVersion() {
            return this.serverVersion;
        }

        public int hashCode() {
            return (b.a(this.heartbeatIntervalMs) * 31) + this.serverVersion;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Hello(heartbeatIntervalMs=");
            sbU.append(this.heartbeatIntervalMs);
            sbU.append(", serverVersion=");
            return outline.B(sbU, this.serverVersion, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Identify {

        @SerializedName("server_id")
        private final String serverId;

        @SerializedName("session_id")
        private final String sessionId;
        private final List<Stream> streams;
        private final String token;

        @SerializedName("user_id")
        private final long userId;
        private final boolean video;

        public Identify(String str, long j, String str2, String str3, boolean z2, List<Stream> list) {
            Intrinsics3.checkNotNullParameter(str, "serverId");
            Intrinsics3.checkNotNullParameter(str2, "sessionId");
            Intrinsics3.checkNotNullParameter(str3, "token");
            Intrinsics3.checkNotNullParameter(list, "streams");
            this.serverId = str;
            this.userId = j;
            this.sessionId = str2;
            this.token = str3;
            this.video = z2;
            this.streams = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Identify copy$default(Identify identify, String str, long j, String str2, String str3, boolean z2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = identify.serverId;
            }
            if ((i & 2) != 0) {
                j = identify.userId;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str2 = identify.sessionId;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                str3 = identify.token;
            }
            String str5 = str3;
            if ((i & 16) != 0) {
                z2 = identify.video;
            }
            boolean z3 = z2;
            if ((i & 32) != 0) {
                list = identify.streams;
            }
            return identify.copy(str, j2, str4, str5, z3, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getServerId() {
            return this.serverId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getVideo() {
            return this.video;
        }

        public final List<Stream> component6() {
            return this.streams;
        }

        public final Identify copy(String serverId, long userId, String sessionId, String token, boolean video, List<Stream> streams) {
            Intrinsics3.checkNotNullParameter(serverId, "serverId");
            Intrinsics3.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics3.checkNotNullParameter(token, "token");
            Intrinsics3.checkNotNullParameter(streams, "streams");
            return new Identify(serverId, userId, sessionId, token, video, streams);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Identify)) {
                return false;
            }
            Identify identify = (Identify) other;
            return Intrinsics3.areEqual(this.serverId, identify.serverId) && this.userId == identify.userId && Intrinsics3.areEqual(this.sessionId, identify.sessionId) && Intrinsics3.areEqual(this.token, identify.token) && this.video == identify.video && Intrinsics3.areEqual(this.streams, identify.streams);
        }

        public final String getServerId() {
            return this.serverId;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final List<Stream> getStreams() {
            return this.streams;
        }

        public final String getToken() {
            return this.token;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final boolean getVideo() {
            return this.video;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        public int hashCode() {
            String str = this.serverId;
            int iA = (b.a(this.userId) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
            String str2 = this.sessionId;
            int iHashCode = (iA + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.token;
            int iHashCode2 = (iHashCode + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z2 = this.video;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = (iHashCode2 + r0) * 31;
            List<Stream> list = this.streams;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Identify(serverId=");
            sbU.append(this.serverId);
            sbU.append(", userId=");
            sbU.append(this.userId);
            sbU.append(", sessionId=");
            sbU.append(this.sessionId);
            sbU.append(", token=");
            sbU.append(this.token);
            sbU.append(", video=");
            sbU.append(this.video);
            sbU.append(", streams=");
            return outline.L(sbU, this.streams, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Incoming {

        @SerializedName("d")
        private final JsonElement data;

        @SerializedName("op")
        private final int opcode;

        public Incoming(int i, JsonElement jsonElement) {
            Intrinsics3.checkNotNullParameter(jsonElement, "data");
            this.opcode = i;
            this.data = jsonElement;
        }

        public static /* synthetic */ Incoming copy$default(Incoming incoming, int i, JsonElement jsonElement, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = incoming.opcode;
            }
            if ((i2 & 2) != 0) {
                jsonElement = incoming.data;
            }
            return incoming.copy(i, jsonElement);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getOpcode() {
            return this.opcode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JsonElement getData() {
            return this.data;
        }

        public final Incoming copy(int opcode, JsonElement data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new Incoming(opcode, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Incoming)) {
                return false;
            }
            Incoming incoming = (Incoming) other;
            return this.opcode == incoming.opcode && Intrinsics3.areEqual(this.data, incoming.data);
        }

        public final JsonElement getData() {
            return this.data;
        }

        public final int getOpcode() {
            return this.opcode;
        }

        public int hashCode() {
            int i = this.opcode * 31;
            JsonElement jsonElement = this.data;
            return i + (jsonElement != null ? jsonElement.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Incoming(opcode=");
            sbU.append(this.opcode);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Outgoing {

        @SerializedName("d")
        private final Object data;

        @SerializedName("op")
        private final int opcode;

        public Outgoing(int i, Object obj) {
            Intrinsics3.checkNotNullParameter(obj, "data");
            this.opcode = i;
            this.data = obj;
        }

        public static /* synthetic */ Outgoing copy$default(Outgoing outgoing, int i, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                i = outgoing.opcode;
            }
            if ((i2 & 2) != 0) {
                obj = outgoing.data;
            }
            return outgoing.copy(i, obj);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getOpcode() {
            return this.opcode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getData() {
            return this.data;
        }

        public final Outgoing copy(int opcode, Object data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            return new Outgoing(opcode, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Outgoing)) {
                return false;
            }
            Outgoing outgoing = (Outgoing) other;
            return this.opcode == outgoing.opcode && Intrinsics3.areEqual(this.data, outgoing.data);
        }

        public final Object getData() {
            return this.data;
        }

        public final int getOpcode() {
            return this.opcode;
        }

        public int hashCode() {
            int i = this.opcode * 31;
            Object obj = this.data;
            return i + (obj != null ? obj.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Outgoing(opcode=");
            sbU.append(this.opcode);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Protocol {
        private final List<CodecInfo> codecs;
        private final ProtocolInfo data;
        private final String protocol;

        /* JADX INFO: compiled from: Payloads.kt */
        public static final /* data */ class CodecInfo {
            private final String name;

            @SerializedName("payload_type")
            private final int payloadType;
            private final int priority;

            @SerializedName("rtx_payload_type")
            private final Integer rtxPayloadType;
            private final String type;

            public CodecInfo(String str, int i, String str2, int i2, Integer num) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(str2, "type");
                this.name = str;
                this.priority = i;
                this.type = str2;
                this.payloadType = i2;
                this.rtxPayloadType = num;
            }

            public static /* synthetic */ CodecInfo copy$default(CodecInfo codecInfo, String str, int i, String str2, int i2, Integer num, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = codecInfo.name;
                }
                if ((i3 & 2) != 0) {
                    i = codecInfo.priority;
                }
                int i4 = i;
                if ((i3 & 4) != 0) {
                    str2 = codecInfo.type;
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    i2 = codecInfo.payloadType;
                }
                int i5 = i2;
                if ((i3 & 16) != 0) {
                    num = codecInfo.rtxPayloadType;
                }
                return codecInfo.copy(str, i4, str3, i5, num);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getPriority() {
                return this.priority;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getPayloadType() {
                return this.payloadType;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Integer getRtxPayloadType() {
                return this.rtxPayloadType;
            }

            public final CodecInfo copy(String name, int priority, String type, int payloadType, Integer rtxPayloadType) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(type, "type");
                return new CodecInfo(name, priority, type, payloadType, rtxPayloadType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CodecInfo)) {
                    return false;
                }
                CodecInfo codecInfo = (CodecInfo) other;
                return Intrinsics3.areEqual(this.name, codecInfo.name) && this.priority == codecInfo.priority && Intrinsics3.areEqual(this.type, codecInfo.type) && this.payloadType == codecInfo.payloadType && Intrinsics3.areEqual(this.rtxPayloadType, codecInfo.rtxPayloadType);
            }

            public final String getName() {
                return this.name;
            }

            public final int getPayloadType() {
                return this.payloadType;
            }

            public final int getPriority() {
                return this.priority;
            }

            public final Integer getRtxPayloadType() {
                return this.rtxPayloadType;
            }

            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.priority) * 31;
                String str2 = this.type;
                int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.payloadType) * 31;
                Integer num = this.rtxPayloadType;
                return iHashCode2 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("CodecInfo(name=");
                sbU.append(this.name);
                sbU.append(", priority=");
                sbU.append(this.priority);
                sbU.append(", type=");
                sbU.append(this.type);
                sbU.append(", payloadType=");
                sbU.append(this.payloadType);
                sbU.append(", rtxPayloadType=");
                return outline.F(sbU, this.rtxPayloadType, ")");
            }
        }

        /* JADX INFO: compiled from: Payloads.kt */
        public static final /* data */ class ProtocolInfo {
            private final String address;
            private final String mode;
            private final int port;

            public ProtocolInfo(String str, int i, String str2) {
                Intrinsics3.checkNotNullParameter(str, "address");
                Intrinsics3.checkNotNullParameter(str2, "mode");
                this.address = str;
                this.port = i;
                this.mode = str2;
            }

            public static /* synthetic */ ProtocolInfo copy$default(ProtocolInfo protocolInfo, String str, int i, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = protocolInfo.address;
                }
                if ((i2 & 2) != 0) {
                    i = protocolInfo.port;
                }
                if ((i2 & 4) != 0) {
                    str2 = protocolInfo.mode;
                }
                return protocolInfo.copy(str, i, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getAddress() {
                return this.address;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getPort() {
                return this.port;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getMode() {
                return this.mode;
            }

            public final ProtocolInfo copy(String address, int port, String mode) {
                Intrinsics3.checkNotNullParameter(address, "address");
                Intrinsics3.checkNotNullParameter(mode, "mode");
                return new ProtocolInfo(address, port, mode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ProtocolInfo)) {
                    return false;
                }
                ProtocolInfo protocolInfo = (ProtocolInfo) other;
                return Intrinsics3.areEqual(this.address, protocolInfo.address) && this.port == protocolInfo.port && Intrinsics3.areEqual(this.mode, protocolInfo.mode);
            }

            public final String getAddress() {
                return this.address;
            }

            public final String getMode() {
                return this.mode;
            }

            public final int getPort() {
                return this.port;
            }

            public int hashCode() {
                String str = this.address;
                int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.port) * 31;
                String str2 = this.mode;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ProtocolInfo(address=");
                sbU.append(this.address);
                sbU.append(", port=");
                sbU.append(this.port);
                sbU.append(", mode=");
                return outline.J(sbU, this.mode, ")");
            }
        }

        public Protocol(String str, ProtocolInfo protocolInfo, List<CodecInfo> list) {
            Intrinsics3.checkNotNullParameter(str, "protocol");
            Intrinsics3.checkNotNullParameter(protocolInfo, "data");
            this.protocol = str;
            this.data = protocolInfo;
            this.codecs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Protocol copy$default(Protocol protocol, String str, ProtocolInfo protocolInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = protocol.protocol;
            }
            if ((i & 2) != 0) {
                protocolInfo = protocol.data;
            }
            if ((i & 4) != 0) {
                list = protocol.codecs;
            }
            return protocol.copy(str, protocolInfo, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getProtocol() {
            return this.protocol;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ProtocolInfo getData() {
            return this.data;
        }

        public final List<CodecInfo> component3() {
            return this.codecs;
        }

        public final Protocol copy(String protocol, ProtocolInfo data, List<CodecInfo> codecs) {
            Intrinsics3.checkNotNullParameter(protocol, "protocol");
            Intrinsics3.checkNotNullParameter(data, "data");
            return new Protocol(protocol, data, codecs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Protocol)) {
                return false;
            }
            Protocol protocol = (Protocol) other;
            return Intrinsics3.areEqual(this.protocol, protocol.protocol) && Intrinsics3.areEqual(this.data, protocol.data) && Intrinsics3.areEqual(this.codecs, protocol.codecs);
        }

        public final List<CodecInfo> getCodecs() {
            return this.codecs;
        }

        public final ProtocolInfo getData() {
            return this.data;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public int hashCode() {
            String str = this.protocol;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            ProtocolInfo protocolInfo = this.data;
            int iHashCode2 = (iHashCode + (protocolInfo != null ? protocolInfo.hashCode() : 0)) * 31;
            List<CodecInfo> list = this.codecs;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Protocol(protocol=");
            sbU.append(this.protocol);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(", codecs=");
            return outline.L(sbU, this.codecs, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Ready {
        private final String ip;
        private final int port;
        private final int ssrc;
        private final List<Stream> streams;

        public Ready(int i, int i2, String str, List<Stream> list) {
            Intrinsics3.checkNotNullParameter(str, "ip");
            Intrinsics3.checkNotNullParameter(list, "streams");
            this.ssrc = i;
            this.port = i2;
            this.ip = str;
            this.streams = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ready copy$default(Ready ready, int i, int i2, String str, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = ready.ssrc;
            }
            if ((i3 & 2) != 0) {
                i2 = ready.port;
            }
            if ((i3 & 4) != 0) {
                str = ready.ip;
            }
            if ((i3 & 8) != 0) {
                list = ready.streams;
            }
            return ready.copy(i, i2, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSsrc() {
            return this.ssrc;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getIp() {
            return this.ip;
        }

        public final List<Stream> component4() {
            return this.streams;
        }

        public final Ready copy(int ssrc, int port, String ip, List<Stream> streams) {
            Intrinsics3.checkNotNullParameter(ip, "ip");
            Intrinsics3.checkNotNullParameter(streams, "streams");
            return new Ready(ssrc, port, ip, streams);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            Ready ready = (Ready) other;
            return this.ssrc == ready.ssrc && this.port == ready.port && Intrinsics3.areEqual(this.ip, ready.ip) && Intrinsics3.areEqual(this.streams, ready.streams);
        }

        public final String getIp() {
            return this.ip;
        }

        public final int getPort() {
            return this.port;
        }

        public final int getSsrc() {
            return this.ssrc;
        }

        public final List<Stream> getStreams() {
            return this.streams;
        }

        public int hashCode() {
            int i = ((this.ssrc * 31) + this.port) * 31;
            String str = this.ip;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            List<Stream> list = this.streams;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Ready(ssrc=");
            sbU.append(this.ssrc);
            sbU.append(", port=");
            sbU.append(this.port);
            sbU.append(", ip=");
            sbU.append(this.ip);
            sbU.append(", streams=");
            return outline.L(sbU, this.streams, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public enum ResolutionType {
        Source,
        Fixed
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Resume {

        @SerializedName("server_id")
        private final String serverId;

        @SerializedName("session_id")
        private final String sessionId;
        private final String token;

        public Resume(String str, String str2, String str3) {
            outline.q0(str, "token", str2, "sessionId", str3, "serverId");
            this.token = str;
            this.sessionId = str2;
            this.serverId = str3;
        }

        public static /* synthetic */ Resume copy$default(Resume resume, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resume.token;
            }
            if ((i & 2) != 0) {
                str2 = resume.sessionId;
            }
            if ((i & 4) != 0) {
                str3 = resume.serverId;
            }
            return resume.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getServerId() {
            return this.serverId;
        }

        public final Resume copy(String token, String sessionId, String serverId) {
            Intrinsics3.checkNotNullParameter(token, "token");
            Intrinsics3.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics3.checkNotNullParameter(serverId, "serverId");
            return new Resume(token, sessionId, serverId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Resume)) {
                return false;
            }
            Resume resume = (Resume) other;
            return Intrinsics3.areEqual(this.token, resume.token) && Intrinsics3.areEqual(this.sessionId, resume.sessionId) && Intrinsics3.areEqual(this.serverId, resume.serverId);
        }

        public final String getServerId() {
            return this.serverId;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            String str = this.token;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.sessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.serverId;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Resume(token=");
            sbU.append(this.token);
            sbU.append(", sessionId=");
            sbU.append(this.sessionId);
            sbU.append(", serverId=");
            return outline.J(sbU, this.serverId, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class SessionUpdate {

        @SerializedName("media_session_id")
        private final String mediaSessionId;

        public SessionUpdate(String str) {
            this.mediaSessionId = str;
        }

        public static /* synthetic */ SessionUpdate copy$default(SessionUpdate sessionUpdate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionUpdate.mediaSessionId;
            }
            return sessionUpdate.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final SessionUpdate copy(String mediaSessionId) {
            return new SessionUpdate(mediaSessionId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SessionUpdate) && Intrinsics3.areEqual(this.mediaSessionId, ((SessionUpdate) other).mediaSessionId);
            }
            return true;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public int hashCode() {
            String str = this.mediaSessionId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("SessionUpdate(mediaSessionId="), this.mediaSessionId, ")");
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Speaking {
        public static final int NOT_SPEAKING = 0;
        public static final int SPEAKING = 1;
        private final Integer delay;
        private final Integer speaking;
        private final int ssrc;

        @SerializedName("user_id")
        private final Long userId;

        public Speaking(int i, Integer num, Integer num2, Long l) {
            this.ssrc = i;
            this.speaking = num;
            this.delay = num2;
            this.userId = l;
        }

        public static /* synthetic */ Speaking copy$default(Speaking speaking, int i, Integer num, Integer num2, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = speaking.ssrc;
            }
            if ((i2 & 2) != 0) {
                num = speaking.speaking;
            }
            if ((i2 & 4) != 0) {
                num2 = speaking.delay;
            }
            if ((i2 & 8) != 0) {
                l = speaking.userId;
            }
            return speaking.copy(i, num, num2, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSsrc() {
            return this.ssrc;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getSpeaking() {
            return this.speaking;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getDelay() {
            return this.delay;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getUserId() {
            return this.userId;
        }

        public final Speaking copy(int ssrc, Integer speaking, Integer delay, Long userId) {
            return new Speaking(ssrc, speaking, delay, userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Speaking)) {
                return false;
            }
            Speaking speaking = (Speaking) other;
            return this.ssrc == speaking.ssrc && Intrinsics3.areEqual(this.speaking, speaking.speaking) && Intrinsics3.areEqual(this.delay, speaking.delay) && Intrinsics3.areEqual(this.userId, speaking.userId);
        }

        public final Integer getDelay() {
            return this.delay;
        }

        public final Integer getSpeaking() {
            return this.speaking;
        }

        public final int getSsrc() {
            return this.ssrc;
        }

        public final Long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            int i = this.ssrc * 31;
            Integer num = this.speaking;
            int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.delay;
            int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Long l = this.userId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Speaking(ssrc=");
            sbU.append(this.ssrc);
            sbU.append(", speaking=");
            sbU.append(this.speaking);
            sbU.append(", delay=");
            sbU.append(this.delay);
            sbU.append(", userId=");
            return outline.G(sbU, this.userId, ")");
        }

        public /* synthetic */ Speaking(int i, Integer num, Integer num2, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : l);
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Stream {
        private final Boolean active;

        @SerializedName("max_bitrate")
        private final Integer maxBitrate;

        @SerializedName("max_framerate")
        private final Integer maxFrameRate;

        @SerializedName("max_resolution")
        private final MaxResolution maxResolution;
        private final Integer quality;
        private final String rid;

        @SerializedName("rtx_ssrc")
        private final Integer rtxSsrc;
        private final Integer ssrc;
        private final String type;

        /* JADX INFO: compiled from: Payloads.kt */
        public static final /* data */ class MaxResolution {
            private final int height;
            private final ResolutionType type;
            private final int width;

            public MaxResolution(ResolutionType resolutionType, int i, int i2) {
                Intrinsics3.checkNotNullParameter(resolutionType, "type");
                this.type = resolutionType;
                this.width = i;
                this.height = i2;
            }

            public static /* synthetic */ MaxResolution copy$default(MaxResolution maxResolution, ResolutionType resolutionType, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    resolutionType = maxResolution.type;
                }
                if ((i3 & 2) != 0) {
                    i = maxResolution.width;
                }
                if ((i3 & 4) != 0) {
                    i2 = maxResolution.height;
                }
                return maxResolution.copy(resolutionType, i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ResolutionType getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getWidth() {
                return this.width;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getHeight() {
                return this.height;
            }

            public final MaxResolution copy(ResolutionType type, int width, int height) {
                Intrinsics3.checkNotNullParameter(type, "type");
                return new MaxResolution(type, width, height);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MaxResolution)) {
                    return false;
                }
                MaxResolution maxResolution = (MaxResolution) other;
                return Intrinsics3.areEqual(this.type, maxResolution.type) && this.width == maxResolution.width && this.height == maxResolution.height;
            }

            public final int getHeight() {
                return this.height;
            }

            public final ResolutionType getType() {
                return this.type;
            }

            public final int getWidth() {
                return this.width;
            }

            public int hashCode() {
                ResolutionType resolutionType = this.type;
                return ((((resolutionType != null ? resolutionType.hashCode() : 0) * 31) + this.width) * 31) + this.height;
            }

            public String toString() {
                StringBuilder sbU = outline.U("MaxResolution(type=");
                sbU.append(this.type);
                sbU.append(", width=");
                sbU.append(this.width);
                sbU.append(", height=");
                return outline.B(sbU, this.height, ")");
            }
        }

        public Stream() {
            this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public Stream(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, MaxResolution maxResolution, Boolean bool, Integer num5) {
            this.type = str;
            this.rid = str2;
            this.maxFrameRate = num;
            this.quality = num2;
            this.ssrc = num3;
            this.rtxSsrc = num4;
            this.maxResolution = maxResolution;
            this.active = bool;
            this.maxBitrate = num5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRid() {
            return this.rid;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getMaxFrameRate() {
            return this.maxFrameRate;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getQuality() {
            return this.quality;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getSsrc() {
            return this.ssrc;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getRtxSsrc() {
            return this.rtxSsrc;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final MaxResolution getMaxResolution() {
            return this.maxResolution;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getActive() {
            return this.active;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getMaxBitrate() {
            return this.maxBitrate;
        }

        public final Stream copy(String type, String rid, Integer maxFrameRate, Integer quality, Integer ssrc, Integer rtxSsrc, MaxResolution maxResolution, Boolean active, Integer maxBitrate) {
            return new Stream(type, rid, maxFrameRate, quality, ssrc, rtxSsrc, maxResolution, active, maxBitrate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stream)) {
                return false;
            }
            Stream stream = (Stream) other;
            return Intrinsics3.areEqual(this.type, stream.type) && Intrinsics3.areEqual(this.rid, stream.rid) && Intrinsics3.areEqual(this.maxFrameRate, stream.maxFrameRate) && Intrinsics3.areEqual(this.quality, stream.quality) && Intrinsics3.areEqual(this.ssrc, stream.ssrc) && Intrinsics3.areEqual(this.rtxSsrc, stream.rtxSsrc) && Intrinsics3.areEqual(this.maxResolution, stream.maxResolution) && Intrinsics3.areEqual(this.active, stream.active) && Intrinsics3.areEqual(this.maxBitrate, stream.maxBitrate);
        }

        public final Boolean getActive() {
            return this.active;
        }

        public final Integer getMaxBitrate() {
            return this.maxBitrate;
        }

        public final Integer getMaxFrameRate() {
            return this.maxFrameRate;
        }

        public final MaxResolution getMaxResolution() {
            return this.maxResolution;
        }

        public final Integer getQuality() {
            return this.quality;
        }

        public final String getRid() {
            return this.rid;
        }

        public final Integer getRtxSsrc() {
            return this.rtxSsrc;
        }

        public final Integer getSsrc() {
            return this.ssrc;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.type;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.rid;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.maxFrameRate;
            int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.quality;
            int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.ssrc;
            int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.rtxSsrc;
            int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 31;
            MaxResolution maxResolution = this.maxResolution;
            int iHashCode7 = (iHashCode6 + (maxResolution != null ? maxResolution.hashCode() : 0)) * 31;
            Boolean bool = this.active;
            int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
            Integer num5 = this.maxBitrate;
            return iHashCode8 + (num5 != null ? num5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Stream(type=");
            sbU.append(this.type);
            sbU.append(", rid=");
            sbU.append(this.rid);
            sbU.append(", maxFrameRate=");
            sbU.append(this.maxFrameRate);
            sbU.append(", quality=");
            sbU.append(this.quality);
            sbU.append(", ssrc=");
            sbU.append(this.ssrc);
            sbU.append(", rtxSsrc=");
            sbU.append(this.rtxSsrc);
            sbU.append(", maxResolution=");
            sbU.append(this.maxResolution);
            sbU.append(", active=");
            sbU.append(this.active);
            sbU.append(", maxBitrate=");
            return outline.F(sbU, this.maxBitrate, ")");
        }

        public /* synthetic */ Stream(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, MaxResolution maxResolution, Boolean bool, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : maxResolution, (i & 128) != 0 ? null : bool, (i & 256) == 0 ? num5 : null);
        }
    }

    /* JADX INFO: compiled from: Payloads.kt */
    public static final /* data */ class Video {

        @SerializedName("audio_ssrc")
        private final int audioSsrc;

        @SerializedName("rtx_ssrc")
        private final int rtxSsrc;
        private final List<Stream> streams;

        @SerializedName("user_id")
        private final Long userId;

        @SerializedName("video_ssrc")
        private final int videoSsrc;

        public Video(int i, int i2, int i3, Long l, List<Stream> list) {
            this.audioSsrc = i;
            this.videoSsrc = i2;
            this.rtxSsrc = i3;
            this.userId = l;
            this.streams = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Video copy$default(Video video, int i, int i2, int i3, Long l, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = video.audioSsrc;
            }
            if ((i4 & 2) != 0) {
                i2 = video.videoSsrc;
            }
            int i5 = i2;
            if ((i4 & 4) != 0) {
                i3 = video.rtxSsrc;
            }
            int i6 = i3;
            if ((i4 & 8) != 0) {
                l = video.userId;
            }
            Long l2 = l;
            if ((i4 & 16) != 0) {
                list = video.streams;
            }
            return video.copy(i, i5, i6, l2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAudioSsrc() {
            return this.audioSsrc;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVideoSsrc() {
            return this.videoSsrc;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getRtxSsrc() {
            return this.rtxSsrc;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getUserId() {
            return this.userId;
        }

        public final List<Stream> component5() {
            return this.streams;
        }

        public final Video copy(int audioSsrc, int videoSsrc, int rtxSsrc, Long userId, List<Stream> streams) {
            return new Video(audioSsrc, videoSsrc, rtxSsrc, userId, streams);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return this.audioSsrc == video.audioSsrc && this.videoSsrc == video.videoSsrc && this.rtxSsrc == video.rtxSsrc && Intrinsics3.areEqual(this.userId, video.userId) && Intrinsics3.areEqual(this.streams, video.streams);
        }

        public final int getAudioSsrc() {
            return this.audioSsrc;
        }

        public final int getRtxSsrc() {
            return this.rtxSsrc;
        }

        public final List<Stream> getStreams() {
            return this.streams;
        }

        public final Long getUserId() {
            return this.userId;
        }

        public final int getVideoSsrc() {
            return this.videoSsrc;
        }

        public int hashCode() {
            int i = ((((this.audioSsrc * 31) + this.videoSsrc) * 31) + this.rtxSsrc) * 31;
            Long l = this.userId;
            int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
            List<Stream> list = this.streams;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Video(audioSsrc=");
            sbU.append(this.audioSsrc);
            sbU.append(", videoSsrc=");
            sbU.append(this.videoSsrc);
            sbU.append(", rtxSsrc=");
            sbU.append(this.rtxSsrc);
            sbU.append(", userId=");
            sbU.append(this.userId);
            sbU.append(", streams=");
            return outline.L(sbU, this.streams, ")");
        }

        public /* synthetic */ Video(int i, int i2, int i3, Long l, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3, (i4 & 8) != 0 ? null : l, list);
        }
    }

    private Payloads() {
    }
}
