package p007b.p076b.p077a.p078a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageButton;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p638j.p640b.C12586a;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.b.a.a.l */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1424l extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX INFO: renamed from: b.b.a.a.l$a */
    /* JADX INFO: compiled from: FlexInputFragment.kt */
    public static final class a<T> implements Action1<Long> {
        public a() {
        }

        @Override // p658rx.functions.Action1
        public void call(Long l) {
            FlexInputFragment flexInputFragment = C1424l.this.this$0;
            KProperty[] kPropertyArr = FlexInputFragment.f22054j;
            if (flexInputFragment.m9294m()) {
                FrameLayout frameLayout = C1424l.this.this$0.m9291j().f2182k;
                C12238m.checkNotNullExpressionValue(frameLayout, "binding.expressionTrayContainer");
                frameLayout.setVisibility(0);
                FlexInputFragment.m9289h(C1424l.this.this$0, true);
                C1424l.this.this$0.m9291j().f2180i.setImageResource(C11170R.e.ic_keyboard_24dp);
                ImageView imageView = C1424l.this.this$0.m9291j().f2181j;
                C12238m.checkNotNullExpressionValue(imageView, "binding.expressionBtnBadge");
                imageView.setVisibility(8);
                AppCompatImageButton appCompatImageButton = C1424l.this.this$0.m9291j().f2180i;
                C12238m.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
                appCompatImageButton.setContentDescription(C1424l.this.this$0.getString(C11170R.h.show_keyboard));
                FrameLayout frameLayout2 = C1424l.this.this$0.m9291j().f2178g;
                C12238m.checkNotNullExpressionValue(frameLayout2, "binding.defaultWindowInsetsHandler");
                frameLayout2.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1424l(FlexInputFragment flexInputFragment) {
        super(0);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.showExpressionKeyboardSubscription = Observable.m11068d0(300L, TimeUnit.MILLISECONDS).m11084J(C12586a.m10738a()).m11096V(new a());
    }
}
