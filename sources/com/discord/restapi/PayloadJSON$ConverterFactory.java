package com.discord.restapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.z.d.m;
import i0.e0.a.a;
import i0.e0.a.b;
import i0.h;
import i0.h$a;
import i0.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: PayloadJSON.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayloadJSON$ConverterFactory extends h$a {
    private final a gsonConverterFactory;

    public PayloadJSON$ConverterFactory(Gson gson) {
        m.checkNotNullParameter(gson, "gson");
        Objects.requireNonNull(gson, "gson == null");
        this.gsonConverterFactory = new a(gson);
    }

    @Override // i0.h$a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, y retrofit) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        m.checkNotNullParameter(methodAnnotations, "methodAnnotations");
        m.checkNotNullParameter(retrofit, "retrofit");
        if (!(type instanceof ParameterizedType)) {
            type = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType == null || (!m.areEqual(parameterizedType.getRawType(), PayloadJSON.class))) {
            return null;
        }
        Type type2 = parameterizedType.getActualTypeArguments()[0];
        a aVar = this.gsonConverterFactory;
        return new PayloadJSON$ConverterFactory$RequestBodyConverter(new b(aVar.a, aVar.a.h(TypeToken.get(type2))));
    }
}
