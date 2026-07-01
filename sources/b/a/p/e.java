package b.a.p;

import b.i.a.c.k2;
import com.discord.player.AppMediaPlayer;
import com.discord.player.AppMediaPlayer$Event;
import com.discord.player.AppMediaPlayer$Event$a;
import com.discord.player.AppMediaPlayer$Event$b;
import com.discord.player.AppMediaPlayer$Event$c;
import com.discord.player.AppMediaPlayer$Event$e;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e<T> implements Action1<k$c> {
    public final /* synthetic */ AppMediaPlayer j;

    public e(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(k$c k_c) {
        int i = k_c.a;
        if (i == 2) {
            PublishSubject<AppMediaPlayer$Event> publishSubject = this.j.eventSubject;
            publishSubject.k.onNext(AppMediaPlayer$Event$b.a);
            return;
        }
        if (i == 3) {
            PublishSubject<AppMediaPlayer$Event> publishSubject2 = this.j.eventSubject;
            publishSubject2.k.onNext(AppMediaPlayer$Event$a.a);
            AppMediaPlayer appMediaPlayer = this.j;
            Subscription subscription = appMediaPlayer.positionPollingSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            appMediaPlayer.positionPollingSubscription = Observable.F(500L, 500L, TimeUnit.MILLISECONDS, appMediaPlayer.timerScheduler).L().J(j0.j.b.a.a()).W(new g(appMediaPlayer), new h(appMediaPlayer));
            return;
        }
        if (i != 4) {
            return;
        }
        PublishSubject<AppMediaPlayer$Event> publishSubject3 = this.j.eventSubject;
        publishSubject3.k.onNext(AppMediaPlayer$Event$e.a);
        Subscription subscription2 = this.j.positionPollingSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        AppMediaPlayer appMediaPlayer2 = this.j;
        PublishSubject<AppMediaPlayer$Event> publishSubject4 = appMediaPlayer2.eventSubject;
        publishSubject4.k.onNext(new AppMediaPlayer$Event$c(((k2) appMediaPlayer2.exoPlayer).T()));
    }
}
