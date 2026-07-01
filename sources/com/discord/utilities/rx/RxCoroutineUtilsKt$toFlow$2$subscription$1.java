package com.discord.utilities.rx;

import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import d0.w.d;
import d0.w.d$b;
import j0.g;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.ProducerScope;
import s.a.c2.h;
import s.a.i1;
import s.a.k0;
import s.a.q0;
import s.a.w;
import s.a.w1;
import s.a.z0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt$toFlow$2$subscription$1<T> implements g<T> {
    public final /* synthetic */ ProducerScope $this_callbackFlow;

    public RxCoroutineUtilsKt$toFlow$2$subscription$1(ProducerScope<? super T> producerScope) {
        this.$this_callbackFlow = producerScope;
    }

    @Override // j0.g
    public void onCompleted() {
        f.I(this.$this_callbackFlow, null, 1, null);
    }

    @Override // j0.g
    public void onError(Throwable e) {
        f.r(this.$this_callbackFlow, f.a("Error in Observable", e));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // j0.g
    public void onNext(T value) throws Throwable {
        q0 q0VarA;
        CoroutineContext coroutineContextPlus;
        ProducerScope producerScope = this.$this_callbackFlow;
        if (producerScope.offer(value)) {
            return;
        }
        h hVar = new h(producerScope, value, null);
        CoroutineContext coroutineContext = d0.w.f.j;
        Thread threadCurrentThread = Thread.currentThread();
        d$b d_b = d$b.a;
        d dVar = (d) coroutineContext.get(d_b);
        if (dVar == null) {
            w1 w1Var = w1.f3847b;
            q0VarA = w1.a();
            coroutineContextPlus = coroutineContext.plus(coroutineContext.plus(q0VarA));
            CoroutineDispatcher coroutineDispatcher = k0.a;
            if (coroutineContextPlus != coroutineDispatcher && coroutineContextPlus.get(d_b) == null) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher);
            }
        } else {
            if (!(dVar instanceof q0)) {
                dVar = null;
            }
            w1 w1Var2 = w1.f3847b;
            q0VarA = w1.a.get();
            coroutineContextPlus = coroutineContext.plus(coroutineContext);
            CoroutineDispatcher coroutineDispatcher2 = k0.a;
            if (coroutineContextPlus != coroutineDispatcher2 && coroutineContextPlus.get(d_b) == null) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher2);
            }
        }
        s.a.f fVar = new s.a.f(coroutineContextPlus, threadCurrentThread, q0VarA);
        fVar.j0(CoroutineStart.DEFAULT, fVar, hVar);
        q0 q0Var = fVar.n;
        if (q0Var != null) {
            int i = q0.j;
            q0Var.L(false);
        }
        while (!Thread.interrupted()) {
            try {
                q0 q0Var2 = fVar.n;
                long jO = q0Var2 != null ? q0Var2.O() : RecyclerView.FOREVER_NS;
                if (!(fVar.M() instanceof z0)) {
                    q0 q0Var3 = fVar.n;
                    if (q0Var3 != null) {
                        int i2 = q0.j;
                        q0Var3.H(false);
                    }
                    Object objA = i1.a(fVar.M());
                    w wVar = (w) (objA instanceof w ? objA : null);
                    if (wVar != null) {
                        throw wVar.f3846b;
                    }
                    return;
                }
                LockSupport.parkNanos(fVar, jO);
            } catch (Throwable th) {
                q0 q0Var4 = fVar.n;
                if (q0Var4 != null) {
                    int i3 = q0.j;
                    q0Var4.H(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        fVar.w(interruptedException);
        throw interruptedException;
    }
}
