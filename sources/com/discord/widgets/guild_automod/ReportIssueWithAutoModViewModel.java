package com.discord.widgets.guild_automod;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportIssueWithAutoModViewModel extends d0<ReportIssueWithAutoModViewModel$ViewState> {
    public static final ReportIssueWithAutoModViewModel$Companion Companion = new ReportIssueWithAutoModViewModel$Companion(null);
    private final long channelId;
    private final long messageId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeMessages = (i & 4) != 0 ? StoreStream.Companion.getMessages() : storeMessages;
        this(j, j2, storeMessages, (i & 8) != 0 ? ReportIssueWithAutoModViewModel$Companion.access$observeStores(Companion, j, j2, storeMessages) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ReportIssueWithAutoModViewModel reportIssueWithAutoModViewModel, ReportIssueWithAutoModViewModel$StoreState reportIssueWithAutoModViewModel$StoreState) {
        reportIssueWithAutoModViewModel.handleStoreState(reportIssueWithAutoModViewModel$StoreState);
    }

    private final void handleStoreState(ReportIssueWithAutoModViewModel$StoreState storeState) {
        String value;
        ReportIssueWithAutoModViewModel$ViewState reportIssueWithAutoModViewModel$ViewState$Valid;
        ReportIssueWithAutoModViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof ReportIssueWithAutoModViewModel$ViewState$Valid)) {
            viewState = null;
        }
        ReportIssueWithAutoModViewModel$ViewState$Valid reportIssueWithAutoModViewModel$ViewState$Valid2 = (ReportIssueWithAutoModViewModel$ViewState$Valid) viewState;
        if (storeState.getMessage() == null) {
            reportIssueWithAutoModViewModel$ViewState$Valid = ReportIssueWithAutoModViewModel$ViewState$Invalid.INSTANCE;
        } else {
            Message message = storeState.getMessage();
            if (reportIssueWithAutoModViewModel$ViewState$Valid2 == null || (value = reportIssueWithAutoModViewModel$ViewState$Valid2.getSelectedOption()) == null) {
                value = FeedbackType.ALLOWED.getValue();
            }
            reportIssueWithAutoModViewModel$ViewState$Valid = new ReportIssueWithAutoModViewModel$ViewState$Valid(message, value);
        }
        updateViewState(reportIssueWithAutoModViewModel$ViewState$Valid);
    }

    public final void onFeedbackTypeSelected(FeedbackType feedbackType) {
        m.checkNotNullParameter(feedbackType, "feedbackType");
        ReportIssueWithAutoModViewModel$ViewState viewState = getViewState();
        if (viewState instanceof ReportIssueWithAutoModViewModel$ViewState$Valid) {
            updateViewState(ReportIssueWithAutoModViewModel$ViewState$Valid.copy$default((ReportIssueWithAutoModViewModel$ViewState$Valid) viewState, null, feedbackType.getValue(), 1, null));
        }
    }

    public final void onSubmit(Function0<Unit> onCompleted) {
        String embedFieldValue;
        m.checkNotNullParameter(onCompleted, "onCompleted");
        ReportIssueWithAutoModViewModel$ViewState viewState = getViewState();
        if (viewState instanceof ReportIssueWithAutoModViewModel$ViewState$Valid) {
            ReportIssueWithAutoModViewModel$ViewState$Valid reportIssueWithAutoModViewModel$ViewState$Valid = (ReportIssueWithAutoModViewModel$ViewState$Valid) viewState;
            List<MessageEmbed> embeds = reportIssueWithAutoModViewModel$ViewState$Valid.getMessage().getEmbeds();
            MessageEmbed messageEmbed = embeds != null ? (MessageEmbed) u.first((List) embeds) : null;
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            if (messageEmbed == null || (embedFieldValue = AutoModUtils.INSTANCE.getEmbedFieldValue(messageEmbed, "decision_id")) == null) {
                embedFieldValue = "";
            }
            long id2 = reportIssueWithAutoModViewModel$ViewState$Valid.getMessage().getId();
            String content = reportIssueWithAutoModViewModel$ViewState$Valid.getMessage().getContent();
            analyticsTracker.trackReportIssueWithAutoMod(embedFieldValue, id2, reportIssueWithAutoModViewModel$ViewState$Valid.getSelectedOption(), content != null ? content : "");
            onCompleted.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportIssueWithAutoModViewModel(long j, long j2, StoreMessages storeMessages, Observable<ReportIssueWithAutoModViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeMessages, "messageStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.messageId = j2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ReportIssueWithAutoModViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ReportIssueWithAutoModViewModel$1(this), 62, (Object) null);
    }
}
