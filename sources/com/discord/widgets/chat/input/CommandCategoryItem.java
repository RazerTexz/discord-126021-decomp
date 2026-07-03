package com.discord.widgets.chat.input;

import com.discord.models.commands.Application;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInputCategoriesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CommandCategoryItem {
    private final Application application;
    private final boolean isSelected;

    public CommandCategoryItem(Application application, boolean z2) {
        C12238m.checkNotNullParameter(application, "application");
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
        C12238m.checkNotNullParameter(application, "application");
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
        return C12238m.areEqual(this.application, commandCategoryItem.application) && this.isSelected == commandCategoryItem.isSelected;
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
        StringBuilder sbM833U = C1643a.m833U("CommandCategoryItem(application=");
        sbM833U.append(this.application);
        sbM833U.append(", isSelected=");
        return C1643a.m827O(sbM833U, this.isSelected, ")");
    }
}
