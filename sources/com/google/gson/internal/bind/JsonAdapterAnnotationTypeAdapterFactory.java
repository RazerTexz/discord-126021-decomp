package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.InterfaceC4905i;
import p007b.p225i.p408d.InterfaceC4909m;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p409p.InterfaceC4912a;
import p007b.p225i.p408d.p410q.C4922g;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements InterfaceC4911o {

    /* JADX INFO: renamed from: j */
    public final C4922g f21518j;

    public JsonAdapterAnnotationTypeAdapterFactory(C4922g c4922g) {
        this.f21518j = c4922g;
    }

    /* JADX INFO: renamed from: a */
    public TypeAdapter<?> m9232a(C4922g c4922g, Gson gson, TypeToken<?> typeToken, InterfaceC4912a interfaceC4912a) {
        TypeAdapter<?> treeTypeAdapter;
        Object objMo6869a = c4922g.m6870a(TypeToken.get((Class) interfaceC4912a.value())).mo6869a();
        if (objMo6869a instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objMo6869a;
        } else if (objMo6869a instanceof InterfaceC4911o) {
            treeTypeAdapter = ((InterfaceC4911o) objMo6869a).create(gson, typeToken);
        } else {
            boolean z2 = objMo6869a instanceof InterfaceC4909m;
            if (!z2 && !(objMo6869a instanceof InterfaceC4905i)) {
                StringBuilder sbM833U = C1643a.m833U("Invalid attempt to bind an instance of ");
                sbM833U.append(objMo6869a.getClass().getName());
                sbM833U.append(" as a @JsonAdapter for ");
                sbM833U.append(typeToken.toString());
                sbM833U.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(sbM833U.toString());
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z2 ? (InterfaceC4909m) objMo6869a : null, objMo6869a instanceof InterfaceC4905i ? (InterfaceC4905i) objMo6869a : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !interfaceC4912a.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }

    @Override // p007b.p225i.p408d.InterfaceC4911o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        InterfaceC4912a interfaceC4912a = (InterfaceC4912a) typeToken.getRawType().getAnnotation(InterfaceC4912a.class);
        if (interfaceC4912a == null) {
            return null;
        }
        return (TypeAdapter<T>) m9232a(this.f21518j, gson, typeToken, interfaceC4912a);
    }
}
