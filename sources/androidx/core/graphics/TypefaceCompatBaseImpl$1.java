package androidx.core.graphics;

import androidx.core.provider.FontsContractCompat$FontInfo;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatBaseImpl$1 implements TypefaceCompatBaseImpl$StyleExtractor<FontsContractCompat$FontInfo> {
    public final /* synthetic */ TypefaceCompatBaseImpl this$0;

    public TypefaceCompatBaseImpl$1(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        this.this$0 = typefaceCompatBaseImpl;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
    public /* bridge */ /* synthetic */ int getWeight(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        return getWeight2(fontsContractCompat$FontInfo);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
    public /* bridge */ /* synthetic */ boolean isItalic(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        return isItalic2(fontsContractCompat$FontInfo);
    }

    /* JADX INFO: renamed from: getWeight, reason: avoid collision after fix types in other method */
    public int getWeight2(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        return fontsContractCompat$FontInfo.getWeight();
    }

    /* JADX INFO: renamed from: isItalic, reason: avoid collision after fix types in other method */
    public boolean isItalic2(FontsContractCompat$FontInfo fontsContractCompat$FontInfo) {
        return fontsContractCompat$FontInfo.isItalic();
    }
}
