package com.google.gson.internal.bind;

import b.i.d.i;
import b.i.d.m;
import b.i.d.o;
import b.i.d.p.a;
import b.i.d.q.g;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements o {
    public final g j;

    public JsonAdapterAnnotationTypeAdapterFactory(g gVar) {
        this.j = gVar;
    }

    public TypeAdapter<?> a(g gVar, Gson gson, TypeToken<?> typeToken, a aVar) {
        TypeAdapter<?> treeTypeAdapter;
        Object objA = gVar.a(TypeToken.get((Class) aVar.value())).a();
        if (objA instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objA;
        } else if (objA instanceof o) {
            treeTypeAdapter = ((o) objA).create(gson, typeToken);
        } else {
            boolean z2 = objA instanceof m;
            if (!z2 && !(objA instanceof i)) {
                StringBuilder sbU = b.d.b.a.a.U("Invalid attempt to bind an instance of ");
                sbU.append(objA.getClass().getName());
                sbU.append(" as a @JsonAdapter for ");
                sbU.append(typeToken.toString());
                sbU.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(sbU.toString());
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z2 ? (m) objA : null, objA instanceof i ? (i) objA : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !aVar.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        a aVar = (a) typeToken.getRawType().getAnnotation(a.class);
        if (aVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.j, gson, typeToken, aVar);
    }
}
