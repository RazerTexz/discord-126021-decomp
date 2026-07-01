package com.discord.widgets.servers.auditlog;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewCreated$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter9 extends Lambda implements Function2<Long, Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter9(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        super(2);
        this.this$0 = widgetServerSettingsAuditLogFilter;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.a;
    }

    public final void invoke(long j, Long l) {
        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, l, null, null, null, 114, null);
    }
}
