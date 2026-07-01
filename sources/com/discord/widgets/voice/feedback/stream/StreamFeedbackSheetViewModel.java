package com.discord.widgets.voice.feedback.stream;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.feedback.FeedbackSheetViewModel$Event;
import com.discord.widgets.feedback.FeedbackSheetViewModel$Event$NavigateToIssueDetails;
import com.discord.widgets.feedback.FeedbackSheetViewModel$Event$Submitted;
import com.discord.widgets.feedback.FeedbackSheetViewModel$ViewState;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback$StreamFeedback;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel extends d0<FeedbackSheetViewModel$ViewState> implements FeedbackSheetViewModel {
    public static final StreamFeedbackSheetViewModel$Companion Companion = new StreamFeedbackSheetViewModel$Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS = n.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.STREAM_REPORT_ENDED_BLACK, FeedbackIssue.STREAM_REPORT_ENDED_BLURRY, FeedbackIssue.STREAM_REPORT_ENDED_LAGGING, FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING, FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR, FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY});
    private final PublishSubject<FeedbackSheetViewModel$Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private StreamFeedbackSheetViewModel$StoreState mostRecentStoreState;
    private PendingFeedback$StreamFeedback pendingStreamFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private final ModelApplicationStream stream;
    private boolean submitOnDismiss;
    private boolean submitted;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments;
        this(str, str2, experiments, (i & 8) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics, (i & 16) != 0 ? StreamFeedbackSheetViewModel$Companion.access$observeStoreState(Companion, experiments) : observable);
    }

    public static final /* synthetic */ List access$getISSUES_UI_OPTIONS$cp() {
        return ISSUES_UI_OPTIONS;
    }

    public static final /* synthetic */ StreamFeedbackSheetViewModel$StoreState access$getMostRecentStoreState$p(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel) {
        return streamFeedbackSheetViewModel.mostRecentStoreState;
    }

    public static final /* synthetic */ void access$setMostRecentStoreState$p(StreamFeedbackSheetViewModel streamFeedbackSheetViewModel, StreamFeedbackSheetViewModel$StoreState streamFeedbackSheetViewModel$StoreState) {
        streamFeedbackSheetViewModel.mostRecentStoreState = streamFeedbackSheetViewModel$StoreState;
    }

    private final FeedbackSheetViewModel$ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel$ViewState(selectedFeedbackRating, feedbackIssues, 2131896050, 2131896071, 2131896065);
    }

    private final void emitSubmittedEvent(boolean showConfirmation) {
        PublishSubject<FeedbackSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel$Event$Submitted(showConfirmation));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public Observable<FeedbackSheetViewModel$Event> observeEvents() {
        PublishSubject<FeedbackSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.submitOnDismiss) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback$StreamFeedback pendingFeedback$StreamFeedbackCopy$default = PendingFeedback$StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, feedbackIssue, null, null, 27, null);
        this.pendingStreamFeedback = pendingFeedback$StreamFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel$Event> publishSubject = this.eventSubject;
            StreamFeedbackSheetViewModel$StoreState streamFeedbackSheetViewModel$StoreState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel$Event$NavigateToIssueDetails(pendingFeedback$StreamFeedbackCopy$default, streamFeedbackSheetViewModel$StoreState != null ? streamFeedbackSheetViewModel$StoreState.getShouldShowCxLinkForIssueDetails() : false));
            return;
        }
        int iOrdinal = requireViewState().getSelectedFeedbackRating().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            submitForm();
        }
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        this.pendingStreamFeedback = PendingFeedback$StreamFeedback.copy$default(this.pendingStreamFeedback, null, feedbackRating, null, null, null, 29, null);
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
        updateViewState(createViewState(feedbackRating, n.emptyList()));
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
    public StreamFeedbackSheetViewModel(String str, String str2, StoreExperiments storeExperiments, StoreAnalytics storeAnalytics, Observable<StreamFeedbackSheetViewModel$StoreState> observable) {
        super(new FeedbackSheetViewModel$ViewState(FeedbackRating.NO_RESPONSE, n.emptyList(), 2131896050, 2131896071, 2131896065));
        m.checkNotNullParameter(str, "streamKey");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeExperiments = storeExperiments;
        this.storeAnalytics = storeAnalytics;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.Companion.decodeStreamKey(str);
        this.stream = modelApplicationStreamDecodeStreamKey;
        this.pendingStreamFeedback = new PendingFeedback$StreamFeedback(modelApplicationStreamDecodeStreamKey, null, null, str2, null, 22, null);
        this.issuesUiOptions = u.plus((Collection<? extends FeedbackIssue>) d0.t.m.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), StreamFeedbackSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StreamFeedbackSheetViewModel$1(this), 62, (Object) null);
    }
}
