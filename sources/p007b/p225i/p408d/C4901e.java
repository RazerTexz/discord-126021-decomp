package p007b.p225i.p408d;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.d.e */
/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4901e {

    /* JADX INFO: renamed from: a */
    public Excluder f13095a = Excluder.f21483j;

    /* JADX INFO: renamed from: b */
    public EnumC4910n f13096b = EnumC4910n.f13108j;

    /* JADX INFO: renamed from: c */
    public InterfaceC4900d f13097c = EnumC4899c.f13088j;

    /* JADX INFO: renamed from: d */
    public final Map<Type, InterfaceC4902f<?>> f13098d = new HashMap();

    /* JADX INFO: renamed from: e */
    public final List<InterfaceC4911o> f13099e = new ArrayList();

    /* JADX INFO: renamed from: f */
    public final List<InterfaceC4911o> f13100f = new ArrayList();

    /* JADX INFO: renamed from: g */
    public boolean f13101g = false;

    /* JADX INFO: renamed from: h */
    public int f13102h = 2;

    /* JADX INFO: renamed from: i */
    public int f13103i = 2;

    /* JADX INFO: renamed from: j */
    public boolean f13104j = true;

    /* JADX INFO: renamed from: a */
    public Gson m6851a() {
        ArrayList arrayList = new ArrayList(this.f13100f.size() + this.f13099e.size() + 3);
        arrayList.addAll(this.f13099e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f13100f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        int i = this.f13102h;
        int i2 = this.f13103i;
        if (i != 2 && i2 != 2) {
            DefaultDateTypeAdapter defaultDateTypeAdapter = new DefaultDateTypeAdapter(Date.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            TypeAdapter<Class> typeAdapter = TypeAdapters.f21582a;
            arrayList.add(new TypeAdapters.C1113932(Date.class, defaultDateTypeAdapter));
            arrayList.add(new TypeAdapters.C1113932(Timestamp.class, defaultDateTypeAdapter2));
            arrayList.add(new TypeAdapters.C1113932(java.sql.Date.class, defaultDateTypeAdapter3));
        }
        return new Gson(this.f13095a, this.f13097c, this.f13098d, this.f13101g, false, false, this.f13104j, false, false, false, this.f13096b, null, this.f13102h, this.f13103i, this.f13099e, this.f13100f, arrayList);
    }

    /* JADX INFO: renamed from: b */
    public C4901e m6852b(Type type, Object obj) {
        boolean z2 = obj instanceof InterfaceC4909m;
        C3404f.m4355w(z2 || (obj instanceof InterfaceC4905i) || (obj instanceof InterfaceC4902f) || (obj instanceof TypeAdapter));
        if (obj instanceof InterfaceC4902f) {
            this.f13098d.put(type, (InterfaceC4902f) obj);
        }
        if (z2 || (obj instanceof InterfaceC4905i)) {
            TypeToken<?> typeToken = TypeToken.get(type);
            this.f13099e.add(new TreeTypeAdapter.SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null));
        }
        if (obj instanceof TypeAdapter) {
            List<InterfaceC4911o> list = this.f13099e;
            final TypeToken<?> typeToken2 = TypeToken.get(type);
            final TypeAdapter typeAdapter = (TypeAdapter) obj;
            TypeAdapter<Class> typeAdapter2 = TypeAdapters.f21582a;
            list.add(new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TypeAdapters.31

                /* JADX INFO: renamed from: k */
                public final /* synthetic */ TypeAdapter f21610k;

                public C1113831() {
                    typeAdapter = typeAdapter;
                }

                @Override // p007b.p225i.p408d.InterfaceC4911o
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
