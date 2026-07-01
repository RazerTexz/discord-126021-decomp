package com.discord.models.deserialization.gson;

import androidx.exifinterface.media.ExifInterface;
import b.a.b.a;
import b.i.d.c;
import b.i.d.e;
import com.discord.models.domain.Model$JsonReader;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import d0.z.d.m;

/* JADX INFO: compiled from: InboundGatewayGsonParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InboundGatewayGsonParser {
    public static final InboundGatewayGsonParser INSTANCE = new InboundGatewayGsonParser();
    private static final Gson gatewayGsonInstance;

    static {
        e eVar = new e();
        eVar.a = eVar.a.j(8);
        eVar.c = c.m;
        m.checkNotNullExpressionValue(eVar, "GsonBuilder()\n          …ER_CASE_WITH_UNDERSCORES)");
        a.a(eVar);
        gatewayGsonInstance = eVar.a();
    }

    private InboundGatewayGsonParser() {
    }

    public static final <T> T fromJson(Model$JsonReader reader, Class<T> clazz) {
        m.checkNotNullParameter(reader, "reader");
        m.checkNotNullParameter(clazz, "clazz");
        JsonReader jsonReader = reader.in;
        m.checkNotNullExpressionValue(jsonReader, "reader.`in`");
        return (T) fromJson(jsonReader, clazz);
    }

    public static final <T> String toJson(T source) {
        String strM = gatewayGsonInstance.m(source);
        m.checkNotNullExpressionValue(strM, "gatewayGsonInstance.toJson(source)");
        return strM;
    }

    public final Gson getGatewayGsonInstance() {
        return gatewayGsonInstance;
    }

    public static final <T> T fromJson(JsonReader reader, Class<T> clazz) {
        m.checkNotNullParameter(reader, "reader");
        m.checkNotNullParameter(clazz, "clazz");
        return (T) gatewayGsonInstance.d(reader, clazz);
    }
}
