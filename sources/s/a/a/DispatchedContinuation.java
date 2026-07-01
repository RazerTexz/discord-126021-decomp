package s.a.a;

import b.d.b.a.outline;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.CompletionState3;
import s.a.DispatchedTask;
import s.a.q0;
import s.a.w1;

/* JADX INFO: renamed from: s.a.a.g, reason: use source file name */
/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    public volatile Object _reusableCancellableContinuation;
    public Object n;
    public final CoroutineStackFrame o;
    public final Object p;
    public final CoroutineDispatcher q;
    public final Continuation<T> r;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.Continuation<? super T>, kotlin.coroutines.Continuation<T>] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation<? super T> to ?? for r4v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:139)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:212)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:143)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:68)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.regions.TernaryMod.replaceWithTernary(TernaryMod.java:359)
        	at jadx.core.dex.visitors.regions.TernaryMod.processOneBranchTernary(TernaryMod.java:284)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:82)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public DispatchedContinuation(kotlinx.coroutines.CoroutineDispatcher r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            r0 = -1
            r2.<init>(r0)
            r2.q = r3
            r2.r = r4
            s.a.a.t r3 = s.a.a.DispatchedContinuation2.a
            r2.n = r3
            boolean r3 = r4 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame
            r0 = 0
            if (r3 != 0) goto L12
            r4 = r0
        L12:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r4 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r4
            r2.o = r4
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.CoroutineContext$Element, java.lang.Object> r1 = s.a.a.ThreadContext.f3825b
            java.lang.Object r3 = r3.fold(r4, r1)
            d0.z.d.Intrinsics3.checkNotNull(r3)
            r2.p = r3
            r2._reusableCancellableContinuation = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.a.a.DispatchedContinuation.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):void");
    }

    @Override // s.a.DispatchedTask
    public void b(Object obj, Throwable th) {
        if (obj instanceof CompletionState3) {
            ((CompletionState3) obj).f3848b.invoke(th);
        }
    }

    @Override // s.a.DispatchedTask
    public Continuation<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.r.getContext();
    }

    @Override // s.a.DispatchedTask
    public Object m() {
        Object obj = this.n;
        this.n = DispatchedContinuation2.a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        CoroutineContext context = this.r.getContext();
        Object objV1 = b.i.a.f.e.o.f.v1(obj, null);
        if (this.q.isDispatchNeeded(context)) {
            this.n = objV1;
            this.l = 0;
            this.q.dispatch(context, this);
            return;
        }
        w1 w1Var = w1.f3847b;
        q0 q0VarA = w1.a();
        if (q0VarA.N()) {
            this.n = objV1;
            this.l = 0;
            q0VarA.J(this);
            return;
        }
        q0VarA.L(true);
        try {
            CoroutineContext context2 = getContext();
            Object objB = ThreadContext.b(context2, this.p);
            try {
                this.r.resumeWith(obj);
                ThreadContext.a(context2, objB);
                while (q0VarA.R()) {
                }
            } catch (Throwable th) {
                ThreadContext.a(context2, objB);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                l(th2, null);
            } finally {
                q0VarA.H(true);
            }
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("DispatchedContinuation[");
        sbU.append(this.q);
        sbU.append(", ");
        sbU.append(b.i.a.f.e.o.f.s1(this.r));
        sbU.append(']');
        return sbU.toString();
    }
}
