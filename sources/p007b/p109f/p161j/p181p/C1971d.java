package p007b.p109f.p161j.p181p;

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
import p007b.p109f.p115d.p119d.C1684g;
import p007b.p109f.p161j.p169d.EnumC1883d;
import p007b.p109f.p161j.p170e.InterfaceC1896k;
import p007b.p109f.p161j.p175j.EnumC1920f;

/* JADX INFO: renamed from: b.f.j.p.d */
/* JADX INFO: compiled from: BaseProducerContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1971d implements InterfaceC2020x0 {

    /* JADX INFO: renamed from: a */
    public static final Set<String> f4025a;

    /* JADX INFO: renamed from: b */
    public final ImageRequest f4026b;

    /* JADX INFO: renamed from: c */
    public final String f4027c;

    /* JADX INFO: renamed from: d */
    public final String f4028d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2024z0 f4029e;

    /* JADX INFO: renamed from: f */
    public final Object f4030f;

    /* JADX INFO: renamed from: g */
    public final ImageRequest.EnumC10667c f4031g;

    /* JADX INFO: renamed from: h */
    public final Map<String, Object> f4032h;

    /* JADX INFO: renamed from: i */
    public boolean f4033i;

    /* JADX INFO: renamed from: j */
    public EnumC1883d f4034j;

    /* JADX INFO: renamed from: k */
    public boolean f4035k;

    /* JADX INFO: renamed from: l */
    public boolean f4036l;

    /* JADX INFO: renamed from: m */
    public final List<InterfaceC2022y0> f4037m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC1896k f4038n;

    static {
        String[] strArr = {ModelAuditLogEntry.CHANGE_KEY_ID, "uri_source"};
        int i = C1684g.f3093j;
        HashSet hashSet = new HashSet(2);
        Collections.addAll(hashSet, strArr);
        f4025a = new C1684g(hashSet);
    }

    public C1971d(ImageRequest imageRequest, String str, String str2, InterfaceC2024z0 interfaceC2024z0, Object obj, ImageRequest.EnumC10667c enumC10667c, boolean z2, boolean z3, EnumC1883d enumC1883d, InterfaceC1896k interfaceC1896k) {
        this.f4026b = imageRequest;
        this.f4027c = str;
        HashMap map = new HashMap();
        this.f4032h = map;
        map.put(ModelAuditLogEntry.CHANGE_KEY_ID, str);
        map.put("uri_source", imageRequest == null ? "null-request" : imageRequest.f19585c);
        this.f4028d = str2;
        this.f4029e = interfaceC2024z0;
        this.f4030f = obj;
        this.f4031g = enumC10667c;
        this.f4033i = z2;
        this.f4034j = enumC1883d;
        this.f4035k = z3;
        this.f4036l = false;
        this.f4037m = new ArrayList();
        this.f4038n = interfaceC1896k;
    }

    /* JADX INFO: renamed from: r */
    public static void m1440r(List<InterfaceC2022y0> list) {
        if (list == null) {
            return;
        }
        Iterator<InterfaceC2022y0> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo1439b();
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m1441s(List<InterfaceC2022y0> list) {
        if (list == null) {
            return;
        }
        Iterator<InterfaceC2022y0> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo1463d();
        }
    }

    /* JADX INFO: renamed from: t */
    public static void m1442t(List<InterfaceC2022y0> list) {
        if (list == null) {
            return;
        }
        Iterator<InterfaceC2022y0> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo1462c();
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: a */
    public Map<String, Object> mo1443a() {
        return this.f4032h;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: b */
    public Object mo1444b() {
        return this.f4030f;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: c */
    public synchronized EnumC1883d mo1445c() {
        return this.f4034j;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: d */
    public void mo1446d(String str, Object obj) {
        if (f4025a.contains(str)) {
            return;
        }
        this.f4032h.put(str, obj);
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: e */
    public ImageRequest mo1447e() {
        return this.f4026b;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: f */
    public void mo1448f(InterfaceC2022y0 interfaceC2022y0) {
        boolean z2;
        synchronized (this) {
            this.f4037m.add(interfaceC2022y0);
            z2 = this.f4036l;
        }
        if (z2) {
            interfaceC2022y0.mo1438a();
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: g */
    public InterfaceC1896k mo1449g() {
        return this.f4038n;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    public String getId() {
        return this.f4027c;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: h */
    public void mo1450h(EnumC1920f enumC1920f) {
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: i */
    public void mo1451i(String str, String str2) {
        this.f4032h.put("origin", str);
        this.f4032h.put("origin_sub", str2);
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: j */
    public void mo1452j(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            mo1446d(entry.getKey(), entry.getValue());
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: k */
    public synchronized boolean mo1453k() {
        return this.f4033i;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: l */
    public <T> T mo1454l(String str) {
        return (T) this.f4032h.get(str);
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: m */
    public String mo1455m() {
        return this.f4028d;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: n */
    public void mo1456n(String str) {
        this.f4032h.put("origin", str);
        this.f4032h.put("origin_sub", "default");
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: o */
    public InterfaceC2024z0 mo1457o() {
        return this.f4029e;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: p */
    public synchronized boolean mo1458p() {
        return this.f4035k;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2020x0
    /* JADX INFO: renamed from: q */
    public ImageRequest.EnumC10667c mo1459q() {
        return this.f4031g;
    }

    /* JADX INFO: renamed from: u */
    public void m1460u() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.f4036l) {
                arrayList = null;
            } else {
                this.f4036l = true;
                arrayList = new ArrayList(this.f4037m);
            }
        }
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC2022y0) it.next()).mo1438a();
        }
    }

    /* JADX INFO: renamed from: v */
    public synchronized List<InterfaceC2022y0> m1461v(EnumC1883d enumC1883d) {
        if (enumC1883d == this.f4034j) {
            return null;
        }
        this.f4034j = enumC1883d;
        return new ArrayList(this.f4037m);
    }
}
