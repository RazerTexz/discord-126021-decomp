package b.b.a.a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends Lambda implements Function1<Boolean, Boolean> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(FlexInputFragment flexInputFragment) {
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
        KProperty[] kPropertyArr = FlexInputFragment.j;
        FrameLayout frameLayout = flexInputFragment.j().k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
        frameLayout.setVisibility(8);
        FlexInputFragment.h(this.this$0, false);
        ImageView imageView = this.this$0.j().j;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.expressionBtnBadge");
        imageView.setVisibility(z2 ? 0 : 8);
        this.this$0.j().i.setImageResource(z2 ? R.e.ic_expression_icon_cutout_24dp : R.e.ic_emoji_24dp);
        AppCompatImageButton appCompatImageButton = this.this$0.j().i;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
        appCompatImageButton.setContentDescription(this.this$0.getString(R.h.toggle_emoji_keyboard));
        FrameLayout frameLayout2 = this.this$0.j().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.defaultWindowInsetsHandler");
        frameLayout2.setVisibility(0);
        return true;
    }
}
