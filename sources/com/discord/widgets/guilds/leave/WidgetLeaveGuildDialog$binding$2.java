package com.discord.widgets.guilds.leave;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetLeaveGuildDialog$binding$2 extends C12236k implements Function1<View, LeaveGuildDialogBinding> {
    public static final WidgetLeaveGuildDialog$binding$2 INSTANCE = new WidgetLeaveGuildDialog$binding$2();

    public WidgetLeaveGuildDialog$binding$2() {
        super(1, LeaveGuildDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/LeaveGuildDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final LeaveGuildDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.leave_guild_cancel_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.leave_guild_cancel_btn);
        if (materialButton != null) {
            i = C5419R.id.leave_guild_confirm_btn;
            LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.leave_guild_confirm_btn);
            if (loadingButton != null) {
                i = C5419R.id.leave_guild_dialog_body;
                TextView textView = (TextView) view.findViewById(C5419R.id.leave_guild_dialog_body);
                if (textView != null) {
                    i = C5419R.id.leave_guild_dialog_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.leave_guild_dialog_header);
                    if (textView2 != null) {
                        i = C5419R.id.notice_header_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.notice_header_container);
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
