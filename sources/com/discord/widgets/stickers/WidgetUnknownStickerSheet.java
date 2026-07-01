package com.discord.widgets.stickers;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.sticker.StickerPartial;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUnknownStickerSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUnknownStickerSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUnknownStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUnknownStickerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetUnknownStickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, StickerPartial sticker) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            WidgetUnknownStickerSheet widgetUnknownStickerSheet = new WidgetUnknownStickerSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            widgetUnknownStickerSheet.setArguments(bundle);
            widgetUnknownStickerSheet.show(fragmentManager, WidgetUnknownStickerSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetUnknownStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUnknownStickerSheet2.INSTANCE, null, 2, null);
    }

    private final WidgetUnknownStickerSheetBinding getBinding() {
        return (WidgetUnknownStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager, StickerPartial stickerPartial) {
        INSTANCE.show(fragmentManager, stickerPartial);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_unknown_sticker_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Serializable serializable = getArgumentsOrDefault().getSerializable("com.discord.intent.extra.EXTRA_STICKER");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.StickerPartial");
        StickerPartial stickerPartial = (StickerPartial) serializable;
        getBinding().f2677b.d(stickerPartial, 0);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unknownStickerSheetStickerName");
        textView.setText(stickerPartial.getName());
    }
}
