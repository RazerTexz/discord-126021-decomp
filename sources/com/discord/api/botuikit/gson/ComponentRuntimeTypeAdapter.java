package com.discord.api.botuikit.gson;

import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.UnknownComponent;
import com.discord.gsonutils.RuntimeTypeAdapterFactory;
import d0.z.d.m;

/* JADX INFO: compiled from: ComponentRuntimeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentRuntimeTypeAdapter {
    public static final ComponentRuntimeTypeAdapter INSTANCE = new ComponentRuntimeTypeAdapter();
    private static final RuntimeTypeAdapterFactory<Component> componentRuntimeTypeAdapterFactory;

    static {
        RuntimeTypeAdapterFactory<Component> runtimeTypeAdapterFactory = new RuntimeTypeAdapterFactory<>(Component.class, "type", true, UnknownComponent.class);
        ComponentType[] componentTypeArrValues = ComponentType.values();
        for (int i = 0; i < 5; i++) {
            ComponentType componentType = componentTypeArrValues[i];
            Class<? extends Component> clazz = componentType.getClazz();
            String strValueOf = String.valueOf(componentType.getType());
            if (clazz == null || strValueOf == null) {
                throw null;
            }
            if (runtimeTypeAdapterFactory.m.containsKey(clazz) || runtimeTypeAdapterFactory.l.containsKey(strValueOf)) {
                throw new IllegalArgumentException("types and labels must be unique");
            }
            runtimeTypeAdapterFactory.l.put(strValueOf, clazz);
            runtimeTypeAdapterFactory.m.put(clazz, strValueOf);
        }
        m.checkNotNullExpressionValue(runtimeTypeAdapterFactory, "RuntimeTypeAdapterFactor…ype.toString())\n    }\n  }");
        componentRuntimeTypeAdapterFactory = runtimeTypeAdapterFactory;
    }

    public final RuntimeTypeAdapterFactory<Component> a() {
        return componentRuntimeTypeAdapterFactory;
    }
}
