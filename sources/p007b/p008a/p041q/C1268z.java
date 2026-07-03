package p007b.p008a.p041q;

import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.RtcConnection;
import java.util.Map;
import kotlin.Pair;
import p507d0.C12116o;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: b.a.q.z */
/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1268z<T1, T2, R> implements Func2<Map<String, ? extends EncodeQuality>, RtcConnection.StateChange, Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection.State>> {

    /* JADX INFO: renamed from: j */
    public static final C1268z f1874j = new C1268z();

    @Override // p658rx.functions.Func2
    public Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection.State> call(Map<String, ? extends EncodeQuality> map, RtcConnection.StateChange stateChange) {
        return C12116o.m10073to(map, stateChange.state);
    }
}
