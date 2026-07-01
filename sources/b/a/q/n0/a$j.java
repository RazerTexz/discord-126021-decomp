package b.a.q.n0;

import com.discord.rtcconnection.socket.io.Payloads$ClientDisconnect;
import com.discord.rtcconnection.socket.io.Payloads$Description;
import com.discord.rtcconnection.socket.io.Payloads$Hello;
import com.discord.rtcconnection.socket.io.Payloads$Incoming;
import com.discord.rtcconnection.socket.io.Payloads$Ready;
import com.discord.rtcconnection.socket.io.Payloads$SessionUpdate;
import com.discord.rtcconnection.socket.io.Payloads$Speaking;
import com.discord.rtcconnection.socket.io.Payloads$Video;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.WebSocket;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$j extends o implements Function0<Unit> {
    public final /* synthetic */ Payloads$Incoming $message;
    public final /* synthetic */ WebSocket $webSocket;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$j(a aVar, WebSocket webSocket, Payloads$Incoming payloads$Incoming) {
        super(0);
        this.this$0 = aVar;
        this.$webSocket = webSocket;
        this.$message = payloads$Incoming;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (!(!m.areEqual(this.$webSocket, this.this$0.f275s))) {
            switch (this.$message.getOpcode()) {
                case 2:
                    a aVar = this.this$0;
                    Object objC = aVar.n.c(this.$message.getData(), Payloads$Ready.class);
                    m.checkNotNullExpressionValue(objC, "gson.fromJson(message.da…yloads.Ready::class.java)");
                    Payloads$Ready payloads$Ready = (Payloads$Ready) objC;
                    aVar.p.succeed();
                    long jCurrentTimeMillis = aVar.I.currentTimeMillis();
                    Long l = aVar.A;
                    aVar.i("[READY] took " + (jCurrentTimeMillis - (l != null ? l.longValue() : 0L)) + " ms");
                    aVar.H.a();
                    for (a$d a_d : aVar.q) {
                        m.checkNotNullExpressionValue(a_d, "it");
                        a_d.k(payloads$Ready.getPort(), payloads$Ready.getSsrc(), payloads$Ready.getIp(), payloads$Ready.getStreams());
                    }
                    break;
                case 3:
                    a aVar2 = this.this$0;
                    aVar2.n(3, String.valueOf(aVar2.I.currentTimeMillis()));
                    break;
                case 4:
                    a aVar3 = this.this$0;
                    Object objC2 = aVar3.n.c(this.$message.getData(), Payloads$Description.class);
                    m.checkNotNullExpressionValue(objC2, "gson.fromJson(message.da….Description::class.java)");
                    Payloads$Description payloads$Description = (Payloads$Description) objC2;
                    aVar3.H.a();
                    for (a$d a_d2 : aVar3.q) {
                        m.checkNotNullExpressionValue(a_d2, "it");
                        a_d2.c(payloads$Description.getMode(), payloads$Description.getSecretKey());
                        a_d2.a(payloads$Description.getAudioCodec(), payloads$Description.getVideoCodec());
                        String mediaSessionId = payloads$Description.getMediaSessionId();
                        if (mediaSessionId != null) {
                            a_d2.d(mediaSessionId);
                        }
                    }
                    aVar3.C = true;
                    break;
                case 5:
                    a aVar4 = this.this$0;
                    Object objC3 = aVar4.n.c(this.$message.getData(), Payloads$Speaking.class);
                    m.checkNotNullExpressionValue(objC3, "gson.fromJson(message.da…ads.Speaking::class.java)");
                    Payloads$Speaking payloads$Speaking = (Payloads$Speaking) objC3;
                    if (payloads$Speaking.getUserId() != null && payloads$Speaking.getSpeaking() != null) {
                        Integer speaking = payloads$Speaking.getSpeaking();
                        boolean z2 = speaking != null && speaking.intValue() == 1;
                        aVar4.H.a();
                        for (a$d a_d3 : aVar4.q) {
                            m.checkNotNullExpressionValue(a_d3, "it");
                            a_d3.onSpeaking(payloads$Speaking.getUserId().longValue(), payloads$Speaking.getSsrc(), z2);
                        }
                    }
                    break;
                case 6:
                    a aVar5 = this.this$0;
                    Object objC4 = aVar5.n.c(this.$message.getData(), Long.TYPE);
                    m.checkNotNullExpressionValue(objC4, "gson.fromJson(message.data, Long::class.java)");
                    long jLongValue = ((Number) objC4).longValue();
                    long jCurrentTimeMillis2 = aVar5.I.currentTimeMillis();
                    long j = jCurrentTimeMillis2 - jLongValue;
                    aVar5.h("got heartbeat ack after " + j + " ms");
                    aVar5.f277y = Long.valueOf(jCurrentTimeMillis2);
                    aVar5.w = true;
                    aVar5.H.a();
                    for (a$d a_d4 : aVar5.q) {
                        m.checkNotNullExpressionValue(a_d4, "it");
                        a_d4.g(j);
                    }
                    break;
                case 7:
                case 10:
                case 11:
                default:
                    a aVar6 = this.this$0;
                    StringBuilder sbU = b.d.b.a.a.U("unknown opcode: ");
                    sbU.append(this.$message.getOpcode());
                    aVar6.i(sbU.toString());
                    break;
                case 8:
                    a aVar7 = this.this$0;
                    Object objC5 = aVar7.n.c(this.$message.getData(), Payloads$Hello.class);
                    m.checkNotNullExpressionValue(objC5, "gson.fromJson(message.da…yloads.Hello::class.java)");
                    Payloads$Hello payloads$Hello = (Payloads$Hello) objC5;
                    TimerTask timerTask = aVar7.f278z;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    aVar7.i("[HELLO] raw: " + payloads$Hello);
                    aVar7.v = Long.valueOf(payloads$Hello.getHeartbeatIntervalMs());
                    aVar7.r = payloads$Hello.getServerVersion();
                    aVar7.f276x.cancel();
                    aVar7.w = true;
                    aVar7.k();
                    break;
                case 9:
                    this.this$0.p.succeed();
                    break;
                case 12:
                    a aVar8 = this.this$0;
                    Object objC6 = aVar8.n.c(this.$message.getData(), Payloads$Video.class);
                    m.checkNotNullExpressionValue(objC6, "gson.fromJson(message.da…yloads.Video::class.java)");
                    Payloads$Video payloads$Video = (Payloads$Video) objC6;
                    if (payloads$Video.getUserId() != null) {
                        aVar8.H.a();
                        for (a$d a_d5 : aVar8.q) {
                            m.checkNotNullExpressionValue(a_d5, "it");
                            a_d5.e(payloads$Video.getUserId().longValue(), payloads$Video.getAudioSsrc(), payloads$Video.getVideoSsrc(), payloads$Video.getStreams());
                        }
                    }
                    break;
                case 13:
                    a aVar9 = this.this$0;
                    Object objC7 = aVar9.n.c(this.$message.getData(), Payloads$ClientDisconnect.class);
                    m.checkNotNullExpressionValue(objC7, "gson.fromJson(message.da…ntDisconnect::class.java)");
                    Payloads$ClientDisconnect payloads$ClientDisconnect = (Payloads$ClientDisconnect) objC7;
                    aVar9.H.a();
                    for (a$d a_d6 : aVar9.q) {
                        m.checkNotNullExpressionValue(a_d6, "it");
                        a_d6.j(payloads$ClientDisconnect.getUserId());
                    }
                    break;
                case 14:
                    a aVar10 = this.this$0;
                    Object objC8 = aVar10.n.c(this.$message.getData(), Payloads$SessionUpdate.class);
                    m.checkNotNullExpressionValue(objC8, "gson.fromJson(message.da…essionUpdate::class.java)");
                    Payloads$SessionUpdate payloads$SessionUpdate = (Payloads$SessionUpdate) objC8;
                    aVar10.H.a();
                    for (a$d a_d7 : aVar10.q) {
                        m.checkNotNullExpressionValue(a_d7, "it");
                        String mediaSessionId2 = payloads$SessionUpdate.getMediaSessionId();
                        if (mediaSessionId2 != null) {
                            a_d7.d(mediaSessionId2);
                        }
                    }
                    break;
                case 15:
                    a aVar11 = this.this$0;
                    Gson gson = aVar11.n;
                    JsonElement data = this.$message.getData();
                    Type type = a.k;
                    Objects.requireNonNull(gson);
                    Object objD = data == null ? null : gson.d(new b.i.d.q.x.a(data), type);
                    m.checkNotNullExpressionValue(objD, "gson.fromJson(message.data, MEDIA_SINK_WANTS_TYPE)");
                    Map<String, Integer> map = (Map) objD;
                    aVar11.H.a();
                    for (a$d a_d8 : aVar11.q) {
                        m.checkNotNullExpressionValue(a_d8, "it");
                        a_d8.f(map);
                    }
                    break;
            }
        }
        return Unit.a;
    }
}
