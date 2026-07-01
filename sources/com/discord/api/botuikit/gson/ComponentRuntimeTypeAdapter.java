package com.discord.api.botuikit.gson;

import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.Component6;
import com.discord.api.botuikit.Component9;
import com.discord.gsonutils.RuntimeTypeAdapterFactory;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ComponentRuntimeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentRuntimeTypeAdapter {
    public static final ComponentRuntimeTypeAdapter INSTANCE = new ComponentRuntimeTypeAdapter();
    private static final RuntimeTypeAdapterFactory<Component> componentRuntimeTypeAdapterFactory;

    static {
        RuntimeTypeAdapterFactory<Component> runtimeTypeAdapterFactory = new RuntimeTypeAdapterFactory<>(Component.class, "type", true, Component9.class);
        Component6[] component6ArrValues = Component6.values();
        for (int i = 0; i < 5; i++) {
            Component6 component6 = component6ArrValues[i];
            Class<? extends Component> clazz = component6.getClazz();
            String strValueOf = String.valueOf(component6.getType());
            if (clazz == null || strValueOf == null) {
                throw null;
            }
            if (runtimeTypeAdapterFactory.m.containsKey(clazz) || runtimeTypeAdapterFactory.l.containsKey(strValueOf)) {
                throw new IllegalArgumentException("types and labels must be unique");
            }
            runtimeTypeAdapterFactory.l.put(strValueOf, clazz);
            runtimeTypeAdapterFactory.m.put(clazz, strValueOf);
        }
        Intrinsics3.checkNotNullExpressionValue(runtimeTypeAdapterFactory, "RuntimeTypeAdapterFactor…ype.toString())\n    }\n  }");
        componentRuntimeTypeAdapterFactory = runtimeTypeAdapterFactory;
    }

    public final RuntimeTypeAdapterFactory<Component> a() {
        return componentRuntimeTypeAdapterFactory;
    }
}
