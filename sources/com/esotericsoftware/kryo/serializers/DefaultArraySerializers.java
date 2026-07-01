package com.esotericsoftware.kryo.serializers;

import b.e.a.Log;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class DefaultArraySerializers {

    public static class BooleanArraySerializer extends Serializer<boolean[]> {
        public BooleanArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public boolean[] copy(Kryo kryo, boolean[] zArr) {
            int length = zArr.length;
            boolean[] zArr2 = new boolean[length];
            System.arraycopy(zArr, 0, zArr2, 0, length);
            return zArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public boolean[] read(Kryo kryo, Input input, Class<boolean[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            int i = varInt - 1;
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 < i; i2++) {
                zArr[i2] = input.readBoolean();
            }
            return zArr;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, boolean[] zArr) {
            if (zArr == null) {
                output.writeVarInt(0, true);
                return;
            }
            output.writeVarInt(zArr.length + 1, true);
            for (boolean z2 : zArr) {
                output.writeBoolean(z2);
            }
        }
    }

    public static class ByteArraySerializer extends Serializer<byte[]> {
        public ByteArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public byte[] copy(Kryo kryo, byte[] bArr) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public byte[] read(Kryo kryo, Input input, Class<byte[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readBytes(varInt - 1);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, byte[] bArr) {
            if (bArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(bArr.length + 1, true);
                output.writeBytes(bArr);
            }
        }
    }

    public static class CharArraySerializer extends Serializer<char[]> {
        public CharArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public char[] copy(Kryo kryo, char[] cArr) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, length);
            return cArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public char[] read(Kryo kryo, Input input, Class<char[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readChars(varInt - 1);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, char[] cArr) {
            if (cArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(cArr.length + 1, true);
                output.writeChars(cArr);
            }
        }
    }

    public static class DoubleArraySerializer extends Serializer<double[]> {
        public DoubleArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public double[] copy(Kryo kryo, double[] dArr) {
            int length = dArr.length;
            double[] dArr2 = new double[length];
            System.arraycopy(dArr, 0, dArr2, 0, length);
            return dArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public double[] read(Kryo kryo, Input input, Class<double[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readDoubles(varInt - 1);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, double[] dArr) {
            if (dArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(dArr.length + 1, true);
                output.writeDoubles(dArr);
            }
        }
    }

    public static class FloatArraySerializer extends Serializer<float[]> {
        public FloatArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public float[] copy(Kryo kryo, float[] fArr) {
            int length = fArr.length;
            float[] fArr2 = new float[length];
            System.arraycopy(fArr, 0, fArr2, 0, length);
            return fArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public float[] read(Kryo kryo, Input input, Class<float[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readFloats(varInt - 1);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, float[] fArr) {
            if (fArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(fArr.length + 1, true);
                output.writeFloats(fArr);
            }
        }
    }

    public static class IntArraySerializer extends Serializer<int[]> {
        public IntArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public int[] copy(Kryo kryo, int[] iArr) {
            int length = iArr.length;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            return iArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public int[] read(Kryo kryo, Input input, Class<int[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readInts(varInt - 1, false);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, int[] iArr) {
            if (iArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(iArr.length + 1, true);
                output.writeInts(iArr, false);
            }
        }
    }

    public static class LongArraySerializer extends Serializer<long[]> {
        public LongArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public long[] copy(Kryo kryo, long[] jArr) {
            int length = jArr.length;
            long[] jArr2 = new long[length];
            System.arraycopy(jArr, 0, jArr2, 0, length);
            return jArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public long[] read(Kryo kryo, Input input, Class<long[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readLongs(varInt - 1, false);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, long[] jArr) {
            if (jArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(jArr.length + 1, true);
                output.writeLongs(jArr, false);
            }
        }
    }

    public static class ObjectArraySerializer extends Serializer<Object[]> {
        private boolean elementsAreSameType;
        private boolean elementsCanBeNull = true;
        private Class[] generics;
        private final Class type;

        public ObjectArraySerializer(Kryo kryo, Class cls) {
            setAcceptsNull(true);
            this.type = cls;
            if ((cls.getComponentType().getModifiers() & 16) != 0) {
                setElementsAreSameType(true);
            }
        }

        public void setElementsAreSameType(boolean z2) {
            this.elementsAreSameType = z2;
        }

        public void setElementsCanBeNull(boolean z2) {
            this.elementsCanBeNull = z2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void setGenerics(Kryo kryo, Class[] clsArr) {
            Log.a aVar = Log.a;
            this.generics = clsArr;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public Object[] copy(Kryo kryo, Object[] objArr) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                objArr2[i] = kryo.copy(objArr[i]);
            }
            return objArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public Object[] read(Kryo kryo, Input input, Class<Object[]> cls) {
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

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, Object[] objArr) {
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

    public static class ShortArraySerializer extends Serializer<short[]> {
        public ShortArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public short[] copy(Kryo kryo, short[] sArr) {
            int length = sArr.length;
            short[] sArr2 = new short[length];
            System.arraycopy(sArr, 0, sArr2, 0, length);
            return sArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public short[] read(Kryo kryo, Input input, Class<short[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            return input.readShorts(varInt - 1);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, short[] sArr) {
            if (sArr == null) {
                output.writeVarInt(0, true);
            } else {
                output.writeVarInt(sArr.length + 1, true);
                output.writeShorts(sArr);
            }
        }
    }

    public static class StringArraySerializer extends Serializer<String[]> {
        public StringArraySerializer() {
            setAcceptsNull(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public String[] copy(Kryo kryo, String[] strArr) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            return strArr2;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public String[] read(Kryo kryo, Input input, Class<String[]> cls) {
            int varInt = input.readVarInt(true);
            if (varInt == 0) {
                return null;
            }
            int i = varInt - 1;
            String[] strArr = new String[i];
            int i2 = 0;
            if (kryo.getReferences() && kryo.getReferenceResolver().useReferences(String.class)) {
                Serializer serializer = kryo.getSerializer(String.class);
                while (i2 < i) {
                    strArr[i2] = (String) kryo.readObjectOrNull(input, String.class, serializer);
                    i2++;
                }
            } else {
                while (i2 < i) {
                    strArr[i2] = input.readString();
                    i2++;
                }
            }
            return strArr;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public void write(Kryo kryo, Output output, String[] strArr) {
            int i = 0;
            if (strArr == null) {
                output.writeVarInt(0, true);
                return;
            }
            output.writeVarInt(strArr.length + 1, true);
            if (!kryo.getReferences() || !kryo.getReferenceResolver().useReferences(String.class)) {
                int length = strArr.length;
                while (i < length) {
                    output.writeString(strArr[i]);
                    i++;
                }
                return;
            }
            Serializer serializer = kryo.getSerializer(String.class);
            int length2 = strArr.length;
            while (i < length2) {
                kryo.writeObjectOrNull(output, strArr[i], serializer);
                i++;
            }
        }
    }
}
