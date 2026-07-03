package p007b.p076b.p077a.p078a;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.a.p */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1428p implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FlexInputFragment f2140a;

    public C1428p(FlexInputFragment flexInputFragment) {
        this.f2140a = flexInputFragment;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
        FlexInputFragment flexInputFragment = this.f2140a;
        KProperty[] kPropertyArr = FlexInputFragment.f22054j;
        ViewCompat.dispatchApplyWindowInsets(flexInputFragment.m9291j().f2178g, windowInsetsCompat);
        ViewCompat.dispatchApplyWindowInsets(this.f2140a.m9291j().f2182k, windowInsetsCompat);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
