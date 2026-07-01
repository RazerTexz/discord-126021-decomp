package com.discord.widgets.guild_delete_feedback;

import b.a.d.d0;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.feedback.FeedbackSheetViewModel$DefaultImpls;
import com.discord.widgets.feedback.FeedbackSheetViewModel$Event;
import com.discord.widgets.feedback.FeedbackSheetViewModel$Event$NavigateToIssueDetails;
import com.discord.widgets.feedback.FeedbackSheetViewModel$Event$Submitted;
import com.discord.widgets.feedback.FeedbackSheetViewModel$ViewState;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback$GuildDeleteFeedback;
import d0.t.m;
import d0.t.n;
import d0.t.u;
import java.util.Collection;
import java.util.List;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildDeleteFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetViewModel extends d0<FeedbackSheetViewModel$ViewState> implements FeedbackSheetViewModel {
    public static final GuildDeleteFeedbackSheetViewModel$Companion Companion = new GuildDeleteFeedbackSheetViewModel$Companion(null);
    private static final List<FeedbackIssue> REASONS = n.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.GUILD_DELETE_TOO_HARD, FeedbackIssue.GUILD_DELETE_TEST, FeedbackIssue.GUILD_DELETE_ACCIDENT, FeedbackIssue.GUILD_DELETE_TEMPLATE, FeedbackIssue.GUILD_DELETE_LONELY, FeedbackIssue.GUILD_DELETE_INACTIVE});
    private final PublishSubject<FeedbackSheetViewModel$Event> eventSubject;
    private PendingFeedback$GuildDeleteFeedback pendingFeedback;
    private boolean submitted;

    public GuildDeleteFeedbackSheetViewModel(long j) {
        super(new FeedbackSheetViewModel$ViewState(FeedbackRating.NO_RESPONSE, u.plus((Collection<? extends FeedbackIssue>) m.shuffled(REASONS), FeedbackIssue.GUILD_DELETE_OTHER), 2131890004, null, 2131890003, 8, null));
        this.eventSubject = PublishSubject.k0();
        this.pendingFeedback = new PendingFeedback$GuildDeleteFeedback(j, null, null, 6, null);
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public Observable<FeedbackSheetViewModel$Event> observeEvents() {
        PublishSubject<FeedbackSheetViewModel$Event> publishSubject = this.eventSubject;
        d0.z.d.m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        submitForm();
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription) {
        PendingFeedback$GuildDeleteFeedback pendingFeedback$GuildDeleteFeedbackCopy$default = PendingFeedback$GuildDeleteFeedback.copy$default(this.pendingFeedback, 0L, feedbackIssue, null, 5, null);
        this.pendingFeedback = pendingFeedback$GuildDeleteFeedbackCopy$default;
        if (feedbackIssue != FeedbackIssue.GUILD_DELETE_OTHER) {
            submitForm();
            return;
        }
        PublishSubject<FeedbackSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FeedbackSheetViewModel$Event$NavigateToIssueDetails(pendingFeedback$GuildDeleteFeedbackCopy$default, false));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        d0.z.d.m.checkNotNullParameter(feedbackRating, "feedbackRating");
        FeedbackSheetViewModel$DefaultImpls.selectRating(this, feedbackRating);
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
        this.eventSubject.k.onNext(new FeedbackSheetViewModel$Event$Submitted(z2));
    }
}
