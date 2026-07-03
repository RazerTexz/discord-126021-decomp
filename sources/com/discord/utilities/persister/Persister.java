package com.discord.utilities.persister;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister<T> {
    private static Clock clock;

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;
    private static boolean initialized;
    private static Preloader preferencesPreloader;
    private final T defaultValue;
    private final String key;
    private T value;
    private boolean valueDirty;
    private Subject<T, T> valueSubject;
    private boolean valueUnset;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function3<? super Integer, ? super String, ? super Exception, Unit> logger = Persister$Companion$logger$1.INSTANCE;
    private static Function1<? super Kryo, Unit> kryoConfig = Persister$Companion$kryoConfig$1.INSTANCE;
    private static final Persister$Companion$kryos$1 kryos = new ThreadLocal<Kryo>() { // from class: com.discord.utilities.persister.Persister$Companion$kryos$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Kryo initialValue() {
            Kryo kryo = new Kryo();
            Persister.INSTANCE.getKryoConfig().invoke(kryo);
            return kryo;
        }
    };
    private static final List<WeakReference<Persister<?>>> preferences = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: Persister.kt */
    public static final class Companion {
        private Companion() {
        }

        private final long availableBytes() {
            Context context = Persister.context;
            if (context == null) {
                C12238m.throwUninitializedPropertyAccessException("context");
            }
            Object systemService = context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            ActivityManager activityManager = (ActivityManager) systemService;
            if (activityManager == null) {
                return RecyclerView.FOREVER_NS;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        }

        private final void persistAll() {
            Iterator<T> it = Persister.preferences.iterator();
            while (it.hasNext()) {
                C12721k c12721k = new C12721k(((WeakReference) it.next()).get());
                C12238m.checkNotNullExpressionValue(c12721k, "Observable\n          .just(weakPreference.get())");
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(c12721k), (Class<?>) Persister.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), Persister$Companion$persistAll$1$1.INSTANCE);
            }
        }

        public final Function1<Kryo, Unit> getKryoConfig() {
            return Persister.kryoConfig;
        }

        public final Function3<Integer, String, Exception, Unit> getLogger() {
            return Persister.logger;
        }

        public final void init(Context context, Clock clock, Observable<Boolean> persistenceStrategy) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(clock, "clock");
            C12238m.checkNotNullParameter(persistenceStrategy, "persistenceStrategy");
            if (Persister.initialized) {
                return;
            }
            Persister.initialized = true;
            Persister.context = context;
            Persister.clock = clock;
            Persister.preferencesPreloader = new Preloader(clock);
            Observable<Boolean> observableM11118y = persistenceStrategy.m11118y(new InterfaceC12589b<Boolean, Boolean>() { // from class: com.discord.utilities.persister.Persister$Companion$init$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(Boolean bool) {
                    return bool;
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11118y, "persistenceStrategy\n    …er { persist -> persist }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(observableM11118y), (Class<?>) Persister.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), Persister$Companion$init$2.INSTANCE);
        }

        public final Observable<Boolean> isPreloaded() {
            Preloader preloader = Persister.preferencesPreloader;
            if (preloader == null) {
                C12238m.throwUninitializedPropertyAccessException("preferencesPreloader");
            }
            return preloader.isPreloaded();
        }

        public final void reset() {
            Iterator<T> it = Persister.preferences.iterator();
            while (it.hasNext()) {
                Persister persister = (Persister) ((WeakReference) it.next()).get();
                if (persister != null) {
                    Persister.clear$default(persister, false, 1, null);
                }
            }
        }

        public final void setKryoConfig(Function1<? super Kryo, Unit> function1) {
            C12238m.checkNotNullParameter(function1, "<set-?>");
            Persister.kryoConfig = function1;
        }

        public final void setLogger(Function3<? super Integer, ? super String, ? super Exception, Unit> function3) {
            C12238m.checkNotNullParameter(function3, "<set-?>");
            Persister.logger = function3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: Persister.kt */
    public static final class Preloader {
        private final List<String> preloadCacheKeys;
        private final SerializedSubject<Persister<?>, Persister<?>> preloadSubject;
        private final TimeElapsed preloadTime;

        /* JADX INFO: renamed from: com.discord.utilities.persister.Persister$Preloader$2 */
        /* JADX INFO: compiled from: Persister.kt */
        public static final class C68312 extends AbstractC12240o implements Function1<Persister<?>, Unit> {
            public C68312() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
                invoke2(persister);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Persister<?> persister) {
                if (persister != null) {
                    Preloader.this.handlePreload(persister);
                }
            }
        }

        public Preloader(Clock clock) {
            C12238m.checkNotNullParameter(clock, "clock");
            this.preloadTime = new TimeElapsed(clock, 0L, 2, null);
            SerializedSubject<Persister<?>, Persister<?>> serializedSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
            this.preloadSubject = serializedSubject;
            this.preloadCacheKeys = C12147n.mutableListOf("STORE_USER_RELATIONSHIPS_V9", "STORE_CHANNELS_V26", "STORE_GUILDS_V34");
            Observable<Persister<?>> observableM11103b0 = serializedSubject.m11103b0(new InterfaceC12589b<Persister<?>, Boolean>() { // from class: com.discord.utilities.persister.Persister.Preloader.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(Persister<?> persister) {
                    return Boolean.valueOf(persister == null);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11103b0, "preloadSubject\n          .takeUntil { it == null }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(observableM11103b0), (Class<?>) Preloader.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C68312());
        }

        private final synchronized <T> void handlePreload(Persister<T> persister) {
            if (this.preloadCacheKeys.contains(persister.getKey())) {
                this.preloadCacheKeys.remove(persister.getKey());
                persister.get();
            }
            if (this.preloadCacheKeys.isEmpty()) {
                this.preloadSubject.f27653k.onNext(null);
                Persister.INSTANCE.getLogger().invoke(4, "Preloaded preferences in " + this.preloadTime.getSeconds() + " seconds.", null);
            }
        }

        public final Observable<Boolean> isPreloaded() {
            Observable<Boolean> observableM11112r = this.preloadSubject.m11083G(new InterfaceC12589b<Persister<?>, Boolean>() { // from class: com.discord.utilities.persister.Persister$Preloader$isPreloaded$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(Persister<?> persister) {
                    return Boolean.valueOf(persister == null);
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "preloadSubject\n         …  .distinctUntilChanged()");
            return observableM11112r;
        }

        public final synchronized <T> void preload(Persister<T> preference) {
            C12238m.checkNotNullParameter(preference, "preference");
            if (this.preloadCacheKeys.contains(preference.getKey())) {
                this.preloadSubject.f27653k.onNext(preference);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.persister.Persister$getObservable$1 */
    /* JADX INFO: compiled from: Persister.kt */
    public static final class C68321 extends AbstractC12240o implements Function0<Subject<T, T>> {

        /* JADX INFO: renamed from: com.discord.utilities.persister.Persister$getObservable$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: Persister.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1 {
            public final /* synthetic */ SerializedSubject $subject;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SerializedSubject serializedSubject) {
                super(1);
                this.$subject = serializedSubject;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.f27425a;
            }

            public final void invoke(Void r2) {
                this.$subject.f27653k.onNext((T) Persister.this.get());
            }
        }

        public C68321() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Subject<T, T> invoke() {
            SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.m11129k0());
            C12721k c12721k = new C12721k(null);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable\n          .just(null)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(c12721k), (Class<?>) Persister.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1(serializedSubject));
            return serializedSubject;
        }
    }

    public Persister(String str, T t) {
        C12238m.checkNotNullParameter(str, "key");
        C12238m.checkNotNullParameter(t, "defaultValue");
        this.key = str;
        this.defaultValue = t;
        this.value = t;
        this.valueUnset = true;
        preferences.add(new WeakReference<>(this));
        Preloader preloader = preferencesPreloader;
        if (preloader == null) {
            C12238m.throwUninitializedPropertyAccessException("preferencesPreloader");
        }
        preloader.preload(this);
    }

    public static /* synthetic */ Object clear$default(Persister persister, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return persister.clear(z2);
    }

    public static /* synthetic */ Object getAndSet$default(Persister persister, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return persister.getAndSet(z2, function1);
    }

    private final File getFileInput() {
        StringBuilder sb = new StringBuilder();
        Context context2 = context;
        if (context2 == null) {
            C12238m.throwUninitializedPropertyAccessException("context");
        }
        sb.append(context2.getFilesDir());
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(this.key);
        return new File(sb.toString());
    }

    private final Input getFileInputStream() {
        File fileInput = getFileInput();
        if (!fileInput.exists() || fileInput.length() >= INSTANCE.availableBytes()) {
            return null;
        }
        return new Input(new FileInputStream(fileInput));
    }

    private final FileOutputStream getFileOutput() throws FileNotFoundException {
        Context context2 = context;
        if (context2 == null) {
            C12238m.throwUninitializedPropertyAccessException("context");
        }
        FileOutputStream fileOutputStreamOpenFileOutput = context2.openFileOutput(this.key, 0);
        C12238m.checkNotNullExpressionValue(fileOutputStreamOpenFileOutput, "context.openFileOutput(key, Context.MODE_PRIVATE)");
        return fileOutputStreamOpenFileOutput;
    }

    private final T getFileValue() {
        T t;
        try {
            Input fileInputStream = getFileInputStream();
            if (fileInputStream != null) {
                try {
                    Kryo kryo = kryos.get();
                    if (kryo != null) {
                        Object classAndObject = kryo.readClassAndObject(fileInputStream);
                        t = !(classAndObject instanceof Object) ? (T) null : classAndObject;
                        if (t == null) {
                            t = this.value;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Found " + classAndObject.getClass() + " for " + this.key + ", ");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("but expecting ");
                            sb2.append(t.getClass());
                            sb2.append('\"');
                            sb.append(sb2.toString());
                            String string = sb.toString();
                            C12238m.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                            logger.invoke(6, "Unable to cast deserialized preference " + this.key + '.', new Exception(string));
                        }
                    } else {
                        t = this.value;
                    }
                    C12201b.closeFinally(fileInputStream, null);
                    if (t != null) {
                        return (T) t;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        C12201b.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            }
            return this.value;
        } catch (Exception e) {
            logger.invoke(5, C1643a.m820H(C1643a.m833U("Unable to deserialize preference "), this.key, '.'), new Exception(this.key, e));
            return this.value;
        }
    }

    private static /* synthetic */ void getFileValue$annotations() {
    }

    public static final Observable<Boolean> isPreloaded() {
        return INSTANCE.isPreloaded();
    }

    private final synchronized void persist() {
        if (this.valueDirty) {
            this.valueDirty = false;
            try {
                Output output = new Output(getFileOutput());
                try {
                    Kryo kryo = kryos.get();
                    if (kryo != null) {
                        kryo.writeClassAndObject(output, this.value);
                    }
                    C12201b.closeFinally(output, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        C12201b.closeFinally(output, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                logger.invoke(5, "Unable to serialize preference " + this.key + '.', new Exception(this.key, e));
            }
        }
    }

    public static final void reset() {
        INSTANCE.reset();
    }

    public static /* synthetic */ Object set$default(Persister persister, Object obj, boolean z2, int i, Object obj2) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return persister.set(obj, z2);
    }

    public final T clear() {
        return (T) clear$default(this, false, 1, null);
    }

    public final T clear(boolean persist) {
        return set(this.defaultValue, persist);
    }

    public final synchronized T get() {
        if (this.valueUnset) {
            this.valueUnset = false;
            this.value = getFileValue();
        }
        return this.value;
    }

    public final T getAndSet(Function1<? super T, ? extends T> function1) {
        return (T) getAndSet$default(this, false, function1, 1, null);
    }

    public final synchronized T getAndSet(boolean persist, Function1<? super T, ? extends T> setter) {
        C12238m.checkNotNullParameter(setter, "setter");
        return set(setter.invoke(get()), persist);
    }

    public final String getKey() {
        return this.key;
    }

    public final synchronized Observable<T> getObservable() {
        Subject<T, T> subjectInvoke;
        C68321 c68321 = new C68321();
        subjectInvoke = this.valueSubject;
        if (subjectInvoke == null) {
            subjectInvoke = c68321.invoke();
            this.valueSubject = subjectInvoke;
        }
        return subjectInvoke;
    }

    public final T set(T t) {
        return (T) set$default(this, t, false, 2, null);
    }

    public final synchronized T set(T newValue, boolean persist) {
        T t;
        C12238m.checkNotNullParameter(newValue, "newValue");
        this.valueDirty = true;
        this.valueUnset = false;
        t = this.value;
        this.value = newValue;
        Subject<T, T> subject = this.valueSubject;
        if (subject != null) {
            subject.onNext(newValue);
        }
        if (persist) {
            persist();
        }
        return t;
    }
}
