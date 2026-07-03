package com.discord.utilities.intent;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.channel.ChannelSelector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p579g0.C12102s;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$12 extends AbstractC12240o implements Function1<FragmentActivity, Unit> {
    public final /* synthetic */ Uri $uri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteHandlers$selectFeature$settingMap$12(Uri uri) {
        super(1);
        this.$uri = uri;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
        invoke2(fragmentActivity);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "ctx");
        String queryParameter = this.$uri.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
        Long longOrNull = queryParameter != null ? C12102s.toLongOrNull(queryParameter) : null;
        if (longOrNull != null) {
            ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            C12238m.checkNotNullExpressionValue(supportFragmentManager, "ctx.supportFragmentManager");
            companion.previewVoiceChannel(supportFragmentManager, longOrNull.longValue());
        }
    }
}
