package com.discord.widgets.botuikit.views.select;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.botuikit.SelectItem;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(SelectComponentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, ComponentContext componentContext, int componentIndex, String customId, String placeholder, int min, int max, List<SelectItem> options, List<SelectItem> selectedItems, boolean emojiAnimationsEnabled) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(componentContext, "componentContext");
            C12238m.checkNotNullParameter(customId, "customId");
            C12238m.checkNotNullParameter(options, "options");
            C12238m.checkNotNullParameter(selectedItems, "selectedItems");
            SelectComponentBottomSheet selectComponentBottomSheet = new SelectComponentBottomSheet();
            selectComponentBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT, componentContext), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX, Integer.valueOf(componentIndex)), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, customId), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_PLACEHOLDER, placeholder), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_MIN, Integer.valueOf(min)), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_MAX, Integer.valueOf(max)), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_OPTIONS, options), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_SELECTED, selectedItems), C12116o.m10073to(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED, Boolean.valueOf(emojiAnimationsEnabled))));
            selectComponentBottomSheet.show(fragmentManager, SelectComponentBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
    public static final /* synthetic */ class C72771 extends C12236k implements Function1<SelectComponentBottomSheetViewModel.ViewState, Unit> {
        public C72771(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((SelectComponentBottomSheet) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$2 */
    /* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
    public static final /* synthetic */ class C72782 extends C12236k implements Function1<SelectComponentBottomSheetViewModel.Event, Unit> {
        public C72782(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((SelectComponentBottomSheet) this.receiver).handleEvent(event);
        }
    }

    public SelectComponentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, SelectComponentBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SelectComponentBottomSheetAdapter(new SelectComponentBottomSheet$adapter$1(this));
        SelectComponentBottomSheet$viewModel$2 selectComponentBottomSheet$viewModel$2 = new SelectComponentBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(SelectComponentBottomSheetViewModel.class), new SelectComponentBottomSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(selectComponentBottomSheet$viewModel$2));
    }

    private final void configureUI(SelectComponentBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().f17450b;
        C12238m.checkNotNullExpressionValue(textView, "binding.widgetSheetComponentBottomSheetPlaceholder");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().f17453e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.widgetSheetComponentBottomSheetSubtitle");
        textView2.setVisibility(viewState.getIsMultiSelect() ? 0 : 8);
        if (viewState.getIsMultiSelect()) {
            TextView textView3 = getBinding().f17453e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.widgetSheetComponentBottomSheetSubtitle");
            textView3.setText(C1107b.m213e(this, C5419R.string.message_select_component_select_requirement, new Object[]{Integer.valueOf(viewState.getMinSelections())}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        }
        TextView textView4 = getBinding().f17452d;
        C12238m.checkNotNullExpressionValue(textView4, "binding.widgetSheetComponentBottomSheetSelect");
        textView4.setVisibility(true ^ viewState.getShowSelectButton() ? 4 : 0);
        getBinding().f17452d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectComponentBottomSheet.this.getViewModel().onClickSelect();
            }
        });
        TextView textView5 = getBinding().f17452d;
        C12238m.checkNotNullExpressionValue(textView5, "binding.widgetSheetComponentBottomSheetSelect");
        ViewExtensions.setEnabledAlpha(textView5, viewState.getIsValidSelection(), 0.3f);
        TextView textView6 = getBinding().f17452d;
        C12238m.checkNotNullExpressionValue(textView6, "binding.widgetSheetComponentBottomSheetSelect");
        textView6.setClickable(viewState.getIsValidSelection());
        this.adapter.setItems(viewState.getItems(), viewState.getMaxSelections(), viewState.getEmojiAnimationsEnabled());
    }

    private final WidgetSelectComponentBottomSheetBinding getBinding() {
        return (WidgetSelectComponentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SelectComponentBottomSheetViewModel getViewModel() {
        return (SelectComponentBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SelectComponentBottomSheetViewModel.Event event) {
        if (C12238m.areEqual(event, SelectComponentBottomSheetViewModel.Event.CloseSheet.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_select_component_bottom_sheet;
    }

    public final void onItemSelected(SelectItem item, boolean isSelected) {
        C12238m.checkNotNullParameter(item, "item");
        getViewModel().selectItem(item, isSelected);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) SelectComponentBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72771(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) SelectComponentBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72782(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f17451c;
        C12238m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSheetComponentBottomSheetRecycler");
        maxHeightRecyclerView.setAdapter(this.adapter);
    }
}
