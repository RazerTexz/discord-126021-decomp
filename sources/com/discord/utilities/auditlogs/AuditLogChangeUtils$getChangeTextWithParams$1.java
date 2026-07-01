package com.discord.utilities.auditlogs;

import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry$Change;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuditLogChangeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuditLogChangeUtils$getChangeTextWithParams$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ ModelAuditLogEntry$Change $change;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuditLogChangeUtils$getChangeTextWithParams$1(ModelAuditLogEntry$Change modelAuditLogEntry$Change) {
        super(1);
        this.$change = modelAuditLogEntry$Change;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        String string;
        String string2;
        m.checkNotNullParameter(renderContext, "$receiver");
        Map<String, String> map = renderContext.args;
        Object oldValue = this.$change.getOldValue();
        String str = "";
        if (oldValue == null || (string = oldValue.toString()) == null) {
            string = "";
        }
        map.put("oldValue", string);
        Map<String, String> map2 = renderContext.args;
        Object newValue = this.$change.getNewValue();
        if (newValue != null && (string2 = newValue.toString()) != null) {
            str = string2;
        }
        map2.put("newValue", str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
