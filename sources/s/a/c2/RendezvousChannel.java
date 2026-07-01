package s.a.c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: s.a.c2.q, reason: use source file name */
/* JADX INFO: compiled from: RendezvousChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class RendezvousChannel<E> extends AbstractChannel<E> {
    public RendezvousChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean h() {
        return true;
    }

    @Override // s.a.c2.AbstractChannel3
    public final boolean i() {
        return true;
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
