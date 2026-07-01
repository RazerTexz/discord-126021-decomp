package com.discord.widgets.media;

import android.content.Context;
import android.net.Uri;
import com.discord.utilities.io.NetworkUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBoundOrOnResume$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetMedia$onViewBoundOrOnResume$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia$onViewBoundOrOnResume$1$1(WidgetMedia$onViewBoundOrOnResume$1 widgetMedia$onViewBoundOrOnResume$1, Context context) {
        super(0);
        this.this$0 = widgetMedia$onViewBoundOrOnResume$1;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context context = this.$context;
        Uri uri = this.this$0.$downloadUri;
        m.checkNotNullExpressionValue(uri, "downloadUri");
        WidgetMedia$onViewBoundOrOnResume$1 widgetMedia$onViewBoundOrOnResume$1 = this.this$0;
        NetworkUtils.downloadFile(context, uri, widgetMedia$onViewBoundOrOnResume$1.$title, widgetMedia$onViewBoundOrOnResume$1.$titleSubtext, new WidgetMedia$onViewBoundOrOnResume$1$1$1(this), new WidgetMedia$onViewBoundOrOnResume$1$1$2(this));
    }
}
