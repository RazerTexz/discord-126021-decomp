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
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.streams.StreamContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.FuncN;

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
        C12238m.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(storeVoiceStates, "voiceStateStore");
        C12238m.checkNotNullParameter(storeChannels, "channelStore");
        C12238m.checkNotNullParameter(storeApplicationStreamPreviews, "applicationStreamPreviewStore");
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
        C12721k c12721k = new C12721k(null);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(null)");
        return c12721k;
    }

    public final Observable<StreamContext> getForActiveStream() {
        Observable observableM11099Y = this.applicationStreamingStore.observeActiveStream().m11099Y(new InterfaceC12589b<StoreApplicationStreaming.ActiveApplicationStream, Observable<? extends StreamContext>>() { // from class: com.discord.utilities.streams.StreamContextService.getForActiveStream.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends StreamContext> call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                if (activeApplicationStream == null) {
                    return new C12721k(null);
                }
                return StreamContextService.this.getForUser(activeApplicationStream.getStream().getOwnerId(), false);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "applicationStreamingStor…  )\n          }\n        }");
        return observableM11099Y;
    }

    public final Observable<Map<Long, StreamContext>> getForAllStreamingUsers() {
        Observable<Map<Long, StreamContext>> observableM11099Y = this.applicationStreamingStore.observeStreamsByUser().m11083G(new InterfaceC12589b<Map<Long, ? extends ModelApplicationStream>, Collection<? extends ModelApplicationStream>>() { // from class: com.discord.utilities.streams.StreamContextService.getForAllStreamingUsers.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Collection<ModelApplicationStream> call(Map<Long, ? extends ModelApplicationStream> map) {
                return map.values();
            }
        }).m11099Y(new InterfaceC12589b<Collection<? extends ModelApplicationStream>, Observable<? extends Map<Long, ? extends StreamContext>>>() { // from class: com.discord.utilities.streams.StreamContextService.getForAllStreamingUsers.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Map<Long, StreamContext>> call(Collection<? extends ModelApplicationStream> collection) {
                if (collection.isEmpty()) {
                    return new C12721k(C12136h0.emptyMap());
                }
                C12238m.checkNotNullExpressionValue(collection, "allUserStreams");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collection, 10));
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(StreamContextService.this.getForUser(((ModelApplicationStream) it.next()).getOwnerId(), false));
                }
                return Observable.m11065b(arrayList, new FuncN<Map<Long, ? extends StreamContext>>() { // from class: com.discord.utilities.streams.StreamContextService.getForAllStreamingUsers.2.1
                    @Override // p658rx.functions.FuncN
                    public final Map<Long, ? extends StreamContext> call(Object[] objArr) {
                        C12238m.checkNotNullExpressionValue(objArr, "allUserStreamContexts");
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
                        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList2, 10)), 16));
                        for (T t : arrayList2) {
                            linkedHashMap.put(Long.valueOf(((StreamContext) t).getUser().getId()), t);
                        }
                        return linkedHashMap;
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "applicationStreamingStor…  }\n          }\n        }");
        return observableM11099Y;
    }

    public final Observable<StreamContext> getForUser(final long userId, final boolean includePreview) {
        Observable observableM11099Y = this.applicationStreamingStore.observeStreamsForUser(userId).m11099Y(new InterfaceC12589b<ModelApplicationStream, Observable<? extends StreamContext>>() { // from class: com.discord.utilities.streams.StreamContextService.getForUser.1

            /* JADX INFO: renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: StreamContextService.kt */
            public static final class AnonymousClass3 extends AbstractC12240o implements Function10<Guild, StoreApplicationStreamPreviews.StreamPreview, Long, User, MeUser, String, Map<Long, ? extends VoiceState>, Channel, Long, StoreApplicationStreaming.ActiveApplicationStream, StreamContext> {
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
                    C12238m.checkNotNullParameter(meUser, "me");
                    C12238m.checkNotNullParameter(map, "voiceStates");
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
                    return new StreamContext(this.$stream, guild, streamPreview, joinability, user, str, activeApplicationStream != null && activeApplicationStream.getState().isStreamActive() && C12238m.areEqual(activeApplicationStream.getStream(), this.$stream), user.getId() == meUser.getId());
                }
            }

            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends StreamContext> call(ModelApplicationStream modelApplicationStream) {
                long guildId;
                if (modelApplicationStream == null) {
                    return new C12721k(null);
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
                Observable<R> observableM11112r = StreamContextService.this.guildStore.observeComputed(guildId).m11083G(new InterfaceC12589b<Map<Long, ? extends GuildMember>, GuildMember>() { // from class: com.discord.utilities.streams.StreamContextService.getForUser.1.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                        return call2((Map<Long, GuildMember>) map);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final GuildMember call2(Map<Long, GuildMember> map) {
                        return map.get(Long.valueOf(userId));
                    }
                }).m11083G(new InterfaceC12589b<GuildMember, String>() { // from class: com.discord.utilities.streams.StreamContextService.getForUser.1.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final String call(GuildMember guildMember) {
                        if (guildMember != null) {
                            return guildMember.getNick();
                        }
                        return null;
                    }
                }).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "guildStore\n             …  .distinctUntilChanged()");
                return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveGuild, previewObservable, observableObservePermissionsForChannel, observableObserveUser, observableObserveMe$default, observableM11112r, StreamContextService.this.voiceStateStore.observe(guildId, modelApplicationStream.getChannelId()), StreamContextService.this.channelStore.observeChannel(modelApplicationStream.getChannelId()), StreamContextService.this.voiceChannelSelectedStore.observeSelectedVoiceChannelId(), StreamContextService.this.applicationStreamingStore.observeActiveStream(), new AnonymousClass3(modelApplicationStream));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "applicationStreamingStor…  }\n          }\n        }");
        return observableM11099Y;
    }

    public /* synthetic */ StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews);
    }
}
