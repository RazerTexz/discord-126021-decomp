package com.discord.utilities.persister;

import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.esotericsoftware.kryo.Kryo;
import d0.z.d.m;
import j0.l.e.k;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Companion {
    private Persister$Companion() {
    }

    public static final /* synthetic */ long access$availableBytes(Persister$Companion persister$Companion) {
        return persister$Companion.availableBytes();
    }

    public static final /* synthetic */ void access$persistAll(Persister$Companion persister$Companion) {
        persister$Companion.persistAll();
    }

    private final long availableBytes() {
        Context contextAccess$getContext$cp = Persister.access$getContext$cp();
        if (contextAccess$getContext$cp == null) {
            m.throwUninitializedPropertyAccessException("context");
        }
        Object systemService = contextAccess$getContext$cp.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager == null) {
            return RecyclerView.FOREVER_NS;
        }
        ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
        activityManager.getMemoryInfo(activityManager$MemoryInfo);
        return activityManager$MemoryInfo.availMem;
    }

    private final void persistAll() {
        Iterator it = Persister.access$getPreferences$cp().iterator();
        while (it.hasNext()) {
            k kVar = new k(((WeakReference) it.next()).get());
            m.checkNotNullExpressionValue(kVar, "Observable\n          .just(weakPreference.get())");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(kVar), Persister.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, Persister$Companion$persistAll$1$1.INSTANCE, 62, (Object) null);
        }
    }

    public final Function1<Kryo, Unit> getKryoConfig() {
        return Persister.access$getKryoConfig$cp();
    }

    public final Function3<Integer, String, Exception, Unit> getLogger() {
        return Persister.access$getLogger$cp();
    }

    public final void init(Context context, Clock clock, Observable<Boolean> persistenceStrategy) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(persistenceStrategy, "persistenceStrategy");
        if (Persister.access$getInitialized$cp()) {
            return;
        }
        Persister.access$setInitialized$cp(true);
        Persister.access$setContext$cp(context);
        Persister.access$setClock$cp(clock);
        Persister.access$setPreferencesPreloader$cp(new Persister$Preloader(clock));
        Observable<Boolean> observableY = persistenceStrategy.y(Persister$Companion$init$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "persistenceStrategy\n    …er { persist -> persist }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableY), Persister.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, Persister$Companion$init$2.INSTANCE, 62, (Object) null);
    }

    public final Observable<Boolean> isPreloaded() {
        Persister$Preloader persister$PreloaderAccess$getPreferencesPreloader$cp = Persister.access$getPreferencesPreloader$cp();
        if (persister$PreloaderAccess$getPreferencesPreloader$cp == null) {
            m.throwUninitializedPropertyAccessException("preferencesPreloader");
        }
        return persister$PreloaderAccess$getPreferencesPreloader$cp.isPreloaded();
    }

    public final void reset() {
        Iterator it = Persister.access$getPreferences$cp().iterator();
        while (it.hasNext()) {
            Persister persister = (Persister) ((WeakReference) it.next()).get();
            if (persister != null) {
                Persister.clear$default(persister, false, 1, null);
            }
        }
    }

    public final void setKryoConfig(Function1<? super Kryo, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        Persister.access$setKryoConfig$cp(function1);
    }

    public final void setLogger(Function3<? super Integer, ? super String, ? super Exception, Unit> function3) {
        m.checkNotNullParameter(function3, "<set-?>");
        Persister.access$setLogger$cp(function3);
    }

    public /* synthetic */ Persister$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
