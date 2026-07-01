package com.discord.utilities.streams;

import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.FuncN;

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
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStateStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        Intrinsics3.checkNotNullParameter(storeApplicationStreamPreviews, "applicationStreamPreviewStore");
        this.applicationStreamingStore = storeApplicationStreaming;
        this.guildStore = storeGuilds;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.voiceStateStore = storeVoiceStates;
        this.channelStore = storeChannels;
        this.applicationStreamPreviewStore = storeApplicationStreamPreviews;
    }

    private final Observable<? extends StoreApplicationStreamPreviews.StreamPreview> getPreviewObservable(ModelApplicationStream stream, boolean includePreview, StoreApplicationStreamPreviews applicationStreamPreviewStore) {
        if (includePreview) {
            return applicationStreamPreviewStore.observeStreamPreview(stream);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
        return scalarSynchronousObservable;
    }

    public final Observable<StreamContext> getForActiveStream() {
        Observable observableY = this.applicationStreamingStore.observeActiveStream().Y(new Func1<StoreApplicationStreaming.ActiveApplicationStream, Observable<? extends StreamContext>>() { // from class: com.discord.utilities.streams.StreamContextService.getForActiveStream.1
            @Override // j0.k.Func1
            public final Observable<? extends StreamContext> call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                if (activeApplicationStream == null) {
                    return new ScalarSynchronousObservable(null);
                }
                return StreamContextService.this.getForUser(activeApplicationStream.getStream().getOwnerId(), false);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  )\n          }\n        }");
        return observableY;
    }

    public final Observable<Map<Long, StreamContext>> getForAllStreamingUsers() {
        Observable<Map<Long, StreamContext>> observableY = this.applicationStreamingStore.observeStreamsByUser().G(new Func1<Map<Long, ? extends ModelApplicationStream>, Collection<? extends ModelApplicationStream>>() { // from class: com.discord.utilities.streams.StreamContextService.getForAllStreamingUsers.1
            @Override // j0.k.Func1
            public final Collection<ModelApplicationStream> call(Map<Long, ? extends ModelApplicationStream> map) {
                return map.values();
            }
        }).Y(new Func1<Collection<? extends ModelApplicationStream>, Observable<? extends Map<Long, ? extends StreamContext>>>() { // from class: com.discord.utilities.streams.StreamContextService.getForAllStreamingUsers.2
            @Override // j0.k.Func1
            public final Observable<? extends Map<Long, StreamContext>> call(Collection<? extends ModelApplicationStream> collection) {
                if (collection.isEmpty()) {
                    return new ScalarSynchronousObservable(Maps6.emptyMap());
                }
                Intrinsics3.checkNotNullExpressionValue(collection, "allUserStreams");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(StreamContextService.this.getForUser(((ModelApplicationStream) it.next()).getOwnerId(), false));
                }
                return Observable.b(arrayList, new FuncN<Map<Long, ? extends StreamContext>>() { // from class: com.discord.utilities.streams.StreamContextService.getForAllStreamingUsers.2.1
                    @Override // rx.functions.FuncN
                    public final Map<Long, ? extends StreamContext> call(Object[] objArr) {
                        Intrinsics3.checkNotNullExpressionValue(objArr, "allUserStreamContexts");
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : objArr) {
                            if (!(obj instanceof StreamContext)) {
                                obj = null;
                            }
                            StreamContext streamContext = (StreamContext) obj;
                            if (streamContext != null) {
                                arrayList2.add(streamContext);
                            }
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList2, 10)), 16));
                        for (T t : arrayList2) {
                            linkedHashMap.put(Long.valueOf(((StreamContext) t).getUser().getId()), t);
                        }
                        return linkedHashMap;
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public final Observable<StreamContext> getForUser(final long userId, final boolean includePreview) {
        Observable observableY = this.applicationStreamingStore.observeStreamsForUser(userId).Y(new Func1<ModelApplicationStream, Observable<? extends StreamContext>>() { // from class: com.discord.utilities.streams.StreamContextService.getForUser.1

            /* JADX INFO: renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: StreamContextService.kt */
            public static final class AnonymousClass3 extends Lambda implements Function10<Guild, StoreApplicationStreamPreviews.StreamPreview, Long, User, MeUser, String, Map<Long, ? extends VoiceState>, Channel, Long, StoreApplicationStreaming.ActiveApplicationStream, StreamContext> {
                public final /* synthetic */ ModelApplicationStream $stream;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(ModelApplicationStream modelApplicationStream) {
                    super(10);
                    this.$stream = modelApplicationStream;
                }

                @Override // kotlin.jvm.functions.Function10
                public /* bridge */ /* synthetic */ StreamContext invoke(Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Long l, User user, MeUser meUser, String str, Map<Long, ? extends VoiceState> map, Channel channel, Long l2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                    return invoke(guild, streamPreview, l, user, meUser, str, (Map<Long, VoiceState>) map, channel, l2.longValue(), activeApplicationStream);
                }

                public final StreamContext invoke(Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Long l, User user, MeUser meUser, String str, Map<Long, VoiceState> map, Channel channel, long j, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                    StreamContext.Joinability joinability;
                    Intrinsics3.checkNotNullParameter(meUser, "me");
                    Intrinsics3.checkNotNullParameter(map, "voiceStates");
                    if (((this.$stream instanceof ModelApplicationStream.GuildStream) && guild == null) || user == null) {
                        return null;
                    }
                    int userLimit = channel != null ? channel.getUserLimit() : 0;
                    boolean z2 = userLimit > 0 && map.size() >= userLimit;
                    boolean z3 = channel != null && channel.getId() == j;
                    boolean zCan = PermissionUtils.can(Permission.CONNECT, l);
                    boolean zCan2 = PermissionUtils.can(16L, l);
                    if (!(this.$stream instanceof ModelApplicationStream.GuildStream) || zCan || z3) {
                        joinability = (!z2 || zCan2) ? StreamContext.Joinability.CAN_CONNECT : StreamContext.Joinability.VOICE_CHANNEL_FULL;
                    } else {
                        joinability = StreamContext.Joinability.MISSING_PERMISSIONS;
                    }
                    return new StreamContext(this.$stream, guild, streamPreview, joinability, user, str, activeApplicationStream != null && activeApplicationStream.getState().isStreamActive() && Intrinsics3.areEqual(activeApplicationStream.getStream(), this.$stream), user.getId() == meUser.getId());
                }
            }

            @Override // j0.k.Func1
            public final Observable<? extends StreamContext> call(ModelApplicationStream modelApplicationStream) {
                long guildId;
                if (modelApplicationStream == null) {
                    return new ScalarSynchronousObservable(null);
                }
                if (modelApplicationStream instanceof ModelApplicationStream.GuildStream) {
                    guildId = ((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId();
                } else {
                    if (!(modelApplicationStream instanceof ModelApplicationStream.CallStream)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    guildId = 0;
                }
                Observable<Guild> observableObserveGuild = StreamContextService.this.guildStore.observeGuild(guildId);
                StreamContextService streamContextService = StreamContextService.this;
                Observable previewObservable = streamContextService.getPreviewObservable(modelApplicationStream, includePreview, streamContextService.applicationStreamPreviewStore);
                Observable<Long> observableObservePermissionsForChannel = StreamContextService.this.permissionsStore.observePermissionsForChannel(modelApplicationStream.getChannelId());
                Observable<User> observableObserveUser = StreamContextService.this.userStore.observeUser(userId);
                Observable observableObserveMe$default = StoreUser.observeMe$default(StreamContextService.this.userStore, false, 1, null);
                Observable<R> observableR = StreamContextService.this.guildStore.observeComputed(guildId).G(new Func1<Map<Long, ? extends GuildMember>, GuildMember>() { // from class: com.discord.utilities.streams.StreamContextService.getForUser.1.1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                        return call2((Map<Long, GuildMember>) map);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final GuildMember call2(Map<Long, GuildMember> map) {
                        return map.get(Long.valueOf(userId));
                    }
                }).G(new Func1<GuildMember, String>() { // from class: com.discord.utilities.streams.StreamContextService.getForUser.1.2
                    @Override // j0.k.Func1
                    public final String call(GuildMember guildMember) {
                        if (guildMember != null) {
                            return guildMember.getNick();
                        }
                        return null;
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "guildStore\n             …  .distinctUntilChanged()");
                return ObservableCombineLatestOverloads2.combineLatest(observableObserveGuild, previewObservable, observableObservePermissionsForChannel, observableObserveUser, observableObserveMe$default, observableR, StreamContextService.this.voiceStateStore.observe(guildId, modelApplicationStream.getChannelId()), StreamContextService.this.channelStore.observeChannel(modelApplicationStream.getChannelId()), StreamContextService.this.voiceChannelSelectedStore.observeSelectedVoiceChannelId(), StreamContextService.this.applicationStreamingStore.observeActiveStream(), new AnonymousClass3(modelApplicationStream));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews);
    }
}
