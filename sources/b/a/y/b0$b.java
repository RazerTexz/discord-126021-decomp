package b.a.y;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b0$b extends d0.z.d.k implements Function1<View, b.a.i.c> {
    public static final b0$b j = new b0$b();

    public b0$b() {
        super(1, b.a.i.c.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/BottomSheetSimpleSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.c invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.widget_simple_bottom_sheet_selector_header;
        ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(R$id.widget_simple_bottom_sheet_selector_header);
        if (constraintLayout != null) {
            i = R$id.widget_simple_bottom_sheet_selector_placeholder;
            TextView textView = (TextView) view2.findViewById(R$id.widget_simple_bottom_sheet_selector_placeholder);
            if (textView != null) {
                i = R$id.widget_simple_bottom_sheet_selector_recycler;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R$id.widget_simple_bottom_sheet_selector_recycler);
                if (maxHeightRecyclerView != null) {
                    return new b.a.i.c((ConstraintLayout) view2, constraintLayout, textView, maxHeightRecyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
