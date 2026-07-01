package com.discord.widgets.status;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.restapi.RestAPIParams$ThreadSettings;
import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel extends d0<WidgetThreadStatusViewModel$ViewState> {
    public static final WidgetThreadStatusViewModel$Companion Companion = new WidgetThreadStatusViewModel$Companion(null);
    private WidgetThreadStatusViewModel$StoreState currentStoreState;
    private final PublishSubject<WidgetThreadStatus$Event> eventSubject;
    private final Observable<WidgetThreadStatusViewModel$StoreState> storeStateObservable;

    public WidgetThreadStatusViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetThreadStatusViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? WidgetThreadStatusViewModel$Companion.observeStoreState$default(Companion, null, null, null, null, null, 31, null) : observable);
    }

    public static final /* synthetic */ void access$emitError(WidgetThreadStatusViewModel widgetThreadStatusViewModel, int i) {
        widgetThreadStatusViewModel.emitError(i);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadStatusViewModel widgetThreadStatusViewModel, WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState) {
        widgetThreadStatusViewModel.handleStoreState(widgetThreadStatusViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewLoading(WidgetThreadStatusViewModel widgetThreadStatusViewModel, boolean z2) {
        widgetThreadStatusViewModel.updateViewLoading(z2);
    }

    private final void emitError(int code) {
        PublishSubject<WidgetThreadStatus$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetThreadStatus$Event$Error(code));
    }

    private final void handleStoreState(WidgetThreadStatusViewModel$StoreState storeState) {
        WidgetThreadStatusViewModel$Status widgetThreadStatusViewModel$Status$Archived;
        this.currentStoreState = storeState;
        Channel selectedChannel = storeState.getSelectedChannel();
        Channel parentChannel = storeState.getParentChannel();
        Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> activeJoinedThreads = storeState.getActiveJoinedThreads();
        Channel selectedChannel2 = storeState.getSelectedChannel();
        StoreThreadsActiveJoined$ActiveJoinedThread storeThreadsActiveJoined$ActiveJoinedThread = null;
        Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread> map = activeJoinedThreads.get(selectedChannel2 != null ? Long.valueOf(selectedChannel2.getParentId()) : null);
        if (map != null) {
            Channel selectedChannel3 = storeState.getSelectedChannel();
            storeThreadsActiveJoined$ActiveJoinedThread = map.get(selectedChannel3 != null ? Long.valueOf(selectedChannel3.getId()) : null);
        }
        boolean z2 = false;
        boolean z3 = storeThreadsActiveJoined$ActiveJoinedThread != null;
        if (selectedChannel == null || !ChannelUtils.H(selectedChannel)) {
            widgetThreadStatusViewModel$Status$Archived = WidgetThreadStatusViewModel$Status$Hide.INSTANCE;
        } else if (parentChannel != null && ChannelUtils.q(parentChannel) && storeState.getCanAccessRedesignedForumChannels()) {
            widgetThreadStatusViewModel$Status$Archived = WidgetThreadStatusViewModel$Status$Hide.INSTANCE;
        } else {
            ThreadMetadata threadMetadata = selectedChannel.getThreadMetadata();
            if (threadMetadata == null || !threadMetadata.getArchived()) {
                widgetThreadStatusViewModel$Status$Archived = z3 ? WidgetThreadStatusViewModel$Status$Hide.INSTANCE : WidgetThreadStatusViewModel$Status$Unjoined.INSTANCE;
            } else {
                ThreadMetadata threadMetadata2 = selectedChannel.getThreadMetadata();
                if (threadMetadata2 != null && threadMetadata2.getLocked()) {
                    z2 = true;
                }
                widgetThreadStatusViewModel$Status$Archived = new WidgetThreadStatusViewModel$Status$Archived(z2, storeState.getCanArchive());
            }
        }
        updateViewWithStatus(widgetThreadStatusViewModel$Status$Archived);
    }

    private final void updateViewLoading(boolean isLoading) {
        WidgetThreadStatusViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetThreadStatusViewModel$ViewState.copy$default(viewState, null, isLoading, 1, null));
        }
    }

    private final void updateViewWithStatus(WidgetThreadStatusViewModel$Status status) {
        updateViewState(new WidgetThreadStatusViewModel$ViewState(status, false, 2, null));
    }

    public final Observable<WidgetThreadStatusViewModel$StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<WidgetThreadStatus$Event> observeEvents() {
        PublishSubject<WidgetThreadStatus$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onJoinTapped() {
        WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState = this.currentStoreState;
        if (widgetThreadStatusViewModel$StoreState != null) {
            if (widgetThreadStatusViewModel$StoreState.getSelectedChannel() == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().joinThread(widgetThreadStatusViewModel$StoreState.getSelectedChannel().getId(), "Banner", new RestAPIParams$EmptyBody()), false, 1, null), this, null, 2, null), WidgetThreadStatusViewModel.class, (Context) null, (Function1) null, new WidgetThreadStatusViewModel$onJoinTapped$$inlined$let$lambda$1(this), (Function0) null, new WidgetThreadStatusViewModel$onJoinTapped$$inlined$let$lambda$2(this), WidgetThreadStatusViewModel$onJoinTapped$1$2.INSTANCE, 22, (Object) null);
        }
        updateViewLoading(true);
    }

    public final void onUnarchiveTapped() {
        WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState = this.currentStoreState;
        if (widgetThreadStatusViewModel$StoreState != null) {
            if (widgetThreadStatusViewModel$StoreState.getSelectedChannel() == null) {
                return;
            }
            RestAPI api = RestAPI.Companion.getApi();
            long id2 = widgetThreadStatusViewModel$StoreState.getSelectedChannel().getId();
            Boolean bool = Boolean.FALSE;
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams$ThreadSettings(bool, widgetThreadStatusViewModel$StoreState.isModerator() ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), WidgetThreadStatusViewModel.class, (Context) null, (Function1) null, new WidgetThreadStatusViewModel$onUnarchiveTapped$$inlined$let$lambda$1(this), (Function0) null, new WidgetThreadStatusViewModel$onUnarchiveTapped$$inlined$let$lambda$2(this), WidgetThreadStatusViewModel$onUnarchiveTapped$1$2.INSTANCE, 22, (Object) null);
        }
        updateViewLoading(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatusViewModel(Observable<WidgetThreadStatusViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadStatusViewModel$1(this), 62, (Object) null);
    }
}
