package com.discord.utilities.persister;

import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.kryo.LeastRecentlyAddedSetSerializer;
import com.discord.utilities.kryo.SnowflakePartitionMapSerializer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Kryo$DefaultInstantiatorStrategy;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import d0.z.d.m;
import d0.z.d.o;
import h0.b.b.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PersisterConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PersisterConfig$init$1 extends o implements Function1<Kryo, Unit> {
    public static final PersisterConfig$init$1 INSTANCE = new PersisterConfig$init$1();

    public PersisterConfig$init$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
        invoke2(kryo);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Kryo kryo) {
        m.checkNotNullParameter(kryo, "it");
        kryo.setInstantiatorStrategy(new Kryo$DefaultInstantiatorStrategy(new c()));
        FieldSerializerConfig fieldSerializerConfig = kryo.getFieldSerializerConfig();
        m.checkNotNullExpressionValue(fieldSerializerConfig, "it.fieldSerializerConfig");
        fieldSerializerConfig.setOptimizedGenerics(true);
        kryo.register(LeastRecentlyAddedSet.class, new LeastRecentlyAddedSetSerializer());
        kryo.register(SnowflakePartitionMap.class, new SnowflakePartitionMapSerializer());
    }
}
