package p507d0.p592z.p594d;

import java.io.Serializable;

/* JADX INFO: renamed from: d0.z.d.o */
/* JADX INFO: compiled from: Lambda.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12240o<R> implements InterfaceC12234i<R>, Serializable {
    private final int arity;

    public AbstractC12240o(int i) {
        this.arity = i;
    }

    @Override // p507d0.p592z.p594d.InterfaceC12234i
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strRenderLambdaToString = C12216a0.renderLambdaToString((AbstractC12240o) this);
        C12238m.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }
}
