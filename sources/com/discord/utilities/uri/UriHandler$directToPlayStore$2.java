package com.discord.utilities.uri;

import android.content.Context;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$directToPlayStore$2 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ UriHandler$directToPlayStore$1 $createFullUriString$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UriHandler$directToPlayStore$2(Context context, UriHandler$directToPlayStore$1 uriHandler$directToPlayStore$1) {
        super(0);
        this.$context = context;
        this.$createFullUriString$1 = uriHandler$directToPlayStore$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        UriHandler.handle$default(UriHandler.INSTANCE, this.$context, this.$createFullUriString$1.invoke2("https://play.google.com/store/apps/details"), false, false, null, 28, null);
    }
}
