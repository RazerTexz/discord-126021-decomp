package p007b.p225i.p226a.p242c.p256d3;

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
import com.google.android.exoplayer2.p505ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.d3.j */
/* JADX INFO: compiled from: CanvasSubtitleOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2666j extends View implements SubtitleView.InterfaceC10760a {

    /* JADX INFO: renamed from: j */
    public final List<C2670n> f6343j;

    /* JADX INFO: renamed from: k */
    public List<C2578b> f6344k;

    /* JADX INFO: renamed from: l */
    public int f6345l;

    /* JADX INFO: renamed from: m */
    public float f6346m;

    /* JADX INFO: renamed from: n */
    public C2667k f6347n;

    /* JADX INFO: renamed from: o */
    public float f6348o;

    public C2666j(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6343j = new ArrayList();
        this.f6344k = Collections.emptyList();
        this.f6345l = 0;
        this.f6346m = 0.0533f;
        this.f6347n = C2667k.f6349a;
        this.f6348o = 0.08f;
    }

    @Override // com.google.android.exoplayer2.p505ui.SubtitleView.InterfaceC10760a
    /* JADX INFO: renamed from: a */
    public void mo2758a(List<C2578b> list, C2667k c2667k, float f, int i, float f2) {
        this.f6344k = list;
        this.f6347n = c2667k;
        this.f6346m = f;
        this.f6345l = i;
        this.f6348o = f2;
        while (this.f6343j.size() < list.size()) {
            this.f6343j.add(new C2670n(getContext()));
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
        C2666j c2666j = this;
        Canvas canvas2 = canvas;
        List<C2578b> list = c2666j.f6344k;
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
        float fM479U1 = C1460d.m479U1(c2666j.f6345l, c2666j.f6346m, height, i7);
        if (fM479U1 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i8 = 0;
        while (i8 < size) {
            C2578b c2578bM2606a = list.get(i8);
            if (c2578bM2606a.f5756A != Integer.MIN_VALUE) {
                C2578b.b bVarM2605a = c2578bM2606a.m2605a();
                bVarM2605a.f5780h = -3.4028235E38f;
                bVarM2605a.f5781i = Integer.MIN_VALUE;
                bVarM2605a.f5775c = null;
                if (c2578bM2606a.f5763q == 0) {
                    bVarM2605a.f5777e = 1.0f - c2578bM2606a.f5762p;
                    bVarM2605a.f5778f = 0;
                } else {
                    bVarM2605a.f5777e = (-c2578bM2606a.f5762p) - 1.0f;
                    bVarM2605a.f5778f = 1;
                }
                int i9 = c2578bM2606a.f5764r;
                if (i9 == 0) {
                    bVarM2605a.f5779g = 2;
                } else if (i9 == 2) {
                    bVarM2605a.f5779g = 0;
                }
                c2578bM2606a = bVarM2605a.m2606a();
            }
            float fM479U2 = C1460d.m479U1(c2578bM2606a.f5771y, c2578bM2606a.f5772z, height, i7);
            C2670n c2670n = c2666j.f6343j.get(i8);
            C2667k c2667k = c2666j.f6347n;
            List<C2578b> list2 = list;
            float f3 = c2666j.f6348o;
            Objects.requireNonNull(c2670n);
            boolean z4 = c2578bM2606a.f5761o == null;
            int i10 = height;
            if (z4) {
                if (TextUtils.isEmpty(c2578bM2606a.f5758l)) {
                    i7 = i7;
                    i2 = size;
                } else {
                    i = c2578bM2606a.f5769w ? c2578bM2606a.f5770x : c2667k.f6352d;
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
                fM479U1 = fM479U1;
                c2666j = this;
            } else {
                i = ViewCompat.MEASURED_STATE_MASK;
            }
            CharSequence charSequence = c2670n.f6384i;
            i2 = size;
            CharSequence charSequence2 = c2578bM2606a.f5758l;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && C2738e0.m2993a(c2670n.f6385j, c2578bM2606a.f5759m) && c2670n.f6386k == c2578bM2606a.f5761o && c2670n.f6387l == c2578bM2606a.f5762p && c2670n.f6388m == c2578bM2606a.f5763q && C2738e0.m2993a(Integer.valueOf(c2670n.f6389n), Integer.valueOf(c2578bM2606a.f5764r)) && c2670n.f6390o == c2578bM2606a.f5765s && C2738e0.m2993a(Integer.valueOf(c2670n.f6391p), Integer.valueOf(c2578bM2606a.f5766t)) && c2670n.f6392q == c2578bM2606a.f5767u && c2670n.f6393r == c2578bM2606a.f5768v && c2670n.f6394s == c2667k.f6350b && c2670n.f6395t == c2667k.f6351c && c2670n.f6396u == i && c2670n.f6398w == c2667k.f6353e && c2670n.f6397v == c2667k.f6354f && C2738e0.m2993a(c2670n.f6381f.getTypeface(), c2667k.f6355g) && c2670n.f6399x == fM479U1 && c2670n.f6400y == fM479U2 && c2670n.f6401z == f3 && c2670n.f6366A == paddingLeft && c2670n.f6367B == paddingTop && c2670n.f6368C == width && c2670n.f6369D == paddingBottom) {
                c2670n.m2760a(canvas2, z4);
                i3 = i8;
            } else {
                c2670n.f6384i = c2578bM2606a.f5758l;
                c2670n.f6385j = c2578bM2606a.f5759m;
                c2670n.f6386k = c2578bM2606a.f5761o;
                c2670n.f6387l = c2578bM2606a.f5762p;
                c2670n.f6388m = c2578bM2606a.f5763q;
                c2670n.f6389n = c2578bM2606a.f5764r;
                c2670n.f6390o = c2578bM2606a.f5765s;
                c2670n.f6391p = c2578bM2606a.f5766t;
                c2670n.f6392q = c2578bM2606a.f5767u;
                c2670n.f6393r = c2578bM2606a.f5768v;
                c2670n.f6394s = c2667k.f6350b;
                c2670n.f6395t = c2667k.f6351c;
                c2670n.f6396u = i;
                c2670n.f6398w = c2667k.f6353e;
                c2670n.f6397v = c2667k.f6354f;
                c2670n.f6381f.setTypeface(c2667k.f6355g);
                c2670n.f6399x = fM479U1;
                c2670n.f6400y = fM479U2;
                c2670n.f6401z = f3;
                c2670n.f6366A = paddingLeft;
                c2670n.f6367B = paddingTop;
                c2670n.f6368C = width;
                c2670n.f6369D = paddingBottom;
                if (z4) {
                    Objects.requireNonNull(c2670n.f6384i);
                    CharSequence charSequence3 = c2670n.f6384i;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(c2670n.f6384i);
                    int i11 = c2670n.f6368C - c2670n.f6366A;
                    int i12 = c2670n.f6369D - c2670n.f6367B;
                    c2670n.f6381f.setTextSize(c2670n.f6399x);
                    int i13 = (int) ((c2670n.f6399x * 0.125f) + 0.5f);
                    int i14 = i13 * 2;
                    int i15 = i11 - i14;
                    float f4 = c2670n.f6392q;
                    if (f4 != -3.4028235E38f) {
                        i15 = (int) (i15 * f4);
                    }
                    if (i15 <= 0) {
                        Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                        paddingLeft = paddingLeft;
                        paddingTop = paddingTop;
                        width = width;
                        paddingBottom = paddingBottom;
                        fM479U1 = fM479U1;
                        i3 = i8;
                        Canvas canvas3 = canvas2;
                        z3 = z4;
                        canvas2 = canvas3;
                    } else {
                        paddingLeft = paddingLeft;
                        paddingTop = paddingTop;
                        if (c2670n.f6400y > 0.0f) {
                            i5 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c2670n.f6400y), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i5 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (c2670n.f6398w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i5, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i16 = 0;
                            for (int length = foregroundColorSpanArr.length; i16 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i16]);
                                i16++;
                            }
                        }
                        if (Color.alpha(c2670n.f6395t) > 0) {
                            int i17 = c2670n.f6398w;
                            if (i17 == 0 || i17 == 2) {
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(c2670n.f6395t), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(c2670n.f6395t), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        }
                        Layout.Alignment alignment = c2670n.f6385j;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        i3 = i8;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, c2670n.f6381f, i15, alignment, c2670n.f6379d, c2670n.f6380e, true);
                        c2670n.f6370E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = c2670n.f6370E.getLineCount();
                        int i18 = 0;
                        int iMax2 = 0;
                        while (i18 < lineCount) {
                            iMax2 = Math.max((int) Math.ceil(c2670n.f6370E.getLineWidth(i18)), iMax2);
                            i18++;
                            lineCount = lineCount;
                            z4 = z4;
                        }
                        z2 = z4;
                        if (c2670n.f6392q == -3.4028235E38f || iMax2 >= i15) {
                            i15 = iMax2;
                        }
                        int i19 = i15 + i14;
                        float f5 = c2670n.f6390o;
                        if (f5 != -3.4028235E38f) {
                            int iRound2 = Math.round(i11 * f5);
                            int i20 = c2670n.f6366A;
                            int i21 = iRound2 + i20;
                            int i22 = c2670n.f6391p;
                            if (i22 == 1) {
                                i21 = ((i21 * 2) - i19) / 2;
                            } else if (i22 == 2) {
                                i21 -= i19;
                            }
                            iMax = Math.max(i21, i20);
                            iMin = Math.min(i19 + iMax, c2670n.f6368C);
                        } else {
                            iMax = c2670n.f6366A + ((i11 - i19) / 2);
                            iMin = iMax + i19;
                        }
                        int i23 = iMin - iMax;
                        if (i23 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            canvas2 = canvas;
                            z3 = z2;
                        } else {
                            float f6 = c2670n.f6387l;
                            if (f6 != -3.4028235E38f) {
                                if (c2670n.f6388m == 0) {
                                    iRound = Math.round(i12 * f6) + c2670n.f6367B;
                                    int i24 = c2670n.f6389n;
                                    if (i24 == 2) {
                                        iRound -= height2;
                                    } else if (i24 == 1) {
                                        iRound = ((iRound * 2) - height2) / 2;
                                    }
                                } else {
                                    int lineBottom = c2670n.f6370E.getLineBottom(0) - c2670n.f6370E.getLineTop(0);
                                    float f7 = c2670n.f6387l;
                                    if (f7 >= 0.0f) {
                                        iRound = Math.round(f7 * lineBottom) + c2670n.f6367B;
                                    } else {
                                        iRound = Math.round((f7 + 1.0f) * lineBottom) + c2670n.f6369D;
                                        iRound -= height2;
                                    }
                                }
                                int i25 = iRound + height2;
                                int i26 = c2670n.f6369D;
                                if (i25 > i26) {
                                    iRound = i26 - height2;
                                } else {
                                    i6 = c2670n.f6367B;
                                    if (iRound >= i6) {
                                    }
                                    Layout.Alignment alignment2 = alignment;
                                    c2670n.f6370E = new StaticLayout(spannableStringBuilder, c2670n.f6381f, i23, alignment2, c2670n.f6379d, c2670n.f6380e, true);
                                    c2670n.f6371F = new StaticLayout(spannableStringBuilder2, c2670n.f6381f, i23, alignment2, c2670n.f6379d, c2670n.f6380e, true);
                                    c2670n.f6372G = iMax;
                                    c2670n.f6373H = i6;
                                    c2670n.f6374I = i13;
                                }
                            } else {
                                iRound = (c2670n.f6369D - height2) - ((int) (i12 * c2670n.f6401z));
                            }
                            i6 = iRound;
                            Layout.Alignment alignment3 = alignment;
                            c2670n.f6370E = new StaticLayout(spannableStringBuilder, c2670n.f6381f, i23, alignment3, c2670n.f6379d, c2670n.f6380e, true);
                            c2670n.f6371F = new StaticLayout(spannableStringBuilder2, c2670n.f6381f, i23, alignment3, c2670n.f6379d, c2670n.f6380e, true);
                            c2670n.f6372G = iMax;
                            c2670n.f6373H = i6;
                            c2670n.f6374I = i13;
                        }
                    }
                    c2670n.m2760a(canvas2, z3);
                } else {
                    z2 = z4;
                    paddingLeft = paddingLeft;
                    paddingTop = paddingTop;
                    width = width;
                    paddingBottom = paddingBottom;
                    fM479U1 = fM479U1;
                    i3 = i8;
                    Objects.requireNonNull(c2670n.f6386k);
                    Bitmap bitmap = c2670n.f6386k;
                    int i27 = c2670n.f6368C;
                    int i28 = c2670n.f6366A;
                    int i29 = c2670n.f6369D;
                    int i30 = c2670n.f6367B;
                    float f8 = i27 - i28;
                    float f9 = (c2670n.f6390o * f8) + i28;
                    float f10 = i29 - i30;
                    float f11 = (c2670n.f6387l * f10) + i30;
                    int iRound3 = Math.round(f8 * c2670n.f6392q);
                    float f12 = c2670n.f6393r;
                    int iRound4 = f12 != -3.4028235E38f ? Math.round(f10 * f12) : Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound3);
                    int i31 = c2670n.f6391p;
                    if (i31 == 2) {
                        f = iRound3;
                    } else {
                        if (i31 == 1) {
                            f = iRound3 / 2;
                        }
                        int iRound5 = Math.round(f9);
                        i4 = c2670n.f6389n;
                        if (i4 == 2) {
                            f2 = iRound4;
                        } else {
                            if (i4 == 1) {
                                f2 = iRound4 / 2;
                            }
                            int iRound6 = Math.round(f11);
                            c2670n.f6375J = new Rect(iRound5, iRound6, iRound3 + iRound5, iRound4 + iRound6);
                        }
                        f11 -= f2;
                        int iRound7 = Math.round(f11);
                        c2670n.f6375J = new Rect(iRound5, iRound7, iRound3 + iRound5, iRound4 + iRound7);
                    }
                    f9 -= f;
                    int iRound8 = Math.round(f9);
                    i4 = c2670n.f6389n;
                    if (i4 == 2) {
                        f2 = iRound4;
                    } else {
                        if (i4 == 1) {
                            f2 = iRound4 / 2;
                        }
                        int iRound9 = Math.round(f11);
                        c2670n.f6375J = new Rect(iRound8, iRound9, iRound3 + iRound8, iRound4 + iRound9);
                    }
                    f11 -= f2;
                    int iRound10 = Math.round(f11);
                    c2670n.f6375J = new Rect(iRound8, iRound10, iRound3 + iRound8, iRound4 + iRound10);
                }
                canvas2 = canvas;
                z3 = z2;
                c2670n.m2760a(canvas2, z3);
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
            fM479U1 = fM479U1;
            c2666j = this;
        }
    }
}
