package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventUpsellBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventUpsellBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String GUILD_EVENT_UPSELL_CACHE_KEY = "GUILD_EVENT_UPSELL_CACHE_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(FragmentManager fragmentManager, long guildId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet = new WidgetGuildScheduledEventUpsellBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetGuildScheduledEventUpsellBottomSheet.setArguments(bundle);
            widgetGuildScheduledEventUpsellBottomSheet.show(fragmentManager, WidgetGuildScheduledEventUpsellBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetGuildScheduledEventUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventUpsellBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildScheduledEventUpsellBottomSheet$guildId$2(this));
    }

    private final WidgetGuildScheduledEventUpsellBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_scheduled_event_upsell_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17049c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Set<GuildFeature> features;
                Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(WidgetGuildScheduledEventUpsellBottomSheet.this.getGuildId());
                if (guild == null || (features = guild.getFeatures()) == null || !features.contains(GuildFeature.COMMUNITY)) {
                    WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetGuildScheduledEventUpsellBottomSheet.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, true, WidgetGuildScheduledEventUpsellBottomSheet.this.getGuildId(), (8 & 8) != 0 ? 0L : 0L, (8 & 16) != 0 ? false : true);
                } else {
                    WidgetGuildScheduledEventListBottomSheet.Companion companion2 = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
                    FragmentManager parentFragmentManager2 = WidgetGuildScheduledEventUpsellBottomSheet.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    WidgetGuildScheduledEventListBottomSheet.Companion.show$default(companion2, parentFragmentManager2, WidgetGuildScheduledEventUpsellBottomSheet.this.getGuildId(), null, 4, null);
                }
                WidgetGuildScheduledEventUpsellBottomSheet.this.dismiss();
            }
        });
        getBinding().f17048b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildScheduledEventUpsellBottomSheet.this.dismiss();
            }
        });
    }
}
