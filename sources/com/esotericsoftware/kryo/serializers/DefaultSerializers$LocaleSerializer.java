package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerializers$LocaleSerializer extends Serializer<Locale> {
    public static final Locale SPANISH = new Locale("es", "", "");
    public static final Locale SPAIN = new Locale("es", "ES", "");

    public DefaultSerializers$LocaleSerializer() {
        setImmutable(true);
    }

    public static boolean isSameLocale(Locale locale, String str, String str2, String str3) {
        try {
            return locale.getLanguage().equals(str) && locale.getCountry().equals(str2) && locale.getVariant().equals(str3);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public Locale create(String str, String str2, String str3) {
        Locale locale = Locale.getDefault();
        if (isSameLocale(locale, str, str2, str3)) {
            return locale;
        }
        Locale locale2 = Locale.US;
        if (locale != locale2 && isSameLocale(locale2, str, str2, str3)) {
            return locale2;
        }
        Locale locale3 = Locale.ENGLISH;
        if (isSameLocale(locale3, str, str2, str3)) {
            return locale3;
        }
        if (isSameLocale(Locale.GERMAN, str, str2, str3)) {
            return Locale.GERMAN;
        }
        Locale locale4 = SPANISH;
        if (isSameLocale(locale4, str, str2, str3)) {
            return locale4;
        }
        if (isSameLocale(Locale.FRENCH, str, str2, str3)) {
            return Locale.FRENCH;
        }
        if (isSameLocale(Locale.ITALIAN, str, str2, str3)) {
            return Locale.ITALIAN;
        }
        if (isSameLocale(Locale.JAPANESE, str, str2, str3)) {
            return Locale.JAPANESE;
        }
        if (isSameLocale(Locale.KOREAN, str, str2, str3)) {
            return Locale.KOREAN;
        }
        if (isSameLocale(Locale.SIMPLIFIED_CHINESE, str, str2, str3)) {
            return Locale.SIMPLIFIED_CHINESE;
        }
        if (isSameLocale(Locale.CHINESE, str, str2, str3)) {
            return Locale.CHINESE;
        }
        if (isSameLocale(Locale.TRADITIONAL_CHINESE, str, str2, str3)) {
            return Locale.TRADITIONAL_CHINESE;
        }
        if (isSameLocale(Locale.UK, str, str2, str3)) {
            return Locale.UK;
        }
        if (isSameLocale(Locale.GERMANY, str, str2, str3)) {
            return Locale.GERMANY;
        }
        Locale locale5 = SPAIN;
        if (isSameLocale(locale5, str, str2, str3)) {
            return locale5;
        }
        if (isSameLocale(Locale.FRANCE, str, str2, str3)) {
            return Locale.FRANCE;
        }
        if (isSameLocale(Locale.ITALY, str, str2, str3)) {
            return Locale.ITALY;
        }
        if (isSameLocale(Locale.JAPAN, str, str2, str3)) {
            return Locale.JAPAN;
        }
        if (isSameLocale(Locale.KOREA, str, str2, str3)) {
            return Locale.KOREA;
        }
        if (isSameLocale(Locale.CANADA, str, str2, str3)) {
            return Locale.CANADA;
        }
        return isSameLocale(Locale.CANADA_FRENCH, str, str2, str3) ? Locale.CANADA_FRENCH : new Locale(str, str2, str3);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Locale read(Kryo kryo, Input input, Class<Locale> cls) {
        return read2(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Locale locale) {
        write2(kryo, output, locale);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Locale read2(Kryo kryo, Input input, Class<Locale> cls) {
        return create(input.readString(), input.readString(), input.readString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Locale locale) {
        output.writeAscii(locale.getLanguage());
        output.writeAscii(locale.getCountry());
        output.writeString(locale.getVariant());
    }
}
