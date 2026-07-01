package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetAuthBirthday;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthBirthday$onViewBoundOrOnResume$1$$special$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday4 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAuthBirthday.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthBirthday4(WidgetAuthBirthday.AnonymousClass1 anonymousClass1) {
        super(1);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetAuthBirthday.this.setBirthday(j);
    }
}
