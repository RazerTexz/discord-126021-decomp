package com.discord.widgets.share;

import android.content.Intent;
import android.net.Uri;
import com.discord.api.activity.Activity;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model$JsonReader;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.ShareUtils$SharedContent;
import com.discord.utilities.intent.IntentUtils;
import d0.z.d.m;
import java.io.StringReader;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$ContentModel$Companion {
    private WidgetIncomingShare$ContentModel$Companion() {
    }

    public final WidgetIncomingShare$ContentModel get(Intent recentIntent) {
        m.checkNotNullParameter(recentIntent, "recentIntent");
        ShareUtils$SharedContent sharedContent = ShareUtils.INSTANCE.getSharedContent(recentIntent, false);
        Long directShareId = IntentUtils.INSTANCE.getDirectShareId(recentIntent);
        String stringExtra = recentIntent.getStringExtra("EXTRA_RECIPIENT");
        String action = recentIntent.getAction();
        Uri data = (action != null && action.hashCode() == -1103390587 && action.equals("com.discord.intent.action.SDK")) ? recentIntent.getData() : null;
        String stringExtra2 = recentIntent.getStringExtra("com.discord.intent.extra.EXTRA_ACTIVITY");
        return new WidgetIncomingShare$ContentModel(sharedContent.getText(), sharedContent.getUris(), directShareId, stringExtra, data, stringExtra2 != null ? (Activity) InboundGatewayGsonParser.fromJson(new Model$JsonReader(new StringReader(stringExtra2)), Activity.class) : null);
    }

    public /* synthetic */ WidgetIncomingShare$ContentModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
