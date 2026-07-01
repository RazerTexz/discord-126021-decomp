package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountBackupCodes3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountBackupCodesBinding> {
    public static final WidgetSettingsAccountBackupCodes3 INSTANCE = new WidgetSettingsAccountBackupCodes3();

    public WidgetSettingsAccountBackupCodes3() {
        super(1, WidgetSettingsAccountBackupCodesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsAccountBackupCodesBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.settings_backup_codes_generate;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_backup_codes_generate);
            if (materialButton != null) {
                i = R.id.settings_backup_codes_info;
                TextView textView = (TextView) view.findViewById(R.id.settings_backup_codes_info);
                if (textView != null) {
                    i = R.id.settings_backup_codes_rv;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.settings_backup_codes_rv);
                    if (recyclerView != null) {
                        return new WidgetSettingsAccountBackupCodesBinding((CoordinatorLayout) view, dimmerView, materialButton, textView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
