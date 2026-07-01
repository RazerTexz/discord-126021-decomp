package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetConfirmRemoveCommunityDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetConfirmRemoveCommunityDialogBinding> {
    public static final WidgetConfirmRemoveCommunityDialog2 INSTANCE = new WidgetConfirmRemoveCommunityDialog2();

    public WidgetConfirmRemoveCommunityDialog2() {
        super(1, WidgetConfirmRemoveCommunityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetConfirmRemoveCommunityDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.confirm_deleting_community_body_text;
        TextView textView = (TextView) view.findViewById(R.id.confirm_deleting_community_body_text);
        if (textView != null) {
            i = R.id.confirm_deleting_community_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.confirm_deleting_community_cancel);
            if (materialButton != null) {
                i = R.id.confirm_deleting_community_header;
                TextView textView2 = (TextView) view.findViewById(R.id.confirm_deleting_community_header);
                if (textView2 != null) {
                    i = R.id.confirm_deleting_community_header_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.confirm_deleting_community_header_container);
                    if (linearLayout != null) {
                        i = R.id.confirm_deleting_community_ok;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm_deleting_community_ok);
                        if (materialButton2 != null) {
                            return new WidgetConfirmRemoveCommunityDialogBinding((LinearLayout) view, textView, materialButton, textView2, linearLayout, materialButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
