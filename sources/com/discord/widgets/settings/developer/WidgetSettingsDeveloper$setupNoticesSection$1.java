package com.discord.widgets.settings.developer;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.views.SwipeableItemTouchHelper$SwipeRevealConfiguration;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupNoticesSection$1 extends o implements Function0<ItemTouchHelper> {
    public final /* synthetic */ WidgetSettingsDeveloper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsDeveloper$setupNoticesSection$1(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        super(0);
        this.this$0 = widgetSettingsDeveloper;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ItemTouchHelper invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ItemTouchHelper invoke() {
        SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration = new SwipeableItemTouchHelper$SwipeRevealConfiguration(ColorCompat.getColor(this.this$0, 2131100382), ContextCompat.getDrawable(this.this$0.requireContext(), 2131231713), DimenUtils.dpToPixels(8));
        return new ItemTouchHelper(new WidgetSettingsDeveloper$setupNoticesSection$1$1(swipeableItemTouchHelper$SwipeRevealConfiguration, swipeableItemTouchHelper$SwipeRevealConfiguration, swipeableItemTouchHelper$SwipeRevealConfiguration));
    }
}
