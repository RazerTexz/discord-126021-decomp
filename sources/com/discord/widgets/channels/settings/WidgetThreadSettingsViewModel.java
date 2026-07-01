package com.discord.widgets.channels.settings;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettingsViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final PublishSubject<Event> eventSubject;

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<StoreState> {
        public final /* synthetic */ StoreChannels $channelStore;
        public final /* synthetic */ StorePermissions $permissionStore;
        public final /* synthetic */ StoreUser $userStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreChannels storeChannels, StoreUser storeUser, StorePermissions storePermissions) {
            super(0);
            this.$channelStore = storeChannels;
            this.$userStore = storeUser;
            this.$permissionStore = storePermissions;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StoreState invoke() {
            Channel channel = this.$channelStore.getChannel(WidgetThreadSettingsViewModel.this.getChannelId());
            return new StoreState(channel, channel != null ? ThreadUtils.INSTANCE.canManageThread(this.$userStore.getMeSnapshot(), channel, (Long) outline.d(channel, this.$permissionStore.getPermissionsByChannel())) : false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetThreadSettingsViewModel widgetThreadSettingsViewModel = WidgetThreadSettingsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetThreadSettingsViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int messageStringRes;

            public ShowToast(@StringRes int i) {
                super(null);
                this.messageStringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.messageStringRes;
                }
                return showToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMessageStringRes() {
                return this.messageStringRes;
            }

            public final ShowToast copy(@StringRes int messageStringRes) {
                return new ShowToast(messageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.messageStringRes == ((ShowToast) other).messageStringRes;
                }
                return true;
            }

            public final int getMessageStringRes() {
                return this.messageStringRes;
            }

            public int hashCode() {
                return this.messageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(messageStringRes="), this.messageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean canManageThread;
        private final Channel channel;

        public StoreState(Channel channel, boolean z2) {
            this.channel = channel;
            this.canManageThread = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                z2 = storeState.canManageThread;
            }
            return storeState.copy(channel, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final StoreState copy(Channel channel, boolean canManageThread) {
            return new StoreState(channel, canManageThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channel, storeState.channel) && this.canManageThread == storeState.canManageThread;
        }

        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.canManageThread;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", canManageThread=");
            return outline.O(sbU, this.canManageThread, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final boolean canManageThread;
            private final Channel channel;
            private final String channelNameDraft;
            private final boolean hasUnsavedChanges;
            private final boolean isPinsEnabled;
            private final int slowModeCooldownDraft;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, String str, int i, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.channelNameDraft = str;
                this.slowModeCooldownDraft = i;
                this.hasUnsavedChanges = z2;
                this.canManageThread = z3;
                this.isPinsEnabled = z4;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, String str, int i, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i2 & 2) != 0) {
                    str = valid.channelNameDraft;
                }
                String str2 = str;
                if ((i2 & 4) != 0) {
                    i = valid.slowModeCooldownDraft;
                }
                int i3 = i;
                if ((i2 & 8) != 0) {
                    z2 = valid.hasUnsavedChanges;
                }
                boolean z5 = z2;
                if ((i2 & 16) != 0) {
                    z3 = valid.canManageThread;
                }
                boolean z6 = z3;
                if ((i2 & 32) != 0) {
                    z4 = valid.isPinsEnabled;
                }
                return valid.copy(channel, str2, i3, z5, z6, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getChannelNameDraft() {
                return this.channelNameDraft;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getSlowModeCooldownDraft() {
                return this.slowModeCooldownDraft;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getHasUnsavedChanges() {
                return this.hasUnsavedChanges;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getCanManageThread() {
                return this.canManageThread;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsPinsEnabled() {
                return this.isPinsEnabled;
            }

            public final Valid copy(Channel channel, String channelNameDraft, int slowModeCooldownDraft, boolean hasUnsavedChanges, boolean canManageThread, boolean isPinsEnabled) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new Valid(channel, channelNameDraft, slowModeCooldownDraft, hasUnsavedChanges, canManageThread, isPinsEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channel, valid.channel) && Intrinsics3.areEqual(this.channelNameDraft, valid.channelNameDraft) && this.slowModeCooldownDraft == valid.slowModeCooldownDraft && this.hasUnsavedChanges == valid.hasUnsavedChanges && this.canManageThread == valid.canManageThread && this.isPinsEnabled == valid.isPinsEnabled;
            }

            public final boolean getCanManageThread() {
                return this.canManageThread;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final String getChannelNameDraft() {
                return this.channelNameDraft;
            }

            public final boolean getHasUnsavedChanges() {
                return this.hasUnsavedChanges;
            }

            public final int getSlowModeCooldownDraft() {
                return this.slowModeCooldownDraft;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                String str = this.channelNameDraft;
                int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.slowModeCooldownDraft) * 31;
                boolean z2 = this.hasUnsavedChanges;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.canManageThread;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.isPinsEnabled;
                return i2 + (z4 ? 1 : z4);
            }

            public final boolean isPinsEnabled() {
                return this.isPinsEnabled;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channel=");
                sbU.append(this.channel);
                sbU.append(", channelNameDraft=");
                sbU.append(this.channelNameDraft);
                sbU.append(", slowModeCooldownDraft=");
                sbU.append(this.slowModeCooldownDraft);
                sbU.append(", hasUnsavedChanges=");
                sbU.append(this.hasUnsavedChanges);
                sbU.append(", canManageThread=");
                sbU.append(this.canManageThread);
                sbU.append(", isPinsEnabled=");
                return outline.O(sbU, this.isPinsEnabled, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$onThreadDeleted$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Integer numB = ChannelUtils.b(channel);
            if (numB != null) {
                WidgetThreadSettingsViewModel.this.eventSubject.k.onNext((T) new Event.ShowToast(numB.intValue()));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$onThreadDeleted$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetThreadSettingsViewModel.this.eventSubject.k.onNext((T) new Event.ShowToast(R.string.default_failure_to_perform_action_message));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$saveThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetThreadSettingsViewModel.this.eventSubject.k.onNext((T) new Event.ShowToast(R.string.thread_settings_updated));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$saveThread$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetThreadSettingsViewModel.this.eventSubject.k.onNext((T) new Event.ShowToast(R.string.default_failure_to_perform_action_message));
        }
    }

    public WidgetThreadSettingsViewModel(long j) {
        super(null, 1, null);
        this.channelId = j;
        this.eventSubject = PublishSubject.k0();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreChannels channels = companion.getChannels();
        StorePermissions permissions = companion.getPermissions();
        StoreUser users = companion.getUsers();
        Observable observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, permissions, users}, false, null, null, new AnonymousClass1(channels, users, permissions), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), (Class<?>) WidgetThreadSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Channel channel = storeState.getChannel();
        if ((channel != null ? channel.getName() : null) == null || !ChannelUtils.H(channel)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        boolean z2 = !channel.getNsfw() || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(channel.getGuildId());
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if ((valid != null ? valid.getChannelNameDraft() : null) != null) {
            updateViewState(ViewState.Valid.copy$default(valid, channel, null, 0, false, false, false, 62, null));
        } else {
            updateViewState(new ViewState.Valid(channel, channel.getName(), channel.getRateLimitPerUser(), false, storeState.getCanManageThread(), z2));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onChannelNameInputChanged(String value) {
        Intrinsics3.checkNotNullParameter(value, "value");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, value, 0, true, false, false, 53, null));
        }
    }

    @MainThread
    public final void onSlowModeInputChanged(int cooldown) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, cooldown, true, false, false, 51, null));
        }
    }

    public final void onThreadDeleted(long channelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(channelId), false, 1, null), this, null, 2, null), (Class<?>) WidgetThreadSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void saveThread() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().editTextChannel(this.channelId, (92 & 2) != 0 ? null : Intrinsics3.areEqual(valid.getChannel().getName(), valid.getChannelNameDraft()) ^ true ? valid.getChannelNameDraft() : null, (92 & 4) != 0 ? null : null, (92 & 8) != 0 ? null : null, (92 & 16) != 0 ? null : null, (92 & 32) != 0 ? null : valid.getChannel().getRateLimitPerUser() != valid.getSlowModeCooldownDraft() ? Integer.valueOf(valid.getSlowModeCooldownDraft()) : null, (92 & 64) != 0 ? null : null), this, null, 2, null), (Class<?>) WidgetThreadSettingsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }
}
