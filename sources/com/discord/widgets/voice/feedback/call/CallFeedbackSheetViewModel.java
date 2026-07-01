package com.discord.widgets.voice.feedback.call;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetViewModel extends AppViewModel<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS;
    private static final Map<FeedbackIssue, Integer> REASON_CODES;
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StoreState mostRecentStoreState;
    private PendingFeedback.CallFeedback pendingCallFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* JADX INFO: renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            CallFeedbackSheetViewModel.this.mostRecentStoreState = storeState;
        }
    }

    /* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getREASON_CODES$annotations() {
        }

        private final Observable<StoreState> observeStoreState(StoreExperiments storeExperiments) {
            Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(new Func1<Experiment, StoreState>() { // from class: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final CallFeedbackSheetViewModel.StoreState call(Experiment experiment) {
                    return new CallFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
            return observableG;
        }

        public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
            return CallFeedbackSheetViewModel.ISSUES_UI_OPTIONS;
        }

        public final Map<FeedbackIssue, Integer> getREASON_CODES() {
            return CallFeedbackSheetViewModel.REASON_CODES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
    public static final /* data */ class Config implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long callDurationMs;
        private final long channelId;
        private final String mediaSessionId;
        private final String rtcConnectionId;

        /* JADX INFO: renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Config$CREATOR, reason: from kotlin metadata */
        /* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
        public static final class Companion implements Parcelable.Creator<Config> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Config createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "parcel");
                return new Config(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Config[] newArray(int size) {
                return new Config[size];
            }
        }

        public Config(long j, String str, String str2, Long l) {
            this.channelId = j;
            this.rtcConnectionId = str;
            this.mediaSessionId = str2;
            this.callDurationMs = l;
        }

        public static /* synthetic */ Config copy$default(Config config, long j, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = config.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = config.rtcConnectionId;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = config.mediaSessionId;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                l = config.callDurationMs;
            }
            return config.copy(j2, str3, str4, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getCallDurationMs() {
            return this.callDurationMs;
        }

        public final Config copy(long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs) {
            return new Config(channelId, rtcConnectionId, mediaSessionId, callDurationMs);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.channelId == config.channelId && Intrinsics3.areEqual(this.rtcConnectionId, config.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, config.mediaSessionId) && Intrinsics3.areEqual(this.callDurationMs, config.callDurationMs);
        }

        public final Long getCallDurationMs() {
            return this.callDurationMs;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final String getRtcConnectionId() {
            return this.rtcConnectionId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            String str = this.rtcConnectionId;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.mediaSessionId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.callDurationMs;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Config(channelId=");
            sbU.append(this.channelId);
            sbU.append(", rtcConnectionId=");
            sbU.append(this.rtcConnectionId);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", callDurationMs=");
            return outline.G(sbU, this.callDurationMs, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.channelId);
            parcel.writeString(this.rtcConnectionId);
            parcel.writeString(this.mediaSessionId);
            parcel.writeValue(this.callDurationMs);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Config(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            String string2 = parcel.readString();
            Object value = parcel.readValue(Long.TYPE.getClassLoader());
            this(j, string, string2, (Long) (value instanceof Long ? value : null));
        }
    }

    /* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean shouldShowCxLinkForIssueDetails;

        public StoreState(boolean z2) {
            this.shouldShowCxLinkForIssueDetails = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.shouldShowCxLinkForIssueDetails;
            }
            return storeState.copy(z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShouldShowCxLinkForIssueDetails() {
            return this.shouldShowCxLinkForIssueDetails;
        }

        public final StoreState copy(boolean shouldShowCxLinkForIssueDetails) {
            return new StoreState(shouldShowCxLinkForIssueDetails);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && this.shouldShowCxLinkForIssueDetails == ((StoreState) other).shouldShowCxLinkForIssueDetails;
            }
            return true;
        }

        public final boolean getShouldShowCxLinkForIssueDetails() {
            return this.shouldShowCxLinkForIssueDetails;
        }

        public int hashCode() {
            boolean z2 = this.shouldShowCxLinkForIssueDetails;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.O(outline.U("StoreState(shouldShowCxLinkForIssueDetails="), this.shouldShowCxLinkForIssueDetails, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FeedbackRating.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackRating.NO_RESPONSE.ordinal()] = 1;
            iArr[FeedbackRating.GOOD.ordinal()] = 2;
            FeedbackRating feedbackRating = FeedbackRating.NEUTRAL;
            iArr[feedbackRating.ordinal()] = 3;
            FeedbackRating feedbackRating2 = FeedbackRating.BAD;
            iArr[feedbackRating2.ordinal()] = 4;
            FeedbackRating.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[feedbackRating.ordinal()] = 1;
            iArr2[feedbackRating2.ordinal()] = 2;
        }
    }

    static {
        FeedbackIssue feedbackIssue = FeedbackIssue.COULD_NOT_HEAR_AUDIO;
        FeedbackIssue feedbackIssue2 = FeedbackIssue.NOBODY_COULD_HEAR_ME;
        FeedbackIssue feedbackIssue3 = FeedbackIssue.AUDIO_ECHOS;
        FeedbackIssue feedbackIssue4 = FeedbackIssue.AUDIO_ROBOTIC;
        FeedbackIssue feedbackIssue5 = FeedbackIssue.AUDIO_CUT_IN_AND_OUT;
        FeedbackIssue feedbackIssue6 = FeedbackIssue.VOLUME_TOO_LOW_OR_HIGH;
        FeedbackIssue feedbackIssue7 = FeedbackIssue.BACKGROUND_NOISE_TOO_LOUD;
        FeedbackIssue feedbackIssue8 = FeedbackIssue.SPEAKERPHONE_ISSUE;
        FeedbackIssue feedbackIssue9 = FeedbackIssue.HEADSET_OR_BLUETOOTH_ISSUE;
        ISSUES_UI_OPTIONS = Collections2.listOf((Object[]) new FeedbackIssue[]{feedbackIssue, feedbackIssue2, feedbackIssue3, feedbackIssue4, feedbackIssue5, feedbackIssue6, feedbackIssue7, feedbackIssue8, feedbackIssue9});
        REASON_CODES = Maps6.mapOf(Tuples.to(FeedbackIssue.OTHER, 1), Tuples.to(feedbackIssue, 2), Tuples.to(feedbackIssue2, 3), Tuples.to(feedbackIssue3, 4), Tuples.to(feedbackIssue4, 5), Tuples.to(feedbackIssue5, 6), Tuples.to(feedbackIssue6, 7), Tuples.to(feedbackIssue7, 8), Tuples.to(feedbackIssue8, 9), Tuples.to(feedbackIssue9, 10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CallFeedbackSheetViewModel(Config config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeAnalytics = (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        storeExperiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        this(config, storeAnalytics, storeExperiments, (i & 8) != 0 ? INSTANCE.observeStoreState(storeExperiments) : observable);
    }

    private final FeedbackSheetViewModel.ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel.ViewState(selectedFeedbackRating, feedbackIssues, R.string.call_feedback_sheet_title, Integer.valueOf(R.string.call_feedback_prompt), R.string.call_feedback_issue_section_header);
    }

    private final void emitSubmittedEvent(boolean showConfirmation) {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel.Event.Submitted(showConfirmation));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public Observable<FeedbackSheetViewModel.Event> observeEvents() {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.submitOnDismiss) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback.CallFeedback callFeedback = this.pendingCallFeedback;
        PendingFeedback.CallFeedback callFeedbackCopy = callFeedback.copy((Opcodes.IF_ICMPEQ & 1) != 0 ? callFeedback.channelId : 0L, (Opcodes.IF_ICMPEQ & 2) != 0 ? callFeedback.rtcConnectionId : null, (Opcodes.IF_ICMPEQ & 4) != 0 ? callFeedback.durationMs : null, (Opcodes.IF_ICMPEQ & 8) != 0 ? callFeedback.mediaSessionId : null, (Opcodes.IF_ICMPEQ & 16) != 0 ? callFeedback.feedbackRating : null, (Opcodes.IF_ICMPEQ & 32) != 0 ? callFeedback.reasonCode : REASON_CODES.get(feedbackIssue), (Opcodes.IF_ICMPEQ & 64) != 0 ? callFeedback.reasonDescription : reasonDescription, (Opcodes.IF_ICMPEQ & 128) != 0 ? callFeedback.issueDetails : null);
        this.pendingCallFeedback = callFeedbackCopy;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
            StoreState storeState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(callFeedbackCopy, storeState != null ? storeState.getShouldShowCxLinkForIssueDetails() : false));
            return;
        }
        int iOrdinal = requireViewState().getSelectedFeedbackRating().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
        PendingFeedback.CallFeedback callFeedback = this.pendingCallFeedback;
        this.pendingCallFeedback = callFeedback.copy((Opcodes.IF_ICMPEQ & 1) != 0 ? callFeedback.channelId : 0L, (Opcodes.IF_ICMPEQ & 2) != 0 ? callFeedback.rtcConnectionId : null, (Opcodes.IF_ICMPEQ & 4) != 0 ? callFeedback.durationMs : null, (Opcodes.IF_ICMPEQ & 8) != 0 ? callFeedback.mediaSessionId : null, (Opcodes.IF_ICMPEQ & 16) != 0 ? callFeedback.feedbackRating : feedbackRating, (Opcodes.IF_ICMPEQ & 32) != 0 ? callFeedback.reasonCode : null, (Opcodes.IF_ICMPEQ & 64) != 0 ? callFeedback.reasonDescription : null, (Opcodes.IF_ICMPEQ & 128) != 0 ? callFeedback.issueDetails : null);
        int iOrdinal = feedbackRating.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                updateViewState(createViewState(feedbackRating, this.issuesUiOptions));
                return;
            } else if (iOrdinal != 3) {
                return;
            }
        }
        selectIssue(null, null);
        updateViewState(createViewState(feedbackRating, Collections2.emptyList()));
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void submitForm() {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        FeedbackRating selectedFeedbackRating = requireViewState().getSelectedFeedbackRating();
        this.storeAnalytics.trackCallReportProblem(this.pendingCallFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetViewModel(Config config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable<StoreState> observable) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, Collections2.emptyList(), R.string.call_feedback_sheet_title, Integer.valueOf(R.string.call_feedback_prompt), R.string.call_feedback_issue_section_header));
        Intrinsics3.checkNotNullParameter(config, "config");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExperiments = storeExperiments;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        this.pendingCallFeedback = new PendingFeedback.CallFeedback(config.getChannelId(), config.getRtcConnectionId(), config.getCallDurationMs(), config.getMediaSessionId(), null, null, null, null, 240, null);
        this.issuesUiOptions = _Collections.plus((Collection<? extends FeedbackIssue>) CollectionsJVM.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        storeAnalytics.trackShowCallFeedbackSheet(config.getChannelId());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) CallFeedbackSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
