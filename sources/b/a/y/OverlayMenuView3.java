package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: renamed from: b.a.y.r, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView3<T, R> implements Func1<Channel, Observable<? extends OverlayMenuView.a>> {
    public static final OverlayMenuView3 j = new OverlayMenuView3();

    @Override // j0.k.Func1
    public Observable<? extends OverlayMenuView.a> call(Channel channel) {
        Object overlayMenuView6;
        Channel channel2 = channel;
        if (channel2 == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel2.getId());
        Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel2.getGuildId());
        Observable<CallModel> observable = CallModel.INSTANCE.get(channel2.getId());
        Observable<RtcConnection.Quality> quality = companion.getRtcConnection().getQuality();
        OverlayMenuView2 overlayMenuView2 = OverlayMenuView2.j;
        if (overlayMenuView2 != null) {
            overlayMenuView6 = overlayMenuView2;
            overlayMenuView6 = new OverlayMenuView6(overlayMenuView2);
        }
        overlayMenuView6 = overlayMenuView2;
        return Observable.h(observableObservePermissionsForChannel, observableObserveGuild, observable, quality, (Func4) overlayMenuView6);
    }
}
