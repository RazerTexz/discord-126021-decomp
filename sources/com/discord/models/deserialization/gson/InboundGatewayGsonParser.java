package com.discord.models.deserialization.gson;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import p007b.p008a.p017b.C0850a;
import p007b.p225i.p408d.C4901e;
import p007b.p225i.p408d.EnumC4899c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InboundGatewayGsonParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InboundGatewayGsonParser {
    public static final InboundGatewayGsonParser INSTANCE = new InboundGatewayGsonParser();
    private static final Gson gatewayGsonInstance;

    static {
        C4901e c4901e = new C4901e();
        c4901e.f13095a = c4901e.f13095a.m9222j(8);
        c4901e.f13097c = EnumC4899c.f13091m;
        C12238m.checkNotNullExpressionValue(c4901e, "GsonBuilder()\n          …ER_CASE_WITH_UNDERSCORES)");
        C0850a.m147a(c4901e);
        gatewayGsonInstance = c4901e.m6851a();
    }

    private InboundGatewayGsonParser() {
    }

    public static final <T> T fromJson(Model.JsonReader reader, Class<T> clazz) {
        C12238m.checkNotNullParameter(reader, "reader");
        C12238m.checkNotNullParameter(clazz, "clazz");
        JsonReader jsonReader = reader.f18559in;
        C12238m.checkNotNullExpressionValue(jsonReader, "reader.`in`");
        return (T) fromJson(jsonReader, clazz);
    }

    public static final <T> String toJson(T source) {
        String strM9209m = gatewayGsonInstance.m9209m(source);
        C12238m.checkNotNullExpressionValue(strM9209m, "gatewayGsonInstance.toJson(source)");
        return strM9209m;
    }

    public final Gson getGatewayGsonInstance() {
        return gatewayGsonInstance;
    }

    public static final <T> T fromJson(JsonReader reader, Class<T> clazz) {
        C12238m.checkNotNullParameter(reader, "reader");
        C12238m.checkNotNullParameter(clazz, "clazz");
        return (T) gatewayGsonInstance.m9200d(reader, clazz);
    }
}
