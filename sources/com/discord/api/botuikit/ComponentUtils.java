package com.discord.api.botuikit;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Component.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentUtils {
    public static final ComponentUtils INSTANCE = new ComponentUtils();

    /* JADX INFO: renamed from: a */
    public final int m7604a(List<? extends Component> list, int i, Function2<? super Integer, ? super Component, Unit> function2) {
        for (Component component : list) {
            Integer numValueOf = Integer.valueOf(i);
            i++;
            function2.invoke(numValueOf, component);
            if (component instanceof LayoutComponent) {
                i = m7604a(((LayoutComponent) component).mo7593a(), i, function2);
            }
        }
        return i;
    }
}
