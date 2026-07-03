package com.discord.api.botuikit.gson;

import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.botuikit.UnknownComponent;
import com.discord.gsonutils.RuntimeTypeAdapterFactory;
import p507d0.p592z.p594d.C12238m;

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
            if (runtimeTypeAdapterFactory.f18536m.containsKey(clazz) || runtimeTypeAdapterFactory.f18535l.containsKey(strValueOf)) {
                throw new IllegalArgumentException("types and labels must be unique");
            }
            runtimeTypeAdapterFactory.f18535l.put(strValueOf, clazz);
            runtimeTypeAdapterFactory.f18536m.put(clazz, strValueOf);
        }
        C12238m.checkNotNullExpressionValue(runtimeTypeAdapterFactory, "RuntimeTypeAdapterFactor…ype.toString())\n    }\n  }");
        componentRuntimeTypeAdapterFactory = runtimeTypeAdapterFactory;
    }

    /* JADX INFO: renamed from: a */
    public final RuntimeTypeAdapterFactory<Component> m7624a() {
        return componentRuntimeTypeAdapterFactory;
    }
}
