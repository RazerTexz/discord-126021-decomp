package com.discord.stores.updates;

import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.o;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter$BackpressureMode;
import rx.Observable;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck {
    private static final String LOG_CATEGORY = "ObservationDeck";
    private final ObservationDeck$LogLevel logLevel;
    private final Logger logger;
    private List<ObservationDeck$Observer> observers;
    public static final ObservationDeck$Companion Companion = new ObservationDeck$Companion(null);
    private static final Function0<Unit> ON_UPDATE_EMPTY = ObservationDeck$Companion$ON_UPDATE_EMPTY$1.INSTANCE;

    public ObservationDeck() {
        this(null, null, 3, null);
    }

    public ObservationDeck(Logger logger, ObservationDeck$LogLevel observationDeck$LogLevel) {
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(observationDeck$LogLevel, "logLevel");
        this.logger = logger;
        this.logLevel = observationDeck$LogLevel;
        this.observers = new ArrayList();
    }

    public static final /* synthetic */ Function0 access$getON_UPDATE_EMPTY$cp() {
        return ON_UPDATE_EMPTY;
    }

    public static /* synthetic */ ObservationDeck$Observer connect$default(ObservationDeck observationDeck, ObservationDeck$UpdateSource[] observationDeck$UpdateSourceArr, boolean z2, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return observationDeck.connect(observationDeck$UpdateSourceArr, z2, str, function0);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, ObservationDeck$UpdateSource[] observationDeck$UpdateSourceArr, boolean z2, Emitter$BackpressureMode emitter$BackpressureMode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            emitter$BackpressureMode = Emitter$BackpressureMode.LATEST;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(observationDeck$UpdateSourceArr, z2, emitter$BackpressureMode, str);
    }

    private final void logBreadcrumb(String message) {
        if (this.logLevel == ObservationDeck$LogLevel.VERBOSE) {
            this.logger.recordBreadcrumb(message, LOG_CATEGORY);
        }
    }

    private final void logNotifyError(Throwable throwable, Set<? extends ObservationDeck$UpdateSource> updates) {
        Logger logger = this.logger;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = o.to("Update Sources", u.joinToString$default(updates, ", ", null, null, 0, null, null, 62, null));
        List<ObservationDeck$Observer> list = this.observers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                pairArr[1] = o.to("Observers", u.joinToString$default(arrayList, "\n", null, null, 0, null, ObservationDeck$logNotifyError$2.INSTANCE, 30, null));
                logger.e("ObservationDeck notify error", throwable, h0.mapOf(pairArr));
                return;
            }
            Object next = it.next();
            ObservationDeck$Observer observationDeck$Observer = (ObservationDeck$Observer) next;
            if (!(updates instanceof Collection) || !updates.isEmpty()) {
                Iterator<T> it2 = updates.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                } while (!observationDeck$Observer.getObservingUpdates().contains((ObservationDeck$UpdateSource) it2.next()));
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    public final synchronized ObservationDeck$Observer connect(ObservationDeck$UpdateSource[] updateSources, boolean updateOnConnect, String observerName, Function0<Unit> onUpdate) {
        ObservationDeck$connect$observer$1 observationDeck$connect$observer$1;
        m.checkNotNullParameter(updateSources, "updateSources");
        m.checkNotNullParameter(onUpdate, "onUpdate");
        observationDeck$connect$observer$1 = new ObservationDeck$connect$observer$1(updateSources, onUpdate, observerName);
        connect(observationDeck$connect$observer$1, updateOnConnect);
        return observationDeck$connect$observer$1;
    }

    public final synchronized Observable<Unit> connectRx(ObservationDeck$UpdateSource[] updateSources, boolean updateOnConnect, Emitter$BackpressureMode backpressureMode, String observerName) {
        Observable<Unit> observableW;
        m.checkNotNullParameter(updateSources, "updateSources");
        m.checkNotNullParameter(backpressureMode, "backpressureMode");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        observableW = Observable.o(new ObservationDeck$connectRx$1(this, ref$ObjectRef, updateOnConnect, observerName, updateSources), backpressureMode).w(new ObservationDeck$connectRx$2(this, ref$ObjectRef));
        m.checkNotNullExpressionValue(observableW, "Observable.create<Unit>(…rver?.let(::disconnect) }");
        return observableW;
    }

    public final synchronized void disconnect(ObservationDeck$Observer observer) {
        m.checkNotNullParameter(observer, "observer");
        logBreadcrumb("disconnect START. observer: " + observer.getName());
        observer.markStale();
        logBreadcrumb("disconnect END. observer: " + observer.getName());
    }

    public final synchronized void notify(Set<? extends ObservationDeck$UpdateSource> updates) {
        String str;
        boolean z2;
        m.checkNotNullParameter(updates, "updates");
        logBreadcrumb("notify START");
        int i = 0;
        while (i < this.observers.size()) {
            try {
                ObservationDeck$Observer observationDeck$Observer = this.observers.get(i);
                if (observationDeck$Observer.getIsStale()) {
                    logBreadcrumb("removing observer: " + observationDeck$Observer.getName());
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
                            if (observationDeck$Observer.getObservingUpdates().contains((ObservationDeck$UpdateSource) it.next())) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        observationDeck$Observer.getOnUpdate().invoke();
                    }
                }
                i++;
            } catch (Throwable th) {
                try {
                    if (this.logLevel.compareTo(ObservationDeck$LogLevel.ERROR) < 0) {
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

    public static /* synthetic */ ObservationDeck$Observer connect$default(ObservationDeck observationDeck, ObservationDeck$Observer observationDeck$Observer, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return observationDeck.connect(observationDeck$Observer, z2);
    }

    public /* synthetic */ ObservationDeck(Logger logger, ObservationDeck$LogLevel observationDeck$LogLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AppLog.g : logger, (i & 2) != 0 ? ObservationDeck$LogLevel.NONE : observationDeck$LogLevel);
    }

    public static /* synthetic */ Observable connectRx$default(ObservationDeck observationDeck, ObservationDeck$UpdateSource[] observationDeck$UpdateSourceArr, boolean z2, Emitter$BackpressureMode emitter$BackpressureMode, String str, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 2) != 0 ? true : z2;
        if ((i & 4) != 0) {
            emitter$BackpressureMode = Emitter$BackpressureMode.LATEST;
        }
        Emitter$BackpressureMode emitter$BackpressureMode2 = emitter$BackpressureMode;
        if ((i & 8) != 0) {
            str = null;
        }
        return observationDeck.connectRx(observationDeck$UpdateSourceArr, z3, emitter$BackpressureMode2, str, function0);
    }

    public final synchronized ObservationDeck$Observer connect(ObservationDeck$Observer observer, boolean updateOnConnect) {
        m.checkNotNullParameter(observer, "observer");
        logBreadcrumb("connect START. observer: " + observer.getName());
        this.observers.add(observer);
        if (updateOnConnect) {
            observer.getOnUpdate().invoke();
        }
        logBreadcrumb("connect END. observer: " + observer.getName() + " -- isStale: " + observer.getIsStale());
        return observer;
    }

    public final synchronized <T> Observable<T> connectRx(ObservationDeck$UpdateSource[] updateSources, boolean updateOnConnect, Emitter$BackpressureMode backpressureMode, String observerName, Function0<? extends T> generator) {
        Observable<T> observable;
        m.checkNotNullParameter(updateSources, "updateSources");
        m.checkNotNullParameter(backpressureMode, "backpressureMode");
        m.checkNotNullParameter(generator, "generator");
        observable = (Observable<T>) connectRx((ObservationDeck$UpdateSource[]) Arrays.copyOf(updateSources, updateSources.length), updateOnConnect, backpressureMode, observerName).G(new ObservationDeck$connectRx$3(generator));
        m.checkNotNullExpressionValue(observable, "connectRx(\n        *upda…    ).map { generator() }");
        return observable;
    }
}
