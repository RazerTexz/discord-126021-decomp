package androidx.core.provider;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequestWorker$TypefaceResult {
    public final int mResult;
    public final Typeface mTypeface;

    public FontRequestWorker$TypefaceResult(int i) {
        this.mTypeface = null;
        this.mResult = i;
    }

    @SuppressLint({"WrongConstant"})
    public boolean isSuccess() {
        return this.mResult == 0;
    }

    @SuppressLint({"WrongConstant"})
    public FontRequestWorker$TypefaceResult(@NonNull Typeface typeface) {
        this.mTypeface = typeface;
        this.mResult = 0;
    }
}
