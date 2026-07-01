package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import d0.z.d.m;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializableTypeAdapterFactory implements o {
    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        m.checkNotNullParameter(gson, "gson");
        m.checkNotNullParameter(type, "type");
        if (!NullSerializable.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        Type type2 = type.getType();
        Objects.requireNonNull(type2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        TypeAdapter<T> typeAdapterH = gson.h(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]));
        m.checkNotNullExpressionValue(typeAdapterH, "delegateTypeAdapter");
        return new NullSerializableTypeAdapter(gson, typeAdapterH);
    }
}
