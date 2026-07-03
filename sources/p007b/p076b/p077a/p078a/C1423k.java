package p007b.p076b.p077a.p078a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.a.k */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1423k extends AbstractC12240o implements Function1<Boolean, Boolean> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1423k(FlexInputFragment flexInputFragment) {
        super(1);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Boolean.TRUE;
    }

    public final boolean invoke(boolean z2) {
        FlexInputFragment flexInputFragment = this.this$0;
        KProperty[] kPropertyArr = FlexInputFragment.f22054j;
        FrameLayout frameLayout = flexInputFragment.m9291j().f2182k;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
        frameLayout.setVisibility(8);
        FlexInputFragment.m9289h(this.this$0, false);
        ImageView imageView = this.this$0.m9291j().f2181j;
        C12238m.checkNotNullExpressionValue(imageView, "binding.expressionBtnBadge");
        imageView.setVisibility(z2 ? 0 : 8);
        this.this$0.m9291j().f2180i.setImageResource(z2 ? C11170R.e.ic_expression_icon_cutout_24dp : C11170R.e.ic_emoji_24dp);
        AppCompatImageButton appCompatImageButton = this.this$0.m9291j().f2180i;
        C12238m.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
        appCompatImageButton.setContentDescription(this.this$0.getString(C11170R.h.toggle_emoji_keyboard));
        FrameLayout frameLayout2 = this.this$0.m9291j().f2178g;
        C12238m.checkNotNullExpressionValue(frameLayout2, "binding.defaultWindowInsetsHandler");
        frameLayout2.setVisibility(0);
        return true;
    }
}
