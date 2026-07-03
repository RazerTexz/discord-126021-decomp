package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreExpressionSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionSuggestions extends StoreV2 {
    public static final long TRACKED_EXPRESSION_SUGGESTIONS_DISPLAYED_THROTTLE_WINDOW = 60000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private String lastSuggestionTrigger;
    private long lastTrackedExpressionSuggestionsDisplayed;
    private final ObservationDeck observationDeck;
    private boolean suggestionsEnabled;

    /* JADX INFO: renamed from: com.discord.stores.StoreExpressionSuggestions$observeSuggestionsEnabled$1 */
    /* JADX INFO: compiled from: StoreExpressionSuggestions.kt */
    public static final class C59291 extends AbstractC12240o implements Function0<Boolean> {
        public C59291() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreExpressionSuggestions.this.suggestionsEnabled;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExpressionSuggestions$setExpressionSuggestionsEnabled$1 */
    /* JADX INFO: compiled from: StoreExpressionSuggestions.kt */
    public static final class C59301 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $enable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59301(boolean z2) {
            super(0);
            this.$enable = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpressionSuggestions.this.suggestionsEnabled = this.$enable;
            StoreExpressionSuggestions.this.markChanged();
        }
    }

    public /* synthetic */ StoreExpressionSuggestions(ObservationDeck observationDeck, Dispatcher dispatcher, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? ClockFactory.get() : clock);
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
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59291(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void setExpressionSuggestionsEnabled(boolean enable) {
        this.dispatcher.schedule(new C59301(enable));
    }

    public final void trackExpressionSuggestionsDisplayed(String suggestionTrigger) {
        C12238m.checkNotNullParameter(suggestionTrigger, "suggestionTrigger");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (this.lastTrackedExpressionSuggestionsDisplayed + 60000 <= jCurrentTimeMillis) {
            this.lastTrackedExpressionSuggestionsDisplayed = jCurrentTimeMillis;
            AnalyticsTracker.INSTANCE.expressionSuggestionsDisplayed(suggestionTrigger);
            this.lastSuggestionTrigger = suggestionTrigger;
        }
    }

    public StoreExpressionSuggestions(ObservationDeck observationDeck, Dispatcher dispatcher, Clock clock) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(clock, "clock");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.suggestionsEnabled = true;
        this.lastSuggestionTrigger = "";
    }
}
