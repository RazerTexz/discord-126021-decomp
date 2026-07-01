package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourcesCompat$FontCallback {
    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public static Handler getHandler(@Nullable Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public final void callbackFailAsync(int i, @Nullable Handler handler) {
        getHandler(handler).post(new ResourcesCompat$FontCallback$2(this, i));
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public final void callbackSuccessAsync(Typeface typeface, @Nullable Handler handler) {
        getHandler(handler).post(new ResourcesCompat$FontCallback$1(this, typeface));
    }

    public abstract void onFontRetrievalFailed(int i);

    public abstract void onFontRetrieved(@NonNull Typeface typeface);
}
