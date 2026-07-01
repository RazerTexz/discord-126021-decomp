package com.discord.widgets.voice.feedback.call;

import android.content.Context;
import b.a.d.d0;
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
import com.discord.widgets.voice.feedback.PendingFeedback$CallFeedback;
import d0.o;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetViewModel extends d0<FeedbackSheetViewModel$ViewState> implements FeedbackSheetViewModel {
    public static final CallFeedbackSheetViewModel$Companion Companion = new CallFeedbackSheetViewModel$Companion(null);
    private static final List<FeedbackIssue> ISSUES_UI_OPTIONS;
    private static final Map<FeedbackIssue, Integer> REASON_CODES;
    private final PublishSubject<FeedbackSheetViewModel$Event> eventSubject;
    private final List<FeedbackIssue> issuesUiOptions;
    private CallFeedbackSheetViewModel$StoreState mostRecentStoreState;
    private PendingFeedback$CallFeedback pendingCallFeedback;
    private final StoreAnalytics storeAnalytics;
    private final StoreExperiments storeExperiments;
    private boolean submitOnDismiss;
    private boolean submitted;

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
        ISSUES_UI_OPTIONS = n.listOf((Object[]) new FeedbackIssue[]{feedbackIssue, feedbackIssue2, feedbackIssue3, feedbackIssue4, feedbackIssue5, feedbackIssue6, feedbackIssue7, feedbackIssue8, feedbackIssue9});
        REASON_CODES = h0.mapOf(o.to(FeedbackIssue.OTHER, 1), o.to(feedbackIssue, 2), o.to(feedbackIssue2, 3), o.to(feedbackIssue3, 4), o.to(feedbackIssue4, 5), o.to(feedbackIssue5, 6), o.to(feedbackIssue6, 7), o.to(feedbackIssue7, 8), o.to(feedbackIssue8, 9), o.to(feedbackIssue9, 10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CallFeedbackSheetViewModel(CallFeedbackSheetViewModel$Config callFeedbackSheetViewModel$Config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeAnalytics = (i & 2) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        storeExperiments = (i & 4) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments;
        this(callFeedbackSheetViewModel$Config, storeAnalytics, storeExperiments, (i & 8) != 0 ? CallFeedbackSheetViewModel$Companion.access$observeStoreState(Companion, storeExperiments) : observable);
    }

    public static final /* synthetic */ List access$getISSUES_UI_OPTIONS$cp() {
        return ISSUES_UI_OPTIONS;
    }

    public static final /* synthetic */ CallFeedbackSheetViewModel$StoreState access$getMostRecentStoreState$p(CallFeedbackSheetViewModel callFeedbackSheetViewModel) {
        return callFeedbackSheetViewModel.mostRecentStoreState;
    }

    public static final /* synthetic */ Map access$getREASON_CODES$cp() {
        return REASON_CODES;
    }

    public static final /* synthetic */ void access$setMostRecentStoreState$p(CallFeedbackSheetViewModel callFeedbackSheetViewModel, CallFeedbackSheetViewModel$StoreState callFeedbackSheetViewModel$StoreState) {
        callFeedbackSheetViewModel.mostRecentStoreState = callFeedbackSheetViewModel$StoreState;
    }

    private final FeedbackSheetViewModel$ViewState createViewState(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues) {
        return new FeedbackSheetViewModel$ViewState(selectedFeedbackRating, feedbackIssues, 2131887380, 2131887376, 2131887365);
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
        PendingFeedback$CallFeedback pendingFeedback$CallFeedbackCopy$default = PendingFeedback$CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, null, REASON_CODES.get(feedbackIssue), reasonDescription, null, Opcodes.IF_ICMPEQ, null);
        this.pendingCallFeedback = pendingFeedback$CallFeedbackCopy$default;
        if (feedbackIssue == FeedbackIssue.OTHER) {
            this.submitOnDismiss = false;
            PublishSubject<FeedbackSheetViewModel$Event> publishSubject = this.eventSubject;
            CallFeedbackSheetViewModel$StoreState callFeedbackSheetViewModel$StoreState = this.mostRecentStoreState;
            publishSubject.k.onNext(new FeedbackSheetViewModel$Event$NavigateToIssueDetails(pendingFeedback$CallFeedbackCopy$default, callFeedbackSheetViewModel$StoreState != null ? callFeedbackSheetViewModel$StoreState.getShouldShowCxLinkForIssueDetails() : false));
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
        this.pendingCallFeedback = PendingFeedback$CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, feedbackRating, null, null, null, 239, null);
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
        this.storeAnalytics.trackCallReportProblem(this.pendingCallFeedback);
        emitSubmittedEvent(selectedFeedbackRating != FeedbackRating.NO_RESPONSE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetViewModel(CallFeedbackSheetViewModel$Config callFeedbackSheetViewModel$Config, StoreAnalytics storeAnalytics, StoreExperiments storeExperiments, Observable<CallFeedbackSheetViewModel$StoreState> observable) {
        super(new FeedbackSheetViewModel$ViewState(FeedbackRating.NO_RESPONSE, n.emptyList(), 2131887380, 2131887376, 2131887365));
        m.checkNotNullParameter(callFeedbackSheetViewModel$Config, "config");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExperiments = storeExperiments;
        this.eventSubject = PublishSubject.k0();
        this.submitOnDismiss = true;
        this.pendingCallFeedback = new PendingFeedback$CallFeedback(callFeedbackSheetViewModel$Config.getChannelId(), callFeedbackSheetViewModel$Config.getRtcConnectionId(), callFeedbackSheetViewModel$Config.getCallDurationMs(), callFeedbackSheetViewModel$Config.getMediaSessionId(), null, null, null, null, 240, null);
        this.issuesUiOptions = u.plus((Collection<? extends FeedbackIssue>) d0.t.m.shuffled(ISSUES_UI_OPTIONS), FeedbackIssue.OTHER);
        storeAnalytics.trackShowCallFeedbackSheet(callFeedbackSheetViewModel$Config.getChannelId());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), CallFeedbackSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new CallFeedbackSheetViewModel$1(this), 62, (Object) null);
    }
}
