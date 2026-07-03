package p659s.p660a.p663c2;

import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.C13129m;
import p659s.p660a.p661a.C13028k;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.c2.i */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13062i<E> extends AbstractC13071r implements InterfaceC13069p<E> {

    /* JADX INFO: renamed from: m */
    public final Throwable f27763m;

    public C13062i(Throwable th) {
        this.f27763m = th;
    }

    @Override // p659s.p660a.p663c2.InterfaceC13069p
    /* JADX INFO: renamed from: b */
    public Object mo11232b() {
        return this;
    }

    @Override // p659s.p660a.p663c2.InterfaceC13069p
    /* JADX INFO: renamed from: c */
    public void mo11209c(E e) {
    }

    @Override // p659s.p660a.p663c2.InterfaceC13069p
    /* JADX INFO: renamed from: d */
    public C13037t mo11210d(E e, C13028k.b bVar) {
        return C13129m.f27874a;
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: q */
    public void mo11227q() {
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: r */
    public Object mo11228r() {
        return this;
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: s */
    public void mo11229s(C13062i<?> c13062i) {
    }

    @Override // p659s.p660a.p663c2.AbstractC13071r
    /* JADX INFO: renamed from: t */
    public C13037t mo11230t(C13028k.b bVar) {
        return C13129m.f27874a;
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Closed@");
        sbM833U.append(C3404f.m4312l0(this));
        sbM833U.append('[');
        sbM833U.append(this.f27763m);
        sbM833U.append(']');
        return sbM833U.toString();
    }

    /* JADX INFO: renamed from: v */
    public final Throwable m11233v() {
        Throwable th = this.f27763m;
        return th != null ? th : new ClosedReceiveChannelException("Channel was closed");
    }

    /* JADX INFO: renamed from: w */
    public final Throwable m11234w() {
        Throwable th = this.f27763m;
        return th != null ? th : new ClosedSendChannelException("Channel was closed");
    }
}
