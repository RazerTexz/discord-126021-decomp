package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$ConnectionState;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$a;
import java.util.List;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c extends MediaEngineConnection$a {
    public final /* synthetic */ k a;

    public k$c(k kVar) {
        this.a = kVar;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$a, com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$TransportInfo mediaEngineConnection$TransportInfo, List<b.a.q.m0.a> list) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$TransportInfo, "transportInfo");
        d0.z.d.m.checkNotNullParameter(list, "supportedVideoCodecs");
        this.a.o(new k$c$a(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$a, com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$ConnectionState, "connectionState");
        if (mediaEngineConnection$ConnectionState == MediaEngineConnection$ConnectionState.DISCONNECTED) {
            this.a.o(new k$c$b(this, mediaEngineConnection));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$a, com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onDestroy(MediaEngineConnection mediaEngineConnection) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        this.a.o(new k$c$c(this, mediaEngineConnection));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection$a, com.discord.rtcconnection.mediaengine.MediaEngineConnection$d
    public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection$FailedConnectionException mediaEngineConnection$FailedConnectionException) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection, "connection");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$FailedConnectionException, "exception");
        this.a.o(new k$c$d(this, mediaEngineConnection));
    }
}
