package com.discord.widgets.voice.feedback;

import b.a.d.d0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: IssueDetailsFormViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IssueDetailsFormViewModel extends d0<Unit> {
    private final PublishSubject<IssueDetailsFormViewModel$Event> eventSubject;
    private final FeedbackSubmitter feedbackSubmitter;
    private final PendingFeedback pendingFeedback;
    private boolean submitted;

    public /* synthetic */ IssueDetailsFormViewModel(PendingFeedback pendingFeedback, FeedbackSubmitter feedbackSubmitter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingFeedback, (i & 2) != 0 ? FeedbackSubmitterFactory.INSTANCE.create(pendingFeedback) : feedbackSubmitter);
    }

    public final Observable<IssueDetailsFormViewModel$Event> observeEvents() {
        return this.eventSubject;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        submitForm(null);
    }

    public final void submitForm(String issueDetails) {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        this.feedbackSubmitter.submit(issueDetails);
        PublishSubject<IssueDetailsFormViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(IssueDetailsFormViewModel$Event$Close.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IssueDetailsFormViewModel(PendingFeedback pendingFeedback, FeedbackSubmitter feedbackSubmitter) {
        super(Unit.a);
        m.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        m.checkNotNullParameter(feedbackSubmitter, "feedbackSubmitter");
        this.pendingFeedback = pendingFeedback;
        this.feedbackSubmitter = feedbackSubmitter;
        PublishSubject<IssueDetailsFormViewModel$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
    }
}
