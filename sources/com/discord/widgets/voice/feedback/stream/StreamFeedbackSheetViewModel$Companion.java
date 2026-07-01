package com.discord.widgets.voice.feedback.stream;

import com.discord.stores.StoreExperiments;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSheetViewModel$Companion {
    private StreamFeedbackSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(StreamFeedbackSheetViewModel$Companion streamFeedbackSheetViewModel$Companion, StoreExperiments storeExperiments) {
        return streamFeedbackSheetViewModel$Companion.observeStoreState(storeExperiments);
    }

    private final Observable<StreamFeedbackSheetViewModel$StoreState> observeStoreState(StoreExperiments storeExperiments) {
        Observable observableG = storeExperiments.observeUserExperiment("2020-08_feedback_modal_helpdesk_link", true).G(StreamFeedbackSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "storeExperiments\n       …            )\n          }");
        return observableG;
    }

    public final List<FeedbackIssue> getISSUES_UI_OPTIONS() {
        return StreamFeedbackSheetViewModel.access$getISSUES_UI_OPTIONS$cp();
    }

    public /* synthetic */ StreamFeedbackSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
