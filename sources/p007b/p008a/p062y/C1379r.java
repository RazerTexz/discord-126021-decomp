package p007b.p008a.p062y;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: b.a.y.r */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1379r<T, R> implements InterfaceC12589b<Channel, Observable<? extends OverlayMenuView.C7085a>> {

    /* JADX INFO: renamed from: j */
    public static final C1379r f2068j = new C1379r();

    @Override // p637j0.p641k.InterfaceC12589b
    public Observable<? extends OverlayMenuView.C7085a> call(Channel channel) {
        Object c1385u;
        Channel channel2 = channel;
        if (channel2 == null) {
            return new C12721k(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel2.getId());
        Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel2.getGuildId());
        Observable<CallModel> observable = CallModel.INSTANCE.get(channel2.getId());
        Observable<RtcConnection.Quality> quality = companion.getRtcConnection().getQuality();
        C1370q c1370q = C1370q.f2065j;
        if (c1370q != null) {
            c1385u = c1370q;
            c1385u = new C1385u(c1370q);
        }
        c1385u = c1370q;
        return Observable.m11073h(observableObservePermissionsForChannel, observableObserveGuild, observable, quality, (Func4) c1385u);
    }
}
