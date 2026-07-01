package com.discord.widgets.user;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.models.message.Message;
import com.discord.stores.StoreChat$InteractionState;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader {
    private StoreChat$InteractionState interactionState;
    private boolean isFocused;
    private Long loadBeforeMessageId;
    private Subscription loadSubscription;
    private final BehaviorSubject<WidgetUserMentions$Model$MessageLoader$LoadingState> mentionsLoadingStateSubject;
    private Function0<Unit> retryAction;
    private final long retryDelayMs;
    private Subscription retrySubscription;
    private final ArrayList<Message> mentions = new ArrayList<>();
    private final int mentionLimit = 25;
    private WidgetUserMentions$Model$MessageLoader$LoadingState mentionsLoadingState = new WidgetUserMentions$Model$MessageLoader$LoadingState(false, false, null, 7, null);
    private WidgetUserMentions$Model$MessageLoader$Filters filters = new WidgetUserMentions$Model$MessageLoader$Filters(0, false, false, false, 15, null);

    public WidgetUserMentions$Model$MessageLoader(long j) {
        this.retryDelayMs = j;
        BehaviorSubject<WidgetUserMentions$Model$MessageLoader$LoadingState> behaviorSubjectL0 = BehaviorSubject.l0(this.mentionsLoadingState);
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(mentionsLoadingState)");
        this.mentionsLoadingStateSubject = behaviorSubjectL0;
    }

    public static final /* synthetic */ Subscription access$getLoadSubscription$p(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        return widgetUserMentions$Model$MessageLoader.loadSubscription;
    }

    public static final /* synthetic */ Subscription access$getRetrySubscription$p(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        return widgetUserMentions$Model$MessageLoader.retrySubscription;
    }

    public static final /* synthetic */ void access$handleLoadError(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader) {
        widgetUserMentions$Model$MessageLoader.handleLoadError();
    }

    public static final /* synthetic */ void access$handleLoaded(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader, List list) {
        widgetUserMentions$Model$MessageLoader.handleLoaded(list);
    }

    public static final /* synthetic */ void access$setLoadSubscription$p(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader, Subscription subscription) {
        widgetUserMentions$Model$MessageLoader.loadSubscription = subscription;
    }

    public static final /* synthetic */ void access$setRetrySubscription$p(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader, Subscription subscription) {
        widgetUserMentions$Model$MessageLoader.retrySubscription = subscription;
    }

    @MainThread
    private final void handleLoadError() {
        retry(new WidgetUserMentions$Model$MessageLoader$handleLoadError$1(this));
    }

    @MainThread
    private final void handleLoaded(List<Message> messages) {
        boolean z2 = messages.isEmpty() || messages.size() < this.mentionLimit;
        Message message = (Message) u.lastOrNull((List) messages);
        this.loadBeforeMessageId = message != null ? Long.valueOf(message.getId()) : null;
        this.mentions.addAll(messages);
        setMentionsLoadingState(WidgetUserMentions$Model$MessageLoader$LoadingState.copy$default(this.mentionsLoadingState, false, false, new ArrayList(this.mentions), 3, null));
        retry(new WidgetUserMentions$Model$MessageLoader$handleLoaded$1(this, z2));
    }

    private final void retry(Function0<Unit> retryAction) {
        Subscription subscription = this.retrySubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.retryAction = retryAction;
        Observable<Long> observableD0 = Observable.d0(this.retryDelayMs, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable.timer(retryDe…s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableD0), WidgetUserMentions$Model$MessageLoader.class, (Context) null, new WidgetUserMentions$Model$MessageLoader$retry$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetUserMentions$Model$MessageLoader$retry$2(retryAction), 58, (Object) null);
    }

    private final void setMentionsLoadingState(WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState) {
        if (m.areEqual(this.mentionsLoadingState, widgetUserMentions$Model$MessageLoader$LoadingState)) {
            return;
        }
        this.mentionsLoadingState = widgetUserMentions$Model$MessageLoader$LoadingState;
        this.mentionsLoadingStateSubject.onNext(widgetUserMentions$Model$MessageLoader$LoadingState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tryLoad$default(WidgetUserMentions$Model$MessageLoader widgetUserMentions$Model$MessageLoader, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = WidgetUserMentions$Model$MessageLoader$tryLoad$1.INSTANCE;
        }
        widgetUserMentions$Model$MessageLoader.tryLoad(function1);
    }

    public final WidgetUserMentions$Model$MessageLoader$Filters getFilters() {
        return this.filters;
    }

    public final BehaviorSubject<WidgetUserMentions$Model$MessageLoader$LoadingState> getMentionsLoadingStateSubject() {
        return this.mentionsLoadingStateSubject;
    }

    @MainThread
    public final void setFilters(WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters) {
        m.checkNotNullParameter(widgetUserMentions$Model$MessageLoader$Filters, "value");
        if (!m.areEqual(this.filters, widgetUserMentions$Model$MessageLoader$Filters)) {
            this.filters = widgetUserMentions$Model$MessageLoader$Filters;
            Subscription subscription = this.loadSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.loadBeforeMessageId = null;
            this.mentions.clear();
            tryLoad(WidgetUserMentions$Model$MessageLoader$filters$1.INSTANCE);
        }
    }

    @MainThread
    public final void setInteractionState(StoreChat$InteractionState interactionState) {
        m.checkNotNullParameter(interactionState, "interactionState");
        this.interactionState = interactionState;
        tryLoad$default(this, null, 1, null);
    }

    @MainThread
    public final void setIsFocused(boolean isFocused) {
        this.isFocused = isFocused;
        tryLoad$default(this, null, 1, null);
    }

    @MainThread
    public final void tryLoad(Function1<? super WidgetUserMentions$Model$MessageLoader$LoadingState, WidgetUserMentions$Model$MessageLoader$LoadingState> loadingStateUpdater) {
        StoreChat$InteractionState storeChat$InteractionState;
        m.checkNotNullParameter(loadingStateUpdater, "loadingStateUpdater");
        setMentionsLoadingState(loadingStateUpdater.invoke(this.mentionsLoadingState));
        if (this.mentionsLoadingState.isLoading() || this.mentionsLoadingState.isAllLoaded() || (storeChat$InteractionState = this.interactionState) == null || !storeChat$InteractionState.isAtTopIgnoringTouch() || !this.isFocused) {
            return;
        }
        setMentionsLoadingState(WidgetUserMentions$Model$MessageLoader$LoadingState.copy$default(this.mentionsLoadingState, true, false, null, 6, null));
        Observable observableG = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getMentions(this.mentionLimit, this.filters.getIncludeRoles(), this.filters.getIncludeEveryone(), Long.valueOf(this.filters.getAllGuilds() ? 0L : this.filters.getGuildId()), this.loadBeforeMessageId), false, 1, null)).G(WidgetUserMentions$Model$MessageLoader$tryLoad$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "RestAPI\n            .api…messages.map(::Message) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetUserMentions$Model$MessageLoader.class, (Context) null, new WidgetUserMentions$Model$MessageLoader$tryLoad$5(this), new WidgetUserMentions$Model$MessageLoader$tryLoad$3(this), (Function0) null, (Function0) null, new WidgetUserMentions$Model$MessageLoader$tryLoad$4(this), 50, (Object) null);
    }
}
