package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R$layout;
import com.discord.api.guild.Guild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteShareBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
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

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShare.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareBinding;", 0)};
    public static final WidgetGuildInviteShare$Companion Companion = new WidgetGuildInviteShare$Companion(null);
    public static final String INTENT_INVITE_STORE_KEY = "INTENT_INVITE_STORE_KEY";
    public static final String INTENT_IS_NUX_FLOW = "INTENT_IS_NUX_FLOW";
    private PrivateChannelAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildInviteShare() {
        super(R$layout.widget_guild_invite_share);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShare$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShare$viewModel$2 widgetGuildInviteShare$viewModel$2 = new WidgetGuildInviteShare$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShare$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShare$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildInviteShare$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildInviteShare widgetGuildInviteShare, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        widgetGuildInviteShare.configureUI(widgetGuildInviteShareViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        PrivateChannelAdapter privateChannelAdapter = widgetGuildInviteShare.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return privateChannelAdapter;
    }

    public static final /* synthetic */ WidgetGuildInviteShareBinding access$getBinding$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        return widgetGuildInviteShare.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShare.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        return widgetGuildInviteShare.getViewModel();
    }

    public static final /* synthetic */ void access$sendInvite(WidgetGuildInviteShare widgetGuildInviteShare, InviteSuggestionItem inviteSuggestionItem, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded, ModelInvite modelInvite) {
        widgetGuildInviteShare.sendInvite(inviteSuggestionItem, widgetGuildInviteShareViewModel$ViewState$Loaded, modelInvite);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildInviteShare widgetGuildInviteShare, PrivateChannelAdapter privateChannelAdapter) {
        widgetGuildInviteShare.adapter = privateChannelAdapter;
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShare widgetGuildInviteShare, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShare.bottomSheetBehavior = bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel$ViewState$Loaded viewState) {
        Guild guild;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().j;
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
        RecyclerView recyclerView = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter.setData(inviteSuggestionItems);
        PrivateChannelAdapter privateChannelAdapter2 = this.adapter;
        if (privateChannelAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter2.setOnClick(new WidgetGuildInviteShare$configureUI$3(this, viewState, invite));
        getBinding().k.configureUi(viewState.getWidgetInviteModel());
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.guildInviteLink");
        textView2.setText(getInviteLink(invite));
        getBinding().d.setOnClickListener(new WidgetGuildInviteShare$configureUI$4(this, invite));
        ModelInvite$Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.i(getBinding().e, GuildInviteUiHelperKt.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().e.e(new WidgetGuildInviteShare$configureUI$5(this, widgetInviteModel, defaultInviteExperiment));
        getBinding().g.setOnClickListener(new WidgetGuildInviteShare$configureUI$6(this, invite));
        ImageView imageView = getBinding().f;
        m.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
        checkedSetting2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
    }

    private final WidgetGuildInviteShareBinding getBinding() {
        return (WidgetGuildInviteShareBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().k.setOnGenerateLinkListener(new WidgetGuildInviteShare$initBottomSheet$1(this));
        getBinding().k.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new WidgetGuildInviteShare$initBottomSheetBehavior$1(this));
        bottomSheetBehavior.setUpdateImportantForAccessibilityOnSiblings(true);
    }

    public static final void launch(Context context, FragmentManager fragmentManager, long j, Long l, boolean z2, Long l2, String str, String str2) {
        Companion.launch(context, fragmentManager, j, l, z2, l2, str, str2);
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel$ViewState$Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem$ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem$ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem$UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem$UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().i;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) mGRecyclerAdapter$Companion.configure(new PrivateChannelAdapter(recyclerView));
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969481, 0, 2, (Object) null)) : null, booleanExtra ? 2131887680 : null);
        setActionBarTitle(2131892315);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setOnBackPressed$default(this, new WidgetGuildInviteShare$onViewBound$1(this, booleanExtra), 0, 2, null);
        TextInputLayout textInputLayout = getBinding().h;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetGuildInviteShare$onViewBound$2(this));
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().k);
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f.setOnClickListener(new WidgetGuildInviteShare$onViewBound$3(this));
        getBinding().f2418b.setOnClickListener(new WidgetGuildInviteShare$onViewBound$4(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel$ViewState> observableK = getViewModel().observeViewState().K();
        m.checkNotNullExpressionValue(observableK, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableG = observableK.y(WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle(observableG, this, privateChannelAdapter), WidgetGuildInviteShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShare$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
