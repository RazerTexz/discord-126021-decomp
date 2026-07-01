package b.f.j.p;

import b.f.d.d.ImmutableSet;
import b.f.j.d.Priority2;
import b.f.j.e.ImagePipelineConfigInterface;
import b.f.j.j.EncodedImageOrigin;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.p.d, reason: use source file name */
/* JADX INFO: compiled from: BaseProducerContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class BaseProducerContext implements ProducerContext {
    public static final Set<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRequest f609b;
    public final String c;
    public final String d;
    public final ProducerListener2 e;
    public final Object f;
    public final ImageRequest.c g;
    public final Map<String, Object> h;
    public boolean i;
    public Priority2 j;
    public boolean k;
    public boolean l;
    public final List<ProducerContextCallbacks> m;
    public final ImagePipelineConfigInterface n;

    static {
        String[] strArr = {ModelAuditLogEntry.CHANGE_KEY_ID, "uri_source"};
        int i = ImmutableSet.j;
        HashSet hashSet = new HashSet(2);
        Collections.addAll(hashSet, strArr);
        a = new ImmutableSet(hashSet);
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.c cVar, boolean z2, boolean z3, Priority2 priority2, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.f609b = imageRequest;
        this.c = str;
        HashMap map = new HashMap();
        this.h = map;
        map.put(ModelAuditLogEntry.CHANGE_KEY_ID, str);
        map.put("uri_source", imageRequest == null ? "null-request" : imageRequest.c);
        this.d = str2;
        this.e = producerListener2;
        this.f = obj;
        this.g = cVar;
        this.i = z2;
        this.j = priority2;
        this.k = z3;
        this.l = false;
        this.m = new ArrayList();
        this.n = imagePipelineConfigInterface;
    }

    public static void r(List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public static void s(List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public static void t(List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // b.f.j.p.ProducerContext
    public Map<String, Object> a() {
        return this.h;
    }

    @Override // b.f.j.p.ProducerContext
    public Object b() {
        return this.f;
    }

    @Override // b.f.j.p.ProducerContext
    public synchronized Priority2 c() {
        return this.j;
    }

    @Override // b.f.j.p.ProducerContext
    public void d(String str, Object obj) {
        if (a.contains(str)) {
            return;
        }
        this.h.put(str, obj);
    }

    @Override // b.f.j.p.ProducerContext
    public ImageRequest e() {
        return this.f609b;
    }

    @Override // b.f.j.p.ProducerContext
    public void f(ProducerContextCallbacks producerContextCallbacks) {
        boolean z2;
        synchronized (this) {
            this.m.add(producerContextCallbacks);
            z2 = this.l;
        }
        if (z2) {
            producerContextCallbacks.a();
        }
    }

    @Override // b.f.j.p.ProducerContext
    public ImagePipelineConfigInterface g() {
        return this.n;
    }

    @Override // b.f.j.p.ProducerContext
    public String getId() {
        return this.c;
    }

    @Override // b.f.j.p.ProducerContext
    public void h(EncodedImageOrigin encodedImageOrigin) {
    }

    @Override // b.f.j.p.ProducerContext
    public void i(String str, String str2) {
        this.h.put("origin", str);
        this.h.put("origin_sub", str2);
    }

    @Override // b.f.j.p.ProducerContext
    public void j(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            d(entry.getKey(), entry.getValue());
        }
    }

    @Override // b.f.j.p.ProducerContext
    public synchronized boolean k() {
        return this.i;
    }

    @Override // b.f.j.p.ProducerContext
    public <T> T l(String str) {
        return (T) this.h.get(str);
    }

    @Override // b.f.j.p.ProducerContext
    public String m() {
        return this.d;
    }

    @Override // b.f.j.p.ProducerContext
    public void n(String str) {
        this.h.put("origin", str);
        this.h.put("origin_sub", "default");
    }

    @Override // b.f.j.p.ProducerContext
    public ProducerListener2 o() {
        return this.e;
    }

    @Override // b.f.j.p.ProducerContext
    public synchronized boolean p() {
        return this.k;
    }

    @Override // b.f.j.p.ProducerContext
    public ImageRequest.c q() {
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
            ((ProducerContextCallbacks) it.next()).a();
        }
    }

    public synchronized List<ProducerContextCallbacks> v(Priority2 priority2) {
        if (priority2 == this.j) {
            return null;
        }
        this.j = priority2;
        return new ArrayList(this.m);
    }
}
