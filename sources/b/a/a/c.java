package b.a.a;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.c0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(c.class, "binding", "getBinding()Lcom/discord/databinding/ImageUploadFailedDialogBinding;", 0)};
    public static final c$b k = new c$b(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onResendCompressed;

    public c() {
        super(R$layout.image_upload_failed_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c$c.j, null, 2, null);
    }

    public final c0 g() {
        return (c0) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        int i;
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int i2 = getArgumentsOrDefault().getInt("PARAM_MAX_FILE_SIZE_MB");
        boolean z2 = getArgumentsOrDefault().getBoolean("PARAM_IS_USER_PREMIUM");
        boolean z3 = this.onResendCompressed != null && getArgumentsOrDefault().getBoolean("PARAM_CAN_COMPRESS");
        if (i2 == 8) {
            i = 2131889029;
        } else if (i2 == 20) {
            i = 2131889026;
        } else if (i2 != 50) {
            i = i2 != 100 ? 0 : 2131889028;
        } else {
            i = 2131889027;
        }
        MaterialButton materialButton = g().i;
        d0.z.d.m.checkNotNullExpressionValue(materialButton, "binding.imageUploadFailedSendCompress");
        materialButton.setVisibility(z3 ? 0 : 8);
        g().i.setOnClickListener(new c$a(0, this));
        boolean z4 = z2 && !z3;
        View view2 = g().e;
        d0.z.d.m.checkNotNullExpressionValue(view2, "binding.imageUploadFailedDivider");
        boolean z5 = !z4;
        view2.setVisibility(z5 ? 0 : 8);
        MaterialButton materialButton2 = g().h;
        d0.z.d.m.checkNotNullExpressionValue(materialButton2, "binding.imageUploadFailedOkay");
        materialButton2.setVisibility(z4 ? 0 : 8);
        g().h.setOnClickListener(new c$a(1, this));
        MaterialButton materialButton3 = g().f89b;
        d0.z.d.m.checkNotNullExpressionValue(materialButton3, "binding.imageUploadFailedCancel");
        materialButton3.setVisibility(z5 ? 0 : 8);
        g().f89b.setOnClickListener(new c$a(2, this));
        RelativeLayout relativeLayout = g().g;
        d0.z.d.m.checkNotNullExpressionValue(relativeLayout, "binding.imageUploadFailedNitroWrapper");
        relativeLayout.setVisibility(z2 ^ true ? 0 : 8);
        g().f.setOnClickListener(new c$a(3, this));
        RelativeLayout relativeLayout2 = g().d;
        d0.z.d.m.checkNotNullExpressionValue(relativeLayout2, "binding.imageUploadFaile…pressionSettingsContainer");
        relativeLayout2.setVisibility(z3 ? 0 : 8);
        g().d.setOnClickListener(new c$a(4, this));
        SwitchMaterial switchMaterial = g().c;
        d0.z.d.m.checkNotNullExpressionValue(switchMaterial, "binding.imageUploadFaile…mpressionSettingsCheckbox");
        switchMaterial.setChecked(StoreStream.Companion.getUserSettings().getIsAutoImageCompressionEnabled());
        g().c.setOnCheckedChangeListener(c$d.a);
        TextView textView = g().j;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.imageUploadFailedText");
        CharSequence charSequenceH = null;
        if (z2 || !z3) {
            Context context = getContext();
            if (context != null) {
                Object[] objArr = new Object[1];
                Context context2 = getContext();
                objArr[0] = context2 != null ? b.h(context2, i, new Object[0], null, 4) : null;
                charSequenceH = b.h(context, 2131896649, objArr, null, 4);
            }
        } else {
            Context context3 = getContext();
            if (context3 != null) {
                Object[] objArr2 = new Object[1];
                Context context4 = getContext();
                objArr2[0] = context4 != null ? b.h(context4, i, new Object[0], null, 4) : null;
                charSequenceH = b.h(context3, 2131896650, objArr2, null, 4);
            }
        }
        textView.setText(charSequenceH);
    }
}
