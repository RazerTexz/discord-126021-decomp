package b.c.a.w.c;

import androidx.annotation.Nullable;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: renamed from: b.c.a.w.c.p, reason: use source file name */
/* JADX INFO: compiled from: ValueCallbackKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    public final A i;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, @Nullable A a) {
        super(Collections.emptyList());
        this.e = lottieValueCallback;
        this.i = a;
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public float b() {
        return 1.0f;
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public A e() {
        LottieValueCallback<A> lottieValueCallback = this.e;
        A a = this.i;
        float f = this.d;
        return lottieValueCallback.a(0.0f, 0.0f, a, a, f, f, f);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public A f(Keyframe<K> keyframe, float f) {
        return e();
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public void g() {
        if (this.e != null) {
            super.g();
        }
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public void h(float f) {
        this.d = f;
    }
}
