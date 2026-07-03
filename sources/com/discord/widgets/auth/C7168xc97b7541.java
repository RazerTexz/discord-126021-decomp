package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetAuthBirthday;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$1$$special$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7168xc97b7541 extends AbstractC12240o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAuthBirthday.C71671 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7168xc97b7541(WidgetAuthBirthday.C71671 c71671) {
        super(1);
        this.this$0 = c71671;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j) {
        WidgetAuthBirthday.this.setBirthday(j);
    }
}
