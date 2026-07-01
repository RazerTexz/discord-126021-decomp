package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.discord.models.commands.Application;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CommandCategoryItem {
    private final Application application;
    private final boolean isSelected;

    public CommandCategoryItem(Application application, boolean z2) {
        m.checkNotNullParameter(application, "application");
        this.application = application;
        this.isSelected = z2;
    }

    public static /* synthetic */ CommandCategoryItem copy$default(CommandCategoryItem commandCategoryItem, Application application, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            application = commandCategoryItem.application;
        }
        if ((i & 2) != 0) {
            z2 = commandCategoryItem.isSelected;
        }
        return commandCategoryItem.copy(application, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final CommandCategoryItem copy(Application application, boolean isSelected) {
        m.checkNotNullParameter(application, "application");
        return new CommandCategoryItem(application, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandCategoryItem)) {
            return false;
        }
        CommandCategoryItem commandCategoryItem = (CommandCategoryItem) other;
        return m.areEqual(this.application, commandCategoryItem.application) && this.isSelected == commandCategoryItem.isSelected;
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
        StringBuilder sbU = a.U("CommandCategoryItem(application=");
        sbU.append(this.application);
        sbU.append(", isSelected=");
        return a.O(sbU, this.isSelected, ")");
    }
}
