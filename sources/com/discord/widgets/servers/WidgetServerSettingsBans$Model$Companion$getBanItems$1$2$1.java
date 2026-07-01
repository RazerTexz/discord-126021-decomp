package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelBan;
import d0.g0.w;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$1<T, R> implements b<ModelBan, Boolean> {
    public final /* synthetic */ String $filter;

    public WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$1(String str) {
        this.$filter = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(ModelBan modelBan) {
        return call2(modelBan);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelBan modelBan) {
        m.checkNotNullExpressionValue(modelBan, "it");
        String username = modelBan.getUser().getUsername();
        String str = this.$filter;
        m.checkNotNullExpressionValue(str, "filter");
        return Boolean.valueOf(w.contains((CharSequence) username, (CharSequence) str, true));
    }
}
