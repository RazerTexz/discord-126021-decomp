package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.ActionRowMessageComponent;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.ComponentView2;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: compiled from: ComponentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentProvider {
    private final Context context;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Component6.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[Component6.ACTION_ROW.ordinal()] = 1;
            iArr[Component6.BUTTON.ordinal()] = 2;
            iArr[Component6.SELECT.ordinal()] = 3;
            iArr[Component6.UNKNOWN.ordinal()] = 4;
        }
    }

    public ComponentProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final void configureView(ComponentView2 listener, MessageComponent component, ComponentView<?> componentView) {
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

    public final ComponentView<? extends MessageComponent> getConfiguredComponentView(ComponentView2 listener, MessageComponent component, ViewGroup root, int childIndex) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(root, "root");
        ComponentInflater componentInflaterFrom = ComponentInflater.INSTANCE.from(this.context);
        KeyEvent.Callback childAt = root.getChildAt(childIndex);
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
