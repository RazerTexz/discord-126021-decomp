package p507d0.p592z.p594d;

import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.InterfaceC11230c;

/* JADX INFO: renamed from: d0.z.d.q */
/* JADX INFO: compiled from: MutablePropertyReference0Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12242q extends AbstractC12241p {
    public C12242q(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(AbstractC12221d.NO_RECEIVER, ((InterfaceC12223e) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof InterfaceC11230c) ? 1 : 0);
    }

    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public void set(Object obj) {
        getSetter().call(obj);
    }

    public C12242q(Class cls, String str, String str2, int i) {
        super(AbstractC12221d.NO_RECEIVER, cls, str, str2, i);
    }

    public C12242q(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
