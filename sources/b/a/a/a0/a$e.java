package b.a.a.a0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$e implements View$OnClickListener {
    public final /* synthetic */ a j;
    public final /* synthetic */ String k;

    public a$e(a aVar, String str) {
        this.j = aVar;
        this.k = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context context = this.j.getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", this.k));
            }
            a aVar = this.j;
            KProperty[] kPropertyArr = a.j;
            MaterialButton materialButton = aVar.g().d;
            m.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
            materialButton.setText(context.getString(2131887923));
            this.j.g().c.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, 2130969404, 0, 2, (Object) null));
        }
    }
}
