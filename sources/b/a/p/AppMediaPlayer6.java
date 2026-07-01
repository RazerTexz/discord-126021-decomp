package b.a.p;

import b.a.p.RxPlayerEventListener;
import b.i.a.c.SimpleExoPlayer;
import com.discord.player.AppMediaPlayer;
import j0.j.b.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.e, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer6<T> implements Action1<RxPlayerEventListener.c> {
    public final /* synthetic */ AppMediaPlayer j;

    public AppMediaPlayer6(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(RxPlayerEventListener.c cVar) {
        int i = cVar.a;
        if (i == 2) {
            PublishSubject<AppMediaPlayer.Event> publishSubject = this.j.eventSubject;
            publishSubject.k.onNext(AppMediaPlayer.Event.b.a);
            return;
        }
        if (i == 3) {
            PublishSubject<AppMediaPlayer.Event> publishSubject2 = this.j.eventSubject;
            publishSubject2.k.onNext(AppMediaPlayer.Event.a.a);
            AppMediaPlayer appMediaPlayer = this.j;
            Subscription subscription = appMediaPlayer.positionPollingSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            appMediaPlayer.positionPollingSubscription = Observable.F(500L, 500L, TimeUnit.MILLISECONDS, appMediaPlayer.timerScheduler).L().J(AndroidSchedulers.a()).W(new AppMediaPlayer8(appMediaPlayer), new AppMediaPlayer9(appMediaPlayer));
            return;
        }
        if (i != 4) {
            return;
        }
        PublishSubject<AppMediaPlayer.Event> publishSubject3 = this.j.eventSubject;
        publishSubject3.k.onNext(AppMediaPlayer.Event.e.a);
        Subscription subscription2 = this.j.positionPollingSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        AppMediaPlayer appMediaPlayer2 = this.j;
        PublishSubject<AppMediaPlayer.Event> publishSubject4 = appMediaPlayer2.eventSubject;
        publishSubject4.k.onNext(new AppMediaPlayer.Event.c(((SimpleExoPlayer) appMediaPlayer2.exoPlayer).T()));
    }
}
