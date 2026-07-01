package d0.w.i.a;

import d0.z.d.a0;
import d0.z.d.m;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends d implements d0.z.d.i<Object> {
    private final int arity;

    public k(int i, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // d0.z.d.i
    public int getArity() {
        return this.arity;
    }

    @Override // d0.w.i.a.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = a0.renderLambdaToString(this);
        m.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }

    public k(int i) {
        this(i, null);
    }
}
