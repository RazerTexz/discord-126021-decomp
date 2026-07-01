package com.discord.widgets.voice.settings;

import android.widget.TextView;
import b.a.k.b;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.utilities.stateful.StatefulViews;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$showRegionDialog$2 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ List $regions;
    public final /* synthetic */ WidgetVoiceChannelSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceChannelSettings$showRegionDialog$2(WidgetVoiceChannelSettings widgetVoiceChannelSettings, List list) {
        super(1);
        this.this$0 = widgetVoiceChannelSettings;
        this.$regions = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        if (i == 0) {
            StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(this.this$0);
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).g;
            m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
            statefulViewsAccess$getState$p.put(textView.getId(), null);
            TextView textView2 = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).g;
            m.checkNotNullExpressionValue(textView2, "binding.channelSettingsRegionOverride");
            textView2.setText(b.k(this.this$0, 2131886954, new Object[0], null, 4));
        } else {
            StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(this.this$0);
            TextView textView3 = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).g;
            m.checkNotNullExpressionValue(textView3, "binding.channelSettingsRegionOverride");
            int i2 = i - 1;
            statefulViewsAccess$getState$p2.put(textView3.getId(), ((ModelVoiceRegion) this.$regions.get(i2)).getId());
            TextView textView4 = WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).g;
            m.checkNotNullExpressionValue(textView4, "binding.channelSettingsRegionOverride");
            textView4.setText(((ModelVoiceRegion) this.$regions.get(i2)).getName());
        }
        WidgetVoiceChannelSettings.access$getState$p(this.this$0).configureSaveActionView(WidgetVoiceChannelSettings.access$getBinding$p(this.this$0).j);
    }
}
