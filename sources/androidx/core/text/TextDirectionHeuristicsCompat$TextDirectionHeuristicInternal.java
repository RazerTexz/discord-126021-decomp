package androidx.core.text;

/* JADX INFO: loaded from: classes.dex */
public class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    private final boolean mDefaultIsRtl;

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat$TextDirectionAlgorithm textDirectionHeuristicsCompat$TextDirectionAlgorithm, boolean z2) {
        super(textDirectionHeuristicsCompat$TextDirectionAlgorithm);
        this.mDefaultIsRtl = z2;
    }

    @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
    public boolean defaultIsRtl() {
        return this.mDefaultIsRtl;
    }
}
