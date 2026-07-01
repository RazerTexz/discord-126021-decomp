package b.i.d;

import com.google.gson.DefaultDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter$SingleTypeFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.bind.TypeAdapters$31;
import com.google.gson.internal.bind.TypeAdapters$32;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public Excluder a = Excluder.j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f1806b = n.j;
    public d c = c.j;
    public final Map<Type, f<?>> d = new HashMap();
    public final List<o> e = new ArrayList();
    public final List<o> f = new ArrayList();
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
            arrayList.add(new TypeAdapters$32(Date.class, defaultDateTypeAdapter));
            arrayList.add(new TypeAdapters$32(Timestamp.class, defaultDateTypeAdapter2));
            arrayList.add(new TypeAdapters$32(java.sql.Date.class, defaultDateTypeAdapter3));
        }
        return new Gson(this.a, this.c, this.d, this.g, false, false, this.j, false, false, false, this.f1806b, null, this.h, this.i, this.e, this.f, arrayList);
    }

    public e b(Type type, Object obj) {
        boolean z2 = obj instanceof m;
        b.i.a.f.e.o.f.w(z2 || (obj instanceof i) || (obj instanceof f) || (obj instanceof TypeAdapter));
        if (obj instanceof f) {
            this.d.put(type, (f) obj);
        }
        if (z2 || (obj instanceof i)) {
            TypeToken<?> typeToken = TypeToken.get(type);
            this.e.add(new TreeTypeAdapter$SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null));
        }
        if (obj instanceof TypeAdapter) {
            List<o> list = this.e;
            TypeAdapter<Class> typeAdapter = TypeAdapters.a;
            list.add(new TypeAdapters$31(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }
}
