package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Currency;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$CurrencySerializer extends Serializer<Currency> {
    public DefaultSerializers$CurrencySerializer() {
        setImmutable(true);
        setAcceptsNull(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Currency read(Kryo kryo, Input input, Class<Currency> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Currency currency) {
        write2(kryo, output, currency);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Currency read2(Kryo kryo, Input input, Class<Currency> cls) {
        String string = input.readString();
        if (string == null) {
            return null;
        }
        return Currency.getInstance(string);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Currency currency) {
        output.writeString(currency == null ? null : currency.getCurrencyCode());
    }
}
