package b.f.j.p;

import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest$c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: BaseProducerContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements x0 {
    public static final Set<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRequest f609b;
    public final String c;
    public final String d;
    public final z0 e;
    public final Object f;
    public final ImageRequest$c g;
    public final Map<String, Object> h;
    public boolean i;
    public b.f.j.d.d j;
    public boolean k;
    public boolean l;
    public final List<y0> m;
    public final b.f.j.e.k n;

    static {
        String[] strArr = {ModelAuditLogEntry.CHANGE_KEY_ID, "uri_source"};
        int i = b.f.d.d.g.j;
        HashSet hashSet = new HashSet(2);
        Collections.addAll(hashSet, strArr);
        a = new b.f.d.d.g(hashSet);
    }

    public d(ImageRequest imageRequest, String str, String str2, z0 z0Var, Object obj, ImageRequest$c imageRequest$c, boolean z2, boolean z3, b.f.j.d.d dVar, b.f.j.e.k kVar) {
        this.f609b = imageRequest;
        this.c = str;
        HashMap map = new HashMap();
        this.h = map;
        map.put(ModelAuditLogEntry.CHANGE_KEY_ID, str);
        map.put("uri_source", imageRequest == null ? "null-request" : imageRequest.c);
        this.d = str2;
        this.e = z0Var;
        this.f = obj;
        this.g = imageRequest$c;
        this.i = z2;
        this.j = dVar;
        this.k = z3;
        this.l = false;
        this.m = new ArrayList();
        this.n = kVar;
    }

    public static void r(List<y0> list) {
        if (list == null) {
            return;
        }
        Iterator<y0> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public static void s(List<y0> list) {
        if (list == null) {
            return;
        }
        Iterator<y0> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public static void t(List<y0> list) {
        if (list == null) {
            return;
        }
        Iterator<y0> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // b.f.j.p.x0
    public Map<String, Object> a() {
        return this.h;
    }

    @Override // b.f.j.p.x0
    public Object b() {
        return this.f;
    }

    @Override // b.f.j.p.x0
    public synchronized b.f.j.d.d c() {
        return this.j;
    }

    @Override // b.f.j.p.x0
    public void d(String str, Object obj) {
        if (a.contains(str)) {
            return;
        }
        this.h.put(str, obj);
    }

    @Override // b.f.j.p.x0
    public ImageRequest e() {
        return this.f609b;
    }

    @Override // b.f.j.p.x0
    public void f(y0 y0Var) {
        boolean z2;
        synchronized (this) {
            this.m.add(y0Var);
            z2 = this.l;
        }
        if (z2) {
            y0Var.a();
        }
    }

    @Override // b.f.j.p.x0
    public b.f.j.e.k g() {
        return this.n;
    }

    @Override // b.f.j.p.x0
    public String getId() {
        return this.c;
    }

    @Override // b.f.j.p.x0
    public void h(b.f.j.j.f fVar) {
    }

    @Override // b.f.j.p.x0
    public void i(String str, String str2) {
        this.h.put("origin", str);
        this.h.put("origin_sub", str2);
    }

    @Override // b.f.j.p.x0
    public void j(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map$Entry<String, ?> map$Entry : map.entrySet()) {
            d(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    @Override // b.f.j.p.x0
    public synchronized boolean k() {
        return this.i;
    }

    @Override // b.f.j.p.x0
    public <T> T l(String str) {
        return (T) this.h.get(str);
    }

    @Override // b.f.j.p.x0
    public String m() {
        return this.d;
    }

    @Override // b.f.j.p.x0
    public void n(String str) {
        this.h.put("origin", str);
        this.h.put("origin_sub", "default");
    }

    @Override // b.f.j.p.x0
    public z0 o() {
        return this.e;
    }

    @Override // b.f.j.p.x0
    public synchronized boolean p() {
        return this.k;
    }

    @Override // b.f.j.p.x0
    public ImageRequest$c q() {
        return this.g;
    }

    public void u() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.l) {
                arrayList = null;
            } else {
                this.l = true;
                arrayList = new ArrayList(this.m);
            }
        }
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((y0) it.next()).a();
        }
    }

    public synchronized List<y0> v(b.f.j.d.d dVar) {
        if (dVar == this.j) {
            return null;
        }
        this.j = dVar;
        return new ArrayList(this.m);
    }
}
