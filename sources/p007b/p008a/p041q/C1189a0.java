package p007b.p008a.p041q;

import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.RtcConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.p046n0.C1245a;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.a0 */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1189a0 extends C12236k implements Function1<Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection.State>, Unit> {
    public C1189a0(RtcConnection rtcConnection) {
        super(1, rtcConnection, RtcConnection.class, "onLocalMediaSinkWants", "onLocalMediaSinkWants(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection.State> pair) {
        Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection.State> pair2 = pair;
        C12238m.checkNotNullParameter(pair2, "p1");
        RtcConnection rtcConnection = (RtcConnection) this.receiver;
        if (rtcConnection.enableMediaSinkWants) {
            Map<String, ? extends EncodeQuality> mapComponent1 = pair2.component1();
            if (C12238m.areEqual(pair2.component2(), RtcConnection.State.C5612f.f18814a)) {
                rtcConnection.logger.mo8366i(rtcConnection.loggingTag, "local MediaSinkWants: " + mapComponent1, null);
                C1245a c1245a = rtcConnection.socket;
                if (c1245a == null) {
                    RtcConnection.m8460o(rtcConnection, "onLocalMediaSinkWants() socket was null.", null, null, 6);
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(mapComponent1.size()));
                    Iterator<T> it = mapComponent1.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap.put(entry.getKey(), Integer.valueOf(((EncodeQuality) entry.getValue()).getValue()));
                    }
                    C12238m.checkNotNullParameter(linkedHashMap, "wants");
                    c1245a.f1773H.m266a();
                    if (c1245a.f1781r >= 5) {
                        c1245a.m350n(15, linkedHashMap);
                    }
                }
            }
        }
        return Unit.f27425a;
    }
}
