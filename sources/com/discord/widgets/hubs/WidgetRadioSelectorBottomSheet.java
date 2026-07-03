package com.discord.widgets.hubs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetRadioSelectorBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super Integer, Unit> onSelected;

    /* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, RadioSelectorItems items, Function1<? super Integer, Unit> onSelected) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(items, "items");
            C12238m.checkNotNullParameter(onSelected, "onSelected");
            WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet = new WidgetRadioSelectorBottomSheet();
            widgetRadioSelectorBottomSheet.setArguments(C1460d.m514e2(items));
            widgetRadioSelectorBottomSheet.setOnSelected(onSelected);
            widgetRadioSelectorBottomSheet.show(fragmentManager, C12216a0.getOrCreateKotlinClass(WidgetRadioSelectorBottomSheet.class).toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetRadioSelectorBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetRadioSelectorBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.args = C12083g.lazy(new WidgetRadioSelectorBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        this.adapter = C12083g.lazy(new WidgetRadioSelectorBottomSheet$adapter$2(this));
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
        return C5419R.layout.widget_radio_selector_bottom_sheet;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f17403c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(getAdapter());
        TextView textView = getBinding().f17402b;
        C12238m.checkNotNullExpressionValue(textView, "binding.radioSelectorBottomSheetTitle");
        textView.setText(getArgs().getTitle());
    }

    public final void setOnSelected(Function1<? super Integer, Unit> function1) {
        this.onSelected = function1;
    }
}
