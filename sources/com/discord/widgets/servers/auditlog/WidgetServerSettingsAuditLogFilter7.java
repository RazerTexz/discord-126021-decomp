package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLogFilter7 extends FunctionReferenceImpl implements Function1<View, WidgetAuditLogFilterBinding> {
    public static final WidgetServerSettingsAuditLogFilter7 INSTANCE = new WidgetServerSettingsAuditLogFilter7();

    public WidgetServerSettingsAuditLogFilter7() {
        super(1, WidgetAuditLogFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuditLogFilterBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.audit_log_filter_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.audit_log_filter_input);
        if (textInputLayout != null) {
            i = R.id.audit_log_filter_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.audit_log_filter_recycler);
            if (recyclerView != null) {
                return new WidgetAuditLogFilterBinding((LinearLayout) view, textInputLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
