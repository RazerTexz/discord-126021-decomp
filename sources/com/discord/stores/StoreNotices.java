package com.discord.stores;

import android.content.Context;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.g;
import d0.g0.w;
import d0.u.a;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices extends Store {
    public static final StoreNotices$Companion Companion = new StoreNotices$Companion(null);
    public static final String IN_APP_NOTICE_TAG = "InAppNotif";
    public static final String NOTICE_POPUP_TAG = "Popup";
    public static final int PRIORITY_HIGH = 0;
    public static final int PRIORITY_INAPP_NOTIFICATION = 1;
    public static final int PRIORITY_PASSIVE_NOTICE = 10;
    public static final int PRIORITY_USER_SURVEY = 5;
    public static final long PROCESS_PERIOD_MS = 30000;
    public static final long PROCESS_THROTTLE_MS = 50;
    private final Clock clock;

    /* JADX INFO: renamed from: firstUseTimestamp$delegate, reason: from kotlin metadata */
    private final Lazy firstUseTimestamp;
    private HashMap<Integer, Long> lastShownTimes;
    private final BehaviorSubject<StoreNotices$Notice> noticePublisher;
    private final PriorityQueue<StoreNotices$Notice> noticeQueue;
    private final Persister<HashMap<String, Long>> noticesSeenCache;
    private long pollRateMs;
    private final BehaviorSubject<Unit> processTrigger;
    private final StoreStream stream;

    public StoreNotices(Clock clock, StoreStream storeStream) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.noticesSeenCache = new Persister<>("NOTICES_SHOWN_V2", new HashMap());
        this.noticeQueue = new PriorityQueue<>(11, a.compareBy(StoreNotices$noticeQueue$1.INSTANCE, StoreNotices$noticeQueue$2.INSTANCE, StoreNotices$noticeQueue$3.INSTANCE));
        this.pollRateMs = 30000L;
        this.lastShownTimes = new HashMap<>();
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.processTrigger = behaviorSubjectK0;
        BehaviorSubject<StoreNotices$Notice> behaviorSubjectL0 = BehaviorSubject.l0(null);
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(null as Notice?)");
        this.noticePublisher = behaviorSubjectL0;
        this.firstUseTimestamp = g.lazy(new StoreNotices$firstUseTimestamp$2(this));
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreNotices storeNotices) {
        return storeNotices.clock;
    }

    public static final /* synthetic */ PriorityQueue access$getNoticeQueue$p(StoreNotices storeNotices) {
        return storeNotices.noticeQueue;
    }

    public static final /* synthetic */ long access$getPollRateMs$p(StoreNotices storeNotices) {
        return storeNotices.pollRateMs;
    }

    public static final /* synthetic */ void access$processNextNotice(StoreNotices storeNotices) {
        storeNotices.processNextNotice();
    }

    public static final /* synthetic */ void access$setPollRateMs$p(StoreNotices storeNotices, long j) {
        storeNotices.setPollRateMs(j);
    }

    public static /* synthetic */ void markSeen$default(StoreNotices storeNotices, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = storeNotices.clock.currentTimeMillis();
        }
        storeNotices.markSeen(str, j);
    }

    private final synchronized void processNextNotice() {
        Object next;
        Iterator<T> it = this.noticeQueue.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((StoreNotices$Notice) next).shouldShow(this.lastShownTimes));
        this.noticePublisher.onNext((StoreNotices$Notice) next);
    }

    private final void setPollRateMs(long j) {
        this.pollRateMs = Math.max(500L, j);
    }

    public final synchronized void clearSeen(String noticeName) {
        m.checkNotNullParameter(noticeName, "noticeName");
        this.noticesSeenCache.getAndSet(true, new StoreNotices$clearSeen$1(noticeName));
    }

    public final long getFirstUseTimestamp() {
        return ((Number) this.firstUseTimestamp.getValue()).longValue();
    }

    public final Observable<StoreNotices$Notice> getNotices() {
        Observable<StoreNotices$Notice> observableR = this.noticePublisher.r();
        m.checkNotNullExpressionValue(observableR, "noticePublisher.distinctUntilChanged()");
        return observableR;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final synchronized boolean hasBeenSeen(String noticeName) {
        m.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().get(noticeName) != null;
    }

    public final synchronized boolean hasSeen(String noticeName) {
        m.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().containsKey(noticeName);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        AppLog appLog = AppLog.g;
        Logger.d$default(appLog, "Notices init", null, 2, null);
        Logger.d$default(appLog, "Notices prev seen: " + this.noticesSeenCache.get().entrySet(), null, 2, null);
        Observable observableP = this.processTrigger.Y(new StoreNotices$init$1(this)).p(50L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "processTrigger\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableP), StoreNotices.class, (Context) null, (Function1) null, new StoreNotices$init$3(this), (Function0) null, (Function0) null, new StoreNotices$init$2(this), 54, (Object) null);
    }

    public final void markDialogSeen(String noticeDialogType) {
        m.checkNotNullParameter(noticeDialogType, "noticeDialogType");
        try {
            markSeen(StoreNotices$Dialog$Type.valueOf(noticeDialogType));
        } catch (IllegalArgumentException unused) {
            markSeen$default(this, noticeDialogType, 0L, 2, null);
        }
    }

    public final synchronized void markInAppSeen() {
        PriorityQueue<StoreNotices$Notice> priorityQueue = this.noticeQueue;
        ArrayList arrayList = new ArrayList();
        for (Object obj : priorityQueue) {
            if (w.contains$default((CharSequence) ((StoreNotices$Notice) obj).getName(), (CharSequence) IN_APP_NOTICE_TAG, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            markSeen$default(this, ((StoreNotices$Notice) it.next()).getName(), 0L, 2, null);
        }
    }

    public final synchronized void markSeen(String noticeName, long seenAtMs) {
        Object next;
        Object next2;
        m.checkNotNullParameter(noticeName, "noticeName");
        AppLog.i("Notice seen: " + noticeName + " @ " + seenAtMs);
        Iterator<T> it = this.noticeQueue.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((StoreNotices$Notice) next).getName(), noticeName));
        StoreNotices$Notice storeNotices$Notice = (StoreNotices$Notice) next;
        if (storeNotices$Notice != null) {
            this.noticeQueue.remove(storeNotices$Notice);
            if (storeNotices$Notice.getDelayPeriodMs() <= this.pollRateMs) {
                Iterator<T> it2 = this.noticeQueue.iterator();
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (it2.hasNext()) {
                        long delayPeriodMs = ((StoreNotices$Notice) next2).getDelayPeriodMs();
                        do {
                            Object next3 = it2.next();
                            long delayPeriodMs2 = ((StoreNotices$Notice) next3).getDelayPeriodMs();
                            if (delayPeriodMs > delayPeriodMs2) {
                                next2 = next3;
                                delayPeriodMs = delayPeriodMs2;
                            }
                        } while (it2.hasNext());
                    }
                } else {
                    next2 = null;
                }
                StoreNotices$Notice storeNotices$Notice2 = (StoreNotices$Notice) next2;
                setPollRateMs(storeNotices$Notice2 != null ? storeNotices$Notice2.getDelayPeriodMs() : 30000L);
            }
            this.lastShownTimes.put(Integer.valueOf(storeNotices$Notice.getPriority()), Long.valueOf(seenAtMs));
            if (storeNotices$Notice.getPersist()) {
                HashMap<String, Long> map = this.noticesSeenCache.get();
                map.put(storeNotices$Notice.getName(), Long.valueOf(seenAtMs));
                this.noticesSeenCache.set(map, true);
                Logger.v$default(AppLog.g, "Notice seen saved: " + noticeName + " @ " + seenAtMs, null, 2, null);
            }
            this.noticePublisher.onNext(null);
        }
        this.processTrigger.onNext(Unit.a);
    }

    public final Observable<HashMap<String, Long>> observeNoticesSeen() {
        return this.noticesSeenCache.getObservable();
    }

    public final synchronized void requestToShow(StoreNotices$Notice notice) {
        m.checkNotNullParameter(notice, "notice");
        if (notice.canShow(this.noticesSeenCache.get().get(notice.getName()))) {
            PriorityQueue<StoreNotices$Notice> priorityQueue = this.noticeQueue;
            boolean z2 = true;
            if (!(priorityQueue instanceof Collection) || !priorityQueue.isEmpty()) {
                Iterator<T> it = priorityQueue.iterator();
                while (it.hasNext()) {
                    if (m.areEqual(((StoreNotices$Notice) it.next()).getName(), notice.getName())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.noticeQueue.add(notice);
                AppLog.i("Notice Request: " + notice.getName());
                Logger.d$default(AppLog.g, "Notice queues: " + this.noticeQueue, null, 2, null);
                long delayPeriodMs = notice.getDelayPeriodMs();
                if (delayPeriodMs < this.pollRateMs) {
                    setPollRateMs(delayPeriodMs);
                }
                this.processTrigger.onNext(Unit.a);
            }
        }
    }

    public final void markSeen(StoreNotices$Dialog$Type type) {
        m.checkNotNullParameter(type, "type");
        markSeen$default(this, type.name(), 0L, 2, null);
    }
}
