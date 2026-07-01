package com.discord.widgets.guilds.leave;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetLeaveGuildDialog2 extends FunctionReferenceImpl implements Function1<View, LeaveGuildDialogBinding> {
    public static final WidgetLeaveGuildDialog2 INSTANCE = new WidgetLeaveGuildDialog2();

    public WidgetLeaveGuildDialog2() {
        super(1, LeaveGuildDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/LeaveGuildDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final LeaveGuildDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.leave_guild_cancel_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.leave_guild_cancel_btn);
        if (materialButton != null) {
            i = R.id.leave_guild_confirm_btn;
            LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.leave_guild_confirm_btn);
            if (loadingButton != null) {
                i = R.id.leave_guild_dialog_body;
                TextView textView = (TextView) view.findViewById(R.id.leave_guild_dialog_body);
                if (textView != null) {
                    i = R.id.leave_guild_dialog_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.leave_guild_dialog_header);
                    if (textView2 != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.notice_header_container);
                        if (linearLayout != null) {
                            return new LeaveGuildDialogBinding((LinearLayout) view, materialButton, loadingButton, textView, textView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
