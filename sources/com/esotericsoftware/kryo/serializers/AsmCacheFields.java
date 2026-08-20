package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p106e.p108b.AbstractC1647c;

/* JADX INFO: loaded from: classes.dex */
public class AsmCacheFields {

    public static final class AsmBooleanField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m917u(obj2, i, abstractC1647c.m906c(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m917u(obj, this.accessIndex, input.readBoolean());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeBoolean(this.access.m906c(obj, this.accessIndex));
        }
    }

    public static final class AsmByteField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m918v(obj2, i, abstractC1647c.m907d(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m918v(obj, this.accessIndex, input.readByte());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeByte(this.access.m907d(obj, this.accessIndex));
        }
    }

    public static abstract class AsmCachedField extends FieldSerializer.CachedField {
    }

    public static final class AsmCharField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m919w(obj2, i, abstractC1647c.m908e(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m919w(obj, this.accessIndex, input.readChar());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeChar(this.access.m908e(obj, this.accessIndex));
        }
    }

    public static final class AsmDoubleField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m920x(obj2, i, abstractC1647c.m909f(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m920x(obj, this.accessIndex, input.readDouble());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeDouble(this.access.m909f(obj, this.accessIndex));
        }
    }

    public static final class AsmFloatField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m921y(obj2, i, abstractC1647c.m910g(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m921y(obj, this.accessIndex, input.readFloat());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeFloat(this.access.m910g(obj, this.accessIndex));
        }
    }

    public static final class AsmIntField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m922z(obj2, i, abstractC1647c.m912i(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            if (this.varIntsEnabled) {
                this.access.m922z(obj, this.accessIndex, input.readInt(false));
            } else {
                this.access.m922z(obj, this.accessIndex, input.readInt());
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            if (this.varIntsEnabled) {
                output.writeInt(this.access.m912i(obj, this.accessIndex), false);
            } else {
                output.writeInt(this.access.m912i(obj, this.accessIndex));
            }
        }
    }

    public static final class AsmLongField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m903A(obj2, i, abstractC1647c.m913j(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            if (this.varIntsEnabled) {
                this.access.m903A(obj, this.accessIndex, input.readLong(false));
            } else {
                this.access.m903A(obj, this.accessIndex, input.readLong());
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            if (this.varIntsEnabled) {
                output.writeLong(this.access.m913j(obj, this.accessIndex), false);
            } else {
                output.writeLong(this.access.m913j(obj, this.accessIndex));
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
                AbstractC1647c abstractC1647c = this.access;
                abstractC1647c.m916t(obj2, i, this.kryo.copy(abstractC1647c.m905b(obj, i)));
            } catch (KryoException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(" (");
                C1643a.m864m0(this.type, sb, ")", e);
                throw e;
            } catch (RuntimeException e2) {
                KryoException kryoException = new KryoException(e2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this);
                sb2.append(" (");
                C1643a.m864m0(this.type, sb2, ")", kryoException);
                throw kryoException;
            }
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public Object getField(Object obj) throws IllegalAccessException, IllegalArgumentException {
            int i = this.accessIndex;
            if (i != -1) {
                return this.access.m905b(obj, i);
            }
            throw new KryoException("Unknown acess index");
        }

        @Override // com.esotericsoftware.kryo.serializers.ObjectField
        public void setField(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            int i = this.accessIndex;
            if (i == -1) {
                throw new KryoException("Unknown acess index");
            }
            this.access.m916t(obj, i, obj2);
        }
    }

    public static final class AsmShortField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m904B(obj2, i, abstractC1647c.m914k(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m904B(obj, this.accessIndex, input.readShort());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeShort(this.access.m914k(obj, this.accessIndex));
        }
    }

    public static final class AsmStringField extends AsmCachedField {
        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void copy(Object obj, Object obj2) {
            AbstractC1647c abstractC1647c = this.access;
            int i = this.accessIndex;
            abstractC1647c.m916t(obj2, i, abstractC1647c.m915l(obj, i));
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void read(Input input, Object obj) {
            this.access.m916t(obj, this.accessIndex, input.readString());
        }

        @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedField
        public void write(Output output, Object obj) {
            output.writeString(this.access.m915l(obj, this.accessIndex));
        }
    }
}
