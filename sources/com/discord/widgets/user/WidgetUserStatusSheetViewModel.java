package com.discord.widgets.user;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.presence.ClientStatus;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView$Emoji;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView$ViewState;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView$ViewState$WithPlaceholder;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView$ViewState$WithStatus;
import d0.c0.c;
import d0.c0.c$a;
import d0.t.k;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel extends d0<WidgetUserStatusSheetViewModel$ViewState> {
    private boolean hasTrackedOpenPopout;
    private final RestAPI restAPI;
    private final StoreUserPresence storePresences;
    private final StoreUserSettings storeUserSettings;
    public static final WidgetUserStatusSheetViewModel$Companion Companion = new WidgetUserStatusSheetViewModel$Companion(null);
    private static final String[] CUSTOM_EMOJI_PLACEHOLDER_EMOJIS = {"grinning", "grimacing", "grin", "joy", "smiley", "smile", "sweat_smile", "laughing", "innocent", "wink", "blush", "slight_smile", "upside_down", "relaxed", "yum", "relieved", "heart_eyes", "kissing_heart", "kissing", "kissing_smiling_eyes", "kissing_closed_eyes", "stuck_out_tongue_winking_eye", "stuck_out_tongue_closed_eyes", "stuck_out_tongue", "money_mouth", "nerd", "sunglasses", "hugging", "smirk", "no_mouth", "neutral_face", "expressionless", "unamused", "rolling_eyes", "thinking", "flushed", "disappointed", "worried", "angry", "rage", "pensive", "confused", "slight_frown", "frowning2", "persevere", "confounded", "tired_face", "weary", "triumph", "open_mouth", "eggplant"};

    public WidgetUserStatusSheetViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserStatusSheetViewModel(StoreUserSettings storeUserSettings, StoreUserPresence storeUserPresence, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        storeUserPresence = (i & 2) != 0 ? StoreStream.Companion.getPresences() : storeUserPresence;
        this(storeUserSettings, storeUserPresence, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 8) != 0 ? WidgetUserStatusSheetViewModel$Companion.access$observeStoreState(Companion, storeUserPresence) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetUserStatusSheetViewModel widgetUserStatusSheetViewModel, WidgetUserStatusSheetViewModel$StoreState widgetUserStatusSheetViewModel$StoreState) {
        widgetUserStatusSheetViewModel.handleStoreState(widgetUserStatusSheetViewModel$StoreState);
    }

    private final ModelEmojiUnicode getPlaceholderEmoji() {
        Map<String, ModelEmojiUnicode> unicodeEmojisNamesMap = StoreStream.Companion.getEmojis().getUnicodeEmojisNamesMap();
        String[] strArr = CUSTOM_EMOJI_PLACEHOLDER_EMOJIS;
        c$a c_a = c.k;
        ModelEmojiUnicode modelEmojiUnicode = unicodeEmojisNamesMap.get(k.random(strArr, c_a));
        return modelEmojiUnicode != null ? modelEmojiUnicode : (ModelEmojiUnicode) u.random(unicodeEmojisNamesMap.values(), c_a);
    }

    private final void handleStoreState(WidgetUserStatusSheetViewModel$StoreState storeState) {
        UserStatusPresenceCustomView$ViewState userStatusPresenceCustomView$ViewState$WithPlaceholder;
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
            userStatusPresenceCustomView$ViewState$WithPlaceholder = new UserStatusPresenceCustomView$ViewState$WithStatus(new UserStatusPresenceCustomView$Emoji(id2, name, emoji3 != null ? emoji3.getAnimated() : false), customStatusActivity.getState());
        } else {
            userStatusPresenceCustomView$ViewState$WithPlaceholder = new UserStatusPresenceCustomView$ViewState$WithPlaceholder(getPlaceholderEmoji());
        }
        updateViewState(new WidgetUserStatusSheetViewModel$ViewState$Loaded(userStatusPresenceCustomView$ViewState$WithPlaceholder));
    }

    private final void trackOpen(WidgetUserStatusSheetViewModel$StoreState storeState) {
        AnalyticsTracker.INSTANCE.openUserStatusSheet(new Traits$Location(null, "Account Panel", "Avatar", null, null, 25, null), storeState.getCustomStatusActivity() != null);
    }

    public final void clearCustomStatus() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(null), false, 1, null), WidgetUserStatusSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetUserStatusSheetViewModel$clearCustomStatus$1.INSTANCE, 62, (Object) null);
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
        m.checkNotNullParameter(status, "status");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserSettings(RestAPIParams$UserSettings.Companion.createWithStatus(status)), false, 1, null), WidgetUserStatusSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetUserStatusSheetViewModel$setStatus$1.INSTANCE, 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserStatusSheetViewModel(StoreUserSettings storeUserSettings, StoreUserPresence storeUserPresence, RestAPI restAPI, Observable<WidgetUserStatusSheetViewModel$StoreState> observable) {
        super(WidgetUserStatusSheetViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(storeUserPresence, "storePresences");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storePresences = storeUserPresence;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetUserStatusSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserStatusSheetViewModel$1(this), 62, (Object) null);
    }
}
