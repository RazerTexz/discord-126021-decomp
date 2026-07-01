package b.a.p;

import b.a.p.RxPlayerEventListener;
import com.discord.player.AppMediaPlayer;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.a, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer2<T> implements Action1<RxPlayerEventListener.a> {
    public final /* synthetic */ AppMediaPlayer j;

    public AppMediaPlayer2(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(RxPlayerEventListener.a aVar) {
        this.j.eventSubject.k.onNext(aVar.a ? AppMediaPlayer.Event.f.a : AppMediaPlayer.Event.d.a);
    }
}
