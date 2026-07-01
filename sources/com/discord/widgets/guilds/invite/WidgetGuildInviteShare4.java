package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.AppScreen2;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare4 extends Lambda implements Function1<Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>>, Unit> {
    public final /* synthetic */ Intent $arguments;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare4(String str, Context context, Intent intent) {
        super(1);
        this.$source = str;
        this.$context = context;
        this.$arguments = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Experiment, ? extends List<? extends InviteSuggestion>> tuples2) {
        invoke2((Tuples2<Experiment, ? extends List<? extends InviteSuggestion>>) tuples2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples2<Experiment, ? extends List<? extends InviteSuggestion>> tuples2) {
        Class cls;
        Experiment experimentComponent1 = tuples2.component1();
        List<? extends InviteSuggestion> listComponent2 = tuples2.component2();
        AnalyticsTracker.openModal$default("Instant Invite Modal", this.$source, null, 4, null);
        if (listComponent2.isEmpty()) {
            cls = WidgetGuildInviteShareEmptySuggestions.class;
        } else {
            cls = (experimentComponent1 == null || experimentComponent1.getBucket() != 1) ? WidgetGuildInviteShare.class : WidgetGuildInviteShareCompact.class;
        }
        AppScreen2.d(this.$context, cls, this.$arguments);
    }
}
