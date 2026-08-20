package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private final RestAPI restApi;
    private final StoreUserGuildSettings storeUserGuildSettings;

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$1 */
    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static final class C75711 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C75711() {
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
            ChannelGroupDMSettingsViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels storeChannels, final StoreUserGuildSettings storeUserGuildSettings) {
            Observable observableM11099Y = storeChannels.observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call(Channel channel) {
                    return channel == null ? new C12721k(ChannelGroupDMSettingsViewModel.StoreState.Invalid.INSTANCE) : Observable.m11076j(new C12721k(channel), storeUserGuildSettings.observeGuildSettings(channel.getGuildId()), new Func2<Channel, ModelNotificationSettings, ChannelGroupDMSettingsViewModel.StoreState.Valid>() { // from class: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Func2
                        public final ChannelGroupDMSettingsViewModel.StoreState.Valid call(Channel channel2, ModelNotificationSettings modelNotificationSettings) {
                            C12238m.checkNotNullExpressionValue(channel2, "channel");
                            C12238m.checkNotNullExpressionValue(modelNotificationSettings, "notificationSettings");
                            return new ChannelGroupDMSettingsViewModel.StoreState.Valid(channel2, modelNotificationSettings);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeChannels\n          …            }\n          }");
            return observableM11099Y;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storeUserGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            }
            return companion.observeStoreState(j, storeChannels, storeUserGuildSettings);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class LeaveGroupSuccess extends Event {
            public static final LeaveGroupSuccess INSTANCE = new LeaveGroupSuccess();

            private LeaveGroupSuccess() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class SettingsSaved extends Event {
            public static final SettingsSaved INSTANCE = new SettingsSaved();

            private SettingsSaved() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Channel channel;
            private final ModelNotificationSettings notificationSettings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, ModelNotificationSettings modelNotificationSettings) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
                this.channel = channel;
                this.notificationSettings = modelNotificationSettings;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, ModelNotificationSettings modelNotificationSettings, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i & 2) != 0) {
                    modelNotificationSettings = valid.notificationSettings;
                }
                return valid.copy(channel, modelNotificationSettings);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ModelNotificationSettings getNotificationSettings() {
                return this.notificationSettings;
            }

            public final Valid copy(Channel channel, ModelNotificationSettings notificationSettings) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(notificationSettings, "notificationSettings");
                return new Valid(channel, notificationSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.channel, valid.channel) && C12238m.areEqual(this.notificationSettings, valid.notificationSettings);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final ModelNotificationSettings getNotificationSettings() {
                return this.notificationSettings;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
                return iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", notificationSettings=");
                sbM833U.append(this.notificationSettings);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final ChannelSettings channelSettings;
            private final String editedIconUrl;
            private final boolean hasUnsavedIconChange;

            /* JADX INFO: renamed from: isDefaultPhoto$delegate, reason: from kotlin metadata */
            private final Lazy isDefaultPhoto;
            private final String originalIconUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ChannelSettings channelSettings, String str, String str2) {
                super(null);
                C12238m.checkNotNullParameter(channelSettings, "channelSettings");
                this.channelSettings = channelSettings;
                this.originalIconUrl = str;
                this.editedIconUrl = str2;
                this.hasUnsavedIconChange = !C12238m.areEqual(str, str2);
                this.isDefaultPhoto = C12083g.lazy(new ChannelGroupDMSettingsViewModel$ViewState$Valid$isDefaultPhoto$2(this));
            }

            public static /* synthetic */ Valid copy$default(Valid valid, ChannelSettings channelSettings, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelSettings = valid.channelSettings;
                }
                if ((i & 2) != 0) {
                    str = valid.originalIconUrl;
                }
                if ((i & 4) != 0) {
                    str2 = valid.editedIconUrl;
                }
                return valid.copy(channelSettings, str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ChannelSettings getChannelSettings() {
                return this.channelSettings;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getOriginalIconUrl() {
                return this.originalIconUrl;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getEditedIconUrl() {
                return this.editedIconUrl;
            }

            public final Valid copy(ChannelSettings channelSettings, String originalIconUrl, String editedIconUrl) {
                C12238m.checkNotNullParameter(channelSettings, "channelSettings");
                return new Valid(channelSettings, originalIconUrl, editedIconUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.channelSettings, valid.channelSettings) && C12238m.areEqual(this.originalIconUrl, valid.originalIconUrl) && C12238m.areEqual(this.editedIconUrl, valid.editedIconUrl);
            }

            public final ChannelSettings getChannelSettings() {
                return this.channelSettings;
            }

            public final String getCurrentIconUrl() {
                if (!this.hasUnsavedIconChange) {
                    return IconUtils.getForChannel(this.channelSettings.getChannel(), null);
                }
                String str = this.editedIconUrl;
                return str != null ? str : IconUtils.INSTANCE.getDefaultForGroupDM(this.channelSettings.getChannel().getId());
            }

            public final String getEditedIconUrl() {
                return this.editedIconUrl;
            }

            public final boolean getHasUnsavedIconChange() {
                return this.hasUnsavedIconChange;
            }

            public final String getOriginalIconUrl() {
                return this.originalIconUrl;
            }

            public int hashCode() {
                ChannelSettings channelSettings = this.channelSettings;
                int iHashCode = (channelSettings != null ? channelSettings.hashCode() : 0) * 31;
                String str = this.originalIconUrl;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.editedIconUrl;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public final boolean isDefaultPhoto() {
                return ((Boolean) this.isDefaultPhoto.getValue()).booleanValue();
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(channelSettings=");
                sbM833U.append(this.channelSettings);
                sbM833U.append(", originalIconUrl=");
                sbM833U.append(this.originalIconUrl);
                sbM833U.append(", editedIconUrl=");
                return C1643a.m822J(sbM833U, this.editedIconUrl, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$editGroup$1 */
    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static final class C75731 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C75731(ViewState.Valid valid) {
            super(1);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "it");
            ChannelGroupDMSettingsViewModel.this.eventSubject.f27650k.onNext((T) Event.SettingsSaved.INSTANCE);
            ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel = ChannelGroupDMSettingsViewModel.this;
            ViewState.Valid valid = this.$viewState;
            channelGroupDMSettingsViewModel.updateViewState(valid.copy(ChannelSettings.copy$default(valid.getChannelSettings(), channel, false, null, 6, null), IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$leaveGroup$1 */
    /* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
    public static final class C75741 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C75741() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "it");
            ChannelGroupDMSettingsViewModel.this.eventSubject.f27650k.onNext((T) Event.LeaveGroupSuccess.INSTANCE);
        }
    }

    public /* synthetic */ ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, (i & 8) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, 6, null) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (C12238m.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Channel channel = valid.getChannel();
            ChannelSettings channelSettingsCreateFromNotificationSettings = ChannelSettings.INSTANCE.createFromNotificationSettings(channel, valid.getNotificationSettings());
            ViewState viewState = getViewState();
            updateViewState(viewState instanceof ViewState.Valid ? ViewState.Valid.copy$default((ViewState.Valid) viewState, channelSettingsCreateFromNotificationSettings, null, null, 6, null) : new ViewState.Valid(channelSettingsCreateFromNotificationSettings, IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    @MainThread
    public final void editGroup(long groupId, String name) {
        String originalIconUrl;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (valid.getHasUnsavedIconChange()) {
                originalIconUrl = valid.getEditedIconUrl();
                if (originalIconUrl == null) {
                    originalIconUrl = "";
                }
            } else {
                originalIconUrl = valid.getOriginalIconUrl();
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.editGroupDM(groupId, new RestAPIParams.GroupDM(name, originalIconUrl)), false, 1, null), this, null, 2, null), (Class<?>) ChannelGroupDMSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75731(valid));
        }
    }

    @MainThread
    public final void leaveGroup() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.deleteChannel(valid.getChannelSettings().getChannel().getId()), false, 1, null), this, null, 2, null), (Class<?>) ChannelGroupDMSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75741());
        }
    }

    @MainThread
    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onIconEdited(String iconUrl) {
        C12238m.checkNotNullParameter(iconUrl, "iconUrl");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, iconUrl, 3, null));
        }
    }

    @MainThread
    public final void removeEditedIcon() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, null, 3, null));
        }
    }

    public final void unmute(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        this.storeUserGuildSettings.setChannelMuted(context, this.channelId, false, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(restAPI, "restApi");
        C12238m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.restApi = restAPI;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ChannelGroupDMSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75711());
    }
}
