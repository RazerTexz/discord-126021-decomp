package com.discord.widgets.channels.memberlist;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListService {
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
    public static final /* data */ class State {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final Channel channel;
        private final Map<Long, Presence> presences;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public State(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
            this.channel = channel;
            this.users = map;
            this.presences = map2;
            this.applicationStreams = map3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Channel channel, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = state.channel;
            }
            if ((i & 2) != 0) {
                map = state.users;
            }
            if ((i & 4) != 0) {
                map2 = state.presences;
            }
            if ((i & 8) != 0) {
                map3 = state.applicationStreams;
            }
            return state.copy(channel, map, map2, map3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final Map<Long, Presence> component3() {
            return this.presences;
        }

        public final Map<Long, ModelApplicationStream> component4() {
            return this.applicationStreams;
        }

        public final State copy(Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
            return new State(channel, users, presences, applicationStreams);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.channel, state.channel) && Intrinsics3.areEqual(this.users, state.users) && Intrinsics3.areEqual(this.presences, state.presences) && Intrinsics3.areEqual(this.applicationStreams, state.applicationStreams);
        }

        public final Map<Long, ModelApplicationStream> getApplicationStreams() {
            return this.applicationStreams;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
            return iHashCode3 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(channel=");
            sbU.append(this.channel);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", presences=");
            sbU.append(this.presences);
            sbU.append(", applicationStreams=");
            return outline.M(sbU, this.applicationStreams, ")");
        }
    }

    public PrivateChannelMemberListService() {
        this(null, null, null, 7, null);
    }

    public PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storePresences");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        this.storeUser = storeUser;
        this.storePresences = storeUserPresence;
        this.storeApplicationStreaming = storeApplicationStreaming;
    }

    public final Observable<State> observeStateForGroupDm(final Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable<State> observableY = Observable.I(this.storeUser.observeMeId().Z(1).c0(5000L, TimeUnit.MILLISECONDS), Observable.B(channel.z()).G(new Func1<com.discord.api.user.User, Long>() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService.observeStateForGroupDm.1
            @Override // j0.k.Func1
            public final Long call(com.discord.api.user.User user) {
                return Long.valueOf(user.getId());
            }
        })).f0().Y(new Func1<List<Long>, Observable<? extends State>>() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService.observeStateForGroupDm.2
            @Override // j0.k.Func1
            public final Observable<? extends State> call(List<Long> list) {
                StoreUser storeUser = PrivateChannelMemberListService.this.storeUser;
                Intrinsics3.checkNotNullExpressionValue(list, "ids");
                return Observable.i(storeUser.observeUsers(list), PrivateChannelMemberListService.this.storePresences.observePresencesForUsers(list), PrivateChannelMemberListService.this.storeApplicationStreaming.observeStreamsByUser(), new Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, State>() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService.observeStateForGroupDm.2.1
                    @Override // rx.functions.Func3
                    public /* bridge */ /* synthetic */ State call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                        return call2(map, (Map<Long, Presence>) map2, map3);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final State call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                        Channel channel2 = channel;
                        Intrinsics3.checkNotNullExpressionValue(map, "users");
                        Intrinsics3.checkNotNullExpressionValue(map2, "presences");
                        Intrinsics3.checkNotNullExpressionValue(map3, "applicationStreams");
                        return new State(channel2, map, map2, map3);
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.merge(\n      …            }\n          }");
        return observableY;
    }

    public /* synthetic */ PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming);
    }
}
