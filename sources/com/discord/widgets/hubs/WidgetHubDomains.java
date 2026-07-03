package com.discord.widgets.hubs;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainsBinding;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubDomains.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainsBinding;", 0)};
    private final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final class C90301 extends AbstractC12240o implements Function1<DomainsState, Unit> {
        public C90301() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DomainsState domainsState) {
            invoke2(domainsState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DomainsState domainsState) {
            WidgetHubDomains widgetHubDomains = WidgetHubDomains.this;
            C12238m.checkNotNullExpressionValue(domainsState, "viewState");
            widgetHubDomains.updateView(domainsState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$updateView$1 */
    /* JADX INFO: compiled from: WidgetHubDomains.kt */
    public static final class C90311 extends AbstractC12240o implements Function1<Success<? extends Object>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DomainsState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90311(Context context, DomainsState domainsState) {
            super(1);
            this.$context = context;
            this.$state = domainsState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends Object> success) {
            invoke2(success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<? extends Object> success) {
            C12238m.checkNotNullParameter(success, "it");
            C0870j.m158g(C0870j.f524g, WidgetHubDomains.this.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new HubAuthenticationArgs(WidgetHubDomains.this.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
            WidgetHubDomains.this.getViewModel().reset();
        }
    }

    public WidgetHubDomains() {
        super(C5419R.layout.widget_hub_domains);
        this.args = C12083g.lazy(new WidgetHubDomains$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDomains$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomains$adapter$1(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new C9027x7a97847d(this), new C0863f0(WidgetHubDomains$viewModel$2.INSTANCE));
    }

    private final void updateView(DomainsState state) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new C90311(context, state), 6, null);
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
        C12238m.checkNotNullParameter(guildInfo, "guildInfo");
        getViewModel().onGuildClicked(guildInfo.getId(), getArgs().getEmail());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f17171b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        this.adapter.setData(getArgs().getGuildInfos());
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_search, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.hubs.WidgetHubDomains.onViewBound.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "item");
                if (menuItem.getItemId() == C5419R.id.search) {
                    C0870j c0870j = C0870j.f524g;
                    FragmentManager parentFragmentManager = WidgetHubDomains.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(context, "context");
                    C0870j.m158g(c0870j, parentFragmentManager, context, WidgetHubDomainSearch.class, 0, true, null, null, 104);
                }
            }
        }, null, 4, null);
        MaterialButton materialButton = getBinding().f17172c;
        final Context context = materialButton.getContext();
        if (context != null) {
            materialButton.setText(C1107b.m210b(context, C5419R.string.hub_email_connection_guild_select_subheader, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null));
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDomains$onViewBound$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C0870j.m158g(C0870j.f524g, this.getParentFragmentManager(), context, WidgetHubWaitlist.class, 0, true, null, new HubWaitlistArgs(this.getArgs().getEmail()), 40);
                }
            });
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<DomainsState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetHubDomains.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90301());
    }
}
