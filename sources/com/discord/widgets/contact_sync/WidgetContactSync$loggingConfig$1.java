package com.discord.widgets.contact_sync;

import com.discord.analytics.generated.events.impression.TrackImpressionContactSyncInputName;
import com.discord.analytics.generated.events.impression.TrackImpressionContactSyncStart;
import com.discord.analytics.generated.events.impression.TrackImpressionContactSyncSuggestions;
import com.discord.analytics.generated.events.impression.TrackImpressionUserAddPhone;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$loggingConfig$1(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        int i = this.this$0.displayedChildIndex;
        if (i == WidgetContactSyncViewModel.Views.VIEW_LANDING.ordinal()) {
            TrackImpressionContactSyncStart trackImpressionContactSyncStart = new TrackImpressionContactSyncStart();
            trackImpressionContactSyncStart.m7518e(this.this$0.contactSyncFlowMetadata);
            return trackImpressionContactSyncStart;
        }
        if (i == WidgetContactSyncViewModel.Views.VIEW_ADD_PHONE.ordinal()) {
            TrackImpressionUserAddPhone trackImpressionUserAddPhone = new TrackImpressionUserAddPhone();
            trackImpressionUserAddPhone.m7525e(this.this$0.contactSyncFlowMetadata);
            return trackImpressionUserAddPhone;
        }
        if (i == WidgetContactSyncViewModel.Views.VIEW_NAME_INPUT.ordinal()) {
            TrackImpressionContactSyncInputName trackImpressionContactSyncInputName = new TrackImpressionContactSyncInputName();
            trackImpressionContactSyncInputName.m7517e(this.this$0.contactSyncFlowMetadata);
            return trackImpressionContactSyncInputName;
        }
        if (i == WidgetContactSyncViewModel.Views.VIEW_SUGGESTIONS.ordinal()) {
            TrackImpressionContactSyncSuggestions trackImpressionContactSyncSuggestions = new TrackImpressionContactSyncSuggestions();
            trackImpressionContactSyncSuggestions.m7519e(this.this$0.contactSyncFlowMetadata);
            return trackImpressionContactSyncSuggestions;
        }
        if (i != WidgetContactSyncViewModel.Views.VIEW_SUGGESTIONS_EMPTY.ordinal()) {
            return null;
        }
        TrackImpressionContactSyncSuggestions trackImpressionContactSyncSuggestions2 = new TrackImpressionContactSyncSuggestions();
        trackImpressionContactSyncSuggestions2.m7519e(this.this$0.contactSyncFlowMetadata);
        return trackImpressionContactSyncSuggestions2;
    }
}
