package com.discord.widgets.chat.input.sticker;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerFullSizeDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerFullSizeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerFullSizeDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(StickerFullSizeDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerFullSizeDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: StickerFullSizeDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(sticker, "sticker");
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            StickerFullSizeDialog stickerFullSizeDialog = new StickerFullSizeDialog();
            stickerFullSizeDialog.setArguments(bundle);
            stickerFullSizeDialog.show(fragmentManager, StickerFullSizeDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StickerFullSizeDialog() {
        super(C5419R.layout.sticker_full_size_dialog);
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
            getBinding().f15268b.m8616d(sticker, 0);
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        requireDialog().setCanceledOnTouchOutside(true);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }
}
