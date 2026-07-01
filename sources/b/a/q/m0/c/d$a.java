package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection$ConnectionState;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo$Protocol;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord$ConnectionInfo;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$a extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ Discord$ConnectionInfo $connectionInfo;
    public final /* synthetic */ String $errorMessage;
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(d dVar, Discord$ConnectionInfo discord$ConnectionInfo, String str) {
        super(0);
        this.this$0 = dVar;
        this.$connectionInfo = discord$ConnectionInfo;
        this.$errorMessage = str;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x0089  */
    /* JADX WARN: Code duplicated, block: B:15:0x0092  */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        e eVar = this.this$0.a;
        Discord$ConnectionInfo discord$ConnectionInfo = this.$connectionInfo;
        String str = this.$errorMessage;
        Logger.i$default(eVar.l, "MediaEngineConnectionLegacy", b.d.b.a.a.w("handleConnection(). errorMessage: ", str), null, 4, null);
        if (discord$ConnectionInfo != null) {
            if (str == null || str.length() == 0) {
                String str2 = discord$ConnectionInfo.localAddress;
                d0.z.d.m.checkNotNullExpressionValue(str2, "connectionInfo.localAddress");
                int i = discord$ConnectionInfo.localPort;
                String str3 = discord$ConnectionInfo.protocol;
                d0.z.d.m.checkNotNullExpressionValue(str3, "connectionInfo.protocol");
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String upperCase = str3.toUpperCase();
                d0.z.d.m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo = new MediaEngineConnection$TransportInfo(str2, i, MediaEngineConnection$TransportInfo$Protocol.valueOf(upperCase));
                MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState = MediaEngineConnection$ConnectionState.CONNECTED;
                eVar.f270b = mediaEngineConnection$ConnectionState;
                eVar.y(new a(eVar, mediaEngineConnection$ConnectionState));
                b.a.q.m0.a aVar = new b.a.q.m0.a("opus", 1, MediaStreamTrack.AUDIO_TRACK_KIND, 120, null);
                eVar.i.clear();
                eVar.i.add(aVar);
                eVar.i.addAll(eVar.o);
                eVar.y(new defpackage.m(0, eVar, mediaEngineConnection$TransportInfo));
            } else if (discord$ConnectionInfo == null) {
                eVar.y(new defpackage.m(1, eVar, str));
            } else {
                eVar.y(new defpackage.m(2, eVar, str));
            }
        } else if (discord$ConnectionInfo == null) {
            eVar.y(new defpackage.m(1, eVar, str));
        } else {
            eVar.y(new defpackage.m(2, eVar, str));
        }
        return Unit.a;
    }
}
