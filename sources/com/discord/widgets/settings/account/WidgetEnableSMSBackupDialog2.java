package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableSMSBackupDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableSmsBackupDialogBinding> {
    public static final WidgetEnableSMSBackupDialog2 INSTANCE = new WidgetEnableSMSBackupDialog2();

    public WidgetEnableSMSBackupDialog2() {
        super(1, WidgetEnableSmsBackupDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEnableSmsBackupDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.enable_sms_backup_body;
        TextView textView = (TextView) view.findViewById(R.id.enable_sms_backup_body);
        if (textView != null) {
            i = R.id.enable_sms_backup_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.enable_sms_backup_cancel);
            if (materialButton != null) {
                i = R.id.enable_sms_backup_confirm;
                LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.enable_sms_backup_confirm);
                if (loadingButton != null) {
                    i = R.id.enable_sms_backup_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.enable_sms_backup_header);
                    if (textView2 != null) {
                        i = R.id.enable_sms_backup_password_wrap;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.enable_sms_backup_password_wrap);
                        if (textInputLayout != null) {
                            i = R.id.notice_header_container;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.notice_header_container);
                            if (linearLayout != null) {
                                return new WidgetEnableSmsBackupDialogBinding((LinearLayout) view, textView, materialButton, loadingButton, textView2, textInputLayout, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
