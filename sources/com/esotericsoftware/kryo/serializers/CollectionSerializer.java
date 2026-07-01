package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CollectionSerializer extends Serializer<Collection> {
    private Class elementClass;
    private boolean elementsCanBeNull;
    private Class genericType;
    private Serializer serializer;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BindCollection {
        Class<?> elementClass() default Object.class;

        Class<? extends Serializer> elementSerializer() default Serializer.class;

        boolean elementsCanBeNull() default true;
    }

    public CollectionSerializer() {
        this.elementsCanBeNull = true;
    }

    public Collection create(Kryo kryo, Input input, Class<Collection> cls) {
        return (Collection) kryo.newInstance(cls);
    }

    public Collection createCopy(Kryo kryo, Collection collection) {
        return (Collection) kryo.newInstance(collection.getClass());
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
    public Collection copy(Kryo kryo, Collection collection) {
        Collection collectionCreateCopy = createCopy(kryo, collection);
        kryo.reference(collectionCreateCopy);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            collectionCreateCopy.add(kryo.copy(it.next()));
        }
        return collectionCreateCopy;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Collection read(Kryo kryo, Input input, Class<Collection> cls) {
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

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, Collection collection) {
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
