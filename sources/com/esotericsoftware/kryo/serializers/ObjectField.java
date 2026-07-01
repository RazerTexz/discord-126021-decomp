package com.esotericsoftware.kryo.serializers;

import b.d.b.a.outline;
import b.e.a.Log;
import b.e.b.FieldAccess2;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ObjectField extends FieldSerializer.CachedField {
    public final FieldSerializer fieldSerializer;
    public Class[] generics;
    public final Kryo kryo;
    public final Class type;

    public static final class ObjectBooleanField extends ObjectField {
        public ObjectBooleanField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setBoolean(obj2, field.getBoolean(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Boolean.valueOf(this.field.getBoolean(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                this.field.setBoolean(obj, input.readBoolean());
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                output.writeBoolean(this.field.getBoolean(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectByteField extends ObjectField {
        public ObjectByteField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setByte(obj2, field.getByte(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Byte.valueOf(this.field.getByte(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                this.field.setByte(obj, input.readByte());
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                output.writeByte(this.field.getByte(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectCharField extends ObjectField {
        public ObjectCharField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setChar(obj2, field.getChar(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Character.valueOf(this.field.getChar(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                this.field.setChar(obj, input.readChar());
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                output.writeChar(this.field.getChar(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectDoubleField extends ObjectField {
        public ObjectDoubleField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setDouble(obj2, field.getDouble(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Double.valueOf(this.field.getDouble(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                this.field.setDouble(obj, input.readDouble());
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                output.writeDouble(this.field.getDouble(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectFloatField extends ObjectField {
        public ObjectFloatField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setFloat(obj2, field.getFloat(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Float.valueOf(this.field.getFloat(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                this.field.setFloat(obj, input.readFloat());
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                output.writeFloat(this.field.getFloat(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectIntField extends ObjectField {
        public ObjectIntField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setInt(obj2, field.getInt(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Integer.valueOf(this.field.getInt(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                if (this.varIntsEnabled) {
                    this.field.setInt(obj, input.readInt(false));
                } else {
                    this.field.setInt(obj, input.readInt());
                }
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                if (this.varIntsEnabled) {
                    output.writeInt(this.field.getInt(obj), false);
                } else {
                    output.writeInt(this.field.getInt(obj));
                }
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectLongField extends ObjectField {
        public ObjectLongField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setLong(obj2, field.getLong(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Long.valueOf(this.field.getLong(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                if (this.varIntsEnabled) {
                    this.field.setLong(obj, input.readLong(false));
                } else {
                    this.field.setLong(obj, input.readLong());
                }
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                if (this.varIntsEnabled) {
                    output.writeLong(this.field.getLong(obj), false);
                } else {
                    output.writeLong(this.field.getLong(obj));
                }
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public static final class ObjectShortField extends ObjectField {
        public ObjectShortField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                Field field = this.field;
                field.setShort(obj2, field.getShort(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            return Short.valueOf(this.field.getShort(obj));
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            try {
                this.field.setShort(obj, input.readShort());
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            try {
                output.writeShort(this.field.getShort(obj));
            } catch (Exception e) {
                KryoException kryoException = new KryoException(e);
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", kryoException);
                throw kryoException;
            }
        }
    }

    public ObjectField(FieldSerializer fieldSerializer) {
        this.fieldSerializer = fieldSerializer;
        this.kryo = fieldSerializer.kryo;
        this.type = fieldSerializer.type;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
    public void copy(Object obj, Object obj2) {
        try {
            int i = this.accessIndex;
            if (i == -1) {
                setField(obj2, this.kryo.copy(getField(obj)));
            } else {
                FieldAccess2 fieldAccess2 = (FieldAccess2) this.fieldSerializer.access;
                fieldAccess2.t(obj2, i, this.kryo.copy(fieldAccess2.b(obj, i)));
            }
        } catch (KryoException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" (");
            outline.m0(this.type, sb, ")", e);
            throw e;
        } catch (IllegalAccessException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error accessing field: ");
            sb2.append(this);
            sb2.append(" (");
            throw new KryoException(outline.o(this.type, sb2, ")"), e2);
        } catch (RuntimeException e3) {
            KryoException kryoException = new KryoException(e3);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this);
            sb3.append(" (");
            outline.m0(this.type, sb3, ")", kryoException);
            throw kryoException;
        }
    }

    public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return this.field.get(obj);
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
    public void read(Input input, Object obj) {
        Object objectOrNull;
        try {
            try {
                try {
                    Log.a aVar = Log.a;
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

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
    public void write(Output output, Object obj) {
        try {
            try {
                Log.a aVar = Log.a;
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
