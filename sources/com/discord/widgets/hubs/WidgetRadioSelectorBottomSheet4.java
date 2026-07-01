package com.discord.widgets.hubs;

import android.view.View;
import com.discord.R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.RadioSelectorViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet4 extends SimpleRecyclerAdapter.ViewHolder<WidgetRadioSelectorBottomSheet2> {
    private final WidgetRadioSelectorViewHolderBinding binding;
    private final Function1<Integer, Unit> onSelected;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetRadioSelectorBottomSheet4(WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding, Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(widgetRadioSelectorViewHolderBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onSelected");
        IconRow iconRow = widgetRadioSelectorViewHolderBinding.a;
        Intrinsics3.checkNotNullExpressionValue(iconRow, "binding.root");
        super(iconRow);
        this.binding = widgetRadioSelectorViewHolderBinding;
        this.onSelected = function1;
    }

    public final WidgetRadioSelectorViewHolderBinding getBinding() {
        return this.binding;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public void bind(final WidgetRadioSelectorBottomSheet2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.binding.f2518b.setText(data.getText());
        this.binding.f2518b.setImageRes(Integer.valueOf(data.getSelected() ? R.drawable.ic_check_brand_16dp : 0));
        this.binding.f2518b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.RadioSelectorViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetRadioSelectorBottomSheet4.this.getOnSelected().invoke(Integer.valueOf(data.getId()));
            }
        });
    }
}
