package p007b.p076b.p077a.p078a;

import android.util.Log;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.b.a.a.j */
/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1422j extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ FlexInputFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1422j(FlexInputFragment flexInputFragment) {
        super(1);
        this.this$0 = flexInputFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        try {
            FlexInputFragment.m9288g(this.this$0, num.intValue());
        } catch (Exception e) {
            Log.d(FlexInputFragment.f22055k, "Could not open AddContentDialogFragment", e);
        }
        return Unit.f27425a;
    }
}
