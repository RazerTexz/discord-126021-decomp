package com.discord.widgets.home;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreNux$NuxState;
import com.discord.stores.StoreStream;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBound$3 extends o implements Function1<StoreNux$NuxState, Unit> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$onViewBound$3(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNux$NuxState storeNux$NuxState) {
        invoke2(storeNux$NuxState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNux$NuxState storeNux$NuxState) {
        boolean z2;
        boolean z3 = false;
        if (!storeNux$NuxState.getFirstOpen()) {
            Collection<Guild> collectionValues = StoreStream.Companion.getGuilds().getGuilds().values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = true;
                        break;
                    } else if (!(!((Guild) it.next()).isHub())) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = true;
                break;
            }
            if (z2 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled()) {
                z3 = true;
            }
        }
        if (z3) {
            WidgetHome.access$maybeShowHubEmailUpsell(this.this$0);
        }
    }
}
