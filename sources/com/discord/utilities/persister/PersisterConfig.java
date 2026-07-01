package com.discord.utilities.persister;

import android.content.Context;
import b.a.d.AppLog2;
import b.a.d.AppState;
import b.a.d.AppState2;
import b.a.e.Backgrounded4;
import com.discord.app.AppLog;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.kryo.LeastRecentlyAddedSetSerializer;
import com.discord.utilities.kryo.SnowflakePartitionMapSerializer;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import h0.b.b.StdInstantiatorStrategy;
import j0.k.Func1;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: PersisterConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PersisterConfig {
    public static final PersisterConfig INSTANCE = new PersisterConfig();

    /* JADX INFO: renamed from: com.discord.utilities.persister.PersisterConfig$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersisterConfig.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Kryo, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
            invoke2(kryo);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Kryo kryo) {
            Intrinsics3.checkNotNullParameter(kryo, "it");
            kryo.setInstantiatorStrategy(new Kryo.DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));
            FieldSerializerConfig fieldSerializerConfig = kryo.getFieldSerializerConfig();
            Intrinsics3.checkNotNullExpressionValue(fieldSerializerConfig, "it.fieldSerializerConfig");
            fieldSerializerConfig.setOptimizedGenerics(true);
            kryo.register(LeastRecentlyAddedSet.class, new LeastRecentlyAddedSetSerializer());
            kryo.register(SnowflakePartitionMap.class, new SnowflakePartitionMapSerializer());
        }
    }

    private PersisterConfig() {
    }

    private final Observable<Boolean> getPersistenceStrategy() {
        Observable<Boolean> observableI = Observable.I(isNotActive(), Observable.d0(1L, TimeUnit.MINUTES).G(new Func1<Long, Boolean>() { // from class: com.discord.utilities.persister.PersisterConfig$persistenceStrategy$1
            @Override // j0.k.Func1
            public final Boolean call(Long l) {
                return Boolean.TRUE;
            }
        }));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .merg…  .map { true }\n        )");
        return observableI;
    }

    private final Observable<Boolean> isNotActive() {
        Observable<Boolean> observableS = Backgrounded4.d.a().S(1);
        AppState2 appState2 = AppState2.c;
        Observable observableR = AppState2.f59b.G(AppState.j).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "numGatewayConnectionCons…  .distinctUntilChanged()");
        return Observable.j(observableS, observableR, new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.utilities.persister.PersisterConfig.isNotActive.1
            @Override // rx.functions.Func2
            public final Boolean call(Boolean bool, Boolean bool2) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isBackgrounded");
                return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
            }
        }).r();
    }

    public final void init(Context context, Clock clock) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Persister.Companion companion = Persister.INSTANCE;
        companion.setKryoConfig(AnonymousClass1.INSTANCE);
        Objects.requireNonNull(AppLog.g);
        Intrinsics3.checkNotNullParameter("[Persister]", "tag");
        companion.setLogger(new AppLog2("[Persister]"));
        companion.init(context, clock, getPersistenceStrategy());
    }
}
