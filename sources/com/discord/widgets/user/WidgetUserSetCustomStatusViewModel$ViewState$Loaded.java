package com.discord.widgets.user;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSetCustomStatusViewModel$ViewState$Loaded extends WidgetUserSetCustomStatusViewModel$ViewState {
    private final WidgetUserSetCustomStatusViewModel$FormState formState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel$ViewState$Loaded(WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState) {
        super(null);
        m.checkNotNullParameter(widgetUserSetCustomStatusViewModel$FormState, "formState");
        this.formState = widgetUserSetCustomStatusViewModel$FormState;
    }

    public static /* synthetic */ WidgetUserSetCustomStatusViewModel$ViewState$Loaded copy$default(WidgetUserSetCustomStatusViewModel$ViewState$Loaded widgetUserSetCustomStatusViewModel$ViewState$Loaded, WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetUserSetCustomStatusViewModel$FormState = widgetUserSetCustomStatusViewModel$ViewState$Loaded.formState;
        }
        return widgetUserSetCustomStatusViewModel$ViewState$Loaded.copy(widgetUserSetCustomStatusViewModel$FormState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetUserSetCustomStatusViewModel$FormState getFormState() {
        return this.formState;
    }

    public final WidgetUserSetCustomStatusViewModel$ViewState$Loaded copy(WidgetUserSetCustomStatusViewModel$FormState formState) {
        m.checkNotNullParameter(formState, "formState");
        return new WidgetUserSetCustomStatusViewModel$ViewState$Loaded(formState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSetCustomStatusViewModel$ViewState$Loaded) && m.areEqual(this.formState, ((WidgetUserSetCustomStatusViewModel$ViewState$Loaded) other).formState);
        }
        return true;
    }

    public final WidgetUserSetCustomStatusViewModel$FormState getFormState() {
        return this.formState;
    }

    public final boolean getShowStatusClear() {
        if (this.formState.getEmoji() == null) {
            if (!(this.formState.getText().length() > 0)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState = this.formState;
        if (widgetUserSetCustomStatusViewModel$FormState != null) {
            return widgetUserSetCustomStatusViewModel$FormState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(formState=");
        sbU.append(this.formState);
        sbU.append(")");
        return sbU.toString();
    }
}
