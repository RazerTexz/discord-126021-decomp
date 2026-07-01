package androidx.core.text;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale extends TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    public static final TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale();

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale() {
        super(null);
    }

    @Override // androidx.core.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl
    public boolean defaultIsRtl() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}
