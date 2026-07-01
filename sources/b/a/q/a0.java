package b.a.q;

import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 extends d0.z.d.k implements Function1<Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection$State>, Unit> {
    public a0(RtcConnection rtcConnection) {
        super(1, rtcConnection, RtcConnection.class, "onLocalMediaSinkWants", "onLocalMediaSinkWants(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection$State> pair) {
        Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection$State> pair2 = pair;
        d0.z.d.m.checkNotNullParameter(pair2, "p1");
        RtcConnection rtcConnection = (RtcConnection) this.receiver;
        if (rtcConnection.enableMediaSinkWants) {
            Map<String, ? extends EncodeQuality> mapComponent1 = pair2.component1();
            if (d0.z.d.m.areEqual(pair2.component2(), RtcConnection$State$f.a)) {
                rtcConnection.logger.i(rtcConnection.loggingTag, "local MediaSinkWants: " + mapComponent1, null);
                b.a.q.n0.a aVar = rtcConnection.socket;
                if (aVar == null) {
                    RtcConnection.o(rtcConnection, "onLocalMediaSinkWants() socket was null.", null, null, 6);
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(d0.t.g0.mapCapacity(mapComponent1.size()));
                    Iterator<T> it = mapComponent1.entrySet().iterator();
                    while (it.hasNext()) {
                        Map$Entry map$Entry = (Map$Entry) it.next();
                        linkedHashMap.put(map$Entry.getKey(), Integer.valueOf(((EncodeQuality) map$Entry.getValue()).getValue()));
                    }
                    d0.z.d.m.checkNotNullParameter(linkedHashMap, "wants");
                    aVar.H.a();
                    if (aVar.r >= 5) {
                        aVar.n(15, linkedHashMap);
                    }
                }
            }
        }
        return Unit.a;
    }
}
