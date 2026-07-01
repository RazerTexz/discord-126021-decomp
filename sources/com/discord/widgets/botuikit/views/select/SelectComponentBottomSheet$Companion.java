package com.discord.widgets.botuikit.views.select;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import com.discord.api.botuikit.SelectItem;
import d0.o;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet$Companion {
    private SelectComponentBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, ComponentContext componentContext, int componentIndex, String customId, String placeholder, int min, int max, List<SelectItem> options, List<SelectItem> selectedItems, boolean emojiAnimationsEnabled) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(componentContext, "componentContext");
        m.checkNotNullParameter(customId, "customId");
        m.checkNotNullParameter(options, "options");
        m.checkNotNullParameter(selectedItems, "selectedItems");
        SelectComponentBottomSheet selectComponentBottomSheet = new SelectComponentBottomSheet();
        selectComponentBottomSheet.setArguments(BundleKt.bundleOf(o.to(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT, componentContext), o.to(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX, Integer.valueOf(componentIndex)), o.to(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, customId), o.to(SelectComponentBottomSheet.EXTRA_PLACEHOLDER, placeholder), o.to(SelectComponentBottomSheet.EXTRA_MIN, Integer.valueOf(min)), o.to(SelectComponentBottomSheet.EXTRA_MAX, Integer.valueOf(max)), o.to(SelectComponentBottomSheet.EXTRA_OPTIONS, options), o.to(SelectComponentBottomSheet.EXTRA_SELECTED, selectedItems), o.to(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED, Boolean.valueOf(emojiAnimationsEnabled))));
        selectComponentBottomSheet.show(fragmentManager, SelectComponentBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ SelectComponentBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
