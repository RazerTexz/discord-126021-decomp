package com.discord.widgets.share;

import android.net.Uri;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$5 extends o implements Function1<Uri, Unit> {
    public final /* synthetic */ WidgetIncomingShare$ContentModel $this_configureUi;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$configureUi$5(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel) {
        super(1);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi = widgetIncomingShare$ContentModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
        invoke2(uri);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Uri uri) {
        ArrayList arrayList;
        WidgetIncomingShare$ContentModel widgetIncomingShare$ContentModel = this.$this_configureUi;
        List<Uri> uris = widgetIncomingShare$ContentModel.getUris();
        if (uris != null) {
            arrayList = new ArrayList();
            for (Object obj : uris) {
                if (!m.areEqual((Uri) obj, uri)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        WidgetIncomingShare.access$getContentPublisher$p(this.this$0).onNext(WidgetIncomingShare$ContentModel.copy$default(widgetIncomingShare$ContentModel, null, arrayList, null, null, null, null, 61, null));
    }
}
