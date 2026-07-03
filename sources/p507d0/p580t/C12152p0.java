package p507d0.p580t;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.AbstractC12072k;
import p507d0.p578f0.C12073l;
import p507d0.p584w.p586i.p587a.AbstractC12193j;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.p0 */
/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12152p0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.p0$a */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    @InterfaceC12188e(m10084c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m10085f = "SlidingWindow.kt", m10086l = {34, 40, 49, 55, 58}, m10087m = "invokeSuspend")
    public static final class a<T> extends AbstractC12193j implements Function2<AbstractC12072k<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Iterator $iterator;
        public final /* synthetic */ boolean $partialWindows;
        public final /* synthetic */ boolean $reuseBuffer;
        public final /* synthetic */ int $size;
        public final /* synthetic */ int $step;
        public int I$0;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Iterator it, boolean z2, boolean z3, Continuation continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z2;
            this.$partialWindows = z3;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((a) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:54:0x0108  */
        /* JADX WARN: Code duplicated, block: B:55:0x010a  */
        /* JADX WARN: Code duplicated, block: B:58:0x011d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x00f7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0104 A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v20, types: [d0.t.a, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r1v21, types: [d0.t.l0] */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [d0.f0.k, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v3, types: [d0.t.a, d0.t.l0, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [d0.t.l0] */
        /* JADX WARN: Type inference failed for: r5v6, types: [d0.t.l0] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v8, types: [d0.f0.k, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 363
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p507d0.p580t.C12152p0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void checkWindowSizeStep(int i, int i2) {
        String strM873r;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            strM873r = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            strM873r = C1643a.m873r("size ", i, " must be greater than zero.");
        }
        throw new IllegalArgumentException(strM873r.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z2, boolean z3) {
        C12238m.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? C12164v.f25220j : C12073l.iterator(new a(i, i2, it, z3, z2, null));
    }
}
