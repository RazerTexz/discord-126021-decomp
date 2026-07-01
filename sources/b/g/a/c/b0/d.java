package b.g.a.c.b0;

import b.g.a.c.c0.m;
import b.g.a.c.c0.n;
import b.g.a.c.t;
import java.beans.ConstructorProperties;
import java.beans.Transient;

/* JADX INFO: compiled from: Java7SupportImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends c {
    @Override // b.g.a.c.b0.c
    public t a(m mVar) {
        ConstructorProperties constructorPropertiesB;
        n nVar = mVar._owner;
        if (nVar == null || (constructorPropertiesB = nVar.b(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] strArrValue = constructorPropertiesB.value();
        int i = mVar._index;
        if (i < strArrValue.length) {
            return t.a(strArrValue[i]);
        }
        return null;
    }

    @Override // b.g.a.c.b0.c
    public Boolean b(b.g.a.c.c0.b bVar) {
        Transient transientB = bVar.b(Transient.class);
        if (transientB != null) {
            return Boolean.valueOf(transientB.value());
        }
        return null;
    }

    @Override // b.g.a.c.b0.c
    public Boolean c(b.g.a.c.c0.b bVar) {
        if (bVar.b(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }
}
