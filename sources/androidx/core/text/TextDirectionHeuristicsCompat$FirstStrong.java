package androidx.core.text;

/* JADX INFO: loaded from: classes.dex */
public class TextDirectionHeuristicsCompat$FirstStrong implements TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
    public static final TextDirectionHeuristicsCompat$FirstStrong INSTANCE = new TextDirectionHeuristicsCompat$FirstStrong();

    private TextDirectionHeuristicsCompat$FirstStrong() {
    }

    @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm
    public int checkRtl(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + i;
        int iIsRtlTextOrFormat = 2;
        while (i < i3 && iIsRtlTextOrFormat == 2) {
            iIsRtlTextOrFormat = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return iIsRtlTextOrFormat;
    }
}
