package b.b.a.a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.lytefast.flexinput.R$e;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends d0.z.d.o implements Function1<Boolean, Boolean> {
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
        d0.z.d.m.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
        frameLayout.setVisibility(8);
        FlexInputFragment.h(this.this$0, false);
        ImageView imageView = this.this$0.j().j;
        d0.z.d.m.checkNotNullExpressionValue(imageView, "binding.expressionBtnBadge");
        imageView.setVisibility(z2 ? 0 : 8);
        this.this$0.j().i.setImageResource(z2 ? R$e.ic_expression_icon_cutout_24dp : R$e.ic_emoji_24dp);
        AppCompatImageButton appCompatImageButton = this.this$0.j().i;
        d0.z.d.m.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
        appCompatImageButton.setContentDescription(this.this$0.getString(R$h.toggle_emoji_keyboard));
        FrameLayout frameLayout2 = this.this$0.j().g;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout2, "binding.defaultWindowInsetsHandler");
        frameLayout2.setVisibility(0);
        return true;
    }
}
