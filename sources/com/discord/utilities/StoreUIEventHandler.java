package com.discord.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$1 */
    /* JADX INFO: compiled from: StoreUIEventHandler.kt */
    public static final class C66621 extends AbstractC12240o implements Function1<KrispOveruseDetector.Status, Unit> {
        public C66621() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KrispOveruseDetector.Status status) {
            invoke2(status);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KrispOveruseDetector.Status status) {
            C12238m.checkNotNullParameter(status, "it");
            StoreUIEventHandler.this.handleKrispStatusEvent(status);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$2 */
    /* JADX INFO: compiled from: StoreUIEventHandler.kt */
    public static final class C66632 extends AbstractC12240o implements Function1<StoreUserGuildSettings.Event, Unit> {
        public C66632() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserGuildSettings.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserGuildSettings.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            StoreUIEventHandler.this.handleUserGuildSettingsEvent(event);
        }
    }

    public StoreUIEventHandler(Context context, StoreMediaEngine storeMediaEngine, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageChannels storeStageChannels, StoreUserGuildSettings storeUserGuildSettings) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        C12238m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
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
        StageRoles stageRolesM11392getMyRolesvisDeB4;
        if (krispStatusEvent == KrispOveruseDetector.Status.FAILED && (channel = this.channelsStore.getChannel(this.voiceChannelSelectedStore.getSelectedVoiceChannelId())) != null && ChannelUtils.m7669D(channel) && (stageRolesM11392getMyRolesvisDeB4 = this.stageChannelsStore.m11392getMyRolesvisDeB4(channel.getId())) != null && StageRoles.m11407isAudienceimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl())) {
            return;
        }
        int iOrdinal = krispStatusEvent.ordinal();
        if (iOrdinal == 0) {
            i = C5419R.string.mobile_noise_cancellation_cpu_overuse;
        } else if (iOrdinal == 1) {
            i = C5419R.string.mobile_noise_cancellation_failed;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.string.mobile_advanced_voice_activity_cpu_overuse;
        }
        C0876m.m169g(this.context, i, 0, null, 12);
    }

    @MainThread
    private final void handleUserGuildSettingsEvent(StoreUserGuildSettings.Event userGuildSettingsEvent) {
        int i;
        if (!(userGuildSettingsEvent instanceof StoreUserGuildSettings.Event.SettingsUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((StoreUserGuildSettings.Event.SettingsUpdated) userGuildSettingsEvent).getType().ordinal();
        if (iOrdinal == 0) {
            i = C5419R.string.server_settings_updated;
        } else if (iOrdinal == 1) {
            i = C5419R.string.channel_settings_have_been_updated;
        } else if (iOrdinal == 2) {
            i = C5419R.string.thread_settings_updated;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.string.category_settings_have_been_updated;
        }
        C0876m.m169g(this.context, i, 0, null, 12);
        KotlinExtensionsKt.getExhaustive(Unit.f27425a);
    }

    private final void subscribeToStoreEvents() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(this.mediaEngineStore.onKrispStatusEvent()), (Class<?>) StoreUIEventHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66621());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(this.storeUserGuildSettings.observeEvents()), (Class<?>) StoreUIEventHandler.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66632());
    }
}
