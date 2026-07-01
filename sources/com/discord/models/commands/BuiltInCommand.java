package com.discord.models.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BuiltInCommand extends ApplicationCommand {
    public /* synthetic */ BuiltInCommand(String str, long j, String str2, Integer num, List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : num, list, (i & 32) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltInCommand(String str, long j, String str2, Integer num, List<ApplicationCommandOption> list, Function1<? super Map<String, ? extends Object>, String> function1) {
        super(str, j, str2, null, num, list, true, null, null, null, null, function1, 1928, null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(list, "options");
    }
}
