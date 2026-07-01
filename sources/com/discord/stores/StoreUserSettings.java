package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings extends Store {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreAccessibility accessibilityStore;
    private final Persister<Boolean> allowAccessibilityDetectionPublisher;
    private final Persister<Boolean> allowAnimatedEmojisPublisher;
    private final Persister<Boolean> autoPlayGifsPublisher;
    private Boolean contactSyncUpsellShown;
    private final SerializedSubject<ModelCustomStatusSetting, ModelCustomStatusSetting> customStatusSubject;
    private final SerializedSubject<Boolean, Boolean> defaultGuildsRestrictedSubject;
    private final Dispatcher dispatcher;
    private Subscription expireCustomStatusSubscription;
    private final SerializedSubject<Integer, Integer> explicitContentFilterSubject;
    private final SerializedSubject<Integer, Integer> friendDiscoveryFlagsSubject;
    private final SerializedSubject<ModelUserSettings.FriendSourceFlags, ModelUserSettings.FriendSourceFlags> friendSourceFlagsSubject;
    private final Persister<List<ModelGuildFolder>> guildFoldersPublisher;
    private final Persister<List<Long>> restrictedGuildIdsPublisher;
    private final SerializedSubject<Boolean, Boolean> shouldRenderEmbedsSubject;
    private final Persister<Boolean> showCurrentGame;
    private final Persister<Integer> stickerAnimationSettingsPublisher;
    private final Persister<Boolean> stickerSuggestionsPublisher;

    /* JADX INFO: compiled from: StoreUserSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void updateUserSettings(AppActivity appActivity, RestAPIParams.UserSettings userSettings, Integer num) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(userSettings), false, 1, null), appActivity, null, 2, null), (Class<?>) StoreUserSettings.class, (58 & 2) != 0 ? null : appActivity, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new StoreUserSettings2(appActivity, num));
        }

        public static /* synthetic */ void updateUserSettings$default(Companion companion, AppActivity appActivity, RestAPIParams.UserSettings userSettings, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            companion.updateUserSettings(appActivity, userSettings, num);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$expireCustomStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$updateAllowAccessibilityDetectionInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $allowAccessibilityDetection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$allowAccessibilityDetection = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserSettings.this.accessibilityStore.updateDetectionAllowed(this.$allowAccessibilityDetection);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$updateContactSyncShown$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            Intrinsics3.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$updateLocalCustomStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreUserSettings.this.expireCustomStatusSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSettings$updateLocalCustomStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSettings.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreUserSettings.this.expireCustomStatus();
        }
    }

    public StoreUserSettings(Dispatcher dispatcher, StoreAccessibility storeAccessibility) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeAccessibility, "accessibilityStore");
        this.dispatcher = dispatcher;
        this.accessibilityStore = storeAccessibility;
        this.shouldRenderEmbedsSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.explicitContentFilterSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.defaultGuildsRestrictedSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendSourceFlagsSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.friendDiscoveryFlagsSubject = new SerializedSubject<>(BehaviorSubject.l0(0));
        this.customStatusSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.restrictedGuildIdsPublisher = new Persister<>("RESTRICTED_GUILD_IDS", new ArrayList());
        this.guildFoldersPublisher = new Persister<>("STORE_SETTINGS_FOLDERS_V1", new ArrayList());
        Boolean bool = Boolean.TRUE;
        this.allowAnimatedEmojisPublisher = new Persister<>("STORE_SETTINGS_ALLOW_ANIMATED_EMOJIS", bool);
        this.stickerAnimationSettingsPublisher = new Persister<>("CACHE_KEY_STICKER_ANIMATION_SETTINGS_V1", 0);
        this.showCurrentGame = new Persister<>("STORE_SETTINGS_ALLOW_GAME_STATUS", bool);
        this.stickerSuggestionsPublisher = new Persister<>("CACHE_KEY_STICKER_SUGGESTIONS", bool);
        this.allowAccessibilityDetectionPublisher = new Persister<>("STORE_SETTINGS_ALLOW_ACCESSIBILITY_DETECTION", Boolean.FALSE);
        this.autoPlayGifsPublisher = new Persister<>("STORE_SETTINGS_AUTO_PLAY_GIFS", bool);
    }

    private final void expireCustomStatus() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(updateCustomStatus(null), false, 1, null), (Class<?>) StoreUserSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    private final void handleUserSettings(ModelUserSettings userSettings) {
        List<ModelGuildFolder> guildFolders = userSettings.getGuildFolders();
        List<Long> restrictedGuilds = userSettings.getRestrictedGuilds();
        if (getIsSyncTextAndImagesEnabled()) {
            if (userSettings.getInlineEmbedMedia() != null) {
                Boolean inlineEmbedMedia = userSettings.getInlineEmbedMedia();
                Intrinsics3.checkNotNullExpressionValue(inlineEmbedMedia, "userSettings.inlineEmbedMedia");
                setIsEmbedMediaInlined(null, inlineEmbedMedia.booleanValue());
            }
            if (userSettings.getInlineAttachmentMedia() != null) {
                Boolean inlineAttachmentMedia = userSettings.getInlineAttachmentMedia();
                Intrinsics3.checkNotNullExpressionValue(inlineAttachmentMedia, "userSettings.inlineAttachmentMedia");
                setIsAttachmentMediaInline(null, inlineAttachmentMedia.booleanValue());
            }
            if (userSettings.getRenderEmbeds() != null) {
                Boolean renderEmbeds = userSettings.getRenderEmbeds();
                Intrinsics3.checkNotNullExpressionValue(renderEmbeds, "userSettings.renderEmbeds");
                setIsRenderEmbedsEnabled(null, renderEmbeds.booleanValue());
            }
            if (userSettings.getAnimateEmoji() != null) {
                Boolean animateEmoji = userSettings.getAnimateEmoji();
                Intrinsics3.checkNotNullExpressionValue(animateEmoji, "userSettings.animateEmoji");
                setIsAnimatedEmojisEnabled(null, animateEmoji.booleanValue());
            }
            if (userSettings.getAnimateStickers() != null) {
                Integer animateStickers = userSettings.getAnimateStickers();
                Intrinsics3.checkNotNullExpressionValue(animateStickers, "userSettings.animateStickers");
                setStickerAnimationSettings(null, animateStickers.intValue());
            }
        }
        if (guildFolders != null) {
            Persister.set$default(this.guildFoldersPublisher, guildFolders, false, 2, null);
        }
        if (restrictedGuilds != null) {
            Persister.set$default(this.restrictedGuildIdsPublisher, restrictedGuilds, false, 2, null);
        }
        if (userSettings.getDeveloperMode() != null) {
            Boolean developerMode = userSettings.getDeveloperMode();
            Intrinsics3.checkNotNullExpressionValue(developerMode, "userSettings.developerMode");
            setDeveloperModeInternal(developerMode.booleanValue());
        }
        if (userSettings.getShowCurrentGame() != null) {
            Persister<Boolean> persister = this.showCurrentGame;
            Boolean showCurrentGame = userSettings.getShowCurrentGame();
            Intrinsics3.checkNotNullExpressionValue(showCurrentGame, "userSettings.showCurrentGame");
            Persister.set$default(persister, showCurrentGame, false, 2, null);
        }
        if (userSettings.getExplicitContentFilter() != null) {
            SerializedSubject<Integer, Integer> serializedSubject = this.explicitContentFilterSubject;
            serializedSubject.k.onNext(userSettings.getExplicitContentFilter());
        }
        if (userSettings.getFriendSourceFlags() != null) {
            SerializedSubject<ModelUserSettings.FriendSourceFlags, ModelUserSettings.FriendSourceFlags> serializedSubject2 = this.friendSourceFlagsSubject;
            serializedSubject2.k.onNext(userSettings.getFriendSourceFlags());
        }
        if (userSettings.getDefaultGuildsRestricted() != null) {
            SerializedSubject<Boolean, Boolean> serializedSubject3 = this.defaultGuildsRestrictedSubject;
            serializedSubject3.k.onNext(userSettings.getDefaultGuildsRestricted());
        }
        if (userSettings.getCustomStatus() != null) {
            updateLocalCustomStatus(userSettings.getCustomStatus());
        }
        if (userSettings.getFriendDiscoveryFlags() != null) {
            SerializedSubject<Integer, Integer> serializedSubject4 = this.friendDiscoveryFlagsSubject;
            serializedSubject4.k.onNext(userSettings.getFriendDiscoveryFlags());
        }
        if (userSettings.getContactSyncUpsellShown() != null) {
            this.contactSyncUpsellShown = userSettings.getContactSyncUpsellShown();
        }
    }

    public static /* synthetic */ Observable observeIsAnimatedEmojisEnabled$default(StoreUserSettings storeUserSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeUserSettings.observeIsAnimatedEmojisEnabled(z2);
    }

    public static /* synthetic */ Observable observeIsAutoPlayGifsEnabled$default(StoreUserSettings storeUserSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeUserSettings.observeIsAutoPlayGifsEnabled(z2);
    }

    public static /* synthetic */ Observable observeStickerAnimationSettings$default(StoreUserSettings storeUserSettings, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return storeUserSettings.observeStickerAnimationSettings(z2);
    }

    private final void setDeveloperModeInternal(boolean isDeveloperMode) {
        getPrefs().edit().putBoolean("CACHE_KEY_DEVELOPER_MODE", isDeveloperMode).apply();
    }

    private final void updateAllowAccessibilityDetectionInternal(boolean allowAccessibilityDetection) {
        Persister.set$default(this.allowAccessibilityDetectionPublisher, Boolean.valueOf(allowAccessibilityDetection), false, 2, null);
        this.dispatcher.schedule(new AnonymousClass1(allowAccessibilityDetection));
    }

    private final synchronized void updateLocalCustomStatus(ModelCustomStatusSetting customStatus) {
        Subscription subscription = this.expireCustomStatusSubscription;
        if (subscription != null) {
            Intrinsics3.checkNotNull(subscription);
            subscription.unsubscribe();
        }
        this.customStatusSubject.k.onNext(customStatus);
        if (!Intrinsics3.areEqual(customStatus, ModelCustomStatusSetting.INSTANCE.getCLEAR())) {
            Intrinsics3.checkNotNull(customStatus);
            if (customStatus.getExpiresAt() != null) {
                Observable<Long> observableD0 = Observable.d0(_Ranges.coerceAtLeast(TimeUtils.parseUTCDate(customStatus.getExpiresAt()) - ClockFactory.get().currentTimeMillis(), 0L), TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n            .…l, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe(observableD0, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
            }
        }
    }

    public final Boolean getContactSyncUpsellShown() {
        return this.contactSyncUpsellShown;
    }

    public final boolean getIsAttachmentMediaInline() {
        return getPrefs().getBoolean("CACHE_KEY_INLINE_ATTACHMENT_MEDIA", true);
    }

    public final boolean getIsAutoImageCompressionEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_IMAGE_COMPRESSION", false);
    }

    public final boolean getIsAutoPlayGifsEnabled() {
        return getPrefs().getBoolean("STORE_SETTINGS_AUTO_PLAY_GIFS", true);
    }

    public final boolean getIsChromeCustomTabsEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_USE_CHROME_CUSTOM_TABS", true);
    }

    public final boolean getIsDeveloperMode() {
        return getPrefs().getBoolean("CACHE_KEY_DEVELOPER_MODE", false);
    }

    public final boolean getIsEmbedMediaInlined() {
        return getPrefs().getBoolean("CACHE_KEY_INLINE_EMBED_MEDIA", true);
    }

    public final boolean getIsMobileOverlayEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_MOBILE_OVERLAY", false);
    }

    public final boolean getIsRenderEmbedsEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_RENDER_EMBEDS", true);
    }

    public final boolean getIsShiftEnterToSendEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_SHIFT_ENTER_TO_SEND", false);
    }

    public final boolean getIsStickerSuggestionsEnabled() {
        return this.stickerSuggestionsPublisher.get().booleanValue();
    }

    public final boolean getIsSyncTextAndImagesEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_SYNC_TEXT_AND_IMAGES", true);
    }

    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettingsPublisher.get().intValue();
    }

    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelUserSettings userSettings = payload.getUserSettings();
        Intrinsics3.checkNotNullExpressionValue(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Store3
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        Intrinsics3.checkNotNullParameter(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        SerializedSubject<Boolean, Boolean> serializedSubject = this.shouldRenderEmbedsSubject;
        serializedSubject.k.onNext(Boolean.valueOf(getIsRenderEmbedsEnabled()));
    }

    public final Observable<ModelUserConsents2> observeConsents() {
        Observable<ModelUserConsents2> observableM = RestAPI.INSTANCE.getApi().getConsents().M(new Func1<Throwable, ModelUserConsents2>() { // from class: com.discord.stores.StoreUserSettings.observeConsents.1
            @Override // j0.k.Func1
            public final ModelUserConsents2 call(Throwable th) {
                return ModelUserConsents2.INSTANCE.getDEFAULT();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableM, "RestAPI\n          .api\n …turn { Consents.DEFAULT }");
        return ObservableExtensionsKt.restSubscribeOn$default(observableM, false, 1, null);
    }

    public final Observable<ModelCustomStatusSetting> observeCustomStatus() {
        Observable<ModelCustomStatusSetting> observableR = ObservableExtensionsKt.computationLatest(this.customStatusSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "customStatusSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeExplicitContentFilter() {
        Observable<Integer> observableR = ObservableExtensionsKt.computationLatest(this.explicitContentFilterSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "explicitContentFilterSub…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeFriendDiscoveryFlags() {
        Observable<Integer> observableR = ObservableExtensionsKt.computationLatest(this.friendDiscoveryFlagsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "friendDiscoveryFlagsSubj…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ModelUserSettings.FriendSourceFlags> observeFriendSourceFlags() {
        Observable<ModelUserSettings.FriendSourceFlags> observableR = ObservableExtensionsKt.computationLatest(this.friendSourceFlagsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "friendSourceFlagsSubject…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<ModelGuildFolder>> observeGuildFolders() {
        Observable<List<ModelGuildFolder>> observableR = ObservableExtensionsKt.computationLatest(this.guildFoldersPublisher.getObservable()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "guildFoldersPublisher\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsAccessibilityDetectionAllowed() {
        Observable<Boolean> observableR = this.allowAccessibilityDetectionPublisher.getObservable().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "allowAccessibilityDetect…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsAnimatedEmojisEnabled(boolean respectReducedMotion) {
        Observable<Boolean> observable = this.allowAnimatedEmojisPublisher.getObservable();
        if (respectReducedMotion) {
            observable = Observable.j(observable, this.accessibilityStore.observeReducedMotionEnabled(), new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.stores.StoreUserSettings$observeIsAnimatedEmojisEnabled$1$1
                @Override // rx.functions.Func2
                public final Boolean call(Boolean bool, Boolean bool2) {
                    Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
                    return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
                }
            });
        }
        Observable<Boolean> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "allowAnimatedEmojisPubli…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsAutoPlayGifsEnabled(boolean respectReducedMotion) {
        Observable<Boolean> observable = this.autoPlayGifsPublisher.getObservable();
        if (respectReducedMotion) {
            observable = Observable.j(observable, this.accessibilityStore.observeReducedMotionEnabled(), new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.stores.StoreUserSettings$observeIsAutoPlayGifsEnabled$1$1
                @Override // rx.functions.Func2
                public final Boolean call(Boolean bool, Boolean bool2) {
                    Intrinsics3.checkNotNullExpressionValue(bool, "autoPlayGifs");
                    return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
                }
            });
        }
        Observable<Boolean> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "autoPlayGifsPublisher\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsDefaultGuildsRestricted() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.defaultGuildsRestrictedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "defaultGuildsRestrictedS…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsRenderEmbedsEnabled() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.shouldRenderEmbedsSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "shouldRenderEmbedsSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsShowCurrentGameEnabled() {
        return this.showCurrentGame.getObservable();
    }

    public final Observable<Boolean> observeIsStickerSuggestionsEnabled() {
        return this.stickerSuggestionsPublisher.getObservable();
    }

    public final Observable<List<Long>> observeRestrictedGuildIds() {
        Observable<List<Long>> observableR = ObservableExtensionsKt.computationLatest(this.restrictedGuildIdsPublisher.getObservable()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "restrictedGuildIdsPublis…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeStickerAnimationSettings(boolean respectReducedMotion) {
        Observable<Integer> observable = this.stickerAnimationSettingsPublisher.getObservable();
        if (respectReducedMotion) {
            observable = Observable.j(observable, this.accessibilityStore.observeReducedMotionEnabled(), new Func2<Integer, Boolean, Integer>() { // from class: com.discord.stores.StoreUserSettings$observeStickerAnimationSettings$1$1
                @Override // rx.functions.Func2
                public final Integer call(Integer num, Boolean bool) {
                    if (num == null || num.intValue() != 0) {
                        return num;
                    }
                    Intrinsics3.checkNotNullExpressionValue(bool, "useReducedMotion");
                    if (bool.booleanValue()) {
                        return 1;
                    }
                    return num;
                }
            });
        }
        Observable<Integer> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "stickerAnimationSettings…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setContactSyncUpsellShown(Boolean bool) {
        this.contactSyncUpsellShown = bool;
    }

    public final void setDefaultGuildsRestricted(AppActivity activity, boolean defaultGuildsRestricted, Collection<Long> restrictedGuilds) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithRestrictedGuilds(Boolean.valueOf(defaultGuildsRestricted), restrictedGuilds), null, 2, null);
        }
    }

    public final void setExplicitContentFilter(AppActivity activity, int explicitContentFilter) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithExplicitContentFilter(explicitContentFilter), null, 2, null);
        }
    }

    public final void setFriendDiscoveryFlags(AppActivity activity, int flags) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithFriendDiscoveryFlags(Integer.valueOf(flags)), null, 2, null);
        }
    }

    public final void setFriendSourceFlags(AppActivity activity, Boolean all, Boolean mutualGuilds, Boolean mutualFriends) {
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithFriendSourceFlags(all, mutualGuilds, mutualFriends), null, 2, null);
        }
    }

    public final Observable<ModelUserSettings> setIsAccessibilityDetectionAllowed(final boolean allowAccessibilityDetection) {
        Observable<ModelUserSettings> observableU = RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithAllowAccessibilityDetection(Boolean.valueOf(allowAccessibilityDetection))).u(new Action1<ModelUserSettings>() { // from class: com.discord.stores.StoreUserSettings.setIsAccessibilityDetectionAllowed.1
            @Override // rx.functions.Action1
            public final void call(ModelUserSettings modelUserSettings) {
                StoreUserSettings.this.updateAllowAccessibilityDetectionInternal(allowAccessibilityDetection);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "RestAPI\n          .api\n …AccessibilityDetection) }");
        return observableU;
    }

    public final void setIsAnimatedEmojisEnabled(AppActivity activity, boolean isAnimatedEmojisEnabled) {
        Persister.set$default(this.allowAnimatedEmojisPublisher, Boolean.valueOf(isAnimatedEmojisEnabled), false, 2, null);
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithAllowAnimatedEmojis(Boolean.valueOf(isAnimatedEmojisEnabled)), null, 2, null);
    }

    public final void setIsAttachmentMediaInline(AppActivity activity, boolean isAttachmentMediaInline) {
        if (getIsAttachmentMediaInline() != isAttachmentMediaInline) {
            getPrefs().edit().putBoolean("CACHE_KEY_INLINE_ATTACHMENT_MEDIA", isAttachmentMediaInline).apply();
        }
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithInlineAttachmentMedia(isAttachmentMediaInline), null, 2, null);
    }

    public final void setIsAutoImageCompressionEnabled(boolean isAutoImageCompressionEnabled) {
        if (getIsAutoImageCompressionEnabled() != isAutoImageCompressionEnabled) {
            getPrefs().edit().putBoolean("CACHE_KEY_IMAGE_COMPRESSION", isAutoImageCompressionEnabled).apply();
        }
    }

    public final boolean setIsAutoPlayGifsEnabled(boolean isAutoPlayGifsEnabled) {
        return ((Boolean) Persister.set$default(this.autoPlayGifsPublisher, Boolean.valueOf(isAutoPlayGifsEnabled), false, 2, null)).booleanValue();
    }

    public final void setIsChromeCustomTabsEnabled(boolean isUseChromeCustomTabsEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_USE_CHROME_CUSTOM_TABS", isUseChromeCustomTabsEnabled);
        editorEdit.apply();
    }

    public final void setIsDeveloperMode(AppActivity activity, boolean isDeveloperMode) {
        if (getIsDeveloperMode() != isDeveloperMode) {
            if (activity != null) {
                INSTANCE.updateUserSettings(activity, RestAPIParams.UserSettings.INSTANCE.createWithDeveloperMode(isDeveloperMode), Integer.valueOf(R.string.theme_updated));
            }
            setDeveloperModeInternal(isDeveloperMode);
        }
    }

    public final void setIsEmbedMediaInlined(AppActivity activity, boolean isInlineEmbedMediaEnabled) {
        if (getIsEmbedMediaInlined() != isInlineEmbedMediaEnabled) {
            getPrefs().edit().putBoolean("CACHE_KEY_INLINE_EMBED_MEDIA", isInlineEmbedMediaEnabled).apply();
        }
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithInlineEmbedMedia(isInlineEmbedMediaEnabled), null, 2, null);
    }

    public final void setIsMobileOverlayEnabled(boolean isMobileOverlayEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        if (getIsMobileOverlayEnabled() != isMobileOverlayEnabled) {
            editorEdit.putBoolean("CACHE_KEY_MOBILE_OVERLAY", isMobileOverlayEnabled);
            AnalyticsTracker.overlayToggled(isMobileOverlayEnabled);
        }
        editorEdit.apply();
    }

    public final void setIsRenderEmbedsEnabled(AppActivity activity, boolean isRenderEmbedsEnabled) {
        if (getIsRenderEmbedsEnabled() != isRenderEmbedsEnabled) {
            getPrefs().edit().putBoolean("CACHE_KEY_RENDER_EMBEDS", isRenderEmbedsEnabled).apply();
            SerializedSubject<Boolean, Boolean> serializedSubject = this.shouldRenderEmbedsSubject;
            serializedSubject.k.onNext(Boolean.valueOf(isRenderEmbedsEnabled));
        }
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithRenderEmbeds(isRenderEmbedsEnabled), null, 2, null);
    }

    public final void setIsShiftEnterToSendEnabled(boolean isShiftEnterToSendEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        if (getIsShiftEnterToSendEnabled() != isShiftEnterToSendEnabled) {
            editorEdit.putBoolean("CACHE_KEY_SHIFT_ENTER_TO_SEND", isShiftEnterToSendEnabled);
        }
        editorEdit.apply();
    }

    public final void setIsShowCurrentGameEnabled(AppActivity activity, boolean isShowCurrentGameEnabled) {
        Persister.set$default(this.showCurrentGame, Boolean.valueOf(isShowCurrentGameEnabled), false, 2, null);
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithShowCurrentGame(isShowCurrentGameEnabled), null, 2, null);
        }
    }

    public final boolean setIsStickerSuggestionsEnabled(boolean enabled) {
        return this.stickerSuggestionsPublisher.set(Boolean.valueOf(enabled), true).booleanValue();
    }

    public final void setRestrictedGuildId(AppActivity activity, long guildId, boolean restricted) {
        setRestrictedGuildIds(activity, this.restrictedGuildIdsPublisher.get(), guildId, restricted);
    }

    public final void setRestrictedGuildIds(AppActivity activity, Collection<Long> restrictedGuilds, long guildId, boolean restricted) {
        ArrayList arrayList = new ArrayList(restrictedGuilds);
        if (restricted && !arrayList.contains(Long.valueOf(guildId))) {
            arrayList.add(Long.valueOf(guildId));
        }
        if (!restricted) {
            arrayList.remove(Long.valueOf(guildId));
        }
        if (activity != null) {
            Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithRestrictedGuilds(null, arrayList), null, 2, null);
        }
    }

    public final void setStickerAnimationSettings(AppActivity activity, int stickerAnimationSettings) {
        Persister.set$default(this.stickerAnimationSettingsPublisher, Integer.valueOf(stickerAnimationSettings), false, 2, null);
        if (!getIsSyncTextAndImagesEnabled() || activity == null) {
            return;
        }
        Companion.updateUserSettings$default(INSTANCE, activity, RestAPIParams.UserSettings.INSTANCE.createWithStickerAnimationSettings(Integer.valueOf(stickerAnimationSettings)), null, 2, null);
    }

    public final void updateContactSyncShown() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithContactSyncUpsellShown()), false, 1, null), (Class<?>) StoreUserSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    public final Observable<ModelUserSettings> updateCustomStatus(ModelCustomStatusSetting customStatus) {
        return RestAPI.INSTANCE.getApiSerializeNulls().updateUserSettingsCustomStatus(new RestAPIParams.UserSettingsCustomStatus(customStatus));
    }

    public final void getIsSyncTextAndImagesEnabled(boolean isSyncTextAndImagesEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        if (getIsSyncTextAndImagesEnabled() != isSyncTextAndImagesEnabled) {
            editorEdit.putBoolean("CACHE_KEY_SYNC_TEXT_AND_IMAGES", isSyncTextAndImagesEnabled);
        }
        editorEdit.apply();
    }
}
