package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$4 implements FitWindowsViewGroup$OnFitSystemWindowsListener {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$4(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener
    public void onFitSystemWindows(Rect rect) {
        rect.top = this.this$0.updateStatusGuard(null, rect);
    }
}
