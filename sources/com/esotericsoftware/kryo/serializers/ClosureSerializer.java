package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ClosureSerializer extends Serializer {
    private static Method readResolve;
    private static Class serializedLambda = SerializedLambda.class;

    public static class Closure {
    }

    static {
        try {
            Method declaredMethod = SerializedLambda.class.getDeclaredMethod("readResolve", new Class[0]);
            readResolve = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException("Could not obtain SerializedLambda or its methods via reflection", e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object copy(Kryo kryo, Object obj) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod("writeReplace", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, new Object[0]);
            if (serializedLambda.isInstance(objInvoke)) {
                return readResolve.invoke(objInvoke, new Object[0]);
            }
            throw new RuntimeException("Could not serialize lambda");
        } catch (Exception e) {
            throw new RuntimeException("Could not serialize lambda", e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object read(Kryo kryo, Input input, Class cls) {
        try {
            return readResolve.invoke(kryo.readObject(input, serializedLambda), new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException("Could not serialize lambda", e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, Object obj) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod("writeReplace", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, new Object[0]);
            if (!serializedLambda.isInstance(objInvoke)) {
                throw new RuntimeException("Could not serialize lambda");
            }
            kryo.writeObject(output, objInvoke);
        } catch (Exception e) {
            throw new RuntimeException("Could not serialize lambda", e);
        }
    }
}
