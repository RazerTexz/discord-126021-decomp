package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class TypefaceCompat$ResourcesCallbackAdapter extends FontsContractCompat$FontRequestCallback {

    @Nullable
    private ResourcesCompat$FontCallback mFontCallback;

    public TypefaceCompat$ResourcesCallbackAdapter(@Nullable ResourcesCompat$FontCallback resourcesCompat$FontCallback) {
        this.mFontCallback = resourcesCompat$FontCallback;
    }

    @Override // androidx.core.provider.FontsContractCompat$FontRequestCallback
    public void onTypefaceRequestFailed(int i) {
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.mFontCallback;
        if (resourcesCompat$FontCallback != null) {
            resourcesCompat$FontCallback.onFontRetrievalFailed(i);
        }
    }

    @Override // androidx.core.provider.FontsContractCompat$FontRequestCallback
    public void onTypefaceRetrieved(@NonNull Typeface typeface) {
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.mFontCallback;
        if (resourcesCompat$FontCallback != null) {
            resourcesCompat$FontCallback.onFontRetrieved(typeface);
        }
    }
}
