package com.discord.stores;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices extends Store {
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
    private final BehaviorSubject<Notice> noticePublisher;
    private final PriorityQueue<Notice> noticeQueue;
    private final Persister<HashMap<String, Long>> noticesSeenCache;
    private long pollRateMs;
    private final BehaviorSubject<Unit> processTrigger;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreNotices.kt */
    public static final /* data */ class Dialog {
        private final Map<String, Object> metadata;
        private final Type type;

        /* JADX INFO: compiled from: StoreNotices.kt */
        public enum Type {
            REQUEST_RATING_MODAL,
            DELETE_CONNECTION_MODAL;

            public static /* synthetic */ PassiveNotice buildPassiveNotice$default(Type type, int i, long j, long j2, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = 10;
                }
                if ((i2 & 2) != 0) {
                    j = 31536000000L;
                }
                long j3 = j;
                if ((i2 & 4) != 0) {
                    j2 = 21600000;
                }
                return type.buildPassiveNotice(i, j3, j2, (i2 & 8) != 0 ? false : z2);
            }

            public final PassiveNotice buildPassiveNotice(int priority, long sinceLastPeriodMs, long delayPeriodMs, boolean persist) {
                return new PassiveNotice(name(), priority, persist, sinceLastPeriodMs, delayPeriodMs, new StoreNotices$Dialog$Type$buildPassiveNotice$1(this));
            }
        }

        public Dialog(Type type, Map<String, ? extends Object> map) {
            C12238m.checkNotNullParameter(type, "type");
            this.type = type;
            this.metadata = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Dialog copy$default(Dialog dialog, Type type, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                type = dialog.type;
            }
            if ((i & 2) != 0) {
                map = dialog.metadata;
            }
            return dialog.copy(type, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final Map<String, Object> component2() {
            return this.metadata;
        }

        public final Dialog copy(Type type, Map<String, ? extends Object> metadata) {
            C12238m.checkNotNullParameter(type, "type");
            return new Dialog(type, metadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dialog)) {
                return false;
            }
            Dialog dialog = (Dialog) other;
            return C12238m.areEqual(this.type, dialog.type) && C12238m.areEqual(this.metadata, dialog.metadata);
        }

        public final Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            int iHashCode = (type != null ? type.hashCode() : 0) * 31;
            Map<String, Object> map = this.metadata;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Dialog(type=");
            sbM833U.append(this.type);
            sbM833U.append(", metadata=");
            return C1643a.m825M(sbM833U, this.metadata, ")");
        }

        public /* synthetic */ Dialog(Type type, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(type, (i & 2) != 0 ? null : map);
        }
    }

    /* JADX INFO: compiled from: StoreNotices.kt */
    public static final /* data */ class InputDialog {
        private final Type type;

        /* JADX INFO: compiled from: StoreNotices.kt */
        public enum Type {
            PASSWORD,
            TEXT_NO_SUGGESTIONS
        }

        public InputDialog(Type type) {
            C12238m.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public static /* synthetic */ InputDialog copy$default(InputDialog inputDialog, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                type = inputDialog.type;
            }
            return inputDialog.copy(type);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final InputDialog copy(Type type) {
            C12238m.checkNotNullParameter(type, "type");
            return new InputDialog(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof InputDialog) && C12238m.areEqual(this.type, ((InputDialog) other).type);
            }
            return true;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("InputDialog(type=");
            sbM833U.append(this.type);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StoreNotices.kt */
    public static class Notice {
        private final boolean autoMarkSeen;
        private final Clock clock;
        private final long delayPeriodMs;
        private boolean hasShown;
        private final String name;
        private final boolean persist;
        private final int priority;
        private final long requestedShowTimestamp;
        private final Function1<FragmentActivity, Boolean> show;
        private final long sinceLastPeriodMs;
        private final List<InterfaceC11230c<? extends AppComponent>> validScreens;

        /* JADX WARN: Multi-variable type inference failed */
        public Notice(String str, Clock clock, long j, int i, boolean z2, List<? extends InterfaceC11230c<? extends AppComponent>> list, long j2, boolean z3, long j3, Function1<? super FragmentActivity, Boolean> function1) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(clock, "clock");
            C12238m.checkNotNullParameter(function1, "show");
            this.name = str;
            this.clock = clock;
            this.requestedShowTimestamp = j;
            this.priority = i;
            this.persist = z2;
            this.validScreens = list;
            this.delayPeriodMs = j2;
            this.autoMarkSeen = z3;
            this.sinceLastPeriodMs = j3;
            this.show = function1;
        }

        public static /* synthetic */ void getHasShown$annotations() {
        }

        public boolean canShow(Long lastSeenMs) {
            return lastSeenMs == null || this.clock.currentTimeMillis() - lastSeenMs.longValue() > this.sinceLastPeriodMs;
        }

        public final boolean getAutoMarkSeen() {
            return this.autoMarkSeen;
        }

        public final Clock getClock() {
            return this.clock;
        }

        public final long getDelayPeriodMs() {
            return this.delayPeriodMs;
        }

        public final boolean getHasShown() {
            return this.hasShown;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getPersist() {
            return this.persist;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final long getRequestedShowTimestamp() {
            return this.requestedShowTimestamp;
        }

        public final Function1<FragmentActivity, Boolean> getShow() {
            return this.show;
        }

        public final long getSinceLastPeriodMs() {
            return this.sinceLastPeriodMs;
        }

        public final List<InterfaceC11230c<? extends AppComponent>> getValidScreens() {
            return this.validScreens;
        }

        public final boolean isInAppNotification() {
            return C12106w.contains((CharSequence) this.name, (CharSequence) StoreNotices.IN_APP_NOTICE_TAG, true);
        }

        public final boolean isPopup() {
            return C12106w.contains((CharSequence) this.name, (CharSequence) StoreNotices.NOTICE_POPUP_TAG, true);
        }

        public final void setHasShown(boolean z2) {
            this.hasShown = z2;
        }

        public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
            C12238m.checkNotNullParameter(lastShownTimes, "lastShownTimes");
            Long l = lastShownTimes.get(Integer.valueOf(this.priority));
            return this.delayPeriodMs < this.clock.currentTimeMillis() - (l != null ? l.longValue() : 0L);
        }

        @MainThread
        public final boolean show(FragmentActivity activity) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (this.hasShown || activity.isFinishing()) {
                return false;
            }
            Boolean boolInvoke = this.show.invoke(activity);
            this.hasShown = boolInvoke.booleanValue();
            return boolInvoke.booleanValue();
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Notice<");
            sbM833U.append(this.name);
            sbM833U.append(">(pri=");
            sbM833U.append(this.priority);
            sbM833U.append(", ts=");
            sbM833U.append(this.requestedShowTimestamp);
            sbM833U.append(')');
            return sbM833U.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Notice(String str, Clock clock, long j, int i, boolean z2, List list, long j2, boolean z3, long j3, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Clock clock2 = (i2 & 2) != 0 ? ClockFactory.get() : clock;
            this(str, clock2, (i2 & 4) != 0 ? clock2.currentTimeMillis() : j, (i2 & 8) != 0 ? 10 : i, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetHome.class), C12216a0.getOrCreateKotlinClass(WidgetCallFullscreen.class)}) : list, (i2 & 64) != 0 ? 15000L : j2, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? 31536000000L : j3, function1);
        }
    }

    /* JADX INFO: compiled from: StoreNotices.kt */
    public static class PassiveNotice extends Notice {
        public /* synthetic */ PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 31536000000L : j, (i2 & 16) != 0 ? 21600000L : j2, function1);
        }

        @Override // com.discord.stores.StoreNotices.Notice
        public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
            C12238m.checkNotNullParameter(lastShownTimes, "lastShownTimes");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Integer, Long>> it = lastShownTimes.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, Long> next = it.next();
                if (next.getKey().intValue() <= getPriority()) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            Long l = (Long) C12163u.maxOrNull((Iterable) linkedHashMap.values());
            return getDelayPeriodMs() < getClock().currentTimeMillis() - (l != null ? l.longValue() : 0L);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1<? super FragmentActivity, Boolean> function1) {
            super(str, null, 0L, i, z2, null, j2, false, j, function1, Opcodes.IF_ACMPNE, null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(function1, "show");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotices$clearSeen$1 */
    /* JADX INFO: compiled from: StoreNotices.kt */
    public static final class C62871 extends AbstractC12240o implements Function1<HashMap<String, Long>, HashMap<String, Long>> {
        public final /* synthetic */ String $noticeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62871(String str) {
            super(1);
            this.$noticeName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final HashMap<String, Long> invoke(HashMap<String, Long> map) {
            C12238m.checkNotNullParameter(map, "cache");
            map.remove(this.$noticeName);
            return map;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotices$init$2 */
    /* JADX INFO: compiled from: StoreNotices.kt */
    public static final class C62892 extends AbstractC12240o implements Function1<Long, Unit> {
        public C62892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreNotices.this.processNextNotice();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNotices$init$3 */
    /* JADX INFO: compiled from: StoreNotices.kt */
    public static final class C62903 extends AbstractC12240o implements Function1<Error, Unit> {
        public C62903() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("Could not process next notice: ");
            sbM833U.append(StoreNotices.this.noticeQueue);
            Logger.e$default(appLog, sbM833U.toString(), error.getThrowable(), null, 4, null);
        }
    }

    public StoreNotices(Clock clock, StoreStream storeStream) {
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.noticesSeenCache = new Persister<>("NOTICES_SHOWN_V2", new HashMap());
        this.noticeQueue = new PriorityQueue<>(11, C12169a.compareBy(StoreNotices$noticeQueue$1.INSTANCE, StoreNotices$noticeQueue$2.INSTANCE, StoreNotices$noticeQueue$3.INSTANCE));
        this.pollRateMs = 30000L;
        this.lastShownTimes = new HashMap<>();
        BehaviorSubject<Unit> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k0, "BehaviorSubject.create()");
        this.processTrigger = behaviorSubjectM11129k0;
        BehaviorSubject<Notice> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(null);
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(null as Notice?)");
        this.noticePublisher = behaviorSubjectM11130l0;
        this.firstUseTimestamp = C12083g.lazy(new StoreNotices$firstUseTimestamp$2(this));
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
        } while (!((Notice) next).shouldShow(this.lastShownTimes));
        this.noticePublisher.onNext((Notice) next);
    }

    private final void setPollRateMs(long j) {
        this.pollRateMs = Math.max(500L, j);
    }

    public final synchronized void clearSeen(String noticeName) {
        C12238m.checkNotNullParameter(noticeName, "noticeName");
        this.noticesSeenCache.getAndSet(true, new C62871(noticeName));
    }

    public final long getFirstUseTimestamp() {
        return ((Number) this.firstUseTimestamp.getValue()).longValue();
    }

    public final Observable<Notice> getNotices() {
        Observable<Notice> observableM11112r = this.noticePublisher.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "noticePublisher.distinctUntilChanged()");
        return observableM11112r;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final synchronized boolean hasBeenSeen(String noticeName) {
        C12238m.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().get(noticeName) != null;
    }

    public final synchronized boolean hasSeen(String noticeName) {
        C12238m.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().containsKey(noticeName);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        AppLog appLog = AppLog.f14950g;
        Logger.d$default(appLog, "Notices init", null, 2, null);
        Logger.d$default(appLog, "Notices prev seen: " + this.noticesSeenCache.get().entrySet(), null, 2, null);
        Observable observableM11110p = this.processTrigger.m11099Y(new InterfaceC12589b<Unit, Observable<? extends Long>>() { // from class: com.discord.stores.StoreNotices.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Long> call(Unit unit) {
                return Observable.m11061E(0L, StoreNotices.this.pollRateMs, TimeUnit.MILLISECONDS);
            }
        }).m11110p(50L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "processTrigger\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableM11110p), (Class<?>) StoreNotices.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C62903()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C62892());
    }

    public final void markDialogSeen(String noticeDialogType) {
        C12238m.checkNotNullParameter(noticeDialogType, "noticeDialogType");
        try {
            markSeen(Dialog.Type.valueOf(noticeDialogType));
        } catch (IllegalArgumentException unused) {
            markSeen$default(this, noticeDialogType, 0L, 2, null);
        }
    }

    public final synchronized void markInAppSeen() {
        PriorityQueue<Notice> priorityQueue = this.noticeQueue;
        ArrayList arrayList = new ArrayList();
        for (Object obj : priorityQueue) {
            if (C12106w.contains$default((CharSequence) ((Notice) obj).getName(), (CharSequence) IN_APP_NOTICE_TAG, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            markSeen$default(this, ((Notice) it.next()).getName(), 0L, 2, null);
        }
    }

    public final synchronized void markSeen(String noticeName, long seenAtMs) {
        Object next;
        Object next2;
        C12238m.checkNotNullParameter(noticeName, "noticeName");
        AppLog.m8358i("Notice seen: " + noticeName + " @ " + seenAtMs);
        Iterator<T> it = this.noticeQueue.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!C12238m.areEqual(((Notice) next).getName(), noticeName));
        Notice notice = (Notice) next;
        if (notice != null) {
            this.noticeQueue.remove(notice);
            if (notice.getDelayPeriodMs() <= this.pollRateMs) {
                Iterator<T> it2 = this.noticeQueue.iterator();
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (it2.hasNext()) {
                        long delayPeriodMs = ((Notice) next2).getDelayPeriodMs();
                        do {
                            Object next3 = it2.next();
                            long delayPeriodMs2 = ((Notice) next3).getDelayPeriodMs();
                            if (delayPeriodMs > delayPeriodMs2) {
                                next2 = next3;
                                delayPeriodMs = delayPeriodMs2;
                            }
                        } while (it2.hasNext());
                    }
                } else {
                    next2 = null;
                }
                Notice notice2 = (Notice) next2;
                setPollRateMs(notice2 != null ? notice2.getDelayPeriodMs() : 30000L);
            }
            this.lastShownTimes.put(Integer.valueOf(notice.getPriority()), Long.valueOf(seenAtMs));
            if (notice.getPersist()) {
                HashMap<String, Long> map = this.noticesSeenCache.get();
                map.put(notice.getName(), Long.valueOf(seenAtMs));
                this.noticesSeenCache.set(map, true);
                Logger.v$default(AppLog.f14950g, "Notice seen saved: " + noticeName + " @ " + seenAtMs, null, 2, null);
            }
            this.noticePublisher.onNext(null);
        }
        this.processTrigger.onNext(Unit.f27425a);
    }

    public final Observable<HashMap<String, Long>> observeNoticesSeen() {
        return this.noticesSeenCache.getObservable();
    }

    public final synchronized void requestToShow(Notice notice) {
        C12238m.checkNotNullParameter(notice, "notice");
        if (notice.canShow(this.noticesSeenCache.get().get(notice.getName()))) {
            PriorityQueue<Notice> priorityQueue = this.noticeQueue;
            boolean z2 = true;
            if (!(priorityQueue instanceof Collection) || !priorityQueue.isEmpty()) {
                Iterator<T> it = priorityQueue.iterator();
                while (it.hasNext()) {
                    if (C12238m.areEqual(((Notice) it.next()).getName(), notice.getName())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.noticeQueue.add(notice);
                AppLog.m8358i("Notice Request: " + notice.getName());
                Logger.d$default(AppLog.f14950g, "Notice queues: " + this.noticeQueue, null, 2, null);
                long delayPeriodMs = notice.getDelayPeriodMs();
                if (delayPeriodMs < this.pollRateMs) {
                    setPollRateMs(delayPeriodMs);
                }
                this.processTrigger.onNext(Unit.f27425a);
            }
        }
    }

    public final void markSeen(Dialog.Type type) {
        C12238m.checkNotNullParameter(type, "type");
        markSeen$default(this, type.name(), 0L, 2, null);
    }
}
