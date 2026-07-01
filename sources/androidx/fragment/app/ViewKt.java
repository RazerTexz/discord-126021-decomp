package androidx.fragment.app;

import android.view.View;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        m.checkNotNullParameter(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        m.checkNotNullExpressionValue(f, "FragmentManager.findFragment(this)");
        return f;
    }
}
