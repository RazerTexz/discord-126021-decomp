package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import p007b.p225i.p408d.InterfaceC4911o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NullSerializableTypeAdapterFactory implements InterfaceC4911o {
    @Override // p007b.p225i.p408d.InterfaceC4911o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        C12238m.checkNotNullParameter(gson, "gson");
        C12238m.checkNotNullParameter(type, "type");
        if (!NullSerializable.class.isAssignableFrom(type.getRawType())) {
            return null;
        }
        Type type2 = type.getType();
        Objects.requireNonNull(type2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        TypeAdapter<T> typeAdapterM9204h = gson.m9204h(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]));
        C12238m.checkNotNullExpressionValue(typeAdapterM9204h, "delegateTypeAdapter");
        return new NullSerializableTypeAdapter(gson, typeAdapterM9204h);
    }
}
