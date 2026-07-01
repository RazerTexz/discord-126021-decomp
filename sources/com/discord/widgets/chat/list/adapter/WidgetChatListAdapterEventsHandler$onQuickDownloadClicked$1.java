package com.discord.widgets.chat.list.adapter;

import android.net.Uri;
import com.discord.utilities.io.NetworkUtils;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $fileName;
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ WeakReference $weakContext;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler, Uri uri, String str, WeakReference weakReference) {
        super(0);
        this.this$0 = widgetChatListAdapterEventsHandler;
        this.$uri = uri;
        this.$fileName = str;
        this.$weakContext = weakReference;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NetworkUtils.downloadFile(WidgetChatListAdapterEventsHandler.access$getContext$p(this.this$0), this.$uri, this.$fileName, null, new WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$1(this), new WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$2(this));
    }
}
