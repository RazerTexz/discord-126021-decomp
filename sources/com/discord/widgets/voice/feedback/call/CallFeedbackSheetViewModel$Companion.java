package com.discord.widgets.voice.feedback.call;

import androidx.annotation.VisibleForTesting;
import com.discord.stores.StoreExperiments;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSheetViewModel$Companion {
    private CallFeedbackSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(CallFeedbackSheetViewModel$Companion callFeedbackSheetViewModel$Companion, StoreExperiments storeExperiments) {
        return callFeedbackSheetViewModel$Companion.observeStoreState(storeExperiments);
    }

    @VisibleForTesting
    public static /* synthetic */ void getREASON_CODES$annotations() {
    }

    private final Observable<CallFeedbackSheetViewModel$StoreState> observeStoreState(StoreExperiments storeExperiments) {
        Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(CallFeedbackSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
        return observableG;
    }

    public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
        return CallFeedbackSheetViewModel.access$getISSUES_UI_OPTIONS$cp();
    }

    public final Map<FeedbackIssue, Integer> getREASON_CODES() {
        return CallFeedbackSheetViewModel.access$getREASON_CODES$cp();
    }

    public /* synthetic */ CallFeedbackSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
