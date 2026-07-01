package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainsBinding;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubDomains.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainsBinding;", 0)};
    private final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHubDomains() {
        super(R$layout.widget_hub_domains);
        this.args = g.lazy(new WidgetHubDomains$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDomains$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomains$adapter$1(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new WidgetHubDomains$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetHubDomains$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$updateView(WidgetHubDomains widgetHubDomains, DomainsState domainsState) {
        widgetHubDomains.updateView(domainsState);
    }

    private final void updateView(DomainsState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new WidgetHubDomains$updateView$1(this, context, state), 6, null);
        }
    }

    public final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> getAdapter() {
        return this.adapter;
    }

    public final HubDomainArgs getArgs() {
        return (HubDomainArgs) this.args.getValue();
    }

    public final WidgetHubDomainsBinding getBinding() {
        return (WidgetHubDomainsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubDomainsViewModel getViewModel() {
        return (WidgetHubDomainsViewModel) this.viewModel.getValue();
    }

    public final void onServerClickListener(DomainGuildInfo guildInfo) {
        m.checkNotNullParameter(guildInfo, "guildInfo");
        getViewModel().onGuildClicked(guildInfo.getId(), getArgs().getEmail());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f2472b;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        this.adapter.setData(getArgs().getGuildInfos());
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_search, new WidgetHubDomains$onViewBound$1(this), null, 4, null);
        MaterialButton materialButton = getBinding().c;
        Context context = materialButton.getContext();
        if (context != null) {
            materialButton.setText(b.h(context, 2131891790, new Object[0], null, 4));
            materialButton.setOnClickListener(new WidgetHubDomains$onViewBound$$inlined$apply$lambda$1(context, this));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<DomainsState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubDomains.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubDomains$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
