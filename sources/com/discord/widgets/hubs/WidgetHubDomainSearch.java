package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainSearchBinding;
import com.discord.i18n.RenderContext;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
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
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubDomainSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainSearchBinding;", 0)};
    private final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90224 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C90224() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetHubDomainSearch.this.searchForGuild();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90235 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBound$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                C0870j c0870j = C0870j.f524g;
                FragmentManager parentFragmentManager = WidgetHubDomainSearch.this.getParentFragmentManager();
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                C0870j.m158g(c0870j, parentFragmentManager, context, WidgetHubWaitlist.class, 0, true, null, new HubWaitlistArgs(WidgetHubDomainSearch.this.getArgs().getEmail()), 40);
            }
        }

        public C90235() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onJoinWaitlist", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90241 extends AbstractC12240o implements Function1<DomainsState, Unit> {
        public C90241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DomainsState domainsState) {
            invoke2(domainsState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DomainsState domainsState) {
            WidgetHubDomainSearch widgetHubDomainSearch = WidgetHubDomainSearch.this;
            C12238m.checkNotNullExpressionValue(domainsState, "viewState");
            widgetHubDomainSearch.updateView(domainsState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$updateView$1 */
    /* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
    public static final class C90251 extends AbstractC12240o implements Function1<Success<? extends Object>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DomainsState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90251(Context context, DomainsState domainsState) {
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
            C0870j.m158g(C0870j.f524g, WidgetHubDomainSearch.this.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new HubAuthenticationArgs(WidgetHubDomainSearch.this.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
            WidgetHubDomainSearch.this.getViewModel().reset();
        }
    }

    public WidgetHubDomainSearch() {
        super(C5419R.layout.widget_hub_domain_search);
        this.args = C12083g.lazy(new WidgetHubDomainSearch$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDomainSearch$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomainSearch$adapter$1(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new C9018xb5e5d61c(this), new C0863f0(WidgetHubDomainSearch$viewModel$2.INSTANCE));
    }

    private final void searchForGuild() {
        TextInputEditText textInputEditText = getBinding().f17169h;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        String strValueOf = String.valueOf(textInputEditText.getText());
        Locale locale = Locale.getDefault();
        C12238m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String lowerCase = strValueOf.toLowerCase(locale);
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<DomainGuildInfo> guildInfos = getArgs().getGuildInfos();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String name = ((DomainGuildInfo) next).getName();
            Locale locale2 = Locale.getDefault();
            C12238m.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = name.toLowerCase(locale2);
            C12238m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (C12106w.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        TextView textView = getBinding().f17165d;
        C12238m.checkNotNullExpressionValue(textView, "binding.emptyTitle");
        textView.setText(getString(arrayList.isEmpty() ? C5419R.string.directory_search_no_results_title : C5419R.string.directory_search_initial_title));
        LinearLayout linearLayout = getBinding().f17164c;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.emptyState");
        linearLayout.setVisibility(arrayList.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().f17166e;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        this.adapter.setData(arrayList);
    }

    private final void updateView(DomainsState state) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new C90251(context, state), 6, null);
        }
    }

    public final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> getAdapter() {
        return this.adapter;
    }

    public final HubDomainArgs getArgs() {
        return (HubDomainArgs) this.args.getValue();
    }

    public final WidgetHubDomainSearchBinding getBinding() {
        return (WidgetHubDomainSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        getBinding().f17166e.setAdapter(this.adapter);
        getBinding().f17168g.setStartIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDomainSearch.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetHubDomainSearch.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.onBackPressed();
                }
                WidgetHubDomainSearch widgetHubDomainSearch = WidgetHubDomainSearch.this;
                widgetHubDomainSearch.hideKeyboard(widgetHubDomainSearch.getView());
            }
        });
        getBinding().f17167f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubDomainSearch.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetHubDomainSearch.this.searchForGuild();
            }
        });
        TextInputLayout textInputLayout = getBinding().f17168g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.searchBar");
        CharSequence charSequenceM210b = null;
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C90224(), 1, null);
        LinkifiedTextView linkifiedTextView = getBinding().f17163b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.emptyDescription");
        Context context = getContext();
        if (context != null) {
            charSequenceM210b = C1107b.m210b(context, C5419R.string.hub_email_connection_guild_select_subheader, new Object[0], new C90235());
        }
        linkifiedTextView.setText(charSequenceM210b);
        TextInputEditText textInputEditText = getBinding().f17169h;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<DomainsState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetHubDomainSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90241());
    }
}
