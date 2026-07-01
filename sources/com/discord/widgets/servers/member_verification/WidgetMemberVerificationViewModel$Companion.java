package com.discord.widgets.servers.member_verification;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel$Companion {
    private WidgetMemberVerificationViewModel$Companion() {
    }

    public final Observable<WidgetMemberVerificationViewModel$StoreState> observeStores(long guildId, Guild inviteGuild) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetMemberVerificationViewModel$StoreState> observableF = Observable.f(storeStream$Companion.getUsers().observeMe(true), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), storeStream$Companion.getChannels().observeNames(), storeStream$Companion.getGuilds().observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), new WidgetMemberVerificationViewModel$Companion$observeStores$1(inviteGuild));
        m.checkNotNullExpressionValue(observableF, "Observable\n            .…          )\n            }");
        return observableF;
    }

    public /* synthetic */ WidgetMemberVerificationViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
