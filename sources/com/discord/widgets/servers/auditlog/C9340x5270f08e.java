package com.discord.widgets.servers.auditlog;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewCreated$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9340x5270f08e extends AbstractC12240o implements Function2<Long, Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9340x5270f08e(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        super(2);
        this.this$0 = widgetServerSettingsAuditLogFilter;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.f27425a;
    }

    public final void invoke(long j, Long l) {
        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, l, null, null, null, 114, null);
    }
}
