package defpackage;

import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import androidx.annotation.ColorInt;
import d0.z.d.m;

/* JADX INFO: compiled from: SpoilerSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpoilerSpan extends BackgroundColorSpan {
    public int j;
    public int k;
    public boolean l;

    public SpoilerSpan() {
        super(0);
        this.j = 0;
        this.k = 0;
        this.l = false;
    }

    @Override // android.text.style.BackgroundColorSpan
    public int getBackgroundColor() {
        return this.l ? this.k : this.j;
    }

    @Override // android.text.style.BackgroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        m.checkNotNullParameter(textPaint, "textPaint");
        if (this.l) {
            textPaint.bgColor = this.k;
            return;
        }
        int i = this.j;
        textPaint.bgColor = i;
        textPaint.setColor(i);
    }

    public SpoilerSpan(@ColorInt int i, @ColorInt int i2, boolean z2) {
        super(i);
        this.j = i;
        this.k = i2;
        this.l = z2;
    }
}
