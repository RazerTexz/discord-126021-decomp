package com.discord.widgets.hubs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetRadioSelectorBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", 0)};

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

        public final void show(FragmentManager fragmentManager, WidgetRadioSelectorBottomSheet3 items, Function1<? super Integer, Unit> onSelected) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(onSelected, "onSelected");
            WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet = new WidgetRadioSelectorBottomSheet();
            widgetRadioSelectorBottomSheet.setArguments(AnimatableValueParser.e2(items));
            widgetRadioSelectorBottomSheet.setOnSelected(onSelected);
            widgetRadioSelectorBottomSheet.show(fragmentManager, Reflection2.getOrCreateKotlinClass(WidgetRadioSelectorBottomSheet.class).toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetRadioSelectorBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetRadioSelectorBottomSheet6.INSTANCE, null, 2, null);
        this.args = LazyJVM.lazy(new WidgetRadioSelectorBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        this.adapter = LazyJVM.lazy(new WidgetRadioSelectorBottomSheet5(this));
    }

    public final SimpleRecyclerAdapter<WidgetRadioSelectorBottomSheet2, WidgetRadioSelectorBottomSheet4> getAdapter() {
        return (SimpleRecyclerAdapter) this.adapter.getValue();
    }

    public final WidgetRadioSelectorBottomSheet3 getArgs() {
        return (WidgetRadioSelectorBottomSheet3) this.args.getValue();
    }

    public final WidgetRadioSelectorBottomSheetBinding getBinding() {
        return (WidgetRadioSelectorBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_radio_selector_bottom_sheet;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(getAdapter());
        TextView textView = getBinding().f2517b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.radioSelectorBottomSheetTitle");
        textView.setText(getArgs().getTitle());
    }

    public final void setOnSelected(Function1<? super Integer, Unit> function1) {
        this.onSelected = function1;
    }
}
