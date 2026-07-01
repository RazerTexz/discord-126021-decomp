package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.utilities.integrations.SpotifyHelper;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ Activity $listeningActivity;
    public final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether$Model $this_configureUI;

    public WidgetChatListAdapterItemSpotifyListenTogether$configureUI$3(WidgetChatListAdapterItemSpotifyListenTogether$Model widgetChatListAdapterItemSpotifyListenTogether$Model, Activity activity) {
        this.$this_configureUI = widgetChatListAdapterItemSpotifyListenTogether$Model;
        this.$listeningActivity = activity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpotifyHelper.INSTANCE.launchAlbum(a.x(view, "it", "it.context"), this.$listeningActivity, this.$this_configureUI.getItem().getUserId(), this.$this_configureUI.isMe());
    }
}
