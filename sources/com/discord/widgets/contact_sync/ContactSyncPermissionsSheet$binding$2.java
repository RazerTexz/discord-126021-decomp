package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ContactSyncPermissionsSheetBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ContactSyncPermissionsSheet$binding$2 extends C12236k implements Function1<View, ContactSyncPermissionsSheetBinding> {
    public static final ContactSyncPermissionsSheet$binding$2 INSTANCE = new ContactSyncPermissionsSheet$binding$2();

    public ContactSyncPermissionsSheet$binding$2() {
        super(1, ContactSyncPermissionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ContactSyncPermissionsSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.contact_sync_permissions_discoverable_toggle;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.contact_sync_permissions_discoverable_toggle);
        if (checkedSetting != null) {
            i = C5419R.id.contact_sync_permissions_discovery_info_1;
            TextView textView = (TextView) view.findViewById(C5419R.id.contact_sync_permissions_discovery_info_1);
            if (textView != null) {
                i = C5419R.id.contact_sync_permissions_discovery_info_2;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.contact_sync_permissions_discovery_info_2);
                if (textView2 != null) {
                    i = C5419R.id.contact_sync_permissions_email_toggle;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.contact_sync_permissions_email_toggle);
                    if (checkedSetting2 != null) {
                        i = C5419R.id.contact_sync_permissions_learn_more;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.contact_sync_permissions_learn_more);
                        if (linkifiedTextView != null) {
                            i = C5419R.id.contact_sync_permissions_phone_toggle;
                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.contact_sync_permissions_phone_toggle);
                            if (checkedSetting3 != null) {
                                i = C5419R.id.contact_sync_permissions_subtitle;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.contact_sync_permissions_subtitle);
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
