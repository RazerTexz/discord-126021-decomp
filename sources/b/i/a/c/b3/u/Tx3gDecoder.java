package b.i.a.c.b3.u;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.d.b.a.outline;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.b.a.Charsets;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.u.a, reason: use source file name */
/* JADX INFO: compiled from: Tx3gDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Tx3gDecoder extends SimpleSubtitleDecoder2 {
    public final ParsableByteArray n;
    public final boolean o;
    public final int p;
    public final int q;
    public final String r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f887s;
    public final int t;

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        this.n = new ParsableByteArray();
        if (list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.p = 0;
            this.q = -1;
            this.r = "sans-serif";
            this.o = false;
            this.f887s = 0.85f;
            this.t = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.p = bArr[24];
        this.q = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.r = "Serif".equals(Util2.m(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.t = i;
        boolean z2 = (bArr[0] & 32) != 0;
        this.o = z2;
        if (z2) {
            this.f887s = Util2.g(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.f887s = 0.85f;
        }
    }

    public static void k(boolean z2) throws SubtitleDecoderException {
        if (!z2) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void l(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
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
    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    public Subtitle j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        String strR;
        ParsableByteArray parsableByteArray = this.n;
        parsableByteArray.a = bArr;
        parsableByteArray.c = i;
        parsableByteArray.f984b = 0;
        int i2 = 2;
        int i3 = 1;
        k(parsableByteArray.a() >= 2);
        int iY = parsableByteArray.y();
        if (iY == 0) {
            strR = "";
        } else if (parsableByteArray.a() >= 2) {
            byte[] bArr2 = parsableByteArray.a;
            int i4 = parsableByteArray.f984b;
            char c = (char) ((bArr2[i4 + 1] & 255) | ((bArr2[i4] & 255) << 8));
            if (c == 65279 || c == 65534) {
                strR = parsableByteArray.r(iY, Charsets.e);
            } else {
                strR = parsableByteArray.r(iY, Charsets.c);
            }
        } else {
            strR = parsableByteArray.r(iY, Charsets.c);
        }
        if (strR.isEmpty()) {
            return Tx3gSubtitle.j;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strR);
        l(spannableStringBuilder, this.p, 0, 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
        int i5 = this.q;
        int length = spannableStringBuilder.length();
        if (i5 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i5 >>> 8) | ((i5 & 255) << 24)), 0, length, 16711713);
        }
        String str = this.r;
        int length2 = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fG = this.f887s;
        for (int i6 = 8; this.n.a() >= i6; i6 = 8) {
            ParsableByteArray parsableByteArray2 = this.n;
            int i7 = parsableByteArray2.f984b;
            int iF = parsableByteArray2.f();
            int iF2 = this.n.f();
            if (iF2 == 1937013100) {
                k(this.n.a() >= i2);
                int iY2 = this.n.y();
                int i8 = 0;
                while (i8 < iY2) {
                    ParsableByteArray parsableByteArray3 = this.n;
                    k(parsableByteArray3.a() >= 12);
                    int iY3 = parsableByteArray3.y();
                    int iY4 = parsableByteArray3.y();
                    parsableByteArray3.F(i2);
                    int iT = parsableByteArray3.t();
                    parsableByteArray3.F(i3);
                    int iF3 = parsableByteArray3.f();
                    if (iY4 > spannableStringBuilder.length()) {
                        int length3 = spannableStringBuilder.length();
                        StringBuilder sb = new StringBuilder(68);
                        sb.append("Truncating styl end (");
                        sb.append(iY4);
                        sb.append(") to cueText.length() (");
                        sb.append(length3);
                        sb.append(").");
                        Log.w("Tx3gDecoder", sb.toString());
                        iY4 = spannableStringBuilder.length();
                    }
                    int i9 = iY4;
                    if (iY3 >= i9) {
                        StringBuilder sb2 = new StringBuilder(60);
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iY3);
                        sb2.append(") >= end (");
                        sb2.append(i9);
                        outline.r0(sb2, ").", "Tx3gDecoder");
                    } else {
                        l(spannableStringBuilder, iT, this.p, iY3, i9, 0);
                        if (iF3 != this.q) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(((iF3 & 255) << 24) | (iF3 >>> 8)), iY3, i9, 33);
                        }
                    }
                    i8++;
                    i2 = 2;
                    i3 = 1;
                }
            } else if (iF2 == 1952608120 && this.o) {
                k(this.n.a() >= 2);
                fG = Util2.g(this.n.y() / this.t, 0.0f, 0.95f);
            }
            this.n.E(i7 + iF);
            i2 = 2;
            i3 = 1;
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder, null, null, null, fG, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null));
    }
}
