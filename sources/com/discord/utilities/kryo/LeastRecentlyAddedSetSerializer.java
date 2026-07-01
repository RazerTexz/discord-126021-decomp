package com.discord.utilities.kryo;

import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.d0.f;
import d0.t.c0;
import d0.z.d.m;
import java.util.Iterator;

/* JADX INFO: compiled from: LeastRecentlyAddedSetSerializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeastRecentlyAddedSetSerializer extends Serializer<LeastRecentlyAddedSet<?>> {
    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LeastRecentlyAddedSet<?> leastRecentlyAddedSet) {
        write2(kryo, output, leastRecentlyAddedSet);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> type) {
        m.checkNotNullParameter(kryo, "kryo");
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        LeastRecentlyAddedSet<?> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(i, null, 2, null);
        Iterator<Integer> it = f.until(0, i2).iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            Object classAndObject = kryo.readClassAndObject(input);
            m.checkNotNullExpressionValue(classAndObject, "kryo.readClassAndObject(input)");
            leastRecentlyAddedSet.add(classAndObject);
        }
        return leastRecentlyAddedSet;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, LeastRecentlyAddedSet<?> target) {
        m.checkNotNullParameter(kryo, "kryo");
        m.checkNotNullParameter(output, "output");
        m.checkNotNullParameter(target, "target");
        output.writeInt(target.getMaxSize(), true);
        output.writeInt(target.size(), true);
        Iterator<?> it = target.iterator();
        while (it.hasNext()) {
            kryo.writeClassAndObject(output, it.next());
        }
    }
}
