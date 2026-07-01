package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsModeration3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsModerationBinding> {
    public static final WidgetServerSettingsModeration3 INSTANCE = new WidgetServerSettingsModeration3();

    public WidgetServerSettingsModeration3() {
        super(1, WidgetServerSettingsModerationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsModerationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.server_settings_moderation_explicit_1;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_explicit_1);
        if (checkedSetting != null) {
            i = R.id.server_settings_moderation_explicit_2;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_explicit_2);
            if (checkedSetting2 != null) {
                i = R.id.server_settings_moderation_explicit_3;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_explicit_3);
                if (checkedSetting3 != null) {
                    i = R.id.server_settings_moderation_explicit_help;
                    TextView textView = (TextView) view.findViewById(R.id.server_settings_moderation_explicit_help);
                    if (textView != null) {
                        i = R.id.server_settings_moderation_verification_1;
                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_1);
                        if (checkedSetting4 != null) {
                            i = R.id.server_settings_moderation_verification_2;
                            CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_2);
                            if (checkedSetting5 != null) {
                                i = R.id.server_settings_moderation_verification_3;
                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_3);
                                if (checkedSetting6 != null) {
                                    i = R.id.server_settings_moderation_verification_4;
                                    CheckedSetting checkedSetting7 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_4);
                                    if (checkedSetting7 != null) {
                                        i = R.id.server_settings_moderation_verification_5;
                                        CheckedSetting checkedSetting8 = (CheckedSetting) view.findViewById(R.id.server_settings_moderation_verification_5);
                                        if (checkedSetting8 != null) {
                                            i = R.id.server_settings_moderation_verification_help;
                                            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_moderation_verification_help);
                                            if (textView2 != null) {
                                                return new WidgetServerSettingsModerationBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, checkedSetting3, textView, checkedSetting4, checkedSetting5, checkedSetting6, checkedSetting7, checkedSetting8, textView2);
                                            }
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
