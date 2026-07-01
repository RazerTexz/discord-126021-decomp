package com.discord.models.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.models.commands.BuiltInCommand, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommand4 extends ApplicationCommand {
    public /* synthetic */ ApplicationCommand4(String str, long j, String str2, Integer num, List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : num, list, (i & 32) != 0 ? null : function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommand4(String str, long j, String str2, Integer num, List<ApplicationCommandOption> list, Function1<? super Map<String, ? extends Object>, String> function1) {
        super(str, j, str2, null, num, list, true, null, null, null, null, function1, 1928, null);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "options");
    }
}
