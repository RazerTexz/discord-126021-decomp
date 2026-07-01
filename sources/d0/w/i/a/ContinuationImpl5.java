package d0.w.i.a;

import d0.z.d.FunctionBase;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: d0.w.i.a.j, reason: use source file name */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContinuationImpl5 extends ContinuationImpl4 implements FunctionBase<Object> {
    private final int arity;

    public ContinuationImpl5(int i, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // d0.z.d.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = Reflection2.renderLambdaToString(this);
        Intrinsics3.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }

    public ContinuationImpl5(int i) {
        this(i, null);
    }
}
