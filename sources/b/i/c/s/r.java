package b.i.c.s;

import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import com.google.firebase.iid.Registrar;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements ComponentFactory {
    public static final ComponentFactory a = new r();

    @Override // b.i.c.l.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return Registrar.lambda$getComponents$0$Registrar(componentContainer);
    }
}
