package androidx.core.provider;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public class FontsContractCompat$FontFamilyResult {
    public static final int STATUS_OK = 0;
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    private final FontsContractCompat$FontInfo[] mFonts;
    private final int mStatusCode;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FontsContractCompat$FontFamilyResult(int i, @Nullable FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        this.mStatusCode = i;
        this.mFonts = fontsContractCompat$FontInfoArr;
    }

    public static FontsContractCompat$FontFamilyResult create(int i, @Nullable FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        return new FontsContractCompat$FontFamilyResult(i, fontsContractCompat$FontInfoArr);
    }

    public FontsContractCompat$FontInfo[] getFonts() {
        return this.mFonts;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
