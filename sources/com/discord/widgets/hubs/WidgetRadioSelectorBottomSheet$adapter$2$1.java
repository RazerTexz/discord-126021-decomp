package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.R$layout;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.views.IconRow;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet$adapter$2$1 extends o implements Function2<LayoutInflater, ViewGroup, RadioSelectorViewHolder> {
    public final /* synthetic */ WidgetRadioSelectorBottomSheet$adapter$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet$adapter$2$1(WidgetRadioSelectorBottomSheet$adapter$2 widgetRadioSelectorBottomSheet$adapter$2) {
        super(2);
        this.this$0 = widgetRadioSelectorBottomSheet$adapter$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ RadioSelectorViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RadioSelectorViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m.checkNotNullParameter(layoutInflater, "inflater");
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(R$layout.widget_radio_selector_view_holder, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        IconRow iconRow = (IconRow) viewInflate;
        WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding = new WidgetRadioSelectorViewHolderBinding(iconRow, iconRow);
        m.checkNotNullExpressionValue(widgetRadioSelectorViewHolderBinding, "WidgetRadioSelectorViewH…(inflater, parent, false)");
        return new RadioSelectorViewHolder(widgetRadioSelectorViewHolderBinding, new WidgetRadioSelectorBottomSheet$adapter$2$1$1(this));
    }
}
