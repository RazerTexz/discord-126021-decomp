package com.discord.widgets.channels;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelPickerSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet extends AppBottomSheet {
    private static final String ARG_CHANNEL_PICKER_GUILD_ID = "ARG_CHANNEL_PICKER_GUILD_ID";
    private static final String ARG_HIDE_ANNOUNCEMENT_CHANNELS = "ARG_HIDE_ANNOUNCEMENT_CHANNELS";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String ARG_SELECTED_CHANNEL_ID = "ARG_SELECTED_CHANNEL_ID";
    private static final int CHANNEL_PICKER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int CHANNEL_PICKER_VIEW_FLIPPER_RESULT = 1;
    private static final String RESULT_EXTRA_CHANNEL_ICON_RES_ID = "RESULT_EXTRA_CHANNEL_ICON_RES_ID";
    private static final String RESULT_EXTRA_CHANNEL_ID = "RESULT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "RESULT_EXTRA_CHANNEL_NAME";
    private static final String RESULT_EXTRA_SELECTION_TYPE = "RESULT_EXTRA_SELECTION_TYPE";
    private WidgetchannelPickerAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hideAnnouncementChannels$delegate, reason: from kotlin metadata */
    private final Lazy hideAnnouncementChannels;
    private final WidgetChannelPickerBottomSheet$itemClickListener$1 itemClickListener;
    private Function0<Unit> onCancel;

    /* JADX INFO: renamed from: selectedChannelId$delegate, reason: from kotlin metadata */
    private final Lazy selectedChannelId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", 0)};
    public static final WidgetChannelPickerBottomSheet$Companion Companion = new WidgetChannelPickerBottomSheet$Companion(null);

    public WidgetChannelPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelPickerBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.selectedChannelId = g.lazy(new WidgetChannelPickerBottomSheet$selectedChannelId$2(this));
        this.guildId = g.lazy(new WidgetChannelPickerBottomSheet$guildId$2(this));
        this.hideAnnouncementChannels = g.lazy(new WidgetChannelPickerBottomSheet$hideAnnouncementChannels$2(this));
        WidgetChannelPickerBottomSheet$viewModel$2 widgetChannelPickerBottomSheet$viewModel$2 = new WidgetChannelPickerBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelPickerBottomSheetViewModel.class), new WidgetChannelPickerBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelPickerBottomSheet$viewModel$2));
        this.itemClickListener = new WidgetChannelPickerBottomSheet$itemClickListener$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet, WidgetChannelPickerBottomSheetViewModel$ViewState widgetChannelPickerBottomSheetViewModel$ViewState) {
        widgetChannelPickerBottomSheet.configureUI(widgetChannelPickerBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getGuildId();
    }

    public static final /* synthetic */ boolean access$getHideAnnouncementChannels$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getHideAnnouncementChannels();
    }

    public static final /* synthetic */ long access$getSelectedChannelId$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getSelectedChannelId();
    }

    public static final /* synthetic */ WidgetChannelPickerBottomSheetViewModel access$getViewModel$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getViewModel();
    }

    private final void configureUI(WidgetChannelPickerBottomSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2264b;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.channelPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
            SearchInputView searchInputView = getBinding().d;
            m.checkNotNullExpressionValue(searchInputView, "binding.channelPickerSearchInput");
            searchInputView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded) {
            SearchInputView searchInputView2 = getBinding().d;
            m.checkNotNullExpressionValue(searchInputView2, "binding.channelPickerSearchInput");
            searchInputView2.setVisibility(0);
            AppViewFlipper appViewFlipper2 = getBinding().f2264b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.channelPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetchannelPickerAdapter widgetchannelPickerAdapter = this.adapter;
            if (widgetchannelPickerAdapter == null) {
                m.throwUninitializedPropertyAccessException("adapter");
            }
            widgetchannelPickerAdapter.setItems(((WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded) viewState).getAdapterItems());
        }
    }

    private final WidgetChannelPickerSheetBinding getBinding() {
        return (WidgetChannelPickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getHideAnnouncementChannels() {
        return ((Boolean) this.hideAnnouncementChannels.getValue()).booleanValue();
    }

    private final long getSelectedChannelId() {
        return ((Number) this.selectedChannelId.getValue()).longValue();
    }

    private final WidgetChannelPickerBottomSheetViewModel getViewModel() {
        return (WidgetChannelPickerBottomSheetViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetChannelPickerBottomSheet.setOnCancel(function0);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelPickerBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelPickerBottomSheet$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channel_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new WidgetchannelPickerAdapter(this.itemClickListener, this, null, 4, null);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.channelPickerRecycler");
        WidgetchannelPickerAdapter widgetchannelPickerAdapter = this.adapter;
        if (widgetchannelPickerAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetchannelPickerAdapter);
        getBinding().d.a(this, new WidgetChannelPickerBottomSheet$onViewCreated$1(this));
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }
}
