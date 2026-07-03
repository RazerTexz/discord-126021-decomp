package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.analytics.AnalyticsTracker;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$Companion$launch$3 extends AbstractC12240o implements Function1<Pair<? extends Experiment, ? extends List<? extends InviteSuggestion>>, Unit> {
    public final /* synthetic */ Intent $arguments;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare$Companion$launch$3(String str, Context context, Intent intent) {
        super(1);
        this.$source = str;
        this.$context = context;
        this.$arguments = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Experiment, ? extends List<? extends InviteSuggestion>> pair) {
        invoke2((Pair<Experiment, ? extends List<? extends InviteSuggestion>>) pair);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Experiment, ? extends List<? extends InviteSuggestion>> pair) {
        Class cls;
        Experiment experimentComponent1 = pair.component1();
        List<? extends InviteSuggestion> listComponent2 = pair.component2();
        AnalyticsTracker.openModal$default("Instant Invite Modal", this.$source, null, 4, null);
        if (listComponent2.isEmpty()) {
            cls = WidgetGuildInviteShareEmptySuggestions.class;
        } else {
            cls = (experimentComponent1 == null || experimentComponent1.getBucket() != 1) ? WidgetGuildInviteShare.class : WidgetGuildInviteShareCompact.class;
        }
        C0870j.m156d(this.$context, cls, this.$arguments);
    }
}
