package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers$ObjectArraySerializer extends Serializer<Object[]> {
    private boolean elementsAreSameType;
    private boolean elementsCanBeNull = true;
    private Class[] generics;
    private final Class type;

    public DefaultArraySerializers$ObjectArraySerializer(Kryo kryo, Class cls) {
        setAcceptsNull(true);
        this.type = cls;
        if ((cls.getComponentType().getModifiers() & 16) != 0) {
            setElementsAreSameType(true);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Object[] copy(Kryo kryo, Object[] objArr) {
        return copy2(kryo, objArr);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Object[] read(Kryo kryo, Input input, Class<Object[]> cls) {
        return read2(kryo, input, cls);
    }

    public void setElementsAreSameType(boolean z2) {
        this.elementsAreSameType = z2;
    }

    public void setElementsCanBeNull(boolean z2) {
        this.elementsCanBeNull = z2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void setGenerics(Kryo kryo, Class[] clsArr) {
        a$a a_a = a.a;
        this.generics = clsArr;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Object[] objArr) {
        write2(kryo, output, objArr);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public Object[] copy2(Kryo kryo, Object[] objArr) {
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length);
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            objArr2[i] = kryo.copy(objArr[i]);
        }
        return objArr2;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Object[] read2(Kryo kryo, Input input, Class<Object[]> cls) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            return null;
        }
        Object[] objArr = (Object[]) Array.newInstance(cls.getComponentType(), varInt - 1);
        kryo.reference(objArr);
        Class componentType = objArr.getClass().getComponentType();
        int i = 0;
        if (this.elementsAreSameType || Modifier.isFinal(componentType.getModifiers())) {
            Serializer serializer = kryo.getSerializer(componentType);
            serializer.setGenerics(kryo, this.generics);
            int length = objArr.length;
            while (i < length) {
                if (this.elementsCanBeNull) {
                    objArr[i] = kryo.readObjectOrNull(input, componentType, serializer);
                } else {
                    objArr[i] = kryo.readObject(input, componentType, serializer);
                }
                i++;
            }
        } else {
            int length2 = objArr.length;
            while (i < length2) {
                Registration registration = kryo.readClass(input);
                if (registration != null) {
                    registration.getSerializer().setGenerics(kryo, this.generics);
                    objArr[i] = kryo.readObject(input, registration.getType(), registration.getSerializer());
                } else {
                    objArr[i] = null;
                }
                i++;
            }
        }
        return objArr;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Object[] objArr) {
        int i = 0;
        if (objArr == null) {
            output.writeVarInt(0, true);
            return;
        }
        output.writeVarInt(objArr.length + 1, true);
        Class<?> componentType = objArr.getClass().getComponentType();
        if (!this.elementsAreSameType && !Modifier.isFinal(componentType.getModifiers())) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] != null) {
                    kryo.getSerializer(objArr[i].getClass()).setGenerics(kryo, this.generics);
                }
                kryo.writeClassAndObject(output, objArr[i]);
                i++;
            }
            return;
        }
        Serializer serializer = kryo.getSerializer(componentType);
        serializer.setGenerics(kryo, this.generics);
        int length2 = objArr.length;
        while (i < length2) {
            if (this.elementsCanBeNull) {
                kryo.writeObjectOrNull(output, objArr[i], serializer);
            } else {
                kryo.writeObject(output, objArr[i], serializer);
            }
            i++;
        }
    }
}
