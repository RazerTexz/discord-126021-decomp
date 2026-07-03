package com.discord.widgets.chat.input.gifpicker;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSheet extends AppBottomSheet {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetGifPickerSearch gifPickerFragment;
    private Function0<Unit> onCancel;
    private Function0<Unit> onGifSelected;

    /* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Function0 function0, Function0 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            if ((i & 4) != 0) {
                function1 = null;
            }
            companion.show(fragmentManager, function0, function1);
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onGifSelected, Function0<Unit> onCancel) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGifPickerSheet widgetGifPickerSheet = new WidgetGifPickerSheet();
            widgetGifPickerSheet.show(fragmentManager, WidgetGifPickerSheet.class.getSimpleName());
            widgetGifPickerSheet.setOnGifSelected(onGifSelected);
            widgetGifPickerSheet.setOnCancel(onCancel);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
    public static final class C78901 extends AbstractC12240o implements Function0<Unit> {
        public C78901() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0 = WidgetGifPickerSheet.this.onGifSelected;
            if (function0 != null) {
            }
            WidgetGifPickerSheet.this.dismiss();
        }
    }

    public WidgetGifPickerSheet() {
        super(false, 1, null);
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        View view = widgetGifPickerSheet.container;
        if (view == null) {
            C12238m.throwUninitializedPropertyAccessException("container");
        }
        return view;
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
        return C5419R.layout.widget_gif_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetGifPickerSearch widgetGifPickerSearch = this.gifPickerFragment;
        if (widgetGifPickerSearch == null) {
            C12238m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.clearSearchBar();
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        this.container = view;
        WidgetGifPickerSearch widgetGifPickerSearch = new WidgetGifPickerSearch();
        this.gifPickerFragment = widgetGifPickerSearch;
        if (widgetGifPickerSearch == null) {
            C12238m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.setOnGifSelected(new C78901());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetGifPickerSearch widgetGifPickerSearch2 = this.gifPickerFragment;
        if (widgetGifPickerSearch2 == null) {
            C12238m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        WidgetGifPickerSearch widgetGifPickerSearch3 = this.gifPickerFragment;
        if (widgetGifPickerSearch3 == null) {
            C12238m.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(C5419R.id.gif_search_sheet_content, widgetGifPickerSearch2, widgetGifPickerSearch3.getClass().getSimpleName()).runOnCommit(new Runnable() { // from class: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet.onViewCreated.2
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams layoutParams = WidgetGifPickerSheet.access$getContainer$p(WidgetGifPickerSheet.this).getLayoutParams();
                if (layoutParams != null) {
                    Resources resources = WidgetGifPickerSheet.this.getResources();
                    C12238m.checkNotNullExpressionValue(resources, "resources");
                    layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                }
            }
        }).commit();
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }

    public final void setOnGifSelected(Function0<Unit> onGifSelected) {
        this.onGifSelected = onGifSelected;
    }
}
