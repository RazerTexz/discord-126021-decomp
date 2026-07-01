package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import b.i.d.TypeAdapterFactory2;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: renamed from: com.discord.nullserializable.NullSerializableTypeAdapterFactory, reason: use source file name */
/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializable3 implements TypeAdapterFactory2 {
    @Override // b.i.d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Intrinsics3.checkNotNullParameter(gson, "gson");
        Intrinsics3.checkNotNullParameter(type, "type");
        if (!NullSerializable.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        Type type2 = type.getType();
        Objects.requireNonNull(type2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        TypeAdapter<T> typeAdapterH = gson.h(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]));
        Intrinsics3.checkNotNullExpressionValue(typeAdapterH, "delegateTypeAdapter");
        return new NullSerializable2(gson, typeAdapterH);
    }
}
