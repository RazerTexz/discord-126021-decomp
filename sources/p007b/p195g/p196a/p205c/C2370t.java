package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p204t.C2144f;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.t */
/* JADX INFO: compiled from: PropertyName.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2370t implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final C2370t f5029j = new C2370t("", null);

    /* JADX INFO: renamed from: k */
    public static final C2370t f5030k = new C2370t(new String(""), null);
    private static final long serialVersionUID = 1;
    public InterfaceC2115k _encodedSimple;
    public final String _namespace;
    public final String _simpleName;

    public C2370t(String str) {
        Annotation[] annotationArr = C2342d.f4944a;
        this._simpleName = str;
        this._namespace = null;
    }

    /* JADX INFO: renamed from: a */
    public static C2370t m2227a(String str) {
        return (str == null || str.isEmpty()) ? f5029j : new C2370t(C2144f.f4602j.m1733a(str), null);
    }

    /* JADX INFO: renamed from: b */
    public static C2370t m2228b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? f5029j : new C2370t(C2144f.f4602j.m1733a(str), str2);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2229c() {
        return !this._simpleName.isEmpty();
    }

    /* JADX INFO: renamed from: d */
    public boolean m2230d() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C2370t.class) {
            return false;
        }
        C2370t c2370t = (C2370t) obj;
        String str = this._simpleName;
        if (str == null) {
            if (c2370t._simpleName != null) {
                return false;
            }
        } else if (!str.equals(c2370t._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        if (str2 == null) {
            return c2370t._namespace == null;
        }
        return str2.equals(c2370t._namespace);
    }

    public int hashCode() {
        String str = this._namespace;
        return str == null ? this._simpleName.hashCode() : str.hashCode() ^ this._simpleName.hashCode();
    }

    public Object readResolve() {
        String str;
        return (this._namespace == null && ((str = this._simpleName) == null || "".equals(str))) ? f5029j : this;
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        StringBuilder sbM833U = C1643a.m833U("{");
        sbM833U.append(this._namespace);
        sbM833U.append("}");
        sbM833U.append(this._simpleName);
        return sbM833U.toString();
    }

    public C2370t(String str, String str2) {
        Annotation[] annotationArr = C2342d.f4944a;
        this._simpleName = str == null ? "" : str;
        this._namespace = str2;
    }
}
