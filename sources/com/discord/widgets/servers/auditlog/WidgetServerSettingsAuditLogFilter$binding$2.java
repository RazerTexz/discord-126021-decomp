package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLogFilter$binding$2 extends C12236k implements Function1<View, WidgetAuditLogFilterBinding> {
    public static final WidgetServerSettingsAuditLogFilter$binding$2 INSTANCE = new WidgetServerSettingsAuditLogFilter$binding$2();

    public WidgetServerSettingsAuditLogFilter$binding$2() {
        super(1, WidgetAuditLogFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuditLogFilterBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.audit_log_filter_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.audit_log_filter_input);
        if (textInputLayout != null) {
            i = C5419R.id.audit_log_filter_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.audit_log_filter_recycler);
            if (recyclerView != null) {
                return new WidgetAuditLogFilterBinding((LinearLayout) view, textInputLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
