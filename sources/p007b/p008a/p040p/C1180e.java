package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import java.util.concurrent.TimeUnit;
import p007b.p008a.p040p.C1186k;
import p007b.p225i.p226a.p242c.C2816k2;
import p637j0.p638j.p640b.C12586a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.e */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1180e<T> implements Action1<C1186k.c> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1584j;

    public C1180e(AppMediaPlayer appMediaPlayer) {
        this.f1584j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(C1186k.c cVar) {
        int i = cVar.f1595a;
        if (i == 2) {
            PublishSubject<AppMediaPlayer.Event> publishSubject = this.f1584j.eventSubject;
            publishSubject.f27650k.onNext(AppMediaPlayer.Event.C5584b.f18655a);
            return;
        }
        if (i == 3) {
            PublishSubject<AppMediaPlayer.Event> publishSubject2 = this.f1584j.eventSubject;
            publishSubject2.f27650k.onNext(AppMediaPlayer.Event.C5583a.f18654a);
            AppMediaPlayer appMediaPlayer = this.f1584j;
            Subscription subscription = appMediaPlayer.positionPollingSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            appMediaPlayer.positionPollingSubscription = Observable.m11062F(500L, 500L, TimeUnit.MILLISECONDS, appMediaPlayer.timerScheduler).m11086L().m11084J(C12586a.m10738a()).m11097W(new C1182g(appMediaPlayer), new C1183h(appMediaPlayer));
            return;
        }
        if (i != 4) {
            return;
        }
        PublishSubject<AppMediaPlayer.Event> publishSubject3 = this.f1584j.eventSubject;
        publishSubject3.f27650k.onNext(AppMediaPlayer.Event.C5587e.f18658a);
        Subscription subscription2 = this.f1584j.positionPollingSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        AppMediaPlayer appMediaPlayer2 = this.f1584j;
        PublishSubject<AppMediaPlayer.Event> publishSubject4 = appMediaPlayer2.eventSubject;
        publishSubject4.f27650k.onNext(new AppMediaPlayer.Event.C5585c(((C2816k2) appMediaPlayer2.exoPlayer).mo2894T()));
    }
}
