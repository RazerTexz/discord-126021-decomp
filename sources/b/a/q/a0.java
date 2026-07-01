package b.a.q;

import b.a.q.n0.RtcControlSocket;
import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.RtcConnection;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 extends FunctionReferenceImpl implements Function1<Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State>, Unit> {
    public a0(RtcConnection rtcConnection) {
        super(1, rtcConnection, RtcConnection.class, "onLocalMediaSinkWants", "onLocalMediaSinkWants(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State> tuples2) {
        Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State> tuples3 = tuples2;
        Intrinsics3.checkNotNullParameter(tuples3, "p1");
        RtcConnection rtcConnection = (RtcConnection) this.receiver;
        if (rtcConnection.enableMediaSinkWants) {
            Map<String, ? extends MediaSinkWantsManager9> mapComponent1 = tuples3.component1();
            if (Intrinsics3.areEqual(tuples3.component2(), RtcConnection.State.f.a)) {
                rtcConnection.logger.i(rtcConnection.loggingTag, "local MediaSinkWants: " + mapComponent1, null);
                RtcControlSocket rtcControlSocket = rtcConnection.socket;
                if (rtcControlSocket == null) {
                    RtcConnection.o(rtcConnection, "onLocalMediaSinkWants() socket was null.", null, null, 6);
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(mapComponent1.size()));
                    Iterator<T> it = mapComponent1.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap.put(entry.getKey(), Integer.valueOf(((MediaSinkWantsManager9) entry.getValue()).getValue()));
                    }
                    Intrinsics3.checkNotNullParameter(linkedHashMap, "wants");
                    rtcControlSocket.H.a();
                    if (rtcControlSocket.r >= 5) {
                        rtcControlSocket.n(15, linkedHashMap);
                    }
                }
            }
        }
        return Unit.a;
    }
}
