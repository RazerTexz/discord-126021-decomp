package com.discord.utilities.video;

import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p638j.p640b.C12586a;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;

/* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoPlayerIdleDetector {
    private final Scheduler backgroundThreadScheduler;
    private final long idleDetectionMs;
    private final Scheduler idleDetectionScheduler;
    private Subscription idleDetectionSubscription;
    private boolean isIdle;
    private final Function1<Boolean, Unit> onIdleStateChanged;

    /* JADX INFO: renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$1 */
    /* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
    public static final class C69871 extends AbstractC12240o implements Function1<Long, Unit> {
        public C69871() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            VideoPlayerIdleDetector.this.setIdle(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$2 */
    /* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
    public static final class C69882 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C69882() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            VideoPlayerIdleDetector.this.idleDetectionSubscription = subscription;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPlayerIdleDetector(long j, Scheduler scheduler, Scheduler scheduler2, Function1<? super Boolean, Unit> function1) {
        C12238m.checkNotNullParameter(scheduler, "idleDetectionScheduler");
        C12238m.checkNotNullParameter(scheduler2, "backgroundThreadScheduler");
        C12238m.checkNotNullParameter(function1, "onIdleStateChanged");
        this.idleDetectionMs = j;
        this.idleDetectionScheduler = scheduler;
        this.backgroundThreadScheduler = scheduler2;
        this.onIdleStateChanged = function1;
    }

    private final void beginIdleDetectionTimer() {
        cancelIdleDetectionTimer();
        Observable<Long> observableM11084J = Observable.m11070e0(this.idleDetectionMs, TimeUnit.MILLISECONDS, this.backgroundThreadScheduler).m11084J(this.idleDetectionScheduler);
        C12238m.checkNotNullExpressionValue(observableM11084J, "Observable\n        .time…n(idleDetectionScheduler)");
        ObservableExtensionsKt.appSubscribe(observableM11084J, (Class<?>) VideoPlayerIdleDetector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C69882()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C69871());
    }

    private final void cancelIdleDetectionTimer() {
        Subscription subscription = this.idleDetectionSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.idleDetectionSubscription = null;
    }

    public static /* synthetic */ void onInteraction$default(VideoPlayerIdleDetector videoPlayerIdleDetector, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        videoPlayerIdleDetector.onInteraction(z2);
    }

    private final void setIdle(boolean isIdle) {
        if (isIdle != this.isIdle) {
            this.isIdle = isIdle;
            this.onIdleStateChanged.invoke(Boolean.valueOf(isIdle));
        }
    }

    public final void beginIdleDetection() {
        if (this.idleDetectionSubscription == null) {
            setIdle(false);
            beginIdleDetectionTimer();
        }
    }

    public final void dispose() {
        cancelIdleDetectionTimer();
        setIdle(false);
    }

    public final void endIdleDetection() {
        cancelIdleDetectionTimer();
        setIdle(false);
    }

    /* JADX INFO: renamed from: isIdle, reason: from getter */
    public final boolean getIsIdle() {
        return this.isIdle;
    }

    public final void onInteraction(boolean otherIsIdle) {
        if ((this.isIdle || otherIsIdle) ? false : true) {
            cancelIdleDetectionTimer();
            setIdle(true);
        } else {
            setIdle(false);
            beginIdleDetectionTimer();
        }
    }

    public final void onPreventIdle() {
        setIdle(false);
        if (this.idleDetectionSubscription != null) {
            beginIdleDetectionTimer();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ VideoPlayerIdleDetector(long j, Scheduler scheduler, Scheduler scheduler2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 1) != 0 ? 3000L : j;
        if ((i & 2) != 0) {
            scheduler = C12586a.m10738a();
            C12238m.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        Scheduler scheduler3 = scheduler;
        if ((i & 4) != 0) {
            scheduler2 = C12781a.m10873a();
            C12238m.checkNotNullExpressionValue(scheduler2, "Schedulers.computation()");
        }
        this(j2, scheduler3, scheduler2, function1);
    }
}
