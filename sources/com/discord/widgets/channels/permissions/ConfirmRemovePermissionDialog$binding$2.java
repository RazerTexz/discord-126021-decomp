package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ConfirmRemovePermissionDialog$binding$2 extends C12236k implements Function1<View, ConfirmRemovePermissionDialogBinding> {
    public static final ConfirmRemovePermissionDialog$binding$2 INSTANCE = new ConfirmRemovePermissionDialog$binding$2();

    public ConfirmRemovePermissionDialog$binding$2() {
        super(1, ConfirmRemovePermissionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ConfirmRemovePermissionDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.body;
        TextView textView = (TextView) view.findViewById(C5419R.id.body);
        if (textView != null) {
            i = C5419R.id.cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel);
            if (materialButton != null) {
                i = C5419R.id.confirm;
                LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.confirm);
                if (loadingButton != null) {
                    i = C5419R.id.notice_header_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.notice_header_container);
                    if (linearLayout != null) {
                        return new ConfirmRemovePermissionDialogBinding((LinearLayout) view, textView, materialButton, loadingButton, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
