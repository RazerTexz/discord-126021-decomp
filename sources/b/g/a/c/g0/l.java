package b.g.a.c.g0;

import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.c.v;
import b.g.a.c.y.e$b;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: compiled from: PropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    public final v a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.c.c f702b;
    public final b.g.a.c.b c;
    public Object d;
    public final p$b e;
    public final boolean f;

    public l(v vVar, b.g.a.c.c cVar) {
        this.a = vVar;
        this.f702b = cVar;
        p$b p_b = p$b.j;
        p$b p_bA = p$b.j;
        p$b p_bC = cVar.c(p_bA);
        vVar.k(cVar.a._class, p_bA);
        p_bA = p_bC != null ? p_bC.a(p_bA) : p_bA;
        p$b p_b2 = vVar._configOverrides._defaultInclusion;
        this.e = p_b2 == null ? p_bA : p_b2.a(p_bA);
        this.f = p_bA._valueInclusion == p$a.NON_DEFAULT;
        this.c = vVar.e();
    }

    public b.g.a.c.j a(b.g.a.c.c0.b bVar, boolean z2, b.g.a.c.j jVar) throws JsonMappingException {
        b.g.a.c.j jVarE0 = this.c.e0(this.a, bVar, jVar);
        if (jVarE0 != jVar) {
            Class<?> cls = jVarE0._class;
            Class<?> cls2 = jVar._class;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                StringBuilder sbU = b.d.b.a.a.U("Illegal concrete-type annotation for method '");
                sbU.append(bVar.c());
                sbU.append("': class ");
                sbU.append(cls.getName());
                sbU.append(" not a super-type of (declared) class ");
                sbU.append(cls2.getName());
                throw new IllegalArgumentException(sbU.toString());
            }
            z2 = true;
            jVar = jVarE0;
        }
        e$b e_bK = this.c.K(bVar);
        if (e_bK != null && e_bK != e$b.DEFAULT_TYPING) {
            z2 = e_bK == e$b.STATIC;
        }
        if (z2) {
            return jVar.G();
        }
        return null;
    }
}
