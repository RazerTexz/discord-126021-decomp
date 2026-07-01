package com.discord.widgets.botuikit;

import android.content.Context;
import android.view.ViewGroup;
import com.discord.api.botuikit.Component6;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.views.ActionRowComponentView;
import com.discord.widgets.botuikit.views.ButtonComponentView;
import com.discord.widgets.botuikit.views.ComponentView;
import com.discord.widgets.botuikit.views.select.SelectComponentView;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ComponentInflater.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentInflater {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    /* JADX INFO: compiled from: ComponentInflater.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ComponentInflater from(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new ComponentInflater(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Component6.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[Component6.ACTION_ROW.ordinal()] = 1;
            iArr[Component6.BUTTON.ordinal()] = 2;
            iArr[Component6.SELECT.ordinal()] = 3;
            iArr[Component6.TEXT.ordinal()] = 4;
            iArr[Component6.UNKNOWN.ordinal()] = 5;
        }
    }

    public ComponentInflater(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ComponentView<? extends MessageComponent> inflateComponent(Component6 component, ViewGroup root) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(root, "root");
        int iOrdinal = component.ordinal();
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal == 1) {
            return ActionRowComponentView.INSTANCE.inflateComponent(this.context, root);
        }
        if (iOrdinal == 2) {
            return ButtonComponentView.INSTANCE.inflateComponent(this.context, root);
        }
        if (iOrdinal == 3) {
            return SelectComponentView.INSTANCE.inflateComponent(this.context, root);
        }
        if (iOrdinal == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
