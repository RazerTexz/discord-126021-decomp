package com.discord.widgets.auth;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung", f = "WidgetOauth2AuthorizeSamsung.kt", l = {Opcodes.RETURN, Opcodes.NEWARRAY, Opcodes.CHECKCAST}, m = "samsungCallbackHandshake")
public final class WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 extends d {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, Continuation continuation) {
        super(continuation);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.samsungCallbackHandshake(null, null, this);
    }
}
