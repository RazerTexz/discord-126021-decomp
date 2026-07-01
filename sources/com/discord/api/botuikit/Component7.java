package com.discord.api.botuikit;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.api.botuikit.ComponentUtils, reason: use source file name */
/* JADX INFO: compiled from: Component.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Component7 {
    public static final Component7 INSTANCE = new Component7();

    public final int a(List<? extends Component> list, int i, Function2<? super Integer, ? super Component, Unit> function2) {
        for (Component component : list) {
            Integer numValueOf = Integer.valueOf(i);
            i++;
            function2.invoke(numValueOf, component);
            if (component instanceof Component8) {
                i = a(((Component8) component).a(), i, function2);
            }
        }
        return i;
    }
}
