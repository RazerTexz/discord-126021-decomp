package com.discord.widgets.chat.input.gifpicker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSheet extends AppBottomSheet {
    public static final WidgetGifPickerSheet$Companion Companion = new WidgetGifPickerSheet$Companion(null);
    private View container;
    private WidgetGifPickerSearch gifPickerFragment;
    private Function0<Unit> onCancel;
    private Function0<Unit> onGifSelected;

    public WidgetGifPickerSheet() {
        super(false, 1, null);
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        View view = widgetGifPickerSheet.container;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ Function0 access$getOnGifSelected$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        return widgetGifPickerSheet.onGifSelected;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetGifPickerSheet widgetGifPickerSheet, View view) {
        widgetGifPickerSheet.container = view;
    }

    public static final /* synthetic */ void access$setOnGifSelected$p(WidgetGifPickerSheet widgetGifPickerSheet, Function0 function0) {
        widgetGifPickerSheet.onGifSelected = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetGifPickerSheet widgetGifPickerSheet, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetGifPickerSheet.setOnCancel(function0);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_gif_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetGifPickerSearch widgetGifPickerSearch = this.gifPickerFragment;
        if (widgetGifPickerSearch == null) {
            m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.clearSearchBar();
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        this.container = view;
        WidgetGifPickerSearch widgetGifPickerSearch = new WidgetGifPickerSearch();
        this.gifPickerFragment = widgetGifPickerSearch;
        if (widgetGifPickerSearch == null) {
            m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.setOnGifSelected(new WidgetGifPickerSheet$onViewCreated$1(this));
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetGifPickerSearch widgetGifPickerSearch2 = this.gifPickerFragment;
        if (widgetGifPickerSearch2 == null) {
            m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        WidgetGifPickerSearch widgetGifPickerSearch3 = this.gifPickerFragment;
        if (widgetGifPickerSearch3 == null) {
            m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R$id.gif_search_sheet_content, widgetGifPickerSearch2, widgetGifPickerSearch3.getClass().getSimpleName()).runOnCommit(new WidgetGifPickerSheet$onViewCreated$2(this)).commit();
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }

    public final void setOnGifSelected(Function0<Unit> onGifSelected) {
        this.onGifSelected = onGifSelected;
    }
}
