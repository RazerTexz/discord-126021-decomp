package com.discord.widgets.user;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.presence.Presence;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel extends AbstractC0859d0<ViewState> {
    private boolean hasTrackedOpenPopout;
    private final RestAPI restAPI;
    private final StoreUserPresence storePresences;
    private final StoreUserSettings storeUserSettings;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] CUSTOM_EMOJI_PLACEHOLDER_EMOJIS = {"grinning", "grimacing", "grin", "joy", "smiley", "smile", "sweat_smile", "laughing", "innocent", "wink", "blush", "slight_smile", "upside_down", "relaxed", "yum", "relieved", "heart_eyes", "kissing_heart", "kissing", "kissing_smiling_eyes", "kissing_closed_eyes", "stuck_out_tongue_winking_eye", "stuck_out_tongue_closed_eyes", "stuck_out_tongue", "money_mouth", "nerd", "sunglasses", "hugging", "smirk", "no_mouth", "neutral_face", "expressionless", "unamused", "rolling_eyes", "thinking", "flushed", "disappointed", "worried", "angry", "rage", "pensive", "confused", "slight_frown", "frowning2", "persevere", "confounded", "tired_face", "weary", "triumph", "open_mouth", "eggplant"};

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
    public static final class C102461 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C102461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            WidgetUserStatusSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreUserPresence storePresences) {
            Observable observableM11083G = storePresences.observeLocalPresence().m11083G(new InterfaceC12589b<Presence, StoreState>() { // from class: com.discord.widgets.user.WidgetUserStatusSheetViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final WidgetUserStatusSheetViewModel.StoreState call(Presence presence) {
                    PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
                    C12238m.checkNotNullExpressionValue(presence, "localPresence");
                    return new WidgetUserStatusSheetViewModel.StoreState(presenceUtils.getCustomStatusActivity(presence));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "storePresences\n         …          )\n            }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Activity customStatusActivity;

        public StoreState(Activity activity) {
            this.customStatusActivity = activity;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Activity activity, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = storeState.customStatusActivity;
            }
            return storeState.copy(activity);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Activity getCustomStatusActivity() {
            return this.customStatusActivity;
        }

        public final StoreState copy(Activity customStatusActivity) {
            return new StoreState(customStatusActivity);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && C12238m.areEqual(this.customStatusActivity, ((StoreState) other).customStatusActivity);
            }
            return true;
        }

        public final Activity getCustomStatusActivity() {
            return this.customStatusActivity;
        }

        public int hashCode() {
            Activity activity = this.customStatusActivity;
            if (activity != null) {
                return activity.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(customStatusActivity=");
            sbM833U.append(this.customStatusActivity);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final UserStatusPresenceCustomView.ViewState customStatusViewState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(UserStatusPresenceCustomView.ViewState viewState) {
                super(null);
                C12238m.checkNotNullParameter(viewState, "customStatusViewState");
                this.customStatusViewState = viewState;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, UserStatusPresenceCustomView.ViewState viewState, int i, Object obj) {
                if ((i & 1) != 0) {
                    viewState = loaded.customStatusViewState;
                }
                return loaded.copy(viewState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final UserStatusPresenceCustomView.ViewState getCustomStatusViewState() {
                return this.customStatusViewState;
            }

            public final Loaded copy(UserStatusPresenceCustomView.ViewState customStatusViewState) {
                C12238m.checkNotNullParameter(customStatusViewState, "customStatusViewState");
                return new Loaded(customStatusViewState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.customStatusViewState, ((Loaded) other).customStatusViewState);
                }
                return true;
            }

            public final UserStatusPresenceCustomView.ViewState getCustomStatusViewState() {
                return this.customStatusViewState;
            }

            public int hashCode() {
                UserStatusPresenceCustomView.ViewState viewState = this.customStatusViewState;
                if (viewState != null) {
                    return viewState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(customStatusViewState=");
                sbM833U.append(this.customStatusViewState);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$clearCustomStatus$1 */
    /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
    public static final class C102471 extends AbstractC12240o implements Function1<ModelUserSettings, Unit> {
        public static final C102471 INSTANCE = new C102471();

        public C102471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            C12238m.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$setStatus$1 */
    /* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
    public static final class C102481 extends AbstractC12240o implements Function1<ModelUserSettings, Unit> {
        public static final C102481 INSTANCE = new C102481();

        public C102481() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
            invoke2(modelUserSettings);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserSettings modelUserSettings) {
            C12238m.checkNotNullParameter(modelUserSettings, "it");
        }
    }

    public WidgetUserStatusSheetViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserStatusSheetViewModel(StoreUserSettings storeUserSettings, StoreUserPresence storeUserPresence, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        storeUserPresence = (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        this(storeUserSettings, storeUserPresence, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? INSTANCE.observeStoreState(storeUserPresence) : observable);
    }

    private final ModelEmojiUnicode getPlaceholderEmoji() {
        Map<String, ModelEmojiUnicode> unicodeEmojisNamesMap = StoreStream.INSTANCE.getEmojis().getUnicodeEmojisNamesMap();
        String[] strArr = CUSTOM_EMOJI_PLACEHOLDER_EMOJIS;
        AbstractC11216c.a aVar = AbstractC11216c.f22272k;
        ModelEmojiUnicode modelEmojiUnicode = unicodeEmojisNamesMap.get(C12141k.random(strArr, aVar));
        return modelEmojiUnicode != null ? modelEmojiUnicode : (ModelEmojiUnicode) C12163u.random(unicodeEmojisNamesMap.values(), aVar);
    }

    private final void handleStoreState(StoreState storeState) {
        UserStatusPresenceCustomView.ViewState withPlaceholder;
        if (!this.hasTrackedOpenPopout) {
            trackOpen(storeState);
            this.hasTrackedOpenPopout = true;
        }
        Activity customStatusActivity = storeState.getCustomStatusActivity();
        if (customStatusActivity != null) {
            ActivityEmoji emoji = customStatusActivity.getEmoji();
            String id2 = emoji != null ? emoji.getId() : null;
            ActivityEmoji emoji2 = customStatusActivity.getEmoji();
            String name = emoji2 != null ? emoji2.getName() : null;
            ActivityEmoji emoji3 = customStatusActivity.getEmoji();
            withPlaceholder = new UserStatusPresenceCustomView.ViewState.WithStatus(new UserStatusPresenceCustomView.Emoji(id2, name, emoji3 != null ? emoji3.getAnimated() : false), customStatusActivity.getState());
        } else {
            withPlaceholder = new UserStatusPresenceCustomView.ViewState.WithPlaceholder(getPlaceholderEmoji());
        }
        updateViewState(new ViewState.Loaded(withPlaceholder));
    }

    private final void trackOpen(StoreState storeState) {
        AnalyticsTracker.INSTANCE.openUserStatusSheet(new Traits.Location(null, "Account Panel", "Avatar", null, null, 25, null), storeState.getCustomStatusActivity() != null);
    }

    public final void clearCustomStatus() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(null), false, 1, null), (Class<?>) WidgetUserStatusSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C102471.INSTANCE);
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreUserPresence getStorePresences() {
        return this.storePresences;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final void setStatus(ClientStatus status) {
        C12238m.checkNotNullParameter(status, "status");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserSettings(RestAPIParams.UserSettings.INSTANCE.createWithStatus(status)), false, 1, null), (Class<?>) WidgetUserStatusSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C102481.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserStatusSheetViewModel(StoreUserSettings storeUserSettings, StoreUserPresence storeUserPresence, RestAPI restAPI, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        C12238m.checkNotNullParameter(storeUserPresence, "storePresences");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storePresences = storeUserPresence;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetUserStatusSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102461());
    }
}
