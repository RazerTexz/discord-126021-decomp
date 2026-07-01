package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreExpressionSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionSuggestions extends StoreV2 {
    public static final StoreExpressionSuggestions$Companion Companion = new StoreExpressionSuggestions$Companion(null);
    public static final long TRACKED_EXPRESSION_SUGGESTIONS_DISPLAYED_THROTTLE_WINDOW = 60000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private String lastSuggestionTrigger;
    private long lastTrackedExpressionSuggestionsDisplayed;
    private final ObservationDeck observationDeck;
    private boolean suggestionsEnabled;

    public /* synthetic */ StoreExpressionSuggestions(ObservationDeck observationDeck, Dispatcher dispatcher, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ boolean access$getSuggestionsEnabled$p(StoreExpressionSuggestions storeExpressionSuggestions) {
        return storeExpressionSuggestions.suggestionsEnabled;
    }

    public static final /* synthetic */ void access$setSuggestionsEnabled$p(StoreExpressionSuggestions storeExpressionSuggestions, boolean z2) {
        storeExpressionSuggestions.suggestionsEnabled = z2;
    }

    public final String getLastSuggestionTrigger() {
        return this.lastSuggestionTrigger;
    }

    @StoreThread
    public final void handleChannelSelected() {
        this.suggestionsEnabled = true;
        markChanged();
    }

    public final Observable<Boolean> observeSuggestionsEnabled() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreExpressionSuggestions$observeSuggestionsEnabled$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setExpressionSuggestionsEnabled(boolean enable) {
        this.dispatcher.schedule(new StoreExpressionSuggestions$setExpressionSuggestionsEnabled$1(this, enable));
    }

    public final void trackExpressionSuggestionsDisplayed(String suggestionTrigger) {
        m.checkNotNullParameter(suggestionTrigger, "suggestionTrigger");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (this.lastTrackedExpressionSuggestionsDisplayed + 60000 <= jCurrentTimeMillis) {
            this.lastTrackedExpressionSuggestionsDisplayed = jCurrentTimeMillis;
            AnalyticsTracker.INSTANCE.expressionSuggestionsDisplayed(suggestionTrigger);
            this.lastSuggestionTrigger = suggestionTrigger;
        }
    }

    public StoreExpressionSuggestions(ObservationDeck observationDeck, Dispatcher dispatcher, Clock clock) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.suggestionsEnabled = true;
        this.lastSuggestionTrigger = "";
    }
}
