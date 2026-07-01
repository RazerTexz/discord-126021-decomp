package b.a.p;

import b.i.a.c.k2;
import com.discord.player.AppMediaPlayer;
import com.discord.player.AppMediaPlayer$Event;
import com.discord.player.AppMediaPlayer$Event$c;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g<T> implements Action1<Long> {
    public final /* synthetic */ AppMediaPlayer j;

    public g(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(Long l) {
        AppMediaPlayer appMediaPlayer = this.j;
        PublishSubject<AppMediaPlayer$Event> publishSubject = appMediaPlayer.eventSubject;
        publishSubject.k.onNext(new AppMediaPlayer$Event$c(((k2) appMediaPlayer.exoPlayer).T()));
    }
}
