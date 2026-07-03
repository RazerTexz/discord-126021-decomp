package com.discord.widgets.hubs;

import android.view.View;
import com.discord.C5419R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RadioSelectorViewHolder extends SimpleRecyclerAdapter.ViewHolder<RadioSelectorItem> {
    private final WidgetRadioSelectorViewHolderBinding binding;
    private final Function1<Integer, Unit> onSelected;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public RadioSelectorViewHolder(WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding, Function1<? super Integer, Unit> function1) {
        C12238m.checkNotNullParameter(widgetRadioSelectorViewHolderBinding, "binding");
        C12238m.checkNotNullParameter(function1, "onSelected");
        IconRow iconRow = widgetRadioSelectorViewHolderBinding.f17404a;
        C12238m.checkNotNullExpressionValue(iconRow, "binding.root");
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
    public void bind(final RadioSelectorItem data) {
        C12238m.checkNotNullParameter(data, "data");
        this.binding.f17405b.setText(data.getText());
        this.binding.f17405b.setImageRes(Integer.valueOf(data.getSelected() ? C5419R.drawable.ic_check_brand_16dp : 0));
        this.binding.f17405b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.RadioSelectorViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioSelectorViewHolder.this.getOnSelected().invoke(Integer.valueOf(data.getId()));
            }
        });
    }
}
