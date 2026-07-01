package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListService {
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUser;

    public PrivateChannelMemberListService() {
        this(null, null, null, 7, null);
    }

    public PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeUserPresence, "storePresences");
        m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        this.storeUser = storeUser;
        this.storePresences = storeUserPresence;
        this.storeApplicationStreaming = storeApplicationStreaming;
    }

    public static final /* synthetic */ StoreApplicationStreaming access$getStoreApplicationStreaming$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storeApplicationStreaming;
    }

    public static final /* synthetic */ StoreUserPresence access$getStorePresences$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storePresences;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storeUser;
    }

    public final Observable<PrivateChannelMemberListService$State> observeStateForGroupDm(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Observable<PrivateChannelMemberListService$State> observableY = Observable.I(this.storeUser.observeMeId().Z(1).c0(5000L, TimeUnit.MILLISECONDS), Observable.B(channel.z()).G(PrivateChannelMemberListService$observeStateForGroupDm$1.INSTANCE)).f0().Y(new PrivateChannelMemberListService$observeStateForGroupDm$2(this, channel));
        m.checkNotNullExpressionValue(observableY, "Observable.merge(\n      …            }\n          }");
        return observableY;
    }

    public /* synthetic */ PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 2) != 0 ? StoreStream.Companion.getPresences() : storeUserPresence, (i & 4) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming);
    }
}
