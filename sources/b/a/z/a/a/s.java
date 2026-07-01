package b.a.z.a.a;

import com.discord.api.channel.Channel;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s implements j0.k.b {
    public final /* synthetic */ Channel j;

    public /* synthetic */ s(Channel channel) {
        this.j = channel;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        return Observable.h0(new j0.l.a.q((List) obj)).y(new t(this.j)).G(v.j).f0();
    }
}
