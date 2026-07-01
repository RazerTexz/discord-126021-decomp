package b.i.a.c.d3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
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
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.d3.j, reason: use source file name */
/* JADX INFO: compiled from: CanvasSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CanvasSubtitleOutput extends View implements SubtitleView.a {
    public final List<SubtitlePainter> j;
    public List<Cue> k;
    public int l;
    public float m;
    public CaptionStyleCompat n;
    public float o;

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList();
        this.k = Collections.emptyList();
        this.l = 0;
        this.m = 0.0533f;
        this.n = CaptionStyleCompat.a;
        this.o = 0.08f;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.k = list;
        this.n = captionStyleCompat;
        this.m = f;
        this.l = i;
        this.o = f2;
        while (this.j.size() < list.size()) {
            this.j.add(new SubtitlePainter(getContext()));
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
        CanvasSubtitleOutput canvasSubtitleOutput = this;
        Canvas canvas2 = canvas;
        List<Cue> list = canvasSubtitleOutput.k;
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
        float fU1 = AnimatableValueParser.U1(canvasSubtitleOutput.l, canvasSubtitleOutput.m, height, i7);
        if (fU1 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i8 = 0;
        while (i8 < size) {
            Cue cueA = list.get(i8);
            if (cueA.A != Integer.MIN_VALUE) {
                Cue.b bVarA = cueA.a();
                bVarA.h = -3.4028235E38f;
                bVarA.i = Integer.MIN_VALUE;
                bVarA.c = null;
                if (cueA.q == 0) {
                    bVarA.e = 1.0f - cueA.p;
                    bVarA.f = 0;
                } else {
                    bVarA.e = (-cueA.p) - 1.0f;
                    bVarA.f = 1;
                }
                int i9 = cueA.r;
                if (i9 == 0) {
                    bVarA.g = 2;
                } else if (i9 == 2) {
                    bVarA.g = 0;
                }
                cueA = bVarA.a();
            }
            float fU2 = AnimatableValueParser.U1(cueA.f840y, cueA.f841z, height, i7);
            SubtitlePainter subtitlePainter = canvasSubtitleOutput.j.get(i8);
            CaptionStyleCompat captionStyleCompat = canvasSubtitleOutput.n;
            List<Cue> list2 = list;
            float f3 = canvasSubtitleOutput.o;
            Objects.requireNonNull(subtitlePainter);
            boolean z4 = cueA.o == null;
            int i10 = height;
            if (z4) {
                if (TextUtils.isEmpty(cueA.l)) {
                    i7 = i7;
                    i2 = size;
                } else {
                    i = cueA.w ? cueA.f839x : captionStyleCompat.d;
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
                canvasSubtitleOutput = this;
            } else {
                i = ViewCompat.MEASURED_STATE_MASK;
            }
            CharSequence charSequence = subtitlePainter.i;
            i2 = size;
            CharSequence charSequence2 = cueA.l;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && Util2.a(subtitlePainter.j, cueA.m) && subtitlePainter.k == cueA.o && subtitlePainter.l == cueA.p && subtitlePainter.m == cueA.q && Util2.a(Integer.valueOf(subtitlePainter.n), Integer.valueOf(cueA.r)) && subtitlePainter.o == cueA.f838s && Util2.a(Integer.valueOf(subtitlePainter.p), Integer.valueOf(cueA.t)) && subtitlePainter.q == cueA.u && subtitlePainter.r == cueA.v && subtitlePainter.f919s == captionStyleCompat.f914b && subtitlePainter.t == captionStyleCompat.c && subtitlePainter.u == i && subtitlePainter.w == captionStyleCompat.e && subtitlePainter.v == captionStyleCompat.f && Util2.a(subtitlePainter.f.getTypeface(), captionStyleCompat.g) && subtitlePainter.f920x == fU1 && subtitlePainter.f921y == fU2 && subtitlePainter.f922z == f3 && subtitlePainter.A == paddingLeft && subtitlePainter.B == paddingTop && subtitlePainter.C == width && subtitlePainter.D == paddingBottom) {
                subtitlePainter.a(canvas2, z4);
                i3 = i8;
            } else {
                subtitlePainter.i = cueA.l;
                subtitlePainter.j = cueA.m;
                subtitlePainter.k = cueA.o;
                subtitlePainter.l = cueA.p;
                subtitlePainter.m = cueA.q;
                subtitlePainter.n = cueA.r;
                subtitlePainter.o = cueA.f838s;
                subtitlePainter.p = cueA.t;
                subtitlePainter.q = cueA.u;
                subtitlePainter.r = cueA.v;
                subtitlePainter.f919s = captionStyleCompat.f914b;
                subtitlePainter.t = captionStyleCompat.c;
                subtitlePainter.u = i;
                subtitlePainter.w = captionStyleCompat.e;
                subtitlePainter.v = captionStyleCompat.f;
                subtitlePainter.f.setTypeface(captionStyleCompat.g);
                subtitlePainter.f920x = fU1;
                subtitlePainter.f921y = fU2;
                subtitlePainter.f922z = f3;
                subtitlePainter.A = paddingLeft;
                subtitlePainter.B = paddingTop;
                subtitlePainter.C = width;
                subtitlePainter.D = paddingBottom;
                if (z4) {
                    Objects.requireNonNull(subtitlePainter.i);
                    CharSequence charSequence3 = subtitlePainter.i;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(subtitlePainter.i);
                    int i11 = subtitlePainter.C - subtitlePainter.A;
                    int i12 = subtitlePainter.D - subtitlePainter.B;
                    subtitlePainter.f.setTextSize(subtitlePainter.f920x);
                    int i13 = (int) ((subtitlePainter.f920x * 0.125f) + 0.5f);
                    int i14 = i13 * 2;
                    int i15 = i11 - i14;
                    float f4 = subtitlePainter.q;
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
                        if (subtitlePainter.f921y > 0.0f) {
                            i5 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) subtitlePainter.f921y), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i5 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (subtitlePainter.w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i5, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i16 = 0;
                            for (int length = foregroundColorSpanArr.length; i16 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i16]);
                                i16++;
                            }
                        }
                        if (Color.alpha(subtitlePainter.t) > 0) {
                            int i17 = subtitlePainter.w;
                            if (i17 == 0 || i17 == 2) {
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(subtitlePainter.t), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(subtitlePainter.t), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        }
                        Layout.Alignment alignment = subtitlePainter.j;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        i3 = i8;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, subtitlePainter.f, i15, alignment, subtitlePainter.d, subtitlePainter.e, true);
                        subtitlePainter.E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = subtitlePainter.E.getLineCount();
                        int i18 = 0;
                        int iMax2 = 0;
                        while (i18 < lineCount) {
                            iMax2 = Math.max((int) Math.ceil(subtitlePainter.E.getLineWidth(i18)), iMax2);
                            i18++;
                            lineCount = lineCount;
                            z4 = z4;
                        }
                        z2 = z4;
                        if (subtitlePainter.q == -3.4028235E38f || iMax2 >= i15) {
                            i15 = iMax2;
                        }
                        int i19 = i15 + i14;
                        float f5 = subtitlePainter.o;
                        if (f5 != -3.4028235E38f) {
                            int iRound2 = Math.round(i11 * f5);
                            int i20 = subtitlePainter.A;
                            int i21 = iRound2 + i20;
                            int i22 = subtitlePainter.p;
                            if (i22 == 1) {
                                i21 = ((i21 * 2) - i19) / 2;
                            } else if (i22 == 2) {
                                i21 -= i19;
                            }
                            iMax = Math.max(i21, i20);
                            iMin = Math.min(i19 + iMax, subtitlePainter.C);
                        } else {
                            iMax = subtitlePainter.A + ((i11 - i19) / 2);
                            iMin = iMax + i19;
                        }
                        int i23 = iMin - iMax;
                        if (i23 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            canvas2 = canvas;
                            z3 = z2;
                        } else {
                            float f6 = subtitlePainter.l;
                            if (f6 != -3.4028235E38f) {
                                if (subtitlePainter.m == 0) {
                                    iRound = Math.round(i12 * f6) + subtitlePainter.B;
                                    int i24 = subtitlePainter.n;
                                    if (i24 == 2) {
                                        iRound -= height2;
                                    } else if (i24 == 1) {
                                        iRound = ((iRound * 2) - height2) / 2;
                                    }
                                } else {
                                    int lineBottom = subtitlePainter.E.getLineBottom(0) - subtitlePainter.E.getLineTop(0);
                                    float f7 = subtitlePainter.l;
                                    if (f7 >= 0.0f) {
                                        iRound = Math.round(f7 * lineBottom) + subtitlePainter.B;
                                    } else {
                                        iRound = Math.round((f7 + 1.0f) * lineBottom) + subtitlePainter.D;
                                        iRound -= height2;
                                    }
                                }
                                int i25 = iRound + height2;
                                int i26 = subtitlePainter.D;
                                if (i25 > i26) {
                                    iRound = i26 - height2;
                                } else {
                                    i6 = subtitlePainter.B;
                                    if (iRound >= i6) {
                                    }
                                    Layout.Alignment alignment2 = alignment;
                                    subtitlePainter.E = new StaticLayout(spannableStringBuilder, subtitlePainter.f, i23, alignment2, subtitlePainter.d, subtitlePainter.e, true);
                                    subtitlePainter.F = new StaticLayout(spannableStringBuilder2, subtitlePainter.f, i23, alignment2, subtitlePainter.d, subtitlePainter.e, true);
                                    subtitlePainter.G = iMax;
                                    subtitlePainter.H = i6;
                                    subtitlePainter.I = i13;
                                }
                            } else {
                                iRound = (subtitlePainter.D - height2) - ((int) (i12 * subtitlePainter.f922z));
                            }
                            i6 = iRound;
                            Layout.Alignment alignment3 = alignment;
                            subtitlePainter.E = new StaticLayout(spannableStringBuilder, subtitlePainter.f, i23, alignment3, subtitlePainter.d, subtitlePainter.e, true);
                            subtitlePainter.F = new StaticLayout(spannableStringBuilder2, subtitlePainter.f, i23, alignment3, subtitlePainter.d, subtitlePainter.e, true);
                            subtitlePainter.G = iMax;
                            subtitlePainter.H = i6;
                            subtitlePainter.I = i13;
                        }
                    }
                    subtitlePainter.a(canvas2, z3);
                } else {
                    z2 = z4;
                    paddingLeft = paddingLeft;
                    paddingTop = paddingTop;
                    width = width;
                    paddingBottom = paddingBottom;
                    fU1 = fU1;
                    i3 = i8;
                    Objects.requireNonNull(subtitlePainter.k);
                    Bitmap bitmap = subtitlePainter.k;
                    int i27 = subtitlePainter.C;
                    int i28 = subtitlePainter.A;
                    int i29 = subtitlePainter.D;
                    int i30 = subtitlePainter.B;
                    float f8 = i27 - i28;
                    float f9 = (subtitlePainter.o * f8) + i28;
                    float f10 = i29 - i30;
                    float f11 = (subtitlePainter.l * f10) + i30;
                    int iRound3 = Math.round(f8 * subtitlePainter.q);
                    float f12 = subtitlePainter.r;
                    int iRound4 = f12 != -3.4028235E38f ? Math.round(f10 * f12) : Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound3);
                    int i31 = subtitlePainter.p;
                    if (i31 == 2) {
                        f = iRound3;
                    } else {
                        if (i31 == 1) {
                            f = iRound3 / 2;
                        }
                        int iRound5 = Math.round(f9);
                        i4 = subtitlePainter.n;
                        if (i4 == 2) {
                            f2 = iRound4;
                        } else {
                            if (i4 == 1) {
                                f2 = iRound4 / 2;
                            }
                            int iRound6 = Math.round(f11);
                            subtitlePainter.J = new Rect(iRound5, iRound6, iRound3 + iRound5, iRound4 + iRound6);
                        }
                        f11 -= f2;
                        int iRound7 = Math.round(f11);
                        subtitlePainter.J = new Rect(iRound5, iRound7, iRound3 + iRound5, iRound4 + iRound7);
                    }
                    f9 -= f;
                    int iRound8 = Math.round(f9);
                    i4 = subtitlePainter.n;
                    if (i4 == 2) {
                        f2 = iRound4;
                    } else {
                        if (i4 == 1) {
                            f2 = iRound4 / 2;
                        }
                        int iRound9 = Math.round(f11);
                        subtitlePainter.J = new Rect(iRound8, iRound9, iRound3 + iRound8, iRound4 + iRound9);
                    }
                    f11 -= f2;
                    int iRound10 = Math.round(f11);
                    subtitlePainter.J = new Rect(iRound8, iRound10, iRound3 + iRound8, iRound4 + iRound10);
                }
                canvas2 = canvas;
                z3 = z2;
                subtitlePainter.a(canvas2, z3);
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
            canvasSubtitleOutput = this;
        }
    }
}
