package com.discord.widgets.announcements;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetChannelFollowSuccessDialogBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.c0.c;
import d0.c0.c$a;
import d0.t.k;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelFollowSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", 0)};
    public static final WidgetChannelFollowSuccessDialog$Companion Companion = new WidgetChannelFollowSuccessDialog$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Integer[] successImageOptions;
    private final Integer[] successTextOptions;

    public WidgetChannelFollowSuccessDialog() {
        super(R$layout.widget_channel_follow_success_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelFollowSuccessDialog$binding$2.INSTANCE, null, 2, null);
        this.successTextOptions = new Integer[]{2131889052, 2131889053, 2131889054, 2131889055, 2131889056, 2131889057, 2131889058, 2131889059, 2131889060, 2131889061};
        this.successImageOptions = new Integer[]{2130969589, 2130969590, 2130969591};
    }

    private final WidgetChannelFollowSuccessDialogBinding getBinding() {
        return (WidgetChannelFollowSuccessDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        Companion.show(fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.channelFollowSuccessText");
        Integer[] numArr = this.successTextOptions;
        c$a c_a = c.k;
        textView.setText(getString(((Number) k.random(numArr, c_a)).intValue()));
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelFollowSuccessImage");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        MGImages.setImage$default(mGImages, simpleDraweeView, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, ((Number) k.random(this.successImageOptions, c_a)).intValue(), 0, 2, (Object) null), (MGImages$ChangeDetector) null, 4, (Object) null);
        getBinding().f2256b.setOnClickListener(new WidgetChannelFollowSuccessDialog$onViewBound$1(this));
    }
}
