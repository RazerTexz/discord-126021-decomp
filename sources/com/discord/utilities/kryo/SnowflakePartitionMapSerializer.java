package com.discord.utilities.kryo;

import com.discord.utilities.collections.SnowflakePartitionMap;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.d0._Ranges;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SnowflakePartitionMapSerializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMapSerializer extends Serializer<SnowflakePartitionMap<?>> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public SnowflakePartitionMap<?> read(Kryo kryo, Input input, Class<SnowflakePartitionMap<?>> type) {
        Intrinsics3.checkNotNullParameter(kryo, "kryo");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        SnowflakePartitionMap<?> snowflakePartitionMap = new SnowflakePartitionMap<>(i);
        Iterator<Integer> it = _Ranges.until(0, i2).iterator();
        while (it.hasNext()) {
            ((Iterators4) it).nextInt();
            snowflakePartitionMap.put(Long.valueOf(input.readLong()), kryo.readClassAndObject(input));
        }
        return snowflakePartitionMap;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, SnowflakePartitionMap<?> target) {
        Intrinsics3.checkNotNullParameter(kryo, "kryo");
        Intrinsics3.checkNotNullParameter(output, "output");
        Intrinsics3.checkNotNullParameter(target, "target");
        output.writeInt(target.getNumPartitions(), true);
        output.writeInt(target.size(), true);
        for (Map.Entry<Long, ?> entry : target.entrySet()) {
            output.writeLong(entry.getKey().longValue());
            kryo.writeClassAndObject(output, entry.getValue());
        }
    }
}
