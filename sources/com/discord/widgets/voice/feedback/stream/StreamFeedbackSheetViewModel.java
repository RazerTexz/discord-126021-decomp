package com.discord.widgets.voice.feedback.stream;

import com.discord.C5419R;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel extends AbstractC0859d0<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS = C12147n.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.STREAM_REPORT_ENDED_BLACK, FeedbackIssue.STREAM_REPORT_ENDED_BLURRY, FeedbackIssue.STREAM_REPORT_ENDED_LAGGING, FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR, FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY});
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StoreState mostRecentStoreState;
    private PendingFeedback.StreamFeedback pendingStreamFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private final ModelApplicationStream stream;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* JADX INFO: renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel$1 */
    /* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
    public static final class C104561 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C104561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            StreamFeedbackSheetViewModel.this.mostRecentStoreState = storeState;
        }
    }

    /* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreExperiments storeExperiments) {
            Observable observableM11083G = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).m11083G(new InterfaceC12589b<Experiment, StoreState>() { // from class: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final StreamFeedbackSheetViewModel.StoreState call(Experiment experiment) {
                    return new StreamFeedbackSheetViewModel.StoreState(experiment != null && experiment.getBucket() == 1);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "storeExperiments\n       …            )\n          }");
            return observableM11083G;
        }

        public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
            return StreamFeedbackSheetViewModel.ISSUES_UI_OPTIONS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
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
            return C1643a.m827O(C1643a.m833U("StoreState(shouldShowCxLinkForIssueDetails="), this.shouldShowCxLinkForIssueDetails, ")");
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        this(str, str2, experiments, (i & 8) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 16) != 0 ? INSTANCE.observeStoreState(experiments) : observable);
    }

    private final FeedbackSheetViewModel.ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel.ViewState(selectedFeedbackRating, feedbackIssues, C5419R.string.stream_report_a_problem_post_stream, Integer.valueOf(C5419R.string.stream_report_rating_body), C5419R.string.stream_report_placeholder);
    }

    private final void emitSubmittedEvent(boolean showConfirmation) {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new FeedbackSheetViewModel.Event.Submitted(showConfirmation));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public Observable<FeedbackSheetViewModel.Event> observeEvents() {
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // p007b.p008a.p018d.AbstractC0859d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.submitOnDismiss) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback.StreamFeedback streamFeedbackCopy$default = PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, feedbackIssue, null, null, 27, null);
        this.pendingStreamFeedback = streamFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
            StoreState storeState = this.mostRecentStoreState;
            publishSubject.f27650k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(streamFeedbackCopy$default, storeState != null ? storeState.getShouldShowCxLinkForIssueDetails() : false));
            return;
        }
        int iOrdinal = requireViewState().getSelectedFeedbackRating().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        C12238m.checkNotNullParameter(feedbackRating, "feedbackRating");
        this.pendingStreamFeedback = PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, feedbackRating, null, null, null, 29, null);
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
        updateViewState(createViewState(feedbackRating, C12147n.emptyList()));
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void submitForm() {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        FeedbackRating selectedFeedbackRating = requireViewState().getSelectedFeedbackRating();
        this.storeAnalytics.trackStreamReportProblem(this.pendingStreamFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable<StoreState> observable) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, C12147n.emptyList(), C5419R.string.stream_report_a_problem_post_stream, Integer.valueOf(C5419R.string.stream_report_rating_body), C5419R.string.stream_report_placeholder));
        C12238m.checkNotNullParameter(str, "streamKey");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeExperiments = storeExperiments;
        this.storeAnalytics = storeAnalytics;
        this.eventSubject = PublishSubject.m11133k0();
        this.submitOnDismiss = true;
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(str);
        this.stream = modelApplicationStreamDecodeStreamKey;
        this.pendingStreamFeedback = new PendingFeedback.StreamFeedback(modelApplicationStreamDecodeStreamKey, null, null, str2, null, 22, null);
        this.issuesUiOptions = C12163u.plus((Collection<? extends FeedbackIssue>) C12145m.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) StreamFeedbackSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C104561());
    }
}
