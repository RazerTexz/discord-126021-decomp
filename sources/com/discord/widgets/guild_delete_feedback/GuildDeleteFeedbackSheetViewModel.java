package com.discord.widgets.guild_delete_feedback;

import com.discord.C5419R;
import com.discord.widgets.feedback.FeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import java.util.Collection;
import java.util.List;
import p007b.p008a.p018d.AbstractC0859d0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildDeleteFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetViewModel extends AbstractC0859d0<FeedbackSheetViewModel.ViewState> implements FeedbackSheetViewModel {
    private static final List<FeedbackIssue> REASONS = C12147n.listOf((Object[]) new FeedbackIssue[]{FeedbackIssue.GUILD_DELETE_TOO_HARD, FeedbackIssue.GUILD_DELETE_TEST, FeedbackIssue.GUILD_DELETE_ACCIDENT, FeedbackIssue.GUILD_DELETE_TEMPLATE, FeedbackIssue.GUILD_DELETE_LONELY, FeedbackIssue.GUILD_DELETE_INACTIVE});
    private final PublishSubject<FeedbackSheetViewModel.Event> eventSubject;
    private PendingFeedback.GuildDeleteFeedback pendingFeedback;
    private boolean submitted;

    public GuildDeleteFeedbackSheetViewModel(long j) {
        super(new FeedbackSheetViewModel.ViewState(FeedbackRating.NO_RESPONSE, C12163u.plus((Collection<? extends FeedbackIssue>) C12145m.shuffled(REASONS), FeedbackIssue.GUILD_DELETE_OTHER), C5419R.string.guild_delete_feedback_header, null, C5419R.string.guild_delete_feedback_body, 8, null));
        this.eventSubject = PublishSubject.m11133k0();
        this.pendingFeedback = new PendingFeedback.GuildDeleteFeedback(j, null, null, 6, null);
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
        publishSubject.f27650k.onNext(new FeedbackSheetViewModel.Event.NavigateToIssueDetails(guildDeleteFeedbackCopy$default, false));
    }

    @Override // com.discord.widgets.feedback.FeedbackSheetViewModel
    public void selectRating(FeedbackRating feedbackRating) {
        C12238m.checkNotNullParameter(feedbackRating, "feedbackRating");
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
        this.eventSubject.f27650k.onNext(new FeedbackSheetViewModel.Event.Submitted(z2));
    }
}
