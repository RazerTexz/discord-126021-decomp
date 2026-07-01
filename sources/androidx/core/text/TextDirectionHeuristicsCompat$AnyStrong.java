package androidx.core.text;

/* JADX INFO: loaded from: classes.dex */
public class TextDirectionHeuristicsCompat$AnyStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
    public static final TextDirectionHeuristicsCompat$AnyStrong INSTANCE_RTL = new TextDirectionHeuristicsCompat$AnyStrong(true);
    private final boolean mLookForRtl;

    private TextDirectionHeuristicsCompat$AnyStrong(boolean z2) {
        this.mLookForRtl = z2;
    }

    @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
    public int checkRtl(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        boolean z2 = false;
        while (i < i3) {
            int iIsRtlText = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(i)));
            if (iIsRtlText != 0) {
                if (iIsRtlText != 1) {
                    continue;
                } else if (!this.mLookForRtl) {
                    return 1;
                }
                i++;
            } else if (this.mLookForRtl) {
                return 0;
            }
            z2 = true;
            i++;
        }
        if (z2) {
            return this.mLookForRtl ? 1 : 0;
        }
        return 2;
    }
}
