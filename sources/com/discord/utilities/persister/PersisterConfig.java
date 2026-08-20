package com.discord.utilities.persister;

import android.content.Context;
import com.discord.app.AppLog;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.kryo.LeastRecentlyAddedSetSerializer;
import com.discord.utilities.kryo.SnowflakePartitionMapSerializer;
import com.discord.utilities.time.Clock;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0864g;
import p007b.p008a.p018d.C0872k;
import p007b.p008a.p018d.C0874l;
import p007b.p008a.p020e.C0894d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p617h0.p620b.p627b.C12449c;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: PersisterConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PersisterConfig {
    public static final PersisterConfig INSTANCE = new PersisterConfig();

    /* JADX INFO: renamed from: com.discord.utilities.persister.PersisterConfig$init$1 */
    /* JADX INFO: compiled from: PersisterConfig.kt */
    public static final class C68331 extends AbstractC12240o implements Function1<Kryo, Unit> {
        public static final C68331 INSTANCE = new C68331();

        public C68331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
            invoke2(kryo);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Kryo kryo) {
            C12238m.checkNotNullParameter(kryo, "it");
            kryo.setInstantiatorStrategy(new Kryo.DefaultInstantiatorStrategy(new C12449c()));
            FieldSerializerConfig fieldSerializerConfig = kryo.getFieldSerializerConfig();
            C12238m.checkNotNullExpressionValue(fieldSerializerConfig, "it.fieldSerializerConfig");
            fieldSerializerConfig.setOptimizedGenerics(true);
            kryo.register(LeastRecentlyAddedSet.class, new LeastRecentlyAddedSetSerializer());
            kryo.register(SnowflakePartitionMap.class, new SnowflakePartitionMapSerializer());
        }
    }

    private PersisterConfig() {
    }

    private final Observable<Boolean> getPersistenceStrategy() {
        Observable<Boolean> observableM11064I = Observable.m11064I(isNotActive(), Observable.m11068d0(1L, TimeUnit.MINUTES).m11083G(new InterfaceC12589b<Long, Boolean>() { // from class: com.discord.utilities.persister.PersisterConfig$persistenceStrategy$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Long l) {
                return Boolean.TRUE;
            }
        }));
        C12238m.checkNotNullExpressionValue(observableM11064I, "Observable\n        .merg…  .map { true }\n        )");
        return observableM11064I;
    }

    private final Observable<Boolean> isNotActive() {
        Observable<Boolean> observableM11093S = C0894d.f600d.m185a().m11093S(1);
        C0874l c0874l = C0874l.f530c;
        Observable observableM11112r = C0874l.f529b.m11083G(C0872k.f526j).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "numGatewayConnectionCons…  .distinctUntilChanged()");
        return Observable.m11076j(observableM11093S, observableM11112r, new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.utilities.persister.PersisterConfig.isNotActive.1
            @Override // p658rx.functions.Func2
            public final Boolean call(Boolean bool, Boolean bool2) {
                C12238m.checkNotNullExpressionValue(bool, "isBackgrounded");
                return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
            }
        }).m11112r();
    }

    public final void init(Context context, Clock clock) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(clock, "clock");
        Persister.Companion companion = Persister.INSTANCE;
        companion.setKryoConfig(C68331.INSTANCE);
        Objects.requireNonNull(AppLog.f14950g);
        C12238m.checkNotNullParameter("[Persister]", "tag");
        companion.setLogger(new C0864g("[Persister]"));
        companion.init(context, clock, getPersistenceStrategy());
    }
}
