package b.a.q;

import com.discord.rtcconnection.MediaSinkWantsManager9;
import com.discord.rtcconnection.RtcConnection;
import d0.Tuples;
import java.util.Map;
import kotlin.Tuples2;
import rx.functions.Func2;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z<T1, T2, R> implements Func2<Map<String, ? extends MediaSinkWantsManager9>, RtcConnection.StateChange, Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State>> {
    public static final z j = new z();

    @Override // rx.functions.Func2
    public Tuples2<? extends Map<String, ? extends MediaSinkWantsManager9>, ? extends RtcConnection.State> call(Map<String, ? extends MediaSinkWantsManager9> map, RtcConnection.StateChange stateChange) {
        return Tuples.to(map, stateChange.state);
    }
}
