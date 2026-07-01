package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadBrowserFilterSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadBrowserFilterSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", 0)};
    public static final WidgetThreadBrowserFilterSheet$Companion Companion = new WidgetThreadBrowserFilterSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetThreadBrowserFilterSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowserFilterSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetThreadBrowserFilterSheet$guildId$2(this));
        this.channelId = g.lazy(new WidgetThreadBrowserFilterSheet$channelId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowserFilterSheet$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetThreadBrowserFilterSheet$viewModel$2(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet, WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState) {
        widgetThreadBrowserFilterSheet.configureUI(widgetThreadBrowserArchivedViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetThreadBrowserFilterSheetBinding access$getBinding$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getViewModel$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getViewModel();
    }

    private final void configureUI(WidgetThreadBrowserArchivedViewModel$ViewState viewState) {
        WidgetThreadBrowserArchivedViewModel$ViewMode viewMode = viewState.getViewMode();
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.threadBrowserVisibilityPublic");
        WidgetThreadBrowserArchivedViewModel$VisibilityMode visibility = viewMode.getVisibility();
        WidgetThreadBrowserArchivedViewModel$VisibilityMode widgetThreadBrowserArchivedViewModel$VisibilityMode = WidgetThreadBrowserArchivedViewModel$VisibilityMode.PublicThreads;
        checkedSetting.setChecked(visibility == widgetThreadBrowserArchivedViewModel$VisibilityMode);
        CheckedSetting checkedSetting2 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.threadBrowserVisibilityPrivate");
        checkedSetting2.setChecked(viewMode.getVisibility() == WidgetThreadBrowserArchivedViewModel$VisibilityMode.PrivateThreads);
        CardView cardView = getBinding().c;
        m.checkNotNullExpressionValue(cardView, "binding.threadBrowserModeratorViewCard");
        cardView.setVisibility(viewState.isModerator() ? 0 : 8);
        if (viewMode.getVisibility() == widgetThreadBrowserArchivedViewModel$VisibilityMode) {
            CheckedSetting.d(getBinding().f2671b, null, 1);
        } else {
            getBinding().f2671b.e(new WidgetThreadBrowserFilterSheet$configureUI$1(this));
        }
        getBinding().f2671b.g(viewMode.isModeratorMode(), false);
    }

    private final WidgetThreadBrowserFilterSheetBinding getBinding() {
        return (WidgetThreadBrowserFilterSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserArchivedViewModel getViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowserFilterSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowserFilterSheet$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_thread_browser_filter_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().e.e(new WidgetThreadBrowserFilterSheet$onResume$1(this));
        getBinding().d.e(new WidgetThreadBrowserFilterSheet$onResume$2(this));
    }
}
