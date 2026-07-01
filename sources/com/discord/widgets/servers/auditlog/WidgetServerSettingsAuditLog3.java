package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsAuditLogBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLog3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsAuditLogBinding> {
    public static final WidgetServerSettingsAuditLog3 INSTANCE = new WidgetServerSettingsAuditLog3();

    public WidgetServerSettingsAuditLog3() {
        super(1, WidgetServerSettingsAuditLogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsAuditLogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.no_logs_body;
        TextView textView = (TextView) view.findViewById(R.id.no_logs_body);
        if (textView != null) {
            i = R.id.no_logs_title;
            TextView textView2 = (TextView) view.findViewById(R.id.no_logs_title);
            if (textView2 != null) {
                i = R.id.server_settings_audit_logs_action_filter;
                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_audit_logs_action_filter);
                if (textView3 != null) {
                    i = R.id.server_settings_audit_logs_action_filter_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.server_settings_audit_logs_action_filter_container);
                    if (linearLayout != null) {
                        i = R.id.server_settings_audit_logs_recycler;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_audit_logs_recycler);
                        if (recyclerView != null) {
                            i = R.id.server_settings_audit_logs_user_filter;
                            TextView textView4 = (TextView) view.findViewById(R.id.server_settings_audit_logs_user_filter);
                            if (textView4 != null) {
                                i = R.id.server_settings_audit_logs_user_filter_container;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.server_settings_audit_logs_user_filter_container);
                                if (linearLayout2 != null) {
                                    i = R.id.server_settings_audit_logs_view_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_audit_logs_view_flipper);
                                    if (appViewFlipper != null) {
                                        i = R.id.server_settings_audit_logs_view_results_flipper;
                                        AppViewFlipper appViewFlipper2 = (AppViewFlipper) view.findViewById(R.id.server_settings_audit_logs_view_results_flipper);
                                        if (appViewFlipper2 != null) {
                                            return new WidgetServerSettingsAuditLogBinding((CoordinatorLayout) view, textView, textView2, textView3, linearLayout, recyclerView, textView4, linearLayout2, appViewFlipper, appViewFlipper2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
