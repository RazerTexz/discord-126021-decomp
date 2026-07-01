package b.a.y;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b0$a {
    public b0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 b(b0$a b0_a, FragmentManager fragmentManager, String str, List list, boolean z2, Function1 function1, int i) {
        boolean z3 = (i & 8) != 0 ? true : z2;
        if ((i & 16) != 0) {
            function1 = b0$a$a.j;
        }
        return b0_a.a(fragmentManager, str, list, z3, function1);
    }

    public final b0 a(FragmentManager fragmentManager, String str, List<c0> list, boolean z2, Function1<? super Integer, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        d0.z.d.m.checkNotNullParameter(str, "title");
        d0.z.d.m.checkNotNullParameter(list, "options");
        d0.z.d.m.checkNotNullParameter(function1, "onSelectedListener");
        b0 b0Var = new b0();
        b0Var.setArguments(BundleKt.bundleOf(d0.o.to("simple_bottom_sheet_title", str), d0.o.to("simple_bottom_sheet_options", list), d0.o.to("simple_bottom_sheet_show_dividers", Boolean.valueOf(z2))));
        b0Var.onSelectedListener = function1;
        b0Var.show(fragmentManager, d0.z.d.a0.getOrCreateKotlinClass(b0.class).toString());
        return b0Var;
    }
}
