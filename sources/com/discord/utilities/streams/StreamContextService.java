package com.discord.utilities.streams;

import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import d0.z.d.m;
import j0.l.e.k;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService {
    private final StoreApplicationStreamPreviews applicationStreamPreviewStore;
    private final StoreApplicationStreaming applicationStreamingStore;
    private final StoreChannels channelStore;
    private final StoreGuilds guildStore;
    private final StorePermissions permissionsStore;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;
    private final StoreVoiceStates voiceStateStore;

    public StreamContextService() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        m.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        m.checkNotNullParameter(storeGuilds, "guildStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeVoiceStates, "voiceStateStore");
        m.checkNotNullParameter(storeChannels, "channelStore");
        m.checkNotNullParameter(storeApplicationStreamPreviews, "applicationStreamPreviewStore");
        this.applicationStreamingStore = storeApplicationStreaming;
        this.guildStore = storeGuilds;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.voiceStateStore = storeVoiceStates;
        this.channelStore = storeChannels;
        this.applicationStreamPreviewStore = storeApplicationStreamPreviews;
    }

    public static final /* synthetic */ StoreApplicationStreamPreviews access$getApplicationStreamPreviewStore$p(StreamContextService streamContextService) {
        return streamContextService.applicationStreamPreviewStore;
    }

    public static final /* synthetic */ StoreApplicationStreaming access$getApplicationStreamingStore$p(StreamContextService streamContextService) {
        return streamContextService.applicationStreamingStore;
    }

    public static final /* synthetic */ StoreChannels access$getChannelStore$p(StreamContextService streamContextService) {
        return streamContextService.channelStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildStore$p(StreamContextService streamContextService) {
        return streamContextService.guildStore;
    }

    public static final /* synthetic */ StorePermissions access$getPermissionsStore$p(StreamContextService streamContextService) {
        return streamContextService.permissionsStore;
    }

    public static final /* synthetic */ Observable access$getPreviewObservable(StreamContextService streamContextService, ModelApplicationStream modelApplicationStream, boolean z2, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return streamContextService.getPreviewObservable(modelApplicationStream, z2, storeApplicationStreamPreviews);
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StreamContextService streamContextService) {
        return streamContextService.userStore;
    }

    public static final /* synthetic */ StoreVoiceChannelSelected access$getVoiceChannelSelectedStore$p(StreamContextService streamContextService) {
        return streamContextService.voiceChannelSelectedStore;
    }

    public static final /* synthetic */ StoreVoiceStates access$getVoiceStateStore$p(StreamContextService streamContextService) {
        return streamContextService.voiceStateStore;
    }

    private final Observable<? extends StoreApplicationStreamPreviews$StreamPreview> getPreviewObservable(ModelApplicationStream stream, boolean includePreview, StoreApplicationStreamPreviews applicationStreamPreviewStore) {
        if (includePreview) {
            return applicationStreamPreviewStore.observeStreamPreview(stream);
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
        return kVar;
    }

    public final Observable<StreamContext> getForActiveStream() {
        Observable observableY = this.applicationStreamingStore.observeActiveStream().Y(new StreamContextService$getForActiveStream$1(this));
        m.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  )\n          }\n        }");
        return observableY;
    }

    public final Observable<Map<Long, StreamContext>> getForAllStreamingUsers() {
        Observable<Map<Long, StreamContext>> observableY = this.applicationStreamingStore.observeStreamsByUser().G(StreamContextService$getForAllStreamingUsers$1.INSTANCE).Y(new StreamContextService$getForAllStreamingUsers$2(this));
        m.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public final Observable<StreamContext> getForUser(long userId, boolean includePreview) {
        Observable observableY = this.applicationStreamingStore.observeStreamsForUser(userId).Y(new StreamContextService$getForUser$1(this, includePreview, userId));
        m.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 32) != 0 ? StoreStream.Companion.getVoiceStates() : storeVoiceStates, (i & 64) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.Companion.getApplicationStreamPreviews() : storeApplicationStreamPreviews);
    }
}
