package com.discord.utilities.persister;

import android.content.Context;
import b.a.d.g;
import b.a.d.k;
import b.a.d.l;
import b.a.e.d;
import com.discord.app.AppLog;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: PersisterConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PersisterConfig {
    public static final PersisterConfig INSTANCE = new PersisterConfig();

    private PersisterConfig() {
    }

    private final Observable<Boolean> getPersistenceStrategy() {
        Observable<Boolean> observableI = Observable.I(isNotActive(), Observable.d0(1L, TimeUnit.MINUTES).G(PersisterConfig$persistenceStrategy$1.INSTANCE));
        m.checkNotNullExpressionValue(observableI, "Observable\n        .merg…  .map { true }\n        )");
        return observableI;
    }

    private final Observable<Boolean> isNotActive() {
        Observable<Boolean> observableS = d.d.a().S(1);
        l lVar = l.c;
        Observable observableR = l.f59b.G(k.j).r();
        m.checkNotNullExpressionValue(observableR, "numGatewayConnectionCons…  .distinctUntilChanged()");
        return Observable.j(observableS, observableR, PersisterConfig$isNotActive$1.INSTANCE).r();
    }

    public final void init(Context context, Clock clock) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(clock, "clock");
        Persister$Companion persister$Companion = Persister.Companion;
        persister$Companion.setKryoConfig(PersisterConfig$init$1.INSTANCE);
        Objects.requireNonNull(AppLog.g);
        m.checkNotNullParameter("[Persister]", "tag");
        persister$Companion.setLogger(new g("[Persister]"));
        persister$Companion.init(context, clock, getPersistenceStrategy());
    }
}
