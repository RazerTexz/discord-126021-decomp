package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CollectionSerializer extends Serializer<Collection> {
    private Class elementClass;
    private boolean elementsCanBeNull;
    private Class genericType;
    private Serializer serializer;

    public CollectionSerializer() {
        this.elementsCanBeNull = true;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Collection copy(Kryo kryo, Collection collection) {
        return copy2(kryo, collection);
    }

    public Collection create(Kryo kryo, Input input, Class<Collection> cls) {
        return (Collection) kryo.newInstance(cls);
    }

    public Collection createCopy(Kryo kryo, Collection collection) {
        return (Collection) kryo.newInstance(collection.getClass());
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Collection read(Kryo kryo, Input input, Class<Collection> cls) {
        return read2(kryo, input, cls);
    }

    public void setElementClass(Class cls, Serializer serializer) {
        this.elementClass = cls;
        this.serializer = serializer;
    }

    public void setElementsCanBeNull(boolean z2) {
        this.elementsCanBeNull = z2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void setGenerics(Kryo kryo, Class[] clsArr) {
        this.genericType = null;
        if (clsArr == null || clsArr.length <= 0 || !kryo.isFinal(clsArr[0])) {
            return;
        }
        this.genericType = clsArr[0];
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Collection collection) {
        write2(kryo, output, collection);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public Collection copy2(Kryo kryo, Collection collection) {
        Collection collectionCreateCopy = createCopy(kryo, collection);
        kryo.reference(collectionCreateCopy);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            collectionCreateCopy.add(kryo.copy(it.next()));
        }
        return collectionCreateCopy;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Collection read2(Kryo kryo, Input input, Class<Collection> cls) {
        Collection collectionCreate = create(kryo, input, cls);
        kryo.reference(collectionCreate);
        int varInt = input.readVarInt(true);
        if (collectionCreate instanceof ArrayList) {
            ((ArrayList) collectionCreate).ensureCapacity(varInt);
        }
        Class cls2 = this.elementClass;
        Serializer serializer = this.serializer;
        Class cls3 = this.genericType;
        if (cls3 != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(cls3);
                cls2 = cls3;
            }
            this.genericType = null;
        }
        int i = 0;
        if (serializer == null) {
            while (i < varInt) {
                collectionCreate.add(kryo.readClassAndObject(input));
                i++;
            }
        } else if (this.elementsCanBeNull) {
            while (i < varInt) {
                collectionCreate.add(kryo.readObjectOrNull(input, cls2, serializer));
                i++;
            }
        } else {
            while (i < varInt) {
                collectionCreate.add(kryo.readObject(input, cls2, serializer));
                i++;
            }
        }
        return collectionCreate;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Collection collection) {
        output.writeVarInt(collection.size(), true);
        Serializer serializer = this.serializer;
        Class cls = this.genericType;
        if (cls != null) {
            if (serializer == null) {
                serializer = kryo.getSerializer(cls);
            }
            this.genericType = null;
        }
        if (serializer == null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                kryo.writeClassAndObject(output, it.next());
            }
        } else if (this.elementsCanBeNull) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                kryo.writeObjectOrNull(output, it2.next(), serializer);
            }
        } else {
            Iterator it3 = collection.iterator();
            while (it3.hasNext()) {
                kryo.writeObject(output, it3.next(), serializer);
            }
        }
    }

    public CollectionSerializer(Class cls, Serializer serializer) {
        this.elementsCanBeNull = true;
        setElementClass(cls, serializer);
    }

    public CollectionSerializer(Class cls, Serializer serializer, boolean z2) {
        this.elementsCanBeNull = true;
        setElementClass(cls, serializer);
        this.elementsCanBeNull = z2;
    }
}
