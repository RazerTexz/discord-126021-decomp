package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import b.a.d.j;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.GuildInfo;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Success;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$updateView$4 extends o implements Function1<Success<? extends EmailVerification>, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $email;
    public final /* synthetic */ HubEmailState $state;
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$updateView$4(WidgetHubEmailFlow widgetHubEmailFlow, HubEmailState hubEmailState, Context context, String str) {
        super(1);
        this.this$0 = widgetHubEmailFlow;
        this.$state = hubEmailState;
        this.$context = context;
        this.$email = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerification> success) {
        invoke2((Success<EmailVerification>) success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<EmailVerification> success) {
        m.checkNotNullParameter(success, "it");
        StoreStream.Companion.getDirectories().markDiscordHubClicked();
        if (!this.$state.getHasMultipleDomains()) {
            EmailVerification emailVerificationInvoke = this.$state.getVerifyEmailAsync().invoke();
            if (emailVerificationInvoke == null || emailVerificationInvoke.getHasMatchingGuild() || !GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled()) {
                return;
            }
            j.g.f(this.$context, WidgetHubEmailFlow.access$getActivityResultHandler$p(this.this$0), WidgetHubWaitlist.class, new HubWaitlistArgs(this.$email));
            WidgetHubEmailFlow.access$getViewModel$p(this.this$0).reset();
            return;
        }
        j jVar = j.g;
        Context context = this.$context;
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getActivityResultHandler$p = WidgetHubEmailFlow.access$getActivityResultHandler$p(this.this$0);
        String str = this.$email;
        List<GuildInfo> listA = success.invoke().a();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(DomainGuildInfo.Companion.from((GuildInfo) it.next()));
        }
        jVar.f(context, activityResultLauncherAccess$getActivityResultHandler$p, WidgetHubDomains.class, new HubDomainArgs(str, arrayList));
        WidgetHubEmailFlow.access$getViewModel$p(this.this$0).reset();
    }
}
