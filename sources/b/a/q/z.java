package b.a.q;

import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$StateChange;
import java.util.Map;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z<T1, T2, R> implements Func2<Map<String, ? extends EncodeQuality>, RtcConnection$StateChange, Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection$State>> {
    public static final z j = new z();

    @Override // rx.functions.Func2
    public Pair<? extends Map<String, ? extends EncodeQuality>, ? extends RtcConnection$State> call(Map<String, ? extends EncodeQuality> map, RtcConnection$StateChange rtcConnection$StateChange) {
        return d0.o.to(map, rtcConnection$StateChange.state);
    }
}
