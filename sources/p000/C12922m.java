package p000;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.p044m0.p045c.C1227e;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: m */
/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class C12922m extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f27492j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f27493k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f27494l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12922m(int i, Object obj, Object obj2) {
        super(1);
        this.f27492j = i;
        this.f27493k = obj;
        this.f27494l = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        MediaEngineConnection.FailedConnectionException.FailureType failureType;
        int i = this.f27492j;
        if (i == 0) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            C1227e c1227e = (C1227e) this.f27493k;
            interfaceC5648d2.onConnected(c1227e, (MediaEngineConnection.TransportInfo) this.f27494l, c1227e.f1706i);
            return Unit.f27425a;
        }
        if (i == 1) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d3 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d3, "it");
            interfaceC5648d3.onError((C1227e) this.f27493k, new MediaEngineConnection.FailedConnectionException("No connection info. Error message from media engine: " + ((String) this.f27494l), MediaEngineConnection.FailedConnectionException.FailureType.NO_CONNECTION_INFO));
            return Unit.f27425a;
        }
        if (i != 2) {
            throw null;
        }
        MediaEngineConnection.InterfaceC5648d interfaceC5648d4 = interfaceC5648d;
        C12238m.checkNotNullParameter(interfaceC5648d4, "it");
        C1227e c1227e2 = (C1227e) this.f27493k;
        String str = (String) this.f27494l;
        Objects.requireNonNull(MediaEngineConnection.FailedConnectionException.FailureType.INSTANCE);
        if (str != null ? C12106w.contains((CharSequence) str, (CharSequence) "Disconnected before we managed to connect", true) : false) {
            failureType = MediaEngineConnection.FailedConnectionException.FailureType.DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED;
        } else {
            if (str != null ? C12106w.contains((CharSequence) str, (CharSequence) "OnConnectAttemptTimedOut", true) : false) {
                failureType = MediaEngineConnection.FailedConnectionException.FailureType.TIMEOUT;
            } else {
                failureType = str != null ? C12106w.contains((CharSequence) str, (CharSequence) "OnAddressIPResolved", true) : false ? MediaEngineConnection.FailedConnectionException.FailureType.ADDRESS_IP_RESOLVED : MediaEngineConnection.FailedConnectionException.FailureType.UNKNOWN;
            }
        }
        interfaceC5648d4.onError(c1227e2, new MediaEngineConnection.FailedConnectionException(str, failureType));
        return Unit.f27425a;
    }
}
