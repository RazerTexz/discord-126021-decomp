package com.discord.models.deserialization.gson;

import androidx.exifinterface.media.ExifInterface;
import b.a.b.TypeAdapterRegistrar;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: InboundGatewayGsonParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InboundGatewayGsonParser {
    public static final InboundGatewayGsonParser INSTANCE = new InboundGatewayGsonParser();
    private static final Gson gatewayGsonInstance;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.a = gsonBuilder.a.j(8);
        gsonBuilder.c = FieldNamingPolicy.m;
        Intrinsics3.checkNotNullExpressionValue(gsonBuilder, "GsonBuilder()\n          …ER_CASE_WITH_UNDERSCORES)");
        TypeAdapterRegistrar.a(gsonBuilder);
        gatewayGsonInstance = gsonBuilder.a();
    }

    private InboundGatewayGsonParser() {
    }

    public static final <T> T fromJson(Model.JsonReader reader, Class<T> clazz) {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        JsonReader jsonReader = reader.in;
        Intrinsics3.checkNotNullExpressionValue(jsonReader, "reader.`in`");
        return (T) fromJson(jsonReader, clazz);
    }

    public static final <T> String toJson(T source) {
        String strM = gatewayGsonInstance.m(source);
        Intrinsics3.checkNotNullExpressionValue(strM, "gatewayGsonInstance.toJson(source)");
        return strM;
    }

    public final Gson getGatewayGsonInstance() {
        return gatewayGsonInstance;
    }

    public static final <T> T fromJson(JsonReader reader, Class<T> clazz) {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(clazz, "clazz");
        return (T) gatewayGsonInstance.d(reader, clazz);
    }
}
