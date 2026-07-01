package com.discord.widgets.user.phone;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$onViewBound$$inlined$with$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    public WidgetUserPhoneVerify$onViewBound$$inlined$with$lambda$1(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        this.this$0 = widgetUserPhoneVerify;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
