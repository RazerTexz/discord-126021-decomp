package com.discord.utilities.fcm;

import android.content.Context;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationData$getCallAction$coloredString$1 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $colorRes;
    public final /* synthetic */ Context $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationData$getCallAction$coloredString$1(Context context, int i) {
        super(1);
        this.$ctx = context;
        this.$colorRes = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(this.$ctx, this.$colorRes));
    }
}
