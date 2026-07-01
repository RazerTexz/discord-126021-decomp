package androidx.fragment.app;

import android.view.View;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        Intrinsics3.checkNotNullExpressionValue(f, "FragmentManager.findFragment(this)");
        return f;
    }
}
