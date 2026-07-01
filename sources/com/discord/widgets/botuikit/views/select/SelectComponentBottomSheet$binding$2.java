package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet$binding$2 extends k implements Function1<View, WidgetSelectComponentBottomSheetBinding> {
    public static final SelectComponentBottomSheet$binding$2 INSTANCE = new SelectComponentBottomSheet$binding$2();

    public SelectComponentBottomSheet$binding$2() {
        super(1, WidgetSelectComponentBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSelectComponentBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSelectComponentBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.widget_sheet_component_bottom_sheet_header;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.widget_sheet_component_bottom_sheet_header);
        if (constraintLayout != null) {
            i = R$id.widget_sheet_component_bottom_sheet_placeholder;
            TextView textView = (TextView) view.findViewById(R$id.widget_sheet_component_bottom_sheet_placeholder);
            if (textView != null) {
                i = R$id.widget_sheet_component_bottom_sheet_recycler;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R$id.widget_sheet_component_bottom_sheet_recycler);
                if (maxHeightRecyclerView != null) {
                    i = R$id.widget_sheet_component_bottom_sheet_select;
                    TextView textView2 = (TextView) view.findViewById(R$id.widget_sheet_component_bottom_sheet_select);
                    if (textView2 != null) {
                        i = R$id.widget_sheet_component_bottom_sheet_subtitle;
                        TextView textView3 = (TextView) view.findViewById(R$id.widget_sheet_component_bottom_sheet_subtitle);
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
