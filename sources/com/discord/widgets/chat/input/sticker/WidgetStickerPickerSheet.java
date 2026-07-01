package com.discord.widgets.chat.input.sticker;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStickerPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPickerSheet extends WidgetExpressionPickerSheet implements StickerPickerListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetStickerPicker stickerPickerFragment;
    private StickerPickerListener stickerPickerListenerDelegate;

    /* JADX INFO: compiled from: WidgetStickerPickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetStickerPickerSheet show(FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long initialStickerPackId, String searchText, Function0<Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            System.gc();
            Bundle bundle = new Bundle();
            if (initialStickerPackId != null) {
                initialStickerPackId.longValue();
                bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", initialStickerPackId.longValue());
            }
            bundle.putString("com.discord.intent.extra.EXTRA_TEXT", searchText);
            WidgetStickerPickerSheet widgetStickerPickerSheet = new WidgetStickerPickerSheet();
            widgetStickerPickerSheet.setStickerPickerListener(stickerPickerListener);
            widgetStickerPickerSheet.setOnCancel(onCancel);
            widgetStickerPickerSheet.setArguments(bundle);
            widgetStickerPickerSheet.show(fragmentManager, WidgetStickerPickerSheet.class.getSimpleName());
            return widgetStickerPickerSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet) {
        View view = widgetStickerPickerSheet.container;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.clearSearchInput();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.selectCategoryById(-1L);
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        StickerPickerListener stickerPickerListener = this.stickerPickerListenerDelegate;
        if (stickerPickerListener != null) {
            stickerPickerListener.onStickerPicked(sticker);
        }
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.container = view;
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("com.discord.intent.EXTRA_STICKER_PICKER_SCREEN") : null;
        Bundle arguments3 = getArguments();
        String string = arguments3 != null ? arguments3.getString("com.discord.intent.extra.EXTRA_TEXT") : null;
        WidgetStickerPicker widgetStickerPicker = new WidgetStickerPicker();
        this.stickerPickerFragment = widgetStickerPicker;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.BOTTOM_SHEET);
        bundle.putSerializable(WidgetStickerPicker.VIEW_TYPE, WidgetStickerPackStoreSheet2.STICKER_SEARCH_VIEW_ALL);
        bundle.putString("com.discord.intent.extra.EXTRA_TEXT", string);
        if (lValueOf != null) {
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", lValueOf.longValue());
        }
        if (serializable != null) {
            bundle.putSerializable("com.discord.intent.EXTRA_STICKER_PICKER_SCREEN", serializable);
        }
        widgetStickerPicker.setArguments(bundle);
        WidgetStickerPicker widgetStickerPicker2 = this.stickerPickerFragment;
        if (widgetStickerPicker2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
        if (widgetStickerPicker3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
        if (widgetStickerPicker4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R.id.sticker_sheet_sticker_picker_content, widgetStickerPicker3, widgetStickerPicker4.getClass().getSimpleName()).runOnCommit(new Runnable() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet.onViewCreated.2
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams layoutParams = WidgetStickerPickerSheet.access$getContainer$p(WidgetStickerPickerSheet.this).getLayoutParams();
                if (layoutParams != null) {
                    Resources resources = WidgetStickerPickerSheet.this.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                    layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                }
            }
        }).commit();
    }

    public final void scrollToPack(Long packId) {
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.scrollToPack(packId);
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        this.stickerPickerListenerDelegate = stickerPickerListener;
    }
}
