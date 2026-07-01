package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public class OptionalSerializers$OptionalSerializer extends Serializer<Optional> {
    private OptionalSerializers$OptionalSerializer() {
        setAcceptsNull(false);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Optional copy(Kryo kryo, Optional optional) {
        return copy2(kryo, optional);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Optional read(Kryo kryo, Input input, Class<Optional> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Optional optional) {
        write2(kryo, output, optional);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public Optional copy2(Kryo kryo, Optional optional) {
        return optional.isPresent() ? Optional.of(kryo.copy(optional.get())) : optional;
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Optional read2(Kryo kryo, Input input, Class<Optional> cls) {
        return Optional.ofNullable(kryo.readClassAndObject(input));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Optional optional) {
        kryo.writeClassAndObject(output, optional.isPresent() ? optional.get() : null);
    }

    public /* synthetic */ OptionalSerializers$OptionalSerializer(OptionalSerializers$1 optionalSerializers$1) {
        this();
    }
}
