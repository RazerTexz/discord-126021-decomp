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
import b.a.a.CameraCapacityDialog;
import b.a.a.GuildVideoAtCapacityDialog;
import b.a.a.f.a.AudioOutputSelectionDialog;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.LayoutVoiceBottomSheetEmptyBinding;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceBottomSheetBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetNavigator;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel;
import com.discord.widgets.voice.stream.StreamNavigator;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static abstract class BottomContent {

        /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
        public static final /* data */ class Connect extends BottomContent {
            private final boolean isConnectEnabled;

            public Connect(boolean z2) {
                super(null);
                this.isConnectEnabled = z2;
            }

            public static /* synthetic */ Connect copy$default(Connect connect, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = connect.isConnectEnabled;
                }
                return connect.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsConnectEnabled() {
                return this.isConnectEnabled;
            }

            public final Connect copy(boolean isConnectEnabled) {
                return new Connect(isConnectEnabled);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connect) && this.isConnectEnabled == ((Connect) other).isConnectEnabled;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isConnectEnabled;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isConnectEnabled() {
                return this.isConnectEnabled;
            }

            public String toString() {
                return outline.O(outline.U("Connect(isConnectEnabled="), this.isConnectEnabled, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
        public static final /* data */ class Controls extends BottomContent {
            private final StoreAudioManagerV2.State audioManagerState;
            private final CameraState cameraState;
            private final MediaEngineConnection.InputMode inputMode;
            private final boolean isMuted;
            private final boolean isScreensharing;
            private final boolean showScreenShareSparkle;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Controls(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State state, boolean z2, CameraState cameraState, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                Intrinsics3.checkNotNullParameter(state, "audioManagerState");
                Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
                this.inputMode = inputMode;
                this.audioManagerState = state;
                this.isMuted = z2;
                this.cameraState = cameraState;
                this.showScreenShareSparkle = z3;
                this.isScreensharing = z4;
            }

            public static /* synthetic */ Controls copy$default(Controls controls, MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State state, boolean z2, CameraState cameraState, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputMode = controls.inputMode;
                }
                if ((i & 2) != 0) {
                    state = controls.audioManagerState;
                }
                StoreAudioManagerV2.State state2 = state;
                if ((i & 4) != 0) {
                    z2 = controls.isMuted;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    cameraState = controls.cameraState;
                }
                CameraState cameraState2 = cameraState;
                if ((i & 16) != 0) {
                    z3 = controls.showScreenShareSparkle;
                }
                boolean z6 = z3;
                if ((i & 32) != 0) {
                    z4 = controls.isScreensharing;
                }
                return controls.copy(inputMode, state2, z5, cameraState2, z6, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final CameraState getCameraState() {
                return this.cameraState;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getShowScreenShareSparkle() {
                return this.showScreenShareSparkle;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsScreensharing() {
                return this.isScreensharing;
            }

            public final Controls copy(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State audioManagerState, boolean isMuted, CameraState cameraState, boolean showScreenShareSparkle, boolean isScreensharing) {
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
                Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
                return new Controls(inputMode, audioManagerState, isMuted, cameraState, showScreenShareSparkle, isScreensharing);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Controls)) {
                    return false;
                }
                Controls controls = (Controls) other;
                return Intrinsics3.areEqual(this.inputMode, controls.inputMode) && Intrinsics3.areEqual(this.audioManagerState, controls.audioManagerState) && this.isMuted == controls.isMuted && Intrinsics3.areEqual(this.cameraState, controls.cameraState) && this.showScreenShareSparkle == controls.showScreenShareSparkle && this.isScreensharing == controls.isScreensharing;
            }

            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final CameraState getCameraState() {
                return this.cameraState;
            }

            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            public final boolean getShowScreenShareSparkle() {
                return this.showScreenShareSparkle;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                MediaEngineConnection.InputMode inputMode = this.inputMode;
                int iHashCode = (inputMode != null ? inputMode.hashCode() : 0) * 31;
                StoreAudioManagerV2.State state = this.audioManagerState;
                int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
                boolean z2 = this.isMuted;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode2 + r2) * 31;
                CameraState cameraState = this.cameraState;
                int iHashCode3 = (i + (cameraState != null ? cameraState.hashCode() : 0)) * 31;
                boolean z3 = this.showScreenShareSparkle;
                ?? r1 = z3;
                if (z3) {
                    r1 = 1;
                }
                int i2 = (iHashCode3 + r1) * 31;
                boolean z4 = this.isScreensharing;
                return i2 + (z4 ? 1 : z4);
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public final boolean isScreensharing() {
                return this.isScreensharing;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Controls(inputMode=");
                sbU.append(this.inputMode);
                sbU.append(", audioManagerState=");
                sbU.append(this.audioManagerState);
                sbU.append(", isMuted=");
                sbU.append(this.isMuted);
                sbU.append(", cameraState=");
                sbU.append(this.cameraState);
                sbU.append(", showScreenShareSparkle=");
                sbU.append(this.showScreenShareSparkle);
                sbU.append(", isScreensharing=");
                return outline.O(sbU, this.isScreensharing, ")");
            }
        }

        private BottomContent() {
        }

        public /* synthetic */ BottomContent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static abstract class CenterContent {

        /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
        public static final /* data */ class Empty extends CenterContent {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Empty(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Empty copy$default(Empty empty, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = empty.items;
                }
                return empty.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final Empty copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Empty(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && Intrinsics3.areEqual(this.items, ((Empty) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Empty(items="), this.items, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
        public static final /* data */ class ListItems extends CenterContent {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ListItems(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ListItems copy$default(ListItems listItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = listItems.items;
                }
                return listItems.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final ListItems copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new ListItems(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ListItems) && Intrinsics3.areEqual(this.items, ((ListItems) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("ListItems(items="), this.items, ")");
            }
        }

        private CenterContent() {
        }

        public /* synthetic */ CenterContent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetVoiceBottomSheet show(FragmentManager fragmentManager, long channelId, boolean forwardToFullscreenIfVideoActivated, FeatureContext featureContext) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(featureContext, "featureContext");
            WidgetVoiceBottomSheet widgetVoiceBottomSheet = new WidgetVoiceBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundle.putSerializable(WidgetVoiceBottomSheet.ARG_FEATURE_CONTEXT, featureContext);
            bundle.putBoolean(WidgetVoiceBottomSheet.ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED, forwardToFullscreenIfVideoActivated);
            widgetVoiceBottomSheet.setArguments(bundle);
            widgetVoiceBottomSheet.show(fragmentManager, WidgetVoiceBottomSheet.class.getSimpleName());
            return widgetVoiceBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public enum FeatureContext {
        HOME,
        FULLSCREEN_CALL
    }

    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public interface ViewState {
        BottomContent getBottomContent();

        CenterContent getCenterContent();

        Channel getChannel();

        boolean getShowInviteOption();

        String getSubtitle();

        String getTitle();

        /* JADX INFO: renamed from: isDeafened */
        boolean getIsDeafened();

        /* JADX INFO: renamed from: isNoiseCancellationActive */
        Boolean getIsNoiseCancellationActive();
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeatureContext.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeatureContext.HOME.ordinal()] = 1;
            iArr[FeatureContext.FULLSCREEN_CALL.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onMutePressed", "onMutePressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onMutePressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onScreenSharePressed", "onScreenSharePressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onScreenSharePressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
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
            AudioOutputSelectionDialog.Companion companion = AudioOutputSelectionDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            new AudioOutputSelectionDialog().show(parentFragmentManager, AudioOutputSelectionDialog.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onCameraButtonPressed", "onCameraButtonPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onCameraButtonPressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass5(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnectPressed", "onDisconnectPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnectPressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StreamContext, Unit> {
        public AnonymousClass1(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
            super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(streamContext, "p1");
            ((WidgetVoiceBottomSheet) this.receiver).onStreamPreviewClicked(streamContext);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetVoiceBottomSheet.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetVoiceBottomSheet.this.getViewModel().onToggleRingingPressed(voiceUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetVoiceBottomSheet.this, this.$channel, WidgetVoiceBottomSheet.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
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
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetVoiceBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$handleEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
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
            WidgetVoiceBottomSheet.this.getViewModel().onCameraPermissionsGranted();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onActivityResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
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
            WidgetVoiceBottomSheet.this.getViewModel().startStream(intent);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetVoiceBottomSheetBinding binding = WidgetVoiceBottomSheet.this.getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            CoordinatorLayout coordinatorLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
            Context context = coordinatorLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(context, GuildScheduledEventModel2.toModel(guildScheduledEvent), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetVoiceBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceBottomSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<WidgetVoiceBottomSheetViewModel.Event, Unit> {
        public AnonymousClass4(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
            super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetVoiceBottomSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass5() {
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
            WidgetVoiceBottomSheet.this.viewModelEventSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onStreamPreviewClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.this.getViewModel().onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(1, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onPttPressed", "onPttPressed(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onPttPressed(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnect", "onDisconnect()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnect();
        }
    }

    public WidgetVoiceBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetVoiceBottomSheet3(this));
        this.forwardToFullscreenIfVideoActivated = LazyJVM.lazy(new WidgetVoiceBottomSheet5(this));
        WidgetVoiceBottomSheet7 widgetVoiceBottomSheet7 = new WidgetVoiceBottomSheet7(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetVoiceBottomSheetViewModel.class), new WidgetVoiceBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetVoiceBottomSheet7));
        this.featureContext = LazyJVM.lazy(new WidgetVoiceBottomSheet4(this));
        this.onStreamPreviewClickedListener = WidgetVoiceBottomSheet6.INSTANCE;
    }

    private final void configureBottomContent(BottomContent bottomContent, Channel channel) {
        if (bottomContent == null) {
            AnchoredVoiceControlsView anchoredVoiceControlsView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsView, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.voiceBottomSheetConnectContainer");
            relativeLayout.setVisibility(8);
            CoordinatorLayout coordinatorLayout = getBinding().i;
            CoordinatorLayout coordinatorLayout2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout2, "binding.voiceBottomSheetRoot");
            coordinatorLayout.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout2, R.attr.colorBackgroundPrimary));
            return;
        }
        if (bottomContent instanceof BottomContent.Controls) {
            AnchoredVoiceControlsView anchoredVoiceControlsView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsView2, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView2.setVisibility(0);
            RelativeLayout relativeLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.voiceBottomSheetConnectContainer");
            relativeLayout2.setVisibility(8);
            AnchoredVoiceControlsView anchoredVoiceControlsView3 = getBinding().f;
            BottomContent.Controls controls = (BottomContent.Controls) bottomContent;
            MediaEngineConnection.InputMode inputMode = controls.getInputMode();
            boolean zIsMuted = controls.isMuted();
            boolean zIsScreensharing = controls.isScreensharing();
            CameraState cameraState = controls.getCameraState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(getViewModel());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(getViewModel());
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(getViewModel());
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(getViewModel());
            boolean showScreenShareSparkle = controls.getShowScreenShareSparkle();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            anchoredVoiceControlsView3.configureUI(inputMode, controls.getAudioManagerState(), zIsMuted, zIsScreensharing, showScreenShareSparkle, cameraState, anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, this, parentFragmentManager, new AnonymousClass6(), getChannelId(), channel.getGuildId(), getForwardToFullscreenIfVideoActivated(), getFeatureContext());
            CoordinatorLayout coordinatorLayout3 = getBinding().i;
            CoordinatorLayout coordinatorLayout4 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout4, "binding.voiceBottomSheetRoot");
            coordinatorLayout3.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout4, R.attr.colorBackgroundSecondary));
        } else if (bottomContent instanceof BottomContent.Connect) {
            AnchoredVoiceControlsView anchoredVoiceControlsView4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsView4, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView4.setVisibility(4);
            getBinding().f.hidePtt();
            RelativeLayout relativeLayout3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout3, "binding.voiceBottomSheetConnectContainer");
            relativeLayout3.setVisibility(0);
            BottomContent.Connect connect = (BottomContent.Connect) bottomContent;
            if (connect.isConnectEnabled()) {
                getBinding().d.setText(R.string.join_voice_channel_cta);
                MaterialButton materialButton = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceBottomSheetConnect");
                materialButton.setEnabled(true);
            } else {
                getBinding().d.setText(R.string.channel_locked_short);
                MaterialButton materialButton2 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.voiceBottomSheetConnect");
                materialButton2.setEnabled(false);
            }
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureBottomContent.7

                /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$7$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
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
                        WidgetVoiceBottomSheet.this.getViewModel().tryConnectToVoice(false);
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnimatableValueParser.S1(WidgetVoiceBottomSheet.this, null, new AnonymousClass1(), 1, null);
                }
            });
            MaterialButton materialButton3 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.voiceBottomSheetJoinVideo");
            materialButton3.setEnabled(connect.isConnectEnabled());
            getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureBottomContent.8

                /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$8$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
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
                        WidgetVoiceBottomSheet.this.getViewModel().tryConnectToVoice(true);
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetVoiceBottomSheet.this.requestVideoCallPermissions(new AnonymousClass1());
                }
            });
            CoordinatorLayout coordinatorLayout5 = getBinding().i;
            CoordinatorLayout coordinatorLayout6 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout6, "binding.voiceBottomSheetRoot");
            coordinatorLayout5.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout6, R.attr.colorBackgroundPrimary));
        }
    }

    private final void configureCenterContent(CenterContent centerContent, Channel channel) {
        if (!(centerContent instanceof CenterContent.ListItems)) {
            if (!(centerContent instanceof CenterContent.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            LayoutVoiceBottomSheetEmptyBinding layoutVoiceBottomSheetEmptyBinding = getBinding().f2699b;
            Intrinsics3.checkNotNullExpressionValue(layoutVoiceBottomSheetEmptyBinding, "binding.empty");
            LinearLayout linearLayout = layoutVoiceBottomSheetEmptyBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.empty.root");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
            CenterContent.Empty empty = (CenterContent.Empty) centerContent;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        LayoutVoiceBottomSheetEmptyBinding layoutVoiceBottomSheetEmptyBinding2 = getBinding().f2699b;
        Intrinsics3.checkNotNullExpressionValue(layoutVoiceBottomSheetEmptyBinding2, "binding.empty");
        LinearLayout linearLayout2 = layoutVoiceBottomSheetEmptyBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.empty.root");
        linearLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.voiceBottomSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((CenterContent.ListItems) centerContent).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new AnonymousClass1(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new AnonymousClass2(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnToggleRingingClicked(new AnonymousClass3());
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnInviteFriendsClicked(new AnonymousClass4(channel));
        CallParticipantsAdapter callParticipantsAdapter7 = this.participantsAdapter;
        if (callParticipantsAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter7.setOnEmbeddedActivityClicked(new AnonymousClass5());
    }

    private final void configureUI(final WidgetVoiceBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().c.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.header.voiceBottomSheetHeaderTitle");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.header.voiceBottomSheetHeaderSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView2, viewState.getSubtitle());
        ImageView imageView = getBinding().c.f208b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView.setActivated(viewState.getIsDeafened());
        ImageView imageView2 = getBinding().c.f208b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView2.setContentDescription(viewState.getIsDeafened() ? getString(R.string.undeafen) : getString(R.string.deafen));
        getBinding().c.f208b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceBottomSheet.this.getViewModel().onDeafenPressed();
            }
        });
        ImageView imageView3 = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.header.voiceBottomSheetHeaderInvite");
        imageView3.setVisibility(viewState.getShowInviteOption() ? 0 : 8);
        getBinding().c.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetVoiceBottomSheet.this, viewState.getChannel(), WidgetVoiceBottomSheet.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
            }
        });
        getBinding().c.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
                Context contextRequireContext = WidgetVoiceBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                WidgetSettingsVoice.Companion.launch$default(companion, contextRequireContext, null, false, 6, null);
            }
        });
        getBinding().c.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceBottomSheet.this.getViewModel().onNoiseCancellationPressed();
            }
        });
        if (viewState.getIsNoiseCancellationActive() != null) {
            if (Intrinsics3.areEqual(viewState.getIsNoiseCancellationActive(), Boolean.TRUE)) {
                getBinding().c.d.setImageResource(R.drawable.ic_noise_cancellation_active_24dp);
            } else {
                getBinding().c.d.setImageResource(R.drawable.ic_noise_cancellation_disabled_24dp);
            }
            ImageView imageView4 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.header.voiceBott…etHeaderNoiseCancellation");
            imageView4.setVisibility(0);
        } else {
            ImageView imageView5 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.header.voiceBott…etHeaderNoiseCancellation");
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

    private final FeatureContext getFeatureContext() {
        return (FeatureContext) this.featureContext.getValue();
    }

    private final boolean getForwardToFullscreenIfVideoActivated() {
        return ((Boolean) this.forwardToFullscreenIfVideoActivated.getValue()).booleanValue();
    }

    private final WidgetVoiceBottomSheetViewModel getViewModel() {
        return (WidgetVoiceBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetVoiceBottomSheetViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowSuppressedDialog.INSTANCE)) {
            showSuppressedDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowServerMutedDialog.INSTANCE)) {
            showServerMutedDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowServerDeafenedDialog.INSTANCE)) {
            showServerDeafenedDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowNoVideoPermissionDialog.INSTANCE)) {
            showNoVideoPermissionDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowNoVideoDevicesAvailableToast.INSTANCE)) {
            showNoVideoDevicesToast();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowRequestCameraPermissionsDialog.INSTANCE)) {
            requestVideoCallPermissions(new AnonymousClass1());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowCameraCapacityDialog) {
            CameraCapacityDialog.Companion aVar = CameraCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.a(parentFragmentManager, ((WidgetVoiceBottomSheetViewModel.Event.ShowCameraCapacityDialog) event).getGuildMaxVideoChannelUsers());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowNoiseCancellationBottomSheet) {
            WidgetNoiseCancellationBottomSheet.INSTANCE.show(this);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.LaunchVideoCall) {
            Subscription subscription = this.viewModelEventSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            dismiss();
            WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetVoiceBottomSheetViewModel.Event.LaunchVideoCall launchVideoCall = (WidgetVoiceBottomSheetViewModel.Event.LaunchVideoCall) event;
            WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, launchVideoCall.getChannelId(), false, launchVideoCall.getAutoTargetStreamKey(), null, 20, null);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.LaunchStageChannel) {
            Subscription subscription2 = this.viewModelEventSubscription;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            dismiss();
            WidgetCallFullscreen.Companion companion2 = WidgetCallFullscreen.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            WidgetCallFullscreen.Companion.launch$default(companion2, contextRequireContext2, ((WidgetVoiceBottomSheetViewModel.Event.LaunchStageChannel) event).getChannelId(), false, null, null, 28, null);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion aVar2 = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            aVar2.a(parentFragmentManager2);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowToast) {
            AppToast.g(requireContext(), ((WidgetVoiceBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd) {
            WidgetEndGuildScheduledEventBottomSheet.Companion companion3 = WidgetEndGuildScheduledEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd showEventEnd = (WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd) event;
            companion3.show(parentFragmentManager3, END_EVENT_REQUEST_KEY, showEventEnd.getGuildScheduledEvent().getGuildId(), showEventEnd.getGuildScheduledEvent().getId());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet) {
            WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet) event;
            CallFeedbackSheetNavigator.INSTANCE.enqueueNotice(enqueueCallFeedbackSheet.getChannelId(), enqueueCallFeedbackSheet.getRtcConnectionId(), enqueueCallFeedbackSheet.getMediaSessionId(), Long.valueOf(enqueueCallFeedbackSheet.getCallDuration()), enqueueCallFeedbackSheet.getTriggerRateDenominator());
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.AccessibilityAnnouncement) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context contextRequireContext3 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            String string = getString(((WidgetVoiceBottomSheetViewModel.Event.AccessibilityAnnouncement) event).getMessageResId());
            Intrinsics3.checkNotNullExpressionValue(string, "getString(event.messageResId)");
            accessibilityUtils.sendAnnouncement(contextRequireContext3, string);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowNoScreenSharePermissionDialog) {
            showNoScreenSharePermissionDialog();
        } else if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.RequestStartStream.INSTANCE)) {
            StreamNavigator.requestStartStream(this);
        } else {
            if (!Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ExpandSheet.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            setBottomSheetState(3);
        }
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        int iOrdinal = getFeatureContext().ordinal();
        if (iOrdinal == 0) {
            AnimatableValueParser.S1(this, null, new AnonymousClass1(streamContext), 1, null);
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
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(R.string.no_screenshare_permission_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVideoDevicesToast() {
        AppToast.i(this, R.string.no_video_devices, 0, 4);
    }

    private final void showNoVideoPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
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
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
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
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
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
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.suppressed);
        String string2 = contextRequireContext.getString(R.string.suppressed_permission_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ppressed_permission_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_voice_bottom_sheet;
    }

    public final Function1<StreamContext, Unit> getOnStreamPreviewClickedListener() {
        return this.onStreamPreviewClickedListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, false, true, 2, null));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new AnonymousClass1());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new AnonymousClass2());
        getBinding().h.setHasFixedSize(false);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetVoiceBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetVoiceBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
        getBinding().f.setOnPttPressedListener(new AnonymousClass1(getViewModel()));
        WidgetEndGuildScheduledEventBottomSheet.INSTANCE.registerForResult(this, END_EVENT_REQUEST_KEY, new AnonymousClass2(getViewModel()));
    }

    public final void setOnStreamPreviewClickedListener(Function1<? super StreamContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClickedListener = function1;
    }
}
