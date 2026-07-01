package b.g.a.b.q;

import b.g.a.b.g;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashSet;

/* JADX INFO: compiled from: JsonWriteContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends g {
    public final c c;
    public a d;
    public c e;
    public String f;
    public Object g;
    public boolean h;

    public c(int i, c cVar, a aVar) {
        this.a = i;
        this.c = cVar;
        this.d = aVar;
        this.f661b = -1;
    }

    @Override // b.g.a.b.g
    public final String a() {
        return this.f;
    }

    @Override // b.g.a.b.g
    public void d(Object obj) {
        this.g = obj;
    }

    public c f() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.j(1);
            return cVar;
        }
        a aVar = this.d;
        c cVar2 = new c(1, this, aVar == null ? null : aVar.a());
        this.e = cVar2;
        return cVar2;
    }

    public c g(Object obj) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.k(1, obj);
            return cVar;
        }
        a aVar = this.d;
        c cVar2 = new c(1, this, aVar == null ? null : aVar.a(), obj);
        this.e = cVar2;
        return cVar2;
    }

    public c h() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.j(2);
            return cVar;
        }
        a aVar = this.d;
        c cVar2 = new c(2, this, aVar == null ? null : aVar.a());
        this.e = cVar2;
        return cVar2;
    }

    public c i(Object obj) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.k(2, obj);
            return cVar;
        }
        a aVar = this.d;
        c cVar2 = new c(2, this, aVar == null ? null : aVar.a(), obj);
        this.e = cVar2;
        return cVar2;
    }

    public c j(int i) {
        this.a = i;
        this.f661b = -1;
        this.f = null;
        this.h = false;
        this.g = null;
        a aVar = this.d;
        if (aVar != null) {
            aVar.f670b = null;
            aVar.c = null;
            aVar.d = null;
        }
        return this;
    }

    public c k(int i, Object obj) {
        this.a = i;
        this.f661b = -1;
        this.f = null;
        this.h = false;
        this.g = obj;
        a aVar = this.d;
        if (aVar != null) {
            aVar.f670b = null;
            aVar.c = null;
            aVar.d = null;
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    public int l(String str) throws JsonProcessingException {
        boolean z2;
        Object obj;
        b.g.a.b.d dVar;
        if (this.a != 2 || this.h) {
            return 4;
        }
        this.h = true;
        this.f = str;
        a aVar = this.d;
        if (aVar != null) {
            String str2 = aVar.f670b;
            if (str2 == null) {
                aVar.f670b = str;
            } else {
                if (str.equals(str2)) {
                    z2 = true;
                } else {
                    String str3 = aVar.c;
                    if (str3 == null) {
                        aVar.c = str;
                    } else if (str.equals(str3)) {
                        z2 = true;
                    } else {
                        if (aVar.d == null) {
                            HashSet<String> hashSet = new HashSet<>(16);
                            aVar.d = hashSet;
                            hashSet.add(aVar.f670b);
                            aVar.d.add(aVar.c);
                        }
                        z2 = !aVar.d.add(str);
                    }
                }
                if (z2) {
                    obj = aVar.a;
                    String strY = b.d.b.a.a.y("Duplicate field '", str, "'");
                    if (obj instanceof b.g.a.b.d) {
                        dVar = (b.g.a.b.d) obj;
                    } else {
                        dVar = null;
                    }
                    throw new JsonGenerationException(strY, dVar);
                }
            }
            z2 = false;
            if (z2) {
                obj = aVar.a;
                String strY2 = b.d.b.a.a.y("Duplicate field '", str, "'");
                if (obj instanceof b.g.a.b.d) {
                    dVar = (b.g.a.b.d) obj;
                } else {
                    dVar = null;
                }
                throw new JsonGenerationException(strY2, dVar);
            }
        }
        return this.f661b < 0 ? 0 : 1;
    }

    public int m() {
        int i = this.a;
        if (i == 2) {
            if (!this.h) {
                return 5;
            }
            this.h = false;
            this.f661b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.f661b;
            this.f661b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i3 = this.f661b + 1;
        this.f661b = i3;
        return i3 == 0 ? 0 : 3;
    }

    public c(int i, c cVar, a aVar, Object obj) {
        this.a = i;
        this.c = cVar;
        this.d = aVar;
        this.f661b = -1;
        this.g = obj;
    }
}
