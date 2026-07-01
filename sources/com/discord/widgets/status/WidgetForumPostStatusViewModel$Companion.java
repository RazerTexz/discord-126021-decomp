package com.discord.widgets.status;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.widgets.forums.ForumUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$Companion {
    private WidgetForumPostStatusViewModel$Companion() {
    }

    public final Observable<WidgetForumPostStatusViewModel$StoreState> observeStoreState(StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StorePermissions storePermissions, StoreEmoji storeEmoji) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        Observable<WidgetForumPostStatusViewModel$StoreState> observableY = ForumUtils.observeSelectedPostChannel$default(ForumUtils.INSTANCE, storeChannels, storeChannelsSelected, null, null, 12, null).Y(new WidgetForumPostStatusViewModel$Companion$observeStoreState$1(storeUser, storeThreadsJoined, storeForumPostMessages, storeThreadMessages, storePermissions, storeEmoji));
        m.checkNotNullExpressionValue(observableY, "ForumUtils.observeSelect…      }\n        }\n      }");
        return observableY;
    }

    public /* synthetic */ WidgetForumPostStatusViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
