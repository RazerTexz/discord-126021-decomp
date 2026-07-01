package b.a.z.a.a;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements j0.k.b {
    public final /* synthetic */ long j;
    public final /* synthetic */ long k;
    public final /* synthetic */ Observable l;

    public /* synthetic */ e(long j, long j2, Observable observable) {
        this.j = j;
        this.k = j2;
        this.l = observable;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        long j = this.j;
        long j2 = this.k;
        Observable observable = this.l;
        Channel channel = (Channel) obj;
        if (channel == null) {
            return new j0.l.e.k(null);
        }
        Observable observableH = Observable.h(StoreStream.getUsers().observeMe(), StoreStream.getGuilds().observeGuild(j), StoreStream.getPermissions().observePermissionsForChannel(j2), observable.p(300L, TimeUnit.MILLISECONDS).Y(new g(j, channel)).r(), new j(channel));
        d0.z.d.m.checkNotNullExpressionValue(observableH, "observable");
        return ObservableExtensionsKt.computationBuffered(observableH).r();
    }
}
