package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLogFilter$binding$2 extends k implements Function1<View, WidgetAuditLogFilterBinding> {
    public static final WidgetServerSettingsAuditLogFilter$binding$2 INSTANCE = new WidgetServerSettingsAuditLogFilter$binding$2();

    public WidgetServerSettingsAuditLogFilter$binding$2() {
        super(1, WidgetAuditLogFilterBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuditLogFilterBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuditLogFilterBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.audit_log_filter_input;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.audit_log_filter_input);
        if (textInputLayout != null) {
            i = R$id.audit_log_filter_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.audit_log_filter_recycler);
            if (recyclerView != null) {
                return new WidgetAuditLogFilterBinding((LinearLayout) view, textInputLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
