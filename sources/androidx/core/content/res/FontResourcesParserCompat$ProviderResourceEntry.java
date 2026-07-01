package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.provider.FontRequest;

/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$ProviderResourceEntry implements FontResourcesParserCompat$FamilyResourceEntry {

    @NonNull
    private final FontRequest mRequest;
    private final int mStrategy;

    @Nullable
    private final String mSystemFontFamilyName;
    private final int mTimeoutMs;

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public FontResourcesParserCompat$ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2, @Nullable String str) {
        this.mRequest = fontRequest;
        this.mStrategy = i;
        this.mTimeoutMs = i2;
        this.mSystemFontFamilyName = str;
    }

    public int getFetchStrategy() {
        return this.mStrategy;
    }

    @NonNull
    public FontRequest getRequest() {
        return this.mRequest;
    }

    @Nullable
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public String getSystemFontFamilyName() {
        return this.mSystemFontFamilyName;
    }

    public int getTimeout() {
        return this.mTimeoutMs;
    }

    public FontResourcesParserCompat$ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2) {
        this(fontRequest, i, i2, null);
    }
}
