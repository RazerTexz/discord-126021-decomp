package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadBrowserArchived.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0)};
    public static final WidgetThreadBrowserArchived$Companion Companion = new WidgetThreadBrowserArchived$Companion(null);
    private WidgetThreadBrowserAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: browserViewModel$delegate, reason: from kotlin metadata */
    private final Lazy browserViewModel;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetThreadBrowserArchivedViewModel$ViewState currentViewState;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetThreadBrowserArchived() {
        super(R$layout.widget_thread_browser_archived);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowserArchived$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetThreadBrowserArchived$guildId$2(this));
        this.channelId = g.lazy(new WidgetThreadBrowserArchived$channelId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowserArchived$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetThreadBrowserArchived$viewModel$2(this)));
        this.browserViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowserArchived$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetThreadBrowserArchived$browserViewModel$2(this)));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        return widgetThreadBrowserArchived.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        return widgetThreadBrowserArchived.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getViewModel$p(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        return widgetThreadBrowserArchived.getViewModel();
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowserArchived widgetThreadBrowserArchived, WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState) {
        widgetThreadBrowserArchived.updateView(widgetThreadBrowserArchivedViewModel$ViewState);
    }

    private final WidgetThreadBrowserArchivedBinding getBinding() {
        return (WidgetThreadBrowserArchivedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadBrowserViewModel getBrowserViewModel() {
        return (WidgetThreadBrowserViewModel) this.browserViewModel.getValue();
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

    private final void updateView(WidgetThreadBrowserArchivedViewModel$ViewState viewState) {
        ConstraintLayout constraintLayout = getBinding().d;
        m.checkNotNullExpressionValue(constraintLayout, "binding.threadBrowserErrorOverlay");
        constraintLayout.setVisibility(viewState.isError() ? 0 : 8);
        this.currentViewState = viewState;
        WidgetThreadBrowserAdapter widgetThreadBrowserAdapter = this.adapter;
        if (widgetThreadBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetThreadBrowserAdapter.setData(viewState.getListItems());
        TextView textView = getBinding().f2669b.d;
        m.checkNotNullExpressionValue(textView, "binding.emptyView.threadBrowserEmptyHeading");
        textView.setText(requireContext().getString(2131896352));
        ConstraintLayout constraintLayout2 = getBinding().f2669b.f196b;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.emptyView.threadBrowserEmpty");
        constraintLayout2.setVisibility(viewState.getListItems().isEmpty() ? 0 : 8);
        MaterialButton materialButton = getBinding().f2669b.c;
        m.checkNotNullExpressionValue(materialButton, "binding.emptyView.threadBrowserEmptyCreateButton");
        materialButton.setVisibility(viewState.getCanCreateThread() ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowserArchived.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowserArchived$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (WidgetThreadBrowserAdapter) mGRecyclerAdapter$Companion.configure(new WidgetThreadBrowserAdapter(recyclerView, new WidgetThreadBrowserArchived$onViewBound$1(getBrowserViewModel()), new WidgetThreadBrowserArchived$onViewBound$2(this)));
        getBinding().c.addOnScrollListener(new WidgetThreadBrowserArchived$onViewBound$3(this));
        getBinding().f2669b.c.setOnClickListener(new WidgetThreadBrowserArchived$onViewBound$4(this));
        getBinding().e.setOnClickListener(new WidgetThreadBrowserArchived$onViewBound$5(this));
    }
}
