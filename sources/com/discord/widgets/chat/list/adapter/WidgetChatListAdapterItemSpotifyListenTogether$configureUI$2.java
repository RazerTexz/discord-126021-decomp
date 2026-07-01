package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.utilities.integrations.SpotifyHelper;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ Activity $listeningActivity;

    public WidgetChatListAdapterItemSpotifyListenTogether$configureUI$2(Activity activity) {
        this.$listeningActivity = activity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SpotifyHelper.INSTANCE.launchTrack(a.x(view, "it", "it.context"), this.$listeningActivity);
    }
}
