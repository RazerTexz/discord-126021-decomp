package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetConfirmRemoveCommunityDialog$binding$2 extends C12236k implements Function1<View, WidgetConfirmRemoveCommunityDialogBinding> {
    public static final WidgetConfirmRemoveCommunityDialog$binding$2 INSTANCE = new WidgetConfirmRemoveCommunityDialog$binding$2();

    public WidgetConfirmRemoveCommunityDialog$binding$2() {
        super(1, WidgetConfirmRemoveCommunityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetConfirmRemoveCommunityDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.confirm_deleting_community_body_text;
        TextView textView = (TextView) view.findViewById(C5419R.id.confirm_deleting_community_body_text);
        if (textView != null) {
            i = C5419R.id.confirm_deleting_community_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.confirm_deleting_community_cancel);
            if (materialButton != null) {
                i = C5419R.id.confirm_deleting_community_header;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.confirm_deleting_community_header);
                if (textView2 != null) {
                    i = C5419R.id.confirm_deleting_community_header_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.confirm_deleting_community_header_container);
                    if (linearLayout != null) {
                        i = C5419R.id.confirm_deleting_community_ok;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.confirm_deleting_community_ok);
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
