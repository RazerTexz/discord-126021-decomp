package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat$Api21Impl$1 implements View$OnApplyWindowInsetsListener {
    public WindowInsetsCompat mLastInsets = null;
    public final /* synthetic */ OnApplyWindowInsetsListener val$listener;
    public final /* synthetic */ View val$v;

    public ViewCompat$Api21Impl$1(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.val$v = view;
        this.val$listener = onApplyWindowInsetsListener;
    }

    @Override // android.view.View$OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        int i = Build$VERSION.SDK_INT;
        if (i < 30) {
            ViewCompat$Api21Impl.callCompatInsetAnimationCallback(windowInsets, this.val$v);
            if (windowInsetsCompat.equals(this.mLastInsets)) {
                return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
            }
        }
        this.mLastInsets = windowInsetsCompat;
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
        if (i >= 30) {
            return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
        }
        ViewCompat.requestApplyInsets(view);
        return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
    }
}
