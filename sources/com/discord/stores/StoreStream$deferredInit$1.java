package com.discord.stores;

import android.app.Application;
import b.a.e.d;
import com.discord.app.AppLog;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.TimeElapsed;
import com.discord.utilities.voice.VoiceEngineServiceController;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$deferredInit$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Application $context;
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$deferredInit$1(StoreStream storeStream, Application application) {
        super(0);
        this.this$0 = storeStream;
        this.$context = application;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        TimeElapsed timeElapsed = new TimeElapsed(StoreStream.access$getClock$p(this.this$0), 0L, 2, null);
        NetworkMonitor networkMonitor = new NetworkMonitor(this.$context, AppLog.g);
        StoreStream.access$startStoreInitializationTimer(this.this$0, networkMonitor);
        this.this$0.getExperiments().init(this.$context);
        this.this$0.getMediaEngine().init(this.$context);
        this.this$0.getAccessibility().init(this.$context);
        this.this$0.getGatewaySocket().init(this.$context, networkMonitor);
        this.this$0.getNavigation().init(this.$context);
        this.this$0.getNux().init(this.$context);
        this.this$0.getChannels().init();
        this.this$0.getUsers().init(this.$context);
        this.this$0.getGuilds().init(this.$context);
        this.this$0.getPermissions().init();
        this.this$0.getGuildsSorted().init(this.$context);
        this.this$0.getGuildsNsfw().init(this.$context);
        this.this$0.getGuildSelected().init(this.$context);
        this.this$0.getChannelsSelected().init();
        this.this$0.getMediaSettings().init();
        this.this$0.getMessages().init(this.$context);
        this.this$0.getMessagesLoader().init(this.$context);
        this.this$0.getMessageAck().init(this.$context);
        this.this$0.getMessagesMostRecent().init(this.$context);
        this.this$0.getNotifications().init(this.$context);
        this.this$0.getRtcConnection().init(this.$context, networkMonitor);
        this.this$0.getReadStates().init(this.$context);
        this.this$0.getVoiceChannelSelected().init(this.$context);
        this.this$0.getVoiceSpeaking().init(this.$context);
        this.this$0.getVoiceParticipants().init(this.$context);
        this.this$0.getConnectivity().init(networkMonitor);
        this.this$0.getClientVersion().init(this.$context);
        this.this$0.getMediaSettings().init(this.$context);
        this.this$0.getAnalytics().init(this.$context);
        this.this$0.getCollapsedChannelCategories().init(this.$context);
        this.this$0.getGuildSettings().init(this.$context);
        this.this$0.getNotices().init(this.$context);
        this.this$0.getUserConnections().init(this.$context);
        this.this$0.getChangeLogStore().init(this.$context);
        this.this$0.getReviewRequestStore().init(this.$context);
        this.this$0.getPresences().init(this.$context);
        this.this$0.getSpotify().init(this.$context);
        StoreStream.access$getStreamRtcConnection$p(this.this$0).init(networkMonitor);
        this.this$0.getGuildsSorted().init(this.$context);
        this.this$0.getExpandedGuildFolders().init(this.$context);
        this.this$0.getUserRelationships().init();
        this.this$0.getMaskedLinks().init(this.$context);
        this.this$0.getRtcRegion().init();
        this.this$0.getStickers().init();
        this.this$0.getGooglePlayPurchases().init(this.$context);
        this.this$0.getPhone().init(this.$context);
        this.this$0.getApplicationInteractions().init(this.$context);
        this.this$0.getStageSelfPresence().init();
        this.this$0.getContactSync().init(this.$context);
        this.this$0.getAudioManagerV2().init(this.$context);
        this.this$0.getOutboundPromotions().init(this.$context);
        StoreStream storeStream = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream, storeStream.getAuthentication().getPreLogoutSignal$app_productionGoogleRelease(), "streamPreLogout", new StoreStream$deferredInit$1$1(this));
        StoreStream storeStream2 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream2, storeStream2.getAuthentication().m8getAuthState$app_productionGoogleRelease(), "streamAuthState", new StoreStream$deferredInit$1$2(this.this$0));
        StoreStream storeStream3 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream3, storeStream3.getAuthentication().getFingerPrint$app_productionGoogleRelease(), "streamAuthedFingerprint", new StoreStream$deferredInit$1$3(this.this$0));
        StoreStream storeStream4 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream4, storeStream4.getMessagesLoader().get(), "streamMessagesLoaded", new StoreStream$deferredInit$1$4(this.this$0));
        StoreStream storeStream5 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream5, storeStream5.getChannelsSelected().observeId(), "streamChannelSelected", new StoreStream$deferredInit$1$5(this.this$0));
        StoreStream storeStream6 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream6, storeStream6.getVoiceChannelSelected().observeSelectedVoiceChannelId(), "streamVoiceChannelSelected", new StoreStream$deferredInit$1$6(this.this$0));
        StoreStream storeStream7 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream7, storeStream7.getVoiceSpeaking().observeSpeakingUsers(), "streamUserSpeaking", new StoreStream$deferredInit$1$7(this.this$0));
        StoreStream storeStream8 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream8, storeStream8.getRtcConnection().getConnectionState(), "streamRtcConnectionStateChanged", new StoreStream$deferredInit$1$8(this.this$0));
        StoreStream storeStream9 = this.this$0;
        StoreStream.access$dispatchSubscribe(storeStream9, storeStream9.getRtcConnection().getSpeakingUpdates(), "streamRtcSpeakingUpdates", new StoreStream$deferredInit$1$9(this.this$0));
        StoreStream.access$initGatewaySocketListeners(this.this$0);
        StoreStream.access$dispatchSubscribe(this.this$0, d.d.a(), "streamBackgrounded", new StoreStream$deferredInit$1$10(this.this$0));
        StoreStream storeStream10 = this.this$0;
        Observable observableH = Observable.h(storeStream10.getExperiments().isInitialized().r(), this.this$0.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), this.this$0.getChannelsSelected().observeInitializedForAuthedUser(), Persister.Companion.isPreloaded(), StoreStream$deferredInit$1$11.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable\n        .comb…tedInitialized)\n        }");
        StoreStream.access$dispatchSubscribe(storeStream10, observableH, "streamInit", new StoreStream$deferredInit$1$12(StoreStream.access$getInitialized$p(this.this$0)));
        AppLog.i("[StoreStream] Application stores initialized in: " + timeElapsed.getSeconds() + " seconds.");
        VoiceEngineServiceController.Companion.getINSTANCE().init(this.$context);
        StoreStream storeStream11 = this.this$0;
        StoreStream.access$maybeLogNotificationPermissionStatus(storeStream11, this.$context, StoreStream.access$getClock$p(storeStream11));
    }
}
