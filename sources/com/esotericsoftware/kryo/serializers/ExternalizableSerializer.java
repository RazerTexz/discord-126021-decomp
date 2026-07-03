package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.KryoObjectInput;
import com.esotericsoftware.kryo.p502io.KryoObjectOutput;
import com.esotericsoftware.kryo.p502io.Output;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ExternalizableSerializer extends Serializer {
    private ObjectMap<Class, JavaSerializer> javaSerializerByType;
    private KryoObjectInput objectInput = null;
    private KryoObjectOutput objectOutput = null;

    private JavaSerializer getCachedSerializer(Class cls) {
        ObjectMap<Class, JavaSerializer> objectMap = this.javaSerializerByType;
        if (objectMap != null) {
            return objectMap.get(cls);
        }
        this.javaSerializerByType = new ObjectMap<>();
        return null;
    }

    private JavaSerializer getJavaSerializerIfRequired(Class cls) {
        JavaSerializer cachedSerializer = getCachedSerializer(cls);
        return (cachedSerializer == null && isJavaSerializerRequired(cls)) ? new JavaSerializer() : cachedSerializer;
    }

    private ObjectInput getObjectInput(Kryo kryo, Input input) {
        KryoObjectInput kryoObjectInput = this.objectInput;
        if (kryoObjectInput == null) {
            this.objectInput = new KryoObjectInput(kryo, input);
        } else {
            kryoObjectInput.setInput(input);
        }
        return this.objectInput;
    }

    private ObjectOutput getObjectOutput(Kryo kryo, Output output) {
        KryoObjectOutput kryoObjectOutput = this.objectOutput;
        if (kryoObjectOutput == null) {
            this.objectOutput = new KryoObjectOutput(kryo, output);
        } else {
            kryoObjectOutput.setOutput(output);
        }
        return this.objectOutput;
    }

    private static boolean hasInheritableReplaceMethod(Class cls, String str) {
        Method declaredMethod;
        while (true) {
            if (cls == null) {
                declaredMethod = null;
                break;
            }
            try {
                declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
                break;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        return declaredMethod != null && declaredMethod.getReturnType() == Object.class;
    }

    private boolean isJavaSerializerRequired(Class cls) {
        return hasInheritableReplaceMethod(cls, "writeReplace") || hasInheritableReplaceMethod(cls, "readResolve");
    }

    private Object readExternal(Kryo kryo, Input input, Class cls) {
        try {
            Externalizable externalizable = (Externalizable) kryo.newInstance(cls);
            externalizable.readExternal(getObjectInput(kryo, input));
            return externalizable;
        } catch (IOException e) {
            throw new KryoException(e);
        } catch (ClassCastException e2) {
            throw new KryoException(e2);
        } catch (ClassNotFoundException e3) {
            throw new KryoException(e3);
        }
    }

    private void writeExternal(Kryo kryo, Output output, Object obj) {
        try {
            ((Externalizable) obj).writeExternal(getObjectOutput(kryo, output));
        } catch (IOException e) {
            throw new KryoException(e);
        } catch (ClassCastException e2) {
            throw new KryoException(e2);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object read(Kryo kryo, Input input, Class cls) {
        JavaSerializer javaSerializerIfRequired = getJavaSerializerIfRequired(cls);
        return javaSerializerIfRequired == null ? readExternal(kryo, input, cls) : javaSerializerIfRequired.read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, Object obj) {
        JavaSerializer javaSerializerIfRequired = getJavaSerializerIfRequired(obj.getClass());
        if (javaSerializerIfRequired == null) {
            writeExternal(kryo, output, obj);
        } else {
            javaSerializerIfRequired.write(kryo, output, obj);
        }
    }
}
