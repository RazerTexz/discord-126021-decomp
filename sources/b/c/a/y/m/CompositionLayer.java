package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import b.c.a.L;
import b.c.a.LottieComposition;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.Logger2;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.k.AnimatableFloatValue;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.m.c, reason: use source file name */
/* JADX INFO: compiled from: CompositionLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class CompositionLayer extends BaseLayer2 {
    public final RectF A;
    public Paint B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f432x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<BaseLayer2> f433y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f434z;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer2 layer2, List<Layer2> list, LottieComposition lottieComposition) {
        int i;
        BaseLayer2 baseLayer2;
        BaseLayer2 compositionLayer;
        super(lottieDrawable, layer2);
        this.f433y = new ArrayList();
        this.f434z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        AnimatableFloatValue animatableFloatValue = layer2.f439s;
        if (animatableFloatValue != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = animatableFloatValue.a();
            this.f432x = baseKeyframeAnimationA;
            e(baseKeyframeAnimationA);
            this.f432x.a.add(this);
        } else {
            this.f432x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.i.size());
        int size = list.size() - 1;
        BaseLayer2 baseLayer3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer2 layer3 = list.get(size);
            int iOrdinal = layer3.e.ordinal();
            if (iOrdinal == 0) {
                compositionLayer = new CompositionLayer(lottieDrawable, layer3, lottieComposition.c.get(layer3.g), lottieComposition);
            } else if (iOrdinal == 1) {
                compositionLayer = new SolidLayer(lottieDrawable, layer3);
            } else if (iOrdinal == 2) {
                compositionLayer = new ImageLayer(lottieDrawable, layer3);
            } else if (iOrdinal == 3) {
                compositionLayer = new NullLayer(lottieDrawable, layer3);
            } else if (iOrdinal == 4) {
                compositionLayer = new ShapeLayer(lottieDrawable, layer3);
            } else if (iOrdinal != 5) {
                StringBuilder sbU = outline.U("Unknown layer type ");
                sbU.append(layer3.e);
                Logger2.b(sbU.toString());
                compositionLayer = null;
            } else {
                compositionLayer = new TextLayer(lottieDrawable, layer3);
            }
            if (compositionLayer != null) {
                longSparseArray.put(compositionLayer.o.d, compositionLayer);
                if (baseLayer3 != null) {
                    baseLayer3.r = compositionLayer;
                    baseLayer3 = null;
                } else {
                    this.f433y.add(0, compositionLayer);
                    int iH = b.c.a.y.b.h(layer3.u);
                    if (iH == 1 || iH == 2) {
                        baseLayer3 = compositionLayer;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer2 baseLayer4 = (BaseLayer2) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer4 != null && (baseLayer2 = (BaseLayer2) longSparseArray.get(baseLayer4.o.f)) != null) {
                baseLayer4.f431s = baseLayer2;
            }
        }
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        for (int size = this.f433y.size() - 1; size >= 0; size--) {
            this.f434z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f433y.get(size).d(this.f434z, this.m, true);
            rectF.union(this.f434z);
        }
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.v.c(t, lottieValueCallback);
        if (t == LottieProperty.A) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f432x;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.i(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f432x = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a.add(this);
            e(this.f432x);
        }
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void j(Canvas canvas, Matrix matrix, int i) {
        RectF rectF = this.A;
        Layer2 layer2 = this.o;
        rectF.set(0.0f, 0.0f, layer2.o, layer2.p);
        matrix.mapRect(this.A);
        boolean z2 = this.n.A && this.f433y.size() > 1 && i != 255;
        if (z2) {
            this.B.setAlpha(i);
            Utils.f(canvas, this.A, this.B, 31);
        } else {
            canvas.save();
        }
        if (z2) {
            i = 255;
        }
        for (int size = this.f433y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.f433y.get(size).f(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.a("CompositionLayer#draw");
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void n(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.f433y.size(); i2++) {
            this.f433y.get(i2).c(keyPath, i, list, keyPath2);
        }
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.o(f);
        if (this.f432x != null) {
            f = ((this.f432x.e().floatValue() * this.o.f438b.m) - this.o.f438b.k) / (this.n.k.c() + 0.01f);
        }
        if (this.f432x == null) {
            Layer2 layer2 = this.o;
            f -= layer2.n / layer2.f438b.c();
        }
        float f2 = this.o.m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        int size = this.f433y.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                this.f433y.get(size).o(f);
            }
        }
    }
}
