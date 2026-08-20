package com.discord.widgets.channels;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelPickerSheetBinding;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SelectionType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[SelectionType.CREATE_CHANNEL.ordinal()] = 1;
                iArr[SelectionType.CHANNEL.ordinal()] = 2;
                iArr[SelectionType.UNKNOWN.ordinal()] = 3;
            }
        }

        private Companion() {
        }

        public final void launch(Fragment fragment, String requestKey, long guildId, Long selectedChannelId, Function0<Unit> onCancel, boolean hideAnnouncementChannels) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = new WidgetChannelPickerBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChannelPickerBottomSheet.ARG_REQUEST_KEY, requestKey);
            bundle.putLong(WidgetChannelPickerBottomSheet.ARG_CHANNEL_PICKER_GUILD_ID, guildId);
            bundle.putBoolean(WidgetChannelPickerBottomSheet.ARG_HIDE_ANNOUNCEMENT_CHANNELS, hideAnnouncementChannels);
            if (selectedChannelId != null) {
                bundle.putLong(WidgetChannelPickerBottomSheet.ARG_SELECTED_CHANNEL_ID, selectedChannelId.longValue());
            }
            widgetChannelPickerBottomSheet.setArguments(bundle);
            widgetChannelPickerBottomSheet.setOnCancel(onCancel);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetChannelPickerBottomSheet.show(parentFragmentManager, WidgetChannelPickerBottomSheet.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function3<? super Long, ? super String, ? super Integer, Unit> onChannelSelected, Function0<Unit> onCreateChannelSelected) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onChannelSelected, "onChannelSelected");
            C12238m.checkNotNullParameter(onCreateChannelSelected, "onCreateChannelSelected");
            FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetChannelPickerBottomSheet$Companion$registerForResult$1(requestKey, onCreateChannelSelected, onChannelSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public enum SelectionType {
        UNKNOWN,
        CREATE_CHANNEL,
        CHANNEL;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
        public static final class Companion {
            private Companion() {
            }

            public final SelectionType fromInt(int value) {
                SelectionType selectionType = (SelectionType) C12141k.getOrNull(SelectionType.values(), value);
                return selectionType != null ? selectionType : SelectionType.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public static final class C73321 extends AbstractC12240o implements Function1<WidgetChannelPickerBottomSheetViewModel.ViewState, Unit> {
        public C73321() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetChannelPickerBottomSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public static final class C73331 extends AbstractC12240o implements Function1<String, Unit> {
        public C73331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "searchQuery");
            WidgetChannelPickerBottomSheet.this.getViewModel().updateSearchQuery(str);
        }
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.discord.widgets.channels.WidgetChannelPickerBottomSheet$itemClickListener$1] */
    public WidgetChannelPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelPickerBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.selectedChannelId = C12083g.lazy(new WidgetChannelPickerBottomSheet$selectedChannelId$2(this));
        this.guildId = C12083g.lazy(new WidgetChannelPickerBottomSheet$guildId$2(this));
        this.hideAnnouncementChannels = C12083g.lazy(new WidgetChannelPickerBottomSheet$hideAnnouncementChannels$2(this));
        WidgetChannelPickerBottomSheet$viewModel$2 widgetChannelPickerBottomSheet$viewModel$2 = new WidgetChannelPickerBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChannelPickerBottomSheetViewModel.class), new C7331xa50f5668(c0865g0), new C0869i0(widgetChannelPickerBottomSheet$viewModel$2));
        this.itemClickListener = new WidgetchannelPickerAdapter.OnItemClickListener() { // from class: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$itemClickListener$1
            @Override // com.discord.widgets.channels.WidgetchannelPickerAdapter.OnItemClickListener
            public void onChannelItemClick(ChannelPickerAdapterItem.ChannelItem channelItem) {
                C12238m.checkNotNullParameter(channelItem, "channelItem");
                String string = this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
                WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
                C12238m.checkNotNullExpressionValue(string, "requestCode");
                FragmentKt.setFragmentResult(widgetChannelPickerBottomSheet, string, BundleKt.bundleOf(C12116o.m10073to("RESULT_EXTRA_CHANNEL_ID", Long.valueOf(channelItem.getChannel().getId())), C12116o.m10073to("RESULT_EXTRA_CHANNEL_NAME", ChannelUtils.m7679c(channelItem.getChannel())), C12116o.m10073to("RESULT_EXTRA_CHANNEL_ICON_RES_ID", Integer.valueOf(GuildChannelIconUtilsKt.guildChannelIcon(channelItem.getChannel()))), C12116o.m10073to("RESULT_EXTRA_SELECTION_TYPE", Integer.valueOf(WidgetChannelPickerBottomSheet.SelectionType.CHANNEL.ordinal()))));
                this.this$0.dismiss();
            }

            @Override // com.discord.widgets.channels.WidgetchannelPickerAdapter.OnItemClickListener
            public void onCreateChannelClick() {
                String string = this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
                WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
                C12238m.checkNotNullExpressionValue(string, "requestCode");
                Bundle bundle = new Bundle();
                bundle.putInt("RESULT_EXTRA_SELECTION_TYPE", WidgetChannelPickerBottomSheet.SelectionType.CREATE_CHANNEL.ordinal());
                FragmentKt.setFragmentResult(widgetChannelPickerBottomSheet, string, bundle);
                this.this$0.dismiss();
            }
        };
    }

    private final void configureUI(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f15884b;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.channelPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
            SearchInputView searchInputView = getBinding().f15886d;
            C12238m.checkNotNullExpressionValue(searchInputView, "binding.channelPickerSearchInput");
            searchInputView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel.ViewState.Loaded) {
            SearchInputView searchInputView2 = getBinding().f15886d;
            C12238m.checkNotNullExpressionValue(searchInputView2, "binding.channelPickerSearchInput");
            searchInputView2.setVisibility(0);
            AppViewFlipper appViewFlipper2 = getBinding().f15884b;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.channelPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetchannelPickerAdapter widgetchannelPickerAdapter = this.adapter;
            if (widgetchannelPickerAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("adapter");
            }
            widgetchannelPickerAdapter.setItems(((WidgetChannelPickerBottomSheetViewModel.ViewState.Loaded) viewState).getAdapterItems());
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
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelPickerBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73321());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channel_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new WidgetchannelPickerAdapter(this.itemClickListener, this, null, 4, null);
        RecyclerView recyclerView = getBinding().f15885c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.channelPickerRecycler");
        WidgetchannelPickerAdapter widgetchannelPickerAdapter = this.adapter;
        if (widgetchannelPickerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetchannelPickerAdapter);
        getBinding().f15886d.m8553a(this, new C73331());
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }
}
