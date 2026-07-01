package b.a.p;

import b.i.a.c.SimpleExoPlayer;
import com.discord.player.AppMediaPlayer;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.g, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer8<T> implements Action1<Long> {
    public final /* synthetic */ AppMediaPlayer j;

    public AppMediaPlayer8(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(Long l) {
        AppMediaPlayer appMediaPlayer = this.j;
        PublishSubject<AppMediaPlayer.Event> publishSubject = appMediaPlayer.eventSubject;
        publishSubject.k.onNext(new AppMediaPlayer.Event.c(((SimpleExoPlayer) appMediaPlayer.exoPlayer).T()));
    }
}
