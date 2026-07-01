package b.i.c.o.b;

import b.i.c.FirebaseApp2;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements ComponentFactory {
    public static final ComponentFactory a = new f();

    @Override // b.i.c.l.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return new e((FirebaseApp2) componentContainer.a(FirebaseApp2.class), (b.i.c.j.a.a) componentContainer.a(b.i.c.j.a.a.class));
    }
}
