package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$Companion {
    private WidgetChannelsListAdapter$ItemChannelCategory$Companion() {
    }

    public static final /* synthetic */ RotateAnimation access$getAnimation(WidgetChannelsListAdapter$ItemChannelCategory$Companion widgetChannelsListAdapter$ItemChannelCategory$Companion, boolean z2) {
        return widgetChannelsListAdapter$ItemChannelCategory$Companion.getAnimation(z2);
    }

    public static final /* synthetic */ int access$getArrowDrawable(WidgetChannelsListAdapter$ItemChannelCategory$Companion widgetChannelsListAdapter$ItemChannelCategory$Companion, ChannelListItemCategory channelListItemCategory) {
        return widgetChannelsListAdapter$ItemChannelCategory$Companion.getArrowDrawable(channelListItemCategory);
    }

    public static final /* synthetic */ int access$getChannelColor(WidgetChannelsListAdapter$ItemChannelCategory$Companion widgetChannelsListAdapter$ItemChannelCategory$Companion, ChannelListItemCategory channelListItemCategory, Context context) {
        return widgetChannelsListAdapter$ItemChannelCategory$Companion.getChannelColor(channelListItemCategory, context);
    }

    private final RotateAnimation getAnimation(boolean expand) {
        RotateAnimation rotateAnimation = new RotateAnimation(expand ? -90.0f : 90.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setDuration(300L);
        return rotateAnimation;
    }

    @DrawableRes
    private final int getArrowDrawable(ChannelListItemCategory channelListItemCategory) {
        if (channelListItemCategory.isCollapsed()) {
            return 2131231668;
        }
        return !channelListItemCategory.isCollapsed() ? 2131231664 : 0;
    }

    @ColorInt
    private final int getChannelColor(ChannelListItemCategory channelListItemCategory, Context context) {
        return channelListItemCategory.isMuted() ? ColorCompat.getThemedColor(context, 2130969007) : ColorCompat.getThemedColor(context, 2130968965);
    }

    public /* synthetic */ WidgetChannelsListAdapter$ItemChannelCategory$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
