package com.discord.utilities.uri;

import android.content.Context;
import android.net.Uri;
import com.discord.app.AppTransitionActivity;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$openUrl$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $forceExternal;
    public final /* synthetic */ Function0 $onFailure;
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UriHandler$openUrl$1(Context context, Uri uri, String str, boolean z2, Function0 function0) {
        super(0);
        this.$context = context;
        this.$uri = uri;
        this.$url = str;
        this.$forceExternal = z2;
        this.$onFailure = function0;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppTransitionActivity.j = false;
        UriHandler.access$openUrlExternally(UriHandler.INSTANCE, this.$context, this.$uri, this.$url, this.$forceExternal, this.$onFailure);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }
}
