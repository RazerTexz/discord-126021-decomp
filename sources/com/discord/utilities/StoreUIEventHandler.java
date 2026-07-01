package com.discord.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUIEventHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUIEventHandler {
    private final StoreChannels channelsStore;
    private final Context context;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreStageChannels stageChannelsStore;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            KrispOveruseDetector.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[KrispOveruseDetector.Status.CPU_OVERUSE.ordinal()] = 1;
            iArr[KrispOveruseDetector.Status.VAD_CPU_OVERUSE.ordinal()] = 2;
            iArr[KrispOveruseDetector.Status.FAILED.ordinal()] = 3;
            StoreUserGuildSettings.SettingsUpdateType.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.GUILD.ordinal()] = 1;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.CHANNEL.ordinal()] = 2;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.THREAD.ordinal()] = 3;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.CATEGORY.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUIEventHandler.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<KrispOveruseDetector.Status, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KrispOveruseDetector.Status status) {
            invoke2(status);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KrispOveruseDetector.Status status) {
            Intrinsics3.checkNotNullParameter(status, "it");
            StoreUIEventHandler.this.handleKrispStatusEvent(status);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUIEventHandler.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreUserGuildSettings.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserGuildSettings.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserGuildSettings.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            StoreUIEventHandler.this.handleUserGuildSettingsEvent(event);
        }
    }

    public StoreUIEventHandler(Context context, StoreMediaEngine storeMediaEngine, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageChannels storeStageChannels, StoreUserGuildSettings storeUserGuildSettings) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        this.context = context;
        this.mediaEngineStore = storeMediaEngine;
        this.channelsStore = storeChannels;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.stageChannelsStore = storeStageChannels;
        this.storeUserGuildSettings = storeUserGuildSettings;
        subscribeToStoreEvents();
    }

    @MainThread
    private final void handleKrispStatusEvent(KrispOveruseDetector.Status krispStatusEvent) {
        int i;
        Channel channel;
        StageRoles stageRolesM15getMyRolesvisDeB4;
        if (krispStatusEvent == KrispOveruseDetector.Status.FAILED && (channel = this.channelsStore.getChannel(this.voiceChannelSelectedStore.getSelectedVoiceChannelId())) != null && ChannelUtils.D(channel) && (stageRolesM15getMyRolesvisDeB4 = this.stageChannelsStore.m15getMyRolesvisDeB4(channel.getId())) != null && StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
            return;
        }
        int iOrdinal = krispStatusEvent.ordinal();
        if (iOrdinal == 0) {
            i = R.string.mobile_noise_cancellation_cpu_overuse;
        } else if (iOrdinal == 1) {
            i = R.string.mobile_noise_cancellation_failed;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.mobile_advanced_voice_activity_cpu_overuse;
        }
        AppToast.g(this.context, i, 0, null, 12);
    }

    @MainThread
    private final void handleUserGuildSettingsEvent(StoreUserGuildSettings.Event userGuildSettingsEvent) {
        int i;
        if (!(userGuildSettingsEvent instanceof StoreUserGuildSettings.Event.SettingsUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((StoreUserGuildSettings.Event.SettingsUpdated) userGuildSettingsEvent).getType().ordinal();
        if (iOrdinal == 0) {
            i = R.string.server_settings_updated;
        } else if (iOrdinal == 1) {
            i = R.string.channel_settings_have_been_updated;
        } else if (iOrdinal == 2) {
            i = R.string.thread_settings_updated;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.category_settings_have_been_updated;
        }
        AppToast.g(this.context, i, 0, null, 12);
        KotlinExtensions.getExhaustive(Unit.a);
    }

    private final void subscribeToStoreEvents() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(this.mediaEngineStore.onKrispStatusEvent()), (Class<?>) StoreUIEventHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(this.storeUserGuildSettings.observeEvents()), (Class<?>) StoreUIEventHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
