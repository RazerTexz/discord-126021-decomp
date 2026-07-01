package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.restapi.RestAPIParams$Invite;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings extends Store {
    public static final StoreInviteSettings$Companion Companion = new StoreInviteSettings$Companion(null);
    public static final String LOCATION_DEEPLINK = "Deeplink";
    public static final String LOCATION_JOIN = "Join Guild Modal";
    private ModelInvite$Settings inviteSettings = new ModelInvite$Settings(86400);
    private final BehaviorSubject<StoreInviteSettings$InviteCode> pendingInviteCodeSubject = BehaviorSubject.l0(null);
    private final BehaviorSubject<ModelInvite$Settings> inviteSettingsSubject = BehaviorSubject.l0(this.inviteSettings);

    public static /* synthetic */ Observable generateInvite$default(StoreInviteSettings storeInviteSettings, long j, ModelInvite$Settings modelInvite$Settings, int i, Object obj) {
        if ((i & 2) != 0) {
            modelInvite$Settings = storeInviteSettings.inviteSettings;
        }
        return storeInviteSettings.generateInvite(j, modelInvite$Settings);
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

    public final synchronized Observable<ModelInvite> generateInvite(long channelId, ModelInvite$Settings settings) {
        m.checkNotNullParameter(settings, "settings");
        return ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().postChannelInvite(channelId, new RestAPIParams$Invite(settings.getMaxAge(), settings.getMaxUses(), settings.isTemporary(), null)), false, 1, null);
    }

    public final Observable<ModelInvite> generateInviteDefaultChannel(long guildId) {
        Observable<ModelInvite> observableA = getInvitableChannels(guildId).G(StoreInviteSettings$generateInviteDefaultChannel$1.INSTANCE).G(StoreInviteSettings$generateInviteDefaultChannel$2.INSTANCE).G(StoreInviteSettings$generateInviteDefaultChannel$3.INSTANCE).Z(1).A(new StoreInviteSettings$generateInviteDefaultChannel$4(this, guildId));
        m.checkNotNullExpressionValue(observableA, "getInvitableChannels(gui…le.just(null)\n          }");
        return observableA;
    }

    public final Observable<Map<Long, Channel>> getInvitableChannels(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Map<Long, Channel>> observableJ = Observable.j(storeStream$Companion.getChannels().observeGuildAndPrivateChannels(), storeStream$Companion.getPermissions().observeAllPermissions(), new StoreInviteSettings$getInvitableChannels$1(guildId));
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…  }\n          }\n        }");
        return observableJ;
    }

    public final Observable<ModelInvite> getInvite() {
        Observable<ModelInvite> observableG = getInviteCode().A(StoreInviteSettings$getInvite$1.INSTANCE).G(StoreInviteSettings$getInvite$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "getInviteCode()\n      .f…-> null\n        }\n      }");
        return observableG;
    }

    public final Observable<StoreInviteSettings$InviteCode> getInviteCode() {
        Observable<StoreInviteSettings$InviteCode> observableR = this.pendingInviteCodeSubject.r();
        m.checkNotNullExpressionValue(observableR, "pendingInviteCodeSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Experiment getInviteGuildExperiment(long guildId, boolean trackExposure) {
        return StoreStream.Companion.getExperiments().getGuildExperiment("2021-03_android_extend_invite_expiration", guildId, trackExposure);
    }

    public final Observable<ModelInvite$Settings> getInviteSettings() {
        BehaviorSubject<ModelInvite$Settings> behaviorSubject = this.inviteSettingsSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "inviteSettingsSubject");
        Observable<ModelInvite$Settings> observableR = ObservableExtensionsKt.computationLatest(behaviorSubject).r();
        m.checkNotNullExpressionValue(observableR, "inviteSettingsSubject\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final void handleGuildSelected(long guildId) {
        setInviteSettings(getInviteSettings(guildId));
    }

    public final void setInviteCode(String inviteCode, String source, Long eventId) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        m.checkNotNullParameter(source, "source");
        this.pendingInviteCodeSubject.onNext(new StoreInviteSettings$InviteCode(inviteCode, source, eventId));
    }

    public final synchronized void setInviteSettings(ModelInvite$Settings settings) {
        m.checkNotNullParameter(settings, "settings");
        this.inviteSettings = settings;
        this.inviteSettingsSubject.onNext(settings);
    }

    public final void trackWithInvite$app_productionGoogleRelease(Class<?> clazz, Function1<? super ModelInvite, Unit> trackBlock) {
        m.checkNotNullParameter(clazz, "clazz");
        m.checkNotNullParameter(trackBlock, "trackBlock");
        Observable<ModelInvite> observableY = getInvite().y(StoreInviteSettings$trackWithInvite$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "getInvite()\n        .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 250L, false, 2, null)), clazz, (Context) null, (Function1) null, new StoreInviteSettings$trackWithInvite$2(trackBlock), (Function0) null, (Function0) null, trackBlock, 54, (Object) null);
    }

    public final ModelInvite$Settings getInviteSettings(long guildId) {
        Experiment inviteGuildExperiment$default = getInviteGuildExperiment$default(this, guildId, false, 2, null);
        if (inviteGuildExperiment$default != null && inviteGuildExperiment$default.getBucket() == 1) {
            return new ModelInvite$Settings(ModelInvite$Settings.SEVEN_DAYS);
        }
        return new ModelInvite$Settings(86400);
    }
}
