package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetSelectComponentBottomSheetBinding> {
    public static final SelectComponentBottomSheet4 INSTANCE = new SelectComponentBottomSheet4();

    public SelectComponentBottomSheet4() {
        super(1, WidgetSelectComponentBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSelectComponentBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.widget_sheet_component_bottom_sheet_header;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.widget_sheet_component_bottom_sheet_header);
        if (constraintLayout != null) {
            i = R.id.widget_sheet_component_bottom_sheet_placeholder;
            TextView textView = (TextView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_placeholder);
            if (textView != null) {
                i = R.id.widget_sheet_component_bottom_sheet_recycler;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_recycler);
                if (maxHeightRecyclerView != null) {
                    i = R.id.widget_sheet_component_bottom_sheet_select;
                    TextView textView2 = (TextView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_select);
                    if (textView2 != null) {
                        i = R.id.widget_sheet_component_bottom_sheet_subtitle;
                        TextView textView3 = (TextView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_subtitle);
                        if (textView3 != null) {
                            return new WidgetSelectComponentBottomSheetBinding((ConstraintLayout) view, constraintLayout, textView, maxHeightRecyclerView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
