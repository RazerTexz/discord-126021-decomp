package com.discord.stores;

import android.content.Context;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.spotify.ModelSpotifyAlbum;
import com.discord.models.domain.spotify.ModelSpotifyAlbum$AlbumImage;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spotify.SpotifyApiClient;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.t;
import d0.g0.w;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSpotify {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Subscription expireStateSub;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private final SpotifyApiClient spotifyApiClient;
    private StoreSpotify$SpotifyState spotifyState;
    private final StoreStream stream;

    public StoreSpotify(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.publishStateTrigger = BehaviorSubject.k0();
        this.spotifyApiClient = new SpotifyApiClient(clock);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreSpotify storeSpotify) {
        return storeSpotify.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSpotify storeSpotify) {
        return storeSpotify.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getExpireStateSub$p(StoreSpotify storeSpotify) {
        return storeSpotify.expireStateSub;
    }

    public static final /* synthetic */ BehaviorSubject access$getPublishStateTrigger$p(StoreSpotify storeSpotify) {
        return storeSpotify.publishStateTrigger;
    }

    public static final /* synthetic */ StoreSpotify$SpotifyState access$getSpotifyState$p(StoreSpotify storeSpotify) {
        return storeSpotify.spotifyState;
    }

    public static final /* synthetic */ void access$publishState(StoreSpotify storeSpotify) {
        storeSpotify.publishState();
    }

    public static final /* synthetic */ void access$setExpireStateSub$p(StoreSpotify storeSpotify, Subscription subscription) {
        storeSpotify.expireStateSub = subscription;
    }

    public static final /* synthetic */ void access$setSpotifyState$p(StoreSpotify storeSpotify, StoreSpotify$SpotifyState storeSpotify$SpotifyState) {
        storeSpotify.spotifyState = storeSpotify$SpotifyState;
    }

    public static final /* synthetic */ void access$startStateExpiration(StoreSpotify storeSpotify, long j) {
        storeSpotify.startStateExpiration(j);
    }

    @StoreThread
    private final void publishState() {
        boolean z2;
        String str;
        List<ModelSpotifyAlbum$AlbumImage> images;
        List<ModelSpotifyAlbum$AlbumImage> images2;
        ModelSpotifyAlbum$AlbumImage modelSpotifyAlbum$AlbumImage;
        String url;
        List listSplit$default;
        if (this.spotifyState == null) {
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
            return;
        }
        StoreUserConnections$State stateSnapshot = this.stream.getUserConnections().getStateSnapshot();
        if (!(stateSnapshot instanceof Collection) || !stateSnapshot.isEmpty()) {
            Iterator<ConnectedAccount> it = stateSnapshot.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                ConnectedAccount next = it.next();
                if (m.areEqual(next.getType(), Platform.SPOTIFY.getPlatformId()) && next.getShowActivity()) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (z2) {
            StoreSpotify$SpotifyState storeSpotify$SpotifyState = this.spotifyState;
            m.checkNotNull(storeSpotify$SpotifyState);
            ModelSpotifyTrack track = storeSpotify$SpotifyState.getTrack();
            boolean playing = storeSpotify$SpotifyState.getPlaying();
            long start = storeSpotify$SpotifyState.getStart();
            if (!playing || track == null) {
                this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
                return;
            }
            ModelSpotifyAlbum album = track.getAlbum();
            String str2 = (album == null || (images2 = album.getImages()) == null || (modelSpotifyAlbum$AlbumImage = (ModelSpotifyAlbum$AlbumImage) u.firstOrNull((List) images2)) == null || (url = modelSpotifyAlbum$AlbumImage.getUrl()) == null || (listSplit$default = w.split$default((CharSequence) url, new String[]{AutocompleteViewModel.COMMAND_DISCOVER_TOKEN}, false, 0, 6, (Object) null)) == null) ? null : (String) u.last(listSplit$default);
            if (str2 != null) {
                str = Platform.SPOTIFY.getPlatformId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str2;
            } else {
                str = null;
            }
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Platform platform = Platform.SPOTIFY;
            String properName = platform.getProperName();
            String name = track.getName();
            String id2 = track.getId();
            ModelSpotifyAlbum album2 = track.getAlbum();
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, ActivityUtilsKt.createSpotifyListeningActivity(jCurrentTimeMillis, properName, name, id2, album2 != null ? album2.getName() : null, str, u.joinToString$default(track.getArtists(), null, null, null, 0, null, StoreSpotify$publishState$activity$1.INSTANCE, 31, null), start, track.getDurationMs() + start, platform.getPlatformId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + this.stream.getUsers().getMe().getId()), true);
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            String id3 = track.getId();
            ModelSpotifyAlbum album3 = track.getAlbum();
            analyticsTracker.activityUpdatedSpotify(id3, (album3 == null || (images = album3.getImages()) == null || images.isEmpty()) ? false : true);
        }
    }

    @StoreThread
    private final void startStateExpiration(long timeLeftMs) {
        Observable<Long> observableD0 = Observable.d0(timeLeftMs + 5000, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, StoreSpotify.class, (Context) null, new StoreSpotify$startStateExpiration$1(this), (Function1) null, (Function0) null, (Function0) null, new StoreSpotify$startStateExpiration$2(this), 58, (Object) null);
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        m.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
        this.publishStateTrigger.onNext(Unit.a);
    }

    @StoreThread
    public final void handleConnectionReady(boolean ready) {
        if (ready) {
            this.publishStateTrigger.onNext(Unit.a);
        }
    }

    @StoreThread
    public final void handlePreLogout() {
        this.spotifyState = null;
    }

    @StoreThread
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        Object next;
        m.checkNotNullParameter(accounts, "accounts");
        Iterator<T> it = accounts.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!t.equals(Platform.SPOTIFY.name(), ((ConnectedAccount) next).getType(), true));
        ConnectedAccount connectedAccount = (ConnectedAccount) next;
        this.spotifyApiClient.setSpotifyAccountId(connectedAccount != null ? connectedAccount.getId() : null);
    }

    public final void init(Context context) {
        m.checkNotNullParameter(context, "context");
        SpotifyHelper.registerSpotifyBroadcastReceivers(context);
        Observable observableP = Observable.j(this.publishStateTrigger, this.spotifyApiClient.getSpotifyTrack().Y(StoreSpotify$init$1.INSTANCE).r(), StoreSpotify$init$2.INSTANCE).p(2L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableP, "Observable.combineLatest…unce(2, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, StoreSpotify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreSpotify$init$3(this), 62, (Object) null);
    }

    public final void setCurrentTrackId(String trackId) {
        m.checkNotNullParameter(trackId, "trackId");
        this.spotifyApiClient.fetchSpotifyTrack(trackId);
    }

    public final void setPlayingStatus(boolean playing, int position) {
        this.dispatcher.schedule(new StoreSpotify$setPlayingStatus$1(this, playing, position));
    }
}
