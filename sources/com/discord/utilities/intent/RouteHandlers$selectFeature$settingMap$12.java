package com.discord.utilities.intent;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.channel.ChannelSelector;
import d0.g0.s;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$12 extends o implements Function1<FragmentActivity, Unit> {
    public final /* synthetic */ Uri $uri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteHandlers$selectFeature$settingMap$12(Uri uri) {
        super(1);
        this.$uri = uri;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
        invoke2(fragmentActivity);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "ctx");
        String queryParameter = this.$uri.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
        Long longOrNull = queryParameter != null ? s.toLongOrNull(queryParameter) : null;
        if (longOrNull != null) {
            ChannelSelector channelSelector$Companion = ChannelSelector.Companion.getInstance();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
            channelSelector$Companion.previewVoiceChannel(supportFragmentManager, longOrNull.longValue());
        }
    }
}
