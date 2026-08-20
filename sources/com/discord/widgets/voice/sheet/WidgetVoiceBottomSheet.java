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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModelKt;
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
import com.discord.widgets.voice.stream.StreamNavigator;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0833j;
import p007b.p008a.p009a.C0836m;
import p007b.p008a.p009a.p014f.p015a.C0826a;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1052t0;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetVoiceBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", 0)};

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
                return C1643a.m827O(C1643a.m833U("Connect(isConnectEnabled="), this.isConnectEnabled, ")");
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
                C12238m.checkNotNullParameter(inputMode, "inputMode");
                C12238m.checkNotNullParameter(state, "audioManagerState");
                C12238m.checkNotNullParameter(cameraState, "cameraState");
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
                C12238m.checkNotNullParameter(inputMode, "inputMode");
                C12238m.checkNotNullParameter(audioManagerState, "audioManagerState");
                C12238m.checkNotNullParameter(cameraState, "cameraState");
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
                return C12238m.areEqual(this.inputMode, controls.inputMode) && C12238m.areEqual(this.audioManagerState, controls.audioManagerState) && this.isMuted == controls.isMuted && C12238m.areEqual(this.cameraState, controls.cameraState) && this.showScreenShareSparkle == controls.showScreenShareSparkle && this.isScreensharing == controls.isScreensharing;
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
                StringBuilder sbM833U = C1643a.m833U("Controls(inputMode=");
                sbM833U.append(this.inputMode);
                sbM833U.append(", audioManagerState=");
                sbM833U.append(this.audioManagerState);
                sbM833U.append(", isMuted=");
                sbM833U.append(this.isMuted);
                sbM833U.append(", cameraState=");
                sbM833U.append(this.cameraState);
                sbM833U.append(", showScreenShareSparkle=");
                sbM833U.append(this.showScreenShareSparkle);
                sbM833U.append(", isScreensharing=");
                return C1643a.m827O(sbM833U, this.isScreensharing, ")");
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
                C12238m.checkNotNullParameter(list, "items");
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
                C12238m.checkNotNullParameter(items, "items");
                return new Empty(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && C12238m.areEqual(this.items, ((Empty) other).items);
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
                return C1643a.m824L(C1643a.m833U("Empty(items="), this.items, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
        public static final /* data */ class ListItems extends CenterContent {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ListItems(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "items");
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
                C12238m.checkNotNullParameter(items, "items");
                return new ListItems(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ListItems) && C12238m.areEqual(this.items, ((ListItems) other).items);
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
                return C1643a.m824L(C1643a.m833U("ListItems(items="), this.items, ")");
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
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(featureContext, "featureContext");
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

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C105751 extends C12236k implements Function0<Unit> {
        public C105751(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onMutePressed", "onMutePressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onMutePressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$2 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C105762 extends C12236k implements Function0<Unit> {
        public C105762(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onScreenSharePressed", "onScreenSharePressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onScreenSharePressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$3 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105773 extends AbstractC12240o implements Function0<Unit> {
        public C105773() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C0826a.Companion companion = C0826a.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            new C0826a().show(parentFragmentManager, C0826a.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$4 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C105784 extends C12236k implements Function0<Unit> {
        public C105784(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onCameraButtonPressed", "onCameraButtonPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onCameraButtonPressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$5 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C105795 extends C12236k implements Function0<Unit> {
        public C105795(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnectPressed", "onDisconnectPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnectPressed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$6 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105806 extends AbstractC12240o implements Function0<Unit> {
        public C105806() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C105831 extends C12236k implements Function1<StreamContext, Unit> {
        public C105831(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
            super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            C12238m.checkNotNullParameter(streamContext, "p1");
            ((WidgetVoiceBottomSheet) this.receiver).onStreamPreviewClicked(streamContext);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$2 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105842 extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105842(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            C12238m.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetVoiceBottomSheet.this.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$3 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105853 extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public C105853() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            C12238m.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetVoiceBottomSheet.this.getViewModel().onToggleRingingPressed(voiceUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$4 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105864 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105864(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetVoiceBottomSheet.this, this.$channel, WidgetVoiceBottomSheet.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$5 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105875 extends AbstractC12240o implements Function0<Unit> {
        public C105875() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetVoiceBottomSheet.this.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(C5419R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(C5419R.string.embedded_activities_desktop_only_modal_description);
            C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$handleEvent$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105921 extends AbstractC12240o implements Function0<Unit> {
        public C105921() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.this.getViewModel().onCameraPermissionsGranted();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onActivityResult$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105931 extends AbstractC12240o implements Function1<Intent, Unit> {
        public C105931() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
            invoke2(intent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Intent intent) {
            C12238m.checkNotNullParameter(intent, "it");
            WidgetVoiceBottomSheet.this.getViewModel().startStream(intent);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105941 extends AbstractC12240o implements Function1<GuildScheduledEvent, Unit> {
        public C105941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105952 extends AbstractC12240o implements Function1<GuildScheduledEvent, Unit> {
        public C105952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetVoiceBottomSheetBinding binding = WidgetVoiceBottomSheet.this.getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            CoordinatorLayout coordinatorLayout = binding.f18437a;
            C12238m.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
            Context context = coordinatorLayout.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(context, GuildScheduledEventModelKt.toModel(guildScheduledEvent), (24 & 4) != 0 ? null : new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$3 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105963 extends AbstractC12240o implements Function1<WidgetVoiceBottomSheetViewModel.ViewState, Unit> {
        public C105963() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceBottomSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$4 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C105974 extends C12236k implements Function1<WidgetVoiceBottomSheetViewModel.Event, Unit> {
        public C105974(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
            super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceBottomSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetVoiceBottomSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$5 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105985 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C105985() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetVoiceBottomSheet.this.viewModelEventSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onStreamPreviewClicked$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final class C105991 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105991(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.this.getViewModel().onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C106001 extends C12236k implements Function1<Boolean, Unit> {
        public C106001(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(1, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onPttPressed", "onPttPressed(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onPttPressed(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
    public static final /* synthetic */ class C106012 extends C12236k implements Function0<Unit> {
        public C106012(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnect", "onDisconnect()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnect();
        }
    }

    public WidgetVoiceBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetVoiceBottomSheet$channelId$2(this));
        this.forwardToFullscreenIfVideoActivated = C12083g.lazy(new WidgetVoiceBottomSheet$forwardToFullscreenIfVideoActivated$2(this));
        WidgetVoiceBottomSheet$viewModel$2 widgetVoiceBottomSheet$viewModel$2 = new WidgetVoiceBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetVoiceBottomSheetViewModel.class), new WidgetVoiceBottomSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetVoiceBottomSheet$viewModel$2));
        this.featureContext = C12083g.lazy(new WidgetVoiceBottomSheet$featureContext$2(this));
        this.onStreamPreviewClickedListener = WidgetVoiceBottomSheet$onStreamPreviewClickedListener$1.INSTANCE;
    }

    private final void configureBottomContent(BottomContent bottomContent, Channel channel) {
        if (bottomContent == null) {
            AnchoredVoiceControlsView anchoredVoiceControlsView = getBinding().f18442f;
            C12238m.checkNotNullExpressionValue(anchoredVoiceControlsView, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().f18441e;
            C12238m.checkNotNullExpressionValue(relativeLayout, "binding.voiceBottomSheetConnectContainer");
            relativeLayout.setVisibility(8);
            CoordinatorLayout coordinatorLayout = getBinding().f18445i;
            CoordinatorLayout coordinatorLayout2 = getBinding().f18445i;
            C12238m.checkNotNullExpressionValue(coordinatorLayout2, "binding.voiceBottomSheetRoot");
            coordinatorLayout.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout2, C5419R.attr.colorBackgroundPrimary));
            return;
        }
        if (bottomContent instanceof BottomContent.Controls) {
            AnchoredVoiceControlsView anchoredVoiceControlsView2 = getBinding().f18442f;
            C12238m.checkNotNullExpressionValue(anchoredVoiceControlsView2, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView2.setVisibility(0);
            RelativeLayout relativeLayout2 = getBinding().f18441e;
            C12238m.checkNotNullExpressionValue(relativeLayout2, "binding.voiceBottomSheetConnectContainer");
            relativeLayout2.setVisibility(8);
            AnchoredVoiceControlsView anchoredVoiceControlsView3 = getBinding().f18442f;
            BottomContent.Controls controls = (BottomContent.Controls) bottomContent;
            MediaEngineConnection.InputMode inputMode = controls.getInputMode();
            boolean zIsMuted = controls.isMuted();
            boolean zIsScreensharing = controls.isScreensharing();
            CameraState cameraState = controls.getCameraState();
            C105751 c105751 = new C105751(getViewModel());
            C105762 c105762 = new C105762(getViewModel());
            C105773 c105773 = new C105773();
            C105784 c105784 = new C105784(getViewModel());
            C105795 c105795 = new C105795(getViewModel());
            boolean showScreenShareSparkle = controls.getShowScreenShareSparkle();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            anchoredVoiceControlsView3.configureUI(inputMode, controls.getAudioManagerState(), zIsMuted, zIsScreensharing, showScreenShareSparkle, cameraState, c105751, c105762, c105773, c105784, c105795, this, parentFragmentManager, new C105806(), getChannelId(), channel.getGuildId(), getForwardToFullscreenIfVideoActivated(), getFeatureContext());
            CoordinatorLayout coordinatorLayout3 = getBinding().f18445i;
            CoordinatorLayout coordinatorLayout4 = getBinding().f18445i;
            C12238m.checkNotNullExpressionValue(coordinatorLayout4, "binding.voiceBottomSheetRoot");
            coordinatorLayout3.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout4, C5419R.attr.colorBackgroundSecondary));
        } else if (bottomContent instanceof BottomContent.Connect) {
            AnchoredVoiceControlsView anchoredVoiceControlsView4 = getBinding().f18442f;
            C12238m.checkNotNullExpressionValue(anchoredVoiceControlsView4, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView4.setVisibility(4);
            getBinding().f18442f.hidePtt();
            RelativeLayout relativeLayout3 = getBinding().f18441e;
            C12238m.checkNotNullExpressionValue(relativeLayout3, "binding.voiceBottomSheetConnectContainer");
            relativeLayout3.setVisibility(0);
            BottomContent.Connect connect = (BottomContent.Connect) bottomContent;
            if (connect.isConnectEnabled()) {
                getBinding().f18440d.setText(C5419R.string.join_voice_channel_cta);
                MaterialButton materialButton = getBinding().f18440d;
                C12238m.checkNotNullExpressionValue(materialButton, "binding.voiceBottomSheetConnect");
                materialButton.setEnabled(true);
            } else {
                getBinding().f18440d.setText(C5419R.string.channel_locked_short);
                MaterialButton materialButton2 = getBinding().f18440d;
                C12238m.checkNotNullExpressionValue(materialButton2, "binding.voiceBottomSheetConnect");
                materialButton2.setEnabled(false);
            }
            getBinding().f18440d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureBottomContent.7

                /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$7$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WidgetVoiceBottomSheet.this.getViewModel().tryConnectToVoice(false);
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C1460d.m473S1(WidgetVoiceBottomSheet.this, null, new AnonymousClass1(), 1, null);
                }
            });
            MaterialButton materialButton3 = getBinding().f18443g;
            C12238m.checkNotNullExpressionValue(materialButton3, "binding.voiceBottomSheetJoinVideo");
            materialButton3.setEnabled(connect.isConnectEnabled());
            getBinding().f18443g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureBottomContent.8

                /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$8$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
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
            CoordinatorLayout coordinatorLayout5 = getBinding().f18445i;
            CoordinatorLayout coordinatorLayout6 = getBinding().f18445i;
            C12238m.checkNotNullExpressionValue(coordinatorLayout6, "binding.voiceBottomSheetRoot");
            coordinatorLayout5.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout6, C5419R.attr.colorBackgroundPrimary));
        }
    }

    private final void configureCenterContent(CenterContent centerContent, Channel channel) {
        if (!(centerContent instanceof CenterContent.ListItems)) {
            if (!(centerContent instanceof CenterContent.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            C1052t0 c1052t0 = getBinding().f18438b;
            C12238m.checkNotNullExpressionValue(c1052t0, "binding.empty");
            LinearLayout linearLayout = c1052t0.f1238a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.empty.root");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().f18444h;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
            CenterContent.Empty empty = (CenterContent.Empty) centerContent;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        C1052t0 c1052t1 = getBinding().f18438b;
        C12238m.checkNotNullExpressionValue(c1052t1, "binding.empty");
        LinearLayout linearLayout2 = c1052t1.f1238a;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.empty.root");
        linearLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().f18444h;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.voiceBottomSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((CenterContent.ListItems) centerContent).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new C105831(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new C105842(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnToggleRingingClicked(new C105853());
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnInviteFriendsClicked(new C105864(channel));
        CallParticipantsAdapter callParticipantsAdapter7 = this.participantsAdapter;
        if (callParticipantsAdapter7 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter7.setOnEmbeddedActivityClicked(new C105875());
    }

    private final void configureUI(final WidgetVoiceBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().f18439c.f1279g;
        C12238m.checkNotNullExpressionValue(textView, "binding.header.voiceBottomSheetHeaderTitle");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().f18439c.f1278f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.header.voiceBottomSheetHeaderSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView2, viewState.getSubtitle());
        ImageView imageView = getBinding().f18439c.f1274b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView.setActivated(viewState.getIsDeafened());
        ImageView imageView2 = getBinding().f18439c.f1274b;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView2.setContentDescription(viewState.getIsDeafened() ? getString(C5419R.string.undeafen) : getString(C5419R.string.deafen));
        getBinding().f18439c.f1274b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceBottomSheet.this.getViewModel().onDeafenPressed();
            }
        });
        ImageView imageView3 = getBinding().f18439c.f1275c;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.header.voiceBottomSheetHeaderInvite");
        imageView3.setVisibility(viewState.getShowInviteOption() ? 0 : 8);
        getBinding().f18439c.f1275c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetVoiceBottomSheet.this, viewState.getChannel(), WidgetVoiceBottomSheet.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
            }
        });
        getBinding().f18439c.f1277e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
                Context contextRequireContext = WidgetVoiceBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                WidgetSettingsVoice.Companion.launch$default(companion, contextRequireContext, null, false, 6, null);
            }
        });
        getBinding().f18439c.f1276d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceBottomSheet.this.getViewModel().onNoiseCancellationPressed();
            }
        });
        if (viewState.getIsNoiseCancellationActive() != null) {
            if (C12238m.areEqual(viewState.getIsNoiseCancellationActive(), Boolean.TRUE)) {
                getBinding().f18439c.f1276d.setImageResource(C5419R.drawable.ic_noise_cancellation_active_24dp);
            } else {
                getBinding().f18439c.f1276d.setImageResource(C5419R.drawable.ic_noise_cancellation_disabled_24dp);
            }
            ImageView imageView4 = getBinding().f18439c.f1276d;
            C12238m.checkNotNullExpressionValue(imageView4, "binding.header.voiceBott…etHeaderNoiseCancellation");
            imageView4.setVisibility(0);
        } else {
            ImageView imageView5 = getBinding().f18439c.f1276d;
            C12238m.checkNotNullExpressionValue(imageView5, "binding.header.voiceBott…etHeaderNoiseCancellation");
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
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowSuppressedDialog.INSTANCE)) {
            showSuppressedDialog();
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowServerMutedDialog.INSTANCE)) {
            showServerMutedDialog();
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowServerDeafenedDialog.INSTANCE)) {
            showServerDeafenedDialog();
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowNoVideoPermissionDialog.INSTANCE)) {
            showNoVideoPermissionDialog();
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowNoVideoDevicesAvailableToast.INSTANCE)) {
            showNoVideoDevicesToast();
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowRequestCameraPermissionsDialog.INSTANCE)) {
            requestVideoCallPermissions(new C105921());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowCameraCapacityDialog) {
            C0833j.Companion aVar = C0833j.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.m137a(parentFragmentManager, ((WidgetVoiceBottomSheetViewModel.Event.ShowCameraCapacityDialog) event).getGuildMaxVideoChannelUsers());
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
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
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
            C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            WidgetCallFullscreen.Companion.launch$default(companion2, contextRequireContext2, ((WidgetVoiceBottomSheetViewModel.Event.LaunchStageChannel) event).getChannelId(), false, null, null, 28, null);
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            C0836m.Companion aVar2 = C0836m.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            aVar2.m140a(parentFragmentManager2);
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowToast) {
            C0876m.m169g(requireContext(), ((WidgetVoiceBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd) {
            WidgetEndGuildScheduledEventBottomSheet.Companion companion3 = WidgetEndGuildScheduledEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd showEventEnd = (WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd) event;
            companion3.show(parentFragmentManager3, END_EVENT_REQUEST_KEY, showEventEnd.getGuildScheduledEvent().getGuildId(), showEventEnd.getGuildScheduledEvent().getId());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet) {
            WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet) event;
            CallFeedbackSheetNavigator.INSTANCE.enqueueNotice(enqueueCallFeedbackSheet.getChannelId(), enqueueCallFeedbackSheet.getRtcConnectionId(), enqueueCallFeedbackSheet.getMediaSessionId(), Long.valueOf(enqueueCallFeedbackSheet.getCallDuration()), enqueueCallFeedbackSheet.getTriggerRateDenominator());
            return;
        }
        if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.AccessibilityAnnouncement) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context contextRequireContext3 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            String string = getString(((WidgetVoiceBottomSheetViewModel.Event.AccessibilityAnnouncement) event).getMessageResId());
            C12238m.checkNotNullExpressionValue(string, "getString(event.messageResId)");
            accessibilityUtils.sendAnnouncement(contextRequireContext3, string);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowNoScreenSharePermissionDialog) {
            showNoScreenSharePermissionDialog();
        } else if (C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.RequestStartStream.INSTANCE)) {
            StreamNavigator.requestStartStream(this);
        } else {
            if (!C12238m.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ExpandSheet.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            setBottomSheetState(3);
        }
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        int iOrdinal = getFeatureContext().ordinal();
        if (iOrdinal == 0) {
            C1460d.m473S1(this, null, new C105991(streamContext), 1, null);
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
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(C5419R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(C5419R.string.no_screenshare_permission_dialog_body);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVideoDevicesToast() {
        C0876m.m171i(this, C5419R.string.no_video_devices, 0, 4);
    }

    private final void showNoVideoPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(C5419R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(C5419R.string.no_video_permission_dialog_body);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…o_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerDeafenedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(C5419R.string.server_deafened_dialog_title);
        String string2 = contextRequireContext.getString(C5419R.string.server_deafened_dialog_body);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ver_deafened_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerMutedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(C5419R.string.server_muted_dialog_title);
        String string2 = contextRequireContext.getString(C5419R.string.server_muted_dialog_body);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…server_muted_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showSuppressedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(C5419R.string.suppressed);
        String string2 = contextRequireContext.getString(C5419R.string.suppressed_permission_body);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…ppressed_permission_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(C5419R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_voice_bottom_sheet;
    }

    public final Function1<StreamContext, Unit> getOnStreamPreviewClickedListener() {
        return this.onStreamPreviewClickedListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new C105931());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f18444h;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, false, true, 2, null));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new C105941());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new C105952());
        getBinding().f18444h.setHasFixedSize(false);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetVoiceBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105963());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetVoiceBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C105985()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C105974(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
        getBinding().f18442f.setOnPttPressedListener(new C106001(getViewModel()));
        WidgetEndGuildScheduledEventBottomSheet.INSTANCE.registerForResult(this, END_EVENT_REQUEST_KEY, new C106012(getViewModel()));
    }

    public final void setOnStreamPreviewClickedListener(Function1<? super StreamContext, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClickedListener = function1;
    }
}
