package com.discord.widgets.hubs;

import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import com.discord.views.IconRow;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RadioSelectorViewHolder extends SimpleRecyclerAdapter$ViewHolder<RadioSelectorItem> {
    private final WidgetRadioSelectorViewHolderBinding binding;
    private final Function1<Integer, Unit> onSelected;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public RadioSelectorViewHolder(WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding, Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(widgetRadioSelectorViewHolderBinding, "binding");
        m.checkNotNullParameter(function1, "onSelected");
        IconRow iconRow = widgetRadioSelectorViewHolderBinding.a;
        m.checkNotNullExpressionValue(iconRow, "binding.root");
        super(iconRow);
        this.binding = widgetRadioSelectorViewHolderBinding;
        this.onSelected = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public /* bridge */ /* synthetic */ void bind(RadioSelectorItem radioSelectorItem) {
        bind2(radioSelectorItem);
    }

    public final WidgetRadioSelectorViewHolderBinding getBinding() {
        return this.binding;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    /* JADX INFO: renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(RadioSelectorItem data) {
        m.checkNotNullParameter(data, "data");
        this.binding.f2518b.setText(data.getText());
        this.binding.f2518b.setImageRes(Integer.valueOf(data.getSelected() ? 2131231654 : 0));
        this.binding.f2518b.setOnClickListener(new RadioSelectorViewHolder$bind$1(this, data));
    }
}
