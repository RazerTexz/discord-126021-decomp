package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteShareBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func0;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildInviteShare.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, FragmentManager fragmentManager, long guildId, Long channelId, boolean isNuxFlow, Long guildScheduledEventId, String inviteStoreKey, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(source, "source");
            if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet.INSTANCE.show(fragmentManager, channelId, guildId, source);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, isNuxFlow);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId != null ? channelId.longValue() : 0L);
            intent.putExtra("com.discord.intent.ORIGIN_SOURCE", source);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            intent.putExtra(WidgetGuildInviteShare.INTENT_INVITE_STORE_KEY, inviteStoreKey);
            Observable observableM11076j = Observable.m11076j(StoreStream.INSTANCE.getExperiments().observeUserExperiment("2020-01_mobile_invite_suggestion_compact", true), new InviteSuggestionsManager(null, null, null, null, null, 31, null).observeInviteSuggestions(), new Func2<Experiment, List<? extends InviteSuggestion>, Pair<? extends Experiment, ? extends List<? extends InviteSuggestion>>>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$1
                @Override // p658rx.functions.Func2
                public final Pair<Experiment, List<InviteSuggestion>> call(Experiment experiment, List<? extends InviteSuggestion> list) {
                    return C12116o.m10073to(experiment, list);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…-> exp to inviteService }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout(ObservableExtensionsKt.computationLatest(observableM11076j), 50L, false), (Class<?>) WidgetGuildInviteShare.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new WidgetGuildInviteShare$Companion$launch$2(source, context, intent)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new WidgetGuildInviteShare$Companion$launch$3(source, context, intent));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$configureUI$3 */
    /* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
    public static final class C86593 extends AbstractC12240o implements Function1<InviteSuggestionItem, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C86593(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
            invoke2(inviteSuggestionItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
            C12238m.checkNotNullParameter(inviteSuggestionItem, "item");
            WidgetGuildInviteShare.this.sendInvite(inviteSuggestionItem, this.$viewState, this.$invite);
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context context = WidgetGuildInviteShare.access$getAdapter$p(WidgetGuildInviteShare.this).getContext();
            String string = WidgetGuildInviteShare.this.getString(C5419R.string.invite_sent);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.invite_sent)");
            accessibilityUtils.sendAnnouncement(context, string);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$initBottomSheet$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
    public static final class C86631 extends AbstractC12240o implements Function0<Unit> {
        public C86631() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
    public static final class C86662 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C86662() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            WidgetGuildInviteShare.this.getViewModel().updateSearchQuery(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
    public static final /* synthetic */ class C86691 extends C12236k implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public C86691(WidgetGuildInviteShare widgetGuildInviteShare) {
            super(1, widgetGuildInviteShare, WidgetGuildInviteShare.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "p1");
            ((WidgetGuildInviteShare) this.receiver).configureUI(loaded);
        }
    }

    public WidgetGuildInviteShare() {
        super(C5419R.layout.widget_guild_invite_share);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShare$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShare$viewModel$2 widgetGuildInviteShare$viewModel$2 = new WidgetGuildInviteShare$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShare$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildInviteShare$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildInviteShare$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        PrivateChannelAdapter privateChannelAdapter = widgetGuildInviteShare.adapter;
        if (privateChannelAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        return privateChannelAdapter;
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShare widgetGuildInviteShare) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShare.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            C12238m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        Guild guild;
        final WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        final ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().f16813j;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.guildInviteSuggestionsFlipper");
        appViewFlipper.setDisplayedChild(!inviteSuggestionItems.isEmpty() ? 1 : 0);
        if (inviteSuggestionItems.size() == 1 && (C12163u.firstOrNull((List) inviteSuggestionItems) instanceof InviteSuggestionItem.Companion)) {
            inviteSuggestionItems = null;
        }
        if (inviteSuggestionItems == null) {
            inviteSuggestionItems = C12147n.emptyList();
        }
        if ((!inviteSuggestionItems.isEmpty()) && !this.hasTrackedSuggestionsViewed) {
            ModelInvite invite2 = widgetInviteModel.getInvite();
            long id2 = (invite2 == null || (guild = invite2.guild) == null) ? 0L : guild.getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : inviteSuggestionItems) {
                if (obj instanceof InviteSuggestionItem.ChannelItem) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InviteSuggestionItem.ChannelItem) it.next()).getChannel());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : inviteSuggestionItems) {
                if (obj2 instanceof InviteSuggestionItem.UserItem) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InviteSuggestionItem.UserItem) it2.next()).getUser());
            }
            analyticsTracker.inviteSuggestionOpened(id2, arrayList2, arrayList4);
            this.hasTrackedSuggestionsViewed = true;
        }
        TextView textView = getBinding().f16806c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().f16812i;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter.setData(inviteSuggestionItems);
        PrivateChannelAdapter privateChannelAdapter2 = this.adapter;
        if (privateChannelAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter2.setOnClick(new C86593(viewState, invite));
        getBinding().f16814k.configureUi(viewState.getWidgetInviteModel());
        TextView textView2 = getBinding().f16807d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildInviteLink");
        textView2.setText(getInviteLink(invite));
        getBinding().f16807d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInviteUiHelperKt.copyLinkClick(C1643a.m885x(view, "it", "it.context"), invite, WidgetGuildInviteShare.this.getMostRecentIntent());
            }
        });
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().f16808e;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        final Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.m8524i(getBinding().f16808e, GuildInviteUiHelperKt.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().f16808e.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i;
                WidgetGuildInviteShare.this.getBinding().f16808e.toggle();
                ModelInvite.Settings settings2 = widgetInviteModel.getSettings();
                if (settings2 != null) {
                    WidgetGuildInviteShareViewModel viewModel = WidgetGuildInviteShare.this.getViewModel();
                    CheckedSetting checkedSetting2 = WidgetGuildInviteShare.this.getBinding().f16808e;
                    C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
                    if (checkedSetting2.isChecked()) {
                        i = 0;
                    } else {
                        Experiment experiment = defaultInviteExperiment;
                        i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                    }
                    ModelInvite.Settings settingsMergeMaxAge = settings2.mergeMaxAge(i);
                    C12238m.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                    viewModel.updateInviteSettings(settingsMergeMaxAge);
                }
                Channel targetChannel = widgetInviteModel.getTargetChannel();
                if (targetChannel != null) {
                    WidgetGuildInviteShare.this.getViewModel().generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
                }
            }
        });
        getBinding().f16810g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelInvite modelInvite = invite;
                if (modelInvite != null) {
                    GuildInviteUiHelperKt.shareLinkClick(WidgetGuildInviteShare.this.getContext(), modelInvite);
                }
            }
        });
        ImageView imageView = getBinding().f16809f;
        C12238m.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().f16808e;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteNeverExpire");
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
        getBinding().f16814k.setOnGenerateLinkListener(new C86631());
        getBinding().f16814k.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.initBottomSheetBehavior.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                C12238m.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                C12238m.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 5) {
                    WidgetGuildInviteShare.this.getViewModel().refreshUi();
                    WidgetGuildInviteShare.this.getBinding().f16809f.sendAccessibilityEvent(8);
                } else if (newState == 3) {
                    WidgetGuildInviteShare.this.getBinding().f16814k.sendAccessibilityEvent(8);
                    WidgetGuildInviteShare.this.getAppLogger().m8371a(null);
                }
                ViewExtensions.fadeBy$default(WidgetGuildInviteShare.this.getBinding().f16805b, newState != 5, 0L, 2, null);
            }
        });
        bottomSheetBehavior.setUpdateImportantForAccessibilityOnSiblings(true);
    }

    public static final void launch(Context context, FragmentManager fragmentManager, long j, Long l, boolean z2, Long l2, String str, String str2) {
        INSTANCE.launch(context, fragmentManager, j, l, z2, l2, str, str2);
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel.ViewState.Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem.ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem.ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem.UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem.UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Window window;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16812i;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        final boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(C5419R.string.close) : null);
        setActionBarTitle(C5419R.string.invite_people);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.onViewBound.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                if (WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).getState() != 5) {
                    WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
                    return Boolean.TRUE;
                }
                if (!booleanExtra) {
                    return Boolean.FALSE;
                }
                C0870j.m155c(WidgetGuildInviteShare.this.requireContext(), false, null, 6);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        TextInputLayout textInputLayout = getBinding().f16811h;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C86662());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f16814k);
        C12238m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            C12238m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f16809f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(3);
            }
        });
        getBinding().f16805b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShare.access$getBottomSheetBehavior$p(WidgetGuildInviteShare.this).setState(5);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel.ViewState> observableM11085K = getViewModel().observeViewState().m11085K();
        C12238m.checkNotNullExpressionValue(observableM11085K, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableM11083G = observableM11085K.m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetGuildInviteShareViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.ViewState.Loaded");
                return (T) ((WidgetGuildInviteShareViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle(observableM11083G, this, privateChannelAdapter), (Class<?>) WidgetGuildInviteShare.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86691(this));
    }
}
