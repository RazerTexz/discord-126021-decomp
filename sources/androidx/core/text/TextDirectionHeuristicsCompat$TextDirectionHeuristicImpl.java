package androidx.core.text;

import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
    private final TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm;

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm) {
        this.mAlgorithm = textDirectionHeuristicsCompat$TextDirectionAlgorithm;
    }

    private boolean doCheck(CharSequence charSequence, int i, int i2) {
        int iCheckRtl = this.mAlgorithm.checkRtl(charSequence, i, i2);
        if (iCheckRtl == 0) {
            return true;
        }
        if (iCheckRtl != 1) {
            return defaultIsRtl();
        }
        return false;
    }

    public abstract boolean defaultIsRtl();

    @Override // androidx.core.text.TextDirectionHeuristicCompat
    public boolean isRtl(char[] cArr, int i, int i2) {
        return isRtl(CharBuffer.wrap(cArr), i, i2);
    }

    @Override // androidx.core.text.TextDirectionHeuristicCompat
    public boolean isRtl(CharSequence charSequence, int i, int i2) {
        if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
            throw new IllegalArgumentException();
        }
        return this.mAlgorithm == null ? defaultIsRtl() : doCheck(charSequence, i, i2);
    }
}
