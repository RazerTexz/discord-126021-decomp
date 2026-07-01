package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout$OnAttachListener;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl$5 implements ContentFrameLayout$OnAttachListener {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$5(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout$OnAttachListener
    public void onAttachedFromWindow() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout$OnAttachListener
    public void onDetachedFromWindow() {
        this.this$0.dismissPopups();
    }
}
