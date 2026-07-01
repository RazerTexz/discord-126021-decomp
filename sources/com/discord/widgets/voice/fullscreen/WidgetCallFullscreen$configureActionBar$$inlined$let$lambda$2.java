package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.activity.OnBackPressedDispatcher;
import com.discord.app.AppActivity;
import com.discord.models.guild.Guild;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$2(Guild guild, WidgetCallFullscreen widgetCallFullscreen) {
        this.$guild$inlined = guild;
        this.this$0 = widgetCallFullscreen;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).onVisitCommunityButtonClicked(this.$guild$inlined.getId());
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity == null || (onBackPressedDispatcher = appActivity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.onBackPressed();
    }
}
