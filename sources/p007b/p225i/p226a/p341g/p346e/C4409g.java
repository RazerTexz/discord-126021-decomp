package p007b.p225i.p226a.p341g.p346e;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: renamed from: b.i.a.g.e.g */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4409g implements TypeEvaluator<Float> {

    /* JADX INFO: renamed from: a */
    public FloatEvaluator f11698a = new FloatEvaluator();

    public C4409g(C4408f c4408f) {
    }

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float fFloatValue = this.f11698a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = 0.0f;
        }
        return Float.valueOf(fFloatValue);
    }
}
