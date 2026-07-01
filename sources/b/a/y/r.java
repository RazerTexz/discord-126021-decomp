package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.views.OverlayMenuView$a;
import com.discord.widgets.voice.model.CallModel;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T, R> implements j0.k.b<Channel, Observable<? extends OverlayMenuView$a>> {
    public static final r j = new r();

    @Override // j0.k.b
    public Observable<? extends OverlayMenuView$a> call(Channel channel) {
        Object uVar;
        Channel channel2 = channel;
        if (channel2 == null) {
            return new j0.l.e.k(null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Long> observableObservePermissionsForChannel = storeStream$Companion.getPermissions().observePermissionsForChannel(channel2.getId());
        Observable<Guild> observableObserveGuild = storeStream$Companion.getGuilds().observeGuild(channel2.getGuildId());
        Observable<CallModel> observable = CallModel.Companion.get(channel2.getId());
        Observable<RtcConnection$Quality> quality = storeStream$Companion.getRtcConnection().getQuality();
        q qVar = q.j;
        if (qVar != null) {
            uVar = qVar;
            uVar = new u(qVar);
        }
        uVar = qVar;
        return Observable.h(observableObservePermissionsForChannel, observableObserveGuild, observable, quality, (Func4) uVar);
    }
}
