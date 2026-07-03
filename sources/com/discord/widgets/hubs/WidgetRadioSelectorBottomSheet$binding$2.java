package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetRadioSelectorBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetRadioSelectorBottomSheetBinding> {
    public static final WidgetRadioSelectorBottomSheet$binding$2 INSTANCE = new WidgetRadioSelectorBottomSheet$binding$2();

    public WidgetRadioSelectorBottomSheet$binding$2() {
        super(1, WidgetRadioSelectorBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetRadioSelectorBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.radio_selector_bottom_sheet_title;
        TextView textView = (TextView) view.findViewById(C5419R.id.radio_selector_bottom_sheet_title);
        if (textView != null) {
            i = C5419R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetRadioSelectorBottomSheetBinding((LinearLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
