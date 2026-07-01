package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.member.GuildMember;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.o;
import d0.t.g0;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import rx.functions.Func4;

/* JADX INFO: compiled from: ApplicationCommandsAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource$observeApplicationCommandAutocompletables$1<T1, T2, T3, T4, R> implements Func4<Long, Map<Long, ? extends GuildMember>, List<? extends Application>, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
    public final /* synthetic */ ApplicationCommandsAutocompletableSource this$0;

    public ApplicationCommandsAutocompletableSource$observeApplicationCommandAutocompletables$1(ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource) {
        this.this$0 = applicationCommandsAutocompletableSource;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Map<Long, ? extends GuildMember> map, List<? extends Application> list, List<? extends ApplicationCommand> list2) {
        return call2(l, (Map<Long, GuildMember>) map, (List<Application>) list, list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Map<Long, GuildMember> map, List<Application> list, List<? extends ApplicationCommand> list2) {
        m.checkNotNullExpressionValue(list2, "queries");
        if (!(!list2.isEmpty())) {
            return g0.mapOf(o.to(LeadingIdentifier.APP_COMMAND, new TreeSet()));
        }
        ApplicationCommandsAutocompletableSource applicationCommandsAutocompletableSource = this.this$0;
        m.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        GuildMember guildMember = map.get(l);
        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
        if (roles == null) {
            roles = n.emptyList();
        }
        m.checkNotNullExpressionValue(list, "apps");
        return ApplicationCommandsAutocompletableSource.access$createAutocompletablesForApplicationCommands(applicationCommandsAutocompletableSource, jLongValue, roles, list, list2);
    }
}
