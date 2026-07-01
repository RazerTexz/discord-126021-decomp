package com.discord.widgets.chat.input;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.CommandCategoryItem, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatInputCategoriesAdapter3 {
    private final Application application;
    private final boolean isSelected;

    public WidgetChatInputCategoriesAdapter3(Application application, boolean z2) {
        Intrinsics3.checkNotNullParameter(application, "application");
        this.application = application;
        this.isSelected = z2;
    }

    public static /* synthetic */ WidgetChatInputCategoriesAdapter3 copy$default(WidgetChatInputCategoriesAdapter3 widgetChatInputCategoriesAdapter3, Application application, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = widgetChatInputCategoriesAdapter3.application;
        }
        if ((i & 2) != 0) {
            z2 = widgetChatInputCategoriesAdapter3.isSelected;
        }
        return widgetChatInputCategoriesAdapter3.copy(application, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final WidgetChatInputCategoriesAdapter3 copy(Application application, boolean isSelected) {
        Intrinsics3.checkNotNullParameter(application, "application");
        return new WidgetChatInputCategoriesAdapter3(application, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputCategoriesAdapter3)) {
            return false;
        }
        WidgetChatInputCategoriesAdapter3 widgetChatInputCategoriesAdapter3 = (WidgetChatInputCategoriesAdapter3) other;
        return Intrinsics3.areEqual(this.application, widgetChatInputCategoriesAdapter3.application) && this.isSelected == widgetChatInputCategoriesAdapter3.isSelected;
    }

    public final Application getApplication() {
        return this.application;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        boolean z2 = this.isSelected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CommandCategoryItem(application=");
        sbU.append(this.application);
        sbU.append(", isSelected=");
        return outline.O(sbU, this.isSelected, ")");
    }
}
