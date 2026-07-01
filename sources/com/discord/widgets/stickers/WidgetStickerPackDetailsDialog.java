package com.discord.widgets.stickers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStickers$StickerPackState;
import com.discord.stores.StoreStickers$StickerPackState$Loaded;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStickerPackDetailsDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0)};
    public static final WidgetStickerPackDetailsDialog$Companion Companion = new WidgetStickerPackDetailsDialog$Companion(null);
    private static final String EXTRA_Y_POSITION = "EXTRA_Y_POSITION";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Long stickerPackId;

    public WidgetStickerPackDetailsDialog() {
        super(R$layout.sticker_pack_details_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStickerPackDetailsDialog$binding$2.INSTANCE, null, 2, null);
        setStyle(1, 2131951655);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog, StoreStickers$StickerPackState storeStickers$StickerPackState) {
        widgetStickerPackDetailsDialog.configureUI(storeStickers$StickerPackState);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(StoreStickers$StickerPackState stickerPackState) {
        if (stickerPackState instanceof StoreStickers$StickerPackState$Loaded) {
            ModelStickerPack stickerPack = ((StoreStickers$StickerPackState$Loaded) stickerPackState).getStickerPack();
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.stickerPackDetailsPack");
            textView.setText(b.k(this, 2131895945, new Object[]{stickerPack.getName()}, null, 4));
            TextView textView2 = getBinding().f2152b;
            m.checkNotNullExpressionValue(textView2, "binding.stickerPackDetailsAnimated");
            textView2.setVisibility(stickerPack.isAnimatedPack() ? 0 : 8);
            TextView textView3 = getBinding().f2152b;
            m.checkNotNullExpressionValue(textView3, "binding.stickerPackDetailsAnimated");
            textView3.setText("・ " + getString(2131895946));
            TextView textView4 = getBinding().f;
            m.checkNotNullExpressionValue(textView4, "binding.stickerPackDetailsPremium");
            textView4.setVisibility(stickerPack.isPremiumPack() ? 0 : 8);
            TextView textView5 = getBinding().f;
            m.checkNotNullExpressionValue(textView5, "binding.stickerPackDetailsPremium");
            textView5.setText("・ " + getString(2131895948));
            TextView textView6 = getBinding().d;
            m.checkNotNullExpressionValue(textView6, "binding.stickerPackDetailsLimited");
            textView6.setVisibility(stickerPack.isLimitedPack() ? 0 : 8);
            TextView textView7 = getBinding().d;
            m.checkNotNullExpressionValue(textView7, "binding.stickerPackDetailsLimited");
            StringBuilder sb = new StringBuilder();
            sb.append("・ ");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            sb.append(b.k(this, 2131895947, new Object[]{stickerUtils.getLimitedTimeLeftString(contextRequireContext, stickerPack.getStoreListing())}, null, 4));
            textView7.setText(sb.toString());
        }
    }

    private final StickerPackDetailsDialogBinding getBinding() {
        return (StickerPackDetailsDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        WindowManager$LayoutParams attributes;
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setGravity(81);
        }
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt(EXTRA_Y_POSITION, 0)) : null;
        Window window2 = dialogOnCreateDialog.getWindow();
        if (window2 != null && (attributes = window2.getAttributes()) != null) {
            if (numValueOf != null && numValueOf.intValue() == 0) {
                Context context = dialogOnCreateDialog.getContext();
                m.checkNotNullExpressionValue(context, "context");
                numValueOf = Integer.valueOf((int) (context.getResources().getDimension(2131165343) / 2));
            }
            attributes.y = numValueOf.intValue();
        }
        return dialogOnCreateDialog;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(new WidgetStickerPackDetailsDialog$onViewBound$1(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        this.stickerPackId = lValueOf;
        if (lValueOf != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getStickers().observeStickerPack(lValueOf.longValue()), this, null, 2, null), WidgetStickerPackDetailsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStickerPackDetailsDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
        }
    }
}
