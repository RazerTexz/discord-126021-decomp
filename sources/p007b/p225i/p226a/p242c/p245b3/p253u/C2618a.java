package p007b.p225i.p226a.p242c.p245b3.p253u;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.b3.u.a */
/* JADX INFO: compiled from: Tx3gDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2618a extends AbstractC2582f {

    /* JADX INFO: renamed from: n */
    public final C2757x f6097n;

    /* JADX INFO: renamed from: o */
    public final boolean f6098o;

    /* JADX INFO: renamed from: p */
    public final int f6099p;

    /* JADX INFO: renamed from: q */
    public final int f6100q;

    /* JADX INFO: renamed from: r */
    public final String f6101r;

    /* JADX INFO: renamed from: s */
    public final float f6102s;

    /* JADX INFO: renamed from: t */
    public final int f6103t;

    public C2618a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f6097n = new C2757x();
        if (list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f6099p = 0;
            this.f6100q = -1;
            this.f6101r = "sans-serif";
            this.f6098o = false;
            this.f6102s = 0.85f;
            this.f6103t = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f6099p = bArr[24];
        this.f6100q = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f6101r = "Serif".equals(C2738e0.m3005m(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.f6103t = i;
        boolean z2 = (bArr[0] & 32) != 0;
        this.f6098o = z2;
        if (z2) {
            this.f6102s = C2738e0.m2999g(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.f6102s = 0.85f;
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m2703k(boolean z2) throws SubtitleDecoderException {
        if (!z2) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    /* JADX INFO: renamed from: l */
    public static void m2704l(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z4 = (i & 4) != 0;
            if (z4) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z4 || z2 || z3) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f  */
    @Override // p007b.p225i.p226a.p242c.p245b3.AbstractC2582f
    /* JADX INFO: renamed from: j */
    public InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        String strM3098r;
        C2757x c2757x = this.f6097n;
        c2757x.f6793a = bArr;
        c2757x.f6795c = i;
        c2757x.f6794b = 0;
        int i2 = 2;
        int i3 = 1;
        m2703k(c2757x.m3081a() >= 2);
        int iM3105y = c2757x.m3105y();
        if (iM3105y == 0) {
            strM3098r = "";
        } else if (c2757x.m3081a() >= 2) {
            byte[] bArr2 = c2757x.f6793a;
            int i4 = c2757x.f6794b;
            char c = (char) ((bArr2[i4 + 1] & 255) | ((bArr2[i4] & 255) << 8));
            if (c == 65279 || c == 65534) {
                strM3098r = c2757x.m3098r(iM3105y, C4483c.f11947e);
            } else {
                strM3098r = c2757x.m3098r(iM3105y, C4483c.f11945c);
            }
        } else {
            strM3098r = c2757x.m3098r(iM3105y, C4483c.f11945c);
        }
        if (strM3098r.isEmpty()) {
            return C2619b.f6104j;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strM3098r);
        m2704l(spannableStringBuilder, this.f6099p, 0, 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
        int i5 = this.f6100q;
        int length = spannableStringBuilder.length();
        if (i5 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i5 >>> 8) | ((i5 & 255) << 24)), 0, length, 16711713);
        }
        String str = this.f6101r;
        int length2 = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fM2999g = this.f6102s;
        for (int i6 = 8; this.f6097n.m3081a() >= i6; i6 = 8) {
            C2757x c2757x2 = this.f6097n;
            int i7 = c2757x2.f6794b;
            int iM3086f = c2757x2.m3086f();
            int iM3086f2 = this.f6097n.m3086f();
            if (iM3086f2 == 1937013100) {
                m2703k(this.f6097n.m3081a() >= i2);
                int iM3105y2 = this.f6097n.m3105y();
                int i8 = 0;
                while (i8 < iM3105y2) {
                    C2757x c2757x3 = this.f6097n;
                    m2703k(c2757x3.m3081a() >= 12);
                    int iM3105y3 = c2757x3.m3105y();
                    int iM3105y4 = c2757x3.m3105y();
                    c2757x3.m3080F(i2);
                    int iM3100t = c2757x3.m3100t();
                    c2757x3.m3080F(i3);
                    int iM3086f3 = c2757x3.m3086f();
                    if (iM3105y4 > spannableStringBuilder.length()) {
                        int length3 = spannableStringBuilder.length();
                        StringBuilder sb = new StringBuilder(68);
                        sb.append("Truncating styl end (");
                        sb.append(iM3105y4);
                        sb.append(") to cueText.length() (");
                        sb.append(length3);
                        sb.append(").");
                        Log.w("Tx3gDecoder", sb.toString());
                        iM3105y4 = spannableStringBuilder.length();
                    }
                    int i9 = iM3105y4;
                    if (iM3105y3 >= i9) {
                        StringBuilder sb2 = new StringBuilder(60);
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iM3105y3);
                        sb2.append(") >= end (");
                        sb2.append(i9);
                        C1643a.m874r0(sb2, ").", "Tx3gDecoder");
                    } else {
                        m2704l(spannableStringBuilder, iM3100t, this.f6099p, iM3105y3, i9, 0);
                        if (iM3086f3 != this.f6100q) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(((iM3086f3 & 255) << 24) | (iM3086f3 >>> 8)), iM3105y3, i9, 33);
                        }
                    }
                    i8++;
                    i2 = 2;
                    i3 = 1;
                }
            } else if (iM3086f2 == 1952608120 && this.f6098o) {
                m2703k(this.f6097n.m3081a() >= 2);
                fM2999g = C2738e0.m2999g(this.f6097n.m3105y() / this.f6103t, 0.0f, 0.95f);
            }
            this.f6097n.m3079E(i7 + iM3086f);
            i2 = 2;
            i3 = 1;
        }
        return new C2619b(new C2578b(spannableStringBuilder, null, null, null, fM2999g, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null));
    }
}
