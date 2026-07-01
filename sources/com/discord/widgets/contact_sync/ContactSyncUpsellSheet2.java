package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.LayoutContactSyncToggleInfoBinding;
import com.discord.R;
import com.discord.databinding.ContactSyncUpsellSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ContactSyncUpsellSheet2 extends FunctionReferenceImpl implements Function1<View, ContactSyncUpsellSheetBinding> {
    public static final ContactSyncUpsellSheet2 INSTANCE = new ContactSyncUpsellSheet2();

    public ContactSyncUpsellSheet2() {
        super(1, ContactSyncUpsellSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ContactSyncUpsellSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.contact_sync_upsell_cta;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.contact_sync_upsell_cta);
        if (linearLayout != null) {
            i = R.id.contact_sync_upsell_next_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.contact_sync_upsell_next_button);
            if (materialButton != null) {
                i = R.id.contact_sync_upsell_skip_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.contact_sync_upsell_skip_button);
                if (materialButton2 != null) {
                    i = R.id.contact_sync_upsell_subtitle;
                    TextView textView = (TextView) view.findViewById(R.id.contact_sync_upsell_subtitle);
                    if (textView != null) {
                        i = R.id.contact_sync_upsell_title;
                        TextView textView2 = (TextView) view.findViewById(R.id.contact_sync_upsell_title);
                        if (textView2 != null) {
                            i = R.id.contact_sync_upsell_toggle_info;
                            View viewFindViewById = view.findViewById(R.id.contact_sync_upsell_toggle_info);
                            if (viewFindViewById != null) {
                                return new ContactSyncUpsellSheetBinding((ConstraintLayout) view, linearLayout, materialButton, materialButton2, textView, textView2, LayoutContactSyncToggleInfoBinding.a(viewFindViewById));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
