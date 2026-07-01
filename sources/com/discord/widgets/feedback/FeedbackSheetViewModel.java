package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import rx.Observable;

/* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface FeedbackSheetViewModel {
    Observable<FeedbackSheetViewModel$Event> observeEvents();

    Observable<FeedbackSheetViewModel$ViewState> observeViewState();

    void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription);

    void selectRating(FeedbackRating feedbackRating);

    void submitForm();
}
