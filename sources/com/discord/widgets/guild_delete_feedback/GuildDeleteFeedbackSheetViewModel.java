package com.discord.widgets.guild_delete_feedback;

import b.a.d.AppViewModel;
import com.discord.R;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildDeleteFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetViewModel extends AppViewModel<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {
    private static final List<FeedbackIssue> REASONS = Collections2.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.GUILD_DELETE_TOO_HARD, FeedbackIssue.GUILD_DELETE_TEST, FeedbackIssue.GUILD_DELETE_ACCIDENT, FeedbackIssue.GUILD_DELETE_TEMPLATE, FeedbackIssue.GUILD_DELETE_LONELY, FeedbackIssue.GUILD_DELETE_INACTIVE});
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private PendingFeedback.GuildDeleteFeedback pendingFeedback;
    private boolean submitted;

    public GuildDeleteFeedbackSheetViewModel(long j) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, _Collections.plus((Collection<? extends FeedbackIssue>) CollectionsJVM.shuffled(REASONS), FeedbackIssue.GUILD_DELETE_OTHER), R.string.guild_delete_feedback_header, null, R.string.guild_delete_feedback_body, 8, null));
        this.eventSubject = PublishSubject.k0();
        this.pendingFeedback = new PendingFeedback.GuildDeleteFeedback(j, null, null, 6, null);
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
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback.GuildDeleteFeedback guildDeleteFeedbackCopy$default = PendingFeedback.GuildDeleteFeedback.copy$default(this.pendingFeedback, 0L, feedbackIssue, null, 5, null);
        this.pendingFeedback = guildDeleteFeedbackCopy$default;
        if (feedbackIssue != FeedbackIssue.GUILD_DELETE_OTHER) {
            submitForm();
            return;
        }
        PublishSubject<FeedbackSheetViewModel.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(guildDeleteFeedbackCopy$default, false));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
        FeedbackSheetViewModel.DefaultImpls.selectRating(this, feedbackRating);
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void submitForm() {
        if (this.submitted) {
            return;
        }
        this.submitted = true;
        boolean z2 = this.pendingFeedback.getReason() != null;
        if (z2) {
            new GuildDeleteFeedbackSubmitter(this.pendingFeedback).submit(null);
        } else {
            new GuildDeleteFeedbackSubmitter(this.pendingFeedback).skip();
        }
        this.eventSubject.k.onNext(new FeedbackSheetViewModel.Event.Submitted(z2));
    }
}
