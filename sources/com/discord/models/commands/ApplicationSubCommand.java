package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandPermission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationSubCommand extends ApplicationCommand {
    private final String parentGroupName;
    private final ApplicationCommand rootCommand;
    private final String subCommandName;

    public /* synthetic */ ApplicationSubCommand(ApplicationCommand applicationCommand, String str, String str2, long j, String str3, String str4, Integer num, List list, Long l, Boolean bool, List list2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommand, str, (i & 4) != 0 ? null : str2, j, str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num, list, l, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : list2, str5);
    }

    public final String getParentGroupName() {
        return this.parentGroupName;
    }

    public final ApplicationCommand getRootCommand() {
        return this.rootCommand;
    }

    public final String getSubCommandName() {
        return this.subCommandName;
    }

    public ApplicationSubCommand(ApplicationCommand applicationCommand, String str, String str2, long j, String str3, String str4, Integer num, List<ApplicationCommandOption> list, Long l, Boolean bool, List<ApplicationCommandPermission> list2, String str5) {
        Map map;
        m.checkNotNullParameter(applicationCommand, "rootCommand");
        m.checkNotNullParameter(str, "subCommandName");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(list, "options");
        String str6 = str2 != null ? applicationCommand.getId() + ' ' + str2 + ' ' + str : applicationCommand.getId() + ' ' + str;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list2, 10));
            for (ApplicationCommandPermission applicationCommandPermission : list2) {
                arrayList.add(d0.o.to(Long.valueOf(applicationCommandPermission.getId()), Boolean.valueOf(applicationCommandPermission.getPermission())));
            }
            map = h0.toMap(arrayList);
        } else {
            map = null;
        }
        super(str6, j, str3, str4, num, list, false, l, str5, bool, map, null, 2112, null);
        this.rootCommand = applicationCommand;
        this.subCommandName = str;
        this.parentGroupName = str2;
    }
}
