package p007b.p076b.p077a.p078a;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.a.o */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1427o implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a */
    public static final C1427o f2139a = new C1427o();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
