package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetAgeVerify;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify3 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAgeVerify.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify3(WidgetAgeVerify.AnonymousClass1 anonymousClass1) {
        super(1);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetAgeVerify.this.getViewModel().setDateOfBirth(j);
    }
}
