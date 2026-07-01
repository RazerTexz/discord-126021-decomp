package com.esotericsoftware.kryo.serializers;

import b.d.b.a.a;
import b.e.a.a$a;
import b.e.b.c;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class ObjectField extends FieldSerializer$CachedField {
    public final FieldSerializer fieldSerializer;
    public Class[] generics;
    public final Kryo kryo;
    public final Class type;

    public ObjectField(FieldSerializer fieldSerializer) {
        this.fieldSerializer = fieldSerializer;
        this.kryo = fieldSerializer.kryo;
        this.type = fieldSerializer.type;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void copy(Object obj, Object obj2) {
        try {
            int i = this.accessIndex;
            if (i == -1) {
                setField(obj2, this.kryo.copy(getField(obj)));
            } else {
                c cVar = (c) this.fieldSerializer.access;
                cVar.t(obj2, i, this.kryo.copy(cVar.b(obj, i)));
            }
        } catch (KryoException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            a.m0(this.type, sb, ")", e);
            throw e;
        } catch (IllegalAccessException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error accessing field: ");
            sb2.append(this);
            sb2.append(" (");
            throw new KryoException(a.o(this.type, sb2, ")"), e2);
        } catch (RuntimeException e3) {
            KryoException kryoException = new KryoException(e3);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this);
            sb3.append(" (");
            a.m0(this.type, sb3, ")", kryoException);
            throw kryoException;
        }
    }

    public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.field.get(obj);
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void read(Input input, Object obj) {
        Object objectOrNull;
        try {
            try {
                try {
                    a$a a_a = b.e.a.a.a;
                    Class cls = this.valueClass;
                    Serializer serializer = this.serializer;
                    if (cls == null) {
                        Registration registration = this.kryo.readClass(input);
                        if (registration == null) {
                            objectOrNull = null;
                        } else {
                            if (serializer == null) {
                                serializer = registration.getSerializer();
                            }
                            serializer.setGenerics(this.kryo, this.generics);
                            objectOrNull = this.kryo.readObject(input, registration.getType(), serializer);
                        }
                    } else {
                        if (serializer == null) {
                            serializer = this.kryo.getSerializer(cls);
                            this.serializer = serializer;
                        }
                        serializer.setGenerics(this.kryo, this.generics);
                        objectOrNull = this.canBeNull ? this.kryo.readObjectOrNull(input, cls, serializer) : this.kryo.readObject(input, cls, serializer);
                    }
                    setField(obj, objectOrNull);
                } catch (RuntimeException e) {
                    KryoException kryoException = new KryoException(e);
                    kryoException.addTrace(this + " (" + this.type.getName() + ")");
                    throw kryoException;
                }
            } catch (KryoException e2) {
                e2.addTrace(this + " (" + this.type.getName() + ")");
                throw e2;
            }
        } catch (IllegalAccessException e3) {
            throw new KryoException("Error accessing field: " + this + " (" + this.type.getName() + ")", e3);
        }
    }

    public void setField(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        this.field.set(obj, obj2);
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer$CachedField
    public void write(Output output, Object obj) {
        try {
            try {
                a$a a_a = b.e.a.a.a;
                Object field = getField(obj);
                Serializer serializer = this.serializer;
                Class cls = this.valueClass;
                if (cls == null) {
                    if (field == null) {
                        this.kryo.writeClass(output, null);
                        return;
                    }
                    Registration registrationWriteClass = this.kryo.writeClass(output, field.getClass());
                    if (serializer == null) {
                        serializer = registrationWriteClass.getSerializer();
                    }
                    serializer.setGenerics(this.kryo, this.generics);
                    this.kryo.writeObject(output, field, serializer);
                    return;
                }
                if (serializer == null) {
                    serializer = this.kryo.getSerializer(cls);
                    this.serializer = serializer;
                }
                serializer.setGenerics(this.kryo, this.generics);
                if (this.canBeNull) {
                    this.kryo.writeObjectOrNull(output, field, serializer);
                    return;
                }
                if (field != null) {
                    this.kryo.writeObject(output, field, serializer);
                    return;
                }
                throw new KryoException("Field value is null but canBeNull is false: " + this + " (" + obj.getClass().getName() + ")");
            } catch (KryoException e) {
                e.addTrace(this + " (" + obj.getClass().getName() + ")");
                throw e;
            }
        } catch (IllegalAccessException e2) {
            throw new KryoException("Error accessing field: " + this + " (" + obj.getClass().getName() + ")", e2);
        } catch (RuntimeException e3) {
            KryoException kryoException = new KryoException(e3);
            kryoException.addTrace(this + " (" + obj.getClass().getName() + ")");
            throw kryoException;
        }
    }
}
