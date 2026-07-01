package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl20$1 implements Runnable {
    public final /* synthetic */ WindowInsetsControllerCompat$Impl20 this$0;
    public final /* synthetic */ View val$finalView;

    public WindowInsetsControllerCompat$Impl20$1(WindowInsetsControllerCompat$Impl20 windowInsetsControllerCompat$Impl20, View view) {
        this.this$0 = windowInsetsControllerCompat$Impl20;
        this.val$finalView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.val$finalView.getContext().getSystemService("input_method")).showSoftInput(this.val$finalView, 0);
    }
}
