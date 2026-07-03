package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.functions.Func3;

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
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(map, "users");
            C12238m.checkNotNullParameter(map2, "presences");
            C12238m.checkNotNullParameter(map3, "applicationStreams");
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
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(users, "users");
            C12238m.checkNotNullParameter(presences, "presences");
            C12238m.checkNotNullParameter(applicationStreams, "applicationStreams");
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
            return C12238m.areEqual(this.channel, state.channel) && C12238m.areEqual(this.users, state.users) && C12238m.areEqual(this.presences, state.presences) && C12238m.areEqual(this.applicationStreams, state.applicationStreams);
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
            StringBuilder sbM833U = C1643a.m833U("State(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", presences=");
            sbM833U.append(this.presences);
            sbM833U.append(", applicationStreams=");
            return C1643a.m825M(sbM833U, this.applicationStreams, ")");
        }
    }

    public PrivateChannelMemberListService() {
        this(null, null, null, 7, null);
    }

    public PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming) {
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeUserPresence, "storePresences");
        C12238m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        this.storeUser = storeUser;
        this.storePresences = storeUserPresence;
        this.storeApplicationStreaming = storeApplicationStreaming;
    }

    public final Observable<State> observeStateForGroupDm(final Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        Observable<State> observableM11099Y = Observable.m11064I(this.storeUser.observeMeId().m11100Z(1).m11104c0(5000L, TimeUnit.MILLISECONDS), Observable.m11058B(channel.m7659z()).m11083G(new InterfaceC12589b<com.discord.api.user.User, Long>() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService.observeStateForGroupDm.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Long call(com.discord.api.user.User user) {
                return Long.valueOf(user.getId());
            }
        })).m11105f0().m11099Y(new InterfaceC12589b<List<Long>, Observable<? extends State>>() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService.observeStateForGroupDm.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends State> call(List<Long> list) {
                StoreUser storeUser = PrivateChannelMemberListService.this.storeUser;
                C12238m.checkNotNullExpressionValue(list, "ids");
                return Observable.m11075i(storeUser.observeUsers(list), PrivateChannelMemberListService.this.storePresences.observePresencesForUsers(list), PrivateChannelMemberListService.this.storeApplicationStreaming.observeStreamsByUser(), new Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, State>() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService.observeStateForGroupDm.2.1
                    @Override // p658rx.functions.Func3
                    public /* bridge */ /* synthetic */ State call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                        return call2(map, (Map<Long, Presence>) map2, map3);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final State call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                        Channel channel2 = channel;
                        C12238m.checkNotNullExpressionValue(map, "users");
                        C12238m.checkNotNullExpressionValue(map2, "presences");
                        C12238m.checkNotNullExpressionValue(map3, "applicationStreams");
                        return new State(channel2, map, map2, map3);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable.merge(\n      …            }\n          }");
        return observableM11099Y;
    }

    public /* synthetic */ PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming);
    }
}
