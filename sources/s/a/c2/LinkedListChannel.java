package s.a.c2;

import b.d.b.a.outline;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import s.a.a.LockFreeLinkedList;
import s.a.a.LockFreeLinkedList3;
import s.a.a.Symbol3;
import s.a.c2.AbstractChannel3;

/* JADX INFO: renamed from: s.a.c2.k, reason: use source file name */
/* JADX INFO: compiled from: LinkedListChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean h() {
        return false;
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean i() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.c2.AbstractChannel3
    public Object k(E e) {
        AbstractChannel6 abstractChannel6;
        do {
            Object objK = super.k(e);
            Symbol3 symbol3 = AbstractChannel2.f3834b;
            if (objK == symbol3) {
                return symbol3;
            }
            if (objK != AbstractChannel2.c) {
                if (objK instanceof AbstractChannel4) {
                    return objK;
                }
                throw new IllegalStateException(outline.v("Invalid offerInternal result ", objK).toString());
            }
            LockFreeLinkedList lockFreeLinkedList = this.k;
            AbstractChannel3.a aVar = new AbstractChannel3.a(e);
            while (true) {
                LockFreeLinkedList3 lockFreeLinkedList3K = lockFreeLinkedList.k();
                if (lockFreeLinkedList3K instanceof AbstractChannel6) {
                    abstractChannel6 = (AbstractChannel6) lockFreeLinkedList3K;
                    break;
                }
                if (lockFreeLinkedList3K.e(aVar, lockFreeLinkedList)) {
                    abstractChannel6 = null;
                    break;
                }
            }
            if (abstractChannel6 == null) {
                return AbstractChannel2.f3834b;
            }
        } while (!(abstractChannel6 instanceof AbstractChannel4));
        return abstractChannel6;
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean s() {
        return true;
    }

    @Override // s.a.c2.AbstractChannel
    public final boolean t() {
        return true;
    }
}
