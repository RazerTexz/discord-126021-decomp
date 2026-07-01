package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.ViewGroup;
import com.discord.api.botuikit.ComponentType;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ComponentInflater.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentInflater {
    public static final ComponentInflater$Companion Companion = new ComponentInflater$Companion(null);
    private final Context context;

    public ComponentInflater(Context context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ComponentView<? extends MessageComponent> inflateComponent(ComponentType component, ViewGroup root) {
        m.checkNotNullParameter(component, "component");
        m.checkNotNullParameter(root, "root");
        int iOrdinal = component.ordinal();
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal == 1) {
            return ActionRowComponentView.Companion.inflateComponent(this.context, root);
        }
        if (iOrdinal == 2) {
            return ButtonComponentView.Companion.inflateComponent(this.context, root);
        }
        if (iOrdinal == 3) {
            return SelectComponentView.Companion.inflateComponent(this.context, root);
        }
        if (iOrdinal == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
