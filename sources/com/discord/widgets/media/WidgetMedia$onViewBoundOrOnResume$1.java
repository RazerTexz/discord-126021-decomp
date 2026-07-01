package com.discord.widgets.media;

import android.content.Context;
import android.net.Uri;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBoundOrOnResume$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ Uri $downloadUri;
    public final /* synthetic */ Uri $sourceUri;
    public final /* synthetic */ String $title;
    public final /* synthetic */ String $titleSubtext;
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia$onViewBoundOrOnResume$1(WidgetMedia widgetMedia, Uri uri, Uri uri2, String str, String str2) {
        this.this$0 = widgetMedia;
        this.$sourceUri = uri;
        this.$downloadUri = uri2;
        this.$title = str;
        this.$titleSubtext = str2;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_media_browser /* 2131364395 */:
                m.checkNotNullExpressionValue(context, "context");
                String string = this.$sourceUri.toString();
                m.checkNotNullExpressionValue(string, "sourceUri.toString()");
                UriHandler.handleOrUntrusted$default(context, string, null, 4, null);
                break;
            case R$id.menu_media_download /* 2131364396 */:
                this.this$0.requestMediaDownload(new WidgetMedia$onViewBoundOrOnResume$1$1(this, context));
                break;
            case R$id.menu_media_share /* 2131364397 */:
                m.checkNotNullExpressionValue(context, "context");
                String string2 = this.$sourceUri.toString();
                m.checkNotNullExpressionValue(string2, "sourceUri.toString()");
                IntentUtils.performChooserSendIntent$default(context, string2, null, 4, null);
                break;
        }
    }
}
