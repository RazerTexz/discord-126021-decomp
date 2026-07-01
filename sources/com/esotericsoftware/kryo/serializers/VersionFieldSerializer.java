package com.esotericsoftware.kryo.serializers;

import b.e.a.a;
import b.e.a.a$a;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class VersionFieldSerializer<T> extends FieldSerializer<T> {
    private boolean compatible;
    private int[] fieldVersion;
    private int typeVersion;

    public VersionFieldSerializer(Kryo kryo, Class cls) {
        super(kryo, cls);
        this.typeVersion = 0;
        this.compatible = true;
        initializeCachedFields();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void initializeCachedFields() {
        FieldSerializer$CachedField[] fields = getFields();
        this.fieldVersion = new int[fields.length];
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            VersionFieldSerializer$Since versionFieldSerializer$Since = (VersionFieldSerializer$Since) fields[i].getField().getAnnotation(VersionFieldSerializer$Since.class);
            if (versionFieldSerializer$Since != null) {
                this.fieldVersion[i] = versionFieldSerializer$Since.value();
                this.typeVersion = Math.max(this.fieldVersion[i], this.typeVersion);
            } else {
                this.fieldVersion[i] = 0;
            }
        }
        this.removedFields.clear();
        a$a a_a = a.a;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public T read(Kryo kryo, Input input, Class<T> cls) {
        T tCreate = create(kryo, input, cls);
        kryo.reference(tCreate);
        int varInt = input.readVarInt(true);
        if (!this.compatible && varInt != this.typeVersion) {
            StringBuilder sbV = b.d.b.a.a.V("Version not compatible: ", varInt, " <-> ");
            sbV.append(this.typeVersion);
            throw new KryoException(sbV.toString());
        }
        FieldSerializer$CachedField[] fields = getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            if (this.fieldVersion[i] > varInt) {
                a$a a_a = a.a;
            } else {
                fields[i].read(input, tCreate);
            }
        }
        return tCreate;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void removeField(String str) {
        super.removeField(str);
        initializeCachedFields();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, T t) {
        FieldSerializer$CachedField[] fields = getFields();
        output.writeVarInt(this.typeVersion, true);
        for (FieldSerializer$CachedField fieldSerializer$CachedField : fields) {
            fieldSerializer$CachedField.write(output, t);
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void removeField(FieldSerializer$CachedField fieldSerializer$CachedField) {
        super.removeField(fieldSerializer$CachedField);
        initializeCachedFields();
    }

    public VersionFieldSerializer(Kryo kryo, Class cls, boolean z2) {
        this(kryo, cls);
        this.compatible = z2;
    }
}
