package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import b.c.a.LottieComposition;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.Utils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.b.ContentGroup;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.TextKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.x.FontAssetManager;
import b.c.a.y.DocumentData;
import b.c.a.y.Font;
import b.c.a.y.FontCharacter;
import b.c.a.y.MutablePair;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableTextProperties;
import b.c.a.y.l.ShapeGroup;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.c.a.y.m.i, reason: use source file name */
/* JADX INFO: compiled from: TextLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class TextLayer extends BaseLayer2 {
    public final Paint A;
    public final Paint B;
    public final Map<FontCharacter, List<ContentGroup>> C;
    public final LongSparseArray<String> D;
    public final TextKeyframeAnimation E;
    public final LottieDrawable F;
    public final LottieComposition G;

    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> H;

    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> I;

    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> J;

    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> K;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> L;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> M;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> N;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> O;

    @Nullable
    public BaseKeyframeAnimation<Float, Float> P;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final StringBuilder f444x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f445y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Matrix f446z;

    /* JADX INFO: renamed from: b.c.a.y.m.i$a */
    /* JADX INFO: compiled from: TextLayer.java */
    public class a extends Paint {
        public a(TextLayer textLayer, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: renamed from: b.c.a.y.m.i$b */
    /* JADX INFO: compiled from: TextLayer.java */
    public class b extends Paint {
        public b(TextLayer textLayer, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public TextLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        super(lottieDrawable, layer2);
        this.f444x = new StringBuilder(2);
        this.f445y = new RectF();
        this.f446z = new Matrix();
        this.A = new a(this, 1);
        this.B = new b(this, 1);
        this.C = new HashMap();
        this.D = new LongSparseArray<>();
        this.F = lottieDrawable;
        this.G = layer2.f438b;
        TextKeyframeAnimation textKeyframeAnimation = new TextKeyframeAnimation(layer2.q.a);
        this.E = textKeyframeAnimation;
        textKeyframeAnimation.a.add(this);
        e(textKeyframeAnimation);
        AnimatableTextProperties animatableTextProperties = layer2.r;
        if (animatableTextProperties != null && (animatableColorValue2 = animatableTextProperties.a) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA = animatableColorValue2.a();
            this.H = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a.add(this);
            e(this.H);
        }
        if (animatableTextProperties != null && (animatableColorValue = animatableTextProperties.f413b) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA2 = animatableColorValue.a();
            this.J = baseKeyframeAnimationA2;
            baseKeyframeAnimationA2.a.add(this);
            e(this.J);
        }
        if (animatableTextProperties != null && (animatableFloatValue2 = animatableTextProperties.c) != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA3 = animatableFloatValue2.a();
            this.L = baseKeyframeAnimationA3;
            baseKeyframeAnimationA3.a.add(this);
            e(this.L);
        }
        if (animatableTextProperties == null || (animatableFloatValue = animatableTextProperties.d) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA4 = animatableFloatValue.a();
        this.N = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a.add(this);
        e(this.N);
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.G.j.width(), this.G.j.height());
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.v.c(t, lottieValueCallback);
        if (t == LottieProperty.a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.I;
            if (baseKeyframeAnimation != null) {
                this.u.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.I = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.I = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a.add(this);
            e(this.I);
            return;
        }
        if (t == LottieProperty.f368b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.K;
            if (baseKeyframeAnimation2 != null) {
                this.u.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.K = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.K = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a.add(this);
            e(this.K);
            return;
        }
        if (t == LottieProperty.o) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.M;
            if (baseKeyframeAnimation3 != null) {
                this.u.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.M = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.M = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a.add(this);
            e(this.M);
            return;
        }
        if (t == LottieProperty.p) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.O;
            if (baseKeyframeAnimation4 != null) {
                this.u.remove(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.O = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.O = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a.add(this);
            e(this.O);
            return;
        }
        if (t == LottieProperty.B) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.P;
            if (baseKeyframeAnimation5 != null) {
                this.u.remove(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.P = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.P = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.a.add(this);
            e(this.P);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.c.a.y.m.BaseLayer2
    public void j(Canvas canvas, Matrix matrix, int i) {
        FontAssetManager fontAssetManager;
        String str;
        float fFloatValue;
        int i2;
        int i3;
        String str2;
        List<ContentGroup> list;
        float fFloatValue2;
        canvas.save();
        if (!(this.F.k.g.size() > 0)) {
            canvas.setMatrix(matrix);
        }
        DocumentData documentDataE = this.E.e();
        Font font = this.G.e.get(documentDataE.f405b);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.I;
        if (baseKeyframeAnimation != null) {
            this.A.setColor(baseKeyframeAnimation.e().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.H;
            if (baseKeyframeAnimation2 != null) {
                this.A.setColor(baseKeyframeAnimation2.e().intValue());
            } else {
                this.A.setColor(documentDataE.h);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.K;
        if (baseKeyframeAnimation3 != null) {
            this.B.setColor(baseKeyframeAnimation3.e().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.J;
            if (baseKeyframeAnimation4 != null) {
                this.B.setColor(baseKeyframeAnimation4.e().intValue());
            } else {
                this.B.setColor(documentDataE.i);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation5 = this.v.j;
        int iIntValue = ((baseKeyframeAnimation5 == null ? 100 : baseKeyframeAnimation5.e().intValue()) * 255) / 100;
        this.A.setAlpha(iIntValue);
        this.B.setAlpha(iIntValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.M;
        if (baseKeyframeAnimation6 != null) {
            this.B.setStrokeWidth(baseKeyframeAnimation6.e().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.L;
            if (baseKeyframeAnimation7 != null) {
                this.B.setStrokeWidth(baseKeyframeAnimation7.e().floatValue());
            } else {
                this.B.setStrokeWidth(Utils.c() * documentDataE.j * Utils.d(matrix));
            }
        }
        if (this.F.k.g.size() > 0) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation8 = this.P;
            float fFloatValue3 = (baseKeyframeAnimation8 != null ? baseKeyframeAnimation8.e().floatValue() : documentDataE.c) / 100.0f;
            float fD = Utils.d(matrix);
            String str3 = documentDataE.a;
            float fC = Utils.c() * documentDataE.f;
            List<String> listT = t(str3);
            int size = listT.size();
            int i4 = 0;
            while (i4 < size) {
                String str4 = listT.get(i4);
                float fC2 = 0.0f;
                int i5 = 0;
                while (i5 < str4.length()) {
                    FontCharacter fontCharacter = this.G.g.get(FontCharacter.a(str4.charAt(i5), font.a, font.c));
                    if (fontCharacter != null) {
                        fC2 = (float) ((fontCharacter.c * ((double) fFloatValue3) * ((double) Utils.c()) * ((double) fD)) + ((double) fC2));
                    }
                    i5++;
                    str4 = str4;
                    fC = fC;
                    i4 = i4;
                }
                float f = fC;
                int i6 = i4;
                String str5 = str4;
                canvas.save();
                q(documentDataE.d, canvas, fC2);
                canvas.translate(0.0f, (i6 * f) - (((size - 1) * f) / 2.0f));
                int i7 = 0;
                while (i7 < str5.length()) {
                    String str6 = str5;
                    FontCharacter fontCharacter2 = this.G.g.get(FontCharacter.a(str6.charAt(i7), font.a, font.c));
                    if (fontCharacter2 == null) {
                        listT = listT;
                        i3 = size;
                        str2 = str6;
                    } else {
                        if (this.C.containsKey(fontCharacter2)) {
                            list = this.C.get(fontCharacter2);
                            i3 = size;
                            str2 = str6;
                        } else {
                            List<ShapeGroup> list2 = fontCharacter2.a;
                            int size2 = list2.size();
                            ArrayList arrayList = new ArrayList(size2);
                            int i8 = 0;
                            while (i8 < size2) {
                                arrayList.add(new ContentGroup(this.F, this, list2.get(i8)));
                                i8++;
                                str6 = str6;
                                size = size;
                                list2 = list2;
                            }
                            i3 = size;
                            str2 = str6;
                            this.C.put(fontCharacter2, arrayList);
                            list = arrayList;
                        }
                        int i9 = 0;
                        while (i9 < list.size()) {
                            Path path = list.get(i9).getPath();
                            path.computeBounds(this.f445y, false);
                            this.f446z.set(matrix);
                            List<ContentGroup> list3 = list;
                            this.f446z.preTranslate(0.0f, (-documentDataE.g) * Utils.c());
                            this.f446z.preScale(fFloatValue3, fFloatValue3);
                            path.transform(this.f446z);
                            if (documentDataE.k) {
                                s(path, this.A, canvas);
                                s(path, this.B, canvas);
                            } else {
                                s(path, this.B, canvas);
                                s(path, this.A, canvas);
                            }
                            i9++;
                            list = list3;
                        }
                        float fC3 = Utils.c() * ((float) fontCharacter2.c) * fFloatValue3 * fD;
                        float f2 = documentDataE.e / 10.0f;
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation9 = this.O;
                        if (baseKeyframeAnimation9 != null) {
                            fFloatValue2 = baseKeyframeAnimation9.e().floatValue();
                        } else {
                            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation10 = this.N;
                            if (baseKeyframeAnimation10 != null) {
                                fFloatValue2 = baseKeyframeAnimation10.e().floatValue();
                            }
                            canvas.translate((f2 * fD) + fC3, 0.0f);
                        }
                        f2 += fFloatValue2;
                        canvas.translate((f2 * fD) + fC3, 0.0f);
                    }
                    i7++;
                    listT = listT;
                    str5 = str2;
                    size = i3;
                }
                canvas.restore();
                i4 = i6 + 1;
                fC = f;
            }
        } else {
            float fD2 = Utils.d(matrix);
            LottieDrawable lottieDrawable = this.F;
            String str7 = font.a;
            String str8 = font.c;
            Typeface typefaceCreate = null;
            if (lottieDrawable.getCallback() == null) {
                fontAssetManager = null;
            } else {
                if (lottieDrawable.v == null) {
                    lottieDrawable.v = new FontAssetManager(lottieDrawable.getCallback());
                }
                fontAssetManager = lottieDrawable.v;
            }
            if (fontAssetManager != null) {
                MutablePair<String> mutablePair = fontAssetManager.a;
                mutablePair.a = str7;
                mutablePair.f411b = str8;
                typefaceCreate = fontAssetManager.f397b.get(mutablePair);
                if (typefaceCreate == null) {
                    Typeface typefaceCreateFromAsset = fontAssetManager.c.get(str7);
                    if (typefaceCreateFromAsset == null) {
                        StringBuilder sbX = outline.X("fonts/", str7);
                        sbX.append(fontAssetManager.e);
                        typefaceCreateFromAsset = Typeface.createFromAsset(fontAssetManager.d, sbX.toString());
                        fontAssetManager.c.put(str7, typefaceCreateFromAsset);
                    }
                    boolean zContains = str8.contains("Italic");
                    boolean zContains2 = str8.contains("Bold");
                    if (zContains && zContains2) {
                        i2 = 3;
                    } else if (zContains) {
                        i2 = 2;
                    } else {
                        i2 = zContains2 ? 1 : 0;
                    }
                    typefaceCreate = typefaceCreateFromAsset.getStyle() == i2 ? typefaceCreateFromAsset : Typeface.create(typefaceCreateFromAsset, i2);
                    fontAssetManager.f397b.put(fontAssetManager.a, typefaceCreate);
                }
            }
            if (typefaceCreate != null) {
                String str9 = documentDataE.a;
                Objects.requireNonNull(this.F);
                this.A.setTypeface(typefaceCreate);
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation11 = this.P;
                this.A.setTextSize(Utils.c() * (baseKeyframeAnimation11 != null ? baseKeyframeAnimation11.e().floatValue() : documentDataE.c));
                this.B.setTypeface(this.A.getTypeface());
                this.B.setTextSize(this.A.getTextSize());
                float fC4 = Utils.c() * documentDataE.f;
                List<String> listT2 = t(str9);
                int size3 = listT2.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    String str10 = listT2.get(i10);
                    q(documentDataE.d, canvas, this.B.measureText(str10));
                    canvas.translate(0.0f, (i10 * fC4) - (((size3 - 1) * fC4) / 2.0f));
                    int length = 0;
                    while (length < str10.length()) {
                        int iCodePointAt = str10.codePointAt(length);
                        int iCharCount = Character.charCount(iCodePointAt) + length;
                        while (iCharCount < str10.length()) {
                            int iCodePointAt2 = str10.codePointAt(iCharCount);
                            if (!(Character.getType(iCodePointAt2) == 16 || Character.getType(iCodePointAt2) == 27 || Character.getType(iCodePointAt2) == 6 || Character.getType(iCodePointAt2) == 28 || Character.getType(iCodePointAt2) == 19)) {
                                break;
                            }
                            iCharCount += Character.charCount(iCodePointAt2);
                            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                        }
                        int i11 = size3;
                        float f3 = fC4;
                        long j = iCodePointAt;
                        if (this.D.containsKey(j)) {
                            str = this.D.get(j);
                        } else {
                            this.f444x.setLength(0);
                            int iCharCount2 = length;
                            while (iCharCount2 < iCharCount) {
                                int iCodePointAt3 = str10.codePointAt(iCharCount2);
                                this.f444x.appendCodePoint(iCodePointAt3);
                                iCharCount2 += Character.charCount(iCodePointAt3);
                            }
                            String string = this.f444x.toString();
                            this.D.put(j, string);
                            str = string;
                        }
                        length += str.length();
                        if (documentDataE.k) {
                            r(str, this.A, canvas);
                            r(str, this.B, canvas);
                        } else {
                            r(str, this.B, canvas);
                            r(str, this.A, canvas);
                        }
                        float fMeasureText = this.A.measureText(str, 0, 1);
                        float f4 = documentDataE.e / 10.0f;
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation12 = this.O;
                        if (baseKeyframeAnimation12 != null) {
                            fFloatValue = baseKeyframeAnimation12.e().floatValue();
                        } else {
                            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation13 = this.N;
                            if (baseKeyframeAnimation13 != null) {
                                fFloatValue = baseKeyframeAnimation13.e().floatValue();
                            }
                            canvas.translate((f4 * fD2) + fMeasureText, 0.0f);
                            fC4 = f3;
                            size3 = i11;
                        }
                        f4 += fFloatValue;
                        canvas.translate((f4 * fD2) + fMeasureText, 0.0f);
                        fC4 = f3;
                        size3 = i11;
                    }
                    canvas.setMatrix(matrix);
                }
            }
        }
        canvas.restore();
    }

    public final void q(int i, Canvas canvas, float f) {
        int iH = b.c.a.y.b.h(i);
        if (iH == 1) {
            canvas.translate(-f, 0.0f);
        } else {
            if (iH != 2) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    public final void r(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void s(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final List<String> t(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }
}
