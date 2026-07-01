package com.discord.api.botuikit;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Component.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentUtils {
    public static final ComponentUtils INSTANCE = new ComponentUtils();

    public final int a(List<? extends Component> list, int i, Function2<? super Integer, ? super Component, Unit> function2) {
        for (Component component : list) {
            Integer numValueOf = Integer.valueOf(i);
            i++;
            function2.invoke(numValueOf, component);
            if (component instanceof LayoutComponent) {
                i = a(((LayoutComponent) component).a(), i, function2);
            }
        }
        return i;
    }
}
