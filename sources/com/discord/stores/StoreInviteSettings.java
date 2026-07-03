package com.discord.stores;

import android.os.Parcel;
import android.os.Parcelable;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings extends Store {
    public static final String LOCATION_DEEPLINK = "Deeplink";
    public static final String LOCATION_JOIN = "Join Guild Modal";
    private ModelInvite.Settings inviteSettings = new ModelInvite.Settings(86400);
    private final BehaviorSubject<InviteCode> pendingInviteCodeSubject = BehaviorSubject.m11130l0(null);
    private final BehaviorSubject<ModelInvite.Settings> inviteSettingsSubject = BehaviorSubject.m11130l0(this.inviteSettings);

    /* JADX INFO: compiled from: StoreInviteSettings.kt */
    public static final /* data */ class InviteCode implements Parcelable {
        public static final Parcelable.Creator<InviteCode> CREATOR = new Creator();
        private final Long eventId;
        private final String inviteCode;
        private final String source;

        public static class Creator implements Parcelable.Creator<InviteCode> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InviteCode createFromParcel(Parcel parcel) {
                C12238m.checkNotNullParameter(parcel, "in");
                return new InviteCode(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InviteCode[] newArray(int i) {
                return new InviteCode[i];
            }
        }

        public InviteCode(String str, String str2, Long l) {
            C12238m.checkNotNullParameter(str, "inviteCode");
            C12238m.checkNotNullParameter(str2, "source");
            this.inviteCode = str;
            this.source = str2;
            this.eventId = l;
        }

        public static /* synthetic */ InviteCode copy$default(InviteCode inviteCode, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inviteCode.inviteCode;
            }
            if ((i & 2) != 0) {
                str2 = inviteCode.source;
            }
            if ((i & 4) != 0) {
                l = inviteCode.eventId;
            }
            return inviteCode.copy(str, str2, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInviteCode() {
            return this.inviteCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getEventId() {
            return this.eventId;
        }

        public final InviteCode copy(String inviteCode, String source, Long eventId) {
            C12238m.checkNotNullParameter(inviteCode, "inviteCode");
            C12238m.checkNotNullParameter(source, "source");
            return new InviteCode(inviteCode, source, eventId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteCode)) {
                return false;
            }
            InviteCode inviteCode = (InviteCode) other;
            return C12238m.areEqual(this.inviteCode, inviteCode.inviteCode) && C12238m.areEqual(this.source, inviteCode.source) && C12238m.areEqual(this.eventId, inviteCode.eventId);
        }

        public final Long getEventId() {
            return this.eventId;
        }

        public final String getInviteCode() {
            return this.inviteCode;
        }

        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            String str = this.inviteCode;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.source;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.eventId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("InviteCode(inviteCode=");
            sbM833U.append(this.inviteCode);
            sbM833U.append(", source=");
            sbM833U.append(this.source);
            sbM833U.append(", eventId=");
            return C1643a.m819G(sbM833U, this.eventId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            C12238m.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.inviteCode);
            parcel.writeString(this.source);
            Long l = this.eventId;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
        }
    }

    public static /* synthetic */ Observable generateInvite$default(StoreInviteSettings storeInviteSettings, long j, ModelInvite.Settings settings, int i, Object obj) {
        if ((i & 2) != 0) {
            settings = storeInviteSettings.inviteSettings;
        }
        return storeInviteSettings.generateInvite(j, settings);
    }

    public static /* synthetic */ Experiment getInviteGuildExperiment$default(StoreInviteSettings storeInviteSettings, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeInviteSettings.getInviteGuildExperiment(j, z2);
    }

    public static /* synthetic */ void setInviteCode$default(StoreInviteSettings storeInviteSettings, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        storeInviteSettings.setInviteCode(str, str2, l);
    }

    public final void clearInviteCode() {
        this.pendingInviteCodeSubject.onNext(null);
    }

    public final Observable<ModelInvite> generateInvite(long j) {
        return generateInvite$default(this, j, null, 2, null);
    }

    public final synchronized Observable<ModelInvite> generateInvite(long channelId, ModelInvite.Settings settings) {
        C12238m.checkNotNullParameter(settings, "settings");
        return ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postChannelInvite(channelId, new RestAPIParams.Invite(settings.getMaxAge(), settings.getMaxUses(), settings.isTemporary(), null)), false, 1, null);
    }

    public final Observable<ModelInvite> generateInviteDefaultChannel(final long guildId) {
        Observable<ModelInvite> observableM11082A = getInvitableChannels(guildId).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, Collection<? extends Channel>>() { // from class: com.discord.stores.StoreInviteSettings.generateInviteDefaultChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Collection<? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Collection<Channel> call2(Map<Long, Channel> map) {
                return map.values();
            }
        }).m11083G(new InterfaceC12589b<Collection<? extends Channel>, List<? extends Channel>>() { // from class: com.discord.stores.StoreInviteSettings.generateInviteDefaultChannel.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends Channel> call(Collection<? extends Channel> collection) {
                return call2((Collection<Channel>) collection);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Channel> call2(Collection<Channel> collection) {
                C12238m.checkNotNullExpressionValue(collection, "it");
                return C12163u.sortedWith(collection, ChannelUtils.m7684h(Channel.INSTANCE));
            }
        }).m11083G(new InterfaceC12589b<List<? extends Channel>, Long>() { // from class: com.discord.stores.StoreInviteSettings.generateInviteDefaultChannel.3
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Long call(List<? extends Channel> list) {
                return call2((List<Channel>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(List<Channel> list) {
                C12238m.checkNotNullExpressionValue(list, "it");
                Channel channel = (Channel) C12163u.firstOrNull((List) list);
                if (channel != null) {
                    return Long.valueOf(channel.getId());
                }
                return null;
            }
        }).m11100Z(1).m11082A(new InterfaceC12589b<Long, Observable<? extends ModelInvite>>() { // from class: com.discord.stores.StoreInviteSettings.generateInviteDefaultChannel.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends ModelInvite> call(Long l) {
                if (l != null) {
                    long jLongValue = l.longValue();
                    StoreInviteSettings storeInviteSettings = StoreInviteSettings.this;
                    Observable<ModelInvite> observableGenerateInvite = storeInviteSettings.generateInvite(jLongValue, storeInviteSettings.getInviteSettings(guildId));
                    if (observableGenerateInvite != null) {
                        return observableGenerateInvite;
                    }
                }
                return new C12721k(null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "getInvitableChannels(gui…le.just(null)\n          }");
        return observableM11082A;
    }

    public final Observable<Map<Long, Channel>> getInvitableChannels(final long guildId) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, Channel>> observableM11076j = Observable.m11076j(companion.getChannels().observeGuildAndPrivateChannels(), companion.getPermissions().observeAllPermissions(), new Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Map<Long, ? extends Long>>, Map<Long, ? extends Channel>>() { // from class: com.discord.stores.StoreInviteSettings.getInvitableChannels.1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Map<Long, ? extends Long>> map2) {
                return call2((Map<Long, Channel>) map, (Map<Long, ? extends Map<Long, Long>>) map2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Channel> call2(Map<Long, Channel> map, Map<Long, ? extends Map<Long, Long>> map2) {
                HashMap map3 = new HashMap();
                Map<Long, Long> map4 = map2.get(Long.valueOf(guildId));
                if (map4 != null) {
                    for (Map.Entry<Long, Long> entry : map4.entrySet()) {
                        long jLongValue = entry.getKey().longValue();
                        long jLongValue2 = entry.getValue().longValue();
                        Channel channel = map.get(Long.valueOf(jLongValue));
                        if (channel != null) {
                            C12238m.checkNotNullParameter(channel, "$this$isInvitableChannel");
                            if ((ChannelUtils.m7698v(channel) || ChannelUtils.m7699w(channel)) && PermissionUtils.INSTANCE.hasAccess(channel, Long.valueOf(jLongValue2)) && PermissionUtils.can(1L, Long.valueOf(jLongValue2))) {
                                map3.put(Long.valueOf(jLongValue), channel);
                            }
                        }
                    }
                }
                return map3;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…  }\n          }\n        }");
        return observableM11076j;
    }

    public final Observable<ModelInvite> getInvite() {
        Observable<ModelInvite> observableM11083G = getInviteCode().m11082A(new InterfaceC12589b<InviteCode, Observable<? extends StoreInstantInvites.InviteState>>() { // from class: com.discord.stores.StoreInviteSettings.getInvite.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends StoreInstantInvites.InviteState> call(InviteCode inviteCode) {
                return inviteCode == null ? new C12721k(null) : StoreStream.INSTANCE.getInstantInvites().observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId()));
            }
        }).m11083G(new InterfaceC12589b<StoreInstantInvites.InviteState, ModelInvite>() { // from class: com.discord.stores.StoreInviteSettings.getInvite.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final ModelInvite call(StoreInstantInvites.InviteState inviteState) {
                if (inviteState instanceof StoreInstantInvites.InviteState.Resolved) {
                    return ((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite();
                }
                return null;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "getInviteCode()\n      .f…-> null\n        }\n      }");
        return observableM11083G;
    }

    public final Observable<InviteCode> getInviteCode() {
        Observable<InviteCode> observableM11112r = this.pendingInviteCodeSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "pendingInviteCodeSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Experiment getInviteGuildExperiment(long guildId, boolean trackExposure) {
        return StoreStream.INSTANCE.getExperiments().getGuildExperiment("2021-03_android_extend_invite_expiration", guildId, trackExposure);
    }

    public final Observable<ModelInvite.Settings> getInviteSettings() {
        BehaviorSubject<ModelInvite.Settings> behaviorSubject = this.inviteSettingsSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "inviteSettingsSubject");
        Observable<ModelInvite.Settings> observableM11112r = ObservableExtensionsKt.computationLatest(behaviorSubject).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "inviteSettingsSubject\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void handleGuildSelected(long guildId) {
        setInviteSettings(getInviteSettings(guildId));
    }

    public final void setInviteCode(String inviteCode, String source, Long eventId) {
        C12238m.checkNotNullParameter(inviteCode, "inviteCode");
        C12238m.checkNotNullParameter(source, "source");
        this.pendingInviteCodeSubject.onNext(new InviteCode(inviteCode, source, eventId));
    }

    public final synchronized void setInviteSettings(ModelInvite.Settings settings) {
        C12238m.checkNotNullParameter(settings, "settings");
        this.inviteSettings = settings;
        this.inviteSettingsSubject.onNext(settings);
    }

    public final void trackWithInvite$app_productionGoogleRelease(Class<?> clazz, Function1<? super ModelInvite, Unit> trackBlock) {
        C12238m.checkNotNullParameter(clazz, "clazz");
        C12238m.checkNotNullParameter(trackBlock, "trackBlock");
        Observable<ModelInvite> observableM11118y = getInvite().m11118y(new InterfaceC12589b<ModelInvite, Boolean>() { // from class: com.discord.stores.StoreInviteSettings$trackWithInvite$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(ModelInvite modelInvite) {
                return Boolean.valueOf(modelInvite != null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "getInvite()\n        .filter { it != null }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 250L, false, 2, null)), (Class<?>) clazz, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new StoreInviteSettings$trackWithInvite$2(trackBlock)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), trackBlock);
    }

    public final ModelInvite.Settings getInviteSettings(long guildId) {
        Experiment inviteGuildExperiment$default = getInviteGuildExperiment$default(this, guildId, false, 2, null);
        if (inviteGuildExperiment$default != null && inviteGuildExperiment$default.getBucket() == 1) {
            return new ModelInvite.Settings(ModelInvite.Settings.SEVEN_DAYS);
        }
        return new ModelInvite.Settings(86400);
    }
}
