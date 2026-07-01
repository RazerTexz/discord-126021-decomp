package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubDomainSearchBinding;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.g0.w;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubDomainSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubDomainSearchBinding;", 0)};
    private final SimpleRecyclerAdapter<DomainGuildInfo, HubDomainViewHolder> adapter;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHubDomainSearch() {
        super(R$layout.widget_hub_domain_search);
        this.args = g.lazy(new WidgetHubDomainSearch$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubDomainSearch$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubDomainSearch$adapter$1(this), 1, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubDomainsViewModel.class), new WidgetHubDomainSearch$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetHubDomainSearch$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$searchForGuild(WidgetHubDomainSearch widgetHubDomainSearch) {
        widgetHubDomainSearch.searchForGuild();
    }

    public static final /* synthetic */ void access$updateView(WidgetHubDomainSearch widgetHubDomainSearch, DomainsState domainsState) {
        widgetHubDomainSearch.updateView(domainsState);
    }

    private final void searchForGuild() {
        TextInputEditText textInputEditText = getBinding().h;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        String strValueOf = String.valueOf(textInputEditText.getText());
        Locale locale = Locale.getDefault();
        m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String lowerCase = strValueOf.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
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
            m.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = name.toLowerCase(locale2);
            m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (w.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.emptyTitle");
        textView.setText(getString(arrayList.isEmpty() ? 2131888459 : 2131888455));
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.emptyState");
        linearLayout.setVisibility(arrayList.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        this.adapter.setData(arrayList);
    }

    private final void updateView(DomainsState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new WidgetHubDomainSearch$updateView$1(this, context, state), 6, null);
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
        m.checkNotNullParameter(guildInfo, "guildInfo");
        getViewModel().onGuildClicked(guildInfo.getId(), getArgs().getEmail());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().e.setAdapter(this.adapter);
        getBinding().g.setStartIconOnClickListener(new WidgetHubDomainSearch$onViewBound$2(this));
        getBinding().f.setOnClickListener(new WidgetHubDomainSearch$onViewBound$3(this));
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.searchBar");
        CharSequence charSequenceB = null;
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetHubDomainSearch$onViewBound$4(this), 1, null);
        LinkifiedTextView linkifiedTextView = getBinding().f2471b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.emptyDescription");
        Context context = getContext();
        if (context != null) {
            charSequenceB = b.b(context, 2131891790, new Object[0], new WidgetHubDomainSearch$onViewBound$5(this));
        }
        linkifiedTextView.setText(charSequenceB);
        TextInputEditText textInputEditText = getBinding().h;
        m.checkNotNullExpressionValue(textInputEditText, "binding.searchBarText");
        showKeyboard(textInputEditText);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<DomainsState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubDomainSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubDomainSearch$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
