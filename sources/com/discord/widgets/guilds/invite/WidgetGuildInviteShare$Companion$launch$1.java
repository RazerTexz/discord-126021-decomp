package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.experiments.domain.Experiment;
import d0.o;
import java.util.List;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$Companion$launch$1<T1, T2, R> implements Func2<Experiment, List<? extends InviteSuggestion>, Pair<? extends Experiment, ? extends List<? extends InviteSuggestion>>> {
    public static final WidgetGuildInviteShare$Companion$launch$1 INSTANCE = new WidgetGuildInviteShare$Companion$launch$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Experiment, ? extends List<? extends InviteSuggestion>> call(Experiment experiment, List<? extends InviteSuggestion> list) {
        return call2(experiment, list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Experiment, List<InviteSuggestion>> call2(Experiment experiment, List<? extends InviteSuggestion> list) {
        return o.to(experiment, list);
    }
}
