package com.discord.widgets.chat.input.sticker;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerFullSizeDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StickerFullSizeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerFullSizeDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(StickerFullSizeDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerFullSizeDialogBinding;", 0)};
    public static final StickerFullSizeDialog$Companion Companion = new StickerFullSizeDialog$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public StickerFullSizeDialog() {
        super(R$layout.sticker_full_size_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, StickerFullSizeDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final StickerFullSizeDialogBinding getBinding() {
        return (StickerFullSizeDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("com.discord.intent.extra.EXTRA_STICKER") : null;
        Sticker sticker = (Sticker) (serializable instanceof Sticker ? serializable : null);
        if (sticker == null) {
            dismiss();
        } else {
            getBinding().f2151b.d(sticker, 0);
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        requireDialog().setCanceledOnTouchOutside(true);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }
}
