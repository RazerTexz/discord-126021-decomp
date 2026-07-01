package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.ContactSyncPermissionsSheetBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ContactSyncPermissionsSheet$binding$2 extends k implements Function1<View, ContactSyncPermissionsSheetBinding> {
    public static final ContactSyncPermissionsSheet$binding$2 INSTANCE = new ContactSyncPermissionsSheet$binding$2();

    public ContactSyncPermissionsSheet$binding$2() {
        super(1, ContactSyncPermissionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ContactSyncPermissionsSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ContactSyncPermissionsSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.contact_sync_permissions_discoverable_toggle;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.contact_sync_permissions_discoverable_toggle);
        if (checkedSetting != null) {
            i = R$id.contact_sync_permissions_discovery_info_1;
            TextView textView = (TextView) view.findViewById(R$id.contact_sync_permissions_discovery_info_1);
            if (textView != null) {
                i = R$id.contact_sync_permissions_discovery_info_2;
                TextView textView2 = (TextView) view.findViewById(R$id.contact_sync_permissions_discovery_info_2);
                if (textView2 != null) {
                    i = R$id.contact_sync_permissions_email_toggle;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.contact_sync_permissions_email_toggle);
                    if (checkedSetting2 != null) {
                        i = R$id.contact_sync_permissions_learn_more;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.contact_sync_permissions_learn_more);
                        if (linkifiedTextView != null) {
                            i = R$id.contact_sync_permissions_phone_toggle;
                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.contact_sync_permissions_phone_toggle);
                            if (checkedSetting3 != null) {
                                i = R$id.contact_sync_permissions_subtitle;
                                TextView textView3 = (TextView) view.findViewById(R$id.contact_sync_permissions_subtitle);
                                if (textView3 != null) {
                                    return new ContactSyncPermissionsSheetBinding((ConstraintLayout) view, checkedSetting, textView, textView2, checkedSetting2, linkifiedTextView, checkedSetting3, textView3);
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
