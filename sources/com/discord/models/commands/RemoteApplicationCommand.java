package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandPermission;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RemoteApplicationCommand extends ApplicationCommand {
    public /* synthetic */ RemoteApplicationCommand(String str, long j, String str2, String str3, List list, Long l, String str4, Boolean bool, List list2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : str3, list, l, str4, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : function1);
    }

    public RemoteApplicationCommand(String str, long j, String str2, String str3, List<ApplicationCommandOption> list, Long l, String str4, Boolean bool, List<ApplicationCommandPermission> list2, Function1<? super Map<String, ? extends Object>, String> function1) {
        Map map;
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(list, "options");
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list2, 10));
            for (ApplicationCommandPermission applicationCommandPermission : list2) {
                arrayList.add(C12116o.m10073to(Long.valueOf(applicationCommandPermission.getId()), Boolean.valueOf(applicationCommandPermission.getPermission())));
            }
            map = C12136h0.toMap(arrayList);
        } else {
            map = null;
        }
        super(str, j, str2, str3, null, list, false, l, str4, bool, map, function1, 80, null);
    }
}
