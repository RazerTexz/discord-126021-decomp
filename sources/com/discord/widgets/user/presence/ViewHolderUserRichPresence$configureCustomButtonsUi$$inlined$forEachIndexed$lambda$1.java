package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.activity.Activity;
import com.discord.models.user.User;
import java.util.List;

/* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderUserRichPresence$configureCustomButtonsUi$$inlined$forEachIndexed$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Activity $activity$inlined;
    public final /* synthetic */ List $activityButtons$inlined;
    public final /* synthetic */ Context $applicationContext$inlined;
    public final /* synthetic */ int $index;
    public final /* synthetic */ User $user$inlined;
    public final /* synthetic */ ViewHolderUserRichPresence this$0;

    public ViewHolderUserRichPresence$configureCustomButtonsUi$$inlined$forEachIndexed$lambda$1(int i, ViewHolderUserRichPresence viewHolderUserRichPresence, List list, Context context, User user, Activity activity) {
        this.$index = i;
        this.this$0 = viewHolderUserRichPresence;
        this.$activityButtons$inlined = list;
        this.$applicationContext$inlined = context;
        this.$user$inlined = user;
        this.$activity$inlined = activity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ViewHolderUserRichPresence.access$handleActivityCustomButtonClick(this.this$0, this.$applicationContext$inlined, this.$user$inlined, this.$activity$inlined, this.$index);
    }
}
