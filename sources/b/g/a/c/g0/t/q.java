package b.g.a.c.g0.t;

import b.g.a.c.g0.u.q0;
import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: compiled from: UnknownSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends q0<Object> {
    public q() {
        super(Object.class);
    }

    @Override // b.g.a.c.n
    public boolean d(x xVar, Object obj) {
        return true;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        if (xVar.D(w.FAIL_ON_EMPTY_BEANS)) {
            p(xVar, obj);
        }
        dVar.f0(obj, 0);
        dVar.u();
    }

    @Override // b.g.a.c.n
    public final void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        if (xVar.D(w.FAIL_ON_EMPTY_BEANS)) {
            p(xVar, obj);
        }
        gVar.f(dVar, gVar.e(dVar, gVar.d(obj, b.g.a.b.h.START_OBJECT)));
    }

    public void p(x xVar, Object obj) throws JsonMappingException {
        xVar.g(this._handledType, String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", obj.getClass().getName()));
    }

    public q(Class<?> cls) {
        super(cls, false);
    }
}
