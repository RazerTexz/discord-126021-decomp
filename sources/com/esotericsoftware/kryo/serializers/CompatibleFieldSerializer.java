package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.esotericsoftware.kryo.util.ObjectMap;

/* JADX INFO: loaded from: classes.dex */
public class CompatibleFieldSerializer<T> extends FieldSerializer<T> {
    private static final int THRESHOLD_BINARY_SEARCH = 32;

    public CompatibleFieldSerializer(Kryo kryo, Class cls) {
        super(kryo, cls);
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public T read(Kryo kryo, Input input, Class<T> cls) {
        T tCreate = create(kryo, input, cls);
        kryo.reference(tCreate);
        ObjectMap graphContext = kryo.getGraphContext();
        FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr = (FieldSerializer$CachedField[]) graphContext.get(this);
        if (fieldSerializer$CachedFieldArr == null) {
            int varInt = input.readVarInt(true);
            a$a a_a = a.a;
            String[] strArr = new String[varInt];
            for (int i = 0; i < varInt; i++) {
                strArr[i] = input.readString();
            }
            FieldSerializer$CachedField[] fieldSerializer$CachedFieldArr2 = new FieldSerializer$CachedField[varInt];
            FieldSerializer$CachedField[] fields = getFields();
            if (varInt < 32) {
                for (int i2 = 0; i2 < varInt; i2++) {
                    String str = strArr[i2];
                    int length = fields.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            a$a a_a2 = a.a;
                            break;
                        }
                        if (getCachedFieldName(fields[i3]).equals(str)) {
                            fieldSerializer$CachedFieldArr2[i2] = fields[i3];
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                int length2 = fields.length;
                for (int i4 = 0; i4 < varInt; i4++) {
                    String str2 = strArr[i4];
                    int i5 = length2 - 1;
                    int i6 = 0;
                    while (true) {
                        if (i6 > i5) {
                            a$a a_a3 = a.a;
                            break;
                        }
                        int i7 = (i6 + i5) >>> 1;
                        int iCompareTo = str2.compareTo(getCachedFieldName(fields[i7]));
                        if (iCompareTo >= 0) {
                            if (iCompareTo <= 0) {
                                fieldSerializer$CachedFieldArr2[i4] = fields[i7];
                                break;
                            }
                            i6 = i7 + 1;
                        } else {
                            i5 = i7 - 1;
                        }
                    }
                }
            }
            graphContext.put(this, fieldSerializer$CachedFieldArr2);
            fieldSerializer$CachedFieldArr = fieldSerializer$CachedFieldArr2;
        }
        InputChunked inputChunked = new InputChunked(input, 1024);
        boolean z2 = getGenerics() != null;
        for (FieldSerializer$CachedField field : fieldSerializer$CachedFieldArr) {
            if (field != null && z2) {
                field = getField(getCachedFieldName(field));
            }
            if (field == null) {
                a$a a_a4 = a.a;
                inputChunked.nextChunks();
            } else {
                field.read(inputChunked, tCreate);
                inputChunked.nextChunks();
            }
        }
        return tCreate;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, T t) {
        FieldSerializer$CachedField[] fields = getFields();
        ObjectMap graphContext = kryo.getGraphContext();
        if (!graphContext.containsKey(this)) {
            graphContext.put(this, null);
            a$a a_a = a.a;
            output.writeVarInt(fields.length, true);
            for (FieldSerializer$CachedField fieldSerializer$CachedField : fields) {
                output.writeString(getCachedFieldName(fieldSerializer$CachedField));
            }
        }
        OutputChunked outputChunked = new OutputChunked(output, 1024);
        for (FieldSerializer$CachedField fieldSerializer$CachedField2 : fields) {
            fieldSerializer$CachedField2.write(outputChunked, t);
            outputChunked.endChunks();
        }
    }
}
