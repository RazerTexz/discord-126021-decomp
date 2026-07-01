package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandPermission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.models.commands.RemoteApplicationCommand, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommand5 extends ApplicationCommand {
    public /* synthetic */ ApplicationCommand5(String str, long j, String str2, String str3, List list, Long l, String str4, Boolean bool, List list2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : str3, list, l, str4, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : function1);
    }

    public ApplicationCommand5(String str, long j, String str2, String str3, List<ApplicationCommandOption> list, Long l, String str4, Boolean bool, List<ApplicationCommandPermission> list2, Function1<? super Map<String, ? extends Object>, String> function1) {
        Map map;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "options");
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
            for (ApplicationCommandPermission applicationCommandPermission : list2) {
                arrayList.add(Tuples.to(Long.valueOf(applicationCommandPermission.getId()), Boolean.valueOf(applicationCommandPermission.getPermission())));
            }
            map = Maps6.toMap(arrayList);
        } else {
            map = null;
        }
        super(str, j, str2, str3, null, list, false, l, str4, bool, map, function1, 80, null);
    }
}
