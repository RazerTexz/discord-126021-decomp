package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class JavaSerializer extends Serializer {

    public static class ObjectInputStreamWithKryoClassLoader extends ObjectInputStream {
        private final ClassLoader loader;

        public ObjectInputStreamWithKryoClassLoader(InputStream inputStream, Kryo kryo) throws IOException {
            super(inputStream);
            this.loader = kryo.getClassLoader();
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
            try {
                return Class.forName(objectStreamClass.getName(), false, this.loader);
            } catch (ClassNotFoundException e) {
                StringBuilder sbM833U = C1643a.m833U("Class not found: ");
                sbM833U.append(objectStreamClass.getName());
                throw new RuntimeException(sbM833U.toString(), e);
            }
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object read(Kryo kryo, Input input, Class cls) {
        try {
            ObjectMap graphContext = kryo.getGraphContext();
            ObjectInputStream objectInputStreamWithKryoClassLoader = (ObjectInputStream) graphContext.get(this);
            if (objectInputStreamWithKryoClassLoader == null) {
                objectInputStreamWithKryoClassLoader = new ObjectInputStreamWithKryoClassLoader(input, kryo);
                graphContext.put(this, objectInputStreamWithKryoClassLoader);
            }
            return objectInputStreamWithKryoClassLoader.readObject();
        } catch (Exception e) {
            throw new KryoException("Error during Java deserialization.", e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, Object obj) {
        try {
            ObjectMap graphContext = kryo.getGraphContext();
            ObjectOutputStream objectOutputStream = (ObjectOutputStream) graphContext.get(this);
            if (objectOutputStream == null) {
                objectOutputStream = new ObjectOutputStream(output);
                graphContext.put(this, objectOutputStream);
            }
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (Exception e) {
            throw new KryoException("Error during Java serialization.", e);
        }
    }
}
