package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.LPaint;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.TransformKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.KeyPathElement;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.l.ContentModel2;
import b.c.a.y.l.ShapeGroup;
import b.c.a.y.m.BaseLayer2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.d, reason: use source file name */
/* JADX INFO: compiled from: ContentGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.b, KeyPathElement {
    public Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f378b;
    public final Matrix c;
    public final Path d;
    public final RectF e;
    public final String f;
    public final boolean g;
    public final List<Content2> h;
    public final LottieDrawable i;

    @Nullable
    public List<PathContent> j;

    @Nullable
    public TransformKeyframeAnimation k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapeGroup shapeGroup) {
        AnimatableTransform animatableTransform;
        String str = shapeGroup.a;
        boolean z2 = shapeGroup.c;
        List<ContentModel2> list = shapeGroup.f426b;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content2 content2A = list.get(i).a(lottieDrawable, baseLayer2);
            if (content2A != null) {
                arrayList.add(content2A);
            }
        }
        List<ContentModel2> list2 = shapeGroup.f426b;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            ContentModel2 contentModel2 = list2.get(i2);
            if (contentModel2 instanceof AnimatableTransform) {
                animatableTransform = (AnimatableTransform) contentModel2;
                this(lottieDrawable, baseLayer2, str, z2, arrayList, animatableTransform);
            }
        }
        animatableTransform = null;
        this(lottieDrawable, baseLayer2, str, z2, arrayList, animatableTransform);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        ArrayList arrayList = new ArrayList(this.h.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.h.get(size);
            content2.b(arrayList, this.h.subList(0, size));
            arrayList.add(content2);
        }
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.e(this.f, i)) {
            if (!"__container".equals(this.f)) {
                keyPath2 = keyPath2.a(this.f);
                if (keyPath.c(this.f, i)) {
                    list.add(keyPath2.g(this));
                }
            }
            if (keyPath.f(this.f, i)) {
                int iD = keyPath.d(this.f, i) + i;
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    Content2 content2 = this.h.get(i2);
                    if (content2 instanceof KeyPathElement) {
                        ((KeyPathElement) content2).c(keyPath, iD, list, keyPath2);
                    }
                }
            }
        }
    }

    @Override // b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            this.c.preConcat(transformKeyframeAnimation.e());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.h.get(size);
            if (content2 instanceof DrawingContent) {
                ((DrawingContent) content2).d(this.e, this.c, z2);
                rectF.union(this.e);
            }
        }
    }

    public List<PathContent> e() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                Content2 content2 = this.h.get(i);
                if (content2 instanceof PathContent) {
                    this.j.add((PathContent) content2);
                }
            }
        }
        return this.j;
    }

    @Override // b.c.a.w.b.DrawingContent
    public void f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            this.c.preConcat(transformKeyframeAnimation.e());
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.k.j;
            i = (int) (((((baseKeyframeAnimation == null ? 100 : baseKeyframeAnimation.e().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z3 = false;
        if (this.i.A) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= this.h.size()) {
                    z2 = false;
                    break;
                } else {
                    if ((this.h.get(i2) instanceof DrawingContent) && (i3 = i3 + 1) >= 2) {
                        z2 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z2 && i != 255) {
                z3 = true;
            }
        }
        if (z3) {
            this.f378b.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(this.f378b, this.c, true);
            this.a.setAlpha(i);
            Utils.f(canvas, this.f378b, this.a, 31);
        }
        if (z3) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.h.get(size);
            if (content2 instanceof DrawingContent) {
                ((DrawingContent) content2).f(canvas, this.c, i);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.c(t, lottieValueCallback);
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.f;
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        this.c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            this.c.set(transformKeyframeAnimation.e());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content2 content2 = this.h.get(size);
            if (content2 instanceof PathContent) {
                this.d.addPath(((PathContent) content2).getPath(), this.c);
            }
        }
        return this.d;
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, String str, boolean z2, List<Content2> list, @Nullable AnimatableTransform animatableTransform) {
        this.a = new LPaint();
        this.f378b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = lottieDrawable;
        this.g = z2;
        this.h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.k = transformKeyframeAnimation;
            transformKeyframeAnimation.a(baseLayer2);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            Content2 content2 = list.get(size);
            if (content2 instanceof GreedyContent) {
                arrayList.add((GreedyContent) content2);
            }
        }
        int size2 = arrayList.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                ((GreedyContent) arrayList.get(size2)).e(list.listIterator(list.size()));
            }
        }
    }
}
