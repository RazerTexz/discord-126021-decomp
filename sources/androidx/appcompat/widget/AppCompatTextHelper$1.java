package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextHelper$1 extends ResourcesCompat$FontCallback {
    public final /* synthetic */ AppCompatTextHelper this$0;
    public final /* synthetic */ int val$fontWeight;
    public final /* synthetic */ int val$style;
    public final /* synthetic */ WeakReference val$textViewWeak;

    public AppCompatTextHelper$1(AppCompatTextHelper appCompatTextHelper, int i, int i2, WeakReference weakReference) {
        this.this$0 = appCompatTextHelper;
        this.val$fontWeight = i;
        this.val$style = i2;
        this.val$textViewWeak = weakReference;
    }

    @Override // androidx.core.content.res.ResourcesCompat$FontCallback
    public void onFontRetrievalFailed(int i) {
    }

    @Override // androidx.core.content.res.ResourcesCompat$FontCallback
    public void onFontRetrieved(@NonNull Typeface typeface) {
        int i;
        if (Build$VERSION.SDK_INT >= 28 && (i = this.val$fontWeight) != -1) {
            typeface = Typeface.create(typeface, i, (this.val$style & 2) != 0);
        }
        this.this$0.onAsyncTypefaceReceived(this.val$textViewWeak, typeface);
    }
}
