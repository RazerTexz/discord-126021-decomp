package com.esotericsoftware.kryo.serializers;

import b.d.b.a.outline;
import b.e.b.FieldAccess2;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;

/* JADX INFO: loaded from: classes.dex */
public class AsmCacheFields {

    public static final class AsmBooleanField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.u(obj2, i, fieldAccess2.c(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.u(obj, this.accessIndex, input.readBoolean());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeBoolean(this.access.c(obj, this.accessIndex));
        }
    }

    public static final class AsmByteField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.v(obj2, i, fieldAccess2.d(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.v(obj, this.accessIndex, input.readByte());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeByte(this.access.d(obj, this.accessIndex));
        }
    }

    public static abstract class AsmCachedField extends FieldSerializer.CachedField {
    }

    public static final class AsmCharField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.w(obj2, i, fieldAccess2.e(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.w(obj, this.accessIndex, input.readChar());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeChar(this.access.e(obj, this.accessIndex));
        }
    }

    public static final class AsmDoubleField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.x(obj2, i, fieldAccess2.f(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.x(obj, this.accessIndex, input.readDouble());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeDouble(this.access.f(obj, this.accessIndex));
        }
    }

    public static final class AsmFloatField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.y(obj2, i, fieldAccess2.g(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.y(obj, this.accessIndex, input.readFloat());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeFloat(this.access.g(obj, this.accessIndex));
        }
    }

    public static final class AsmIntField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.z(obj2, i, fieldAccess2.i(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            if (this.varIntsEnabled) {
                this.access.z(obj, this.accessIndex, input.readInt(false));
            } else {
                this.access.z(obj, this.accessIndex, input.readInt());
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            if (this.varIntsEnabled) {
                output.writeInt(this.access.i(obj, this.accessIndex), false);
            } else {
                output.writeInt(this.access.i(obj, this.accessIndex));
            }
        }
    }

    public static final class AsmLongField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.A(obj2, i, fieldAccess2.j(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            if (this.varIntsEnabled) {
                this.access.A(obj, this.accessIndex, input.readLong(false));
            } else {
                this.access.A(obj, this.accessIndex, input.readLong());
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            if (this.varIntsEnabled) {
                output.writeLong(this.access.j(obj, this.accessIndex), false);
            } else {
                output.writeLong(this.access.j(obj, this.accessIndex));
            }
        }
    }

    public static final class AsmObjectField extends ObjectField {
        public AsmObjectField(FieldSerializer fieldSerializer) {
            super(fieldSerializer);
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField, com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            try {
                int i = this.accessIndex;
                if (i == -1) {
                    throw new KryoException("Unknown acess index");
                }
                FieldAccess2 fieldAccess2 = this.access;
                fieldAccess2.t(obj2, i, this.kryo.copy(fieldAccess2.b(obj, i)));
            } catch (KryoException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                outline.m0(this.type, sb, ")", e);
                throw e;
            } catch (RuntimeException e2) {
                KryoException kryoException = new KryoException(e2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this);
                sb2.append(" (");
                outline.m0(this.type, sb2, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            int i = this.accessIndex;
            if (i != -1) {
                return this.access.b(obj, i);
            }
            throw new KryoException("Unknown acess index");
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public void setField(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            int i = this.accessIndex;
            if (i == -1) {
                throw new KryoException("Unknown acess index");
            }
            this.access.t(obj, i, obj2);
        }
    }

    public static final class AsmShortField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.B(obj2, i, fieldAccess2.k(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.B(obj, this.accessIndex, input.readShort());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeShort(this.access.k(obj, this.accessIndex));
        }
    }

    public static final class AsmStringField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            FieldAccess2 fieldAccess2 = this.access;
            int i = this.accessIndex;
            fieldAccess2.t(obj2, i, fieldAccess2.l(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.t(obj, this.accessIndex, input.readString());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeString(this.access.l(obj, this.accessIndex));
        }
    }
}
