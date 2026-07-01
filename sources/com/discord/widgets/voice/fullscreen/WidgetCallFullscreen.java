package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.a.j$a;
import b.a.a.m$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.i;
import b.a.i.j;
import b.a.j.a$b;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.app.AppTransitionActivity$a;
import com.discord.databinding.WidgetCallFullscreenBinding;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.tooltips.DefaultTooltipCreator;
import com.discord.tooltips.TooltipManager;
import com.discord.tooltips.TooltipManager$a;
import com.discord.tooltips.TooltipManager$b;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.utilities.voice.VoiceViewUtils;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.views.calls.StageCallVisitCommunityView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData;
import com.discord.views.calls.VoiceCallActiveEventView;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.channels.TextInVoiceOnboardingManager;
import com.discord.widgets.guildscheduledevent.GuildEventPromptListView;
import com.discord.widgets.guildscheduledevent.GuildEventPromptListView$ScheduledEventData;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.stage.model.StageMediaParticipant;
import com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import com.discord.widgets.user.usersheet.WidgetUserSheet$StreamPreviewClickBehavior;
import com.discord.widgets.voice.controls.VoiceControlsOutputSelectorState;
import com.discord.widgets.voice.controls.VoiceControlsSheetSwipeTooltip;
import com.discord.widgets.voice.controls.VoiceControlsSheetView;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetNavigator;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetNavigator;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridLayoutManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallAdapter;
import com.discord.widgets.voice.fullscreen.stage.StageCallBottomSheetManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$AudienceHeaderItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$DetailsItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$DividerItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$MediaItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem$PreStartDetailsItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.stream.StreamNavigator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.t.c0;
import d0.t.o;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCallFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallFullscreenBinding;", 0)};
    public static final WidgetCallFullscreen$Companion Companion = new WidgetCallFullscreen$Companion(null);
    private static final String END_EVENT_REQUEST_KEY = "END_EVENT_REQUEST_KEY";
    private static final String END_STAGE_REQUEST_KEY = "END_STAGE_REQUEST_KEY";
    private static final String INTENT_EXTRA_CONNECT_ON_LAUNCH = "INTENT_EXTRA_CONNECT_ON_LAUNCH";
    public static final int MAX_SPEAKERS_PER_ROW = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior;
    private final BottomSheetBehavior$BottomSheetCallback bottomSheetCallback;
    private Subscription connectedTimerSubscription;
    private final DefaultTooltipCreator defaultTooltipCreator;

    /* JADX INFO: renamed from: eventPromptOverlay$delegate, reason: from kotlin metadata */
    private final Lazy eventPromptOverlay;
    private VideoCallGridAdapter gridAdapter;
    private boolean hasVideoCallGridChildrenChanged;
    private Integer lastMentionsCount;
    private Set<? extends WidgetCallFullscreenViewModel$MenuItem> lastMenuItems;
    private Integer lastUnreadsCount;
    private StageCallAdapter stageAdapter;
    private final StageCallBottomSheetManager stageCallBottomSheetManager;
    private GridLayoutManager stageLayoutManager;
    private final WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1 stageSpeakerPillManagingScrollListener;
    private WindowInsetsCompat systemWindowInsets;
    private final TooltipManager tooltipManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetCallFullscreen() {
        super(R$layout.widget_call_fullscreen);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetCallFullscreen$binding$2.INSTANCE, new WidgetCallFullscreen$binding$3(this));
        this.bottomSheetCallback = new WidgetCallFullscreen$bottomSheetCallback$1(this);
        WidgetCallFullscreen$viewModel$2 widgetCallFullscreen$viewModel$2 = new WidgetCallFullscreen$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetCallFullscreenViewModel.class), new WidgetCallFullscreen$appViewModels$$inlined$viewModels$1(new g0(this)), new i0(widgetCallFullscreen$viewModel$2));
        this.stageSpeakerPillManagingScrollListener = new WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1(this);
        AppLog appLog = AppLog.g;
        m.checkNotNullParameter(appLog, "logger");
        WeakReference<b.a.j.a> weakReference = a$b.a;
        b.a.j.a aVar = weakReference != null ? weakReference.get() : null;
        if (aVar == null) {
            aVar = new b.a.j.a(appLog);
            a$b.a = new WeakReference<>(aVar);
        }
        b.a.j.a aVar2 = aVar;
        TooltipManager$a tooltipManager$a = TooltipManager$a.d;
        m.checkNotNullParameter(aVar2, "floatingViewManager");
        WeakReference<TooltipManager> weakReference2 = TooltipManager$a.a;
        TooltipManager tooltipManager = weakReference2 != null ? weakReference2.get() : null;
        if (tooltipManager == null) {
            tooltipManager = new TooltipManager((b.a.v.a) TooltipManager$a.f2815b.getValue(), (Set) TooltipManager$a.c.getValue(), 0, aVar2, 4);
            TooltipManager$a.a = new WeakReference<>(tooltipManager);
        }
        this.tooltipManager = tooltipManager;
        this.defaultTooltipCreator = new DefaultTooltipCreator(tooltipManager);
        this.stageCallBottomSheetManager = new StageCallBottomSheetManager();
        this.eventPromptOverlay = LazyViewStubDelegate.Companion.lazyViewStub(new WidgetCallFullscreen$eventPromptOverlay$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewState) {
        widgetCallFullscreen.configureUI(widgetCallFullscreenViewModel$ViewState);
    }

    public static final /* synthetic */ void access$finishActivity(WidgetCallFullscreen widgetCallFullscreen, boolean z2, boolean z3) {
        widgetCallFullscreen.finishActivity(z2, z3);
    }

    public static final /* synthetic */ WidgetCallFullscreenBinding access$getBinding$p(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.getChannelId();
    }

    public static final /* synthetic */ Subscription access$getConnectedTimerSubscription$p(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.connectedTimerSubscription;
    }

    public static final /* synthetic */ VideoCallGridAdapter access$getGridAdapter$p(WidgetCallFullscreen widgetCallFullscreen) {
        VideoCallGridAdapter videoCallGridAdapter = widgetCallFullscreen.gridAdapter;
        if (videoCallGridAdapter == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        return videoCallGridAdapter;
    }

    public static final /* synthetic */ boolean access$getHasVideoCallGridChildrenChanged$p(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.hasVideoCallGridChildrenChanged;
    }

    public static final /* synthetic */ WindowInsetsCompat access$getSystemWindowInsets$p(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.systemWindowInsets;
    }

    public static final /* synthetic */ TooltipManager access$getTooltipManager$p(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.tooltipManager;
    }

    public static final /* synthetic */ WidgetCallFullscreenViewModel access$getViewModel$p(WidgetCallFullscreen widgetCallFullscreen) {
        return widgetCallFullscreen.getViewModel();
    }

    public static final /* synthetic */ List access$getVisibleParticipants(WidgetCallFullscreen widgetCallFullscreen, VideoCallGridLayoutManager videoCallGridLayoutManager) {
        return widgetCallFullscreen.getVisibleParticipants(videoCallGridLayoutManager);
    }

    public static final /* synthetic */ boolean access$isStageUserVisible(WidgetCallFullscreen widgetCallFullscreen, long j) {
        return widgetCallFullscreen.isStageUserVisible(j);
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        widgetCallFullscreen.onViewBindingDestroy(widgetCallFullscreenBinding);
    }

    public static final /* synthetic */ void access$openTextInVoice(WidgetCallFullscreen widgetCallFullscreen) {
        widgetCallFullscreen.openTextInVoice();
    }

    public static final /* synthetic */ void access$setConnectedTimerSubscription$p(WidgetCallFullscreen widgetCallFullscreen, Subscription subscription) {
        widgetCallFullscreen.connectedTimerSubscription = subscription;
    }

    public static final /* synthetic */ void access$setGridAdapter$p(WidgetCallFullscreen widgetCallFullscreen, VideoCallGridAdapter videoCallGridAdapter) {
        widgetCallFullscreen.gridAdapter = videoCallGridAdapter;
    }

    public static final /* synthetic */ void access$setHasVideoCallGridChildrenChanged$p(WidgetCallFullscreen widgetCallFullscreen, boolean z2) {
        widgetCallFullscreen.hasVideoCallGridChildrenChanged = z2;
    }

    public static final /* synthetic */ void access$setSystemWindowInsets$p(WidgetCallFullscreen widgetCallFullscreen, WindowInsetsCompat windowInsetsCompat) {
        widgetCallFullscreen.systemWindowInsets = windowInsetsCompat;
    }

    public static final /* synthetic */ void access$setVoiceControlsSheetPeekHeight(WidgetCallFullscreen widgetCallFullscreen) {
        widgetCallFullscreen.setVoiceControlsSheetPeekHeight();
    }

    private final void collapseBottomSheet() {
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehavior.setState(4);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0164  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:81:0x0213  */
    private final void configureActionBar(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        int i;
        boolean zHasLiveEvent;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ViewExtensions.fadeBy(getBinding().d, viewState.getShowHeader(), 200L);
        boolean z7 = viewState.getTotalMentionsCount() > 0;
        ViewExtensions.fadeBy(getBinding().h, viewState.getShowHeader() && z7, 200L);
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getTotalMentionsCount()));
        Toolbar toolbar = getBinding().f2245b;
        m.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        Context contextRequireContext = requireContext();
        if (!viewState.isTextInVoiceEnabled() && viewState.getDisplayMode() != WidgetCallFullscreenViewModel$DisplayMode.STAGE && z7) {
            i = 2131231599;
        } else if (viewState.isTextInVoiceEnabled() || viewState.getDisplayMode() == WidgetCallFullscreenViewModel$DisplayMode.STAGE) {
            i = z7 ? 2131231602 : 2131231603;
        } else {
            i = 2131231598;
        }
        toolbar.setNavigationIcon(ContextCompat.getDrawable(contextRequireContext, i));
        getBinding().f2245b.setNavigationOnClickListener(new WidgetCallFullscreen$configureActionBar$1(this, viewState));
        CallEventsButtonView callEventsButtonView = getBinding().w;
        Guild guild = viewState.getCallModel().getGuild();
        if (guild == null || viewState.getStageCallModel() == null || viewState.getStageCallModel().isLurking()) {
            zHasLiveEvent = false;
        } else {
            zHasLiveEvent = viewState.getCallModel().canManageEvent() ? true : GuildScheduledEventUtilitiesKt.hasLiveEvent(viewState.getCallModel().getGuildScheduledEvents());
        }
        callEventsButtonView.setVisibility(zHasLiveEvent ? 0 : 8);
        if (guild != null && zHasLiveEvent) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            callEventsButtonView.a(parentFragmentManager, guild.getId(), getChannelId(), viewState.getCallModel().getGuildScheduledEvents());
        }
        VoiceCallActiveEventView voiceCallActiveEventView = getBinding().f2247x;
        m.checkNotNullExpressionValue(voiceCallActiveEventView, "binding.toolbarVoiceActiveEvent");
        if (viewState.getStageCallModel() != null) {
            z2 = false;
        } else {
            GuildScheduledEvent activeEvent = viewState.getActiveEvent();
            if (activeEvent != null) {
                VoiceCallActiveEventView voiceCallActiveEventView2 = getBinding().f2247x;
                Channel channel = viewState.getCallModel().getChannel();
                Objects.requireNonNull(voiceCallActiveEventView2);
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(activeEvent, "guildScheduledEvent");
                TextView textView2 = voiceCallActiveEventView2.binding.f135b;
                m.checkNotNullExpressionValue(textView2, "binding.channelName");
                textView2.setText(channel.getName());
                TextView textView3 = voiceCallActiveEventView2.binding.c;
                m.checkNotNullExpressionValue(textView3, "binding.eventName");
                textView3.setText(activeEvent.getName());
                voiceCallActiveEventView2.setOnClickListener(new WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1(activeEvent, this, viewState));
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        voiceCallActiveEventView.setVisibility(z2 ? 0 : 8);
        StageCallVisitCommunityView stageCallVisitCommunityView = getBinding().q;
        m.checkNotNullExpressionValue(stageCallVisitCommunityView, "binding.callVisitCommunity");
        StageCallModel stageCallModel = viewState.getStageCallModel();
        if (stageCallModel == null || !stageCallModel.isLurking()) {
            z3 = false;
        } else {
            Guild guild2 = viewState.getStageCallModel().getGuild();
            if (guild2 != null) {
                StageCallVisitCommunityView stageCallVisitCommunityView2 = getBinding().q;
                Objects.requireNonNull(stageCallVisitCommunityView2);
                m.checkNotNullParameter(guild2, "guild");
                String icon = guild2.getIcon();
                if (icon == null) {
                    z5 = false;
                } else {
                    if (icon.length() > 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                SimpleDraweeView simpleDraweeView = stageCallVisitCommunityView2.binding.f229b;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.visitCommunityIcon");
                SimpleDraweeViewExtensionsKt.setGuildIcon$default(simpleDraweeView, true, guild2, stageCallVisitCommunityView2.getResources().getDimensionPixelSize(2131165449), Integer.valueOf(IconUtils.getMediaProxySize(stageCallVisitCommunityView2.getResources().getDimensionPixelSize(2131165294))), null, null, null, false, null, 496, null);
                TextView textView4 = stageCallVisitCommunityView2.binding.c;
                m.checkNotNullExpressionValue(textView4, "binding.visitCommunityIconText");
                textView4.setText(z5 ? null : guild2.getShortName());
                stageCallVisitCommunityView2.setOnClickListener(new WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$2(guild2, this));
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        stageCallVisitCommunityView.setVisibility(z3 ? 0 : 8);
        int color = ColorCompat.getColor(this, 2131100438);
        String titleText = viewState.getTitleText();
        if (titleText == null) {
            titleText = "";
        }
        setActionBarTitle(titleText);
        setActionBarTitleColor(-1);
        ViewExtensions.fadeBy(getBinding().c, viewState.getShowHeader(), 200L);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x010c  */
    private final void configureBottomControls(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        boolean z2;
        VoiceControlsSheetView voiceControlsSheetView = getBinding().f2248y;
        m.checkNotNullExpressionValue(voiceControlsSheetView, "binding.voiceControlsSheetView");
        voiceControlsSheetView.setVisibility(0);
        VoiceControlsSheetView voiceControlsSheetView2 = getBinding().f2248y;
        CallModel callModel = viewState.getCallModel();
        VoiceControlsOutputSelectorState outputSelectorState = viewState.getOutputSelectorState();
        boolean z3 = viewState.getCameraState() != CameraState.CAMERA_DISABLED;
        boolean zIsPushToTalk = viewState.getIsPushToTalk();
        boolean zIsDeafened = viewState.getIsDeafened();
        boolean startedAsVideo = viewState.getStartedAsVideo();
        WidgetCallFullscreen$configureBottomControls$1 widgetCallFullscreen$configureBottomControls$1 = new WidgetCallFullscreen$configureBottomControls$1(this, viewState);
        WidgetCallFullscreen$configureBottomControls$2 widgetCallFullscreen$configureBottomControls$2 = new WidgetCallFullscreen$configureBottomControls$2(this);
        WidgetCallFullscreen$configureBottomControls$3 widgetCallFullscreen$configureBottomControls$3 = new WidgetCallFullscreen$configureBottomControls$3(this);
        WidgetCallFullscreen$configureBottomControls$4 widgetCallFullscreen$configureBottomControls$4 = new WidgetCallFullscreen$configureBottomControls$4(this);
        voiceControlsSheetView2.m64configureUI3jxq49Y(callModel, outputSelectorState, z3, zIsPushToTalk, zIsDeafened, startedAsVideo, viewState.getIsStreamFocused(), !viewState.getIsStreamFocused(), widgetCallFullscreen$configureBottomControls$2, widgetCallFullscreen$configureBottomControls$1, widgetCallFullscreen$configureBottomControls$3, widgetCallFullscreen$configureBottomControls$4, new WidgetCallFullscreen$configureBottomControls$5(this), new WidgetCallFullscreen$configureBottomControls$7(this, viewState), new WidgetCallFullscreen$configureBottomControls$6(this, viewState), viewState.getShowStreamVolume(), viewState.getPerceptualStreamVolume(), new WidgetCallFullscreen$configureBottomControls$8(this), new WidgetCallFullscreen$configureBottomControls$9(this), viewState.getRequestingToSpeakCount(), new WidgetCallFullscreen$configureBottomControls$10(this, viewState), new WidgetCallFullscreen$configureBottomControls$11(this), viewState.isUpdatingRequestToSpeak(), viewState.m72getStageRolestwRsX0());
        configureSwipeTooltip(viewState.getStageCallModel() == null && viewState.getShowFooter());
        if (!viewState.getIsVideoCallGridVisible()) {
            VoiceControlsSheetView voiceControlsSheetView3 = getBinding().f2248y;
            m.checkNotNullExpressionValue(voiceControlsSheetView3, "binding.voiceControlsSheetView");
            ViewExtensions.cancelFadeAnimations(voiceControlsSheetView3);
            VoiceControlsSheetView voiceControlsSheetView4 = getBinding().f2248y;
            m.checkNotNullExpressionValue(voiceControlsSheetView4, "binding.voiceControlsSheetView");
            voiceControlsSheetView4.setAlpha(1.0f);
        } else if (viewState.getShowFooter()) {
            showControls();
        } else {
            hideControls();
        }
        MaterialButton materialButton = getBinding().g;
        m.checkNotNullExpressionValue(materialButton, "binding.callFloatingPushToTalk");
        if (viewState.getIsPushToTalk()) {
            VoiceControlsSheetView voiceControlsSheetView5 = getBinding().f2248y;
            m.checkNotNullExpressionValue(voiceControlsSheetView5, "binding.voiceControlsSheetView");
            z2 = voiceControlsSheetView5.getVisibility() == 0 ? false : true;
        }
        materialButton.setVisibility(z2 ? 0 : 8);
    }

    private final void configureConnectionStatusText(CallModel callModel) {
        Subscription subscription = this.connectedTimerSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
            m.checkNotNullExpressionValue(observableE, "Observable\n          .in…0L, 1L, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableE, this, null, 2, null), WidgetCallFullscreen.class, (Context) null, new WidgetCallFullscreen$configureConnectionStatusText$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetCallFullscreen$configureConnectionStatusText$1(this, callModel), 58, (Object) null);
        }
    }

    private final void configureEventPrompt(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        Guild guild = viewState.getCallModel().getGuild();
        WidgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 widgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 = new WidgetCallFullscreen$configureEventPrompt$onCreateEventClick$1(this, guild);
        GuildScheduledEvent startableEvent = viewState.getStartableEvent();
        WidgetCallFullscreen$configureEventPrompt$onStartEvent$1 widgetCallFullscreen$configureEventPrompt$onStartEvent$1 = new WidgetCallFullscreen$configureEventPrompt$onStartEvent$1(this, startableEvent);
        WidgetCallFullscreen$configureEventPrompt$onStartStage$1 widgetCallFullscreen$configureEventPrompt$onStartStage$1 = new WidgetCallFullscreen$configureEventPrompt$onStartStage$1(this);
        GuildEventPromptListView guildEventPromptListView = (GuildEventPromptListView) getEventPromptOverlay().getMaybeView();
        if (guildEventPromptListView != null) {
            GuildEventPromptListView$ScheduledEventData guildEventPromptListView$ScheduledEventData = (startableEvent != null && GuildScheduledEventUtilities.Companion.canStartEventInChannel(viewState.getCallModel().getChannel(), viewState.getChannelPermissions())) ? new GuildEventPromptListView$ScheduledEventData(startableEvent, widgetCallFullscreen$configureEventPrompt$onStartEvent$1) : null;
            if (guild == null || viewState.getStageCallModel() == null || !PermissionUtils.can(Permission.START_STAGE_EVENT, viewState.getChannelPermissions())) {
                widgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 = null;
            }
            if (viewState.getStageCallModel() == null || !StageRoles.m32isModeratorimpl(viewState.getStageCallModel().m42getMyStageRoles1LxfuJo())) {
                widgetCallFullscreen$configureEventPrompt$onStartStage$1 = null;
            }
            guildEventPromptListView.configure(guildEventPromptListView$ScheduledEventData, widgetCallFullscreen$configureEventPrompt$onCreateEventClick$1, widgetCallFullscreen$configureEventPrompt$onStartStage$1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x019c  */
    private final void configureGridUi(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        boolean z2;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        fragmentActivityRequireActivity.setRequestedOrientation(-1);
        RelativeLayout relativeLayout = getBinding().f2246s.d;
        m.checkNotNullExpressionValue(relativeLayout, "binding.privateCall.privateCallContainer");
        relativeLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        recyclerView.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().t;
        m.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(8);
        getBinding().j.setOnClickListener(new WidgetCallFullscreen$configureGridUi$1(this));
        LinearLayout linearLayout = getBinding().j;
        m.checkNotNullExpressionValue(linearLayout, "binding.callParticipantsHidden");
        linearLayout.setVisibility(viewState.getShowParticipantsHiddenView() ? 0 : 8);
        getBinding().o.setOnClickListener(new WidgetCallFullscreen$configureGridUi$2(this));
        ConstraintLayout constraintLayout2 = getBinding().o;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.callStreamingActive");
        constraintLayout2.setVisibility(viewState.getCallModel().isStreaming() ? 0 : 8);
        MaterialButton materialButton = getBinding().n;
        m.checkNotNullExpressionValue(materialButton, "binding.callStopStreamingButton");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        materialButton.setVisibility(resources.getConfiguration().orientation != 2 ? 0 : 8);
        getBinding().n.setOnClickListener(new WidgetCallFullscreen$configureGridUi$3(this));
        getBinding().k.setOnClickListener(new WidgetCallFullscreen$configureGridUi$4(this));
        RecyclerView recyclerView2 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
        boolean z3 = recyclerView2.getVisibility() == 0;
        if (viewState.getIsVideoCallGridVisible() != z3) {
            RecyclerView recyclerView3 = getBinding().p;
            m.checkNotNullExpressionValue(recyclerView3, "binding.callVideoRecycler");
            recyclerView3.setVisibility(viewState.getIsVideoCallGridVisible() ? 0 : 8);
            if (viewState.getIsVideoCallGridVisible() && !z3) {
                RecyclerView recyclerView4 = getBinding().p;
                m.checkNotNullExpressionValue(recyclerView4, "binding.callVideoRecycler");
                recyclerView4.setVisibility(viewState.getIsVideoCallGridVisible() ? 0 : 8);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(250L);
                getBinding().p.startAnimation(alphaAnimation);
            }
        }
        VideoCallParticipantView videoCallParticipantView = getBinding().l;
        m.checkNotNullExpressionValue(videoCallParticipantView, "binding.callPip");
        videoCallParticipantView.setVisibility(viewState.getPipParticipant() != null ? 0 : 8);
        VideoCallParticipantView videoCallParticipantView2 = getBinding().l;
        CallParticipant$UserOrStreamParticipant pipParticipant = viewState.getPipParticipant();
        VideoCallParticipantView.d(videoCallParticipantView2, pipParticipant != null ? pipParticipant.getParticipantData() : null, null, false, null, false, 30);
        View view = getBinding().e.f181b;
        m.checkNotNullExpressionValue(view, "binding.audioShare.callStreamingAudioShareWarning");
        if (VoiceViewUtils.INSTANCE.getIsSoundshareSupported()) {
            z2 = false;
        } else {
            VideoCallParticipantView videoCallParticipantView3 = getBinding().l;
            m.checkNotNullExpressionValue(videoCallParticipantView3, "binding.callPip");
            if (videoCallParticipantView3.getVisibility() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        view.setVisibility(z2 ? 0 : 8);
        VideoCallGridAdapter videoCallGridAdapter = this.gridAdapter;
        if (videoCallGridAdapter == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        boolean z4 = videoCallGridAdapter.getPageSize() == 1;
        boolean z5 = viewState.getVisibleVideoParticipants().size() == 1;
        VideoCallGridAdapter videoCallGridAdapter2 = this.gridAdapter;
        if (videoCallGridAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter2.setData(viewState.getVisibleVideoParticipants());
        if (z4 && !z5) {
            getBinding().p.scrollToPosition(0);
        }
        configureMenu(viewState);
        configureActionBar(viewState);
        if ((viewState.getStartableEvent() == null || GuildScheduledEventUtilitiesKt.hasLiveEvent(viewState.getCallModel().getGuildScheduledEvents())) ? false : true) {
            ViewExtensions.fadeBy(getEventPromptOverlay().getForceInitializedView(), viewState.getShowFooter(), 200L);
            if (viewState.getShowFooter()) {
                configureEventPrompt(viewState);
            }
        } else {
            getEventPromptOverlay().setVisible(false);
        }
        WidgetEndGuildScheduledEventBottomSheet.Companion.registerForResult(this, END_EVENT_REQUEST_KEY, new WidgetCallFullscreen$configureGridUi$5(this, viewState));
        enableWakeLock();
    }

    private final void configureMenu(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        if (m.areEqual(viewState.getMenuItems(), this.lastMenuItems)) {
            int textInVoiceMentionsCount = viewState.getTextInVoiceMentionsCount();
            Integer num = this.lastMentionsCount;
            if (num != null && textInVoiceMentionsCount == num.intValue()) {
                int textInVoiceUnreadsCount = viewState.getTextInVoiceUnreadsCount();
                Integer num2 = this.lastUnreadsCount;
                if (num2 != null && textInVoiceUnreadsCount == num2.intValue()) {
                    return;
                }
            }
        }
        this.lastMenuItems = viewState.getMenuItems();
        this.lastMentionsCount = Integer.valueOf(viewState.getTextInVoiceMentionsCount());
        this.lastUnreadsCount = Integer.valueOf(viewState.getTextInVoiceUnreadsCount());
        setActionBarOptionsMenu(R$menu.menu_call_fullscreen, new WidgetCallFullscreen$configureMenu$1(this, viewState), new WidgetCallFullscreen$configureMenu$2(this, viewState));
    }

    private final void configurePrivateCallParticipantsUi(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        String displayName;
        LinearLayout linearLayout = getBinding().j;
        m.checkNotNullExpressionValue(linearLayout, "binding.callParticipantsHidden");
        linearLayout.setVisibility(viewState.getShowParticipantsHiddenView() ? 0 : 8);
        RelativeLayout relativeLayout = getBinding().f2246s.d;
        m.checkNotNullExpressionValue(relativeLayout, "binding.privateCall.privateCallContainer");
        relativeLayout.setVisibility(0);
        getBinding().f2246s.f187b.configure(viewState.getPrivateCallUserListItems());
        TextView textView = getBinding().f2246s.c;
        m.checkNotNullExpressionValue(textView, "binding.privateCall.priv…CallConnectivityStatusBar");
        textView.setVisibility(viewState.getShowLowConnectivityBar() ? 0 : 8);
        getBinding().f2246s.f.configure(viewState.getPrivateCallUserListItems());
        VideoCallParticipantView videoCallParticipantView = getBinding().l;
        m.checkNotNullExpressionValue(videoCallParticipantView, "binding.callPip");
        videoCallParticipantView.setVisibility(8);
        RecyclerView recyclerView = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        recyclerView.setVisibility(8);
        RecyclerView recyclerView2 = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callStageRecycler");
        recyclerView2.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().t;
        m.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(8);
        configureMenu(viewState);
        configureActionBar(viewState);
        enableWakeLock();
        getBinding().f2246s.i.setText(viewState.getCallModel().isConnected() ? 2131893512 : 2131897190);
        TextView textView2 = getBinding().f2246s.h;
        m.checkNotNullExpressionValue(textView2, "binding.privateCall.privateCallStatusPrimary");
        if (ChannelUtils.z(viewState.getCallModel().getChannel())) {
            displayName = ChannelUtils.c(viewState.getCallModel().getChannel());
        } else {
            StoreVoiceParticipants$VoiceUser dmRecipient = viewState.getCallModel().getDmRecipient();
            displayName = dmRecipient != null ? dmRecipient.getDisplayName() : null;
        }
        textView2.setText(displayName);
        configureConnectionStatusText(viewState.getCallModel());
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00e5  */
    private final void configureStageUi(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        boolean z2;
        boolean z3;
        StageCallModel stageCallModel = viewState.getStageCallModel();
        if (stageCallModel != null) {
            if (getViewModel().getShowStageCallBottomSheet()) {
                WidgetCallFullscreenViewModel viewModel = getViewModel();
                StageCallBottomSheetManager stageCallBottomSheetManager = this.stageCallBottomSheetManager;
                FragmentManager parentFragmentManager = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                viewModel.setShowStageCallBottomSheet(!stageCallBottomSheetManager.configureBottomSheet(parentFragmentManager, viewState.getCallModel().getChannel()));
            }
            RecyclerView recyclerView = getBinding().m;
            m.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
            recyclerView.setVisibility(0);
            RelativeLayout relativeLayout = getBinding().f2246s.d;
            m.checkNotNullExpressionValue(relativeLayout, "binding.privateCall.privateCallContainer");
            relativeLayout.setVisibility(8);
            VideoCallParticipantView videoCallParticipantView = getBinding().l;
            m.checkNotNullExpressionValue(videoCallParticipantView, "binding.callPip");
            videoCallParticipantView.setVisibility(8);
            RecyclerView recyclerView2 = getBinding().p;
            m.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
            recyclerView2.setVisibility(8);
            if (StageRoles.m32isModeratorimpl(stageCallModel.m42getMyStageRoles1LxfuJo())) {
                boolean z4 = stageCallModel.getStageInstance() == null;
                getEventPromptOverlay().setVisible(z4);
                if (z4) {
                    configureEventPrompt(viewState);
                }
            } else {
                getEventPromptOverlay().setVisible(false);
            }
            Channel channel = viewState.getCallModel().getChannel();
            List<StoreVoiceParticipants$VoiceUser> speakingVoiceUsers = stageCallModel.getSpeakingVoiceUsers();
            ConstraintLayout constraintLayout = getBinding().t;
            m.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
            if (!speakingVoiceUsers.isEmpty()) {
                if (!(speakingVoiceUsers instanceof Collection) || !speakingVoiceUsers.isEmpty()) {
                    Iterator<T> it = speakingVoiceUsers.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!isStageUserVisible(((StoreVoiceParticipants$VoiceUser) it.next()).getUser().getId())) {
                                z3 = true;
                                break;
                            }
                        } else {
                            z3 = false;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                }
                if (z3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            constraintLayout.setVisibility(z2 ? 0 : 8);
            if (!speakingVoiceUsers.isEmpty()) {
                UserSummaryView userSummaryView = getBinding().u;
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(speakingVoiceUsers, 10));
                for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser : speakingVoiceUsers) {
                    arrayList.add(new UserGuildMember(storeVoiceParticipants$VoiceUser.getUser(), storeVoiceParticipants$VoiceUser.getGuildMember()));
                }
                UserSummaryView.b(userSummaryView, arrayList, false, 2);
                MaterialTextView materialTextView = getBinding().v;
                m.checkNotNullExpressionValue(materialTextView, "binding.stageCallSpeakingUserSummaryLabel");
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                materialTextView.setText(b.e(this, 2131895826, new Object[]{speakingVoiceUsers.get(0).getDisplayName(), StringResourceUtilsKt.getQuantityString(resources, R$plurals.stage_is_speaking_hook_count, 2131895827, speakingVoiceUsers.size() - 1, Integer.valueOf(speakingVoiceUsers.size() - 1))}, new WidgetCallFullscreen$configureStageUi$3(this)));
            }
            List<StageMediaParticipant> mediaParticipants = stageCallModel.getMediaParticipants();
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(mediaParticipants, 10));
            for (StageMediaParticipant stageMediaParticipant : mediaParticipants) {
                CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant = viewState.getAllVideoParticipants().get(stageMediaParticipant.getId());
                if (callParticipant$UserOrStreamParticipant == null) {
                    return;
                } else {
                    arrayList2.add(new StageCallItem$MediaItem(stageMediaParticipant.getVoiceUser(), stageMediaParticipant.getChannel(), stageMediaParticipant.isModerator(), stageMediaParticipant.isBlocked(), stageMediaParticipant.getMediaType(), callParticipant$UserOrStreamParticipant));
                }
            }
            ArrayList arrayList3 = new ArrayList();
            boolean z5 = stageCallModel.getNumSpeakers() > 0;
            boolean zIsEmpty = true ^ stageCallModel.getAudience().isEmpty();
            if (stageCallModel.getStageInstance() != null) {
                arrayList3.add(new StageCallItem$DetailsItem(stageCallModel.getStageInstance().getTopic(), ChannelUtils.c(channel), viewState.getCallModel().getNumUsersConnected(), stageCallModel.getNumSpeakers(), stageCallModel.getAudience().size(), stageCallModel.getNumBlockedUsers(), d.W0(stageCallModel.getStageInstance())));
            } else {
                String string = StageRoles.m32isModeratorimpl(stageCallModel.m42getMyStageRoles1LxfuJo()) ? getString(2131895848) : getString(2131895847);
                m.checkNotNullExpressionValue(string, "when {\n                s…pt_title)\n              }");
                String string2 = StageRoles.m32isModeratorimpl(stageCallModel.m42getMyStageRoles1LxfuJo()) ? getString(2131895846) : getString(2131895845);
                m.checkNotNullExpressionValue(string2, "when {\n                s…e_mobile)\n              }");
                arrayList3.add(new StageCallItem$PreStartDetailsItem(string, string2, stageCallModel.getNumSpeakers(), stageCallModel.getAudience().size()));
            }
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(stageCallModel.getSpeakerItems());
            if (z5 && zIsEmpty) {
                arrayList3.add(StageCallItem$DividerItem.INSTANCE);
            }
            if (zIsEmpty) {
                arrayList3.add(new StageCallItem$AudienceHeaderItem(stageCallModel.getAudience().size()));
                arrayList3.addAll(stageCallModel.getAudience());
            }
            StageCallAdapter stageCallAdapter = this.stageAdapter;
            if (stageCallAdapter == null) {
                m.throwUninitializedPropertyAccessException("stageAdapter");
            }
            stageCallAdapter.setData(arrayList3, stageCallModel.getSpeakerItems().size());
            configureMenu(viewState);
            configureActionBar(viewState);
            enableWakeLock();
            WidgetEndStageBottomSheet.Companion.registerForResult(this, END_STAGE_REQUEST_KEY, new WidgetCallFullscreen$configureStageUi$4(this, viewState));
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void configureSwipeTooltip(boolean showTooltip) {
        ViewBinding iVar;
        if (!showTooltip) {
            this.tooltipManager.c(VoiceControlsSheetSwipeTooltip.INSTANCE);
            return;
        }
        DefaultTooltipCreator defaultTooltipCreator = this.defaultTooltipCreator;
        View view = getBinding().f2248y;
        m.checkNotNullExpressionValue(view, "binding.voiceControlsSheetView");
        TooltipManager$b tooltipManager$b = VoiceControlsSheetSwipeTooltip.INSTANCE;
        String string = getResources().getString(2131897178);
        m.checkNotNullExpressionValue(string, "resources.getString(R.st…s_sheet_tooltip_swipe_up)");
        int iDpToPixels = DimenUtils.dpToPixels(-12);
        Observable<R> observableG = getUnsubscribeSignal().G(WidgetCallFullscreen$configureSwipeTooltip$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "this.unsubscribeSignal.map { }");
        FloatingViewGravity floatingViewGravity = FloatingViewGravity.TOP;
        Objects.requireNonNull(defaultTooltipCreator);
        m.checkNotNullParameter(view, "anchorView");
        m.checkNotNullParameter(string, "tooltipText");
        m.checkNotNullParameter(tooltipManager$b, "tooltip");
        m.checkNotNullParameter(floatingViewGravity, "tooltipGravity");
        m.checkNotNullParameter(observableG, "componentPausedObservable");
        if (defaultTooltipCreator.tooltipManager.b(tooltipManager$b, true)) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(view.getContext());
            if (floatingViewGravity == floatingViewGravity) {
                View rootView = view.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                View viewInflate = layoutInflaterFrom.inflate(R$layout.default_tooltip_view_top, (ViewGroup) rootView, false);
                TextView textView = (TextView) viewInflate.findViewById(R$id.default_tooltip_text);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R$id.default_tooltip_text)));
                }
                iVar = new j((ConstraintLayout) viewInflate, textView);
                m.checkNotNullExpressionValue(textView, "defaultTooltipText");
                textView.setText(string);
                m.checkNotNullExpressionValue(iVar, "DefaultTooltipViewTopBin…ext = tooltipText\n      }");
            } else {
                View rootView2 = view.getRootView();
                Objects.requireNonNull(rootView2, "null cannot be cast to non-null type android.view.ViewGroup");
                View viewInflate2 = layoutInflaterFrom.inflate(R$layout.default_tooltip_view_bottom, (ViewGroup) rootView2, false);
                TextView textView2 = (TextView) viewInflate2.findViewById(R$id.default_tooltip_text);
                if (textView2 == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R$id.default_tooltip_text)));
                }
                iVar = new i((ConstraintLayout) viewInflate2, textView2);
                m.checkNotNullExpressionValue(textView2, "defaultTooltipText");
                textView2.setText(string);
                m.checkNotNullExpressionValue(iVar, "DefaultTooltipViewBottom…ext = tooltipText\n      }");
            }
            iVar.getRoot().setOnClickListener(new b.a.v.b(defaultTooltipCreator, tooltipManager$b));
            TooltipManager tooltipManager = defaultTooltipCreator.tooltipManager;
            View root = iVar.getRoot();
            m.checkNotNullExpressionValue(root, "tooltipView.root");
            tooltipManager.d(view, root, tooltipManager$b, floatingViewGravity, 0, iDpToPixels, true, observableG);
        }
    }

    private final void configureUI(WidgetCallFullscreenViewModel$ViewState viewState) {
        if (m.areEqual(viewState, WidgetCallFullscreenViewModel$ViewState$Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetCallFullscreenViewModel$ViewState$Valid) {
            configureValidUI((WidgetCallFullscreenViewModel$ViewState$Valid) viewState);
        }
    }

    private final void configureValidUI(WidgetCallFullscreenViewModel$ViewState$Valid viewState) {
        configureBottomControls(viewState);
        ConstraintLayout constraintLayout = getBinding().a;
        int iOrdinal = viewState.getDisplayMode().ordinal();
        int themedDrawableRes = 2131100225;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                themedDrawableRes = 2131099689;
            }
        } else if (!viewState.isTextInVoiceEnabled()) {
            ConstraintLayout constraintLayout2 = getBinding().a;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            themedDrawableRes = DrawableCompat.getThemedDrawableRes(constraintLayout2, 2130968911, 0);
        }
        constraintLayout.setBackgroundResource(themedDrawableRes);
        int iOrdinal2 = viewState.getDisplayMode().ordinal();
        if (iOrdinal2 == 0) {
            configureGridUi(viewState);
        } else if (iOrdinal2 == 1) {
            configureStageUi(viewState);
        } else {
            if (iOrdinal2 != 2) {
                return;
            }
            configurePrivateCallParticipantsUi(viewState);
        }
    }

    private final void destroyAllRenderers(WidgetCallFullscreenBinding binding) {
        VideoCallParticipantView.d(binding.l, null, null, false, null, false, 30);
        RecyclerView recyclerView = binding.p;
        m.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = binding.p.getChildAt(i);
            if (childAt instanceof VideoCallParticipantView) {
                VideoCallParticipantView.d((VideoCallParticipantView) childAt, null, null, false, null, false, 30);
            }
        }
    }

    private final void enableWakeLock() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        fragmentActivityRequireActivity.getWindow().addFlags(128);
    }

    private final void finishActivity(boolean disconnect, boolean transition) {
        getViewModel().selectTextChannelAfterFinish();
        if (disconnect) {
            getViewModel().disconnect();
        }
        requireActivity().finish();
        if (transition) {
            requireAppActivity().overridePendingTransition(0, R$anim.anim_slide_out_down);
        }
    }

    public static /* synthetic */ void finishActivity$default(WidgetCallFullscreen widgetCallFullscreen, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        widgetCallFullscreen.finishActivity(z2, z3);
    }

    private final WidgetCallFullscreenBinding getBinding() {
        return (WidgetCallFullscreenBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final LazyViewStubDelegate getEventPromptOverlay() {
        return (LazyViewStubDelegate) this.eventPromptOverlay.getValue();
    }

    private final WidgetCallFullscreenViewModel getViewModel() {
        return (WidgetCallFullscreenViewModel) this.viewModel.getValue();
    }

    private final List<VideoCallParticipantView$ParticipantData> getVisibleParticipants(VideoCallGridLayoutManager layoutManager) {
        IntRange intRange = new IntRange(layoutManager.findFirstVisibleItemPosition(), layoutManager.findLastVisibleItemPosition());
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            View childAt = getBinding().p.getChildAt(((c0) it).nextInt());
            arrayList.add(childAt instanceof VideoCallParticipantView ? ((VideoCallParticipantView) childAt).getData() : null);
        }
        return u.filterNotNull(arrayList);
    }

    private final void handleIdleStateChanged(WidgetCallFullscreenViewModel$Event$OnIdleStateChanged event) {
        if (event.isIdle()) {
            BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
            if (bottomSheetBehavior == null) {
                m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
            }
            if (bottomSheetBehavior.getState() == 3) {
                collapseBottomSheet();
            }
        }
    }

    private final void hideControls() {
        ViewExtensions.fadeBy(getBinding().f2248y, false, 200L);
        VideoCallGridAdapter videoCallGridAdapter = this.gridAdapter;
        if (videoCallGridAdapter == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter.notifyCallControlsVisibilityChanged(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        m.checkNotNullExpressionValue(window, "requireActivity().window");
        RecyclerView recyclerView = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        m.checkNotNullParameter(window, "window");
        m.checkNotNullParameter(recyclerView, "view");
        if (Build$VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(true);
        }
        recyclerView.setSystemUiVisibility(5894);
    }

    private final void initializeSystemUiListeners(ViewGroup viewGroup) {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2248y, new WidgetCallFullscreen$initializeSystemUiListeners$1(this));
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, WidgetCallFullscreen$initializeSystemUiListeners$2.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new WidgetCallFullscreen$initializeSystemUiListeners$3(this));
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, WidgetCallFullscreen$initializeSystemUiListeners$4.INSTANCE);
        CoordinatorLayout coordinatorLayout = getBinding().f;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.callControlsSheetContainer");
        ViewExtensions.setForwardingWindowInsetsListener(coordinatorLayout);
        ConstraintLayout constraintLayout = getBinding().i;
        m.checkNotNullExpressionValue(constraintLayout, "binding.callNonVideoContainer");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new WidgetCallFullscreen$initializeSystemUiListeners$5(this));
    }

    private final boolean isPortraitMode() {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return resources.getConfiguration().orientation == 1;
    }

    private final boolean isStageUserVisible(long userId) {
        StoreVoiceParticipants$VoiceUser voiceUser;
        User user;
        RecyclerView recyclerView = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        if (!(recyclerView.getVisibility() == 0)) {
            return false;
        }
        GridLayoutManager gridLayoutManager = this.stageLayoutManager;
        if (gridLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("stageLayoutManager");
        }
        int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition != -1 && iFindLastVisibleItemPosition != -1) {
            StageCallAdapter stageCallAdapter = this.stageAdapter;
            if (stageCallAdapter == null) {
                m.throwUninitializedPropertyAccessException("stageAdapter");
            }
            if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                while (true) {
                    DiffKeyProvider diffKeyProvider = (StageCallItem) stageCallAdapter.getItem(iFindFirstVisibleItemPosition);
                    if (!(diffKeyProvider instanceof StageCallParticipantItem)) {
                        diffKeyProvider = null;
                    }
                    StageCallParticipantItem stageCallParticipantItem = (StageCallParticipantItem) diffKeyProvider;
                    if (stageCallParticipantItem != null && (voiceUser = stageCallParticipantItem.getVoiceUser()) != null && (user = voiceUser.getUser()) != null && user.getId() == userId) {
                        return true;
                    }
                    if (iFindFirstVisibleItemPosition != iFindLastVisibleItemPosition) {
                        iFindFirstVisibleItemPosition++;
                    }
                }
            }
        }
        return false;
    }

    public static final void launch(Context context, long j, boolean z2, String str, AppTransitionActivity$Transition appTransitionActivity$Transition) {
        Companion.launch(context, j, z2, str, appTransitionActivity$Transition);
    }

    private final void onViewBindingDestroy(WidgetCallFullscreenBinding binding) {
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehavior.removeBottomSheetCallback(this.bottomSheetCallback);
        destroyAllRenderers(binding);
    }

    private final void openTextInVoice() {
        transitionActivity();
        getViewModel().onTextInVoiceTapped();
    }

    private final void setUpGridRecycler() {
        VideoCallGridAdapter videoCallGridAdapter = new VideoCallGridAdapter(new WidgetCallFullscreen$setUpGridRecycler$1(this), new WidgetCallFullscreen$setUpGridRecycler$2(this), new WidgetCallFullscreen$setUpGridRecycler$3(this), new WidgetCallFullscreen$setUpGridRecycler$4(getViewModel()), new WidgetCallFullscreen$setUpGridRecycler$5(getViewModel()), 2);
        this.gridAdapter = videoCallGridAdapter;
        if (videoCallGridAdapter == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter.setHasStableIds(true);
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getConfiguration().orientation != 2 ? 1 : 0;
        WidgetCallFullscreen$setUpGridRecycler$layoutManager$1 widgetCallFullscreen$setUpGridRecycler$layoutManager$1 = new WidgetCallFullscreen$setUpGridRecycler$layoutManager$1(this, i);
        WidgetCallFullscreen$setUpGridRecycler$layoutManager$2 widgetCallFullscreen$setUpGridRecycler$layoutManager$2 = new WidgetCallFullscreen$setUpGridRecycler$layoutManager$2(this);
        RecyclerView recyclerView = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "binding.callVideoRecycler.context");
        VideoCallGridLayoutManager videoCallGridLayoutManager = new VideoCallGridLayoutManager(widgetCallFullscreen$setUpGridRecycler$layoutManager$1, 2, widgetCallFullscreen$setUpGridRecycler$layoutManager$2, i, context);
        getBinding().p.addOnScrollListener(new WidgetCallFullscreen$setUpGridRecycler$6(this, videoCallGridLayoutManager));
        getBinding().p.addOnChildAttachStateChangeListener(new WidgetCallFullscreen$setUpGridRecycler$7(this));
        VideoCallGridAdapter videoCallGridAdapter2 = this.gridAdapter;
        if (videoCallGridAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridLayoutManager.setSpanSizeLookup(videoCallGridAdapter2.getSpanSizeLookup());
        RecyclerView recyclerView2 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
        recyclerView2.setLayoutManager(videoCallGridLayoutManager);
        RecyclerView recyclerView3 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView3, "binding.callVideoRecycler");
        recyclerView3.setItemAnimator(null);
        RecyclerView recyclerView4 = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView4, "binding.callVideoRecycler");
        VideoCallGridAdapter videoCallGridAdapter3 = this.gridAdapter;
        if (videoCallGridAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        recyclerView4.setAdapter(videoCallGridAdapter3);
    }

    private final void setUpStageRecycler() {
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.stageAdapter = (StageCallAdapter) mGRecyclerAdapter$Companion.configure(new StageCallAdapter(recyclerView, parentFragmentManager, WidgetCallFullscreen$setUpStageRecycler$1.INSTANCE, new WidgetCallFullscreen$setUpStageRecycler$2(this), new WidgetCallFullscreen$setUpStageRecycler$3(this), new WidgetCallFullscreen$setUpStageRecycler$4(getViewModel()), new WidgetCallFullscreen$setUpStageRecycler$5(getViewModel())));
        RecyclerView recyclerView2 = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callStageRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView2.getContext(), 12);
        StageCallAdapter stageCallAdapter = this.stageAdapter;
        if (stageCallAdapter == null) {
            m.throwUninitializedPropertyAccessException("stageAdapter");
        }
        gridLayoutManager.setSpanSizeLookup(stageCallAdapter.getSpanSizeLookup());
        this.stageLayoutManager = gridLayoutManager;
        RecyclerView recyclerView3 = getBinding().m;
        GridLayoutManager gridLayoutManager2 = this.stageLayoutManager;
        if (gridLayoutManager2 == null) {
            m.throwUninitializedPropertyAccessException("stageLayoutManager");
        }
        recyclerView3.setLayoutManager(gridLayoutManager2);
        StageCallAdapter stageCallAdapter2 = this.stageAdapter;
        if (stageCallAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("stageAdapter");
        }
        recyclerView3.addItemDecoration(stageCallAdapter2.getItemDecoration());
        recyclerView3.addOnScrollListener(this.stageSpeakerPillManagingScrollListener);
    }

    private final void setVoiceControlsSheetPeekHeight() {
        WindowInsetsCompat windowInsetsCompat = this.systemWindowInsets;
        int systemWindowInsetBottom = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetBottom() : 0;
        int peekHeight = getBinding().f2248y.getPeekHeight();
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        int i = systemWindowInsetBottom + peekHeight;
        bottomSheetBehavior.setPeekHeight(i);
        RecyclerView recyclerView = getBinding().m;
        m.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), i);
        ConstraintLayout constraintLayout = getBinding().o;
        m.checkNotNullExpressionValue(constraintLayout, "binding.callStreamingActive");
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), peekHeight);
        LinearLayout linearLayout = getBinding().f2246s.e;
        m.checkNotNullExpressionValue(linearLayout, "binding.privateCall.privateCallContainerContent");
        linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), peekHeight);
    }

    private final void showControls() {
        ViewExtensions.fadeBy(getBinding().f2248y, true, 200L);
        VideoCallGridAdapter videoCallGridAdapter = this.gridAdapter;
        if (videoCallGridAdapter == null) {
            m.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter.notifyCallControlsVisibilityChanged(true);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        m.checkNotNullExpressionValue(window, "requireActivity().window");
        RecyclerView recyclerView = getBinding().p;
        m.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        m.checkNotNullParameter(window, "window");
        m.checkNotNullParameter(recyclerView, "view");
        if (Build$VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(true);
        }
        recyclerView.setSystemUiVisibility(1792);
    }

    private final void showNoScreenSharePermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131893293);
        String string2 = contextRequireContext.getString(2131893279);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_permission_dialog_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVadPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131897020);
        String string2 = contextRequireContext.getString(2131897016);
        m.checkNotNullExpressionValue(string2, "context.getString(R.string.vad_permission_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVideoPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
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
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131896115);
        String string2 = contextRequireContext.getString(2131896118);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ppressed_permission_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void transitionActivity() {
        requireAppActivity().finish();
        requireAppActivity().overridePendingTransition(R$anim.activity_slide_horizontal_open_in, R$anim.activity_slide_horizontal_open_out);
    }

    public final void handleEvent(WidgetCallFullscreenViewModel$Event event) {
        Unit unit;
        m.checkNotNullParameter(event, "event");
        if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowSuppressedDialog.INSTANCE)) {
            showSuppressedDialog();
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowServerMutedDialog.INSTANCE)) {
            showServerMutedDialog();
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowServerDeafenedDialog.INSTANCE)) {
            showServerDeafenedDialog();
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowNoVideoPermissionDialog.INSTANCE)) {
            showNoVideoPermissionDialog();
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowNoVadPermissionDialog.INSTANCE)) {
            showNoVadPermissionDialog();
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            m$a m_a = b.a.a.m.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            m_a.a(parentFragmentManager);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog) {
            j$a j_a = b.a.a.j.k;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            j_a.a(parentFragmentManager2, ((WidgetCallFullscreenViewModel$Event$ShowCameraCapacityDialog) event).getGuildMaxVideoChannelUsers());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$ShowUserSheet) {
            WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
            WidgetCallFullscreenViewModel$Event$ShowUserSheet widgetCallFullscreenViewModel$Event$ShowUserSheet = (WidgetCallFullscreenViewModel$Event$ShowUserSheet) event;
            long userId = widgetCallFullscreenViewModel$Event$ShowUserSheet.getUserId();
            Long lValueOf = Long.valueOf(widgetCallFullscreenViewModel$Event$ShowUserSheet.getChannelId());
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, userId, lValueOf, parentFragmentManager3, null, Boolean.TRUE, WidgetUserSheet$StreamPreviewClickBehavior.TARGET_AND_DISMISS, null, 72, null);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$ShowRequestCameraPermissionsDialog) {
            requestVideoCallPermissions(new WidgetCallFullscreen$handleEvent$1(this));
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            String string = getString(((WidgetCallFullscreenViewModel$Event$AccessibilityAnnouncement) event).getMessageResId());
            m.checkNotNullExpressionValue(string, "getString(event.messageResId)");
            accessibilityUtils.sendAnnouncement(contextRequireContext, string);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet) {
            WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet = (WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet) event;
            StreamFeedbackSheetNavigator.INSTANCE.enqueueNotice(widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.getStreamKey(), widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.getMediaSessionId(), widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.getTriggerRateDenominator());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet) {
            WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet = (WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet) event;
            CallFeedbackSheetNavigator.INSTANCE.enqueueNotice(widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.getChannelId(), widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.getRtcConnectionId(), widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.getMediaSessionId(), Long.valueOf(widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.getCallDuration()), widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.getTriggerRateDenominator());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$ShowNoScreenSharePermissionDialog) {
            showNoScreenSharePermissionDialog();
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$RequestStartStream.INSTANCE)) {
            BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
            if (bottomSheetBehavior == null) {
                m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
            }
            bottomSheetBehavior.setState(4);
            StreamNavigator.requestStartStream(this);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$OnIdleStateChanged) {
            handleIdleStateChanged((WidgetCallFullscreenViewModel$Event$OnIdleStateChanged) event);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel$Event$NavigateToPremiumSettings) {
            WidgetSettingsPremium$Companion.launch$default(WidgetSettingsPremium.Companion, requireContext(), null, null, 6, null);
            unit = Unit.a;
        } else if (m.areEqual(event, WidgetCallFullscreenViewModel$Event$ShowActivitiesDesktopOnlyDialog.INSTANCE)) {
            FragmentManager parentFragmentManager4 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
            Context contextRequireContext2 = requireContext();
            m.checkNotNullParameter(parentFragmentManager4, "fragmentManager");
            m.checkNotNullParameter(contextRequireContext2, "context");
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
            String string2 = contextRequireContext2.getString(2131888676);
            String string3 = contextRequireContext2.getString(2131888675);
            m.checkNotNullExpressionValue(string3, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager4, string2, string3, contextRequireContext2.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else {
            if (!(event instanceof WidgetCallFullscreenViewModel$Event$ShowTextInVoiceNux)) {
                throw new NoWhenBranchMatchedException();
            }
            new TextInVoiceOnboardingManager().show(new WidgetCallFullscreen$handleEvent$2(this));
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        StreamNavigator.handleActivityResult(requestCode, resultCode, data, new WidgetCallFullscreen$onActivityResult$1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        m.checkNotNullExpressionValue(window, "requireActivity().window");
        m.checkNotNullParameter(window, "window");
        if (Build$VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        getViewModel().setTargetChannelId(getChannelId());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.connectedTimerSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetGlobalStatusIndicatorState.updateState$default(WidgetGlobalStatusIndicatorState.Provider.get(), false, false, false, 3, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewGroup viewGroup = (ViewGroup) view;
        initializeSystemUiListeners(viewGroup);
        Context context = viewGroup.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        setActionBarDisplayHomeAsUpEnabled(true, Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(context, 2130969456, 0, 2, (Object) null)), 2131888557);
        AppTransitionActivity$a appTransitionActivity$a = requireAppActivity().k;
        setUpGridRecycler();
        setUpStageRecycler();
        ViewCompat.setAccessibilityDelegate(view, new WidgetCallFullscreen$onViewBound$1(this));
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f2248y);
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…g.voiceControlsSheetView)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehaviorFrom.setGestureInsetBottomIgnored(true);
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
        VoiceControlsSheetView voiceControlsSheetView = getBinding().f2248y;
        m.checkNotNullExpressionValue(voiceControlsSheetView, "binding.voiceControlsSheetView");
        ViewExtensions.addOnHeightChangedListener(voiceControlsSheetView, new WidgetCallFullscreen$onViewBound$2(this));
        OnPressListener onPressListener = new OnPressListener(new WidgetCallFullscreen$onViewBound$listener$1(getViewModel()));
        getBinding().g.setOnTouchListener(onPressListener);
        getBinding().f2248y.setOnPTTListener(onPressListener);
        Channel channel = StoreStream.Companion.getChannels().getChannel(getChannelId());
        if (channel != null && ChannelUtils.D(channel)) {
            requireAppActivity().k = AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE.getAnimations();
        }
        if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONNECT_ON_LAUNCH, false)) {
            if (channel == null || !ChannelUtils.D(channel)) {
                requestMicrophone(new WidgetCallFullscreen$onViewBound$3(this, channel), new WidgetCallFullscreen$onViewBound$4(this));
            } else {
                getViewModel().tryConnectToVoice();
            }
        }
        AppFragment.setOnBackPressed$default(this, new WidgetCallFullscreen$onViewBound$5(this, channel), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetGlobalStatusIndicatorState.updateState$default(WidgetGlobalStatusIndicatorState.Provider.get(), false, false, true, 3, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetCallFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCallFullscreen$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetCallFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCallFullscreen$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
