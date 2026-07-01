package com.discord.utilities.persister;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeElapsed;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Preloader {
    private final List<String> preloadCacheKeys;
    private final SerializedSubject<Persister<?>, Persister<?>> preloadSubject;
    private final TimeElapsed preloadTime;

    public Persister$Preloader(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        this.preloadTime = new TimeElapsed(clock, 0L, 2, null);
        SerializedSubject<Persister<?>, Persister<?>> serializedSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.preloadSubject = serializedSubject;
        this.preloadCacheKeys = n.mutableListOf("STORE_USER_RELATIONSHIPS_V9", "STORE_CHANNELS_V26", "STORE_GUILDS_V34");
        Observable<Persister<?>> observableB0 = serializedSubject.b0(Persister$Preloader$1.INSTANCE);
        m.checkNotNullExpressionValue(observableB0, "preloadSubject\n          .takeUntil { it == null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableB0), Persister$Preloader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new Persister$Preloader$2(this), 62, (Object) null);
    }

    public static final /* synthetic */ void access$handlePreload(Persister$Preloader persister$Preloader, Persister persister) {
        persister$Preloader.handlePreload(persister);
    }

    private final synchronized <T> void handlePreload(Persister<T> persister) {
        if (this.preloadCacheKeys.contains(persister.getKey())) {
            this.preloadCacheKeys.remove(persister.getKey());
            persister.get();
        }
        if (this.preloadCacheKeys.isEmpty()) {
            this.preloadSubject.k.onNext(null);
            Persister.Companion.getLogger().invoke(4, "Preloaded preferences in " + this.preloadTime.getSeconds() + " seconds.", null);
        }
    }

    public final Observable<Boolean> isPreloaded() {
        Observable<Boolean> observableR = this.preloadSubject.G(Persister$Preloader$isPreloaded$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "preloadSubject\n         …  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized <T> void preload(Persister<T> preference) {
        m.checkNotNullParameter(preference, "preference");
        if (this.preloadCacheKeys.contains(preference.getKey())) {
            this.preloadSubject.k.onNext(preference);
        }
    }
}
