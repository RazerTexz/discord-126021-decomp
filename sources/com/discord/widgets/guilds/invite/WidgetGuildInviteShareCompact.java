package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R$layout;
import com.discord.api.guild.Guild;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareCompactBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShareCompact.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", 0)};
    private WidgetGuildInviteShareCompact$PrivateChannelAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildInviteShareCompact() {
        super(R$layout.widget_guild_invite_share_compact);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareCompact$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareCompact$viewModel$2 widgetGuildInviteShareCompact$viewModel$2 = new WidgetGuildInviteShareCompact$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShareCompact$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShareCompact$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        widgetGuildInviteShareCompact.configureUI(widgetGuildInviteShareViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ WidgetGuildInviteShareCompactBinding access$getBinding$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        return widgetGuildInviteShareCompact.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareCompact.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        return widgetGuildInviteShareCompact.getViewModel();
    }

    public static final /* synthetic */ void access$sendInvite(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, InviteSuggestionItem inviteSuggestionItem, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, ModelInvite modelInvite) {
        widgetGuildInviteShareCompact.sendInvite(inviteSuggestionItem, widgetGuildInviteShareViewModel$ViewState$Loaded, modelInvite);
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShareCompact.bottomSheetBehavior = bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel$ViewState$Loaded viewState) {
        Guild guild;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().i;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildInviteSuggestionsFlipper");
        appViewFlipper.setDisplayedChild(!inviteSuggestionItems.isEmpty() ? 1 : 0);
        if (inviteSuggestionItems.size() == 1 && (u.firstOrNull((List) inviteSuggestionItems) instanceof InviteSuggestionItem$SearchNoResultsItem)) {
            inviteSuggestionItems = null;
        }
        if (inviteSuggestionItems == null) {
            inviteSuggestionItems = n.emptyList();
        }
        if ((!inviteSuggestionItems.isEmpty()) && !this.hasTrackedSuggestionsViewed) {
            ModelInvite invite2 = widgetInviteModel.getInvite();
            long id2 = (invite2 == null || (guild = invite2.guild) == null) ? 0L : guild.getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : inviteSuggestionItems) {
                if (obj instanceof InviteSuggestionItem$ChannelItem) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InviteSuggestionItem$ChannelItem) it.next()).getChannel());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : inviteSuggestionItems) {
                if (obj2 instanceof InviteSuggestionItem$UserItem) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InviteSuggestionItem$UserItem) it2.next()).getUser());
            }
            analyticsTracker.inviteSuggestionOpened(id2, arrayList2, arrayList4);
            this.hasTrackedSuggestionsViewed = true;
        }
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().h;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        WidgetGuildInviteShareCompact$PrivateChannelAdapter widgetGuildInviteShareCompact$PrivateChannelAdapter = this.adapter;
        if (widgetGuildInviteShareCompact$PrivateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetGuildInviteShareCompact$PrivateChannelAdapter.setData(inviteSuggestionItems);
        WidgetGuildInviteShareCompact$PrivateChannelAdapter widgetGuildInviteShareCompact$PrivateChannelAdapter2 = this.adapter;
        if (widgetGuildInviteShareCompact$PrivateChannelAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetGuildInviteShareCompact$PrivateChannelAdapter2.setOnClick(new WidgetGuildInviteShareCompact$configureUI$3(this, viewState, invite));
        getBinding().j.configureUi(viewState.getWidgetInviteModel());
        MaterialButton materialButton = getBinding().f;
        m.checkNotNullExpressionValue(materialButton, "binding.guildInviteShareBtn");
        materialButton.setText(getInviteLink(invite));
        getBinding().f.setOnClickListener(new WidgetGuildInviteShareCompact$configureUI$4(this, invite));
        ImageView imageView = getBinding().e;
        m.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildInviteNeverExpire");
        textView2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView3 = getBinding().d;
        m.checkNotNullExpressionValue(textView3, "binding.guildInviteNeverExpire");
        textView3.setText(GuildInviteUiHelperKt.getInviteLinkText(requireContext(), getViewModel().getDefaultInviteExperiment()));
    }

    private final WidgetGuildInviteShareCompactBinding getBinding() {
        return (WidgetGuildInviteShareCompactBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().j.setOnGenerateLinkListener(new WidgetGuildInviteShareCompact$initBottomSheet$1(this));
        getBinding().j.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new WidgetGuildInviteShareCompact$initBottomSheetBehavior$1(this));
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel$ViewState$Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem$ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem$ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem$UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem$UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().h;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (WidgetGuildInviteShareCompact$PrivateChannelAdapter) mGRecyclerAdapter$Companion.configure(new WidgetGuildInviteShareCompact$PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969481, 0, 2, (Object) null)) : null, booleanExtra ? 2131887680 : null);
        setActionBarTitle(2131892315);
        AppFragment.setOnBackPressed$default(this, new WidgetGuildInviteShareCompact$onViewBound$1(this, booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareCompactSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetGuildInviteShareCompact$onViewBound$2(this));
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().j);
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().d.setOnClickListener(new WidgetGuildInviteShareCompact$onViewBound$3(this));
        getBinding().e.setOnClickListener(new WidgetGuildInviteShareCompact$onViewBound$4(this));
        getBinding().f2419b.setOnClickListener(new WidgetGuildInviteShareCompact$onViewBound$5(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        WidgetGuildInviteShareCompact$PrivateChannelAdapter widgetGuildInviteShareCompact$PrivateChannelAdapter = this.adapter;
        if (widgetGuildInviteShareCompact$PrivateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableG, this, widgetGuildInviteShareCompact$PrivateChannelAdapter), WidgetGuildInviteShareCompact.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShareCompact$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
