package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareSheetBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import com.discord.widgets.guilds.invite.WidgetGuildInviteSettings;
import com.discord.widgets.home.WidgetHome;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet extends AppBottomSheet {
    private static final String ARG_ANALYTICS_SOURCE = "ARG_ANALYTICS_SOURCE";
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private InviteSuggestionsAdapter adapter;
    private String analyticsSource;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> guildInviteSettingsLauncher;
    private boolean isFixedHeight;
    private final AppLogger2 loggingConfig;
    private boolean restoredSearchQueryFromViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInviteShareSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void enqueueNoticeForHomeTab$default(Companion companion, Long l, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            companion.enqueueNoticeForHomeTab(l, j, str);
        }

        private final String getNoticeName() {
            return WidgetGuildInviteShareSheet.class.getSimpleName() + " - " + ClockFactory.get().currentTimeMillis();
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Long l, long j, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                l = null;
            }
            companion.show(fragmentManager, l, j, str);
        }

        public final void enqueueNoticeForHomeTab(Long channelId, long guildId, String source) {
            Intrinsics3.checkNotNullParameter(source, "source");
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            notices.requestToShow(new StoreNotices.Notice(getNoticeName(), null, ClockFactory.get().currentTimeMillis(), 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildInviteShareSheet$Companion$enqueueNoticeForHomeTab$notice$1(channelId, guildId, source, notices, getNoticeName()), Opcodes.I2C, null));
        }

        public final void show(FragmentManager fragmentManager, Long channelId, long guildId, String source) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(source, "source");
            AnalyticsTracker.INSTANCE.openPopout("Instant Invite", source);
            WidgetGuildInviteShareSheet widgetGuildInviteShareSheet = new WidgetGuildInviteShareSheet();
            Bundle bundle = new Bundle();
            if (channelId != null) {
                bundle.putLong(WidgetGuildInviteShareSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            bundle.putLong(WidgetGuildInviteShareSheet.ARG_GUILD_ID, guildId);
            bundle.putString(WidgetGuildInviteShareSheet.ARG_ANALYTICS_SOURCE, source);
            widgetGuildInviteShareSheet.setArguments(bundle);
            widgetGuildInviteShareSheet.show(fragmentManager, WidgetGuildInviteShareSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<InviteSuggestionItemV2, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            invoke2(inviteSuggestionItemV2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItemV2, "item");
            WidgetGuildInviteShareSheet.this.getViewModel().sendInvite(inviteSuggestionItemV2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildInviteShareSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteShareSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteShareSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGuildInviteShareSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$setUpSearchBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetGuildInviteShareSheet.this.getViewModel().onSearchTextChanged(str);
        }
    }

    public WidgetGuildInviteShareSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareSheet$viewModel$2 widgetGuildInviteShareSheet$viewModel$2 = new WidgetGuildInviteShareSheet$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildInviteShareSheetViewModel.class), new WidgetGuildInviteShareSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareSheet$viewModel$2));
        this.guildInviteSettingsLauncher = WidgetGuildInviteSettings.INSTANCE.registerForResult(this, new WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1(this));
        this.analyticsSource = "";
        this.loggingConfig = new AppLogger2(false, null, new WidgetGuildInviteShareSheet$loggingConfig$1(this), 3);
    }

    private final void configureEmptyStateUI(final GuildInviteShareSheetViewModel.ViewState viewState) {
        if (this.isFixedHeight) {
            this.isFixedHeight = false;
            FrameLayout frameLayout = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Intrinsics3.checkNotNullParameter(view, "view");
                        view.removeOnLayoutChangeListener(this);
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = -1;
                        view.setLayoutParams(layoutParams2);
                    }
                });
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.height = -1;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        AppViewFlipper appViewFlipper = binding.n;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(0);
        NestedScrollView nestedScrollView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(true);
        final GuildInvite invite = viewState.getInvite();
        ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        CharSequence inviteSettingsText = null;
        if (invite != null) {
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            TextView textView = binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "emptyStateInviteLink");
            textView.setText(invite.toLink());
            TextView textView2 = binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "emptyStateSettingsSubtext");
            if (inviteSettings != null) {
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                inviteSettingsText = GuildInviteUiHelper.getInviteSettingsText(contextRequireContext, expirationTimeMs, inviteSettings.getMaxUses());
            }
            textView2.setText(inviteSettingsText);
        } else {
            TextView textView3 = binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "emptyStateInviteLink");
            textView3.setText(getString(R.string.loading));
            TextView textView4 = binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView4, "emptyStateSettingsSubtext");
            textView4.setText((CharSequence) null);
        }
        binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (invite != null) {
                    GuildInviteUiHelper.copyLinkClick(outline.x(view, "it", "it.context"), invite, viewState.getChannel(), this.analyticsSource);
                }
            }
        });
        binding.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (invite != null) {
                    GuildInviteUiHelper.shareLinkClick(this.getContext(), invite, viewState.getChannel());
                }
            }
        });
        ImageButton imageButton = binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageButton, "emptyStateLinkOptions");
        imageButton.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.Companion companion = WidgetGuildInviteSettings.INSTANCE;
                Context contextRequireContext2 = this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                ActivityResultLauncher<Intent> activityResultLauncher = this.guildInviteSettingsLauncher;
                GuildInvite guildInvite = invite;
                companion.launch(contextRequireContext2, activityResultLauncher, guildInvite != null ? guildInvite.getChannelId() : null, this.getViewModel().getGuildId(), "Instant Invite Action Sheet");
            }
        });
    }

    private final void configureNormalUI(final GuildInviteShareSheetViewModel.ViewState viewState) {
        if (!this.isFixedHeight) {
            this.isFixedHeight = true;
            FrameLayout frameLayout = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Intrinsics3.checkNotNullParameter(view, "view");
                        view.removeOnLayoutChangeListener(this);
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        Resources resources = this.this$0.getResources();
                        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                        layoutParams2.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                        view.setLayoutParams(layoutParams2);
                        this.this$0.getBinding().m.requestLayout();
                    }
                });
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                Resources resources = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                layoutParams2.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                frameLayout.setLayoutParams(layoutParams2);
                getBinding().m.requestLayout();
            }
        }
        final String searchQuery = viewState.getSearchQuery();
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        if (!this.restoredSearchQueryFromViewModel && (!StringsJVM.isBlank(searchQuery))) {
            this.restoredSearchQueryFromViewModel = true;
            binding.k.setText(searchQuery);
        }
        AppViewFlipper appViewFlipper = binding.n;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(1);
        NestedScrollView nestedScrollView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(false);
        if (viewState.getChannel() != null) {
            SearchInputView searchInputView = binding.k;
            Channel channel = viewState.getChannel();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            searchInputView.setHint(FormatUtils.e(this, R.string.invite_your_friends_channel_mobile, new Object[]{ChannelUtils.e(channel, contextRequireContext, false, 2)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        } else {
            SearchInputView searchInputView2 = binding.k;
            String string = getString(R.string.invite_your_friends);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.invite_your_friends)");
            searchInputView2.setHint(string);
        }
        final GuildInvite invite = viewState.getInvite();
        if (invite != null) {
            CardView cardView = binding.l;
            Intrinsics3.checkNotNullExpressionValue(cardView, "shareButton");
            cardView.setContentDescription(FormatUtils.e(this, R.string.share_invite_mobile, new Object[]{invite}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            String link = invite.toLink();
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence inviteSettingsText = GuildInviteUiHelper.getInviteSettingsText(contextRequireContext2, expirationTimeMs);
            TextView textView = binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "copyLinkSubtitle");
            textView.setText(link + ' ' + inviteSettingsText);
            binding.l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildInviteUiHelper.shareLinkClick(this.getContext(), invite, viewState.getChannel());
                }
            });
            binding.f2422b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildInviteUiHelper.copyLinkClick(outline.x(view, "it", "it.context"), invite, viewState.getChannel(), this.analyticsSource);
                }
            });
        }
        CardView cardView2 = binding.l;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "shareButton");
        cardView2.setVisibility(invite != null ? 0 : 8);
        FrameLayout frameLayout2 = binding.i;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "inviteSettingsButton");
        frameLayout2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.Companion companion = WidgetGuildInviteSettings.INSTANCE;
                Context contextRequireContext3 = this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                ActivityResultLauncher<Intent> activityResultLauncher = this.guildInviteSettingsLauncher;
                GuildInvite guildInvite = invite;
                companion.launch(contextRequireContext3, activityResultLauncher, guildInvite != null ? guildInvite.getChannelId() : null, this.getViewModel().getGuildId(), "Instant Invite Action Sheet");
            }
        });
        InviteSuggestionsAdapter inviteSuggestionsAdapter = this.adapter;
        if (inviteSuggestionsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter.setOnClick(new AnonymousClass3());
        InviteSuggestionsAdapter inviteSuggestionsAdapter2 = this.adapter;
        if (inviteSuggestionsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter2.setData(viewState.getInviteSuggestionItems());
    }

    private final WidgetGuildInviteShareSheetBinding getBinding() {
        return (WidgetGuildInviteShareSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildInviteShareSheetViewModel getViewModel() {
        return (GuildInviteShareSheetViewModel) this.viewModel.getValue();
    }

    private final void setUpSearchBar() {
        getBinding().k.a(this, new AnonymousClass1());
    }

    public final void configureUI(GuildInviteShareSheetViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState.getHasResults()) {
            configureNormalUI(viewState);
        } else {
            configureEmptyStateUI(viewState);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_invite_share_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildInviteShareSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString(ARG_ANALYTICS_SOURCE);
        if (string == null) {
            string = "";
        }
        this.analyticsSource = string;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.suggestionList");
        this.adapter = (InviteSuggestionsAdapter) companion.configure(new InviteSuggestionsAdapter(recyclerView));
        setUpSearchBar();
    }
}
