package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.m$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.q0;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen extends AppFragment {
    private static final String ANALYTICS_SOURCE = "Fullscreen Voice Channel Preview";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetHomePanelNsfw panelNsfw;
    private CallParticipantsAdapter participantsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private Subscription viewModelEventSubscription;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCallPreviewFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0)};
    public static final WidgetCallPreviewFullscreen$Companion Companion = new WidgetCallPreviewFullscreen$Companion(null);

    public WidgetCallPreviewFullscreen() {
        super(R$layout.widget_call_preview_fullscreen);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCallPreviewFullscreen$binding$2.INSTANCE, null, 2, null);
        WidgetCallPreviewFullscreen$viewModel$2 widgetCallPreviewFullscreen$viewModel$2 = new WidgetCallPreviewFullscreen$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetCallPreviewFullscreenViewModel.class), new WidgetCallPreviewFullscreen$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetCallPreviewFullscreen$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState) {
        widgetCallPreviewFullscreen.configureUI(widgetCallPreviewFullscreenViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetCallPreviewFullscreenBinding access$getBinding$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getBinding();
    }

    public static final /* synthetic */ WidgetCallPreviewFullscreenViewModel access$getViewModel$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getViewModel();
    }

    public static final /* synthetic */ Subscription access$getViewModelEventSubscription$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.viewModelEventSubscription;
    }

    public static final /* synthetic */ long access$getVoiceChannelId(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getVoiceChannelId();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel$Event widgetCallPreviewFullscreenViewModel$Event) {
        widgetCallPreviewFullscreen.handleEvent(widgetCallPreviewFullscreenViewModel$Event);
    }

    public static final /* synthetic */ void access$onDenyNsfw(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        widgetCallPreviewFullscreen.onDenyNsfw();
    }

    public static final /* synthetic */ void access$onNsfwToggle(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2) {
        widgetCallPreviewFullscreen.onNsfwToggle(z2);
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, StreamContext streamContext) {
        widgetCallPreviewFullscreen.onStreamPreviewClicked(streamContext);
    }

    public static final /* synthetic */ void access$setViewModelEventSubscription$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, Subscription subscription) {
        widgetCallPreviewFullscreen.viewModelEventSubscription = subscription;
    }

    public static final /* synthetic */ void access$transitionActivity(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        widgetCallPreviewFullscreen.transitionActivity();
    }

    private final void configureActionBar(WidgetCallPreviewFullscreenViewModel$ViewState viewState) {
        boolean z2 = viewState.getOtherChannelsMentionsCount() > 0;
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getOtherChannelsMentionsCount()));
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.callFullscreenMentions");
        textView2.setVisibility(z2 ? 0 : 8);
        Toolbar toolbar = getBinding().f2249b;
        m.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext(), z2 ? 2131231601 : 2131231600));
        getBinding().f2249b.setNavigationOnClickListener(new WidgetCallPreviewFullscreen$configureActionBar$1(this));
        setActionBarOptionsMenu(R$menu.menu_call_preview_fullscreen, new WidgetCallPreviewFullscreen$configureActionBar$2(this, viewState), new WidgetCallPreviewFullscreen$configureActionBar$3(this, viewState));
        int color = ColorCompat.getColor(this, 2131100438);
        String titleText = viewState.getTitleText();
        if (titleText == null) {
            titleText = "";
        }
        setActionBarTitle(titleText);
        setActionBarTitleColor(-1);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
    }

    private final void configureParticipants(WidgetCallPreviewFullscreenViewModel$ParticipantsList participantsList, Channel channel) {
        if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems)) {
            if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            q0 q0Var = getBinding().l;
            m.checkNotNullExpressionValue(q0Var, "binding.empty");
            ConstraintLayout constraintLayout = q0Var.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.empty.root");
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().k;
            m.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
            WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty widgetCallPreviewFullscreenViewModel$ParticipantsList$Empty = (WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty) participantsList;
            recyclerView.setVisibility(widgetCallPreviewFullscreenViewModel$ParticipantsList$Empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                m.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(widgetCallPreviewFullscreenViewModel$ParticipantsList$Empty.getItems());
            return;
        }
        q0 q0Var2 = getBinding().l;
        m.checkNotNullExpressionValue(q0Var2, "binding.empty");
        ConstraintLayout constraintLayout2 = q0Var2.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.empty.root");
        constraintLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callPreviewVoiceSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems) participantsList).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new WidgetCallPreviewFullscreen$configureParticipants$1(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new WidgetCallPreviewFullscreen$configureParticipants$2(this, channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnInviteFriendsClicked(new WidgetCallPreviewFullscreen$configureParticipants$3(this, channel));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnEmbeddedActivityClicked(new WidgetCallPreviewFullscreen$configureParticipants$4(this));
    }

    private final void configureUI(WidgetCallPreviewFullscreenViewModel$ViewState viewState) {
        configureActionBar(viewState);
        configureParticipants(viewState.getParticipantsList(), viewState.getVoiceChannel());
        if (viewState.isConnectEnabled()) {
            getBinding().i.setText(2131892398);
            getBinding().h.setText(2131892384);
            MaterialButton materialButton = getBinding().i;
            m.checkNotNullExpressionValue(materialButton, "binding.callPreviewJoinVoice");
            materialButton.setEnabled(true);
            MaterialButton materialButton2 = getBinding().h;
            m.checkNotNullExpressionValue(materialButton2, "binding.callPreviewJoinMuted");
            materialButton2.setEnabled(true);
        } else {
            getBinding().i.setText(2131887550);
            MaterialButton materialButton3 = getBinding().i;
            m.checkNotNullExpressionValue(materialButton3, "binding.callPreviewJoinVoice");
            materialButton3.setEnabled(false);
            getBinding().h.setText(2131887550);
            MaterialButton materialButton4 = getBinding().h;
            m.checkNotNullExpressionValue(materialButton4, "binding.callPreviewJoinMuted");
            materialButton4.setEnabled(false);
        }
        getBinding().i.setOnClickListener(new WidgetCallPreviewFullscreen$configureUI$1(this));
        getBinding().h.setOnClickListener(new WidgetCallPreviewFullscreen$configureUI$2(this));
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getVoiceChannel().getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().j, new WidgetCallPreviewFullscreen$configureUI$3(this), new WidgetCallPreviewFullscreen$configureUI$4(this));
        }
    }

    private final void finishActivity(boolean selectTextChannel, boolean transition) {
        if (selectTextChannel) {
            getViewModel().selectTextChannelAfterFinish();
        }
        Subscription subscription = this.viewModelEventSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        requireAppActivity().finish();
        if (transition) {
            requireAppActivity().overridePendingTransition(0, R$anim.anim_slide_out_down);
        }
    }

    public static /* synthetic */ void finishActivity$default(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        widgetCallPreviewFullscreen.finishActivity(z2, z3);
    }

    private final WidgetCallPreviewFullscreenBinding getBinding() {
        return (WidgetCallPreviewFullscreenBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetCallPreviewFullscreenViewModel getViewModel() {
        return (WidgetCallPreviewFullscreenViewModel) this.viewModel.getValue();
    }

    private final long getVoiceChannelId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final void handleEvent(WidgetCallPreviewFullscreenViewModel$Event event) {
        if (m.areEqual(event, WidgetCallPreviewFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            m$a m_a = b.a.a.m.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            m_a.a(parentFragmentManager);
            return;
        }
        if (m.areEqual(event, WidgetCallPreviewFullscreenViewModel$Event$ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.Companion.enqueue();
        } else {
            if (!(event instanceof WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall)) {
                throw new NoWhenBranchMatchedException();
            }
            finishActivity$default(this, false, false, 1, null);
            WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall = (WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall) event;
            WidgetCallFullscreen$Companion.launch$default(WidgetCallFullscreen.Companion, requireContext(), widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.getChannelId(), false, widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.getAutoTargetStreamKey(), null, 20, null);
        }
    }

    public static final void launch(Context context, long j, AppTransitionActivity$Transition appTransitionActivity$Transition) {
        Companion.launch(context, j, appTransitionActivity$Transition);
    }

    private final void onDenyNsfw() {
        finishActivity$default(this, true, false, 2, null);
    }

    private final void onNsfwToggle(boolean isHidden) {
        ConstraintLayout constraintLayout = getBinding().d;
        m.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenBody");
        constraintLayout.setVisibility(isHidden ^ true ? 0 : 8);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        d.S1(this, null, new WidgetCallPreviewFullscreen$onStreamPreviewClicked$1(this, streamContext), 1, null);
    }

    private final void transitionActivity() {
        finishActivity$default(this, false, false, 3, null);
        requireAppActivity().overridePendingTransition(R$anim.activity_slide_horizontal_open_in, R$anim.activity_slide_horizontal_open_out);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().g, WidgetCallPreviewFullscreen$onViewBound$1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().l.f183b, WidgetCallPreviewFullscreen$onViewBound$2.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().k, WidgetCallPreviewFullscreen$onViewBound$3.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, WidgetCallPreviewFullscreen$onViewBound$4.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new WidgetCallPreviewFullscreen$onViewBound$5(this));
        ConstraintLayout constraintLayout = getBinding().f;
        m.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenParent");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) mGRecyclerAdapter$Companion.configure(new CallParticipantsAdapter(recyclerView, true, true));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new WidgetCallPreviewFullscreen$onViewBound$6(this));
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new WidgetCallPreviewFullscreen$onViewBound$7(this));
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, new WidgetCallPreviewFullscreen$onViewBoundOrOnResume$3(this), (Function1) null, (Function0) null, (Function0) null, new WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2(this), 58, (Object) null);
        AppFragment.setOnBackPressed$default(this, new WidgetCallPreviewFullscreen$onViewBoundOrOnResume$4(this), 0, 2, null);
    }
}
