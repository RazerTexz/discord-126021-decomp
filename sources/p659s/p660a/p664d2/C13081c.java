package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import p007b.p100d.p104b.p105a.C1643a;
import p659s.p660a.p663c2.EnumC13058e;
import p659s.p660a.p664d2.p665g.AbstractC13085a;

/* JADX INFO: renamed from: s.a.d2.c */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13081c<T> extends AbstractC13085a<T> {

    /* JADX INFO: renamed from: d */
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> f27782d;

    /* JADX WARN: Multi-variable type inference failed */
    public C13081c(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i, EnumC13058e enumC13058e) {
        super(coroutineContext, i, enumC13058e);
        this.f27782d = function2;
    }

    @Override // p659s.p660a.p664d2.p665g.AbstractC13085a
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("block[");
        sbM833U.append(this.f27782d);
        sbM833U.append("] -> ");
        sbM833U.append(super.toString());
        return sbM833U.toString();
    }
}
