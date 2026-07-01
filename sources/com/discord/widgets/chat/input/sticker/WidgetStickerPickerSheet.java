package com.discord.widgets.chat.input.sticker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: WidgetStickerPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPickerSheet extends WidgetExpressionPickerSheet implements StickerPickerListener {
    public static final WidgetStickerPickerSheet$Companion Companion = new WidgetStickerPickerSheet$Companion(null);
    private View container;
    private WidgetStickerPicker stickerPickerFragment;
    private StickerPickerListener stickerPickerListenerDelegate;

    public static final /* synthetic */ View access$getContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet) {
        View view = widgetStickerPickerSheet.container;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet, View view) {
        widgetStickerPickerSheet.container = view;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_sticker_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.clearSearchInput();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.selectCategoryById(-1L);
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        StickerPickerListener stickerPickerListener = this.stickerPickerListenerDelegate;
        if (stickerPickerListener != null) {
            stickerPickerListener.onStickerPicked(sticker);
        }
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
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
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.BOTTOM_SHEET);
        bundle.putSerializable(WidgetStickerPicker.VIEW_TYPE, StickerPackStoreSheetViewType.STICKER_SEARCH_VIEW_ALL);
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
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
        if (widgetStickerPicker3 == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
        if (widgetStickerPicker4 == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R$id.sticker_sheet_sticker_picker_content, widgetStickerPicker3, widgetStickerPicker4.getClass().getSimpleName()).runOnCommit(new WidgetStickerPickerSheet$onViewCreated$2(this)).commit();
    }

    public final void scrollToPack(Long packId) {
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.scrollToPack(packId);
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        this.stickerPickerListenerDelegate = stickerPickerListener;
    }
}
