package p507d0.p592z.p594d;

import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.InterfaceC11230c;

/* JADX INFO: renamed from: d0.z.d.y */
/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12250y extends AbstractC12249x {
    public C12250y(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(AbstractC12221d.NO_RECEIVER, ((InterfaceC12223e) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof InterfaceC11230c) ? 1 : 0);
    }

    @Override // p507d0.p513e0.InterfaceC11234g
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public C12250y(Class cls, String str, String str2, int i) {
        super(AbstractC12221d.NO_RECEIVER, cls, str, str2, i);
    }
}
