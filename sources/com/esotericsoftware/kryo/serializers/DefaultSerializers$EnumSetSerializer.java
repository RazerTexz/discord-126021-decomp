package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$EnumSetSerializer extends Serializer<EnumSet> {
    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ EnumSet copy(Kryo kryo, EnumSet enumSet) {
        return copy2(kryo, enumSet);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ EnumSet read(Kryo kryo, Input input, Class<EnumSet> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, EnumSet enumSet) {
        write2(kryo, output, enumSet);
    }

    /* JADX INFO: renamed from: copy, reason: avoid collision after fix types in other method */
    public EnumSet copy2(Kryo kryo, EnumSet enumSet) {
        return EnumSet.copyOf(enumSet);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public EnumSet read2(Kryo kryo, Input input, Class<EnumSet> cls) {
        Registration registration = kryo.readClass(input);
        EnumSet enumSetNoneOf = EnumSet.noneOf(registration.getType());
        Serializer serializer = registration.getSerializer();
        int i = input.readInt(true);
        for (int i2 = 0; i2 < i; i2++) {
            enumSetNoneOf.add(serializer.read(kryo, input, null));
        }
        return enumSetNoneOf;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, EnumSet enumSet) {
        Serializer serializer;
        if (enumSet.isEmpty()) {
            EnumSet enumSetComplementOf = EnumSet.complementOf(enumSet);
            if (enumSetComplementOf.isEmpty()) {
                throw new KryoException("An EnumSet must have a defined Enum to be serialized.");
            }
            serializer = kryo.writeClass(output, enumSetComplementOf.iterator().next().getClass()).getSerializer();
        } else {
            serializer = kryo.writeClass(output, enumSet.iterator().next().getClass()).getSerializer();
        }
        output.writeInt(enumSet.size(), true);
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            serializer.write(kryo, output, it.next());
        }
    }
}
