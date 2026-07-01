package com.google.gson.internal.bind;

import b.d.b.a.outline;
import b.i.d.JsonDeserializer2;
import b.i.d.JsonSerializer2;
import b.i.d.TypeAdapterFactory2;
import b.i.d.p.JsonAdapter;
import b.i.d.q.g;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory2 {
    public final g j;

    public JsonAdapterAnnotationTypeAdapterFactory(g gVar) {
        this.j = gVar;
    }

    public TypeAdapter<?> a(g gVar, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> treeTypeAdapter;
        Object objA = gVar.a(TypeToken.get((Class) jsonAdapter.value())).a();
        if (objA instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objA;
        } else if (objA instanceof TypeAdapterFactory2) {
            treeTypeAdapter = ((TypeAdapterFactory2) objA).create(gson, typeToken);
        } else {
            boolean z2 = objA instanceof JsonSerializer2;
            if (!z2 && !(objA instanceof JsonDeserializer2)) {
                StringBuilder sbU = outline.U("Invalid attempt to bind an instance of ");
                sbU.append(objA.getClass().getName());
                sbU.append(" as a @JsonAdapter for ");
                sbU.append(typeToken.toString());
                sbU.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(sbU.toString());
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z2 ? (JsonSerializer2) objA : null, objA instanceof JsonDeserializer2 ? (JsonDeserializer2) objA : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // b.i.d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.j, gson, typeToken, jsonAdapter);
    }
}
