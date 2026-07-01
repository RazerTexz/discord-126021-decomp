package com.discord.utilities.images;

import android.content.Context;
import b.a.k.b;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MGImages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImages$requestImageCrop$1 extends o implements Function1<Exception, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGImages$requestImageCrop$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Exception exc) {
        m.checkNotNullParameter(exc, "e");
        Context context = this.$context;
        b.a.d.m.h(context, context != null ? b.h(context, 2131896561, new Object[]{exc.getMessage()}, null, 4) : null, 0, null, 12);
    }
}
