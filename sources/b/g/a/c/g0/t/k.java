package b.g.a.c.g0.t;

import b.g.a.a.i0;
import b.g.a.a.l0;
import b.g.a.c.c0.a0;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PropertyBasedObjectIdGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends l0 {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.g0.c _property;

    public k(Class<?> cls, b.g.a.c.g0.c cVar) {
        super(cls);
        this._property = cVar;
    }

    @Override // b.g.a.a.j0, b.g.a.a.i0
    public boolean a(i0<?> i0Var) {
        if (i0Var.getClass() != k.class) {
            return false;
        }
        k kVar = (k) i0Var;
        return kVar._scope == this._scope && kVar._property == this._property;
    }

    @Override // b.g.a.a.i0
    public i0<Object> b(Class<?> cls) {
        return cls == this._scope ? this : new k(cls, this._property);
    }

    @Override // b.g.a.a.i0
    public Object c(Object obj) {
        try {
            b.g.a.c.g0.c cVar = this._property;
            Method method = cVar.l;
            return method == null ? cVar.m.get(obj) : method.invoke(obj, null);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder sbU = b.d.b.a.a.U("Problem accessing property '");
            sbU.append(this._property._name._value);
            sbU.append("': ");
            sbU.append(e2.getMessage());
            throw new IllegalStateException(sbU.toString(), e2);
        }
    }

    @Override // b.g.a.a.i0
    public i0<Object> e(Object obj) {
        return this;
    }

    public k(a0 a0Var, b.g.a.c.g0.c cVar) {
        super(a0Var.e);
        this._property = cVar;
    }
}
