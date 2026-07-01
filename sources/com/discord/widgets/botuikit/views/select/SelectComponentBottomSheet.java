package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.botuikit.SelectItem;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(SelectComponentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0)};
    public static final SelectComponentBottomSheet$Companion Companion = new SelectComponentBottomSheet$Companion(null);
    public static final String EXTRA_COMPONENT_CONTEXT = "extra_component_context";
    public static final String EXTRA_COMPONENT_INDEX = "extra_component_index";
    public static final String EXTRA_CUSTOM_ID = "extra_custom_id";
    public static final String EXTRA_EMOJI_ANIMATIONS_ENABLED = "extra_emoji_animations_enabled";
    public static final String EXTRA_MAX = "extra_max";
    public static final String EXTRA_MIN = "extra_min";
    public static final String EXTRA_OPTIONS = "extra_options";
    public static final String EXTRA_PLACEHOLDER = "extra_placeholder";
    public static final String EXTRA_SELECTED = "extra_selected";
    private final SelectComponentBottomSheetAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public SelectComponentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, SelectComponentBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SelectComponentBottomSheetAdapter(new SelectComponentBottomSheet$adapter$1(this));
        SelectComponentBottomSheet$viewModel$2 selectComponentBottomSheet$viewModel$2 = new SelectComponentBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SelectComponentBottomSheetViewModel.class), new SelectComponentBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(selectComponentBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(SelectComponentBottomSheet selectComponentBottomSheet, SelectComponentBottomSheetViewModel$ViewState selectComponentBottomSheetViewModel$ViewState) {
        selectComponentBottomSheet.configureUI(selectComponentBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(SelectComponentBottomSheet selectComponentBottomSheet) {
        return selectComponentBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ SelectComponentBottomSheetViewModel access$getViewModel$p(SelectComponentBottomSheet selectComponentBottomSheet) {
        return selectComponentBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(SelectComponentBottomSheet selectComponentBottomSheet, SelectComponentBottomSheetViewModel$Event selectComponentBottomSheetViewModel$Event) {
        selectComponentBottomSheet.handleEvent(selectComponentBottomSheetViewModel$Event);
    }

    private final void configureUI(SelectComponentBottomSheetViewModel$ViewState viewState) {
        TextView textView = getBinding().f2532b;
        m.checkNotNullExpressionValue(textView, "binding.widgetSheetComponentBottomSheetPlaceholder");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.widgetSheetComponentBottomSheetSubtitle");
        textView2.setVisibility(viewState.getIsMultiSelect() ? 0 : 8);
        if (viewState.getIsMultiSelect()) {
            TextView textView3 = getBinding().e;
            m.checkNotNullExpressionValue(textView3, "binding.widgetSheetComponentBottomSheetSubtitle");
            textView3.setText(b.k(this, 2131892972, new Object[]{Integer.valueOf(viewState.getMinSelections())}, null, 4));
        }
        TextView textView4 = getBinding().d;
        m.checkNotNullExpressionValue(textView4, "binding.widgetSheetComponentBottomSheetSelect");
        textView4.setVisibility(true ^ viewState.getShowSelectButton() ? 4 : 0);
        getBinding().d.setOnClickListener(new SelectComponentBottomSheet$configureUI$1(this));
        TextView textView5 = getBinding().d;
        m.checkNotNullExpressionValue(textView5, "binding.widgetSheetComponentBottomSheetSelect");
        ViewExtensions.setEnabledAlpha(textView5, viewState.getIsValidSelection(), 0.3f);
        TextView textView6 = getBinding().d;
        m.checkNotNullExpressionValue(textView6, "binding.widgetSheetComponentBottomSheetSelect");
        textView6.setClickable(viewState.getIsValidSelection());
        this.adapter.setItems(viewState.getItems(), viewState.getMaxSelections(), viewState.getEmojiAnimationsEnabled());
    }

    private final WidgetSelectComponentBottomSheetBinding getBinding() {
        return (WidgetSelectComponentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SelectComponentBottomSheetViewModel getViewModel() {
        return (SelectComponentBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SelectComponentBottomSheetViewModel$Event event) {
        if (m.areEqual(event, SelectComponentBottomSheetViewModel$Event$CloseSheet.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_select_component_bottom_sheet;
    }

    public final void onItemSelected(SelectItem item, boolean isSelected) {
        m.checkNotNullParameter(item, "item");
        getViewModel().selectItem(item, isSelected);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), SelectComponentBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SelectComponentBottomSheet$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), SelectComponentBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SelectComponentBottomSheet$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().c;
        m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSheetComponentBottomSheetRecycler");
        maxHeightRecyclerView.setAdapter(this.adapter);
    }
}
