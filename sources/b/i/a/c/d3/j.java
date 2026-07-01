package b.i.a.c.d3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout$Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.i.a.c.b3.b$b;
import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.ui.SubtitleView$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: CanvasSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends View implements SubtitleView$a {
    public final List<n> j;
    public List<b.i.a.c.b3.b> k;
    public int l;
    public float m;
    public k n;
    public float o;

    public j(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList();
        this.k = Collections.emptyList();
        this.l = 0;
        this.m = 0.0533f;
        this.n = k.a;
        this.o = 0.08f;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView$a
    public void a(List<b.i.a.c.b3.b> list, k kVar, float f, int i, float f2) {
        this.k = list;
        this.n = kVar;
        this.m = f;
        this.l = i;
        this.o = f2;
        while (this.j.size() < list.size()) {
            this.j.add(new n(getContext()));
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:192:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:193:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:195:0x04ac  */
    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        boolean z2;
        int i3;
        float f;
        int i4;
        float f2;
        boolean z3;
        int i5;
        int iMax;
        int iMin;
        int iRound;
        int i6;
        j jVar = this;
        Canvas canvas2 = canvas;
        List<b.i.a.c.b3.b> list = jVar.k;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i7 = paddingBottom - paddingTop;
        float fU1 = b.c.a.a0.d.U1(jVar.l, jVar.m, height, i7);
        if (fU1 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i8 = 0;
        while (i8 < size) {
            b.i.a.c.b3.b bVarA = list.get(i8);
            if (bVarA.A != Integer.MIN_VALUE) {
                b$b b_bA = bVarA.a();
                b_bA.h = -3.4028235E38f;
                b_bA.i = Integer.MIN_VALUE;
                b_bA.c = null;
                if (bVarA.q == 0) {
                    b_bA.e = 1.0f - bVarA.p;
                    b_bA.f = 0;
                } else {
                    b_bA.e = (-bVarA.p) - 1.0f;
                    b_bA.f = 1;
                }
                int i9 = bVarA.r;
                if (i9 == 0) {
                    b_bA.g = 2;
                } else if (i9 == 2) {
                    b_bA.g = 0;
                }
                bVarA = b_bA.a();
            }
            float fU2 = b.c.a.a0.d.U1(bVarA.f840y, bVarA.f841z, height, i7);
            n nVar = jVar.j.get(i8);
            k kVar = jVar.n;
            List<b.i.a.c.b3.b> list2 = list;
            float f3 = jVar.o;
            Objects.requireNonNull(nVar);
            boolean z4 = bVarA.o == null;
            int i10 = height;
            if (z4) {
                if (TextUtils.isEmpty(bVarA.l)) {
                    i7 = i7;
                    i2 = size;
                } else {
                    i = bVarA.w ? bVarA.f839x : kVar.d;
                }
                i3 = i8;
                i8 = i3 + 1;
                canvas2 = canvas2;
                list = list2;
                i7 = i7;
                height = i10;
                size = i2;
                paddingLeft = paddingLeft;
                paddingTop = paddingTop;
                width = width;
                paddingBottom = paddingBottom;
                fU1 = fU1;
                jVar = this;
            } else {
                i = ViewCompat.MEASURED_STATE_MASK;
            }
            CharSequence charSequence = nVar.i;
            i2 = size;
            CharSequence charSequence2 = bVarA.l;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && e0.a(nVar.j, bVarA.m) && nVar.k == bVarA.o && nVar.l == bVarA.p && nVar.m == bVarA.q && e0.a(Integer.valueOf(nVar.n), Integer.valueOf(bVarA.r)) && nVar.o == bVarA.f838s && e0.a(Integer.valueOf(nVar.p), Integer.valueOf(bVarA.t)) && nVar.q == bVarA.u && nVar.r == bVarA.v && nVar.f919s == kVar.f914b && nVar.t == kVar.c && nVar.u == i && nVar.w == kVar.e && nVar.v == kVar.f && e0.a(nVar.f.getTypeface(), kVar.g) && nVar.f920x == fU1 && nVar.f921y == fU2 && nVar.f922z == f3 && nVar.A == paddingLeft && nVar.B == paddingTop && nVar.C == width && nVar.D == paddingBottom) {
                nVar.a(canvas2, z4);
                i3 = i8;
            } else {
                nVar.i = bVarA.l;
                nVar.j = bVarA.m;
                nVar.k = bVarA.o;
                nVar.l = bVarA.p;
                nVar.m = bVarA.q;
                nVar.n = bVarA.r;
                nVar.o = bVarA.f838s;
                nVar.p = bVarA.t;
                nVar.q = bVarA.u;
                nVar.r = bVarA.v;
                nVar.f919s = kVar.f914b;
                nVar.t = kVar.c;
                nVar.u = i;
                nVar.w = kVar.e;
                nVar.v = kVar.f;
                nVar.f.setTypeface(kVar.g);
                nVar.f920x = fU1;
                nVar.f921y = fU2;
                nVar.f922z = f3;
                nVar.A = paddingLeft;
                nVar.B = paddingTop;
                nVar.C = width;
                nVar.D = paddingBottom;
                if (z4) {
                    Objects.requireNonNull(nVar.i);
                    CharSequence charSequence3 = nVar.i;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(nVar.i);
                    int i11 = nVar.C - nVar.A;
                    int i12 = nVar.D - nVar.B;
                    nVar.f.setTextSize(nVar.f920x);
                    int i13 = (int) ((nVar.f920x * 0.125f) + 0.5f);
                    int i14 = i13 * 2;
                    int i15 = i11 - i14;
                    float f4 = nVar.q;
                    if (f4 != -3.4028235E38f) {
                        i15 = (int) (i15 * f4);
                    }
                    if (i15 <= 0) {
                        Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                        paddingLeft = paddingLeft;
                        paddingTop = paddingTop;
                        width = width;
                        paddingBottom = paddingBottom;
                        fU1 = fU1;
                        i3 = i8;
                        Canvas canvas3 = canvas2;
                        z3 = z4;
                        canvas2 = canvas3;
                    } else {
                        paddingLeft = paddingLeft;
                        paddingTop = paddingTop;
                        if (nVar.f921y > 0.0f) {
                            i5 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) nVar.f921y), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i5 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (nVar.w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i5, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i16 = 0;
                            for (int length = foregroundColorSpanArr.length; i16 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i16]);
                                i16++;
                            }
                        }
                        if (Color.alpha(nVar.t) > 0) {
                            int i17 = nVar.w;
                            if (i17 == 0 || i17 == 2) {
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(nVar.t), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(nVar.t), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        }
                        Layout$Alignment layout$Alignment = nVar.j;
                        if (layout$Alignment == null) {
                            layout$Alignment = Layout$Alignment.ALIGN_CENTER;
                        }
                        i3 = i8;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, nVar.f, i15, layout$Alignment, nVar.d, nVar.e, true);
                        nVar.E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = nVar.E.getLineCount();
                        int i18 = 0;
                        int iMax2 = 0;
                        while (i18 < lineCount) {
                            iMax2 = Math.max((int) Math.ceil(nVar.E.getLineWidth(i18)), iMax2);
                            i18++;
                            lineCount = lineCount;
                            z4 = z4;
                        }
                        z2 = z4;
                        if (nVar.q == -3.4028235E38f || iMax2 >= i15) {
                            i15 = iMax2;
                        }
                        int i19 = i15 + i14;
                        float f5 = nVar.o;
                        if (f5 != -3.4028235E38f) {
                            int iRound2 = Math.round(i11 * f5);
                            int i20 = nVar.A;
                            int i21 = iRound2 + i20;
                            int i22 = nVar.p;
                            if (i22 == 1) {
                                i21 = ((i21 * 2) - i19) / 2;
                            } else if (i22 == 2) {
                                i21 -= i19;
                            }
                            iMax = Math.max(i21, i20);
                            iMin = Math.min(i19 + iMax, nVar.C);
                        } else {
                            iMax = nVar.A + ((i11 - i19) / 2);
                            iMin = iMax + i19;
                        }
                        int i23 = iMin - iMax;
                        if (i23 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            canvas2 = canvas;
                            z3 = z2;
                        } else {
                            float f6 = nVar.l;
                            if (f6 != -3.4028235E38f) {
                                if (nVar.m == 0) {
                                    iRound = Math.round(i12 * f6) + nVar.B;
                                    int i24 = nVar.n;
                                    if (i24 == 2) {
                                        iRound -= height2;
                                    } else if (i24 == 1) {
                                        iRound = ((iRound * 2) - height2) / 2;
                                    }
                                } else {
                                    int lineBottom = nVar.E.getLineBottom(0) - nVar.E.getLineTop(0);
                                    float f7 = nVar.l;
                                    if (f7 >= 0.0f) {
                                        iRound = Math.round(f7 * lineBottom) + nVar.B;
                                    } else {
                                        iRound = Math.round((f7 + 1.0f) * lineBottom) + nVar.D;
                                        iRound -= height2;
                                    }
                                }
                                int i25 = iRound + height2;
                                int i26 = nVar.D;
                                if (i25 > i26) {
                                    iRound = i26 - height2;
                                } else {
                                    i6 = nVar.B;
                                    if (iRound >= i6) {
                                    }
                                    Layout$Alignment layout$Alignment2 = layout$Alignment;
                                    nVar.E = new StaticLayout(spannableStringBuilder, nVar.f, i23, layout$Alignment2, nVar.d, nVar.e, true);
                                    nVar.F = new StaticLayout(spannableStringBuilder2, nVar.f, i23, layout$Alignment2, nVar.d, nVar.e, true);
                                    nVar.G = iMax;
                                    nVar.H = i6;
                                    nVar.I = i13;
                                }
                            } else {
                                iRound = (nVar.D - height2) - ((int) (i12 * nVar.f922z));
                            }
                            i6 = iRound;
                            Layout$Alignment layout$Alignment3 = layout$Alignment;
                            nVar.E = new StaticLayout(spannableStringBuilder, nVar.f, i23, layout$Alignment3, nVar.d, nVar.e, true);
                            nVar.F = new StaticLayout(spannableStringBuilder2, nVar.f, i23, layout$Alignment3, nVar.d, nVar.e, true);
                            nVar.G = iMax;
                            nVar.H = i6;
                            nVar.I = i13;
                        }
                    }
                    nVar.a(canvas2, z3);
                } else {
                    z2 = z4;
                    paddingLeft = paddingLeft;
                    paddingTop = paddingTop;
                    width = width;
                    paddingBottom = paddingBottom;
                    fU1 = fU1;
                    i3 = i8;
                    Objects.requireNonNull(nVar.k);
                    Bitmap bitmap = nVar.k;
                    int i27 = nVar.C;
                    int i28 = nVar.A;
                    int i29 = nVar.D;
                    int i30 = nVar.B;
                    float f8 = i27 - i28;
                    float f9 = (nVar.o * f8) + i28;
                    float f10 = i29 - i30;
                    float f11 = (nVar.l * f10) + i30;
                    int iRound3 = Math.round(f8 * nVar.q);
                    float f12 = nVar.r;
                    int iRound4 = f12 != -3.4028235E38f ? Math.round(f10 * f12) : Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound3);
                    int i31 = nVar.p;
                    if (i31 == 2) {
                        f = iRound3;
                    } else {
                        if (i31 == 1) {
                            f = iRound3 / 2;
                        }
                        int iRound5 = Math.round(f9);
                        i4 = nVar.n;
                        if (i4 == 2) {
                            f2 = iRound4;
                        } else {
                            if (i4 == 1) {
                                f2 = iRound4 / 2;
                            }
                            int iRound6 = Math.round(f11);
                            nVar.J = new Rect(iRound5, iRound6, iRound3 + iRound5, iRound4 + iRound6);
                        }
                        f11 -= f2;
                        int iRound7 = Math.round(f11);
                        nVar.J = new Rect(iRound5, iRound7, iRound3 + iRound5, iRound4 + iRound7);
                    }
                    f9 -= f;
                    int iRound8 = Math.round(f9);
                    i4 = nVar.n;
                    if (i4 == 2) {
                        f2 = iRound4;
                    } else {
                        if (i4 == 1) {
                            f2 = iRound4 / 2;
                        }
                        int iRound9 = Math.round(f11);
                        nVar.J = new Rect(iRound8, iRound9, iRound3 + iRound8, iRound4 + iRound9);
                    }
                    f11 -= f2;
                    int iRound10 = Math.round(f11);
                    nVar.J = new Rect(iRound8, iRound10, iRound3 + iRound8, iRound4 + iRound10);
                }
                canvas2 = canvas;
                z3 = z2;
                nVar.a(canvas2, z3);
            }
            i8 = i3 + 1;
            canvas2 = canvas2;
            list = list2;
            i7 = i7;
            height = i10;
            size = i2;
            paddingLeft = paddingLeft;
            paddingTop = paddingTop;
            width = width;
            paddingBottom = paddingBottom;
            fU1 = fU1;
            jVar = this;
        }
    }
}
