package b.a.y;

import android.content.Context;
import android.view.View;
import com.discord.app.DiscordConnectService;
import com.discord.app.DiscordConnectService$a;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemChannel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y extends d0.z.d.o implements Function4<View, Integer, WidgetGlobalSearchModel$ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $searchModel$inlined;
    public final /* synthetic */ z this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(4);
        this.this$0 = zVar;
        this.$searchModel$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function4
    public Unit invoke(View view, Integer num, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, Boolean bool) {
        View view2 = view;
        num.intValue();
        WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload2 = widgetGlobalSearchModel$ItemDataPayload;
        bool.booleanValue();
        d0.z.d.m.checkNotNullParameter(view2, "view");
        d0.z.d.m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload2, "data");
        if (widgetGlobalSearchModel$ItemDataPayload2 instanceof WidgetGlobalSearchModel$ItemChannel) {
            DiscordConnectService$a discordConnectService$a = DiscordConnectService.j;
            Context context = view2.getContext();
            d0.z.d.m.checkNotNullExpressionValue(context, "view.context");
            discordConnectService$a.b(context, ((WidgetGlobalSearchModel$ItemChannel) widgetGlobalSearchModel$ItemDataPayload2).getChannel().getId());
            this.this$0.g();
        }
        return Unit.a;
    }
}
