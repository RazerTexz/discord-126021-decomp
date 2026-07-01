package b.b.a.a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final class a<T> implements Action1<Long> {
        public a() {
        }

        @Override // rx.functions.Action1
        public void call(Long l) {
            FlexInputFragment flexInputFragment = l.this.this$0;
            KProperty[] kPropertyArr = FlexInputFragment.j;
            if (flexInputFragment.m()) {
                FrameLayout frameLayout = l.this.this$0.j().k;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
                frameLayout.setVisibility(0);
                FlexInputFragment.h(l.this.this$0, true);
                l.this.this$0.j().i.setImageResource(R.e.ic_keyboard_24dp);
                ImageView imageView = l.this.this$0.j().j;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.expressionBtnBadge");
                imageView.setVisibility(8);
                AppCompatImageButton appCompatImageButton = l.this.this$0.j().i;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
                appCompatImageButton.setContentDescription(l.this.this$0.getString(R.h.show_keyboard));
                FrameLayout frameLayout2 = l.this.this$0.j().g;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.defaultWindowInsetsHandler");
                frameLayout2.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FlexInputFragment flexInputFragment) {
        super(0);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.showExpressionKeyboardSubscription = Observable.d0(300L, TimeUnit.MILLISECONDS).J(AndroidSchedulers.a()).V(new a());
    }
}
