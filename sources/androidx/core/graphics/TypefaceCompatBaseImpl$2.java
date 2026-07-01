package androidx.core.graphics;

import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatBaseImpl$2 implements TypefaceCompatBaseImpl$StyleExtractor<FontResourcesParserCompat$FontFileResourceEntry> {
    public final /* synthetic */ TypefaceCompatBaseImpl this$0;

    public TypefaceCompatBaseImpl$2(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        this.this$0 = typefaceCompatBaseImpl;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
    public /* bridge */ /* synthetic */ int getWeight(FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry) {
        return getWeight2(fontResourcesParserCompat$FontFileResourceEntry);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
    public /* bridge */ /* synthetic */ boolean isItalic(FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry) {
        return isItalic2(fontResourcesParserCompat$FontFileResourceEntry);
    }

    /* JADX INFO: renamed from: getWeight, reason: avoid collision after fix types in other method */
    public int getWeight2(FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry) {
        return fontResourcesParserCompat$FontFileResourceEntry.getWeight();
    }

    /* JADX INFO: renamed from: isItalic, reason: avoid collision after fix types in other method */
    public boolean isItalic2(FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry) {
        return fontResourcesParserCompat$FontFileResourceEntry.isItalic();
    }
}
