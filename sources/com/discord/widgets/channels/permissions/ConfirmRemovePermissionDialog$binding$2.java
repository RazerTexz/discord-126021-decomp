package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ConfirmRemovePermissionDialog$binding$2 extends k implements Function1<View, ConfirmRemovePermissionDialogBinding> {
    public static final ConfirmRemovePermissionDialog$binding$2 INSTANCE = new ConfirmRemovePermissionDialog$binding$2();

    public ConfirmRemovePermissionDialog$binding$2() {
        super(1, ConfirmRemovePermissionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ConfirmRemovePermissionDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ConfirmRemovePermissionDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.body;
        TextView textView = (TextView) view.findViewById(R$id.body);
        if (textView != null) {
            i = R$id.cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.cancel);
            if (materialButton != null) {
                i = R$id.confirm;
                LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.confirm);
                if (loadingButton != null) {
                    i = R$id.notice_header_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.notice_header_container);
                    if (linearLayout != null) {
                        return new ConfirmRemovePermissionDialogBinding((LinearLayout) view, textView, materialButton, loadingButton, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
