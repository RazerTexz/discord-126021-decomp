package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$FontFileResourceEntry {

    @NonNull
    private final String mFileName;
    private boolean mItalic;
    private int mResourceId;
    private int mTtcIndex;
    private String mVariationSettings;
    private int mWeight;

    public FontResourcesParserCompat$FontFileResourceEntry(@NonNull String str, int i, boolean z2, @Nullable String str2, int i2, int i3) {
        this.mFileName = str;
        this.mWeight = i;
        this.mItalic = z2;
        this.mVariationSettings = str2;
        this.mTtcIndex = i2;
        this.mResourceId = i3;
    }

    @NonNull
    public String getFileName() {
        return this.mFileName;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    @Nullable
    public String getVariationSettings() {
        return this.mVariationSettings;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}
