package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build$VERSION;
import android.text.PrecomputedText$Params;
import android.text.PrecomputedText$Params$Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.util.ObjectsCompat;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class PrecomputedTextCompat$Params {
    private final int mBreakStrategy;
    private final int mHyphenationFrequency;

    @NonNull
    private final TextPaint mPaint;

    @Nullable
    private final TextDirectionHeuristic mTextDir;
    public final PrecomputedText$Params mWrapped;

    @SuppressLint({"NewApi"})
    public PrecomputedTextCompat$Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
        if (Build$VERSION.SDK_INT >= 29) {
            this.mWrapped = new PrecomputedText$Params$Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
        } else {
            this.mWrapped = null;
        }
        this.mPaint = textPaint;
        this.mTextDir = textDirectionHeuristic;
        this.mBreakStrategy = i;
        this.mHyphenationFrequency = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrecomputedTextCompat$Params)) {
            return false;
        }
        PrecomputedTextCompat$Params precomputedTextCompat$Params = (PrecomputedTextCompat$Params) obj;
        return equalsWithoutTextDirection(precomputedTextCompat$Params) && this.mTextDir == precomputedTextCompat$Params.getTextDirection();
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean equalsWithoutTextDirection(@NonNull PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        int i = Build$VERSION.SDK_INT;
        if ((i >= 23 && (this.mBreakStrategy != precomputedTextCompat$Params.getBreakStrategy() || this.mHyphenationFrequency != precomputedTextCompat$Params.getHyphenationFrequency())) || this.mPaint.getTextSize() != precomputedTextCompat$Params.getTextPaint().getTextSize() || this.mPaint.getTextScaleX() != precomputedTextCompat$Params.getTextPaint().getTextScaleX() || this.mPaint.getTextSkewX() != precomputedTextCompat$Params.getTextPaint().getTextSkewX() || this.mPaint.getLetterSpacing() != precomputedTextCompat$Params.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.mPaint.getFontFeatureSettings(), precomputedTextCompat$Params.getTextPaint().getFontFeatureSettings()) || this.mPaint.getFlags() != precomputedTextCompat$Params.getTextPaint().getFlags()) {
            return false;
        }
        if (i >= 24) {
            if (!this.mPaint.getTextLocales().equals(precomputedTextCompat$Params.getTextPaint().getTextLocales())) {
                return false;
            }
        } else if (!this.mPaint.getTextLocale().equals(precomputedTextCompat$Params.getTextPaint().getTextLocale())) {
            return false;
        }
        if (this.mPaint.getTypeface() == null) {
            return precomputedTextCompat$Params.getTextPaint().getTypeface() == null;
        }
        return this.mPaint.getTypeface().equals(precomputedTextCompat$Params.getTextPaint().getTypeface());
    }

    @RequiresApi(23)
    public int getBreakStrategy() {
        return this.mBreakStrategy;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.mHyphenationFrequency;
    }

    @Nullable
    @RequiresApi(18)
    public TextDirectionHeuristic getTextDirection() {
        return this.mTextDir;
    }

    @NonNull
    public TextPaint getTextPaint() {
        return this.mPaint;
    }

    public int hashCode() {
        return Build$VERSION.SDK_INT >= 24 ? ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)) : ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sbU = a.U("textSize=");
        sbU.append(this.mPaint.getTextSize());
        sb.append(sbU.toString());
        sb.append(", textScaleX=" + this.mPaint.getTextScaleX());
        sb.append(", textSkewX=" + this.mPaint.getTextSkewX());
        int i = Build$VERSION.SDK_INT;
        StringBuilder sbU2 = a.U(", letterSpacing=");
        sbU2.append(this.mPaint.getLetterSpacing());
        sb.append(sbU2.toString());
        sb.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
        if (i >= 24) {
            StringBuilder sbU3 = a.U(", textLocale=");
            sbU3.append(this.mPaint.getTextLocales());
            sb.append(sbU3.toString());
        } else {
            StringBuilder sbU4 = a.U(", textLocale=");
            sbU4.append(this.mPaint.getTextLocale());
            sb.append(sbU4.toString());
        }
        StringBuilder sbU5 = a.U(", typeface=");
        sbU5.append(this.mPaint.getTypeface());
        sb.append(sbU5.toString());
        if (i >= 26) {
            StringBuilder sbU6 = a.U(", variationSettings=");
            sbU6.append(this.mPaint.getFontVariationSettings());
            sb.append(sbU6.toString());
        }
        StringBuilder sbU7 = a.U(", textDir=");
        sbU7.append(this.mTextDir);
        sb.append(sbU7.toString());
        sb.append(", breakStrategy=" + this.mBreakStrategy);
        sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
        sb.append("}");
        return sb.toString();
    }

    @RequiresApi(28)
    public PrecomputedTextCompat$Params(@NonNull PrecomputedText$Params precomputedText$Params) {
        this.mPaint = precomputedText$Params.getTextPaint();
        this.mTextDir = precomputedText$Params.getTextDirection();
        this.mBreakStrategy = precomputedText$Params.getBreakStrategy();
        this.mHyphenationFrequency = precomputedText$Params.getHyphenationFrequency();
        this.mWrapped = Build$VERSION.SDK_INT < 29 ? null : precomputedText$Params;
    }
}
