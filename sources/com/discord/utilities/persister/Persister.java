package com.discord.utilities.persister;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.y.b;
import d0.z.d.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import rx.Observable;
import rx.subjects.Subject;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister<T> {
    private static Clock clock;

    @SuppressLint({"StaticFieldLeak"})
    private static Context context;
    private static boolean initialized;
    private static Persister$Preloader preferencesPreloader;
    private final T defaultValue;
    private final String key;
    private T value;
    private boolean valueDirty;
    private Subject<T, T> valueSubject;
    private boolean valueUnset;
    public static final Persister$Companion Companion = new Persister$Companion(null);
    private static Function3<? super Integer, ? super String, ? super Exception, Unit> logger = Persister$Companion$logger$1.INSTANCE;
    private static Function1<? super Kryo, Unit> kryoConfig = Persister$Companion$kryoConfig$1.INSTANCE;
    private static final Persister$Companion$kryos$1 kryos = new Persister$Companion$kryos$1();
    private static final List<WeakReference<Persister<?>>> preferences = new CopyOnWriteArrayList();

    public Persister(String str, T t) {
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(t, "defaultValue");
        this.key = str;
        this.defaultValue = t;
        this.value = t;
        this.valueUnset = true;
        preferences.add(new WeakReference<>(this));
        Persister$Preloader persister$Preloader = preferencesPreloader;
        if (persister$Preloader == null) {
            m.throwUninitializedPropertyAccessException("preferencesPreloader");
        }
        persister$Preloader.preload(this);
    }

    public static final /* synthetic */ Clock access$getClock$cp() {
        return clock;
    }

    public static final /* synthetic */ Context access$getContext$cp() {
        return context;
    }

    public static final /* synthetic */ boolean access$getInitialized$cp() {
        return initialized;
    }

    public static final /* synthetic */ Function1 access$getKryoConfig$cp() {
        return kryoConfig;
    }

    public static final /* synthetic */ Function3 access$getLogger$cp() {
        return logger;
    }

    public static final /* synthetic */ List access$getPreferences$cp() {
        return preferences;
    }

    public static final /* synthetic */ Persister$Preloader access$getPreferencesPreloader$cp() {
        return preferencesPreloader;
    }

    public static final /* synthetic */ void access$persist(Persister persister) {
        persister.persist();
    }

    public static final /* synthetic */ void access$setClock$cp(Clock clock2) {
        clock = clock2;
    }

    public static final /* synthetic */ void access$setContext$cp(Context context2) {
        context = context2;
    }

    public static final /* synthetic */ void access$setInitialized$cp(boolean z2) {
        initialized = z2;
    }

    public static final /* synthetic */ void access$setKryoConfig$cp(Function1 function1) {
        kryoConfig = function1;
    }

    public static final /* synthetic */ void access$setLogger$cp(Function3 function3) {
        logger = function3;
    }

    public static final /* synthetic */ void access$setPreferencesPreloader$cp(Persister$Preloader persister$Preloader) {
        preferencesPreloader = persister$Preloader;
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
            m.throwUninitializedPropertyAccessException("context");
        }
        sb.append(context2.getFilesDir());
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(this.key);
        return new File(sb.toString());
    }

    private final Input getFileInputStream() {
        File fileInput = getFileInput();
        if (!fileInput.exists() || fileInput.length() >= Persister$Companion.access$availableBytes(Companion)) {
            return null;
        }
        return new Input(new FileInputStream(fileInput));
    }

    private final FileOutputStream getFileOutput() throws FileNotFoundException {
        Context context2 = context;
        if (context2 == null) {
            m.throwUninitializedPropertyAccessException("context");
        }
        FileOutputStream fileOutputStreamOpenFileOutput = context2.openFileOutput(this.key, 0);
        m.checkNotNullExpressionValue(fileOutputStreamOpenFileOutput, "context.openFileOutput(key, Context.MODE_PRIVATE)");
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
                            m.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                            logger.invoke(6, "Unable to cast deserialized preference " + this.key + '.', new Exception(string));
                        }
                    } else {
                        t = this.value;
                    }
                    b.closeFinally(fileInputStream, null);
                    if (t != null) {
                        return (T) t;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        b.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            }
            return this.value;
        } catch (Exception e) {
            logger.invoke(5, a.H(a.U("Unable to deserialize preference "), this.key, '.'), new Exception(this.key, e));
            return this.value;
        }
    }

    private static /* synthetic */ void getFileValue$annotations() {
    }

    public static final Observable<Boolean> isPreloaded() {
        return Companion.isPreloaded();
    }

    private final synchronized void persist() {
        try {
            if (this.valueDirty) {
                this.valueDirty = false;
                try {
                    Output output = new Output(getFileOutput());
                    try {
                        Kryo kryo = kryos.get();
                        if (kryo != null) {
                            kryo.writeClassAndObject(output, this.value);
                        }
                        b.closeFinally(output, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            b.closeFinally(output, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    logger.invoke(5, "Unable to serialize preference " + this.key + '.', new Exception(this.key, e));
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public static final void reset() {
        Companion.reset();
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
        m.checkNotNullParameter(setter, "setter");
        return set(setter.invoke(get()), persist);
    }

    public final String getKey() {
        return this.key;
    }

    public final synchronized Observable<T> getObservable() {
        Subject<T, T> subjectInvoke;
        Persister$getObservable$1 persister$getObservable$1 = new Persister$getObservable$1(this);
        subjectInvoke = this.valueSubject;
        if (subjectInvoke == null) {
            subjectInvoke = persister$getObservable$1.invoke();
            this.valueSubject = subjectInvoke;
        }
        return subjectInvoke;
    }

    public final T set(T t) {
        return (T) set$default(this, t, false, 2, null);
    }

    public final synchronized T set(T newValue, boolean persist) {
        T t;
        m.checkNotNullParameter(newValue, "newValue");
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
