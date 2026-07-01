package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$configureGuildForumChannel$1<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetChannelNotificationSettings$Model $this_configureGuildForumChannel;
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    public WidgetChannelNotificationSettings$configureGuildForumChannel$1(WidgetChannelNotificationSettings widgetChannelNotificationSettings, WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        this.this$0 = widgetChannelNotificationSettings;
        this.$this_configureGuildForumChannel = widgetChannelNotificationSettings$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isChecked");
        int i = bool.booleanValue() ? ModelNotificationSettings.FORUM_THREAD_CREATED_ON : ModelNotificationSettings.FORUM_THREAD_CREATED_OFF;
        Integer channelOverrideFlags = this.$this_configureGuildForumChannel.getChannelOverrideFlags();
        int iIntValue = i | ((channelOverrideFlags != null ? channelOverrideFlags.intValue() : 0) & (~ModelNotificationSettings.FORUM_THREAD_CREATED_MASK));
        StoreUserGuildSettings userGuildSettings = StoreStream.Companion.getUserGuildSettings();
        CheckedSetting checkedSetting = WidgetChannelNotificationSettings.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.frequencyAllPosts");
        Context context = checkedSetting.getContext();
        m.checkNotNullExpressionValue(context, "binding.frequencyAllPosts.context");
        userGuildSettings.setChannelNotificationFlags(context, this.$this_configureGuildForumChannel.getChannel(), iIntValue);
    }
}
