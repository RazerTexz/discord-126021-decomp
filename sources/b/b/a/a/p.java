package b.b.a.a;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.z.d.Intrinsics3;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements OnApplyWindowInsetsListener {
    public final /* synthetic */ FlexInputFragment a;

    public p(FlexInputFragment flexInputFragment) {
        this.a = flexInputFragment;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
        FlexInputFragment flexInputFragment = this.a;
        KProperty[] kPropertyArr = FlexInputFragment.j;
        ViewCompat.dispatchApplyWindowInsets(flexInputFragment.j().g, windowInsetsCompat);
        ViewCompat.dispatchApplyWindowInsets(this.a.j().k, windowInsetsCompat);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
