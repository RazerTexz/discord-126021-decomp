package com.discord.widgets.stage.start;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageViewModel$Companion {
    private ModeratorStartStageViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(ModeratorStartStageViewModel$Companion moderatorStartStageViewModel$Companion, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants) {
        return moderatorStartStageViewModel$Companion.observeStores(j, storeChannels, storeGuildScheduledEvents, storePermissions, storeVoiceParticipants);
    }

    private final Observable<ModeratorStartStageViewModel$StoreState> observeStores(long channelId, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, StoreVoiceParticipants voiceParticipantsStore) {
        Observable<R> observableG = channelStore.observeChannel(channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<ModeratorStartStageViewModel$StoreState> observableY = observableG.Y(new ModeratorStartStageViewModel$Companion$observeStores$1(voiceParticipantsStore, guildScheduledEventsStore, permissionsStore, channelId));
        m.checkNotNullExpressionValue(observableY, "channelStore.observeChan…  )\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ ModeratorStartStageViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
