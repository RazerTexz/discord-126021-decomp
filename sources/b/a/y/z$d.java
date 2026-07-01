package b.a.y;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z$d extends d0.z.d.o implements Function1<WidgetGlobalSearchModel, Unit> {
    public final /* synthetic */ z this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z$d(z zVar) {
        super(1);
        this.this$0 = zVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
        WidgetGlobalSearchModel widgetGlobalSearchModel2 = widgetGlobalSearchModel;
        d0.z.d.m.checkNotNullParameter(widgetGlobalSearchModel2, "it");
        z zVar = this.this$0;
        TextView textView = zVar.f318z.d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.emptyResults");
        textView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ? 0 : 8);
        RecyclerView recyclerView = zVar.f318z.f;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.resultsRv");
        recyclerView.setVisibility(widgetGlobalSearchModel2.getData().isEmpty() ^ true ? 0 : 8);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = zVar.A;
        widgetGlobalSearchAdapter.setOnUpdated(new x(zVar, widgetGlobalSearchModel2));
        List<WidgetGlobalSearchModel$ItemDataPayload> data = widgetGlobalSearchModel2.getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            Channel channel = ((WidgetGlobalSearchModel$ItemDataPayload) obj).getChannel();
            if (channel != null && ChannelUtils.J(channel)) {
                arrayList.add(obj);
            }
        }
        widgetGlobalSearchAdapter.setData(arrayList);
        widgetGlobalSearchAdapter.setOnSelectedListener(new y(zVar, widgetGlobalSearchModel2));
        return Unit.a;
    }
}
