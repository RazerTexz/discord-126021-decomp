package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventUpsellBottomSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventUpsellBottomSheetBinding;", 0)};
    public static final WidgetGuildScheduledEventUpsellBottomSheet$Companion Companion = new WidgetGuildScheduledEventUpsellBottomSheet$Companion(null);
    public static final String GUILD_EVENT_UPSELL_CACHE_KEY = "GUILD_EVENT_UPSELL_CACHE_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    public WidgetGuildScheduledEventUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventUpsellBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildScheduledEventUpsellBottomSheet$guildId$2(this));
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet) {
        return widgetGuildScheduledEventUpsellBottomSheet.getGuildId();
    }

    private final WidgetGuildScheduledEventUpsellBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_scheduled_event_upsell_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new WidgetGuildScheduledEventUpsellBottomSheet$onViewCreated$1(this));
        getBinding().f2450b.setOnClickListener(new WidgetGuildScheduledEventUpsellBottomSheet$onViewCreated$2(this));
    }
}
