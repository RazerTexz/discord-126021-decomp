package com.discord.stores.updates;

import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck {
    private static final String LOG_CATEGORY = "ObservationDeck";
    private final LogLevel logLevel;
    private final Logger logger;
    private List<Observer> observers;
    private static final Function0<Unit> ON_UPDATE_EMPTY = ObservationDeck$Companion$ON_UPDATE_EMPTY$1.INSTANCE;

    /* JADX INFO: compiled from: ObservationDeck.kt */
    public enum LogLevel {
        NONE,
        ERROR,
        VERBOSE
    }

    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static abstract class Observer {
        private boolean isStale;

        public abstract String getName();

        public abstract Set<UpdateSource> getObservingUpdates();

        public abstract Function0<Unit> getOnUpdate();

        /* JADX INFO: renamed from: isStale, reason: from getter */
        public final boolean getIsStale() {
            return this.isStale;
        }

        public final void markStale() {
            this.isStale = true;
            setOnUpdate(ObservationDeck.ON_UPDATE_EMPTY);
        }

        public abstract void setOnUpdate(Function0<Unit> function0);

        public final String toDebugLogString() {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbM833U = C1643a.m833U("Observer name: ");
            String name = getName();
            if (name == null) {
                name = "Unknown";
            }
            sbM833U.append(name);
            sbM833U.append('\n');
            sb.append(sbM833U.toString());
            sb.append(C12163u.joinToString$default(getObservingUpdates(), ", ", null, null, 0, null, null, 62, null));
            String string = sb.toString();
            C12238m.checkNotNullExpressionValue(string, "stringBuilder.toString()");
            return string;
        }
    }

    /* JADX INFO: compiled from: ObservationDeck.kt */
    public interface UpdateSource {
    }

    /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$logNotifyError$2 */
    /* JADX INFO: compiled from: ObservationDeck.kt */
    public static final class C66352 extends AbstractC12240o implements Function1<Observer, CharSequence> {
        public static final C66352 INSTANCE = new C66352();

        public C66352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(Observer observer) {
            C12238m.checkNotNullParameter(observer, "observer");
            return observer.toDebugLogString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObservationDeck() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ObservationDeck(Logger logger, LogLevel logLevel) {
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(logLevel, "logLevel");
        this.logger = logger;
        this.logLevel = logLevel;
        this.observers = new ArrayList();
    }

    public static /* synthetic */ Observer connect$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return observationDeck.connect(updateSourceArr, z2, str, function0);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, Emitter.BackpressureMode backpressureMode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            backpressureMode = Emitter.BackpressureMode.LATEST;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(updateSourceArr, z2, backpressureMode, str);
    }

    private final void logBreadcrumb(String message) {
        if (this.logLevel == LogLevel.VERBOSE) {
            this.logger.recordBreadcrumb(message, LOG_CATEGORY);
        }
    }

    private final void logNotifyError(Throwable throwable, Set<? extends UpdateSource> updates) {
        Logger logger = this.logger;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = C12116o.m10073to("Update Sources", C12163u.joinToString$default(updates, ", ", null, null, 0, null, null, 62, null));
        List<Observer> list = this.observers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                pairArr[1] = C12116o.m10073to("Observers", C12163u.joinToString$default(arrayList, "\n", null, null, 0, null, C66352.INSTANCE, 30, null));
                logger.mo8364e("ObservationDeck notify error", throwable, C12136h0.mapOf(pairArr));
                return;
            }
            Object next = it.next();
            Observer observer = (Observer) next;
            if (!(updates instanceof Collection) || !updates.isEmpty()) {
                Iterator<T> it2 = updates.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!observer.getObservingUpdates().contains((UpdateSource) it2.next()));
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    public final synchronized Observer connect(final UpdateSource[] updateSources, boolean updateOnConnect, final String observerName, final Function0<Unit> onUpdate) {
        Observer observer;
        C12238m.checkNotNullParameter(updateSources, "updateSources");
        C12238m.checkNotNullParameter(onUpdate, "onUpdate");
        observer = new Observer(updateSources, onUpdate, observerName) { // from class: com.discord.stores.updates.ObservationDeck$connect$observer$1
            public final /* synthetic */ String $observerName;
            public final /* synthetic */ Function0 $onUpdate;
            public final /* synthetic */ ObservationDeck.UpdateSource[] $updateSources;
            private final String name;
            private final Set<ObservationDeck.UpdateSource> observingUpdates;
            private Function0<Unit> onUpdate;

            {
                this.$updateSources = updateSources;
                this.$onUpdate = onUpdate;
                this.$observerName = observerName;
                this.observingUpdates = C12141k.toSet(updateSources);
                this.onUpdate = onUpdate;
                this.name = observerName == null ? String.valueOf(hashCode()) : observerName;
            }

            @Override // com.discord.stores.updates.ObservationDeck.Observer
            public String getName() {
                return this.name;
            }

            @Override // com.discord.stores.updates.ObservationDeck.Observer
            public Set<ObservationDeck.UpdateSource> getObservingUpdates() {
                return this.observingUpdates;
            }

            @Override // com.discord.stores.updates.ObservationDeck.Observer
            public Function0<Unit> getOnUpdate() {
                return this.onUpdate;
            }

            @Override // com.discord.stores.updates.ObservationDeck.Observer
            public void setOnUpdate(Function0<Unit> function0) {
                C12238m.checkNotNullParameter(function0, "<set-?>");
                this.onUpdate = function0;
            }
        };
        connect(observer, updateOnConnect);
        return observer;
    }

    public final synchronized Observable<Unit> connectRx(final UpdateSource[] updateSources, final boolean updateOnConnect, Emitter.BackpressureMode backpressureMode, final String observerName) {
        Observable<Unit> observableM11117w;
        C12238m.checkNotNullParameter(updateSources, "updateSources");
        C12238m.checkNotNullParameter(backpressureMode, "backpressureMode");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        observableM11117w = Observable.m11080o(new Action1<Emitter<Unit>>() { // from class: com.discord.stores.updates.ObservationDeck.connectRx.1

            /* JADX INFO: renamed from: com.discord.stores.updates.ObservationDeck$connectRx$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: ObservationDeck.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ Emitter $emitter;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(Emitter emitter) {
                    super(0);
                    this.$emitter = emitter;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.$emitter.onNext(Unit.f27425a);
                }
            }

            @Override // p658rx.functions.Action1
            public final void call(Emitter<Unit> emitter) {
                Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                ObservationDeck observationDeck = ObservationDeck.this;
                boolean z2 = updateOnConnect;
                String str = observerName;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(emitter);
                UpdateSource[] updateSourceArr = updateSources;
                ref$ObjectRef2.element = (T) observationDeck.connect((UpdateSource[]) Arrays.copyOf(updateSourceArr, updateSourceArr.length), z2, str, anonymousClass1);
            }
        }, backpressureMode).m11117w(new Action0() { // from class: com.discord.stores.updates.ObservationDeck.connectRx.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p658rx.functions.Action0
            public final void call() {
                Observer observer = (Observer) ref$ObjectRef.element;
                if (observer != null) {
                    ObservationDeck.this.disconnect(observer);
                }
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11117w, "Observable.create<Unit>(…rver?.let(::disconnect) }");
        return observableM11117w;
    }

    public final synchronized void disconnect(Observer observer) {
        C12238m.checkNotNullParameter(observer, "observer");
        logBreadcrumb("disconnect START. observer: " + observer.getName());
        observer.markStale();
        logBreadcrumb("disconnect END. observer: " + observer.getName());
    }

    public final synchronized void notify(Set<? extends UpdateSource> updates) {
        String str;
        boolean z2;
        C12238m.checkNotNullParameter(updates, "updates");
        logBreadcrumb("notify START");
        int i = 0;
        while (i < this.observers.size()) {
            try {
                Observer observer = this.observers.get(i);
                if (observer.getIsStale()) {
                    logBreadcrumb("removing observer: " + observer.getName());
                    this.observers.remove(i);
                    i += -1;
                } else {
                    if (!(updates instanceof Collection) || !updates.isEmpty()) {
                        Iterator<T> it = updates.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (observer.getObservingUpdates().contains((UpdateSource) it.next())) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        observer.getOnUpdate().invoke();
                    }
                }
                i++;
            } catch (Throwable th) {
                try {
                    if (this.logLevel.compareTo(LogLevel.ERROR) < 0) {
                        throw th;
                    }
                    logNotifyError(th, updates);
                    str = "notify END";
                } catch (Throwable th2) {
                    logBreadcrumb("notify END");
                    throw th2;
                }
            }
        }
        str = "notify END";
        logBreadcrumb(str);
    }

    public static /* synthetic */ Observer connect$default(ObservationDeck observationDeck, Observer observer, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return observationDeck.connect(observer, z2);
    }

    public /* synthetic */ ObservationDeck(Logger logger, LogLevel logLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AppLog.f14950g : logger, (i & 2) != 0 ? LogLevel.NONE : logLevel);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, UpdateSource[] updateSourceArr, boolean z2, Emitter.BackpressureMode backpressureMode, String str, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 2) != 0 ? true : z2;
        if ((i & 4) != 0) {
            backpressureMode = Emitter.BackpressureMode.LATEST;
        }
        Emitter.BackpressureMode backpressureMode2 = backpressureMode;
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(updateSourceArr, z3, backpressureMode2, str, function0);
    }

    public final synchronized Observer connect(Observer observer, boolean updateOnConnect) {
        C12238m.checkNotNullParameter(observer, "observer");
        logBreadcrumb("connect START. observer: " + observer.getName());
        this.observers.add(observer);
        if (updateOnConnect) {
            observer.getOnUpdate().invoke();
        }
        logBreadcrumb("connect END. observer: " + observer.getName() + " -- isStale: " + observer.getIsStale());
        return observer;
    }

    public final synchronized <T> Observable<T> connectRx(UpdateSource[] updateSources, boolean updateOnConnect, Emitter.BackpressureMode backpressureMode, String observerName, final Function0<? extends T> generator) {
        Observable<T> observable;
        C12238m.checkNotNullParameter(updateSources, "updateSources");
        C12238m.checkNotNullParameter(backpressureMode, "backpressureMode");
        C12238m.checkNotNullParameter(generator, "generator");
        observable = (Observable<T>) connectRx((UpdateSource[]) Arrays.copyOf(updateSources, updateSources.length), updateOnConnect, backpressureMode, observerName).m11083G(new InterfaceC12589b<Unit, T>() { // from class: com.discord.stores.updates.ObservationDeck.connectRx.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Unit unit) {
                return (T) generator.invoke();
            }
        });
        C12238m.checkNotNullExpressionValue(observable, "connectRx(\n        *upda…    ).map { generator() }");
        return observable;
    }
}
