package com.discord.widgets.channels;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.restapi.RestAPIParams$CreateGuildChannel;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetCreateChannel this$0;

    public WidgetCreateChannel$configureUI$1(WidgetCreateChannel widgetCreateChannel) {
        this.this$0 = widgetCreateChannel;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.getItemId() == 2131364413) {
            RestAPI api = RestAPI.Companion.getApi();
            long jAccess$getGuildId$p = WidgetCreateChannel.access$getGuildId$p(this.this$0);
            int iAccess$getChannelType$p = WidgetCreateChannel.access$getChannelType$p(this.this$0);
            TextInputLayout textInputLayout = WidgetCreateChannel.access$getBinding$p(this.this$0).f;
            m.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(api.createGuildChannel(jAccess$getGuildId$p, new RestAPIParams$CreateGuildChannel(iAccess$getChannelType$p, null, ViewExtensions.getTextOrEmpty(textInputLayout), WidgetCreateChannel.access$getCategoryId$p(this.this$0), WidgetCreateChannel.access$getPermissionOverwrites(this.this$0), null)), new WidgetCreateChannel$configureUI$1$1(this)), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCreateChannel$configureUI$1$2(this.this$0), 60, (Object) null);
        }
    }
}
