package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser {
    public static final GuildScheduledEventExternalLocationParser$Companion Companion = new GuildScheduledEventExternalLocationParser$Companion(null);
    private static final Lazy PARSER$delegate = g.lazy(GuildScheduledEventExternalLocationParser$Companion$PARSER$2.INSTANCE);
    private GuildScheduledEventExternalLocationParser$Cache cache = new GuildScheduledEventExternalLocationParser$Cache("", "");

    public static final /* synthetic */ Lazy access$getPARSER$cp() {
        return PARSER$delegate;
    }

    private final CharSequence parse(Context context, String location) {
        if (m.areEqual(this.cache.getLocation(), location)) {
            return this.cache.getOutput();
        }
        DraweeSpanStringBuilder draweeSpanStringBuilderRender = AstRenderer.render(Parser.parse$default(GuildScheduledEventExternalLocationParser$Companion.access$getPARSER$p(Companion), location, MessageParseState.Companion.getInitialState(), null, 4, null), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, null, null, null, 16376, null));
        this.cache = new GuildScheduledEventExternalLocationParser$Cache(location, draweeSpanStringBuilderRender);
        return draweeSpanStringBuilderRender;
    }

    public final CharSequence getTextFromLocation(Context context, GuildScheduledEventLocationInfo locationInfo) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(locationInfo, "locationInfo");
        if (locationInfo instanceof GuildScheduledEventLocationInfo$ChannelLocation) {
            return locationInfo.getLocationName();
        }
        if (locationInfo instanceof GuildScheduledEventLocationInfo$ExternalLocation) {
            return parse(context, locationInfo.getLocationName());
        }
        throw new NoWhenBranchMatchedException();
    }
}
