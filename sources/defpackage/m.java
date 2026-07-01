package defpackage;

import b.a.q.m0.c.e;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException$FailureType;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$TransportInfo;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import d0.g0.w;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends o implements Function1<MediaEngineConnection$d, Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i, Object obj, Object obj2) {
        super(1);
        this.j = i;
        this.k = obj;
        this.l = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(MediaEngineConnection$d mediaEngineConnection$d) {
        MediaEngineConnection$FailedConnectionException$FailureType mediaEngineConnection$FailedConnectionException$FailureType;
        int i = this.j;
        if (i == 0) {
            MediaEngineConnection$d mediaEngineConnection$d2 = mediaEngineConnection$d;
            d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d2, "it");
            e eVar = (e) this.k;
            mediaEngineConnection$d2.onConnected(eVar, (MediaEngineConnection$TransportInfo) this.l, eVar.i);
            return Unit.a;
        }
        if (i == 1) {
            MediaEngineConnection$d mediaEngineConnection$d3 = mediaEngineConnection$d;
            d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d3, "it");
            mediaEngineConnection$d3.onError((e) this.k, new MediaEngineConnection$FailedConnectionException("No connection info. Error message from media engine: " + ((String) this.l), MediaEngineConnection$FailedConnectionException$FailureType.NO_CONNECTION_INFO));
            return Unit.a;
        }
        if (i != 2) {
            throw null;
        }
        MediaEngineConnection$d mediaEngineConnection$d4 = mediaEngineConnection$d;
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d4, "it");
        e eVar2 = (e) this.k;
        String str = (String) this.l;
        Objects.requireNonNull(MediaEngineConnection$FailedConnectionException$FailureType.Companion);
        if (str != null ? w.contains((CharSequence) str, (CharSequence) "Disconnected before we managed to connect", true) : false) {
            mediaEngineConnection$FailedConnectionException$FailureType = MediaEngineConnection$FailedConnectionException$FailureType.DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED;
        } else {
            if (str != null ? w.contains((CharSequence) str, (CharSequence) "OnConnectAttemptTimedOut", true) : false) {
                mediaEngineConnection$FailedConnectionException$FailureType = MediaEngineConnection$FailedConnectionException$FailureType.TIMEOUT;
            } else {
                mediaEngineConnection$FailedConnectionException$FailureType = str != null ? w.contains((CharSequence) str, (CharSequence) "OnAddressIPResolved", true) : false ? MediaEngineConnection$FailedConnectionException$FailureType.ADDRESS_IP_RESOLVED : MediaEngineConnection$FailedConnectionException$FailureType.UNKNOWN;
            }
        }
        mediaEngineConnection$d4.onError(eVar2, new MediaEngineConnection$FailedConnectionException(str, mediaEngineConnection$FailedConnectionException$FailureType));
        return Unit.a;
    }
}
