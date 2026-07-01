package com.discord.widgets.notice;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.intent.IntentUtils$RouteBuilders$Uris;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetNoticeNuxSamsungLink this$0;

    public WidgetNoticeNuxSamsungLink$onViewBound$2(WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink) {
        this.this$0 = widgetNoticeNuxSamsungLink;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink = this.this$0;
        Uri oauth2Authorize = IntentUtils$RouteBuilders$Uris.INSTANCE.getOauth2Authorize();
        m.checkNotNullParameter(oauth2Authorize, "oAuthUri");
        widgetNoticeNuxSamsungLink.startActivity(new Intent("android.intent.action.VIEW", oauth2Authorize.buildUpon().appendQueryParameter("client_id", "591317049637339146").appendQueryParameter("prompt", "consent").appendQueryParameter("response_type", ModelAuditLogEntry.CHANGE_KEY_CODE).appendQueryParameter("scope", "identify activities.read activities.write").build()));
        this.this$0.dismiss();
    }
}
