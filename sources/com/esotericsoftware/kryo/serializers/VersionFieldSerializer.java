package com.esotericsoftware.kryo.serializers;

import b.d.b.a.outline;
import b.e.a.Log;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
public class VersionFieldSerializer<T> extends FieldSerializer<T> {
    private boolean compatible;
    private int[] fieldVersion;
    private int typeVersion;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Since {
        int value() default 0;
    }

    public VersionFieldSerializer(Kryo kryo, Class cls) {
        super(kryo, cls);
        this.typeVersion = 0;
        this.compatible = true;
        initializeCachedFields();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void initializeCachedFields() {
        FieldSerializer.CachedField[] fields = getFields();
        this.fieldVersion = new int[fields.length];
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            Since since = (Since) fields[i].getField().getAnnotation(Since.class);
            if (since != null) {
                this.fieldVersion[i] = since.value();
                this.typeVersion = Math.max(this.fieldVersion[i], this.typeVersion);
            } else {
                this.fieldVersion[i] = 0;
            }
        }
        this.removedFields.clear();
        Log.a aVar = Log.a;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public T read(Kryo kryo, Input input, Class<T> cls) {
        T tCreate = create(kryo, input, cls);
        kryo.reference(tCreate);
        int varInt = input.readVarInt(true);
        if (!this.compatible && varInt != this.typeVersion) {
            StringBuilder sbV = outline.V("Version not compatible: ", varInt, " <-> ");
            sbV.append(this.typeVersion);
            throw new KryoException(sbV.toString());
        }
        FieldSerializer.CachedField[] fields = getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            if (this.fieldVersion[i] > varInt) {
                Log.a aVar = Log.a;
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
        FieldSerializer.CachedField[] fields = getFields();
        output.writeVarInt(this.typeVersion, true);
        for (FieldSerializer.CachedField cachedField : fields) {
            cachedField.write(output, t);
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void removeField(FieldSerializer.CachedField cachedField) {
        super.removeField(cachedField);
        initializeCachedFields();
    }

    public VersionFieldSerializer(Kryo kryo, Class cls, boolean z2) {
        this(kryo, cls);
        this.compatible = z2;
    }
}
