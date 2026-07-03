package p007b.p195g.p196a.p198b.p201q;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashSet;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2111g;

/* JADX INFO: renamed from: b.g.a.b.q.c */
/* JADX INFO: compiled from: JsonWriteContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2133c extends AbstractC2111g {

    /* JADX INFO: renamed from: c */
    public final C2133c f4570c;

    /* JADX INFO: renamed from: d */
    public C2131a f4571d;

    /* JADX INFO: renamed from: e */
    public C2133c f4572e;

    /* JADX INFO: renamed from: f */
    public String f4573f;

    /* JADX INFO: renamed from: g */
    public Object f4574g;

    /* JADX INFO: renamed from: h */
    public boolean f4575h;

    public C2133c(int i, C2133c c2133c, C2131a c2131a) {
        this.f4503a = i;
        this.f4570c = c2133c;
        this.f4571d = c2131a;
        this.f4504b = -1;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2111g
    /* JADX INFO: renamed from: a */
    public final String mo1673a() {
        return this.f4573f;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2111g
    /* JADX INFO: renamed from: d */
    public void mo1676d(Object obj) {
        this.f4574g = obj;
    }

    /* JADX INFO: renamed from: f */
    public C2133c m1706f() {
        C2133c c2133c = this.f4572e;
        if (c2133c != null) {
            c2133c.m1710j(1);
            return c2133c;
        }
        C2131a c2131a = this.f4571d;
        C2133c c2133c2 = new C2133c(1, this, c2131a == null ? null : c2131a.m1703a());
        this.f4572e = c2133c2;
        return c2133c2;
    }

    /* JADX INFO: renamed from: g */
    public C2133c m1707g(Object obj) {
        C2133c c2133c = this.f4572e;
        if (c2133c != null) {
            c2133c.m1711k(1, obj);
            return c2133c;
        }
        C2131a c2131a = this.f4571d;
        C2133c c2133c2 = new C2133c(1, this, c2131a == null ? null : c2131a.m1703a(), obj);
        this.f4572e = c2133c2;
        return c2133c2;
    }

    /* JADX INFO: renamed from: h */
    public C2133c m1708h() {
        C2133c c2133c = this.f4572e;
        if (c2133c != null) {
            c2133c.m1710j(2);
            return c2133c;
        }
        C2131a c2131a = this.f4571d;
        C2133c c2133c2 = new C2133c(2, this, c2131a == null ? null : c2131a.m1703a());
        this.f4572e = c2133c2;
        return c2133c2;
    }

    /* JADX INFO: renamed from: i */
    public C2133c m1709i(Object obj) {
        C2133c c2133c = this.f4572e;
        if (c2133c != null) {
            c2133c.m1711k(2, obj);
            return c2133c;
        }
        C2131a c2131a = this.f4571d;
        C2133c c2133c2 = new C2133c(2, this, c2131a == null ? null : c2131a.m1703a(), obj);
        this.f4572e = c2133c2;
        return c2133c2;
    }

    /* JADX INFO: renamed from: j */
    public C2133c m1710j(int i) {
        this.f4503a = i;
        this.f4504b = -1;
        this.f4573f = null;
        this.f4575h = false;
        this.f4574g = null;
        C2131a c2131a = this.f4571d;
        if (c2131a != null) {
            c2131a.f4561b = null;
            c2131a.f4562c = null;
            c2131a.f4563d = null;
        }
        return this;
    }

    /* JADX INFO: renamed from: k */
    public C2133c m1711k(int i, Object obj) {
        this.f4503a = i;
        this.f4504b = -1;
        this.f4573f = null;
        this.f4575h = false;
        this.f4574g = obj;
        C2131a c2131a = this.f4571d;
        if (c2131a != null) {
            c2131a.f4561b = null;
            c2131a.f4562c = null;
            c2131a.f4563d = null;
        }
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX INFO: renamed from: l */
    public int m1712l(String str) throws JsonProcessingException {
        boolean z2;
        Object obj;
        AbstractC2108d abstractC2108d;
        if (this.f4503a != 2 || this.f4575h) {
            return 4;
        }
        this.f4575h = true;
        this.f4573f = str;
        C2131a c2131a = this.f4571d;
        if (c2131a != null) {
            String str2 = c2131a.f4561b;
            if (str2 == null) {
                c2131a.f4561b = str;
            } else {
                if (str.equals(str2)) {
                    z2 = true;
                } else {
                    String str3 = c2131a.f4562c;
                    if (str3 == null) {
                        c2131a.f4562c = str;
                    } else if (str.equals(str3)) {
                        z2 = true;
                    } else {
                        if (c2131a.f4563d == null) {
                            HashSet<String> hashSet = new HashSet<>(16);
                            c2131a.f4563d = hashSet;
                            hashSet.add(c2131a.f4561b);
                            c2131a.f4563d.add(c2131a.f4562c);
                        }
                        z2 = !c2131a.f4563d.add(str);
                    }
                }
                if (z2) {
                    obj = c2131a.f4560a;
                    String strM886y = C1643a.m886y("Duplicate field '", str, "'");
                    if (obj instanceof AbstractC2108d) {
                        abstractC2108d = (AbstractC2108d) obj;
                    } else {
                        abstractC2108d = null;
                    }
                    throw new JsonGenerationException(strM886y, abstractC2108d);
                }
            }
            z2 = false;
            if (z2) {
                obj = c2131a.f4560a;
                String strM886y2 = C1643a.m886y("Duplicate field '", str, "'");
                if (obj instanceof AbstractC2108d) {
                    abstractC2108d = (AbstractC2108d) obj;
                } else {
                    abstractC2108d = null;
                }
                throw new JsonGenerationException(strM886y2, abstractC2108d);
            }
        }
        return this.f4504b < 0 ? 0 : 1;
    }

    /* JADX INFO: renamed from: m */
    public int m1713m() {
        int i = this.f4503a;
        if (i == 2) {
            if (!this.f4575h) {
                return 5;
            }
            this.f4575h = false;
            this.f4504b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.f4504b;
            this.f4504b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i3 = this.f4504b + 1;
        this.f4504b = i3;
        return i3 == 0 ? 0 : 3;
    }

    public C2133c(int i, C2133c c2133c, C2131a c2131a, Object obj) {
        this.f4503a = i;
        this.f4570c = c2133c;
        this.f4571d = c2131a;
        this.f4504b = -1;
        this.f4574g = obj;
    }
}
