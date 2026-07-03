package p507d0.p584w.p586i.p587a;

import kotlin.coroutines.Continuation;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.InterfaceC12234i;

/* JADX INFO: renamed from: d0.w.i.a.j */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12193j extends AbstractC12192i implements InterfaceC12234i<Object> {
    private final int arity;

    public AbstractC12193j(int i, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // p507d0.p592z.p594d.InterfaceC12234i
    public int getArity() {
        return this.arity;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = C12216a0.renderLambdaToString(this);
        C12238m.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }

    public AbstractC12193j(int i) {
        this(i, null);
    }
}
