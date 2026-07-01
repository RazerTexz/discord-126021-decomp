package b.i.a.c.b3.n;

import android.text.Layout$Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.f3.e0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Cea608Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public final List<c$a$a> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpannableString> f851b = new ArrayList();
    public final StringBuilder c = new StringBuilder();
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public c$a(int i, int i2) {
        f(i);
        this.h = i2;
    }

    public void a(char c) {
        if (this.c.length() < 32) {
            this.c.append(c);
        }
    }

    public void b() {
        int length = this.c.length();
        if (length > 0) {
            this.c.delete(length - 1, length);
            for (int size = this.a.size() - 1; size >= 0; size--) {
                c$a$a c_a_a = this.a.get(size);
                int i = c_a_a.c;
                if (i != length) {
                    return;
                }
                c_a_a.c = i - 1;
            }
        }
    }

    @Nullable
    public b.i.a.c.b3.b c(int i) {
        int i2;
        float f;
        int i3 = this.e + this.f;
        int i4 = 32 - i3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i5 = 0; i5 < this.f851b.size(); i5++) {
            SpannableString spannableStringSubSequence = this.f851b.get(i5);
            int i6 = e0.a;
            if (spannableStringSubSequence.length() > i4) {
                spannableStringSubSequence = spannableStringSubSequence.subSequence(0, i4);
            }
            spannableStringBuilder.append(spannableStringSubSequence);
            spannableStringBuilder.append('\n');
        }
        SpannableString spannableStringD = d();
        int i7 = e0.a;
        int length = spannableStringD.length();
        SpannableString spannableStringSubSequence2 = spannableStringD;
        if (length > i4) {
            spannableStringSubSequence2 = spannableStringD.subSequence(0, i4);
        }
        spannableStringBuilder.append((CharSequence) spannableStringSubSequence2);
        if (spannableStringBuilder.length() == 0) {
            return null;
        }
        int length2 = i4 - spannableStringBuilder.length();
        int i8 = i3 - length2;
        if (i != Integer.MIN_VALUE) {
            i2 = i;
        } else if (this.g != 2 || (Math.abs(i8) >= 3 && length2 >= 0)) {
            i2 = (this.g != 2 || i8 <= 0) ? 0 : 2;
        } else {
            i2 = 1;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                i3 = 32 - length2;
            }
            f = ((i3 / 32.0f) * 0.8f) + 0.1f;
        } else {
            f = 0.5f;
        }
        int i9 = this.d;
        if (i9 > 7) {
            i9 = (i9 - 15) - 2;
        } else if (this.g == 1) {
            i9 -= this.h - 1;
        }
        return new b.i.a.c.b3.b(spannableStringBuilder, Layout$Alignment.ALIGN_NORMAL, null, null, i9, 1, Integer.MIN_VALUE, f, i2, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
    }

    public final SpannableString d() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
        int length = spannableStringBuilder.length();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        int i5 = -1;
        boolean z2 = false;
        int i6 = -1;
        while (i < this.a.size()) {
            c$a$a c_a_a = this.a.get(i);
            boolean z3 = c_a_a.f852b;
            int i7 = c_a_a.a;
            if (i7 != 8) {
                boolean z4 = i7 == 7;
                if (i7 != 7) {
                    i6 = c.i[i7];
                }
                z2 = z4;
            }
            int i8 = c_a_a.c;
            i++;
            if (i8 != (i < this.a.size() ? this.a.get(i).c : length)) {
                if (i2 != -1 && !z3) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i8, 33);
                    i2 = -1;
                } else if (i2 == -1 && z3) {
                    i2 = i8;
                }
                if (i3 != -1 && !z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i3, i8, 33);
                    i3 = -1;
                } else if (i3 == -1 && z2) {
                    i3 = i8;
                }
                if (i6 != i5) {
                    if (i5 != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, i8, 33);
                    }
                    i4 = i8;
                    i5 = i6;
                }
            }
        }
        if (i2 != -1 && i2 != length) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
        }
        if (i3 != -1 && i3 != length) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
        }
        if (i4 != length && i5 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, length, 33);
        }
        return new SpannableString(spannableStringBuilder);
    }

    public boolean e() {
        return this.a.isEmpty() && this.f851b.isEmpty() && this.c.length() == 0;
    }

    public void f(int i) {
        this.g = i;
        this.a.clear();
        this.f851b.clear();
        this.c.setLength(0);
        this.d = 15;
        this.e = 0;
        this.f = 0;
    }
}
