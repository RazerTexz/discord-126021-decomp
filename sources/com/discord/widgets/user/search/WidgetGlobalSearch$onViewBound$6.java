package com.discord.widgets.user.search;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.friends.WidgetFriendsAdd$Companion;
import com.discord.widgets.tabs.NavigationTab;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.w;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$onViewBound$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    public WidgetGlobalSearch$onViewBound$6(WidgetGlobalSearch widgetGlobalSearch) {
        this.this$0 = widgetGlobalSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsAdd$Companion widgetFriendsAdd$Companion = WidgetFriendsAdd.Companion;
        Context contextX = a.x(view, "it", "it.context");
        TextInputLayout textInputLayout = WidgetGlobalSearch.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        widgetFriendsAdd$Companion.show(contextX, w.trimStart(ViewExtensions.getTextOrEmpty(textInputLayout), MentionUtilsKt.MENTIONS_CHAR, MentionUtilsKt.CHANNELS_CHAR, '*'), "QuickSwitcher");
        WidgetGlobalSearch.onSelected$default(this.this$0, NavigationTab.FRIENDS, null, 2, null);
    }
}
