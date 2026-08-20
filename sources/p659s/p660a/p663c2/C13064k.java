package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p659s.p660a.p661a.C13026i;
import p659s.p660a.p661a.C13028k;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.c2.k */
/* JADX INFO: compiled from: LinkedListChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13064k<E> extends AbstractC13054a<E> {
    public C13064k(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: h */
    public final boolean mo11219h() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: i */
    public final boolean mo11220i() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: k */
    public Object mo11222k(E e) {
        InterfaceC13069p interfaceC13069p;
        do {
            Object objMo11222k = super.mo11222k(e);
            C13037t c13037t = C13055b.f27740b;
            if (objMo11222k == c13037t) {
                return c13037t;
            }
            if (objMo11222k != C13055b.f27741c) {
                if (objMo11222k instanceof C13062i) {
                    return objMo11222k;
                }
                throw new IllegalStateException(C1643a.m881v("Invalid offerInternal result ", objMo11222k).toString());
            }
            C13026i c13026i = this.f27746k;
            AbstractC13056c.a aVar = new AbstractC13056c.a(e);
            while (true) {
                C13028k c13028kM11157k = c13026i.m11157k();
                if (c13028kM11157k instanceof InterfaceC13069p) {
                    interfaceC13069p = (InterfaceC13069p) c13028kM11157k;
                    break;
                }
                if (c13028kM11157k.m11152e(aVar, c13026i)) {
                    interfaceC13069p = null;
                    break;
                }
            }
            if (interfaceC13069p == null) {
                return C13055b.f27740b;
            }
        } while (!(interfaceC13069p instanceof C13062i));
        return interfaceC13069p;
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: s */
    public final boolean mo11203s() {
        return true;
    }

    @Override // p659s.p660a.p663c2.AbstractC13054a
    /* JADX INFO: renamed from: t */
    public final boolean mo11204t() {
        return true;
    }
}
