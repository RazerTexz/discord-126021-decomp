package com.discord.widgets.user;

import android.content.Context;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.d.d0;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.g0.w;
import d0.z.d.m;
import java.util.Calendar;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel extends d0<WidgetUserSetCustomStatusViewModel$ViewState> {
    public static final WidgetUserSetCustomStatusViewModel$Companion Companion = new WidgetUserSetCustomStatusViewModel$Companion(null);
    private static final WidgetUserSetCustomStatusViewModel$FormState$Expiration DEFAULT_EXPIRATION = WidgetUserSetCustomStatusViewModel$FormState$Expiration.TOMORROW;
    private final Clock clock;
    private final PublishSubject<WidgetUserSetCustomStatusViewModel$Event> eventSubject;
    private final StoreUserSettings storeUserSettings;

    public WidgetUserSetCustomStatusViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.Companion.getUserSettings() : storeUserSettings;
        clock = (i & 2) != 0 ? ClockFactory.get() : clock;
        if ((i & 4) != 0) {
            WidgetUserSetCustomStatusViewModel$Companion widgetUserSetCustomStatusViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = WidgetUserSetCustomStatusViewModel$Companion.access$observeStoreState(widgetUserSetCustomStatusViewModel$Companion, storeStream$Companion.getUserSettings(), storeStream$Companion.getEmojis());
        }
        this(storeUserSettings, clock, observable);
    }

    public static final /* synthetic */ void access$emitSetStatusFailureEvent(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        widgetUserSetCustomStatusViewModel.emitSetStatusFailureEvent();
    }

    public static final /* synthetic */ void access$emitSetStatusSuccessEvent(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        widgetUserSetCustomStatusViewModel.emitSetStatusSuccessEvent();
    }

    public static final /* synthetic */ WidgetUserSetCustomStatusViewModel$FormState$Expiration access$getDEFAULT_EXPIRATION$cp() {
        return DEFAULT_EXPIRATION;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel, WidgetUserSetCustomStatusViewModel$StoreState widgetUserSetCustomStatusViewModel$StoreState) {
        widgetUserSetCustomStatusViewModel.handleStoreState(widgetUserSetCustomStatusViewModel$StoreState);
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<WidgetUserSetCustomStatusViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSetCustomStatusViewModel$Event$SetStatusFailure(2131888366));
    }

    private final void emitSetStatusSuccessEvent() {
        PublishSubject<WidgetUserSetCustomStatusViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetUserSetCustomStatusViewModel$Event$SetStatusSuccess(2131888316));
    }

    private final Emoji getEmojiFromSetting(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
        String emojiName;
        if (customStatusSetting == ModelCustomStatusSetting.Companion.getCLEAR()) {
            return null;
        }
        Long emojiId = customStatusSetting.getEmojiId();
        if (emojiId == null || (emojiName = String.valueOf(emojiId.longValue())) == null) {
            emojiName = customStatusSetting.getEmojiName();
        }
        return emojiSet.emojiIndex.get(emojiName);
    }

    private final String getExpirationUTCDateString(WidgetUserSetCustomStatusViewModel$FormState$Expiration expiresAt) {
        Long lValueOf;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        int iOrdinal = expiresAt.ordinal();
        if (iOrdinal == 0) {
            lValueOf = null;
        } else if (iOrdinal == 1) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD);
        } else if (iOrdinal == 2) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + 3600000);
        } else if (iOrdinal == 3) {
            lValueOf = Long.valueOf(jCurrentTimeMillis + 14400000);
        } else {
            if (iOrdinal != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Calendar calendar = TimeUtils.toCalendar(jCurrentTimeMillis);
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            lValueOf = Long.valueOf(calendar.getTimeInMillis());
        }
        return TimeUtils.toUTCDateTime$default(lValueOf, null, 2, null);
    }

    private final String getStatusTextFromSetting(ModelCustomStatusSetting customStatusSetting) {
        if (customStatusSetting != ModelCustomStatusSetting.Companion.getCLEAR()) {
            return customStatusSetting.getText();
        }
        return null;
    }

    private final void handleStoreState(WidgetUserSetCustomStatusViewModel$StoreState storeState) {
        if (getViewState() instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded) {
            return;
        }
        Emoji emojiFromSetting = getEmojiFromSetting(storeState.getCustomStatusSetting(), storeState.getEmojiSet());
        String statusTextFromSetting = getStatusTextFromSetting(storeState.getCustomStatusSetting());
        if (statusTextFromSetting == null) {
            statusTextFromSetting = "";
        }
        updateViewState(new WidgetUserSetCustomStatusViewModel$ViewState$Loaded(new WidgetUserSetCustomStatusViewModel$FormState(emojiFromSetting, statusTextFromSetting, DEFAULT_EXPIRATION)));
    }

    private final void updateFormState(WidgetUserSetCustomStatusViewModel$FormState formState) {
        WidgetUserSetCustomStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
        if (widgetUserSetCustomStatusViewModel$ViewState$Loaded != null) {
            updateViewState(widgetUserSetCustomStatusViewModel$ViewState$Loaded.copy(formState));
        }
    }

    public final void clearStatusTextAndEmoji() {
        WidgetUserSetCustomStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
        if (widgetUserSetCustomStatusViewModel$ViewState$Loaded != null) {
            updateFormState(WidgetUserSetCustomStatusViewModel$FormState.copy$default(widgetUserSetCustomStatusViewModel$ViewState$Loaded.getFormState(), null, "", null, 4, null));
        }
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<WidgetUserSetCustomStatusViewModel$Event> observeEvents() {
        PublishSubject<WidgetUserSetCustomStatusViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveStatus() {
        ModelCustomStatusSetting modelCustomStatusSetting;
        WidgetUserSetCustomStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
        if (widgetUserSetCustomStatusViewModel$ViewState$Loaded != null) {
            WidgetUserSetCustomStatusViewModel$FormState formState = widgetUserSetCustomStatusViewModel$ViewState$Loaded.getFormState();
            String text = formState.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = w.trim(text).toString();
            if (!(string.length() > 0)) {
                string = null;
            }
            WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState = string != null || formState.getEmoji() != null ? formState : null;
            if (widgetUserSetCustomStatusViewModel$FormState != null) {
                Emoji emoji = widgetUserSetCustomStatusViewModel$FormState.getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = widgetUserSetCustomStatusViewModel$FormState.getEmoji();
                if (!(emoji2 instanceof ModelEmojiUnicode)) {
                    emoji2 = null;
                }
                ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
                modelCustomStatusSetting = new ModelCustomStatusSetting(string, lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getExpirationUTCDateString(widgetUserSetCustomStatusViewModel$FormState.getExpiration()));
            } else {
                modelCustomStatusSetting = null;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(modelCustomStatusSetting), false, 1, null), this, null, 2, null), WidgetUserSetCustomStatusViewModel.class, (Context) null, (Function1) null, new WidgetUserSetCustomStatusViewModel$saveStatus$2(this), (Function0) null, (Function0) null, new WidgetUserSetCustomStatusViewModel$saveStatus$1(this), 54, (Object) null);
            if (modelCustomStatusSetting != null) {
                AnalyticsTracker.INSTANCE.customStatusUpdated(formState, new Traits$Location(null, "Account Panel", "Avatar", null, null, 25, null));
            }
        }
    }

    public final void setExpiration(WidgetUserSetCustomStatusViewModel$FormState$Expiration expiration) {
        m.checkNotNullParameter(expiration, "expiration");
        WidgetUserSetCustomStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
        if (widgetUserSetCustomStatusViewModel$ViewState$Loaded != null) {
            updateFormState(WidgetUserSetCustomStatusViewModel$FormState.copy$default(widgetUserSetCustomStatusViewModel$ViewState$Loaded.getFormState(), null, null, expiration, 3, null));
        }
    }

    public final void setStatusEmoji(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        WidgetUserSetCustomStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
        if (widgetUserSetCustomStatusViewModel$ViewState$Loaded != null) {
            updateFormState(WidgetUserSetCustomStatusViewModel$FormState.copy$default(widgetUserSetCustomStatusViewModel$ViewState$Loaded.getFormState(), emoji, null, null, 6, null));
        }
    }

    public final void setStatusText(String text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        WidgetUserSetCustomStatusViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded = (WidgetUserSetCustomStatusViewModel$ViewState$Loaded) viewState;
        if (widgetUserSetCustomStatusViewModel$ViewState$Loaded != null) {
            updateFormState(WidgetUserSetCustomStatusViewModel$FormState.copy$default(widgetUserSetCustomStatusViewModel$ViewState$Loaded.getFormState(), null, text, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable<WidgetUserSetCustomStatusViewModel$StoreState> observable) {
        super(WidgetUserSetCustomStatusViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.clock = clock;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetUserSetCustomStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSetCustomStatusViewModel$1(this), 62, (Object) null);
        this.eventSubject = PublishSubject.k0();
    }
}
