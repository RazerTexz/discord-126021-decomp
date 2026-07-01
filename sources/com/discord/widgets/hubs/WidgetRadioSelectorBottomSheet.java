package com.discord.widgets.hubs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetRadioSelectorBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", 0)};
    public static final WidgetRadioSelectorBottomSheet$Companion Companion = new WidgetRadioSelectorBottomSheet$Companion(null);

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super Integer, Unit> onSelected;

    public WidgetRadioSelectorBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetRadioSelectorBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.args = g.lazy(new WidgetRadioSelectorBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        this.adapter = g.lazy(new WidgetRadioSelectorBottomSheet$adapter$2(this));
    }

    public final SimpleRecyclerAdapter<RadioSelectorItem, RadioSelectorViewHolder> getAdapter() {
        return (SimpleRecyclerAdapter) this.adapter.getValue();
    }

    public final RadioSelectorItems getArgs() {
        return (RadioSelectorItems) this.args.getValue();
    }

    public final WidgetRadioSelectorBottomSheetBinding getBinding() {
        return (WidgetRadioSelectorBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_radio_selector_bottom_sheet;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(getAdapter());
        TextView textView = getBinding().f2517b;
        m.checkNotNullExpressionValue(textView, "binding.radioSelectorBottomSheetTitle");
        textView.setText(getArgs().getTitle());
    }

    public final void setOnSelected(Function1<? super Integer, Unit> function1) {
        this.onSelected = function1;
    }
}
