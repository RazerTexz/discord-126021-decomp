package com.discord.api.science;

import com.discord.api.science.Science;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import p007b.p225i.p408d.C4901e;
import p007b.p225i.p408d.EnumC4899c;
import p007b.p225i.p408d.InterfaceC4908l;
import p007b.p225i.p408d.InterfaceC4909m;
import p007b.p225i.p408d.p410q.p411x.C4940b;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AnalyticsSchemaTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsSchemaTypeAdapter implements InterfaceC4909m<Science.Event.SchemaObject> {
    private final Gson gson;

    public AnalyticsSchemaTypeAdapter() {
        C4901e c4901e = new C4901e();
        c4901e.f13097c = EnumC4899c.f13091m;
        this.gson = c4901e.m6851a();
    }

    /* JADX INFO: renamed from: a */
    public final List<Pair<String, Object>> m8214a(Map<String, ? extends Object> map) {
        List<Pair<String, Object>> listListOf;
        C12238m.checkNotNullParameter(map, "$this$flatMapProperties");
        Set<Map.Entry<String, ? extends Object>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (!(value instanceof Map)) {
                value = null;
            }
            Map<String, ? extends Object> map2 = (Map) value;
            if (map2 == null || (listListOf = m8214a(map2)) == null) {
                listListOf = C12145m.listOf(new Pair(entry.getKey(), entry.getValue()));
            }
            C12160r.addAll(arrayList, listListOf);
        }
        return arrayList;
    }

    @Override // p007b.p225i.p408d.InterfaceC4909m
    public JsonElement serialize(Science.Event.SchemaObject schemaObject, Type type, InterfaceC4908l interfaceC4908l) {
        Science.Event.SchemaObject schemaObject2 = schemaObject;
        C12238m.checkNotNullParameter(schemaObject2, "src");
        C12238m.checkNotNullParameter(type, "typeOfSrc");
        C12238m.checkNotNullParameter(interfaceC4908l, "context");
        Gson gson = this.gson;
        String type2 = schemaObject2.getType();
        AnalyticsSchema schema = schemaObject2.getSchema();
        C12238m.checkNotNullParameter(schema, "$this$serializeToMap");
        Object objM9203g = this.gson.m9203g(this.gson.m9209m(schema), new TypeToken<Map<String, ? extends Object>>() { // from class: com.discord.api.science.AnalyticsSchemaTypeAdapter$serializeToMap$1
        }.getType());
        C12238m.checkNotNullExpressionValue(objM9203g, "gson.fromJson(json, obje…<String, Any>>() {}.type)");
        Science.Event.MapObject mapObject = new Science.Event.MapObject(type2, C12136h0.toMap(m8214a((Map) objM9203g)));
        Objects.requireNonNull(gson);
        C4940b c4940b = new C4940b();
        gson.m9211o(mapObject, Science.Event.MapObject.class, c4940b);
        JsonElement jsonElementM6897L = c4940b.m6897L();
        C12238m.checkNotNullExpressionValue(jsonElementM6897L, "gson.toJsonTree(\n       …).toMap()\n        )\n    )");
        return jsonElementM6897L;
    }
}
