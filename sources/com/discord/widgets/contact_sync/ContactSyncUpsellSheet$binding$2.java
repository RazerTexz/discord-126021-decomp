package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ContactSyncUpsellSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1017o0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ContactSyncUpsellSheet$binding$2 extends C12236k implements Function1<View, ContactSyncUpsellSheetBinding> {
    public static final ContactSyncUpsellSheet$binding$2 INSTANCE = new ContactSyncUpsellSheet$binding$2();

    public ContactSyncUpsellSheet$binding$2() {
        super(1, ContactSyncUpsellSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ContactSyncUpsellSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.contact_sync_upsell_cta;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.contact_sync_upsell_cta);
        if (linearLayout != null) {
            i = C5419R.id.contact_sync_upsell_next_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.contact_sync_upsell_next_button);
            if (materialButton != null) {
                i = C5419R.id.contact_sync_upsell_skip_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.contact_sync_upsell_skip_button);
                if (materialButton2 != null) {
                    i = C5419R.id.contact_sync_upsell_subtitle;
                    TextView textView = (TextView) view.findViewById(C5419R.id.contact_sync_upsell_subtitle);
                    if (textView != null) {
                        i = C5419R.id.contact_sync_upsell_title;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.contact_sync_upsell_title);
                        if (textView2 != null) {
                            i = C5419R.id.contact_sync_upsell_toggle_info;
                            View viewFindViewById = view.findViewById(C5419R.id.contact_sync_upsell_toggle_info);
                            if (viewFindViewById != null) {
                                return new ContactSyncUpsellSheetBinding((ConstraintLayout) view, linearLayout, materialButton, materialButton2, textView, textView2, C1017o0.m202a(viewFindViewById));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
