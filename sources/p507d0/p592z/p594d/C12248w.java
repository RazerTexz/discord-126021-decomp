package p507d0.p592z.p594d;

import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.InterfaceC11230c;

/* JADX INFO: renamed from: d0.z.d.w */
/* JADX INFO: compiled from: PropertyReference0Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12248w extends AbstractC12247v {
    public C12248w(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(AbstractC12221d.NO_RECEIVER, ((InterfaceC12223e) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof InterfaceC11230c) ? 1 : 0);
    }

    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public C12248w(Class cls, String str, String str2, int i) {
        super(AbstractC12221d.NO_RECEIVER, cls, str, str2, i);
    }

    public C12248w(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
