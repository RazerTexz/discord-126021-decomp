package com.discord.utilities.kryo;

import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.util.Iterator;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LeastRecentlyAddedSetSerializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeastRecentlyAddedSetSerializer extends Serializer<LeastRecentlyAddedSet<?>> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> type) {
        C12238m.checkNotNullParameter(kryo, "kryo");
        C12238m.checkNotNullParameter(input, "input");
        C12238m.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        LeastRecentlyAddedSet<?> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(i, null, 2, null);
        Iterator<Integer> it = C11226f.until(0, i2).iterator();
        while (it.hasNext()) {
            ((AbstractC12126c0) it).nextInt();
            Object classAndObject = kryo.readClassAndObject(input);
            C12238m.checkNotNullExpressionValue(classAndObject, "kryo.readClassAndObject(input)");
            leastRecentlyAddedSet.add(classAndObject);
        }
        return leastRecentlyAddedSet;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, LeastRecentlyAddedSet<?> target) {
        C12238m.checkNotNullParameter(kryo, "kryo");
        C12238m.checkNotNullParameter(output, "output");
        C12238m.checkNotNullParameter(target, "target");
        output.writeInt(target.getMaxSize(), true);
        output.writeInt(target.size(), true);
        Iterator<?> it = target.iterator();
        while (it.hasNext()) {
            kryo.writeClassAndObject(output, it.next());
        }
    }
}
