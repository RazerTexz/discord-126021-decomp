package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.a.CameraCapacityDialog;
import b.a.a.GuildVideoAtCapacityDialog;
import b.a.a.f.a.AudioOutputSelectionDialog;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.DefaultTooltipViewBottomBinding;
import b.a.i.DefaultTooltipViewTopBinding;
import b.a.j.FloatingViewManager;
import b.a.k.FormatUtils;
import b.a.v.AcknowledgedTooltipsCache;
import b.a.v.DefaultTooltipCreator2;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetCallFullscreenBinding;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.tooltips.DefaultTooltipCreator;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.VoiceViewUtils;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.views.calls.StageCallVisitCommunityView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VoiceCallActiveEventView;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.channels.TextInVoiceOnboardingManager;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.guildscheduledevent.GuildEventPromptListView;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageCallModel;
import com.discord.widgets.stage.model.StageCallModel5;
import com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.controls.VoiceControlsOutputSelectorState;
import com.discord.widgets.voice.controls.VoiceControlsSheetSwipeTooltip;
import com.discord.widgets.voice.controls.VoiceControlsSheetView;
import com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetNavigator;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetNavigator;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridLayoutManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallAdapter;
import com.discord.widgets.voice.fullscreen.stage.StageCallBottomSheetManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem2;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet;
import com.discord.widgets.voice.stream.StreamNavigator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCallFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallFullscreenBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String END_EVENT_REQUEST_KEY = "END_EVENT_REQUEST_KEY";
    private static final String END_STAGE_REQUEST_KEY = "END_STAGE_REQUEST_KEY";
    private static final String INTENT_EXTRA_CONNECT_ON_LAUNCH = "INTENT_EXTRA_CONNECT_ON_LAUNCH";
    public static final int MAX_SPEAKERS_PER_ROW = 3;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior;
    private final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private Subscription connectedTimerSubscription;
    private final DefaultTooltipCreator defaultTooltipCreator;

    /* JADX INFO: renamed from: eventPromptOverlay$delegate, reason: from kotlin metadata */
    private final Lazy eventPromptOverlay;
    private VideoCallGridAdapter gridAdapter;
    private boolean hasVideoCallGridChildrenChanged;
    private Integer lastMentionsCount;
    private Set<? extends WidgetCallFullscreenViewModel.MenuItem> lastMenuItems;
    private Integer lastUnreadsCount;
    private StageCallAdapter stageAdapter;
    private final StageCallBottomSheetManager stageCallBottomSheetManager;
    private GridLayoutManager stageLayoutManager;
    private final WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1 stageSpeakerPillManagingScrollListener;
    private WindowInsetsCompat systemWindowInsets;
    private final TooltipManager tooltipManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, boolean z2, String str, AppTransitionActivity.Transition transition, int i, Object obj) {
            companion.launch(context, j, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : transition);
        }

        public final int getUnreadIndicatorMarginDp(Resources resources) {
            Intrinsics3.checkNotNullParameter(resources, "resources");
            if (resources.getConfiguration().orientation != 2) {
                return DeviceUtils.INSTANCE.isTablet(resources) ? 36 : 32;
            }
            return DeviceUtils.INSTANCE.isTablet(resources) ? 36 : 28;
        }

        public final int getUnreadIndicatorMarginLeftDp(Resources resources) {
            Intrinsics3.checkNotNullParameter(resources, "resources");
            if (resources.getConfiguration().orientation != 2) {
                if (DeviceUtils.INSTANCE.isTablet(resources)) {
                    return 40;
                }
            } else if (DeviceUtils.INSTANCE.isTablet(resources)) {
                return 40;
            }
            return 32;
        }

        public final void launch(Context context, long channelId, boolean connectOnLaunch, String streamKey, AppTransitionActivity.Transition transition) {
            ActivityOptionsCompat activityOptions;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AppActivity.Call.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_STREAM_KEY", streamKey);
            intent.putExtra(WidgetCallFullscreen.INTENT_EXTRA_CONNECT_ON_LAUNCH, connectOnLaunch);
            context.startActivity(intent, (transition == null || (activityOptions = transition.toActivityOptions(context)) == null) ? null : activityOptions.toBundle());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetCallFullscreenViewModel.DisplayMode.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            WidgetCallFullscreenViewModel.DisplayMode displayMode = WidgetCallFullscreenViewModel.DisplayMode.STAGE;
            iArr[displayMode.ordinal()] = 1;
            WidgetCallFullscreenViewModel.DisplayMode displayMode2 = WidgetCallFullscreenViewModel.DisplayMode.GRID;
            iArr[displayMode2.ordinal()] = 2;
            WidgetCallFullscreenViewModel.DisplayMode.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[displayMode.ordinal()] = 1;
            iArr2[displayMode2.ordinal()] = 2;
            iArr2[WidgetCallFullscreenViewModel.DisplayMode.PRIVATE_CALL_PARTICIPANTS.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GuildScheduledEvent guildScheduledEventToEndForCall$default;
            long channelId = WidgetCallFullscreen.this.getChannelId();
            if (StageChannelUtils.shouldShowEndStageBottomSheet$default(StageChannelUtils.INSTANCE, channelId, null, null, null, null, 30, null)) {
                WidgetEndStageBottomSheet.Companion companion = WidgetEndStageBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetCallFullscreen.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetCallFullscreen.END_STAGE_REQUEST_KEY, channelId);
                return;
            }
            if (!ChannelUtils.J(this.$viewState.getCallModel().getChannel()) || (guildScheduledEventToEndForCall$default = GuildScheduledEventUtilities.Companion.getGuildScheduledEventToEndForCall$default(GuildScheduledEventUtilities.INSTANCE, this.$viewState.getCallModel(), this.$viewState.getChannelPermissions(), null, 4, null)) == null) {
                WidgetCallFullscreen.finishActivity$default(WidgetCallFullscreen.this, false, this.$viewState.isTextInVoiceEnabled(), 1, null);
                return;
            }
            WidgetEndGuildScheduledEventBottomSheet.Companion companion2 = WidgetEndGuildScheduledEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetCallFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2, WidgetCallFullscreen.END_EVENT_REQUEST_KEY, guildScheduledEventToEndForCall$default.getGuildId(), guildScheduledEventToEndForCall$default.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$10, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass10 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StageRoles stageRolesM72getStageRolestwRsX0 = this.$viewState.m72getStageRolestwRsX0();
            if (stageRolesM72getStageRolestwRsX0 == null || !StageRoles.m32isModeratorimpl(stageRolesM72getStageRolestwRsX0.m35unboximpl())) {
                WidgetCallFullscreen.this.getViewModel().toggleRequestToSpeak();
                return;
            }
            WidgetStageRaisedHandsBottomSheet.Companion companion = WidgetStageRaisedHandsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetCallFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetCallFullscreen.this.getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$11, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass11 extends Lambda implements Function0<Unit> {
        public AnonymousClass11() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.getViewModel().moveMeToAudience();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.getViewModel().requestStopWatchingStreamFromUserInput();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AudioOutputSelectionDialog.Companion bVar = AudioOutputSelectionDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetCallFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Objects.requireNonNull(bVar);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            new AudioOutputSelectionDialog().show(parentFragmentManager, AudioOutputSelectionDialog.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetCallFullscreen.this.getViewModel().toggleCameraPressed();
            }
        }

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.requestVideoCallPermissions(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public AnonymousClass5() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.getViewModel().onMuteClicked();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetScreenShareNfxSheet.Companion companion = WidgetScreenShareNfxSheet.INSTANCE;
            if (!companion.canShow()) {
                WidgetCallFullscreen.this.getViewModel().onScreenShareClick();
                return;
            }
            FragmentManager parentFragmentManager = WidgetCallFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetScreenShareNfxSheet.Companion.show$default(companion, parentFragmentManager, WidgetCallFullscreen.this.getChannelId(), this.$viewState.getCallModel().getChannel().getGuildId(), null, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$7, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass7 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetCallFullscreen.this, this.$viewState.getCallModel().getChannel(), "Voice Call", (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$8, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass8 extends Lambda implements Function2<Float, Boolean, Unit> {
        public AnonymousClass8() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Float f, Boolean bool) {
            invoke(f.floatValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(float f, boolean z2) {
            WidgetCallFullscreen.this.getViewModel().onStreamPerceptualVolumeChanged(f, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureBottomControls$9, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass9 extends Lambda implements Function0<Unit> {
        public AnonymousClass9() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.getViewModel().onDeafenPressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureConnectionStatusText$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ CallModel $callModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CallModel callModel) {
            super(1);
            this.$callModel = callModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            TextView textView = WidgetCallFullscreen.this.getBinding().f2246s.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.privateCall.privateCallStatusDuration");
            textView.setText(TimeUtils.toFriendlyString$default(TimeUtils.INSTANCE, this.$callModel.getTimeConnectedMs(), 0L, null, null, 14, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureConnectionStatusText$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetCallFullscreen.this.connectedTimerSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureGridUi$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.finishActivity$default(WidgetCallFullscreen.this, false, this.$viewState.isTextInVoiceEnabled(), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureStageUi$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureStageUi$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                Typeface themedFont = FontUtils.INSTANCE.getThemedFont(WidgetCallFullscreen.this.requireContext(), R.attr.font_primary_semibold);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(WidgetCallFullscreen.this.getContext(), R.attr.primary_000)));
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("usernameHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureStageUi$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(WidgetCallFullscreenViewModel.ViewState.Valid valid) {
            super(0);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.finishActivity$default(WidgetCallFullscreen.this, false, this.$viewState.isTextInVoiceEnabled(), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$handleEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.getViewModel().onCameraPermissionsGranted();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$handleEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.openTextInVoice();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$onActivityResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Intent, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
            invoke2(intent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "it");
            WidgetCallFullscreen.this.getViewModel().startScreenShare(intent);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Integer, Integer, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            WidgetCallFullscreen.this.setVoiceControlsSheetPeekHeight();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Channel channel) {
            super(0);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppToast.g(WidgetCallFullscreen.this.getContext(), R.string.permission_microphone_denied, 0, null, 12);
            WidgetCallFullscreen widgetCallFullscreen = WidgetCallFullscreen.this;
            TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.INSTANCE.getINSTANCE();
            Channel channel = this.$channel;
            WidgetCallFullscreen.finishActivity$default(widgetCallFullscreen, false, instance.isEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.this.getViewModel().tryConnectToVoice();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetCallFullscreenViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetCallFullscreen widgetCallFullscreen) {
            super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallFullscreenViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetCallFullscreen) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetCallFullscreenViewModel.Event, Unit> {
        public AnonymousClass2(WidgetCallFullscreen widgetCallFullscreen) {
            super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallFullscreenViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallFullscreenViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetCallFullscreen) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpGridRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<CallParticipant, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallParticipant callParticipant) {
            invoke2(callParticipant);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallParticipant callParticipant) {
            Intrinsics3.checkNotNullParameter(callParticipant, "it");
            WidgetCallFullscreen.this.getViewModel().onGridParticipantTapped(callParticipant);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpGridRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<CallParticipant, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallParticipant callParticipant) {
            invoke2(callParticipant);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallParticipant callParticipant) {
            Intrinsics3.checkNotNullParameter(callParticipant, "it");
            WidgetCallFullscreen.this.getViewModel().onGridParticipantLongPressed(callParticipant);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpGridRecycler$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetCallFullscreen.this.getViewModel().targetAndFocusStream(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpGridRecycler$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> {
        public AnonymousClass4(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
            super(2, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onStreamQualityIndicatorShown", "onStreamQualityIndicatorShown(Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            invoke2(streamResolution, streamFps);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            Intrinsics3.checkNotNullParameter(streamResolution, "p1");
            ((WidgetCallFullscreenViewModel) this.receiver).onStreamQualityIndicatorShown(streamResolution, streamFps);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpGridRecycler$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> {
        public AnonymousClass5(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
            super(2, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onStreamQualityIndicatorClicked", "onStreamQualityIndicatorClicked(Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            invoke2(streamResolution, streamFps);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            Intrinsics3.checkNotNullParameter(streamResolution, "p1");
            ((WidgetCallFullscreenViewModel) this.receiver).onStreamQualityIndicatorClicked(streamResolution, streamFps);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpStageRecycler$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<CallParticipant.UserOrStreamParticipant, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            invoke2(userOrStreamParticipant);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            Intrinsics3.checkNotNullParameter(userOrStreamParticipant, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpStageRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<CallParticipant.UserOrStreamParticipant, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            invoke2(userOrStreamParticipant);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
            Intrinsics3.checkNotNullParameter(userOrStreamParticipant, "it");
            WidgetCallFullscreen.this.getViewModel().onGridParticipantLongPressed(userOrStreamParticipant);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpStageRecycler$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetCallFullscreen.this.getViewModel().targetAndFocusStream(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpStageRecycler$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> {
        public AnonymousClass4(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
            super(2, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onStreamQualityIndicatorShown", "onStreamQualityIndicatorShown(Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            invoke2(streamResolution, streamFps);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            Intrinsics3.checkNotNullParameter(streamResolution, "p1");
            ((WidgetCallFullscreenViewModel) this.receiver).onStreamQualityIndicatorShown(streamResolution, streamFps);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$setUpStageRecycler$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> {
        public AnonymousClass5(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
            super(2, widgetCallFullscreenViewModel, WidgetCallFullscreenViewModel.class, "onStreamQualityIndicatorClicked", "onStreamQualityIndicatorClicked(Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            invoke2(streamResolution, streamFps);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoCallParticipantView.StreamResolution streamResolution, VideoCallParticipantView.StreamFps streamFps) {
            Intrinsics3.checkNotNullParameter(streamResolution, "p1");
            ((WidgetCallFullscreenViewModel) this.receiver).onStreamQualityIndicatorClicked(streamResolution, streamFps);
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1] */
    public WidgetCallFullscreen() {
        super(R.layout.widget_call_fullscreen);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetCallFullscreen$binding$2.INSTANCE, new WidgetCallFullscreen$binding$3(this));
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$bottomSheetCallback$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
                this.this$0.getViewModel().stopIdle();
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
                this.this$0.getBinding().f2248y.handleSheetState(newState);
                this.this$0.getViewModel().handleBottomSheetState(newState);
                if (newState == 3) {
                    this.this$0.getViewModel().stopIdle();
                    this.this$0.tooltipManager.a(VoiceControlsSheetSwipeTooltip.INSTANCE);
                } else {
                    if (newState != 4) {
                        return;
                    }
                    this.this$0.getViewModel().startIdle();
                }
            }
        };
        WidgetCallFullscreen$viewModel$2 widgetCallFullscreen$viewModel$2 = new WidgetCallFullscreen$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetCallFullscreenViewModel.class), new WidgetCallFullscreen$appViewModels$$inlined$viewModels$1(new AppViewModelDelegates3(this)), new AppViewModelDelegates5(widgetCallFullscreen$viewModel$2));
        this.stageSpeakerPillManagingScrollListener = new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1
            private List<StoreVoiceParticipants.VoiceUser> activeSpeakers = Collections2.emptyList();

            public final List<StoreVoiceParticipants.VoiceUser> getActiveSpeakers() {
                return this.activeSpeakers;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
                List<StoreVoiceParticipants.VoiceUser> list = this.activeSpeakers;
                boolean z2 = true;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                    } while (!(!this.this$0.isStageUserVisible(((StoreVoiceParticipants.VoiceUser) it.next()).getUser().getId())));
                } else {
                    z2 = false;
                    break;
                }
                ConstraintLayout constraintLayout = this.this$0.getBinding().t;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
                constraintLayout.setVisibility(z2 ? 0 : 8);
            }

            public final void setActiveSpeakers(List<StoreVoiceParticipants.VoiceUser> list) {
                Intrinsics3.checkNotNullParameter(list, "<set-?>");
                this.activeSpeakers = list;
            }
        };
        AppLog appLog = AppLog.g;
        Intrinsics3.checkNotNullParameter(appLog, "logger");
        WeakReference<FloatingViewManager> weakReference = FloatingViewManager.b.a;
        FloatingViewManager floatingViewManager = weakReference != null ? weakReference.get() : null;
        if (floatingViewManager == null) {
            floatingViewManager = new FloatingViewManager(appLog);
            FloatingViewManager.b.a = new WeakReference<>(floatingViewManager);
        }
        FloatingViewManager floatingViewManager2 = floatingViewManager;
        TooltipManager.a aVar = TooltipManager.a.d;
        Intrinsics3.checkNotNullParameter(floatingViewManager2, "floatingViewManager");
        WeakReference<TooltipManager> weakReference2 = TooltipManager.a.a;
        TooltipManager tooltipManager = weakReference2 != null ? weakReference2.get() : null;
        if (tooltipManager == null) {
            tooltipManager = new TooltipManager((AcknowledgedTooltipsCache) TooltipManager.a.f2815b.getValue(), (Set) TooltipManager.a.c.getValue(), 0, floatingViewManager2, 4);
            TooltipManager.a.a = new WeakReference<>(tooltipManager);
        }
        this.tooltipManager = tooltipManager;
        this.defaultTooltipCreator = new DefaultTooltipCreator(tooltipManager);
        this.stageCallBottomSheetManager = new StageCallBottomSheetManager();
        this.eventPromptOverlay = LazyViewStubDelegate.INSTANCE.lazyViewStub(new WidgetCallFullscreen$eventPromptOverlay$2(this));
    }

    public static final /* synthetic */ VideoCallGridAdapter access$getGridAdapter$p(WidgetCallFullscreen widgetCallFullscreen) {
        VideoCallGridAdapter videoCallGridAdapter = widgetCallFullscreen.gridAdapter;
        if (videoCallGridAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        return videoCallGridAdapter;
    }

    private final void collapseBottomSheet() {
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehavior.setState(4);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0164  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:81:0x0213  */
    private final void configureActionBar(final WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
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
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getTotalMentionsCount()));
        Toolbar toolbar = getBinding().f2245b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        Context contextRequireContext = requireContext();
        if (!viewState.isTextInVoiceEnabled() && viewState.getDisplayMode() != WidgetCallFullscreenViewModel.DisplayMode.STAGE && z7) {
            i = R.drawable.ic_call_toolbar_icon_minimize_cutout;
        } else if (viewState.isTextInVoiceEnabled() || viewState.getDisplayMode() == WidgetCallFullscreenViewModel.DisplayMode.STAGE) {
            i = z7 ? R.drawable.ic_call_toolbar_stage_minimize_cutout_dark : R.drawable.ic_call_toolbar_stage_minimize_dark;
        } else {
            i = R.drawable.ic_call_toolbar_icon_minimize;
        }
        toolbar.setNavigationIcon(ContextCompat.getDrawable(contextRequireContext, i));
        getBinding().f2245b.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureActionBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFullscreen.this.finishActivity(false, viewState.isTextInVoiceEnabled());
            }
        });
        CallEventsButtonView callEventsButtonView = getBinding().w;
        Guild guild = viewState.getCallModel().getGuild();
        if (guild == null || viewState.getStageCallModel() == null || viewState.getStageCallModel().isLurking()) {
            zHasLiveEvent = false;
        } else {
            zHasLiveEvent = viewState.getCallModel().canManageEvent() ? true : GuildScheduledEventUtilities5.hasLiveEvent(viewState.getCallModel().getGuildScheduledEvents());
        }
        callEventsButtonView.setVisibility(zHasLiveEvent ? 0 : 8);
        if (guild != null && zHasLiveEvent) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            callEventsButtonView.a(parentFragmentManager, guild.getId(), getChannelId(), viewState.getCallModel().getGuildScheduledEvents());
        }
        VoiceCallActiveEventView voiceCallActiveEventView = getBinding().f2247x;
        Intrinsics3.checkNotNullExpressionValue(voiceCallActiveEventView, "binding.toolbarVoiceActiveEvent");
        if (viewState.getStageCallModel() != null) {
            z2 = false;
        } else {
            final GuildScheduledEvent activeEvent = viewState.getActiveEvent();
            if (activeEvent != null) {
                VoiceCallActiveEventView voiceCallActiveEventView2 = getBinding().f2247x;
                Channel channel = viewState.getCallModel().getChannel();
                Objects.requireNonNull(voiceCallActiveEventView2);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(activeEvent, "guildScheduledEvent");
                TextView textView2 = voiceCallActiveEventView2.binding.f135b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelName");
                textView2.setText(channel.getName());
                TextView textView3 = voiceCallActiveEventView2.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.eventName");
                textView3.setText(activeEvent.getName());
                voiceCallActiveEventView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
                        FragmentManager parentFragmentManager2 = this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                        companion.showForGuild(parentFragmentManager2, activeEvent.getId());
                    }
                });
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
        Intrinsics3.checkNotNullExpressionValue(stageCallVisitCommunityView, "binding.callVisitCommunity");
        StageCallModel stageCallModel = viewState.getStageCallModel();
        if (stageCallModel == null || !stageCallModel.isLurking()) {
            z3 = false;
        } else {
            final Guild guild2 = viewState.getStageCallModel().getGuild();
            if (guild2 != null) {
                StageCallVisitCommunityView stageCallVisitCommunityView2 = getBinding().q;
                Objects.requireNonNull(stageCallVisitCommunityView2);
                Intrinsics3.checkNotNullParameter(guild2, "guild");
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
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.visitCommunityIcon");
                SimpleDraweeViewExtensions.setGuildIcon(simpleDraweeView, true, (496 & 2) != 0 ? null : guild2, stageCallVisitCommunityView2.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius), (496 & 8) != 0 ? null : Integer.valueOf(IconUtils.getMediaProxySize(stageCallVisitCommunityView2.getResources().getDimensionPixelSize(R.dimen.avatar_size_medium))), (496 & 16) != 0 ? null : null, (496 & 32) != 0 ? null : null, (496 & 64) != 0 ? null : null, (496 & 128) != 0 ? false : false, (496 & 256) != 0 ? null : null);
                TextView textView4 = stageCallVisitCommunityView2.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.visitCommunityIconText");
                textView4.setText(z5 ? null : guild2.getShortName());
                stageCallVisitCommunityView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OnBackPressedDispatcher onBackPressedDispatcher;
                        this.getViewModel().onVisitCommunityButtonClicked(guild2.getId());
                        AppActivity appActivity = this.getAppActivity();
                        if (appActivity == null || (onBackPressedDispatcher = appActivity.getOnBackPressedDispatcher()) == null) {
                            return;
                        }
                        onBackPressedDispatcher.onBackPressed();
                    }
                });
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
        int color = ColorCompat.getColor(this, R.color.transparent);
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
    private final void configureBottomControls(WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        boolean z2;
        VoiceControlsSheetView voiceControlsSheetView = getBinding().f2248y;
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetView, "binding.voiceControlsSheetView");
        voiceControlsSheetView.setVisibility(0);
        VoiceControlsSheetView voiceControlsSheetView2 = getBinding().f2248y;
        CallModel callModel = viewState.getCallModel();
        VoiceControlsOutputSelectorState outputSelectorState = viewState.getOutputSelectorState();
        boolean z3 = viewState.getCameraState() != CameraState.CAMERA_DISABLED;
        boolean zIsPushToTalk = viewState.getIsPushToTalk();
        boolean zIsDeafened = viewState.getIsDeafened();
        boolean startedAsVideo = viewState.getStartedAsVideo();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(viewState);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        voiceControlsSheetView2.m64configureUI3jxq49Y(callModel, outputSelectorState, z3, zIsPushToTalk, zIsDeafened, startedAsVideo, viewState.getIsStreamFocused(), !viewState.getIsStreamFocused(), anonymousClass2, anonymousClass1, anonymousClass3, anonymousClass4, new AnonymousClass5(), new AnonymousClass7(viewState), new AnonymousClass6(viewState), viewState.getShowStreamVolume(), viewState.getPerceptualStreamVolume(), new AnonymousClass8(), new AnonymousClass9(), viewState.getRequestingToSpeakCount(), new AnonymousClass10(viewState), new AnonymousClass11(), viewState.isUpdatingRequestToSpeak(), viewState.m72getStageRolestwRsX0());
        configureSwipeTooltip(viewState.getStageCallModel() == null && viewState.getShowFooter());
        if (!viewState.getIsVideoCallGridVisible()) {
            VoiceControlsSheetView voiceControlsSheetView3 = getBinding().f2248y;
            Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetView3, "binding.voiceControlsSheetView");
            ViewExtensions.cancelFadeAnimations(voiceControlsSheetView3);
            VoiceControlsSheetView voiceControlsSheetView4 = getBinding().f2248y;
            Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetView4, "binding.voiceControlsSheetView");
            voiceControlsSheetView4.setAlpha(1.0f);
        } else if (viewState.getShowFooter()) {
            showControls();
        } else {
            hideControls();
        }
        MaterialButton materialButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.callFloatingPushToTalk");
        if (viewState.getIsPushToTalk()) {
            VoiceControlsSheetView voiceControlsSheetView5 = getBinding().f2248y;
            Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetView5, "binding.voiceControlsSheetView");
            z2 = voiceControlsSheetView5.getVisibility() == 0 ? false : true;
        }
        materialButton.setVisibility(z2 ? 0 : 8);
    }

    private final void configureConnectionStatusText(CallModel callModel) {
        Subscription subscription = this.connectedTimerSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n          .in…0L, 1L, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableE, this, null, 2, null), (Class<?>) WidgetCallFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(callModel));
        }
    }

    private final void configureEventPrompt(WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        Guild guild = viewState.getCallModel().getGuild();
        WidgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 widgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 = new WidgetCallFullscreen$configureEventPrompt$onCreateEventClick$1(this, guild);
        GuildScheduledEvent startableEvent = viewState.getStartableEvent();
        WidgetCallFullscreen$configureEventPrompt$onStartEvent$1 widgetCallFullscreen$configureEventPrompt$onStartEvent$1 = new WidgetCallFullscreen$configureEventPrompt$onStartEvent$1(this, startableEvent);
        WidgetCallFullscreen$configureEventPrompt$onStartStage$1 widgetCallFullscreen$configureEventPrompt$onStartStage$1 = new WidgetCallFullscreen$configureEventPrompt$onStartStage$1(this);
        GuildEventPromptListView guildEventPromptListView = (GuildEventPromptListView) getEventPromptOverlay().getMaybeView();
        if (guildEventPromptListView != null) {
            GuildEventPromptListView.ScheduledEventData scheduledEventData = (startableEvent != null && GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(viewState.getCallModel().getChannel(), viewState.getChannelPermissions())) ? new GuildEventPromptListView.ScheduledEventData(startableEvent, widgetCallFullscreen$configureEventPrompt$onStartEvent$1) : null;
            if (guild == null || viewState.getStageCallModel() == null || !PermissionUtils.can(Permission.START_STAGE_EVENT, viewState.getChannelPermissions())) {
                widgetCallFullscreen$configureEventPrompt$onCreateEventClick$1 = null;
            }
            if (viewState.getStageCallModel() == null || !StageRoles.m32isModeratorimpl(viewState.getStageCallModel().m42getMyStageRoles1LxfuJo())) {
                widgetCallFullscreen$configureEventPrompt$onStartStage$1 = null;
            }
            guildEventPromptListView.configure(scheduledEventData, widgetCallFullscreen$configureEventPrompt$onCreateEventClick$1, widgetCallFullscreen$configureEventPrompt$onStartStage$1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x019c  */
    private final void configureGridUi(WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        boolean z2;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        fragmentActivityRequireActivity.setRequestedOrientation(-1);
        RelativeLayout relativeLayout = getBinding().f2246s.d;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.privateCall.privateCallContainer");
        relativeLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        recyclerView.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(8);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureGridUi.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFullscreen.this.getViewModel().onEmptyStateTapped();
            }
        });
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.callParticipantsHidden");
        linearLayout.setVisibility(viewState.getShowParticipantsHiddenView() ? 0 : 8);
        getBinding().o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureGridUi.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFullscreen.this.getViewModel().onEmptyStateTapped();
            }
        });
        ConstraintLayout constraintLayout2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.callStreamingActive");
        constraintLayout2.setVisibility(viewState.getCallModel().isStreaming() ? 0 : 8);
        MaterialButton materialButton = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.callStopStreamingButton");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        materialButton.setVisibility(resources.getConfiguration().orientation != 2 ? 0 : 8);
        getBinding().n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureGridUi.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFullscreen.this.getViewModel().stopScreenShare();
            }
        });
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureGridUi.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFullscreen.this.getViewModel().onShowParticipantsPressed();
            }
        });
        RecyclerView recyclerView2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
        boolean z3 = recyclerView2.getVisibility() == 0;
        if (viewState.getIsVideoCallGridVisible() != z3) {
            RecyclerView recyclerView3 = getBinding().p;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.callVideoRecycler");
            recyclerView3.setVisibility(viewState.getIsVideoCallGridVisible() ? 0 : 8);
            if (viewState.getIsVideoCallGridVisible() && !z3) {
                RecyclerView recyclerView4 = getBinding().p;
                Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.callVideoRecycler");
                recyclerView4.setVisibility(viewState.getIsVideoCallGridVisible() ? 0 : 8);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(250L);
                getBinding().p.startAnimation(alphaAnimation);
            }
        }
        VideoCallParticipantView videoCallParticipantView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "binding.callPip");
        videoCallParticipantView.setVisibility(viewState.getPipParticipant() != null ? 0 : 8);
        VideoCallParticipantView videoCallParticipantView2 = getBinding().l;
        CallParticipant.UserOrStreamParticipant pipParticipant = viewState.getPipParticipant();
        VideoCallParticipantView.d(videoCallParticipantView2, pipParticipant != null ? pipParticipant.getParticipantData() : null, null, false, null, false, 30);
        View view = getBinding().e.f181b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.audioShare.callStreamingAudioShareWarning");
        if (VoiceViewUtils.INSTANCE.getIsSoundshareSupported()) {
            z2 = false;
        } else {
            VideoCallParticipantView videoCallParticipantView3 = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView3, "binding.callPip");
            if (videoCallParticipantView3.getVisibility() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        view.setVisibility(z2 ? 0 : 8);
        VideoCallGridAdapter videoCallGridAdapter = this.gridAdapter;
        if (videoCallGridAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        boolean z4 = videoCallGridAdapter.getPageSize() == 1;
        boolean z5 = viewState.getVisibleVideoParticipants().size() == 1;
        VideoCallGridAdapter videoCallGridAdapter2 = this.gridAdapter;
        if (videoCallGridAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter2.setData(viewState.getVisibleVideoParticipants());
        if (z4 && !z5) {
            getBinding().p.scrollToPosition(0);
        }
        configureMenu(viewState);
        configureActionBar(viewState);
        if ((viewState.getStartableEvent() == null || GuildScheduledEventUtilities5.hasLiveEvent(viewState.getCallModel().getGuildScheduledEvents())) ? false : true) {
            ViewExtensions.fadeBy(getEventPromptOverlay().getForceInitializedView(), viewState.getShowFooter(), 200L);
            if (viewState.getShowFooter()) {
                configureEventPrompt(viewState);
            }
        } else {
            getEventPromptOverlay().setVisible(false);
        }
        WidgetEndGuildScheduledEventBottomSheet.INSTANCE.registerForResult(this, END_EVENT_REQUEST_KEY, new AnonymousClass5(viewState));
        enableWakeLock();
    }

    private final void configureMenu(final WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        if (Intrinsics3.areEqual(viewState.getMenuItems(), this.lastMenuItems)) {
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
        setActionBarOptionsMenu(R.menu.menu_call_fullscreen, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureMenu.1

            /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$configureMenu$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetCallFullscreen.kt */
            public static final class C03611 extends Lambda implements Function1<StreamContext, Unit> {
                public C03611() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
                    invoke2(streamContext);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(StreamContext streamContext) {
                    Intrinsics3.checkNotNullParameter(streamContext, "streamContext");
                    WidgetCallFullscreen.this.getViewModel().targetAndFocusStream(streamContext.getStream().getEncodedStreamKey());
                }
            }

            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case R.id.menu_call_overlay_launcher /* 2131364365 */:
                        DiscordOverlayService.Companion companion = DiscordOverlayService.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        companion.launchForConnect(context);
                        break;
                    case R.id.menu_call_switch_camera /* 2131364366 */:
                        WidgetCallFullscreen.this.getViewModel().switchCameraInputPressed();
                        break;
                    case R.id.menu_call_video_list /* 2131364367 */:
                        WidgetVoiceBottomSheet.Companion companion2 = WidgetVoiceBottomSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetCallFullscreen.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion2.show(parentFragmentManager, viewState.getCallModel().getChannel().getId(), false, WidgetVoiceBottomSheet.FeatureContext.FULLSCREEN_CALL).setOnStreamPreviewClickedListener(new C03611());
                        break;
                    case R.id.menu_call_voice_settings /* 2131364368 */:
                        WidgetVoiceSettingsBottomSheet.Companion companion3 = WidgetVoiceSettingsBottomSheet.INSTANCE;
                        Long lValueOf = Long.valueOf(viewState.getCallModel().getChannel().getId());
                        FragmentManager parentFragmentManager2 = WidgetCallFullscreen.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                        companion3.show(lValueOf, parentFragmentManager2);
                        break;
                }
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureMenu.2
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_text_in_voice);
                boolean zContains = viewState.getMenuItems().contains(WidgetCallFullscreenViewModel.MenuItem.TEXT_IN_VOICE);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
                menuItemFindItem.setVisible(zContains);
                if (zContains) {
                    View actionView = menuItemFindItem.getActionView();
                    TextView textView = actionView != null ? (TextView) actionView.findViewById(R.id.text_in_voice_count) : null;
                    View actionView2 = menuItemFindItem.getActionView();
                    ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(R.id.text_in_voice_icon) : null;
                    int textInVoiceMentionsCount2 = viewState.getTextInVoiceMentionsCount();
                    int textInVoiceUnreadsCount2 = viewState.getTextInVoiceUnreadsCount();
                    if (textInVoiceMentionsCount2 > 0) {
                        if (textView != null) {
                            ViewKt.setVisible(textView, true);
                        }
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.ic_text_in_voice_cutout_dark);
                        }
                        if (textView != null) {
                            textView.setBackground(ContextCompat.getDrawable(WidgetCallFullscreen.this.requireContext(), R.drawable.drawable_circle_red));
                        }
                        if (textView != null) {
                            textView.setText(String.valueOf(Math.min(99, textInVoiceMentionsCount2)));
                        }
                        if (textView != null) {
                            textView.setTextColor(ContextCompat.getColor(WidgetCallFullscreen.this.requireContext(), R.color.white));
                        }
                    } else if (textInVoiceUnreadsCount2 > 0) {
                        if (textView != null) {
                            ViewKt.setVisible(textView, true);
                        }
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.ic_text_in_voice_cutout_dark);
                        }
                        if (textView != null) {
                            textView.setBackground(ContextCompat.getDrawable(WidgetCallFullscreen.this.requireContext(), R.drawable.drawable_circle_white));
                        }
                        if (textView != null) {
                            textView.setText(String.valueOf(Math.min(99, textInVoiceUnreadsCount2)));
                        }
                        if (textView != null) {
                            textView.setTextColor(ContextCompat.getColor(WidgetCallFullscreen.this.requireContext(), R.color.black));
                        }
                    } else {
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.ic_text_in_voice_dark);
                        }
                        if (textView != null) {
                            ViewKt.setVisible(textView, false);
                        }
                    }
                    menuItemFindItem.getActionView().setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureMenu.2.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WidgetCallFullscreen.this.openTextInVoice();
                        }
                    });
                }
                MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_call_switch_camera);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "switchCameraMenuItem");
                menuItemFindItem2.setVisible(viewState.getMenuItems().contains(WidgetCallFullscreenViewModel.MenuItem.SWITCH_CAMERA));
                MenuItem menuItemFindItem3 = menu.findItem(R.id.menu_call_voice_settings);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem3, "voiceSettingsMenuItem");
                menuItemFindItem3.setVisible(viewState.getMenuItems().contains(WidgetCallFullscreenViewModel.MenuItem.VOICE_SETTINGS));
                MenuItem menuItemFindItem4 = menu.findItem(R.id.menu_call_overlay_launcher);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem4, "overlayLauncherMenuItem");
                menuItemFindItem4.setVisible(viewState.getMenuItems().contains(WidgetCallFullscreenViewModel.MenuItem.LAUNCH_OVERLAY));
                MenuItem menuItemFindItem5 = menu.findItem(R.id.menu_call_video_list);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem5, "listMenuItem");
                menuItemFindItem5.setVisible(viewState.getMenuItems().contains(WidgetCallFullscreenViewModel.MenuItem.SHOW_PARTICIPANT_LIST));
            }
        });
    }

    private final void configurePrivateCallParticipantsUi(WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        String displayName;
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.callParticipantsHidden");
        linearLayout.setVisibility(viewState.getShowParticipantsHiddenView() ? 0 : 8);
        RelativeLayout relativeLayout = getBinding().f2246s.d;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.privateCall.privateCallContainer");
        relativeLayout.setVisibility(0);
        getBinding().f2246s.f187b.configure(viewState.getPrivateCallUserListItems());
        TextView textView = getBinding().f2246s.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.privateCall.priv…CallConnectivityStatusBar");
        textView.setVisibility(viewState.getShowLowConnectivityBar() ? 0 : 8);
        getBinding().f2246s.f.configure(viewState.getPrivateCallUserListItems());
        VideoCallParticipantView videoCallParticipantView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "binding.callPip");
        videoCallParticipantView.setVisibility(8);
        RecyclerView recyclerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        recyclerView.setVisibility(8);
        RecyclerView recyclerView2 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callStageRecycler");
        recyclerView2.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(8);
        configureMenu(viewState);
        configureActionBar(viewState);
        enableWakeLock();
        getBinding().f2246s.i.setText(viewState.getCallModel().isConnected() ? R.string.ongoing_call : R.string.voice_status_not_connected);
        TextView textView2 = getBinding().f2246s.h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.privateCall.privateCallStatusPrimary");
        if (ChannelUtils.z(viewState.getCallModel().getChannel())) {
            displayName = ChannelUtils.c(viewState.getCallModel().getChannel());
        } else {
            StoreVoiceParticipants.VoiceUser dmRecipient = viewState.getCallModel().getDmRecipient();
            displayName = dmRecipient != null ? dmRecipient.getDisplayName() : null;
        }
        textView2.setText(displayName);
        configureConnectionStatusText(viewState.getCallModel());
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00e5  */
    private final void configureStageUi(WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        boolean z2;
        boolean z3;
        StageCallModel stageCallModel = viewState.getStageCallModel();
        if (stageCallModel != null) {
            if (getViewModel().getShowStageCallBottomSheet()) {
                WidgetCallFullscreenViewModel viewModel = getViewModel();
                StageCallBottomSheetManager stageCallBottomSheetManager = this.stageCallBottomSheetManager;
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                viewModel.setShowStageCallBottomSheet(!stageCallBottomSheetManager.configureBottomSheet(parentFragmentManager, viewState.getCallModel().getChannel()));
            }
            RecyclerView recyclerView = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
            recyclerView.setVisibility(0);
            RelativeLayout relativeLayout = getBinding().f2246s.d;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.privateCall.privateCallContainer");
            relativeLayout.setVisibility(8);
            VideoCallParticipantView videoCallParticipantView = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "binding.callPip");
            videoCallParticipantView.setVisibility(8);
            RecyclerView recyclerView2 = getBinding().p;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
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
            List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers = stageCallModel.getSpeakingVoiceUsers();
            ConstraintLayout constraintLayout = getBinding().t;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
            if (!speakingVoiceUsers.isEmpty()) {
                if (!(speakingVoiceUsers instanceof Collection) || !speakingVoiceUsers.isEmpty()) {
                    Iterator<T> it = speakingVoiceUsers.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!isStageUserVisible(((StoreVoiceParticipants.VoiceUser) it.next()).getUser().getId())) {
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
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(speakingVoiceUsers, 10));
                for (StoreVoiceParticipants.VoiceUser voiceUser : speakingVoiceUsers) {
                    arrayList.add(new UserGuildMember(voiceUser.getUser(), voiceUser.getGuildMember()));
                }
                UserSummaryView.b(userSummaryView, arrayList, false, 2);
                MaterialTextView materialTextView = getBinding().v;
                Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.stageCallSpeakingUserSummaryLabel");
                Resources resources = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                materialTextView.setText(FormatUtils.e(this, R.string.stage_is_speaking_hook, new Object[]{speakingVoiceUsers.get(0).getDisplayName(), StringResourceUtils.getQuantityString(resources, R.plurals.stage_is_speaking_hook_count, R.string.stage_is_speaking_zero_quantity_hook, speakingVoiceUsers.size() - 1, Integer.valueOf(speakingVoiceUsers.size() - 1))}, new AnonymousClass3()));
            }
            List<StageCallModel5> mediaParticipants = stageCallModel.getMediaParticipants();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(mediaParticipants, 10));
            for (StageCallModel5 stageCallModel5 : mediaParticipants) {
                CallParticipant.UserOrStreamParticipant userOrStreamParticipant = viewState.getAllVideoParticipants().get(stageCallModel5.getId());
                if (userOrStreamParticipant == null) {
                    return;
                } else {
                    arrayList2.add(new StageCallItem.MediaItem(stageCallModel5.getVoiceUser(), stageCallModel5.getChannel(), stageCallModel5.isModerator(), stageCallModel5.isBlocked(), stageCallModel5.getMediaType(), userOrStreamParticipant));
                }
            }
            ArrayList arrayList3 = new ArrayList();
            boolean z5 = stageCallModel.getNumSpeakers() > 0;
            boolean zIsEmpty = true ^ stageCallModel.getAudience().isEmpty();
            if (stageCallModel.getStageInstance() != null) {
                arrayList3.add(new StageCallItem.DetailsItem(stageCallModel.getStageInstance().getTopic(), ChannelUtils.c(channel), viewState.getCallModel().getNumUsersConnected(), stageCallModel.getNumSpeakers(), stageCallModel.getAudience().size(), stageCallModel.getNumBlockedUsers(), AnimatableValueParser.W0(stageCallModel.getStageInstance())));
            } else {
                String string = StageRoles.m32isModeratorimpl(stageCallModel.m42getMyStageRoles1LxfuJo()) ? getString(R.string.stage_start_prompt_title_moderator) : getString(R.string.stage_start_prompt_title);
                Intrinsics3.checkNotNullExpressionValue(string, "when {\n                s…pt_title)\n              }");
                String string2 = StageRoles.m32isModeratorimpl(stageCallModel.m42getMyStageRoles1LxfuJo()) ? getString(R.string.stage_start_prompt_subtitle_mobile_moderator) : getString(R.string.stage_start_prompt_subtitle_mobile);
                Intrinsics3.checkNotNullExpressionValue(string2, "when {\n                s…e_mobile)\n              }");
                arrayList3.add(new StageCallItem.PreStartDetailsItem(string, string2, stageCallModel.getNumSpeakers(), stageCallModel.getAudience().size()));
            }
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(stageCallModel.getSpeakerItems());
            if (z5 && zIsEmpty) {
                arrayList3.add(StageCallItem.DividerItem.INSTANCE);
            }
            if (zIsEmpty) {
                arrayList3.add(new StageCallItem.AudienceHeaderItem(stageCallModel.getAudience().size()));
                arrayList3.addAll(stageCallModel.getAudience());
            }
            StageCallAdapter stageCallAdapter = this.stageAdapter;
            if (stageCallAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stageAdapter");
            }
            stageCallAdapter.setData(arrayList3, stageCallModel.getSpeakerItems().size());
            configureMenu(viewState);
            configureActionBar(viewState);
            enableWakeLock();
            WidgetEndStageBottomSheet.INSTANCE.registerForResult(this, END_STAGE_REQUEST_KEY, new AnonymousClass4(viewState));
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
        ViewBinding defaultTooltipViewBottomBinding;
        if (!showTooltip) {
            this.tooltipManager.c(VoiceControlsSheetSwipeTooltip.INSTANCE);
            return;
        }
        DefaultTooltipCreator defaultTooltipCreator = this.defaultTooltipCreator;
        View view = getBinding().f2248y;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.voiceControlsSheetView");
        TooltipManager.b bVar = VoiceControlsSheetSwipeTooltip.INSTANCE;
        String string = getResources().getString(R.string.voice_controls_sheet_tooltip_swipe_up);
        Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(R.st…s_sheet_tooltip_swipe_up)");
        int iDpToPixels = DimenUtils.dpToPixels(-12);
        Observable<R> observableG = getUnsubscribeSignal().G(new Func1<Void, Unit>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.configureSwipeTooltip.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Unit call(Void r1) {
                call2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r1) {
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "this.unsubscribeSignal.map { }");
        FloatingViewGravity floatingViewGravity = FloatingViewGravity.TOP;
        Objects.requireNonNull(defaultTooltipCreator);
        Intrinsics3.checkNotNullParameter(view, "anchorView");
        Intrinsics3.checkNotNullParameter(string, "tooltipText");
        Intrinsics3.checkNotNullParameter(bVar, "tooltip");
        Intrinsics3.checkNotNullParameter(floatingViewGravity, "tooltipGravity");
        Intrinsics3.checkNotNullParameter(observableG, "componentPausedObservable");
        if (defaultTooltipCreator.tooltipManager.b(bVar, true)) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(view.getContext());
            if (floatingViewGravity == floatingViewGravity) {
                View rootView = view.getRootView();
                Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
                View viewInflate = layoutInflaterFrom.inflate(R.layout.default_tooltip_view_top, (ViewGroup) rootView, false);
                TextView textView = (TextView) viewInflate.findViewById(R.id.default_tooltip_text);
                if (textView == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.default_tooltip_text)));
                }
                defaultTooltipViewBottomBinding = new DefaultTooltipViewTopBinding((ConstraintLayout) viewInflate, textView);
                Intrinsics3.checkNotNullExpressionValue(textView, "defaultTooltipText");
                textView.setText(string);
                Intrinsics3.checkNotNullExpressionValue(defaultTooltipViewBottomBinding, "DefaultTooltipViewTopBin…ext = tooltipText\n      }");
            } else {
                View rootView2 = view.getRootView();
                Objects.requireNonNull(rootView2, "null cannot be cast to non-null type android.view.ViewGroup");
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.default_tooltip_view_bottom, (ViewGroup) rootView2, false);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.default_tooltip_text);
                if (textView2 == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R.id.default_tooltip_text)));
                }
                defaultTooltipViewBottomBinding = new DefaultTooltipViewBottomBinding((ConstraintLayout) viewInflate2, textView2);
                Intrinsics3.checkNotNullExpressionValue(textView2, "defaultTooltipText");
                textView2.setText(string);
                Intrinsics3.checkNotNullExpressionValue(defaultTooltipViewBottomBinding, "DefaultTooltipViewBottom…ext = tooltipText\n      }");
            }
            defaultTooltipViewBottomBinding.getRoot().setOnClickListener(new DefaultTooltipCreator2(defaultTooltipCreator, bVar));
            TooltipManager tooltipManager = defaultTooltipCreator.tooltipManager;
            View root = defaultTooltipViewBottomBinding.getRoot();
            Intrinsics3.checkNotNullExpressionValue(root, "tooltipView.root");
            tooltipManager.d(view, root, bVar, floatingViewGravity, 0, iDpToPixels, true, observableG);
        }
    }

    private final void configureUI(WidgetCallFullscreenViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetCallFullscreenViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetCallFullscreenViewModel.ViewState.Valid) {
            configureValidUI((WidgetCallFullscreenViewModel.ViewState.Valid) viewState);
        }
    }

    private final void configureValidUI(WidgetCallFullscreenViewModel.ViewState.Valid viewState) {
        configureBottomControls(viewState);
        ConstraintLayout constraintLayout = getBinding().a;
        int iOrdinal = viewState.getDisplayMode().ordinal();
        int themedDrawableRes = R.color.primary_dark_800;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                themedDrawableRes = R.color.black;
            }
        } else if (!viewState.isTextInVoiceEnabled()) {
            ConstraintLayout constraintLayout2 = getBinding().a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            themedDrawableRes = DrawableCompat.getThemedDrawableRes(constraintLayout2, R.attr.colorBackgroundPrimary, 0);
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
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
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
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        fragmentActivityRequireActivity.getWindow().addFlags(128);
    }

    private final void finishActivity(boolean disconnect, boolean transition) {
        getViewModel().selectTextChannelAfterFinish();
        if (disconnect) {
            getViewModel().disconnect();
        }
        requireActivity().finish();
        if (transition) {
            requireAppActivity().overridePendingTransition(0, R.anim.anim_slide_out_down);
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

    private final List<VideoCallParticipantView.ParticipantData> getVisibleParticipants(VideoCallGridLayoutManager layoutManager) {
        Ranges2 ranges2 = new Ranges2(layoutManager.findFirstVisibleItemPosition(), layoutManager.findLastVisibleItemPosition());
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
        Iterator<Integer> it = ranges2.iterator();
        while (it.hasNext()) {
            View childAt = getBinding().p.getChildAt(((Iterators4) it).nextInt());
            arrayList.add(childAt instanceof VideoCallParticipantView ? ((VideoCallParticipantView) childAt).getData() : null);
        }
        return _Collections.filterNotNull(arrayList);
    }

    private final void handleIdleStateChanged(WidgetCallFullscreenViewModel.Event.OnIdleStateChanged event) {
        if (event.isIdle()) {
            BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
            if (bottomSheetBehavior == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
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
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter.notifyCallControlsVisibilityChanged(false);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        Intrinsics3.checkNotNullExpressionValue(window, "requireActivity().window");
        RecyclerView recyclerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        Intrinsics3.checkNotNullParameter(window, "window");
        Intrinsics3.checkNotNullParameter(recyclerView, "view");
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(true);
        }
        recyclerView.setSystemUiVisibility(5894);
    }

    private final void initializeSystemUiListeners(ViewGroup viewGroup) {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2248y, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.initializeSystemUiListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WidgetCallFullscreen.this.systemWindowInsets = windowInsetsCompat;
                WidgetCallFullscreen.this.setVoiceControlsSheetPeekHeight();
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), WidgetCallFullscreen.this.getResources().getDimensionPixelSize(R.dimen.voice_controls_sheet_bottom_padding) + windowInsetsCompat.getSystemWindowInsetBottom());
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = windowInsetsCompat.getSystemWindowInsetLeft();
                marginLayoutParams.rightMargin = windowInsetsCompat.getSystemWindowInsetRight();
                view.setLayoutParams(marginLayoutParams);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.initializeSystemUiListeners.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().h, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.initializeSystemUiListeners.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                Companion companion = WidgetCallFullscreen.INSTANCE;
                Resources resources = WidgetCallFullscreen.this.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
                int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                Resources resources2 = WidgetCallFullscreen.this.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
                view.setLayoutParams(layoutParams2);
                return windowInsetsCompat;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.initializeSystemUiListeners.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        CoordinatorLayout coordinatorLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.callControlsSheetContainer");
        ViewExtensions.setForwardingWindowInsetsListener(coordinatorLayout);
        ConstraintLayout constraintLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callNonVideoContainer");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.initializeSystemUiListeners.5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
                VideoCallGridAdapter videoCallGridAdapterAccess$getGridAdapter$p = WidgetCallFullscreen.access$getGridAdapter$p(WidgetCallFullscreen.this);
                Resources resources = WidgetCallFullscreen.this.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                videoCallGridAdapterAccess$getGridAdapter$p.setDisplayCutout(displayCutout, resources.getConfiguration().orientation == 2);
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(Math.max(windowInsetsCompat.getSystemWindowInsetLeft(), displayCutout != null ? displayCutout.getSafeInsetLeft() : 0), Math.max(windowInsetsCompat.getSystemWindowInsetTop(), displayCutout != null ? displayCutout.getSafeInsetTop() : 0), Math.max(windowInsetsCompat.getSystemWindowInsetRight(), displayCutout != null ? displayCutout.getSafeInsetRight() : 0), Math.max(windowInsetsCompat.getSystemWindowInsetBottom(), displayCutout != null ? displayCutout.getSafeInsetBottom() : 0))).build();
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
                VideoCallGridAdapter videoCallGridAdapterAccess$getGridAdapter$p2 = WidgetCallFullscreen.access$getGridAdapter$p(WidgetCallFullscreen.this);
                AppBarLayout appBarLayout = WidgetCallFullscreen.this.getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
                videoCallGridAdapterAccess$getGridAdapter$p2.setInsetsForAvoidingCallUiOverlap(appBarLayout.getMeasuredHeight(), windowInsetsCompat.getSystemWindowInsetBottom(), windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetRight());
                ViewCompat.dispatchApplyWindowInsets(WidgetCallFullscreen.this.getBinding().f, windowInsetsCompatBuild);
                ViewCompat.dispatchApplyWindowInsets(WidgetCallFullscreen.this.getBinding().i, windowInsetsCompatBuild);
                RecyclerView recyclerView = WidgetCallFullscreen.this.getBinding().m;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
                recyclerView.setPadding(recyclerView.getPaddingLeft(), WidgetCallFullscreen.this.getResources().getDimensionPixelOffset(R.dimen.stage_details_top_padding) + windowInsetsCompatBuild.getSystemWindowInsetTop(), recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
                return windowInsetsCompatBuild;
            }
        });
    }

    private final boolean isPortraitMode() {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return resources.getConfiguration().orientation == 1;
    }

    private final boolean isStageUserVisible(long userId) {
        StoreVoiceParticipants.VoiceUser voiceUser;
        User user;
        RecyclerView recyclerView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        if (!(recyclerView.getVisibility() == 0)) {
            return false;
        }
        GridLayoutManager gridLayoutManager = this.stageLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stageLayoutManager");
        }
        int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        if (iFindFirstVisibleItemPosition != -1 && iFindLastVisibleItemPosition != -1) {
            StageCallAdapter stageCallAdapter = this.stageAdapter;
            if (stageCallAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stageAdapter");
            }
            if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                while (true) {
                    DiffKeyProvider diffKeyProvider = (StageCallItem) stageCallAdapter.getItem(iFindFirstVisibleItemPosition);
                    if (!(diffKeyProvider instanceof StageCallItem2)) {
                        diffKeyProvider = null;
                    }
                    StageCallItem2 stageCallItem2 = (StageCallItem2) diffKeyProvider;
                    if (stageCallItem2 != null && (voiceUser = stageCallItem2.getVoiceUser()) != null && (user = voiceUser.getUser()) != null && user.getId() == userId) {
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

    public static final void launch(Context context, long j, boolean z2, String str, AppTransitionActivity.Transition transition) {
        INSTANCE.launch(context, j, z2, str, transition);
    }

    private final void onViewBindingDestroy(WidgetCallFullscreenBinding binding) {
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehavior.removeBottomSheetCallback(this.bottomSheetCallback);
        destroyAllRenderers(binding);
    }

    private final void openTextInVoice() {
        transitionActivity();
        getViewModel().onTextInVoiceTapped();
    }

    private final void setUpGridRecycler() {
        VideoCallGridAdapter videoCallGridAdapter = new VideoCallGridAdapter(new AnonymousClass1(), new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass4(getViewModel()), new AnonymousClass5(getViewModel()), 2);
        this.gridAdapter = videoCallGridAdapter;
        if (videoCallGridAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter.setHasStableIds(true);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getConfiguration().orientation != 2 ? 1 : 0;
        WidgetCallFullscreen$setUpGridRecycler$layoutManager$1 widgetCallFullscreen$setUpGridRecycler$layoutManager$1 = new WidgetCallFullscreen$setUpGridRecycler$layoutManager$1(this, i);
        WidgetCallFullscreen$setUpGridRecycler$layoutManager$2 widgetCallFullscreen$setUpGridRecycler$layoutManager$2 = new WidgetCallFullscreen$setUpGridRecycler$layoutManager$2(this);
        RecyclerView recyclerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.callVideoRecycler.context");
        final VideoCallGridLayoutManager videoCallGridLayoutManager = new VideoCallGridLayoutManager(widgetCallFullscreen$setUpGridRecycler$layoutManager$1, 2, widgetCallFullscreen$setUpGridRecycler$layoutManager$2, i, context);
        getBinding().p.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.setUpGridRecycler.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                Intrinsics3.checkNotNullParameter(recyclerView2, "recyclerView");
                if (newState == 0) {
                    WidgetCallFullscreen.this.getViewModel().updateOffScreenParticipantsFromScroll(WidgetCallFullscreen.this.getVisibleParticipants(videoCallGridLayoutManager));
                }
            }
        });
        getBinding().p.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.setUpGridRecycler.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetCallFullscreen.this.hasVideoCallGridChildrenChanged = true;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetCallFullscreen.this.hasVideoCallGridChildrenChanged = true;
            }
        });
        VideoCallGridAdapter videoCallGridAdapter2 = this.gridAdapter;
        if (videoCallGridAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridLayoutManager.setSpanSizeLookup(videoCallGridAdapter2.getSpanSizeLookup());
        RecyclerView recyclerView2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
        recyclerView2.setLayoutManager(videoCallGridLayoutManager);
        RecyclerView recyclerView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.callVideoRecycler");
        recyclerView3.setItemAnimator(null);
        RecyclerView recyclerView4 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.callVideoRecycler");
        VideoCallGridAdapter videoCallGridAdapter3 = this.gridAdapter;
        if (videoCallGridAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        recyclerView4.setAdapter(videoCallGridAdapter3);
    }

    private final void setUpStageRecycler() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.stageAdapter = (StageCallAdapter) companion.configure(new StageCallAdapter(recyclerView, parentFragmentManager, AnonymousClass1.INSTANCE, new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass4(getViewModel()), new AnonymousClass5(getViewModel())));
        RecyclerView recyclerView2 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callStageRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView2.getContext(), 12);
        StageCallAdapter stageCallAdapter = this.stageAdapter;
        if (stageCallAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stageAdapter");
        }
        gridLayoutManager.setSpanSizeLookup(stageCallAdapter.getSpanSizeLookup());
        this.stageLayoutManager = gridLayoutManager;
        RecyclerView recyclerView3 = getBinding().m;
        GridLayoutManager gridLayoutManager2 = this.stageLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stageLayoutManager");
        }
        recyclerView3.setLayoutManager(gridLayoutManager2);
        StageCallAdapter stageCallAdapter2 = this.stageAdapter;
        if (stageCallAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stageAdapter");
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
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        int i = systemWindowInsetBottom + peekHeight;
        bottomSheetBehavior.setPeekHeight(i);
        RecyclerView recyclerView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), i);
        ConstraintLayout constraintLayout = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callStreamingActive");
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), peekHeight);
        LinearLayout linearLayout = getBinding().f2246s.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.privateCall.privateCallContainerContent");
        linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), peekHeight);
    }

    private final void showControls() {
        ViewExtensions.fadeBy(getBinding().f2248y, true, 200L);
        VideoCallGridAdapter videoCallGridAdapter = this.gridAdapter;
        if (videoCallGridAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gridAdapter");
        }
        videoCallGridAdapter.notifyCallControlsVisibilityChanged(true);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        Intrinsics3.checkNotNullExpressionValue(window, "requireActivity().window");
        RecyclerView recyclerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
        Intrinsics3.checkNotNullParameter(window, "window");
        Intrinsics3.checkNotNullParameter(recyclerView, "view");
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(true);
        }
        recyclerView.setSystemUiVisibility(1792);
    }

    private final void showNoScreenSharePermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(R.string.no_screenshare_permission_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVadPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.vad_permission_title);
        String string2 = contextRequireContext.getString(R.string.vad_permission_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.vad_permission_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVideoPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(R.string.no_video_permission_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…o_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerDeafenedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.server_deafened_dialog_title);
        String string2 = contextRequireContext.getString(R.string.server_deafened_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ver_deafened_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerMutedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.server_muted_dialog_title);
        String string2 = contextRequireContext.getString(R.string.server_muted_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…server_muted_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showSuppressedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.suppressed);
        String string2 = contextRequireContext.getString(R.string.suppressed_permission_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ppressed_permission_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void transitionActivity() {
        requireAppActivity().finish();
        requireAppActivity().overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out);
    }

    public final void handleEvent(WidgetCallFullscreenViewModel.Event event) {
        Unit unit;
        Intrinsics3.checkNotNullParameter(event, "event");
        if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowSuppressedDialog.INSTANCE)) {
            showSuppressedDialog();
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowServerMutedDialog.INSTANCE)) {
            showServerMutedDialog();
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowServerDeafenedDialog.INSTANCE)) {
            showServerDeafenedDialog();
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowNoVideoPermissionDialog.INSTANCE)) {
            showNoVideoPermissionDialog();
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowNoVadPermissionDialog.INSTANCE)) {
            showNoVadPermissionDialog();
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion aVar = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.a(parentFragmentManager);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.ShowCameraCapacityDialog) {
            CameraCapacityDialog.Companion aVar2 = CameraCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            aVar2.a(parentFragmentManager2, ((WidgetCallFullscreenViewModel.Event.ShowCameraCapacityDialog) event).getGuildMaxVideoChannelUsers());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.ShowUserSheet) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            WidgetCallFullscreenViewModel.Event.ShowUserSheet showUserSheet = (WidgetCallFullscreenViewModel.Event.ShowUserSheet) event;
            long userId = showUserSheet.getUserId();
            Long lValueOf = Long.valueOf(showUserSheet.getChannelId());
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, userId, lValueOf, parentFragmentManager3, null, Boolean.TRUE, WidgetUserSheet.StreamPreviewClickBehavior.TARGET_AND_DISMISS, null, 72, null);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.ShowRequestCameraPermissionsDialog) {
            requestVideoCallPermissions(new AnonymousClass1());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.AccessibilityAnnouncement) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            String string = getString(((WidgetCallFullscreenViewModel.Event.AccessibilityAnnouncement) event).getMessageResId());
            Intrinsics3.checkNotNullExpressionValue(string, "getString(event.messageResId)");
            accessibilityUtils.sendAnnouncement(contextRequireContext, string);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.EnqueueStreamFeedbackSheet) {
            WidgetCallFullscreenViewModel.Event.EnqueueStreamFeedbackSheet enqueueStreamFeedbackSheet = (WidgetCallFullscreenViewModel.Event.EnqueueStreamFeedbackSheet) event;
            StreamFeedbackSheetNavigator.INSTANCE.enqueueNotice(enqueueStreamFeedbackSheet.getStreamKey(), enqueueStreamFeedbackSheet.getMediaSessionId(), enqueueStreamFeedbackSheet.getTriggerRateDenominator());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.EnqueueCallFeedbackSheet) {
            WidgetCallFullscreenViewModel.Event.EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (WidgetCallFullscreenViewModel.Event.EnqueueCallFeedbackSheet) event;
            CallFeedbackSheetNavigator.INSTANCE.enqueueNotice(enqueueCallFeedbackSheet.getChannelId(), enqueueCallFeedbackSheet.getRtcConnectionId(), enqueueCallFeedbackSheet.getMediaSessionId(), Long.valueOf(enqueueCallFeedbackSheet.getCallDuration()), enqueueCallFeedbackSheet.getTriggerRateDenominator());
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.ShowNoScreenSharePermissionDialog) {
            showNoScreenSharePermissionDialog();
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.RequestStartStream.INSTANCE)) {
            BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
            if (bottomSheetBehavior == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
            }
            bottomSheetBehavior.setState(4);
            StreamNavigator.requestStartStream(this);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.OnIdleStateChanged) {
            handleIdleStateChanged((WidgetCallFullscreenViewModel.Event.OnIdleStateChanged) event);
            unit = Unit.a;
        } else if (event instanceof WidgetCallFullscreenViewModel.Event.NavigateToPremiumSettings) {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, requireContext(), null, null, 6, null);
            unit = Unit.a;
        } else if (Intrinsics3.areEqual(event, WidgetCallFullscreenViewModel.Event.ShowActivitiesDesktopOnlyDialog.INSTANCE)) {
            FragmentManager parentFragmentManager4 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullParameter(parentFragmentManager4, "fragmentManager");
            Intrinsics3.checkNotNullParameter(contextRequireContext2, "context");
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            String string2 = contextRequireContext2.getString(R.string.embedded_activities_desktop_only_modal_title);
            String string3 = contextRequireContext2.getString(R.string.embedded_activities_desktop_only_modal_description);
            Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager4, string2, string3, contextRequireContext2.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else {
            if (!(event instanceof WidgetCallFullscreenViewModel.Event.ShowTextInVoiceNux)) {
                throw new NoWhenBranchMatchedException();
            }
            new TextInVoiceOnboardingManager().show(new AnonymousClass2());
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        StreamNavigator.handleActivityResult(requestCode, resultCode, data, new AnonymousClass1());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        Intrinsics3.checkNotNullExpressionValue(window, "requireActivity().window");
        Intrinsics3.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 28) {
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
        WidgetGlobalStatusIndicatorState.updateState$default(WidgetGlobalStatusIndicatorState.INSTANCE.get(), false, false, false, 3, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewGroup viewGroup = (ViewGroup) view;
        initializeSystemUiListeners(viewGroup);
        Context context = viewGroup.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        setActionBarDisplayHomeAsUpEnabled(true, Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_action_bar_down, 0, 2, (Object) null)), Integer.valueOf(R.string.dismiss));
        AppTransitionActivity.a aVar = requireAppActivity().k;
        setUpGridRecycler();
        setUpStageRecycler();
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.onViewBound.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
                Integer numValueOf = event != null ? Integer.valueOf(event.getEventType()) : null;
                if ((numValueOf != null && numValueOf.intValue() == 8) || (numValueOf != null && numValueOf.intValue() == 32768)) {
                    WidgetCallFullscreen.this.getViewModel().disableControlFading();
                }
                return super.onRequestSendAccessibilityEvent(host, child, event);
            }
        });
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f2248y);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…g.voiceControlsSheetView)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehaviorFrom.setGestureInsetBottomIgnored(true);
        BottomSheetBehavior<VoiceControlsSheetView> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
        VoiceControlsSheetView voiceControlsSheetView = getBinding().f2248y;
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetView, "binding.voiceControlsSheetView");
        ViewExtensions.addOnHeightChangedListener(voiceControlsSheetView, new AnonymousClass2());
        OnPressListener onPressListener = new OnPressListener(new WidgetCallFullscreen$onViewBound$listener$1(getViewModel()));
        getBinding().g.setOnTouchListener(onPressListener);
        getBinding().f2248y.setOnPTTListener(onPressListener);
        final Channel channel = StoreStream.INSTANCE.getChannels().getChannel(getChannelId());
        if (channel != null && ChannelUtils.D(channel)) {
            requireAppActivity().k = AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE.getAnimations();
        }
        if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONNECT_ON_LAUNCH, false)) {
            if (channel == null || !ChannelUtils.D(channel)) {
                requestMicrophone(new AnonymousClass3(channel), new AnonymousClass4());
            } else {
                getViewModel().tryConnectToVoice();
            }
        }
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.voice.fullscreen.WidgetCallFullscreen.onViewBound.5
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetCallFullscreen widgetCallFullscreen = WidgetCallFullscreen.this;
                TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.INSTANCE.getINSTANCE();
                Channel channel2 = channel;
                widgetCallFullscreen.finishActivity(false, instance.isEnabled(channel2 != null ? Long.valueOf(channel2.getGuildId()) : null));
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetGlobalStatusIndicatorState.updateState$default(WidgetGlobalStatusIndicatorState.INSTANCE.get(), false, false, true, 3, null);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetCallFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetCallFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
