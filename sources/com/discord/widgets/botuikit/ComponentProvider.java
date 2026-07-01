package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.KeyEvent$Callback;
import android.view.ViewGroup;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.discord.widgets.botuikit.views.ComponentActionListener;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: ComponentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentProvider {
    private final Context context;

    public ComponentProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final void configureView(ComponentActionListener listener, MessageComponent component, ComponentView<?> componentView) {
        int iOrdinal = component.getType().ordinal();
        if (iOrdinal == 1) {
            Objects.requireNonNull(componentView, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.ActionRowComponentView");
            ((ActionRowComponentView) componentView).configure((ActionRowMessageComponent) component, this, listener);
        } else if (iOrdinal == 2) {
            Objects.requireNonNull(componentView, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.ButtonComponentView");
            ((ButtonComponentView) componentView).configure((ButtonMessageComponent) component, this, listener);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            Objects.requireNonNull(componentView, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.select.SelectComponentView");
            ((SelectComponentView) componentView).configure((SelectMessageComponent) component, this, listener);
        }
    }

    public final ComponentView<? extends MessageComponent> getConfiguredComponentView(ComponentActionListener listener, MessageComponent component, ViewGroup root, int childIndex) {
        m.checkNotNullParameter(listener, "listener");
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(root, "root");
        ComponentInflater componentInflaterFrom = ComponentInflater.Companion.from(this.context);
        KeyEvent$Callback childAt = root.getChildAt(childIndex);
        if (childAt != null && (childAt instanceof ComponentView)) {
            ComponentView<? extends MessageComponent> componentView = (ComponentView) childAt;
            if (componentView.type() == component.getType()) {
                configureView(listener, component, componentView);
                return componentView;
            }
        }
        ComponentView<? extends MessageComponent> componentViewInflateComponent = componentInflaterFrom.inflateComponent(component.getType(), root);
        if (componentViewInflateComponent == null) {
            return null;
        }
        configureView(listener, component, componentViewInflateComponent);
        return componentViewInflateComponent;
    }

    public final Context getContext() {
        return this.context;
    }
}
