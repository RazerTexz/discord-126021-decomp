package androidx.fragment.app;

import android.view.View;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        C12238m.checkNotNullParameter(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        C12238m.checkNotNullExpressionValue(f, "FragmentManager.findFragment(this)");
        return f;
    }
}
