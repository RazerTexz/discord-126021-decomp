package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelUrl;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$authorizeConnection$1 extends o implements Function1<ModelUrl, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$authorizeConnection$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUrl modelUrl) {
        invoke2(modelUrl);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUrl modelUrl) {
        m.checkNotNullParameter(modelUrl, "response");
        UriHandler.handle$default(UriHandler.INSTANCE, this.$context, modelUrl.getUrl(), false, false, null, 28, null);
    }
}
