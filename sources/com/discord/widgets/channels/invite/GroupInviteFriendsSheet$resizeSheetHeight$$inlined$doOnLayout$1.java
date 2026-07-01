package com.discord.widgets.channels.invite;

import android.content.res.Resources;
import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    public GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        this.this$0 = groupInviteFriendsSheet;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        Resources resources = this.this$0.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        layoutParams.height = (int) (resources.getDisplayMetrics().heightPixels * 0.9f);
        view.setLayoutParams(layoutParams);
    }
}
