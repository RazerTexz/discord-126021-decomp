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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteShareSheetBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.SearchInputView;
import com.discord.widgets.home.WidgetHome;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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
    private final LoggingConfig loggingConfig;
    private boolean restoredSearchQueryFromViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildInviteShareSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareSheetBinding;", 0)};

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
            C12238m.checkNotNullParameter(source, "source");
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            notices.requestToShow(new StoreNotices.Notice(getNoticeName(), null, ClockFactory.get().currentTimeMillis(), 0, false, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new C8695x9a7ac400(channelId, guildId, source, notices, getNoticeName()), Opcodes.I2C, null));
        }

        public final void show(FragmentManager fragmentManager, Long channelId, long guildId, String source) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(source, "source");
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$3 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class C87043 extends AbstractC12240o implements Function1<InviteSuggestionItemV2, Unit> {
        public C87043() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            invoke2(inviteSuggestionItemV2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItemV2 inviteSuggestionItemV2) {
            C12238m.checkNotNullParameter(inviteSuggestionItemV2, "item");
            WidgetGuildInviteShareSheet.this.getViewModel().sendInvite(inviteSuggestionItemV2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class C87051 extends AbstractC12240o implements Function1<GuildInviteShareSheetViewModel.ViewState, Unit> {
        public C87051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteShareSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteShareSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetGuildInviteShareSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$setUpSearchBar$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
    public static final class C87061 extends AbstractC12240o implements Function1<String, Unit> {
        public C87061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "searchQuery");
            WidgetGuildInviteShareSheet.this.getViewModel().onSearchTextChanged(str);
        }
    }

    public WidgetGuildInviteShareSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareSheet$viewModel$2 widgetGuildInviteShareSheet$viewModel$2 = new WidgetGuildInviteShareSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildInviteShareSheetViewModel.class), new WidgetGuildInviteShareSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildInviteShareSheet$viewModel$2));
        this.guildInviteSettingsLauncher = WidgetGuildInviteSettings.INSTANCE.registerForResult(this, new WidgetGuildInviteShareSheet$guildInviteSettingsLauncher$1(this));
        this.analyticsSource = "";
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildInviteShareSheet$loggingConfig$1(this), 3);
    }

    private final void configureEmptyStateUI(final GuildInviteShareSheetViewModel.ViewState viewState) {
        if (this.isFixedHeight) {
            this.isFixedHeight = false;
            FrameLayout frameLayout = getBinding().f16846j;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        C12238m.checkNotNullParameter(view, "view");
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
        AppViewFlipper appViewFlipper = binding.f16850n;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(0);
        NestedScrollView nestedScrollView = binding.f16842f;
        C12238m.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(true);
        final GuildInvite invite = viewState.getInvite();
        ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        CharSequence inviteSettingsText = null;
        if (invite != null) {
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            TextView textView = binding.f16840d;
            C12238m.checkNotNullExpressionValue(textView, "emptyStateInviteLink");
            textView.setText(invite.toLink());
            TextView textView2 = binding.f16843g;
            C12238m.checkNotNullExpressionValue(textView2, "emptyStateSettingsSubtext");
            if (inviteSettings != null) {
                Context contextRequireContext = requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                inviteSettingsText = GuildInviteUiHelperKt.getInviteSettingsText(contextRequireContext, expirationTimeMs, inviteSettings.getMaxUses());
            }
            textView2.setText(inviteSettingsText);
        } else {
            TextView textView3 = binding.f16840d;
            C12238m.checkNotNullExpressionValue(textView3, "emptyStateInviteLink");
            textView3.setText(getString(C5419R.string.loading));
            TextView textView4 = binding.f16843g;
            C12238m.checkNotNullExpressionValue(textView4, "emptyStateSettingsSubtext");
            textView4.setText((CharSequence) null);
        }
        binding.f16840d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (invite != null) {
                    GuildInviteUiHelperKt.copyLinkClick(C1643a.m885x(view, "it", "it.context"), invite, viewState.getChannel(), this.analyticsSource);
                }
            }
        });
        binding.f16844h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (invite != null) {
                    GuildInviteUiHelperKt.shareLinkClick(this.getContext(), invite, viewState.getChannel());
                }
            }
        });
        ImageButton imageButton = binding.f16841e;
        C12238m.checkNotNullExpressionValue(imageButton, "emptyStateLinkOptions");
        imageButton.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.f16841e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$with$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.Companion companion = WidgetGuildInviteSettings.INSTANCE;
                Context contextRequireContext2 = this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                ActivityResultLauncher<Intent> activityResultLauncher = this.guildInviteSettingsLauncher;
                GuildInvite guildInvite = invite;
                companion.launch(contextRequireContext2, activityResultLauncher, guildInvite != null ? guildInvite.getChannelId() : null, this.getViewModel().getGuildId(), "Instant Invite Action Sheet");
            }
        });
    }

    private final void configureNormalUI(final GuildInviteShareSheetViewModel.ViewState viewState) {
        if (!this.isFixedHeight) {
            this.isFixedHeight = true;
            FrameLayout frameLayout = getBinding().f16846j;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            if (!ViewCompat.isLaidOut(frameLayout) || frameLayout.isLayoutRequested()) {
                frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        C12238m.checkNotNullParameter(view, "view");
                        view.removeOnLayoutChangeListener(this);
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        Resources resources = this.this$0.getResources();
                        C12238m.checkNotNullExpressionValue(resources, "resources");
                        layoutParams2.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                        view.setLayoutParams(layoutParams2);
                        this.this$0.getBinding().f16849m.requestLayout();
                    }
                });
            } else {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                Resources resources = getResources();
                C12238m.checkNotNullExpressionValue(resources, "resources");
                layoutParams2.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                frameLayout.setLayoutParams(layoutParams2);
                getBinding().f16849m.requestLayout();
            }
        }
        final String searchQuery = viewState.getSearchQuery();
        WidgetGuildInviteShareSheetBinding binding = getBinding();
        if (!this.restoredSearchQueryFromViewModel && (!C12103t.isBlank(searchQuery))) {
            this.restoredSearchQueryFromViewModel = true;
            binding.f16847k.setText(searchQuery);
        }
        AppViewFlipper appViewFlipper = binding.f16850n;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "suggestionsFlipper");
        appViewFlipper.setDisplayedChild(1);
        NestedScrollView nestedScrollView = binding.f16842f;
        C12238m.checkNotNullExpressionValue(nestedScrollView, "emptyStateScroller");
        nestedScrollView.setNestedScrollingEnabled(false);
        if (viewState.getChannel() != null) {
            SearchInputView searchInputView = binding.f16847k;
            Channel channel = viewState.getChannel();
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            searchInputView.setHint(C1107b.m213e(this, C5419R.string.invite_your_friends_channel_mobile, new Object[]{ChannelUtils.m7681e(channel, contextRequireContext, false, 2)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        } else {
            SearchInputView searchInputView2 = binding.f16847k;
            String string = getString(C5419R.string.invite_your_friends);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.invite_your_friends)");
            searchInputView2.setHint(string);
        }
        final GuildInvite invite = viewState.getInvite();
        if (invite != null) {
            CardView cardView = binding.f16848l;
            C12238m.checkNotNullExpressionValue(cardView, "shareButton");
            cardView.setContentDescription(C1107b.m213e(this, C5419R.string.share_invite_mobile, new Object[]{invite}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            long expirationTimeMs = invite.getExpirationTimeMs() - ClockFactory.get().currentTimeMillis();
            String link = invite.toLink();
            Context contextRequireContext2 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence inviteSettingsText = GuildInviteUiHelperKt.getInviteSettingsText(contextRequireContext2, expirationTimeMs);
            TextView textView = binding.f16839c;
            C12238m.checkNotNullExpressionValue(textView, "copyLinkSubtitle");
            textView.setText(link + ' ' + inviteSettingsText);
            binding.f16848l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildInviteUiHelperKt.shareLinkClick(this.getContext(), invite, viewState.getChannel());
                }
            });
            binding.f16838b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildInviteUiHelperKt.copyLinkClick(C1643a.m885x(view, "it", "it.context"), invite, viewState.getChannel(), this.analyticsSource);
                }
            });
        }
        CardView cardView2 = binding.f16848l;
        C12238m.checkNotNullExpressionValue(cardView2, "shareButton");
        cardView2.setVisibility(invite != null ? 0 : 8);
        FrameLayout frameLayout2 = binding.f16845i;
        C12238m.checkNotNullExpressionValue(frameLayout2, "inviteSettingsButton");
        frameLayout2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        binding.f16845i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.Companion companion = WidgetGuildInviteSettings.INSTANCE;
                Context contextRequireContext3 = this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                ActivityResultLauncher<Intent> activityResultLauncher = this.guildInviteSettingsLauncher;
                GuildInvite guildInvite = invite;
                companion.launch(contextRequireContext3, activityResultLauncher, guildInvite != null ? guildInvite.getChannelId() : null, this.getViewModel().getGuildId(), "Instant Invite Action Sheet");
            }
        });
        InviteSuggestionsAdapter inviteSuggestionsAdapter = this.adapter;
        if (inviteSuggestionsAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        inviteSuggestionsAdapter.setOnClick(new C87043());
        InviteSuggestionsAdapter inviteSuggestionsAdapter2 = this.adapter;
        if (inviteSuggestionsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
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
        getBinding().f16847k.m8553a(this, new C87061());
    }

    public final void configureUI(GuildInviteShareSheetViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (viewState.getHasResults()) {
            configureNormalUI(viewState);
        } else {
            configureEmptyStateUI(viewState);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_invite_share_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildInviteShareSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87051());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        String string = getArgumentsOrDefault().getString(ARG_ANALYTICS_SOURCE);
        if (string == null) {
            string = "";
        }
        this.analyticsSource = string;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16849m;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.suggestionList");
        this.adapter = (InviteSuggestionsAdapter) companion.configure(new InviteSuggestionsAdapter(recyclerView));
        setUpSearchBar();
    }
}
