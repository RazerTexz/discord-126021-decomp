package com.discord.widgets.announcements;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetChannelFollowSuccessDialogBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.announcements.WidgetChannelFollowSuccessDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelFollowSuccessDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelFollowSuccessDialogBinding> {
    public static final WidgetChannelFollowSuccessDialog2 INSTANCE = new WidgetChannelFollowSuccessDialog2();

    public WidgetChannelFollowSuccessDialog2() {
        super(1, WidgetChannelFollowSuccessDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelFollowSuccessDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelFollowSuccessDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_follow_success_confirm;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.channel_follow_success_confirm);
        if (materialButton != null) {
            i = R.id.channel_follow_success_image;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channel_follow_success_image);
            if (simpleDraweeView != null) {
                i = R.id.channel_follow_success_text;
                TextView textView = (TextView) view.findViewById(R.id.channel_follow_success_text);
                if (textView != null) {
                    return new WidgetChannelFollowSuccessDialogBinding((NestedScrollView) view, materialButton, simpleDraweeView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
