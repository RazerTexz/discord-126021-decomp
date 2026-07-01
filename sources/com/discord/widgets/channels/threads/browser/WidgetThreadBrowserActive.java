package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
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

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActive extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadBrowserActive.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0)};
    public static final WidgetThreadBrowserActive$Companion Companion = new WidgetThreadBrowserActive$Companion(null);
    private WidgetThreadBrowserAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: browserViewModel$delegate, reason: from kotlin metadata */
    private final Lazy browserViewModel;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetThreadBrowserActive() {
        super(R$layout.widget_thread_browser_active);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowserActive$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetThreadBrowserActive$guildId$2(this));
        this.channelId = g.lazy(new WidgetThreadBrowserActive$channelId$2(this));
        WidgetThreadBrowserActive$viewModel$2 widgetThreadBrowserActive$viewModel$2 = new WidgetThreadBrowserActive$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserActiveViewModel.class), new WidgetThreadBrowserActive$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetThreadBrowserActive$viewModel$2));
        this.browserViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowserActive$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetThreadBrowserActive$browserViewModel$2(this)));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        return widgetThreadBrowserActive.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        return widgetThreadBrowserActive.getGuildId();
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowserActive widgetThreadBrowserActive, WidgetThreadBrowserActiveViewModel$ViewState widgetThreadBrowserActiveViewModel$ViewState) {
        widgetThreadBrowserActive.updateView(widgetThreadBrowserActiveViewModel$ViewState);
    }

    private final WidgetThreadBrowserActiveBinding getBinding() {
        return (WidgetThreadBrowserActiveBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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

    private final WidgetThreadBrowserActiveViewModel getViewModel() {
        return (WidgetThreadBrowserActiveViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetThreadBrowserActiveViewModel$ViewState viewState) {
        WidgetThreadBrowserAdapter widgetThreadBrowserAdapter = this.adapter;
        if (widgetThreadBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetThreadBrowserAdapter.setData(viewState.getListItems());
        TextView textView = getBinding().f2668b.d;
        m.checkNotNullExpressionValue(textView, "binding.emptyView.threadBrowserEmptyHeading");
        textView.setText(requireContext().getString(2131896351));
        ConstraintLayout constraintLayout = getBinding().f2668b.f196b;
        m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.threadBrowserEmpty");
        constraintLayout.setVisibility(viewState.getListItems().isEmpty() ? 0 : 8);
        MaterialButton materialButton = getBinding().f2668b.c;
        m.checkNotNullExpressionValue(materialButton, "binding.emptyView.threadBrowserEmptyCreateButton");
        materialButton.setVisibility(viewState.getCanCreateThread() ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowserActive.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowserActive$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (WidgetThreadBrowserAdapter) mGRecyclerAdapter$Companion.configure(new WidgetThreadBrowserAdapter(recyclerView, new WidgetThreadBrowserActive$onViewBound$1(getBrowserViewModel()), new WidgetThreadBrowserActive$onViewBound$2(this)));
        getBinding().f2668b.c.setOnClickListener(new WidgetThreadBrowserActive$onViewBound$3(this));
    }
}
