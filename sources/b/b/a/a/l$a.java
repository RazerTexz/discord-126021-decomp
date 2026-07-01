package b.b.a.a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.lytefast.flexinput.R$e;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a<T> implements Action1<Long> {
    public final /* synthetic */ l j;

    public l$a(l lVar) {
        this.j = lVar;
    }

    @Override // rx.functions.Action1
    public void call(Long l) {
        FlexInputFragment flexInputFragment = this.j.this$0;
        KProperty[] kPropertyArr = FlexInputFragment.j;
        if (flexInputFragment.m()) {
            FrameLayout frameLayout = this.j.this$0.j().k;
            d0.z.d.m.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
            frameLayout.setVisibility(0);
            FlexInputFragment.h(this.j.this$0, true);
            this.j.this$0.j().i.setImageResource(R$e.ic_keyboard_24dp);
            ImageView imageView = this.j.this$0.j().j;
            d0.z.d.m.checkNotNullExpressionValue(imageView, "binding.expressionBtnBadge");
            imageView.setVisibility(8);
            AppCompatImageButton appCompatImageButton = this.j.this$0.j().i;
            d0.z.d.m.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
            appCompatImageButton.setContentDescription(this.j.this$0.getString(R$h.show_keyboard));
            FrameLayout frameLayout2 = this.j.this$0.j().g;
            d0.z.d.m.checkNotNullExpressionValue(frameLayout2, "binding.defaultWindowInsetsHandler");
            frameLayout2.setVisibility(8);
        }
    }
}
