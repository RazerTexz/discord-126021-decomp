package com.discord.utilities.kryo;

import com.discord.utilities.collections.SnowflakePartitionMap;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.util.Iterator;
import java.util.Map;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SnowflakePartitionMapSerializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMapSerializer extends Serializer<SnowflakePartitionMap<?>> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public SnowflakePartitionMap<?> read(Kryo kryo, Input input, Class<SnowflakePartitionMap<?>> type) {
        C12238m.checkNotNullParameter(kryo, "kryo");
        C12238m.checkNotNullParameter(input, "input");
        C12238m.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        SnowflakePartitionMap<?> snowflakePartitionMap = new SnowflakePartitionMap<>(i);
        Iterator<Integer> it = C11226f.until(0, i2).iterator();
        while (it.hasNext()) {
            ((AbstractC12126c0) it).nextInt();
            snowflakePartitionMap.put(Long.valueOf(input.readLong()), kryo.readClassAndObject(input));
        }
        return snowflakePartitionMap;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, SnowflakePartitionMap<?> target) {
        C12238m.checkNotNullParameter(kryo, "kryo");
        C12238m.checkNotNullParameter(output, "output");
        C12238m.checkNotNullParameter(target, "target");
        output.writeInt(target.getNumPartitions(), true);
        output.writeInt(target.size(), true);
        for (Map.Entry<Long, ?> entry : target.entrySet()) {
            output.writeLong(entry.getKey().longValue());
            kryo.writeClassAndObject(output, entry.getValue());
        }
    }
}
