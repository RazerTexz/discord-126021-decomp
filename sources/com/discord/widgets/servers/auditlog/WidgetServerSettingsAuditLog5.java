package com.discord.widgets.servers.auditlog;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog5 extends Lambda implements Function2<Long, Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLog5(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        super(2);
        this.this$0 = widgetServerSettingsAuditLog;
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
