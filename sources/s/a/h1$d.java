package s.a;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {949, 951}, m = "invokeSuspend")
public final class h1$d extends d0.w.i.a.j implements Function2<d0.f0.k<? super r>, Continuation<? super Unit>, Object> {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;
    private d0.f0.k p$;
    public final /* synthetic */ h1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1$d(h1 h1Var, Continuation continuation) {
        super(2, continuation);
        this.this$0 = h1Var;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h1$d h1_d = new h1$d(this.this$0, continuation);
        h1_d.p$ = (d0.f0.k) obj;
        return h1_d;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(d0.f0.k<? super r> kVar, Continuation<? super Unit> continuation) {
        h1$d h1_d = new h1$d(this.this$0, continuation);
        h1_d.p$ = kVar;
        return h1_d.invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    /* JADX WARN: Code duplicated, block: B:26:0x009c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:27:0x009d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:27:0x009d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // d0.w.i.a.a
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = d0.w.h.c.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            java.lang.Object r1 = r10.L$5
            s.a.q r1 = (s.a.q) r1
            java.lang.Object r1 = r10.L$4
            s.a.a.k r1 = (s.a.a.k) r1
            java.lang.Object r4 = r10.L$3
            s.a.a.i r4 = (s.a.a.i) r4
            java.lang.Object r5 = r10.L$2
            s.a.m1 r5 = (s.a.m1) r5
            java.lang.Object r6 = r10.L$1
            java.lang.Object r7 = r10.L$0
            d0.f0.k r7 = (d0.f0.k) r7
            d0.l.throwOnFailure(r11)
            r11 = r10
            goto L9d
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            java.lang.Object r0 = r10.L$0
            d0.f0.k r0 = (d0.f0.k) r0
            d0.l.throwOnFailure(r11)
            goto La2
        L3a:
            d0.l.throwOnFailure(r11)
            d0.f0.k r11 = r10.p$
            s.a.h1 r1 = r10.this$0
            java.lang.Object r1 = r1.M()
            boolean r4 = r1 instanceof s.a.q
            if (r4 == 0) goto L5b
            r2 = r1
            s.a.q r2 = (s.a.q) r2
            s.a.r r2 = r2.n
            r10.L$0 = r11
            r10.L$1 = r1
            r10.label = r3
            java.lang.Object r11 = r11.yield(r2, r10)
            if (r11 != r0) goto La2
            return r0
        L5b:
            boolean r4 = r1 instanceof s.a.z0
            if (r4 == 0) goto La2
            r4 = r1
            s.a.z0 r4 = (s.a.z0) r4
            s.a.m1 r4 = r4.getList()
            if (r4 == 0) goto La2
            java.lang.Object r5 = r4.i()
        */
        //  java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r5, r6)
            s.a.a.k r5 = (s.a.a.k) r5
            r7 = r11
            r6 = r1
            r1 = r5
            r11 = r10
            r5 = r4
        L78:
            boolean r8 = d0.z.d.m.areEqual(r1, r4)
            r8 = r8 ^ r3
            if (r8 == 0) goto La2
            boolean r8 = r1 instanceof s.a.q
            if (r8 == 0) goto L9d
            r8 = r1
            s.a.q r8 = (s.a.q) r8
            s.a.r r9 = r8.n
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r5
            r11.L$3 = r4
            r11.L$4 = r1
            r11.L$5 = r8
            r11.label = r2
            java.lang.Object r8 = r7.yield(r9, r11)
            if (r8 != r0) goto L9d
            return r0
        L9d:
            s.a.a.k r1 = r1.j()
            goto L78
        La2:
            kotlin.Unit r11 = kotlin.Unit.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: s.a.h1$d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
