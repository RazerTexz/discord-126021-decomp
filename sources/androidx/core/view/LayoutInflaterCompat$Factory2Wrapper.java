package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater$Factory2;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class LayoutInflaterCompat$Factory2Wrapper implements LayoutInflater$Factory2 {
    public final LayoutInflaterFactory mDelegateFactory;

    public LayoutInflaterCompat$Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
        this.mDelegateFactory = layoutInflaterFactory;
    }

    @Override // android.view.LayoutInflater$Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
    }

    @NonNull
    public String toString() {
        return getClass().getName() + "{" + this.mDelegateFactory + "}";
    }

    @Override // android.view.LayoutInflater$Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
    }
}
