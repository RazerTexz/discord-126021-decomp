package com.discord.widgets.botuikit;

import com.discord.stores.StoreExperiments;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ComponentExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BotComponentExperiments$Companion {
    private BotComponentExperiments$Companion() {
    }

    public final ComponentExperiments get(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        BotComponentExperiments botComponentExperiments = getBotComponentExperiments();
        if (botComponentExperiments != null) {
            return botComponentExperiments;
        }
        BotComponentExperiments botComponentExperiments2 = new BotComponentExperiments(storeExperiments);
        setBotComponentExperiments(botComponentExperiments2);
        return botComponentExperiments2;
    }

    public final BotComponentExperiments getBotComponentExperiments() {
        return BotComponentExperiments.access$getBotComponentExperiments$cp();
    }

    public final void setBotComponentExperiments(BotComponentExperiments botComponentExperiments) {
        BotComponentExperiments.access$setBotComponentExperiments$cp(botComponentExperiments);
    }

    public /* synthetic */ BotComponentExperiments$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
