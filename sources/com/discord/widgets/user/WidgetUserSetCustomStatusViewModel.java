package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Calendar;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FormState.Expiration DEFAULT_EXPIRATION = FormState.Expiration.TOMORROW;
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
    private final StoreUserSettings storeUserSettings;

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetUserSetCustomStatusViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreUserSettings storeUserSettings, StoreEmoji storeEmoji) {
            Observable<StoreState> observableZ = Observable.j(storeUserSettings.observeCustomStatus(), storeEmoji.getEmojiSet(StoreEmoji.EmojiContext.Global.INSTANCE, false, false), new Func2<ModelCustomStatusSetting, EmojiSet, StoreState>() { // from class: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public final WidgetUserSetCustomStatusViewModel.StoreState call(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
                    Intrinsics3.checkNotNullExpressionValue(modelCustomStatusSetting, "customStatusSetting");
                    Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
                    return new WidgetUserSetCustomStatusViewModel.StoreState(modelCustomStatusSetting, emojiSet);
                }
            }).Z(1);
            Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…        )\n      }.take(1)");
            return observableZ;
        }

        public final FormState.Expiration getDEFAULT_EXPIRATION() {
            return WidgetUserSetCustomStatusViewModel.DEFAULT_EXPIRATION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final /* data */ class SetStatusFailure extends Event {
            private final int failureMessageStringRes;

            public SetStatusFailure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ SetStatusFailure copy$default(SetStatusFailure setStatusFailure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setStatusFailure.failureMessageStringRes;
                }
                return setStatusFailure.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final SetStatusFailure copy(int failureMessageStringRes) {
                return new SetStatusFailure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetStatusFailure) && this.failureMessageStringRes == ((SetStatusFailure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("SetStatusFailure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final /* data */ class SetStatusSuccess extends Event {
            private final int successMessageStringRes;

            public SetStatusSuccess(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ SetStatusSuccess copy$default(SetStatusSuccess setStatusSuccess, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = setStatusSuccess.successMessageStringRes;
                }
                return setStatusSuccess.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final SetStatusSuccess copy(int successMessageStringRes) {
                return new SetStatusSuccess(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SetStatusSuccess) && this.successMessageStringRes == ((SetStatusSuccess) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("SetStatusSuccess(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final /* data */ class FormState {
        private final Emoji emoji;
        private final Expiration expiration;
        private final String text;

        /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public enum Expiration {
            NEVER,
            IN_30_MINUTES,
            IN_1_HOUR,
            IN_4_HOURS,
            TOMORROW
        }

        public FormState(Emoji emoji, String str, Expiration expiration) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(expiration, "expiration");
            this.emoji = emoji;
            this.text = str;
            this.expiration = expiration;
        }

        public static /* synthetic */ FormState copy$default(FormState formState, Emoji emoji, String str, Expiration expiration, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = formState.emoji;
            }
            if ((i & 2) != 0) {
                str = formState.text;
            }
            if ((i & 4) != 0) {
                expiration = formState.expiration;
            }
            return formState.copy(emoji, str, expiration);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Expiration getExpiration() {
            return this.expiration;
        }

        public final FormState copy(Emoji emoji, String text, Expiration expiration) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(expiration, "expiration");
            return new FormState(emoji, text, expiration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormState)) {
                return false;
            }
            FormState formState = (FormState) other;
            return Intrinsics3.areEqual(this.emoji, formState.emoji) && Intrinsics3.areEqual(this.text, formState.text) && Intrinsics3.areEqual(this.expiration, formState.expiration);
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final Expiration getExpiration() {
            return this.expiration;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            Emoji emoji = this.emoji;
            int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
            String str = this.text;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            Expiration expiration = this.expiration;
            return iHashCode2 + (expiration != null ? expiration.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FormState(emoji=");
            sbU.append(this.emoji);
            sbU.append(", text=");
            sbU.append(this.text);
            sbU.append(", expiration=");
            sbU.append(this.expiration);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final /* data */ class StoreState {
        private final ModelCustomStatusSetting customStatusSetting;
        private final EmojiSet emojiSet;

        public StoreState(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
            Intrinsics3.checkNotNullParameter(modelCustomStatusSetting, "customStatusSetting");
            Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
            this.customStatusSetting = modelCustomStatusSetting;
            this.emojiSet = emojiSet;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet, int i, Object obj) {
            if ((i & 1) != 0) {
                modelCustomStatusSetting = storeState.customStatusSetting;
            }
            if ((i & 2) != 0) {
                emojiSet = storeState.emojiSet;
            }
            return storeState.copy(modelCustomStatusSetting, emojiSet);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelCustomStatusSetting getCustomStatusSetting() {
            return this.customStatusSetting;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final EmojiSet getEmojiSet() {
            return this.emojiSet;
        }

        public final StoreState copy(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
            Intrinsics3.checkNotNullParameter(customStatusSetting, "customStatusSetting");
            Intrinsics3.checkNotNullParameter(emojiSet, "emojiSet");
            return new StoreState(customStatusSetting, emojiSet);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.customStatusSetting, storeState.customStatusSetting) && Intrinsics3.areEqual(this.emojiSet, storeState.emojiSet);
        }

        public final ModelCustomStatusSetting getCustomStatusSetting() {
            return this.customStatusSetting;
        }

        public final EmojiSet getEmojiSet() {
            return this.emojiSet;
        }

        public int hashCode() {
            ModelCustomStatusSetting modelCustomStatusSetting = this.customStatusSetting;
            int iHashCode = (modelCustomStatusSetting != null ? modelCustomStatusSetting.hashCode() : 0) * 31;
            EmojiSet emojiSet = this.emojiSet;
            return iHashCode + (emojiSet != null ? emojiSet.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(customStatusSetting=");
            sbU.append(this.customStatusSetting);
            sbU.append(", emojiSet=");
            sbU.append(this.emojiSet);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final FormState formState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(FormState formState) {
                super(null);
                Intrinsics3.checkNotNullParameter(formState, "formState");
                this.formState = formState;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, FormState formState, int i, Object obj) {
                if ((i & 1) != 0) {
                    formState = loaded.formState;
                }
                return loaded.copy(formState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FormState getFormState() {
                return this.formState;
            }

            public final Loaded copy(FormState formState) {
                Intrinsics3.checkNotNullParameter(formState, "formState");
                return new Loaded(formState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.formState, ((Loaded) other).formState);
                }
                return true;
            }

            public final FormState getFormState() {
                return this.formState;
            }

            public final boolean getShowStatusClear() {
                if (this.formState.getEmoji() == null) {
                    if (!(this.formState.getText().length() > 0)) {
                        return false;
                    }
                }
                return true;
            }

            public int hashCode() {
                FormState formState = this.formState;
                if (formState != null) {
                    return formState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(formState=");
                sbU.append(this.formState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FormState.Expiration.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[FormState.Expiration.NEVER.ordinal()] = 1;
            iArr[FormState.Expiration.IN_30_MINUTES.ordinal()] = 2;
            iArr[FormState.Expiration.IN_1_HOUR.ordinal()] = 3;
            iArr[FormState.Expiration.IN_4_HOURS.ordinal()] = 4;
            iArr[FormState.Expiration.TOMORROW.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$saveStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserSettings, Unit> {
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
            WidgetUserSetCustomStatusViewModel.this.emitSetStatusSuccessEvent();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$saveStatus$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSetCustomStatusViewModel.this.emitSetStatusFailureEvent();
        }
    }

    public WidgetUserSetCustomStatusViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeUserSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        clock = (i & 2) != 0 ? ClockFactory.get() : clock;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(companion2.getUserSettings(), companion2.getEmojis());
        }
        this(storeUserSettings, clock, observable);
    }

    private final void emitSetStatusFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetStatusFailure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSetStatusSuccessEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.SetStatusSuccess(R.string.custom_status_update_success));
    }

    private final Emoji getEmojiFromSetting(ModelCustomStatusSetting customStatusSetting, EmojiSet emojiSet) {
        String emojiName;
        if (customStatusSetting == ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return null;
        }
        Long emojiId = customStatusSetting.getEmojiId();
        if (emojiId == null || (emojiName = String.valueOf(emojiId.longValue())) == null) {
            emojiName = customStatusSetting.getEmojiName();
        }
        return emojiSet.emojiIndex.get(emojiName);
    }

    private final String getExpirationUTCDateString(FormState.Expiration expiresAt) {
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
        if (customStatusSetting != ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return customStatusSetting.getText();
        }
        return null;
    }

    private final void handleStoreState(StoreState storeState) {
        if (getViewState() instanceof ViewState.Loaded) {
            return;
        }
        Emoji emojiFromSetting = getEmojiFromSetting(storeState.getCustomStatusSetting(), storeState.getEmojiSet());
        String statusTextFromSetting = getStatusTextFromSetting(storeState.getCustomStatusSetting());
        if (statusTextFromSetting == null) {
            statusTextFromSetting = "";
        }
        updateViewState(new ViewState.Loaded(new FormState(emojiFromSetting, statusTextFromSetting, DEFAULT_EXPIRATION)));
    }

    private final void updateFormState(FormState formState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(loaded.copy(formState));
        }
    }

    public final void clearStatusTextAndEmoji() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, "", null, 4, null));
        }
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final StoreUserSettings getStoreUserSettings() {
        return this.storeUserSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveStatus() {
        ModelCustomStatusSetting modelCustomStatusSetting;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            FormState formState = loaded.getFormState();
            String text = formState.getText();
            Objects.requireNonNull(text, "null cannot be cast to non-null type kotlin.CharSequence");
            String string = Strings4.trim(text).toString();
            if (!(string.length() > 0)) {
                string = null;
            }
            FormState formState2 = string != null || formState.getEmoji() != null ? formState : null;
            if (formState2 != null) {
                Emoji emoji = formState2.getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = formState2.getEmoji();
                if (!(emoji2 instanceof ModelEmojiUnicode)) {
                    emoji2 = null;
                }
                ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
                modelCustomStatusSetting = new ModelCustomStatusSetting(string, lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getExpirationUTCDateString(formState2.getExpiration()));
            } else {
                modelCustomStatusSetting = null;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeUserSettings.updateCustomStatus(modelCustomStatusSetting), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSetCustomStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            if (modelCustomStatusSetting != null) {
                AnalyticsTracker.INSTANCE.customStatusUpdated(formState, new Traits.Location(null, "Account Panel", "Avatar", null, null, 25, null));
            }
        }
    }

    public final void setExpiration(FormState.Expiration expiration) {
        Intrinsics3.checkNotNullParameter(expiration, "expiration");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, null, expiration, 3, null));
        }
    }

    public final void setStatusEmoji(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), emoji, null, null, 6, null));
        }
    }

    public final void setStatusText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateFormState(FormState.copy$default(loaded.getFormState(), null, text, null, 5, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel(StoreUserSettings storeUserSettings, Clock clock, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.clock = clock;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetUserSetCustomStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        this.eventSubject = PublishSubject.k0();
    }
}
