package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import com.esotericsoftware.kryo.Kryo;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes.dex */
public class JavaSerializer$ObjectInputStreamWithKryoClassLoader extends ObjectInputStream {
    private final ClassLoader loader;

    public JavaSerializer$ObjectInputStreamWithKryoClassLoader(InputStream inputStream, Kryo kryo) throws IOException {
        super(inputStream);
        this.loader = kryo.getClassLoader();
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return Class.forName(objectStreamClass.getName(), false, this.loader);
        } catch (ClassNotFoundException e) {
            StringBuilder sbU = a.U("Class not found: ");
            sbU.append(objectStreamClass.getName());
            throw new RuntimeException(sbU.toString(), e);
        }
    }
}
