package com.discord.widgets.botuikit.views.select;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetViewModel;
import d0.Tuples;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(SelectComponentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0)};

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

        public final void show(FragmentManager fragmentManager, SelectComponentBottomSheet2 componentContext, int componentIndex, String customId, String placeholder, int min, int max, List<SelectComponent2> options, List<SelectComponent2> selectedItems, boolean emojiAnimationsEnabled) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(componentContext, "componentContext");
            Intrinsics3.checkNotNullParameter(customId, "customId");
            Intrinsics3.checkNotNullParameter(options, "options");
            Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
            SelectComponentBottomSheet selectComponentBottomSheet = new SelectComponentBottomSheet();
            selectComponentBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT, componentContext), Tuples.to(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX, Integer.valueOf(componentIndex)), Tuples.to(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, customId), Tuples.to(SelectComponentBottomSheet.EXTRA_PLACEHOLDER, placeholder), Tuples.to(SelectComponentBottomSheet.EXTRA_MIN, Integer.valueOf(min)), Tuples.to(SelectComponentBottomSheet.EXTRA_MAX, Integer.valueOf(max)), Tuples.to(SelectComponentBottomSheet.EXTRA_OPTIONS, options), Tuples.to(SelectComponentBottomSheet.EXTRA_SELECTED, selectedItems), Tuples.to(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED, Boolean.valueOf(emojiAnimationsEnabled))));
            selectComponentBottomSheet.show(fragmentManager, SelectComponentBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SelectComponentBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((SelectComponentBottomSheet) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SelectComponentBottomSheetViewModel.Event, Unit> {
        public AnonymousClass2(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((SelectComponentBottomSheet) this.receiver).handleEvent(event);
        }
    }

    public SelectComponentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, SelectComponentBottomSheet4.INSTANCE, null, 2, null);
        this.adapter = new SelectComponentBottomSheetAdapter(new SelectComponentBottomSheet3(this));
        SelectComponentBottomSheet5 selectComponentBottomSheet5 = new SelectComponentBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SelectComponentBottomSheetViewModel.class), new SelectComponentBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(selectComponentBottomSheet5));
    }

    private final void configureUI(SelectComponentBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().f2532b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetSheetComponentBottomSheetPlaceholder");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.widgetSheetComponentBottomSheetSubtitle");
        textView2.setVisibility(viewState.getIsMultiSelect() ? 0 : 8);
        if (viewState.getIsMultiSelect()) {
            TextView textView3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.widgetSheetComponentBottomSheetSubtitle");
            textView3.setText(FormatUtils.e(this, R.string.message_select_component_select_requirement, new Object[]{Integer.valueOf(viewState.getMinSelections())}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        }
        TextView textView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.widgetSheetComponentBottomSheetSelect");
        textView4.setVisibility(true ^ viewState.getShowSelectButton() ? 4 : 0);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectComponentBottomSheet.this.getViewModel().onClickSelect();
            }
        });
        TextView textView5 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.widgetSheetComponentBottomSheetSelect");
        ViewExtensions.setEnabledAlpha(textView5, viewState.getIsValidSelection(), 0.3f);
        TextView textView6 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.widgetSheetComponentBottomSheetSelect");
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
        if (Intrinsics3.areEqual(event, SelectComponentBottomSheetViewModel.Event.CloseSheet.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_select_component_bottom_sheet;
    }

    public final void onItemSelected(SelectComponent2 item, boolean isSelected) {
        Intrinsics3.checkNotNullParameter(item, "item");
        getViewModel().selectItem(item, isSelected);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) SelectComponentBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) SelectComponentBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSheetComponentBottomSheetRecycler");
        maxHeightRecyclerView.setAdapter(this.adapter);
    }
}
