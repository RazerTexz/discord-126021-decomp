package b.i.d;

import com.google.gson.DefaultDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.d.e, reason: use source file name */
/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonBuilder {
    public Excluder a = Excluder.j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LongSerializationPolicy f1806b = LongSerializationPolicy.j;
    public FieldNamingStrategy c = FieldNamingPolicy.j;
    public final Map<Type, InstanceCreator<?>> d = new HashMap();
    public final List<TypeAdapterFactory2> e = new ArrayList();
    public final List<TypeAdapterFactory2> f = new ArrayList();
    public boolean g = false;
    public int h = 2;
    public int i = 2;
    public boolean j = true;

    public Gson a() {
        ArrayList arrayList = new ArrayList(this.f.size() + this.e.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        int i = this.h;
        int i2 = this.i;
        if (i != 2 && i2 != 2) {
            DefaultDateTypeAdapter defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            TypeAdapter<Class> typeAdapter = TypeAdapters.a;
            arrayList.add(new TypeAdapters.AnonymousClass32(Date.class, defaultDateTypeAdapter));
            arrayList.add(new TypeAdapters.AnonymousClass32(Timestamp.class, defaultDateTypeAdapter2));
            arrayList.add(new TypeAdapters.AnonymousClass32(java.sql.Date.class, defaultDateTypeAdapter3));
        }
        return new Gson(this.a, this.c, this.d, this.g, false, false, this.j, false, false, false, this.f1806b, null, this.h, this.i, this.e, this.f, arrayList);
    }

    public GsonBuilder b(Type type, Object obj) {
        boolean z2 = obj instanceof JsonSerializer2;
        b.i.a.f.e.o.f.w(z2 || (obj instanceof JsonDeserializer2) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.d.put(type, (InstanceCreator) obj);
        }
        if (z2 || (obj instanceof JsonDeserializer2)) {
            TypeToken<?> typeToken = TypeToken.get(type);
            this.e.add(new TreeTypeAdapter.SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null));
        }
        if (obj instanceof TypeAdapter) {
            List<TypeAdapterFactory2> list = this.e;
            final TypeToken<?> typeToken2 = TypeToken.get(type);
            final TypeAdapter typeAdapter = (TypeAdapter) obj;
            TypeAdapter<Class> typeAdapter2 = TypeAdapters.a;
            list.add(new TypeAdapterFactory2() { // from class: com.google.gson.internal.bind.TypeAdapters.31
                public final /* synthetic */ TypeAdapter k;

                public AnonymousClass31() {
                    typeAdapter = typeAdapter;
                }

                @Override // b.i.d.TypeAdapterFactory2
                public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken3) {
                    if (typeToken3.equals(typeToken)) {
                        return typeAdapter;
                    }
                    return null;
                }
            });
        }
        return this;
    }
}
