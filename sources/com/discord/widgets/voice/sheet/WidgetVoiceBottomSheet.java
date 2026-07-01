package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.j;
import b.a.a.j$a;
import b.a.a.m$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.t0;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceBottomSheetBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$Companion;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetNavigator;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.stream.StreamNavigator;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet extends AppBottomSheet {
    private static final String ANALYTICS_SOURCE = "Voice Channel Bottom Sheet";
    private static final String ARG_FEATURE_CONTEXT = "ARG_FEATURE_CONTEXT";
    private static final String ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED = "ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED";
    private static final String END_EVENT_REQUEST_KEY = "END_EVENT_REQUEST_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: featureContext$delegate, reason: from kotlin metadata */
    private final Lazy featureContext;

    /* JADX INFO: renamed from: forwardToFullscreenIfVideoActivated$delegate, reason: from kotlin metadata */
    private final Lazy forwardToFullscreenIfVideoActivated;
    private Function1<? super StreamContext, Unit> onStreamPreviewClickedListener;
    private CallParticipantsAdapter participantsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private Subscription viewModelEventSubscription;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", 0)};
    public static final WidgetVoiceBottomSheet$Companion Companion = new WidgetVoiceBottomSheet$Companion(null);

    public WidgetVoiceBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetVoiceBottomSheet$channelId$2(this));
        this.forwardToFullscreenIfVideoActivated = g.lazy(new WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2(this));
        WidgetVoiceBottomSheet$viewModel$2 widgetVoiceBottomSheet$viewModel$2 = new WidgetVoiceBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetVoiceBottomSheetViewModel.class), new WidgetVoiceBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetVoiceBottomSheet$viewModel$2));
        this.featureContext = g.lazy(new WidgetVoiceBottomSheet$featureContext$2(this));
        this.onStreamPreviewClickedListener = WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1.INSTANCE;
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceBottomSheet widgetVoiceBottomSheet, WidgetVoiceBottomSheetViewModel$ViewState widgetVoiceBottomSheetViewModel$ViewState) {
        widgetVoiceBottomSheet.configureUI(widgetVoiceBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetVoiceBottomSheetBinding access$getBinding$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getChannelId();
    }

    public static final /* synthetic */ boolean access$getForwardToFullscreenIfVideoActivated$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getForwardToFullscreenIfVideoActivated();
    }

    public static final /* synthetic */ WidgetVoiceBottomSheetViewModel access$getViewModel$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getViewModel();
    }

    public static final /* synthetic */ Subscription access$getViewModelEventSubscription$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.viewModelEventSubscription;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetVoiceBottomSheet widgetVoiceBottomSheet, WidgetVoiceBottomSheetViewModel$Event widgetVoiceBottomSheetViewModel$Event) {
        widgetVoiceBottomSheet.handleEvent(widgetVoiceBottomSheetViewModel$Event);
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetVoiceBottomSheet widgetVoiceBottomSheet, StreamContext streamContext) {
        widgetVoiceBottomSheet.onStreamPreviewClicked(streamContext);
    }

    public static final /* synthetic */ void access$setViewModelEventSubscription$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet, Subscription subscription) {
        widgetVoiceBottomSheet.viewModelEventSubscription = subscription;
    }

    private final void configureBottomContent(WidgetVoiceBottomSheet$BottomContent bottomContent, Channel channel) {
        if (bottomContent == null) {
            AnchoredVoiceControlsView anchoredVoiceControlsView = getBinding().f;
            m.checkNotNullExpressionValue(anchoredVoiceControlsView, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().e;
            m.checkNotNullExpressionValue(relativeLayout, "binding.voiceBottomSheetConnectContainer");
            relativeLayout.setVisibility(8);
            CoordinatorLayout coordinatorLayout = getBinding().i;
            CoordinatorLayout coordinatorLayout2 = getBinding().i;
            m.checkNotNullExpressionValue(coordinatorLayout2, "binding.voiceBottomSheetRoot");
            coordinatorLayout.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout2, 2130968911));
            return;
        }
        if (bottomContent instanceof WidgetVoiceBottomSheet$BottomContent$Controls) {
            AnchoredVoiceControlsView anchoredVoiceControlsView2 = getBinding().f;
            m.checkNotNullExpressionValue(anchoredVoiceControlsView2, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView2.setVisibility(0);
            RelativeLayout relativeLayout2 = getBinding().e;
            m.checkNotNullExpressionValue(relativeLayout2, "binding.voiceBottomSheetConnectContainer");
            relativeLayout2.setVisibility(8);
            AnchoredVoiceControlsView anchoredVoiceControlsView3 = getBinding().f;
            WidgetVoiceBottomSheet$BottomContent$Controls widgetVoiceBottomSheet$BottomContent$Controls = (WidgetVoiceBottomSheet$BottomContent$Controls) bottomContent;
            MediaEngineConnection$InputMode inputMode = widgetVoiceBottomSheet$BottomContent$Controls.getInputMode();
            boolean zIsMuted = widgetVoiceBottomSheet$BottomContent$Controls.isMuted();
            boolean zIsScreensharing = widgetVoiceBottomSheet$BottomContent$Controls.isScreensharing();
            CameraState cameraState = widgetVoiceBottomSheet$BottomContent$Controls.getCameraState();
            WidgetVoiceBottomSheet$configureBottomContent$1 widgetVoiceBottomSheet$configureBottomContent$1 = new WidgetVoiceBottomSheet$configureBottomContent$1(getViewModel());
            WidgetVoiceBottomSheet$configureBottomContent$2 widgetVoiceBottomSheet$configureBottomContent$2 = new WidgetVoiceBottomSheet$configureBottomContent$2(getViewModel());
            WidgetVoiceBottomSheet$configureBottomContent$3 widgetVoiceBottomSheet$configureBottomContent$3 = new WidgetVoiceBottomSheet$configureBottomContent$3(this);
            WidgetVoiceBottomSheet$configureBottomContent$4 widgetVoiceBottomSheet$configureBottomContent$4 = new WidgetVoiceBottomSheet$configureBottomContent$4(getViewModel());
            WidgetVoiceBottomSheet$configureBottomContent$5 widgetVoiceBottomSheet$configureBottomContent$5 = new WidgetVoiceBottomSheet$configureBottomContent$5(getViewModel());
            boolean showScreenShareSparkle = widgetVoiceBottomSheet$BottomContent$Controls.getShowScreenShareSparkle();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            anchoredVoiceControlsView3.configureUI(inputMode, widgetVoiceBottomSheet$BottomContent$Controls.getAudioManagerState(), zIsMuted, zIsScreensharing, showScreenShareSparkle, cameraState, widgetVoiceBottomSheet$configureBottomContent$1, widgetVoiceBottomSheet$configureBottomContent$2, widgetVoiceBottomSheet$configureBottomContent$3, widgetVoiceBottomSheet$configureBottomContent$4, widgetVoiceBottomSheet$configureBottomContent$5, this, parentFragmentManager, new WidgetVoiceBottomSheet$configureBottomContent$6(this), getChannelId(), channel.getGuildId(), getForwardToFullscreenIfVideoActivated(), getFeatureContext());
            CoordinatorLayout coordinatorLayout3 = getBinding().i;
            CoordinatorLayout coordinatorLayout4 = getBinding().i;
            m.checkNotNullExpressionValue(coordinatorLayout4, "binding.voiceBottomSheetRoot");
            coordinatorLayout3.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout4, 2130968912));
        } else if (bottomContent instanceof WidgetVoiceBottomSheet$BottomContent$Connect) {
            AnchoredVoiceControlsView anchoredVoiceControlsView4 = getBinding().f;
            m.checkNotNullExpressionValue(anchoredVoiceControlsView4, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView4.setVisibility(4);
            getBinding().f.hidePtt();
            RelativeLayout relativeLayout3 = getBinding().e;
            m.checkNotNullExpressionValue(relativeLayout3, "binding.voiceBottomSheetConnectContainer");
            relativeLayout3.setVisibility(0);
            WidgetVoiceBottomSheet$BottomContent$Connect widgetVoiceBottomSheet$BottomContent$Connect = (WidgetVoiceBottomSheet$BottomContent$Connect) bottomContent;
            if (widgetVoiceBottomSheet$BottomContent$Connect.isConnectEnabled()) {
                getBinding().d.setText(2131892401);
                MaterialButton materialButton = getBinding().d;
                m.checkNotNullExpressionValue(materialButton, "binding.voiceBottomSheetConnect");
                materialButton.setEnabled(true);
            } else {
                getBinding().d.setText(2131887550);
                MaterialButton materialButton2 = getBinding().d;
                m.checkNotNullExpressionValue(materialButton2, "binding.voiceBottomSheetConnect");
                materialButton2.setEnabled(false);
            }
            getBinding().d.setOnClickListener(new WidgetVoiceBottomSheet$configureBottomContent$7(this));
            MaterialButton materialButton3 = getBinding().g;
            m.checkNotNullExpressionValue(materialButton3, "binding.voiceBottomSheetJoinVideo");
            materialButton3.setEnabled(widgetVoiceBottomSheet$BottomContent$Connect.isConnectEnabled());
            getBinding().g.setOnClickListener(new WidgetVoiceBottomSheet$configureBottomContent$8(this));
            CoordinatorLayout coordinatorLayout5 = getBinding().i;
            CoordinatorLayout coordinatorLayout6 = getBinding().i;
            m.checkNotNullExpressionValue(coordinatorLayout6, "binding.voiceBottomSheetRoot");
            coordinatorLayout5.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout6, 2130968911));
        }
    }

    private final void configureCenterContent(WidgetVoiceBottomSheet$CenterContent centerContent, Channel channel) {
        if (!(centerContent instanceof WidgetVoiceBottomSheet$CenterContent$ListItems)) {
            if (!(centerContent instanceof WidgetVoiceBottomSheet$CenterContent$Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            t0 t0Var = getBinding().f2699b;
            m.checkNotNullExpressionValue(t0Var, "binding.empty");
            LinearLayout linearLayout = t0Var.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.empty.root");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().h;
            m.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
            WidgetVoiceBottomSheet$CenterContent$Empty widgetVoiceBottomSheet$CenterContent$Empty = (WidgetVoiceBottomSheet$CenterContent$Empty) centerContent;
            recyclerView.setVisibility(widgetVoiceBottomSheet$CenterContent$Empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                m.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(widgetVoiceBottomSheet$CenterContent$Empty.getItems());
            return;
        }
        t0 t0Var2 = getBinding().f2699b;
        m.checkNotNullExpressionValue(t0Var2, "binding.empty");
        LinearLayout linearLayout2 = t0Var2.a;
        m.checkNotNullExpressionValue(linearLayout2, "binding.empty.root");
        linearLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().h;
        m.checkNotNullExpressionValue(recyclerView2, "binding.voiceBottomSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetVoiceBottomSheet$CenterContent$ListItems) centerContent).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new WidgetVoiceBottomSheet$configureCenterContent$1(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new WidgetVoiceBottomSheet$configureCenterContent$2(this, channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnToggleRingingClicked(new WidgetVoiceBottomSheet$configureCenterContent$3(this));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnInviteFriendsClicked(new WidgetVoiceBottomSheet$configureCenterContent$4(this, channel));
        CallParticipantsAdapter callParticipantsAdapter7 = this.participantsAdapter;
        if (callParticipantsAdapter7 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter7.setOnEmbeddedActivityClicked(new WidgetVoiceBottomSheet$configureCenterContent$5(this));
    }

    private final void configureUI(WidgetVoiceBottomSheetViewModel$ViewState viewState) {
        TextView textView = getBinding().c.g;
        m.checkNotNullExpressionValue(textView, "binding.header.voiceBottomSheetHeaderTitle");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().c.f;
        m.checkNotNullExpressionValue(textView2, "binding.header.voiceBottomSheetHeaderSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView2, viewState.getSubtitle());
        ImageView imageView = getBinding().c.f208b;
        m.checkNotNullExpressionValue(imageView, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView.setActivated(viewState.getIsDeafened());
        ImageView imageView2 = getBinding().c.f208b;
        m.checkNotNullExpressionValue(imageView2, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView2.setContentDescription(viewState.getIsDeafened() ? getString(2131896574) : getString(2131888355));
        getBinding().c.f208b.setOnClickListener(new WidgetVoiceBottomSheet$configureUI$1(this));
        ImageView imageView3 = getBinding().c.c;
        m.checkNotNullExpressionValue(imageView3, "binding.header.voiceBottomSheetHeaderInvite");
        imageView3.setVisibility(viewState.getShowInviteOption() ? 0 : 8);
        getBinding().c.c.setOnClickListener(new WidgetVoiceBottomSheet$configureUI$2(this, viewState));
        getBinding().c.e.setOnClickListener(new WidgetVoiceBottomSheet$configureUI$3(this));
        getBinding().c.d.setOnClickListener(new WidgetVoiceBottomSheet$configureUI$4(this));
        if (viewState.getIsNoiseCancellationActive() != null) {
            if (m.areEqual(viewState.getIsNoiseCancellationActive(), Boolean.TRUE)) {
                getBinding().c.d.setImageResource(2131231971);
            } else {
                getBinding().c.d.setImageResource(2131231972);
            }
            ImageView imageView4 = getBinding().c.d;
            m.checkNotNullExpressionValue(imageView4, "binding.header.voiceBott…etHeaderNoiseCancellation");
            imageView4.setVisibility(0);
        } else {
            ImageView imageView5 = getBinding().c.d;
            m.checkNotNullExpressionValue(imageView5, "binding.header.voiceBott…etHeaderNoiseCancellation");
            imageView5.setVisibility(8);
        }
        configureCenterContent(viewState.getCenterContent(), viewState.getChannel());
        configureBottomContent(viewState.getBottomContent(), viewState.getChannel());
    }

    private final WidgetVoiceBottomSheetBinding getBinding() {
        return (WidgetVoiceBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetVoiceBottomSheet$FeatureContext getFeatureContext() {
        return (WidgetVoiceBottomSheet$FeatureContext) this.featureContext.getValue();
    }

    private final boolean getForwardToFullscreenIfVideoActivated() {
        return ((Boolean) this.forwardToFullscreenIfVideoActivated.getValue()).booleanValue();
    }

    private final WidgetVoiceBottomSheetViewModel getViewModel() {
        return (WidgetVoiceBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetVoiceBottomSheetViewModel$Event event) {
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowSuppressedDialog.INSTANCE)) {
            showSuppressedDialog();
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowServerMutedDialog.INSTANCE)) {
            showServerMutedDialog();
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowServerDeafenedDialog.INSTANCE)) {
            showServerDeafenedDialog();
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoPermissionDialog.INSTANCE)) {
            showNoVideoPermissionDialog();
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoDevicesAvailableToast.INSTANCE)) {
            showNoVideoDevicesToast();
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowRequestCameraPermissionsDialog.INSTANCE)) {
            requestVideoCallPermissions(new WidgetVoiceBottomSheet$handleEvent$1(this));
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog) {
            j$a j_a = j.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            j_a.a(parentFragmentManager, ((WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog) event).getGuildMaxVideoChannelUsers());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$ShowNoiseCancellationBottomSheet) {
            WidgetNoiseCancellationBottomSheet.Companion.show(this);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall) {
            Subscription subscription = this.viewModelEventSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            dismiss();
            WidgetCallFullscreen$Companion widgetCallFullscreen$Companion = WidgetCallFullscreen.Companion;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall = (WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall) event;
            WidgetCallFullscreen$Companion.launch$default(widgetCallFullscreen$Companion, contextRequireContext, widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.getChannelId(), false, widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.getAutoTargetStreamKey(), null, 20, null);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel) {
            Subscription subscription2 = this.viewModelEventSubscription;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            dismiss();
            WidgetCallFullscreen$Companion widgetCallFullscreen$Companion2 = WidgetCallFullscreen.Companion;
            Context contextRequireContext2 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            WidgetCallFullscreen$Companion.launch$default(widgetCallFullscreen$Companion2, contextRequireContext2, ((WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel) event).getChannelId(), false, null, null, 28, null);
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            m$a m_a = b.a.a.m.k;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            m_a.a(parentFragmentManager2);
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.Companion.enqueue();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$ShowToast) {
            b.a.d.m.g(requireContext(), ((WidgetVoiceBottomSheetViewModel$Event$ShowToast) event).getToastResId(), 0, null, 12);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd) {
            WidgetEndGuildScheduledEventBottomSheet$Companion widgetEndGuildScheduledEventBottomSheet$Companion = WidgetEndGuildScheduledEventBottomSheet.Companion;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd widgetVoiceBottomSheetViewModel$Event$ShowEventEnd = (WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd) event;
            widgetEndGuildScheduledEventBottomSheet$Companion.show(parentFragmentManager3, END_EVENT_REQUEST_KEY, widgetVoiceBottomSheetViewModel$Event$ShowEventEnd.getGuildScheduledEvent().getGuildId(), widgetVoiceBottomSheetViewModel$Event$ShowEventEnd.getGuildScheduledEvent().getId());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet) {
            WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet widgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet = (WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet) event;
            CallFeedbackSheetNavigator.INSTANCE.enqueueNotice(widgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet.getChannelId(), widgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet.getRtcConnectionId(), widgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet.getMediaSessionId(), Long.valueOf(widgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet.getCallDuration()), widgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet.getTriggerRateDenominator());
            return;
        }
        if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$Dismiss.INSTANCE)) {
            dismiss();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context contextRequireContext3 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            String string = getString(((WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement) event).getMessageResId());
            m.checkNotNullExpressionValue(string, "getString(event.messageResId)");
            accessibilityUtils.sendAnnouncement(contextRequireContext3, string);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel$Event$ShowNoScreenSharePermissionDialog) {
            showNoScreenSharePermissionDialog();
        } else if (m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$RequestStartStream.INSTANCE)) {
            StreamNavigator.requestStartStream(this);
        } else {
            if (!m.areEqual(event, WidgetVoiceBottomSheetViewModel$Event$ExpandSheet.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            setBottomSheetState(3);
        }
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        int iOrdinal = getFeatureContext().ordinal();
        if (iOrdinal == 0) {
            d.S1(this, null, new WidgetVoiceBottomSheet$onStreamPreviewClicked$1(this, streamContext), 1, null);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            this.onStreamPreviewClickedListener.invoke(streamContext);
        }
    }

    private final void showNoScreenSharePermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131893293);
        String string2 = contextRequireContext.getString(2131893279);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_permission_dialog_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVideoDevicesToast() {
        b.a.d.m.i(this, 2131893291, 0, 4);
    }

    private final void showNoVideoPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131893293);
        String string2 = contextRequireContext.getString(2131893292);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…o_permission_dialog_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerDeafenedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131895439);
        String string2 = contextRequireContext.getString(2131895438);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ver_deafened_dialog_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerMutedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131895587);
        String string2 = contextRequireContext.getString(2131895586);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…server_muted_dialog_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showSuppressedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131896115);
        String string2 = contextRequireContext.getString(2131896118);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ppressed_permission_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_voice_bottom_sheet;
    }

    public final Function1<StreamContext, Unit> getOnStreamPreviewClickedListener() {
        return this.onStreamPreviewClickedListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new WidgetVoiceBottomSheet$onActivityResult$1(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().h;
        m.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) mGRecyclerAdapter$Companion.configure(new CallParticipantsAdapter(recyclerView, false, true, 2, null));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new WidgetVoiceBottomSheet$onResume$1(this));
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new WidgetVoiceBottomSheet$onResume$2(this));
        getBinding().h.setHasFixedSize(false);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetVoiceBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceBottomSheet$onResume$3(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetVoiceBottomSheet.class, (Context) null, new WidgetVoiceBottomSheet$onResume$5(this), (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceBottomSheet$onResume$4(this), 58, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
        getBinding().f.setOnPttPressedListener(new WidgetVoiceBottomSheet$onViewCreated$1(getViewModel()));
        WidgetEndGuildScheduledEventBottomSheet.Companion.registerForResult(this, END_EVENT_REQUEST_KEY, new WidgetVoiceBottomSheet$onViewCreated$2(getViewModel()));
    }

    public final void setOnStreamPreviewClickedListener(Function1<? super StreamContext, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClickedListener = function1;
    }
}
