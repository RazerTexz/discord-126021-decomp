package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$None;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel$Companion$observeStoreState$1<T, R> implements b<String, Observable<? extends StoreGuildTemplates$GuildTemplateState>> {
    public final /* synthetic */ StoreGuildTemplates $storeGuildTemplates;

    public WidgetAuthLandingViewModel$Companion$observeStoreState$1(StoreGuildTemplates storeGuildTemplates) {
        this.$storeGuildTemplates = storeGuildTemplates;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StoreGuildTemplates$GuildTemplateState> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreGuildTemplates$GuildTemplateState> call2(String str) {
        return str != null ? this.$storeGuildTemplates.observeGuildTemplate(str).v(new WidgetAuthLandingViewModel$Companion$observeStoreState$1$1(this, str)) : new k(StoreGuildTemplates$GuildTemplateState$None.INSTANCE);
    }
}
