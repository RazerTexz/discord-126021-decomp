package com.discord.widgets.stickers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStickerPackDetailsDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_Y_POSITION = "EXTRA_Y_POSITION";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Long stickerPackId;

    /* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            companion.show(fragmentManager, j, num);
        }

        public final void show(FragmentManager fragmentManager, long stickerPackId, Integer y2) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", stickerPackId);
            if (y2 != null) {
                y2.intValue();
                bundle.putInt(WidgetStickerPackDetailsDialog.EXTRA_Y_POSITION, y2.intValue());
            }
            WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog = new WidgetStickerPackDetailsDialog();
            widgetStickerPackDetailsDialog.setArguments(bundle);
            widgetStickerPackDetailsDialog.show(fragmentManager, WidgetStickerPackDetailsDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreStickers.StickerPackState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreStickers.StickerPackState stickerPackState) {
            invoke2(stickerPackState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreStickers.StickerPackState stickerPackState) {
            Intrinsics3.checkNotNullParameter(stickerPackState, "it");
            WidgetStickerPackDetailsDialog.this.configureUI(stickerPackState);
        }
    }

    public WidgetStickerPackDetailsDialog() {
        super(R.layout.sticker_pack_details_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerPackDetailsDialog2.INSTANCE, null, 2, null);
        setStyle(1, 2131951655);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(StoreStickers.StickerPackState stickerPackState) {
        if (stickerPackState instanceof StoreStickers.StickerPackState.Loaded) {
            ModelStickerPack stickerPack = ((StoreStickers.StickerPackState.Loaded) stickerPackState).getStickerPack();
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerPackDetailsPack");
            textView.setText(FormatUtils.e(this, R.string.sticker_picker_pack_details, new Object[]{stickerPack.getName()}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            TextView textView2 = getBinding().f2152b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerPackDetailsAnimated");
            textView2.setVisibility(stickerPack.isAnimatedPack() ? 0 : 8);
            TextView textView3 = getBinding().f2152b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.stickerPackDetailsAnimated");
            textView3.setText("・ " + getString(R.string.sticker_picker_pack_details_animated));
            TextView textView4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.stickerPackDetailsPremium");
            textView4.setVisibility(stickerPack.isPremiumPack() ? 0 : 8);
            TextView textView5 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.stickerPackDetailsPremium");
            textView5.setText("・ " + getString(R.string.sticker_picker_pack_details_premium));
            TextView textView6 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.stickerPackDetailsLimited");
            textView6.setVisibility(stickerPack.isLimitedPack() ? 0 : 8);
            TextView textView7 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.stickerPackDetailsLimited");
            StringBuilder sb = new StringBuilder();
            sb.append("・ ");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            sb.append(FormatUtils.e(this, R.string.sticker_picker_pack_details_limited_time_left, new Object[]{stickerUtils.getLimitedTimeLeftString(contextRequireContext, stickerPack.getStoreListing())}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            textView7.setText(sb.toString());
        }
    }

    private final StickerPackDetailsDialogBinding getBinding() {
        return (StickerPackDetailsDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
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
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                numValueOf = Integer.valueOf((int) (context.getResources().getDimension(R.dimen.default_keyboard_height) / 2));
            }
            attributes.y = numValueOf.intValue();
        }
        return dialogOnCreateDialog;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetStickerPackDetailsDialog.this.dismiss();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        this.stickerPackId = lValueOf;
        if (lValueOf != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getStickers().observeStickerPack(lValueOf.longValue()), this, null, 2, null), (Class<?>) WidgetStickerPackDetailsDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }
}
