package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$TreeSetSerializer extends CollectionSerializer {
    private TreeSet createTreeSet(Class<? extends Collection> cls, Comparator comparator) {
        if (cls == TreeSet.class || cls == null) {
            return new TreeSet(comparator);
        }
        try {
            Constructor<? extends Collection> constructor = cls.getConstructor(Comparator.class);
            if (!constructor.isAccessible()) {
                try {
                    constructor.setAccessible(true);
                } catch (SecurityException unused) {
                }
            }
            return (TreeSet) constructor.newInstance(comparator);
        } catch (Exception e) {
            throw new KryoException(e);
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
    public /* bridge */ /* synthetic */ Collection create(Kryo kryo, Input input, Class cls) {
        return create(kryo, input, (Class<Collection>) cls);
    }

    @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
    public /* bridge */ /* synthetic */ Collection createCopy(Kryo kryo, Collection collection) {
        return createCopy(kryo, collection);
    }

    @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer, com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Collection collection) {
        write2(kryo, output, collection);
    }

    @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
    public TreeSet create(Kryo kryo, Input input, Class<Collection> cls) {
        return createTreeSet(cls, (Comparator) kryo.readClassAndObject(input));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
    public TreeSet createCopy(Kryo kryo, Collection collection) {
        return createTreeSet(collection.getClass(), ((TreeSet) collection).comparator());
    }

    @Override // com.esotericsoftware.kryo.serializers.CollectionSerializer
    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Collection collection) {
        kryo.writeClassAndObject(output, ((TreeSet) collection).comparator());
        super.write2(kryo, output, collection);
    }
}
