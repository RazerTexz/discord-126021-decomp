package com.discord.widgets.stage.sheet;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private Subscription lastRequestToSpeakSubscription;
    private final StoreUser usersStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
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
            WidgetStageRaisedHandsBottomSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreVoiceParticipants voiceParticipants, StoreChannels channelsStore, StoreGuilds guildsStore, StoreStageChannels stageChannels, Clock clock) {
            Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.r().Y(new WidgetStageRaisedHandsBottomSheetViewModel2(guildsStore, voiceParticipants, channelId, stageChannels, clock));
            Intrinsics3.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        public static final /* data */ class Error extends Event {
            private final com.discord.utilities.error.Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(com.discord.utilities.error.Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ Error copy$default(Error error, com.discord.utilities.error.Error error2, int i, Object obj) {
                if ((i & 1) != 0) {
                    error2 = error.error;
                }
                return error.copy(error2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public final Error copy(com.discord.utilities.error.Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && Intrinsics3.areEqual(this.error, ((Error) other).error);
                }
                return true;
            }

            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public int hashCode() {
                com.discord.utilities.error.Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Error(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final int myStageRoles;
        private final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants;
        private final Map<Long, GuildRole> roles;

        /* JADX WARN: Multi-variable type inference failed */
        private StoreState(Channel channel, Map<Long, GuildRole> map, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list, int i) {
            this.channel = channel;
            this.roles = map;
            this.raisedHandsParticipants = list;
            this.myStageRoles = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-FZjiw-U$default, reason: not valid java name */
        public static /* synthetic */ StoreState m47copyFZjiwU$default(StoreState storeState, Channel channel, Map map, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i2 & 2) != 0) {
                map = storeState.roles;
            }
            if ((i2 & 4) != 0) {
                list = storeState.raisedHandsParticipants;
            }
            if ((i2 & 8) != 0) {
                i = storeState.myStageRoles;
            }
            return storeState.m49copyFZjiwU(channel, map, list, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, GuildRole> component2() {
            return this.roles;
        }

        public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> component3() {
            return this.raisedHandsParticipants;
        }

        /* JADX INFO: renamed from: component4-1LxfuJo, reason: not valid java name and from getter */
        public final int getMyStageRoles() {
            return this.myStageRoles;
        }

        /* JADX INFO: renamed from: copy-FZjiw-U, reason: not valid java name */
        public final StoreState m49copyFZjiwU(Channel channel, Map<Long, GuildRole> roles, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants, int myStageRoles) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(raisedHandsParticipants, "raisedHandsParticipants");
            return new StoreState(channel, roles, raisedHandsParticipants, myStageRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.roles, storeState.roles) && Intrinsics3.areEqual(this.raisedHandsParticipants, storeState.raisedHandsParticipants) && this.myStageRoles == storeState.myStageRoles;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
        public final int m50getMyStageRoles1LxfuJo() {
            return this.myStageRoles;
        }

        public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> getRaisedHandsParticipants() {
            return this.raisedHandsParticipants;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.roles;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list = this.raisedHandsParticipants;
            return ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.myStageRoles;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", raisedHandsParticipants=");
            sbU.append(this.raisedHandsParticipants);
            sbU.append(", myStageRoles=");
            sbU.append(StageRoles.m34toStringimpl(this.myStageRoles));
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ StoreState(Channel channel, Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, map, list, i);
        }
    }

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final boolean isEmpty;
            private final boolean isRequestToSpeakEnabled;
            private final boolean isSpeaker;
            private final boolean isTogglingSpeakingState;
            private final boolean isUpdatingRequestToSpeakPermissions;
            private final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants;

            public /* synthetic */ Loaded(Channel channel, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, list, z2, z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Channel channel, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 2) != 0) {
                    list = loaded.raisedHandsParticipants;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    z2 = loaded.isRequestToSpeakEnabled;
                }
                boolean z6 = z2;
                if ((i & 8) != 0) {
                    z3 = loaded.isSpeaker;
                }
                boolean z7 = z3;
                if ((i & 16) != 0) {
                    z4 = loaded.isUpdatingRequestToSpeakPermissions;
                }
                boolean z8 = z4;
                if ((i & 32) != 0) {
                    z5 = loaded.isTogglingSpeakingState;
                }
                return loaded.copy(channel, list2, z6, z7, z8, z5);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> component2() {
                return this.raisedHandsParticipants;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsRequestToSpeakEnabled() {
                return this.isRequestToSpeakEnabled;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsSpeaker() {
                return this.isSpeaker;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIsUpdatingRequestToSpeakPermissions() {
                return this.isUpdatingRequestToSpeakPermissions;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsTogglingSpeakingState() {
                return this.isTogglingSpeakingState;
            }

            public final Loaded copy(Channel channel, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> raisedHandsParticipants, boolean isRequestToSpeakEnabled, boolean isSpeaker, boolean isUpdatingRequestToSpeakPermissions, boolean isTogglingSpeakingState) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(raisedHandsParticipants, "raisedHandsParticipants");
                return new Loaded(channel, raisedHandsParticipants, isRequestToSpeakEnabled, isSpeaker, isUpdatingRequestToSpeakPermissions, isTogglingSpeakingState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.raisedHandsParticipants, loaded.raisedHandsParticipants) && this.isRequestToSpeakEnabled == loaded.isRequestToSpeakEnabled && this.isSpeaker == loaded.isSpeaker && this.isUpdatingRequestToSpeakPermissions == loaded.isUpdatingRequestToSpeakPermissions && this.isTogglingSpeakingState == loaded.isTogglingSpeakingState;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> getRaisedHandsParticipants() {
                return this.raisedHandsParticipants;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v13 */
            /* JADX WARN: Type inference failed for: r1v14 */
            /* JADX WARN: Type inference failed for: r1v15 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                List<WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list = this.raisedHandsParticipants;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isRequestToSpeakEnabled;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.isSpeaker;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.isUpdatingRequestToSpeakPermissions;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.isTogglingSpeakingState;
                return i3 + (z5 ? 1 : z5);
            }

            /* JADX INFO: renamed from: isEmpty, reason: from getter */
            public final boolean getIsEmpty() {
                return this.isEmpty;
            }

            public final boolean isRequestToSpeakEnabled() {
                return this.isRequestToSpeakEnabled;
            }

            public final boolean isSpeaker() {
                return this.isSpeaker;
            }

            public final boolean isTogglingSpeakingState() {
                return this.isTogglingSpeakingState;
            }

            public final boolean isUpdatingRequestToSpeakPermissions() {
                return this.isUpdatingRequestToSpeakPermissions;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(channel=");
                sbU.append(this.channel);
                sbU.append(", raisedHandsParticipants=");
                sbU.append(this.raisedHandsParticipants);
                sbU.append(", isRequestToSpeakEnabled=");
                sbU.append(this.isRequestToSpeakEnabled);
                sbU.append(", isSpeaker=");
                sbU.append(this.isSpeaker);
                sbU.append(", isUpdatingRequestToSpeakPermissions=");
                sbU.append(this.isUpdatingRequestToSpeakPermissions);
                sbU.append(", isTogglingSpeakingState=");
                return outline.O(sbU, this.isTogglingSpeakingState, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Channel channel, List<? extends WidgetStageRaisedHandsBottomSheetAdapter.ListItem> list, boolean z2, boolean z3, boolean z4, boolean z5) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(list, "raisedHandsParticipants");
                this.channel = channel;
                this.raisedHandsParticipants = list;
                this.isRequestToSpeakEnabled = z2;
                this.isSpeaker = z3;
                this.isUpdatingRequestToSpeakPermissions = z4;
                this.isTogglingSpeakingState = z5;
                this.isEmpty = list.isEmpty();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$dismissRequestToSpeak$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "emitError", "emitError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).emitError(error);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$inviteToSpeak$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
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
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetStageRaisedHandsBottomSheetViewModel.this.lastRequestToSpeakSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
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
            ViewState viewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetStageRaisedHandsBottomSheetViewModel.this.updateViewState(ViewState.Loaded.copy$default(loaded, null, null, false, false, false, false, 47, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setRequestToSpeakEnabled$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $isEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z2) {
            super(1);
            this.$isEnabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r10) {
            ViewState viewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetStageRaisedHandsBottomSheetViewModel.this.updateViewState(ViewState.Loaded.copy$default(loaded, null, null, this.$isEnabled, false, false, false, 43, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "emitError", "emitError(Lcom/discord/utilities/error/Error;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).emitError(error);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ViewState viewStateAccess$getViewState$p = WidgetStageRaisedHandsBottomSheetViewModel.access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetStageRaisedHandsBottomSheetViewModel.this.updateViewState(ViewState.Loaded.copy$default(loaded, null, null, false, false, false, false, 31, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$setSpeakingState$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel(long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreVoiceParticipants voiceParticipants = (i & 2) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreStageChannels stageChannels = (i & 32) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        Clock clock2 = (i & 64) != 0 ? ClockFactory.get() : clock;
        this(j, voiceParticipants, channels, users, guilds, stageChannels, clock2, (i & 128) != 0 ? INSTANCE.observeStoreState(j, voiceParticipants, channels, guilds, stageChannels, clock2) : observable);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        return widgetStageRaisedHandsBottomSheetViewModel.getViewState();
    }

    private final void emitDismiss() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    private final void emitError(Error error) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.Error(error));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(storeState.getChannel(), storeState.getRaisedHandsParticipants(), PermissionUtils.INSTANCE.canEveryoneRole(Permission.REQUEST_TO_SPEAK, storeState.getChannel(), storeState.getRoles()), StageRoles.m33isSpeakerimpl(storeState.m50getMyStageRoles1LxfuJo()), false, false, 48, null));
    }

    private final Observable<Void> setUserSuppressed(final long userId, final boolean isSuppressed) {
        Observable<R> observableG = this.channelsStore.observeChannel(this.channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableA = observableG.z().A(new Func1<Channel, Observable<? extends Void>>() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel.setUserSuppressed.1
            @Override // j0.k.Func1
            public final Observable<? extends Void> call(Channel channel) {
                StageChannelAPI stageChannelAPI = StageChannelAPI.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                return ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(stageChannelAPI, channel, userId, isSuppressed, 0L, 8, null), false, 1, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "channelSingle\n        .f…stSubscribeOn()\n        }");
        return ObservableExtensionsKt.ui$default(observableA, this, null, 2, null);
    }

    public final void dismissRequestToSpeak(StoreVoiceParticipants.VoiceUser participant) {
        Intrinsics3.checkNotNullParameter(participant, "participant");
        ObservableExtensionsKt.appSubscribe(setUserSuppressed(participant.getUser().getId(), true), (Class<?>) WidgetStageRaisedHandsBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    public final void inviteToSpeak(StoreVoiceParticipants.VoiceUser participant) {
        Intrinsics3.checkNotNullParameter(participant, "participant");
        ObservableExtensionsKt.appSubscribe(setUserSuppressed(participant.getUser().getId(), false), (Class<?>) WidgetStageRaisedHandsBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setRequestToSpeakEnabled(boolean isEnabled) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, false, false, true, false, 47, null));
            Tuples2<Long, Long> tuples2ComputeAllowDenyUpdateBits = PermissionOverwriteUtils.computeAllowDenyUpdateBits(ChannelUtils.f(loaded.getChannel(), loaded.getChannel().getGuildId()), Permission.REQUEST_TO_SPEAK, isEnabled);
            long jLongValue = tuples2ComputeAllowDenyUpdateBits.component1().longValue();
            long jLongValue2 = tuples2ComputeAllowDenyUpdateBits.component2().longValue();
            Subscription subscription = this.lastRequestToSpeakSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(loaded.getChannel().getId(), loaded.getChannel().getGuildId(), RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(loaded.getChannel().getGuildId(), Long.valueOf(jLongValue), Long.valueOf(jLongValue2))), false, 1, null), this, null, 2, null), (Class<?>) WidgetStageRaisedHandsBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(isEnabled));
        }
    }

    public final void setSpeakingState(boolean isSuppressed) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, false, false, false, true, 31, null));
            ObservableExtensionsKt.appSubscribe(setUserSuppressed(this.usersStore.getMeSnapshot().getId(), isSuppressed), (Class<?>) WidgetStageRaisedHandsBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass2()), AnonymousClass3.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetViewModel(long j, StoreVoiceParticipants storeVoiceParticipants, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreStageChannels storeStageChannels, Clock clock, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.voiceParticipants = storeVoiceParticipants;
        this.channelsStore = storeChannels;
        this.usersStore = storeUser;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetStageRaisedHandsBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        this.eventSubject = PublishSubject.k0();
    }
}
