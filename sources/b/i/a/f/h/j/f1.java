package b.i.a.f.h.j;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends b.i.a.f.b.e<f1> {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1416b;
    public String c;
    public String d;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.a);
        map.put("appVersion", this.f1416b);
        map.put("appId", this.c);
        map.put("appInstallerId", this.d);
        return b.i.a.f.b.e.a(map, 0);
    }
}
